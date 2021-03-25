package com.example.TaskManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.entities.UserTask;
import com.example.TaskManager.repositories.UserRepository;



@Service
public class UserService {
	
	@Autowired
	 private UserRepository userRepository;
	
	

    public Iterable<UserTask> GetAllUsers()
    {
        return userRepository.findAll();
    }


    public UserTask GetUserByName(String name) {
        UserTask foundUser = userRepository.findByName(name);
        return foundUser;
    }
    
    public UserTask GetUserById(int id) throws Exception {
    	Optional<UserTask> foundUser = userRepository.findById(id);
    	
    	//TODO: we need to decide how to handle a "Not Found" condition
    	if(!foundUser.isPresent())
    		return null;
    	
    	return(foundUser.get());
    }
    
    public void UpdateUser(UserTask usertoUpdate) {
    	userRepository.save(usertoUpdate);
    }
    
    public void setUser(UserTask u, String name, String email, String password) {
    	//u.setId(id);
    	u.setName(name);
    	u.setEmail(email);
    	u.setPassword(password);
    	UpdateUser(u);
    }

}
