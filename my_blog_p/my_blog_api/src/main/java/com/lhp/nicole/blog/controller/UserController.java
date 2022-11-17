package com.lhp.nicole.blog.controller;

import com.lhp.nicole.blog.service.UserService;
import com.lhp.nicole.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /* /users/currentUser */
    @PostMapping("/currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token){
        return userService.findUserByToken(token);
    }
}
