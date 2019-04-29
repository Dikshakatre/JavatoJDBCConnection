
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Diksha
 */

public class DBHelper {
    Connection con;
    
    public DBHelper(){
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/authsystem","root","Diksha@1234");         
//        }
//        catch(Exception e){ System.out.println(e);}
    }
    
    public boolean validAuthentication(String Username, String pass, String usercode){
        try{
            String DB_URL = "jdbc:mysql://localhost:3306/authsystem";
            String DB_DRV = "com.mysql.jdbc.Driver";
            String DB_USER = "root";
            String DB_PASSWD = "Diksha@1234";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection
            (DB_URL,DB_USER,DB_PASSWD);
         
//            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/authsystem","diksha","Diksha@1234");
            
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/authsystem","diksha","Diksha@1234");         
            Statement stmt = con.createStatement();
            String st_querry = "select username from accountinfo as acc where acc.username =\""
                    +Username+"\" AND acc.password = \""+pass+"\" AND usercode=\""+usercode+"\"";
            ResultSet rs=stmt.executeQuery(st_querry);
            
            con.close();
            while(rs.next())
            {
                System.out.println(rs.getString(1));
                if(!rs.getString(1).isEmpty()){
                   return true; 
                }    
            } 
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        return false;
    }

//           
}
