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
    Node_XY tail; // 指向末節點

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

class AP62 extends AP61 {
    static void step2() {
        System.out.println("\n--- step 2 --- ");
        if (L1 != null && L1.tail != null) {
            Node_XY head = L1.tail.next; 
            for (Node_XY curr = head; curr != null; curr = curr.next) {
                curr.data.swap(); 
                if (curr == L1.tail) {
                    break; 
                }
            }
        }
        System.out.println("L1: " + L1);
    }
}

class AP63 extends AP62 {
    static void step3() {
        System.out.println("\n--- step 3 --- ");
        L2 = new CLList_XY();
        
        XY[] dataToAppend = {
            new XY(8, 11),
            new XY(8, 12),
            new XY(8, 13),
            new XY(8, 14)
        };
        
        for (int i = 0; i < dataToAppend.length; i++) {
            XY v = dataToAppend[i];
            L2.append(v);
        }
        System.out.println("L2: " + L2);
    }
}

public class AP64 extends AP63 {
    
    static void step4() {
        System.out.println("\n--- step 4 --- ");
        
        Node_XY p;
        
        p = L1.tail;
        
        if (p != null) {
            Node_XY stop = p; // 記住原本的末節點
            p = p.next;       // 將 p 移至首節點開始巡行
            
            while (true) {
                L2.append(p.data);
                if (p == stop) {
                    break; 
                }
                p = p.next;
            }
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