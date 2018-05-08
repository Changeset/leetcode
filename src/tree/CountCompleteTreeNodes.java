package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:53 2018/5/8
 * @ ModifiedBy:
 */
public class CountCompleteTreeNodes {
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h - 1 ? (1 << h) + countNodes(root.right)
                                            : (1 << h - 1) + countNodes(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        CountCompleteTreeNodes c = new CountCompleteTreeNodes();
        System.out.println(c.countNodes(root));
    }
}
