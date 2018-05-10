package tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            while (length > 0) {
                length--;
                root = queue.poll();
                if (length == 0) root.next = null;
                else root.next = queue.peek();
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
        }
    }
}
