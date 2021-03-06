package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.dao.entity.AddressEntity;
import hu.uni.eszterhazy.framework.dao.entity.CityEntity;
import hu.uni.eszterhazy.framework.dao.entity.CountryEntity;
import hu.uni.eszterhazy.framework.exceptions.UnknownCountryException;
import hu.uni.eszterhazy.framework.model.Address;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressDaoImpl implements AddressDao{

    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Override
    public void createAddress(Address address) throws UnknownCountryException {
        GeometryFactory geometryFactory = new GeometryFactory();
        addressRepository.save(AddressEntity.builder()
                .address(address.getAddress())
                .address2(address.getAddress2())
                .district(address.getDistrict())
                .postalCode(address.getPostalCode())
                .phone(address.getPhone())
                .city(queryCityByNameAndCountry(address.getCity(), address.getCountry()))
                .location(geometryFactory.createPoint(new Coordinate()))
                .lastUpdate( currentTimestamp())
                .build());
    }

    private CityEntity queryCityByNameAndCountry(String city, String country) throws UnknownCountryException {
        CountryEntity countryEntity;
        if(countryRepository.findByCountry(country).isEmpty()){
           log.error("Country {} has not been recorded!", country);
//           countryRepository.save(new CountryEntity(0,country, currentTimestamp() ));
            throw new UnknownCountryException(country);
        }
        countryEntity = countryRepository.findByCountry(country).get();
        if(cityRepository.findByCity(city).isEmpty()){
            log.info("City {} has not been recorded!", city);
            cityRepository.save(CityEntity.builder()
                    .city(city)
                    .country(countryEntity)
                    .lastUpdate(currentTimestamp())
                    .build());
        }
        return cityRepository.findByCity(city).get();
    }

    private Timestamp currentTimestamp(){
        return new Timestamp( (new Date()).getTime() );
    }

    @Override
    public Collection<Address> readAll() {
        return StreamSupport.stream(addressRepository.findAll().spliterator(),false).map((addressEntity -> new Address(
                addressEntity.getAddress(),
                addressEntity.getAddress2(),
                addressEntity.getDistrict(),
                addressEntity.getCity().getCity(),
                addressEntity.getCity().getCountry().getCountry(),
                addressEntity.getPostalCode(),
                addressEntity.getPhone()
        ))).collect(Collectors.toList());
    }
}
