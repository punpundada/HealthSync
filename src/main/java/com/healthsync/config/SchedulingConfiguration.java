package com.healthsync.config;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.healthsync.entity.Reminder;
import com.healthsync.enums.ReminderStatus;
import com.healthsync.repository.ReminderRepository;

@Configuration
@EnableScheduling
public class SchedulingConfiguration {
	@Autowired
    private ReminderRepository reminderRepository;
    
    @Scheduled(fixedDelay = 60000) // Runs every minute
    public void checkReminders() {
        LocalDateTime currentTime = LocalDateTime.now();
        List<Reminder> reminders = reminderRepository.findByReminderTimeBeforeAndStatus(currentTime, ReminderStatus.PENDING);
        
        for (Reminder reminder : reminders) {
            // Send reminder notification to user
            sendNotification(reminder.getUser().getEmail(), reminder.getMessage());
            
            // Update reminder status
            reminder.setStatus(ReminderStatus.SENT);
            reminderRepository.save(reminder);
        }
    }
    
    private void sendNotification(String email, String message) {
        // Implementation for sending notification, e.g., sending an email or push notification
    }
}
