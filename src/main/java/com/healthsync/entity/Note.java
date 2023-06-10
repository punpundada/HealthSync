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
@Table(name = "Notes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Note {
	@Id
	private int id;
    private int task_Id;
    private String content;
    private Date createdAt;
}
