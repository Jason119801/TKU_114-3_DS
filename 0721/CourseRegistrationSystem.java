import java.util.ArrayList;

// 補上缺少的 Course 類別
class Course {
    private String code;
    private String name;
    private int capacity;
    private int enrolled;

    public Course(String code, String name, int capacity) {
        this.code = code;
        this.name = name;
        this.capacity = capacity;
        this.enrolled = 0; // 初始選課人數為 0
    }

    public String getCode() {
        return code;
    }

    // 選課邏輯：若未滿則人數加 1 並回傳 true，否則回傳 false
    public boolean enroll() {
        if (enrolled < capacity) {
            enrolled++;
            return true;
        }
        return false;
    }

    public void drop() {
        if (enrolled > 0) {
            enrolled--;
        }
    }

    public int getEnrolled() {
        return enrolled;
    }

    // 判斷是否額滿
    public boolean isFull() {
        return enrolled >= capacity;
    }

    @Override
    public String toString() {
        return code + " - " + name + " (已選: " + enrolled + " / 上限: " + capacity + ")";
    }
}

public class CourseRegistrationSystem {
    private static ArrayList<Course> courses = new ArrayList<>();
    
    public static void main(String[] args) {
        addCourse(new Course("C01", "Java Programming", 2));
        addCourse(new Course("C02", "Data Structures", 3));
        
        enroll("C01"); 
        enroll("C01"); 
        enroll("C01"); // 第三次應失敗 (額滿)
        
        enroll("C02");
        drop("C02");
        
        printStats();
    }
    
    public static void addCourse(Course c) {
        if (search(c.getCode()) == null) {
            courses.add(c);
            System.out.println("新增課程: " + c.getCode());
        }
    }
    
    public static Course search(String code) {
        for (Course c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) return c;
        }
        return null;
    }
    
    public static void enroll(String code) {
        Course c = search(code);
        if (c != null) {
            if (c.enroll()) {
                System.out.println("選課成功: " + code);
            } else {
                System.out.println("選課失敗，課程已滿: " + code);
            }
        } else {
            System.out.println("找不到課程");
        }
    }
    
    public static void drop(String code) {
        Course c = search(code);
        if (c != null) {
            c.drop();
            System.out.println("退選成功: " + code);
        }
    }
    
    public static void deleteCourse(String code) {
        Course c = search(code);
        if (c != null) {
            courses.remove(c);
            System.out.println("已刪除課程: " + code);
        }
    }
    
    public static void printStats() {
        int totalEnrolled = 0;
        System.out.println("\n--- 系統統計 ---");
        System.out.println("額滿課程清單:");
        for (Course c : courses) {
            totalEnrolled += c.getEnrolled();
            if (c.isFull()) {
                System.out.println(" - " + c.getCode());
            }
        }
        System.out.println("總課程數: " + courses.size());
        System.out.println("總選課人次: " + totalEnrolled);
        System.out.println("所有課程狀態:");
        for (Course c : courses) {
            System.out.println(c);
        }
    }
}