import java.util.ArrayList;

public class ShoppingCartSystem {
    private static ArrayList<CartItem> cart = new ArrayList<>();
    
    public static void main(String[] args) {
        addItem(new CartItem("P1", "Apple", 20, 2));
        addItem(new CartItem("P2", "Banana", 15, 5));
        addItem(new CartItem("P1", "Apple", 20, 3)); // 應合併數量
        
        System.out.println("目前總額: $" + calculateTotal());
        
        updateQuantity("P1", -5); // 應拒絕
        updateQuantity("P1", 10);
        
        removeItem("P2");
        
        System.out.println("--- 購物車清單 ---");
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