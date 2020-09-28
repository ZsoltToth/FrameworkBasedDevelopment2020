package hu.uni.eszterhazy.framework;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.QuadracitSolver;
import service.QuadraticSolverImpl;

@SpringBootConfiguration
@ComponentScan(basePackages ={"hu.uni.eszterhazy.framework"} )
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
