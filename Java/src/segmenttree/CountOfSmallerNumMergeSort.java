package segmenttree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:14 2018/5/21
 * @ ModifiedBy:
 */
public class CountOfSmallerNumMergeSort {
    class NumberIndex {
        int number;
        int index;

        NumberIndex(int number, int index) {
            this.number = number;
            this.index = index;
        }

        NumberIndex(NumberIndex another) {
            this.number = another.number;
            this.index = another.index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        NumberIndex[] cnums = new NumberIndex[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cnums[i] = new NumberIndex(nums[i], i);
        }
        int[] smaller = new int[nums.length];
        cnums = sort(cnums, smaller);
        List<Integer> res = new ArrayList<>();
        for (int i : smaller) {
            res.add(i);
        }
        return res;
    }

    private NumberIndex[] sort(NumberIndex[] nums, int[] smaller) {
        int half = nums.length / 2;
        if (half > 0) {
            NumberIndex[] rightPart = new NumberIndex[nums.length];
            NumberIndex[] leftPart = new NumberIndex[half];
            for (int i = 0; i < leftPart.length; i++) {
                leftPart[i] = new NumberIndex(nums[i]);
            }
            for (int i = 0; i < rightPart.length; i++) {
                rightPart[i] = new NumberIndex(nums[half + i]);
            }
            NumberIndex[] left = sort(leftPart, smaller), right = sort(
                    rightPart, smaller);
            int m = left.length, n = right.length, i = 0, j = 0;
            while (i < m || j < n) {
                if (j == n || i < m && left[i].number <= right[j] .number) {
                    nums[i + j] = left[i];
                    smaller[left[i].index] += j;
                    i++;
                } else {
                    nums[i + j] = right[j];
                    j++;
                }
            }
        }
        return nums;
    }
}
