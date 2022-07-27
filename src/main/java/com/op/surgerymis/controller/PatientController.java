package com.op.surgerymis.controller;

import com.op.surgerymis.models.Patients;
import com.op.surgerymis.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @RequestMapping("/patients")
    public List<Patients> getAllPatients(){
        return patientService.getAllPatients();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/patient")
    public void addPatient(@RequestBody Patients patient){
        System.out.println(patient.getPatientNames());
        patient.setCreatedAt(new Date());
        patientService.addPatient(patient);
    }
}
