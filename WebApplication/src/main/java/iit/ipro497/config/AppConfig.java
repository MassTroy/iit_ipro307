package iit.ipro497.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "iit.ipro497.thermal")
@Import(value = { PersistenceConfig.class, DomainConfig.class })
public class AppConfig {
	public static final String GOOGLE_API_KEY = "AIzaSyAdorDhOfuE0hwHw9lcQgAwLSq1rAzNdvs";

}
