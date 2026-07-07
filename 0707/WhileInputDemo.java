import java.util.Scanner;
public class WhileInputDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("請輸入一個整數 (輸入 0 結束): ");
        int number = scanner.nextInt(); // 第一次讀取數字
        
        while (number != 0) {
            System.out.println( number);
            
            System.out.print("請再輸入一個整數 (輸入 0 結束): ");
            number = scanner.nextInt();
        }
        
        scanner.close();
    }
}