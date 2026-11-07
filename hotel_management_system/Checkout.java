package hotel_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
    
    Choice ch;
    JButton payrent, checkout, back;
    String rno, p;
    JLabel roomno, checkin, deposite, payment;
    
    Checkout(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpg"));
        Image i2 = i1.getImage().getScaledInstance(520, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 30, 520, 450);
        add(image);       
        
        JLabel t1 = new JLabel("Check Out");
        t1.setBounds(170, 15, 290, 50);
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setForeground(Color.BLUE);
        add(t1);
        
        JLabel cus = new JLabel("Customer ID");
        cus.setBounds(30, 85, 150, 30);
        cus.setFont(new Font("Raleway", Font.BOLD, 20));
        add(cus);
        
        ch = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer;");
            while(rs.next()){
                ch.add(rs.getString("customer_id"));
            }
        }catch(Exception e){
            System.out.println(e);
        }

        ch.setBounds(210, 85, 150, 30);
        ch.setFont(new Font("Arial", Font.PLAIN, 14));
        ch.setBackground(Color.white);
        add(ch);

        JLabel name = new JLabel("Name: ");
        name.setBounds(30, 145, 150, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        add(name);

        JLabel namespace = new JLabel("");
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer;");
            while(rs.next()){
                namespace.setText(rs.getString("name"));
            }
        }catch(Exception e){
            System.out.println(e);
        }

        namespace.setBounds(210, 145, 220, 30);
        namespace.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(namespace);
        
        JLabel room = new JLabel("Room No  :");
        room.setBounds(30, 205, 150, 30);
        room.setFont(new Font("Raleway", Font.BOLD, 20));
        add(room);
        
        roomno = new JLabel("");
        roomno.setBounds(210, 205, 150, 30);
        roomno.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(roomno);
        
        JLabel chein = new JLabel("Check IN Time :");
        chein.setBounds(30, 265, 170, 30);
        chein.setFont(new Font("Raleway", Font.BOLD, 20));
        add(chein);
        
        checkin = new JLabel("");
        checkin.setBounds(210, 265, 220, 30);
        checkin.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(checkin);
              
        JLabel Chk = new JLabel("Check Out Time :");
        Chk.setBounds(30, 325, 170, 30);
        Chk.setFont(new Font("Raleway", Font.BOLD, 20));
        add(Chk);
        
        Date dd = new Date();
        JLabel chkout = new JLabel("" + dd);
        chkout.setBounds(210, 325, 220, 30);
        chkout.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(chkout);
        
        JLabel pay = new JLabel("Deposited  :");
        pay.setBounds(30, 385, 150, 30);
        pay.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pay);
        
        deposite = new JLabel("");
        deposite.setBounds(210, 385, 150, 30);
        deposite.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(deposite);
        
        JLabel payt = new JLabel("Remaining  :");
        payt.setBounds(30, 445, 150, 30);
        payt.setFont(new Font("Raleway", Font.BOLD, 20));
        add(payt);
        
        payment = new JLabel("");
        payment.setBounds(210, 445, 150, 30);
        payment.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(payment);
        
        ch.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                loadCustomerDetails();
            }
        });
        loadCustomerDetails();
        
        payrent = new JButton("Pay");
        payrent.setBounds(50, 510, 120, 30);
        payrent.setBackground(Color.black);
        payrent.setForeground(Color.white);
        payrent.setFont(new Font("Arial", Font.BOLD, 15));
        payrent.addActionListener(this);
        add(payrent);
        
        checkout = new JButton("Check Out");
        checkout.setBounds(260, 510, 150, 30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setFont(new Font("Arial", Font.BOLD, 15));
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBounds(750, 510, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);
        
        setTitle("Check Out");
        setBounds(500, 200, 1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
    }
    
    private void loadCustomerDetails() {
        String selected = ch.getSelectedItem();
        if (selected == null || selected.isEmpty()) {
            roomno.setText("");
            checkin.setText("");
            deposite.setText("");
            payment.setText("");
            rno = null;
            p = null;
            return;
        }
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where customer_id = '" + selected + "';");
            int dep = 0;
            if (rs.next()) {
                rno = rs.getString("room_no");
                roomno.setText(rno);
                checkin.setText(rs.getString("chekin_time"));
                String depStr = rs.getString("deposite");
                deposite.setText(depStr);
                try {
                    dep = Integer.parseInt(depStr.trim());
                } catch (Exception ex) {
                    dep = 0;
                }
                
                ResultSet rs1 = c.s.executeQuery("select * from room where room_number = '" + rno + "';");
                int total = 0;
                if (rs1.next()) {
                    try {
                        total = Integer.parseInt(rs1.getString("price").trim());
                    } catch (Exception ex) {
                        total = 0;
                    }
                }
                p = String.valueOf(total - dep);
                payment.setText(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }else if(ae.getSource() == checkout){
            if(ch.getSelectedItem() == null || rno == null){
                JOptionPane.showMessageDialog(null, "No customer selected..!");
                return;
            }
            if(p != null && (p.equals("0") || Integer.parseInt(p) <= 0)){
                try{
                Conn c = new Conn();
                c.s.executeUpdate("delete from customer where customer_id = '"+ch.getSelectedItem()+"';");
                c.s.executeUpdate("update room set availability = 'Available', clean_sts = 'Dirty' where room_number = '"+rno+"';");
                JOptionPane.showMessageDialog(null, "Successfully Checked Out..!"); 
                setVisible(false);
                }catch(Exception e){
                    System.out.println(e);
                }
            }else {
                JOptionPane.showMessageDialog(null, "Payment Not Done..!");
            }
            
        }else if(ae.getSource() == payrent){
            Payment pp = new Payment();
            String rt = pp.Payment(p);
            if("true".equals(rt)){
                payment.setText("0");
                p = "0";
            }
        }
    }
    
    public static void main(String args[]){
        new Checkout().setVisible(true);
    }
    
}