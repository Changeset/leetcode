package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:48 2018/3/24
 * @ ModifiedBy:
 */
public class WithinThreeJump {
    public int[] withinThreeJumps(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer, Integer> map = new HashMap<>();

        int length = Math.min(a.length, b.length);
        int[][] friend = new int[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                friend[i][j] = 1001;
            }
        }
        for (int i = 0; i < length; i++) {
            friend[a[i]][b[i]] = 1;
        }
        boolean[] visited = new boolean[1000];
        floyd(friend, a);
        if (c.length == 0) return new int[0];
        int[] res = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            int num = friend[c[i]][d[i]];
            if (0 < num && num <= 3)
                res[i] = 1;
        }
        return res;
    }
    public void floyd(int[][] x, int[] a) {
        for (int num : a)  {
            for (int i = 1; i < x.length; i++) {
                for (int j = 1; j < x[0].length; j++) {
                    if (x[i][j] > x[i][num] + x[num][j])
                        x[i][j] = x[i][num] + x[num][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {2,3,4,5};
        int[] c = {1,1};
        int[] d = {4,5};
        WithinThreeJump w = new WithinThreeJump();
        int[] res = w.withinThreeJumps(a,b,c,d);
        for (int num : res)
            System.out.println(num);
    }
}
