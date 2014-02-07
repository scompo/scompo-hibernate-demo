package it.scompo.scompohibernatedemo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

	

	private static final Logger logger = LogManager
			.getLogger(Application.class);
	
    public static void main(String[] args) {
    	logger.debug("test");
    	SpringApplication.run(Application.class, args);
    	
    }
}
