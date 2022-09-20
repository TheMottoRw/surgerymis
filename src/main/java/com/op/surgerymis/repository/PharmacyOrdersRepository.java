package com.op.surgerymis.repository;

import com.op.surgerymis.models.Pharmacy;
import com.op.surgerymis.models.PharmacyOrders;
import com.op.surgerymis.models.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PharmacyOrdersRepository extends CrudRepository<PharmacyOrders,Integer> {
    List<PharmacyOrders> getPharmacyOrdersByPharmacyAndIsDeletedOrIsDeletedAndPatientIsDeletedOrPatientIsDeletedAndNurseIsDeletedOrNurseIsDeleted(Pharmacy pharmacy,Boolean isDeleted,String nullval,Boolean patisDeleted,String patnullval,Boolean nurseisDeleted,String nursenullval);
    List<PharmacyOrders> getPharmacyOrdersByIsDeletedOrIsDeleted(Boolean isDeleted,String nullval);
    List<PharmacyOrders> findPharmacyOrdersByIsDeletedOrIsDeletedAndPatientIsDeletedOrPatientIsDeleted(Boolean isDeleted, String nullval,Boolean pharIsDeleted, String pharnullval);

}
