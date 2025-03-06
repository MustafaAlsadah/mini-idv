package com.miniidv.miniidv.controller;

import com.miniidv.miniidv.service.UserService;
import com.miniidv.miniidv.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
       return userService.getUsers();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
