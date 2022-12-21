package com.example.SpringBoot.service;


import com.example.SpringBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll ();
    User getById(Long id);
    void save(User user);
    void deleteById(Long id);
}
