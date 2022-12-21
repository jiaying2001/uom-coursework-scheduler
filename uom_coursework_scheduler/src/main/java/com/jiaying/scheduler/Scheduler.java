package com.jiaying.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jiaying.resource.Unit;
import com.jiaying.timetable.ITimeslot;
import com.jiaying.timetable.Timetable;

@Component
public class Scheduler implements IScheduler{
	
	@Autowired
	Timetable timetable;
	
	public List<ITimeslot> schedule(List<Unit> courseworks){
		return null;
	}
}
