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
            int ans = 0;
            for (String key : one.keySet()) 
                if (one.get(key) == 1 && two.containsKey(key) && two.get(key) == 1) 
                    ans++;
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
        public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
            int res = 0, i = startPos[0], j = startPos[1], x = homePos[0], y = homePos[1];
            while (i != x) {
                i += (x - i) / Math.abs(x - i);
                res += rowCosts[i];
            }
            while (j != y) {
                j += (y - j) / Math.abs(y - j);
                res += colCosts[j];
            }
            return res;
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

        public int minimumBuckets(String t) { // 自己写的，脑袋昏昏没能理清楚逻辑
            int n = t.length(), cnt = 0;
            if (n > 0 && t.indexOf(".") == -1) return -1;
            if (t.chars().distinct().count() == 1 && t.charAt(0) == '.') return 0;
            char [] s = t.toCharArray();
            if (n == 1) return s[0] == '.' ? 0 : -1;
            boolean [] vis = new boolean[n];
            for (int i = 0; i < n; i++) {
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
        public int minimumBuckets(String s) {
            return (s.equals("H") || s.startsWith("HH") || s.endsWith("HH") || s.contains("HHH")) ?
                -1 : s.replace("H.H", "  ").length() - s.replace("H", "").length();
        }
        public int minimumBuckets(String s) {
            return (s.equals("H") || s.startsWith("HH") || s.endsWith("HH") || s.contains("HHH")) ?
                -1 : s.replace("H.H", "  ").length() - s.replace("H", "").length();
        }
        // If there is empty space on both the side of house then better will be to put bucket on the right side
        // because it can also store water for house next to it if necessary.
        // Approach1: Keep track of ur bucket using hashmap
        public int minimumBuckets(String t) {
            Map<Integer, Boolean> m = new HashMap<>();
            char [] s = t.toCharArray();
            int n = t.length(), cnt = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == 'H') {
                    if (m.getOrDefault(i-1, false)) continue;
                    if (i+1 < n && s[i+1] == '.') {
                        cnt++;
                        m.put(i+1, true);
                        continue;
                    }
                    if (i-1 >= 0 && s[i-1] == '.') {
                        cnt++;
                        continue;
                    }
                    return -1;
                }
            }
            return cnt;
        }
    // Approach2: You don't need map actually...just modify your string and keep putting bucket
        public int minimumBuckets(String street) {
            int count=0;
            StringBuilder sb = new StringBuilder(street);
            for(int i=0;i<street.length();i++){
                if(sb.charAt(i)=='H'){
                    if(i-1>=0 && sb.charAt(i-1)=='B') continue;
                    if(i+1<sb.length() && sb.charAt(i+1)=='.'){
                        count++;
                        sb.setCharAt(i+1,'B');
                        continue;
                    }
                    if(i-1>=0 && sb.charAt(i-1)=='.'){
                        count++;
                        continue;
                    }
                    return -1;
                }
            }
            return count;
        }
        // You actually don't even need to modify string..
        // u can just increase your index to by 2 after keepig bucket because till next two index u don't need to take care of bucket
        public int minimumBuckets(String street) {
            int count=0;
            for(int i=0;i<street.length();i++){
                if(street.charAt(i)=='H'){
                    if(i+1<street.length() && street.charAt(i+1)=='.'){
                        count++;
                        i+=2;
                        continue;
                    }
                    if(i-1>=0 && street.charAt(i-1)=='.'){
                        count++;
                        continue;
                    }
                    return -1;
                }
            }
            return count;
        }
        public int minimumBuckets(String street) {
            int retval = 0;
            int n = street.length();
            StringBuilder sb = new StringBuilder(street);
            for (int i = 0; i < n; i++) { // solve it by greedy
                if (sb.charAt(i) == 'H') {
                    if (i - 1 >= 0 && sb.charAt(i - 1) == 'U') {
                        //it can use same bucket with previous house
                        continue;
                    }else if (i + 1 < n && sb.charAt(i + 1) == '.') {
                        //set buckets to used, so we can know if next house can just used it without extra buckets
                        retval += 1;
                        sb.setCharAt(i + 1, 'U');
                    }else if (i - 1 >= 0 && sb.charAt(i - 1) == '.') {
                        //this bucket can only used by current house, so we just need retval add 1
                        retval += 1;
                    }else {
                        //no buckets around this house return -1
                        return -1;
                    }
                }
            }
            return retval;
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