import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class existWordSearch {
    public static class Solution {
        public boolean dfs(char[][] board, String word,
                           int i, int j, int idx, int [][] visited) {
            int m = board.length;
            int n = board[0].length;
            if (idx == word.length()) return true;
            if (i < 0 || i >= m || j < 0 || j >= n || 
                visited[i][j] == 1 || word.charAt(idx) != board[i][j]) return false;
            visited[i][j] = 1;
            if (dfs(board, word, i + 1, j, idx + 1, visited)
                || dfs(board, word, i - 1, j, idx + 1, visited)
                || dfs(board, word, i, j + 1, idx + 1, visited)
                || dfs(board, word, i, j - 1, idx + 1, visited))
                return true;
            visited[i][j] = 0;
            return false;
        }
        
        public boolean exist(char[][] board, String word) {
            if (word == null || word.length() == 0) return true;
            else if (board == null || board.length == 0 || board[0].length == 0) return false;
            int m = board.length;
            int n = board[0].length;
            int div = m >= n ? m : n;
            int tmp = 0;
            int [][] visited = new int[m][n];
            
            if (word.length() > m * n) return false;
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    if (board[i][j] == word.charAt(0))
                        stack.push(i * div + j);
            while (!stack.isEmpty()) {
                tmp = stack.pop();
                int i = tmp / div;
                int j = tmp % div;
                if (dfs(board, word, i, j, 0, visited) == true) return true;
            }
            return false;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        char [][] s = {{'A', 'B', 'C', 'E'},
                       {'S', 'F', 'C', 'S'},
                       {'A', 'D', 'E', 'E'}};
        System.out.println("");
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) 
                System.out.print(s[i][j] + ", ");
            System.out.println("");
        }

        String word = "ABCB";
        boolean res = result.exist(s, word);

        System.out.println(res);
    }
}
