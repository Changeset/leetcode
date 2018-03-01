package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:20 2018/3/1
 * @ ModifiedBy:
 */
public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return left > right ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        MaximumDepth m = new MaximumDepth();
        System.out.println(m.maxDepth(root));
    }
}
