public class BuildLinkedList {
    public static void main(String[] args) {
        IntNode head = new IntNode(10);
        head.next = new IntNode(20);
        head.next.next = new IntNode(30);
        head.next.next.next = new IntNode(40);

        int count = 0;
        int sum = 0;
        IntNode current = head;
        
        System.out.print("走訪結果: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            count++;
            sum += current.data;
            current = current.next;
        }
        System.out.println("null");
        System.out.println("節點數: " + count);
        System.out.println("總和: " + sum);
    }
}