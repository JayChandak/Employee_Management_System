package employee.management.system;
import java.sql.*;

public class Conn {
//  interface  
    Connection c;
    Statement s;
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
//            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root","admin");
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","admin");
            s = c.createStatement();
            
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}