package com.healthsync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthsync.responce.ApiResponce;
import com.healthsync.responce.UserDto;
import com.healthsync.service.UserService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/user")
@NoArgsConstructor
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
	
	@PostMapping
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
		UserDto dto = this.userService.saveUser(userDto);
		return new ResponseEntity<UserDto>(dto, HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers(){
		 List<UserDto> allUsers = this.userService.getAllUsers();
		 return new ResponseEntity<List<UserDto>>(allUsers, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getOneUser(@PathVariable("id") Integer userId){
		UserDto dto = this.userService.getUser(userId);
		return new ResponseEntity<UserDto>(dto , HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto dto , @PathVariable("id") Integer userId){
		 UserDto userDto = this.userService.updateUser(dto, userId);
		 return new ResponseEntity<UserDto>(userDto , HttpStatus.OK);
	} 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponce> deleteUser(@PathVariable("id") Integer userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponce>(new ApiResponce("User deleted successfully", true), HttpStatus.OK);
	}
	
}
