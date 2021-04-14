package com.citi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.domain.User;

public interface UserRepository extends JpaRepository<User, String>{

	@Query("Select u from User u where u.userName = :userName")
	public User getUserByUsername(@Param("userName") String userName);
}
