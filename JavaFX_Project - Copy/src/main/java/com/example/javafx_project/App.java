package com.example.javafx_project;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        HelloApplication.main(args);

        try {
            Runtime.getRuntime().exec("C:/Users/assem/IdeaProjects/Intro" +
                    "toSoftwareEngineering/JavaFX_Project/MavenProject10SNAPSHOT (1).exe", null, new File("C:\\Users\\assem\\IdeaProjects\\IntrotoSoftwareEngineering\\JavaFX_Project"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }

