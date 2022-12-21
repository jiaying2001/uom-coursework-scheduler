package com.jiaying.evaluator;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.jiaying.resource.CourseWork;
import com.jiaying.resource.Resource;
import com.jiaying.resource.Unit;

@Component
public class Evaluator {
	private static int[] proportion = new int[] {1, 2, 3};
	private static int sum;
	
	Evaluator(){
		int total=0;
		for(int i=0; i < proportion.length; i++) {
			total += proportion[i];
		}
		sum = total;
	}
	
	public void evaluate(Resource resource){
		ArrayList<Unit> courseWorks = resource.getCourseWorks();
		for(int i=0; i < courseWorks.size(); i++) {
			CourseWork courseWork = (CourseWork) courseWorks.get(i);
			courseWork.setOrder(Integer.parseInt(
					courseWork.getWeight()) * (proportion[0] / sum) +
					(courseWork.getDueDate().getTime() / (1000 * 60 * 60 * 24)) * (proportion[1] / sum) +
					courseWork.getTimeEstimate() * (proportion[2] / sum)
							);
		}
	}
}
