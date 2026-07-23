import java.util.ArrayList;

public class ContactBookSystem {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    
    public static void main(String[] args) {
        addContact(new Contact("C01", "Amy", "0912-345", "amy@a.com"));
        addContact(new Contact("C02", "Ben", "0934-567", "ben@b.com"));
        addContact(new Contact("C01", "Cara", "0988", "c@c.com")); // 應拒絕 (代碼重複)
        addContact(new Contact("C03", "   ", "0999", "")); // 應拒絕 (姓名空白)
        
        System.out.println("搜尋 C01: " + searchContact("C01"));
        updatePhone("C01", "0988-888-888");
        listAll();
        
        removeContact("C02");
        listAll();
    }
    
    // 方法 1: 新增
    public static void addContact(Contact c) {
        if (c.getName() == null || c.getName().trim().isEmpty()) {
            System.out.println("錯誤：姓名不可為空白");
            return;
        }
        if (searchContact(c.getCode()) == null) {
            contacts.add(c);
            System.out.println("新增聯絡人: " + c.getName());
        } else {
            System.out.println("錯誤：代碼重複 " + c.getCode());
        }
    }
    
    // 方法 2: 搜尋
    public static Contact searchContact(String code) {
        for (Contact c : contacts) {
            if (c.getCode().equalsIgnoreCase(code)) return c;
        }
        return null;
    }
    
    // 方法 3: 修改電話
    public static void updatePhone(String code, String newPhone) {
        Contact c = searchContact(code);
        if (c != null) {
            c.setPhone(newPhone);
            System.out.println(c.getName() + " 的電話已修改");
        } else {
            System.out.println("找不到聯絡人: " + code);
        }
    }
    
    // 方法 4: 刪除
    public static void removeContact(String code) {
        Contact c = searchContact(code);
        if (c != null) {
            contacts.remove(c);
            System.out.println("已刪除聯絡人: " + code);
        } else {
            System.out.println("找不到聯絡人: " + code);
        }
    }
    
    // 方法 5: 列出全部
    public static void listAll() {
        System.out.println("--- 聯絡人清單 ---");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}