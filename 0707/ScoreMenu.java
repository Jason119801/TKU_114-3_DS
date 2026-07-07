import java.util.Scanner;

public class ScoreMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入姓名：");
        String name = scanner.nextLine();

        System.out.print("請輸入 Java 成績：");
        double javaScore = scanner.nextDouble();

        System.out.print("請輸入 English 成績：");
        double englishScore = scanner.nextDouble();

        System.out.print("請輸入 Math 成績：");
        double mathScore = scanner.nextDouble();

        double average = (javaScore + englishScore + mathScore) / 3.0;

        String passStatus = (average >= 60) ? "及格" : "不及格";
        String grade = "";

        // 使用 if else if else 判斷等第
        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        int choice = 1; // 預設一個數字讓迴圈啟動

        while (choice != 0) {
            System.out.println("\n=== 成績查詢選單 ===");
            System.out.println("1：顯示平均分數");
            System.out.println("2：顯示及格狀態");
            System.out.println("3：顯示等第");
            System.out.println("0：離開");
            System.out.print("請輸入選項：");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(name + " 的平均分數為：" + average);
                    break;
                case 2:
                    System.out.println(name + " 的狀態為：" + passStatus);
                    break;
                case 3:
                    System.out.println(name + " 的等第為：" + grade);
                    break;
                case 0:
                    System.out.println("系統結束");
                    break;
                default:
                    System.out.println("輸入錯誤，請輸入 0-3 之間的數字。");
                    break;
            }
        }
        
        scanner.close();
    }
}