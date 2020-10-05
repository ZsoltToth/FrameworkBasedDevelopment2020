package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.model.EquationSolution;
import hu.uni.eszterhazy.framework.model.QuadraticEquation;
import hu.uni.eszterhazy.framework.service.QuadracitSolver;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quadratic")
@RequiredArgsConstructor
public class QuadraticEquationController {

    private final QuadracitSolver solver;

   @RequestMapping("/demo")
    public double[] demo(){
       return new double[] { 0.0, 1.0};
   }

   @GetMapping("/solve")
   public double[] solve(@RequestParam(name = "a", required = true) double a,
                         @RequestParam(name = "b", required = true) double b,
                         @RequestParam(name = "c", required = true) double c){
       QuadraticEquation equation = new QuadraticEquation(c,b,a);
       EquationSolution solution = solver.solve(equation);
       return solution.getRoots();
   }

   @GetMapping("/solve/{a}/{b}/{c}")
   public double[] solveFromPath(@PathVariable(name = "a") double a,
                                 @PathVariable(name = "b") double b,
                                 @PathVariable(name = "c") double c){
       QuadraticEquation equation = new QuadraticEquation(c,b,a);
       EquationSolution solution = solver.solve(equation);
       return solution.getRoots();
   }
}
