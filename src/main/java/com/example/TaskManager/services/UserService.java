package com.example.TaskManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.entities.singleUser;
import com.example.TaskManager.repositories.UserRepository;



@Service
public class UserService {
	
	@Autowired
	 private UserRepository userRepository;
	
	

    public Iterable<singleUser> GetAllUsers()
    {
        return userRepository.findAll();
    }


    public singleUser GetUserByName(String name) {
        singleUser foundUser = userRepository.findByName(name);
        return foundUser;
    }
    
    public singleUser GetUserById(int id) throws Exception {
    	Optional<singleUser> foundUser = userRepository.findById(id);
    	
    	//TODO: we need to decide how to handle a "Not Found" condition
    	if(!foundUser.isPresent())
    		return null;
    	
    	return(foundUser.get());
    }
    
    public void UpdateUser(singleUser usertoUpdate) {
    	userRepository.save(usertoUpdate);
    }
    
    public void setUser(singleUser u, String name, String email, String password) {
    	//u.setId(id);
    	u.setName(name);
    	u.setEmail(email);
    	u.setPassword(password);
    	UpdateUser(u);
    }

}
