package math;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:53 2018/3/23
 * @ ModifiedBy:
 */
public class Main2 {

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
            res.add();
        }
        for (boolean result : res) {
            if (result)
                System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
