
package pmsjavafx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class Items {
    
    Connection conn=databaseConnection.connect();
    Statement stmt;
    PreparedStatement pstm;
    
    int id;
    String cat,mod,des,ava;
    double pri;
    
    Items(int itemId,String category,String model,String description,String available ,double price){
        
    id=itemId;
    cat=category;
    mod=model;
    des=description;
    ava=available;
    pri=price;
    
    
    }
    
    public void addItem()
    {
   
        try{ 
        
        
        stmt=conn.createStatement();
      
        String query= "insert into equipment(equipmentID,category,model,eDescription,availability,price) values(?,?,?,?,?,?)";
        pstm=conn.prepareStatement(query);
        
        pstm.setInt(1, id);
        pstm.setString(2, cat);
        pstm.setString(3, mod);
        pstm.setString(4, des);
        pstm.setString(5, ava);
        pstm.setDouble(6, pri);
        
        pstm.execute();
        
        }
        
        catch(SQLException e)
        {
        System.out.println(e);
        }
    
    }
   
    public void updateItem()
    {
        try {
            
            
            
            pstm= conn.prepareStatement("update equipment set category=?,model=?,eDescription=?,price=?,availability=? where equipmentID=?");
            pstm.setString(1, cat);
            pstm.setString(2, mod);
            pstm.setString(3, des);
            
            pstm.setDouble(4, pri);
            pstm.setString(5, ava);
            pstm.setInt(6, id);
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update item error");
            
        }
    
    
    
    }
    
    public void deleteItem()
    {
        try {
            pstm=conn.prepareStatement("delete from equipment where equipmentID=?");
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("deleteItem error");
        }

        
    }
}
