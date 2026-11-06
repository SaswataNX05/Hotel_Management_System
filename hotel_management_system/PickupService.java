package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PickupService extends JFrame implements ActionListener{
    
    JTextField loc, des, rent, duration ;
    Choice drv, car;
    JButton book, clear, back;
    
    PickupService(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addcar.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 200, 200);
        add(image);
        
        JLabel t1 = new JLabel("Pick-Up Service");
        t1.setBounds(110, 20, 250, 30);
        t1.setFont(new Font("Raleway", Font.BOLD, 26));
        t1.setForeground(Color.BLUE);
        add(t1);
             
        
        JLabel t2 = new JLabel("Driver Id :");
        t2.setBounds(20, 80, 140, 30);
        t2.setFont(new Font("Raleway", Font.BOLD, 18));
        add(t2);
               
        drv = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver;");
            while(rs.next()){
                drv.add(rs.getString("id"));
            }
        }catch(Exception e){
            System.out.print(e);
        }
        drv.setBounds(190, 80, 155, 30);
        drv.setFont(new Font("Arial", Font.PLAIN, 15));
        drv.setBackground(Color.WHITE);
        add(drv);
        
        JLabel t3 = new JLabel("Car ID :");
        t3.setBounds(20, 130, 140, 30);
        t3.setFont(new Font("Raleway", Font.BOLD, 18));
        add(t3);
        
        car = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from cars where availability = 'Available';");
            while(rs.next()){
                car.add(rs.getString("car_id"));
            }
        }catch(Exception e){
            System.out.print(e);
        }
        car.setBounds(190, 130, 155, 30);
        car.setFont(new Font("Arial", Font.PLAIN, 15));
        car.setBackground(Color.WHITE);
        add(car);
        
        JLabel t4 = new JLabel("Pick-Up Location :");
        t4.setBounds(20, 180, 170, 30);
        t4.setFont(new Font("Raleway", Font.BOLD, 18));
        add(t4);
        
        loc = new JTextField();
        loc.setBounds(190, 180, 155, 30);
        loc.setFont(new Font("Arial", Font.PLAIN, 15));
        add(loc);
        
        JLabel t5 = new JLabel("Destination:");
        t5.setBounds(20, 230, 140, 30);
        t5.setFont(new Font("Raleway", Font.BOLD, 18));
        add(t5);
        
        des = new JTextField();
        des.setBounds(190, 230, 155, 30);
        des.setFont(new Font("Arial", Font.PLAIN, 15));
        add(des);

        JLabel t6 = new JLabel("Duration:");
        t6.setBounds(20, 280, 140, 30);
        t6.setFont(new Font("Raleway", Font.BOLD, 18));
        add(t6);

        duration = new JTextField();
        duration.setBounds(190, 280, 155, 30);
        duration.setFont(new Font("Arial", Font.PLAIN, 15));
        add(duration);
        
        JLabel t7 = new JLabel("Rent:");
        t7.setBounds(20, 330, 140, 30);
        t7.setFont(new Font("Raleway", Font.BOLD, 18));
        add(t7);
        
        rent = new JTextField();
        rent.setBounds(190, 330, 155, 30);
        rent.setFont(new Font("Arial", Font.PLAIN, 15));
        add(rent);
        
        book = new JButton("BOOK");
        book.setBounds(50, 390, 100, 30);
        book.setBackground(Color.black);
        book.setForeground(Color.white);
        book.setFont(new Font("Arial", Font.BOLD, 15));
        book.addActionListener(this);
        add(book);
        
        clear = new JButton("Clear");
        clear.setBounds(200, 390, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.setFont(new Font("Arial", Font.BOLD, 15));
        clear.addActionListener(this);
        add(clear);            
             
        back = new JButton("Back");
        back.setBounds(350, 390, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.addActionListener(this);
        add(back); 
        
        setTitle("Pick Up Service");
        setBounds(600, 200, 600, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){            
            loc.setText("");
            des.setText("");
            rent.setText("");           
        }else if(ae.getSource() == back){            
           setVisible(false);
        }else if(ae.getSource() == book){            
            String location = loc.getText();
            String destination = des.getText();
            String rentt = rent.getText();         
            String drvid = (String)drv.getSelectedItem();
            String carid = (String)car.getSelectedItem();
            String dura = duration.getText();
            
            if(drvid == null || carid == null) JOptionPane.showMessageDialog(null, "No Driver or Car available");
            else if(location.equals("")) JOptionPane.showMessageDialog(null, "Pick-Up Location can't be empty");
            else if(destination.equals("")) JOptionPane.showMessageDialog(null, "Destination can't be empty");
            else if(rentt.equals("")) JOptionPane.showMessageDialog(null, "Car Rent can't be empty");
            else if(dura.equals("")) JOptionPane.showMessageDialog(null, "The Trip must have a duration");
            else{
                Payment p = new Payment();
                String rt = p.Payment(rentt);
                if("true".equals(rt)){                           
                    try{
                        Conn c = new Conn();
                        float dur = Float.parseFloat(dura);
                        c.s.executeUpdate("insert into pickup_service values('"+drvid+"', '"+carid+"', '"+location+"', '"+destination+"', '"+rentt+"', '"+dur+"');");
                        c.s.executeUpdate("update cars set availability = 'Engaged' where car_id = '"+carid+"';");
                        c.s.executeUpdate("create event realese_"+carid+" on schedule at CURRENT_TIMESTAMP + INTERVAL "+dur+" minute on completion not preserve do update cars set availability = 'Available' where car_id = '"+carid+"';");
                        JOptionPane.showMessageDialog(null, "Pick-Up Service Booked Successfully...!");
                        setVisible(false);
                    }catch(Exception e){
                        System.out.println(e);
                    }            
                }else{
                    JOptionPane.showMessageDialog(null, "Payment Not Done..!");
                }
            }                       
        }
    }
    
    public static void main(String args[]){
        new PickupService().setVisible(true);
    }
    
}
