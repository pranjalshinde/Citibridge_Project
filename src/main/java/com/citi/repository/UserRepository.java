package com.citi.repository;

import com.citi.domain.User;
//import com.citi.domain.QPerson;
//import com.codejava.domain.User;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;


//public interface PersonRepository extends CrudRepository<Person, Integer>, QuerydslPredicateExecutor<Person>, QuerydslBinderCustomizer<QPerson> {
//
//    @Override
//    default public void customize(QuerydslBindings bindings, QPerson qPerson) {
//        bindings.bind(String.class)
//                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
//    }
//
////    public  Person save(Person person);
//}

@Repository

public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("Select t from User t where t.Name = ?")
	public User findByUserName(String userName);
	
	@Query("Select t from UserKey where t.Password = ?")
	public User checkPassword(String password);
}