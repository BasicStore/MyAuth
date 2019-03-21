package com.security.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

	// spring mVC only
	
	
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/").setViewName("user");
    	registry.addViewController("/user").setViewName("user");
     	registry.addViewController("/member").setViewName("member");
    	registry.addViewController("/admin").setViewName("admin");
    }
    
  
}
    
  