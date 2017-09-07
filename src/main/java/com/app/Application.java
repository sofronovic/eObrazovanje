package com.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableAutoConfiguration
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
