package com.example.mohit.databindingdemo;

/**
 * Created by Mohit on 2/17/2018.
 */

public class Doctor {

    public String name;
    public String contact;
    public String speciality;
    public Float rating;
    public String timing;

    public Doctor() {
        this.name = "";
        this.contact = "";
        this.speciality = "";
        this.rating = new Float(0.0f);
        this.timing = "";
    }
    public Doctor(String name, String contact, String speciality, Float rating, String timing) {
        this.name = name;
        this.contact = contact;
        this.speciality = speciality;
        this.rating = rating;
        this.timing = timing;
    }
}

