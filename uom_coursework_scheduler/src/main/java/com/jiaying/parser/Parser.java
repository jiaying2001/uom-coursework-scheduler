package com.jiaying.parser;

import java.util.ArrayList;

import org.json.JSONArray;

import com.jiaying.resource.CourseWork;
import com.jiaying.resource.Unit;

public interface Parser {
	ArrayList<CourseWork> parse(JSONArray courseunits);
}
