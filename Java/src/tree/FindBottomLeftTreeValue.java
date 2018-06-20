package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:33 2018/6/19
 * @ ModifiedBy:
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }

    public static void main(String[] args) {
        FindBottomLeftTreeValue f = new FindBottomLeftTreeValue();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(f.findBottomLeftValue(root));
    }
}
