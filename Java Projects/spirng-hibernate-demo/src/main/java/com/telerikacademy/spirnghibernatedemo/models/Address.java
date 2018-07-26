package com.telerikacademy.spirnghibernatedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
    private int id;

    @Column(name = "AddressText")
    private String text;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "address")
    private List<Employee> employee;

    @ManyToOne
    @JoinColumn(name = "TownId")
    private Town town;

    public Address() {
    }

    public Address(String text, List<Employee> employee, Town town) {
        this.text = text;
        this.employee = employee;
        this.town = town;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", id, text, town.getName());
    }
}
