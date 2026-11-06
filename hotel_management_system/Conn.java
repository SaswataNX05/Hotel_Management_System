package hotel_management_system;
import java.sql.*;

public class Conn {
    
    public Connection c;
    public Statement s;
    
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "2005");
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
