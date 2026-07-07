import java.util.Scanner;

public class AtmMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int balance = 1000; // 初始餘額設定為 1000
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1：查詢餘額");
            System.out.println("2：存款");
            System.out.println("3：提款");
            System.out.println("0：離開");
            System.out.print("請輸入選項：");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("目前餘額：" + balance);
                    break;
                    
                case 2:
                    System.out.print("請輸入存款金額：");
                    int deposit = scanner.nextInt();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("存款成功！目前餘額：" + balance);
                    } else {
                        System.out.println("錯誤：存款金額必須大於 0！");
                    }
                    break;
                    
                case 3:
                    System.out.print("請輸入提款金額：");
                    int withdraw = scanner.nextInt();
                    if (withdraw > 0) {
                        // 提款金額不能大於目前餘額
                        if (withdraw <= balance) {
                            balance -= withdraw;
                            System.out.println("提款成功！目前餘額：" + balance);
                        } else {
                            System.out.println("餘額不足！您的餘額只有：" + balance);
                        }
                    } else {
                        System.out.println("提款金額必須大於 0");
                    }
                    break;
                    
                case 0:
                    System.out.println("再見！");
                    break;
                    
                default:
                    System.out.println("無效的選項，請重新輸入 0~3。");
                    break;
            }
        }
        
        // scanner.close();
    }
}