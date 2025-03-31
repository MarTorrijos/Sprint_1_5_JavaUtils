package main.java.level_1.exercici_5.model;

import java.io.Serializable;

public class Cat implements Serializable {

    private String name;
    private String breed;
    private int age;

    public Cat(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " de raza " + breed + " y " + age + " años de edad";
    }

}