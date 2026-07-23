public class ArrayTool {

    // 印出陣列A的前s個元素. 前後有方括號, 中間用逗點空格隔開.
    static void print(float[] A, int s) {
        System.out.print("[ ");
        for (int i = 0; i < s; i++) {
            System.out.print(A[i] + ", ");
        }
        System.out.print("]");
    }
    
    // 印出陣列A的全部元素
    static void print(float[] A) {
        print(A, A.length);
    }
    
    // 呼叫print(A, s)然後換行
    static void println(float[] A, int s) {
        print(A, s);
        System.out.println();
    }
    
    // 呼叫print(A)然後換行
    static void println(float[] A) {
        print(A);
        System.out.println();
    }
    
    // 複製陣列A, 新陣列為函數值
    static float[] copy(float[] A) {
        float[] newA = new float[A.length];
        for (int i = 0; i < A.length; i++) {
            newA[i] = A[i];
        }
        return newA;
    }
    
    // 測試各個函數
    public static void main(String[] args) {
        float[] testArr = {1.1f, 2.2f, 3.3f, 4.4f};
        System.out.print("print(A, 2): ");
        print(testArr, 2);
        System.out.println();
        System.out.print("println(A): ");
        println(testArr);
    }
}