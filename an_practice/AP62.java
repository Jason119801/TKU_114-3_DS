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

class CLList_XY {
    Node_XY tail;

    CLList_XY() {
        this.tail = null;
    }

    CLList_XY(XY[] arr) {
        this(); 
        for (int i = 0; i < arr.length; i++) {
            this.append(arr[i]);
        }
    }

    void append(XY v) {
        Node_XY newNode = new Node_XY(v);
        if (this.tail == null) {
            this.tail = newNode;
            this.tail.next = this.tail;
        } else {
            newNode.next = this.tail.next;
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    void insAfter(Node_XY p, XY v) {
        if (p == null) return; 
        Node_XY newNode = new Node_XY(v);
        
        newNode.next = p.next;
        p.next = newNode;
        
        if (this.tail == p) {
            this.tail = newNode;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        if (tail != null) {
            Node_XY head = tail.next; 
            Node_XY curr = head;
            do {
                sb.append(curr.data).append(", ");
                curr = curr.next;
            } while (curr != head); 
        }
        sb.append("]");
        return sb.toString();
    }
}

class AP61 {
    static CLList_XY L1, L2;

    static void step1() {
        System.out.println("\n--- step 1 --- "); 
        XY[] data = { new XY(1,9), new XY(2,9), new XY(3,9) };
        L1 = new CLList_XY(data);
        System.out.println("L1: " + L1); 
    }
}

public class AP62 extends AP61 {
    
    static void step2() {
        System.out.println("\n--- step 2 --- ");
        
        if (L1 != null && L1.tail != null) {
            Node_XY head = L1.tail.next;
            
            for (Node_XY curr = head; curr != null; curr = curr.next) {
                curr.data.swap(); // x, y 交換
                if (curr == L1.tail) {
                    break; // 到達末節點就結束
                }
            }
        }
        
        System.out.println("L1: " + L1);
    }
    
    public static void main(String[] args) {
        step1();
        step2();
    }
}