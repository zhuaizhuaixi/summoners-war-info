package com.zzx.controller;

import com.zzx.model.User;
import com.zzx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Object getAll(@RequestParam("userid") Integer userid) {
        System.out.println(userid);
        return userService.findOne(userid);
    }

    @PostMapping("/getOne")
    public Object getOne(@RequestBody User user){
        System.out.println(user);
        return userService.findOne(user.getUserId());
    }

    @PostMapping("/getAll")
    public Object getAll(User user){
        System.out.println(user);
        return userService.findAllUser();
    }
}