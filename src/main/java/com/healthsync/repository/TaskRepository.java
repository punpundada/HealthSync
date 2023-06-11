package com.healthsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthsync.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
