import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ1918 {

    private static Stack<String> stack = new Stack<>();
    private static StringBuilder stringBuilder = new StringBuilder();

    public static int priority(String operator) {

        if (operator.equals("(") || operator.equals(")")) {
            return 0;
        } else if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String[] strings = stringTokenizer.nextToken().split("");
        for (String str : strings) {
            if (str.equals("(")) {
                stack.add(str);
                continue;
            }
            if (str.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    stringBuilder.append(stack.pop());
                }
                stack.pop();
                continue;
            }
            if (str.equals("+") | str.equals("-") | str.equals("*") | str.equals("/")) {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(str)) {
                    stringBuilder.append(stack.pop());
                }
                stack.add(str);
                continue;
            }
            stringBuilder.append(str);
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        System.out.println(stringBuilder);
    }
}
