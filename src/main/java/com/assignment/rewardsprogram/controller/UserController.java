package com.assignment.rewardsprogram.controller;

import com.assignment.rewardsprogram.model.User;
import com.assignment.rewardsprogram.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/byUserId")
    public @ResponseBody ResponseEntity<User> getUserByUserId (@RequestParam Long userId) {
        LOGGER.info(String.format("Request: getUserByUserId :: %s", userId));
        User user = userService.getUserByUserId(userId);
        ResponseEntity<User> response = new ResponseEntity<>(user, HttpStatus.OK);
        LOGGER.info(String.format("Response: getUserByUserId :: %s", response));
        return response;
    }

    @GetMapping("/getUsers")
    public @ResponseBody ResponseEntity<List<User>> getUsers () {
        LOGGER.info(String.format("Request: getUsers"));
        List<User> users = userService.getUsers();
        ResponseEntity<List<User>> response = new ResponseEntity<>(users, HttpStatus.OK);
        LOGGER.info(String.format("Response: getUsers :: %s", response));
        return response;
    }
}
