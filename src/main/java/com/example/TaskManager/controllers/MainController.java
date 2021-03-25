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

import com.example.TaskManager.entities.singleUser;
import com.example.TaskManager.exceptions.UserNotFoundException;
import com.example.TaskManager.repositories.UserRepository;
import com.example.TaskManager.services.UserService;


@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
    Logger logger = LoggerFactory.getLogger(MainController.class);
    Integer currID = null;
    	
	 @GetMapping(value="/")
     public String showHomePage(ModelMap model, 
    		 @RequestParam(value="name", required=false, defaultValue="World") String name){
	     model.addAttribute("name", name);    
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
		 ArrayList<singleUser> userarry = (ArrayList<singleUser>) userRepository.findAll();
		 try {
		 singleUser u = userService.GetUserByName(nameadd);
		 for(singleUser su : userarry)
			 if(su.getName().equals(nameadd)) return "error";
		 singleUser user = new singleUser(nameadd,emailadd,passwordadd);
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
		 ArrayList<singleUser> userarry = (ArrayList<singleUser>) userRepository.findAll();
		 try {
		 for(singleUser su : userarry)
		 {
			 if(su.getName().equals(namelogin) && su.getPassword().equals(passwordlogin))
				 return "update";
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
	 
	 @PostMapping("/update")                     
	 public String saveDetails(ModelMap modelMap) {
		singleUser u;
		try {
			u = userService.GetUserById(currID);
		} catch (Exception e) {
			return "nouser";
		}
		modelMap.put("userName", u.getName());
		modelMap.put("userEmail", u.getEmail());
        return "update";           
	 }
	 
	 @PostMapping("/update2")                     
	 public String updateDetails(@RequestParam("nameedit") String nameedit, @RequestParam("emailedit") String emailedit, @RequestParam("passwordedit") String passwordedit, ModelMap modelMap) {
		 ArrayList<singleUser> userList = new ArrayList<>();
		 try
		 {
			 singleUser u = userService.GetUserById(Integer.valueOf(currID));
			 userService.setUser(u, nameedit, emailedit, passwordedit);
			 userList.add(u);
			 Iterable<singleUser> users = userList;
			 modelMap.put("user", users);
		 }
		 catch (NumberFormatException e)
		 {
			e.printStackTrace();
		 }
		 catch(Exception e)
		 {
			e.printStackTrace();
		 }
		 modelMap.put("IDedit", currID);
		 
		 return "update2";
	 }
}

