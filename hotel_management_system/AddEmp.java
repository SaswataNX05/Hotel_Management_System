package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AddEmp extends JFrame implements ActionListener{
    
    JTextField namebox, agebox, salbox, phbox, emailbox, addrbox;
    JComboBox jobbox;
    JRadioButton male, female;
    JButton submit, clear;
    
    AddEmp(){
        
        setLayout(null);
        setTitle("ADD EMPLOYEE");
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/emp.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420, 100, 400, 300);
        add(image);
        
        JLabel empname = new JLabel("NAME");
        empname.setBounds(40, 50, 120, 30);
        empname.setFont(new Font("Raleway", Font.BOLD, 20));
        add(empname);
        
        namebox = new JTextField();
        namebox.setBounds(200, 50, 200, 30);
        namebox.setFont(new Font("Arial", Font.PLAIN, 14));
        add(namebox);
        
        JLabel empage = new JLabel("AGE");
        empage.setBounds(40, 120, 120, 30);
        empage.setFont(new Font("Raleway", Font.BOLD, 20));
        add(empage);
        
        agebox = new JTextField();
        agebox.setBounds(200, 120, 200, 30);
        agebox.setFont(new Font("Arial", Font.PLAIN, 14));
        add(agebox);
        
        JLabel empgender = new JLabel("GENDER");
        empgender.setBounds(40, 190, 120, 30);
        empgender.setFont(new Font("Raleway", Font.BOLD, 20));
        add(empgender);
        
        male = new JRadioButton("Male");
        male.setBounds(200, 190, 60, 30);
        male.setFont(new Font("Arial", Font.BOLD, 14));
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(320, 190, 80, 30);
        female.setFont(new Font("Arial", Font.BOLD, 14));
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel empjob = new JLabel("JOB");
        empjob.setBounds(40, 260, 120, 30);
        empjob.setFont(new Font("Raleway", Font.BOLD, 20));
        add(empjob);
        
        String st[]= { "Receptionist", "HouseKeeping", "Laundry", "Swiper","Manager", "Cook", "Wieghter", "Clener", "Gardener"};
        jobbox = new JComboBox(st);
        jobbox.setBounds(200, 260, 200, 30);
        jobbox.setFont(new Font("Raleway", Font.BOLD, 14));
        jobbox.setBackground(Color.white);
        add(jobbox);
        
        JLabel empsal = new JLabel("SALARY");
        empsal.setBounds(40, 330, 120, 30);
        empsal.setFont(new Font("Raleway", Font.BOLD, 20));
        add(empsal);
        
        salbox = new JTextField();
        salbox.setBounds(200, 330, 200, 30);
        salbox.setFont(new Font("Arial", Font.PLAIN, 14));
        add(salbox);
        
        JLabel empph = new JLabel("PHONE NO");
        empph.setBounds(40, 400, 120, 30);
        empph.setFont(new Font("Raleway", Font.BOLD, 20));
        add(empph);
    
        phbox = new JTextField();
        phbox.setBounds(200, 400, 200, 30);
        phbox.setFont(new Font("Arial", Font.PLAIN, 14));
        add(phbox);
        
        JLabel empemail = new JLabel("EMAIL");
        empemail.setBounds(40, 470, 120, 30);
        empemail.setFont(new Font("Raleway", Font.BOLD, 20));
        add(empemail);
        
        emailbox = new JTextField();
        emailbox.setBounds(200, 470, 200, 30);
        emailbox.setFont(new Font("Arial", Font.PLAIN, 14));
        add(emailbox);
        
        JLabel empadhar = new JLabel("ADHAR NO");
        empadhar.setBounds(40, 540, 120, 30);
        empadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        add(empadhar);  
        
        addrbox = new JTextField();
        addrbox.setBounds(200, 540, 200, 30);
        addrbox.setFont(new Font("Arial", Font.PLAIN, 14));
        add(addrbox);
        
        submit = new JButton("Submit");
        submit.setBounds(500, 590, 100, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Arial", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);
        
        clear = new JButton("Clear");
        clear.setBounds(650, 590, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.setFont(new Font("Arial", Font.BOLD, 15));
        clear.addActionListener(this);
        add(clear);            
        
        setSize(850, 700);
        setLocation(400, 200);
        getContentPane().setBackground(Color.white);       
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear){
            namebox.setText("");
            agebox.setText("");
            salbox.setText("");
            phbox.setText("");
            emailbox.setText("");
            addrbox.setText("");             
        }else if(ae.getSource() == submit){
            String name = namebox.getText();
            String age = agebox.getText();
            String sal = salbox.getText();
            String ph = phbox.getText();
            String eamil = emailbox.getText();
            String adhar = addrbox.getText();     
            String job = (String)jobbox.getSelectedItem();    
            
            String gender = null;
            if(male.isSelected()) gender = "Male";
            else if(female.isSelected()) gender =  "Female";
            
            if(name.equals("")) JOptionPane.showMessageDialog(null, "Name can't be empty");
            else if(age.equals("")) JOptionPane.showMessageDialog(null, "Age can't be empty");
            else if(gender == null) JOptionPane.showMessageDialog(null, "Please select Gender");
            else if(sal.equals("")) JOptionPane.showMessageDialog(null, "Salary can't be empty");
            else if(ph.equals("")) JOptionPane.showMessageDialog(null, "Phone NO can't be empty");            
            else if(eamil.equals("")) JOptionPane.showMessageDialog(null, "Email can't be empty");
            else if(adhar.equals("")) JOptionPane.showMessageDialog(null, "Adhar can't be empty");           
            else{
                try{
                    Conn c = new Conn();
                    Random rn = new Random();
                    long no = Math.abs((rn.nextLong() % 900L) + 100L);
                    String em = "emp" + no;
                    String st = "insert into employee values('"+em+"', '"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+sal+"', '"+ph+"', '"+eamil+"', '"+adhar+"')";
                    c.s.executeUpdate(st);
                    JOptionPane.showMessageDialog(null, "Employee Successfully added \n Your employee code : '"+em+"'");
                    setVisible(false);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            
           
        }
    }
    
    public static void main(String args[]){
        new AddEmp().setVisible(true);
    }
    
}
