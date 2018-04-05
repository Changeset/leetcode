package arrays;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:25 2018/4/5
 * @ ModifiedBy:
 */
public class Test3 {
    public static void getResult(int n, int m, List<List<Integer>> mac, List<List<Integer>> task) {
        Queue<Integer> queue = new LinkedList<>();
        int index = 0, maxCount = 0;
        int profit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mac.get(i).get(1) >= task.get(j).get(1)) {
                    profit += 200 * (mac.get(i).get(0)) + 3 * (mac.get(i).get(1));
                    index++;
                }
            }
        }
        System.out.println(index + " " + profit);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> mac = new LinkedList<>();
        List<List<Integer>> task = new LinkedList<>();
        for (int i = 0; i < n + m; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                List<Integer> temp = new LinkedList<>();
                temp.add(x);
                temp.add(y);
                mac.add(temp);
            }
            for (int j = 0; j < m; j++) {
                int z = sc.nextInt();
                int w = sc.nextInt();
                List<Integer> temp = new LinkedList<>();
                temp.add(z);
                temp.add(w);
                task.add(temp);
            }
        }
        getResult(n, m ,mac, task);
    }
}
