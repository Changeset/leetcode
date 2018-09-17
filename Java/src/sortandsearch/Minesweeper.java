package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:13 2018/9/11
 * @ ModifiedBy:
 */
public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    int r = row + i, c = col + j;
                    if (r < 0 || r >= m || c < 0 || c >= n) continue;
                    if (board[r][c] == 'M' || board[r][c] == 'X') count++;
                }
            }
            if (count > 0) board[row][col] = (char)(count + '0');
            else {
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c >= n) continue;
                        if (board[r][c] == 'E') updateBoard(board, new int[]{r, c});
                    }
                }
            }
        }
        return board;
    }

    public char[][] updateBoard1(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0 || click.length != 2) return board;
        int x = click[0], y = click[1], m = board.length, n = board[0].length;
        if (board[x][y] == 'M') board[x][y] = 'X';
        else {
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
            dfs(board, x, y, m, n, dirs);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y, int m, int n, int[][] dirs) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'E') return;
        int mine = adjMine(board, x, y, m, n);
        if (mine > 0) {
            board[x][y] = (char)('0' + mine);
        } else {
            board[x][y] = 'B';
            for (int[] d : dirs) {
                dfs(board, x + d[0], y + d[1], m, n, dirs);
            }
        }
    }

    private int adjMine(char[][] board, int x, int y, int m, int n) {
        int cnt = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1;  j <= y + 1; j++) {
                if (0 <= i && i < m && 0 <= j && j < n && board[i][j] == 'M')
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Minesweeper m = new Minesweeper();
    }
}
