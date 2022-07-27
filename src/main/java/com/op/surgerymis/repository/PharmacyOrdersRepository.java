package com.op.surgerymis.repository;

import com.op.surgerymis.models.PharmacyOrders;
import com.op.surgerymis.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface PharmacyOrdersRepository extends CrudRepository<PharmacyOrders,Integer> {
}
