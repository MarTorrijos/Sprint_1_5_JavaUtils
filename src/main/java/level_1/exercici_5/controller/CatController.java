package main.java.level_1.exercici_5.controller;

import main.java.level_1.exercici_5.model.CatMethods;
import main.java.level_1.exercici_5.model.entities.Cat;

public class CatController {

    public void run() {
        Cat cat = new Cat("Misifuso", "Persa", 11);
        CatMethods catMethods = new CatMethods();

        catMethods.serializeCat(cat);
        System.out.println("Objecto Cat con nombre Misifuso serializado");

        catMethods.deserializeCat(cat);
        System.out.println("Misifuso deserializado ^•ﻌ•^");
    }

}
