package hu.uni.eszterhazy.framework;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class AppConfigruation {

    @Bean
    public String name(){
        return "Zsolt";
    }

}
