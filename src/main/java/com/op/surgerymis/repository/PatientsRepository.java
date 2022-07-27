package com.op.surgerymis.repository;

import com.op.surgerymis.models.Patients;
import org.springframework.data.repository.CrudRepository;

public interface PatientsRepository extends CrudRepository<Patients,Integer> {
}
