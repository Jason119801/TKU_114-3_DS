import java.util.Scanner;

public class QuantityValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入商品數量：");
        int num = sc.nextInt();

        while (num <= 0) {
            System.out.print("請重新輸入（大於0）：");
            num = sc.nextInt();
        }

        System.out.println("商品數量: " + num);

        sc.close();
    }
}
