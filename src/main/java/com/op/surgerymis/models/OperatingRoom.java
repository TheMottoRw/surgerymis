package com.op.surgerymis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class OperatingRoom {
    @Id
    private int id;
    private String intraOpDiagnosis;
    private String opProcedure;
    private String emergenceOrEntrance;
    private String dressing;
    private String out_;
    private String cleaning;
    private String operationStatus;
    private String observation;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isDeleted;
    private Date deletedAt;

    @ManyToOne
    private Patients patient;
    @ManyToOne
    private Operations operation;
    @ManyToOne
    private Users surgeon;
    @ManyToOne
    private Users nurse;


    public OperatingRoom() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntraOpDiagnosis() {
        return intraOpDiagnosis;
    }

    public void setIntraOpDiagnosis(String intraOpDiagnosis) {
        this.intraOpDiagnosis = intraOpDiagnosis;
    }

    public String getOpProcedure() {
        return opProcedure;
    }

    public void setOpProcedure(String opProcedure) {
        this.opProcedure = opProcedure;
    }

    public String getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(String status) {
        this.operationStatus = status;
    }

    public String getEmergencyOrEntrance() {
        return emergenceOrEntrance;
    }

    public void setEmergencyOrEntrance(String entranceorentrance) {
        this.emergenceOrEntrance = entranceorentrance;
    }

    public String getDressing() {
        return dressing;
    }

    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    public String getOut_() {
        return out_;
    }

    public void setOut_(String out_) {
        this.out_ = out_;
    }

    public String getCleaning() {
        return cleaning;
    }

    public void setCleaning(String cleaning) {
        this.cleaning = cleaning;
    }


    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Operations getOperation() {
        return operation;
    }

    public void setOperation(Operations operation) {
        this.operation = operation;
    }

    public Users getSurgeon() {
        return surgeon;
    }

    public void setSurgeon(Users surgeon) {
        this.surgeon = surgeon;
    }

    public Users getNurse() {
        return nurse;
    }

    public void setNurse(Users nurse) {
        this.nurse = nurse;
    }
}
