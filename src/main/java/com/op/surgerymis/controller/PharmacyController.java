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

    @RequestMapping("/pharmacy")
    public List<Pharmacy> getAllPharmacy(){
        return pharmacyService.getAllPharmacy();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/pharmacy")
    public void addPharmacy(@RequestBody Pharmacy pharmacy, @RequestParam String representedBy){
        pharmacy.setCreatedAt(new Date());
        Users user = usersRepository.findById(Integer.parseInt(representedBy)).get();
        pharmacy.setRepresentedBy(user);
        pharmacyService.addPharmacy(pharmacy);
    }
}
