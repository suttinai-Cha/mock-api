package cs.pointscenter.app;

import java.time.Duration;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import cs.pointscenter.log.LoggableDispatcherServlet;





@SpringBootApplication
public class MockApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(MockApplication.class, args);
	}


	@Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
	public DispatcherServlet dispatcherServlet() {
		LoggableDispatcherServlet ds = new LoggableDispatcherServlet();
		ds.setThrowExceptionIfNoHandlerFound(true);
		return ds;
	}
	@Bean
	public ServletRegistrationBean<DispatcherServlet> dispatcherRegistration() {
		ServletRegistrationBean<DispatcherServlet> bean = new ServletRegistrationBean<DispatcherServlet>(
				dispatcherServlet());
		MultipartConfigElement multipartConfig = new MultipartConfigElement(System.getProperty("java.io.tmpdir"));
		bean.setMultipartConfig(multipartConfig);
		return bean;
	}

}
