package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 17:02 2018/5/24
 * @ ModifiedBy:
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
    public static void main(String[] args) {
        HouseRobberIII h = new HouseRobberIII();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(h.rob(root));
    }
}

