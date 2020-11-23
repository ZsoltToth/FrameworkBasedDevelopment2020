package hu.uni.eszterhazy.framework.controller.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class AddressDto {

    private String address;
    private String address2;
    private String district;
    private String city;
    private String country;
    private String postalCode;
}
