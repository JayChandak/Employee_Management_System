package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    JButton addB,view,update,remove;
    
    public Home(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1050, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);        
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1050, 600);        
        add(image);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(600,20,400,40);
        heading.setFont(new Font("ARIAL",Font.BOLD,18));        
        image.add(heading);
        
        addB = new JButton("Add Employee");
        addB.setBounds(600,80,150,30);
        addB.addActionListener(this);
        image.add(addB);       
        
        view = new JButton("View Employees");
        view.setBounds(600,120,150,30);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Employee");
        update.setBounds(780,80,150,30);
        update.addActionListener(this);
        image.add(update);        
        
        remove = new JButton("Remove Employee");
        remove.setBounds(780,120,150,30);
        remove.addActionListener(this);
        image.add(remove);
        
        setSize(1050,600);
        setLocation(150,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addB){
            setVisible(false);
            new Add();
        }
        else if(ae.getSource() == view){
            setVisible(false);
            new View();
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new View();
        }
        else{
            setVisible(false);
            new Remove();
        }
    }
    
    public static void main(String []args){
        new Home();
    }
}
