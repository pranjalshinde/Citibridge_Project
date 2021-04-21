package com.citi.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.citi.service.implementation.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity

public class MyConfig extends WebSecurityConfigurerAdapter{
	
	

	@Bean
	public UserDetailsService getUserDetailsService() {
		//System.out.println("UserDetailsServiceImpl Bean");
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder getpassBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		//System.out.println("authentication provider");
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(getpassBCryptPasswordEncoder());
		
		return daoAuthenticationProvider;
	}
	
	
	//configure method
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//System.out.println("configure 1st");

		auth.authenticationProvider(authenticationProvider());
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("configure 2nd");
		http.authorizeRequests().antMatchers("/user/**").authenticated().and().formLogin().and().csrf().disable();
	}
}
