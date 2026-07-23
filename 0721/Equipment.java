public class Equipment {
    private String code;
    private String name;
    private boolean isAvailable;

    public Equipment(String code, String name) {
        this.code = code;
        this.name = name;
        this.isAvailable = true; // 預設可借用
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public boolean isAvailable() { return isAvailable; }
    
    public void setAvailable(boolean status) { this.isAvailable = status; }
    
    @Override
    public String toString() { 
        return code + " | " + name + " | 可借用: " + (isAvailable ? "是" : "否"); 
    }
}