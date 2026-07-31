public class ScoreRankingPractice {
    public static void main(String[] args) {
        int[] scores = {90, 80, 80, 70, 60, 50, 40, 100};
        for (int i = 0; i < scores.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] > scores[max]) max = j;
            }
            int temp = scores[i]; scores[i] = scores[max]; scores[max] = temp;
        }
        for (int i = 0; i < scores.length; i++) {
            System.out.println("名次 " + (i+1) + ": " + scores[i] + (scores[i] >= 60 ? " 及格" : " 不及格"));
        }
    }
}