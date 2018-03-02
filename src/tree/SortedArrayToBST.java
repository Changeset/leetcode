package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:45 2018/3/2
 * @ ModifiedBy:
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) return null;
        else return helper(num, 0, num.length - 1);
    }

    public TreeNode helper(int[] num, int lo, int hi) {
        if (lo > hi) return null;
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(mid);
        root.left = helper(num, lo, mid - 1);
        root.right = helper(num, mid + 1, hi);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9,10,11,12};
        SortedArrayToBST s = new SortedArrayToBST();
        TreeNode root = s.sortedArrayToBST(nums);
    }
}
