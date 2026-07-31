public class AllOccurrenceSearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30, 10};
        searchAll(arr, 10);
    }
    public static void searchAll(int[] values, int target) {
        int count = 0;
        int checks = 0;
        for (int i = 0; i < values.length; i++) {
            checks++;
            if (values[i] == target) {
                System.out.println("找到索引: " + i);
                count++;
            }
        }
        System.out.println("出現次數: " + count + ", 比較次數: " + checks);
    }
}