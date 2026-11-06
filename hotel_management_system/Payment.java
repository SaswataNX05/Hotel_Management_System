package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JDialog implements ActionListener{
    
    JButton back, paid;
    String ruppe;
    String rt = "false";
    
    public Payment(){
        setModal(true);
        setModalityType(ModalityType.APPLICATION_MODAL);
    }
    
    String Payment(String ruppe){
        
        setTitle("Payment");
        setBounds(600, 200, 550, 650);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        this.ruppe = ruppe;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/payment.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 80, 450, 400);
        add(image);
        
        JLabel t1 = new JLabel("SCAN THE QR CODE AND PAY");
        t1.setBounds(100, 10, 360, 30);
        t1.setFont(new Font("Arial", Font.BOLD, 25));
        t1.setForeground(Color.BLUE);
        add(t1);
        
        JLabel t2 = new JLabel("Amount : "+ruppe+" -/Rs");
        t2.setBounds(160, 50, 360, 30);
        t2.setFont(new Font("Arial", Font.BOLD, 25));
        t2.setForeground(Color.BLUE);
        add(t2);
        
        JLabel t3 = new JLabel("UPI ID :  saswata@arch");
        t3.setBounds(170, 485, 360, 30);
        t3.setFont(new Font("Arial", Font.BOLD, 15));
        add(t3);
        
        paid = new JButton("PAID");
        paid.setBounds(150, 530, 100, 30);
        paid.setBackground(Color.GREEN);
        paid.setForeground(Color.BLACK);
        paid.setFont(new Font("Arial", Font.BOLD, 15));
        paid.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, " "+ruppe+" -/Rs Paid.\n Thank you... :)");
            rt = "true";            
            setVisible(false);
            dispose();
        });
        add(paid);
        
        back = new JButton("Back");
        back.setBounds(300, 530, 100, 30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.white);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.addActionListener(e -> {
            rt = "false";
            setVisible(false);
            dispose();
        });
        add(back);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // Modal dialog will block execution right here until dismissed,
        // without freezing the Swing UI thread
        setVisible(true);
        
        return rt;
    }

    public void actionPerformed(ActionEvent ae){

    }
    
    public static void main(String args[]){
        Payment p = new Payment();
        String res = p.Payment("1000");
        System.out.println("Result: " + res);
    }
    
}
