package com.op.surgerymis.service;

import com.op.surgerymis.models.Operations;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.repository.OperationsRepository;
import com.op.surgerymis.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperationsService {

    @Autowired
    public OperationsRepository operationsRepository;
    @Autowired
    public PatientsRepository patientsRepository;

    public List<Operations> getAllOperations() {
        List<Operations> operations = new ArrayList<>();
        operationsRepository.findAll().forEach(operations::add);
        return operations;
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
        operationsRepository.findById(Integer.parseInt(id));
    }
}
