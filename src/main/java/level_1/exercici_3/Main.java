package main.java.level_1.exercici_3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Path directory = Paths.get(System.getProperty("user.dir"), "resources");
        String fileName = "Result.txt";

        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            listDirectoryContents(directory, 0, pw);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        System.out.println("Contenidos del directorio guardados en un .txt");
    }

    public static void listDirectoryContents(Path directory, int level, PrintWriter pw) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            List<String> filesAndDirectories = new ArrayList<>();

            for (Path file : stream) {
                filesAndDirectories.add(file.getFileName().toString());
            }
            Collections.sort(filesAndDirectories);

            for (String file : filesAndDirectories) {
                Path fullPath = directory.resolve(file);
                String type = Files.isDirectory(fullPath) ? "D" : "F";
                String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                        .format(new Date(Files.getLastModifiedTime(fullPath).toMillis()));

                pw.println(getIndentation(level) + "- " + file + " (" + type + ", " + lastModified + ")");

                if (type.equals("D")) {
                    listDirectoryContents(fullPath, level + 1, pw);
                }
            }

        } catch (DirectoryIteratorException | IOException x) {
            System.err.println("Error reading directory: " + x.getMessage());
        }
    }

    public static String getIndentation(int level) {
        return "  |---".repeat(level);
    }

}