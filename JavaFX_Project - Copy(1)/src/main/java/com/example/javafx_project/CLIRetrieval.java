package com.example.javafx_project;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

class CLIRetrieval {
     public static void openFile(String targetFilePath) throws IOException
     {
         Desktop desktop = Desktop.getDesktop();

         desktop.open(new File(targetFilePath));
     }


}






