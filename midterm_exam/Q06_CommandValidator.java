public class Q06_CommandValidator {
    public static void main(String[] args) {
        String[] commands = {"START", new String("stop"), "  Pause  ", "RUN", "   ", null};
        for (String c : commands) {
            System.out.println(c + " -> " + isValidCommand(c));
        }
    }

    public static boolean isValidCommand(String command) {
        if (command == null) return false;
        
        String cleanCmd = command.trim().toUpperCase();
        switch (cleanCmd) {
            case "START":
            case "STOP":
            case "PAUSE":
                return true;
            default:
                return false;
        }
    }
}