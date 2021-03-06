package greedy;

import java.util.PriorityQueue;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:19 2018/6/15
 * @ ModifiedBy:
 */
public class IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        for (int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[] {Capital[i], Profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                pqPro.add(pqCap.poll());
            }
            if (pqPro.isEmpty()) break;

            W += pqPro.poll()[1];
        }

        return W;
    }

    public static void main(String[] args) {
        IPO i = new IPO();
        int[] Pro = {1, 2, 3};
        int[] Capital = {0, 1, 1};
        System.out.println(i.findMaximizedCapital(2, 0, Pro, Capital));
    }
}
