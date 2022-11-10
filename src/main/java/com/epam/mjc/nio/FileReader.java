package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        Path path = Paths.get(file.getPath());
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {//while there is content on the current line
                if (currentLine.contains("Name: ")) {
                    profile.setName(currentLine.substring(6));
                }
                if (currentLine.contains("Age: ")) {
                    profile.setAge(Integer.parseInt(currentLine.substring(5)));
                }
                if (currentLine.contains("Email: ")) {
                    profile.setEmail(currentLine.substring(7));
                }
                if (currentLine.contains("Phone: ")) {
                    profile.setPhone(Long.parseLong(currentLine.substring(7)));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return profile;
    }
}
