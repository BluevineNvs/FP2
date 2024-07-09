import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ejercicio_3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Colorineainador");
        JButton button = new JButton("Escoge un Color");
        JPanel panel = new JPanel();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Escoge un Color", panel.getBackground());
                if (color != null) {
                    panel.setBackground(color);
                }
            }
        });

        frame.add(button, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
