package franco.maurizio.hr.desk.com.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class CeReProBackendConfiguration {

	@Bean(name = "messageSource")
	ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageBundle =
				new ReloadableResourceBundleMessageSource();
		messageBundle.setBasename("classpath:messages");
		messageBundle.setDefaultEncoding("UTF-8");
		return messageBundle;
	}
}
