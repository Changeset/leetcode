package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:03 2018/5/8
 * @ ModifiedBy:
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            while (i + 1 < nums.length && (nums[i + 1] == nums[i] + 1)) {
                i++;
            }
            if (a != nums[i]) {
                result.add(a + "->" + nums[i]);
            } else {
                result.add(a + "");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        SummaryRanges s = new SummaryRanges();
        System.out.println(s.summaryRanges(nums));
    }
}
