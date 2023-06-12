package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Remove extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JButton delete,back;
    
    Remove(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);        
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);        
        add(image);
        
        JLabel empIdLabel = new JLabel("Employee Id");
        empIdLabel.setFont(new Font("Arial",Font.BOLD,18));
        empIdLabel.setBounds(40,50,150,30);
        add(empIdLabel);
        
        cEmpId = new Choice();
        cEmpId.setBounds(200,50,150,30);
        add(cEmpId);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cEmpId.add(rs.getString("empId"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel name = new JLabel("Name");
        name.setBounds(40,100,150,30);
        name.setFont(new Font("Arial",Font.BOLD,18));
        add(name);                
        JLabel nameLabel = new JLabel();
        nameLabel.setBounds(200,100,150,30);
        add(nameLabel);        
        
        JLabel phoneNo = new JLabel("Phone No ");
        phoneNo.setBounds(40,150,150,30);
        phoneNo.setFont(new Font("Arial",Font.BOLD,18));
        add(phoneNo);                
        JLabel phoneNoLabel = new JLabel();
        phoneNoLabel.setBounds(200,150,150,30);
        add(phoneNoLabel);        
        
        JLabel email = new JLabel("Email Id ");
        email.setBounds(40,200,150,30);
        email.setFont(new Font("Arial",Font.BOLD,18));
        add(email);                
        JLabel emailLabel = new JLabel();
        emailLabel.setBounds(200,200,150,30);
        add(emailLabel);
        
        delete = new JButton("Delete");
        delete.setBounds(50,280,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(170,280,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                nameLabel.setText(rs.getString("name"));
                phoneNoLabel.setText(rs.getString("phoneNo"));
                emailLabel.setText(rs.getString("email"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
//        Values changed or Not
        cEmpId.addItemListener(new ItemListener(){
            
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        nameLabel.setText(rs.getString("name"));
                        phoneNoLabel.setText(rs.getString("phoneNo"));
                        emailLabel.setText(rs.getString("email"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }            
        });

        
        setSize(970,400);
        setLocation(250,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
            try{
                Conn c = new Conn();
                String query = "delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";                
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Information Deleted Successfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }                
    }
    public static void main(String []args){
        new Remove();
    }
}
