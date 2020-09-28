package hu.uni.eszterhazy.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigruation {

    @Bean
    public String name(){
        return "Zsolt";
    }
}
