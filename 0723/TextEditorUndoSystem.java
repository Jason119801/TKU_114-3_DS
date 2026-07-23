import java.util.ArrayDeque;
import java.util.Deque;

public class TextEditorUndoSystem {
    private String content = "";
    private Deque<String> history = new ArrayDeque<>();

    public void addText(String text) {
        history.push(content);
        content += text;
        System.out.println("新增文字後: " + content);
    }

    public void deleteLast(int count) {
        history.push(content);
        if (count >= content.length()) {
            content = "";
        } else {
            content = content.substring(0, content.length() - count);
        }
        System.out.println("刪除文字後: " + content);
    }

    public void undo() {
        if (history.isEmpty()) {
            System.out.println("無法復原：沒有歷史紀錄了！");
        } else {
            content = history.pop();
            System.out.println("Undo後: " + content);
        }
    }

    public void printContent() {
        System.out.println("目前內容: " + content);
    }

    public static void main(String[] args) {
        TextEditorUndoSystem editor = new TextEditorUndoSystem();
        editor.addText("Hello");
        editor.addText(" World");
        editor.addText("!");
        editor.deleteLast(6);

        System.out.println("--- 測試 Undo ---");
        editor.undo();
        editor.undo();
        editor.undo();
        editor.undo(); // 測試沒有歷史
    }
}