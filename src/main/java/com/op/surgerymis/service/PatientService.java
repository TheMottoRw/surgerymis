package com.op.surgerymis.service;

import com.op.surgerymis.helpers.SmsUtils;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.models.Users;
import com.op.surgerymis.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    public PatientsRepository patientsRepository;

    public List<Patients> getAllPatients() {
        List<Patients> patients = new ArrayList<>();
        patientsRepository.findPatientsByIsDeletedOrIsDeleted(false,null).forEach(patients::add);
        return patients;
    }
    public Patients getPatientById(String id) {
        Patients patients = null;
        patients = patientsRepository.findById(Integer.parseInt(id)).get();
        return patients;
    }
    public void addPatient(Patients patient){
        List<Patients> lastPatient = new ArrayList<Patients>();
        SmsUtils smsUtils = new SmsUtils();
        String patientId = null;

        patientsRepository.save(patient);
        patientsRepository.findAll().forEach(lastPatient::add);
        //send sms
        try {
            String message = "SURGERY MIS\nHello "+patient.getPatientNames()+",Information recorded successfully.\nYour Patient ID is:"+lastPatient.get(lastPatient.size()-1).getId();
            smsUtils.send(patient.getPhone(),message);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void updatePatient(String id, Patients pat){
        patientsRepository.findById(Integer.parseInt(id));
        Patients patient = patientsRepository.findById(Integer.parseInt(id)).get();
        patient.setUpdatedAt(new Date());
        patient.setPatientNames(pat.getPatientNames());
        patient.setPhone(pat.getPhone());
        patient.setProvince(pat.getProvince());
        patient.setDistrict(pat.getDistrict());
        patientsRepository.save(patient);
    }
    public void deletePatient(String id){
        Patients patient = patientsRepository.findById(Integer.parseInt(id)).get();
        patient.setDeleted(true);
        patient.setDeletedAt(new Date());
        patientsRepository.save(patient);
    }
}
