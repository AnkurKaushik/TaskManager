package com.example.TaskManager.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.TaskManager.entities.AllTasks;
import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.entities.singleUser;
import com.example.TaskManager.exceptions.UserNotFoundException;
import com.example.TaskManager.repositories.TaskRepository;
import com.example.TaskManager.repositories.UserRepository;
import com.example.TaskManager.services.TaskService;
import com.example.TaskManager.services.UserService;


@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskRepository taskRepository;
	
    Logger logger = LoggerFactory.getLogger(MainController.class);
    Integer currID = null;
    User currUser = null;
    
	 @GetMapping(value="/")
     public String showHomePage(ModelMap model, 
    		 @RequestParam(value="name", required=false, defaultValue="World") String name){
	     model.addAttribute("name", name);
	     currUser = null;
		 return "home";
     }
	 
	 @GetMapping(value="/register")
     public String showRegisterPage(ModelMap model){
		 return "register";
     }
	 
	 @GetMapping(value="/login")
     public String showLoginPage(ModelMap model){
		 return "login";
     }
	 
	 @GetMapping(value="/about")
     public String showAboutPage(ModelMap model){
		 return "about";
     }
	 
	 @PostMapping(value="/add")
	 public String addUser(@RequestParam("nameadd") String nameadd, @RequestParam("emailadd") String emailadd, @RequestParam("passwordadd") String passwordadd, ModelMap modelMap)
	 {
		 ArrayList<User> userarry = (ArrayList<User>) userRepository.findAll();
		 try {
		 User u = userService.GetUserByName(nameadd);
		 for(User su : userarry)
			 if(su.getName().equals(nameadd)) return "error";
		 User user = new User(nameadd,emailadd,passwordadd);
		 userService.UpdateUser(user);
		 return "success";
		 }
		 catch(Exception e)
		 {
			 return "error";
		 }
	 }
	 
	 @PostMapping(value="/loginHandler")
	 public String handleLogin(@RequestParam("namelogin") String namelogin, @RequestParam("passwordlogin") String passwordlogin, ModelMap modelMap)
	 {
		 ArrayList<User> userarry = (ArrayList<User>) userRepository.findAll();
		 try {
		 for(User su : userarry)
		 {
			 if(su.getName().equals(namelogin) && su.getPassword().equals(passwordlogin))
			 {
				modelMap.put("userName", namelogin);
				currUser = su;
				return "dashboard";
			 }
		 }
		 return "error";
		 }
		 catch(Exception e)
		 {
			 return "error";
		 }
	 }
	 
	 public boolean isNumber(String s)
	 {
		 if(s == null)
			 return false;
		 try
		 {
			 double db = Double.parseDouble(s);
		 }
		 catch(NumberFormatException e)
		 {
			 return false;
		 }
		 return true;
	 }
	 
	 @GetMapping("/update")                     
	 public String saveDetails(ModelMap modelMap) {
        return "update";           
	 }
	 
	 public User findUser(String name)
	 {
		 ArrayList<User> userarry = (ArrayList<User>) userRepository.findAll();
		 for(User u : userarry)
			 if(u.getName().equals(name)) return u;
		 return null;
	 }
	 
	 @PostMapping("/update2")                     
	 public String updateDetails(@RequestParam("taskname") String taskname, @RequestParam("taskstart") String taskstart, @RequestParam("taskend") String taskend, @RequestParam("taskdesc") String taskdesc, @RequestParam("taskemail") String taskemail, @RequestParam("sev") String taskseverity, ModelMap modelMap) {
		 
		 Task at = new Task(taskname, taskstart, taskend, taskseverity, taskdesc, taskemail, currUser);
		 taskRepository.save(at);
		 modelMap.put("userName", currUser.getName());
		 modelMap.put("sTask", "Successfully added task: " + taskname);
		 //taskService.UpdateTask(at);
		 return "dashboard";
	 }
}

