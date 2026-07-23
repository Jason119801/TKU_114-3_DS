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

// 新造 class HMS0，繼承 MS
class HMS0 extends MS {
    int h; // 新添 nonstatic 的 int 欄位 h
    
    HMS0(int h0, int m0, int s0) {
        super(m0, s0); // 負責呼叫 MS 的建構子
        this.h = h0;   // 自行設定欄位 h
    }
    
    // 本題未在 HMS0 中複寫 toString()，印出時會自動使用父類別 MS 的格式
}

// 將 AP14 的邏輯包裝為靜態函數 test_MS() 供呼叫
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
        System.out.println(); // 印出空行，使輸出格式與題目要求一致
    }
}

public class AP21 {
    
    static void test_HMS0() {
        // 1. 先印出 --- test_HMS0 ---
        System.out.println("--- test_HMS0 ---");
        
        // 2. 造出 HMS0 局部變數 p1 (2, 5, 30)
        HMS0 p1 = new HMS0(2, 5, 30);
        System.out.println("p1:" + p1);
        
        // 3. 用 p1 呼叫 addS(50)
        p1.addS(50);
        System.out.println("p1:" + p1);
        
        // 4. 造出 HMS0 局部變數 p2 (5, 2, 40)
        HMS0 p2 = new HMS0(5, 2, 40);
        System.out.println("p1:" + p1 + ", p2:" + p2);
        
        // 5. 呼叫 mul2。因為 mul2 回傳的是 MS 型態，需用 MS 型的變數 p2_ 承接
        MS p2_ = p2.mul2();
        System.out.println("p1:" + p1 + ", p2_:" + p2_);
        
        // 6. 用 p1 呼叫 add，參數為 p2_，交給 p3_ 指住。之後 p1 呼叫 incS。
        MS p3_ = p1.add(p2_);
        p1.incS();
        System.out.println("p1:" + p1 + ", p2_:" + p2_ + ", p3_:" + p3_);
    }
    
    public static void main(String[] args) {
        // 呼叫 AP14 的 test_MS()
        AP14.test_MS();
        
        // 呼叫本類別的 test_HMS0()
        test_HMS0();
    }
}