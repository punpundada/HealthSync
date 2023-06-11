package com.healthsync.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthsync.repository.TaskRepository;
import com.healthsync.responce.TaskDto;
import com.healthsync.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	
	private TaskService taskService;
	
	@PostMapping("/userId")
	public ResponseEntity<TaskDto> saveTask(@RequestBody TaskDto taskDto ,@PathVariable("userId")  Integer userId){
		TaskDto dto = this.taskService.saveTask(taskDto, userId);
		return new ResponseEntity<TaskDto>(dto , HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<TaskDto> getTask(@PathVariable("id") Integer taskId){
		TaskDto taskDto = this.taskService.getOneTask(taskId);
		return new ResponseEntity<TaskDto>(taskDto, HttpStatus.OK);
	}
	
	public ResponseEntity<List<TaskDto>> getAllTasks(Integer userID){
		List<TaskDto> allTasks = this.taskService.getAllTasks(userID);
		return new ResponseEntity<List<TaskDto>>(allTasks ,HttpStatus.OK);
	}
}
