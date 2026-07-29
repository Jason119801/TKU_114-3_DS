class MS {
    int m, s;
    
    MS(int m0, int s0) {
        this.m = m0;
        this.s = s0;
        this.adjust();
    }
    
    void addS(int ds) {
        this.s += ds;
        this.adjust();
    }
    
    void adjust() {
        if (this.m < 0 || this.s < 0) return; 
        this.m += this.s / 60;
        this.s %= 60;
    }
    
    void incS() {
        this.addS(1);
    }

    public String toString() {
        return this.m + "m" + this.s + "s";
    }
    
    MS mul2() {
        return new MS(this.m * 2, this.s * 2);
    }
    
    MS add(MS t2) {
        return new MS(this.m + t2.m, this.s + t2.s);
    }
}

public class AP14 {
    public static void main(String[] args) {
        MS p1 = new MS(5, 30);
        // 使用 toString() 取代 toStr()
        System.out.println("p1:" + p1.toString());
        
        p1.addS(50);
        System.out.println("p1:" + p1.toString());
        
        MS p2 = new MS(2, 40);
        System.out.println("p1:" + p1.toString() + ", p2:" + p2.toString());
        
        p2 = p2.mul2();
        System.out.println("p1:" + p1.toString() + ", p2:" + p2.toString());
        
        MS p3 = p1.add(p2);
        p1.incS();
        System.out.println("p1:" + p1.toString() + ", p2:" + p2.toString() + ", p3:" + p3.toString());
    }
}