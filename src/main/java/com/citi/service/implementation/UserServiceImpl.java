package com.citi.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.domain.User;
//import com.citi.repository.PersonRepository;
import com.citi.repository.UserRepository;
import com.citi.service.UserService;
import com.querydsl.core.types.Predicate;

@Service("personService")
public class UserServiceImpl implements UserService {
    Predicate predicate;
    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public Boolean savePerson(User p) throws Exception {
//    	userRepository.save(p);
//        return true;
//    }

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User validateUser(String userName,String password){
		// TODO Auto-generated method stub
		
		User user = userRepository.findByUserName(userName);
		if(user != null) {
			user = userRepository.checkPassword(password);
			if(user != null) {
				return user;
			}
		}
		return null;
	}

}