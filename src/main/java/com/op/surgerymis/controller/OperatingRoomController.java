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


    @RequestMapping(method = RequestMethod.GET,value = "/oprooms")
    public List<OperatingRoom> getAllOperatingRooms(){
        return operatingRoomService.getAllOperatingRoom();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/oproom")
    public void addOperatingRoom(@RequestBody OperatingRoom operatingRoom, @RequestParam String patient, @RequestParam String operation, @RequestParam String assistant,@RequestParam String nurse){
        System.out.println(operatingRoom.getCleaning());
        Patients patients = patientsRepository.findById(Integer.parseInt(patient)).get();
        Operations operations = operationsRepository.findById(Integer.parseInt(operation)).get();
        Users assistants = usersRepository.findById(Integer.parseInt(assistant)).get();
        Users nurses = usersRepository.findById(Integer.parseInt(nurse)).get();
        operatingRoom.setPatient(patients);
        operatingRoom.setOperation(operations);
        operatingRoom.setAssistant(assistants);
        operatingRoom.setNurse(nurses);
        operatingRoom.setCreatedAt(new Date());
        operatingRoomService.addOperatingRoom(operatingRoom);
    }
}
