package com.healthsync.responce;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TaskDto {

	
	private int id;
    private int categoryId;
    private String title;
    private String description;
    private LocalDate dueDate;
    private String priority;
    private boolean isCompleted;
    private LocalDate reminderDate;
}
