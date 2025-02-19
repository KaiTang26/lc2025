import java.util.Stack;

public class ValidParentheses20 {
    public static boolean isValid(String s) {

        char[] stringCharArray = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        stack.push(stringCharArray[0]);

        for (int i = 1; i < stringCharArray.length; i++) {

            char newC = stringCharArray[i];

            if (stack.isEmpty()) {

                stack.push(newC);
            } else {
                char stackPeek = stack.peek();

                if ((stackPeek == '(' && newC == ')') || (stackPeek == '[' && newC == ']')
                        || (stackPeek == '{' && newC == '}')) {
                    stack.pop();
                } else {
                    stack.push(newC);
                }

            }

        }

        return stack.isEmpty();

    }

    public static boolean isValidUpdate(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') {
                    return false;
                }

                if (c == ']' && top != '[') {
                    return false;
                }

                if (c == '}' && top != '{') {
                    return false;
                }
            }

        }

        return stack.isEmpty();

    }

}
