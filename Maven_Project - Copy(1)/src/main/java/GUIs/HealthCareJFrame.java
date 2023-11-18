package GUIs;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthCareJFrame implements ActionListener {


    public static Button buttonOne = new Button();

    public static Label label = new Label();

    static DefaultListModel<String> l1 = getStringDefaultListModel();
    static JList<String> list = new JList<>(l1);

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

        list.setBounds(75, 200, 100, 270);

        mb.add(menu);
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        menu.add(item5);
        menu.add(item6);
        menu.add(item7);
        menu.add(item8);
        menu.add(item9);
        menu.add(item10);
        menu.add(item11);
        menu.add(item12);
        menu.add(item13);
        menu.add(item14);
        menu.add(item15);

        frame.setMenuBar(mb);

        HealthCareJFrame healthCareFrame = new HealthCareJFrame();

        item1.addActionListener(healthCareFrame);
        item2.addActionListener(healthCareFrame);
        item3.addActionListener(healthCareFrame);
        item4.addActionListener(healthCareFrame);
        item5.addActionListener(healthCareFrame);
        item6.addActionListener(healthCareFrame);
        item7.addActionListener(healthCareFrame);
        item8.addActionListener(healthCareFrame);
        item9.addActionListener(healthCareFrame);
        item10.addActionListener(healthCareFrame);
        item11.addActionListener(healthCareFrame);
        item12.addActionListener(healthCareFrame);
        item13.addActionListener(healthCareFrame);
        item14.addActionListener(healthCareFrame);
        item15.addActionListener(healthCareFrame);





        frame.add(textFieldOne);
        frame.add(textFieldTwo);
        frame.add(textFieldThree);
        frame.add(textFieldFour);

        frame.add(list);
        frame.setSize(675, 675);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    static Menu menu = new Menu("Selected City: ");

    static MenuItem item1 = new MenuItem("New_York");
    static MenuItem item2 = new MenuItem("Santa_Fe");
    static MenuItem item3 = new MenuItem("Chicago");
    static MenuItem item4 = new MenuItem("Savannah");

    static MenuItem item5 = new MenuItem("New_Orleans");
    static MenuItem item6 = new MenuItem("Charleston");
    static MenuItem item7 = new MenuItem("Portland");
    static MenuItem item8 = new MenuItem("London");
    static MenuItem item9 = new MenuItem("Shanghai");
    static MenuItem item10 = new MenuItem("Mumbai");
    static MenuItem item11 = new MenuItem("Luxembourg");
    static MenuItem item12 = new MenuItem("Tokyo");
    static MenuItem item13 = new MenuItem("Mexico_City");
    static MenuItem item14 = new MenuItem("Cairo");
    static MenuItem item15 = new MenuItem("Zurich");

    static String cityString = "";

    static String cityName = "";

    static MenuBar mb = new MenuBar();

    public static DefaultListModel<String> getStringDefaultListModel() {
        DefaultListModel<String> l1 = new DefaultListModel<>();

        l1.addElement("New_York");
        l1.addElement("Santa_Fe");
        l1.addElement("Chicago");
        l1.addElement("Savannah");
        l1.addElement("New_Orleans");
        l1.addElement("Charleston");
        l1.addElement("Portland");
        l1.addElement("London");
        l1.addElement("Shanghai");
        l1.addElement("Mumbai");
        l1.addElement("Luxembourg");
        l1.addElement("Tokyo");
        l1.addElement("Mexico_City");
        l1.addElement("Cairo");
        l1.addElement("Zurich");
        return l1;

    }





    public static TextField textFieldOne = new TextField();
    public static TextField textFieldTwo = new TextField();
    public static TextField textFieldThree = new TextField();
    public static TextField textFieldFour = new TextField();

    public static String stateCode = "";
    public static String countryCode = "US";
    public static Integer zipCode = 0;

    public static Integer getZipCode() {
        return zipCode;
    }

    public void setCountryCode(String string) { countryCode = string; }

    public static String getCountryCode() {
        return countryCode;
    }

    public static String getCityName()  {return cityName; }




    @Override
    public void actionPerformed(ActionEvent e) {




            if (e.getSource() == buttonOne) {


                if ((!textFieldOne.getText().isEmpty()) && (textFieldTwo.getText().isEmpty())) {
                    cityName = textFieldOne.getText();
                    setCountryCode("US");
                    if(cityName.equals("London"))
                    {
                        setCountryCode("GB");
                    }
                    if(cityName.equals("Shanghai"))
                    {
                        setCountryCode("CN");
                    }
                    if(cityName.equals("Mumbai"))
                    {
                        setCountryCode("IN");
                    }
                    if(cityName.equals("Luxembourg"))
                    {
                        setCountryCode("LU");
                    }
                    if(cityName.equals("Tokyo"))
                    {
                        setCountryCode("JP");
                    }
                    if(cityName.equals("Mexico_City"))
                    {
                        setCountryCode("MX");
                    }
                    if(cityName.equals("Cairo"))
                    {
                        setCountryCode("EG");
                    }
                    if(cityName.equals("Zurich"))
                    {
                        setCountryCode("CH");
                    }




                    try {
                        textFieldThree.setText("No zip code " + HealthCareAPI.getCoordinateTwo());
                    } catch (JSONException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        textFieldFour.setText("Pollen count is " + PollenAPI.getCoordinate());
                    } catch (JSONException ex) {
                        throw new RuntimeException(ex);
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }

                }

                if ((!textFieldTwo.getText().isEmpty()) && (textFieldOne.getText().isEmpty())) {
                    zipCode = Integer.parseInt(textFieldTwo.getText());
                    try {
                        textFieldThree.setText("No city name " + HealthCareAPI.getCoordinateThree());
                    } catch (JSONException ex) {
                        throw new RuntimeException(ex);
                    }
                }


            } else {

                String string = e.getActionCommand();

                textFieldOne.setText(string);

        }


        }
    }







