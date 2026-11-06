package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCar extends JFrame implements ActionListener{
    
    JTextField brname, number, id, insurence;
    JComboBox type;
    JButton addb, clear, back;
    
    AddCar(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addcar.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 200, 200);
        add(image);
        
        JLabel t1 = new JLabel("Brand Name :");
        t1.setBounds(20, 20, 140, 30);
        t1.setFont(new Font("Raleway", Font.BOLD, 18));
        add(t1);
        
        brname = new JTextField();
        brname.setBounds(190, 20, 155, 30);
        brname.setFont(new Font("Arial", Font.PLAIN, 15));
        add(brname);
        
        JLabel t2 = new JLabel("Car Type :");
        t2.setBounds(20, 70, 140, 30);
        t2.setFont(new Font("Raleway", Font.BOLD, 18));
        add(t2);
        
        String st[] = {"SUV", "Sedan", "VAN", "EV"};
        type = new JComboBox(st);
        type.setBounds(190, 70, 155, 30);
        type.setFont(new Font("Arial", Font.PLAIN, 15));
        type.setBackground(Color.WHITE);
        add(type);
        
        JLabel t3 = new JLabel("Number :");
        t3.setBounds(20, 120, 140, 30);
        t3.setFont(new Font("Raleway", Font.BOLD, 18));
        add(t3);
        
        number = new JTextField();
        number.setBounds(190, 120, 155, 30);
        number.setFont(new Font("Arial", Font.PLAIN, 15));
        add(number);
        
        JLabel t4 = new JLabel("Insurence Id :");
        t4.setBounds(20, 170, 140, 30);
        t4.setFont(new Font("Raleway", Font.BOLD, 18));
        add(t4);
        
        insurence = new JTextField();
        insurence.setBounds(190, 170, 155, 30);
        insurence.setFont(new Font("Arial", Font.PLAIN, 15));
        add(insurence);
        
        JLabel t5 = new JLabel("Car Id :");
        t5.setBounds(20, 220, 140, 30);
        t5.setFont(new Font("Raleway", Font.BOLD, 18));
        add(t5);
        
        id = new JTextField();
        id.setBounds(190, 220, 155, 30);
        id.setFont(new Font("Arial", Font.PLAIN, 15));
        add(id);
        
        addb = new JButton("ADD");
        addb.setBounds(50, 280, 100, 30);
        addb.setBackground(Color.black);
        addb.setForeground(Color.white);
        addb.setFont(new Font("Arial", Font.BOLD, 15));
        addb.addActionListener(this);
        add(addb);
        
        clear = new JButton("Clear");
        clear.setBounds(200, 280, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.setFont(new Font("Arial", Font.BOLD, 15));
        clear.addActionListener(this);
        add(clear);            
             
        back = new JButton("Back");
        back.setBounds(350, 280, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.addActionListener(this);
        add(back); 
        
        setTitle("Add Car");
        setBounds(400, 200, 600, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){            
            brname.setText("");
            number.setText("");
            id.setText("");
            insurence.setText("");
        }else if(ae.getSource() == back){            
           setVisible(false);
        }else if(ae.getSource() == addb){            
            String brand = brname.getText();
            String carnum = number.getText();
            String carid = id.getText();
            String carinsurence = insurence.getText();
            String cartype = (String)type.getSelectedItem();
            
            if(brand.equals("")) JOptionPane.showMessageDialog(null, "Brand Name can't be empty");
            else if(carnum.equals("")) JOptionPane.showMessageDialog(null, "Car Number can't be empty");
            else if(carid.equals("")) JOptionPane.showMessageDialog(null, "Car ID can't be empty");
            else if(carinsurence.equals("")) JOptionPane.showMessageDialog(null, "Car Insurence Id can't be empty");
            else{
                try{
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into cars values('"+carid+"', '"+brand+"', '"+cartype+"', '"+carnum+"', '"+carinsurence+"', 'Available');");
                    JOptionPane.showMessageDialog(null, "Car Added Successfully...!");
                    setVisible(false);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    
    public static void main(String args[]){
        new AddCar().setVisible(true);
    }
    
}
