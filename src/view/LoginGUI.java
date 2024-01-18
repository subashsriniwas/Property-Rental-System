package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI {

    // private member variables for the GUI components

    private JLabel userLabel;
    private JTextField usernameText;
    private JLabel passwordLabel;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JButton guestButton;
    private JButton registerButton;
    private JLabel userTypeLabel;
    private JComboBox userType;

    String[] userTypes = {"Renter", "Landlord", "Manager"};

    /** 
    * Constructor for the LoginGUI. Creates the GUI and displays it to the user.
    */
    public LoginGUI(){

        // initialize the GUI components and display them on screen
        JFrame frame = new JFrame("Welcome");
        JPanel loginPanel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(loginPanel);   
        loginPanel.setLayout(null);

        userTypeLabel = new JLabel("User Type:");
        userTypeLabel.setBounds(10, 20, 80, 25);
        loginPanel.add(userTypeLabel);        

        userType = new JComboBox(userTypes);
        userType.setBounds(100, 20, 200, 25);
        loginPanel.add(userType);        

        userLabel = new JLabel("Email:");
        userLabel.setBounds(10, 50, 80, 25);
        loginPanel.add(userLabel);

        usernameText = new JTextField(20); 
        usernameText.setBounds(100, 50, 200, 25);
        loginPanel.add(usernameText);
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 80, 80, 25);
        loginPanel.add(passwordLabel);

        passwordText = new JPasswordField(20); 
        passwordText.setBounds(100, 80, 200, 25);
        loginPanel.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 110, 90, 25);
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String email = usernameText.getText();
                String password = String.valueOf(passwordText.getPassword());
                String userLoginType = userType.getSelectedItem().toString();
                Boolean authenticated = false;
                authenticated = Driver.authenticateLogin(userLoginType, email, password);
                if(authenticated == true){
                    if(userLoginType.equals("Renter")){
                        Driver.renterLoginButtonPressed(email);
                    }
                    else if(userLoginType.equals("Landlord")){
                        Driver.landlordLoginButtonPressed(email);
                    }
                    else if(userLoginType.equals("Manager")){
                        Driver.managerLoginButtonPressed();
                    }
                    frame.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Invalid login. Please try again.");
                }
            }
        });
        loginPanel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(210, 110, 90, 25);
        registerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Driver.registerButtonPressed();
                frame.dispose();
            }
        });
        loginPanel.add(registerButton);        

        guestButton = new JButton("Continue as guest");
        guestButton.setBounds(100, 140, 200, 25);
        guestButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Driver.guestButtonPressed();
                frame.dispose();
            }
        });   
        loginPanel.add(guestButton);             

        frame.setContentPane(loginPanel); 
        frame.setVisible(true);
    }       
}
