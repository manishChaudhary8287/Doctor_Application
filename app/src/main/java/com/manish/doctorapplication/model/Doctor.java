package com.manish.doctorapplication.model;

public class Doctor {
    private String doctor;
    private String spec;
    private String price;

    public Doctor() {
        // Default constructor required for Firebase
    }

    public Doctor(String doctor, String spec, String price) {
        this.doctor = doctor;
        this.spec = spec;
        this.price = price;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
