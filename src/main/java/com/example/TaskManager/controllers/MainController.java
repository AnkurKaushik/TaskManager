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

import com.example.TaskManager.entities.UserTask;
import com.example.TaskManager.services.UserService;


@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
    Logger logger = LoggerFactory.getLogger(MainController.class);
    String currID = null;
    	
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
	 
	 @PostMapping(value="/index")
	 public String showIndexPage(@RequestParam("namelogin") String namelogin, @RequestParam("passwordlogin") String passwordlogin, ModelMap modelMap)
	 {
		 try {
			 UserTask u = userService.GetUserByName(namelogin);
			 if(u.getName().equals(namelogin) && u.getPassword().equals(passwordlogin))
		     {
			     return "index";
			 }
			 else 
			 {
				 return "home";
			 }
		 }
		 catch(NullPointerException e) {
			 return "home";
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
	 public String saveDetails(@RequestParam("id") String id, ModelMap modelMap) {
	        
		try 
		{
			UserTask user = userService.GetUserById(Integer.valueOf(id));
			ArrayList<UserTask> userList = new ArrayList<>();
			if(user != null)
			{
				userList.add(user);
				Iterable<UserTask> users = userList;
				currID = id;
				modelMap.put("user", users);
			}
			else
				return "nouser";
		} 
		catch (NumberFormatException e) 
		{
			// TODO Auto-generated catch block
			return "nouser";
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 	
		modelMap.put("ID", id);
        return "update";           
	 }
	 
	 @PostMapping("/update2")                     
	 public String updateDetails(@RequestParam("nameedit") String nameedit, @RequestParam("emailedit") String emailedit, @RequestParam("passwordedit") String passwordedit, ModelMap modelMap) {
		 ArrayList<UserTask> userList = new ArrayList<>();
		 try
		 {
			 UserTask u = userService.GetUserById(Integer.valueOf(currID));
			 userService.setUser(u, nameedit, emailedit, passwordedit);
			 userList.add(u);
			 Iterable<UserTask> users = userList;
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

