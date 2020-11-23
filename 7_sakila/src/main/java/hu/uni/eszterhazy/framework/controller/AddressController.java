package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.controller.dto.AddressDto;
import hu.uni.eszterhazy.framework.controller.dto.ExtendedAddressDto;
import hu.uni.eszterhazy.framework.exceptions.UnknownCountryException;
import hu.uni.eszterhazy.framework.model.Address;
import hu.uni.eszterhazy.framework.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Tasks of a Controller:
 *  - Provides Endpoints.
 *  - Convert Data Transfer Objects to model objects and vice versa.
 *  - validates requests (low level validation: types, values).
 *  - Exception Handling (and mapping).
 */
@RequestMapping(value = "/address")
@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;

    @GetMapping(value = {"/","/all"})
    public Collection<AddressDto> getAll(){
        return service.listAll().stream()
                .map(model -> AddressDto.builder()
                        .address(model.getAddress())
                        .address2(model.getAddress2())
                        .district(model.getDistrict())
                        .city(model.getCity())
                        .country(model.getCountry())
                        .postalCode(model.getPostalCode())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping(value = {"/city/{city}"})
    public Collection<AddressDto> getAll(@PathVariable(name = "city") String city){
        return service.listAllByCity(city).stream()
                .map(model -> AddressDto.builder()
                        .address(model.getAddress())
                        .address2(model.getAddress2())
                        .district(model.getDistrict())
                        .city(model.getCity())
                        .country(model.getCountry())
                        .postalCode(model.getPostalCode())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/record")
    public void recordAddress( @RequestBody ExtendedAddressDto addressDto) {
        try {
            service.createAddress(new Address(
                    addressDto.getAddress(),
                    addressDto.getAddress2(),
                    addressDto.getDistrict(),
                    addressDto.getCity(),
                    addressDto.getCountry(),
                    addressDto.getPostalCode(),
                    addressDto.getPhone()
            ));
        } catch (UnknownCountryException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
