import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserUndoSystem {
    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();
        String currentPage = "Home"; 
        System.out.println("開啟: " + currentPage);
        
        // 1
        history.push(currentPage);
        currentPage = "Page 1";
        System.out.println("開啟: " + currentPage);
        
        // 2
        history.push(currentPage);
        currentPage = "Page 2";
        System.out.println("開啟: " + currentPage);
        
        // 3
        System.out.println("目前頁面: " + currentPage);
        
        // 4
        if (!history.isEmpty()) {
            currentPage = history.pop();
            System.out.println("返回上一頁，目前頁面: " + currentPage);
        }
        
        // 5
        history.push(currentPage);
        currentPage = "Page 3";
        System.out.println("開啟: " + currentPage);
        
        // 6
        if (!history.isEmpty()) {
            currentPage = history.pop();
            System.out.println("返回上一頁，目前頁面: " + currentPage);
        }
        
        // 7
        if (!history.isEmpty()) {
            currentPage = history.pop();
            System.out.println("返回上一頁，目前頁面: " + currentPage);
        }
        
        // 8
        if (!history.isEmpty()) {
            currentPage = history.pop();
        } else {
            System.out.println("錯誤：已經沒有上一頁了！");
        }
    }
}