package Pekan9_2411533008;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Kalkulator_2411533008 extends JFrame implements ActionListener {
    private JTextField textField;
    private double firstNum = 0;
    private double secondNum = 0;
    private double result = 0;
    private String operator = "";
    private boolean operatorPressed = false;

    public Kalkulator_2411533008() {
        setTitle("Kalkulator");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,4,5,5));

        // ===== PERUBAHAN ADA DI SINI =====
        String[] buttonLabels = {
            "\u2190", "C", "00", "+",
            "7", "8", "9", "-",
            "4", "5", "6", "*",
            "1", "2", "3", "/",
            "0", ".", "=", "%"
        };
        // ==================================

        for (String label : buttonLabels) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("Arial", Font.PLAIN, 20));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals("00") || command.equals(".")) {
            if (operatorPressed) {
                textField.setText("");
                operatorPressed = false;
            }
            textField.setText(textField.getText() + command);
        } else if (command.equals("C")) {
            textField.setText("");
            firstNum = secondNum = result = 0;
            operator = "";
        } else if (command.equals("\u2190")) {
            String currentText = textField.getText();
            if (currentText.length() > 0) {
                textField.setText(currentText.substring(0, currentText.length()-1));
            }
        } else if (command.equals("%")) {
            try {
                double value = Double.parseDouble(textField.getText());
                value = value / 100;
                textField.setText(Double.toString(value));
            } catch(NumberFormatException ex) {
                textField.setText("Error");
            }
        } else if (command.equals("=")) {
            try {
                secondNum = Double.parseDouble(textField.getText());
                switch(operator) {
                    case "+": result = firstNum + secondNum; break;
                    case "-": result = firstNum - secondNum; break;
                    case "*": result = firstNum * secondNum; break;
                    case "/": result = (secondNum == 0 ? 0 : firstNum / secondNum); break;
                }
                textField.setText(Double.toString(result));
                operator = "";
            } catch(NumberFormatException ex) {
                textField.setText("Error");
            }
        } else {
            try {
                firstNum = Double.parseDouble(textField.getText());
            } catch(NumberFormatException ex) {
                firstNum = 0;
            }
            operator = command;
            operatorPressed = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Kalkulator_2411533008 calc = new Kalkulator_2411533008();
            calc.setVisible(true);
        });
    }
}
