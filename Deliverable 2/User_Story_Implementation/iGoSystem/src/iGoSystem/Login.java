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
import java.awt.event.ActionEvent;

public class Login extends JFrame {

  private JPanel contentPane;
  private JTextField txtUserName;
  private JTextField txtPassword;
  private JButton btnregister;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Login frame = new Login();
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
  public Login() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 439, 397);
    contentPane = new JPanel();
    setTitle("Login");
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("Username:");
    lblNewLabel.setBounds(51, 71, 146, 42);
    contentPane.add(lblNewLabel);
    
    JLabel lblPassword = new JLabel("Password:");
    lblPassword.setBounds(51, 177, 123, 42);
    contentPane.add(lblPassword);
    
    txtUserName = new JTextField();
    txtUserName.setBounds(196, 74, 175, 36);
    contentPane.add(txtUserName);
    txtUserName.setColumns(10);
    
    txtPassword = new JTextField();
    txtPassword.setBounds(196, 180, 175, 36);
    contentPane.add(txtPassword);
    txtPassword.setColumns(10);
    
    JButton btnLogIn = new JButton("Log in ");
    btnLogIn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        if(userName.equals("jingya")&&password.equals("123456789")) {
          //success
          JOptionPane.showMessageDialog(contentPane, "login successfully");
          mainPage main = new mainPage();
          main.setVisible(true);
          dispose();
          
        }else {
          JOptionPane.showMessageDialog(contentPane, "invalid username or password");
        }
      }
    });
    btnLogIn.setBounds(82, 279, 115, 29);
    contentPane.add(btnLogIn);
    
    btnregister = new JButton(">>Register");
    btnregister.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Register re = new Register();
        re.setVisible(true);
        dispose();
      }
    });
    btnregister.setBounds(256, 279, 115, 29);
    contentPane.add(btnregister);
  }
}
