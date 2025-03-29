package main.java.level_1.exercici_5.model;

import main.java.level_1.exercici_5.model.entities.Cat;

import java.io.*;

public class CatMethods implements Serializable {

    public void serializeCat(Cat cat) {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("cat.ser"))) {
            oss.writeObject(cat);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String deserializeCat() {
        String message = "";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cat.ser"))) {
            Cat deserializedCat = (Cat) ois.readObject();
            message = "De-serializado " + deserializedCat;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return message;
    }

}
