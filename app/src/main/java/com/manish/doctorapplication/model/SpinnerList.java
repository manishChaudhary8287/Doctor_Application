package com.manish.doctorapplication.model;

public class SpinnerList {
    private String doctorName;

    public SpinnerList() {
        // Default constructor required for various scenarios
    }

    public SpinnerList(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}

