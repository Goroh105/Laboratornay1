package com.dolsoft.proizvoditelservice.model;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class Proizvoditel extends RepresentationModel<Proizvoditel> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String country;
    private String contactPerson;
    private String phone;

    public Proizvoditel() {
    }

    public Proizvoditel(int id, String name, String country, String contactPerson, String phone) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.contactPerson = contactPerson;
        this.phone = phone;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Proizvoditel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}