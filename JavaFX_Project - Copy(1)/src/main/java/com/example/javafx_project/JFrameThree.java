package com.example.javafx_project;

public class JFrameThree {

    javax.swing.JFrame jframe = new javax.swing.JFrame();

    // JButton button = new JButton("Display");
    JFrameThree() {


        jframe.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400, 400);
        jframe.setLayout(null);
        jframe.setVisible(true);

    }

    public static void main(String[] args){
        JFrameThree jFrame3= new JFrameThree();
    }

}
