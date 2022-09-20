package com.op.surgerymis.repository;

import com.op.surgerymis.models.Anesthesia;
import com.op.surgerymis.models.OperatingRoom;
import com.op.surgerymis.models.Pharmacy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OperatingRoomRepository extends CrudRepository<OperatingRoom, Integer> {
    List<OperatingRoom> findOperatingRoomByIsDeletedOrIsDeleted(Boolean isDeleted, String nullval);

    List<OperatingRoom> findOperatingRoomByIsDeletedOrIsDeletedOrOperationIsDeletedOrOperationIsDeleted(Boolean isDeleted, String nullval,Boolean oprisDeleted, String oprnullval);

}
