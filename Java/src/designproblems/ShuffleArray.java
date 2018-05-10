package designproblems;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:45 2018/3/4
 * @ ModifiedBy:
 */

import java.util.Random;

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
public class ShuffleArray {
    private int[] nums;
    private Random random;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if (nums == null) return null;
        int[] a = nums.clone();
        for (int j = 1; j < a.length; j++) {
            int i = random.nextInt(j+1);
            swap(a, i, j);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        ShuffleArray s = new ShuffleArray(nums);
        int[] test = s.shuffle();
        for (int n : test) {
            System.out.print(n + " ");
        }
    }
}
