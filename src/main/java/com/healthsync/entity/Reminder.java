package com.healthsync.entity;

import java.time.LocalDateTime;

import com.healthsync.enums.ReminderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Reminders")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Reminder {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private String message;
    
    @Column(name = "reminder_time")
    private LocalDateTime reminderTime;
    
    @Enumerated(EnumType.STRING)
    private ReminderStatus status;

}
