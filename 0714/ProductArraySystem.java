import java.util.Scanner;

public class ProductArraySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
        int[] prices = {890, 490, 5200, 250, 1290};
        int[] stocks = {12, 20, 5, 30, 8};

        int choice = -1;
        while (choice != 0) {
            printMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayAllProducts(names, prices, stocks);
                    break;
                case 2:
                    searchProduct(sc, names, prices, stocks);
                    break;
                case 3:
                    buyProduct(sc, names, prices, stocks);
                    break;
                case 4:
                    restockProduct(sc, names, stocks);
                    break;
                case 5:
                    displayLowStock(names, stocks);
                    break;
                case 6:
                    displayTotalValue(names, prices, stocks);
                    break;
                case 0:
                    System.out.println("\n=== 系統結束摘要 ===");
                    displayAllProducts(names, prices, stocks);
                    displayTotalValue(names, prices, stocks);
                    System.out.println("感謝使用本系統！");
                    break;
                default:
                    System.out.println("請重新輸入。");
            }
        }
        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n=== 商品管理系統 ===");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 依商品編號查詢");
        System.out.println("3. 購買商品");
        System.out.println("4. 補充商品庫存");
        System.out.println("5. 顯示低庫存商品(<10)");
        System.out.println("6. 顯示全部庫存總價值");
        System.out.println("0. 結束系統");
        System.out.print("請輸入選項：");
    }

    public static int readValidId(Scanner sc, int length) {
        System.out.print("請輸入商品編號 (1~" + length + ")：");
        int id = sc.nextInt();
        if (id < 1 || id > length) {
            System.out.println("查無此商品編號！");
            return -1;
        }
        return id - 1; // 轉換為陣列索引
    }

    public static void displayAllProducts(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n--- 庫存清單 ---");
        for (int i = 0; i < names.length; i++) {
            System.out.println("編號 " + (i + 1) + " | " + names[i] + " | 單價: $" + prices[i] + " | 庫存: " + stocks[i]);
        }
    }

    public static void searchProduct(Scanner sc, String[] names, int[] prices, int[] stocks) {
        int index = readValidId(sc, names.length);
        if (index != -1) {
            System.out.println("\n--- 查詢結果 ---");
            System.out.println("商品名稱：" + names[index]);
            System.out.println("商品單價：$" + prices[index]);
            System.out.println("目前庫存：" + stocks[index]);
        }
    }

    public static void buyProduct(Scanner sc, String[] names, int[] prices, int[] stocks) {
        int index = readValidId(sc, names.length);
        if (index != -1) {
            System.out.println("目前 " + names[index] + " 庫存為 " + stocks[index]);
            System.out.print("請輸入購買數量：");
            int qty = sc.nextInt();

            if (qty <= 0) {
                System.out.println("購買數量必須大於 0！");
            } else if (qty > stocks[index]) {
                System.out.println("庫存不足！");
            } else {
                stocks[index] -= qty;
                int cost = prices[index] * qty;
                System.out.println("購買成功！總共花費 $" + cost + "，" + names[index] + " 剩餘庫存：" + stocks[index]);
            }
        }
    }

    public static void restockProduct(Scanner sc, String[] names, int[] stocks) {
        int index = readValidId(sc, names.length);
        if (index != -1) {
            System.out.print("請輸入補貨數量：");
            int qty = sc.nextInt();

            if (qty <= 0) {
                System.out.println("補貨數量必須大於 0！");
            } else {
                stocks[index] += qty;
                System.out.println("補貨成功！" + names[index] + " 最新庫存：" + stocks[index]);
            }
        }
    }

    public static void displayLowStock(String[] names, int[] stocks) {
        System.out.println("\n--- 低庫存警報 (< 10) ---");
        boolean found = false;
        for (int i = 0; i < stocks.length; i++) {
            if (stocks[i] < 10) {
                System.out.println("編號 " + (i + 1) + " | " + names[i] + " | 庫存僅剩: " + stocks[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("目前所有商品庫存皆充足。");
        }
    }

    public static void displayTotalValue(String[] names, int[] prices, int[] stocks) {
        int totalValue = 0;
        for (int i = 0; i < names.length; i++) {
            totalValue += (prices[i] * stocks[i]);
        }
        System.out.println("\n當前全部庫存總價值為：$" + totalValue);
    }
}