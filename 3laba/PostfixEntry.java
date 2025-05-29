import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixEntry {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine().trim();
            int result = postfixNotation(input);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int postfixNotation(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split("\s+");
        for (String oper : tokens) {
            if (isNumeric(oper)) {
                stack.push(Integer.parseInt(oper));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int result;
                switch (oper) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    default:
                        throw new IllegalArgumentException("Неизвестный оператор: " + oper);
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}