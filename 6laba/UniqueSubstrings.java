import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueSubstrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Set<String> uniqueSubstrings = new HashSet<>();
        String base = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isInBase(substring, base)) {
                    uniqueSubstrings.add(substring);
                }
            }
        }

        System.out.println(uniqueSubstrings.size());
        scanner.close();
    }

    private static boolean isInBase(String substring, String base) {
        for (char c : substring.toCharArray()) {
            if (base.indexOf(c) == -1) {
                return false;
            }
        }

        for (int i = 0; i < substring.length(); i++) {
            char currentChar = substring.charAt(i);
            int indexInBase = base.indexOf(currentChar);
            if (i > 0 && (indexInBase == -1 || indexInBase != (base.indexOf(substring.charAt(i - 1)) + 1) % 26)) {
                return false;
            }
        }
        return true;
    }
}