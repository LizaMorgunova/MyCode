import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GoblinsAndShamans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество команд:");
        int N = scanner.nextInt();
        scanner.nextLine();
        List<Integer> goblinQueue = new LinkedList<>();
        System.out.println("Введите команды:");
        for (int i = 0; i < N; i++) {
            String command = scanner.nextLine();
            if (command.startsWith("+")) {
                int goblinId = Integer.parseInt(command.substring(2).trim());
                goblinQueue.add(goblinId);
            } else if (command.startsWith("*")) {
                int goblinIndex = Integer.parseInt(command.substring(2).trim());
                int middleIndex = (goblinQueue.size() / 2);
                goblinQueue.add(middleIndex, goblinIndex);
            } else if (command.equals("-")) {
                if (!goblinQueue.isEmpty()) {
                    System.out.println(goblinQueue.remove(0));
                }
            }
        }
        scanner.close();
    }
}