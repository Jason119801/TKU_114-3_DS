public class NumberHistoryList {
    private IntNode head;
    private int size;

    public void addFirst(int value) {
        IntNode newNode = new IntNode(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int value) {
        IntNode newNode = new IntNode(value);
        if (head == null) {
            head = newNode;
        } else {
            IntNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public boolean search(int value) {
        IntNode current = head;
        while (current != null) {
            if (current.data == value) return true;
            current = current.next;
        }
        return false;
    }

    public boolean remove(int value) {
        if (head == null) return false;
        
        if (head.data == value) {
            head = head.next;
            size--;
            return true;
        }

        IntNode prev = head;
        IntNode curr = head.next;
        while (curr != null) {
            if (curr.data == value) {
                prev.next = curr.next;
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public void print() {
        IntNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printStats() {
        if (head == null) {
            System.out.println("統計資料 -> size: 0, 總和: 0, 最大值: 無, 最小值: 無");
            return;
        }
        int sum = 0, max = head.data, min = head.data;
        IntNode current = head;
        while (current != null) {
            sum += current.data;
            if (current.data > max) max = current.data;
            if (current.data < min) min = current.data;
            current = current.next;
        }
        System.out.println("統計資料 -> size: " + size + ", 總和: " + sum + ", 最大值: " + max + ", 最小值: " + min);
    }

    public static void main(String[] args) {
        NumberHistoryList list = new NumberHistoryList();
        
        // 至少 8 次操作測試
        list.printStats();          // 1
        list.addLast(10);           // 2
        list.addFirst(20);          // 3
        list.addLast(5);            // 4
        list.addLast(30);           // 5
        list.print();               // 6
        list.printStats();          // 7
        list.remove(20);            // 8
        list.print();
        list.printStats();
    }
}