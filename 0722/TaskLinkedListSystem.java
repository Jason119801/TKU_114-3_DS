public class TaskLinkedListSystem {
    public static void main(String[] args) {
        TaskLinkedList system = new TaskLinkedList();

        system.addNormalTask("T01", "寫作業");
        system.addNormalTask("T02", "整理房間");
        system.addEmergencyTask("E01", "修復伺服器"); // 加到前端

        system.listUncompleted();

        System.out.println("完成 T01: " + system.completeTask("T01"));
        System.out.println("刪除 T02: " + system.removeTask("T02"));

        system.listUncompleted();
    }
}