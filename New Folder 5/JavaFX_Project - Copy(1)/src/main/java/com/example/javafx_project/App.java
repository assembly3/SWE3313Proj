package com.example.javafx_project;

import java.io.File;
import java.io.IOException;

import GUIs.Class1;
import GUIs.Class2;
import GUIs.Class3;

public class App {

    public static int x = 1;


    public static void main(String[] args) throws IOException {


      //  try {
      // Runtime.getRuntime().exec("C:/Users/assem/IdeaProjects/Intro" +
      //      "toSoftwareEngineering/JavaFX_Project/MavenProject10SNAPSHOT (1).exe", null, new File("C:\\Users\\assem\\IdeaProjects\\IntrotoSoftwareEngineering\\JavaFX_Project"));
      //  } catch (IOException e) {
      // throw new RuntimeException(e);
      //  }


        int x = 1;

        switch (x){

            case 0:

                javafx.application.Application.launch(HelloApplication.class);

            case 1:

                javafx.application.Application.launch(HCP.class);

            default:
                break;
        }

    }

}





