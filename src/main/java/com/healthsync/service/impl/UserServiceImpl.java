package com.healthsync.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.healthsync.entity.User;
import com.healthsync.exception.ResourceNotFoundException;
import com.healthsync.repository.UserRepository;
import com.healthsync.responce.UserDto;
import com.healthsync.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public UserDto saveUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepository.save(user);
		return this.UserToDto(savedUser);
	}

	@Override
	public UserDto getUser(Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId) );
		return this.UserToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> allUsers = this.userRepository.findAll();
		List<UserDto> allUserDtos = allUsers.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
		return allUserDtos;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId) );
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getUsername());
		user.setProfilePicture(userDto.getProfilePicture());
		
		return this.UserToDto(user);
	}

	@Override
	public void deleteUser(Integer userId) {
		
		this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId) );
		this.userRepository.deleteById(userId);
		
		
	}
	
	private User dtoToUser(UserDto userDto) {
		User user = this.modelmapper.map(userDto, User.class);
		return user;
	}
	
	private UserDto UserToDto(User user) {
		UserDto userDto = this.modelmapper.map(user, UserDto.class);
		return userDto;
	}

}
