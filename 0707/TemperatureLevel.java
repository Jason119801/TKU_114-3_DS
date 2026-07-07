public class TemperatureLevel {
    public static void main(String[] args) {
        int temperature = 18;

        if (temperature < 15) {
            System.out.println("Cold");
        } else if (temperature > 28) {
            System.out.println("Hot");
        } else {
            System.out.println("Comfortable");
        }
    }
}
