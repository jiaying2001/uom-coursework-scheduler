package com.jiaying.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiaying.service.ShedulerService;
import com.jiaying.timetable.ITimeslot;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class mainController {
	@Autowired
	ShedulerService shedulerService;
	
	@GetMapping
	@ResponseBody
	public List<ITimeslot> showHome() { 
		return shedulerService.listAllSheduledCoursworks();
	}
}
