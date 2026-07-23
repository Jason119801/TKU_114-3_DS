public class HMS0 extends MS {
    int h;

    // 建構子負責呼叫父類別(MS)的建構子，然後自行設定 h
    public HMS0(int h0, int m0, int s0) {
        super(m0, s0); // 呼叫 MS 的建構子
        this.h = h0;
    }
    
    // 注意：此階段尚未覆寫 toString()，印出時仍會使用父類別 MS 的格式（無 h 欄位）
}