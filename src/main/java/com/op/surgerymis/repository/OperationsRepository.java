package com.op.surgerymis.repository;

import com.op.surgerymis.dto.OperationStatDTO;
import com.op.surgerymis.dto.TransferStatDTO;
import com.op.surgerymis.helpers.Utils;
import com.op.surgerymis.models.Operations;
import com.op.surgerymis.models.Patients;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OperationsRepository extends CrudRepository<Operations, Integer> {
    List<Operations> findOperationsByPatient(Patients id);

    @Query("SELECT new com.op.surgerymis.dto.TransferStatDTO(transfer,count(id)) FROM Operations group by transfer")
    List<TransferStatDTO> findOperationGroupByTransfer();

    @Query("SELECT new com.op.surgerymis.dto.OperationStatDTO(createdAt ,'1') FROM Operations")
    List<OperationStatDTO> findOperationGroupByMonth();

    List<Operations> findOperationsByCreatedAtStartingWith(String year);
}
