package com.jiaying.resource;

import java.util.List;

public interface Resource {
	public List<CourseWork> getCourseWorks();
	public void assemble(String filename);
}
