package com.op.surgerymis.service;

import com.op.surgerymis.models.Pharmacy;
import com.op.surgerymis.models.Users;
import com.op.surgerymis.repository.PharmacyRepository;
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
    @Autowired
    public PharmacyRepository pharmacyRepository;

    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        usersRepository.findUsersByIsDeletedOrIsDeleted(false,null).forEach(users::add);
        return users;
    }
    public List<Users> getUserByType(String userType) {
        List<Users> users = new ArrayList<>();
        users = usersRepository.findByUserType(userType);
        return users;
    }
    public Users getUserById(String id) {
        Users users = usersRepository.findById(Integer.parseInt(id)).get();
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
        List<Users> users = new ArrayList<Users>();
        List<String> userTypes = new ArrayList<>();
        userTypes.add("Admin");
        userTypes.add("Receptionist");
        userTypes.add("Pharmacist");
        userTypes.add("Operation manager");
        users = usersRepository.findUsersByEmailAndPasswordAndUserTypeIn(email,password,userTypes);
        if (users.size()>0) {
            if (users.get(0).getUserType().equals("Pharmacist")) {

                List<Pharmacy> pharmacyArr = pharmacyRepository.findPharmacyByRepresentedBy(usersRepository.findById(users.get(0).getId()).get());
                if (pharmacyArr.size() > 0) {
                    users.get(0).setId(pharmacyArr.get(0).getId());
                }else return new ArrayList<Users>();
            }else {
                return users;
            }
        }
        return users;
    }

    public void deleteUser(String id){
        Users user = usersRepository.findById(Integer.parseInt(id)).get();
        user.setDeleted(true);
        user.setDeletedAt(new Date());
        usersRepository.save(user);
    }

}
