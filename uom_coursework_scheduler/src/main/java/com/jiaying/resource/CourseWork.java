package com.jiaying.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

import lombok.Data;

@Data
public class CourseWork extends ExtraFeatures implements Unit {
	private final String name;
	private final String weight;
	private final Date dueDate;
	
	CourseWork(CourseWorkBuilder builder){
		name = builder.name;
		weight = builder.weight;
		dueDate = builder.dueDate;
	}
	
	public String getName() {
		return name;
	}

	public String getWeight() {
		return weight;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public static class CourseWorkBuilder{
		private final String name;
		private final String weight;
		private final Date dueDate;
		
		public CourseWorkBuilder(String name, String weight, String dueDate) throws ParseException{
			this.name = name;
			this.weight = weight;
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-HH:mm-yyyy");
			this.dueDate = formatter.parse(dueDate + "-" + Integer.toString(Year.now().getValue()));
		}
		public CourseWork build()
		{
			return new CourseWork(this);
		}
	}
}
