package com.example.spring_boot_example.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class Car {

    private String name;
    private String type;

    public Car() {
    }

    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
