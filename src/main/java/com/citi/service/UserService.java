package com.citi.service;

import com.citi.domain.User;

public interface UserService {
//    public Boolean savePerson(User p) throws Exception;
    public User validateUser(String userName, String password);
}
