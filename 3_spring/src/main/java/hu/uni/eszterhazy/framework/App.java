package hu.uni.eszterhazy.framework;

import hu.uni.eszterhazy.framework.model.EquationSolution;
import hu.uni.eszterhazy.framework.model.QuadraticEquation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.QuadracitSolver;
import service.QuadraticSolverImpl;

@SpringBootApplication
@Configuration
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
        System.out.println(String.format("Hello %s!", applicationContext.getBean("name").toString()));
        QuadraticEquation equation = new QuadraticEquation(4,-6,1);
        EquationSolution solution = applicationContext.getBean(QuadraticSolverImpl.class).solve(equation);
        for(double root : solution.getRoots()){
            System.out.println(root);
        }
    }

}
