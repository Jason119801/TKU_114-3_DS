public class RangeSearchSystem {
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 20, 30};
        System.out.println("第一次: " + findBound(arr, 20, true));
        System.out.println("最後一次: " + findBound(arr, 20, false));
    }
    public static int findBound(int[] values, int target, boolean isFirst) {
        int low = 0, high = values.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (values[mid] == target) {
                ans = mid;
                if (isFirst) high = mid - 1;
                else low = mid + 1;
            } else if (target < values[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return ans;
    }
}