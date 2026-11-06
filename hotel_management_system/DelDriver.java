package hotel_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class DelDriver extends JFrame implements ActionListener {
    
    JTextField id;
    JPasswordField password;
    JButton search, cancel;
    
    DelDriver(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/deldriver.png"));
        Image i2 = i1.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(390,30, 170, 170);
        add(image);
        
        JLabel drvid = new JLabel("Driver Id :");
        drvid.setBounds(50, 30, 200, 40);
        drvid.setFont(new Font("Arial", Font.BOLD, 15));
        add(drvid);
        
        id = new JTextField();
        id.setBounds(190, 35, 150, 30);
        id.setFont(new Font("Raleway", Font.BOLD, 15));
        add(id);
        
        JLabel pass = new JLabel("Password :");
        pass.setBounds(50, 90, 100, 40);
        pass.setFont(new Font("Arial", Font.BOLD, 15));
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(190, 95, 150, 30);
        password.setFont(new Font("Raleway", Font.BOLD, 15));
        add(password);
        
        search = new JButton("Delete");
        search.setBounds(60, 170, 100, 30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 170, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        setLayout(null);
        setTitle("Delete Driver");
        setBounds(500, 300, 600, 300);
        setLocation(400, 200);
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
        String did = id.getText();
        String pass = new String(password.getPassword());
        
        if(ae.getSource() == cancel){
            setVisible(false);
        }else if(ae.getSource() == search){
            if(did.equals("") || pass.equals("")){
                JOptionPane.showMessageDialog(null, "Driver Id Or Password Can't be Empty");
            }else{
                try{
                    
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from  login where user_password = '"+pass+"'");
                    if(rs.next()){
                        ResultSet rrs = c.s.executeQuery("select * from driver where id = '"+did+"'");
                        if(rrs.next()){
                            c.s.executeUpdate("delete from driver where id = '"+did+"'");
                            JOptionPane.showMessageDialog(null, "Driver ID - "+did+" has been successfully deleted..!");
                            setVisible(false);
                        }else{
                            JOptionPane.showMessageDialog(null, "Driver ID - "+did+" not found..!");
                            id.setText("");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Wrong Password...!");
                        password.setText("");
                    }
                    
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    
    public static void main(String args[]){
        new DelDriver().setVisible(true);
    }
}
