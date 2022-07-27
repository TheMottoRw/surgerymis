package com.op.surgerymis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Operations {
    @Id
    private int id;
    private String districtHospital;
    private String preOpDiagnostic;
    private String plannedProcedure;
    private String caution;
    private String assurance;
    private String accompanying;
    private String provenance;
    private String transfer;
    private Boolean received;
    private String observation;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isDeleted;
    private Date deletedAt;

    @ManyToOne
    private Patients patient;


    public Operations() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrictHospital() {
        return districtHospital;
    }

    public void setDistrictHospital(String districtHospital) {
        this.districtHospital = districtHospital;
    }

    public String getPreOpDiagnostic() {
        return preOpDiagnostic;
    }

    public void setPreOpDiagnostic(String preOpDiagnostic) {
        this.preOpDiagnostic = preOpDiagnostic;
    }

    public String getPlannedProcedure() {
        return plannedProcedure;
    }

    public void setPlannedProcedure(String plannedProcedure) {
        this.plannedProcedure = plannedProcedure;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }

    public String getAssurance() {
        return assurance;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }

    public String getAccompanying() {
        return accompanying;
    }

    public void setAccompanying(String accompanying) {
        this.accompanying = accompanying;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }

    public String getObservation() {
        return observation;
    }

    public void setObserved(String observation) {
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
}
