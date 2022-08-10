package com.op.surgerymis.controller;

import com.op.surgerymis.models.Operations;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.models.Users;
import com.op.surgerymis.repository.PatientsRepository;
import com.op.surgerymis.service.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class OperationsController {
    @Autowired
    OperationsService operationsService;
    @Autowired
    PatientsRepository patientsRepository;

    @RequestMapping("/api/operations")
    public List<Operations> getAllOperations(){
        return operationsService.getAllOperations();
    }

    @RequestMapping("/api/operations/bypatient")
    public List<Operations> getOperationsByPatient(@RequestParam String patient){
        return operationsService.getOperationsByPatient(patient);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/api/operation")
    public void addOperations(@RequestBody Operations operations, @RequestParam String patient){
        System.out.println(operations.getCaution());
        Patients patients = patientsRepository.findById(Integer.parseInt(patient)).get();
        operations.setPatient(patients);
        operations.setCreatedAt(new Date());
        operationsService.addOperation(operations);
    }
}
