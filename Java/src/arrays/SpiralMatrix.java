package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:24 2018/4/9
 * @ ModifiedBy:Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 *
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) result.add(matrix[rowBegin][i]);
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) result.add(matrix[i][colEnd]);
            colEnd--;

            if (rowBegin > rowEnd || colBegin > colEnd) break;
            for (int i = colEnd; i >= colBegin; i--) result.add(matrix[rowEnd][i]);
            rowEnd--;

            for (int i = rowEnd; i >= rowBegin; i--) result.add(matrix[i][colBegin]);
            colBegin++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2,5},
                {8,4},
                {0,-1}
        };
        SpiralMatrix s = new SpiralMatrix();
        System.out.println(s.spiralOrder(matrix));
    }
}
