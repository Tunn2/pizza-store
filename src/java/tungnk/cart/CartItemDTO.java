/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.cart;

/**
 *
 * @author ktung
 */
public class CartItemDTO {
    private int itemID;
    private String itemName;
    private int quantity;
    private double unitPrice;

    public CartItemDTO() {
    }

    public CartItemDTO(int itemID, String itemName, int quantity, double unitPrice) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public double getSubTotal() {
        return quantity * unitPrice;
    }
}
