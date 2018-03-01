package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:36 2018/2/28
 * @ ModifiedBy:
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] use1 = new int[9][9],
                use2 = new int[9][9],
                use3 = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int num = board[i][j]-'0'-1, k = i/3*3 + j/3;
                if (board[i][j] != '.' && num >= 0) {
                    if (use1[i][num] > 0 || use2[j][num] > 0 || use3[k][num] > 0)
                        return false;
                    use1[i][num] = use2[j][num] = use3[k][num] = 1;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ValidSudoku sudoku = new ValidSudoku();
        sudoku.isValidSudoku(new char[9][9]);
    }
}
