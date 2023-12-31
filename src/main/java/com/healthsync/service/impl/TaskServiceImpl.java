package com.healthsync.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthsync.entity.Task;
import com.healthsync.entity.User;
import com.healthsync.exception.ResourceNotFoundException;
import com.healthsync.repository.TaskRepository;
import com.healthsync.repository.UserRepository;
import com.healthsync.responce.TaskDto;

import com.healthsync.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public TaskDto saveTask(TaskDto taskDto ,Integer userID) {
		User user = this.userRepository.findById(userID).orElseThrow(()-> new ResourceNotFoundException("User", "id", userID));
		Task task = this.DtoToTask(taskDto);
		List<Task> userTasks = user.getTasks();
		userTasks.add(task);
		user.setTasks(userTasks);
		this.userRepository.save(user);
		Task task2 = this.taskRepository.save(task);
		return this.TaskToDto(task2);
		
	}

	@Override
	public TaskDto getOneTask(Integer taskId) {
		
		Task task = this.taskRepository.findById(taskId).orElseThrow(()-> new ResourceNotFoundException("Task", "id", taskId));
		TaskDto dto = this.TaskToDto(task);
		
		  return dto;
				
		
	}

	@Override
	public List<TaskDto> getAllTasks(Integer userId) {
		
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		List<Task> allTasks = user.getTasks();
		
		List<TaskDto> allTaskDto = allTasks.stream().map(task -> this.TaskToDto(task)).collect(Collectors.toList());
		return allTaskDto;
	}

	@Override
	public TaskDto updateTask(TaskDto taskDto, Integer taskId) {
		Task task = this.taskRepository.findById(taskId).orElseThrow(()-> new ResourceNotFoundException("Task", "id", taskId));
		
		task.setCategoryId(taskDto.getCategoryId());
		task.setCompleted(taskDto.isCompleted());
		task.setDueDate(taskDto.getDueDate());
		task.setTitle(taskDto.getTitle());
		task.setDescription(taskDto.getDescription());
		task.setPriority(taskDto.getPriority());
		task.setReminderDate(taskDto.getReminderDate());
		 
		return this.TaskToDto(task);
	}

	@Override
	public void deleteTask(Integer taskId) {
		
		this.taskRepository.findById(taskId).orElseThrow(()-> new ResourceNotFoundException("Task", "id", taskId));
		this.taskRepository.deleteById(taskId);
		
	}
	
	private TaskDto TaskToDto(Task task) {
		return this.modelmapper.map(task, TaskDto.class);
	}
	
	private Task DtoToTask(TaskDto dto) {
		
		return this.modelmapper.map(dto, Task.class);
	}
	
	
	

}
