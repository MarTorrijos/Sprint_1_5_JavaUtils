package main.java.level_1.exercici_2;

import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Path directory = Paths.get(System.getProperty("user.dir"), "resources");
        listDirectoryContents(directory, 0);
    }

    public static void listDirectoryContents(Path directory, int level) {
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

                System.out.println(getIndentation(level) + "- " + file + " (" + type + ", " + lastModified + ")");

                if (type.equals("D")) {
                    listDirectoryContents(fullPath, level + 1);
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