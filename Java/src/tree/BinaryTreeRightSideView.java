package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:48 2018/5/3
 * @ ModifiedBy:
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        queue.offer(root);
        TreeNode node = root;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (i == length - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left.right = new TreeNode(5);
        BinaryTreeRightSideView b = new BinaryTreeRightSideView();
        System.out.println(b.rightSideView(root));
    }
}
