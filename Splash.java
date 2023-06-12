package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{

    Splash(){        
        setTitle("Employee Management System");
        getContentPane().setBackground(Color.WHITE);        
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(220,20,1200,60);
        heading.setFont(new Font("arial",Font.BOLD,25));
        heading.setForeground(Color.RED);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/image.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(110, 90, 700, 450);        
        add(image);
        
        JButton clickHere = new JButton("Click Here");
        clickHere.setBounds(500,340,150,70);
        clickHere.setBackground(Color.black);
        clickHere.setForeground(Color.white);
        clickHere.addActionListener(this);
        image.add(clickHere);               
            
        
        setSize(900,600);
        setLocation(200,100);
        setVisible(true);      
        
        while(true){
            clickHere.setVisible(false);
            try{
                Thread.sleep(500);
//                500 means half mili seconds
            }catch(Exception e){
                
            }
            clickHere.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
        }        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String []args)    {
    
        // annonymous object
        new Splash();
        
    }

}
