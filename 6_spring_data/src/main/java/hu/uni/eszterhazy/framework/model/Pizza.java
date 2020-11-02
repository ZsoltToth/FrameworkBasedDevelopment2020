package hu.uni.eszterhazy.framework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pizza {

    private String name;
    private double price;
    private boolean isAllergen;
}
