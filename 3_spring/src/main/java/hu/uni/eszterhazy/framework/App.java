package hu.uni.eszterhazy.framework;

import hu.uni.eszterhazy.framework.model.EquationSolution;
import hu.uni.eszterhazy.framework.model.QuadraticEquation;
import hu.uni.eszterhazy.framework.service.QuadracitSolver;
import hu.uni.eszterhazy.framework.service.QuadraticSolverImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


/**
 * Task:    Create a calculator for the 4 basic operations similar to the QuadraticSolver.
 *          Separate the interface from its implementation.
 *          Test it manually in the App.run method.
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
    @Autowired
    private ApplicationContext applicationContext;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.printf("Hello %s!%n", applicationContext.getBean("name").toString());
        QuadraticEquation equation = new QuadraticEquation(4,-6,1);
        EquationSolution solution = applicationContext.getBean(QuadracitSolver.class).solve(equation);
        for(double root : solution.getRoots()){
            System.out.println(root);
        }
    }

}
