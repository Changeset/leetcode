package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:41 2018/3/19
 * @ ModifiedBy:
 */
public class KthLargestElementMinHeap {
    public int findKthLargests(int[] nums, int k) {
        if (nums.length < k) return 0;
        int res = partition(nums, 0, nums.length - 1);
        int mask = nums.length - k;
        while (res != mask) {
            if (res < mask) {
                res = partition(nums, res + 1, nums.length - 1);
            }
            else {
                res = partition(nums, 0, res - 1);
            }
        }
        return nums[res];
    }

    public int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        int sentinel = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (nums[++i] <= sentinel) {
                if (i == hi) break;
            }
            while (nums[--j] > sentinel) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }
    public void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                heap[i] = nums[i];
            }
            else {
                int min = minTopHeap(heap);
                if (nums[i] > min) {
                    heap[0] = nums[i];
                    sink(heap);
                }
            }
        }
        minTopHeap(heap);
        return heap[0];
    }
    private int minTopHeap(int[] heap) {
        int n = heap.length;
        for (int i = n-1; i >= 0; i--) {
            swim(heap, i);
        }
        return heap[0];
    }

    private void swim(int[] heap, int k) {
        while (k > 0 && heap[(k-1)/2] > heap[k]) {
            exch(heap, k, (k-1)/2);
            k = (k-1)/2;
        }
    }

    private void sink(int[] heap) {
        int j = 0;
        int n = heap.length;
        while (j < n) {
            int next = j*2 + 1;
            if (next >= n) break;
            if (next + 1 < n && heap[next] > heap[next+1]) next++;
            if (heap[j] <= heap[next]) break;
            exch(heap, j, next);
            j= next;
        }
    }
    public static void main(String[] args) {
        int[] nums = {2, 1};
        KthLargestElementMinHeap k = new KthLargestElementMinHeap();
        System.out.println(k.findKthLargest(nums, 2));
    }
}
