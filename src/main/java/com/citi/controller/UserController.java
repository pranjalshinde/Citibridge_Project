package com.citi.controller;


import org.springframework.web.bind.annotation.*;

import com.citi.service.implementation.BSEDataServiceImpl;
import com.citi.service.implementation.NSEDataServiceImpl;

@RestController
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
    
    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public String getDataFromUi()
    {
    	String requiredAttributes = BSEDataServiceImpl.BSEData();
		System.out.println(requiredAttributes);
		return requiredAttributes;
	}
    
 
    @RequestMapping("/index")
    public String dashboard() {
    	System.out.println("getUserName in Controller.java");
    	return "index";
    }
    
}