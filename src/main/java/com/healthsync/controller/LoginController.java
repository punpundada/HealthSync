package com.healthsync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.healthsync.responce.UserDto;
import com.healthsync.service.UserService;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	@Autowired
	private UserService userService;
	
	public ResponseEntity<UserDto> loginUser(String password , String username){
		UserDto dto = this.userService.isLoggin(username, password);
		return new ResponseEntity<UserDto>(dto, HttpStatus.OK);
	}
	
}
