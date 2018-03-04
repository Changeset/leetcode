package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:58 2018/3/4
 * @ ModifiedBy:
 */
public class HouseRobber {
//    public int rob(int[] nums) {
//        if (nums.length == 0) return 0;
//        int maxLast = 0, maxCur = 0;
//        boolean hasEndCur = false;
//        for (int i = 0; i < nums.length; i++) {
//            if(hasEndCur) {
//                if(maxCur < maxLast + nums[i]) {
//                    int temp = maxCur;
//                    maxCur = maxLast + nums[i];
//                    maxLast = temp;
//                }
//                else hasEndCur = false;
//            }
//            else {
//                maxLast = maxCur;
//                maxCur += nums[i];
//                hasEndCur = true;
//            }
//        }
//        return maxCur;
//    }

    public int rob(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,4,3,5,9,2};
        HouseRobber hr = new HouseRobber();
        System.out.println(hr.rob(nums));
    }
}
