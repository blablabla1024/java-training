package com.jksoft.runpro.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogOutputPrinter implements OutputPrinter{
	
	private static final Logger LOG = LoggerFactory.getLogger(LogOutputPrinter.class);

	@Override
	public void print(String string) {
		LOG.info(string);
		
	}

}
