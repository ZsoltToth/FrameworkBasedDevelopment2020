package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AddressDaoImpl implements AddressDao{

    private final AddressRepository repository;

    @Override
    public Collection<Address> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false).map((addressEntity -> new Address(
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
