package iit.ipro497.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ DomainConfig.COMPONENT_SCAN })
public class DomainConfig {
	public static final String COMPONENT_SCAN = "iit.ipro497.domain";
}
