import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String result = findMostFrequentWord(input);
        System.out.println(result);
    }

    private static String findMostFrequentWord(String text) {
        String[] words = text.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        String mostFrequentWord = null;
        int maxCount = 0;

        // Поиск самого частого слова
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && (mostFrequentWord == null || word.compareTo(mostFrequentWord) < 0))) {
                mostFrequentWord = word;
                maxCount = count;
            }
        }

        return mostFrequentWord;
    }
}