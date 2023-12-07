
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
   
    
    JButton login,clear,signup;
    JTextField ct;
    JPasswordField pt;
    
    Login(){
        setTitle("Indian Bank");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Bank.jpeg"));
        Image i2= i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("Bank Management System");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,700,60);
        add(text);
        
        JLabel cardno = new JLabel("<html>Enter your Card <br/>No:</html>");
        cardno.setFont(new Font("Serif", Font.BOLD, 25));
        cardno.setBounds(125,135,300,75);
        add(cardno);
        
        ct = new JTextField(15);
        ct.setBounds(300,150,230,30);
        ct.setFont(new Font("Arial", Font.BOLD, 14));
        add(ct);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(125,220,375,30);
        add(pin);
        
        pt = new JPasswordField(15);
        pt.setFont(new Font("Arial", Font.BOLD, 14));
        pt.setBounds(300,220,230,30);
        add(pt);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.ORANGE);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.RED);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.GREEN);
        signup.setForeground(Color.BLACK);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.PINK);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            ct.setText("");
            pt.setText("");
            
        }
else if(ae.getSource() ==  login){
            Conn conn= new Conn();
            String cardnumber = ct.getText();
            String pinnumber = pt.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card no or Pin");
                    
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
    
}
