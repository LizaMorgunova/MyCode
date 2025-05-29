import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;
    int height;
    TreeNode(int elem) {
        val = elem;
        left = right = null;
        height = 1;
    }
}
public class AVLBalance {
    TreeNode root;
    int height(TreeNode record) {
        if (record == null) {
            return 0;
        }
        return record.height;
    }
    int getBalance(TreeNode record) {
        if (record == null) {
            return 0;
        }
        return height(record.left) - height(record.right);
    }
    TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
    TreeNode insert(TreeNode node, int key) {
        if (node == null) {
            return new TreeNode(key);
        }
        if (key < node.val) {
            node.left = insert(node.left, key);
        } else if (key > node.val) {
            node.right = insert(node.right, key);
        } else { // Дубликаты не допускаются
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && key < node.left.val) {
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.val) {
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        int balance = getBalance(node);
        return (balance >= -1 && balance <= 1) && isBalanced(node.left) && isBalanced(node.right);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLBalance avlTree = new AVLBalance();
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            avlTree.root = avlTree.insert(avlTree.root, num);
        }
        if (avlTree.isBalanced(avlTree.root)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }
}
