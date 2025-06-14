import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {

    JTextField input;
    double number1, number2, result;
    int operator;

    Main() {
        setTitle("Scientific Calculator");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        input = new JTextField();
        input.setBounds(30, 40, 320, 40);
        input.setEditable(false);
        add(input);

        String[] buttonLabels = {
                "7", "8", "9", "/", "sin",
                "4", "5", "6", "*", "cos",
                "1", "2", "3", "-", "tan",
                "0", ".", "=", "+", "√",
                "log", "x^y", "C", "←"
        };

        JButton[] buttons = new JButton[buttonLabels.length];

        int x = 30, y = 100;
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setBounds(x, y, 60, 40);
            buttons[i].addActionListener(this);
            add(buttons[i]);

            x += 70;
            if ((i + 1) % 5 == 0) {
                x = 30;
                y += 50;
            }
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case "C":
                    input.setText("");
                    break;
                case "←":
                    String text = input.getText();
                    if (!text.isEmpty())
                        input.setText(text.substring(0, text.length() - 1));
                    break;
                case "+":
                    number1 = Double.parseDouble(input.getText());
                    operator = 1;
                    input.setText("");
                    break;
                case "-":
                    number1 = Double.parseDouble(input.getText());
                    operator = 2;
                    input.setText("");
                    break;
                case "*":
                    number1 = Double.parseDouble(input.getText());
                    operator = 3;
                    input.setText("");
                    break;
                case "/":
                    number1 = Double.parseDouble(input.getText());
                    operator = 4;
                    input.setText("");
                    break;
                case "=":
                    number2 = Double.parseDouble(input.getText());
                    switch (operator) {
                        case 1: result = number1 + number2; break;
                        case 2: result = number1 - number2; break;
                        case 3: result = number1 * number2; break;
                        case 4: result = number1 / number2; break;
                        case 5: result = Math.pow(number1, number2); break;
                    }
                    input.setText(String.valueOf(result));
                    break;
                case "sin":
                    result = Math.sin(Math.toRadians(Double.parseDouble(input.getText())));
                    input.setText(String.valueOf(result));
                    break;
                case "cos":
                    result = Math.cos(Math.toRadians(Double.parseDouble(input.getText())));
                    input.setText(String.valueOf(result));
                    break;
                case "tan":
                    result = Math.tan(Math.toRadians(Double.parseDouble(input.getText())));
                    input.setText(String.valueOf(result));
                    break;
                case "log":
                    result = Math.log10(Double.parseDouble(input.getText()));
                    input.setText(String.valueOf(result));
                    break;
                case "√":
                    result = Math.sqrt(Double.parseDouble(input.getText()));
                    input.setText(String.valueOf(result));
                    break;
                case "x^y":
                    number1 = Double.parseDouble(input.getText());
                    operator = 5;
                    input.setText("");
                    break;
                case ".":
                    input.setText(input.getText() + ".");
                    break;
                default: // numbers
                    input.setText(input.getText() + cmd);
                    break;
            }
        } catch (Exception ex) {
            input.setText("Error");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}