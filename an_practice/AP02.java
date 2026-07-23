public class AP02 {

    static void pm(char c, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
    }
    
    // 迴圈計算x的n次方
    static int pw(int x, int n) {
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= x;
        }
        return ans;
    }

    public static void main(String[] args) {
        pm('A', 5);
        System.out.println();
        System.out.print(pw(10, 3));
        System.out.println();

        for (int i = 1; i <= 5; i++) {
            System.out.print(pw(2, i) + " ");
        }
        System.out.println(); // 結尾安全換行
    }
}