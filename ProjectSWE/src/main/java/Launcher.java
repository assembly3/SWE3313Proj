import GUIs.HealthCareJFrame;
import org.json.JSONException;
import org.json.JSONObject;

import GUIs.Class1;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;


import static javax.swing.SwingConstants.HORIZONTAL;

public class Launcher implements ActionListener, ChangeListener {

    javax.swing.JFrame jframe = new javax.swing.JFrame();

    JSlider slider = new JSlider(HORIZONTAL);
    JButton myButton = new JButton("Weekly Forecast");

    JButton myButton2 = new JButton("Covid-19 Data");

    JButton myButton3 = new JButton("Pollen Data");

    JButton myButton4 = new JButton("IP Data Info");

    JButton myButton5 = new JButton("Geolocation");

    JButton myButton6 = new JButton("CLInterface");

    JTextField tf = new JTextField("IP Information");
    static JTextField tf2 = new JTextField("C://ProjectSWE//ConsoleApp1.exe");

    Label l1 = new Label("Manual Label");

    Label l2 = new Label("CLASSPATH to CLInterface: ");


    Launcher() {


        l2.setBounds(740,200,150,50);
        l1.setBounds(300,0,150,50);
        tf.setBounds(950, 100, 500, 50);
        tf.setFocusable(false);

        tf2.setBounds(950, 200, 500, 50);
        // tf2.setFocusable(false);


        slider.setBounds(100, 0, 150, 50);
        slider.addChangeListener(this);

        myButton6.setBounds(1300, 650, 150, 50);
        myButton6.setFocusable(false);
        myButton6.addActionListener(this);

        myButton5.setBounds(1300, 550, 150, 50);
        myButton5.setFocusable(false);
        myButton5.addActionListener(this);

        myButton4.setBounds(1300, 450, 150, 50);
        myButton4.setFocusable(false);
        myButton4.addActionListener(this);

        myButton3.setBounds(100, 350, 150, 50);
        myButton3.setFocusable(false);
        myButton3.addActionListener(this);

        myButton2.setBounds(100, 250, 150, 50);
        myButton2.setFocusable(false);
        myButton2.addActionListener(this);

        myButton.setBounds(100, 150, 150, 50);
        myButton.setFocusable(false);
        myButton.addActionListener(this);

        JLabel l = new JLabel(new ImageIcon
                ("C://ProjectSWE//Screenshot2.png"));


        l.setBounds(750, 500, 507, 302);
        l.setVisible(true);

        jframe.add(l);
        jframe.add(l1);
        jframe.add(l2);
        jframe.add(slider);
        jframe.add(tf);
        jframe.add(tf2);
        jframe.add(myButton);
        jframe.add(myButton2);
        jframe.add(myButton3);
        jframe.add(myButton4);
        jframe.add(myButton5);
        jframe.add(myButton6);

        jframe.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        jframe.setSize(1600, 900);
        jframe.setLayout(null);
        jframe.getContentPane().setBackground(Color.gray);
        jframe.setVisible(true);

    }
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (source.getValue() == 0){

            Class1.main(null);

        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == myButton){
            jframe.dispose();
            try {
                CurrentCondition.main(null);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            } catch (JSONException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == myButton2){
            jframe.dispose();
            try {
                HCP.main(null);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

        }

        if (e.getSource() == myButton3){
            jframe.dispose();
            try {
                HealthCareJFrame.main(null);
            } catch (JSONException ex) {
                throw new RuntimeException(ex);
            }

        }



        if (e.getSource() == myButton4) {

            String lines2 = "";
            try {


                URI uri = new URI("https://get.geojs.io/v1/ip/geo.json");

                URL url;

                url = uri.toURL();

                Scanner sc = new Scanner(url.openStream());

                String lines = "";
                while (sc.hasNextLine()) {
                    lines += sc.nextLine();
                }

                JSONObject obj = new JSONObject(lines);


                lines2 += obj.getString("organization") + " ";
                lines2 += obj.getString("ip") + " ";
                lines2 += obj.getString("city") + " ";
                lines2 += obj.getString("country_code") + " ";
                lines2 += obj.getString("country_code3") + " ";
                lines2 += obj.getString("region") + " ";
                lines2 += obj.getString("latitude") + " ";
                lines2 += obj.getString("longitude") + " ";



            } catch (URISyntaxException | JSONException | IOException ex) {
                throw new RuntimeException(ex);
            } finally {
                tf.setText(lines2);
            }

        }
        if (e.getSource() == myButton5) {
            jframe.dispose();
            GeoLocationGUI.main(null);
        }

        if (e.getSource() == myButton6) {
            jframe.dispose();
            cLIConnector.main(null);
        }

        }

        public static void main(String[] args){




        }
}


