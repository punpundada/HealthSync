package com.healthsync.entity;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "Tasks")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Task {
	@Id
	private int id;
	private User users;
	private String title;
	private String description;
	private Date dueDate;
    private String priority;
    private boolean isCompleted;
    private Date reminderDate;

}
