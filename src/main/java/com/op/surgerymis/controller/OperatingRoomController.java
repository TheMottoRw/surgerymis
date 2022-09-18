package com.op.surgerymis.controller;

import com.op.surgerymis.models.OperatingRoom;
import com.op.surgerymis.models.Operations;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.models.Users;
import com.op.surgerymis.repository.OperationsRepository;
import com.op.surgerymis.repository.PatientsRepository;
import com.op.surgerymis.repository.UsersRepository;
import com.op.surgerymis.service.OperatingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class OperatingRoomController {
    @Autowired
    OperatingRoomService operatingRoomService;
    @Autowired
    PatientsRepository patientsRepository;
    @Autowired
    OperationsRepository operationsRepository;
    @Autowired
    UsersRepository usersRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/api/oprooms")
    public List<OperatingRoom> getAllOperatingRooms() {
        return operatingRoomService.getAllOperatingRoom();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/oproom/{id}")
    public OperatingRoom getOperatingRoomById(@PathVariable String id) {
        return operatingRoomService.getOperatinRoomById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/oproom")
    public void addOperatingRoom(@RequestBody OperatingRoom operatingRoom, @RequestParam String patient, @RequestParam String operation, @RequestParam String surgeon, @RequestParam String nurse) {
        System.out.println(operatingRoom.getCleaning());
        Patients patients = patientsRepository.findById(Integer.parseInt(patient)).get();
        Operations operations = operationsRepository.findById(Integer.parseInt(operation)).get();
        Users surgeons = usersRepository.findById(Integer.parseInt(surgeon)).get();
        Users nurses = usersRepository.findById(Integer.parseInt(nurse)).get();
        operatingRoom.setPatient(patients);
        operatingRoom.setOperation(operations);
        operatingRoom.setSurgeon(surgeons);
        operatingRoom.setNurse(nurses);
        operatingRoom.setCreatedAt(new Date());
        operatingRoomService.addOperatingRoom(operatingRoom);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/oproom/{id}")
    public void addOperatingRoom(@PathVariable String id, @RequestBody OperatingRoom operatingRoom, @RequestParam String patient, @RequestParam String operation, @RequestParam String surgeon, @RequestParam String nurse) {
        Patients patients = patientsRepository.findById(Integer.parseInt(patient)).get();
        Operations operations = operationsRepository.findById(Integer.parseInt(operation)).get();
        Users surgeons = usersRepository.findById(Integer.parseInt(surgeon)).get();
        Users nurses = usersRepository.findById(Integer.parseInt(nurse)).get();
        operatingRoom.setPatient(patients);
        operatingRoom.setOperation(operations);
        operatingRoom.setSurgeon(surgeons);
        operatingRoom.setNurse(nurses);
        operatingRoom.setCreatedAt(new Date());
        operatingRoomService.updateOperatingRoom(id, operatingRoom);
    }
}
