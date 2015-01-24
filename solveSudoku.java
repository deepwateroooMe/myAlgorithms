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
        public void helper(char[][] bd, List<Integer> set, int fst, List<Character> avb) {
            System.out.println("");
            System.out.println("fst: " + fst);
            int x = fst / 9;
            int y = fst % 9;
            System.out.println("x: " + x);
            System.out.println("y: " + y);

            char c = avb.get(0);
            System.out.println("c: " + c);

            bd[x][y] = c;
            avb.remove(0);

            for (int i = 0; i < bd.length; i++) {
                for (int j = 0; j < bd[0].length; j++) 
                    System.out.print(bd[i][j] + ", ");
                System.out.println("");
            }
            // when should I check valid answer ?
            if (set.size() == 0) return;
            
            List<Character> nextAvb = new ArrayList<Character>();
            int first = getFirst(bd, set, nextAvb);
            set.remove(fst);
            helper(bd, set, first, nextAvb);
            
            return;
        }

        public int getFirst(char[][] bd, List<Integer> list, List<Character> res) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            Set<Character> tmp = new HashSet<Character>();  // for each pos
            Set<Character> avb = new HashSet<Character>();
            int x, y; // row, col
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
                        if (bd[j + x / 3][k + y / 3] != '.')
                            tmp.add(bd[j + x / 3][k + y / 3]);
                if (tmp.size() == 8) {
                    for (char a = '1'; a <= '9'; a++)
                        if (!tmp.contains(a)) res.add(a);
                    return i;   
                }
                map.put(i, tmp.size());
            }
            int result = -1;
            for (Integer key : map.keySet())
                if (map.get(key) > result)
                    result = key;

            tmp.clear();
            x = result / 9;
            y = result % 9;
            for (int j = 0; j < 9; j++) {
                if (bd[x][j] != '.') tmp.add(bd[x][j]);
                if (bd[j][y] != '.') tmp.add(bd[j][y]);
            }
            for (int j = 0; j < 3; j++) 
                for (int k = 0; k < 3; k++) 
                    if (bd[j + x / 3][k + y / 3] != '.')
                        tmp.add(bd[j + x / 3][k + y / 3]);
            for (char i = '1'; i <= '9'; i++) {
                if (!tmp.contains(i)) res.add(i);
            }
            System.out.println("res.size(): " + res.size());

            return result;
        }
        
        public void solveSudoku(char[][] board) {
            List<Integer> list = new ArrayList<Integer>();
            List<Character> avb = new ArrayList<Character>();
            for (int i = 0; i < 9; i++) 
                for (int j = 0; j < 9; j++) 
                    if (board[i][j] == '.') list.add(i * 9 + j);
            int first = getFirst(board, list, avb);
            //System.out.println("first: " + first);
            list.remove(first);
            helper(board, list, first, avb);
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

        result.solveSudoku(board);

        System.out.println("");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) 
                System.out.print(board[i][j] + ", ");
            System.out.println("");
        }
    }
}
