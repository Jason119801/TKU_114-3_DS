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
    public Course(String code, String name) {
        this.code = code;
        this.name = name;
        this.capacity = 30; // 可以給一個預設的容量
        this.enrolled = 0;
    }
    public String getCode() { return code; }
    public String getName() { return name; } // 補上getName
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    
    public void addQuantity(int q) { this.quantity += q; }
    
    public void setQuantity(int q) { 
        // 數量小於或等於 0 時不接受更新
        if (q > 0) {
            this.quantity = q; 
        }
    }
    
    @Override
    public String toString() { 
        return code + " | " + name + " | $" + price + " x " + quantity + " = $" + (price * quantity); 
    }
}