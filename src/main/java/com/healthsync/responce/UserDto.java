package com.healthsync.responce;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserDto {
	private int id;
	private String username;
	private String password;
	private String name;
	private String email;
	private String profilePicture;
	private TaskDto task;

}
