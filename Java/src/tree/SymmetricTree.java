package tree;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:49 2018/3/2
 * @ ModifiedBy:
 */
public class SymmetricTree {
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        reverseTree(root.right);
//        if (isEqual(root.left, root.right)) return true;
//        else return false;
//    }
//    public boolean isEqual(TreeNode tree1, TreeNode tree2) {
//        if (tree1 == null && tree2 == null) return true;
//        if (tree1 == null || tree2 == null) return false;
//        if (tree1.val == tree2.val)
//            return isEqual(tree1.left, tree2.left) && isEqual(tree1.right, tree2.right);
//        else return false;
//    }
//    public void reverseTree(TreeNode root) {
//        if (root == null) return;
//        TreeNode temp;
//        temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        reverseTree(root.left);
//        reverseTree(root.right);
//    }
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    public boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    public boolean isSymmetricNonRecursive(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if (root.left != null) {
            if (root.right == null) return false;
            stack.push(root.left);
            stack.push(root.right);
        }
        else if (root.right != null) {
            return false;
        }
        while (!stack.isEmpty()) {
            if (stack.size()%2 != 0) return false;
            right = stack.pop();
            left = stack.pop();
            if (right.val != left.val) return false;

            if (left.left != null) {
                if (right.right == null) return false;
                stack.push(left.left);
                stack.push(right.right);
            }
            else if (right.right != null) {
                return false;
            }

            if (left.right != null) {
                if (right.left == null) return false;
                stack.push(left.right);
                stack.push(right.left);
            }
            else if (right.left != null) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        st.isSymmetricNonRecursive(root);
    }
}
