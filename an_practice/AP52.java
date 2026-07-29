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

class Node_XY {
    XY data;
    Node_XY next;
    
    Node_XY(XY data) {
        this.data = data;
        this.next = null;
    }
}

class SLList_XY {
    Node_XY head;
    
    SLList_XY() {
        this.head = null;
    }
    
    void prepend(XY v) {
        Node_XY newNode = new Node_XY(v);
        newNode.next = this.head;
        this.head = newNode;
    }
    
    void insAfter(Node_XY p, XY v) {
        if (p != null) {
            Node_XY newNode = new Node_XY(v);
            newNode.next = p.next;
            p.next = newNode;
        }
    }
    
    SLList_XY(XY[] arr) {
        this(); 
        for (int i = arr.length - 1; i >= 0; i--) {
            this.prepend(arr[i]);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node_XY curr = head;
        while (curr != null) {
            sb.append(curr.data).append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

class AP51 {
    static SLList_XY L1, L2;
    
    static void step1() {
        System.out.println("--- step 1 ---"); 
        XY[] data = { new XY(1,9), new XY(2,9), new XY(3,9) };
        L1 = new SLList_XY(data);
        System.out.println("L1: " + L1); 
    } 
}

public class AP52 extends AP51 {
    
    static void step2() {
        System.out.println("\n--- step 2 ---");
        
        for (Node_XY curr = L1.head; curr != null; curr = curr.next) {
            curr.data.swap();
        }
        
        System.out.println("L1: " + L1);
    }
    
    public static void main(String[] args) {
        step1();
        step2();
    }
}