package Pekan8_2411533008;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * RelationalOperatorGUI
 * Contoh GUI sederhana menggunakan Swing untuk membandingkan dua angka
 * berdasarkan operator relasional: >, <, ==, !=, >=, <=
 *
 * Cara pakai:
 * 1. Masukkan angka pertama dan kedua (boleh bilangan desimal).
 * 2. Pilih operator dari dropdown.
 * 3. Klik "Compare" untuk melihat hasil (true/false) dan penjelasan.
 */
public class OperatorRasional_2411533008 extends JFrame {
    private JTextField fieldA;
    private JTextField fieldB;
    private JComboBox<String> operatorBox;
    private JButton compareButton;
    private JLabel resultLabel;
    private JTextArea explanationArea;

    public OperatorRasional_2411533008() {
        super("Operator Relasional - Java GUI (Eclipse)");
        initComponents();
        layoutComponents();
        attachListeners();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(460, 280);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        fieldA = new JTextField(10);
        fieldB = new JTextField(10);
        String[] ops = { ">", "<", "==", "!=", ">=", "<=" };
        operatorBox = new JComboBox<>(ops);
        compareButton = new JButton("Compare");
        resultLabel = new JLabel("Hasil: -");
        resultLabel.setFont(resultLabel.getFont().deriveFont(Font.BOLD, 14f));
        explanationArea = new JTextArea(4, 35);
        explanationArea.setEditable(false);
        explanationArea.setLineWrap(true);
        explanationArea.setWrapStyleWord(true);
    }

    private void layoutComponents() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0; c.gridy = 0;
        inputPanel.add(new JLabel("Angka A:"), c);
        c.gridx = 1;
        inputPanel.add(fieldA, c);

        c.gridx = 0; c.gridy = 1;
        inputPanel.add(new JLabel("Operator:"), c);
        c.gridx = 1;
        inputPanel.add(operatorBox, c);

        c.gridx = 0; c.gridy = 2;
        inputPanel.add(new JLabel("Angka B:"), c);
        c.gridx = 1;
        inputPanel.add(fieldB, c);

        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        inputPanel.add(compareButton, c);

        JPanel resultPanel = new JPanel(new BorderLayout(6, 6));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Hasil Perbandingan"));
        resultPanel.add(resultLabel, BorderLayout.NORTH);
        resultPanel.add(new JScrollPane(explanationArea), BorderLayout.CENTER);

        Container content = getContentPane();
        content.setLayout(new BorderLayout(10, 10));
        content.add(inputPanel, BorderLayout.NORTH);
        content.add(resultPanel, BorderLayout.CENTER);
        content.add(new JLabel("Masukkan angka valid (contoh: 5, -3.2, 2.0)"), BorderLayout.SOUTH);
    }

    private void attachListeners() {
        compareButton.addActionListener(e -> doCompare());
        
        ActionListener enterPressed = e -> doCompare();
        fieldA.addActionListener(enterPressed);
        fieldB.addActionListener(enterPressed);
    }

    private void doCompare() {
        String aText = fieldA.getText().trim();
        String bText = fieldB.getText().trim();
        String op = (String) operatorBox.getSelectedItem();

        if (aText.isEmpty() || bText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi kedua angka terlebih dahulu.", "Input kosong", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double a, b;
        try {
            a = Double.parseDouble(aText);
            b = Double.parseDouble(bText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan angka valid (contoh: 3.5, -2, 0).", "Format angka salah", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        double eps = 1e-9;
        boolean result;
        String explanation;

        switch (op) {
            case ">":
                result = a > b;
                explanation = String.format("%s > %s ? %b  (karena %s %s %s)", a, b, result, a, (result ? "lebih besar dari" : "tidak lebih besar dari"), b);
                break;
            case "<":
                result = a < b;
                explanation = String.format("%s < %s ? %b  (karena %s %s %s)", a, b, result, a, (result ? "lebih kecil dari" : "tidak lebih kecil dari"), b);
                break;
            case "==":
                result = Math.abs(a - b) < eps;
                explanation = String.format("%s == %s ? %b  (dibandingkan dengan toleransi eps=%.0e).", a, b, result, eps);
                break;
            case "!=":
                result = !(Math.abs(a - b) < eps);
                explanation = String.format("%s != %s ? %b  (dibandingkan dengan toleransi eps=%.0e).", a, b, result, eps);
                break;
            case ">=":
                result = a > b || Math.abs(a - b) < eps;
                explanation = String.format("%s >= %s ? %b  (>= berarti lebih besar atau hampir sama dengan, eps=%.0e).", a, b, result, eps);
                break;
            case "<=":
                result = a < b || Math.abs(a - b) < eps;
                explanation = String.format("%s <= %s ? %b  (<= berarti lebih kecil atau hampir sama dengan, eps=%.0e).", a, b, result, eps);
                break;
            default:
                result = false;
                explanation = "Operator tidak dikenali.";
        }

        resultLabel.setText("Hasil: " + result);
        explanationArea.setText(explanation);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new OperatorRasional_2411533008().setVisible(true);
        });
    }
}
