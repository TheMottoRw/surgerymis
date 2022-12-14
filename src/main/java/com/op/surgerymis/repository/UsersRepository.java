package com.op.surgerymis.repository;

import com.op.surgerymis.models.Users;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository <Users,Integer> {

    List<Users> findByUserType(String userType);
    List<Users> findUsersByEmailAndPasswordAndUserTypeIn(String email,String password,List<String> userTypes);
    List<Users> findUsersByIsDeletedOrIsDeleted(Boolean isDeleted,String nullval);
}
