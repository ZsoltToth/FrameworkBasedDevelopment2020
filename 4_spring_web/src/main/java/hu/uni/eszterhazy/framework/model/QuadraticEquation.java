package hu.uni.eszterhazy.framework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class QuadraticEquation {

    private double coeffConst;
    private double coeffLinear;
    private double coeffQuadratic;
}
