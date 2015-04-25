import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class solveNQueens {
    public static class Solution {
        // see II
        public boolean isValid(char [][] s, int n, int x, int y) {
            for (int i = 0; i < n && i != y; i++) // col
                if (s[x][i] == 'Q') return false;
            for (int i = 0; i < n && i != x; i++) // row
                if (s[i][y] == 'Q') return false;

            for (int i = x - 1; i >= 0 && y - x + i >= 0; i--)
                if (s[i][y - x + i] == 'Q') return false;
            for (int i = x - 1; i >= 0 && y + x - i < n; i--)
                if (s[i][y + x - i] == 'Q') return false;
            for (int i = x + 1; i < n && y + x - i >= 0; i++)
                if (s[i][y + x - i] == 'Q') return false;
            for (int i = x + 1; i < n && y + i - x < n; i++)
                if (s[i][y + i - x] == 'Q') return false;
            return true;
        }
        
        public void myQueen(int n, List<String[]> res, char [][] s, int i, int j, int cnt) {
            StringBuffer [] tmp = new StringBuffer[n];
            String [] one = new String[n];
            System.out.println("");
            System.out.println("i: " + i);
            System.out.println("j: " + j);
            System.out.println("cnt: " + cnt);
            if (cnt == n) {
                for (int x = 0; x < n; x++) {
                    tmp[x] = new StringBuffer();
                    for (int y = 0; y < n; y++) {
                        if (s[x][y] != 'Q' && s[x][y] != '.') s[x][y] = '.';
                        tmp[x].append(s[x][y]);
                    }
                    System.out.println("tmp[x].toString(): " + tmp[x].toString());
                    one[x] = tmp[x].toString();
                }
                res.add(one);
                cnt = 0;
                return;
            }
            
            for (int x = 0; x < n && x != i; x++) {
                for (int y = 0; y < n && y != j; y++) {  // need optimize y != x
                    System.out.println("x: " + x);
                    System.out.println("y: " + y);
                    s[x][y] = 'Q';
                    if (!isValid(s, n, x, y)) {
                        s[x][y] = '.';
                        continue;
                    } else {
                        ++cnt;
                        myQueen(n, res, s, x, y, cnt);
                    }
                    //s[x][y] = '.';
                }
            }
        }
        
        public List<String[]> solveNQueens(int n) {
            List<String[]> res = new ArrayList<String[]>();
            char [][] s = new char[n][n];
            int curr = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) { //row
                for (int j = 0; j < n; j++) { //col
                    s[i][j] = 'Q';
                    //++cnt;
                    System.out.println("");
                    myQueen(n, res, s, i, j, cnt);
                    s[i][j] = '.';
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        List<String[]> res = result.solveNQueens(4);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            for (int j = 0; j < res.get(i).length; j++) {
                System.out.println((res.get(i))[j] + ", ");                
            }
            System.out.println("");            
        }
    }
}

/*
  [
  [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

  ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
  ]
*/
