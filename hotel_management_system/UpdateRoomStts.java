package hotel_management_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateRoomStts extends JFrame implements ActionListener{
    
    JTextField cusbox;
    JComboBox aval, cleaned;
    Choice roomno;
    JButton update, back;
    
    UpdateRoomStts(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/rooms.jpg"));
        Image i2 = i1.getImage().getScaledInstance(520, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 520, 350);
        add(image);
        
        JLabel custumer = new JLabel("Update Room Status");
        custumer.setBounds(40, 20, 290, 50);
        custumer.setFont(new Font("Raleway", Font.BOLD, 25));
        custumer.setForeground(Color.BLUE);
        add(custumer);
       
        
        JLabel cus = new JLabel("Customer ID");
        cus.setBounds(40, 85, 150, 30);
        cus.setFont(new Font("Raleway", Font.BOLD, 20));
        add(cus);
        
        cusbox = new JTextField();
        cusbox.setBounds(220, 85, 200, 30);
        cusbox.setFont(new Font("Arial", Font.PLAIN, 14));
        add(cusbox);
        
        JLabel RoomNo = new JLabel("Room No");
        RoomNo.setBounds(40, 145, 150, 30);
        RoomNo.setFont(new Font("Raleway", Font.BOLD, 20));
        add(RoomNo);
        
        roomno = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room;");
            while(rs.next()){
                roomno.add(rs.getString("room_number"));
            }           
        }catch(Exception e){
            System.out.println(e);
        }
        
        roomno.setBounds(220, 145, 200, 30);
        roomno.setFont(new Font("Arial", Font.PLAIN, 14));
        roomno.setBackground(Color.white);
        add(roomno);              
        
        JLabel ava = new JLabel("Availability");
        ava.setBounds(40, 205, 150, 30);
        ava.setFont(new Font("Raleway", Font.BOLD, 20));
        add(ava);
        
        String st1[] = {"Available", "Not Available", "Occupied"};
        aval = new JComboBox(st1);
        aval.setBounds(220, 205, 200, 30);
        aval.setFont(new Font("Arial", Font.PLAIN, 14));
        aval.setBackground(Color.white);
        add(aval);
        
        JLabel clean = new JLabel("Clean Status");
        clean.setBounds(40, 265, 150, 30);
        clean.setFont(new Font("Raleway", Font.BOLD, 20));
        add(clean);
        
        String st2[] = {"Cleaned", "Not Cleaned"};
        cleaned = new JComboBox(st2);
        cleaned.setBounds(220, 265, 200, 30);
        cleaned.setFont(new Font("Arial", Font.PLAIN, 14));
        cleaned.setBackground(Color.white);
        add(cleaned);
        
        update = new JButton("Update Room");
        update.setBounds(50, 350, 150, 30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setFont(new Font("Arial", Font.BOLD, 15));
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(250, 350, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);
        
        setTitle("Update Room Status");
        setBounds(500, 200, 1000, 450);
        getContentPane().setBackground(Color.white);   
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }else if(ae.getSource() == update){
            String cus = cusbox.getText();
            String avalability = (String)aval.getSelectedItem();
            String clean = (String)cleaned.getSelectedItem();
            String room = (String)roomno.getSelectedItem();                           
            if (room == null || room.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No room selected..!");
                return;
            }
            try{
                Conn c = new Conn();
               
                if (cus.equals("")){
                    String st = "update room set availability = '"+avalability+"', clean_sts = '"+clean+"' where room_number = '"+room+"';";
                    c.s.executeUpdate(st);                     
                    JOptionPane.showMessageDialog(null, "Room Updated Successfully..!");  
                    setVisible(false); 
                }else{
                    
                    ResultSet rs = c.s.executeQuery("select * from customer where customer_id = '"+cus+"';");
                    if(rs.next()){
                        String st = "update room set availability = '"+avalability+"', clean_sts = '"+clean+"' where room_number = '"+room+"';";
                        c.s.executeUpdate(st);
                        String st1 = "update customer set room_no = '"+room+"' where customer_id = '"+cus+"';";
                        c.s.executeUpdate(st1);
                        JOptionPane.showMessageDialog(null, "Room Updated Successfully..!");  
                        setVisible(false); 
                    }else{
                        JOptionPane.showMessageDialog(null, "Room Updation Failed..!\nCustomer ID don't exist..!");           
                    }                                      
                }                                                                               
            }catch(Exception e){
                System.out.println(e);
            }
        }        
       
    }
    
    public static void main(String args[]){
        new UpdateRoomStts().setVisible(true);
    }
    
}
