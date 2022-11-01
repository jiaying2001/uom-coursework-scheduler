package com.jiaying.loader;

public abstract class AbstractResourceLoader implements ResourceLoader{
	String ROOT_DIR = "src/main/resources";
	
	@Override
	public abstract String load(String filename);
}
