import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
class insertLeaves {
    private TreeNode root;
    public void insert(int value) {
        root = insertRecord(root, value);
    }
    private TreeNode insertRecord(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRecord(root.left, value);
        } else if (value > root.value) {
            root.right = insertRecord(root.right, value);
        }
        return root;
    }

    public List<Integer> getLeaves() {
        List<Integer> leaves = new ArrayList<>();
        getLeavesRecord(root, leaves);
        return leaves;
    }

    private void getLeavesRecord(TreeNode node, List<Integer> leaves) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leaves.add(node.value);
            }
            getLeavesRecord(node.left, leaves);
            getLeavesRecord(node.right, leaves);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        insertLeaves bst = new insertLeaves();
        while (true) {
            int value = scanner.nextInt();
            if (value == 0) break;
            bst.insert(value);
        }
        List<Integer> leaves = bst.getLeaves();
        Collections.sort(leaves);
        for (int leaf : leaves) {
            System.out.println(leaf);
        }
        scanner.close();
    }
}