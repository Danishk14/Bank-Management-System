
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Homepage extends JFrame implements ActionListener{
    JLabel l1,lable;
    JButton b7;
    
    
    Homepage(){
        
        
        setTitle("Automated Teller Machine");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Start.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 800, 800);
        add(l2);
        
        l1 = new JLabel("WELCOME ");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 60));
        
        lable = new JLabel("INDIAN BANK");
        lable.setForeground(Color.WHITE);
        lable.setFont(new Font("System", Font.BOLD, 45));
       
        
        b7 = new JButton("LET'S START");
        
        setLayout(null);
        
        l1.setBounds(180,100,900,55);
        l2.add(l1);
        
        lable.setBounds(350,180,600,55);
        l2.add(lable);
        
        
        
        b7.setBounds(350,633,150,35);
        l2.add(b7);
        
        

        b7.addActionListener(this);
        
        
        setSize(800,800);
        setLocation(300,0);

        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b7){ 
            setVisible(false);
            new Login().setVisible(true);
        }
        
        
    }
    
    
    public static void main(String args[]){
        new Homepage().setVisible(true);
    }
}
