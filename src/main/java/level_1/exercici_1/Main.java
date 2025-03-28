    package main.java.level_1.exercici_1;

    import java.io.File;
    import java.io.IOException;
    import java.nio.file.*;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

    public class Main {

        static List<String> files = new ArrayList<>();

        public static void main(String[] args) {
            Path directory = Paths.get(System.getProperty("user.dir") + File.separator + "resources");

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
                addFileNamesTo(stream);
                System.out.println(alphabeticallyList(files));
            } catch (DirectoryIteratorException | IOException x) {
                System.err.println(x);
            }
        }

        public static void addFileNamesTo(DirectoryStream<Path> stream) {
            for (Path file : stream) {
                files.add(file.getFileName().toString());
            }
        }

        public static String alphabeticallyList(List<String> files) {
            Collections.sort(files);
            StringBuilder fileList = new StringBuilder();
            for (String file : files) {
                fileList.append("- ").append(file).append("\n");
            }
            return fileList.toString();
        }

    }