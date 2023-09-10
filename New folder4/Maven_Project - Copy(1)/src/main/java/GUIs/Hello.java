package GUIs;

import javax.swing.*;

public class Hello {
    public static void main(String[] args){

                JFrame frame = new JFrame("GUIs.Hello");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300,300);
                JButton button = new JButton("Press");
                frame.getContentPane().add(button);
                frame.setVisible(true);
            }
        }

