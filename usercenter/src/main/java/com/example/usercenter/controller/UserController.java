package com.example.usercenter.controller;

import com.common.domain.UserCenter;
import com.example.usercenter.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final IUserService userService;

    @GetMapping("/getUserById")
    public UserCenter resultUserById(@RequestParam("userId") Integer userId){
        return userService.findById(userId);
    }
}
