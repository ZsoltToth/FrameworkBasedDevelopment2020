package hu.uni.eszterhazy.framework.controller.dto;


import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ExtendedAddressDto extends AddressDto {

    private String phone;
}
