package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:27 2018/5/16
 * @ ModifiedBy:
 */
public class RangeSumQueryMutable {
    class SegementTreeNode {
        int start, end;
        SegementTreeNode left, right;
        int sum;

        public SegementTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
    SegementTreeNode root = null;
    public RangeSumQueryMutable(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }

    private SegementTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegementTreeNode ret = new SegementTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    public void update(SegementTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public int sumRange(SegementTreeNode root, int start, int end) {
        if (root.end == end && root.start == start) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid + 1) {
                return sumRange(root.right, start, end);
            } else {
                return sumRange(root.right, mid + 1, end) + sumRange(root.left, start, mid);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        RangeSumQueryMutable obj = new RangeSumQueryMutable(nums);
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 4);
        System.out.println(obj.sumRange(0, 2));

    }
}
