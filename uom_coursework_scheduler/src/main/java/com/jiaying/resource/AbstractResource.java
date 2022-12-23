package com.jiaying.resource;

import java.util.ArrayList;

import com.jiaying.loader.ResourceLoader;
import com.jiaying.parser.Parser;

import lombok.Data;

@Data
public abstract class AbstractResource implements Resource{
	protected Parser parser;
	protected ResourceLoader loader;
	protected ArrayList<CourseWork> courseWorks;
	
	AbstractResource(Parser parser, ResourceLoader loader){
		this.parser = parser;
		this.loader = loader;
	}
	
	public ArrayList<CourseWork> getCourseWorks(){
		return courseWorks;
	}
	
	public abstract void assemble(String filename);
}
