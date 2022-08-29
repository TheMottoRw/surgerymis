package com.op.surgerymis.dto;

public class UsersStatsDTO {
    private int surgeons;
    private int nurses;
    private int anesthetists;


    private int anesthesiologists;
    private int patients;
    private int operations;


    public int getSurgeons() {
        return surgeons;
    }

    public void setSurgeons(int surgeons) {
        this.surgeons = surgeons;
    }

    public int getNurses() {
        return nurses;
    }

    public void setNurses(int nurses) {
        this.nurses = nurses;
    }

    public int getAnesthetists() {
        return anesthetists;
    }

    public void setAnesthetists(int anesthetists) {
        this.anesthetists = anesthetists;
    }

    public int getAnesthesiologists() {
        return anesthesiologists;
    }

    public void setAnesthesiologists(int anesthesiologists) {
        this.anesthesiologists = anesthesiologists;
    }

    public int getPatients() {
        return patients;
    }

    public void setPatients(int patients) {
        this.patients = patients;
    }

    public int getOperations() {
        return operations;
    }

    public void setOperations(int operations) {
        this.operations = operations;
    }

}
