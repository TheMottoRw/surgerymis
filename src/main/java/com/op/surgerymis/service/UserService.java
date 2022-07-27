package com.op.surgerymis.service;

import com.op.surgerymis.models.Users;
import com.op.surgerymis.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    public UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }
    public void addUser(Users user){
        user.setCreatedAt(new Date());
        usersRepository.save(user);
    }
    public void updateUser(String id, Users usr){
        Users user = usersRepository.findById(Integer.parseInt(id)).get();
        user.setUpdatedAt(new Date());
        user.setName(usr.getName());
        user.setPhone(usr.getPhone());
        user.setEmail(usr.getEmail());
        user.setUserType(usr.getUserType());
        usersRepository.save(user);
    }

}
