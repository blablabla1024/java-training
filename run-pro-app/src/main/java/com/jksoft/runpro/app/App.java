package com.jksoft.runpro.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class App {
	
	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		LOG.info("Application started");
		ApplicationContext context = new AnnotationConfigApplicationContext(
				App.class);
		LOG.info("Spring started");
		
		Stats stats = context.getBean(Stats.class);
		stats.execute(args);
		LOG.info("application finished");
		
	}
	
	@Bean
	public TcxFileParser tcxFileParser() {
		return new TcxFileParser();
	}

}
