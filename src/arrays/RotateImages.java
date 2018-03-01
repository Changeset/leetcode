package arrays;

import javafx.scene.transform.Rotate;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 17:29 2018/2/28
 * @ ModifiedBy:
 * The idea was firstly transpose the matrix and then flip it symmetrically. For instance,

 1  2  3
 4  5  6
 7  8  9
 after transpose, it will be swap(matrix[i][j], matrix[j][i])

 1  4  7
 2  5  8
 3  6  9
 Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])

 7  4  1
 8  5  2
 9  6  3
 */
public class RotateImages {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                exch(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                exch(matrix, i, j, i, n-j-1);
            }
        }
    }

    public static void exch(int[][] a, int i, int j, int x, int y) {
        int swap = a[i][j];
        a[i][j] = a[x][y];
        a[x][y] = swap;
    }

    public static void main(String[] args) {
        RotateImages ri = new RotateImages();
        int[][] matrix = {{1,2},{3,4}};
        ri.rotate(matrix);
    }
}
