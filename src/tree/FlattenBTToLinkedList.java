package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:16 2018/4/19
 * @ ModifiedBy:
 */
public class FlattenBTToLinkedList {
    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    private TreeNode flatten(TreeNode root, TreeNode prev) {
        if (root == null) return prev;
        prev = flatten(root.right, prev);
        prev = flatten(root.left, prev);
        root.right = prev;
        root.left = null;
        prev = root;
        return prev;
    }

    public static void main(String[] args) {
        FlattenBTToLinkedList f = new FlattenBTToLinkedList();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(7);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        f.flatten(root);
    }
}
