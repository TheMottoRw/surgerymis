package com.op.surgerymis.repository;

import com.op.surgerymis.dto.OperationStatDTO;
import com.op.surgerymis.dto.TransferStatDTO;
import com.op.surgerymis.models.Operations;
import com.op.surgerymis.models.Patients;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OperationsRepository  extends CrudRepository<Operations,Integer> {
    List<Operations> findOperationsByPatient(Patients id);

    @Query("SELECT new com.op.surgerymis.dto.TransferStatDTO(transfer,count(id)) FROM Operations group by transfer")
    List<TransferStatDTO> findOperationGroupByTransfer();

    @Query("SELECT new com.op.surgerymis.dto.OperationStatDTO(createdAt ,count(id))FROM Operations group by substring(createdAt,7)")
    List<OperationStatDTO> findOperationGroupByMonth();
}
