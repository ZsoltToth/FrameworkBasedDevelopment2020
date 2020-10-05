package hu.uni.eszterhazy.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Extend the application with a Calculator which provides services for the 3 basic operation (plus, minus, multiplication).
 * Division is not required because it may throw Exception.
 * Use only get Requests.
 *
 */
@SpringBootApplication
@EnableWebMvc
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
