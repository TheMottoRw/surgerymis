package com.op.surgerymis.service;

import com.op.surgerymis.models.Anesthesia;
import com.op.surgerymis.models.Pharmacy;
import com.op.surgerymis.models.Users;
import com.op.surgerymis.repository.AnesthesiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AnesthesiaService {

    @Autowired
    public AnesthesiaRepository anesthesiaRepository;

    public List<Anesthesia> getAllAnesthesia() {
        List<Anesthesia> anesthesia = new ArrayList<>();
        anesthesiaRepository.findAnesthesiaByIsDeletedOrIsDeleted(false,null).forEach(anesthesia::add);
        return anesthesia;
    }
    public Anesthesia getAnesthesiaById(String id) {
        return anesthesiaRepository.findById(Integer.parseInt(id)).get();
    }
    public void addAnesthesia(Anesthesia anesthesia){
        anesthesiaRepository.save(anesthesia);
    }
    public void updateAnesthesia(String id, Anesthesia anesth){
        Anesthesia anesthesia = anesthesiaRepository.findById(Integer.parseInt(id)).get();
        anesthesia.setUpdatedAt(new Date());
        anesthesia.setPatient(anesth.getPatient());
        anesthesia.setOperation(anesth.getOperation());
        anesthesia.setAnesthetist(anesth.getAnesthetist());
        anesthesia.setAnesthesiaType(anesth.getAnesthesiaType());
        anesthesia.setInduction(anesth.getInduction());
        anesthesia.setOperativeDuration(anesth.getOperativeDuration());
        anesthesia.setAnesthesiaDuration(anesth.getAnesthesiaDuration());
        anesthesiaRepository.save(anesthesia);
    }
    public void deleteAnesthesia(String id){
        Anesthesia anesthesia = anesthesiaRepository.findById(Integer.parseInt(id)).get();
        anesthesia.setDeleted(true);
        anesthesia.setDeletedAt(new Date());
        anesthesiaRepository.save(anesthesia);
    }
}
