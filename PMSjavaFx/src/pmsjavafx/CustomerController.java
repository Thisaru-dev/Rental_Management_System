/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pmsjavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;



public class CustomerController implements Initializable {

    @FXML
    private RadioButton rbNewCus;
    @FXML
    private RadioButton rbExCus;
    @FXML
    private AnchorPane anNewCus;
    @FXML
    private AnchorPane anExCus;
    @FXML
    private Button btnAdd;
    
    /****** newCustomerpanel Components******/
    
    @FXML
    private Label lblID;
    @FXML
    private TextField txtCusName;
    @FXML
    private TextField txtCusNic;
    @FXML
    private TextField txtCusMobile;
    @FXML
    private TextField txtCusAddress;
    
    /******* Existing Panel Components********/
    @FXML
    private Label lblExID;
    @FXML
    private Label lblExName;
    @FXML
    private Label lblExNIC;
    @FXML
    private Label lblExMob;
    @FXML
    private Label lblExAddress;
    
    @FXML
    private TextField txtExCusID;
    @FXML
    private TextField txtExCusNIC;
    @FXML
    private Button btnFind;
    
     
    /****** panel switch by using radio buttons******/
    @FXML
    private void switchPane(ActionEvent event){
    
    if (rbNewCus.isSelected()){
    anNewCus.setVisible(true);
    anExCus.setVisible(false);
   
    
    }
    else if(rbExCus.isSelected()){
    anNewCus.setVisible(false);
    anExCus.setVisible(true);
    
    }
    
    }
    // addCustomer 
    @FXML
    private void handleAddCusAction(ActionEvent event){
        
    if(txtCusName.getText().isEmpty()||txtCusNic.getText().isEmpty()||txtCusMobile.getText().isEmpty()||txtCusAddress.getText().isEmpty()){
         AlertMessage alert = new AlertMessage();
         alert.errorMessage("Fill all Fields");
         }
    else if(rbNewCus.isSelected())
     {AlertMessage alert = new AlertMessage();
        if(alert.confirmationMessage("Are you sure to add?")==true){
                
         
         
     String name=txtCusName.getText();
     String nic = txtCusNic.getText();
     String mobile = txtCusMobile.getText();
     String address = txtCusAddress.getText();
     
     Customer customer = new Customer(name,nic,mobile,address);
     customer.addCustomer();
     btnAdd.getScene().getWindow().hide();
        
    int i;
    i=customer.getLastCusID();
    //System.out.println(i);
    PMSsoftwareController ida = new PMSsoftwareController();
    ida.setCusID(lblID.getText());
    
     }   
     
    }
    }
    
    
    /***** Existing customer*****/ 
    
    // Text Field Disable actions
    
    @FXML
    private void handleTxt1Click(KeyEvent event)
    {
        
        if(txtExCusID.getText().isEmpty())
        {
            txtExCusNIC.setDisable(false);
          
        }
        else{txtExCusNIC.setDisable(true);}
    }
    
    @FXML
    private void handleTxt2Click(KeyEvent event)
    {
        
      if(txtExCusNIC.getText().isEmpty())
        {
            txtExCusID.setDisable(false);
        }
        else{txtExCusID.setDisable(true);
      txtExCusID.setText("1");
      }  
   
    }
    
    // find ex Customer 
    String q=null;
    @FXML
    private void handleFindAction(ActionEvent event)
    {
    int exCusID= Integer.parseInt(txtExCusID.getText());
    String eCusNIC = txtExCusNIC.getText();
    if (txtExCusNIC.getText().isEmpty())
    {
    q="select * from customer where customerID='"+exCusID+"'";
    }
    else
    {
      
    q="select * from customer where NIC='"+eCusNIC+"'";
    }
    Customer exCus= new Customer();
    System.out.println(q);
    exCus.findCus(q);
    lblExID.setText(exCus.getsCusID());
    lblExName.setText(exCus.getsName());
    lblExNIC.setText(exCus.getsNic());
    lblExMob.setText(exCus.getsMobile());
    lblExAddress.setText(exCus.getsAddress());
    
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Customer cus= new Customer();
    lblID.setText(cus.calNowCusID());
    }    
    
}
