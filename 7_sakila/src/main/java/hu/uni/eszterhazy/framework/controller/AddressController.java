package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.controller.dto.AddressDto;
import hu.uni.eszterhazy.framework.model.Address;
import hu.uni.eszterhazy.framework.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // TODO: Replace Model objects with DTOs
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

}
