package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;


public class Login extends JFrame implements ActionListener {
    JTextField userfield;
    JPasswordField passfield;
    JButton login, cancel;
    Login() {
        getContentPane().setBackground(Color.white);
        setBounds(500, 200, 600, 300);
        setLayout(null);
        JLabel user = new JLabel("UserName");
        user.setBounds(40, 20, 100, 30);
        add(user);

        userfield = new JTextField();
        userfield.setBounds(150, 20, 150, 30);
        add(userfield);
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);
        passfield = new JPasswordField();
        passfield.setBounds(150, 70, 150, 30);
        add(passfield);

        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.yellow);
        login.setForeground(Color.blue);
        login.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.blue);
        cancel.addActionListener(this);
        add(cancel);

        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setVisible(true);
    }

        public static void main(String[] args){
            new Login();
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login){
            try {
                conn c = new conn();
                String user = userfield.getText();
                String pass = passfield.getText();
                String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()) {
                    setVisible(false);
                    new Dashboard();

                }
                else{

                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");

                    setVisible(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }   else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
}