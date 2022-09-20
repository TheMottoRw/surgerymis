package com.op.surgerymis.repository;

import com.op.surgerymis.models.Patients;
import com.op.surgerymis.models.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientsRepository extends CrudRepository<Patients,Integer> {
    List<Patients> findPatientsByIsDeletedOrIsDeleted(Boolean isDeleted, String nullval);

}
