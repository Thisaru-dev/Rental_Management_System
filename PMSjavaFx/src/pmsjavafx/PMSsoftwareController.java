/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pmsjavafx;

import static java.awt.Color.white;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import static javafx.scene.layout.Background.fill;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pmsjavafx.ItemAdd;

/**
 * FXML Controller class
 *
 * @author thisa
 */
public class PMSsoftwareController implements Initializable {
    
     Connection conn=databaseConnection.connect();;
    Statement stmt;
     ResultSet rs;
    PreparedStatement pstm;

  //side panel buttons
    
   @FXML
   private Button btnDashboard;
   @FXML
   private Button btnRent;
   @FXML
   private Button btnReturn;
   @FXML
   private Button btnItem;
   @FXML
   private Button btnCategory;
   @FXML
   private Button btnCustomer;
   
   @FXML
   private Button btnLogout;
   
   // side panel button imageViewer
   
   @FXML
   private ImageView imgDashboard;
   @FXML
   private ImageView imgRent;
   @FXML
   private ImageView imgReturn;
   @FXML
   private ImageView imgItem;
   @FXML
   private ImageView imgCategory;
   @FXML
   private ImageView imgCustomer;
   
   // panels
   
   @FXML
   private AnchorPane panelDashboard;
   @FXML
   private AnchorPane panelRent;
   @FXML
   private AnchorPane panelReturn;
   @FXML
   private AnchorPane panelItem;
   @FXML
   private AnchorPane panelCategory;
   
   
   
   //Side Navigation panel events
   String white="#ffffff";
    private ObservableList<CusOblist> ListM;
    private ObservableList<CusOblist> ListC;
    private ObservableList<CatOblist> Lista;
    private ObservableList<CatOblist> ListA;
   @FXML
   private void handleDashAction(ActionEvent event){
   
   panelDashboard.setVisible(true);
   panelRent.setVisible(false);
   panelReturn.setVisible(false);
   panelItem.setVisible(false);
   panelCategory.setVisible(false);
   
   
   btnDashboard.setBackground(Background.fill(Color.web(white)));
   btnDashboard.setStyle("-fx-text-fill:#000000;");
   
   Image imgdash = new Image (getClass().getResourceAsStream("Image\\Dashboard black.png"));
   imgDashboard.setImage(imgdash);
   
   
   btnRent.setBackground(null);
   btnRent.setStyle("-fx-text-fill:#ffffff;");
   
   btnReturn.setBackground(null);
   btnReturn.setStyle("-fx-text-fill:#ffffff;");
   
   btnItem.setBackground(null);
   btnItem.setStyle("-fx-text-fill:#ffffff;");
   
   btnCategory.setBackground(null);
   btnCategory.setStyle("-fx-text-fill:#ffffff;");
   
   Image imgrent = new Image (getClass().getResourceAsStream("Image\\Basket white.png"));
   imgRent.setImage(imgrent);
   
   Image imgreturn = new Image (getClass().getResourceAsStream("Image\\Checked Checkbox white.png"));
   imgReturn.setImage(imgreturn);
   
   Image imgitem = new Image (getClass().getResourceAsStream("Image\\Content white.png"));
   imgItem.setImage(imgitem);
   
   Image imgcat = new Image (getClass().getResourceAsStream("Image\\New Window white.png"));
   imgCategory.setImage(imgcat);
   
   }
   
