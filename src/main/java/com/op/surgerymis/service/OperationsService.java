package com.op.surgerymis.service;

import com.op.surgerymis.models.Operations;
import com.op.surgerymis.repository.OperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperationsService {

    @Autowired
    public OperationsRepository operationsRepository;

    public List<Operations> getAllOperations() {
        List<Operations> operations = new ArrayList<>();
        operationsRepository.findAll().forEach(operations::add);
        return operations;
    }
    public void addOperation(Operations operations){
        operationsRepository.save(operations);
    }
    public void updateOperation(String id, Operations operations){
        operationsRepository.findById(Integer.parseInt(id));
    }
}
