package com.citi.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.citi.domain.User;
import com.citi.domain.UserKey;
import com.citi.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//fetching user from database
		
		User user = userRepository.getUserByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Could not found this user!");
		}
		UserKey userKey = userRepository.getUserById(user.getId());
		if(userKey == null) {
			throw new UsernameNotFoundException("Invalid User");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(user, userKey);
		return customUserDetails;
	}

}
