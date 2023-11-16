import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JFrameTwo implements ActionListener {

    javax.swing.JFrame jframe = new javax.swing.JFrame();

    JButton button = new JButton("Display");
    JFrameTwo() {

        button.setBounds(0, 0, 150, 50);
        button.setFocusable(false);
        button.addActionListener(this);

        jframe.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        jframe.setSize(600, 500);
        jframe.setLayout(null);
        jframe.setVisible(true);

        jframe.add(button);

    }
        @Override
        public void actionPerformed (ActionEvent e){

            if (e.getSource() == button) {
                jframe.dispose();
                JFrameThree.main(null);
            }

        }

    public static void main(String[] args) {
        JFrameTwo jFrameClass = new JFrameTwo();

    }
}
