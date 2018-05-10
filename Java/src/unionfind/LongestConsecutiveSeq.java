package unionfind;

import java.util.HashMap;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:09 2018/4/25
 * @ ModifiedBy:
 */
public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map  = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                //extend the length to the boundary(s)
                //of the sequence
                //will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                //duplicates
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {200,1,100,4,2,3};
        LongestConsecutiveSeq l = new LongestConsecutiveSeq();
        System.out.println(l.longestConsecutive(nums));
    }
}
