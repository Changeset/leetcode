package designproblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:13 2018/3/22
 * @ ModifiedBy:
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class SerializeDeserializeBT {
    private static final String SPLITER = ",";
    private static final String NULL = "null";
    public String serialize(TreeNode root) {
        StringBuilder st = new StringBuilder();
        serialize(root, st);
        return st.toString();
    }

    public void serialize(TreeNode root, StringBuilder st) {
        if (root == null) st.append(NULL + SPLITER);
        else {
            st.append(root.val + SPLITER);
            serialize(root.left, st);
            serialize(root.right, st);
        }
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(SPLITER)));
        return deserialize(queue);
    }

    public TreeNode deserialize(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}
