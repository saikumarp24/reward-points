package com.assignment.rewardsprogram.repository;

import com.assignment.rewardsprogram.model.User;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Repository
public class UserRepository {
    private final Set<User> userList = new TreeSet<>();

    public Set<User> getUserList () {
        return userList;
    }

    public User findById (Long userId) {
        return userList.stream().filter(user -> Objects.equals(user.getUserId(), userId)).findFirst().orElse(null);
    }

    public void addUser (User user) {
        userList.add(user);
    }

    public void deleteUser (User user) {
        userList.remove(user);
    }

    public void updateUser (User user) {
        userList.stream().filter(user1 -> Objects.equals(user1.getUserId(), user.getUserId()))
            .forEach(user1 -> user1.setUserName(user.getUserName()));
    }
}
