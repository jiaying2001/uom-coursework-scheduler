package com.jiaying.parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jiaying.resource.Unit;
import com.jiaying.timetable.ITimeslot;
import com.jiaying.timetable.Timeslot;

public class timetableParser{

	public ArrayList<ITimeslot> parse(JSONObject jo) {
		// TODO Auto-generated method stub
		ArrayList<ITimeslot> timeslotArray = new ArrayList<>();
		
		JSONArray timeslots = jo.getJSONArray("activities");
		for(int timeslotIndex=0; timeslotIndex < timeslots.length(); timeslotIndex++)
		{
			JSONObject timeslot = timeslots.getJSONObject(timeslotIndex);
			timeslotArray.add(new Timeslot.TimeslotBuilder(timeslot.getString("moduleName")).build());
		}
		return null;
	}

}
