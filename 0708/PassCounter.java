public class PassCounter {
    public static void main(String[] args) {
        int count = 0;
        int[] num = { 80 ,55 ,70 };
        for (int i = 0; i < 3; i++) {
            if(num[i]>=60)count++;
        }

        System.out.println("Pass count: " + count);
    }
}
