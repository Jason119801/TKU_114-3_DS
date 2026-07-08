import java.util.Scanner;

public class OrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int totalItems = 0;   // 總數量
        int totalAmount = 0;  // 總金額
        int choice = -1;

        // 選擇 0 時結帳並結束
        while (choice != 0) {
            System.out.println("\n=== Order Menu ===");
            System.out.println("1. Black tea  $30");
            System.out.println("2. Green tea  $35");
            System.out.println("3. Coffee     $50");
            System.out.println("0. Checkout");
            System.out.print("請輸入選項：");
            
            choice = scanner.nextInt();

            if (choice == 0) { break; }

            // 判斷是否為有效商品選項 (1~3)
            if (choice >= 1 && choice <= 3) {
                System.out.print("請輸入數量：");
                int quantity = scanner.nextInt();

                // 確認數量大於 0
                if (quantity > 0) {
                    int price = 0;
                    
                    switch (choice) {
                        case 1:
                            price = 30;
                            break;
                        case 2:
                            price = 35;
                            break;
                        case 3:
                            price = 50;
                            break;
                    }
                    
                    int subtotal = price * quantity;
                    System.out.println("Subtotal: " + subtotal);
                    
                    // 累加數量與金額
                    totalItems += quantity;
                    totalAmount += subtotal;
                    
                } else {
                    System.out.println("數量必須大於 0！");
                }
            } else {
                System.out.println("無效的選項，請重新輸入。");
            }
        }

        System.out.println("\n=== Receipt ===");
        System.out.println("Total items: " + totalItems);
        System.out.println("Total amount: " + totalAmount);

        scanner.close();
    }
}