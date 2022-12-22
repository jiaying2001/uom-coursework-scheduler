package com.jiaying.scheduler;

import java.util.List;

import org.python.google.common.collect.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jiaying.resource.CourseWork;
import com.jiaying.timetable.ITimeslot;
import com.jiaying.timetable.Timetable;

import lombok.val;

@Component
public class Scheduler implements IScheduler{
	
	@Autowired
	Timetable timetable;
	
	public List<ITimeslot> schedule(List<CourseWork> courseworks){
		val byDuedateOrdering = new Ordering<CourseWork>() {
			@Override
			public int compare(CourseWork firstCoursework, CourseWork secondCoursework) {
				// TODO Auto-generated method stub
			return firstCoursework.getDueDate().compareTo(secondCoursework.getDueDate());
			}
		};
		courseworks.sort(byDuedateOrdering);
		for(CourseWork unit: courseworks) {
			break;
		}
		return null;
	}
}
