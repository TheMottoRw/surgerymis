package com.op.surgerymis.repository;

import com.op.surgerymis.models.Anesthesia;
import com.op.surgerymis.models.Pacu;
import com.op.surgerymis.models.Pharmacy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PacuRepository  extends CrudRepository<Pacu,Integer> {
    List<Pacu> findPacuByIsDeletedOrIsDeleted(Boolean isDeleted, String nullval);
    List<Pacu> findPacuByIsDeletedOrIsDeletedAndOperationIsDeletedOrOperationIsDeleted(Boolean isDeleted, String nullval, Boolean isPatientDeleted, String annullval);

}
