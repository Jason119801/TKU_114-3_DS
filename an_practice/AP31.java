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
    
    // 不可以在建構子中呼叫會被子類別覆寫的函式
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
    
    void reset() {
        this.m = 0;
        this.s = 0;
    }
}

class HMS0 extends MS {
    int h;
    HMS0(int h0, int m0, int s0) {
        super(m0, s0);
        this.h = h0;
    }
}

// --- AP21 (為支援 main 函式的呼叫) ---
class AP21 {
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
}

class HMS extends MS {
    int h;
    
    HMS(int h0, int m0, int s0) {
        super(m0, s0);
        this.h = h0;
        this.adjustHM(); // 自行處理 h 與 m 的進位
    }
    
    void adjustHM() {
        if (this.h < 0 || this.m < 0) return;
        this.h += this.m / 60;
        this.m %= 60;
    }
    
    // 覆寫 toString()
    @Override
    public String toString() {
        return this.h + "h" + this.m + "m" + this.s + "s";
    }
    
    // 覆寫 reset()
    @Override
    void reset() {
        super.reset();
        this.h = 0;
    }
    
    // 覆寫 mul2()
    @Override
    HMS mul2() {
        return new HMS(this.h * 2, this.m * 2, this.s * 2);
    }
    
    // 覆寫 addS(int ds)
    @Override
    void addS(int ds) {
        super.addS(ds); // 會自動呼叫 MS 的 adjust() 處理 m 與 s
        this.adjustHM(); 
    }
    
    // 覆寫 add(MS t2)
    @Override
    HMS add(MS t2) {
        System.out.println("// execute HMS::add(MS).");
        int h2 = 0;
        // 判定 t2 所指的物件是否為 HMS 型態
        if (t2 instanceof HMS) {
            h2 = ((HMS) t2).h;
        }
        return new HMS(this.h + h2, this.m + t2.m, this.s + t2.s);
    }
    
    HMS add(HMS t2) {
        System.out.println("// execute HMS::add(HMS).");
        return new HMS(this.h + t2.h, this.m + t2.m, this.s + t2.s);
    }
}

public class AP31 {
    
    static void test_HMS() {
        System.out.println("\n--- test_HMS ---");
        HMS p1 = new HMS(2, 5, 30);
        System.out.println("p1:" + p1);
        
        p1.addS(3650);
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
        MS p1_= new HMS(2,5,30);
        System.out.println("p1_:"+p1_);

        p1_.addS(3650);  // 60*60+50
        System.out.println("p1_:"+p1_);

        MS p2_= new HMS(5,2,40);
        System.out.println("p1_:"+p1_+", p2_:"+p2_);

        p2_= p2_.mul2();    
        System.out.println("p1_:"+p1_ + ", p2_:"+p2_);

        MS p3_= p1_.add(p2_);
        p1_.incS();
        System.out.println("p1_:"+p1_ + ", p2_:"+p2_ +", p3_:"+p3_);

        HMS p4= (HMS)( p1_.add(p2_) );
        MS p5_= p1_.add((HMS)p2_); 
        MS p6_= ((HMS)p1_).add(p2_); 
        MS p7_= ((HMS)p1_).add((HMS)p2_); 
        System.out.println("p4:"+p4 + ", p5_:"+p5_ +", p6_:"+p6_+", p7_:"+p7_);
    }

    public static void main(String[] args) {
        AP21.test_HMS0();
        test_HMS();
        test_HMSx();
    }
}