   @FXML
   private void handleRentAction(ActionEvent event){
   
   panelDashboard.setVisible(false);
   panelRent.setVisible(true);
   panelReturn.setVisible(false);
   panelItem.setVisible(false);
   panelCategory.setVisible(false);
  
   btnRent.setBackground(Background.fill(Color.web(white)));
   btnRent.setStyle("-fx-text-fill:#000000;");
   
   Image imgrent = new Image (getClass().getResourceAsStream("Image\\Basket black.png"));
   imgRent.setImage(imgrent);
   
   btnDashboard.setBackground(null);
   btnDashboard.setStyle("-fx-text-fill:#ffffff;");
   
   btnReturn.setBackground(null);
   btnReturn.setStyle("-fx-text-fill:#ffffff;");
   
   btnItem.setBackground(null);
   btnItem.setStyle("-fx-text-fill:#ffffff;");
   
   btnCategory.setBackground(null);
   btnCategory.setStyle("-fx-text-fill:#ffffff;");
   
   
   Image imgdash = new Image (getClass().getResourceAsStream("Image\\Dashboard white.png"));
   imgDashboard.setImage(imgdash);
   
   Image imgreturn = new Image (getClass().getResourceAsStream("Image\\Checked Checkbox white.png"));
   imgReturn.setImage(imgreturn);
   
   Image imgitem = new Image (getClass().getResourceAsStream("Image\\Content white.png"));
   imgItem.setImage(imgitem);
   
   Image imgcat = new Image (getClass().getResourceAsStream("Image\\New Window white.png"));
   imgCategory.setImage(imgcat);
   
   // rent id show
   nowtId();
   // rent item show on table
   showRentpnItem();
   updateCmb2();
   }
   
   @FXML
   private void handleReturnAction(ActionEvent event){
       
   panelDashboard.setVisible(false);
   panelRent.setVisible(false);
   panelReturn.setVisible(true);
   panelItem.setVisible(false);
   panelCategory.setVisible(false);
   
   btnReturn.setBackground(Background.fill(Color.web(white)));
   btnReturn.setStyle("-fx-text-fill:#000000;");
   
   Image imgreturn = new Image (getClass().getResourceAsStream("Image\\Checked Checkbox black.png"));
   imgReturn.setImage(imgreturn);
   
   btnRent.setBackground(null);
   btnRent.setStyle("-fx-text-fill:#ffffff;");
   
   btnDashboard.setBackground(null);
   btnDashboard.setStyle("-fx-text-fill:#ffffff;");
   
   btnItem.setBackground(null);
   btnItem.setStyle("-fx-text-fill:#ffffff;");
   
   btnCategory.setBackground(null);
   btnCategory.setStyle("-fx-text-fill:#ffffff;");
   
   
   Image imgdash = new Image (getClass().getResourceAsStream("Image\\Dashboard white.png"));
   imgDashboard.setImage(imgdash);
   
   Image imgrent = new Image (getClass().getResourceAsStream("Image\\Basket white.png"));
   imgRent.setImage(imgrent);
   
   Image imgitem = new Image (getClass().getResourceAsStream("Image\\Content white.png"));
   imgItem.setImage(imgitem);
   
   Image imgcat = new Image (getClass().getResourceAsStream("Image\\New Window white.png"));
   imgCategory.setImage(imgcat);
   
   }
   
