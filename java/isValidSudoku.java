import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isValidSudoku {
    public static class Solution {
        public boolean isValidSudoku(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) return false;
            Map<Character, Integer> map = new HashMap<Character, Integer>();

            // check row
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == '.') continue;
                    if (!map.containsKey(board[i][j]))
                        map.put(board[i][j], 1);
                    else if (map.containsKey(board[i][j]))
                        return false;
                }
                map.clear();
            }

            // check column
            for (int j = 0; j < board[0].length; j++) {
                for (int i = 0; i < board.length; i++) {
                    if (board[i][j] == '.') continue;
                    if (!map.containsKey(board[i][j]))
                        map.put(board[i][j], 1);
                    else if (map.containsKey(board[i][j]))
                        return false;
                }
                map.clear();
            }

            // check square
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int cnti = 0; cnti < 3; cnti++) {
                        for (int cntj = 0; cntj < 3; cntj++) {
                            if (board[i*3+cnti][j*3+cntj] == '.') continue;
                            if (!map.containsKey(board[i*3+cnti][j*3+cntj]))
                                map.put(board[i*3+cnti][j*3+cntj], 1);
                            else if (map.containsKey(board[i*3+cnti][j*3+cntj]))
                                return false;
                        }
                    }
                    map.clear();
                }
            }
            return true;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        char [][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        
        boolean res = result.isValidSudoku(board);
        
        System.out.println(res);
    }
}
