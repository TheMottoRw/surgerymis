package com.op.surgerymis.service;

import com.op.surgerymis.models.Patients;
import com.op.surgerymis.models.Pharmacy;
import com.op.surgerymis.models.Users;
import com.op.surgerymis.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PharmacyService {

    @Autowired
    public PharmacyRepository pharmacyRepository;

    public List<Pharmacy> getAllPharmacy() {
        List<Pharmacy> pharmacy = new ArrayList<>();
        pharmacyRepository.findPharmacyByIsDeletedOrIsDeleted(false,null).forEach(pharmacy::add);
        return pharmacy;
    }
    public void addPharmacy(Pharmacy pharmacy){
        if(pharmacyRepository.findPharmacyByRepresentedBy(pharmacy.getRepresentedBy()).size()==0) {
            pharmacyRepository.save(pharmacy);
        }else{
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Representer already has a pharmacy he represent");
        }
    }
    public void updatePharmacy(String id, Pharmacy phar){
        Pharmacy pharmacy = pharmacyRepository.findById(Integer.parseInt(id)).get();
        pharmacy.setUpdatedAt(new Date());
        pharmacy.setPharmacyName(phar.getPharmacyName());
        pharmacy.setRepresentedBy(phar.getRepresentedBy());
        pharmacyRepository.save(pharmacy);
    }
    public void deletePharmacy(String id){
        Pharmacy pharmacy = pharmacyRepository.findById(Integer.parseInt(id)).get();
        pharmacy.setDeleted(true);
        pharmacy.setDeletedAt(new Date());
        pharmacyRepository.save(pharmacy);
    }
}
