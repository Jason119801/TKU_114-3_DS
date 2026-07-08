import java.util.Scanner;

public class AtmMethodHomework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int balance = 1000;
        int choice = -1;

        while (choice != 0) {
            printMenu(); // 選單
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    printBalance(balance); // 顯示餘額
                    break;
                case 2:
                    int depositAmount = readPositiveAmount(sc, "請輸入存款金額：");
                    // 呼叫存款方法，將回傳的新餘額覆蓋掉舊餘額
                    balance = deposit(balance, depositAmount);
                    break;
                case 3:
                    int withdrawAmount = readPositiveAmount(sc, "請輸入提款金額：");
                    // 呼叫提款方法，將回傳的新餘額覆蓋掉舊餘額
                    balance = withdraw(balance, withdrawAmount);
                    break;
                case 0:
                    System.out.println("系統結束，再見！");
                    break;
                default:
                    System.out.println("無效的選項，請重新輸入 0~3。");
                    break;
            }
        }
        
        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n=== ATM Menu ===");
        System.out.println("1：查詢餘額");
        System.out.println("2：存款");
        System.out.println("3：提款");
        System.out.println("0：離開");
        System.out.print("請輸入選項：");
    }

    public static int readPositiveAmount(Scanner sc, String message) {
        System.out.print(message);
        int amount = sc.nextInt();
        if (amount <= 0) {
            System.out.println("金額必須大於 0！");
            return 0; // 讓後續的 deposit 或 withdraw 不會進行計算
        }
        return amount;
    }

    public static int deposit(int balance, int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("存款成功！");
            printBalance(balance);
        }
        return balance;
    }

    public static int withdraw(int balance, int amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("提款成功！");
                printBalance(balance);
            } else {
                System.out.println("餘額不足！");
                printBalance(balance);
            }
        }
        return balance;
    }

    public static void printBalance(int balance) {
        System.out.println("目前餘額：" + balance);
    }
}