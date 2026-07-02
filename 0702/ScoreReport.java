import java.util.Scanner;

public class ScoreReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入姓名：");
        String name = sc.nextLine();

        System.out.print("請輸入 Java 成績：");
        int Java = sc.nextInt();

        System.out.print("請輸入 English 成績：");
        int English = sc.nextInt();

        System.out.print("請輸入 Math 成績：");
        int Math = sc.nextInt();
        //計算平均
        double average = (Java + English + Math)/3;
        
        //輸出
        System.out.println("=== 成績報表 ===");//===裝飾
        System.out.println("姓名：" + name);//名稱
        System.out.println("Java：" + Java);
        System.out.println("English：" + English);
        System.out.println("Math：" + Math);
        System.out.println("平均： " + average);
        
    }
}
