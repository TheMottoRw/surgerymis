package com.op.surgerymis.service;

import com.op.surgerymis.helpers.Utils;
import com.op.surgerymis.models.Operations;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.models.Pharmacy;
import com.op.surgerymis.models.Users;
import com.op.surgerymis.repository.OperationsRepository;
import com.op.surgerymis.repository.PatientsRepository;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OperationsService {

    @Autowired
    public OperationsRepository operationsRepository;
    @Autowired
    public PatientsRepository patientsRepository;

    public List<Operations> getAllOperations() {
        List<Operations> operations = new ArrayList<>();
        operationsRepository.findOperationsByIsDeletedOrIsDeleted(false,null).forEach(operations::add);
        return operations;
    }
    public Operations getOperationById(String id) {
        return operationsRepository.findById(Integer.parseInt(id)).get();
    }
    public List<Operations> getOperationsByPatient(String pat) {
        List<Operations> operations = new ArrayList<>();
        Patients patient = patientsRepository.findById(Integer.parseInt(pat)).get();
        operations = operationsRepository.findOperationsByPatient(patient);
        return operations;
    }
    public void addOperation(Operations operations){
        operationsRepository.save(operations);
    }
    public void updateOperation(String id, Operations operations){
        Operations ops = operationsRepository.findById(Integer.parseInt(id)).get();
        ops.setUpdatedAt(new Date());
        ops.setPatient(operations.getPatient());
        ops.setDistrictHospital(operations.getDistrictHospital());
        ops.setPreOpDiagnostic(operations.getPreOpDiagnostic());
        ops.setPlannedProcedure(operations.getPlannedProcedure());
        ops.setAssurance(operations.getAssurance());
        ops.setAccompanying(operations.getAccompanying());
        ops.setObserved(operations.getObservation());
        operationsRepository.save(ops);
    }
    public List<Operations> filterOperationByDate(String start, String end){
        String dStart = start+" 00:00:00";
        String dEnd = end+" 23:59:59";
        System.out.println(dStart);
        System.out.println(dEnd);
        return operationsRepository.findOperationsByCreatedAtIsBetween(dStart,dEnd);
    }

    public void deleteOperation(String id){
        Operations operations = operationsRepository.findById(Integer.parseInt(id)).get();
        operations.setDeleted(true);
        operations.setDeletedAt(new Date());
        operationsRepository.save(operations);
    }
}
