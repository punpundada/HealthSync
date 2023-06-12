package com.healthsync.entity;

import java.util.ArrayList;
import java.util.List;import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name =  "Users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String username;
	@NotBlank
	@Size(min = 8, max = 20)
	private String password;
	@NotBlank
	private String name;
	@Email
	private String email;
	private String profilePicture;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Task> tasks;
	 
	@OneToMany(cascade = CascadeType.ALL)
	private List<Reminder> allReminders;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<MedicationSchedule> allMedicationSchedule=new ArrayList<>();
	
}
