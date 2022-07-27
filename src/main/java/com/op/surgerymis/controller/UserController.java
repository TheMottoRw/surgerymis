package com.op.surgerymis.controller;

import com.op.surgerymis.models.Users;
import com.op.surgerymis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public void addUser(@RequestBody Users user){
        System.out.println(user.getEmail());
        user.setCreatedAt(new Date());
        userService.addUser(user);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/user/{id}")
    public void updateUser(@RequestBody Users user, @PathVariable String id){
        System.out.println(user.getEmail());
        user.setUpdatedAt(new Date());
        userService.updateUser(id,user);
    }
}
