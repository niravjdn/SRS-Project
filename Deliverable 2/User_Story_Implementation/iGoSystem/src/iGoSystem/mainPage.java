package iGoSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class mainPage extends JFrame {

  private JPanel contentPane;
  JLabel lblList = new JLabel("");
  private final JButton btnunlinkTheOpus = new JButton(">>Unlink the Opus card");
  private final JButton btnCheckTheBalance = new JButton(">>Check the balance");
  List<String> opusList = new ArrayList<String>();
  private final JButton btnNewButton = new JButton(">>Load OPUS Card");

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          mainPage frame = new mainPage();
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
  public void initmainPage() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 579, 490);
    setTitle("iGo System");
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JButton btnlinkTheOpus = new JButton(">>Link the Opus card");
    btnlinkTheOpus.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        LinkCard linkCard = new LinkCard();
        linkCard.setVisible(true);
      }
    });
    btnlinkTheOpus.setBounds(15, 44, 235, 38);
    contentPane.add(btnlinkTheOpus);
    
    //JLabel lblList = new JLabel("New label");
    lblList.setBounds(310, 16, 195, 115);
    contentPane.add(lblList);
    btnunlinkTheOpus.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String[] itemsArray = new String[opusList.size()];
        itemsArray = opusList.toArray(itemsArray);
        new UnlinkCard(itemsArray).setVisible(true);
      }
    });
    btnunlinkTheOpus.setBounds(15, 143, 235, 45);
    
    contentPane.add(btnunlinkTheOpus);
    btnCheckTheBalance.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new ShowBalance(opusList).setVisible(true);
      }
    });
    btnCheckTheBalance.setBounds(15, 250, 235, 45);
    
    contentPane.add(btnCheckTheBalance);
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new LoadCard(opusList).setVisible(true);
      }
    });
    btnNewButton.setBounds(15, 347, 235, 45);
    
    contentPane.add(btnNewButton);
  }
  public mainPage() {
    initmainPage();
  }
  public mainPage(List<String> list) {
    initmainPage();
    String text = "<html><h3>List:</h1><br />";
    for(String s:list) {
      text = text + s + "<br />";
    }
    lblList.setText(text);
    opusList = list;
  }

}
