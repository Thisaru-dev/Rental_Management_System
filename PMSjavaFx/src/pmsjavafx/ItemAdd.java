
package pmsjavafx;




public class ItemAdd {
    
    
    
    
     private int itemID;
     private String category;
     private String model;
     private String description;
     private String availability;
     private double price;

    public ItemAdd(int itemID, String category, String model, String description, String availability, double price) {
        this.itemID = itemID;
        this.category = category;
        this.model = model;
        this.description = description;
        this.availability = availability;
        this.price = price;
    }

     public ItemAdd(int itemID, String category, String model, String description, double price) {
        this.itemID = itemID;
        this.category = category;
        this.model = model;
        this.description = description;
        this.price = price;
    }
    
    
    
    public int getItemID() {
        return itemID;
    }

    public String getCategory() {
        return category;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public String getAvailability() {
        return availability;
    }

    public double getPrice() {
        return price;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
  
    
    
}
