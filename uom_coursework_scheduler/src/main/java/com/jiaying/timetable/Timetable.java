package com.jiaying.timetable;

import java.util.ArrayList;
import java.util.Date;

import com.jiaying.loader.ResourceLoader;
import com.jiaying.parser.Parser;

public class Timetable implements ITimetable {
	// 单例模式
	public static Timetable timetable = new Timetable();
	private static ArrayList<ITimeslot> timeslots;
	
	private Timetable() {}

	@Override
	public ITimeslot getTimeslotAt(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveTimeslotTo(ITimeslot timeslot, Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ITimeslot> getAvailableSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ITimeslot> getAvailableSlotsAt(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ITimeslot> getAvailableSlotsafter(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITimeslot getEarliestTimeslot(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITimeslot getEarliestTimeslotAfter(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITimeslot getEarliestTimeslotAt(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean haveAnyAvailableSlotAt(Date date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean haveAnyAvailableSlotAfter(Date date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean haveAnyAvailableSlot(Date date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putTimeslot(ITimeslot timeslot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTimeslot(ITimeslot timeslot) {
		// TODO Auto-generated method stub
		
	}

	public static Timetable getInstance() {
		// TODO Auto-generated method stub
		return timetable;
	}

	@Override
	public void fillTimetableBy(ResourceLoader loader, Parser parser) {
		// TODO Auto-generated method stub
		
		
	}
	
}
