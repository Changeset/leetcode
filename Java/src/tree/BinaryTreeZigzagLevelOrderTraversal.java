package tree;

import java.util.LinkedList;
import java.util.List;
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
        while (!stack[0].isEmpty() || !stack[1].isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int length = stack[flag].size();
            while (length > 0) {
                root = stack[flag].pop();
                if (flag == 0) {
                    if (root.left != null) stack[1 - flag].push(root.left);
                    if (root.right != null) stack[1 - flag].push(root.right);
                } else {
                    if (root.right != null) stack[1 - flag].push(root.right);
                    if (root.left != null) stack[1 - flag].push(root.left);
                }
                length--;
                list.add(root.val);
            }
            result.add(list);
            flag = 1 - flag;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(20);
        BinaryTreeZigzagLevelOrderTraversal b = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(b.zigzagLevelOrder(root));
    }
}
