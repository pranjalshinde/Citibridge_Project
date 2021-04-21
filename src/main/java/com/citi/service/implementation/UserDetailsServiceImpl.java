package com.citi.service.implementation;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.citi.configs.CustomUserDetails;
import com.citi.domain.User;
import com.citi.domain.UserKey;
import com.citi.repository.UserKeyRepository;
import com.citi.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	
	@Autowired
	private UserKeyRepository userKeyRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//fetching user from database
		
		//System.out.println("userDetailsService working fine");
		
		
		
		User user = userRepository.getUserByUsername(username);
		
		
		
		//System.out.println("Username fetched");
		
		if(user == null) {
			throw new UsernameNotFoundException("Could not found this user!");
		}
		
		UserKey userKey = userKeyRepository.getUserById(user.getId());
		if(userKey == null) {
			throw new UsernameNotFoundException("Invalid User");
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encoded = passwordEncoder.encode(userKey.getPassword());
		userKey.setPassword(encoded);
		CustomUserDetails customUserDetails = new CustomUserDetails(user, userKey);
		
		//System.out.println(customUserDetails.getPassword());
		
		return customUserDetails;
	}
	
	

}
