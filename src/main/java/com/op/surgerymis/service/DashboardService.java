package com.op.surgerymis.service;

import com.op.surgerymis.dto.DashboardDTO;
import com.op.surgerymis.dto.UsersStatsDTO;
import com.op.surgerymis.models.Operations;
import com.op.surgerymis.repository.OperationsRepository;
import com.op.surgerymis.repository.PatientsRepository;
import com.op.surgerymis.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    public UsersRepository usersRepository;
    @Autowired
    OperationsRepository operationsRepository;
    @Autowired
    PatientsRepository patientsRepository;

    UsersStatsDTO usersStatsDTO = new UsersStatsDTO();

    DashboardDTO dashboardDTO = new DashboardDTO();


    public DashboardDTO getDashboardStats(){

        int surgeonLen= usersRepository.findByUserType("Surgeon").size();
        int nurseLen= usersRepository.findByUserType("Nurse").size();
        int anesthesiologistLen= usersRepository.findByUserType("Anesthesiologist").size();
        int anesthetistLen = usersRepository.findByUserType("Anesthetist").size();
        int patientsLen= Integer.parseInt(String.valueOf(patientsRepository.count()));
        int operationsLen= Integer.parseInt(String.valueOf(operationsRepository.count()));

        System.out.println(surgeonLen);
        usersStatsDTO.setSurgeons(surgeonLen);
        usersStatsDTO.setNurses(nurseLen);
        usersStatsDTO.setAnesthesiologists(anesthesiologistLen);
        usersStatsDTO.setAnesthetists(anesthetistLen);
        usersStatsDTO.setPatients(patientsLen);
        usersStatsDTO.setOperations(operationsLen);

        dashboardDTO.setTransfers(operationsRepository.findOperationGroupByTransfer());
        dashboardDTO.setUsers(usersStatsDTO);
        dashboardDTO.setOperations(operationsRepository.findOperationGroupByMonth());

        return dashboardDTO;
    }

}
