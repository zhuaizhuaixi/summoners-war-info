package com.zzx.controller;

import com.zzx.model.User;
import com.zzx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zzx
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private UserService userService;

    @Autowired
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Object getAll(@RequestParam("userId") Integer userId) {
        System.out.println(userId);
        return userService.findOne(userId);
    }

    @PostMapping("/getOne")
    public Object getOne(@RequestBody User user) {
        return userService.findOne(user.getUserId());
    }

    @PostMapping("/addOne")
    public Object addOne(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/getAll")
    public Object getAll() {
        return userService.findAllUser();
    }

    @GetMapping("/paramTest/{param}")
    public Object paramTest(@PathVariable String param) {
        return param;
    }
}