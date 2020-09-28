package hu.uni.eszterhazy.framework.service;

import hu.uni.eszterhazy.framework.model.EquationSolution;
import hu.uni.eszterhazy.framework.model.QuadraticEquation;

public interface QuadracitSolver {

    EquationSolution solve(QuadraticEquation equation);
}
