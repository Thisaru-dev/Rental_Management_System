/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pmsjavafx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;



public class Customer {
    
    Connection conn=databaseConnection.connect();
    Statement stmt;
    PreparedStatement pstm;
    ResultSet rs;
    
    private int customeriD;
    private String customerName;
    private String customerNIC;
    private String telNumber;
    private String cusAddress;
    
    /**** getters to excus show ****/
    
    private String sCusID;
    private String sName;
    private String sNic;
    private String sMobile;
    private String sAddress;
    
    Customer(String name,String nic,String number,String address){
    customerName=name;
    customerNIC=nic;
    telNumber=number;
    cusAddress=address;
    }
    Customer(int id)
    {
    customeriD=id;
    }
    Customer(){}
    
    public void addCustomer()
    {
  
        try{ 
        
        
        stmt=conn.createStatement();
      
        String query= "insert into customer(customerName,NIC,phone,address) values(?,?,?,?)";
        pstm=conn.prepareStatement(query);
      
        pstm.setString(1, customerName);
        pstm.setString(2, customerNIC);
        pstm.setString(3, telNumber);
        pstm.setString(4,cusAddress);
        
        
        pstm.execute();
        
        }
        
        catch(SQLException e)
        {
        System.out.println(e);
        }
    
        
    }
    
  public void deleteCustomer()
    {
        try {
            pstm=conn.prepareStatement("delete from customer where customerID=?");
            pstm.setInt(1, customeriD);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("deleteCustomer error");
        }

        
    }
      
    
   public int getLastCusID()
   {
   
   int lastid = 0;
        try {
            stmt = conn.createStatement();
            String query2="select customerID from customer order by customerID desc limit 1";
            rs=stmt.executeQuery(query2);
            
            
            if (rs.next())
            {
                lastid=rs.getInt("customerID");
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   return lastid;
   }
   
   public String calNowCusID(){
   int x = getLastCusID();
   
   String y=Integer.toString(x+1);
   
   return y;
   }
   
   
   
   public void findCus(String query3)
   {
      
        try {
            
            pstm=conn.prepareStatement(query3);
            rs=pstm.executeQuery();
            if(rs.next())
            {
            sCusID=Integer.toString(rs.getInt(1));
            sName=rs.getString(2);
            sNic=rs.getString(3);
            sMobile=rs.getString(4);
            sAddress=rs.getString(5);
            
            }
            
       
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
/***** getMethods for return Ex cuss show Values *****/
    public String getsCusID() {
        return sCusID;
    }

    public String getsName() {
        return sName;
    }

    public String getsNic() {
        return sNic;
    }

    public String getsMobile() {
        return sMobile;
    }

    public String getsAddress() {
        return sAddress;
    }
   
  
   
}
