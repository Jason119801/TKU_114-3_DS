public class RecursiveDigitSumPractice {
    public static void main(String[] args) {
        System.out.println(digitSum(5729));
    }
    public static int digitSum(int number) {
        if (number == 0) return 0;
        return (number % 10) + digitSum(number / 10);
    }
}