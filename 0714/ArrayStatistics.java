import java.util.Scanner;

public class ArrayStatistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. 取得陣列長度並建立陣列
        int count = readCount(sc);
        int[] scores = new int[count];
        
        inputScores(sc, scores);
        
        // 3. 顯示全部成績
        System.out.println("\n=== 所有成績 ===");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();
        
        // 4. 統計與顯示
        int total = calculateTotal(scores);
        double average = (double) total / scores.length;
        int max = findMax(scores);
        int min = findMin(scores);
        int passCount = countPass(scores);
        int failCount = scores.length - passCount;
        
        System.out.println("\n=== 統計結果 ===");
        System.out.println("總分：" + total);
        System.out.println("平均：" + average);
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("及格人數：" + passCount);
        System.out.println("不及格人數：" + failCount);
        
        // 5. 搜尋目標成績
        System.out.print("\n請輸入要搜尋的目標成績：");
        int target = sc.nextInt();
        int index = findIndex(scores, target);
        
        if (index != -1) {
            System.out.println("目標成績 " + target + " 第一次出現在索引：" + index);
        } else {
            System.out.println("找不到目標成績 " + target + "。");
        }
        
        sc.close();
    }

    public static int readCount(Scanner sc) {
        int count = 0;
        while (count < 1 || count > 50) {
            System.out.print("請輸入資料筆數 (1~50)：");
            count = sc.nextInt();
            if (count < 1 || count > 50) {
                System.out.println("錯誤：筆數必須在 1 到 50 之間！");
            }
        }
        return count;
    }

    public static void inputScores(Scanner sc, int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            int score = -1;
            while (score < 0 || score > 100) {
                System.out.print("請輸入第 " + (i + 1) + " 筆成績 (0~100)：");
                score = sc.nextInt();
                if (score < 0 || score > 100) {
                    System.out.println("錯誤：成績必須在 0 到 100 之間！");
                }
            }
            scores[i] = score;
        }
    }

    public static int calculateTotal(int[] scores) {
        int total = 0;
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }
        return total;
    }

    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    public static int findMin(int[] scores) {
        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }

    public static int countPass(int[] scores) {
        int pass = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 60) {
                pass++;
            }
        }
        return pass;
    }

    public static int findIndex(int[] scores, int target) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                return i; // 當下的索引
            }
        }
        return -1; // 不存在
    }
}