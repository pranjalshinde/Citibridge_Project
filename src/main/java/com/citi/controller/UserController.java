package com.citi.controller;

import com.citi.domain.User;
import com.citi.domain.UserKey;
import com.citi.service.UserService;
import com.citi.service.implementation.UserServiceImpl;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/person")

@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public Boolean getPersonData(@RequestBody User p)
    {
//    	System.out.println(p.getName());
    	try {
//			personService.savePerson(p);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
    
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getDataFromUi(@RequestParam String name)
    {
		System.out.println(name);
		return name;
	}
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user, UserKey key) {
    	String output;
    	UserServiceImpl valid = new UserServiceImpl();
    	if(valid.validateUser(user.getUserName(), key.getPassword()) != null) {
    		output = "Login Successful";
    	}
    	else {
    		output = "Invalid details";
    	}
    	return output;
    }
}