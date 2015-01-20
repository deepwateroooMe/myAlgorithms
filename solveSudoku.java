import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.BitSet;

public class solveSudoku {
    public static class Solution {
        // I want to try his method it seems fun, & struct in class ...
        // https://oj.leetcode.com/discuss/21452/sharing-my-2ms-c-solution-with-comments-and-explanations

        public class cell {
            int val; // 1, 2, ..., 9, 0 if unset
            int pcnt; // cnt possibilities
            BitSet limit;
            public cell() {
                val = 0;
                pcnt = 9;
                limit = new BitSet(10);
            }
        }
        private cell [][] cells = new cell[9][9];
        
        // sets the value of the call to [v]
        // the function also propagates constraints to other cells and deduce new values where possible
        public boolean set(int i, int j, int val) {
            cell tmp = cells[i][j];
            if (tmp.val == val) return true;
            if (tmp.limit[v]) return false;  // [] access bit
            tmp.limit = fromString("1111111111"); // 0x3fe
            tmp.limit.set(val);
            tmp.pcnt = 1;
            tmp.val = val;

            // propagating constraints
            for (int k = 0; k < 9; k++) {
                // to the row;
                if (i != k && !updateLimit(k, j, val)) return false;
                // to the col;
                if (j != k && !updateLimit(i, k, val)) return false;
                // to the 3*3
                int ix = (i / 3) * 3 + k / 3;
                int jx = (j / 3) * 3 + k % 3;
                if (ix != i && jx != j && !updateLimit(ix, jx, val)) return false;
            }
            return true;
        }

        // update limits of the cell i j by excluding possibilities of excleval
        
        public void solveSudoku(char[][] board) {
            
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
        
        //boolean res = result.isValidSudoku(board);
        result.solveSudoku(board);

        System.out.println("");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) 
                System.out.print(board[i][j] + ", ");
            System.out.println("");
        }
    }
}
