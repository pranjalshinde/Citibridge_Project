package com.citi.repository;

import com.citi.domain.User;
import com.citi.domain.UserKey;
//import com.citi.domain.QPerson;
//import com.codejava.domain.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.data.repository.query.Param;



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


@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("Select u from User u where u.Name = :userName")
	public User getUserByUsername(@Param("userName") String userName);
	
	@Query("Select t from UserKey t where t.id = :id")
	public UserKey getUserById(@Param("id") int id);
	
}