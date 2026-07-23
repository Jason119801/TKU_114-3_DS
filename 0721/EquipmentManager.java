import java.util.ArrayList;

public class EquipmentManager {
    public static void main(String[] args) {
        ArrayList<Equipment> equipments = new ArrayList<>();
        
        // 簡易測試
        addEquipment(equipments, new Equipment("E01", "Projector"));
        addEquipment(equipments, new Equipment("E02", "Microphone"));
        addEquipment(equipments, new Equipment("E01", "Screen")); // 應拒絕重複代碼

        borrowEquipment(equipments, "E01");
        borrowEquipment(equipments, "E03"); // 找不到

        listAvailable(equipments); // 應只列出 E02
        
        returnEquipment(equipments, "E01");
        listAvailable(equipments); // 應列出 E01, E02
    }

    public static void addEquipment(ArrayList<Equipment> list, Equipment eq) {
        if (searchByCode(list, eq.getCode()) == null) {
            list.add(eq);
            System.out.println("新增設備成功: " + eq.getName());
        } else {
            System.out.println("新增失敗，代碼已存在: " + eq.getCode());
        }
    }

    public static Equipment searchByCode(ArrayList<Equipment> list, String code) {
        for (Equipment e : list) {
            if (e.getCode().equalsIgnoreCase(code)) return e;
        }
        return null;
    }

    public static void borrowEquipment(ArrayList<Equipment> list, String code) {
        Equipment eq = searchByCode(list, code);
        if (eq == null) {
            System.out.println("錯誤：找不到設備 " + code);
        } else if (!eq.isAvailable()) {
            System.out.println("錯誤：設備已借出 " + eq.getName());
        } else {
            eq.setAvailable(false);
            System.out.println("借出成功: " + eq.getName());
        }
    }

    public static void returnEquipment(ArrayList<Equipment> list, String code) {
        Equipment eq = searchByCode(list, code);
        if (eq != null && !eq.isAvailable()) {
            eq.setAvailable(true);
            System.out.println("歸還成功: " + eq.getName());
        }
    }

    public static void listAvailable(ArrayList<Equipment> list) {
        System.out.println("--- 目前可借用設備 ---");
        for (Equipment e : list) {
            if (e.isAvailable()) System.out.println(e);
        }
    }
}