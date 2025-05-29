
package pmsjavafx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RentOrder {
    
    Connection conn=databaseConnection.connect();
    Statement stmt;
    PreparedStatement pstm;
    ResultSet rs;
    
     private int ID=3;
     private int cusID=1;
     private String rentdate="2012-01-01";
     private String returndate="2021-10-20";
     private int duration=4;
     private double advance=1000.0;
     private double total=2000.0;
     private int status= 1;
    
    
    
    
    
    /********* Constructor *********/
    
   /* RentOrder(int customerID,String rentDate,String returnDate,double advancedAmount){
    
    
    cusID=customerID;
    rentdate=rentDate;
    returndate=returnDate;
    advance=advancedAmount;
    }
    */
    
    public double calTotal()
    {
       
        
        
        
        return 0.0;
    }
    
    
    public void rentItem(int cID,String rentd,String returnd,double adv)
    {
     PMSsoftwareController du= new PMSsoftwareController();
     
    try{ 
        
        
        stmt=conn.createStatement();
      
        String query= "insert into rentorder(customerID,rentDate,returnDate,duration,advanceAmount,totalAmount,orderStatus) values(?,?,?,?,?,?,?)";
        pstm=conn.prepareStatement(query);
        
        
        pstm.setInt(1, cID);
        pstm.setString (2, rentd);
        pstm.setString(3, returnd);
        pstm.setInt(4, (int) du.calDuration());
        pstm.setDouble(5, adv);
        pstm.setDouble(6, total);
        pstm.setInt(7, 1);
        
        pstm.execute();
        
        }
        
    catch(SQLException e)
      {
        System.out.println(e);
      }
    
    
    
    }
    
    public int getLastRentID()
   {
   
   int lastid = 0;
        try {
            stmt = conn.createStatement();
            String query2="select orderID from rentorder order by orderID desc limit 1";
            rs=stmt.executeQuery(query2);
            
            
            if (rs.next())
            {
                lastid=rs.getInt("orderID");
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   return lastid;
   }
   
   public String calNowRentID(){
   int x = getLastRentID();
   
   String y=Integer.toString(x+1);
   
   return y;
   }
    
    
}
