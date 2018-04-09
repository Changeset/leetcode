package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:49 2018/4/9
 * @ ModifiedBy:
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preOrderTrav(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            result.add(root.val);
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
        }
        return result;
    }

    public List<Integer> preOrderTrav2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                root = stack.peek();
                stack.pop();
                root = root.right;
            }
        }
        return res;
    }
}
