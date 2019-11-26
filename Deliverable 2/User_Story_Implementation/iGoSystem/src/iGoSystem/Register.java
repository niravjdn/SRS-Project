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
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

  private JPanel contentPane;
  private JTextField txtEmail;
  private JTextField textPwd;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Register frame = new Register();
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
  public Register() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 439, 397);
    setTitle("Register");
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblEmail = new JLabel("Email:");
    lblEmail.setBounds(39, 71, 127, 33);
    contentPane.add(lblEmail);
    
    txtEmail = new JTextField();
    txtEmail.setBounds(165, 72, 189, 30);
    contentPane.add(txtEmail);
    txtEmail.setColumns(10);
    
    JLabel lblPassword = new JLabel("Password:");
    lblPassword.setBounds(39, 170, 127, 33);
    contentPane.add(lblPassword);
    
    textPwd = new JTextField();
    textPwd.setBounds(165, 173, 189, 30);
    contentPane.add(textPwd);
    textPwd.setColumns(10);
    
    /**
     * Verify the email address
     * Verify the password must be more than 8 characters
     * 
     */
    JButton btnRegister = new JButton("register");
    btnRegister.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
            "[a-zA-Z0-9_+&*-]+)*@" + 
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
            "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex); 
        String email = txtEmail.getText();
        if (email == null) {
          JOptionPane.showMessageDialog(contentPane, "please enter the email");
          txtEmail.setText("");
          textPwd.setText("");
        }
        else if(pat.matcher(email).matches()) {
          if(textPwd.getText().length()>8) {
            JOptionPane.showMessageDialog(contentPane, "Registration is successful");
            Login login = new Login();
            login.setVisible(true);
            dispose();
          }else {
            JOptionPane.showMessageDialog(contentPane, "Password must be more than 8 characters");
            txtEmail.setText("");
            textPwd.setText("");
          }
          
        }else {
          JOptionPane.showMessageDialog(contentPane, "please enter a valid email");
          txtEmail.setText("");
          textPwd.setText("");
        }
      }
    });
    btnRegister.setBounds(267, 261, 121, 33);
    contentPane.add(btnRegister);
    
    JButton button = new JButton("<<back");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Login login = new Login();
        login.setVisible(true);
        dispose();
      }
    });
    button.setBounds(52, 263, 115, 29);
    contentPane.add(button);
  }

}
