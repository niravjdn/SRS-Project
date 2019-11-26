package iGoSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.naming.InitialContext;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnlinkCard extends JFrame {

  private JPanel contentPane;
  JComboBox<String> cmbOpus = new JComboBox<String>();
  private final JButton btnDelete = new JButton("Delete");
  List<String> list = new ArrayList<String>();
  int selectedIndex = -1;
  private final JButton button = new JButton("<<Back");

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          UnlinkCard frame = new UnlinkCard();
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
  public void initUnlinkCard() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("Opus Number:");
    lblNewLabel.setBounds(15, 59, 120, 39);
    contentPane.add(lblNewLabel);
    cmbOpus.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
          selectedIndex = cmbOpus.getSelectedIndex();
        }
      }
    });
    
    cmbOpus.setEditable(true);
    cmbOpus.setBounds(207, 62, 168, 33);
    contentPane.add(cmbOpus);
    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(selectedIndex == -1) {
          JOptionPane.showMessageDialog(contentPane, "please select the number to be deleted");
        }else {
          list.remove(selectedIndex);
          new mainPage(list).setVisible(true);
        }
        
      }
    });
    btnDelete.setBounds(248, 168, 115, 29);
    
    contentPane.add(btnDelete);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new mainPage(list).setVisible(true);
      }
    });
    button.setBounds(64, 168, 115, 29);
    
    contentPane.add(button);
  }
  public UnlinkCard() {
    initUnlinkCard();
  }
  public UnlinkCard(String[] itemsArray) {
    initUnlinkCard();
    //set value
   for(int i = 0;i<itemsArray.length;i++) {
     cmbOpus.addItem(itemsArray[i]);
     list.add(itemsArray[i]);
   }
  }
}
