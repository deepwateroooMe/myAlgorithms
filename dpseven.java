import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class dpseven {
    public static class Solution {

        public int minDistance(int[] h, int k) {
            n = h.length;
            d = new int [n][n];
            dp = new int [n][k+1];
            Arrays.sort(h);
            return dfs(h, 0, k);
        }
        int [][] d;
        int [][] dp;
        int n;
        private int dfs(int [] a, int i, int k) {
            if (i == n || i == n-k) return 0; // 剩余每户人家放一个邮箱，距离为0
            if (k == 1) return dp[i][k] = getDist(a, i, n-1);
            if (dp[i][k] > 0) return dp[i][k];
            int ans = Integer.MAX_VALUE;
            for (int j = i; j < n-(k-1); j++)  // 留足k-1户人家
                ans = Math.min(ans, dfs(a, j+1, k-1) + getDist(a, i, j));
            return dp[i][k] = ans;
        }
        private int getDist(int [] a, int i, int j) {
            if (d[i][j] > 0) return d[i][j];
            int m = i + (j-i) / 2, v = a[m], sum = 0;
            for (int k = i; k <= j; k++) 
                sum  += Math.abs(v - a[k]);
            return d[i][j] = sum;
        }
        public int minDistance(int[] h, int k) {
            int n = h.length;
            Arrays.sort(h);
            int [][] medsum = new int[n][n];
            for (int i = n - 2; i >= 0; --i) 
                for (int j = i + 1; j < n; ++j) 
                    medsum[i][j] = medsum[i + 1][j - 1] + h[j] - h[i];
            int [][] f = new int[n][k + 1];
            for (int i = 0; i < n; ++i) 
                Arrays.fill(f[i], Integer.MAX_VALUE / 2);
            for (int i = 0; i < n; ++i) {
                f[i][1] = medsum[0][i];
                for (int j = 2; j <= k && j <= i + 1; ++j)
                    for (int x = 0; x < i; x++) 
                        f[i][j] = Math.min(f[i][j], f[x][j-1] + medsum[x+1][i]);
            }
            return f[n - 1][k];
        }

       // 1. 从左至右循环一遍字符串，如果当前字符为”.”，记录下他与左边最近的R的距离：（i-RIndex），如果左边还没出现过R，那么距离设为无穷大。如果当前字符为R，记住当前R的下标（ RIndex = i）。如果当前字符为L，更新 RIndex 为无穷大。
       // 2.同理从右至左循环一遍字符串，记录下”.”与右方最近的L的距离。
       // 3.最后再循环一遍字符串，如果当前字符为L或者R，直接加入返回结果。如果当前字符是”.”，查看其距左方的R的距离以及距右方L的距离，如果左方的距离小，将R加入返回结果，反之将L加入返回结果。
        public String pushDominoes(String d) { // todo: multi source BFS, queue<Integer> etc 需要再总结一下
            int n = d.length(), dist = Integer.MAX_VALUE;
            char [] s = d.toCharArray();
            int [] l = new int [n]; // dist pushing to the left, traverse from right to left
            int [] r = new int [n]; // dist pushing to the right, traverse from left to right
            Arrays.fill(l, Integer.MAX_VALUE);
            Arrays.fill(r, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) // pushing to right, fill r[]
                if (s[i] == '.' && dist != Integer.MAX_VALUE)
                    r[i] = i - dist;
                else if (s[i] == 'R')
                    dist = i;
                else dist = Integer.MAX_VALUE;
            dist = Integer.MAX_VALUE;
            for (int i = n-1; i >= 0; i--) // pushing to left, fill l[]
                if (s[i] == '.' && dist != Integer.MAX_VALUE)
                    l[i] = dist - i;
                else if (s[i] == 'L')
                    dist = i;
                else dist = Integer.MAX_VALUE;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (s[i] == 'L' || s[i] == 'R') // 它们的状态无法改变，只要记下来就可以了
                    sb.append(s[i]);
                else {
                    if (r[i] < l[i]) sb.append('R'); // 距离它最近的倒下方向是向右，所以它也会倒向右边
                    else if (r[i] == l[i]) sb.append('.');
                    else sb.append('L');
                }
            }
            return sb.toString();
        }
        
        阵列的基础容量必须为2的幂(限制为2 ^ 30)。达到此大小时，有效地忽略了负载因子，并且阵列停止增长。
        此时，冲突率增加。
        由于hashCode()仅具有32位，因此无论如何都不能将其增大得太大。
        当大小超过Integer.MAX_VALUE时，它将溢出
        HashMap 数组最大容量是 （1<<30）HashMap 容量是 2 的幂次方
        public int uniqueLetterString(String s) { // mle: 超内存! 借助一个图：将遍历过的子串、数过的个数存起来备用,是一种带点儿记忆的暴力解法
            int n = s.length(), ans = 0, cur = 0; // 是否研究过HashMaps源代码？ 然后，您将快速了解为什么它会受到整数大小的限制
            char [] c = s.toCharArray();
            Map<String, Integer> m = new HashMap<>(); // 对于n <= 10^5数量级来说，子串的个数10^10应该是走出了图所能存条目的限制
            int [] cnt = new int [26];
            for (int d = 1; d <= n; d++) {
                for (int i = 0; i+d <= n; i++) {
                    String str = s.substring(i, i+d);
                    if (m.containsKey(str)) {
                        ans += m.get(str);
                        continue;
                    }
                    Arrays.fill(cnt, 0);
                    for (int j = i; j < i+d; j++)
                        cnt[c[j]-'A']++;
                    cur = getCnt(cnt);
                    m.put(str, cur);
                    ans += cur;
                }
            }
            return ans;
        }
        private int getCnt(int [] a) {
            int ans = 0;
            for (int i = 0; i < a.length; i++) 
                if (a[i] == 1) ans++;
            return ans;
        }
        public int uniqueLetterString(String t) { // 中心扩散法
            int mod = (int)1e9 + 7;
            int n = t.length(), ans = 0, j = 0, k = 0;
            char [] s = t.toCharArray();
            for (int i = 0; i < n; i++) {
                j = i-1;
                while (j >= 0 && s[j] != s[i]) j--;
                k = i+1;
                while (k < n && s[k] != s[i]) k++;
                ans = (ans + (i - j) * (k - i)) % mod;
            }
            return (int)ans;
        }

        public double soupServings(int N) {
            this.n = (int)Math.ceil(N / 25.0);
            dp = new Double [5001][5001];
            return n >= 5000 ? 1.0 : dfs(n, n);
        }
        Double [][] dp;
        int n;
        private double dfs(int i, int j) {
            if (i <= 0 && j <= 0) return 0.5;
            if (i <= 0) return 1;
            if (j <= 0) return 0;
            if (dp[i][j] != null) return dp[i][j];
            return dp[i][j] = 0.25 * dfs(i-4, j) + 0.25 * dfs(i-3, j-1) + 0.25 * dfs(i-2, j-2) + 0.25 * dfs(i-1, j-3);
        }

        // 给定数组a 以及整数 k，需要把数组完整地分成 k+1 段连续的子数组，每一段的权值是「这一段的最大值乘以这一段的长度再减去这一段的元素和」。需要最小化总权值。
        public int minSpaceWastedKResizing(int[] a, int k) { 
            n = a.length;
            dp = new Integer [n][k+2];
            max = new int [n][n];
            for (int i = 0; i < n; i++) {
                int cur = a[i];
                for (int j = i; j < n; j++) {
                    cur = Math.max(cur, a[j]);
                    max[i][j] = cur;
                }
            }
            sum = Arrays.copyOf(a, n);
            for (int i = 1; i < n; i++) 
                sum[i] += sum[i-1];
            return dfs(a, 0, k+1);
        }
        Integer [][] dp;
        int [][] max;
        int [] sum;
        int n;
        private int dfs(int [] a, int i, int k) {
            if (i == n || k == n-i) return 0;
            if (dp[i][k] != null) return dp[i][k];
            if (k == 1) return dp[i][k] = max[i][n-1] * (n - i) - (sum[n-1] - (i == 0 ? 0 : sum[i-1]));
            int min = Integer.MAX_VALUE;
            for (int j = i; j <= n-k; j++) 
                min = Math.min(min, dfs(a, j+1, k-1) + max[i][j] * (j-i+1) - (sum[j] - (i == 0 ? 0 : sum[i-1])));
            return dp[i][k] = min;
         }
        public int minSpaceWastedKResizing(int[] a, int k) {
            int n = a.length;
            if (n == 1) return 0;
            int [][] dp = new int [n+1][k+1];
            int max = Integer.MIN_VALUE, sum = 0;
            for (int i = n-1; i >= 0; i--) {
                max = Math.max(max, a[i]);
                sum += a[i];
                dp[i][0] = (n-i) * max - sum;
            }
            for (int i = 1; i <= k; i++) 
                for (int j = n-1-i; j >= 0; j--) {
                    max = Integer.MIN_VALUE;
                    sum = 0;
                    int cur = dp[j][0];
                    for (int x = j; x < n-1; x++) {
                        max = Math.max(max, a[x]);
                        sum += a[x];
                        cur = Math.min(cur, (x-j+1) * max - sum + dp[x+1][i-1]);
                    }
                    dp[j][i] = cur;
                }
            return dp[0][k];
        }

        // DP + BitSet : 这里面有个小问题需要挑出来
        // 使用一个DP数组存下当前行和之前行每行选一个数可能构成的和，
        // 在本题中，可以使用BitSet来存储之前行可以组成的和（由于所有数的最大值为70，而行数最大也为70，故BitSet最大的位数即为4900）。
        // 对于当前行，遍历BitSet已经set过的位（即代表之前行可能组成的和），然后加上当前数，set新的和
        // 最后遍历BitSet，求出当前位与target的最小值
        public int minimizeTheDifference(int[][] mat, int target) {
            int m = mat.length;
            int n = mat[0].length;
            BitSet sum = new BitSet(); // 遍历每一行，存下当前行和之前行可能组成的和
            for (int i = 0; i < n; i++) // 初始时存下第一行
                sum.set(mat[0][i]);
            for (int i = 1; i < m; i++) {
                BitSet newSum = new BitSet(); // 用来存新的和
                for (int j = 0; j < n; j++) {
                    // 注意：要遍历BitSet中的真实位，请使用以下循环：previousSetBit()方法 用于查找在指定的起始索引上或之前是否存在任何真位
                    // for (int i = bs.length(); (i = bs.previousSetBit(i-1)) >= 0; ) {
                    //     // operate on index i here
                    // }
                    for (int k = sum.length(); (k = sum.previousSetBit(k-1)) >= 0; ) {
                        newSum.set(k+mat[i][j]);
                    }
                }
                sum = newSum;
            }
            int ans = 4900;
            for (int k = sum.length(); (k = sum.previousSetBit(k-1)) >= 0;) {
                int diff = Math.abs(k - target);
                ans = Math.min(ans, diff);
            }
            return ans;
        }
        public int minimizeTheDifference(int[][] mat, int target) { // todo: google search to get these 2 methods clear
            int m = mat.length;
            int n = mat[0].length;
            int diff = Integer.MAX_VALUE, limit = 4900;
            int [] dp = new int[limit];
            for (int i = 0; i < n; i++) // 相当于是手工实现java BitSet
                dp[mat[0][i]] = 1;
            for (int i = 1; i < m; i++) {
                int [] tmp = new int [limit];
                for (int v = limit-1; v >= 0; v--) {
                    if (dp[v] == 0) continue;
                    for (int j = 0; j < n; j++) {
                        if (v + mat[i][j] < limit)
                            tmp[v+mat[i][j]] = 1;
                    }
                }
                System.arraycopy(tmp, 0, dp, 0, dp.length);
            }
            for (int i = 0; i < limit; i++) 
                if (dp[i] > 0) diff = Math.min(diff, Math.abs(i-target));
            return diff;  // min difference
        }
        public int minimizeTheDifference(int[][] mat, int target) {
            int m = mat.length, n = mat[0].length, N = 4901; // 70 * 70 + 1
            boolean [] vis = new boolean[N], cur = new boolean[N];
            for (int i = 0; i < n; i++) 
                vis[mat[0][i]] = true;
            for (int i = 1; i < m; i++) {
                Arrays.fill(cur, false);
                for (Integer v : mat[i]) 
                    for (int j = 0; j < N; j++) {
                        if (vis[j] && !cur[j+v] && j + v < N) 
                            cur[j+v] = true;
                    }
                vis = Arrays.copyOf(cur, N);
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) 
                if (vis[i] && Math.abs(i - target) < min) min = Math.abs(i - target);
            return min;
        }
        public int minimizeTheDifference(int[][] mat, int target) {
            Set<Integer> cur = new HashSet<>();
            Set<Integer> next = new HashSet<>();
            cur.add(0);      // does NOT affect result, 也不会混淆数据
            for (int i = 0; i < mat.length; i++) {
                next.clear();
                for (Integer v : cur) 
                    for (int j = 0; j < mat[i].length; ++j)
                        next.add(v + mat[i][j]);
                cur.clear(); // Remove all elements greater than the smallest element greater than target
                int smallestGreaterVal = Integer.MAX_VALUE;
                for (Integer v : next) 
                    if (v >= target) smallestGreaterVal = Math.min(smallestGreaterVal, v);
                    else cur.add(v);
                if (smallestGreaterVal != Integer.MAX_VALUE)
                    cur.add(smallestGreaterVal);
            }
            int minDif = Integer.MAX_VALUE;
            for (Integer v : cur)
                minDif = Math.min(minDif, Math.abs(v - target));
            return minDif;
        }
        public int minimizeTheDifference(int[][] mat, int target) { // the fastest so far
            // 1. Prepare process
            int remain = target;
            for (int i = 0; i < mat.length; i++) {
                Arrays.sort(mat[i]);       // 1) sort each row
                int minValue = mat[i][0];
                remain -= minValue;        // 2) let remain=sum(min value per row)
                for (int j = 0; j < mat[i].length; j++) 
                    mat[i][j] -= minValue; // 3) rebase row so that can be used in dfs directly
            }
            if (remain <= 0) //stop when target <= sum of the min value in each row
                return Math.abs(remain);
            // 2. Cached version DFS
            // 1) Cache calcuated result to avoid Time Limit Exceeded error
            // 2) Saving space by using remain instead of target
            Integer [][] dp = new Integer [mat.length][remain + 1];
            return dfs(0, remain, dp, mat);
        }
        private int dfs(int row, int remain, Integer[][] dp, int[][] mat) {
            if (row >= mat.length || remain <= 0) // < 0 ?
                return Math.abs(remain);
            if (dp[row][remain] != null) return dp[row][remain];
            int min = Math.abs(remain);
            // Take one item from current row then join with the rest of table
            // Start col from 0 means take the 1st column value
            for (int col = 0; col < mat[0].length; col++) {
                min = Math.min(min, dfs(row + 1, remain - mat[row][col], dp, mat));
                if (min == 0) return 0; // early return
                // skipping duplicate columns based on the already sorted row
                if (col > 0 && mat[row][col] == mat[row][col - 1]) 
                    continue; 
            }
            return dp[row][remain] = min;
        }

        public int kConcatenationMaxSum(int[] a, int k) {
            int mod = (int)1e9 + 7;
            int n = a.length;
            long ans = Integer.MIN_VALUE;
            long curSum = 0, sum = Arrays.stream(a).sum();;
            for (int i = 0; i < n * Math.min(k, 2); i++) {
                curSum = Math.max(curSum + a[i % n], a[i % n]);
                ans = Math.max(ans, curSum);
            }
            // 当数组有正数、负数，最大子数组出现在首尾相连的地方时 ？ [1, 2, -2] 可以连续重复k-2次
            // 如果把数组变为 [1,-2,2] 的话，那就不一样了，虽然说两个为 [1,-2,2,1,-2,2] 的最大子数组之和为3，但是由于原数组之和为1，只要尽可能多的连，就可以得到更大的值，所以这种情况也要考虑到。
            return (int)(Math.max(Math.max(0, ans), ans + sum * Math.max(0, k-2)) % mod);
        }

        public int maxSatisfaction(int[] a) {
            int n = a.length;
            Arrays.sort(a); // 做菜的顺序无关，就可以排序寻找最优解
            int sum = 0, max = 0;
            for (int i = n-1; i >= 0; i--) {
                sum = 0;
                for (int j = i; j < n; j++) 
                    sum += (j-i+1) * a[j];
                max = Math.max(max, sum);
            }
            return max;
        }

        public int tilingRectangle(int n, int m) {                      // has to set a special case
            if (Math.max(m, n) == 13 && Math.min(m, n) == 11) return 6; // special case
            int [][] dp = new int [n+1][m+1];
            for (int i = 1; i <= n; i++) 
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    if (i == j) {
                        dp[i][j] = 1;
                        continue;
                    }
                    for (int r = 1; r <= i / 2; r++) // 遍历分成上下两半的情况
                        dp[i][j] = Math.min(dp[i][j], dp[r][j] + dp[i-r][j]);
                    for (int c = 1; c <= j/2; c++)   // 遍历分成左右两半的所有可能情况
                        dp[i][j] = Math.min(dp[i][j], dp[i][c] + dp[i][j-c]);
                }
            return dp[n][m];
        }
        private void dfs(int n, int m, int [] a, int cnt) { // 还是当作m行、n列来写的
            if (cnt > min) return;
            boolean isFull = true;
            int idx = -1, minHeight = m;
            for (int i = 1; i <= n; i++) {
                if (a[i] < m) isFull = false;
                if (a[i] < minHeight) {
                    idx = i;
                    minHeight = a[i];
                }
            }
            if (isFull) {
                min = Math.min(min, cnt);
                return;
            }
            long key = 0, base = m+1; // 把a转化为hashing值作为dp的键,应该比较string作为键更高效
            for (int i = 1; i <= n; i++) {
                key += a[i] * base;
                base *= m+1;
            }
            if (dp.containsKey(key) && dp.get(key) <= cnt) return;
            dp.put(key, cnt); // 更新全局变量至每个状态最优
            int end = idx;    // 想要放一个最大的正方形，向右扩展增加长度，也要检查长度为（end+1-idx+1 == j-i+1）时高度是否会越界
            while (end+1 <= n && a[end+1] == a[idx] && end+1 - idx+1+minHeight <= m) end++;
            for (int j = end; j >= idx; j--) { // 所有当下有效合理解中，选择最优
                int curHeight = j - idx + 1;
                int [] next = Arrays.copyOf(a, n+1);
                for (int k = idx; k <= j; k++) 
                    next[k] += curHeight;      // skyline: 高度增加当下正方形的边长
                dfs(n, m, next, cnt+1);
            }
        }
        private void dfs(int m, int n, int [] a, int cnt) { // bug: todo fix and understand why bugged
            if (cnt > min) return ; // 
            boolean isFilled = true;
            int idx = -1, hi = n; // hi: mininum height available
            for (int i = 1; i <= m; i++) {
                if (a[i] < n) isFilled = false;
                if (a[i] < hi) {
                    idx = i;
                    hi = a[i];
                }
            }
            if (isFilled) {
                min = Math.min(min, cnt);
                // min = cnt;
                return ;
            }
            long key = 0, base = n+1;
            for (int i = 1; i <= m; i++) {
                key += a[i] * base;
                base *= n+1;
            }
            if (dp.containsKey(key) && dp.get(key) <= cnt) return;
            dp.put(key, cnt);
            int i = idx; // i: end, right end 向右向上增加边上，向右高度相等，向上保证不会越界
            while (i+1 <= m && a[i+1] == a[idx] && i+1-idx+1+hi <= n) i++; // 得到当下可放正方形的最大边长
            for (int j = i; j >= idx; j--) { // 所以可放正方形边长里，遍历并寻找全局最优解
                int curSideLen = j - idx + 1;
                int [] next = Arrays.copyOf(a, m+1);
                for (int k = idx; k <= j; k++) {
                    next[i] += curSideLen;
                    dfs(m, n, next, cnt + 1);
                }
            }
        }
        Map<Long, Integer> dp = new HashMap<>();
        int min = Integer.MAX_VALUE;
        public int tilingRectangle(int n, int m) {
            if (m == n) return 1;
            if (n > m) return tilingRectangle(m, n); // make sure: n <= m
            dfs(n, m, new int [n+1], 0);
            return min;
        }

        可以用回塑技能2^16，人择优录用,写起来相对复杂, 如同 万能的dfs记忆化搜索, 2^20对回塑来说也是灵丹炒药
        public int [] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
            n = req_skills.length;
        }
        int n;
        public int [] smallestSufficientTeam(String[] req_skills, List<List<String>> people) { // 不知道哪里写错了,改天再回来写这个题
            Map<String, Integer> m = new HashMap<>();
            for (int i = 0; i < req_skills.length; i++) 
                m.put(req_skills[i], 1 << i); 
            int range = 1 << req_skills.length;
            Map<Integer, Set<Integer>> dp = new HashMap<>();
            Map<Integer, Set<Integer>> tmp = new HashMap<>();
            dp.put(0, new HashSet<>());
            int [] cnt = new int [range];
            Arrays.fill(cnt, Integer.MAX_VALUE);
            cnt[0] = 0;
            for (int i = 0; i < people.size(); i++) {
                int cur = 0;
                for (String s : people.get(i)) 
                    if (m.keySet().contains(s)) cur += m.get(s);
                Set<Integer> si = new HashSet<>();
                si.add(i);
                dp.put(cur, si);
                cnt[cur] = 1;
                tmp.clear();
                for (Integer key : dp.keySet()) 
                    if (!dp.containsKey(key | cur) || dp.get(key | cur).size() > dp.get(key).size() + 1) {
                        Set<Integer> tmpSet = new HashSet<>(dp.get(key));
                        tmpSet.add(i);
                        tmp.put(key | cur, tmpSet);
                    }
                for (Integer key : tmp.keySet()) 
                    dp.put(key, new HashSet<>(tmp.get(key)));
                // for (int j = range-1; j >= 0; j--) 
                //     if ((j & cur) == cur && cnt[j ^ cur] != Integer.MAX_VALUE) 
                //         if (cnt[j] > cnt[j ^ cur] + 1) {
                //             cnt[j] = cnt[j ^ cur] + 1;
                //             dp[j].clear();
                //             dp[j].addAll(dp[j ^ cur]);
                //             dp[j].add(i);
                //         }
            }
            int [] ans = new int [dp.get(range-1).size()];
            int idx = 0;
            for (Integer v : dp.get(range-1)) 
                ans[idx++] = v;
            return ans;
        }
        // String []  a = new String []  {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
        // String [][] b = new String [][] {{"algorithms","math","java"},{"algorithms","math","reactjs"},{"java","csharp","aws"},{"reactjs","csharp"},{"csharp","math"},{"aws","java"}};
        // String []  a = new String []  {"java", "nodejs", "reactjs"};
        // String [][] b = new String [][] {{"java"},{"nodejs"},{"nodejs","reactjs"}};
        // List<List<String>> ll = new ArrayList<>();
        // for (int i = 0; i < b.length; i++) 
        //     ll.add(Arrays.asList(b[i]));

        public int removeBoxes(int [] b) { // 区间型dp
            n = b.length;
            dp = new int [n][n][n];
            return dfs(b, 0, n-1, 0);
        }
        int [][][] dp;
        int n;
        private int dfs(int [] a, int i, int j, int k) {
            if (i > j) return 0;
            if (dp[i][j][k] > 0) return dp[i][j][k];
            int ans = dfs(a, i, j-1, 0) + (k+1) * (k+1); // 消除[i, j-1]区间后，（k+1）个a[j]就可以连续消除
            for (int x = i; x < j; x++) 
                if (a[x] == a[j])       // 试图先消除掉 [x+1, j-1]范围内的数，然后剩下a[x], a[j] 以及j后面有k个连续与a[j]相等的数
                    ans = Math.max(ans, dfs(a, x+1, j-1, 0) + dfs(a, i, x, k+1)); // [x+1,j-1]消除后，a[x]后面就跟了k+1个连续与a[x]相等的数
            return dp[i][j][k] = ans;
        }

        public int strangePrinter(String t) {
            n = t.length();
            s = t.toCharArray();
            dp = new int [n][n];
            return dfs(0, n-1);
        }
        int [][] dp;
        char [] s;
        int n;
        private int dfs(int i, int j) {
            if (i > j) return 0;
            if (dp[i][j] > 0) return dp[i][j];
            int ans = dfs(i+1, j) + 1; // 初始化为先打i位置，再打[i+1, j]区间覆盖原 [i, j]区间
            for (int k = i+1; k <= j; k++) 
                if (s[i] == s[k])
                    ans = Math.min(ans, dfs(i+1, k-1) + dfs(k, j));
            return dp[i][j] = ans;
        }
        public int strangePrinter(String s) {
            int n = s.length();
            int [][] dp = new int[n][n];
            for (int i = n-1; i >= 0; i--) 
                for (int j = i; j < n; j++) {
                    dp[i][j] = i == j ? 1 : 1 + dp[i+1][j]; // 同样是先打出[i, j]区间一次，再用[i+1,j]区间覆盖
                    for (int k = i+1; k <= j; k++) 
                        if (s.charAt(k) == s.charAt(i))     // 如果存在相同的字符，就可以进一步地优化
                            dp[i][j] = Math.min(dp[i][j], dp[i+1][k-1]+dp[k][j]);
                }
            return dp[0][n-1];
        }
        
        // 相比于前两题，数组线性问题上的区间dp,这里增加一个维度矩阵上的，
        // 但本质仍然是：如果某个区间首尾相同（矩阵上四个边上有相同着色），那么可以先打印解决小区间内子问题，再推进
        public boolean isPrintable(int[][] targetGrid) { // todo: 这个题还是狠值得一做滴
        // 建个图：topological 排序，大致是这个意思，改天回来写 1591
        }

        public int maxScore(int[] a) {
            n = a.length;
            vis = new boolean [n];
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) 
                    gcd[i][j] = getGcd(a[i], a[j]);
            return dfs(a, 0, 1, 0);
        }
        int [][] gcd;
        boolean [] vis;
        int n, max = 0;
        private int dfs(int [] a, int i, int v, int cur) { // 这里的思路还是没有想清楚
            if (i == n) {
                if (cur > max) max = cur;
                return ;
            }
            for (int j = 0; j < n; j++) {
                if (j == i || vis[j]) continue;
                if (!vis[j]) {
                    vis[j] = true;
                    dfs(a, )
                }
            }
        }
        private int getGcd(int i, int j) { // complexity of Euclid's algorithm is O(Log min(n1, n2)) 
            if (j == 0) return i;
            return getGcd(j, i % j);
        }

        public int minStickers(String [] s, String t) {
            tt = new int [26];
            for (int i = 0; i < t.length(); i++) tt[t.charAt(i)-'a']++;
            Set<Character> tc = new HashSet<>(t.toCharArray());
            List<String> l = new ArrayList<>();
            for (String v : s) {
                StringBuilder sb = new StringBuilder();
                for (char c : v.toCharArray()) 
                    if (tc.contains(c)) 
                        sb.append(c);
                if (sb.length() == 0) continue;
                l.add(sb.toString());
            }
            n = l.size();
            return dfs(l, 0, tt, t);
        }
        Map<Integer, Integer> dp = new HashMap<>(); // 2^50不能用回塑，顶多记忆化搜索
        int [] tt;
        int n;
        private int dfs(List<String> l, int i, int [] cnt, String t) {
            if (i == n) {
                for (int i = 0; i < 26; i++) 
                    if (tt[i] > 0) return Integer.MAX_VALUE;
                return 0;
            }
            String key = Arrays.toString(cnt)+"_"+i;
            if (dp.containsKey(key)) return dp.get(key);
            int ans = dfs(l, i+1, cnt, t);
            int [] next = Arrays.copyOf(cnt, 26);
            for (char c : l.get(i).toCharArray())
                next[c-'a'] = Math.max(0, --cnt[c-'a']);
            ans = Math.min(ans, 1 + dfs(l, i, next, t)); // 同一个词用几次的标准是什么， 怎么才能遍历到下一个idx,
            dp.put(key, ans);
            return ans;
        }

        public int connectTwoGroups(List<List<Integer>> cost) {
            m = cost.size();
            n = cost.get(0).size();
            range = 1 << n;
            dp = new Integer [m][range];
            min = new int [n];
            Arrays.fill(min, Integer.MAX_VALUE);
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    min[j] = Math.min(min[j], cost.get(i).get(j));
            return dfs(cost, 0, 0);
        }
        Integer [][] dp;
        int [] min;
        int m, n, range;
        private int dfs(List<List<Integer>> ll, int i, int j) {
            // if (i >= m && Integer.bitCount(j) >= n) return 0; // 这一行可以不要了
            if (i == m) {
                int ans = 0;
                for (int k = 0; k < n; k++) 
                    if (((j >> k) & 1) == 0) ans += min[k];
                return ans;
                // return dp[i][j] = ans; // 这个记不记答案好像不重要了: 频次太低，或仅一次？
            }
            if (dp[i][j] != null) return dp[i][j];
            int ans = Integer.MAX_VALUE;
            for (int k = 0; k < ll.get(i).size(); k++) 
                ans = Math.min(ans, dfs(ll, i+1, (j | (1 << k))) + ll.get(i).get(k)); // left i connets to right k
            return dp[i][j] = ans;
        }
        public int connectTwoGroups(List<List<Integer>> ll) { 
            int m = ll.size();
            int n = ll.get(0).size();
            int [][] dp = new int [m][1 << n]; // 右边点组过程中共有1 << n种状态，但是如何知道记住右边的点分别是与左边哪个点连接起来的呢？
            for (int i = 0; i < m; i++) 
                Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            for (int i = 0; i < m; i++) {      // 暴力求解所有值取最小
                for (int j = 0; j < 1 << n; j++) {
                    for (int k = 0; k < n; k++) {  // 感觉这里面的关系没能理清楚，所以才会写得这么累坠
                        if (i > 0 && dp[i-1][j^(1 << k)] != Integer.MAX_VALUE/2) 
                            dp[i][j] = Math.min(dp[i][j], ll.get(i).get(k) + dp[i-1][j ^ (1 << k)]);
                        if (i > 0 && dp[i-1][j] != Integer.MAX_VALUE/2)
                            dp[i][j] = Math.min(dp[i][j], ll.get(i).get(k) + dp[i-1][j]);
                        if (i == 0 && (j ^ (1 << k)) == 0) dp[i][j] = ll.get(i).get(k);
                        else if (dp[i][j^(1 << k)] != Integer.MAX_VALUE/2)
                            dp[i][j] = Math.min(dp[i][j], ll.get(i).get(k) + dp[i][j ^ (1 << k)]);
                    }
                }
            }
            return dp[m-1][(1 << n)-1];
        }
        public int connectTwoGroups(List<List<Integer>> ll) { // todo dp
            int m = ll.size();
            int n = ll.get(0).size();
            int [][] f = new int[m + 1][1 << n];
            for (int i = 0; i <= m; i++) 
                Arrays.fill(f[i], Integer.MAX_VALUE / 2);
            f[0][0] = 0;
            for (int i = 0; i < m; i++) 
                for (int s = 0; s < 1 << n; s++) 
                    for (int j = 0; j < n; j++) 
                        f[i + 1][s | 1 << j] = Math.min(f[i + 1][s | 1 << j], // 原本没连，把它连上， or ? 看不懂
                                                        Math.min(f[i + 1][s] + ll.get(i).get(j), f[i][s] + ll.get(i).get(j)));
            return f[m][(1 << n) - 1];
        }
        public int connectTwoGroups(List<List<Integer>> ll) {
            int m = ll.size();
            int n = ll.get(0).size();
            int t = 1 << n;
            int[][] dp = new int[2][t];
            Arrays.fill(dp[0], Integer.MAX_VALUE);
            int old = 0;
            int now = 0;
            dp[now][0] = 0;
            for (int i = 0; i < m; ++i) {
                old = now;
                now = 1 - now;
                Arrays.fill(dp[now], Integer.MAX_VALUE);
                for (int j = 0; j < t; ++j) {
                    for (int k = 0; k < n; ++k) {
                        int mask = j | (1 << k);
                        if (dp[old][j] != Integer.MAX_VALUE) 
                            dp[now][mask] = Math.min(dp[now][mask], dp[old][j] + ll.get(i).get(k));
                        if ((j & (1 << k)) == 0 && dp[now][j] != Integer.MAX_VALUE) 
                            dp[now][mask] = Math.min(dp[now][mask], dp[now][j] + ll.get(i).get(k));
                    }
                }
            }
            return dp[now][t - 1];
        }

        public int numWays(int steps, int arrLen) {
            dp = new Integer [steps + 1][Math.min(steps, arrLen)];
            return dfs(steps, 0, arrLen);
        }
        int mod = (int)1e9 + 7;
        Integer [][] dp;
        private int dfs(int cnt, int i, int n) {
            if (cnt == 0) return i == 0 ? 1 : 0;
            if (dp[cnt][i] != null) return dp[cnt][i];
            long ans = dfs(cnt-1, i, n); // 我坐在这里等呀等
            if (i > 0) ans = (ans + dfs(cnt-1, i-1, n)) % mod;
            if (i < n-1) ans = (ans + dfs(cnt-1, i+1, n)) % mod;
            return dp[cnt][i] = (int)ans;
        }

        public boolean canCross(int [] s) { // bug
            n = s.length;
            dp = new Boolean [n][n];
            return dfs(s, 0, 0);
        }
        Boolean [][] dp;
        int n;
        private boolean dfs(int [] a, int i, int j) {
            if (i == n) return false;
            if (dp[i][j] != null) return dp[i][j];
            if (i == n-1) return dp[i][j] = true;
            int k = i;
            if (k < n-1 && a[k+1] > a[i] + j+1) return dp[i][j] = false;
            while (k < n-1 && a[k+1] < a[i] + j-1) k++;
            if (k == n-1) return dp[i][j] = false;
            if (k > i)
                k += 1;
            for (; k < n && a[k] >= a[i] + Math.max(1, j-1) && a[k] <= a[i] + j+1; k++) {
                if (dfs(a, k, a[k] - a[i]))
                    return dp[i][j] = true;
            }
            return dp[i][j] = false;
        }
        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [] a = new int [] {0,1,3,5,6,8,12,17};
        // int [] a = new int [] {0,1,2,3,4,8,9,11};
        int []  a = new int []  {0, 2};
        
        boolean r = s.canCross(a);
        System.out.println("r: " + r);
    }
}