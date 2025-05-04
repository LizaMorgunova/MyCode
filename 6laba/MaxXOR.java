import java.util.Scanner;

public class MaxXOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        int[] nums = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            nums[i] = Integer.parseInt(inputArray[i]);
        }

        int maxXOR = findMaxXOR(nums);
        System.out.println(maxXOR);
    }

    private static int findMaxXOR(int[] nums) {
        int maxResult = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                maxResult = Math.max(maxResult, nums[i] ^ nums[j]);
            }
        }
        return maxResult;
    }
}