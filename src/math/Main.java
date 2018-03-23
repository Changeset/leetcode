package math;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:21 2018/3/23
 * @ ModifiedBy:
 */
public class Main {
    static double dis(int x1, int y1, int x2, int y2) {
        return Math.sqrt((double) (Math.pow(Math.abs(x1-x2), 2) + (Math.pow(Math.abs(y1-y2), 2))));
    }
    public static boolean result(int[][] x) {
        int x1 = x[0][0], y1 = x[1][0];
        int x2 = x[0][1], y2 = x[1][1];
        int x3 = x[0][2], y3 = x[1][2];
        int x4 = x[0][3], y4 = x[1][3];
        double[] dd = new double[10];
        dd[0] = dis(x1, y1, x2, y2);
        dd[1] = dis(x1, y1, x3, y3);
        dd[2] = dis(x1, y1, x4, y4);
        dd[3] = dis(x2, y2, x3, y3);
        dd[4] = dis(x2, y2, x4, y4);
        dd[5] = dis(x3, y3, x4, y4);
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            if (!map.containsKey(dd[i])) map.put(dd[i], 1);
            else map.put(dd[i], map.get(dd[i]) + 1);
        }
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : map.values()) {
            if(num != 2 && num != 4) return false;
            if (!set.contains(num)) set.add(num);
            else return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Boolean> res = new LinkedList<>();
        for (int i = 0; i < t; i++) {
            int[][] x = new int[4][4];
            for (int m = 0; m < 2; m++) {
                for (int n = 0; n < 4; n++) {
                    x[m][n] = sc.nextInt();
                }
            }
            res.add(result(x));
        }
        for (boolean result : res) {
            if (result)
                System.out.println("Yes");
            else System.out.println("No");
        }
    }
}