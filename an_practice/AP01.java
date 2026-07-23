public class AP01 {
    
    static void print(String s) {
        System.out.print(s);
    }
    
    // 造出n個s串接的字串，並傳回
    static String build(int n, String s) {
        String ans = "";
        for (int i = 0; i < n; i++) {
            ans += s;
        }
        return ans;
    }

    public static void main(String[] args) {
        // 呼叫build, 然後用函數值當參數呼叫 print.
        print(build(5, "ab"));
        print("\n");
        
        for (int i = 4; i <= 7; i++) {
            // build, 然後用函數值當參數呼叫 print.
            print(build(i, "c"));
            print("\n");
        }
    }
}