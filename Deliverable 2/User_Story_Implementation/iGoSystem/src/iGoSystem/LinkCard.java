package iGoSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LinkCard extends JFrame {

  private JPanel contentPane;
  private JTextField txtOpus;
  ArrayList<String> list = new ArrayList<String>();

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          LinkCard frame = new LinkCard();
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
  public LinkCard() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Link the Opus card");
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblOpusNumber = new JLabel("OPUS number:");
    lblOpusNumber.setBounds(15, 50, 137, 29);
    contentPane.add(lblOpusNumber);
    
    txtOpus = new JTextField();
    txtOpus.setBounds(196, 45, 197, 39);
    contentPane.add(txtOpus);
    txtOpus.setColumns(10);
    
    JButton btnNewButton = new JButton("Add");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       //Check the digit.
        String regex = "\\d+";
        String Opus = txtOpus.getText();
        // only exist number
        if(Opus.matches(regex)) {
          list.add(Opus);
          txtOpus.setText("");
        }else {
          JOptionPane.showMessageDialog(contentPane, "Only digits are allowed");
        }
      }
    });
    btnNewButton.setBounds(237, 172, 115, 29);
    contentPane.add(btnNewButton);
    
    JButton button = new JButton("<<Back");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new mainPage(list).setVisible(true);
      }
    });
    button.setBounds(57, 172, 115, 29);
    contentPane.add(button);
  }

}
