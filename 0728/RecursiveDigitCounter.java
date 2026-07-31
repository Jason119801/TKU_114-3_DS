public class RecursiveDigitCounter {
    public static void main(String[] args) {
        System.out.println(countDigit(123114, 1));
    }
    public static int countDigit(int number, int target) {
        if (number == 0) return 0;
        int match = (number % 10 == target) ? 1 : 0;
        return match + countDigit(number / 10, target);
    }
}