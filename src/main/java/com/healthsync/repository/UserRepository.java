package com.healthsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthsync.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
