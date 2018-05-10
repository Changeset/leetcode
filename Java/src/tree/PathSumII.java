package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:26 2018/4/19
 * @ ModifiedBy:
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        if (root.left == null && root.right == null && sum == root.val) {
            path.add(root.val);
            List<Integer> temp = new ArrayList<>(path);
            res.add(temp);
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            dfs(root.left, sum - root.val, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, sum - root.val, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(7);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        PathSumII p = new PathSumII();
        System.out.println(p.pathSum(root, 22));
    }
}
