import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class solveSudoku {
    public static class Solution {
        // can NOT think tonight any more
        public boolean helper(char[][] bd, List<Integer> list, int fst, List<Character> avb) {

            System.out.println("");
            System.out.println("fst: " + fst);
            int x = fst / 9;
            int y = fst % 9;
            System.out.println("x: " + x);
            System.out.println("y: " + y);
            
            list.remove(new Integer(fst));
            for (int k = 0; k < avb.size(); k++) {
                char c = avb.get(k);
                System.out.println("c: " + c);
                bd[x][y] = c;
                // print board
                for (int i = 0; i < bd.length; i++) {
                    for (int j = 0; j < bd[0].length; j++) 
                        System.out.print(bd[i][j] + " ");
                    System.out.println("");
                }

                if (!isValidSudoku(bd)) {
                    bd[x][y] = '.';
                    continue;
                }

                if (list.size() == 0) return true;
                
                List<Character> nextAvb = new ArrayList<Character>();
                int first = getFirst(bd, list, nextAvb);
                //list.remove(new Integer(first));
                if (helper(bd, list, first, nextAvb)) return true;
                //list.add(new Integer(first));
                bd[x][y] = '.';
            }
            list.add(new Integer(fst));

            List<Character> nextAvb = new ArrayList<Character>();
            int first = getFirst(bd, list, nextAvb);
            //list.remove(new Integer(first));
            if (helper(bd, list, first, nextAvb)) return true;
            return false;
        }

        public int getFirst(char[][] bd, List<Integer> list, List<Character> res) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            Set<Character> tmp = new HashSet<Character>();  // for each pos
            Set<Character> bst = new HashSet<Character>();  // for each pos
            Set<Character> avb = new HashSet<Character>();
            int x, y; // row, col
            int result = 0;
            for (int i = 0; i < list.size(); i++) {
                tmp.clear();
                x = list.get(i) / 9;
                y = list.get(i) % 9;
                for (int j = 0; j < 9; j++) {
                    if (bd[x][j] != '.') tmp.add(bd[x][j]);
                    if (bd[j][y] != '.') tmp.add(bd[j][y]);
                }
                for (int j = 0; j < 3; j++) 
                    for (int k = 0; k < 3; k++) 
                        if (bd[j + (x / 3) * 3][k + (y / 3) * 3] != '.')
                            tmp.add(bd[j + (x / 3) * 3][k + (y / 3) * 3]);
                if (tmp.size() == 8) {
                    for (char a = '1'; a <= '9'; a++)
                        if (!tmp.contains(a)) res.add(a);
                    return list.get(i);   
                }
                if (tmp.size() > result) {
                    result = list.get(i);
                    bst = new HashSet<Character>(tmp);
                }
            }
            for (char i = '1'; i <= '9'; i++) {
                if (!bst.contains(i)) res.add(i);
            }
            return result;
        }
        
        public void solveSudoku(char[][] board) {
            List<Integer> list = new ArrayList<Integer>();
            List<Character> avb = new ArrayList<Character>();
            for (int i = 0; i < 9; i++) 
                for (int j = 0; j < 9; j++) 
                    if (board[i][j] == '.') list.add(i * 9 + j);
            int first = getFirst(board, list, avb);
            //list.remove(new Integer(first));
            helper(board, list, first, avb);
        }

        public boolean isValidSudoku(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) return false;
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            // check row
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == '.') continue;
                    if (!map.containsKey(board[i][j]))
                        map.put(board[i][j], 1);
                    else if (map.containsKey(board[i][j])) {
                        System.out.println("row wrong");
                        return false;
                    }
                }
                map.clear();
            }
            // check column
            for (int j = 0; j < board[0].length; j++) {
                for (int i = 0; i < board.length; i++) {
                    if (board[i][j] == '.') continue;
                    if (!map.containsKey(board[i][j]))
                        map.put(board[i][j], 1);
                    else if (map.containsKey(board[i][j])) {
                        System.out.println("col wrong");
                        return false;
                    }
                }
                map.clear();
            }
            // check square
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++) {
                    for (int cnti = 0; cnti < 3; cnti++) {
                        for (int cntj = 0; cntj < 3; cntj++) {
                            if (board[i*3+cnti][j*3+cntj] == '.') continue;
                            if (!map.containsKey(board[i*3+cnti][j*3+cntj]))
                                map.put(board[i*3+cnti][j*3+cntj], 1);
                            else if (map.containsKey(board[i*3+cnti][j*3+cntj])) {
                                System.out.println("sqr wrong");
                                return false;
                            }
                        }
                    }
                    map.clear();
                }
            return true;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        char [][] board = {
            {'.', '.', '9', '7', '4', '8', '.', '.', '.'}, 
            {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, 
            {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, 
            {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, 
            {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, 
            {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, 
            {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, 
            {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, 
            {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
            /*
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};  */

        result.solveSudoku(board);

        System.out.println("");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) 
                System.out.print(board[i][j] + " ");
            System.out.println("");
        }
    }
}
/*
  Input:	["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
Output:	["539748612","78.6.2459","426159873",".57986241","264317598","198524367","915863724","872491.36","64327598."]
Expected:	["519748632","783652419","426139875","357986241","264317598","198524367","975863124","832491756","641275983"]
*/