   @FXML
   private void handleItemAction(ActionEvent event){
   
   panelDashboard.setVisible(false);
   panelRent.setVisible(false);
   panelReturn.setVisible(false);
   panelItem.setVisible(true);
   panelCategory.setVisible(false);
   
   btnItem.setBackground(Background.fill(Color.web(white)));
   btnItem.setStyle("-fx-text-fill:#000000;");
   
   Image imgitem = new Image (getClass().getResourceAsStream("Image\\Content black.png"));
   imgItem.setImage(imgitem);
   
   btnRent.setBackground(null);
   btnRent.setStyle("-fx-text-fill:#ffffff;");
   
   btnReturn.setBackground(null);
   btnReturn.setStyle("-fx-text-fill:#ffffff;");
   
   btnDashboard.setBackground(null);
   btnDashboard.setStyle("-fx-text-fill:#ffffff;");
   
   btnCategory.setBackground(null);
   btnCategory.setStyle("-fx-text-fill:#ffffff;");
   
   
   Image imgdash = new Image (getClass().getResourceAsStream("Image\\Dashboard white.png"));
   imgDashboard.setImage(imgdash);
   
   Image imgrent = new Image (getClass().getResourceAsStream("Image\\Basket white.png"));
   imgRent.setImage(imgrent);
   
   Image imgreturn = new Image (getClass().getResourceAsStream("Image\\Checked Checkbox white.png"));
   imgReturn.setImage(imgreturn);
   
   Image imgcat = new Image (getClass().getResourceAsStream("Image\\New Window white.png"));
   imgCategory.setImage(imgcat);
   
   
   }
   
   
   @FXML
   private void handleCatAction(ActionEvent event){
   
   panelDashboard.setVisible(false);
   panelRent.setVisible(false);
   panelReturn.setVisible(false);
   panelItem.setVisible(false);
   panelCategory.setVisible(true);
       
   
   btnCategory.setBackground(Background.fill(Color.web(white)));
   btnCategory.setStyle("-fx-text-fill:#000000;");
   
   Image imgcat = new Image (getClass().getResourceAsStream("Image\\New Window black.png"));
   imgCategory.setImage(imgcat);
   
   btnRent.setBackground(null);
   btnRent.setStyle("-fx-text-fill:#ffffff;");
   
   btnReturn.setBackground(null);
   btnReturn.setStyle("-fx-text-fill:#ffffff;");
   
   btnItem.setBackground(null);
   btnItem.setStyle("-fx-text-fill:#ffffff;");
   
   btnDashboard.setBackground(null);
   btnDashboard.setStyle("-fx-text-fill:#ffffff;");
   
   
   Image imgdash = new Image (getClass().getResourceAsStream("Image\\Dashboard white.png"));
   imgDashboard.setImage(imgdash);
   
   Image imgrent = new Image (getClass().getResourceAsStream("Image\\Basket white.png"));
   imgRent.setImage(imgrent);
   
   Image imgreturn = new Image (getClass().getResourceAsStream("Image\\Checked Checkbox white.png"));
   imgReturn.setImage(imgreturn);
   
   Image imgitem = new Image (getClass().getResourceAsStream("Image\\Content white.png"));
   imgItem.setImage(imgitem);
   
   //getNowID();
   showCus();
   showCat();
   }
   /*private void getNowID(){
   Customer getID = new Customer();
   String i=getID.calNowCusID();
    setNowCusID(i);
   }*/
   
   @FXML
   private void handleLogoutAction(ActionEvent event){
   Stage stage = (Stage) btnLogout.getScene().getWindow();
    stage.close();
   
   }
   
   
   
   //Item panel 
   
   @FXML
   private TextField txtItemid;
   
   @FXML
   private ComboBox cmbCategory;
   
   @FXML
   private TextField txtModel;
           
   @FXML
   private TextField txtDescription;
   
   @FXML
   private TextField txtPrice;
   
   @FXML
   private ComboBox cmbAvailability;
    
   
   @FXML 
   private Button btnAdd;
   @FXML 
   private Button btnUpdate;
   @FXML 
   private Button btnDelete;
   @FXML 
   private Button btnClear;
   
   @FXML
   private TableView tbItem;
   // Table coulumn 
   @FXML
   private TableColumn<ItemAdd,Integer> colItemID;
   @FXML
   private TableColumn<ItemAdd,String> colCategory;
   @FXML
   private TableColumn<ItemAdd,String> colModel;
   @FXML
   private TableColumn<ItemAdd,String> colDes;
   @FXML
   private TableColumn<ItemAdd,Double> colPrice;
   @FXML
   private TableColumn<ItemAdd,String> colAvailability;
   
