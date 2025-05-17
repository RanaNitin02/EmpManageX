package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField; 
    JButton loginButton, backButton;

    Login() {
        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);

        usernameField = new JTextField();
        usernameField.setBounds(150, 20, 150, 30);
        add(usernameField);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        add(passwordField);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(150, 140, 150, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);

        backButton = new JButton("BACK");
        backButton.setBounds(150, 180, 150, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);


        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel bgImage = new JLabel(i33);
        bgImage.setBounds(350, 10, 600, 400);
        add(bgImage);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 600, 300);
        add(image);


        setSize(600, 300);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            try{

                String username = usernameField.getText();
                String password = passwordField.getText();

                Conn conn = new Conn();

                String query = "select * from login where username = '"+ username +"' and password = '"+ password +"'";

                ResultSet resultSet = conn.statement.executeQuery(query);

                if(resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            }catch(Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == backButton) {
            System.exit(90);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}