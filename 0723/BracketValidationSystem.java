import java.util.ArrayDeque;
import java.util.Deque;

public class BracketValidationSystem {
    public static void main(String[] args) {
        System.out.println("1. (a+b)*[c-d]: " + isValid("(a+b)*[c-d]"));
        System.out.println("2. {[(x)]}: " + isValid("{[(x)]}"));
        System.out.println("3. ((x): " + isValid("((x)"));
        System.out.println("4. {x}): " + isValid("{x})"));
        System.out.println("5. ([)]: " + isValid("([)]"));
    }

    public static boolean isValid(String text) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty() || !isMatching(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatching(char left, char right) {
        return (left == '(' && right == ')') ||
               (left == '[' && right == ']') ||
               (left == '{' && right == '}');
    }
}