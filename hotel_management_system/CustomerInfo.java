package hotel_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.TableColumn;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
      JButton back;
      
    CustomerInfo(){
                     
        JLabel t1 = new JLabel("Name");
        t1.setBounds(20, 8, 75, 30);
        t1.setFont(new Font("Arial", Font.BOLD, 16));
        add(t1);
        
        JLabel t2 = new JLabel("ID Name");
        t2.setBounds(140, 8, 75, 30);
        t2.setFont(new Font("Arial", Font.BOLD, 16));
        add(t2);
        
        JLabel t3 = new JLabel("ID NO");
        t3.setBounds(280, 8, 75, 30);
        t3.setFont(new Font("Arial", Font.BOLD, 16));
        add(t3);
        
        JLabel t4 = new JLabel("Gender");
        t4.setBounds(380, 8, 75, 30);
        t4.setFont(new Font("Arial", Font.BOLD, 16));
        add(t4);
                
        JLabel t5 = new JLabel("Country");
        t5.setBounds(500, 8, 75, 30);
        t5.setFont(new Font("Arial", Font.BOLD, 16));
        add(t5);
        
        JLabel t6 = new JLabel("Religion");
        t6.setBounds(620, 8, 75, 30);
        t6.setFont(new Font("Arial", Font.BOLD, 16));
        add(t6);
        
        JLabel t7 = new JLabel("Room No");
        t7.setBounds(725, 8, 85, 30);
        t7.setFont(new Font("Arial", Font.BOLD, 16));
        add(t7);
        
        JLabel t8 = new JLabel("Checkin Time");
        t8.setBounds(840, 8, 125, 30);
        t8.setFont(new Font("Arial", Font.BOLD, 16));
        add(t8);
        
        JLabel t9 = new JLabel("Deposite");
        t9.setBounds(1030, 8, 75, 30);
        t9.setFont(new Font("Arial", Font.BOLD, 16));
        add(t9);
        
        JLabel t10 = new JLabel("Phone No");
        t10.setBounds(1130, 8, 100, 30);
        t10.setFont(new Font("Arial", Font.BOLD, 16));
        add(t10);
        
        JLabel t11 = new JLabel("Customer ID");
        t11.setBounds(1250, 8, 100, 30);
        t11.setFont(new Font("Arial", Font.BOLD, 16));
        add(t11);
                     
        JTable tabel = new JTable();
        tabel.setBounds(0, 45, 1380, 450);
        tabel.setFont(new Font("Arial", Font.ROMAN_BASELINE, 13));
        add(tabel);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer;");
            tabel.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.println(e);
        }
        
        TableColumn col = null;
        int totalCols = tabel.getColumnModel().getColumnCount();
        for (int i = 0; i < Math.min(10, totalCols); i++){
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
        
        setTitle("Customer Information");
        setBounds(600, 100, 1380, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new CustomerInfo().setVisible(true);
    }
    
}
