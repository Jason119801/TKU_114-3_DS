import java.util.ArrayList;
class CartItem {
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

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int q) {
        this.quantity += q;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }

    @Override
    public String toString() {
        return code + " - " + name + " (單價: $" + price + ", 數量: " + quantity + ", 小計: $" + (price * quantity) + ")";
    }
}

public class ShoppingCartSystem {
    private static ArrayList<CartItem> cart = new ArrayList<>();
        public static void main(String[] args) {
        addItem(new CartItem("P1", "Apple", 20, 2));
        addItem(new CartItem("P2", "Banana", 15, 5));
        addItem(new CartItem("P1", "Apple", 20, 3));
        
        System.out.println("目前總額: $" + calculateTotal());
        
        updateQuantity("P1", -5); 
        updateQuantity("P1", 10);
        
        removeItem("P2");
        
        System.out.println("\n--- 購物車清單 ---");
        for(CartItem item : cart) {
            System.out.println(item);
        }
        System.out.println("最終總額: $" + calculateTotal());
    }
    
    public static void addItem(CartItem item) {
        CartItem existing = findItem(item.getCode());
        if (existing != null) {
            existing.addQuantity(item.getQuantity());
            System.out.println("增加商品數量: " + existing.getName());
        } else {
            cart.add(item);
            System.out.println("加入購物車: " + item.getName());
        }
    }
    
    public static CartItem findItem(String code) {
        for (CartItem i : cart) {
            if (i.getCode().equalsIgnoreCase(code)) return i;
        }
        return null;
    }
    
    public static void updateQuantity(String code, int q) {
        if (q <= 0) {
            System.out.println("錯誤：數量必須大於 0");
            return;
        }
        CartItem item = findItem(code);
        if (item != null) {
            item.setQuantity(q);
            System.out.println("數量更新成功");
        }
    }
    
    public static void removeItem(String code) {
        CartItem item = findItem(code);
        if (item != null) {
            cart.remove(item);
            System.out.println("已移除商品: " + code);
        }
    }
    
    public static double calculateTotal() {
        double total = 0;
        for (CartItem i : cart) {
            total += i.getPrice() * i.getQuantity();
        }
        return total;
    }
}