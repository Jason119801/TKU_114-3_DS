public class Q07_ArrayAudit {
    private static final int MIN_VALID = 10;
    private static final int MAX_VALID = 60;
    private static final int TARGET = 35;
    private static final int INVALID_MARK = -1;

    public static void main(String[] args) {
        int[] readings = {12, 71, 35, -4, 35, 22, 60, 9, 48, 61};
        System.out.println("有效筆數：" + countValid(readings));
        System.out.printf("有效平均：%.2f%n", averageValid(readings));
        System.out.println("最後符合門檻的索引：" + findLastAtLeast(readings, TARGET));

        int[] cleaned = createCleanCopy(readings);
        System.out.print("清理後資料：");
        printArray(cleaned);
        System.out.print("原始資料：");
        printArray(readings);
    }

    private static boolean isValid(int value) {
        return value >= MIN_VALID && value <= MAX_VALID;
    }

    public static int countValid(int[] data) {
        int validItems = 0;
        for (int v : data) {
            if (isValid(v)) validItems++;
        }
        return validItems;
    }

    public static double averageValid(int[] data) {
        int totalSum = 0;
        int validItems = 0;
        for (int v : data) {
            if (isValid(v)) {
                totalSum += v;
                validItems++;
            }
        }
        return validItems == 0 ? -1.0 : (double) totalSum / validItems;
    }

    public static int findLastAtLeast(int[] data, int target) {
        int idx = data.length - 1;
        while (idx >= 0) {
            if (isValid(data[idx]) && data[idx] >= target) {
                return idx;
            }
            idx--;
        }
        return -1;
    }

    public static int[] createCleanCopy(int[] data) {
        int[] output = new int[data.length];
        for (int k = 0; k < data.length; k++) {
            if (isValid(data[k])) {
                output[k] = data[k];
            } else {
                output[k] = INVALID_MARK;
            }
        }
        return output;
    }

    private static void printArray(int[] data) {
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            if (i < data.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}