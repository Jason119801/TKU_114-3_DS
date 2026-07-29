// 沿用之前的 class MS
class MS {
    int m, s;
    
    MS(int m0, int s0) {
        this.m = m0;
        this.s = s0;
        this.adjust();
    }
    
    void addS(int ds) {
        this.s += ds;
        this.adjust();
    }
    
    void adjust() {
        if (this.m < 0 || this.s < 0) return; 
        this.m += this.s / 60;
        this.s %= 60;
    }
    
    void incS() {
        this.addS(1);
    }
    
    public String toString() {
        return this.m + "m" + this.s + "s";
    }
    
    MS mul2() {
        return new MS(this.m * 2, this.s * 2);
    }
    
    MS add(MS t2) {
        return new MS(this.m + t2.m, this.s + t2.s);
    }
}

class HMS0 extends MS {
    int h; 
    
    HMS0(int h0, int m0, int s0) {
        super(m0, s0); 
        this.h = h0;   
    }
}

public class AP22 {
    
    static void testArray() {
        System.out.println("--- testArray ---");
        
        MS p1_ = new MS(5, 30);
        MS q1_ = new MS(5, 190);
        HMS0 p2 = new HMS0(5, 50, 42);
        MS p2_ = new HMS0(5, 50, 42); // 向上轉型 (Upcasting)
        HMS0 p3 = new HMS0(2, 20, 15);
        MS p3_ = new HMS0(2, 20, 15); // 向上轉型 (Upcasting)
        
        // 印出
        System.out.println("p1_:" + p1_);
        System.out.println("q1_:" + q1_);
        System.out.println("p2:" + p2);
        System.out.println("p2_:" + p2_);
        System.out.println("p3:" + p3);
        System.out.println("p3_:" + p3_);
        
        System.out.println();
        
        MS[] a = {p1_, q1_, p2, p3};
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            // 若不是最後一個元素，則印出空格
            if (i < a.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        testArray();
    }
}