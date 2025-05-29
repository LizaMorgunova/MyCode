import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        else {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }

    public TreeNode recordTree(int[] arr, TreeNode root, int i) {
        if (i < arr.length) {
            if (arr[i] != -1) {
                TreeNode temp = new TreeNode(arr[i]);
                root = temp;
                root.left = recordTree(arr, root.left, 2 * i + 1);
                root.right = recordTree(arr, root.right, 2 * i + 2);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputValues = input.split(" ");

        int[] values = new int[inputValues.length];
        for (int i = 0; i < inputValues.length; i++) {
            values[i] = Integer.parseInt(inputValues[i]);
        }
        RangeSumBST solution = new RangeSumBST();
        TreeNode root = solution.recordTree(values, null, 0);

        int low = scanner.nextInt();
        int high = scanner.nextInt();

        int sum = solution.rangeSumBST(root, low, high);

        System.out.println(sum);
        scanner.close();
    }
}