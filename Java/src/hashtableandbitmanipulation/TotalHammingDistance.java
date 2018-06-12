package hashtableandbitmanipulation;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:09 2018/6/12
 * @ ModifiedBy:
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j = 0; j < 32; j++) {
            int bitCount = 0;
            for (int i = 0; i < n; i++)
                bitCount += (nums[i] >> j) & 1;
            total += bitCount * (n - bitCount);
        }
        return total;
    }

    public static void main(String[] args) {
        TotalHammingDistance t = new TotalHammingDistance();
        int[] nums = {4,14,2};
        System.out.println(t.totalHammingDistance(nums));
    }
}
