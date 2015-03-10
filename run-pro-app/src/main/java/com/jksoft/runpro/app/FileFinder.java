package com.jksoft.runpro.app;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component
public class FileFinder {
	
	public File findFile(String filePath){
		Path path = getPathToResource(filePath);
		return path.toFile();
	}
	
	private Path getPathToResource(String filePath) {
		try {
			return Paths.get(ClassLoader.getSystemResource(filePath).toURI());
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
