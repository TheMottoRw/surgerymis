package com.op.surgerymis.controller;

import com.op.surgerymis.helpers.SmsUtils;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.models.Users;
import com.op.surgerymis.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @RequestMapping("/api/patients")
    public List<Patients> getAllPatients(){
        return patientService.getAllPatients();
    }
    @RequestMapping(method=RequestMethod.GET,value = "/api/patient/{id}")
    public Patients getPatientById(@PathVariable String id){
        return patientService.getPatientById(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/api/patient")
    public void addPatient(@RequestBody Patients patient){
        System.out.println(patient.getPatientNames());
        patient.setCreatedAt(new Date());
        patientService.addPatient(patient);

    }

    @RequestMapping(method = RequestMethod.PUT,value = "/api/patient/{id}")
    public void updatePatient(@RequestBody Patients patient, @PathVariable String id){
        patient.setUpdatedAt(new Date());
        patientService.updatePatient(id,patient);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/api/patient/{id}")
    public void deletePatient(@PathVariable String id){
        patientService.deletePatient(id);
    }
}
