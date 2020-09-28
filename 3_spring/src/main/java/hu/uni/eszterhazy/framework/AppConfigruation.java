package hu.uni.eszterhazy.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.QuadracitSolver;
import service.QuadraticSolverImpl;

@Configuration
public class AppConfigruation {

    @Bean
    public String name(){
        return "Zsolt";
    }

    @Bean
    public QuadracitSolver quadracitSolver(){
        return new QuadraticSolverImpl();
    }
}
