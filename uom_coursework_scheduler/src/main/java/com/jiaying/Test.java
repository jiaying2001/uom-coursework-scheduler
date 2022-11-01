package com.jiaying;

import java.util.Scanner;

import org.json.*;

import com.jiaying.loader.PythonLoader;

public class Test {
	public static void main(String args[]) {
		PythonLoader loader = new PythonLoader();
		String jsonString = loader.load("spotLoader.py");
		try (Scanner scanner = new Scanner(jsonString)) {
			jsonString = scanner.nextLine();
		}
		JSONArray courseunits = new JSONArray(jsonString);
	    JSONObject jo = courseunits.getJSONObject(0);
	    System.out.println(jo.getString("Due"));
	}
}
