public class GradeMethod {
    public static void main(String[] args) {
        double average = calculateAverage( 85, 92, 70);
        //System.out.println("平均分數為：" + average);
        System.out.println(getGrade(average));
    }

    public static double calculateAverage(int javaScore, int englishScore, int mathScore){return (javaScore + englishScore + mathScore) / 3.0;}

    public static String getGrade(double average){
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
