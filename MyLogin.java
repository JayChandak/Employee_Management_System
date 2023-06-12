package employee.management.system;
import javax.swing.*;
import java.awt.*;

public class MyLogin extends JFrame{

    public MyLogin(){
        setTitle("EMS");
        getContentPane().setBackground(Color.WHITE);        
        setLayout(null);
        
        JLabel admin = new JLabel("Admin Login");
        admin.setBounds(120,20,200,30);
        admin.setFont(new Font("Arial",Font.BOLD,17));        
        admin.setForeground(Color.blue);        
        add(admin);
                
        JLabel login = new JLabel("User Name");
        login.setFont(new Font("Arial",Font.BOLD,15));
        login.setBounds(30,80,200,30);        
        login.setForeground(Color.black);
        add(login);
        
        JTextField loginT = new JTextField();
        loginT.setBounds(150,80,270,30);
        loginT.setSize(120,30);
        add(loginT);
        
        JLabel pass = new JLabel("Password ");
        pass.setFont(new Font("Arial",Font.BOLD,15));
        pass.setBounds(30,130,200,30);        
        pass.setForeground(Color.black);
        add(pass);
        
        JPasswordField pin = new JPasswordField();        
        pin.setBounds(150,130,140,30);
        pin.setFont(new Font("Arial",Font.BOLD,14));
        pass.setSize(120,30);
        add(pin);
        
        
        JButton clickHere = new JButton("Click Here");
        clickHere.setBounds(200,260,100,50);
        clickHere.setBackground(Color.black);
        clickHere.setForeground(Color.white);
        add(clickHere);                
        
        setSize(350,400);
        setLocation(500,100);
        setVisible(true);        
        
    }
    
    public static void main(String []args){
        new MyLogin();
    }
    
}
