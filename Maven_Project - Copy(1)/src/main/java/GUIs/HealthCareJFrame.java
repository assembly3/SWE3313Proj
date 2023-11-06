package GUIs;

import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.Objects;

public class HealthCareJFrame implements ActionListener {


    public static Button buttonOne = new Button();

    public static Label label = new Label();

    public static void main(String[] args) throws JSONException {

        JFrame frame = new JFrame("Health Care Frame - Pollen Count");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label.setBounds(250,300,400,25);
        buttonOne.setBounds(250, 230, 25, 25);
        textFieldOne.setBounds(250, 330, 150, 25);
        textFieldTwo.setBounds(250, 360, 150, 25);
        textFieldThree.setBounds(250, 390, 150, 25);
        textFieldFour.setBounds(250, 420, 150, 25);

        frame.add(buttonOne);

        label.setText("Enter the city name, including underscores, or ZIP.");

        frame.add(label);

        ActionListener HealthCareJFrame = new HealthCareJFrame();

        buttonOne.addActionListener(HealthCareJFrame);

        DefaultListModel<String> l1 = getStringDefaultListModel();
        JList<String> list = new JList<>(l1);
        list.setBounds(100, 200, 75, 270);

        frame.add(textFieldOne);
        frame.add(textFieldTwo);
        frame.add(textFieldThree);
        frame.add(textFieldFour);

        frame.add(list);
        frame.setSize(675, 675);
        frame.setLayout(null);
        frame.setVisible(true);

    }


    private static DefaultListModel<String> getStringDefaultListModel() {
        DefaultListModel<String> l1 = new DefaultListModel<>();
        l1.addElement("Item1");
        l1.addElement("Item2");
        l1.addElement("Item3");
        l1.addElement("Item4");
        l1.addElement("Item5");
        l1.addElement("Item6");
        l1.addElement("Item7");
        l1.addElement("Item8");
        l1.addElement("Item9");
        l1.addElement("Item10");
        l1.addElement("Item11");
        l1.addElement("Item12");
        l1.addElement("Item13");
        l1.addElement("Item14");
        l1.addElement("Item15");
        return l1;
    }


    public static TextField textFieldOne = new TextField();
    public static TextField textFieldTwo = new TextField();
    public static TextField textFieldThree = new TextField();
    public static TextField textFieldFour = new TextField();
    public static String cityName = "";
    public static String stateCode = "";
    public static String countryCode = "US";
    public static Integer zipCode = 0;

    public static String getCityName() {
        return cityName;
    }

    public static Integer getZipCode() {
        return zipCode;
    }

    public static String getCountryCode() {
        return countryCode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonOne) {

            if (!textFieldOne.getText().isEmpty()) {
                cityName = textFieldOne.getText();
                try {

                    textFieldThree.setText("No zip code " + HealthCareAPI.getCoordinateTwo());

                    textFieldFour.setText("Pollen count is " + HealthCareAPI.getCoordinate());
                } catch (JSONException ex) {
                    throw new RuntimeException(ex);
                }

            }

                if (!textFieldTwo.getText().isEmpty()) {
                    zipCode = Integer.parseInt(textFieldTwo.getText());
                    try {
                        textFieldThree.setText("No city name " + HealthCareAPI.getCoordinateThree());
                    } catch (JSONException ex) {
                        throw new RuntimeException(ex);
                    }
                }


            }
        }


    }


