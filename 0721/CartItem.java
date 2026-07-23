public class CartItem {
    private String code;
    private String name;
    private double price;
    private int quantity;

    public CartItem(String code, String name, double price, int quantity) {
        this.code = code; 
        this.name = name; 
        this.price = price; 
        this.quantity = quantity;
    }

    public String getCode() { return code; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    
    public void addQuantity(int q) { this.quantity += q; }
    public void setQuantity(int q) { 
        if (q > 0) this.quantity = q; 
    }
    
    @Override
    public String toString() { 
        return code + " | " + name + " | $" + price + " x " + quantity + " = $" + (price * quantity); 
    }
}