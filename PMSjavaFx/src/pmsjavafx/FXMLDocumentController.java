/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package pmsjavafx;
import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 *
 * @author thisa
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private TextField txtUserName;
    
    @FXML
    private TextField txtPassword;
    
    @FXML
    private TextField txtPassHide;
    
    @FXML
    private CheckBox showPassword;
    
    @FXML
    private Label lblReset;
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private Button btnClose;
   
    
    @FXML
    private void handleCloseAction(ActionEvent event){ 
    Stage stage = (Stage) btnClose.getScene().getWindow();
    stage.close();
    
    }
    //dbms tools
    private Connection conn;
   
    
      
    //login button code
    @FXML
    private void handleLoginAction(ActionEvent event){
    
    
        conn=databaseConnection.connect();
        try{
              
               
        String username=txtUserName.getText();
        String pass=txtPassword.getText();
        
        Statement stm= conn.createStatement();
        String query = "select * from users where userName='"+username+"'and password='"+pass+"'";
        ResultSet rs= stm.executeQuery(query);
        
         if(rs.next())
         {
            JOptionPane.showMessageDialog(null,"Login successful");

             Parent root = FXMLLoader.load(getClass().getResource("PMSsoftware.fxml"));
             Stage stage = new Stage();
             stage.setScene(new Scene(root));
             stage.setFullScreen(true);
             stage.show();
             btnLogin.getScene().getWindow().hide();
            
         }
         else if(username.equals("")&&pass.equals(""))
         {

            JOptionPane.showMessageDialog(null,"Please enter User Name & Password");
         }
         
         else if(username.equals(""))
         {
            JOptionPane.showMessageDialog(null,"Please enter User Name");
         }
         
         else if(pass.equals(""))
         {
            JOptionPane.showMessageDialog(null,"Please enter Password");
         }
        
        else
         {
            JOptionPane.showMessageDialog(null,"Wrong User name or Password !!!","Message",JOptionPane.ERROR_MESSAGE);

         }
     
        conn.close();
        
        
        
        }
        catch(Exception e){System.out.println(e);}
       
    }                                           

    
    @FXML
    private void handleShowpassAction(ActionEvent event){
    txtPassword.setText(txtPassHide.getText());
    if(showPassword.isSelected()){
        txtPassword.setText(txtPassHide.getText());
       txtPassword.setVisible(true); 
       txtPassHide.setVisible(false);
            
            
        }
        else{
        txtPassHide.setText(txtPassword.getText());
        txtPassword.setVisible(false); 
        txtPassHide.setVisible(true);
             
            
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
