package arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:50 2018/6/19
 * @ ModifiedBy:
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }
        return next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        NextGreaterElementII n = new NextGreaterElementII();
        System.out.println(n.nextGreaterElements(nums));
    }
}
