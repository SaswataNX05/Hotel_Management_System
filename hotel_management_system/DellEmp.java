package hotel_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class DellEmp extends JFrame implements ActionListener{
    
    JTextField empid ;
    JPasswordField password;
    JButton search, cancel;
    
    DellEmp(){
        
        setTitle("Delete Employe");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delemp.png"));
        Image i2 = i1.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(390,30, 170, 170);
        add(image);
        
        JLabel emp = new JLabel("Enter Employe Id");
        emp.setBounds(50, 30, 200, 40);
        emp.setFont(new Font("Arial", Font.BOLD, 15));
        add(emp);
        
        empid = new JTextField();
        empid.setBounds(200, 35, 150, 30);
        empid.setFont(new Font("Raleway", Font.BOLD, 15));
        add(empid);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(50, 90, 100, 40);
        pass.setFont(new Font("Arial", Font.BOLD, 15));
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(200, 95, 150, 30);
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
           
        
        setBounds(500, 300, 600, 300);
        setLocation(400, 200);
        getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent ae){
        String EmpId = empid.getText();
        String Pass = new String(password.getPassword());
        
        if(ae.getSource() == cancel){
            setVisible(false);          
        }else if(ae.getSource() == search){
            if(EmpId.equals("") || Pass.equals("")){
                JOptionPane.showMessageDialog(null, "Must fill up Employee ID AND Password");
            }else{
                try{
                    Conn c = new Conn();
                    ResultSet rrs = c.s.executeQuery("select * from login where user_password = '"+Pass+"'");
                    if(rrs.next()){
                        ResultSet rs = c.s.executeQuery("select * from employee where id = '"+EmpId+"'"); 
                        if(rs.next()){
                            c.s.executeUpdate("delete from employee where id = '"+EmpId+"'"); 
                            JOptionPane.showMessageDialog(null, "Employee id "+EmpId+" has been successfully deleted..!");
                            setVisible(false);                        
                        }else{
                            JOptionPane.showMessageDialog(null, "Employee id "+EmpId+" not Found..!");
                            empid.setText("");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Password..!");
                        password.setText("");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String args[]){
        new DellEmp().setVisible(true);
    }
}


