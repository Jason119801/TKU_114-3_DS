import java.util.Arrays;
public class MergeSortPractice {
    public static void main(String[] args) {
        int[] values = {41, 12, 35, 8, 27, 19, 50, 3};
        int[] temp = new int[values.length];
        mergeSort(values, temp, 0, values.length - 1);
        System.out.println(Arrays.toString(values));
    }
    public static void mergeSort(int[] v, int[] temp, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(v, temp, l, mid);
        mergeSort(v, temp, mid + 1, r);
        merge(v, temp, l, mid, r);
    }
    public static void merge(int[] v, int[] temp, int l, int mid, int r) {
        int i = l, j = mid + 1, k = l;
        while (i <= mid && j <= r) {
            temp[k++] = v[i] <= v[j] ? v[i++] : v[j++];
        }
        while (i <= mid) temp[k++] = v[i++];
        while (j <= r) temp[k++] = v[j++];
        for (int idx = l; idx <= r; idx++) v[idx] = temp[idx];
    }
}