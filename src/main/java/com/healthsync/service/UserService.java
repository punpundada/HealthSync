package com.healthsync.service;

import java.util.List;

import com.healthsync.responce.UserDto;

public interface UserService {
	public UserDto saveUser(UserDto userDto);
	public UserDto getUser(Integer userId);
	public List<UserDto> getAllUsers();
	public UserDto updateUser(UserDto uderDto , Integer userId);
	public void deleteUser(Integer userId);
	

}
