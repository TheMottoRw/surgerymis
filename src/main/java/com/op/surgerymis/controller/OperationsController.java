package com.op.surgerymis.controller;

import com.op.surgerymis.dto.DashboardDTO;
import com.op.surgerymis.helpers.Utils;
import com.op.surgerymis.models.Operations;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.models.Users;
import com.op.surgerymis.repository.PatientsRepository;
import com.op.surgerymis.service.DashboardService;
import com.op.surgerymis.service.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class OperationsController {
    @Autowired
    OperationsService operationsService;
    @Autowired
    DashboardService dashboardService;
    @Autowired
    PatientsRepository patientsRepository;

    @RequestMapping("/api/operations")
    public List<Operations> getAllOperations() {
        return operationsService.getAllOperations();
    }
    @RequestMapping("/api/operation/{id}")
    public Operations getOperationById(@PathVariable String id) {
        return operationsService.getOperationById(id);
    }

    @RequestMapping("/api/operations/bypatient")
    public List<Operations> getOperationsByPatient(@RequestParam String patient) {
        return operationsService.getOperationsByPatient(patient);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/operation")
    public void addOperations(@RequestBody Operations operations, @RequestParam String patient) {
        Patients patients = patientsRepository.findById(Integer.parseInt(patient)).get();
        operations.setPatient(patients);
        operations.setCreatedAt(Utils.getCurrentDate());
        operationsService.addOperation(operations);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/api/operation/{id}")
    public void updateOperation(@PathVariable String id,@RequestBody Operations operations, @RequestParam String patient) {
        Patients patients = patientsRepository.findById(Integer.parseInt(patient)).get();
        operations.setPatient(patients);
        operations.setCreatedAt(Utils.getCurrentDate());
        operationsService.updateOperation(id,operations);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/opfilter")
    public List<Operations> filterOperationReport(@RequestParam String start, @RequestParam String end) {
        return operationsService.filterOperationByDate(start, end);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/api/operation/{id}")
    public void deleteOrder(@PathVariable String id){
        operationsService.deleteOperation(id);
    }

    @RequestMapping("/api/dashboard")
    public DashboardDTO getDashboardStat() {
        return dashboardService.getDashboardStats();
    }
}
