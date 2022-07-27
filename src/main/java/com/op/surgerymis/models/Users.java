package com.op.surgerymis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
public class Users {
    @Id
    private int id;
    private String name;
    private String email;
    private String phone;
    private String userType;
    private Boolean isPasswordChanged;
    private String password="";

    private Boolean isOtpRequired;
    private String otp="";
    private Date createdAt;
    private Date updatedAt;
    @JsonIgnore
    private Boolean isDeleted;
    @JsonIgnore
    private Date deletedAt;

    public Users(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getPasswordChanged() {
        return isPasswordChanged;
    }

    public void setPasswordChanged(Boolean passwordChanged) {
        isPasswordChanged = passwordChanged;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getOtpRequired() {
        return isOtpRequired;
    }

    public void setOtpRequired(Boolean otpRequired) {
        isOtpRequired = otpRequired;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
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
}
