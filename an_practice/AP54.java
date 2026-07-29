public class AP54 extends AP53 {
    static void step4() {
        System.out.println("\n--- step 4 ---");

        Node_XY tail;
        
        tail = L2.head;
        if (tail != null) {
            while (tail.next != null) {
                tail = tail.next;
            }
        }
        Node_XY currL1 = L1.head;
        while (currL1 != null) {
            L2.insAfter(tail, currL1.data);
            
            tail = tail.next;
    
            currL1 = currL1.next;
        }
        
        System.out.println("L2: " + L2);
    }
    
    public static void main(String[] args) {
        step1();
        step2();
        step3();
        step4();
    }
}