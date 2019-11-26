package iGoSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoadCard extends JFrame {

  private JPanel contentPane;
  JComboBox<String> cmbOpus = new JComboBox<String>();
  int selectedIndex = -1;
  private final JLabel lblNewLabel = new JLabel("Recharge value:");
  private final JTextField textField = new JTextField();
  private final JButton btnRecharge = new JButton("Recharge");
  private final JButton button = new JButton("<<Back");

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          LoadCard frame = new LoadCard();
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
  public void initLoadCard() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Load Card");
    setBounds(100, 100, 467, 478);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblNumber = new JLabel("Opus Number:");
    lblNumber.setBounds(27, 67, 129, 34);
    contentPane.add(lblNumber);
    
    
    cmbOpus.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
          selectedIndex = cmbOpus.getSelectedIndex();
        }
      }
    });
    cmbOpus.setEditable(true);
    cmbOpus.setBounds(232, 67, 149, 34);
    contentPane.add(cmbOpus);
    lblNewLabel.setBounds(27, 174, 129, 20);
    
    contentPane.add(lblNewLabel);
    textField.setBounds(232, 167, 149, 34);
    
    contentPane.add(textField);
    btnRecharge.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(contentPane, "Recharge success");
      }
    });
    btnRecharge.setBounds(266, 308, 115, 29);
    
    contentPane.add(btnRecharge);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    button.setBounds(55, 308, 115, 29);
    
    contentPane.add(button);
  }
  public LoadCard() {
    textField.setColumns(10);
    initLoadCard();
  }
  public LoadCard(List<String> list) {
    initLoadCard();
    for(int i = 0;i<list.size();i++) {
      cmbOpus.addItem(list.get(i));
    }
  }

}
