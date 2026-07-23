import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class DynamicScoreManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        System.out.println("請持續輸入成績 (0~100)，輸入 -1 結束：");
        while (true) {
            System.out.print("成績：");
            int score = scanner.nextInt();
            if (score == -1) break;
            
            if (score >= 0 && score <= 100) {
                scores.add(score);
            } else {
                System.out.println("成績無效，請重新輸入。");
            }
        }
        
        if (scores.isEmpty()) {
            System.out.println("未輸入任何有效成績。");
            return;
        }

        System.out.println("-----------------");
        System.out.println("總筆數：" + scores.size());
        System.out.println("平均：" + getAverage(scores));
        System.out.println("最高分：" + Collections.max(scores));
        System.out.println("最低分：" + Collections.min(scores));
        System.out.println("及格名單：" + getPassedList(scores));
    }

    public static double getAverage(ArrayList<Integer> scores) {
        int sum = 0;
        for (int s : scores) sum += s;
        return (double) sum / scores.size();
    }

    public static ArrayList<Integer> getPassedList(ArrayList<Integer> scores) {
        ArrayList<Integer> passed = new ArrayList<>();
        for (int s : scores) {
            if (s >= 60) passed.add(s);
        }
        return passed;
    }
}