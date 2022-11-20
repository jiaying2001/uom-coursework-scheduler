package com.jiaying;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.*;

import com.jiaying.loader.PythonLoader;

public class Test extends TestFather{
	
	public static void main(String args[]) {
		PythonLoader loader = new PythonLoader();
		String timetable = loader.load("timetable.py");
		JSONObject jo = new JSONObject(timetable);
		JSONArray ja = jo.getJSONArray("activities");
		JSONObject timeslot = ja.getJSONObject(0);
		String moduleName = timeslot.getString("moduleName");
		System.out.println(ja.length());
		
	}
}
