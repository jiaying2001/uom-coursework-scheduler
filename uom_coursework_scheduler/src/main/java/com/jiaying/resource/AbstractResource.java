package com.jiaying.resource;

import java.util.ArrayList;

import com.jiaying.loader.ResourceLoader;
import com.jiaying.parser.Parser;

import lombok.Data;

@Data
public abstract class AbstractResource {
	protected Parser parser;
	protected ResourceLoader loader;
	protected ArrayList<Unit> courseWorks;
	
	AbstractResource(Parser parser, ResourceLoader loader){
		this.parser = parser;
		this.loader = loader;
	}
	
	public ArrayList<Unit> getCourseWorks(){
		return courseWorks;
	}
	
	abstract void assemble(String filename);
}
