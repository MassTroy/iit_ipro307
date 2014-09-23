package iit.ipro497.themal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
// Specify which package to scan
@ComponentScan(basePackageClasses = { PageGenConfig.class })
public class WebConfig extends WebMvcConfigurerAdapter {
	private static final int RESOURCE_CACHE_PERIOD = 31556926;
	private static final String RESOURCES = "/WEB-INF/resources/";

	// Resolve logical view names to .jsp resources in the /WEB-INF/jsp directory
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver .setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("favicon.ico").addResourceLocations(RESOURCES + "img/favicon.ico").setCachePeriod(RESOURCE_CACHE_PERIOD);

		addResourceFolder(registry, "css");
		addResourceFolder(registry, "css_static");
		addResourceFolder(registry, "js");
		addResourceFolder(registry, "js_static");
		addResourceFolder(registry, "img");
		addResourceFolder(registry, "font");
	}

	private void addResourceFolder(ResourceHandlerRegistry registry, String resourceFolder) {
		registry.addResourceHandler("/" + resourceFolder + "/**").addResourceLocations(RESOURCES + resourceFolder + "/").setCachePeriod(RESOURCE_CACHE_PERIOD);
	}
	
}
