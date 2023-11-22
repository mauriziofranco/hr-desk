package franco.maurizio.hr.desk.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 
 * Spring application main class.
 * 
 * Used for tests.
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@SpringBootApplication
public class CeReProPersistenceApplication {
	private static final Logger logger = LoggerFactory.getLogger(CeReProPersistenceApplication.class);
	public static void main(String[] args) { 
		logger.info("APPLICATION IS STARTING!!!!!!");
		ApplicationContext applicationContext = 
				SpringApplication.run(CeReProPersistenceApplication.class, args);
		
		for (String name : applicationContext.getBeanDefinitionNames()) {
			logger.info(name);
		}
		logger.info("APPLICATION STARTED!!!!!!");
	}
}
