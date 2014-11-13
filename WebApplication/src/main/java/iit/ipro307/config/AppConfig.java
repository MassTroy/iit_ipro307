package iit.ipro307.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import common.util.PrefixLogger;

/**
 * Describes all packages to scan for components and wires any needed beans
 * @author Troy Mass
 */
@Configuration
@ComponentScan(basePackages = "iit.ipro307.thermal")
@Import(value = { DomainConfig.class })
public class AppConfig {
	/**
	 * Define the Logger bean
	 */
	@Bean
	public PrefixLogger getLogger() {
		return new PrefixLogger("ipro307");
	}
}
