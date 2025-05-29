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
class BinarySearchTree {
    private TreeNode root;
    public void insert(int value) {
        root = recordInsert(root, value);
    }
    private TreeNode recordInsert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.value) {
            node.left = recordInsert(node.left, value);
        } else if (value > node.value) {
            node.right = recordInsert(node.right, value);
        }
        return node;
    }
    public int height() {
        return recordHeight(root);
    }
    private int recordHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = recordHeight(node.left);
        int rightHeight = recordHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            bst.insert(number);
        }
        int height = bst.height();
        System.out.println(height);
    }
}