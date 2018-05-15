package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:12 2018/5/15
 * @ ModifiedBy:
 */
public class FindDupNumber {
    public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindDupNumber f = new FindDupNumber();
        int[] nums = {1,3,4,2,4};
        System.out.println(f.findDuplicate(nums));
    }
}
