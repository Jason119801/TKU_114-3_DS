public class MS {
    int m, s;

    // 建構子負責設定 m, s，並呼叫 adjust() 確保建立時的格式正確
    public MS(int m0, int s0) {
        this.m = m0;
        this.s = s0;
        this.adjust(); 
    }

    // 非靜態：將本身的 s 加上 ds
    public void addS(int ds) {
        this.s += ds;
    }

    // 非靜態：調整本身的值，使 s 介於 0~59 之間
    public void adjust() {
        if (this.m < 0 || this.s < 0) return;
        this.m += this.s / 60;
        this.s %= 60;
    }

    // 非靜態：將本身的秒數加 1，並自動進位
    public void incS() {
        this.addS(1);
        this.adjust();
    }

    // 為了相容較早題目的 toStr() 呼叫
    public String toStr() {
        return this.toString();
    }

    // 覆寫原生 toString() 方便後續題目直接列印物件
    @Override
    public String toString() {
        return this.m + "m" + this.s + "s";
    }

    // 非靜態：造出時刻為本身兩倍的新物件並回傳
    public MS mul2() {
        MS ans = new MS(this.m * 2, this.s * 2);
        ans.adjust();
        return ans;
    }

    // 非靜態：造出時刻為本身與 t2 和的新物件並回傳
    public MS add(MS t2) {
        MS ans = new MS(this.m + t2.m, this.s + t2.s);
        ans.adjust();
        return ans;
    }

    // 為了 AP31 後續的覆寫需求新增的歸零方法
    public void reset() {
        this.m = 0;
        this.s = 0;
    }
}