package hotel_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JMenuItem addemp, adddriver, addrooms, delemp, deldriver, reception, addcar;
    
    Dashboard(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1940, 1050, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1940, 1050);
        add(image);
        
        JLabel text = new JLabel("SB Group Welcomes You");
        text.setBounds(650, 80, 700, 60);
        text.setFont(new Font("serif", Font.BOLD, 55));
        text.setForeground(Color.white);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1940, 30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setFont(new Font("Arial", Font.BOLD, 15));
        hotel.setForeground(Color.red);
        mb.add(hotel);
        
        reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setFont(new Font("Arial", Font.BOLD, 15));
        admin.setForeground(Color.blue);
        mb.add(admin);
        
        addemp = new JMenuItem("ADD EMPLOYEE");
        addemp.addActionListener(this);
        admin.add(addemp);
        
        addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        adddriver = new JMenuItem("ADD DRIVER");
        adddriver.addActionListener(this);
        admin.add(adddriver);
        
        addcar = new JMenuItem("ADD CAR");
        addcar.addActionListener(this);
        admin.add(addcar);
        
        delemp = new JMenuItem("REMOVE EMPLOYEE");
        delemp.addActionListener(this);
        admin.add(delemp);
        
        
        deldriver = new JMenuItem("REMOVE DRIVER");
        deldriver.addActionListener(this);
        admin.add(deldriver);     
        
        JMenu adminmagement = new JMenu("ADMIN MANAGEMENT");
        adminmagement.setFont(new Font("Arial", Font.BOLD, 15));
        adminmagement.setForeground(Color.magenta);
        mb.add(adminmagement);
        
        JMenuItem addadmin = new JMenuItem("ADD ADMIN");
        adminmagement.add(addadmin);
        
        JMenuItem deladmin = new JMenuItem("REMOVE ADMIN");
        adminmagement.add(deladmin);
        
        
        setBounds(0, 0, 1900, 1080);      
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addemp){
            new AddEmp().setVisible(true);
        }else if(ae.getSource() == adddriver){
            new AddDriver().setVisible(true);
        }else if(ae.getSource() == addrooms){
            new AddRooms().setVisible(true);
        }else if(ae.getSource() == delemp){
            new DellEmp().setVisible(true);
        }else if(ae.getSource() == deldriver){
            new DelDriver().setVisible(true);
        }else if(ae.getSource() == reception){
            new Receptionn().setVisible(true);
        }else if(ae.getSource() == addcar){
            new AddCar().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Dashboard().setVisible(true);
    }
}
