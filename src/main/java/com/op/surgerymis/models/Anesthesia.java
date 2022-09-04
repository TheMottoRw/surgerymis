package com.op.surgerymis.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Anesthesia {
    @Id
    private int id;
    private String asa;
    private String anesthesiaType;
    private String operativeDuration;
    private String anesthesiaDuration;
    private Boolean postOpDisposition;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isDeleted;
    private Date deletedAt;

    @ManyToOne
    private Patients patient;
    @ManyToOne
    private Operations operation;
    @ManyToOne
    private Users anesthetist;
    @ManyToOne
    private Users anesthesiologist;


    public Anesthesia() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsa() {
        return asa;
    }

    public void setAsa(String asa) {
        this.asa = asa;
    }

    public String getAnesthesiaType() {
        return anesthesiaType;
    }

    public void setAnesthesiaType(String anesthesiaType) {
        this.anesthesiaType = anesthesiaType;
    }

    public String getOperativeDuration() {
        return operativeDuration;
    }

    public void setOperativeDuration(String operativeDuration) {
        this.operativeDuration = operativeDuration;
    }

    public String getAnesthesiaDuration() {
        return anesthesiaDuration;
    }

    public void setAnesthesiaDuration(String anesthesiaDuration) {
        this.anesthesiaDuration = anesthesiaDuration;
    }

    public Users getAnesthesiologist() {
        return anesthesiologist;
    }

    public void setAnesthesiologist(Users anesthesiologist) {
        this.anesthesiologist = anesthesiologist;
    }

    public Users getAnesthetist() {
        return anesthetist;
    }

    public void setAnesthetist(Users anesthetist) {
        this.anesthetist = anesthetist;
    }

    public Boolean getPostOpDisposition() {
        return postOpDisposition;
    }

    public void setPostOpDisposition(Boolean postOpDisposition) {
        this.postOpDisposition = postOpDisposition;
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
}
