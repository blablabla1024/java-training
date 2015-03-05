package com.jksoft.runpro;

import org.springframework.stereotype.Component;

@Component
public class ConsoleOutputPrinter implements OutputPrinter{

	@Override
	public void print(String string) {
		System.out.println(string);
		
	}

}
