public class AP53 extends AP52 {
    
    static void step3() {
        System.out.println("\n--- step 3 ---");
        
        L2 = new SLList_XY();
        Node_XY tail;
        
        L2.prepend(new XY(8, 11));
        tail = L2.head;
        
        XY[] items = { new XY(8, 12), new XY(8, 13), new XY(8, 14) };
        
        for (int i = 0; i < items.length; i++) {
            // 指標 v 指住要存入的 XY 物件
            XY v = items[i];
            L2.insAfter(tail, v);
            tail = tail.next;
        }
        
        System.out.println("L2: " + L2);
    }
    
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }
}