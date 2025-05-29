package pmsjavafx;



import java.sql.*;

public  class databaseConnection {
  
    

    
    static Connection connect(){
    String url= "jdbc:mysql://localhost:3306/pms";
    String user= "root";
    String password= "thisaru";
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(url, user, password); 
        return con;
        }
        catch(Exception e){System.out.println(e);}
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
