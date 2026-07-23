public class PlaylistLinkedList {
    private PlaylistNode head;

    public boolean addLast(String code, String name) {
        if (search(code) != null) return false; // 代碼不可重複

        PlaylistNode newNode = new PlaylistNode(code, name);
        if (head == null) {
            head = newNode;
            return true;
        }
        
        PlaylistNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return true;
    }

    public PlaylistNode search(String code) {
        PlaylistNode current = head;
        while (current != null) {
            if (current.code.equalsIgnoreCase(code)) return current;
            current = current.next;
        }
        return null;
    }

    public boolean remove(String code) {
        if (head == null) return false;

        if (head.code.equalsIgnoreCase(code)) {
            head = head.next;
            return true;
        }

        PlaylistNode prev = head;
        PlaylistNode curr = head.next;
        while (curr != null) {
            if (curr.code.equalsIgnoreCase(code)) {
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public void printOrder() {
        System.out.println("--- 播放清單 ---");
        PlaylistNode current = head;
        if (current == null) {
            System.out.println("(空)");
            return;
        }
        while (current != null) {
            System.out.println(current.code + " - " + current.name);
            current = current.next;
        }
    }
}