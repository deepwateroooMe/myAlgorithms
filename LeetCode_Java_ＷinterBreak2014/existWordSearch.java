import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class existWordSearch {
    public static class Solution {
        public boolean dfs(char[][] board, String word,
                           int i, int j, int idx, boolean [][] visited) {
            int m = board.length;
            int n = board[0].length;
            if (idx == word.length()) return true;
            
            if (i < 0 || i >= m || j < 0 || j >= n) return false;
            if (visited[i][j]) return false;
            if (word.charAt(idx) != board[i][j]) return false;

            visited[i][j] = true;
            if (dfs(board, word, i + 1, j, idx + 1, visited)
                || dfs(board, word, i - 1, j, idx + 1, visited)
                || dfs(board, word, i, j + 1, idx + 1, visited)
                || dfs(board, word, i, j - 1, idx + 1, visited))
                return true;
            visited[i][j] = false;
            return false;
        }
        
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            boolean [][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    if (dfs(board, word, i, j, 0, visited) == true) return true;
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
