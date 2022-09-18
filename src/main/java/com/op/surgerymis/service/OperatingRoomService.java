package com.op.surgerymis.service;

import com.op.surgerymis.models.OperatingRoom;
import com.op.surgerymis.models.Operations;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.models.Pharmacy;
import com.op.surgerymis.repository.OperatingRoomRepository;
import com.op.surgerymis.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OperatingRoomService {

    @Autowired
    public OperatingRoomRepository opRoomRepository;

    public List<OperatingRoom> getAllOperatingRoom() {
        List<OperatingRoom> oproom = new ArrayList<>();
        opRoomRepository.findAll().forEach(oproom::add);
        return oproom;
    }
    public void addOperatingRoom(OperatingRoom anesthesia){
        opRoomRepository.save(anesthesia);
    }
    public void updateOperatingRoom(String id, OperatingRoom oproom){
        OperatingRoom operatingRoom = opRoomRepository.findById(Integer.parseInt(id)).get();
        operatingRoom.setUpdatedAt(new Date());
        operatingRoom.setPatient(oproom.getPatient());
        operatingRoom.setOperation(oproom.getOperation());
        operatingRoom.setSurgeon(oproom.getSurgeon());
        operatingRoom.setNurse(oproom.getNurse());
        operatingRoom.setIntraOpDiagnosis(oproom.getIntraOpDiagnosis());
        operatingRoom.setOpProcedure(oproom.getOpProcedure());
        operatingRoom.setEmergencyOrEntrance(oproom.getEmergencyOrEntrance());
        operatingRoom.setDressing(oproom.getDressing());
        operatingRoom.setOut_(oproom.getOut_());
        operatingRoom.setObservation(oproom.getObservation());
        opRoomRepository.save(operatingRoom);
    }
    public OperatingRoom getOperatinRoomById(String id){
        return opRoomRepository.findById(Integer.parseInt(id)).get();
    }
}
