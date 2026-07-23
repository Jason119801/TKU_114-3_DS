class sMS12 {
    int m, s;
    
    sMS12(int m0, int s0) {
        this.m = m0;
        this.s = s0;
    }
    
    static void addS(sMS12 p, int ds) {
        p.s += ds;
    }
    
    // 調整p的值, 使p.s介於0~59之間 (拒絕處理負的)
    static void adjust(sMS12 p) {
        if (p.m < 0 || p.s < 0) return; 
        p.m += p.s / 60;
        p.s %= 60;
    }
    
    // 修改incS, 使答案的s介於0~59之間
    static void incS(sMS12 p) {
        addS(p, 1);
        adjust(p);
    }
    
    static String toStr(sMS12 p) {
        return p.m + "m" + p.s + "s";
    }
    
    static sMS12 mul2(sMS12 t1) {
        sMS12 ans = new sMS12(t1.m * 2, t1.s * 2);
        adjust(ans);
        return ans;
    }
    
    static sMS12 add(sMS12 t1, sMS12 t2) {
        sMS12 ans = new sMS12(t1.m + t2.m, t1.s + t2.s);
        adjust(ans);
        return ans;
    }
}

public class AP12 {
    public static void main(String[] args) {
        // 1. 造出物件p1 (5,30)，並印出標示局部變數的名稱
        sMS12 p1 = new sMS12(5, 30);
        System.out.println("p1:" + sMS12.toStr(p1));
        
        // 2. 用p1,50呼叫addS，再進行手動調整以正確進位，然後印出
        sMS12.addS(p1, 50);
        sMS12.adjust(p1);
        System.out.println("p1:" + sMS12.toStr(p1));
        
        // 3. 造出物件p2 (2,40)，然後印出p1, p2
        sMS12 p2 = new sMS12(2, 40);
        System.out.println("p1:" + sMS12.toStr(p1) + ", p2:" + sMS12.toStr(p2));
        
        // 4. 呼叫mul2將p2指向兩倍的結果，然後印出p1, p2
        p2 = sMS12.mul2(p2);
        System.out.println("p1:" + sMS12.toStr(p1) + ", p2:" + sMS12.toStr(p2));
        
        // 5. 呼叫add將p1, p2相加交給p3。呼叫incS處理p1。然後印出p1, p2, p3
        sMS12 p3 = sMS12.add(p1, p2);
        sMS12.incS(p1);
        System.out.println("p1:" + sMS12.toStr(p1) + ", p2:" + sMS12.toStr(p2) + ", p3:" + sMS12.toStr(p3));
    }
}