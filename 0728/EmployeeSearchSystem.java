class Employee {
    int id; String name; String dept; String ext;
    public Employee(int id, String name, String dept, String ext) {
        this.id = id; this.name = name; this.dept = dept; this.ext = ext;
    }
    public String toString() { return id + " " + name + " " + dept; }
}
public class EmployeeSearchSystem {
    public static void main(String[] args) {
        Employee[] emps = { new Employee(1, "A", "IT", "101"), new Employee(2, "B", "HR", "102") };
        int target = 2;
        int low = 0, high = emps.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (emps[mid].id == target) { System.out.println(emps[mid]); return; }
            if (target < emps[mid].id) high = mid - 1;
            else low = mid + 1;
        }
        System.out.println("找不到");
    }
}