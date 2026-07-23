public class TaskLinkedList {
    private TaskNode head;
    private int totalCount = 0;

    public void addEmergencyTask(String code, String desc) {
        TaskNode newNode = new TaskNode(code, desc);
        newNode.next = head;
        head = newNode;
        totalCount++;
    }

    public void addNormalTask(String code, String desc) {
        TaskNode newNode = new TaskNode(code, desc);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        totalCount++;
    }

    public boolean completeTask(String code) {
        TaskNode current = head;
        while (current != null) {
            if (current.code.equalsIgnoreCase(code)) {
                current.isCompleted = true;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean removeTask(String code) {
        if (head == null) return false;

        if (head.code.equalsIgnoreCase(code)) {
            head = head.next;
            totalCount--;
            return true;
        }

        TaskNode prev = head;
        TaskNode curr = head.next;
        while (curr != null) {
            if (curr.code.equalsIgnoreCase(code)) {
                prev.next = curr.next;
                totalCount--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public void listUncompleted() {
        System.out.println("--- 未完成工作 ---");
        TaskNode current = head;
        int uncompletedCount = 0;
        while (current != null) {
            if (!current.isCompleted) {
                System.out.println(current.code + " : " + current.description);
                uncompletedCount++;
            }
            current = current.next;
        }
        System.out.println("------------------");
        System.out.println("工作總數: " + totalCount);
        System.out.println("未完成數量: " + uncompletedCount);
    }
}