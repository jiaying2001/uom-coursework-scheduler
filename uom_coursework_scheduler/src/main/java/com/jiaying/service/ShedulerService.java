package com.jiaying.service;

import java.util.List;

import com.jiaying.resource.Unit;
import com.jiaying.timetable.ITimeslot;

public interface ShedulerService {

	List<ITimeslot> listAllSheduledCoursworks();

}
