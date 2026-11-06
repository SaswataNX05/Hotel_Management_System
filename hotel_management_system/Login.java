package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JTextField user;
    JPasswordField password;
    JButton login, clear;
    
    Login(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(390, 30, 180, 180);
        add(image);
        
        JLabel name = new JLabel("User Name");
        name.setBounds(60, 30, 100, 40);
        name.setFont(new Font("Arial", Font.BOLD, 15));
        add(name);
        
        user = new JTextField();
        user.setBounds(190, 35, 150, 30);
        user.setFont(new Font("Raleway", Font.BOLD, 15));
        add(user);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(60, 90, 100, 40);
        pass.setFont(new Font("Arial", Font.BOLD, 15));
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(190, 95, 150, 30);
        password.setFont(new Font("Raleway", Font.BOLD, 15));
        add(password);
        
        login = new JButton("Login");
        login.setBounds(60, 170, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("Cancel");
        clear.setBounds(220, 170, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        setBounds(500, 300, 600, 300);
        getContentPane().setBackground(Color.WHITE);       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String username = user.getText();
        String word = new String(password.getPassword());
        
        if(ae.getSource() == clear){
            System.exit(0);
        }else if (ae.getSource() == login){
            if(username.equals("") || word.equals("")){
                JOptionPane.showMessageDialog(null, "User Name Or Password can't be Empty");
            }else{
                try{
                    Conn c = new Conn();
                    String qr = "select * from login where user_name = '"+username+"' and user_password = '"+word+"'";
                    System.out.println(qr);
                    ResultSet rs = c.s.executeQuery(qr);
                    if(rs.next()){
                        setVisible(false);
                        new Dashboard().setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect User Name Or Password");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            
        }
    }
    
    public static void main(String args[]){
        new Login().setVisible(true);
    }
}
