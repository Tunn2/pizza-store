
package tungnk.orderdetail;

public class OrderDetailDTO {
    private int order_ID;
    private int product_ID;
    private int quantity;
    private double price;
    private String productName;

    public OrderDetailDTO(int order_ID, int product_ID, int quantity, double price) {
        this.order_ID = order_ID;
        this.product_ID = product_ID;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetailDTO(int quantity, double price, String productName) {
        
        this.quantity = quantity;
        this.price = price;
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    

    public OrderDetailDTO() {
    }

    public int getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(int order_ID) {
        this.order_ID = order_ID;
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}

