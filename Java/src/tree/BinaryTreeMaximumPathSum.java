package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:41 2018/4/24
 * @ ModifiedBy:
 */
public class BinaryTreeMaximumPathSum {
    int maxValue;
    public int maxPathSum (TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.right = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
        System.out.println(b.maxPathSum(root));
    }
}
