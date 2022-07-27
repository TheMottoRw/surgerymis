package com.op.surgerymis.controller;

import com.op.surgerymis.models.Anesthesia;
import com.op.surgerymis.models.Operations;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.models.Users;
import com.op.surgerymis.repository.OperationsRepository;
import com.op.surgerymis.repository.PatientsRepository;
import com.op.surgerymis.repository.UsersRepository;
import com.op.surgerymis.service.AnesthesiaService;
import com.op.surgerymis.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class AnesthesiaController {
    @Autowired
    AnesthesiaService anesthesiaService;
    @Autowired
    PatientsRepository patientsRepository;
    @Autowired
    OperationsRepository operationsRepository;
    @Autowired
    UsersRepository usersRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/anesthesia")
    public List<Anesthesia> getAllAnesthesia() {
        return anesthesiaService.getAllAnesthesia();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/anesthesia")
    public void addAnesthesia(@RequestBody Anesthesia anesthesia, @RequestParam String patient, @RequestParam String operation, @RequestParam String anesthesiologist, @RequestParam String anesthetist) {
        anesthesia.setCreatedAt(new Date());
        Patients patients = patientsRepository.findById(Integer.parseInt(patient)).get();
        Operations operations = operationsRepository.findById(Integer.parseInt(operation)).get();
        Users anesthesiologist0 = usersRepository.findById(Integer.parseInt(anesthesiologist)).get();
        Users anesthetist0 = usersRepository.findById(Integer.parseInt(anesthetist)).get();
        anesthesia.setPatient(patients);
        anesthesia.setOperation(operations);
        anesthesia.setAnesthetist(anesthetist0);
        anesthesia.setAnesthesiologist(anesthesiologist0);
        anesthesiaService.addAnesthesia(anesthesia);
    }
}
