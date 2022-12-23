package com.jiaying.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaying.evaluator.IEvaluator;
import com.jiaying.loader.ResourceLoader;
import com.jiaying.resource.Resource;
import com.jiaying.scheduler.IScheduler;
import com.jiaying.service.ShedulerService;
import com.jiaying.timetable.ITimeslot;
import com.jiaying.timetable.assembler.ITimetableAssembler;

@Service
public class ShedulerServiceImpl implements ShedulerService {

//	@Autowired
//	ITimetableAssembler timetableAssembler;
	
	@Autowired
	Resource uomSpotResource;
	
//	@Autowired
//	IEvaluator evaluator;
	
	@Autowired 
	IScheduler scheduler;
	
//	@Autowired
//	ResourceLoader pythonLoader;
	
	public List<ITimeslot> listAllSheduledCoursworks() {
		// TODO Auto-generated method stub
//		timetableAssembler.assembleTimetable(pythonLoader);
//		evaluator.evaluate(uomSpotResource);
		uomSpotResource.assemble("spotLoader.py");
		return scheduler.schedule(uomSpotResource.getCourseWorks());
	}
	
	

}
