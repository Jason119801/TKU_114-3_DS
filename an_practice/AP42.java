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

class HMS extends MS {
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
        int h2 = 0;
        if (t2 instanceof HMS) {
            h2 = ((HMS) t2).h;
        }
        return new HMS(this.h + h2, this.m + t2.m, this.s + t2.s);
    }
    
    public HMS add(HMS t2) {
        return new HMS(this.h + t2.h, this.m + t2.m, this.s + t2.s);
    }
}

class HM implements MTime {
    int h, m;
    
    HM(int h0, int m0) {
        this.h = h0;
        this.m = m0;
        this.adjust();
    }
    
    void adjust() {
        if (this.h < 0 || this.m < 0) return;
        this.h += this.m / 60;
        this.m %= 60;
    }
    
    @Override
    public String toString() {
        return this.h + "h" + this.m + "m";
    }

    @Override
    public void reset() {
        this.h = 0;
        this.m = 0;
    }

    @Override
    public HM mul2() {
        return new HM(this.h * 2, this.m * 2);
    }

    @Override
    public void addS(int ds) {
        this.m += ds / 60;
        this.adjust();
    }

    @Override
    public MTime add(MTime t2) {
        int h2 = 0, m2 = 0;
        if (t2 instanceof HM) {
            h2 = ((HM) t2).h;
            m2 = ((HM) t2).m;
        } else if (t2 instanceof HMS) {
            h2 = ((HMS) t2).h;
            m2 = ((HMS) t2).m;
        } else if (t2 instanceof MS) {
            m2 = ((MS) t2).m;
        }
        return new HM(this.h + h2, this.m + m2);
    }
}

public class AP42 {
    
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
        
        // 為了符合輸出的 6h40m，這裡加入一個 HM 物件
        MTime p4_ = new HM(6, 40); 
        MTime[] a = {p1_, q1_, p2_, p3_, p4_};
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) System.out.print(" ");
        }
        System.out.println();
        
        // 局部變數 b，將其設為 a[i] 的兩倍
        MTime[] b = new MTime[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i].mul2(); // 動態綁定 (Dynamic Binding)：各自呼叫對應的 mul2()
        }
        
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
            if (i < b.length - 1) System.out.print(" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        testArray();
    }
}