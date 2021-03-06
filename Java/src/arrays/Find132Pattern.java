package arrays;

import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:06 2018/6/10
 * @ ModifiedBy:
 */
public class Find132Pattern {
    public boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) return true;
            else while (!st.empty() && nums[i] > st.peek()) {
                s3 = st.peek();
                st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Find132Pattern f = new Find132Pattern();
        int[] nums = {9,11,8,9,10,7,9};
        System.out.println(f.find132pattern(nums));
    }
}
