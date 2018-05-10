package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:33 2018/3/18
 * @ ModifiedBy:
 */
public class KthSmallestElementBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = inorderTraversal(root);
        return res.get(k - 1);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
