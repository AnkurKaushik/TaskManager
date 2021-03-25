package com.example.TaskManager.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.TaskManager.entities.singleUser;

public interface UserRepository extends CrudRepository<singleUser, Integer> {

    public singleUser findByName(String username);
}