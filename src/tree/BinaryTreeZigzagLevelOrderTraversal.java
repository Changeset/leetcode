package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:16 2018/3/16
 * @ ModifiedBy:
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        int flag = 0;
        Stack<TreeNode>[] stack = new Stack[2];
        stack[0] = new Stack<TreeNode>();
        stack[1] = new Stack<TreeNode>();
        if (root == null) return result;
        stack[0].push(root);
        while (root != null || !stack[0].isEmpty() || !stack[1].isEmpty()) {
            List<Integer> list = new LinkedList<>();
            if (flag == 0) {
                int length = stack[0].size();
                while (length > 0) {
                    root = stack[0].pop();
                    if (root.left != null) stack[1].push(root.left);
                    if (root.right != null) stack[1].push(root.right);
                    length--;
                    list.add(root.val);
                }
            } else {
                int length = stack[1].size();
                while (length > 0) {
                    root = stack[1].pop();
                    if (root.right != null) stack[0].push(root.right);
                    if (root.left != null) stack[0].push(root.left);
                    length--;
                    list.add(root.val);
                }
            }
            result.add(list);
        }
        return result;
    }
}
