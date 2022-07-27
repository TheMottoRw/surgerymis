package com.op.surgerymis.service;

import com.op.surgerymis.models.OperatingRoom;
import com.op.surgerymis.models.Patients;
import com.op.surgerymis.repository.OperatingRoomRepository;
import com.op.surgerymis.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        opRoomRepository.findById(Integer.parseInt(id));
    }
}
