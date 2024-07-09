import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ejercicio_4 {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Calculadora");
    JTextField num1Field = new JTextField(5);
    JTextField num2Field = new JTextField(5);
    JLabel resultLabel = new JLabel("Resultado: ");
    JButton addButton = new JButton("+");
    JButton subButton = new JButton("-");
    JButton mulButton = new JButton("*");
    JButton divButton = new JButton("/");

    ActionListener listener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          double num1 = Double.parseDouble(num1Field.getText());
          double num2 = Double.parseDouble(num2Field.getText());
          double result = 0;

          switch (e.getActionCommand()) {
            case "+":
              result = num1 + num2;
              break;
            case "-":
              result = num1 - num2;
              break;
            case "*":
              result = num1 * num2;
              break;
            case "/":
              if (num2 != 0) {
                result = num1 / num2;
              } else {
                JOptionPane.showMessageDialog(frame, "La división entre cero aun no existe joven! :/");
              }
              break;
          }

          resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(frame, "Porfavor ingresa un valor valido");
        }
      }
    };

    addButton.addActionListener(listener);
    subButton.addActionListener(listener);
    mulButton.addActionListener(listener);
    divButton.addActionListener(listener);

    frame.setLayout(new FlowLayout());
    frame.add(num1Field);
    frame.add(num2Field);
    frame.add(addButton);
    frame.add(subButton);
    frame.add(mulButton);
    frame.add(divButton);
    frame.add(resultLabel);

    frame.setSize(400, 150);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
