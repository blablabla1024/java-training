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

		if (args.length == 0) {
			LOG.info("Missing file path argument. Application cannot be started.");
			System.out
					.println("Missing file path argument. Application cannot be started.");
		} else {
			LOG.info("Application started");
			ApplicationContext context = new AnnotationConfigApplicationContext(
					App.class);
			LOG.info("Spring started");

			Stats stats = context.getBean(Stats.class);
			try {
				stats.execute(args);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			LOG.info("application finished");
		}

	}

	@Bean
	public TcxFileParser tcxFileParser() {
		return new TcxFileParser();
	}

}
