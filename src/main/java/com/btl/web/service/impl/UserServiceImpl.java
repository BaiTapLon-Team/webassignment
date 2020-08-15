package com.btl.web.service.impl;


import com.btl.web.entity.User;
import com.btl.web.repository.UserRepository;
import com.btl.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User getUserFormUsernameAndPassword ( String username, String password ) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<User> findByEmailAndPassword ( String email, String password ) {
       return  userRepository.findByEmailAndPassword(email, password);
    }
    //Loi day
}
