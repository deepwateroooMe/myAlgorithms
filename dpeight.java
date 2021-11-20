import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class dpeight {
    public static class Solution {

        
        // public int maxEnvelopes(int[][] a) {
        //     int n = a.length, max = 1;
        //     List<int []> ll = new ArrayList<>();
        //     for (int [] v : a) ll.add (v);
        //     Collections.sort(ll, (x, y) -> x[0] != y[0] ? x[0]- y[0] : x[1] - y[1]);
        //     int [] dp = new int [n];
        //     // dp[0] = 1; // bug: 可以从中间某个位置开始，需要确保中间某个位置的起始值——也同样是——初始化——了的
        //     Arrays.fill(dp, 1);
        //     for (int i = 1; i < n; i++) {
        //         int [] cur = ll.get(i);
        //         for (int j = 0; j < i; j++) {
        //             int [] pre = ll.get(j);
        //             if (pre[0] < cur[0] && pre[1] < cur[1])
        //                 dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //         max = Math.max(max, dp[i]);
        //     }
        //     return max;
        // }
 
        // public int[] pathsWithMaxScore(List<String> bd) { // bug
        //     int m = bd.size(), n = bd.get(0).length();
        //     int [][] a = new int [m][n];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) {
        //             char c = bd.get(i).charAt(j);
        //             a[i][j] = ((c == 'X' || c == 'S' || c == 'E') ? 0 : c-'0');
        //         }
        //     // System.out.println("a.length: " + a.length);
        //     // for (int z = 0; z < a.length; ++z) 
        //     //     System.out.println(Arrays.toString(a[z]));
            
        //     int [][] dirs = {{-1, -1}, {-1, 0}, {0, -1}};
        //     int [][] dp = new int [m][n];
        //     int [][] cnt = new int [m][n];
        //     cnt[m-1][n-1] = 1;
        //     boolean poss = false;
        //     for (int i = m-1; i >= 0; i--) {
        //         for (int j = n-1; j >= 0; j--) {
        //             // System.out.println("\n i: " + i);
        //             // System.out.println("j: " + j);

        //             if (a[i][j] == 0 && !(i == 0 && j == 0) && !(i == m-1 && j == n-1)) continue;
        //             poss = false;
        //             for (int [] d : dirs) {
        //                 int x = i + d[0], y = j + d[1];
        //                 if (x < 0 || x >= m || y < 0 || y >= n) continue;
        //                 // System.out.println("(a[x][y] == 0 && !(x == 0 && y == 0)) : " + (a[x][y] == 0 && !(x == 0 && y == 0)) );
        //                 if (a[x][y] == 0 && !(x == 0 && y == 0)) continue;
        //                 poss = true;
        //                 if (dp[x][y] == 0) {
        //                     dp[x][y] = dp[i][j] + a[x][y];
        //                     cnt[x][y] = cnt[i][j];
        //                 } else if (dp[x][y] < dp[i][j] + a[x][y]) {
        //                     dp[x][y] = dp[i][j] + a[x][y];
        //                     cnt[x][y] = cnt[i][j];
        //                 } else if (dp[x][y] == dp[i][j] + a[x][y])
        //                     cnt[x][y] += cnt[i][j];
        //             }
        //             if (!poss && !(i == 0 && j == 0)) return new int [2];
        //             // System.out.println("dp.length: " + dp.length);
        //             // for (int z = 0; z < dp.length; ++z) 
        //             //     System.out.println(Arrays.toString(dp[z]));
        //             // System.out.println("cnt.length: " + cnt.length);
        //             // for (int z = 0; z < cnt.length; ++z) 
        //             //     System.out.println(Arrays.toString(cnt[z]));
        //         }
        //     }
        //     // System.out.println("dp.length: " + dp.length);
        //     // for (int z = 0; z < dp.length; ++z) 
        //     //     System.out.println(Arrays.toString(dp[z]));
        //     // System.out.println("cnt.length: " + cnt.length);
        //     // for (int z = 0; z < cnt.length; ++z) 
        //     //     System.out.println(Arrays.toString(cnt[z]));
        //     return new int [] {dp[0][0], cnt[0][0]} ;
        // }

        // public int maxSum(int [] a, int [] b) {
        //     int mod = (int)1e9 + 7;
        //     int m = a.length, n = b.length;
        //     long [] sa = new long [m];
        //     long [] sb = new long [n];
        //     for (int i = 0; i < m; i++) 
        //         sa[i] = (i == 0 ? 0 : sa[i-1]) + a[i];
        //     for (int i = 0; i < n; i++) 
        //         sb[i] = (i == 0 ? 0 : sb[i-1]) + b[i];
        //     int i = 0, j = 0;
        //     long max = 0;
        //     List<Integer> ia = new ArrayList<>(); // idx a b 
        //     List<Integer> ib = new ArrayList<>();
        //     while (i < m && j < n) {
        //         while (i < m && j < n && a[i] < b[j]) i++;
        //         while (i < m && j < n && a[i] > b[j]) j++;
        //         if (i < m && j < n && a[i] == b[j]) {
        //             ia.add(i);
        //             ib.add(j);
        //             i++;
        //             j++;
        //         }
        //     }
        //     if (ia.size() == 0) return (int)(Math.max(sa[m-1], sb[n-1]) % mod);
        //     for ( i = 0; i < ia.size(); i++) {
        //         long ca = sa[ia.get(i)] - (i == 0 ? 0 : sa[ia.get(i-1)]);
        //         long cb = sb[ib.get(i)] - (i == 0 ? 0 : sb[ib.get(i-1)]);
        //         max += Math.max(ca, cb);
        //         if (i == ia.size()-1) 
        //             max += Math.max(sa[m-1] - sa[ia.get(i)], sb[n-1] - sb[ib.get(i)]);
        //     }
        //     return (int)(max % mod);
        // }

        // public int maxSumBST(TreeNode root) { // tle
        //     bottomUpTraverse(root);
        //     return max < 0 ? 0 : max;
        // }
        // int max = Integer.MIN_VALUE;
        // private void bottomUpTraverse(TreeNode r) { // 以前什么时候写的忘记了，这个题再想想，怎么把分开的每个node遍历合并成可剪枝的一次系统性遍历 ？
        //     if (r == null) return ;
        //     bottomUpTraverse(r.left);
        //     bottomUpTraverse(r.right);
        //     Rn cur = traverse(r);
        //     if (cur.bst) max = Math.max(max, cur.sum);
        // }
        // private Rn traverse(TreeNode r) {
        //     if (r == null) return null;
        //     if (r.left == null && r.right == null) 
        //         return new Rn(r.val, true, r.val, r.val);
        //     Rn left = traverse(r.left);
        //     Rn right = traverse(r.right);
        //     if (left == null || right == null) {
        //         return new Rn((left == null ? right.sum : left.sum) + r.val,
        //                       left == null ? right.bst && right.min > r.val : left.bst && left.max < r.val,
        //                       Math.min(r.val, (left == null ? right.min : left.min)),
        //                       Math.max(r.val, (left == null ? right.max : left.max)));
        //     }
        //     return new Rn(left.sum + right.sum + r.val,
        //                   left.bst && right.bst && r.val > left.max && r.val < right.min,
        //                   Math.min(r.val, Math.min(left.min, right.min)),
        //                   Math.max(r.val, Math.max(left.max, right.max)));
        // }
        // public class Rn {
        //     int sum;
        //     boolean bst;
        //     int min, max;// from left
        //      public Rn(int a, boolean b, int c, int d) {
        //         sum = a;
        //         bst = b;
        //         min = c;
        //         max = d;
        //     }
        // }

        // public int minimumIncompatibility(int[] a, int k) { // bug
        //     n = a.length;
        //     dp = new TreeSet [k];
        //     for (int i = 0; i < k; i++) 
        //         dp[i] = new TreeSet<>();
        //     Arrays.sort(a);
        //     // System.out.println(Arrays.toString(a));
        //     dfs(n-1, 0, a, k);
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }
        // TreeSet<Integer> [] dp;
        // int n, min = Integer.MAX_VALUE;
        // private void dfs(int idx, int sum, int [] a, int k) {
        //     if (sum >= min) return ; // 裁枝
        //     if (idx < 0) {
        //         min = sum;
        //         return ;
        //     }
        //     for (int i = 0; i < k; i++) {
        //         if (dp[i].contains(a[idx])) continue;
        //         int last = dp[i].size() > 0 ? dp[i].last() : 0;
        //         dp[i].add(a[idx]);
        //         dfs(idx-1, sum + (last == 0 ? 0 : last - a[idx]), a, k);
        //         dp[i].pollLast();
        //     }
        // }

        // public int cherryPickup(int[][] gd) { // bug: 想的是类似于cherry pickup II两条路线同时走的最大值
        //     m = gd.length;
        //     n = gd[0].length;
        //     dp = new int [m][n][m]; // dp[i][j][x]: 一个机器人的坐标[i,j]和另一个机器人的坐标[x, y] i+j == x+y
        //     return dfs(0, 0, gd);
        // }
        // int [][][] dp;
        // int m, n;
        // private int dfs(int i, int j, int k, int [][] a) {
        //     if (i == m-1 && j == n-1) return a[m-1][n-1] + a[k][m+n-2-k];
        //     if (x < 0 || x >= m || y < 0 || y >= n)
        //     if (dp[i][j] > 0) return dp[i][j];
        // }

        // public int minAbsDifference(int[] a, int goal) {
        //     int n = a.length, idx = 0, min = Integer.MAX_VALUE;
        //     int [] left = Arrays.copyOfRange(a, 0, n/2); // [0, n/2)
        //     int [] right = Arrays.copyOfRange(a, n/2, n);
        //     Set<Integer> lsum = new HashSet<>();
        //     getSum(0, 0, left, lsum);
        //     Set<Integer> rsum = new HashSet<>();
        //     getSum(0, 0, right, rsum);
        //     int [] list = new int [lsum.size()];
        //     for (Integer v : lsum) list[idx++] = v;
        //     Arrays.sort(list);
        //     for (Integer v : rsum) {
        //         int rv = binarySearch(list, goal - v);
        //         min = Math.min(min, Math.abs(rv + v - goal));
        //     }
        //     return min;
        // }
        // private int binarySearch(int [] a, int v) { // todo: 这里写得有些乱
        //     if (v <= a[0]) return a[0];
        //     if (v >= a[a.length-1]) return a[a.length-1];
        //     int l = 0, r = a.length-1;
        //     while (l <= r) {
        //         int m = l + (r - l) / 2;
        //         if (a[m] == v) return a[m];
        //         if (a[m] < v && m < r && a[m+1] > v)
        //             return Math.abs(a[m] - v) < Math.abs(a[m+1] - v) ? a[m] : a[m+1];
        //         else if (a[m] > v && m > l && a[m-1] < v)
        //             return Math.abs(a[m] - v) < Math.abs(a[m-1] - v) ? a[m] : a[m-1];
        //         else if (a[m] < v) l = m+1;
        //         else r = m-1;
        //     }
        //     return a[l];
        // }
        // private void getSum(int i, int sum, int [] a, Set<Integer> ss) {
        //     if (i == a.length) {
        //         ss.add(sum);
        //         return ;
        //     }
        //     getSum(i+1, sum + a[i], a, ss);
        //     getSum(i+1, sum, a, ss);
        // }

        // public int calculateMinimumHP(int[][] g) { // 有个bug: 如果过程中因为power up而获得能量，还需要纪录过程中一度出现过的最小值才对
        //     int m = g.length, n = g[0].length;
        //     int [][] f = new int [m][n];
        //     int [][] dirs = {{1, 0}, {0, 1}};
        //     f[0][0] = g[0][0];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             for (int [] d : dirs) {
        //                 int x = i + d[0], y = j + d[1];
        //                 if (x < 0 || x >= m || y < 0 || y >= n) continue;
        //                 f[x][y] = Math.max(f[x][y], f[i][j] + g[x][y]);
        //             }
        //     return Math.abs(f[m-1][n-1]) + 1;
        // }
        // public int calculateMinimumHP(int[][] g) { // 有个bug: 如果过程中因为power up而获得能量，还需要纪录过程中一度出现过的最小值才对
        //     m = g.length;
        //     n = g[0].length;
        //     // f = new int [m][n];
        //     dfs(0, 0, 0, 0);
        //     return 
        // }
        // int m, n, gmin = Integer.MAX_VALUE;
        // // int [][] f;
        // private void dfs(int i, int j, int sum, int locMin) {
        //     if (i == m-1 && j == n-1) {
        //         if (sum < 0 && (gmin < sum || locMin))
        //     }
        // }

        // public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //     if (startFuel >= target) return 0;
        // }

        // public String largestMultipleOfThree(int[] d) {
        //     int [] sorted = Arrays.stream(d).boxed()
        //         .sorted(Comparator.reverseOrder()) // just use 'sorted()' for ascending order
        //         .mapToInt(Integer::intValue).toArray();
        //     System.out.println(Arrays.toString(sorted));
        //     int sum = Arrays.stream(d).sum();
        //     return "";
        // }

        // public int scoreOfStudents(String t, int[] a) {
        //     int answer = getAns(t);
        //     n = t.length();
        //     this.t = t;
        //     this.s = t.toCharArray();
        //     dp = new Set[n][n];
        //     Set<Integer> candi = dfs(0, n-1);
        //     // Set<Integer> candi = generateAllPossCandiAns(s); // tle
        //     int ans = 0;
        //     for (Integer v : a) 
        //         if (v == answer) ans += 5;
        //         else if (candi.contains(v)) ans += 2;
        //     return ans;
        // }
        // Set<Integer> [][] dp;
        // String t;
        // char [] s;
        // int n;
        // private Set<Integer> dfs(int i, int j) {
        //     if (dp[i][j] != null) return dp[i][j];
        //     dp[i][j] = new HashSet<>();
        //     if (i == j) {
        //         dp[i][j].add(s[i] - '0');
        //         return dp[i][j];
        //     }
        //     // String cur = t.substring(i, j+1); // 这部分可以不要的
        //     // if (cur.indexOf("+") == -1 && cur.indexOf("*") == -1)
        //     //     return dp[i][j] = new HashSet<>(List.of(Integer.parseInt(cur)));
        //     Set<Integer> ans = new HashSet<>();
        //     for (int k = i+1; k < j; k++) 
        //         if (s[k] == '+' || s[k] == '*') {
        //             Set<Integer> l = dfs(i, k-1);
        //             Set<Integer> r = dfs(k+1, j);
        //             for (Integer vl : l) 
        //                 for (Integer vr : r) {
        //                     int v = s[k] == '+' ? vl + vr : vl * vr;
        //                     if (v >= 0 && v <= 1000) ans.add(v); // 把题目这个限制条件看丢了 
        //                 }
        //         }
        //     return dp[i][j] = ans;
        // }
        // private int getAns(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     ArrayDeque<Integer> st = new ArrayDeque<>(); // 原生函数可以优化效率
        //     for (int i = 0; i < n; i++) {
        //         if (Character.isDigit(s[i])) {
        //             int j = i+1;
        //             while (j < n && Character.isDigit(s[j])) j++;
        //             st.push(Integer.parseInt(t.substring(i, j)));
        //             i = j-1;
        //         } else if (s[i] == '*') {
        //             int j = i+1;
        //             while (j < n && Character.isDigit(s[j])) j++;
        //             int ans = st.pop() * Integer.parseInt(t.substring(i+1, j));
        //             st.push(ans);
        //             i = j-1;
        //         }
        //     }
        //     int ans = 0;
        //     while (!st.isEmpty()) ans += st.pop();
        //     return ans;
        // }
        // private Set<Integer> generateAllPossCandiAns(String t) { // 不长记性，木有记忆！！！ 第二次三次》？
        //     int n = t.length();
        //     if (n == 0) return new HashSet<>();
        //     if (t.indexOf("+") == -1 && t.indexOf("*") == -1) return new HashSet<>(List.of(Integer.parseInt(t)));
        //     char [] s = t.toCharArray();
        //     Set<Integer> ans = new HashSet<>();
        //     for (int i = 0; i < n; i++) 
        //         if (s[i] == '+' || s[i] == '*') {
        //             Set<Integer> left = generateAllPossCandiAns(t.substring(0, i));
        //             Set<Integer> right = generateAllPossCandiAns(t.substring(i+1));
        //             for (Integer l : left) 
        //                 for (Integer r : right) {
        //                     if (s[i] == '+') ans.add(l + r);
        //                     else ans.add(l * r);
        //                 }
        //         }
        //     return ans;
        // }

        // public boolean splitArraySameAverage(int [] a) {
        //     int n = a.length, sum = Arrays.stream(a).sum();
        //     System.out.println("sum: " + sum);
        //     System.out.println("(double)sum / n: " + (double)sum / n);
        //     return true;
        // }

        public int minimumDifference(int[] a) {
            int n = a.length, sum = Arrays.stream(a).sum(), target = sum / 2;
            int [] left = Arrays.copyOfRange(a, 0, n/2);
            int [] right = Arrays.copyOfRange(a, n/2, n);
            lsum = getAllPosssSums(left);
            rsum = getAllPosssSums(right);
            int ans = sum;
            for (int i = 1; i < n/2; i++) 
                for (Integer l : lsum.get(i)) 
                    for (Integer r : rsum.get(n/2-i))
                        ans = Math.min(ans, Math.abs(l + r - target));
            return ans;
        }
        Map<Integer, Set<Integer>> lsum;
        Map<Integer, Set<Integer>> rsum;
        private Map<Integer, Set<Integer>> getAllPosssSums(int [] a) {
            int n = a.length, r = 1 << n;
            Map<Integer, Set<Integer>> m = new HashMap<>();
            // m.put(0, new HashSet<>());
            for (int i = 1; i < r; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) 
                    if (((i >> j) & 1) == 1)
                        sum += a[j];
                m.computeIfAbsent(Integer.bitCount(i), z -> new HashSet<>()).add(sum);
            }
            return m;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [] a = new int [] {1,2,3,4,5,6,7,8};
        int []  a = new int []  {3, 9, 7, 3};

        int r = s.minimumDifference(a);
        System.out.println("r: " + r);
    }
}

// int []  a = new int []  {1, 4, 3, 2, 4, 2, 5, -1, -1, -1, -1, -1, -1, 4, 6};
// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
        
// int r = s.maxSumBST(root);
// System.out.println("r: " + r);
