package hu.uni.eszterhazy.framework;

import hu.uni.eszterhazy.framework.dao.AddressDao;
import hu.uni.eszterhazy.framework.dao.AddressRepository;
import hu.uni.eszterhazy.framework.dao.CountryRepository;
import hu.uni.eszterhazy.framework.dao.entity.CountryEntity;
import hu.uni.eszterhazy.framework.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.stream.StreamSupport;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }


}
