package com.jiaying.parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.jiaying.resource.CourseWork;
import com.jiaying.resource.Unit;

@Component
public class JsonParser implements Parser {

	@Override
	public ArrayList<CourseWork> parse(JSONArray courseunits) {
		ArrayList<CourseWork> courseWorks = new ArrayList<>();
		for (int i = 0; i < courseunits.length(); i++) {
			JSONObject jo = courseunits.getJSONObject(i);
			try {
				CourseWork cs = new CourseWork.CourseWorkBuilder(jo.getString("Assessment Name"), jo.getString("Weight"), jo.getString("Due")).build();
				courseWorks.add(cs);
			} catch (Exception e) {}
		}
		return courseWorks;
	}
}
