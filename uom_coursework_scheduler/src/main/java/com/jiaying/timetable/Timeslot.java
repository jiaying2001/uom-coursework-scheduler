package com.jiaying.timetable;

import java.util.Date;

public class Timeslot implements ITimeslot {
		private final String shortName;
		private final String fullName;
		private final int duration;
		private final int scheduleDay;
		private final String activityType;
		private final Date startTime;
		private final Date endTime;
		
		Timeslot(TimeslotBuilder builder){
			shortName = builder.shortName;
			fullName = builder.fullName;
			duration = builder.duration;
			scheduleDay = builder.scheduleDay;
			activityType = builder.activityType;
			startTime = builder.startTime;
			endTime = builder.endTime;
		}
		
		public static class TimeslotBuilder{
			private final String shortName;
			private String fullName = "";
			private int duration = 0;
			private int scheduleDay = 0;
			private String activityType = "";
			private Date startTime = null;
			private Date endTime = null;
			public TimeslotBuilder(String shortName) {
				this.shortName = shortName;
			}
			public TimeslotBuilder fullName(String fullName) {
				this.fullName = fullName;
				return this;
			}
			public TimeslotBuilder duration(int duration) {
				this.duration = duration;
				return this;
			}
			public TimeslotBuilder scheduleDay(int scheduleDay) {
				this.scheduleDay = scheduleDay;
				return this;
			}
			public TimeslotBuilder activityType(String activityType) {
				this.activityType = activityType;
				return this;
			}
			public TimeslotBuilder startTime(Date startTime) {
				this.startTime = startTime;
				return this;
			}
			public TimeslotBuilder endTime(Date endTime) {
				this.endTime = endTime;
				return this;
			}
			
			public Timeslot build() {
				return new Timeslot(this);
			}
			
		}
}
