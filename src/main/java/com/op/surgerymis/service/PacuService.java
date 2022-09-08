package com.op.surgerymis.service;

import com.op.surgerymis.helpers.SmsUtils;
import com.op.surgerymis.models.Pacu;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.repository.PacuRepository;
import org.hibernate.metamodel.model.convert.internal.JpaAttributeConverterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacuService {

    @Autowired
    public PacuRepository pacuRepository;

    public List<Pacu> getAllPacu() {
        List<Pacu> pacu = new ArrayList<>();
        pacuRepository.findAll().forEach(pacu::add);
        return pacu;
    }
    public void addPacu(Pacu pacu){
        SmsUtils smsUtils = new SmsUtils();
        pacuRepository.save(pacu);
        //send notification
        try {
            Patients patient = pacu.getPatient();
            String message = "SURGERY MIS\nHello "+patient.getPatientNames()+",Operation done, get well soon.";
            smsUtils.send(patient.getPhone(),message);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void updatePacu(String id, Pacu pacu){
        pacuRepository.findById(Integer.parseInt(id));
    }
}
