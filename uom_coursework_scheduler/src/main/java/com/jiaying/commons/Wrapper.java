package com.jiaying.commons;

import java.time.Year;
import java.util.Date;

import com.jiaying.resource.CourseWork;
import com.jiaying.timetable.ITimeslot;
import com.jiaying.timetable.Timeslot;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import lombok.NonNull;

public class Wrapper {

		public static ITimeslot courseworkToTimeslot(@NonNull CourseWork coursework) {
				String startDateString = "Sep-19-" + Integer.toString(Year.now().getValue());
				Date startDate = DateUtil.parse(startDateString, "MMM-dd-yyyy");
				long days = DateUtil.between(startDate, coursework.getDueDate(), DateUnit.DAY);
				long scheduleDay = days % 8;
				long weekLabel = (days + 8) / 7;
				return new Timeslot.TimeslotBuilder(coursework.getName())
						.scheduleDay((int) scheduleDay)
						.weekLabels(Long.toString(weekLabel))
						.coursework(coursework)
						.build();
		}
}
