package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:46 2018/3/2
 * @ ModifiedBy:
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            while (length > 0) {
                TreeNode top = queue.remove();
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
                length--;
                list.add(top.val);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        LevelOrder l = new LevelOrder();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        l.levelOrder(root);
    }
}
