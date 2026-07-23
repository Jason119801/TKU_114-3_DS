public class AP32 {
    static void testArray() {
        System.out.println("--- testArray ---");
        MS p1_ = new MS(5, 30);
        MS q1_ = new MS(5, 190);
        
        HMS p2 = new HMS(5, 50, 42);
        MS p2_ = new HMS(5, 50, 42);
        
        HMS p3 = new HMS(2, 20, 15);
        MS p3_ = new HMS(2, 20, 15);
        
        System.out.println("p1_:" + p1_);
        System.out.println("q1_:" + q1_);
        System.out.println("p2:" + p2);
        System.out.println("p2_:" + p2_);
        System.out.println("p3:" + p3);
        System.out.println("p3_:" + p3_);
        System.out.println();
        
        // 利用 MS 型態的陣列存取多型物件
        MS[] a = {p1_, q1_, p2_, p3_};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        testArray();
    }
}