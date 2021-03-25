package com.example.TaskManager.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.TaskManager.entities.UserTask;

public interface UserRepository extends CrudRepository<UserTask, Integer> {

    public UserTask findByName(String name);
}