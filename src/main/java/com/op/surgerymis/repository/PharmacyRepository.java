package com.op.surgerymis.repository;

import com.op.surgerymis.models.Pharmacy;
import com.op.surgerymis.models.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PharmacyRepository extends CrudRepository<Pharmacy,Integer> {
    List<Pharmacy> findPharmacyByRepresentedBy(Users representedBy);
}
