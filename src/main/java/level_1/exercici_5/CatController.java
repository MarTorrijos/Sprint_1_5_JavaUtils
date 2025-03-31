package main.java.level_1.exercici_5.controller;

import main.java.level_1.exercici_5.model.CatMethods;
import main.java.level_1.exercici_5.model.entities.Cat;

public class CatController {

    public void run() {
        Cat cat = new Cat("Misifuso", "Persa", 11);
        System.out.println(cat);

        CatMethods catMethods = new CatMethods();

        catMethods.serializeCat(cat);
        System.out.println(cat.getName() + " serializado D:");

        System.out.println(catMethods.deserializeCat() + " ^•ﻌ•^");
    }

}