   ObservableList<ItemAdd> listM;
    
   
   
   
   // create a items obj
   
   
   // addItem button
   @FXML
   private void handleAddItemAction(ActionEvent event){
       
       // item panel components values pass to the variables
   int itemid=Integer.parseInt(txtItemid.getText());
   String category= cmbCategory.getSelectionModel().getSelectedItem().toString();
   String model = txtModel.getText();
   String description = txtDescription.getText();
   String availability = cmbAvailability.getSelectionModel().getSelectedItem().toString();
   double price=Double.parseDouble(txtPrice.getText());
       
       Items items = new Items(itemid,category,model,description,availability,price);
       items.addItem();
       showItem();
       
      
       
   }
   //UpdatebtnItem 
   @FXML
   private void handleUpdateItemAction(ActionEvent event){
   
    if(tbItem.getSelectionModel().getSelectedIndex()>=0)
     {
         // item panel components values pass to the variables
   int itemid=Integer.parseInt(txtItemid.getText());
   String category= cmbCategory.getSelectionModel().getSelectedItem().toString();
   String model = txtModel.getText();
   String description = txtDescription.getText();
   String availability = cmbAvailability.getSelectionModel().getSelectedItem().toString();
   double price=Double.parseDouble(txtPrice.getText());
         
       Items items = new Items(itemid,category,model,description,availability,price);
       items.updateItem();
       showItem();
     } 
     else
     {
       JOptionPane.showMessageDialog(null,"Please select a row !","Message",JOptionPane.ERROR_MESSAGE);
     }
   }
   
   //deleteItembtn
   @FXML
   private void handleDeleteItemAction(ActionEvent event){
   
   if(tbItem.getSelectionModel().getSelectedIndex()>=0)
   {
       
       // item panel components values pass to the variables
   int itemid=Integer.parseInt(txtItemid.getText());
   String category= cmbCategory.getSelectionModel().getSelectedItem().toString();
   String model = txtModel.getText();
   String description = txtDescription.getText();
   String availability = cmbAvailability.getSelectionModel().getSelectedItem().toString();
   double price=Double.parseDouble(txtPrice.getText());
       
       Items items = new Items(itemid,category,model,description,availability,price);
       items.deleteItem();
       showItem();  
   }
   
   else{JOptionPane.showMessageDialog(null,"Please select a row !","Message",JOptionPane.ERROR_MESSAGE);}
   }
   
   // select table row
   @FXML
   private void getRow(MouseEvent event){
   Integer index=tbItem.getSelectionModel().getSelectedIndex();
   
   if(index<=-1){return;}
   
       txtItemid.setText(colItemID.getCellData(index).toString());
       cmbCategory.setValue(colCategory.getCellData(index).toString());
       txtModel.setText(colModel.getCellData(index).toString());
       txtDescription.setText(colDes.getCellData(index).toString());
       cmbAvailability.setValue(colAvailability.getCellData(index).toString());
       txtPrice.setText(colPrice.getCellData(index).toString());
   
   }
   
