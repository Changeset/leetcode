package hashtableandbitmanipulation;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:16 2018/5/14
 * @ ModifiedBy:
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }

        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (citations[i] > length) {
                array2[length]++;
            } else {
                array2[citations[i]]++;
            }
        }
        int t = 0;
        int result = 0;
        for (int i = length; i >= 0; i--) {
            t = t + array2[i];
            if (t >= i) {
                return i;
            }
        }
        return 0;
    }
}
