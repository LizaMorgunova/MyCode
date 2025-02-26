import java.util.Stack;
import java.util.Scanner;
class MyStack {
    private Stack<Integer> stack;

    public MyStack() {
        stack = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
    }
    public int pop() {
        return stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public boolean empty() {
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество команд: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        String[] commands = new String[num];
        Object[] values = new Object[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Введите команду (MyStack, push, pop, top, empty): ");
            commands[i] = scanner.nextLine();
            if (commands[i].equals("push")) {
                System.out.print("Введите значение для push: ");
                values[i] = scanner.nextInt();
                scanner.nextLine();
            } else {
                values[i] = null;
            }
        }
        MyStack myStack = new MyStack();
        Object[] results = new Object[num];
        for (int i = 0; i < num; i++) {
            switch (commands[i]) {
                case "MyStack":
                    results[i] = null;
                    break;
                case "push":
                    myStack.push((Integer) values[i]);
                    results[i] = null;
                    break;
                case "pop":
                    results[i] = myStack.pop();
                    break;
                case "top":
                    results[i] = myStack.top();
                    break;
                case "empty":
                    results[i] = myStack.empty();
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