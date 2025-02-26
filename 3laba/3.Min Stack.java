import java.util.Stack;
import java.util.Scanner;
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    public void pop() {
        if (!stack.isEmpty()) {
            int topValue = stack.pop();
            if (topValue == minStack.peek()) {
                minStack.pop();
            }
        }
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество команд: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        String[] commands = new String[num];
        Object[] values = new Object[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Введите команду (MinStack, push, pop, top, getMin): ");
            commands[i] = scanner.nextLine();
            if (commands[i].equals("push")) {
                System.out.print("Введите значение для push: ");
                values[i] = scanner.nextInt();
                scanner.nextLine();
            } else {
                values[i] = null;
            }
        }
        MinStack minStack = new MinStack();
        Object[] results = new Object[num];
        for (int i = 0; i < num; i++) {
            switch (commands[i]) {
                case "MinStack":
                    results[i] = null;
                    break;
                case "push":
                    minStack.push((Integer) values[i]);
                    results[i] = null;
                    break;
                case "pop":
                    minStack.pop();
                    results[i] = null;
                    break;
                case "top":
                    results[i] = minStack.top();
                    break;
                case "getMin":
                    results[i] = minStack.getMin();
                    break;
                default:
                    System.out.println("Неизвестная команда: " + commands[i]);
                    results[i] = null;
                    break;
            }
        }
        System.out.println(java.util.Arrays.toString(results));
        scanner.close();
    }
}