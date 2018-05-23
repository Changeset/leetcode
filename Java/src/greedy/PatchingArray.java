package greedy;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:04 2018/5/23
 * @ ModifiedBy:
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long miss = 1, added = 0;
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                added++;
            }
        }
        return (int)added;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 10};
        PatchingArray p = new PatchingArray();
        System.out.println(p.minPatches(nums, 20));
    }
}
