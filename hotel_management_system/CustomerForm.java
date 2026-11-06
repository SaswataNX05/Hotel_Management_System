package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.util.Random;

public class CustomerForm extends JFrame implements ActionListener{
    
    JTextField namebox, idnumbox, conbox, rellbox, depbox, phnobox; 
    JComboBox idbox;
    JRadioButton male, female;
    ButtonGroup genderGroup;
    JButton book, clear, back;
    Choice roombox;
    String datee;
    
    CustomerForm(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/customer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(485, 50, 500, 500);
        add(image);
        
        JLabel t1 = new JLabel("NEW  CUSTOMER");
        t1.setBounds(300, 25, 400, 40);
        t1.setFont(new Font("Raleway", Font.BOLD, 45));
        add(t1);
        
        JLabel namee = new JLabel("NAME :");
        namee.setBounds(40, 100, 120, 35);
        namee.setFont(new Font("Raleway", Font.BOLD, 20));
        add(namee);
        
        namebox = new JTextField();
        namebox.setBounds(200, 100, 250, 35);
        namebox.setFont(new Font("Arial", Font.PLAIN, 18));
        add(namebox);
        
        JLabel iddd = new JLabel("ID :");
        iddd.setBounds(40, 165, 200, 35);
        iddd.setFont(new Font("Raleway", Font.BOLD, 20));
        add(iddd);
        
        String st[] = {"ADHAR CARD", "VOTER CARD", "PAN CARD", "DRIVING LICENCE", "PASSPORT"};
        idbox = new JComboBox(st);
        idbox.setBounds(200, 165, 250, 35);
        idbox.setFont(new Font("Arial", Font.BOLD, 18));
        idbox.setBackground(Color.white);
        add(idbox);
        
        JLabel num = new JLabel("ID NUMBER :");
        num.setBounds(40, 230, 200, 35);
        num.setFont(new Font("Raleway", Font.BOLD, 20));
        add(num);
        
        idnumbox = new JTextField();
        idnumbox.setBounds(200, 230, 250, 35);
        idnumbox.setFont(new Font("Arial", Font.PLAIN, 18));
        add(idnumbox);
        
        JLabel empgender = new JLabel("GENDER :");
        empgender.setBounds(40, 295, 120, 30);
        empgender.setFont(new Font("Raleway", Font.BOLD, 20));
        add(empgender);
        
        male = new JRadioButton("Male");
        male.setBounds(200, 295, 100, 30);
        male.setFont(new Font("Arial", Font.BOLD, 18));
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(320, 295, 100, 30);
        female.setFont(new Font("Arial", Font.BOLD, 18));
        female.setBackground(Color.white);
        add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel contry = new JLabel("COUNTRY :");
        contry.setBounds(40, 360, 120, 30);
        contry.setFont(new Font("Raleway", Font.BOLD, 20));
        add(contry);
        
        conbox = new JTextField();
        conbox.setBounds(200, 360, 250, 35);
        conbox.setFont(new Font("Arial", Font.PLAIN, 18));
        add(conbox);
        
        JLabel religion = new JLabel("RELIGION :");
        religion.setBounds(40, 425, 120, 30);
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        add(religion);
        
        rellbox = new JTextField();
        rellbox.setBounds(200, 425, 250, 35);
        rellbox.setFont(new Font("Arial", Font.PLAIN, 18));
        add(rellbox);
        
        JLabel room = new JLabel("ROOM NO :");
        room.setBounds(40, 490, 120, 30);
        room.setFont(new Font("Raleway", Font.BOLD, 20));
        add(room);
        
        roombox = new Choice();
         try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room where availability = 'Available';");
            while(rs.next()){
                roombox.add(rs.getString("room_number"));
            }           
        }catch(Exception e){
            System.out.println(e);
        }
        roombox.setBounds(200, 490, 250, 35);
        roombox.setFont(new Font("Raleway", Font.BOLD, 16));
        roombox.setBackground(Color.white);
        add(roombox);
        
        JLabel chk = new JLabel("CHEKIN TIME :");
        chk.setBounds(40, 555, 150, 30);
        chk.setFont(new Font("Raleway", Font.BOLD, 20));
        add(chk);
        
