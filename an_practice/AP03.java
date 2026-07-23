public class AP03 {
    static boolean show = false;
    
    // 將A中 < x 的元素抄入to中, 函數值是抄寫的個數
    static int copyBelow(float[] A, float x, float[] to) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < x) {
                to[count] = A[i];
                count++;
            }
            if (show) {
                System.out.println("// @" + i + " " + A[i] + ":");
                ArrayTool.println(to, count);
            }
        }
        return count;
    }

    static void demo(float[] A, float bound) {
        ArrayTool.println(A);
        System.out.println("copy below " + bound + ":");
        float[] to = new float[A.length];
        int count = copyBelow(A, bound, to);
        System.out.println("result:");
        ArrayTool.println(to, count);
        System.out.println();
    }
    
    public static void main(String[] dummy) {
        float[] A = { 5.0f, 91.0f, 30.0f, 16.0f, 17.0f, 80.0f, 15.0f };
        
        show = true;
        demo(A, 60.0f);
        
        show = false;
        demo(A, 100.0f);
        demo(A, 3.0f);
        demo(A, 10.0f);
        demo(A, 20.0f);
        
        System.out.println("OK");
    }
}