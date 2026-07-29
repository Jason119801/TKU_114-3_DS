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
    int h; // nonstatic 的 int : h
    
    HMS0(int h0, int m0, int s0) {
        super(m0, s0); 
        this.h = h0;  
    }
}

class AP14 {
    static void test_MS() {
        System.out.println("--- test_MS ---");
        MS p1 = new MS(5, 30);
        System.out.println("p1:" + p1);
        
        p1.addS(50);
        System.out.println("p1:" + p1);
        
        MS p2 = new MS(2, 40);
        System.out.println("p1:" + p1 + ", p2:" + p2);
        
        p2 = p2.mul2();
        System.out.println("p1:" + p1 + ", p2:" + p2);
        
        MS p3 = p1.add(p2);
        p1.incS();
        System.out.println("p1:" + p1 + ", p2:" + p2 + ", p3:" + p3);
        System.out.println(); 
    }
}

public class AP21 {
    
    static void test_HMS0() {

        System.out.println("--- test_HMS0 ---");

        HMS0 p1 = new HMS0(2, 5, 30);
        System.out.println("p1:" + p1);
        
        p1.addS(50);
        System.out.println("p1:" + p1);
        
        HMS0 p2 = new HMS0(5, 2, 40);
        System.out.println("p1:" + p1 + ", p2:" + p2);
        
        MS p2_ = p2.mul2();
        System.out.println("p1:" + p1 + ", p2_:" + p2_);
        
        MS p3_ = p1.add(p2_);
        p1.incS();
        System.out.println("p1:" + p1 + ", p2_:" + p2_ + ", p3_:" + p3_);
    }
    
    public static void main(String[] args) {
        // 呼叫 AP14 的 test_MS()
        AP14.test_MS();
        test_HMS0();
    }
}