package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:27 2018/3/20
 * @ ModifiedBy:
 */
public class JumpGame {
    public int leastJumpTime(int[] a) {
        int cur=0, far=0, step=0;
        far = a[0];
        while(cur < a.length){
            if(far >= a.length - 1)
                return step + 1;
            int nextstep = cur, temp = far;
            while(cur <= temp){
                if(a[cur] + cur > far){
                    nextstep = cur;
                    far = a[cur] + cur;
                }
                cur++;
            }
            step++;
            cur = nextstep;
        }
        return -1;
    }
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return false;
        int end = nums.length - 1;
        for (int i = end; i >= 0; i--) {
            if (nums[i] >= end - i) end = i;
        }
        if (end == 0) return true;
        else return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGame j = new JumpGame();
        System.out.println(j.leastJumpTime(nums));
    }
}
