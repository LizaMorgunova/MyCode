import java.util.Scanner;
import java.util.Stack;

public class SortingOfWagonsLite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество вагонов");
        int N = scanner.nextInt();
        int[] train = new int[N];
        System.out.println("Введите порядок номеров вагонов");
        for (int i = 0; i < N; i++) {
            train[i] = scanner.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int nextTrainCar = 1;
        for (int i = 0; i < N; i++) {
            stack.push(train[i]);
            while (!stack.isEmpty() && stack.peek() == nextTrainCar) {
                stack.pop();
                nextTrainCar++;
            }
        }
        if (nextTrainCar == N + 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }
}