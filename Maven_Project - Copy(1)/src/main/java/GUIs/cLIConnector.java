package GUIs;

import javax.swing.*;

public class cLIConnector {

    public static void main(String[] args){
    JFrame frame = new JFrame("GUI1");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300,300);
    JButton button = new JButton("GUI1");
                frame.getContentPane().add(button);
                frame.setVisible(true);
}

}
