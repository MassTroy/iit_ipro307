package iit.ipro307.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import common.util.PrefixLogger;

@Configuration
@ComponentScan(basePackages = "iit.ipro307.thermal")
@Import(value = { PersistenceConfig.class, DomainConfig.class })
public class AppConfig {
	public static final String GOOGLE_API_KEY = "AIzaSyAdorDhOfuE0hwHw9lcQgAwLSq1rAzNdvs";
	public static final String OPEN_WEATHER_MAP_API_KEY = "5c42a4b74ec48c12b24aa57982417e04";

	@Bean
	public PrefixLogger getLogger() {
		return new PrefixLogger("ipro307");
	}
}