
package bestseller.tungnk;

public class BestSellerDTO {
    private int id;
    private String name;
    private double price;
    private int saled;

    public BestSellerDTO() {
    }

    public BestSellerDTO(int id, String name, double price, int saled) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.saled = saled;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getSaled() {
        return saled;
    }
    
    
}
