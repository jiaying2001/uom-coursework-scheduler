package com.jiaying.timetable;

import java.util.Date;

public abstract class AbstractTimeslot implements ITimeslot {
		private String shortName;
		private String fullName;
		private int duration;
		private int scheduleDay;
		private String activityType;
		private Date startTime;
		private Date endTime;
}
