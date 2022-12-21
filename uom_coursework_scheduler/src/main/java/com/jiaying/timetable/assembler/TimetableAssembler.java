package com.jiaying.timetable.assembler;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jiaying.loader.ResourceLoader;
import com.jiaying.timetable.ITimeslot;
import com.jiaying.timetable.Timeslot;
import com.jiaying.timetable.Timetable;

@Component
public class TimetableAssembler implements ITimetableAssembler{
	
	public void assembleTimetable(ResourceLoader pythonLoader) {
			ArrayList<ITimeslot> timeslots = new ArrayList<>();
			
			String timetable = pythonLoader.load("timetable.py");
			JSONObject jo = new JSONObject(timetable);
			JSONArray ja = jo.getJSONArray("activities");
			for(Object timeslotObject: ja) {
				JSONObject TimeslotJO = (JSONObject) timeslotObject;
				ITimeslot timeslot = new Timeslot.TimeslotBuilder(TimeslotJO.getString("moduleName"))
						.duration(Integer.parseInt(TimeslotJO.getString("duration")))
						.startTime(TimeslotJO.getString("startTime"))
						.endTime(TimeslotJO.getString("endTime"))
						.scheduleDay(Integer.parseInt(TimeslotJO.getString("scheduledDay")))
						.activityType(TimeslotJO.getString("activityType"))
						.build();
				timeslots.add(timeslot);
			}
			Timetable.getInstance().setTimeslots(timeslots);
		}
}
