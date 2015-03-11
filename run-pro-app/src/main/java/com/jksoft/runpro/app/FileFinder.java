package com.jksoft.runpro.app;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FileFinder {
	
	private static final Logger LOG = LoggerFactory.getLogger(FileFinder.class);
	
	public File findFile(String filePath){
		Path path = getPathToResource(filePath);
		return path.toFile();
	}
	
	private Path getPathToResource(String filePath) {
		try {
			URL systemResource = ClassLoader.getSystemResource(filePath);
			if(systemResource == null){
				LOG.info("File could not be found");
				throw new IllegalArgumentException("File could not be found");
			}
			return Paths.get(systemResource.toURI());
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException("File could not be loaded", e);
		}
	}

}
