package service;

import hu.uni.eszterhazy.framework.model.EquationSolution;
import hu.uni.eszterhazy.framework.model.QuadraticEquation;
import org.springframework.stereotype.Service;

@Service
public class QuadraticSolverImpl implements QuadracitSolver{


    @Override
    public EquationSolution solve(QuadraticEquation equation) {
        if(discriminant(equation.getCoeffQuadratic(), equation.getCoeffLinear(), equation.getCoeffConst()) > 0.0){
            return EquationSolution.builder().roots(new double[] {
                    (-1 * equation.getCoeffLinear() + Math.sqrt(discriminant(equation.getCoeffQuadratic(), equation.getCoeffLinear(), equation.getCoeffConst()))) / (2 * equation.getCoeffQuadratic()),
                    (-1 * equation.getCoeffLinear() - Math.sqrt(discriminant(equation.getCoeffQuadratic(), equation.getCoeffLinear(), equation.getCoeffConst()))) / (2 * equation.getCoeffQuadratic())
            }).build();
        }
        if(discriminant(equation.getCoeffQuadratic(), equation.getCoeffLinear(), equation.getCoeffConst()) == 0.0){
            return EquationSolution.builder().roots(new double[] {
                    (-1 * equation.getCoeffLinear() ) / (2 * equation.getCoeffQuadratic())
            }).build();
        }
        return EquationSolution.builder().roots(new double[]{}).build();
    }

    private double discriminant(double a, double b, double c){
        return Math.pow(b,2) - 4 * a * c;
    }
}
