import java.util.Arrays;
import java.util.Scanner;

public class ProductDataManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 初始原始資料
        String[] records = {
            "Keyboard,890,12",
            "Mouse,490,20",
            "Monitor,5200,5",
            "USB Cable,250,30",
            "Headset,1290,8"
        };

        // 建立平行陣列
        String[] names = new String[records.length];
        int[] prices = new int[records.length];
        int[] stocks = new int[records.length];

        // 解析初始資料
        for (int i = 0; i < records.length; i++) {
            String[] parts = records[i].split(",");
            names[i] = parts[0];
            prices[i] = Integer.parseInt(parts[1]);
            stocks[i] = Integer.parseInt(parts[2]);
        }

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n=== 商品文字資料管理器 ===");
            System.out.println("1. 顯示商品表格");
            System.out.println("2. 搜尋商品名稱 (支援部分名稱)");
            System.out.println("3. 顯示低庫存商品");
            System.out.println("4. 顯示庫存總價值");
            System.out.println("5. 輸入新商品資料");
            System.out.println("0. 離開");
            System.out.print("請選擇功能：");
            
            // 避免輸入非數字導致錯誤
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("輸入無效，請輸入數字選項。");
                continue;
            }

            switch (choice) {
                case 1:
                    displayTable(names, prices, stocks);
                    break;
                case 2:
                    System.out.print("請輸入要搜尋的名稱：");
                    String keyword = sc.nextLine().toLowerCase();
                    searchProducts(names, prices, stocks, keyword);
                    break;
                case 3:
                    displayLowStock(names, prices, stocks);
                    break;
                case 4:
                    calculateTotalValue(names, prices, stocks);
                    break;
                case 5:
                    System.out.print("請輸入新商品資料 (格式：名稱,價格,庫存)：");
                    String newData = sc.nextLine();
                    boolean isValid = validateAndParseNewData(newData);
                    
                    if (isValid) {
                        // 若格式正確，擴充陣列並存入資料
                        String[] parts = newData.split(",");
                        names = Arrays.copyOf(names, names.length + 1);
                        prices = Arrays.copyOf(prices, prices.length + 1);
                        stocks = Arrays.copyOf(stocks, stocks.length + 1);
                        
                        names[names.length - 1] = parts[0];
                        prices[prices.length - 1] = Integer.parseInt(parts[1]);
                        stocks[stocks.length - 1] = Integer.parseInt(parts[2]);
                        
                        System.out.println("資料新增成功！");
                    }
                    break;
                case 0:
                    System.out.println("系統已結束。");
                    break;
                default:
                    System.out.println("無效選項，請重新輸入。");
            }
        }
        sc.close();
    }

    public static void displayTable(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n--- 商品表格 ---");
        System.out.printf("%-15s %-10s %-10s%n", "商品名稱", "價格", "庫存");
        System.out.println("------------------------------------");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-15s $%-9d %-10d%n", names[i], prices[i], stocks[i]);
        }
    }

    public static void searchProducts(String[] names, int[] prices, int[] stocks, String keyword) {
        System.out.println("\n--- 搜尋結果 ---");
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            // 使用 toLowerCase 達成不分大小寫的搜尋，contains 支援部分比對
            if (names[i].toLowerCase().contains(keyword)) {
                System.out.printf("%-15s $%-9d %-10d%n", names[i], prices[i], stocks[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("找不到符合「" + keyword + "」的商品。");
        }
    }

    public static void displayLowStock(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n--- 低庫存商品 (<10) ---");
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (stocks[i] < 10) {
                System.out.printf("%-15s $%-9d %-10d%n", names[i], prices[i], stocks[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("目前無低庫存商品。");
        }
    }

    public static void calculateTotalValue(String[] names, int[] prices, int[] stocks) {
        int total = 0;
        for (int i = 0; i < names.length; i++) {
            total += prices[i] * stocks[i];
        }
        System.out.println("\n目前庫存總價值：$" + total);
    }

    public static boolean validateAndParseNewData(String data) {
        // 例外處理邏輯：檢查格式與型態轉換
        try {
            String[] parts = data.split(",");
            
            if (parts.length != 3) {
                System.out.println("格式錯誤：必須包含名稱、價格、庫存，並以逗號分隔。");
                return false;
            }
            
            if (parts[0].trim().isEmpty()) {
                System.out.println("格式錯誤：商品名稱不能為空。");
                return false;
            }
            
            int price = Integer.parseInt(parts[1].trim());
            int stock = Integer.parseInt(parts[2].trim());
            
            if (price < 0 || stock < 0) {
                System.out.println("數值錯誤：價格與庫存不可為負數。");
                return false;
            }
            
            return true;

        } catch (NumberFormatException e) {
            System.out.println("數字轉換錯誤：價格與庫存必須為整數數字 (" + e.getMessage() + ")。");
            return false;
        } catch (Exception e) {
            System.out.println("未知的解析錯誤發生：" + e.getMessage());
            return false;
        }
    }
}