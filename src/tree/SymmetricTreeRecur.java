package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 17:15 2018/3/2
 * @ ModifiedBy:
 */
public class SymmetricTreeRecur {
    public boolean symmetricTree(TreeNode root) {
        if (root == null) return true;
        return symmetricTreeHelper(root.left, root.right);
    }

    public boolean symmetricTreeHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val) return false;
        return symmetricTreeHelper(left.left , right.right) && symmetricTreeHelper(left.right, right.left);
    }

    public static void main(String[] args) {
        SymmetricTreeRecur s = new SymmetricTreeRecur();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(4);
        System.out.println(s.symmetricTree(root));
    }
}
