import java.util.Scanner;

public class SalesMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 3 列 (商) 4 欄 (天) 
        int[][] sales = new int[3][4];

        inputSales(sc, sales);
        displayMatrix(sales);
        calculateProductTotals(sales);
        calculateDayTotals(sales);
        findBestProduct(sales);

        sc.close();
    }

    public static void inputSales(Scanner sc, int[][] sales) {
        System.out.println("=== 輸入銷售資料 ===");
        for (int row = 0; row < sales.length; row++) {
            for (int col = 0; col < sales[row].length; col++) {
                int amount = -1;
                while (amount < 0) {
                    System.out.print("請輸入 商品 " + (row + 1) + " 在第 " + (col + 1) + " 天的銷售量：");
                    amount = sc.nextInt();
                    if (amount < 0) {
                        System.out.println("銷售量不得小於 0！");
                    }
                }
                sales[row][col] = amount;
            }
        }
    }

    public static void displayMatrix(int[][] sales) {
        System.out.println("\n=== 銷售矩陣報表 ===");
        System.out.println("      \tDay1\tDay2\tDay3\tDay4");
        for (int row = 0; row < sales.length; row++) {
            System.out.print("Prod " + (row + 1) + ":");
            for (int col = 0; col < sales[row].length; col++) {
                System.out.print("\t" + sales[row][col]);
            }
            System.out.println();
        }
    }

    public static void calculateProductTotals(int[][] sales) {
        System.out.println("\n=== 每項商品銷售總量 ===");
        for (int row = 0; row < sales.length; row++) {
            int total = 0;
            for (int col = 0; col < sales[row].length; col++) {
                total += sales[row][col];
            }
            System.out.println("商品 " + (row + 1) + " 總銷量：" + total);
        }
    }

    public static void calculateDayTotals(int[][] sales) {
        System.out.println("\n=== 每天全部商品銷售總量 ===");
        for (int col = 0; col < sales[0].length; col++) {
            int total = 0;
            for (int row = 0; row < sales.length; row++) {
                total += sales[row][col];
            }
            System.out.println("第 " + (col + 1) + " 天總銷量：" + total);
        }
    }

    public static void findBestProduct(int[][] sales) {
        int bestProductIndex = 0;
        int maxSales = 0;

        for (int row = 0; row < sales.length; row++) {
            int total = 0;
            for (int col = 0; col < sales[row].length; col++) {
                total += sales[row][col];
            }
            if (total > maxSales) {
                maxSales = total;
                bestProductIndex = row;
            }
        }
        System.out.println("\n總銷售量最高的商品是：商品 " + (bestProductIndex + 1) + " (共 " + maxSales + " 件)");
    }
}