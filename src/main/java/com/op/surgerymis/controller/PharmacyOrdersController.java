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
    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/api/allorders")
    public List<PharmacyOrders> getAllPharmacy(){
        return ordersService.getAllOrders();
    }
    @RequestMapping("/api/order/{id}")
    public PharmacyOrders getOrderById(String id){
        return ordersService.getOrderById(id);
    }
    @RequestMapping("/api/orders")
    public List<PharmacyOrders> getOrdersByPharmacy(@RequestParam String pharmacy){
        Pharmacy pharmacy1 = pharmacyRepository.findById(Integer.parseInt(pharmacy)).get();
        return ordersService.getOrdersByPharmacy(pharmacy1);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/api/order")
    public void addPharmacy(@RequestBody PharmacyOrders orders, @RequestParam String patient,@RequestParam String pharmacy,@RequestParam String nurse){
        orders.setCreatedAt(new Date());
        Patients patients = patientsRepository.findById(Integer.parseInt(patient)).get();
        Pharmacy pharmacy0 = pharmacyRepository.findById(Integer.parseInt(pharmacy)).get();
        Users nurses = usersRepository.findById(Integer.parseInt(nurse)).get();
        orders.setPatient(patients);
        orders.setPharmacy(pharmacy0);
        orders.setNurse(nurses);
        ordersService.addOrder(orders);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/api/order/{id}")
    public void addPharmacy(@PathVariable String id,@RequestBody PharmacyOrders orders, @RequestParam String patient,@RequestParam String pharmacy,@RequestParam String nurse){
        orders.setUpdatedAt(new Date());
        Patients patients = patientsRepository.findById(Integer.parseInt(patient)).get();
        Pharmacy pharmacy0 = pharmacyRepository.findById(Integer.parseInt(pharmacy)).get();
        Users nurses = usersRepository.findById(Integer.parseInt(nurse)).get();
        orders.setPatient(patients);
        orders.setPharmacy(pharmacy0);
        orders.setNurse(nurses);
        ordersService.updatePharmacy(id,orders);
    }
}
