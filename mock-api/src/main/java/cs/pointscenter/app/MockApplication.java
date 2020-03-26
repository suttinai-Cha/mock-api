package cs.pointscenter.app;

import java.time.Duration;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;


//@EnableResourceServer
//@EnableAuthorizationServer
@SpringBootApplication
/**
 * 
 * @author Phai noi this project require run configuration below 1
 *         -Dspring.profiles.active=dev (VM agrguments)
 */
public class MockApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(MockApplication.class, args);
	}

	
}
