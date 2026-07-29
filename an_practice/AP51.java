class XY {
    int x;
    int y;
    
    XY(int x0, int y0) {  
        this.x = x0;  
        this.y = y0;  
    }
    
    @Override 
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
    
    void swap() {
        int t = this.x;  
        this.x = this.y;  
        this.y = t;
    }
}

class SLList_XY {
    class Node {
        XY data;
        Node next;
        
        Node(XY data) {
            this.data = data;
            this.next = null;
        }
    }
    
    Node head;
    
    SLList_XY() {
        this.head = null;
    }
    
    void prepend(XY v) {
        Node newNode = new Node(v);
        newNode.next = this.head;
        this.head = newNode;
    }
    
    SLList_XY(XY[] arr) {
        this(); // 呼叫空串列建構子
        // 為了確保印出時的順序與陣列相同，必須從陣列尾端反向 prepend
        for (int i = arr.length - 1; i >= 0; i--) {
            this.prepend(arr[i]);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node curr = head;
        while (curr != null) {
            sb.append(curr.data).append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class AP51 {
    static SLList_XY L1, L2;
    
    static void step1() {
        System.out.println("\n--- step 1 --- "); 
        XY[] data = { new XY(1,9), new XY(2,9), new XY(3,9) };
        L1 = new SLList_XY(data);
        System.out.println("L1: " + L1); 
    } 
    
    public static void main(String[] args) {
        step1();
    }
}