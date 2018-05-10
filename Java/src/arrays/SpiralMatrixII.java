package arrays;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:05 2018/4/9
 * @ ModifiedBy:
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowMin = 0, rowMax = n - 1;
        int colMin = 0, colMax = n - 1;
        int data = 1;
        while (rowMin <= rowMax && colMin <= colMax) {
            for (int i = colMin; i <= colMax; i++)
                res[rowMin][i] = data++;
            rowMin++;
            for (int i = rowMin; i <= rowMax; i++) {
                res[i][colMax] = data++;
            }
            colMax--;
            for (int i = colMax; i >= colMin; i--) {
                res[rowMax][i] = data++;
            }
            rowMax--;
            for (int i = rowMax; i >= rowMin; i--) {
                res[i][colMin] = data++;
            }
            colMin++;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrixII s = new SpiralMatrixII();
        int[][] res = s.generateMatrix(4);
        for (int[] array : res) {
            for (int num : array)
                System.out.println(num);
        }
    }
}
