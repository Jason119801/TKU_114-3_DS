class sMS {
    int m, s;
    
    // 建構子負責設定this的欄位m及s
    sMS(int m0, int s0) {
        this.m = m0;
        this.s = s0;
    }
    
    // 將p的s欄位加上ds
    static void addS(sMS p, int ds) {
        p.s += ds;
    }
    
    static void incS(sMS p) {
        addS(p, 1);
    }
    
    static String toStr(sMS p) {
        return p.m + "m" + p.s + "s";
    }
}

public class AP11 {
    public static void main(String[] args) {
        // 造出sMS型態的局部變數p1. 用參數5,30造出sMS物件, 用p1指住這個物件.
        sMS p1 = new sMS(5, 30);
        // 利用toStr印出p1所指的物件.
        System.out.println(sMS.toStr(p1));
        // 用p1當參數呼叫 incS.
        sMS.incS(p1);
        // 利用toStr印出p1所指的物件.
        System.out.println(sMS.toStr(p1));
    }
}