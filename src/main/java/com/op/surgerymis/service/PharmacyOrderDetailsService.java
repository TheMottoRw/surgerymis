package com.op.surgerymis.service;

import com.op.surgerymis.models.PharmacyOrderDetails;
import com.op.surgerymis.repository.PharmacyOrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacyOrderDetailsService {

    @Autowired
    public PharmacyOrderDetailsRepository pharmacyOrderDetailsRepository;

    public List<PharmacyOrderDetails> getAllPharmacyOrderDetails() {
        List<PharmacyOrderDetails> pharmacyOrderDetails = new ArrayList<>();
        pharmacyOrderDetailsRepository.findAll().forEach(pharmacyOrderDetails::add);
        return pharmacyOrderDetails;
    }
    public void addPharmacyOrderDetails(PharmacyOrderDetails pharmacyOrderDetails){
        pharmacyOrderDetailsRepository.save(pharmacyOrderDetails);
    }
    public void updatePharmacyOrderDetails(String id, PharmacyOrderDetails pharmacyOrderDetails){
        pharmacyOrderDetailsRepository.findById(Integer.parseInt(id));
    }
}
