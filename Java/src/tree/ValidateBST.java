package tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:31 2018/3/1
 * @ ModifiedBy:
 */
public class ValidateBST {
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        boolean left = root.left != null ? (root.val > maxNum(root.left) && isValidBST(root.left)) : isValidBST(root.left);
//        boolean right = root.right != null ? (root.val < minNum(root.right) && isValidBST(root.right)) : isValidBST(root.right);
//        return left && right;
//    }
//    private int maxNum(TreeNode root) {
//        if (root.left == null && root.right == null) return root.val;
//        int left = root.left != null ? Math.max(root.val, maxNum(root.left)) : root.val;
//        int right = root.right != null ? Math.max(root.val, maxNum(root.right)) : root.val;
//        return Math.max(left, right);
//    }
//
//    private int minNum(TreeNode root) {
//        if (root.left == null && root.right == null) return root.val;
//        int left = root.left != null ? Math.min(root.val, minNum(root.left)) : root.val;
//        int right = root.right != null ? Math.min(root.val, minNum(root.right)) : root.val;
//        return Math.min(left, right);
//    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) >= list.get(i+1)) return false;
        }
        return true;
    }
}
