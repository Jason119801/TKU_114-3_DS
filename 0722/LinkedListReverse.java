public class LinkedListReverse {
    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList();
        
        System.out.print("空串列反轉前: ");
        list.print();
        list.reverse();
        System.out.print("空串列反轉後: ");
        list.print();

        list.addLast(10);
        System.out.print("單一節點反轉前: ");
        list.print();
        list.reverse();
        System.out.print("單一節點反轉後: ");
        list.print();

        list.addLast(20);
        list.addLast(30);
        System.out.print("多節點反轉前: ");
        list.print();
        list.reverse();
        System.out.print("多節點反轉後: ");
        list.print();
    }
}