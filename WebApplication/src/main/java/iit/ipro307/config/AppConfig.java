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
	@Bean
	public PrefixLogger getLogger() {
		return new PrefixLogger("ipro307");
	}
}
