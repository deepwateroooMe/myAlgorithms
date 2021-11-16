import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class dpfour {
    public static class Solution {
    
        public class Trie {
            private class Node {
                boolean end;
                Node [] next;
                public Node () {
                    end = false;
                    next = new Node [26];
                }
            }
            private Node root;
            public Trie () {
                root = new Node();
            }
            public void insert(String t) {
                Node r = root;
                char [] s = t.toCharArray();
                for (int i = 0; i < t.length(); i++) {
                    if (r.next[s[i]-'a'] == null)
                        r.next[s[i]-'a'] = new Node();
                    r = r.next[s[i]-'a'];
                }
                r.end = true;
            }
            public boolean search(String t) {
                int n = t.length();
                char [] s = t.toCharArray();
                Node r = root;
                for (int i = 0; i < n; i++) {
                    if (r.next[s[i]-'a'] == null) return false;
                    r = r.next[s[i]-'a'];
                }
                return r.end;
            }
        }
        private boolean difByOne(String ss, String tt) {
            if (ss.length() != tt.length()) return false;
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            int cnt = 0;
            for (int i = 0; i < ss.length(); i++) 
                if (s[i] != t[i]) {
                    ++cnt;
                    if (cnt > 1)
                        return false;
                }
            return cnt == 1;
        }
        public int countSubstrings(String s, String t) {
            int m = s.length(), n = t.length(), ans = 0;
            Map<String, Integer> map = new HashMap<>(); // t's substring may have repeats, need to remember the cnts
            // Trie r = new Trie();
            for (int i = 0; i < n; i++) 
                for (int j = i+1; j <= n; j++) {
                    map.put(t.substring(i, j), map.getOrDefault(t.substring(i, j), 0) + 1);
                    // r.insert(t.substring(i, j));
                }
            for (int i = 0; i < m; i++) 
                for (int j = i+1; j <= m; j++) {
                    String cur = s.substring(i, j);
                    for (String v : map.keySet()) 
                        if (difByOne(v, cur))  ans += map.get(v);
                    // for (int k = 0; k < cur.length(); k++) {
                    //     for (char c = 'a'; c <= 'z'; c++) {
                    //         if (cur.charAt(k) == c) continue;
                    //         String tmp = (k == 0 ? "" : cur.substring(0, k)) + c + (k == cur.length()-1 ? "" : cur.substring(k+1));
                    //         if (r.search(tmp)) ans += map.get(tmp);
                    //     }
                    // }
                }
            return ans;
        }
        public int countSubstrings(String ss, String tt) { // 字符串上的dp要好好熟悉一下
            int m = ss.length(), n = tt.length(), ans = 0;
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            int [][] sam = new int [m][n];
            int [][] dif = new int [m][n];
            for (int i = 0; i < m; i++) { // 初始化
                sam[i][0] = s[i] == t[0] ? 1 : 0;
                dif[i][0] = s[i] == t[0] ? 0 : 1;
            }
            for (int j = 0; j < n; j++) { // 初始化
                sam[0][j] = s[0] == t[j] ? 1 : 0;
                dif[0][j] = s[0] == t[j] ? 0 : 1;
            }
            for (int i = 1; i < m; i++) 
                for (int j = 1; j < n; j++) {
                    if (s[i] == t[j]) { // 字符相同
                        sam[i][j] = sam[i-1][j-1] + 1;
                        dif[i][j] = dif[i-1][j-1]; //  前面的数量跟我组合，以及 单个字符
                    } else dif[i][j] = sam[i-1][j-1] + 1;
                }
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    ans += dif[i][j];
            return ans;
        }
        public int countSubstrings(String ss, String tt) {
            int m = ss.length();
            int n = tt.length();
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            int res = 0, dif = 0;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) {
                    dif = 0;
                    for (int k = i, l = j; k < m && l < n; k++, l++) {
                        if (s[k] != t[l]) {
                            if (dif > 0) break;
                            res++;
                            dif++;
                        } else if (dif == 1) {
                            res++;
                        }
                    }
                }
            return res;
        }

        
        public int numTeams(int[] a) { // 感觉leetcode这种卡时间的方法很坑人。。。。。。
            int n = a.length, ans = 0;
            // for (int i = 0; i < n-2; i++) { 
            //     for (int j = i+1; j < n-1; j++) { 
            for (int i = 0; i < n-2; i++) // 注意这里不需要 -2 -1
                for (int j = i+1; j < n-1; j++) 
                    for (int k = j+1; k < n; k++) {
                        if (a[i] < a[j] && a[j] < a[k] || a[i] > a[j] && a[j] > a[k]) // 这些个条件的比较也会自动过滤重复
                            ans++;
                    }
            return ans;
        }
        public int numTeams(int[] a) { // 出发点是对的，但是还是要去想：到底哪些信息是需要自己统计和纪录的
            int n = a.length, ans = 0;
            for (int i = 1; i < n-1; i++) {
                int lgt = 0, lls = 0;
                for (int j = 0; j < i; j++) {
                    if (a[j] > a[i]) lgt ++;
                    if (a[j] < a[i]) lls ++;
                }
                int rgt = 0, rls= 0;
                for (int j = i+1; j < n; j++) {
                    if (a[j] > a[i]) rgt ++;
                    if (a[j] < a[i]) rls ++;
                }
                ans += lgt * rls + lls * rgt;
            } 
            return ans;
        }

        private void dfs(int [][] a, int x, int y, boolean h, int oy) { // h: horizontal
            if (x == m) {
                ans[oy] = y;
                return ;
            }
// [/  \/  \] 3 return cases
            if (y == 0 && a[x][y] == -1 && !h || y == n-1 && a[x][y] == 1 && !h
                || a[x][y] == 1 && y < n-1 && a[x][y+1] == -1 && !h
                || a[x][y] == -1 && y > 0 && a[x][y-1] == 1 && !h) {
                ans[oy] = -1;
                return;
            }
            if (!h) { // move horizontally
                if (y < n-1 && a[x][y] == 1) dfs(a, x, y+1, true, oy);
                if (y > 0 && a[x][y] == -1) dfs(a, x, y-1, true, oy);
            } else  // mover vertically
                dfs(a, x+1, y, false, oy);
        }
        int [] ans;
        int m, n;
        public int[] findBall(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            ans = new int [n];
            for (int i = 0; i < n; i++) 
                dfs(grid, 0, i, false, i);
            return ans;
        }

        public double nthPersonGetsNthSeat(int n) { // bug 
            if (n == 1) return 1;
            double [] dp = new double [n+1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) 
                dp[i] = dp[i-1] * 0.5;
            return dp[n];
        }

        public int maxProfit(int[] p, int fee) {
            int n = p.length;
            int [] sold = new int [n];
            int [] hold = new int [n];
            hold[0] = -p[0]; // 因为买进投资了，还没有产出，所以是负数
            for (int i = 1; i < n; i++) {
                sold[i] = Math.max(p[i] + hold[i-1] - fee, sold[i-1]); // 卖或不卖
                hold[i] = Math.max(sold[i-1] - p[i], hold[i-1]);       // 买或不买
            }
            return Math.max(hold[n-1], sold[n-1]);
        }

        public int maxProfit(int[] p) { // bug
            int n = p.length;
            int [] sold = new int [n];
            int [] hold = new int [n];
            hold[0] = -p[0]; // 因为买进投资了，还没有产出，所以是负数
            for (int i = 1; i < n; i++) {
                sold[i] = Math.max(p[i] + hold[i-1], (i > 2 ? hold[i-2] : 0)); // 卖或不卖
                hold[i] = Math.max((i > 2 ? sold[i-2] - p[i] : 0), (i > 2 ? sold[i-2] : 0)); // 买或不买: 因为卖完要休息一天，只能是最早前2天的结果
            }
            System.out.println(Arrays.toString(sold));
            System.out.println(Arrays.toString(hold));
            return Math.max(hold[n-1], sold[n-1]);
        }

        public int maxProfit(int[] p) { // bug
            int n = p.length, lmin = 0, lmax = 0, gmax = 0;
            int [] l = new int [n];
            int [] r = new int [n];
            lmin = p[0];
            lmax = p[0];
            for (int i = 1; i < n; i++) {
                 System.out.println("\n i: " + i);
                if (p[i] < lmin) {
                    gmax = Math.max(gmax, lmax - lmin);
                    lmin = p[i];
                    lmax = 0;
                } else {
                    lmax = Math.max(lmax, p[i]);
                    gmax = Math.max(gmax, lmax - lmin);
                }
                l[i] = gmax;
                 System.out.println(Arrays.toString(l));
            }
            lmin = p[n-1];
            lmax = p[n-1];
            gmax = 0;
            for (int i = n-2; i >= 0; i--) {
                 System.out.println("\n i: " + i);
                if (p[i] < lmin) {
                    lmin = Math.min(lmin, p[i]);
                    gmax = Math.max(gmax, lmax - lmin);
                    lmax = 0;
                } else {
                    gmax = Math.max(gmax, lmax - lmin);
                    lmax = Math.max(lmax, p[i]);
                    // lmin = 0;
                }
                r[i] = gmax;
                // System.out.println("lmax: " + lmax);
                // System.out.println("lmin: " + lmin);
                //  System.out.println("r[i]: " + r[i]);
                //  System.out.println(Arrays.toString(r));
            }
            gmax = 0;
            for (int i = 1; i < n; i++) 
                gmax = Math.max(gmax, l[i] + r[i]);
            return gmax;
        }

        public int minimumDeleteSum(String ss, String tt) { // 字符串中的dp还是需要再多熟悉 712
            int m = ss.length(), n = tt.length();
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            int [][] dp = new int [m+1][n+1]; // 设 dp[i][j] 表示 s1[:i] 和 s2[:j] 中删除元素之后相等所累积的 ASCII 码的总和
            // 初始化 dp[i][0] = sum(s1[:i]), 即 s1 的 ASCII 码前缀和, dp[0][j] = sum(s2[:j]), 即 s1 的 ASCII 码前缀和
            for (int i = 1; i <= m; i++) 
                dp[i][0] = dp[i-1][0] + s[i-1];
            for (int j = 1; j <= n; j++) 
                dp[0][j] = dp[0][j-1] + t[j-1];
            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n; j++) 
                    if (s[i-1] == t[j-1]) dp[i][j] = dp[i-1][j-1];
                    else dp[i][j] = Math.min(dp[i-1][j] + s[i-1], dp[i][j-1] + t[j-1]);
            return dp[m][n];
        }

        public int getKth(int lo, int hi, int k) { 
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = lo; i <= hi; i++) {
                if (m.containsKey(i)) continue;
                int cnt = 0, cur = i;
                while (cur > 1) {
                    if (cur % 2 == 0) cur /= 2;
                    else cur = cur * 3  + 1;
                    if (cur == 1) break;
                    // if (m.containsKey(cur)) { // ? bug: why these would cauase a bug ?
                    //     cnt += m.get(cur);
                    //     break;
                    // }
                    cnt++;
                }
                m.put(i, cnt);
            }
            List<List<Integer>> l = new ArrayList<>();
            m.forEach((key, v)-> { 
                    l.add(List.of(key, v));
                });
            Collections.sort(l, (a, b)->a.get(1) != b.get(1) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));
            return l.get(k-1).get(0);
        }

        public int minCost(String t, int[] cost) {
            int n = t.length(), i = 0, ans = 0;
            char [] s = t.toCharArray();
            while (i < n-1 && s[i+1] != s[i]) i++;
            if (i == n) return 0;
            int max = cost[i], sum = cost[i];
            while (i < n-1) {
                while (i < n-1 && s[i] == s[i+1]) {
                    max = Math.max(max, cost[i+1]);
                    sum += cost[i+1];
                    i++;
                }
                ans += (sum - max);
                if (i == n-1) return ans;
                sum = 0;
                while (i < n-1 && s[i] != s[i+1]) i++;
                sum = cost[i];
                max = cost[i];
            }
            return ans;
        }
        public int minCost(String t, int[] cost) {
            char [] s = t.toCharArray();
            int minCost = 0;
            int i = 0;
            while (i < t.length() -1) {
                if (s[i] == s[i+1]) {
                    minCost = minCost + Math.min(cost[i], cost[i+1]);
                    if (cost[i+1] < cost[i]) // 把相临字母中代价较高的那一个保留为局部最大值，从而累加较小值
                        cost[i+1] = cost[i];
                }
                i++;
            }
            return minCost;
        }

        public int minHeightShelves(int[][] books, int shelfWidth) {
            int n = books.length;
            int [] dp = new int [n];
            dp[0] = books[0][1];
            for (int i = 2; i < n; i++) {
            }
        }
        
        public long countVowels(String t) {
            long n = t.length();
            char [] s = t.toCharArray();
            Set<Character> sc = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
            long ans = 0;
            for (long i = 0; i < n; i++)
                if (sc.contains(s[i]))
                    ans += (i+1)*(n-i);
            return ans;
        }

        private int dfs(int [] a, int i, int j) { // 没有搞明白这个题目的划分到底是怎么回事，以及终止条件
            System.out.println("\n i: " + i);
            System.out.println("j: " + j);
            // if (i == j) return a[i];
            if (j - i == 2) return dp[i][j] = a[i] * a[i+1] * a[j];
            if (j - i == 3) return dp[i][j] = Math.min(a[i] * a[i+1] * a[i+2] + a[i] * a[j-1] * a[j],
                                                       a[i] * a[i+1] * a[j] + a[i+1] * a[j-1] * a[j]);
            // if (i > j) return 0;
            if (dp[i][j] > 0) return dp[i][j];
            int ans = Integer.MAX_VALUE;
            for (int k = i+1; k < j; k++) {
                System.out.println("\n k: " + k);
                System.out.println("a[k]: " + a[k]);
                ans = Math.min(ans, a[i]*a[k]*a[j] + dfs(a, i, k) + dfs(a, k, j));
                System.out.println("ans: " + ans);
            }
            dp[i][j] = ans;
            return ans;
            // return dp[i][j] = ans;
        }
        int [][] dp;
        int n;
        public int minScoreTriangulation(int[] a) {
            n = a.length;
            dp = new int [n][n];
            return dfs(a, 0, n-1);
        }

        public int findLength(int[] a, int[] b) { // 这个题没想透 bug bug bug
            int m = a.length, n = b.length;
            int [][] dp = new int [m+1][n+1];
            for (int j = 1; j <= n; j++)
                if (a[0] == b[j-1]) dp[0][j] = 1;
                else dp[0][j] = dp[0][j-1];
            for (int i = 1; i <= m; i++) 
                if (a[i-1] == b[0]) dp[i][0] = 1;
                else dp[i][0] = dp[i-1][0];
            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n; j++) {
                    if (a[i-1] == b[j-1] && (i == 1 && j == 1 || i >= 2 && j >= 2 && a[i-2] == b[j-2]))
                        dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            System.out.println("dp.length: " + dp.length);
            for (int z = 0; z < dp.length; ++z) 
                System.out.println(Arrays.toString(dp[z]));
            return dp[m][n];
        }
        public int findLength(int[] a, int[] b) { 
            int m = a.length, n = b.length, max = 0;
            int [][] dp = new int [m+1][n+1];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) {
                    if (a[i] == b[j])
                        dp[i+1][j+1] = dp[i][j] + 1;
                    // else dp[i+1][j+1] = Math.max(dp[i+1][j+1], max); // bug: 无效的，不用更新状态，default = 0
                    max = Math.max(max, dp[i+1][j+1]);
                }
            return max;
        }

        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) return 1;
            if (n == 1) return 10;
            int [] dp = new int [n+1];
            dp[1] = 10;
            int cur = 1;
            for (int i = 2; i <= n; i++) {
                cur = 9;
                for (int j = 9-i+2; j <= 9; j++) 
                    cur *= j;
                dp[i] = cur;
            }
            return Arrays.stream(dp).sum();
        }

        private int binarySearch(int [] a, int l, int r, int v) { 
            while (l <= r) {
                int m = (l+r) / 2;
                if (a[m] == v) return m;
                if (a[m] > v) r = m-1;
                else l = m + 1;
            }
            return -1;
        }
        public int lenLongestFibSubseq(int[] a) { // tle 
            int n = a.length, max = 0;
            int [] dp = new int [n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                if (i + max > n) break;
                for (int j = i+1; j < n; j++) {
                    Arrays.fill(dp, 1);
                    int next = a[i] + a[j];
                    int idx = binarySearch(a, j+1, n-1, next);
                    int k = j;
                    if (idx != -1) dp[k] = Math.max(dp[k], dp[i]+1);
                    while (idx != -1) {
                        dp[idx] = Math.max(dp[idx], dp[k]+1);
                        max = Math.max(max, dp[idx]);
                        next = a[k] + a[idx];
                        k = idx;
                        idx = binarySearch(a, idx+1, n-1, next);
                    }
                }
            }
            return max;
        }

        private int dfs(int [] a, int i, int j) { // i: idx, j: k
            if (i == n) return 0;
            if (j == 1)  return dp[i][j] = max[i] * (n - i) - (sum[n-1] - (i == 0 ? 0 : sum[i-1]));
            if (dp[i][j] > 0) return dp[i][j];
            int min = max[i] * (n-i) - (sum[n-1] - (i == 0 ? 0 : sum[i-1]));
            for (int k = i; k < n; k++) { // 中间resize一段的界限要如何确定呢？
            }
        }
        int [][] dp;
        int [] sum;
        int [] max;
        int n;
        public int minSpaceWastedKResizing(int[] a, int k) {
            if (k == 0) return max[0] * n - sum[n-1];
            n = a.length;
            dp = new int [n][k+1];
            sum = Arrays.copyOf(a, n);
            for (int i = 1; i < n; i++) sum[i] += sum[i-1];
            int curMax = a[n-1];
            max[n-1] = a[n-1];
            for (int i = n-2; i >= 0; i--) {
                curMax = Math.max(curMax, a[i]);
                max[i] = curMax;
            }
            return dfs(a, 0, k);
            // int [][] dp = new int [n][k+1];
            // dp[n-1][0] = Arrays.stream(a).max().getAsInt() * n - Arrays.stream(a).sum();
            // for (int i = n-1; i >= 0; i--) {
            //     for (int j = 1; j <= k; j++) {
            //     }
            // }
        }

        public int firstDayBeenInAllRooms(int[] nextVisit) { // bug
            int n = nextVisit.length;
            int [] dp = new int [n];
            dp[0] = 0;
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i-1] + nextVisit[i-1] + 1;
            }
        }
        
        public boolean checkValidString(String t) {
            if (t.charAt(0) == ')') return false;
            int n = t.length();
            if (n == 1 && t.charAt(0) != '*') return false;
            // t = preprocess(t);
            ArrayDeque<Character> st = new ArrayDeque<>();
            while (t.startsWith("()") || t.startsWith("*)")) t = t.substring(2);
            n = t.length();
            char [] s = t.toCharArray();
            for (int i = 0; i < n; i++) {
                if (s[i] != ')') st.push(s[i]);
                else if (s[i] == ')' && !st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else if (s[i] == ')' && st.isEmpty()) return false;
                else if (s[i] == ')') st.push(s[i]);
            }
            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty()) 
                sb.append(st.pop());
            t = sb.reverse().toString();
            System.out.println("t: " + t);
            s = t.toCharArray();
            int l = 0, r = 0, i = 0, j = 0;
            // while (i < n && s[i] != '*') {
            //     if (s[i] == '(') l++;
            //     else r++;
            //     if (r > l) return false;
            //     i++;
            // }
            while (i < n && s[i] != '*') i++;
            // if (i == n && l == r) return true;
            if (i == n) return false;
            if (s[i] == '*') {
                String base = t.substring(0, i);
                // if (l > r) base = "(".repeat(l-r);
                if (checkValidString(base + t.substring(i+1))) return true; 
                if (checkValidString(base + "(" + t.substring(i+1))) return true;
                if (checkValidString(base + ")" + t.substring(i+1))) return true;
                return false;
            }
            return false;
        }

        private void backtracking(int [] a, int limit, int idx, List<Integer> list) { // 说明对回溯的原理理解得不够透彻
            if (list.size() >= ans) return;
            if (idx < 0) {
                if (sum == list.stream().collect(Collectors.summingInt(Integer::intValue))) // 这个前提条件一定不能忘记
                    ans = list.size();
                return;
            }
            // for (int i = idx; i >= 0; i--) { // 画蛇添足： 第三次！！！
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j) + a[idx] > limit) continue;
                        if (j > 0 && list.get(j) == list.get(j-1)) continue;
                        list.set(j, list.get(j) + a[idx]);
                        backtracking(a, limit, idx-1, list);
                        list.set(j, list.get(j) - a[idx]);
                    }
                    list.add(a[idx]);
                    backtracking(a, limit, idx-1, list);
                    list.remove(list.size()-1); // backtracking: 这里是需要回缩的
                // 
            // }
        }
        // boolean [] vis; // 全排列的时候用vis，顺序遍历应该不用 
        int n, ans, sum;
        public int minSessions(int[] tasks, int sessionTime) {
            n = tasks.length;
            ans = n;
            Arrays.sort(tasks);
            sum = Arrays.stream(tasks).sum();
            // vis = new boolean[n];
            backtracking(tasks, sessionTime, n-1, new ArrayList<>());
            return ans;
        }

        要点一：怎么求解某课程的最快完成时间
          要知道课程编号为k的最快完成时间，我们就得求它的所有前置课程的最快完成时间，递归求解即可，当某课程没有前置课程，那么它的最快完成时间就是time[k]
        要点二：怎么遍历
          从出度为0的节点，即没有后续课程的节点，开始递归，再递归过程中可以
        Map<Integer, List<Integer>> map = new HashMap<>(); // key：某课程 value：某课程对应的所有先修课
        Map<Integer,Integer> minMap = new HashMap<>();     // key：某课程 value：最小完成时间，记忆化处理
        public int minimumTime(int n, int[][] relations, int[] time) {
            boolean [] start = new boolean [n+1]; // 用于标记出度为0的节点，从这些节点开始遍历
            Arrays.fill(start, true);
            for (int i = 0; i < relations.length; i++) {
                start[relations[i][0]] = false;
                map.computeIfAbsent(relations[i][1], z -> new ArrayList<>()).add(relations[i][0]);
            }
            int res = 0;
            for (int i = 1; i <= n; i++) 
                if (start[i]) // 从出度为0的节点，即没有后续课程的节点，开始遍历
                    res = Math.max(res, minTime(i, time));
            return res;
        }
        private int minTime(int k, int [] time) { // 完成课程k所需的最小时间
            if (minMap.containsKey(k)) return minMap.get(k); // 如果之前有结果了就直接返回
            int res = time[k-1]; // 初始化为课程k所需时间
            List<Integer> pre = map.get(k);
            if (pre != null) { // 如果课程k有前置课程，加上所有前置课程都上完的最早时间
                int t = 0;
                for (int i = 0; i < pre.size(); i++) 
                    t = Math.max(t, minTime(pre.get(i), time));
                res += t;
            }
            minMap.put(k, res);
            return res;
        }
        课程的依赖关系上是一张图。对于任意一门课，该课程的最早完成事件＝前置课程的最晚完成时间+当前课程的事件，所以该问题可以转换为求最短路径的问题。只不过求最短路径是长度更小的时候更新并加入队列，该问题则是时间更长的时候更新并加入队列。
        public int minimumTime(int n, int[][] relations, int[] time) { // 感觉这个思路理简洁一点儿，可是效率不如上面的方法
            int [] dis = new int[n];
            List<Integer> [] g = new ArrayList[n];
            for (int i = 0; i < n; i++) 
                g[i] = new ArrayList<>();
            for (int [] r : relations) {
                int u = r[0] - 1, v = r[1] - 1;
                dis[v] = -1; // 意味着有依赖的前置课程
                g[u].add(v);
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) 
                if (dis[i] == 0) { // 所有不依赖前置课程的课程时间更新为本身花费的时间并且加入队列
                    dis[i] = time[i];
                    q.offer(i);
                }
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (Integer v : g[cur]) 
                    if (dis[v] < dis[cur] + time[v]) { // 如果花费的时间更多，就更新时间并加入队列
                        dis[v] = dis[cur] + time[v];
                        q.offer(v);
                    }
            }
            return Arrays.stream(dis).max().getAsInt();
        }

        public int longestDecomposition(String t) { // 土方法：要找些真正涉及算法的答案再参考一下
            if (t == null || t.length() == 0) return 0;
            int n = t.length();
            if (n == 1) return 1;
            if (t.chars().distinct().count() == 1) return n;
            char [] s = t.toCharArray();
            List<Integer> ids = new ArrayList<>();
            for (int i = 0; i < n-1; i++) 
                if (s[i] == s[n-1]) ids.add(i);
            if (ids.size() == 0) return 1;
            int max = 1;
            for (Integer idx : ids) 
                if (t.endsWith(t.substring(0, idx+1)) && n >= (idx+1)*2) {
                    max = Math.max(max, 2 + longestDecomposition(t.substring(idx+1, n-(idx+1))));
                    if ((idx + 1) * 2 == t.length())
                        break;
                }
            return max;
        }

        public int countVowelPermutation(int n) {
            Map<Character, Integer> idx = new HashMap<>();
            idx.put('a', 0);
            idx.put('e', 1);
            idx.put('i', 2);
            idx.put('o', 3);
            idx.put('u', 4);
            Map<Integer, List<Character>> m = new HashMap<>();
            m.put(0, List.of('e'));
            m.put(1, List.of('a', 'i'));
            m.put(2, List.of('a', 'e', 'o', 'u'));
            m.put(3, List.of('i', 'u'));
            m.put(4, List.of('a'));
            int mod = (int)1e9 + 7;
            int [][] dp = new int [n][5];
            for (int i = 0; i < 5; i++) 
                dp[0][i] = 1;
            for (int i = 1; i < n; i++) 
                for (int j = 0; j < 5; j++) {
                    if (dp[i-1][j] == 0) continue;
                    for (char c : m.get(j)) 
                        dp[i][idx.get(c)] = (dp[i][idx.get(c)] + dp[i-1][j]) % mod;
                }
            long ans = 0;
            for (int i = 0; i < 5; i++) 
                ans = (ans + dp[n-1][i]) % mod;
            return (int)ans;
        }

        public int findNumberOfLIS(int[] a) {
            int n = a.length;
            int [] dp = new int [n];
            Arrays.fill(dp, 1);
            int [] cnt = new int [n];
            int max = 0, maxIdx = -1;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    System.out.println("\n i: " + i);
                    System.out.println("j: " + j);
                    if (a[j] > a[i]) {
                        dp[j] = Math.max(dp[j], dp[i]+1);
                        if (dp[j] == dp[i]+1)
                            cnt[j]++;
                        // cnt[j] += cnt[i];
                    }
                }
                if (dp[i] > max) {
                    max = dp[i];
                    maxIdx = i;
                }
                System.out.println(Arrays.toString(dp));
                System.out.println(Arrays.toString(cnt));
            }
            return cnt[maxIdx] - 1;
        }

        public int cherryPickup(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int [][][] dp = new int [m][n][n];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    Arrays.fill(dp[i][j], -1);
            dp[0][0][n-1] = grid[0][0] + grid[0][n-1];
            for (int i = 1; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    for (int k = 0; k < n; k++) {
                        if (j == k || dp[i-1][j][k] == -1) continue;
                        for (int x = Math.max(0, j-1); x <= Math.min(n-1, j+1); x++) 
                            for (int y = Math.max(0, k-1); y <= Math.min(n-1, k+1); y++) {
                                if (x == y) continue;
                                dp[i][x][y] = Math.max(dp[i][x][y], dp[i-1][j][k] + grid[i][x] + grid[i][y]);
                            }
                    }
            int max = 0;
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) 
                    max = Math.max(max, dp[m-1][i][j]);
            return max;
        }

        public int maxJumps(int [] a, int d) {
            int n = a.length, j = 0, k = 0, cur = 0;
            int [] dp = new int [n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                for ( j = i+1; j <= Math.min(n-1, i+d); j++) 
                    if (a[i] <= a[j]) break;
                dp[i] = Math.max(dp[i], b) // 没想清楚
            }
        }

        int [][][] dp; // tle: 应该是对重复字母的处理久缺，需要把这个bug解决了 todo 
        int n;
        // 思路：记忆化搜索，top down dp，两个手指move，可以写一个cost function计算两个点的cost，这个没有问题，那么问题转换成下一个move由谁来完成，cost分别是多少。
        // top down就是最后一步，如果由左边完成，cost + dfs(左边)， 由右边完成，cost + dfs(右边）
        // 建立一个三维的dp，[leftindex][rightindex][pos in word]来标记计算过的结果；Time ( n * 27 ^ 2); Space ( n * 27 ^ 2);
        public int minimumDistance(String t) { // 需要一个三维的状态来表示整个动态规划的过程，包括当前考虑的字母下标，左指的键位，右指的键位。
            n = t.length();
            dp = new int [27][27][n]; // 27，只是为了char为null的时候，index可以包含null的情况，设置为0；
            return dfs(t, 0, null, null); // 刚开始设置为null，这样两个指头走上第一char的时候，cost 会return 0；
        }
    https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/discuss/1435135/Simple-Solution-Java-DFS-memorization
        private int dfs(String t, int idx, Character a, Character b) { // 想要输入位置在idx的字符时，两手指的位置分别指向a b
            if (idx == n) return 0;
            int i = a == null ? 0 : a - 'A' + 1;
            int j = b == null ? 0 : b - 'A' + 1;
            if (dp[i][j][idx] != 0) return dp[i][j][idx];
            int k = t.charAt(idx) - 'A' + 1;
            return dp[i][j][idx] = Math.min(cost(i, k) + dfs(t, idx+1, t.charAt(idx), b),
                                            cost(j, k) + dfs(t, idx+1, a, t.charAt(idx)));
        }
        private int cost(int x, int y) {
            if (x == 0 || y == 0) return 0;
            int i = (x-1) / 6, j = (x-1) % 6;
            int u = (y-1) / 6, v = (y-1) % 6;
            return Math.abs(i-u) + Math.abs(j-v);
        }
        public int minimumDistance(String word) { // 空间战胜比较高
            int[][][] dp = new int[301][26][26];
            for (int i = 1; i <= 300; i++) 
                for (int j = 0; j < 26; j++) 
                    Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            int ans = Integer.MAX_VALUE;
            char[] ca = word.toCharArray();
            for (int i = 1; i <= word.length(); i++) { // 遍历每个字母
                int v = ca[i - 1] - 'A';     // 遍历上一个阶段左指键位
                for (int l = 0; l < 26; l++) // 遍历上一个阶段右指键位
                    for (int r = 0; r < 26; r++) { // 判断上一个阶段的状态是否存在
                        if (dp[i - 1][l][r] != Integer.MAX_VALUE) {
                            dp[i][v][r] = Math.min(dp[i][v][r], dp[i - 1][l][r] + help(l, v)); // 移动左指
                            dp[i][l][v] = Math.min(dp[i][l][v], dp[i - 1][l][r] + help(r, v)); // 移动右指
                        }
                        if (i == word.length()) {
                            ans = Math.min(ans, dp[i][v][r]);
                            ans = Math.min(ans, dp[i][l][v]);
                        }
                    }
            }            
            return ans;
        }
        public int help(int a, int b) { // 计算距离
            int x = a / 6, y = a % 6;
            int x2 = b / 6, y2 = b % 6;
            return (int)(Math.abs(x - x2)) + (int)(Math.abs(y - y2));
        }
        时间复杂度：O(26 * 26 * N)，其中 N 为字符串 word 的长度。
            空间复杂度：O(26 * 26 * 2)
        public int minimumDistance(String word) { // 压缩空间
            int[][][] dp = new int[2][26][26];
            for (int j = 0; j < 26; j++) 
                Arrays.fill(dp[1][j], Integer.MAX_VALUE);
            int ans = Integer.MAX_VALUE;
            char[] ca = word.toCharArray();
            for (int i = 1; i <= word.length(); i++) { // 遍历每个字母
                int v = ca[i - 1] - 'A';     // 遍历上一个阶段左指键位
                for (int l = 0; l < 26; l++) // 遍历上一个阶段右指键位
                    for (int r = 0; r < 26; r++) { // 判断上一个阶段的状态是否存在
                        if (dp[(i-1)%2][l][r] != Integer.MAX_VALUE) {
                            dp[i%2][v][r] = Math.min(dp[i%2][v][r], dp[(i-1) % 2][l][r] + help(l, v)); // 移动左指
                            dp[i%2][l][v] = Math.min(dp[i%2][l][v], dp[(i-1) % 2][l][r] + help(r, v)); // 移动右指
                        }
                        if (i == word.length()) {
                            ans = Math.min(ans, dp[i%2][v][r]);
                            ans = Math.min(ans, dp[i%2][l][v]);
                        }
                    }
                for (int l = 0; l < 26; l++)  // 重新初始化另外一个数组
                    for (int r = 0; r < 26; r++) 
                        dp[(i-1) % 2][l][r] = Integer.MAX_VALUE;
            }            
            return ans;
        }
        public int help(int a, int b) { // 计算距离
            int x = a / 6, y = a % 6;
            int x2 = b / 6, y2 = b % 6;
            return (int)(Math.abs(x - x2)) + (int)(Math.abs(y - y2));
        }
        // 时间复杂度：O(26 * N)O(26∗N)，其中 N 为字符串 word 的长度。
        // 空间复杂度：O(26 * 2)O(26∗2)
        public int minimumDistance(String word) {
            int len = word.length();
            int ans = Integer.MAX_VALUE;
            char[] ca = word.toCharArray();
            int[][] dp = new int[2][26]; // 第一个字母的初始值为 0，从第二个字母开始考虑。
            Arrays.fill(dp[1], Integer.MAX_VALUE);
            for (int i = 2; i <= word.length(); i++) { // 遍历每个字母
                int v = ca[i - 1] - 'A';
                for (int j = 0; j < 26; j++) { // 遍历上一个阶段键位
                    if (dp[i % 2][j] == Integer.MAX_VALUE) continue;
                    int preV = ca[i - 2] - 'A';
                    dp[(i + 1) % 2][j] = Math.min(dp[(i + 1) % 2][j], dp[i % 2][j] + help(preV, v));
                    dp[(i + 1) % 2][preV] = Math.min(dp[(i + 1) % 2][preV], dp[i % 2][j] + help(j, v));
                    if (i == word.length()) {
                        ans = Math.min(ans, dp[(i + 1) % 2][j]);
                        ans = Math.min(ans, dp[(i + 1) % 2][preV]);
                    }
                }
                Arrays.fill(dp[i % 2], Integer.MAX_VALUE);
            }
            return ans;
        }

        private long dfs(int [] a, int end, int f, int bgn) {
        }
        long mod = (int)1e9 + 7;
        long [][] dp;
        int n;
        public int countRoutes(int [] locations, int start, int finish, int fuel) {
            n = locations.length;
            dp = new long [fuel+1][n];
            return (int)dfs(locations, finish, fuel, start);
        }

        public int ways(String[] pizza, int p) { // 自底向上
            int mod = (int)1e9 + 7;
            int m = pizza.length, n = pizza[0].length();
            int [][] cnt = new int [m+1][n+1]; // 苹果数的前缀和，用于快速获得在指定矩阵范围内的苹果数量，两个维度也分别是左上角的x、y
            for (int i = m-1; i >= 0; i--) 
                for (int j = n-1; j >= 0; j--) 
                    cnt[i][j] = cnt[i+1][j] + cnt[i][j+1] - cnt[i+1][j+1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            int [][][] dp = new int [m+1][n+1][p+1]; // 状态数组，三个维度分别表示以x、y为左上角的矩阵中，分给k个人，元素值表示方案数
            for (int i = m-1; i >= 0; i--)       // 遍历矩阵，获取指定左上角矩阵中范围内的苹果数量
                for (int j = n-1; j >= 0; j--) { // 从右下角开始，向左上角开始枚举所有状态
                    if (cnt[i][j] > 0) dp[i][j][1] = 1; // 如果这个范围矩阵内存在苹果，那么这个矩阵肯定可以分给1个人，且方案数为1
                    for (int k = 2; k <= p; k++) {      // 枚举所有人数状态下的方案，前面已经判断了人数为1的状态，所以这里只需要从2开始枚举
                        for (int x = m-1-i; x >= 0; x--)     // 横着切，枚举所有切法
                            if (cnt[i][j] - cnt[i+x][j] > 0) // 如果当前切掉的矩阵内存在苹果，则可以进行状态转移
                                dp[i][j][k] = (dp[i][j][k] + dp[i+x][j][k-1]) % mod;
                        for (int y = n-1-j; y >= 0; y--)     // 竖着切
                            if (cnt[i][j] - cnt[i][j+y] > 0)
                                dp[i][j][k] = (dp[i][j][k] + dp[i][j+y][k-1]) % mod;
                    }
                }
            return (int)dp[0][0][p];
        }
        public int ways(String[] pizza, int p) { // 自顶向下
            int mod = (int)1e9 + 7;
            int m = pizza.length, n = pizza[0].length();
            int [][] cnt = new int [m][n]; // 苹果数的前缀和，用于快速获得在指定矩阵范围内的苹果数量，两个维度也分别是左上角的x、y
            for (int i = 0; i < m; i++) 
                cnt[i][0] = (i == 0 ? 0 : cnt[i-1][0]) + (pizza[i].charAt(0) == 'A' ? 1 : 0);
            for (int j = 0; j < n; j++) 
                cnt[0][j] = (j == 0 ? 0 : cnt[0][j-1]) + (pizza[0].charAt(j) == 'A' ? 1 : 0);
            for (int i = 1; i < m; i++) 
                for (int j = 1; j < n; j++) 
                    cnt[i][j] = cnt[i-1][j] + cnt[i][j-1] - cnt[i-1][j-1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            int [][][] dp = new int [m][n][p+1]; // dp[i][j][k]表示切完k次后，剩余蛋糕左上角 在i,j位置时的方案数
            dp[0][0][0] = 1;
            for (int k = 1; k < p; k++) 
                for (int i = 0; i < m; i++) 
                    for (int j = 0; j < n; j++) {
                        if (dp[i][j][k-1] == 0) continue; //上一次cut完后，剩余蛋糕左上角在i,j
                        for (int x = i+1; x < m; x++) {  // 横向切，切完后的剩余左上角为 x, j
                            int appCnt = cnt[x-1][n-1] - (j > 0 ? cnt[x-1][j-1] : 0) - (i > 0 ? cnt[i-1][n-1] : 0) + (i > 0 && j > 0 ? cnt[i-1][j-1] : 0);
                            if (appCnt > 0)
                                dp[x][j][k] = (dp[x][j][k] + dp[i][j][k-1]) % mod;
                        }
                        for (int y = j+1; y < n; y++) { //竖向切
                            int appCnt = cnt[m-1][y-1] - (i > 0 ? cnt[i-1][y-1] : 0) - (j > 0 ? cnt[m-1][j-1] : 0) + (i > 0 && j > 0 ? cnt[i-1][j-1] : 0);
                            if (appCnt > 0)
                                dp[i][y][k] = (dp[i][y][k] + dp[i][j][k-1]) % mod;
                        }
                    }
            long ans = 0;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) {
                    int appCnt = cnt[m-1][n-1] - (i > 0 ? cnt[i-1][n-1] : 0) - (j > 0 ? cnt[m-1][j-1] : 0) + (i > 0 && j > 0 ? cnt[i-1][j-1] : 0);
                    if (appCnt > 0) ans = (ans + dp[i][j][p-1]) % mod;
                }
            return (int)ans;
        }
        public int ways(String[] pizza, int p) { // 自顶向下: 与自底向上相比
            int mod = (int)1e9 + 7;
            int m = pizza.length, n = pizza[0].length();
            int [][] cnt = new int [m+1][n+1];  // 苹果数的前缀和，用于快速获得在指定矩阵范围内的苹果数量，两个维度也分别是左上角的x、y
            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n; j++) 
                    cnt[i][j] = cnt[i-1][j] + cnt[i][j-1] - cnt[i-1][j-1] + (pizza[i-1].charAt(j-1) == 'A' ? 1 : 0);
            int [][][] dp = new int [m+1][n+1][p]; // dp[i][j][k]表示切完k次后，剩余蛋糕左上角 在i,j位置时的方案数
            dp[1][1][0] = 1; // 初始值是为了程序的运行，
            for (int k = 1; k < p; k++) 
                for (int i = 1; i <= m; i++) 
                    for (int j = 1; j <= n; j++) {
                        System.out.println("(dp[i][j][k-1] == 0) : " + (dp[i][j][k-1] == 0) );
                        if (dp[i][j][k-1] == 0) continue; // 上一次cut完后，剩余蛋糕左上角在i,j
                        for (int x = i+1; x <= m; x++)   // 横向切，切完后的剩余左上角为 x, j
                            if (cnt[x-1][n] - cnt[i-1][n] - cnt[x-1][j-1] + cnt[i-1][j-1] > 0)
                                dp[x][j][k] = (dp[x][j][k] + dp[i][j][k-1]) % mod;
                        for (int y = j+1; y <= n; y++)  // 竖向切
                            if (cnt[m][y-1] - cnt[m][j-1] - cnt[i-1][y-1] + cnt[i-1][j-1] > 0)
                                dp[i][y][k] = (dp[i][y][k] + dp[i][j][k-1]) % mod;
                    }
            long ans = 0;
            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n; j++) 
                    if (cnt[m][n] - cnt[i-1][n] - cnt[m][j-1] + cnt[i-1][j-1] > 0) // 先前并没有确认切的结果有效，即最后剩下的那块是否有苹果
                        ans = (ans + dp[i][j][p-1]) % mod;                         // 统计结果的时候，要先确保有效
            return (int)ans;
        }

        public boolean canIWin(int maxChoosableInteger, int desiredTotal) { // 这个师与其它类假题相比，为什么顺序无关？
            if (desiredTotal == 0) return true; // 如果1到最大能选的值所有和都不能满足目标值，那么肯定失败
            if ((maxChoosableInteger+1) * maxChoosableInteger / 2 < desiredTotal) return false;
            char [] state = new char [maxChoosableInteger];
            for (int i = 0; i < maxChoosableInteger; i++) state[i] = '0';
            return dfs(desiredTotal, state, new HashMap<>());
        }
        private boolean dfs(int sum, char [] st, Map<String, Boolean> map) {
            String key = new String(st);
            if (map.containsKey(key)) return map.get(key);
            for (int i = 0; i < st.length; i++) {
                if (st[i] != '0') continue;
                st[i] = '1';
                if (sum <= i+1 || !dfs(sum - (i+1), st, map)) {
                    map.put(key, true);
                    st[i] = '0';
                    return true;
                }
                st[i] = '0';
            }
            map.put(key, false);
            return false;
        }
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) { // 下面这个效率更高 
            if (desiredTotal <= 0) return true;
            int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
            if (sum < desiredTotal) return false;
            boolean[] vis = new boolean[maxChoosableInteger+1];
            return helper(desiredTotal, vis);
        }
        Map<Integer, Boolean> map = new HashMap<>();
        public boolean helper(int desiredTotal, boolean[] vis) {
            if (desiredTotal <= 0) return false;
            int symbol = format(vis);
            if (map.containsKey(symbol)) return map.get(symbol);
            for (int i = 1 ; i < vis.length ; i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    if (!helper(desiredTotal-i, vis)) {
                        vis[i] = false; // 这里不回复状态会影响其它结果
                        map.put(symbol, true);
                        return true;
                    }
                    vis[i] = false;
                }
            }
            map.put(symbol, false);
            return false;
        }
        public int format(boolean[] vis) {
            int symbol = 0;
            for (boolean select : vis) {
                symbol <<= 1;
                if (select) symbol |= 1;
            }
            return symbol;
        }
        private boolean dfs(int sum, int t, int target, int max) { // 没有体会到这个题与其它类似题的不同，force a win到底是什么意思呢？ bug bug bug
            if (sum >= target) return t % 2 == 0;                   // 感觉思路想得挺清楚的，不知道细节哪里错了，改天再回来写这题
            if (dp[sum][t%2] != null) return dp[sum][t%2];
            boolean res = (t % 2 == 0 ? false : true);
            for (int i = 1; i <= max; i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    boolean tmp = dfs(sum + i, t+1, target, max);
                    if (t % 2 == 0 && tmp)
                        res |= true;
                        // return dp[sum][t%2] = true;
                    else if (t % 2 == 1 && !tmp)
                        res = false;
                        // return dp[sum][t%2] = false;
                    vis[i] = false;
                }
            }
            return dp[sum][t%2] = res;
            // return dp[sum][t%2] = (t % 2 == 0 ? false : true);
        }
        Boolean [][] dp;
        boolean [] vis; // 就是说，这个数组并不能正确记录乘余可以选择的数字的状态
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            dp = new Boolean[desiredTotal+1][2];
            vis = new boolean [maxChoosableInteger + 1];
            return dfs(0, 0, desiredTotal, maxChoosableInteger); // 这里dfs自顶向下方向写反了，另则顺序无关
        }
 
        public int minOperationsToFlip(String t) { // bug: 不知道自己写的错到哪里去了 todo , bug
            int n = t.length();
            s = t.toCharArray();
            ArrayDeque<Integer> st = new ArrayDeque<>();
            for (int i = 0; i < n; i++) 
                if (s[i] == '(') st.push(i);
                else if (s[i] == ')') m.put(i, st.pop());
            int [] res = dfs(0, n-1, t);
            return Math.max(res[0], res[1]); // 有一个必为0
        }
        Map<Integer, Integer> m = new HashMap<>(); // ) ( matched idxes
        char [] s;
        private int [] dfs(int l, int r, String t) { // 返回{表达式为0的最小flip次数， 表达式为1的最小flip次数}
            if (l == r) {
                if (s[l] == 0) return new int [] {0, 1};
                else return new int [] {1, 0} ;
            }
            if (s[r] == ')' && m.get(r) == l)
                return dfs(l+1, r-1, t);
            // expression[r]只能是0，1，）
            // expression[m]只能是｜，&
            int mid = r-1;
            if (s[r] == ')') mid = m.get(r)-1; 
            System.out.println("mid: " + mid);
            int [] left = dfs(l, mid-1, t);
            int [] right = dfs(mid+1, r, t);
            int minCostToOne = 0, minCostToOOO = 0;
            if (s[mid] == '|') {
                minCostToOne = Math.min(left[1], right[1]); // left or right to 1
                minCostToOOO = Math.min(left[0] + right[0], Math.min(left[0], right[0]) + 1); // 0 | 0 or 0 & 1 or 1 & 0
            } else if (s[mid] == '&') {
                minCostToOOO = Math.min(left[0], right[0]);
                minCostToOne = Math.min(left[1] + right[1], Math.min(left[1], right[1]) + 1); // 1 & 1 or 1 | 0 or 0 | 1
            }
            return new int [] {minCostToOOO, minCostToOne};
        }
        private int[] dfs(int l, int r, String expression, Map<Integer, Integer> pre) {
            if (l == r) {
                if (expression.charAt(l) == '0') {
                    return new int[] {0, 1};
                } else {
                    return new int[] {1, 0};
                }
            }
            if (expression.charAt(r) == ')' && pre.get(r) == l) {
                return dfs(l + 1, r - 1, expression, pre);
            }
            // expression[r]只能是0，1，）
            // expression[m]只能是｜，&
            int m = r - 1;
            if (expression.charAt(r) == ')') {
                m = pre.get(r) - 1;
            }
            int[] left = dfs(l, m - 1, expression, pre);
            int[] right = dfs(m + 1, r, expression, pre);
            int changeExpressionToZero = 0;
            int changeExpressionToOne = 0;
            if (expression.charAt(m) == '|') {
                // 左右有一个1
                changeExpressionToOne = Math.min(left[1], right[1]);
                // 左右都是0，左右有一个0且把符号改成&
                changeExpressionToZero = Math.min(left[0] + right[0], Math.min(left[0], right[0]) + 1);
            } else if (expression.charAt(m) == '&') {
                // 左右有一个0, &后就是0
                changeExpressionToZero = Math.min(left[0], right[0]);
                // 左右都是1，或者左右有一个1且把符号改成｜
                changeExpressionToOne = Math.min(left[1] + right[1], Math.min(left[1], right[1]) + 1);
            }
            return new int[] {changeExpressionToZero, changeExpressionToOne};
        }
        public int minOperationsToFlip(String expression) {
            Stack<Integer> stack = new Stack<>();
            Map<Integer, Integer> pre = new HashMap<>();
            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) == '(') {
                    stack.push(i);
                } else if (expression.charAt(i) == ')') {
                    pre.put(i, stack.pop());
                }
            }
            int[] result = dfs(0, expression.length() - 1, expression, pre);
            // 有一个必为0
            return Math.max(result[0], result[1]);
        }


        public String shortestCommonSupersequence(String ss, String tt) {
            int m = ss.length(), n = tt.length();
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            int [][] dp = new int [m+1][n+1];
            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n; j++) 
                    if (s[i-1] == t[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            int i = m, j = n;
            StringBuilder sb = new StringBuilder(); // reversed Longest Common Subsequence
            while (i-1 >= 0 && j-1 >= 0 && dp[i][j] > 0) {
                if (s[i-1] == t[j-1]) {
                    sb.insert(0, s[i-1]);
                    --i;
                    --j;
                } else {
                    if (dp[i-1][j] >= dp[i][j-1]) --i;
                    else --j;
                }
            }
            // while (i >= 0 && j >= 0 && dp[i+1][j+1] > 0) { // bug 这里写得不对
            //     if (dp[i+1][j+1] == dp[i][j] + 1) {
            //         sb.append(s[i]);
            //         --i;
            //         --j;
            //     } else if (dp[i+1][j+1] == dp[i][j+1]) {
            //         --i;
            //     } else --j;
            // }
            String sub = sb.toString();
            i = 0;
            j = 0;
            String ans = "";
            for (char c : sub.toCharArray()) {
                while (s[i] != c) {
                    ans += s[i];
                    i++;
                }
                while (t[j] != c) {
                    ans += t[j];
                    j++;
                }
                ans += c;
                i++;
                j++;
            }
            return ans + ss.substring(i) + tt.substring(j);
        }
        
        public int countVowelStrings(int n) {
            int mod = (int)1e9 + 7;
            Map<Integer, List<Integer>> m = new HashMap<>();
            m.put(0, List.of(0, 1, 2, 3, 4));
            m.put(1, List.of(1, 2, 3, 4));
            m.put(2, List.of(2, 3, 4));
            m.put(3, List.of(3, 4));
            m.put(4, List.of(4));
            long [][] dp = new long [n][5];
            for (int i = 0; i < 5; i++) 
                dp[0][i] = 1;
            for (int i = 1; i < n; i++) 
                for (int j = 0; j < 5; j++) {
                    if (dp[i-1][j] == 0) continue;
                    for (Integer v : m.get(j)) 
                        dp[i][v] = (dp[i][v] + dp[i-1][j]) % mod;
                }
            long ans = 0;
            for (int i = 0; i < 5; i++) 
                ans = (ans + dp[n-1][i]) % mod;
            return (int)ans;
        }

        public int countOrders(int n) {
            int mod = (int)1e9 + 7;
            int spots = n * 2;
            long ans = 1;
            for (int i = n; i >= 2; i--) {
                ans = (ans * spots * (spots - 1) / 2l) % mod;
                spots -= 2;
            }
            return (int)ans;
        }

        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] f = new boolean[m + 1][n + 1];
            f[0][0] = true;
            for (int i = 0; i <= m; ++i) 
                for (int j = 1; j <= n; ++j) 
                    if (p.charAt(j - 1) == '*') {
                        f[i][j] = f[i][j - 2];
                        if (matches(s, p, i, j - 1)) 
                            f[i][j] = f[i][j] || f[i - 1][j];
                    } else {
                        if (matches(s, p, i, j)) 
                            f[i][j] = f[i - 1][j - 1];
                    }
            return f[m][n];
        }
        public boolean matches(String s, String p, int i, int j) {
            if (i == 0) return false;
            if (p.charAt(j - 1) == '.') return true;
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
        public boolean isMatch(String s, String t) { // bug: 错哪里了呢？
            int m = s.length(), n = t.length();
            boolean[][] dp = new boolean[m+1][n+1];
            dp[0][0] = true;
            for (int i = 1; i < n; i++) { // 处理tt以星号开头的特殊情况
                if (t.charAt(i) != '*') break;
                    dp[0][i] = true;
                }
            for (int i = 1; i < m; i++) 
                for (int j = 1; j < n; j++) 
                    if (s.charAt(i) == t.charAt(j) || t.charAt(j) == '.') dp[i][j] = dp[i-1][j-1];
                    else if (t.charAt(j) == '*') {
                        if (s.charAt(i) == t.charAt(j-1)) dp[i][j] = dp[i-1][j] || dp[i][j-2]; // 匹配 ss 末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配；
                        else dp[i][j] = dp[i][j-2]; // 不匹配字符，将该组合扔掉，不再进行匹配。
                    }
            return dp[m-1][n-1];
        }

        public static int getMaxDiff(int[] array) {
            int sum = Arrays.stream(array).sum();
            int length = array.length;
            int [][] f = new int[length+1][sum/2+1];
            for (int i = 0; i < length; i++) 
                for (int j = 1; j <  = sum/2; j++) {
                    f[i+1][j]  =  f[i][j];
                    if (array[i] <= j && f[i][j-array[i]] + array[i] > f[i][j]) 
                        f[i+1][j] = f[i][j-array[i]] + array[i];
                }
            return sum-2*f[length][sum/2];
        }

        private static int lengthOfLongest(int[] set){
            Arrays.sort(set);
            int n = set.length;
            if (n <= 2) return n;
            int llap = 2;
            int[][] dp = new int[n][n];
            for (int i=0; i<n; i++) dp[i][n-1] = 2;
            for (int j=n-2; j>=1; j--) {
                int i=j-1, k=j+1;
                while (i>=0 && k<=n-1) {
                    if (set[i] + set[k] < 2 * set[j])
                        k++;
                    else if (set[i] + set[k] > 2 * set[j]) {
                        dp[i][j] = 2;
                        i--;
                    } else {
                        dp[i][j] = dp[j][k] + 1;
                        llap = Math.max(llap, dp[i][j]);
                        i--;
                        k++;
                    }
                }
                while (i >= 0) {
                    dp[i][j] = 2;
                    i--;
                }
            }
            return llap;
        }

        private static int getMaxLength(int[] arr){
            if (arr.length <= 2) return arr.length;
            int[][] dp = new int[arr.length][2];
            dp[0][0] = 1;
            dp[0][1] = 1;
            for (int i = 1; i < arr.length; i++) {
                dp[i][0] = dp[i-1][0]+1;
                if (arr[i] <= arr[i-1])
                    dp[i][0]--;
                if (dp[i-1][0] == dp[i-1][1] && arr[i] <= arr[i-1]) {// 说明前面还没有改的
                    dp[i][1] = dp[i][0] + 1;
                    arr[i] = arr[i-1]+1;
                } else {//说明前面已经改动或者arr[i] <= arr[i-1]
                    if (arr[i] > arr[i-1]) {
                        //判断前面是否已经改动
                        dp[i][1] = dp[i-1][1]+1;
                        if (dp[i-1][0] != dp[i-1][1]) 
                            dp[i][1]--;
                    } else
                        dp[i][1] = dp[i-1][1];
                }
            }
            return dp[arr.length-1][1];
        }

        public int numDistinct(String ss, String tt) {
            int m = ss.length(), n = tt.length();
            char [] s = ("#"+ss).toCharArray();
            char [] t = ("#"+tt).toCharArray();
            int [][] dp = new int [m+1][n+1];
            dp[0][0] = 1;
            for (int j = 1; j <= n; j++) // 注意这两行初始状态的设置
                dp[0][j] = 0;
            for (int i = 1; i <= m; i++) 
                dp[i][0] = 1;
            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n; j++) 
                    if (s[i] == t[j])
                        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    else dp[i][j] = dp[i-1][j];
            return dp[m][n];
        }
    }
    public static void main(String[] args) {
        Solution s  =  new Solution();

        int []  a = new int []  { 1, 2, 3, 4, 6};
        int [] b = new int [] {3,5,10,6,9};
        int [] c = new int [] {20,20,100,70,60};

        int  r  =  s.jobScheduling(a, b, c);
        System.out.println("r: " + r);
    }
}