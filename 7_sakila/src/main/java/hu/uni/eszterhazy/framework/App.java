package hu.uni.eszterhazy.framework;

import hu.uni.eszterhazy.framework.dao.AddressDao;
import hu.uni.eszterhazy.framework.dao.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.stream.StreamSupport;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
    @Autowired
    private ApplicationContext context;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
        AddressDao dao = context.getBean(AddressDao.class);
        dao.readAll().forEach(System.out::println);
    }
}
