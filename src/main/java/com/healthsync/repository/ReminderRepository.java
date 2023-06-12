package com.healthsync.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthsync.entity.Reminder;
import com.healthsync.enums.ReminderStatus;

public interface ReminderRepository extends JpaRepository<Reminder, Integer>  {
	List<Reminder> findByReminderTimeBeforeAndStatus(LocalDateTime time, ReminderStatus status);
}
