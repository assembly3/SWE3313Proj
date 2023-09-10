package com.example.javafx_project;

import java.io.File;
import java.io.IOException;

import GUIs.Class1;
import GUIs.Class2;
import GUIs.Class3;

public class App {
    public static void main(String[] args) throws IOException{

        Class1.main(args);

        HelloApplication.main(args);

        try {
            Runtime.getRuntime().exec("C:/Users/assem/IdeaProjects/Intro" +
                    "toSoftwareEngineering/JavaFX_Project/MavenProject10SNAPSHOT (1).exe", null, new File("C:\\Users\\assem\\IdeaProjects\\IntrotoSoftwareEngineering\\JavaFX_Project"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Class2.main(args);

        Class3.main(args);



    }


}


