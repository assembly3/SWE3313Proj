package GUIs;

import javax.swing.*;

public class Class3 {

    public static void main(String[] args){
        JFrame frame = new JFrame("GUI3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button = new JButton("GUI3");
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }
}
