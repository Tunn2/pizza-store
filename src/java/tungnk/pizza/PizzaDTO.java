
package tungnk.pizza;

public class PizzaDTO {
    private int id;
    private String name;
    private int supplierID;
    private int categoryID;
    private double price;
    private int quantity;
    private String image;
    private String description;
    private boolean isSale;

    public PizzaDTO(int id, String name, int supplierID, int categoryID, double price, int quantity, String image, String description, boolean isSale) {
        this.id = id;
        this.name = name;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
        this.isSale = isSale;
    }

    public boolean isIsSale() {
        return isSale;
    }

    public void setIsSale(boolean isSale) {
        this.isSale = isSale;
    }
    
    

    public PizzaDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
   

}
