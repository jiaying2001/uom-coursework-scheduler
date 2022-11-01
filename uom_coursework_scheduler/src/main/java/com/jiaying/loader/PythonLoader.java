package com.jiaying.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


@Component
public class PythonLoader extends AbstractResourceLoader implements ResourceLoader{

	@Override
	public String load(String filename) {
		ProcessBuilder processBuilder = new ProcessBuilder("python3", resolvePythonScriptPath(filename));
		processBuilder.redirectErrorStream(true);
		try {
			 Process process = processBuilder.start();
			 return new BufferedReader(new InputStreamReader(process.getInputStream()))
					   .lines().collect(Collectors.joining("\n"));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String resolvePythonScriptPath(String filename) {
		File file = new File(ROOT_DIR + "/python/" + filename);
		return file.getAbsolutePath();
	}
}
