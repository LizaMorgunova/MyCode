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
class DepthOfAddedElements {
    private TreeNode root;
    public Integer add(int value) {
        return addRecursive(root, value, 1);
    }
    private Integer addRecursive(TreeNode node, int value, int depth) {
        if (node == null) {
            root = new TreeNode(value);
            return depth;
        }
        if (value < node.value) {
            if (node.left == null) {
                node.left = new TreeNode(value);
                return depth + 1;
            } else {
                return addRecursive(node.left, value, depth + 1);
            }
        } else if (value > node.value) {
            if (node.right == null) {
                node.right = new TreeNode(value);
                return depth + 1;
            } else {
                return addRecursive(node.right, value, depth + 1);
            }
        } else {
            return null;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DepthOfAddedElements bst = new DepthOfAddedElements();
        StringBuilder output = new StringBuilder();
        while (true) {
            int value = scanner.nextInt();
            if (value == 0) {
                break;
            }
            Integer depth = bst.add(value);
            if (depth != null) {
                output.append(depth).append(" ");
            }
        }
        System.out.println(output.toString().trim());
        scanner.close();
    }
}
