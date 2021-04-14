package com.citi.main;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.citi.service.implementation.UserDetailsServiceImpl;

@SpringBootTest
class MainApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void login() {
		UserDetailsServiceImpl userDetailsServiceImpl = new UserDetailsServiceImpl();
		UserDetails u = userDetailsServiceImpl.loadUserByUsername("Yashika.Jain");
		if(u != null) {
			System.out.println("true");
		}
		else {
			System.out.print("false");
		}
	}
	
}
