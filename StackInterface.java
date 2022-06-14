import java.util.EmptyStackException;

public interface StackInterface<E> {
    public static boolean cheeckBrackets(String expr) {
        StackInterface<Character> openBracket = new ArrayStack<>();
        int n = expr.length(), i = 0;
        boolean result = true;
        char current = ' ';
        while (i < n && result) {
            current = expr.charAt(i);
            //
            switch (current) {
                case '(':
                case '[':
                case '{':
                    openBracket.push(current);
                    break;
                case ')':
                case ']':
                case '}':
                    try {
                        char open = openBracket.pop();
                        result = isMatching(open, current);
                    } catch (EmptyStackException e) {
                        result = false;
                    }
                    break;

                default:
                    // ?
            }

            i++;

        }

        result = result & openBracket.isEmpty(); // if result is true and openBracket is empty

        return result;
    }
}
