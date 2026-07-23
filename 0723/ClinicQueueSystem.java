import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ClinicQueueSystem {
    private Deque<Patient> queue = new ArrayDeque<>();
    private Map<String, Integer> deptWaitCount = new HashMap<>();
    private int totalServed = 0;

    public void register(Patient p) {
        for (Patient existing : queue) {
            if (existing.getNumber().equals(p.getNumber())) {
                System.out.println("錯誤：號碼 " + p.getNumber() + " 已存在");
                return;
            }
        }
        queue.offer(p);
        deptWaitCount.put(p.getDepartment(), deptWaitCount.getOrDefault(p.getDepartment(), 0) + 1);
        System.out.println("掛號成功: " + p);
    }

    public void callNext() {
        Patient p = queue.poll();
        if (p == null) {
            System.out.println("目前無人等待看診");
        } else {
            System.out.println("請 " + p.getName() + " 到 " + p.getDepartment() + " 看診");
            deptWaitCount.put(p.getDepartment(), deptWaitCount.get(p.getDepartment()) - 1);
            totalServed++;
        }
    }

    public void peekNext() {
        Patient p = queue.peek();
        if (p != null) {
            System.out.println("下一位: " + p);
        } else {
            System.out.println("目前無人等待");
        }
    }

    public void printWaitingList() {
        System.out.println("--- 等待清單 ---");
        for (Patient p : queue) {
            System.out.println(p);
        }
    }

    public void printStats() {
        System.out.println("--- 統計資料 ---");
        System.out.println("總服務人數: " + totalServed);
        System.out.println("各科等待人數:");
        for (Map.Entry<String, Integer> entry : deptWaitCount.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        ClinicQueueSystem clinic = new ClinicQueueSystem();
        clinic.register(new Patient("N01", "Amy", "內科"));
        clinic.register(new Patient("N02", "Ben", "外科"));
        clinic.register(new Patient("N03", "Cara", "內科"));
        clinic.register(new Patient("N01", "Dave", "眼科")); // 應拒絕

        clinic.peekNext();
        clinic.printWaitingList();
        
        clinic.callNext();
        clinic.printStats();
    }
}