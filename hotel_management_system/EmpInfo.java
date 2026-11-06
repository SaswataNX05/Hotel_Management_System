package hotel_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.TableColumn;
import net.proteanit.sql.*;

public class EmpInfo extends JFrame implements ActionListener{
      JButton back;
      
    EmpInfo(){
                     
        JLabel t1 = new JLabel("Emp_ID");
        t1.setBounds(20, 8, 75, 30);
        t1.setFont(new Font("Arial", Font.BOLD, 16));
        add(t1);
        
        JLabel t2 = new JLabel("Name");
        t2.setBounds(170, 8, 75, 30);
        t2.setFont(new Font("Arial", Font.BOLD, 16));
        add(t2);
        
        JLabel t3 = new JLabel("Age");
        t3.setBounds(320, 8, 75, 30);
        t3.setFont(new Font("Arial", Font.BOLD, 16));
        add(t3);
        
        JLabel t4 = new JLabel("Gender");
        t4.setBounds(425, 8, 75, 30);
        t4.setFont(new Font("Arial", Font.BOLD, 16));
        add(t4);
                
        JLabel t5 = new JLabel("Job");
        t5.setBounds(565, 8, 75, 30);
        t5.setFont(new Font("Arial", Font.BOLD, 16));
        add(t5);
        
        JLabel t6 = new JLabel("Salary");
        t6.setBounds(680, 8, 75, 30);
        t6.setFont(new Font("Arial", Font.BOLD, 16));
        add(t6);
        
        JLabel t7 = new JLabel("Phone No");
        t7.setBounds(775, 8, 85, 30);
        t7.setFont(new Font("Arial", Font.BOLD, 16));
        add(t7);
        
        JLabel t8 = new JLabel("Email ID");
        t8.setBounds(940, 8, 95, 30);
        t8.setFont(new Font("Arial", Font.BOLD, 16));
        add(t8);
        
        JLabel t9 = new JLabel("Adhar");
        t9.setBounds(1115, 8, 75, 30);
        t9.setFont(new Font("Arial", Font.BOLD, 16));
        add(t9);
                     
        JTable tabel = new JTable();
        tabel.setBounds(0, 45, 1200, 450);
        tabel.setFont(new Font("Arial", Font.ROMAN_BASELINE, 13));
        add(tabel);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            tabel.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.println(e);
        }
        
        TableColumn col = null;
        int totalCols = tabel.getColumnModel().getColumnCount();
        for (int i = 0; i < Math.min(9, totalCols); i++){
            col = tabel.getColumnModel().getColumn(i);
            if(i == 1) col.setPreferredWidth(75);  
            else if( i == 4) col.setPreferredWidth(50); 
            else if( i == 7) col.setPreferredWidth(120); 
            else col.setPreferredWidth(20); 
            
        }
        
        back = new JButton("Back");
        back.setBounds(550, 500, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);
        
        setTitle("Employe Information");
        setBounds(600, 200, 1200, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new EmpInfo().setVisible(true);
    }
    
}
