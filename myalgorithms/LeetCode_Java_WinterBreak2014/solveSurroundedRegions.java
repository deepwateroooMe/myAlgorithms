import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class solveSurroundedRegions {
    public static class Solution {

        // stack overflow for longest testcase, bfs better
        public void dfs0(char[][] board, int i, int j) {
            int row = board.length;
            int col = board[0].length;
            board[i][j] = '#';
            if (i > 0 && board[i-1][j] == 'O')
                dfs0(board, i-1, j);
            if (i < row-1 && board[i+1][j] == 'O')
                dfs0(board, i+1, j);
            if (j > 0 && board[i][j-1] == 'O')
                dfs0(board, i, j-1);
            if (j < col-1 && board[i][j+1] == 'O')
                dfs0(board, i, j+1);
            return;
        }
        public void solve0(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) return;
            int row = board.length;
            int col = board[0].length;
            for (int i = 0; i < col; i++) {
                if (board[0][i] == 'O') 
                    dfs0(board, 0, i);
                if (board[row-1][i] == 'O') 
                    dfs0(board, row-1, i);
            }
            
            for (int i = 1; i < row-1; i++) {
                if (board[i][0] == 'O') 
                    dfs0(board, i, 0);
                if (board[i][col-1] == 'O') 
                    dfs0(board, i, col-1);
            }
            
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O')
                        board[i][j] = 'X';
                    if (board[i][j] == '#')
                        board[i][j] = 'O';
                }
            }
        }

        // https://oj.leetcode.com/discuss/10425/use-stack-to-get-rid-of-stackoverflow-in-dfs
        public void solve(char[][] board) {
              if (board.length == 0) return;
            int row = board.length;
            int col = board[0].length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if ((i == 0 || j == 0 || i == row-1 || j == col-1) && board[i][j] == 'O') {
                        Stack<Integer> stk = new Stack<Integer>();
                        stk.push(i * col + j);         // cannot *row, produce error, the larger 
                        while (!stk.isEmpty()) {
                            int tmp = stk.pop();
                            int x = tmp / col;
                            int y = tmp % col;
                            if (x < 0 || y < 0 || x >= row || y >= col ||
                                !(board[x][y] == 'O'))
                                continue;
                            board[x][y] = '#';
                            stk.push((x-1) * col + y);
                            stk.push((x+1) * col + y);
                            stk.push(x * col + (y - 1));
                            stk.push(x * col + (y + 1));
                        }
                    }
                }
            }
            
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O')
                        board[i][j] = 'X';
                    if (board[i][j] == '#')
                        board[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        char [][] board = {{'X', 'O', 'X', 'O', 'X', 'O'},
                           {'O', 'X', 'O', 'X', 'O', 'X'},
                           {'X', 'O', 'X', 'O', 'X', 'O'},
                           {'O', 'X', 'O', 'X', 'O', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) 
                System.out.print(board[i][j] + ", ");
            System.out.println("");
        }

        result.solve(board);
        System.out.println("");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) 
                System.out.print(board[i][j] + ", ");
            System.out.println("");
        }
    }
}

/*
  // StackOverflowError
 */
