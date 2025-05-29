import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class BinaryTreeTraversal {
    private TreeNode num;
    public void record(int value) {
        num = insertRecord(num, value);
    }

    private TreeNode insertRecord(TreeNode num, int value) {
        if (num == null) {
            num = new TreeNode(value);
            return num;
        }
        if (value < num.value) {
            num.left = insertRecord(num.left, value);
        } else if (value > num.value) {
            num.right = insertRecord(num.right, value);
        }
        return num;
    }

    public void binaryTree() {
        insertBinaryTree(num);
    }

    private void insertBinaryTree(TreeNode num) {
        if (num != null) {
            insertBinaryTree(num.left);
            System.out.println(num.value);
            insertBinaryTree(num.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTreeTraversal bst = new BinaryTreeTraversal();
        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            bst.record(number);
        }
        bst.binaryTree();
    }
}