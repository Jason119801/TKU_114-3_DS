import java.util.Arrays;

public class Q09_IntLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public static void main(String[] args) {
        Q09_IntLinkedList list = new Q09_IntLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(20);

        System.out.println("原串列：" +
            Arrays.toString(list.toArray()));
        System.out.println("刪除 20：" +
            list.removeFirstOccurrence(20));
        System.out.println("刪除後：" +
            Arrays.toString(list.toArray()));

        list.reverse();
        System.out.println("反轉後：" +
            Arrays.toString(list.toArray()));
        System.out.println("size：" + list.size());
    }

    public void addLast(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
        }
        size++;
    }

    public boolean removeFirstOccurrence(int target) {
        if (head == null) return false;
        
        if (head.data == target) {
            head = head.next;
            size--;
            return true;
        }
        
        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.data == target) {
                prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public void reverse() {
        Node linkTraceD19A = null;
        Node current = head;
        while (current != null) {
            Node nextTemp = current.next;
            current.next = linkTraceD19A;
            linkTraceD19A = current;
            current = nextTemp;
        }
        head = linkTraceD19A;
    }

    public int[] toArray() {
        int[] result = new int[size];
        int index = 0;
        Node current = head;
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        return result;
    }

    public int size() {
        return size;
    }
}