  // Clear all txt boxes
   @FXML
   private void handleCleartxtBox(ActionEvent event){
   txtItemid.clear();
   cmbCategory.setValue(null);
   txtModel.clear();
   txtDescription.clear();
   cmbAvailability.setValue(null);
   txtPrice.clear();
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   //Combobox update
   
    private void updateCmb()
    {
    cmbAvailability.setItems(FXCollections.observableArrayList("Yes","No"));
    try
    {
        
    
    pstm=conn.prepareStatement("select * from category");
    rs = pstm.executeQuery();
    while(rs.next())
    {
    cmbCategory.getItems().addAll(rs.getString("categoryName"));
    }
    
    }
    catch(Exception e){System.out.print(e);}
    }
    
   //Item Table Data Show
    
   private ObservableList<ItemAdd> getDataItem(){
   
   ObservableList<ItemAdd> list = FXCollections.observableArrayList();
   try
   {
   
    PreparedStatement pstm=conn.prepareStatement("select * from equipment");
    ResultSet rs=pstm.executeQuery();
   
    while(rs.next())
    {
        
    list.add(new ItemAdd(rs.getInt("equipmentID"), rs.getString("category"), rs.getString("model"), rs.getString("eDescription"), rs.getString("availability"), rs.getDouble("price")));

    }
   
   }
   
   catch(Exception e){System.out.println(e);} 
   return list;
   }
   
   
   // show item table calling method
    
   private void showItem(){
   
      colItemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
      colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));  
      colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
      colDes.setCellValueFactory(new PropertyValueFactory<>("description"));
      colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
      colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
      
      
      listM=getDataItem();
      tbItem.setItems(listM);
   
   }
   
  
    
   
   //*********** Rent Panel *************//
   
   //Customer button
   @FXML
   private Button btnCus;
   
   //Detail Boxes
   @FXML
   private Label lblOrderID;
   @FXML
   private Label lblDate;
   @FXML
   private TextField txtCusID;
   @FXML
   private DatePicker dtRent;
   @FXML
   private DatePicker dtReturn;
   @FXML
   private Label lblDuration;
   @FXML
   private TextField txtAdvance;
   @FXML
   private Label lblTotal;
   @FXML
   private AnchorPane apCus;
   
   // main Button
   @FXML
   private Button btnRentItem;
   @FXML
   private Button btnReciept;
   // table name
   @FXML
   private TableView tbRentpn;
   // table column 
   @FXML
   private TableColumn<ItemAdd,Integer> colItID;
   @FXML
   private TableColumn<ItemAdd,String> colCat;
   @FXML
   private TableColumn<ItemAdd,String> colMod;
   @FXML
   private TableColumn<ItemAdd,String> colDesc;
   @FXML
   private TableColumn<ItemAdd,Double> colPri;
   
   // add item to the list panel
   @FXML
   private TextField txtIDfind;
   @FXML
   private Button btnAddList;
   
   @FXML
   private ComboBox cmbCat;
   
   
   
   @FXML
   private Button btnFind2;
   
   // rent 
   
   
   
   
   @FXML
   private void handleCusAction(ActionEvent event){
   
         try {
             
            Stage upperstage = new Stage();
            
            Parent upperRoot =  FXMLLoader.load(getClass().getResource("Customer.fxml"));
            upperstage.setScene(new Scene(upperRoot));
            upperstage.show();
             
         } catch (IOException ex) {
             Logger.getLogger(PMSsoftwareController.class.getName()).log(Level.SEVERE, null, ex);
         }
     //txtCusID.setText("pass una");
   }
   
    public void setCusID(String a)
   {
       if(!a.isEmpty()){
   txtCusID.setText(a);
   System.out.println(a);
   }
   }
    
    /*** method for cal duration****/
    public long calDuration()
    {
    LocalDate date1=dtRent.getValue();
    LocalDate date2=dtReturn.getValue();
    
    Duration duration = Duration.between(date1, date2);
        
        long x=duration.toDays();
    return x;
    }
   @FXML
   private void handleRentbtnAction(ActionEvent event){
   RentOrder rentorder=new RentOrder();
   
   
   }
   
   /*****rent item table show ******/
   String query;
   private ObservableList<ItemAdd> getDataItem2(){
   
   ObservableList<ItemAdd> list = FXCollections.observableArrayList();
   try
   {
   
    PreparedStatement pstm=conn.prepareStatement(query);
    ResultSet rs=pstm.executeQuery();
   
    while(rs.next())
    {
        
    list.add(new ItemAdd(rs.getInt("equipmentID"), rs.getString("category"), rs.getString("model"), rs.getString("eDescription"), rs.getDouble("price")));

    }
   
   }
   
   catch(Exception e){System.out.println(e);} 
   return list;
   }
   
   
   // show item table calling method
    
   private void showRentpnItem(){
   
      colItID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
      colCat.setCellValueFactory(new PropertyValueFactory<>("category"));  
      colMod.setCellValueFactory(new PropertyValueFactory<>("model"));
      colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
      colPri.setCellValueFactory(new PropertyValueFactory<>("price"));
      
      
      listM=getDataItem2();
      tbRentpn.setItems(listM);
   
   }
   
