package com.healthsync.service;

import java.util.List;

import com.healthsync.entity.Reminder;

public interface ReminderService {
	
	public Reminder saveReminder(Reminder reminder , Integer userId);
	public List<Reminder> getAllReminders(Integer userId);
	public Reminder updateReminder(Reminder reminder, Integer remId);
	public void deleteReminder(Integer remId);

}
