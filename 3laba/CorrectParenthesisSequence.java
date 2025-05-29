import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class CorrectParenthesisSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = reader.readLine();
        if (BracketSequence(input)) {
            writer.write("yes\n");
        } else {
            writer.write("no\n");
        }
        writer.flush();
        reader.close();
        writer.close();
    }
    private static boolean BracketSequence(String sequence) {
        Stack<Character> stack = new Stack<>();
        for (char ch : sequence.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!MatchingBrackets(top, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private static boolean MatchingBrackets(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') ||
        (open == '{' && close == '}');
    }
}