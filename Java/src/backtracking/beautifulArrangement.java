package backtracking;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:05 2018/8/27
 * @ ModifiedBy:
 */
public class beautifulArrangement {
    int count = 0;

    public int countArrangement(int N) {
        if (N == 0) return 0;
        helper(N, 1, new int[N + 1]);
        return count;
    }

    private void helper(int N, int pos, int[] used) {
        if (pos > N) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        beautifulArrangement b = new beautifulArrangement();
        System.out.println(b.countArrangement(5));
    }
}
