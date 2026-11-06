package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HotelManagementSystem extends JFrame implements ActionListener{
    
    JButton next;
    
    HotelManagementSystem(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1700, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1700, 900);
        add(image);
 
        
        JLabel text = new JLabel("SB GROUP'S HOTEL MANAGEMENT SYSTEM");
        text.setBounds(100, 50, 1200, 100);
        text.setFont(new Font("serif", Font.BOLD, 48));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JLabel arr = new JLabel("→");
        arr.setBounds(1478, 755, 100, 100);
        arr.setFont(new Font("Arial", Font.BOLD, 55));
        arr.setForeground(Color.WHITE);
        image.add(arr);
        
        JLabel text2 = new JLabel("WHERE EVERYDAY STAY FEELS LIKE GETAWAY");
        text2.setBounds(100, 120, 1200, 100);
        text2.setFont(new Font("serif", Font.BOLD, 44));
        text2.setForeground(Color.WHITE);
        image.add(text2);
        
        JLabel text3 = new JLabel("WELCOMES YOU!  ");
        text3.setBounds(100, 190, 1200, 100);
        text3.setFont(new Font("serif", Font.BOLD, 44));
        text3.setForeground(Color.WHITE);
        image.add(text3);
        
        next = new JButton("NEXT");
        next.setBounds(1550, 775, 120, 70);
        next.setFont(new Font("Raleway", Font.BOLD, 22));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLUE);
        next.addActionListener(this);
        image.add(next);
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1700, 900);
        setLocation(100, 80);
        //setVisible(true);
        
        while(isVisible()){
            arr.setVisible(true);
            text.setVisible(true);
            text2.setVisible(false);
            text3.setVisible(false);
            try{
               Thread.sleep(1500);
            }catch(Exception e){
                e.printStackTrace();
            }
            if(!isVisible()) break;
            arr.setVisible(false);
            text.setVisible(false);
            text2.setVisible(true);
            text3.setVisible(false);
            try{
               Thread.sleep(1500);
            }catch(Exception e){
                e.printStackTrace();
            }
            if(!isVisible()) break;
            arr.setVisible(true);
            text.setVisible(false);
            text2.setVisible(false);
            text3.setVisible(true);
            try{
               Thread.sleep(1500);
            }catch(Exception e){
                e.printStackTrace();
            }
            if(!isVisible()) break;
            arr.setVisible(false);
            text.setVisible(false);
            text2.setVisible(false);
            text3.setVisible(false);
            try{
               Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
 
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new HotelManagementSystem().setVisible(true);
    }
    
}
