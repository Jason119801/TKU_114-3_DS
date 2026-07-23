public class AP21 {
    static void test_HMS0() {
        System.out.println("--- test_HMS0 ---");
        HMS0 p1 = new HMS0(2, 5, 30);
        System.out.println("p1:" + p1);
        
        p1.addS(50);
        p1.adjust();
        System.out.println("p1:" + p1);
        
        HMS0 p2 = new HMS0(5, 2, 40);
        System.out.println("p1:" + p1 + ", p2:" + p2);
        
        MS p2_ = p2.mul2();
        System.out.println("p1:" + p1 + ", p2_:" + p2_);
        
        MS p3_ = p1.add(p2_);
        p1.incS();
        System.out.println("p1:" + p1 + ", p2_:" + p2_ + ", p3_:" + p3_);
        System.out.println();
    }
}