import java.util.Arrays;
public class SelectionSortPractice {
    public static void main(String[] args) {
        int[] values = {42, 18, 35, 7, 29, 14};
        int checks = 0, swaps = 0;
        for (int i = 0; i < values.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < values.length; j++) {
                checks++;
                if (values[j] < values[min]) min = j;
            }
            if (min != i) {
                int temp = values[i]; values[i] = values[min]; values[min] = temp;
                swaps++;
            }
            System.out.printf("第 %d 輪: %s\n", i + 1, Arrays.toString(values));
        }
    }
}