package hu.uni.eszterhazy.framework.model;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EquationSolution {

    private double[] roots;
}
