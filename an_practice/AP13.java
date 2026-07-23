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
    
    String toStr() {
        return this.m + "m" + this.s + "s";
    }
    
    MS mul2() {
        // 建構子內已經有調用 adjust()
        return new MS(this.m * 2, this.s * 2);
    }
    
    // 實體方法：將本身 (this) 與傳入的物件 (t2) 相加，並回傳新的 MS 物件
    MS add(MS t2) {
        return new MS(this.m + t2.m, this.s + t2.s);
    }
}

public class AP13 {
    public static void main(String[] args) {
        // 1. 造出物件p1 (5,30)，並印出標示局部變數的名稱
        MS p1 = new MS(5, 30);
        System.out.println("p1:" + p1.toStr());
        
        // 2. 呼叫addS增加50秒 (addS內已包含adjust，因此不需在main裡手動adjust)
        p1.addS(50);
        System.out.println("p1:" + p1.toStr());
        
        // 3. 造出物件p2 (2,40)，然後印出p1, p2
        MS p2 = new MS(2, 40);
        System.out.println("p1:" + p1.toStr() + ", p2:" + p2.toStr());
        
        // 4. 呼叫實體方法mul2將p2指向兩倍的結果，然後印出p1, p2
        p2 = p2.mul2();
        System.out.println("p1:" + p1.toStr() + ", p2:" + p2.toStr());
        
        // 5. 呼叫實體方法add將p1, p2相加交給p3。呼叫incS處理p1。然後印出p1, p2, p3
        MS p3 = p1.add(p2);
        p1.incS();
        System.out.println("p1:" + p1.toStr() + ", p2:" + p2.toStr() + ", p3:" + p3.toStr());
    }
}