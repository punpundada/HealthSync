package com.healthsync.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthsync.entity.Reminder;
import com.healthsync.entity.User;
import com.healthsync.responce.ApiResponce;
import com.healthsync.responce.UserDto;
import com.healthsync.service.ReminderService;
import com.healthsync.service.UserService;

@RestController
@RequestMapping("/api/reminder")
public class ReminderController {
	@Autowired
	private ReminderService reminderService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Reminder>> getAllReminders(@PathVariable Integer userId){
	 UserDto user = this.userService.getUser(userId);
	 List<Reminder> reminders= user.getAllReminders();
	 return new ResponseEntity<List<Reminder>>(reminders , HttpStatus.OK);
	}
	
	@PostMapping("/user/{userId}")
	public ResponseEntity<Reminder> saveReminder(@RequestBody Reminder reminder,@PathVariable Integer userId) {
		UserDto user = this.userService.getUser(userId);
		 List<Reminder> reminders= user.getAllReminders();
		 reminders.add(reminder);
		 this.userService.saveUser(user);
		 this.reminderService.saveReminder(reminder, userId);
		 return new ResponseEntity<Reminder>(reminder , HttpStatus.CREATED);
	}
	
	@PutMapping("/{remId}")
	public ResponseEntity<Reminder> updateReminder(@RequestBody Reminder reminder, @PathVariable Integer remId){
		
		Reminder updatedReminder = this.reminderService.updateReminder(reminder, remId);
		return new ResponseEntity<Reminder>(updatedReminder ,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{remId}")
	public ResponseEntity<ApiResponce> deleteReminder(Integer remId){
		this.reminderService.deleteReminder(remId);
		return new ResponseEntity<ApiResponce>(new ApiResponce(String.format("The reminder deleted with %d id", remId), true) , HttpStatus.OK);
	}
}
