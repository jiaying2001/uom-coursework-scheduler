package com.jiaying.loader;

import com.jiaying.resource.Resource;

public abstract class AbstractResourceLoader implements ResourceLoader{
	String ROOT_DIR = "src/main/resources";
	
	@Override
	public abstract Resource load(String filename);
}
