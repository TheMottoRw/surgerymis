package com.op.surgerymis.repository;

import com.op.surgerymis.models.Operations;
import com.op.surgerymis.models.Patients;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OperationsRepository  extends CrudRepository<Operations,Integer> {
    List<Operations> findOperationsByPatient(Patients id);
}
