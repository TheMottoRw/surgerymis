package com.op.surgerymis.service;

import com.op.surgerymis.models.Anesthesia;
import com.op.surgerymis.repository.AnesthesiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnesthesiaService {

    @Autowired
    public AnesthesiaRepository anesthesiaRepository;

    public List<Anesthesia> getAllAnesthesia() {
        List<Anesthesia> anesthesia = new ArrayList<>();
        anesthesiaRepository.findAll().forEach(anesthesia::add);
        return anesthesia;
    }
    public void addAnesthesia(Anesthesia anesthesia){
        anesthesiaRepository.save(anesthesia);
    }
    public void updateAnesthesia(String id, Anesthesia anesthesia){
        anesthesiaRepository.findById(Integer.parseInt(id));
    }
}
