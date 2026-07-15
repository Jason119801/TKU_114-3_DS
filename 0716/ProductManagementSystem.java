public class ProductManagementSystem {

    // 顯示全部商品
    public static void displayAllProducts(Product[] products) {
        System.out.println("--- 目前商品列表 ---");
        for (Product p : products) {
            if (p != null) {
                System.out.println(p.toString());
            }
        }
        System.out.println("--------------------");
    }

    // 依完整名稱搜尋 (忽略大小寫與前後空白)
    public static Product searchProduct(Product[] products, String name) {
        if (name == null) return null;
        String searchName = name.trim();
        for (Product p : products) {
            if (p != null && p.getName().equalsIgnoreCase(searchName)) {
                return p;
            }
        }
        return null; // 找不到回傳 null
    }

    // 尋找陣列中的空位
    private static int findEmptyIndex(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                return i;
            }
        }
        return -1; // 陣列已滿
    }

    public static boolean addProduct(Product[] products, String name, int price, int stock) {
        if (searchProduct(products, name) != null) {
            System.out.println("新增失敗：商品名稱 [" + name.trim() + "] 已存在。");
            return false;
        }
        int emptyIndex = findEmptyIndex(products);
        if (emptyIndex == -1) {
            System.out.println("新增失敗：系統空間已滿，無法新增商品。");
            return false;
        }
        products[emptyIndex] = new Product(name, price, stock);
        System.out.println("新增成功：" + products[emptyIndex].getName());
        return true;
    }

    public static void sellProduct(Product[] products, String name, int quantity) {
        Product p = searchProduct(products, name);
        if (p == null) {
            System.out.println("出售失敗：找不到商品 [" + name + "]。");
            return;
        }
        if (p.sell(quantity)) {
            System.out.println("出售成功：賣出 " + quantity + " 個 " + p.getName() + "，剩餘庫存：" + p.getStock());
        } else {
            System.out.println("出售失敗：" + p.getName() + " 庫存不足或數量無效。");
        }
    }

    public static void restockProduct(Product[] products, String name, int quantity) {
        Product p = searchProduct(products, name);
        if (p == null) {
            System.out.println("補貨失敗：找不到商品 [" + name + "]。");
            return;
        }
        if (p.restock(quantity)) {
            System.out.println("補貨成功：" + p.getName() + " 增加 " + quantity + " 個，最新庫存：" + p.getStock());
        } else {
            System.out.println("補貨失敗：數量無效。");
        }
    }

    public static void changePrice(Product[] products, String name, int newPrice) {
        Product p = searchProduct(products, name);
        if (p == null) {
            System.out.println("改價失敗：找不到商品 [" + name + "]。");
            return;
        }
        if (p.setPrice(newPrice)) {
            System.out.println("改價成功：" + p.getName() + " 新價格為 " + p.getPrice());
        } else {
            System.out.println("改價失敗：無效的價格。");
        }
    }

    public static void displayLowStockProducts(Product[] products) {
        System.out.println("--- 低庫存商品警報 (<10) ---");
        boolean found = false;
        for (Product p : products) {
            if (p != null && p.isLowStock()) {
                System.out.println(p.getName() + " (目前庫存: " + p.getStock() + ")");
                found = true;
            }
        }
        if (!found) System.out.println("目前無低庫存商品。");
        System.out.println("---------------------------");
    }

    // 計算並顯示全部庫存總價值
    public static void displayTotalInventoryValue(Product[] products) {
        long totalValue = 0;
        int totalItems = 0;
        for (Product p : products) {
            if (p != null) {
                totalValue += p.getInventoryValue();
                totalItems++;
            }
        }
        System.out.println("--- 系統操作摘要 ---");
        System.out.println("目前系統商品總數：" + totalItems);
        System.out.println("全部庫存總價值：$" + totalValue);
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        Product[] products = new Product[10];
        products[0] = new Product("Apple", 30, 50);
        products[1] = new Product("Banana", 15, 5); // 低庫存
        products[2] = new Product("Orange", 25, 20);
        products[3] = new Product("Milk", 80, 15);
        products[4] = new Product("Bread", 45, 8); // 低庫存

        System.out.println("==== 系統測試開始 ====\n");

        System.out.println("[測試 1: 顯示全部商品]");
        displayAllProducts(products);

        System.out.println("\n[測試 2: 新增商品]");
        addProduct(products, "Coffee", 60, 30);

        System.out.println("\n[測試 3: 新增重複商品]");
        addProduct(products, "Apple", 35, 10);

        System.out.println("\n[測試 4: 搜尋商品 (輸入 ' mILk ')]");
        Product found = searchProduct(products, " mILk ");
        System.out.println("搜尋結果：" + (found != null ? found.toString() : "找不到"));

        System.out.println("\n[測試 5: 出售商品]");
        sellProduct(products, "Apple", 10);

        System.out.println("\n[測試 6: 超賣商品]");
        sellProduct(products, "Banana", 100);

        System.out.println("\n[測試 7: 補充庫存]");
        restockProduct(products, "Banana", 20);

        System.out.println("\n[測試 8: 修改價格]");
        changePrice(products, "Orange", 28);

        System.out.println("\n[測試 9: 顯示低庫存]");
        displayLowStockProducts(products);

        System.out.println("\n[測試 10: 陣列空間滿載測試]");
        addProduct(products, "Tea", 25, 40);
        addProduct(products, "Water", 20, 100);
        addProduct(products, "Juice", 35, 20);
        addProduct(products, "Cake", 90, 5);
        // 此時陣列 (長度10) 已滿，第11個會失敗
        addProduct(products, "Cookie", 40, 50); 

        // 顯示總價值與摘要 (結束)
        System.out.println("\n[系統關閉前摘要]");
        displayTotalInventoryValue(products);
    }
}