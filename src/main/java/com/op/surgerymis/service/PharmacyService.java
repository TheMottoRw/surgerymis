package com.op.surgerymis.service;

import com.op.surgerymis.models.Pharmacy;
import com.op.surgerymis.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacyService {

    @Autowired
    public PharmacyRepository pharmacyRepository;

    public List<Pharmacy> getAllPharmacy() {
        List<Pharmacy> pharmacy = new ArrayList<>();
        pharmacyRepository.findAll().forEach(pharmacy::add);
        return pharmacy;
    }
    public void addPharmacy(Pharmacy pharmacy){
        pharmacyRepository.save(pharmacy);
    }
    public void updatePharmacy(String id, Pharmacy pharmacy){
        pharmacyRepository.findById(Integer.parseInt(id));
    }
}
