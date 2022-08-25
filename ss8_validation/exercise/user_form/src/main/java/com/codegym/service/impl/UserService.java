package com.codegym.service.impl;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return this.iUserRepository.findAll();
    }

    @Override
    public User save(User user) {
        return this.iUserRepository.save(user);
    }
}
