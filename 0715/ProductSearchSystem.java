import java.util.Scanner;

public class ProductSearchSystem {

    /*
    1. 輸入：選項 2，關鍵字 "  mOuSe  "
       預期：成功找到 Mouse，單價 490。

    2. 輸入：選項 2，關鍵字 "USB"
       預期：找不到 (因為完整名稱是 USB Cable)。

    3. 輸入：選項 3，關鍵字 "board"
       預期：列出 Keyboard。

    4. 輸入：選項 3，關鍵字 "o"
       預期：列出 Keyboard, Mouse, Monitor (都包含字母 o)。

    5. 輸入：選項 4
       預期：列出 "USB Cable"。

    6. 輸入：選項 5，關鍵字 "s"
       預期：顯示 Mouse (位置 3), USB Cable (位置 1), Headset (位置 4)。
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
        int[] prices = {890, 490, 5200, 250, 1290};
        int[] stocks = {12, 20, 5, 30, 8};

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n=== 商品搜尋系統 ===");
            System.out.println("1. 顯示全部商品");
            System.out.println("2. 完整名稱搜尋");
            System.out.println("3. 部分名稱搜尋");
            System.out.println("4. 顯示名稱最長的商品");
            System.out.println("5. 顯示商品名稱與關鍵字第一次出現的位置");
            System.out.println("0. 結束系統");
            System.out.print("請選擇功能：");
            
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("請輸入數字！");
                continue;
            }

            switch (choice) {
                case 1:
                    displayAll(names, prices, stocks);
                    break;
                case 2:
                    System.out.print("請輸入要搜尋的完整名稱：");
                    String exactKey = sc.nextLine();
                    searchExact(names, prices, stocks, exactKey);
                    break;
                case 3:
                    System.out.print("請輸入要搜尋的部分名稱：");
                    String partialKey = sc.nextLine();
                    searchPartial(names, prices, stocks, partialKey);
                    break;
                case 4:
                    findLongestNameProduct(names, prices, stocks);
                    break;
                case 5:
                    System.out.print("請輸入要找位置的關鍵字：");
                    String posKey = sc.nextLine();
                    findIndexPositions(names, posKey);
                    break;
                case 0:
                    System.out.println("系統已結束。");
                    break;
                default:
                    System.out.println("無效的選項。");
            }
        }
        sc.close();
    }

    public static void displayAll(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n--- 商品清單 ---");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " | $" + prices[i] + " | 庫存: " + stocks[i]);
        }
    }

    // 完整名稱搜尋 (忽略大小寫與前後空白)
    public static void searchExact(String[] names, int[] prices, int[] stocks, String keyword) {
        String target = keyword.trim();
        boolean found = false;
        System.out.println("\n--- 完整搜尋結果 ---");
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(target)) {
                System.out.println(names[i] + " | $" + prices[i] + " | 庫存: " + stocks[i]);
                found = true;
            }
        }
        if (!found) System.out.println("找不到完整名稱為「" + target + "」的商品。");
    }

    // 部分名稱搜尋 (忽略大小寫)
    public static void searchPartial(String[] names, int[] prices, int[] stocks, String keyword) {
        String target = keyword.toLowerCase();
        boolean found = false;
        System.out.println("\n--- 部分搜尋結果 ---");
        for (int i = 0; i < names.length; i++) {
            if (names[i].toLowerCase().contains(target)) {
                System.out.println(names[i] + " | $" + prices[i] + " | 庫存: " + stocks[i]);
                found = true;
            }
        }
        if (!found) System.out.println("找不到名稱包含「" + keyword + "」的商品。");
    }

    // 尋找名稱最長的商品
    public static void findLongestNameProduct(String[] names, int[] prices, int[] stocks) {
        int longestIndex = 0;
        for (int i = 1; i < names.length; i++) {
            if (names[i].length() > names[longestIndex].length()) {
                longestIndex = i;
            }
        }
        System.out.println("\n--- 名稱最長的商品 ---");
        System.out.println(names[longestIndex] + " | $" + prices[longestIndex] + " | 庫存: " + stocks[longestIndex]);
    }

    // 顯示商品名稱與關鍵字第一次出現的位置
    public static void findIndexPositions(String[] names, String keyword) {
        String target = keyword.toLowerCase();
        System.out.println("\n--- 關鍵字出現位置 ---");
        boolean foundAny = false;
        for (int i = 0; i < names.length; i++) {
            int pos = names[i].toLowerCase().indexOf(target);
            if (pos != -1) {
                System.out.println(names[i] + " -> 第一次出現在索引位置: " + pos);
                foundAny = true;
            }
        }
        if (!foundAny) System.out.println("沒有任何商品名稱包含此關鍵字。");
    }
}