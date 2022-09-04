package com.op.surgerymis.controller;

import com.op.surgerymis.helpers.SmsUtils;
import com.op.surgerymis.models.Users;
import com.op.surgerymis.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/api/users")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }
    @RequestMapping("/api/users/find")
    public List<Users> getUsersByType(@RequestParam String userType){
        return userService.getUserByType(userType);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/api/user")
    public void addUser(@RequestBody Users user){
        user.setCreatedAt(new Date());
        user.setPasswordChanged(false);
        userService.addUser(user);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/api/user/{id}")
    public void updateUser(@RequestBody Users user, @PathVariable String id){
        user.setUpdatedAt(new Date());
        userService.updateUser(id,user);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/api/login")
    public List<Users> loginUser(@RequestParam String email, @RequestParam String password){
        System.out.println(email);
        System.out.println(password);
        return userService.login(email,password);
    }
}
