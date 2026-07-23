public class LinkedListSearchRemove {
    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        System.out.print("初始狀態: ");
        list.print();

        System.out.println("刪除頭部 10: " + list.removeValue(10));
        list.print();

        System.out.println("刪除中間 30: " + list.removeValue(30));
        list.print();

        System.out.println("刪除尾部 40: " + list.removeValue(40));
        list.print();

        System.out.println("刪除不存在 99: " + list.removeValue(99));
        list.print();
    }
}