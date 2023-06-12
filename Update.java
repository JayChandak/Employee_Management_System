package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
public class Update extends JFrame implements ActionListener{
        
    JTextField salaryT,addressT,phoneNoT,emailT,designationT,educationT;        
    JLabel nameL,fnameL,aadharL,dobLabel,empIdLabel;
    JButton add,back;    
    String empId;
    
    public Update(String empId){
    
        this.empId = empId;
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel(" Update Employee Details ");
        heading.setBounds(280,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(heading);
        
        JLabel name = new JLabel("Name");
        name.setBounds(40,120,100,25);
        name.setFont(new Font("SERIF",Font.PLAIN,20));
        add(name);        
        nameL = new JLabel();
        nameL.setBounds(160,120,150,25);
        add(nameL);
        
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,120,150,25);
        fname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(fname);                        
        fnameL = new JLabel();
        fnameL.setBounds(530,120,150,25);
        add(fnameL);
        
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(40,160,150,25);
        dob.setFont(new Font("SERIF",Font.PLAIN,20));
        add(dob);        
        dobLabel = new JLabel();
        dobLabel.setBounds(160,160,150,25);
        add(dobLabel);
                
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,160,150,25);
        salary.setFont(new Font("SERIF",Font.PLAIN,20));
        add(salary);
        salaryT = new JTextField();
        salaryT.setBounds(550,160,150,25);
        add(salaryT);
        
        JLabel address = new JLabel("Address");
        address.setBounds(40,200,150,25);
        address.setFont(new Font("SERIF",Font.PLAIN,20));
        add(address);
        addressT = new JTextField();
        addressT.setBounds(160,200,150,25);
        add(addressT);
        
        JLabel phoneNo = new JLabel("Phone No ");
        phoneNo.setBounds(400,200,150,25);
        phoneNo.setFont(new Font("SERIF",Font.PLAIN,20));
        add(phoneNo);
        phoneNoT = new JTextField();
        phoneNoT.setBounds(550,200,150,25);
        add(phoneNoT);
        
        JLabel email = new JLabel("Email Id");
        email.setBounds(40,240,150,25);
        email.setFont(new Font("SERIF",Font.PLAIN,20));
        add(email);
        emailT = new JTextField();
        emailT.setBounds(160,240,150,25);
        add(emailT);              
               
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400,240,250,25);
        education.setFont(new Font("SERIF",Font.PLAIN,20));        
        add(education);        
        educationT = new JTextField();
        educationT.setBackground(Color.WHITE);
        educationT.setBounds(550,240,150,25);
        add(educationT);              
        
        JLabel designation = new JLabel("Designation");
        designation.setBounds(40,280,150,25);
        designation.setFont(new Font("SERIF",Font.PLAIN,20));
        add(designation);
        designationT = new JTextField();
        designationT.setBounds(160,280,150,25);
        add(designationT);
        
        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(400,280,150,25);
        aadhar.setFont(new Font("SERIF",Font.PLAIN,20));
        add(aadhar);
        aadharL = new JLabel();
        aadharL.setBounds(550,280,150,25);
        add(aadharL);
        
        JLabel empIdL = new JLabel("Employee Id ");
        empIdL.setBounds(40,320,150,25);
        empIdL.setFont(new Font("SERIF",Font.PLAIN,20));
        add(empIdL);
        empIdLabel = new JLabel();
        empIdLabel.setBounds(160,320,150,25);
        empIdLabel.setFont(new Font("SERIF",Font.PLAIN,20));
        add(empIdLabel);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                nameL.setText(rs.getString("name"));
                fnameL.setText(rs.getString("fname"));
                dobLabel.setText(rs.getString("dob"));                
                salaryT.setText(rs.getString("salary"));
                addressT.setText(rs.getString("address"));
                phoneNoT.setText(rs.getString("phoneno"));
                emailT.setText(rs.getString("email"));
                educationT.setText(rs.getString("education"));
                designationT.setText(rs.getString("designation"));
                aadharL.setText(rs.getString("aadhar"));
                empIdLabel.setText(rs.getString("empId"));                
            }
        }catch(Exception e){
            e.printStackTrace();
        }       
        
        add = new JButton("Update Details");
        add.setBounds(200,400,150,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);        
        add(add);
        
        back = new JButton("Back");
        back.setBounds(400,400,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);        
        add(back);
                
        setSize(800,600);
        setLocation(280,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){                                                
            String salary = salaryT.getText();
            String address = addressT.getText();
            String phone = phoneNoT.getText();
            String email = emailT.getText();            
            String education = educationT.getText();
            String designation = designationT.getText();                        
            
            Conn c = new Conn(); 
            String query = "update employee set salary = '"+salary+"',address = '"+address+"',phoneno = '"+phone+"',email = '"+email+"',education = '"+education+"',designation = '"+designation+"' where empId = '"+empId+"'";
            try{                
                c.s.executeUpdate(query);                                                
                JOptionPane.showMessageDialog(null,"Details updated Successfully");
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
        new Update("");
    }
}  
