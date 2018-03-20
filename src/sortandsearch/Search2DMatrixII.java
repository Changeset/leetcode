package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 18:39 2018/3/20
 * @ ModifiedBy:
 */
public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;
        if (matrix != null) {
            int row = 0;
            int column = matrix[0].length - 1;
            while (row < matrix.length && column >= 0) {
                if (matrix[row][column] == target) {
                    found = true;
                    break;
                }
                else if (matrix[row][column] > target)
                    --column;
                else ++row;
            }
        }
        return found;
    }
}
