package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:06 2018/6/7
 * @ ModifiedBy:
 */
public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllDuplicatesinanArray f = new FindAllDuplicatesinanArray();
        System.out.println(f.findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
    }
}
