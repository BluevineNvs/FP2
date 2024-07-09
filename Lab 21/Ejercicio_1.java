import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Ejercicio_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        JButton button = new JButton("Clickeame");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("El boton a sido Clickado!");
            }
        });

        frame.add(button);
        frame.setSize(150, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
