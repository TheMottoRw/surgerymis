package com.op.surgerymis.repository;

import com.op.surgerymis.models.Anesthesia;
import com.op.surgerymis.models.Pharmacy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnesthesiaRepository extends CrudRepository<Anesthesia, Integer> {
    List<Anesthesia> findAnesthesiaByIsDeletedOrIsDeleted(Boolean isDeleted, String nullval);
    List<Anesthesia> findAnesthesiaByIsDeletedOrIsDeletedOrPatientIsDeletedOrPatientIsDeleted(Boolean isDeleted,String nullval,Boolean isPatientDeleted,String annullval);

}
