public class AP31 {
    static void test_HMS() {
        System.out.println("--- test_HMS ---");
        HMS p1 = new HMS(2, 5, 30);
        System.out.println("p1:" + p1);
        
        p1.addS(3650); // 3650 = 60*60 + 50
        System.out.println("p1:" + p1);
        
        HMS p2 = new HMS(5, 2, 40);
        System.out.println("p1:" + p1 + ", p2:" + p2);
        
        p2 = p2.mul2();
        System.out.println("p1:" + p1 + ", p2:" + p2);
        
        HMS p3 = p1.add(p2);
        p1.incS();
        System.out.println("p1:" + p1 + ", p2:" + p2 + ", p3:" + p3);
    }

    static void test_HMSx() {  
        System.out.println("\n--- test_HMSx ---");
        MS p1_ = new HMS(2, 5, 30);
        System.out.println("p1_:" + p1_);

        p1_.addS(3650);  
        System.out.println("p1_:" + p1_);

        MS p2_ = new HMS(5, 2, 40);
        System.out.println("p1_:" + p1_ + ", p2_:" + p2_);

        p2_ = p2_.mul2();    
        System.out.println("p1_:" + p1_ + ", p2_:" + p2_);

        MS p3_ = p1_.add(p2_);      
        p1_.incS();
        System.out.println("p1_:" + p1_ + ", p2_:" + p2_ + ", p3_:" + p3_);

        HMS p4 = (HMS)(p1_.add(p2_));  
        MS p5_ = p1_.add((HMS) p2_);  
        MS p6_ = ((HMS) p1_).add(p2_); 
        MS p7_ = ((HMS) p1_).add((HMS) p2_); 
        System.out.println("p4:" + p4 + ", p5_:" + p5_ + ", p6_:" + p6_ + ", p7_:" + p7_);
    }

    public static void main(String[] args) {
        AP21.test_HMS0();
        test_HMS();
        test_HMSx();
    }
}