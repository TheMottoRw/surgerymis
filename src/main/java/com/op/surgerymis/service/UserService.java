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
    public List<Users> getUserByType(String userType) {
        List<Users> users = new ArrayList<>();
        users = usersRepository.findByUserType(userType);
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
    public List<Users> login(String email,String password){
        List<String> userTypes = new ArrayList<>();
        userTypes.add("Admin");
        userTypes.add("Receptionist");
        userTypes.add("Pharmacist");
        userTypes.add("Operation manager");
        return usersRepository.findUsersByEmailAndPasswordAndUserTypeIn(email,password,userTypes);
    }

}
