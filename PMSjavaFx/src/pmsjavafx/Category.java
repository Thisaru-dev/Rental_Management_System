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


public class Category {
 
     Connection conn=databaseConnection.connect();
    Statement stmt;
    PreparedStatement pstm;
    ResultSet rs;
    
    private int catiD;
    private String catName;
    
    public void addCategory()
    {
  
        try{ 
        
        
        stmt=conn.createStatement();
      
        String query= "insert into category values(?,?s)";
        pstm=conn.prepareStatement(query);
      
        pstm.setInt(1, catiD);
        pstm.setString(2, catName);
        
        
        
        pstm.execute();
        
        }
        
        catch(SQLException e)
        {
        System.out.println(e);
        }
    
        
    }

    public Category(int catiD, String catName) {
        this.catiD = catiD;
        this.catName = catName;
    }
    
  public void deleteCategory()
    {
        try {
            pstm=conn.prepareStatement("delete from category where categoryID=?");
            pstm.setInt(1, catiD);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("deleteCustomer error");
        }

        
    }
      
    
 
}
