package com.jiaying.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jiaying.commons.Wrapper;
import com.jiaying.resource.CourseWork;
import com.jiaying.timetable.ITimeslot;
import com.jiaying.timetable.Timetable;


@Component
public class Scheduler implements IScheduler{
	
	public List<ITimeslot> schedule(List<CourseWork> courseworks){
		return courseworks.stream()
					.sorted((arg1, arg2) -> {
						int returnValue = arg1.getDueDate().compareTo(arg2.getDueDate());
						if(returnValue == 0) return Long.compare(arg1.getOrder(), arg2.getOrder());
						return returnValue;
					})
					.map(Wrapper::courseworkToTimeslot)
					.collect(Collectors.toCollection(ArrayList::new));
	}
}
