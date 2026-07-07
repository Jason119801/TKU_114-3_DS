import java.util.Scanner;

public class HealthAdvisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueInput = "y"; // 預設繼續變數

        // 只要使用者輸入 y 就繼續
        while (continueInput.equalsIgnoreCase("y")) {
            System.out.print("請輸入姓名：");
            String name = scanner.next();

            System.out.print("請輸入身高（公尺）：");
            double height = scanner.nextDouble();

            System.out.print("請輸入體重（公斤）：");
            double weight = scanner.nextDouble();

            double bmi = weight / (height * height);
            String level = "";

            // if else if else 判斷
            if (bmi < 18.5) {
                level = "Underweight";
            } else if (bmi < 24) {
                level = "Normal";
            } else if (bmi < 27) {
                level = "Overweight";
            } else {
                level = "Obese";
            }

            System.out.println("\n=== BMI Report ===");
            System.out.println("Name: " + name);
            System.out.println("BMI: " + bmi);
            System.out.println("Level: " + level);
            System.out.println(); // 按照輸出範例印出一個空白行

            System.out.print("是否繼續輸入下一筆？(y/n)：");
            continueInput = scanner.next();
        }
        
    }
}