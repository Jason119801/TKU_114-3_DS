import java.util.Scanner;

public class DrinkOrderSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int blackTeaCount = 0;
        int greenTeaCount = 0;
        int milkTeaCount = 0;
        int coffeeCount = 0;
        int totalItems = 0;
        int totalAmount = 0;
        int option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            if (option == 0) {
                break;
            }

            if (option >= 1 && option <= 4) {
                int quantity = readValidQuantity(sc);
                if (quantity > 0) {
                    int price = getPrice(option);
                    String name = getItemName(option);
                    int subtotal = calculateSubtotal(price, quantity);

                    System.out.println(name + " x " + quantity);
                    System.out.println("Subtotal: " + subtotal);

                    totalItems += quantity;
                    totalAmount += subtotal;

                    // 記錄各品項數量
                    switch (option) {
                        case 1: blackTeaCount += quantity; break;
                        case 2: greenTeaCount += quantity; break;
                        case 3: milkTeaCount += quantity; break;
                        case 4: coffeeCount += quantity; break;
                    }
                }
            } else {
                System.out.println("無效的選項，請重新輸入。");
            }
        }

        int finalAmount = calculateDiscountedTotal(totalAmount);
        printReceipt(blackTeaCount, greenTeaCount, milkTeaCount, coffeeCount, totalItems, totalAmount, finalAmount);
        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n=== Drink Menu ===");
        System.out.println("1. Black tea  $30");
        System.out.println("2. Green tea  $35");
        System.out.println("3. Milk tea   $45");
        System.out.println("4. Coffee     $50");
        System.out.println("0. Checkout");
    }

    public static int getPrice(int option) {
        switch (option) {
            case 1: return 30;
            case 2: return 35;
            case 3: return 45;
            case 4: return 50;
            default: return 0;
        }
    }

    public static String getItemName(int option) {
        switch (option) {
            case 1: return "Black tea";
            case 2: return "Green tea";
            case 3: return "Milk tea";
            case 4: return "Coffee";
            default: return "Unknown";
        }
    }

    public static int readValidQuantity(Scanner sc) {
        System.out.print("請輸入數量：");
        int qty = sc.nextInt();
        if (qty <= 0) {
            System.out.println("錯誤：數量必須大於 0！");
            return 0;
        }
        return qty;
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static int calculateDiscountedTotal(int totalAmount) {
        if (totalAmount >= 300) {
            return (int) (totalAmount * 0.9);
        }
        return totalAmount;
    }

    public static void printReceipt(int blackTeaCount, int greenTeaCount, int milkTeaCount, int coffeeCount, int totalItems, int totalAmount, int finalAmount) {
        System.out.println("\n=== Receipt ===");
        System.out.println("Black tea: " + blackTeaCount);
        System.out.println("Green tea: " + greenTeaCount);
        System.out.println("Milk tea: " + milkTeaCount);
        System.out.println("Coffee: " + coffeeCount);
        System.out.println("Total items: " + totalItems);
        System.out.println("Original amount: " + totalAmount);
        
        if (finalAmount < totalAmount) {
            System.out.println("Discount: Yes");
        } else {
            System.out.println("Discount: No");
        }
        System.out.println("Final amount: " + finalAmount);
    }
}