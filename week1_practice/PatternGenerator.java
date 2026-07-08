import java.util.Scanner;

public class PatternGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    printMultiplicationTable();
                    break;
                case 2:
                    int h1 = readPositiveInt(sc, "請輸入高度：");
                    printTriangle(h1);
                    break;
                case 3:
                    int h2 = readPositiveInt(sc, "請輸入高度：");
                    printReverseTriangle(h2);
                    break;
                case 4:
                    int rows = readPositiveInt(sc, "請輸入列數：");
                    int cols = readPositiveInt(sc, "請輸入欄數：");
                    printNumberGrid(rows, cols);
                    break;
                case 0:
                    System.out.println("程式結束。");
                    break;
                default:
                    System.out.println("無效的選項，請重新輸入。");
            }
        }
        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n=== Pattern Menu ===");
        System.out.println("1. 九九乘法表");
        System.out.println("2. 正三角形星號");
        System.out.println("3. 倒三角形星號");
        System.out.println("4. 數字方格");
        System.out.println("0. 離開");
    }

    public static int readPositiveInt(Scanner sc, String message) {
        int val = -1;
        while (val <= 0) {
            System.out.print(message);
            val = sc.nextInt();
            if (val <= 0) {
                System.out.println("錯誤：請輸入大於 0 的正整數！");
            }
        }
        return val;
    }

    public static void printMultiplicationTable() {
        System.out.println("\n=== 九九乘法表 ===");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                // 使用 printf 可以讓版面稍微整齊，但這裡使用一般 print 也行
                System.out.print(i + "x" + j + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    public static void printTriangle(int height) {
        System.out.println();
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printReverseTriangle(int height) {
        System.out.println();
        for (int i = height; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printNumberGrid(int rows, int cols) {
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}