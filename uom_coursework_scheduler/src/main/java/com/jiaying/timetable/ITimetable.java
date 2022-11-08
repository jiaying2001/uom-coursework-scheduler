package com.jiaying.timetable;

import java.util.ArrayList;
import java.util.Date;

public interface ITimetable {
	ITimeslot getTimeslotAt(Date date);
	void moveTimeslotTo(ITimeslot timeslot, Date date);
	ArrayList<ITimeslot> getAvailableSlots();
	ArrayList<ITimeslot> getAvailableSlotsAt(Date date);
	ArrayList<ITimeslot> getAvailableSlotsafter(Date date);
	ITimeslot getEarliestTimeslot(Date date);
	ITimeslot getEarliestTimeslotAfter(Date date);
	ITimeslot getEarliestTimeslotAt(Date date);
	boolean haveAnyAvailableSlotAt(Date date);
	boolean haveAnyAvailableSlotAfter(Date date);
	boolean haveAnyAvailableSlot(Date date);
	void putTimeslot(ITimeslot timeslot);
	void removeTimeslot(ITimeslot timeslot);
}
