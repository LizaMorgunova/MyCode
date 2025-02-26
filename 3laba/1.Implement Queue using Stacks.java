import java.util.Stack;
import java.util.Scanner;
class MyQueue {
    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    public void push(int x) {
        st1.push(x);
    }
    public int pop() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int del = st2.pop();
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        return del;
    }
    public int peek() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int remove = st2.peek();
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        return remove;
    }
    public boolean empty() {
        return st1.isEmpty();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество команд: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        String[] commands = new String[num];
        Object[] values = new Object[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Введите команду (MyQueue, push, pop, peek, empty): ");
            commands[i] = scanner.nextLine();
            if (commands[i].equals("push")) {
                System.out.print("Введите значение для push: ");
                values[i] = scanner.nextInt();
                scanner.nextLine();
            } else {
                values[i] = null;
            }
        }
        MyQueue myStack = new MyQueue();
        Object[] results = new Object[num];
        for (int i = 0; i < num; i++) {
            switch (commands[i]) {
                case "MyQueue":
                    results[i] = null;
                    break;
                case "push":
                    myStack.push((Integer) values[i]);
                    results[i] = null;
                    break;
                case "pop":
                    results[i] = myStack.pop();
                    break;
                case "peek":
                    results[i] = myStack.peek();
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