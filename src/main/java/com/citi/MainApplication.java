package com.citi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.citi.service.implementation.BSEDataServiceImpl;
import com.citi.service.implementation.NSEDataServiceImpl;

@SpringBootApplication
//@EntityScan(basePackages = {"com.citi.domain"})
//@ComponentScan(basePackages = "com.citi")
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		
		
		
//		 BSEDataServiceImpl.BSEData();
//		 NSEDataServiceImpl.NSEData();
		
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String password = "yawinpassword";
//		String encodedPassword = passwordEncoder.encode(password);
//		System.out.println();
//		System.out.println("Password is         : " + password);
//		System.out.println("Encoded Password is : " + encodedPassword);
	}

}
