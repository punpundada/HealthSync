package com.healthsync.service;

import java.util.List;

import com.healthsync.responce.TaskDto;

public interface TaskService {
	TaskDto saveTask(TaskDto taskDto, Integer userID);
	TaskDto getOneTask(Integer taskId);
	List<TaskDto> getAllTasks(Integer userId);
	TaskDto updateTask(TaskDto taskDto , Integer taskId);
	void deleteTask(Integer taskId);
}
