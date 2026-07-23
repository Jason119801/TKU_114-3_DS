public class AP22 {
    static void testArray() {
        System.out.println("--- testArray ---");
        
        MS p1_ = new MS(5, 30);
        MS q1_ = new MS(5, 190);
        HMS0 p2 = new HMS0(5, 50, 42);
        MS p2_ = new HMS0(5, 50, 42);
        HMS0 p3 = new HMS0(2, 20, 15);
        MS p3_ = new HMS0(2, 20, 15);
        
        System.out.println("p1_:" + p1_.toStr());
        System.out.println("q1_:" + q1_.toStr());
        System.out.println("p2:" + p2.toStr());
        System.out.println("p2_:" + p2_.toStr());
        System.out.println("p3:" + p3.toStr());
        System.out.println("p3_:" + p3_.toStr());
        System.out.println();
        
        MS[] a = {p1_, q1_, p2, p3};
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i].toStr() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        testArray();
    }
}