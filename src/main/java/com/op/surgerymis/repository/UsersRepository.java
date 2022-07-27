package com.op.surgerymis.repository;

import com.op.surgerymis.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository <Users,Integer> {
}
