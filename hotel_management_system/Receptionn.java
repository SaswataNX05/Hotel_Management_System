package hotel_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Receptionn extends JFrame implements ActionListener{
    
    JButton customer_form, room_status, all_emp, customer_info, manager_info, checkouts;
    JButton update_status, pickupservice, department, logout, driver_info;
    
    Receptionn(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/recep.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(200, 0, 800, 600);
        add(image);
        
        JLabel t1 = new JLabel("HOTEL");
        t1.setBounds(350, 370, 300, 100);
        t1.setFont(new Font("Arial", Font.BOLD, 35));
        t1.setForeground(Color.DARK_GRAY);
        image.add(t1);
        
        JLabel t2 = new JLabel("RECEPTION");
        t2.setBounds(310, 415, 300, 100);
        t2.setFont(new Font("Arial", Font.BOLD, 35));
        t2.setForeground(Color.DARK_GRAY);
        image.add(t2);
        
        customer_form = new JButton("Customer Form");
        customer_form.setBounds(10, 10, 180, 30);
        customer_form.setBackground(Color.BLACK);
        customer_form.setForeground(Color.WHITE);
        customer_form.addActionListener(this);
        add(customer_form);
        
        customer_info = new JButton("Customer Info");
        customer_info.setBounds(10, 60, 180, 30);
        customer_info.setBackground(Color.BLACK);
        customer_info.setForeground(Color.WHITE);
        customer_info.addActionListener(this);
        add(customer_info);
        
        room_status = new JButton("Room Status");
        room_status.setBounds(10, 110, 180, 30);
        room_status.setBackground(Color.BLACK);
        room_status.setForeground(Color.WHITE);
        room_status.addActionListener(this);
        add(room_status);
        
        update_status = new JButton("Update Room Status");
        update_status.setBounds(10, 160, 180, 30);
        update_status.setBackground(Color.BLACK);
        update_status.setForeground(Color.WHITE);
        update_status.addActionListener(this);
        add(update_status);
        
        checkouts = new JButton("Check Out");
        checkouts.setBounds(10, 210, 180, 30);
        checkouts.setBackground(Color.BLACK);
        checkouts.setForeground(Color.WHITE);
        checkouts.addActionListener(this);
        add(checkouts);
        
        all_emp = new JButton("Employee Info");
        all_emp.setBounds(10, 260, 180, 30);
        all_emp.setBackground(Color.BLACK);
        all_emp.setForeground(Color.WHITE);
        all_emp.addActionListener(this);
        add(all_emp);
        
        manager_info = new JButton("Manager Info");
        manager_info.setBounds(10, 310, 180, 30);
        manager_info.setBackground(Color.BLACK);
        manager_info.setForeground(Color.WHITE);
        manager_info.addActionListener(this);
        add(manager_info);
        
        driver_info = new JButton("Driver Info");
        driver_info.setBounds(10, 360, 180, 30);
        driver_info.setBackground(Color.BLACK);
        driver_info.setForeground(Color.WHITE);
        driver_info.addActionListener(this);
        add(driver_info);
        
        pickupservice = new JButton("Pick-Up Service");
        pickupservice.setBounds(10, 410, 180, 30);
        pickupservice.setBackground(Color.BLACK);
        pickupservice.setForeground(Color.WHITE);
        pickupservice.addActionListener(this);
        add(pickupservice);
        
        department = new JButton("Department");
        department.setBounds(10, 460, 180, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
        
        logout = new JButton("Logout");
        logout.setBounds(10, 510, 180, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        setTitle("Reception");
        setBounds(400, 100, 1000, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == logout){
            setVisible(false);
            System.exit(0);
        }else if (ae.getSource() == customer_form){
            new CustomerForm().setVisible(true);
        }else if (ae.getSource() == room_status){
            new RoomStatus().setVisible(true);
        }else if (ae.getSource() == all_emp){
            new EmpInfo().setVisible(true);
        }else if (ae.getSource() == driver_info){   
            new DriverInfo().setVisible(true);
        }else if (ae.getSource() == manager_info){
            new ManagerInfo().setVisible(true);
        }else if (ae.getSource() == customer_info){
            new CustomerInfo().setVisible(true);
        }else if (ae.getSource() == update_status){
            new UpdateRoomStts().setVisible(true);
        }else if (ae.getSource() == checkouts){
            new Checkout().setVisible(true);
        }else if (ae.getSource() == pickupservice){
            new PickupService().setVisible(true);
        }
    }
    
    public static void main (String args[]){
        new Receptionn().setVisible(true);
    }
}
