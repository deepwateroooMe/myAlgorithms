import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class cmp {
    public static class Solution {

        public int countWords(String[] a, String[] b) {
            int m = a.length, n = b.length;
            Map<String, Integer> one = new HashMap<>();
            Map<String, Integer> two = new HashMap<>();
            for (String sa : a) 
                one.put(sa, one.getOrDefault(sa, 0) + 1);
            for (String sb : b) 
                two.put(sb, two.getOrDefault(sb, 0) + 1);
            int ans = 0, both = 0;
            Set<String> vis = new HashSet<>();
            for (String key : one.keySet()) 
                if (one.get(key) == 1 && two.containsKey(key) && two.get(key) == 1) {
                    ans++;
                    vis.add(key);
                }
            for (String key : two.keySet()) {
                if (vis.contains(key)) continue;
                if (two.get(key) == 1 && one.containsKey(key) && one.get(key) == 1) 
                    ans++;
            }
            return ans;
        }

        public int countPyramids(int[][] g) {
            int m = g.length, n = g[0].length, ans = 0;
            int [][] r = new int [m][n];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    r[i][j] = (j == 0 ? 0 : r[i][j-1]) + g[i][j];
            for (int i = 0; i < m-1; i++) 
                for (int j = 1; j < n-1; j++) {
                    if (g[i][j] == 0) continue;
                    for (int d = 2; d <= Math.min(m, n) && i+d-1 < m && j-(d-1) >= 0 && j+(d-1) < n; d++) {
                        if (r[i+d-1][j+d-1] - (j-(d-1) == 0 ? 0 : r[i+d-1][j-(d-1)-1]) == 2 * d - 1) ans++;
                        else break;
                    }
                }
            for (int i = m-1; i > 0; i--) 
                for (int j = 1; j < n-1; j++) {
                    if (g[i][j] == 0) continue;
                    for (int d = 2; d <= Math.min(m, n) && i-(d-1) >= 0 && j-(d-1) >= 0 && j+(d-1) < n; d++) {
                        int x = i-(d-1), yl = j - (d-1), yr = j + (d-1);
                        if (r[x][yr] - (yl == 0 ? 0 : r[x][yl-1]) == 2 * d - 1) ans++;
                        else break;
                    }
                }
            return ans;
        }

        public int minimumBuckets(String t) { // 还有几个case没过
            int n = t.length(), cnt = 0;
            if (n > 0 && t.indexOf(".") == -1) return -1;
            if (t.chars().distinct().count() == 1 && t.charAt(0) == '.') return 0;
            char [] s = t.toCharArray();
            if (n == 1) return s[0] == '.' ? 0 : -1;
            boolean [] vis = new boolean[n];
            for (int i = 0; i < n; i++) {
                // if (s[i] == 'H') continue;
                if (s[i] == 'H') {
                    if (i == 0 && s[i+1] != '.') return -1;
                    if (i == n-1 && s[i-1] != '.') return -1;
                    if (i > 0 && s[i-1] != '.' && s[i+1] != '.') return -1;
                    if (vis[i]) continue;
                    cnt++;
                    if (i < n-2 && s[i+1] == '.' && s[i+2] == 'H') {
                        vis[i] = true;
                        vis[i+2] = true;
                    }
                    continue;
                }
            }
            return cnt;
        }

        // 这个题：一开始想的是四个方面priorityQue O(NlogN)的解法。tle
        // 后来试过 dfs后想到我只需要两个方向
        // 但两个方向的仍然超时了，时间卡得极严
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
        int min = Integer.MAX_VALUE;
        public int minCost(int[] s, int[] t, int[] rowCosts, int[] colCosts) {
            if (s[0] == t[0] && s[1] == t[1]) return 0;
            int m = rowCosts.length, n = colCosts.length;
            int [][] ds = new int [2][2];
            if (t[0] >= s[0] && t[1] >= s[1]) ds = new int [][] {{1, 0}, {0, 1}};
            else if (t[0] >= s[0] && t[1] < s[1]) ds = new int [][] {{1, 0}, {0, -1}};
            else if (t[0] < s[0] && t[1] >= s[1]) ds = new int [][] {{-1, 0}, {0, 1}};
            else ds = new int [][] {{-1, 0}, {0, -1}};
            Set<Integer> vis = new HashSet<>();
            Queue<int []> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
            q.offer(new int [] {s[0] * n + s[1], 0});
            vis.add(s[0] * n + s[1]);
            while (!q.isEmpty()) {
                for (int size = q.size()-1; size >= 0; size--) {
                    int [] cur = q.poll();
                    if (cur[0] / n == t[0] && cur[0] % n == t[1]) return cur[1];
                    for (int i = 0; i < 2; i++) {
                        int x = cur[0] / n + ds[i][0], y = cur[0] % n + ds[i][1];
                        if (x < 0 || x >= m || y < 0 || y >= n || vis.contains(x*n + y)) continue;
                        vis.add(x * n + y);
                        q.offer(new int [] {x * n + y, cur[1] + (i < 1 ? rowCosts[x] : colCosts[y])});
                    }
                }
            }
            return -1;
        }
        public int minCost(int[] s, int[] t, int[] rowCosts, int[] colCosts) {
            if (s[0] == t[0] && s[1] == t[1]) return 0;
            m = rowCosts.length;
            n = colCosts.length;
            vis = new boolean [m][n];
            int [][] ds = new int [2][2];
            if (t[0] >= s[0] && t[1] >= s[1]) ds = new int [][] {{1, 0}, {0, 1}};
            else if (t[0] >= s[0] && t[1] < s[1]) ds = new int [][] {{1, 0}, {0, -1}};
            else if (t[0] < s[0] && t[1] >= s[1]) ds = new int [][] {{-1, 0}, {0, 1}};
            else ds = new int [][] {{-1, 0}, {0, -1}};
            dfs(s[0], s[1], 0, t, rowCosts, colCosts, ds);
            return min;
        }
        // int [][] dirsOne = {{1, 0}, {0, 1}, {0, -1}};
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 是否可以考虑只走两个方向
        boolean [][] vis;
        int m, n, min = Integer.MAX_VALUE;
        private void dfs(int i, int j, int sum, int [] t, int [] r, int [] c, int [][] ds) {
            if (i == t[0] && j == t[1]) {
                min = Math.min(min, sum);
                return ;
            }
            vis[i][j] = true;
            for (int k = 0; k < 2; k++) {
                int x = i + ds[k][0], y = j + ds[k][1];
                if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y]) continue;
                dfs(x, y, sum + (k < 1 ? r[x] : c[y]), t, r, c, ds);
            }
            vis[i][j] = false;
        }
        // 最后的解题答案其实非常简单
        public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
            if (startPos[0] == homePos[0] && startPos[1] == homePos[1])
                return 0;
            int minRow = Math.min(startPos[0], homePos[0]);
            int maxRow = Math.max(startPos[0], homePos[0]);
            int minCol = Math.min(startPos[1], homePos[1]);
            int maxCol = Math.max(startPos[1], homePos[1]);
            int res = 0;
            for (int i = minRow; i <= maxRow; i++) 
                res += rowCosts[i];
            for (int i = minCol; i <= maxCol; i++) 
                res += colCosts[i];
            res = res - rowCosts[startPos[0]] - colCosts[startPos[1]];
            return res;
        }

    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        // int [] a = new int [] {1, 0};
        // int [] b = new int [] {2, 3};
        // int [] c = new int [] {5, 4, 3};
        // int [] d = new int [] {8, 2, 6, 7};
        String a = ".....HH...";
        // String a = ".HH.H.H.H..";
        int r = s.minimumBuckets(a);

        // int r = s.minCost(a, b, c, d);
        System.out.println ("r: " + r);

    }
}
// cmp s = new cmp (a);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
        
// TreeNode res = s.(root );
// res.levelPrintTree(res);