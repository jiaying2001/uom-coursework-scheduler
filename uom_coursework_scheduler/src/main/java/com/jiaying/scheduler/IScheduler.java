package com.jiaying.scheduler;

import java.util.List;

import com.jiaying.resource.CourseWork;
import com.jiaying.timetable.ITimeslot;

public interface IScheduler {
	public List<ITimeslot> schedule(List<CourseWork> courseworks);
}
