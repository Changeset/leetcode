package hashtableandbitmanipulation;

import arrays.SingleNumber;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:23 2018/5/11
 * @ ModifiedBy:
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;

        int[] rets = {0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) {
                rets[0] ^= num;
            } else {
                rets[1] ^= num;
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,4,4,5};
        SingleNumberIII s = new SingleNumberIII();
        int[] res = s.singleNumber(nums);
        for (int i : res) {
            System.out.println(i);
        }
        int i = 1;
        i &= -i;
        System.out.println(i);
    }
}
