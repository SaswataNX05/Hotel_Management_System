package hotel_management_system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.TableColumn;
import net.proteanit.sql.*;

public class DriverInfo extends JFrame implements ActionListener{
      JButton back;
      
    DriverInfo(){
                     
        JLabel t1 = new JLabel("Driver_ID");
        t1.setBounds(10, 8, 75, 30);
        t1.setFont(new Font("Arial", Font.BOLD, 15));
        add(t1);
        
        JLabel t2 = new JLabel("Name");
        t2.setBounds(140, 8, 75, 30);
        t2.setFont(new Font("Arial", Font.BOLD, 15));
        add(t2);
        
        JLabel t3 = new JLabel("Age");
        t3.setBounds(270, 8, 75, 30);
        t3.setFont(new Font("Arial", Font.BOLD, 15));
        add(t3);
        
        JLabel t4 = new JLabel("Gender");
        t4.setBounds(350, 8, 75, 30);
        t4.setFont(new Font("Arial", Font.BOLD, 15));
        add(t4);
                
        JLabel t5 = new JLabel("Salary");
        t5.setBounds(450, 8, 75, 30);
        t5.setFont(new Font("Arial", Font.BOLD, 15));
        add(t5);
        
        JLabel t6 = new JLabel("Phone No");
        t6.setBounds(530, 8, 75, 30);
        t6.setFont(new Font("Arial", Font.BOLD, 15));
        add(t6);
        
        JLabel t7 = new JLabel("Email ID");
        t7.setBounds(670, 8, 85, 30);
        t7.setFont(new Font("Arial", Font.BOLD, 15));
        add(t7);
        
        JLabel t8 = new JLabel("Adhar");
        t8.setBounds(825, 8, 95, 30);
        t8.setFont(new Font("Arial", Font.BOLD, 15));
        add(t8);
            
                     
        JTable tabel = new JTable();
        tabel.setBounds(0, 40, 900, 450);
        tabel.setFont(new Font("Arial", Font.ROMAN_BASELINE, 13));
        add(tabel);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver;");
            tabel.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.println(e);
        }
        
        TableColumn col = null;
        int totalCols = tabel.getColumnModel().getColumnCount();
        for (int i = 0; i < Math.min(8, totalCols); i++){
            col = tabel.getColumnModel().getColumn(i);
            if(i == 1) col.setPreferredWidth(75); 
            else if( i == 6) col.setPreferredWidth(120); 
            else col.setPreferredWidth(20); 
            
        }
        
        back = new JButton("Back");
        back.setBounds(425, 500, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);
        
        setTitle("Driver Information");
        setBounds(600, 200, 900, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new DriverInfo().setVisible(true);
    }
    
}
