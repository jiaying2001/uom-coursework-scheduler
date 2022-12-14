package com.jiaying.timetable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jiaying.resource.CourseWork;

import lombok.Data;

@Data
public class Timeslot implements ITimeslot {
		private final String shortName;
		private final String fullName;
		private final int duration;
		private final String weekLabels;
		private final int scheduleDay;
		private final String activityType;
		private final Date startTime;
		private final Date endTime;
		private final CourseWork coursework;
		
		Timeslot(TimeslotBuilder builder){
			shortName = builder.shortName;
			fullName = builder.fullName;
			duration = builder.duration;
			scheduleDay = builder.scheduleDay;
			activityType = builder.activityType;
			startTime = builder.startTime;
			endTime = builder.endTime;
			weekLabels = builder.weekLabels;
			coursework = builder.coursework;
		}
		
		public static class TimeslotBuilder{
			private final String shortName;
			private String weekLabels = "";
			private String fullName = "";
			private int duration = 0;
			private int scheduleDay = 0;
			private String activityType = "";
			private Date startTime = null;
			private Date endTime = null;
			private CourseWork coursework = null;
			public TimeslotBuilder(String shortName) {
				this.shortName = shortName;
			}
			public TimeslotBuilder coursework(CourseWork coursework) {
				this.coursework = coursework;
				return this;
			}
			public TimeslotBuilder weekLabels(String weekLabels) {
				this.weekLabels = weekLabels;
				return this;
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
			public TimeslotBuilder startTime(String startTime) {
				SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
				try {
					this.startTime = formatter.parse(startTime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return this;
			}
			public TimeslotBuilder endTime(String endTime) {
				SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
				try {
					this.endTime = formatter.parse(endTime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return this;
			}
			
			public Timeslot build() {
				return new Timeslot(this);
			}
			
		}
}
