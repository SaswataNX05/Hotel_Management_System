package hotel_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class RoomStatus extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    JComboBox box;
    JCheckBox chbox;

    RoomStatus(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/roomstts.jpg"));
        Image i2 = i1.getImage().getScaledInstance(710, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(440, 0, 710, 700);
        add(image);
        
        JLabel bed = new JLabel ("Bed Type  :");
        bed.setBounds(5, 15, 95, 30);
        bed.setFont(new Font("Arial", Font.BOLD, 15));
        add(bed);
        
        String st[] = {"Single Bed", "Double Bed", "KingSize Bed", "Triple Bed"};
        box = new JComboBox(st);
        box.setBounds(100, 15, 125, 30);
        box.setFont(new Font("Arial", Font.BOLD, 14));
        box.setBackground(Color.WHITE);
        add(box);
        
        chbox = new JCheckBox("Only Display Available");
        chbox.setBounds(260, 15, 180, 30);
        chbox.setFont(new Font("Arial", Font.BOLD, 13));
        chbox.setBackground(Color.WHITE);
        add(chbox);
        
        JLabel t1 = new JLabel("Room No");
        t1.setBounds(5, 65, 75, 30);
        t1.setFont(new Font("Arial", Font.BOLD, 13));
        add(t1);
        
        JLabel t2 = new JLabel("Availablity");
        t2.setBounds(95, 65, 75, 30);
        t2.setFont(new Font("Arial", Font.BOLD, 13));
        add(t2);
        
        JLabel t3 = new JLabel("Cleanliness");
        t3.setBounds(185, 65, 75, 30);
        t3.setFont(new Font("Arial", Font.BOLD, 13));
        add(t3);
        
        JLabel t4 = new JLabel("Price");
        t4.setBounds(285, 65, 75, 30);
        t4.setFont(new Font("Arial", Font.BOLD, 13));
        add(t4);
                
        JLabel t5 = new JLabel("Bed Type");
        t5.setBounds(365, 65, 75, 30);
        t5.setFont(new Font("Arial", Font.BOLD, 13));
        add(t5);
        
        table = new JTable();
        table.setBounds(0, 100, 440, 450);
        add(table);
        
        try{
            Conn c = new Conn();
            String str = (String)box.getSelectedItem();
                   
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            System.out.print(e);
        }
        
        back = new JButton("Back");
        back.setBounds(190, 620, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);
        
        submit = new JButton("Apply");        
        submit.setBounds(60, 620, 100, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Arial", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);
        
        setTitle("Room Status");
        setBounds(600, 200, 1150, 700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }else if(ae.getSource() == submit){
             try{
            Conn c = new Conn();
            String str = (String)box.getSelectedItem();
            
            if(chbox.isSelected()){            
                ResultSet rs = c.s.executeQuery("select * from room where availability = 'Available' and bed_type = '"+str+"';");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }else{
                 ResultSet rs = c.s.executeQuery("select * from room where bed_type = '"+str+"';");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            
            }catch(Exception e){
                System.out.print(e);
            }
        }
    }
    
    public static void main(String args[]){
        new RoomStatus().setVisible(true);
    }
    
}
