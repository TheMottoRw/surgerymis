package com.op.surgerymis.service;

import com.op.surgerymis.models.Pacu;
import com.op.surgerymis.repository.PacuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        pacuRepository.save(pacu);
    }
    public void updatePacu(String id, Pacu pacu){
        pacuRepository.findById(Integer.parseInt(id));
    }
}
