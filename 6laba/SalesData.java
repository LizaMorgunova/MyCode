import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SalesData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> salesData = new HashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Неверный формат ввода");
                continue;
            }

            String buyer = parts[0];
            String product = parts[1];
            int quantity;

            try {
                quantity = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                System.out.println("Количество должно быть числом");
                continue;
            }

            salesData.putIfAbsent(buyer, new HashMap<>());
            salesData.get(buyer).put(product, salesData.get(buyer).getOrDefault(product, 0) + quantity);
        }

        List<String> buyers = new ArrayList<>(salesData.keySet());
        Collections.sort(buyers);

        for (String buyer : buyers) {
            System.out.println(buyer + ":");

            Map<String, Integer> products = salesData.get(buyer);

            List<String> productList = new ArrayList<>(products.keySet());
            Collections.sort(productList);

            for (String product : productList) {
                System.out.println(product + " " + products.get(product));
            }
        }
        scanner.close();
    }
}