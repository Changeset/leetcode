package sortandsearch;

import java.util.PriorityQueue;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:42 2018/5/31
 * @ ModifiedBy:
 */
class Tuple implements Comparable<Tuple> {
    int x, y, val;

    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for (int j = 0; j <= n - 1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.x == n - 1) continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;
    }
}
