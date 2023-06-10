package com.healthsync.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Collaborators")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Collaborator {
	private int id;
	private List<User> users;
	private Task task_id;
}
