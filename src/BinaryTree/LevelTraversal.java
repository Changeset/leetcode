package BinaryTree;


import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:12 2018/1/25
 * @ ModifiedBy:
 */

class SolutionQueue {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left  != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}

class SolutionDFS{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
}
public class LevelTraversal {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println(e);
        System.out.println(a == c);
        System.out.println(a == e);

    }
}
