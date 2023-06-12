package employee.management.system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class Add extends JFrame implements ActionListener{
    
    Random ran = new Random() ;
    int number = ran.nextInt(999999);
    JTextField nameT,fnameT,salaryT,addressT,phoneNoT,emailT,designationT,aadharT;
    JDateChooser dobChooser;
    JComboBox educationT;
    JButton add,back;
    JLabel empId2;
    
    public Add(){
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel(" Add Employee Details ");
        heading.setBounds(280,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(heading);
        
        JLabel name = new JLabel("Name");
        name.setBounds(40,120,100,25);
        name.setFont(new Font("SERIF",Font.PLAIN,20));
        add(name);        
        nameT = new JTextField();
        nameT.setBounds(160,120,150,25);
        add(nameT);
        
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,120,150,25);
        fname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(fname);        
        fnameT = new JTextField();
        fnameT.setBounds(550,120,150,25);
        add(fnameT);
        
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(40,160,150,25);
        dob.setFont(new Font("SERIF",Font.PLAIN,20));
        add(dob);        
        dobChooser = new JDateChooser();
        dobChooser.setBounds(160,160,150,25);
        add(dobChooser);
                
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
        
        String [] courses = {"SSC","HSC","BBA","BCA","BSC","BCOM","B.E","MCA","MSC","MBA","M.TECH","PHD"};
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400,240,250,25);
        education.setFont(new Font("SERIF",Font.PLAIN,20));        
        add(education);        
        educationT = new JComboBox(courses);
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
        aadharT = new JTextField();
        aadharT.setBounds(550,280,150,25);
        add(aadharT);
        
        JLabel empId = new JLabel("Employee Id ");
        empId.setBounds(40,320,150,25);
        empId.setFont(new Font("SERIF",Font.PLAIN,20));
        add(empId);
        empId2 = new JLabel("" + number);
        empId2.setBounds(160,320,150,25);
        empId2.setFont(new Font("SERIF",Font.PLAIN,20));
        add(empId2);
        
        add = new JButton("Add Details");
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
            String name = nameT.getText();
            String fname = fnameT.getText();
            String dob = ((JTextField)dobChooser.getDateEditor().getUiComponent()).getText();
            String salary = salaryT.getText();
            String address = addressT.getText();
            String phone = phoneNoT.getText();
            String email = emailT.getText();
            String education = (String)educationT.getSelectedItem();
            String designation = designationT.getText();
            String aadhar = aadharT.getText();
            String empId = empId2.getText();
            Conn c = new Conn(); 
            String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empId+"')";
            try{
                c.s.executeUpdate(query);                                                
                JOptionPane.showMessageDialog(null,"Details added Successfully");
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
        new Add();
    }
}  
