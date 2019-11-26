package iGoSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.security.Identity;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowBalance extends JFrame {

  private JPanel contentPane;
  private JTable table;
  private JTextField textField_1;
  private JTextField textField_2;
  JLabel lblN1 = new JLabel("New label");
  JLabel lblN2 = new JLabel("New label");
  JLabel lblN3 = new JLabel("New label");
  private JLabel lblBalance;
  private JLabel lblN4;
  private JTextField textField;
  private JButton btnNewButton;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ShowBalance frame = new ShowBalance();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public void initShowBalance() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 395);
    setTitle("Show Balance");
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    
    lblN1.setBounds(28, 38, 95, 20);
    contentPane.add(lblN1);
    
    
    lblN2.setBounds(28, 96, 95, 20);
    contentPane.add(lblN2);
    
    
    lblN3.setBounds(28, 160, 95, 20);
    contentPane.add(lblN3);
    
    textField_1 = new JTextField();
    textField_1.setEditable(false);
    textField_1.setBounds(204, 93, 146, 26);
    contentPane.add(textField_1);
    textField_1.setColumns(10);
    
    textField_2 = new JTextField();
    textField_2.setEditable(false);
    textField_2.setBounds(204, 157, 146, 26);
    contentPane.add(textField_2);
    textField_2.setColumns(10);
    
    lblBalance = new JLabel("New label");
    lblBalance.setBounds(225, 38, 95, 20);
    contentPane.add(lblBalance);
    
    lblN4 = new JLabel("New label");
    lblN4.setBounds(28, 228, 95, 20);
    contentPane.add(lblN4);
    
    textField = new JTextField();
    textField.setEditable(false);
    textField.setBounds(204, 225, 146, 26);
    contentPane.add(textField);
    textField.setColumns(10);
    
    btnNewButton = new JButton("<<back");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    btnNewButton.setBounds(15, 279, 115, 29);
    contentPane.add(btnNewButton);
    
  }
  public ShowBalance() {
    initShowBalance();
  }
  public ShowBalance(List<String> list) {
    initShowBalance();
    lblN1.setText("OPUS Number");
    lblBalance.setText("Current Balance");
    int size = list.size();
    if(size == 0) {
      lblN3.setVisible(false);
      lblN4.setVisible(false);
      textField_2.setVisible(false);
      textField.setVisible(false);
      lblN2.setText("Null");
      textField_1.setText("Null");
    }
    else if(size == 1) {
      lblN3.setVisible(false);
      lblN4.setVisible(false);
      textField_2.setVisible(false);
      textField.setVisible(false);
      lblN2.setText(list.get(0));
      textField_1.setText(String.valueOf(Math.random()*100));
    }
    else if(size ==2) {
      lblN2.setText(list.get(0));
      textField_1.setText(String.valueOf(Math.random()*100));
      lblN3.setText(list.get(1));
      textField_2.setText(String.valueOf(Math.random()*100));
      lblN4.setVisible(false);
      textField.setVisible(false);
    }else {
      lblN2.setText(list.get(0));
      textField_1.setText(String.valueOf(Math.random()*100));
      lblN3.setText(list.get(1));
      textField_2.setText(String.valueOf(Math.random()*100));
      lblN4.setText(list.get(2));
      textField.setText(String.valueOf(Math.random()*100));
    }
  }
}
