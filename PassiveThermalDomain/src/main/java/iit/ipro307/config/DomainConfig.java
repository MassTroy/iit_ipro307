package iit.ipro307.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ DomainConfig.COMPONENT_SCAN })
public class DomainConfig {
	public static final String COMPONENT_SCAN = "iit.ipro307.domain";

	// TODO: move API keys to a properties file
	public static final String GOOGLE_API_KEY = "AIzaSyAdorDhOfuE0hwHw9lcQgAwLSq1rAzNdvs";
	public static final String OPEN_WEATHER_MAP_API_KEY = "5c42a4b74ec48c12b24aa57982417e04";
}
