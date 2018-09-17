package others;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 17:18 2018/8/28
 * @ ModifiedBy:
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        int lo = 0, hi = array.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[hi] > array[mid]) {
                hi = mid;
            }
            else if (array[hi] == array[mid]) {
                return array[mid];
            } else {
                lo = mid + 1;
            }
        }
        return array[lo];
    }

    public static void main(String[] args) {
        MinNumberInRotateArray m = new MinNumberInRotateArray();
        int[] array = {3,4,5,1,2};
        System.out.println(m.minNumberInRotateArray(array));
    }
}
