import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIdx = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                result[resultIdx++] = nums[deque.peek()];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Введите размер окна k: ");
        int k = scanner.nextInt();
        Solution solution = new Solution();
        int[] result = solution.maxSlidingWindow(nums, k);
        for (int max : result) {
            System.out.print(max + " ");
        }
        scanner.close();
    }
}