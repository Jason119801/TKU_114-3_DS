import java.util.ArrayList;

public class NameListManager {
    private static ArrayList<String> names = new ArrayList<>();

    public static void main(String[] args) {
        // 簡易測試
        addName("Alice");
        addName("Bob");
        addName("  "); // 應顯示錯誤
        System.out.println("全部名單: " + names);
        
        System.out.println("搜尋 Bob: " + searchName("bob")); // 忽略大小寫
        updateName("alice", "Alice Smith");
        System.out.println("修改後: " + names);
        
        removeName("bob");
        removeName("Charlie"); // 找不到
        System.out.println("最後名單: " + names);
    }

    public static void addName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("錯誤：姓名不可為空白");
            return;
        }
        names.add(name);
        System.out.println("新增成功：" + name);
    }

    public static boolean searchName(String name) {
        for (String n : names) {
            if (n.equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public static void updateName(String oldName, String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            System.out.println("錯誤：新姓名不可為空白");
            return;
        }
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(oldName)) {
                names.set(i, newName);
                System.out.println("修改成功");
                return;
            }
        }
        System.out.println("找不到該姓名");
    }

    public static void removeName(String name) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(name)) {
                names.remove(i);
                System.out.println("刪除成功：" + name);
                return;
            }
        }
        System.out.println("找不到姓名，刪除失敗：" + name);
    }
}