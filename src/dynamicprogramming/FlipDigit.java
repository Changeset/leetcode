package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:46 2018/3/10
 * @ ModifiedBy:
 */
public class FlipDigit {
    public int flipDigit(int[] nums) {
        int countZero=0, countOne=0, min=0;
        boolean zero=false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                countZero=Math.min(countOne, countZero);
                countOne = countOne+1;
            }
            else {
                countZero = countZero+1;
            }

            min = Math.min(countOne, countZero);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = {1,0,1,0,1,0};
        FlipDigit f = new FlipDigit();
        System.out.println(f.flipDigit(a));
    }
}