        Date dd = new Date();
        datee = ""+dd;
        JLabel date = new JLabel("" + dd);
        date.setBounds(210, 555, 350, 35);
        date.setFont(new Font("Arial", Font.PLAIN, 18));
        add(date);
        
        JLabel dep = new JLabel("DEPOSITE :");
        dep.setBounds(40, 620, 120, 30);
        dep.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dep);
        
        depbox = new JTextField();
        depbox.setBounds(200, 620, 250, 35);
        depbox.setFont(new Font("Arial", Font.PLAIN, 18));
        add(depbox);
               
        JLabel ph = new JLabel("PHONE NO :");
        ph.setBounds(40, 685, 120, 30);
        ph.setFont(new Font("Raleway", Font.BOLD, 20));
        add(ph);
        
        phnobox = new JTextField();
        phnobox.setBounds(200, 685, 250, 35);
        phnobox.setFont(new Font("Arial", Font.PLAIN, 18));
        add(phnobox);
        
        book = new JButton("BOOK");
        book.setBounds(500, 680, 100, 30);
        book.setBackground(Color.black);
        book.setForeground(Color.white);
        book.setFont(new Font("Arial", Font.BOLD, 15));
        book.addActionListener(this);
        add(book);
        
        clear = new JButton("Clear");
        clear.setBounds(650, 680, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.setFont(new Font("Arial", Font.BOLD, 15));
        clear.addActionListener(this);
        add(clear);  
        
        back = new JButton("Back");
        back.setBounds(800, 680, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);
        
        
        setTitle("Customer Form");
        setBounds(600, 100,950, 800);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear){
            namebox.setText("");
            idnumbox.setText("");
            conbox.setText("");
            rellbox.setText("");
            depbox.setText("");
            phnobox.setText("");
            genderGroup.clearSelection();
        }else if (ae.getSource() == back){
            setVisible(false);    
        }else if(ae.getSource() == book){
            String name = namebox.getText();
            String id = (String)idbox.getSelectedItem();
            String idnumber = idnumbox.getText();
            String country = conbox.getText();
            String religion = rellbox.getText();
            String deposite = depbox.getText();     
            String roomno = (String)roombox.getSelectedItem();  
            String phno = phnobox.getText();
            
            String gender = null;
            if(male.isSelected()) gender = "Male";
            else if(female.isSelected()) gender =  "Female";
            
            if(name.equals("")) JOptionPane.showMessageDialog(null, "Name can't be empty");
            else if(idnumber.equals("")) JOptionPane.showMessageDialog(null, "ID Number can't be empty");
            else if(gender == null) JOptionPane.showMessageDialog(null, "Please select Gender");
            else if(country.equals("")) JOptionPane.showMessageDialog(null, "Country can't be empty");
            else if(religion.equals("")) JOptionPane.showMessageDialog(null, "Religion can't be empty");
            else if(roomno == null || roomno.isEmpty()) JOptionPane.showMessageDialog(null, "No Available Room Selected!");
            else if(deposite.equals("")) JOptionPane.showMessageDialog(null, "Deposite section can't be empty");
            else if(phno.equals("")) JOptionPane.showMessageDialog(null, "Phone No can't be empty");
            else{
              try{
                Conn c = new Conn();
                Random rn = new Random();
                long no = Math.abs((rn.nextLong() % 9000L) + 1000L);
                String cusid = "Cus" + no;
                c.s.executeUpdate("insert into customer values('"+name+"', '"+id+"', '"+idnumber+"', '"+gender+"', '"+country+"', '"+religion+"', '"+roomno+"', '"+datee+"', '"+deposite+"', '"+phno+"', '"+cusid+"');");
                c.s.executeUpdate("update room set availability = 'Occupied' where room_number = '"+roomno+"';");
                JOptionPane.showMessageDialog(null, "Room Booked Successfully..!\n Your Id is "+cusid+"");
                setVisible(false);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    
    public static void main(String args[]){
        new CustomerForm().setVisible(true);
    }
}
