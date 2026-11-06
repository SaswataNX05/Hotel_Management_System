package hotel_management_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JTextField roombox, pricebox;
    JComboBox aval, cleaned, bed;
    JButton add, clear;
    
    AddRooms(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/rooms.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 450, 300);
        add(image);
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(40, 50, 150, 30);
        room.setFont(new Font("Raleway", Font.BOLD, 20));
        add(room);
        
        roombox = new JTextField();
        roombox.setBounds(220, 50, 200, 30);
        roombox.setFont(new Font("Arial", Font.PLAIN, 14));
        add(roombox);
        
        JLabel ava = new JLabel("Availability");
        ava.setBounds(40, 120, 150, 30);
        ava.setFont(new Font("Raleway", Font.BOLD, 20));
        add(ava);
        
        String st1[] = {"Available", "Not Available"};
        aval = new JComboBox(st1);
        aval.setBounds(220, 120, 200, 30);
        aval.setFont(new Font("Arial", Font.PLAIN, 14));
        aval.setBackground(Color.white);
        add(aval);
        
        JLabel clean = new JLabel("Clean Status");
        clean.setBounds(40, 190, 150, 30);
        clean.setFont(new Font("Raleway", Font.BOLD, 20));
        add(clean);
        
        String st2[] = {"Cleaned", "Not Cleaned"};
        cleaned = new JComboBox(st2);
        cleaned.setBounds(220, 190, 200, 30);
        cleaned.setFont(new Font("Arial", Font.PLAIN, 14));
        cleaned.setBackground(Color.white);
        add(cleaned);
        
        JLabel pc = new JLabel("Price");
        pc.setBounds(40, 260, 150, 30);
        pc.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pc);
        
        pricebox = new JTextField();
        pricebox.setBounds(220, 260, 200, 30);
        pricebox.setFont(new Font("Arial", Font.PLAIN, 14));
        add(pricebox);
        
        JLabel bedt = new JLabel("Bed Type");
        bedt.setBounds(40, 330, 150, 30);
        bedt.setFont(new Font("Raleway", Font.BOLD, 20));
        add(bedt);
        
        String st3[] = {"Single Bed", "Double Bed", "KingSize Bed", "Triple Bed"};
        bed = new JComboBox(st3);
        bed.setBounds(220, 330, 200, 30);
        bed.setFont(new Font("Arial", Font.PLAIN, 14));
        bed.setBackground(Color.white);
        add(bed);
        
        add = new JButton("Add Room");
        add.setBounds(550, 400, 120, 30);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setFont(new Font("Arial", Font.BOLD, 15));
        add.addActionListener(this);
        add(add);
        
        clear = new JButton("Clear");
        clear.setBounds(750, 400, 120, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.setFont(new Font("Arial", Font.BOLD, 15));
        clear.addActionListener(this);
        add(clear);
        
        setTitle("ADD ROOMS");
        setBounds(420, 200, 1000, 500);
        getContentPane().setBackground(Color.white);   
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            roombox.setText("");
            pricebox.setText("");           
        }else if(ae.getSource() == add){
            String room = roombox.getText();
            String avalability = (String)aval.getSelectedItem();
            String clean = (String)cleaned.getSelectedItem();
            String price = pricebox.getText();
            String bedtype = (String)bed.getSelectedItem();
            
            if(room.equals("")) JOptionPane.showMessageDialog(null, "Room Number Can't Be Empty");
            else if(price.equals("")) JOptionPane.showMessageDialog(null, "Price Can't Be Empty");
            else{
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from room where room_number = '" + room + "';");
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Room Number already exists!");
                    } else {
                        String st = "insert into room values ('"+room+"', '"+avalability+"', '"+clean+"', '"+price+"','"+bedtype+"')" ;
                        c.s.executeUpdate(st);
                        JOptionPane.showMessageDialog(null, "Room Successfully added..!");
                        setVisible(false);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        
       
    }
    
    public static void main(String args[]){
        new AddRooms().setVisible(true);
    }
    
}
