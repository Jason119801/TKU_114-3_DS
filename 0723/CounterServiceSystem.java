import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
import java.util.List;

public class CounterServiceSystem {
    public static void main(String[] args) {
        Deque<String> queue = new ArrayDeque<>();
        List<String> records = new ArrayList<>();

        queue.offer("001 - Amy");
        queue.offer("002 - Ben");
        queue.offer("003 - Cara");

        System.out.println("下一位: " + queue.peek());
        System.out.println("等待人數: " + queue.size());

        serve(queue, records);
        serve(queue, records);
        serve(queue, records);
        
        serve(queue, records); // 測試空 Queue

        System.out.println("處理紀錄: " + records);
    }

    public static void serve(Deque<String> queue, List<String> records) {
        String customer = queue.poll();
        if (customer == null) {
            System.out.println("目前無人等待");
        } else {
            System.out.println("叫號服務: " + customer);
            records.add(customer);
        }
    }
}