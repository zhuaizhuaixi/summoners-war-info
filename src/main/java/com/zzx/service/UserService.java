package com.zzx.service;

import com.zzx.dao.UserRepository;
import com.zzx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzx
 * Created by zzx on 2018/8/5.
 */
@Service(value = "userService")
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUser() {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        return userRepository.findAll();
    }

    public User findOne(Integer userId) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        return userRepository.findByUserId(userId);
    }
}