package com.manish.doctorapplication.model;

import java.util.Date;

public class Patient {
    private String doctor;
    private String name;
    private String phone;
    private String address;
    private String gender;
    private String age;
    private String des;
    private String pay;
    private String payment;
    private String date;

    public Patient() {
        // Default constructor required for various scenarios
    }

    public Patient(String doctor, String name, String phone, String address, String gender, String age,
                   String des, String pay, String payment, String date) {
        this.doctor = doctor;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.des = des;
        this.pay = pay;
        this.payment = payment;
        this.date = date;
    }

    public Patient(String doctor, String name, String age, String pay, String date) {
        this.doctor = doctor;
        this.name = name;
        this.age = age;
        this.pay = pay;
        this.date = date;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

