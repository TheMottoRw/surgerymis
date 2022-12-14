package com.op.surgerymis.controller;

import com.op.surgerymis.models.Pharmacy;
import com.op.surgerymis.models.Users;
import com.op.surgerymis.repository.UsersRepository;
import com.op.surgerymis.service.PharmacyService;
import com.op.surgerymis.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PharmacyController {
    @Autowired
    PharmacyService pharmacyService;
    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/api/pharmacy")
    public List<Pharmacy> getAllPharmacy() {
        return pharmacyService.getAllPharmacy();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/pharmacy")
    public void addPharmacy(@RequestBody Pharmacy pharmacy, @RequestParam String representedBy) {
        pharmacy.setCreatedAt(new Date());
        Users user = usersRepository.findById(Integer.parseInt(representedBy)).get();
        pharmacy.setRepresentedBy(user);
        pharmacyService.addPharmacy(pharmacy);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/pharmacy/{id}")
    public void updatePharmacy(@PathVariable String id, @RequestBody Pharmacy pharmacy, @RequestParam String representedBy) {
        pharmacy.setCreatedAt(new Date());
        Users user = usersRepository.findById(Integer.parseInt(representedBy)).get();
        pharmacy.setRepresentedBy(user);
        pharmacyService.updatePharmacy(id, pharmacy);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/api/pharmacy/{id}")
    public void deleteOPharmacy(@PathVariable String id){
        pharmacyService.deletePharmacy(id);
    }
}
