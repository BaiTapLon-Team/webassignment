package com.btl.web.service;

import com.btl.web.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User getUserFormUsernameAndPassword(String username, String password);

    public List<User> findByEmailAndPassword( String email, String password);
}
