package GUIs;

import javax.swing.*;



public class Class2 {

    public static void main(String[] args){
        JFrame frame = new JFrame("GUI2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button = new JButton("GUI2");
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }
}
