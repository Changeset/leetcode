package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:24 2018/3/17
 * @ ModifiedBy:
 */
public class GetColumn {
    public int getColumn(int[][] arr) {
        int col = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    col = Math.min(col, j);
                    break;
                }
            }
        }
        return col;
    }
}
