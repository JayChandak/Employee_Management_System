package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{    
    JTextField loginT;
    JPasswordField pin;
    public Login(){
        getContentPane().setBackground(Color.white);        
        setLayout(null);        
        
        JLabel login = new JLabel("Username");
//        login.setFont(new Font("Arial",Font.BOLD,15));
        login.setBounds(40,20,100,30);        
        login.setForeground(Color.black);
        add(login);
        
        loginT = new JTextField();
        loginT.setBounds(160,20,300,30);
        loginT.setSize(137,30);
        add(loginT);
        
        JLabel pass = new JLabel("Password ");
        pass.setBounds(40,70,200,30);        
        pass.setForeground(Color.black);
        add(pass);
        
        pin = new JPasswordField();        
        pin.setBounds(160,70,140,30);
        pin.setFont(new Font("Arial",Font.BOLD,14));
        pass.setSize(120,30);
        add(pin);
                
        JButton loginB = new JButton("Login");
        loginB.setBounds(160,140,150,30);
        loginB.setBackground(Color.BLACK);
        loginB.setForeground(Color.WHITE);
        loginB.addActionListener(this);        
        add(loginB);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);        
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200,200);        
        add(image);
        
        setSize(600,300);        
        setLocation(450,200);              
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        
        String username = loginT.getText();
        String password = pin.getText();            
            
        Conn  obj = new Conn();
        String query = "select * from login where username ='"+username+"' and password ='"+password+"'";                        
        try{
            ResultSet rs = obj.s.executeQuery(query);                      
            if(rs.next()){
                setVisible(false);                
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String []args){
        new Login();
    }
}