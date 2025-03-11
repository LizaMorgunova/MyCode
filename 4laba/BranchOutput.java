import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int elem) {
        val = elem;
        left = right = null;
    }
}
public class BranchOutput {
    TreeNode root;
    void insert(int val) {
        root = insertRecord(root, val);
    }
    TreeNode insertRecord(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val < root.val) {
            root.left = insertRecord(root.left, val);
        } else {
            root.right = insertRecord(root.right, val);
        }
        return root;
    }
    void findNodesWithChild(TreeNode node, List<Integer> result) {
        if (node != null) {
            if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
                result.add(node.val);
            }
            findNodesWithChild(node.left, result);
            findNodesWithChild(node.right, result);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BranchOutput bst = new BranchOutput();
        List<Integer> nodesWithChild = new ArrayList<>();
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            bst.insert(num);
        }
        bst.findNodesWithChild(bst.root, nodesWithChild);
        Collections.sort(nodesWithChild);
        for (int val : nodesWithChild) {
            System.out.println(val);
        }
    }
}