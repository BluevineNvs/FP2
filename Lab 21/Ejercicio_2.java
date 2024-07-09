import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ejercicio_2 {
    private int count = 0;
    public static void main(String[] args) {
        new Ejercicio_2().createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Contador de Click´s");
        JButton button = new JButton("Clickeame");
        JLabel label = new JLabel("Cuenta: 0");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                label.setText("Cuenta: " + count);
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
