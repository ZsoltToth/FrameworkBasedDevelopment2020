package hu.uni.eszterhazy.framework.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Address {

    private String address;
    private String address2;
    private String district;
    private String city;
    private String country;
    private String postalCode;
    private String phone;

}
