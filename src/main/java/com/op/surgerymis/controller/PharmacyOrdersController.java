package com.op.surgerymis.controller;

import com.op.surgerymis.models.Patients;
import com.op.surgerymis.models.Pharmacy;
import com.op.surgerymis.models.PharmacyOrders;
import com.op.surgerymis.models.Users;
import com.op.surgerymis.repository.PatientsRepository;
import com.op.surgerymis.repository.PharmacyRepository;
import com.op.surgerymis.repository.UsersRepository;
import com.op.surgerymis.service.PharmacyOrdersService;
import com.op.surgerymis.service.PharmacyService;
import com.op.surgerymis.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PharmacyOrdersController {
    @Autowired
    PharmacyOrdersService ordersService;
    @Autowired
    PatientsRepository patientsRepository;
    @Autowired
    PharmacyRepository pharmacyRepository;

    @RequestMapping("/api/orders")
    public List<PharmacyOrders> getAllPharmacy(){
        return ordersService.getAllOrders();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/api/order")
    public void addPharmacy(@RequestBody PharmacyOrders orders, @RequestParam String patient,@RequestParam String pharmacy){
        orders.setCreatedAt(new Date());
        Patients patients = patientsRepository.findById(Integer.parseInt(patient)).get();
        Pharmacy pharmacy0 = pharmacyRepository.findById(Integer.parseInt(pharmacy)).get();
        orders.setPatient(patients);
        orders.setPharmacy(pharmacy0);
        ordersService.addOrder(orders);
    }
}
