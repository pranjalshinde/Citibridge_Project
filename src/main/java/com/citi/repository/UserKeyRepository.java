package com.citi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.domain.UserKey;



public interface UserKeyRepository extends JpaRepository<UserKey, String>{
	@Query("Select t from UserKey t where t.id = :id")
	public UserKey getUserById(@Param("id") String id);
}
