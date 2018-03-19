package backtracking;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:15 2018/3/19
 * @ ModifiedBy:
 */
public class WordSearch {
//    public boolean exist(char[][] board, String word) {
//        if (board.length == 0) return false;
//        if (word.isEmpty()) return false;
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                boolean[][] marked = new boolean[board.length][board[0].length];
//                if (backtrack(board, i, j, word, marked)) return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean backtrack(char[][] board, int row, int col, String word, boolean[][] marked) {
//        if (word.isEmpty()) return true;
//        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
//        if (!marked[row][col]) {
//            if (board[row][col] == word.charAt(0)) {
//                marked[row][col] = true;
//                if(backtrack(board, row + 1, col, word.substring(1), marked) ||
//                        backtrack(board, row - 1, col, word.substring(1), marked) ||
//                        backtrack(board, row, col - 1, word.substring(1), marked) ||
//                        backtrack(board, row, col + 1, word.substring(1), marked))
//                    return true;
//                else {
//                    marked[row][col] = false;
//                    return false;
//                }
//            } else {
//                marked[row][col] = false;
//                return false;
//            }
//        }
//        else return false;
//    }
    public boolean exist(char[][] board, String word) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (exist(board, y, x, word, 0)) return true;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, int i, int j, String word, int ind) {
        if (ind == word.length()) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[i].length || board[i][j] != word.charAt(ind)) return false;
        board[i][j] = '*';
        boolean result = exist(board, i-1, j, word, ind+1) ||
                exist(board, i, j-1, word, ind+1) ||
                exist(board, i, j+1, word, ind+1) ||
                exist(board, i+1, j, word, ind+1);
        board[i][j] = word.charAt(ind);
        return result;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}
        };
        WordSearch w = new WordSearch();
        String word = "ASB";
        System.out.println(w.exist(board, word));
    }
}
