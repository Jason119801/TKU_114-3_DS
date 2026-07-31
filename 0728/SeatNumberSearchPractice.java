import java.util.Scanner;
public class SeatNumberSearchPractice {
    public static void main(String[] args) {
        int[] seats = {1, 5, 8, 12, 15, 20, 22, 25, 30, 35, 40, 50};
        Scanner sc = new Scanner(System.in);
        System.out.print("輸入座位: ");
        int target = sc.nextInt();
        int low = 0, high = seats.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.printf("low=%d, mid=%d, high=%d\n", low, mid, high);
            if (seats[mid] == target) { ans = mid; break; }
            if (target < seats[mid]) high = mid - 1;
            else low = mid + 1;
        }
        System.out.println("結果索引: " + ans);
    }
}