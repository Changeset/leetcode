package tree;

import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:06 2018/4/25
 * @ ModifiedBy:
 */
public class SumRootToLeafNum {
    private int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        sumDFS(root, 0);
        return sum;
    }

    private void sumDFS(TreeNode root, int num) {
        if (root == null) return;
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        if (root.left != null) sumDFS(root.left, num);
        if (root.right != null) sumDFS(root.right, num);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        SumRootToLeafNum s = new SumRootToLeafNum();
        System.out.println(s.sumNumbers(root));
    }
}
