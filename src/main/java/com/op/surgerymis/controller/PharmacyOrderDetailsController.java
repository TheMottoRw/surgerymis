package com.op.surgerymis.controller;

import com.op.surgerymis.models.Operations;
import com.op.surgerymis.models.PharmacyOrderDetails;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.models.PharmacyOrders;
import com.op.surgerymis.repository.OperationsRepository;
import com.op.surgerymis.repository.PatientsRepository;
import com.op.surgerymis.repository.PharmacyOrdersRepository;
import com.op.surgerymis.service.PharmacyOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PharmacyOrderDetailsController {
    @Autowired
    PharmacyOrderDetailsService orderDetailsService;
    @Autowired
    PharmacyOrdersRepository pharmacyOrdersRepository;

    @RequestMapping(method = RequestMethod.GET,value = "/details")
    public List<PharmacyOrderDetails> getAllPharmacyOrderDetails(){
        return orderDetailsService.getAllPharmacyOrderDetails();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/detail")
    public void addPharmacyOrderDetails(@RequestBody PharmacyOrderDetails details, @RequestParam String order){
        System.out.println(details.getKit());
        PharmacyOrders orders = pharmacyOrdersRepository.findById(Integer.parseInt(order)).get();
        details.setPharmacyOrder(orders);
        details.setCreatedAt(new Date());
        orderDetailsService.addPharmacyOrderDetails(details);
    }
}
