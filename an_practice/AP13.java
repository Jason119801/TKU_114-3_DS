public class AP13 {
    public static void main(String[] args) {
        // 1. 造出MS物件
        MS p1 = new MS(5, 30);
        System.out.println("p1:" + p1.toStr());
        
        // 2. 呼叫實體方法 addS，並手動 adjust
        p1.addS(50);
        p1.adjust();
        System.out.println("p1:" + p1.toStr());
        
        // 3. 造出物件 p2
        MS p2 = new MS(2, 40);
        System.out.println("p1:" + p1.toStr() + ", p2:" + p2.toStr());
        
        // 4. 用 p2 呼叫實體方法 mul2
        p2 = p2.mul2();
        System.out.println("p1:" + p1.toStr() + ", p2:" + p2.toStr());
        
        // 5. 用 p1 呼叫 add(p2) 交給 p3，p1 呼叫 incS()
        MS p3 = p1.add(p2);
        p1.incS();
        System.out.println("p1:" + p1.toStr() + ", p2:" + p2.toStr() + ", p3:" + p3.toStr());
    }
}