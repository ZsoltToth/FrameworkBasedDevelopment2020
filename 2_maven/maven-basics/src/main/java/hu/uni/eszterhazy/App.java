package hu.uni.eszterhazy;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@Slf4j
public class App{

    public static void main( String[] args )
    {
        log.warn("This is the main method!");
        System.out.println( "Hello World!" );
        new Greetings();
    }

    @Slf4j
    static class Greetings{

        public Greetings() {
            log.info("Greetings object is created!");
        }
    }
}
