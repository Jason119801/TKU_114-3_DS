import java.util.ArrayDeque;
import java.util.Deque;

public class DeliveryProcessingSystem {
    private Deque<DeliveryTask> waitingQueue = new ArrayDeque<>();
    private Deque<DeliveryTask> completedStack = new ArrayDeque<>();

    public void addTask(DeliveryTask task) {
        waitingQueue.offer(task);
        System.out.println("新增工作: " + task);
    }

    public void completeNext() {
        DeliveryTask task = waitingQueue.poll();
        if (task != null) {
            completedStack.push(task);
            System.out.println("完成工作: " + task);
        } else {
            System.out.println("沒有等待中的工作");
        }
    }

    public void peekNext() {
        DeliveryTask task = waitingQueue.peek();
        if (task != null) {
            System.out.println("下一筆待處理: " + task);
        } else {
            System.out.println("沒有等待中的工作");
        }
    }

    public void undoLastCompleted() {
        DeliveryTask task = completedStack.poll();
        if (task != null) {
            waitingQueue.offer(task);
            System.out.println("復原工作，回到等待佇列: " + task);
        } else {
            System.out.println("沒有可復原的完成紀錄");
        }
    }

    public void printStats() {
        System.out.println("--- 系統狀態 ---");
        System.out.println("等待數: " + waitingQueue.size());
        System.out.println("目前已完成紀錄 (由新到舊):");
        for (DeliveryTask t : completedStack) {
            System.out.println(" - " + t);
        }
        System.out.println("完成總數: " + completedStack.size());
    }

    public static void main(String[] args) {
        DeliveryProcessingSystem system = new DeliveryProcessingSystem();
        system.addTask(new DeliveryTask("T001", "台北"));
        system.addTask(new DeliveryTask("T002", "台中"));
        system.addTask(new DeliveryTask("T003", "高雄"));

        system.peekNext();
        system.completeNext();
        system.completeNext();

        system.printStats();

        system.undoLastCompleted();
        system.printStats();
    }
}