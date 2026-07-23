public class sMS {
    int m, s;
    
    // 建構子
    public sMS(int m0, int s0) {
        this.m = m0;
        this.s = s0;
    }
    
    // 將 p 的 s 欄位加上 ds
    public static void addS(sMS p, int ds) {
        p.s += ds;
    }
    
    // 調整 p 的值，使 p.s 介於 0~59 之間
    public static void adjust(sMS p) {
        if (p.m < 0 || p.s < 0) return; 
        p.m += p.s / 60;
        p.s %= 60;
    }
    
    // 將 p 的 s 欄位加 1 並調整進位
    public static void incS(sMS p) {
        addS(p, 1);
        adjust(p);
    }
    
    // 傳回 p 的純文字格式
    public static String toStr(sMS p) {
        return p.m + "m" + p.s + "s";
    }
    
    // 造出時刻為 t1 兩倍的新物件並調整進位
    public static sMS mul2(sMS t1) {
        sMS ans = new sMS(t1.m * 2, t1.s * 2);
        adjust(ans);
        return ans;
    }
    
    // 造出時刻為 t1, t2 和的新物件並調整進位
    public static sMS add(sMS t1, sMS t2) {
        sMS ans = new sMS(t1.m + t2.m, t1.s + t2.s);
        adjust(ans);
        return ans;
    }
}