/*
1. 錯誤位置：System.out.println("系統結束，年齡：" + age)
   錯誤類型：編譯錯誤
   原因：語句結尾缺少分號。
   修正方式：在句尾補上分號 (;)。

2. 錯誤位置：for (int i = 0; i <= scores.length; i++)
   錯誤類型：陣列越界錯誤
   原因：陣列最大索引為 length - 1。當迴圈條件為 <= 時，最後一圈 i 會等於 length，導致越界。
   修正方式：將 <= 改為 <。

3. 錯誤位置：double average = total / scores.length;
   錯誤類型：邏輯錯誤
   原因：total 和 scores.length 都是 int，相除時會直接捨去小數部分，才將結果存入 double 變數中。
   修正方式：將 total 或長度強制轉型為 double，如 (double) total / scores.length;。

4. 錯誤位置：String command = sc.nextLine(); (在 sc.nextInt() 之後)
   錯誤類型：Scanner 換行問題
   原因：nextInt() 只會讀取數字，把(\n) 留在緩衝區中。接下來的 nextLine() 會立刻讀到這個換行字元，導致得到空字串。
   修正方式：在 nextInt() 後面加上一行 sc.nextLine(); 來消耗掉多餘的換行字元。

5. 錯誤位置：if (command == "exit")
   錯誤類型：字串比較錯誤
   原因：在 Java 中，== 用於比較字串時，比較的是「記憶體位址」而非「字串內容」。
   修正方式：使用字串內建的 .equals() 方法進行內容比較，改為 command.equals("exit")。
*/

import java.util.Scanner;

public class DebuggingChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = {80, 75, 92};
        int total = 0;

        // 修正 2：陣列越界錯誤 (將 <= 改為 <)
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }

        // 修正 3：邏輯錯誤 (加入 double 轉型確保保留小數)
        double average = (double) total / scores.length;
        System.out.printf("平均：%.2f%n", average);

        System.out.print("請輸入年齡：");
        int age = sc.nextInt();
        
        // 修正 4：Scanner 換行字元問題 (消耗留在緩衝區的換行字元)
        sc.nextLine(); 

        System.out.print("請輸入指令：");
        String command = sc.nextLine();

        // 修正 5：字串比較錯誤 (改用 equals)
        if (command.equals("exit")) {
            // 修正 1：編譯錯誤 (補上分號)
            System.out.println("系統結束，年齡：" + age);
        }

        sc.close();
    }
}