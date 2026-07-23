// 沿用 class MS
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

// 改善 AP22 的行為，將 HMS0 升級為 HMS，並複寫 toString()
class HMS extends MS {
    int h;
    
    HMS(int h0, int m0, int s0) {
        super(m0, s0); 
        this.h = h0;   
    }
    
    // 複寫 (Override) 父類別的 toString 方法，加入小時(h)的顯示
    @Override
    public String toString() {
        return this.h + "h" + this.m + "m" + this.s + "s";
    }
}

public class AP32 {
    
    static void testArray() {
        // 1. 先印出 --- testArray ---
        System.out.println("--- testArray ---");
        
        // 2. 造出局部變數並指向物件
        MS p1_ = new MS(5, 30);
        MS q1_ = new MS(5, 190);               // 內部 adjust() 會自動進位為 8m10s
        HMS p2 = new HMS(5, 50, 42);
        MS p2_ = new HMS(5, 50, 42);           // 向上轉型 (Upcasting)
        HMS p3 = new HMS(2, 20, 15);
        MS p3_ = new HMS(2, 20, 15);           // 向上轉型 (Upcasting)
        
        // 印出各變數所指物件
        System.out.println("p1_:" + p1_);
        System.out.println("q1_:" + q1_);
        System.out.println("p2:" + p2);
        System.out.println("p2_:" + p2_);      // 展現多型，呼叫的是 HMS 的 toString()
        System.out.println("p3:" + p3);
        System.out.println("p3_:" + p3_);      // 展現多型，呼叫的是 HMS 的 toString()
        
        // 印出一個空行以符合題目輸出格式
        System.out.println();
        
        // 3. 另造 MS[] 型態的局部變數 a，陣列內容為 {p1_, q1_, p2_, p3_}
        MS[] a = {p1_, q1_, p2_, p3_};
        
        // 用迴圈印出 a 所指的陣列的內容，各值以空格分開
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
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