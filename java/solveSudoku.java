import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class solveSudoku {
    public static class Solution {
        public boolean helper(char[][] bd, List<Integer> list, int fst, List<Character> avb) {
            avb = new ArrayList<Character>();
            fst = getFirst(bd, list, avb);
            int val = list.get(fst);
            int x = list.get(fst) / 9;
            int y = list.get(fst) % 9;
            //System.out.println("avb.size(): " + avb.size());
                
            if (avb.size() == 0) return false;
            list.remove(fst);
            
            for (int k = 0; k < avb.size(); k++) {
                char c = avb.get(k);
                bd[x][y] = c;
                /*  
                // print board
                for (int i = 0; i < bd.length; i++) {
                    for (int j = 0; j < bd[0].length; j++) {
                        System.out.print(bd[i][j] + " ");
                        if (j % 3 == 2)
                            System.out.print("| ");
                    }
                    System.out.println("");
                    if (i % 3 == 2)
                        System.out.println("-----------------------");
                }

                if (!isValidSudoku(bd, x, y)) {
                    bd[x][y] = '.';
                    continue;
                }
                */
                if (list.size() == 0) return true;
                if (helper(bd, new ArrayList<Integer>(list), fst, avb)) return true;
                bd[x][y] = '.';
            }
            list.add(new Integer(val));
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
                    return i;
                }
                if (tmp.size() > result) {
                    result = i; 
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
            helper(board, list, first, avb);
        }
        /*
        public boolean isValidSudoku(char[][] bd, int x, int y) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (int j = 0; j < 9; j++) // row
                if (bd[x][j] != '.') {
                    if (!map.containsKey(bd[x][j])) map.put(bd[x][j], 1);   
                    else return false;
                }
            map.clear();
            for (int j = 0; j < 9; j++) 
                if (bd[j][y] != '.') {
                    if (!map.containsKey(bd[j][y])) map.put(bd[j][y], 1);   
                    else return false;
                }
            map.clear();
            for (int j = 0; j < 3; j++) 
                for (int k = 0; k < 3; k++) 
                    if (bd[j + (x / 3) * 3][k + (y / 3) * 3] != '.') {
                        if (!map.containsKey(bd[j + (x / 3) * 3][k + (y / 3) * 3]))
                            map.put(bd[j + (x / 3) * 3][k + (y / 3) * 3], 1);   
                        else return false;
                    }
            return true;
        }
        */
    }

    public static void main(String[] args){
        Solution result = new Solution();
        char [][] board = {
            {'1', '.', '.', '.', '7', '.', '.', '3', '.'},
            {'8', '3', '.', '6', '.', '.', '.', '.', '.'},
            {'.', '.', '2', '9', '.', '.', '6', '.', '8'},
            {'6', '.', '.', '.', '.', '4', '9', '.', '7'},
            {'.', '9', '.', '.', '.', '.', '.', '5', '.'},
            {'3', '.', '7', '5', '.', '.', '.', '.', '4'},
            {'2', '.', '3', '.', '.', '9', '1', '.', '.'},
            {'.', '.', '.', '.', '.', '2', '.', '4', '3'},
            {'.', '4', '.', '.', '8', '.', '.', '.', '9'}};
            /*
            {'.', '.', '.', '.', '.', '7', '.', '.', '9'},
            {'.', '4', '.', '.', '8', '1', '2', '.', '.'},
            {'.', '.', '.', '9', '.', '.', '.', '1', '.'},
            {'.', '.', '5', '3', '.', '.', '.', '7', '2'},
            {'2', '9', '3', '.', '.', '.', '.', '5', '.'},
            {'.', '.', '.', '.', '.', '5', '3', '.', '.'},
            {'8', '.', '.', '.', '2', '3', '.', '.', '.'},
            {'7', '.', '.', '.', '5', '4', '.', '.', '.'},
            {'5', '3', '1', '.', '7', '.', '.', '.', '.'}};
            {'.', '.', '9', '7', '4', '8', '.', '.', '.'}, 
            {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, 
            {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, 
            {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, 
            {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, 
            {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, 
            {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, 
            {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, 
            {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
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
  Time Limit ExceededMore Details 
Last executed input:	[
"1...7..3.",
"83.6.....",
"..29..6.8",
"6....49.7",
".9.....5.",
"3.75....4",
"2.3..91..",
".....2.43",
".4..8...9"]

  Time Limit ExceededMore Details 
Last executed input:[
".....7..9",
".4..812..",
"...9...1.",
"..53...72",
"293....5.",
".....53..",
"8...23...",
"7...5..4.",
"531.7...."]

  Input:	["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
Output:	["539748612","78.6.2459","426159873",".57986241","264317598","198524367","915863724","872491.36","64327598."]
Expected:	["519748632","783652419","426139875","357986241","264317598","198524367","975863124","832491756","641275983"]
*/
