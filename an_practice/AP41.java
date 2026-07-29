interface MTime {
    void reset();
    MTime mul2();
    void addS(int ds);
    MTime add(MTime t2);
    
    public default void incS() {
        this.addS(1);
    }
}

class MS implements MTime {
    int m, s;
    
    MS(int m0, int s0) {
        this.m = m0;
        this.s = s0;
        this.adjust();
    }
    
    public void addS(int ds) {
        this.s += ds;
        this.adjust();
    }
    
    void adjust() {
        if (this.m < 0 || this.s < 0) return; 
        this.m += this.s / 60;
        this.s %= 60;
    }
    
    public String toString() {
        return this.m + "m" + this.s + "s";
    }
    
    public MS mul2() {
        return new MS(this.m * 2, this.s * 2);
    }
    
    public MS add(MS t2) {
        return new MS(this.m + t2.m, this.s + t2.s);
    }
    
    public MS add(MTime t2) {
        if (!(t2 instanceof MS)) {
            throw new Error("Not expected type: " + t2.getClass());
        }
        return this.add((MS) t2);
    }
    
    public void reset() {
        this.m = 0;
        this.s = 0;
    }
}

// 加上 implements MTime 來強制編譯器重新驗證介面階層
class HMS extends MS implements MTime {
    int h;
    
    HMS(int h0, int m0, int s0) {
        super(m0, s0);
        this.h = h0;
        this.adjustHM();
    }
    
    void adjustHM() {
        if (this.h < 0 || this.m < 0) return;
        this.h += this.m / 60;
        this.m %= 60;
    }
    
    @Override
    public String toString() {
        return this.h + "h" + this.m + "m" + this.s + "s";
    }
    
    @Override
    public void reset() {
        super.reset();
        this.h = 0;
    }
    
    @Override
    public HMS mul2() {
        return new HMS(this.h * 2, this.m * 2, this.s * 2);
    }
    
    @Override
    public void addS(int ds) {
        super.addS(ds);
        this.adjustHM();
    }
    
    @Override
    public HMS add(MS t2) {
        System.out.println("// execute HMS::add(MS).");
        int h2 = 0;
        if (t2 instanceof HMS) {
            h2 = ((HMS) t2).h;
        }
        return new HMS(this.h + h2, this.m + t2.m, this.s + t2.s);
    }
    
    public HMS add(HMS t2) {
        System.out.println("// execute HMS::add(HMS).");
        return new HMS(this.h + t2.h, this.m + t2.m, this.s + t2.s);
    }
}

public class AP41 {
    
    static void test_MTime() {  
        System.out.println("\n--- test_MTime ---");
        MTime p1_= new HMS(2,5,30);
        System.out.println("p1_:"+p1_);

        p1_.addS(3650);  // 60*60+50
        System.out.println("p1_:"+p1_);

        MTime p2_= new HMS(5,2,40);
        System.out.println("p1_:"+p1_+", p2_:"+p2_);

        p2_= p2_.mul2();    
        System.out.println("p1_:"+p1_ + ", p2_:"+p2_);

        MTime p3_= p1_.add(p2_);
        p1_.incS();
        System.out.println("p1_:"+p1_ + ", p2_:"+p2_ +", p3_:"+p3_);

        MTime p4= ( p1_.add(p2_) );
        MTime p5_= p1_.add((HMS)p2_); 
        MTime p6_= ((HMS)p1_).add(p2_);
        MTime p7_= ((HMS)p1_).add((HMS)p2_); 
        System.out.println("p4:"+p4 + ", p5_:"+p5_ +", p6_:"+p6_+", p7_:"+p7_);
    }

    public static void main(String[] args) {
        test_MTime();
    }
}