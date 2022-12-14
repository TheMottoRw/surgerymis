package com.op.surgerymis.controller;

import com.op.surgerymis.models.Operations;
import com.op.surgerymis.models.Pacu;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.repository.OperationsRepository;
import com.op.surgerymis.repository.PatientsRepository;
import com.op.surgerymis.service.PacuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PacuController {
    @Autowired
    PacuService pacuService;
    @Autowired
    PatientsRepository patientsRepository;
    @Autowired
    OperationsRepository operationsRepository;

    @RequestMapping(method = RequestMethod.GET,value = "/api/pacu")
    public List<Pacu> getAllPacu(){
        return pacuService.getAllPacu();
    }
    @RequestMapping(method = RequestMethod.GET,value = "/api/pacu/{id}")
    public Pacu getPacuById(@PathVariable  String id){
        return pacuService.getPacuById(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/api/pacu")
    public void addPacu(@RequestBody Pacu pacu, @RequestParam String patient,@RequestParam String operation){
        System.out.println(pacu.getDestination());
        Patients patients = patientsRepository.findById(Integer.parseInt(patient)).get();
        Operations operations = operationsRepository.findById(Integer.parseInt(operation)).get();
        pacu.setPatient(patients);
        pacu.setOperation(operations);
        pacu.setCreatedAt(new Date());
        pacuService.addPacu(pacu);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/api/pacu/{id}")
    public void addPacu(@PathVariable String id,@RequestBody Pacu pacu, @RequestParam String patient,@RequestParam String operation){
        System.out.println(pacu.getDestination());
        Patients patients = patientsRepository.findById(Integer.parseInt(patient)).get();
        Operations operations = operationsRepository.findById(Integer.parseInt(operation)).get();
        pacu.setPatient(patients);
        pacu.setOperation(operations);
        pacu.setCreatedAt(new Date());
        pacuService.updatePacu(id,pacu);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/api/pacu/{id}")
    public void deletePacu(@PathVariable String id){
        pacuService.deletePacu(id);
    }
}
