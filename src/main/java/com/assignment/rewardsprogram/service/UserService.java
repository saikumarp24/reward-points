package com.assignment.rewardsprogram.service;

import com.assignment.rewardsprogram.model.User;
import com.assignment.rewardsprogram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserByUserId (Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> getUsers () {
        return userRepository.getUserList().stream().toList();
    }
}
