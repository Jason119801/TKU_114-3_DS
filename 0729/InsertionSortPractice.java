import java.util.Arrays;
public class InsertionSortPractice {
    public static void main(String[] args) {
        int[] values = {30, 10, 20, 50, 40, 5};
        for (int i = 1; i < values.length; i++) {
            int key = values[i];
            int p = i - 1;
            while (p >= 0 && values[p] > key) {
                values[p + 1] = values[p];
                p--;
            }
            values[p + 1] = key;
            System.out.println("插入 " + key + ": " + Arrays.toString(values));
        }
    }
}