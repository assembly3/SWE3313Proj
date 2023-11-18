import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class cLIConnector implements ActionListener {

    public static JButton button = new JButton("Press to access CLInterface");

    static JFrame frame = new JFrame("JFrame2");

    cLIConnector() {

        button.addActionListener(this);

    }

    public static void main(String[] args){

        cLIConnector cLIConnectorTwo = new cLIConnector();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

        button.setSize(100,50);
        frame.add(button);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            try {

                frame.dispose();
                CLIRetrieval.openFile(Launcher.tf2.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
