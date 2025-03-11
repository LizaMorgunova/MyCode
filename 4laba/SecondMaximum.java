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

public class SecondMaximum {
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
    public int findSecondMax() {
        return findSecondMaxRecord(num);
    }
    private int findSecondMaxRecord(TreeNode node) {
        if (node.right != null) {
            TreeNode current = node.right;
            while (current.right != null) {
                current = current.right;
            }
            if (current.left != null) {
                return findMax(current.left);
            } else {
                return node.value;
            }
        } else {
            return findMax(node.left);
        }
    }
    private int findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecondMaximum bst = new SecondMaximum();
        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            bst.record(number);
        }
        int secondMax = bst.findSecondMax();
        System.out.println(secondMax);
    }
}