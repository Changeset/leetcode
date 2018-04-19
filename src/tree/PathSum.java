package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:13 2018/4/19
 * @ ModifiedBy:
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (sum == 0) return true;
        if (root == null) return false;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        PathSum p = new PathSum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        System.out.println(p.hasPathSum(root, 22));
    }
}
