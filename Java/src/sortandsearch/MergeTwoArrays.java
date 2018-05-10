package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 17:27 2018/3/2
 * @ ModifiedBy:
 */
public class MergeTwoArrays {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] result = new int[m+n];
//        int ptr1=0, ptr2=0;
//        for (int i = 0; i < m+n; i++) {
//            if (ptr1 < m && ptr2 < n)
//                result[i] = nums1[ptr1] > nums2[ptr2] ? nums1[ptr1++] : nums2[ptr2++];
//            else if (ptr1 == m) result[i] = nums2[ptr2++];
//            else if (ptr2 == n) result[i] = nums1[ptr1++];
//        }
//        nums1 = result;
//    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (n > 0) nums1[n+m-1] = (m == 0 || nums2[n-1] > nums1[m-1]) ? nums2[--n] : nums2[--m];
    }
}
