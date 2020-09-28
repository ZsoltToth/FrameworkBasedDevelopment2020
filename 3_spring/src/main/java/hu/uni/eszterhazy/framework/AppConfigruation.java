package hu.uni.eszterhazy.framework;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import hu.uni.eszterhazy.framework.service.QuadracitSolver;
import hu.uni.eszterhazy.framework.service.QuadraticSolverImpl;

@SpringBootConfiguration
public class AppConfigruation {

    @Bean
    public String name(){
        return "Zsolt";
    }

}
