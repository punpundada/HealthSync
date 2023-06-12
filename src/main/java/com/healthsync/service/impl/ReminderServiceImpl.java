package com.healthsync.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.healthsync.entity.Reminder;
import com.healthsync.entity.User;
import com.healthsync.exception.ResourceNotFoundException;
import com.healthsync.repository.ReminderRepository;
import com.healthsync.repository.UserRepository;
import com.healthsync.service.ReminderService;

public class ReminderServiceImpl implements ReminderService {
	@Autowired
	private ReminderRepository reminderRepository;
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public Reminder saveReminder(Reminder reminder,Integer userId) {
		
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		Reminder reminder2 = this.reminderRepository.save(reminder);
		return reminder2;
	}

	@Override
	public List<Reminder> getAllReminders(Integer userId) {
		
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		List<Reminder> allReminders = user.getAllReminders();
		
		return allReminders;
	}

	@Override
	public Reminder updateReminder(Reminder reminder, Integer remId) {
		Reminder reminder2 = this.reminderRepository.findById(remId).orElseThrow(()-> new ResourceNotFoundException("Reminder", "id", remId));
		reminder2.setMessage(reminder.getMessage());
		reminder2.setReminderTime(reminder.getReminderTime());
		reminder2.setStatus(reminder.getStatus());
		
		return reminder2;
	}

	@Override
	public void deleteReminder(Integer remId) {
		this.reminderRepository.findById(remId).orElseThrow(()-> new ResourceNotFoundException("Reminder", "id", remId));
		this.reminderRepository.deleteById(remId);
		
	}

}
