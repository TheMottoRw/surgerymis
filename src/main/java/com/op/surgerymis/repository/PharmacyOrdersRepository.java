package com.op.surgerymis.repository;

import com.op.surgerymis.models.Pharmacy;
import com.op.surgerymis.models.PharmacyOrders;
import com.op.surgerymis.models.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PharmacyOrdersRepository extends CrudRepository<PharmacyOrders,Integer> {
    List<PharmacyOrders> getPharmacyOrdersByPharmacy(Pharmacy pharmacy);
}
