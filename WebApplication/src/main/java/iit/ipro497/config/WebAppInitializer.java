package iit.ipro497.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(2)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	public static final int MAX_UPLOAD_MB = 25;
	private static final int MEGABYTE = 1024 * 1024;

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new MultipartFilter() };
	}

	@Override
	protected void registerDispatcherServlet(ServletContext servletContext) {
		super.registerDispatcherServlet(servletContext);
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		String uploadDirectory = "/tmp";
		long maxFileSize = MEGABYTE * MAX_UPLOAD_MB;
		long maxRequestSize = MEGABYTE * MAX_UPLOAD_MB;
		int fileSizeThreshold = MEGABYTE * 1;

		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(uploadDirectory,
				maxFileSize, maxRequestSize, fileSizeThreshold);

		registration.setMultipartConfig(multipartConfigElement);

	}

}
