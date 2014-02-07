package it.scompo.scompohibernatedemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration xmlConfig.
 * 
 * @author mscomparin
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({"it.scompo.scompohibernatedemo.dao","it.scompo.scompohibernatedemo.dto"})
@ImportResource({"classpath:hibernate4Config.xml"})
public class PersistenceXmlConfig {
	
	public PersistenceXmlConfig() {
		super();
	}
	
}
