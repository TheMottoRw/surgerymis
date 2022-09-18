package com.op.surgerymis.service;

import com.op.surgerymis.models.Pharmacy;
import com.op.surgerymis.models.PharmacyOrders;
import com.op.surgerymis.repository.PharmacyOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PharmacyOrdersService {

    @Autowired
    public PharmacyOrdersRepository pharmacyOrdersRepository;

    public List<PharmacyOrders> getAllOrders() {
        List<PharmacyOrders> orders = new ArrayList<>();
        pharmacyOrdersRepository.findAll().forEach(orders::add);
        return orders;
    }
    public List<PharmacyOrders> getOrdersByPharmacy(Pharmacy pharmacy) {
        List<PharmacyOrders> orders = new ArrayList<>();
        pharmacyOrdersRepository.getPharmacyOrdersByPharmacy(pharmacy).forEach(orders::add);
        return orders;
    }
    public PharmacyOrders getOrderById(String id) {
        PharmacyOrders orders =  pharmacyOrdersRepository.findById(Integer.parseInt(id)).get();
        return orders;
    }
    public void addOrder(PharmacyOrders orders){
        pharmacyOrdersRepository.save(orders);
    }
    public void updatePharmacy(String id, PharmacyOrders orders){
        PharmacyOrders pharmacy = pharmacyOrdersRepository.findById(Integer.parseInt(id)).get();
        pharmacy.setUpdatedAt(new Date());
        pharmacy.setPharmacy(orders.getPharmacy());
        pharmacy.setNurse(orders.getNurse());
        pharmacy.setPatient(orders.getPatient());
        pharmacy.setKit(orders.getKit());
        pharmacy.setDelivery(orders.getDelivery());
        pharmacyOrdersRepository.save(pharmacy);
    }
}
