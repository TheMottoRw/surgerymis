package com.op.surgerymis.service;

import com.op.surgerymis.models.Patients;
import com.op.surgerymis.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    public PatientsRepository patientsRepository;

    public List<Patients> getAllPatients() {
        List<Patients> patients = new ArrayList<>();
        patientsRepository.findAll().forEach(patients::add);
        return patients;
    }
    public void addPatient(Patients patient){
        patientsRepository.save(patient);
    }
    public void updatePatient(String id, Patients patient){
        patientsRepository.findById(Integer.parseInt(id));
    }
}
