package com.op.surgerymis.repository;

import com.op.surgerymis.dto.OperationStatDTO;
import com.op.surgerymis.dto.TransferStatDTO;
import com.op.surgerymis.helpers.Utils;
import com.op.surgerymis.models.Anesthesia;
import com.op.surgerymis.models.Operations;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.models.Pharmacy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OperationsRepository extends CrudRepository<Operations, Integer> {
    List<Operations> findOperationsByPatient(Patients id);

    @Query("SELECT new com.op.surgerymis.dto.TransferStatDTO(districtHospital,count(id)) FROM Operations group by districtHospital")
    List<TransferStatDTO> findOperationGroupByTransfer();

    @Query("SELECT new com.op.surgerymis.dto.OperationStatDTO(createdAt ,'1') FROM Operations")
    List<OperationStatDTO> findOperationGroupByMonth();

    List<Operations> findOperationsByCreatedAtIsBetween(String start,String end);
    List<Operations> findOperationsByIsDeletedOrIsDeleted(Boolean isDeleted, String nullval);
    List<Operations> findOperationsByIsDeletedOrIsDeletedAndPatientIsDeletedOrPatientIsDeleted(Boolean isDeleted, String nullval, Boolean isPatientDeleted, String opnullval);


}
