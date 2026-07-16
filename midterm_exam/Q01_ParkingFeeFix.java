public class Q01_ParkingFeeFix {
    public static void main(String[] args) {
        int[] testMinutes = {-20, 30, 31, 60, 61, 120, 121, 420};
        for (int minutes : testMinutes) {
            int fee = calculateFee(minutes);
            System.out.println("停車 " + minutes + " 分鐘，費用：" + fee + " 元");
        }
    }
    public static int calculateFee(int minutes) {
        // 停車時間小於 0 分鐘，回傳 -1
        if (minutes < 0) {
            return -1;
        }

        if (minutes <= 30) {
            return 0;
        }
        
        int fee = 0;
        
        if (minutes > 30 && minutes <= 120) {
            // 使用 Math.ceil 進行小數點向上取整，再轉回 int
            fee = (int) Math.ceil((minutes - 30) / 30.0) * 20;
        } 
        else if (minutes > 120) {
            // 前 120 分鐘 60 元，之後每開始 60 分鐘 30 元
            fee = 60 + (int) Math.ceil((minutes - 120) / 60.0) * 30;
        }
        
        // 單次停車費最高為 180 元
        return Math.min(fee, 180);
    }
}