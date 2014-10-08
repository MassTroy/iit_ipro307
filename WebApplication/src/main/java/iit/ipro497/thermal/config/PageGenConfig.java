package iit.ipro497.thermal.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "iit.ipro497.thermal")
@Import(value = PersistenceConfig.class)
public class PageGenConfig {
}
