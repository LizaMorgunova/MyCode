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
class InsertForks {
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

    public List<Integer> getNodesWithChild() {
        List<Integer> nodesWithTwoChildren = new ArrayList<>();
        getNodesWithChildRecord(root, nodesWithTwoChildren);
        return nodesWithTwoChildren;
    }

    private void getNodesWithChildRecord(TreeNode node, List<Integer> nodes) {
        if (node != null) {
            if (node.left != null && node.right != null) {
                nodes.add(node.value);
            }
            getNodesWithChildRecord(node.left, nodes);
            getNodesWithChildRecord(node.right, nodes);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InsertForks bst = new InsertForks();
        while (true) {
            int value = scanner.nextInt();
            if (value == 0) break;
            bst.insert(value);
        }
        List<Integer> nodesWithChild = bst.getNodesWithChild();
        Collections.sort(nodesWithChild);
        for (int node : nodesWithChild) {
            System.out.println(node);
        }
        scanner.close();
    }
}