package com.ewasteManagement.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class CORSconfiguration  extends WebMvcConfigurationSupport {
	
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
	    }

}
