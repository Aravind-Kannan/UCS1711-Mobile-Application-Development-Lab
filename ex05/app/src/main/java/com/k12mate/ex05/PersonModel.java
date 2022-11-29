package com.k12mate.ex05;

public class PersonModel {
    private String name, country, phone, email;
    private int id;

    public PersonModel(int id, String name, String country, String phone, String email) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}