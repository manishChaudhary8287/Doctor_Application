package com.manish.doctorapplication.model;

public class TestModel {
    private String test;
    private String price;

    public TestModel(String test, String price) {
        this.test = test;
        this.price = price;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
