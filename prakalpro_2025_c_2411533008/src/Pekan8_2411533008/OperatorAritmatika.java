package Pekan8_2411533008;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorAritmatikaGUI_2411533008 extends JFrame {

    private JPanel contentPane;
    private JTextField txtBil1;
    private JTextField txtBil2;
    private JTextField txtHasil;
    
    private void pesanPeringatan(String pesan) {
        JOptionPane.showMessageDialog(this, pesan, "Peringatan", JOptionPane.WARNING_MESSAGE);
    }

    private void PesanEror(String pesan) {
        JOptionPane.showMessageDialog(this, pesan, "Peringatan", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OperatorAritmatikaGUI_2411533008 frame = new OperatorAritmatikaGUI_2411533008();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public OperatorAritmatikaGUI_2411533008() {
        setTitle("Operator Aritmatika");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 330, 280);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("OPERATOR ARITMATIKA");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
        lblTitle.setBounds(60, 11, 191, 14);
        contentPane.add(lblTitle);

        JLabel lblBil1 = new JLabel("Bilangan 1");
        lblBil1.setBounds(10, 50, 80, 14);
        contentPane.add(lblBil1);

        JLabel lblBil2 = new JLabel("Bilangan 2");
        lblBil2.setBounds(10, 90, 80, 14);
        contentPane.add(lblBil2);

        JLabel lblOp = new JLabel("Operator");
        lblOp.setBounds(10, 130, 80, 14);
        contentPane.add(lblOp);

        JLabel lblHasil = new JLabel("Hasil");
        lblHasil.setBounds(10, 170, 80, 14);
        contentPane.add(lblHasil);

        txtBil1 = new JTextField();
        txtBil1.setBounds(100, 47, 96, 20);
        txtBil1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(txtBil1);

        txtBil2 = new JTextField();
        txtBil2.setBounds(100, 87, 96, 20);
        txtBil2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(txtBil2);

        txtHasil = new JTextField();
        txtHasil.setBounds(100, 167, 96, 20);
        txtHasil.setHorizontalAlignment(SwingConstants.CENTER);
        txtHasil.setEditable(false);
        contentPane.add(txtHasil);

        JComboBox cbOperator = new JComboBox();
        cbOperator.setModel(new DefaultComboBoxModel(new String[]{"+" , "-" , ":" , "x" , "%"}));
        cbOperator.setBounds(100, 127, 96, 22);
        contentPane.add(cbOperator);

        JButton btnNewButton = new JButton("Hitung");
        btnNewButton.addActionListener(new ActionListener() {
            int hasil;

            public void actionPerformed(ActionEvent e) {
                int a = Integer.valueOf(txtBil1.getText());
                int b = Integer.valueOf(txtBil2.getText());
                int c = cbOperator.getSelectedIndex();

                if (c == 0) hasil = a + b;
                if (c == 1) hasil = a - b;
                if (c == 2) hasil = a / b;
                if (c == 3) hasil = a * b;
                if (c == 4) hasil = a % b;

                txtHasil.setText(String.valueOf(hasil));
            }
        });

        btnNewButton.setBounds(210, 127, 89, 23);
        contentPane.add(btnNewButton);
    }
}
