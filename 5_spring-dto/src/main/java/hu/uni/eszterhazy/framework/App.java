package hu.uni.eszterhazy.framework;

/**
 * Task
 *  - Add a new Exception for unknown Users at AccessControlManagerServiceImpl. (Not Found)
 *  - Convert the requestAccess method (AccessControlMangerServiceImpl L33-L53) to use Stream API. (stream().reduce(), etc.)
 *
 * See:
 *  - {@link hu.uni.eszterhazy.framework.service.AccessControlManagerServiceImpl}
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
