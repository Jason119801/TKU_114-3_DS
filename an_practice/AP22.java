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

// 沿用之前的 class HMS0
class HMS0 extends MS {
    int h; 
    
    HMS0(int h0, int m0, int s0) {
        super(m0, s0); 
        this.h = h0;   
    }
}

public class AP22 {
    
    static void testArray() {
        // 1. 先印出 --- testArray ---
        System.out.println("--- testArray ---");
        
        // 2. 宣告與實例化局部變數
        MS p1_ = new MS(5, 30);
        MS q1_ = new MS(5, 190);
        HMS0 p2 = new HMS0(5, 50, 42);
        MS p2_ = new HMS0(5, 50, 42); // 向上轉型 (Upcasting)
        HMS0 p3 = new HMS0(2, 20, 15);
        MS p3_ = new HMS0(2, 20, 15); // 向上轉型 (Upcasting)
        
        // 印出變數所指物件 (物件之間換行)
        System.out.println("p1_:" + p1_);
        System.out.println("q1_:" + q1_);
        System.out.println("p2:" + p2);
        System.out.println("p2_:" + p2_);
        System.out.println("p3:" + p3);
        System.out.println("p3_:" + p3_);
        
        // 印出一個空行以符合題目輸出格式
        System.out.println();
        
        // 3. 另造 MS[] 型態的局部變數 a
        // 陣列可以存放子類別的物件，這展現了多型的特性
        MS[] a = {p1_, q1_, p2, p3};
        
        // 用迴圈印出陣列內容，各值以空格分開
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            // 若不是最後一個元素，則印出空格分隔
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