// updateCombo box 
   
    private void updateCmb2()
    {
   cmbCat.getItems().clear();
    try
    {
        
    
    pstm=conn.prepareStatement("select * from category");
    rs = pstm.executeQuery();
    while(rs.next())
    {
    cmbCat.getItems().addAll(rs.getString("categoryName"));
    
    
    
    }
    
    }
    catch(Exception e){System.out.print(e);}
    
    }
   String categoryitem;
   @FXML
   private void handleSelectedAction(ActionEvent event){
       
   sqlChange();
    showRentpnItem();
   
   }
   
   private void sqlChange(){
   if(!cmbCat.getSelectionModel().isEmpty()&&txtIDfind.getText().isEmpty())
   {
    query="select * from equipment where category='"+cmbCat.getSelectionModel().getSelectedItem().toString()+"'and Availability='Yes'";
   }
   else if(txtIDfind.getText().isEmpty()&&cmbCat.getSelectionModel().isEmpty())
   {
   query= "select * from equipment where Availability='Yes'";
   }
   else if(cmbCat.getSelectionModel().isEmpty()&&!txtIDfind.getText().isEmpty())
   {    
   query="select * from equipment where equipmentID='"+txtIDfind.getText()+"'and Availability='Yes'";
   }
   }
  
   private void nowtId()
   {
       RentOrder id = new RentOrder();
       
   lblOrderID.setText("Rent ID : "+id.calNowRentID());
   
   }
   
   
   @FXML
   private void handleAddtbAction(ActionEvent event)
   {
   
   
   }
   
   
  
   
   
   
   
   
   
   
   
   
   
   
   /***** Customer pane Components ******/
   @FXML
   private TextField txtcuID;
   @FXML
   private TextField txtcName;
   @FXML
   private TextField txtcNIC;
   @FXML
   private TextField txtcMob; 
   @FXML
   private TextField txtcAddress;
   @FXML
   private Button btncAdd;
   @FXML
   private Button btncRemove;
   @FXML
   private Button txtcClear;
   
   // customer table columns
   @FXML
   private TableView tbCus;
   @FXML
   private TableColumn<CusOblist,Integer> cuID;
   @FXML
   private TableColumn<CusOblist,String> cn;
   @FXML
   private TableColumn<CusOblist,String> cnic;
   @FXML
   private TableColumn<CusOblist,String> cm;
   @FXML
   private TableColumn<CusOblist,String> ca;
   
   
   
   /**** category pane Components*****/
   @FXML
   private TextField txtCaID;
   @FXML
   private TextField txtCategory;
   @FXML
   private Button btncaAdd;
   @FXML
   private Button btncaRemove;
   @FXML
   private Button btncaClear;
   
   // table components
  @FXML
  private TableView cattb;
  @FXML
   private TableColumn<CatOblist,Integer> catID;
  @FXML
   private TableColumn<CatOblist,String> catn;
   
   
   
   /**** customer pane events *****/
   @FXML
   private void handleAddcusAction(ActionEvent event)
   {
   String name=txtcName.getText();
   String nic=txtcNIC.getText();
   String mob=txtcMob.getText();
   String address=txtcAddress.getText();
   
   Customer addcus = new Customer(name,nic,mob,address);
   addcus.addCustomer();
   showCus();
   }
   // show entering cus id
  /*private void setNowCusID(String id)
  {
  
  
  }*/
  
  @FXML
  private void handleRemovecusAction(ActionEvent event)
  {
     int x= Integer.parseInt(txtcuID.getText());
   Customer removecus = new Customer(x);
   removecus.deleteCustomer();
   showCus();
  }
   
  @FXML
  private void handleCusclearAction(ActionEvent event)
  {
   txtcuID.clear();
   txtcName.clear();
   txtcNIC.clear();
   txtcMob.clear();
   txtcAddress.clear();  
      
  }
   // show Customers on The table
   private ObservableList<CusOblist> getDataItem34(){
   
   ObservableList<CusOblist> list3 = FXCollections.observableArrayList();
   try
   {
   
    PreparedStatement pstm=conn.prepareStatement("select * from customer");
    ResultSet rs=pstm.executeQuery();
   
    while(rs.next())
    {
        
    list3.add(new CusOblist(rs.getInt("customerID"), rs.getString("customerName"), rs.getString("NIC"), rs.getString("phone"), rs.getString("address")));

    }
  
   }
   
   catch(SQLException e){System.out.println(e);} 
   return list3;
   }
   
   
   // show item table calling method
    
   private void showCus(){
   
      cuID.setCellValueFactory(new PropertyValueFactory<>("custiD"));
      cn.setCellValueFactory(new PropertyValueFactory<>("name"));  
      cnic.setCellValueFactory(new PropertyValueFactory<>("nic"));
      cm.setCellValueFactory(new PropertyValueFactory<>("mobile"));
      ca.setCellValueFactory(new PropertyValueFactory<>("address"));
     
      
      //System.out.println();
      ListM=getDataItem34();
      tbCus.setItems(ListM);
   
   }
   @FXML
   private void getRowMouse(MouseEvent event){
   Integer index=tbCus.getSelectionModel().getSelectedIndex();
   
   if(index<=-1){return;}
   
       txtcuID.setText(cuID.getCellData(index).toString());
       txtcName.setText(cn.getCellData(index).toString());
       txtcNIC.setText(cnic.getCellData(index).toString());
       txtcMob.setText(cm.getCellData(index).toString());
       txtcAddress.setText(ca.getCellData(index).toString());
      
   
   /*txtcName
   txtcNIC
   txtcMob
   txtcAddress
     */  
       
       
   }
   
   // show Categories on The table
   private ObservableList<CatOblist> getDataItem5(){
   
   ObservableList<CatOblist> list4;
         list4 = FXCollections.observableArrayList();
   try
   {
   
    PreparedStatement pstm=conn.prepareStatement("select * from category");
    ResultSet rs=pstm.executeQuery();
   
    while(rs.next())
    {
        
    list4.add(new CatOblist(rs.getInt("categoryID"), rs.getString("categoryName")));

    }
  
   }
   
   catch(SQLException e){System.out.println(e);} 
   return list4;
   }
   
   
   // show item table calling method
    
   private void showCat(){
   
      catID.setCellValueFactory(new PropertyValueFactory<>("catiD"));
      catn.setCellValueFactory(new PropertyValueFactory<>("cname"));  
      
     
      
      //System.out.println();
      ListA=getDataItem5();
      cattb.setItems(ListA);
   
   }
   
   @FXML
   private void getRowMouse2(MouseEvent event){
   Integer index=cattb.getSelectionModel().getSelectedIndex();
   
   if(index<=-1){return;}
   
       txtCaID.setText(catID.getCellData(index).toString());
       txtCategory.setText(catn.getCellData(index).toString());
       
      
   
   /*txtcName
   txtcNIC
   txtcMob
   txtcAddress
     */  
       
       
   }
   
   
   @FXML
   private void handleAddCatAction(ActionEvent event)
   {
   String x =txtCaID.getText();
   String y=txtCategory.getText();
       int cid= Integer.parseInt(x);
   showCat();
   }
   
   @FXML
   private void handleDeleteCatAction(ActionEvent event)
   {
   String a =txtCaID.getText();
   String b=txtCategory.getText();
       int cid= Integer.parseInt(a);
      Category addcategory = new Category(cid,b);
   addcategory.deleteCategory();
   showCat();
   }
   
   
    @FXML
   private void handleClearCatAction(ActionEvent event)
   {
   txtCaID.clear();
   txtCategory.clear();
      
   }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     showItem();
      cmbCategory.getItems().clear();
      updateCmb();
    }    

}