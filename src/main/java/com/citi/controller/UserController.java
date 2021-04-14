package com.citi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.citi.domain.User;
import com.citi.domain.UserKey;
//import com.citi.service.UserService;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class UserController {
    
//    @Autowired
//    private UserDetailsService userDetailsService;
    
//    @RequestMapping(value = "/person", method = RequestMethod.POST)
//    public Boolean getPersonData(@RequestBody User p)
//    {
//    	System.out.println(p.getName());
//    	try {
//			userService.savePerson(p);
//			return true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
//	}
    
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getDataFromUi(@RequestParam String name)
    {
		System.out.println(name);
		return name;
	}
    
 
    @RequestMapping("/index")
    public String dashboard() {
    	System.out.println("getUserName in Controller.java");
    	return "index";
    }
    
}