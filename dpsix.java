import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class dpsix {
    public static class Solution {

        // 在java里，List的哈希方式，是将其哈希成开头加个1后的31进制整数，例如对于列表[ 1 , 2 , 3 ]，java会将其哈希成31进制下的1123，也就是哈希成
        // 1*31^3 + 1 * 32^2 + 2 * 31 + 3 = 30817，而List里判断是否equals，是逐个比较列表里的值，如果值全相等就返回true。
        //     所以在记忆化的时候，可以直接把key设为是List类型的。
        public int shoppingOffers(List<Integer> p, List<List<Integer>> of, List<Integer> need) {
            n = p.size();
            return dfs(p, of, need);
        }
        Map<List<Integer>, Integer> dp = new HashMap<>();
        int n;
        private int dfs(List<Integer> p, List<List<Integer>> of, List<Integer> need) {
            if (dp.containsKey(need)) return dp.get(need);  // 首先检查记忆
            int ans = 0;
            for (int i = 0; i < n; i++) 
                ans += p.get(i) * need.get(i);
            if (ans == 0) return ans; // ? 这里就不需要记忆了？
            for (List<Integer> cur : of) {
                if (cur.get(cur.size()-1) >= ans) continue; // >=
                List<Integer> newNeed = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (cur.get(i) > need.get(i)) break;
                    newNeed.add(need.get(i) - cur.get(i));
                }
                if (newNeed.size() == need.size()) // 即当前礼包合法
                    ans = Math.min(ans, cur.get(cur.size()-1) + dfs(p, of, newNeed));
            }
            dp.put(need, ans);
            return ans;
        }
        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) { // bug, todo
            n = price.size();
            int[][] dp = new int[special.size() + 1][1 << n * 3]; // 开一个记忆化数组，dp[i][s]表示如果只考虑前i个套餐的话，要买到s这个状态，至少需要多少花费
            for (int [] row : dp) Arrays.fill(row, -1); // 先初始化为-1
            int target = 0; // 求一下needs代表的状态，这里target的最低3位表示的是下标是0的商品要买多少个，以此类推
            for (int i = needs.size() - 1; i >= 0; i--) 
                target = (target << 3) + needs.get(i);
            return dfs(special.size(), target, special, price, dp);
        }
        int n;
        // 返回的是，如果只考虑前count个套餐的话，要达到state这个状态的最小花费（当然单买也是考虑的）
        private int dfs(int count, int state, List<List<Integer>> special, List<Integer> price, int[][] dp) {
            if (state >= (1 << n*3)) return 0;
            if (dp[count][state] != -1) return dp[count][state]; // 如果之前已经算出来过，则直接返回
            if (count == 0) { // 如果一个套餐都不考虑，那就是全单买
                dp[count][state] = 0;
                // 求一下每个商品买多少个，然后累加一下花费
                for (int i = 0; i < n; i++) {
                    int c = state >> i * 3 & 7;
                    dp[count][state] += c * price.get(i);
                }
                return dp[count][state];
            }
            dp[count][state] = dfs(count - 1, state, special, price, dp); // 考虑不选第count个套餐的情况
            List<Integer> sp = special.get(count - 1);                    // 考虑选第count个套餐的情况
            int nextState = 0; // 存一下考虑完当前套餐后的需求状态
            for (int i = n - 1; i >= 0; i--) { // 逆序遍历是为了方便nextState的计算
                int c = state >> i * 3 & 7;
                if (c < sp.get(i)) { // 小了，说明当前套餐是不能选的，标记为-1并退出循环
                    nextState = -1;
                    break;
                }
                nextState = (nextState << 3) + c - sp.get(i);
            }
            if (nextState != -1)  // 如果当前套餐能选，再算一下选了当前套餐的情况下的最小花费
                dp[count][state] = Math.min(dp[count][state], sp.get(n) + dfs(count, nextState, special, price, dp));
            return dp[count][state];
        }

        public int findMaxForm(String[] strs, int m, int p) { // m: 0 p: 1 dfs记忆化搜索
            n = strs.length;
            int [] one = new int [n]; // cnt 1s
            int [] two = new int [n]; // cnt 0s
            int cntOne = 0, cntZero = 0;
            for (int i = 0; i < n; i++) {
                String cur = strs[i];
                cntOne = 0;
                cntZero = 0;
                for (char c : cur.toCharArray()) {
                    if (c == '0') cntZero++;
                    else cntOne++;
                }
                one[i] = cntOne;
                two[i] = cntZero;
            }
            List<String> l = new ArrayList<>();
           cnt = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (one[i] > p || two[i] > m) continue;
                l.add(strs[i]);
                cnt.add(new int [] {two[i], one[i]});
            }
            dp = new int [l.size()][m+1][p+1];
            return dfs(l, 0, m, p);
        }
        int [][][] dp;
        List<int []> cnt;
        int n;
        private int dfs(List<String> l, int idx, int i, int j) { 
            if (idx >= l.size() || i < 0 || j < 0) return 0;
            if (i == 0 && j == 0) return 0;
            if (dp[idx][i][j] > 0) return dp[idx][i][j];
            int x = i - cnt.get(idx)[0], y = j - cnt.get(idx)[1];
            int ans = x >= 0 && y >= 0 ? 1 : 0;
            return dp[idx][i][j] = Math.max(ans + dfs(l, idx+1, x, y), dfs(l, idx+1, i, j));
         }
        public int findMaxForm(String[] strs, int m, int n) { // m: 0 p: 1 
            int [][] dp = new int [m+1][n+1];
            for (String  s : strs) {
                int one = 0, zero = 0;
                for (char c : s.toCharArray()) 
                    if (c == '0') zero++;
                    else one++;
                // if (zero > m || one > n) continue;
                for (int i = m; i >= zero; i--) 
                    for (int j = n; j >= one; j--) 
                        dp[i][j] = Math.max(dp[i][j], dp[i-zero][j-one] + 1);
                // dp[zero][cntOne] = Math.max(dp[zero][cntOne], 1);
                // for (int i = 0; i <= m-zero; i++) 
                //     for (int j = 0; j <= n-cntOne; j++) 
                //         if (dp[i][j] > 0)
                //             dp[i+zero][j+cntOne] = Math.max(dp[i+zero][j+cntOne], dp[i][j] + 1);
                // for (int i = zero; i <= m; i++) 
                //     for (int j = cntOne; j <= n; j++) 
                //         if (dp[i][j] > 0)
                //             dp[i][j] = Math.max(dp[i][j], dp[i-zero][j-cntOne] + 1);
            }
            return dp[m][n];
        }
        public int findMaxForm(String[] strs, int m, int n) {
            int [][] dp = new int [m+1][n+1];
            dp[0][0] = 0;
            for (String s : strs) {
                int one = 0, zoo = 0;
                for (int i = 0; i < s.length(); i++) 
                    if (s.charAt(i) == '0') ++ zoo;
                    else ++one;
                for (int i = m; i >= zoo; i--) 
                    for (int j = n; j >= one; j--) 
                        dp[i][j] = Math.max(dp[i][j], dp[i-zoo][j-one] + 1);
            }
            return dp[m][n];
        }

        public int maximumSum(int[] a) { // bug
            int n = a.length, max = Integer.MIN_VALUE, locMax = Integer.MIN_VALUE;
            int [] l = new int [n+1], r = new int [n+1];
            Arrays.fill(l, Integer.MIN_VALUE);
            Arrays.fill(r, Integer.MIN_VALUE);
            l[0] = 0;
            for (int i = 0; i < n; i++) {
                locMax = Math.max((i == 0 ? 0 : locMax) + a[i], a[i]);
                l[i+1] = locMax;
            }
            r[n] = 0; locMax = Integer.MIN_VALUE;
            for (int i = n-1; i >= 0; i--) {
                locMax = Math.max(locMax + a[i], a[i]);
                r[i] = locMax;
            }
            max = Integer.MIN_VALUE;
            for (int i = 0; i <= n; i++) 
                max = Math.max(max, l[i] + r[i]);
            return max;
        }

        public int countRestrictedPaths(int n, int[][] edges) {
            this.n = n;
            for (int [] e : edges) {
                adj.computeIfAbsent(e[0], z -> new HashMap<>()).put(e[1], e[2]);
                adj.computeIfAbsent(e[1], z -> new HashMap<>()).put(e[0], e[2]);
            }
            dist = new int [n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[n] = 0;
            dijstra();
            dp = new int [n+1];
            Arrays.fill(dp, -1);
            return (int)dfs(1);
        }
        HashMap<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        int mod = (int)1e9 + 7;
        int [] dist;
        int [] dp;
        int n;
        private long dfs(int u) {
            if (u == n) return 1;
            if (dp[u] != -1) return dp[u];
            long ans = 0;
            Map<Integer, Integer> tmp = adj.get(u);
            if (tmp != null) 
                for (Integer v : tmp.keySet()) 
                    if (dist[u] > dist[v])
                        ans = (ans + dfs(v)) % mod;
            return dp[u] = (int)ans;
        }
        private void dijstra() {
            // Queue<int []> q = new LinkedList<>(); // tle 
            Queue<int []> q = new PriorityQueue<>((a, b)->a[1] - b[1]); // 狠重要
            q.offer(new int [] {n, 0});
            while (!q.isEmpty()) {
                int [] u = q.poll();
                if (dist[u[0]] < u[1]) continue; // 狠重要
                Map<Integer, Integer> tmp = adj.get(u[0]);
                if (tmp == null) continue;
                for (Integer v : tmp.keySet()) 
                    if (u[1] + tmp.get(v) < dist[v]) {
                        dist[v] = u[1] + tmp.get(v);
                        q.offer(new int [] {v, dist[v]});
                    }
            }
        }
 
        public long maxTaxiEarnings(int n, int[][] rides) {
            Arrays.sort(rides, (a, b)-> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
            Map<Integer, Set<int []>> m = new HashMap<>();
            for (int [] r : rides) 
                m.computeIfAbsent(r[1], z -> new HashSet<>()).add(r);
            long [] dp = new long [n+1];
            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i-1];
                if (m.containsKey(i)) 
                    for (int [] r : m.get(i)) 
                        dp[r[1]] = Math.max(dp[r[1]], dp[r[0]] + r[1] - r[0] + r[2]);
            }
            return dp[n];
        }
        Similar to 1235. Maximum Profit in Job Scheduling
        Sort by the end time to get non-overlapping intervals.
        Use the treemap to find the previous ride before the current ride.
        public long maxTaxiEarnings(int n, int[][] rides) {
            if (rides == null || rides.length == 0) return 0;
            for (int[] r : rides) 
                r[2] = r[1] - r[0] + r[2];
            Arrays.sort(rides, (a, b) -> (a[1] - b[1]));
            TreeMap<Long, Long> map = new TreeMap<>();
            map.put((long)0, (long)0); 
            for (int[] r : rides) {
                long cur = map.floorEntry((long)r[0]).getValue() + r[2];
                if (cur > map.lastEntry().getValue()) {
                    map.put((long)r[1], cur);
                }
            }
            return map.lastEntry().getValue();
        }

        public int findSubstringInWraproundString(String p) {
            int n = p.length();
            char [] s = p.toCharArray();
            int [] cnt = new int [26];
            int [] a = new int [n];
            for (int i = 0; i < n; i++) 
                a[i] = s[i] - 'a';
            int validLen = 0;
            for (int i = 0; i < n; i++) {
                if (i > 0 && (a[i-1] +1) % 26 == a[i])
                    validLen++;
                else validLen = 1;
                cnt[a[i]] = Math.max(cnt[a[i]], validLen);
            }
            return Arrays.stream(cnt).sum();
        }

        // 如果是普通的DP方法，那么使用二维dp[i][j]表示子数组的起始和结束区间，能做到O(n^2)的时间复杂度，但是题目对时间复杂度要求的很死，必须O(N).
        // 正确的做法也是动态规划，dp[i]表示以A[i]结尾的所有子数组的异或结果，其实是个set。
        // 转移方程式: 
        // dp[i] = [b | A[i] for b in dp[i - 1]] + A[i]，
        //     即以A[i]结尾的所有子数组异或结果等于以A[i-1]结尾的所有子数组或的结果，和当前的A[i]相或，再加上A[i]这个结果。
        //     同时使用一个set保存所有的异或结果。最后返回这个结果set的长度。
        public int subarrayBitwiseORs(int[] a) { 
            int n = a.length;
            Set<Integer> ans = new HashSet<>();
            Set<Integer> [] dp = new HashSet[n];  // 以滚动数组的原理，继续压缩空间
            dp[0] = new HashSet<>(List.of(a[0])); // 这里应该不用加0的
            ans.add(a[0]);
            for (int i = 1; i < n; i++) {
                dp[i] = new HashSet<>();
                for (Integer v : dp[i-1]) 
                    dp[i].add(v | a[i]);
                dp[i].add(a[i]);
                ans.addAll(dp[i]);
            }
            return ans.size();
        }
        public int subarrayBitwiseORs(int[] A) {
            Set<Integer> ans = new HashSet<>();
            Set<Integer> cur = new HashSet<>();
            for (int a : A) {
                Set<Integer> next = new HashSet<>();
                next.add(a);
                for (Integer b : cur)
                    next.add(b | a);
                ans.addAll(next);
                cur = next;
            }
            return ans.size();
        }
        public int subarrayBitwiseORs(int[] arr) { // 这个方法写得好仙幻啊，看不懂呀看不懂～！！！ todo： 还是看不懂
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
                for (int j = i - 1; j >= 0; j--) {
                    if ((arr[i] | arr[j]) == arr[j]) {
                        // arr[j]的置位位置包含了arr[i]的置位位置，
                        // 那么已经无需考虑arr[i]的加入与否
                        break;
                    }
                    // 求值的同时保留积累状态
                    arr[j] |= arr[i];
                    set.add(arr[j]);
                }
            }
            return set.size();
        }

        public int maxSubarraySumCircular(int[] a) { // 寻找全局最大子数组、和全局最小子数组
            int n = a.length;
            int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, locMax = 0, locMin = 0;
            for (Integer v : a) {
                locMax = Math.max(locMax + v, v);
                max = Math.max(max, locMax);
                locMin = Math.min(locMin + v, v);
                min = Math.min(min, locMin);
                sum += v;
            }
            return max > 0 ? Math.max(max, sum - min) : max;
        }
        
        public int maximumSum(int[] a) { 
            int n = a.length, ans = a[0];
            int [] l = new int [n], r = new int [n];
            l[0] = a[0];
            for (int i = 1; i < n; i++) {// l[]: max ending at idx i
                l[i] = Math.max(l[i-1] + a[i], a[i]);
                ans = Math.max(ans, l[i]); // 这里取的是不行使删除一个元素操作的最大子数组和
            }
            r[n-1] = a[n-1];
            for (int i = n-2; i >= 0; i--)
                r[i] = Math.max(r[i+1] + a[i], a[i]);
            for (int i = 1; i < n-1; i++) 
                ans = Math.max(ans, l[i-1] + r[i+1]);
            return ans;
        }
        // maximum subarray sum的变形，
        // 变形在于，答案在于咩有删除和有删除。
        // 没有删除：以每个index为结尾走一遍，得到最大值。
        // 有删除：以每个index为结尾和开头走一遍，然后删除i的结果 res = Math.max(res, end[i-1] + start[i+1]).
        // 再详细一点儿的分析： 
        // 这道题因为允许删除操作的存在，还是要记录每个位置的状态。
        // 若将i位置上的数字删除了，实际上原数组就被分为两个部分：[0, i-1] 和 [i+1, n-1]，
        // 由于是子数组，则 arr[i-1] 和 arr[i+1] 这两个数字一定要出现在子数组中，那这不就正好是 Kadane 算法定义的 dp 数组么（后半段的定义需要翻转一下），
        // 用个 maxEndHere[i] 表示在 [0, i] 范围内以 arr[i] 结尾的最大子数组之和，
        // 用个 maxStartHere[i] 表示在 [i, n-1] 范围内以 arr[i] 为起始的最大子数组之和，
        // 那么移除数字i的最大子数组之和就是 maxEndHere[i-1] + maxStartHere[i+1] 了
        public int maximumSum(int[] arr) {
            int n = arr.length;
            int [] maxEndHere = new int [n];
            int [] maxBgnHere = new int [n];
            maxEndHere[0] = arr[0];
            int res = maxEndHere[0];
            for (int i = 1; i < n; i++) { // 以 i 为下标、从零至 i 的最大了序列和
                maxEndHere[i] = Math.max(maxEndHere[i-1]+arr[i], arr[i]);
                res = Math.max(res, maxEndHere[i]);
            }
            maxBgnHere[n-1] = arr[n-1];
            for (int i = n-2; i >= 0; i--) 
                maxBgnHere[i] = Math.max(maxBgnHere[i+1]+arr[i], arr[i]);
            for (int i = 1; i < n-1; i++) {
                if (arr[i] < 0) {
                    res = Math.max(res, maxEndHere[i-1]+maxBgnHere[i+1]);
                }
            }
            return res;
        }
        // 解法1：动态规划。跟 53. Maximum Subarray 比，多了一个变量，用来记录delete一个元素后的subarray最大值。
        // 题目中说删除一个元素是optional的，最终的结果在删除的最大值与不删除的最大值中出。思路比较曲折一点
        public int maximumSum(int[] arr) {
            int sum = arr[0], sumWithDeletion = 0, ans = arr[0];
            for (int i = 1; i < arr.size(); ++i){
                ans = max(ans, sumWithDeletion + arr[i]);
                sumWithDeletion = max(sumWithDeletion + arr[i], sum);
                sum = sum < 0 ? 0 : sum;
                sum += arr[i];
                ans = max(ans, sum);
            }
            return ans;
        }

        public int bestTeamScore(int [] scores, int [] ages) {
            int n = scores.length, max = 0;
            int [][] a = new int [n][];
            for (int i = 0; i < n; i++) 
                a[i] = new int [] {ages[i], scores[i]};
            Arrays.sort(a, (x, y)->x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]); // age increasing; score increasing
            int [] dp = new int [n]; // 这里的思路还没有想清楚
            for (int i = 0; i < n; i++) {
                dp[i] = a[i][1];
                for (int j = i-1; j >= 0; j--) 
                    if (a[j][0] <= a[i][0]) // j年龄比i小，不存在冲突
                        dp[i] = Math.max(dp[i], dp[j] + a[i][1]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        public boolean checkValidString(String t) {
            n = t.length();
            s = t.toCharArray();
            dp = new Boolean [n][n];
            return dfs(0, 0);
        }
        Boolean [][] dp; // 这个状态，不要搞成一维数组了
        char [] s;
        int n;
        private boolean dfs(int idx, int cnt) {
            if (cnt < 0) return false;
            if (idx == n) return cnt == 0;
            // if (idx < n && cnt < 0) return false;
            if (dp[idx][cnt] != null) return dp[idx][cnt];
            boolean ans = false;
            if (s[idx] == '(') ans = dfs(idx+1, cnt+1);
            else if (s[idx] == ')') ans = dfs(idx+1, cnt-1);
            else ans = dfs(idx+1, cnt-1) || dfs(idx+1, cnt) || dfs(idx+1, cnt+1);
            return dp[idx][cnt] = ans;
        }

        public int numOfArrays(int n, int m, int k) {
            dp = new Integer [n+1][m+1][k+1];
            return dfs(n, -1, k, m);
        }
        int mod = (int)1e9 + 7;
        Integer [][][] dp;
        private int dfs(int idx, int cur, int k, int limit) {
            if (k < 0 || idx < 0) return 0;
            if (idx == 0 && k == 0) return 1; // 唯一一种情况是空数组
            // if (idx == 0) return k == 0 ? 1 : 0;
            if (cur != -1 && dp[idx][cur][k] != null) return dp[idx][cur][k];
            long ans = 0;
            for (int i = 1; i <= limit; i++) 
                ans = (ans + dfs(idx-1, Math.max(cur, i), cur < i ? k-1 : k, limit)) % mod;
            if (cur != -1)
                dp[idx][cur][k] = (int)ans;
            return (int)ans;
        }
        public int numOfArrays(int n, int m, int k) {
            this.n = n;
            dp = new Integer [n][m+1][k+1];
            return dfs(0, 0, k, m);
        }
        int mod = (int)1e9 + 7;
        Integer [][][] dp; // 这里不要用int
        int n;
        private int dfs(int idx, int cur, int k, int limit) {
            if (k < 0) return 0; 
            if (idx == n) return k == 0 ? 1 : 0;
            if (dp[idx][cur][k] != null) return dp[idx][cur][k]; // != null 就可以提速，原本解法没问题
            long ans = 0;
            for (int i = 1; i <= limit; i++) 
                ans = (ans + dfs(idx+1, Math.max(cur, i), cur < i ? k-1 : k, limit)) % mod;
            return dp[idx][cur][k] = (int)ans;
        }
        // (动态规划) O(nkm)O(nkm)
        // 设 f(i,c,j)f(i,c,j) 表示填充了前 ii 个位置，search_cost 为 cc，且最大值为 jj 时的方案数。
        // 初始时 f(1,1,j)=1f(1,1,j)=1，其余为 0。
        //     转移时，对于 f(i,c,j)f(i,c,j)，
        //     如果上一个位置结尾时，最大值已经为 jj，则我们这个位置有 jj 种方案（即填 1 到 jj），且不需要增加花费，可以累加 f(i−1,c,j)∗jf(i−1,c,j)∗j。
        //     如果上一个位置结束时最大值不到 jj，则我们需要这个位置填 jj，即一种方案，且需要增加花费。此时可以累加 ∑j−1l=1f(i−1,c−1,l)∑l=1j−1f(i−1,c−1,l) 的和。
        //     我们不妨用 g(i,c,j)g(i,c,j) 来表示 f(i,c,j)f(i,c,j) 在第三维上的前缀和，则第二个转移就是累加 g(i−1,c−1,j−1)g(i−1,c−1,j−1)。
        //     最终答案为 g(n,k,m)g(n,k,m)。
        //     时间复杂度
        //     状态数为 O(nkm)O(nkm)，采用了辅助数组 gg，转移时间为常数，故总时间复杂度为 O(nkm)O(nkm)。
        //     空间复杂度
        //     需要额外 O(nkm)O(nkm) 的空间存储状态。
        //     可以通过滚动数组优化到 O(km)O(km)
        public int numOfArrays(int n, int m, int k) { // todo: 动态规划的解法 
            int mod = 1_000_000_007;
            long[][][] dp = new long[n+1][k+1][m+1];
            long[][][] g = new long[n+1][k+1][m+1];
            Arrays.fill(dp[1][1], 1);
            for (int j = 1; j <= m; j++)
                g[1][1][j] = j;
            for (int i = 2; i <= n; i++) {
                for (int c = 1; c <= k; c++) {
                    for (int j = 1; j <= m; j++) {
                        dp[i][c][j] = (dp[i-1][c][j] * j + g[i-1][c-1][j-1]) % mod;
                        g[i][c][j] = (g[i][c][j-1] + dp[i][c][j]) % mod;
                    }
                }
            }
            return (int)g[n][k][m];
        }

        public int numMusicPlaylists(int n, int goal, int k) {
            long mod = (int)1e9 + 7;
            long [][] dp = new long [goal+1][n+1]; // dp[i][j]: 播完i首用了j首不同的曲子，分第爱首播不播第这首两种情况
            // 要怎么初始化呢？
            for (int j = 1; j <= k; j++) 
                dp[1][j] = n;
            return (int)dp[goal][n];
        }

        // 记 dp[i][j] = v 表示s[0:j]区间内分割成j段，只需要改变v个字符就可以使得每一段的子串都是回文串。
        //     要求dp[i][j]的值，关键就是找出j和j-1的分割点。
        //     很显然有dp[i][j] = min(dp[m][j-1] + s[m:j]需要改变的字符的个数)，只需要找出最小的分割点m即可。        
        public int palindromePartition(String t, int k) { // todo: 不知道哪里的细节错了，改天再改 dfs记忆化搜索 会写，可是dp不太会写 
            int n = t.length();
            // if (k == n) return 0;
            char [] s = t.toCharArray();
            Map<String, Integer> m = new HashMap<>();
            for (int i = 0; i < n; i++) 
                for (int j = i+1; j <= n; j++) {
                    String cur = t.substring(i, j);
                    if (!m.containsKey(cur)) m.put(cur, getCnt(cur));
                }
            int [][] dp = new int [n][k+1];
            for (int i = 0; i < n; i++) 
                Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            dp[0][0] = 0;
            // for (int i = 0; i < n; i++) 
            //     dp[i][1] = m.get(t.substring(0, i+1));
            for (int d = 1; d <= k; d++) 
                for (int i = 0; i < n; i++) {
                    int min = Integer.MAX_VALUE;
                    for (int j = 0; j < i; j++) 
                        min = Math.min(min, dp[j][d-1] + m.get(t.substring(j+1, i+1)));
                    dp[i][d] = Math.min(dp[i][d], min);
                }
            System.out.println("dp.length: " + dp.length);
            for (int z = 0; z < dp.length; ++z) 
                System.out.println(Arrays.toString(dp[z]));
            return dp[n-1][k];
        }
        private int getCnt(String t) {
            int n = t.length(), cnt = 0;
            char [] s = t.toCharArray();
            int i = 0, j = n-1;
            while (i < j) {
                if (s[i] != s[j]) cnt++;
                i++;
                j--;
            }
            return cnt;
        }
        // 记 dp[i][j] = v 表示s[0:j]区间内分割成j段，只需要改变v个字符就可以使得每一段的子串都是回文串。
        //     要求dp[i][j]的值，关键就是找出j和j-1的分割点。
        //     很显然有dp[i][j] = min(dp[m][j-1] + s[m:j]需要改变的字符的个数)，只需要找出最小的分割点m即可。        
        public int palindromePartition(String t, int k) { // 不知道哪里的细节错了，改天再改
            n = t.length();
            s = t.toCharArray();
            m = new HashMap<>();
            this.t = t;
            for (int i = 0; i < n; i++) 
                for (int j = i+1; j <= n; j++) {
                    String cur = t.substring(i, j);
                    if (!m.containsKey(cur)) m.put(cur, getCnt(cur));
                }
            dp = new Integer [n][k+1];
            return dfs(0, k);
        }
        Map<String, Integer> m;
        Integer [][] dp;
        String t;
        char [] s;
        int n;
        private int dfs(int i, int k) {
            if (i == n) return 0;
            if (k == 1) return m.get(t.substring(i));
            if (dp[i][k] != null) return dp[i][k];
            int ans = Integer.MAX_VALUE;
            for (int j = i+1; j <= n-k+1; j++) 
                ans = Math.min(ans, dfs(j, k-1) + m.get(t.substring(i, j)));
            return dp[i][k] = ans;
        }

        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            n = locations.length;
            dp = new Integer [n][fuel+1];
            return dfs(start, fuel, finish, locations);
        }
        int mod = (int)1e9 + 7;
        Integer [][] dp; // 第二次： Integer 狠重要，otherwise tle !
        int n;
        private int dfs(int u, int f, int end, int [] a) {
            // if (f < 0) return 0; // 因为前面检查过，这个状态不存在了
            if (f == 0) return u == end ? 1 : 0;
            if (dp[u][f] != null) return dp[u][f];
            long ans = 0;
            if (u == end) ans = 1;
            for (int i = 0; i < a.length; i++) {
                if (i == u || Math.abs(a[i] - a[u]) > f) continue;
                ans = (ans + dfs(i, f - Math.abs(a[i]-a[u]), end, a)) % mod;
            }
            return dp[u][f] = (int)ans;
        }

        public int minDeletionSize(String[] ss) { // 寻找每个字符串的最长递增子序列--》寻找多个字符串的递增子序列
            int m = ss.length, n = ss[0].length(), max = 1;
            int [] dp = new int [n];
            Arrays.fill(dp, 1); // 不要忘记了 ！！！
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    valid = true;
                    for (int k = 0; k < m; k++) 
                        if (ss[k].charAt(j) > ss[k].charAt(i)) {
                            valid = false;
                            break;
                        }
                    if (valid)
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
            return n - max;
        }

        public int maxValue(int[][] en, int k) {
            n = en.length;
            dp = new int [n][k+1];
            Arrays.sort(en, (a, b)->a[0] - b[0]);
            return dfs(en, 0, k);
        }
        int [][] dp;
        int n;
        private int dfs(int [][] a, int i, int k) {
            if (i == n || k == 0) return 0;
            if (dp[i][k] > 0) return dp[i][k];
            int idx = binarySearch(a, i+1, a[i][1]);
            return dp[i][k] = Math.max(a[i][2] + (idx == -1 ? 0 : dfs(a, idx, k-1)), dfs(a, i+1, k));
        }
        private int binarySearch(int [][] a, int l, int v) {
            int r = a.length-1;
            int ans = -1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (a[m][0] > v) {
                    ans = m;
                    r = m-1;
                } else l = m + 1;
            }
            return ans;
        }

        public int minCost(int[] houses, int[][] cost, int m, int n, int target) { 
            this.m = m;
            this.n = n;
            dp = new Integer [m][n+1][target+1];
            return dfs(0, -1, target, houses, cost);
        }
        Integer [][][] dp; // dp[i][j][k]: the minimum cost where we have k neighborhoods in the first i houses and the i-th house is painted with the color j.
        int m, n;
        private int dfs(int i, int j, int k, int [] h, int [][] c) {
            if (target < 0) return 0;
            if (i == m) return target == 0 ? 1 : 0;
            if (dp[i][j][k] != null) return dp[i][j][k];
            int ans = 0;
            if (h[i] > 0 && h[i] != j) return dp[i][j][k] = Integer.MAX_VALUE;
            // 这里的递推 还有点儿不清楚
        }

        public int minTaps(int n, int[] r) {
            int [][] a = new int [n+1][];
            for (int i = 0; i <= n; i++) 
                a[i] = new int [] {i-r[i], i + r[i]};
            Arrays.sort(a, (x, y)-> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            int j = 0, cnt = 0;
            if (a[0][0] > 0) return -1;
            for (int i = 0; i < n; i++) {
                j = i+1;
                while (j < n && a[j][0] < a[i][1]) {
                }
            }
        }

        // public int [] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        public int smallestSufficientTeam(String[] req_skills, List<List<String>> people) { // bug: 有些什么地方没有写对
            Map<String, Integer> m = new HashMap<>();
            for (int i = 0; i < req_skills.length; i++) 
                m.put(req_skills[i], i);
            int range = 1 << req_skills.length;
            int [] dp = new int [range];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i < people.size(); i++) {
                // for (List<String> p : people) {
                int cur = 0;
                for (String s : people.get(i)) 
                    if (m.keySet().contains(s)) cur |= (1 << m.get(s));
                // System.out.println("Integer.toBinaryString(cur): " + Integer.toBinaryString(cur));
                dp[cur] = 1;
                for (int j = 0; j < range; j++) {
                    if ((j & cur) == cur)
                        dp[j] = Math.min(dp[j], dp[j ^ cur] + 1 ); // 有可能遍历的方向可以反着来？
                }
                // for (int i = range-1; i >= cur; i--) {
                //     // if (dp[i] != Integer.MAX_VALUE && (i & cur) == cur)
                //     if ((i & cur) == cur)
                //         dp[i] = Math.min(dp[i], dp[i ^ cur] + 1);
                // }
            }
            System.out.println(Arrays.toString(dp));
            return dp[range-1];
        }
        // String []  a = new String []  {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
        // String [][] b = new String [][] {{"algorithms","math","java"},{"algorithms","math","reactjs"},{"java","csharp","aws"},{"reactjs","csharp"},{"csharp","math"},{"aws","java"}};
        // String []  a = new String []  {"java", "nodejs", "reactjs"};
        // String [][] b = new String [][] {{"java"},{"nodejs"},{"nodejs","reactjs"}};
        // List<List<String>> ll = new ArrayList<>();
        // for (int i = 0; i < b.length; i++) 
        //     ll.add(Arrays.asList(b[i]));

        public int dieSimulator(int n, int [] r) { // DP(pos, last) which means we are at the position pos having as last the last character seen.
            long mod = (int)1e9 + 7;
            long [][] dp = new long [n][7];
            int [] cnt = new int [7];
            Arrays.fill(cnt, 1);
            for (int i = 1; i < 7; i++) dp[0][i] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < 7; j++) {
                    if (dp[i-1][j] == 0) continue;
                    for (int k = 1; k < 7; k++) {
                        if (j != k) {
                            dp[i][k] = (dp[i][k] + dp[i-1][j]) % mod;
                            cnt[k] = 1;
                        } else if (j == k && cnt[j] < r[j-1]) {
                            dp[i][k] = (dp[i][k] + dp[i-1][k]) % mod;
                            cnt[k]++;
                        } else if ()  // 这么着好像没有纪录连续多少次同一个数字
                    }
                }
            }
        }
        public int dieSimulator(int n, int [] r) { // DP(pos, last) which means we are at the position pos having as last the last character seen.
            this.n = n;
            dp = new long [n+1][7][16];
            long ans = 0;
            // for (int i = 1; i < 7; i++) 
            //     ans = (ans + dfs(n-1, i, 1, r)) % mod;
            // return (int)ans;
            return (int)dfs(n, -1, 0, r);
        }
        int mod = (int)1e9 + 7;
       long [][][] dp;
        int n;
        private long dfs(int i, int j, int k, int [] a) { // 感觉自项向下、自底向上，这里的上下方向有些混乱，条理不清楚
            if (i <= 0) return 0;
            if (i == 1) return k < a[j-1] ? 1 : 0;
            if (j != -1 && dp[i][j][k] > 0) return dp[i][j][k];
            long ans = 0;
            for (int x = 1; x < 7; x++) {
                if (j == -1 || j != x)
                    ans = (ans + dfs(i-1, x, 1, a)) % mod;
                if (j == x && k < a[j-1])
                    ans = (ans + dfs(i-1, j, k+1, a)) % mod;
                // else if (j == x && k = a[j-1])
            }
            if (j != -1)
                dp[i][j][k] = ans;
            return ans;
            // return dp[i][j][k] = ans;
        }

        public int minHeightShelves(int [][] b, int w) { 
            int n = b.length, curLayerWidth = 0, max = 0;
            int [] dp = new int [n+1];
            Arrays.fill(dp, n+1);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {   // 依次求摆放前i本书的最小高度
                dp[i] = dp[i-1] + b[i-1][1]; // 初始化为最大值：单列一行，再看之前的行有没有空隙可以放入之前的层？
                curLayerWidth = b[i-1][0];
                 max = b[i-1][1];
                for (int j = i-1; j > 0 && curLayerWidth + b[j-1][0] <= w; j--) { // 将前i - 1本书从第i - 1本开始放在与i同一层，直到这一层摆满或者所有的书都摆好
                    curLayerWidth += b[j-1][0];
                    max = Math.max(max, b[j-1][1]);
                    // dp[i] = Math.min(dp[i], dp[j] + max);  // bug: dp[j] + max 是从第j本开始，包括第j本，这与之后的书放到最后一层所能形成的最小高度
                    dp[i] = Math.min(dp[i], dp[j - 1] + max); // 所以，是用j之前所开成的最小高度，dp[j-1]加上最后一层所能形成的最小高度
                }
            }
            return dp[n];
        }

        public int combinationSum4(int[] a, int target) { // 如果临时想不出动态规划，也可以用带记忆化的来搜索
            dp = new int[target + 1];
            Arrays.fill(dp, -1);
            dp[0] = 1;
            return helper(a, target);
        }
        int [] dp;
        private int helper(int[] a, int target) {
            if (dp[target] != -1) return dp[target];
            int res = 0;
            for (int i = 0; i < a.length; i++) 
                if (target >= a[i]) 
                    res += helper(a, target - a[i]);
            dp[target] = res;
            return dp[target];
        }
        public int combinationSum4(int[] a, int target) { // 带记忆化的来搜索,用数组还是用图，可能也看数据规模吧
            return helper(a, target);
        }
        Map<Integer, Integer> dp = new HashMap<>();
        private int helper(int[] a, int target) {
            if (target < 0) return 0;
            if (target == 0) return 1;
            if (dp.containsKey(target)) return dp.get(target);
            int ans = 0;
            for (int i = 0; i < a.length; i++) 
                ans += helper(a, target-a[i]);
            dp.put(target, ans);
            return ans;
        }
        public int combinationSum4(int[] a, int target) { // 如果是不同的序列会被认为是不同的
            int n = a.length;
            int [] dp = new int [target + 1];
            dp[0] = 1;
            for (int i = 1; i <= target; i++) 
                for (int j = 0; j < n; j++) 
                    if (i - a[j] >= 0)
                        dp[i] += dp[i - a[j]];
            return dp[target];
        }
        public int combinationSum4(int[] a, int target) { // if target 远大于 数组元素个数
            int n = a.length;
            Arrays.sort(a);
            int [] dp = new int [target + 1];
            dp[0] = 1;
            for (int i = 1; i <= target; i++)
                for (Integer v : a) {
                    if (i < v) break;
                    dp[i] += dp[i-v];
                }
            return dp[target];
        }

        public List<Integer> largestDivisibleSubset(int[] a) { // 出来一个新题: 恁是认不是它是dfs记忆化搜索，岂不是很悲催？
            Arrays.sort(a);
            n = a.length;
            dp = new List [n];
            for (int i = 0; i < n; i++) {
                List<Integer> cur = dfs(a, i, 1);
                if (cur.size() > ans.size())
                    ans = cur;
            }
            return ans;
        }
        List<Integer> ans = new ArrayList<>();
        List<Integer> [] dp;
        int n;
        // pre: dfs路径中前一节点
        // 返回值：当前节点的倍数数组（包含当前节点）
        private List<Integer> dfs(int [] a, int i, int pre) { 
            int cur = a[i];
            if (cur % pre != 0) return new ArrayList<>(); 
            if (dp[i] != null) return dp[i]; // 记忆数组存在当前结果的话直接返回，避免重复计算
            List<Integer> maxList = new ArrayList<>();
            for (int j = i+1; j < n; j++) {
                List<Integer> tmp = dfs(a, j, cur);
                if (tmp.size() > maxList.size())
                    maxList = new ArrayList<>(tmp);
                // maxList = tmp; // bug: 
            }
            maxList.add(cur); // 将当前节点加入到集合中, 有点儿回溯的样子，把路径中的数字反序加了回来
            dp[i] = maxList;  // 将当前结果存入记忆数组
            return maxList;
        }
        public List<Integer> largestDivisibleSubset(int[] a) { // todo: 
            if (a == null || a.length == 0) return new ArrayList();
            Arrays.sort(a);
            int n = a.length;
            HashMap<Integer, Integer> dp = new HashMap();
            HashMap<Integer, Integer> pre = new HashMap();
            for (int i = 0; i < n; i++) {
                dp.put(a[i], 1);
                pre.put(a[i], -1);
            }
            int lastNum = a[0];
            for (int i = 0; i < n; i++) {
                int num = a[i];
                for (Integer factor : getFactors(num)) {
                    if (!dp.containsKey(factor)) continue;
                    if (dp.get(num) < dp.get(factor) + 1) {
                        dp.put(num, dp.get(factor) + 1);
                        pre.put(num, factor);
                    }
                }
                if (dp.get(num) > dp.get(lastNum)) 
                    lastNum = num;
            }
            return getPath(pre, lastNum);
        }
        private List<Integer> getPath(HashMap<Integer, Integer> pre, int lastNum) {
            List<Integer> path = new ArrayList();
            while (lastNum != -1) {
                path.add(lastNum);
                lastNum = pre.get(lastNum);
            }
            Collections.reverse(path);
            return path;
        }
        private List<Integer> getFactors(int num) {
            List<Integer> factors = new ArrayList();
            if (num == 1) return factors;
            int factor = 1;
            while (factor * factor <= num) {
                if (num % factor == 0) {
                    factors.add(factor);
                    if (factor != 1 && num / factor != factor) // 这里会把所有质因子的倍数也加进去，怕数组中不存在最小质因子，而是存在其某个倍数？
                        factors.add(num / factor);
                }
                factor++;
            }
            return factors;
        }
        public List<Integer> largestDivisibleSubset(int[] nums) { // todo
            int n = nums.length;
            List<Integer> ans = new ArrayList<Integer>();
            if (n < 2) {
                if (n == 0) return ans;
                ans.add(nums[0]);
                return ans;
            }
            Arrays.sort(nums);
            int[] preFactIdx = new int[n];
            int[] factCnt = new int[n];
            int maxlength = 0;
            int maxnum = 0;
            for (int i = n-1; i >= 0; i--) 
                for (int j = i; j < n; j++) 
                    if (nums[j] % nums[i] == 0 && factCnt[i] < factCnt[j]+1) {
                        factCnt[i] = factCnt[j]+1;
                        preFactIdx[i] = j;
                        if (factCnt[i] > maxlength) {
                            maxlength = factCnt[i];
                            maxnum = i;
                        }
                    }
            for (int i = 0; i < maxlength; i++) {
                ans.add(nums[maxnum]);
                maxnum = preFactIdx[maxnum];
            }
            return ans;
        }

        public double champagneTower(int p, int r, int c) { // 障碍点是：无法将它给出的图与解题中的下标快速对应起来 
            double [][] dp = new double [101][101];
            dp[0][0] = p;
            for (int i = 0; i <= r; i++) 
                for (int j = 0; j <= i; j++) // 相当于算到一定范围内的最大值了
                    if (dp[i][j] > 1) {
                        dp[i+1][j] += (dp[i][j] - 1.0) / 2.0;
                        dp[i+1][j+1] += (dp[i][j] - 1.0) / 2.0;
                    }
            // return dp[r][c]; // bug: mmi: 是因为计算double除法的过程中使用其有可能微大于1.0吗？
            return Math.min(1.0, dp[r][c]); // mmi: 是因为计算double除法的过程中使用其有可能微大于1.0吗？
        }

        public int maxTurbulenceSize(int[] a) {
            int n = a.length;
            if (n == 1) return 1;
            if (n == 2) return a[0] == a[1] ? 1 : 2;
            int [] dp = new int [n];
            Arrays.fill(dp, 1);
            int max = 1;
            int i = 0;
            boolean valid = false;
            for (i = 1; i < n-1; i++) {
                if (a[i-1] < a[i] && a[i] > a[i+1] || a[i-1] > a[i] && a[i] < a[i+1]) {
                    dp[i] = Math.max(dp[i], valid ? dp[i-1] + 1 : 2);
                    dp[i+1] = Math.max(dp[i+1], dp[i]+1);
                    if (!valid) valid = true;
                } else valid = false;
                max = Math.max(max, dp[i]); // max取了dp[0, n-2]范围内的最大值
            }
            max = Math.max(max, dp[i]);     // 也取与dp[n-1]相比之后的最大值
            if (max == 1) {
                if (Arrays.stream(a).distinct().count() == 1) return 1;
                return 2;
            }
            return max;
        }
        public int maxTurbulenceSize(int[] arr) {
            int n = arr.length;
            if (n < 2) return n;
            int left = 0;
            int right = 1;
            boolean pre = false; // 为 true 表示 arr[i - 1] < arr[i]
            int res = 1;
            while (right < n) {
                boolean current = arr[right - 1] < arr[right];
                if (current == pre) 
                    left = right - 1;
                if (arr[right - 1] == arr[right]) 
                    left = right;
                right++;
                res = Math.max(res, right - left);
                pre = current;
            }
            return res;
        }
        public int maxTurbulenceSize(int[] arr) {
            int n = arr.length;
            if (n < 2) return n;
            int[] up = new int[n]; // 以 arr[i] 结尾，并且 arr[i - 1] < arr[i] 的湍流子数组的长度
            int[] dn = new int[n]; // 以 arr[i] 结尾，并且 arr[i - 1] > arr[i] 的湍流子数组的长度
            Arrays.fill(up, 1);
            Arrays.fill(dn, 1);
            int res = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] < arr[i]) 
                    up[i] = dn[i - 1] + 1;
                else if (arr[i - 1] > arr[i]) 
                    dn[i] = up[i - 1] + 1;
                res = Math.max(res, Math.max(up[i], dn[i]));
            }
            return res;
        }

        public int maxProfit(int[] p) { 
            int n = p.length;
            int [] sold = new int [n];
            int [] hold = new int [n];
            hold[0] = -p[0]; // 因为买进投资了，还没有产出，所以是负数
            for (int i = 1; i < n; i++) {
                // sold[i] = Math.max(p[i] + hold[i-1], (i > 2 ? sold[i-2] : 0));               // bug: 卖或不卖
                // hold[i] = Math.max((i > 2 ? sold[i-2] : 0) - p[i], (i > 2 ? sold[i-2] : 0)); // bug: 买或不买: 因为卖完要休息一天，只能是最早前2天的结果
                sold[i] = Math.max(p[i] + hold[i-1], sold[i-1]);               // 卖或不卖
                hold[i] = Math.max((i > 2 ? sold[i-2] : 0) - p[i], hold[i-1]); // 买或不买: 因为卖完要休息一天，只能是最早前2天的结果
            }
            return Math.max(hold[n-1], sold[n-1]);
        }

        public int maxProfit(int[] p) { // bug, to be finished
            int n = p.length, lmin = 0, lmax = 0, gmax = 0;
            int [] l = new int [n];
            int [] r = new int [n];
            lmin = p[0];
            lmax = p[0];
            for (int i = 1; i < n; i++) {
                if (p[i] < lmin) {
                    gmax = Math.max(gmax, lmax - lmin);
                    lmin = p[i];
                    lmax = 0;
                } else {
                    lmax = Math.max(lmax, p[i]);
                    gmax = Math.max(gmax, lmax - lmin);
                }
                l[i] = gmax;
            }
            lmin = p[n-1];
            lmax = p[n-1];
            gmax = 0;
            for (int i = n-2; i >= 0; i--) {
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
            }
            gmax = 0;
            for (int i = 1; i < n; i++) 
                gmax = Math.max(gmax, l[i] + r[i]);
            return gmax;
        }


        public int nthUglyNumber(int n) {
            if (n <= 5) return n;
            int [] a = new int [n];
            a[0] = 1;
            int i = 0, ii = 0, iii = 0; // idx
            int f = 2, ff = 3, fff = 5; // 三个list里的队首最小值
            for (int j = 1; j < n; j++) {
                int min = Math.min(Math.min(f, ff), fff); 
                a[j] = min;
                if (f == min) f = 2 * a[++i];    // 不是 else if，对产生的 f, ff == fff 公倍数数字自动滤掉
                if (ff == min) ff = 3 * a[++ii];
                if (fff == min) fff = 5 * a[++iii];
            }
            return a[n-1];
        }

        public int nthSuperUglyNumber(int n, int[] primes) {
            int m = primes.length;
            int [] ans = new int[n]; // 存放1-n个SuperUglyNumber
            ans[0] = 1;              // 第一个SuperUglyNumber是1
            int [] next = new int[m];
            for (int i=0; i < m; i++)
                next[i] = 0;         // 初始化
            int cnt = 1, min = Integer.MAX_VALUE, tmp = 0;
            while (cnt < n) {
                min = Integer.MAX_VALUE;
                for (int i = 0; i < m; i++){
                     tmp = ans[next[i]] * primes[i];
                     min = Math.min(min, tmp);
                }
                for (int i = 0; i < m; i++)
                    if (min == ans[next[i]] * primes[i])
                        next[i]++;
                ans[cnt++] = min;			
            }
            return ans[n-1];		
        }
        public int nthSuperUglyNumber(int n, int[] p) {
            int m = p.length;
            int [] a = new int [n];   // ans
            int [] idx = new int [m]; // idx times prime idx 想像成m个链表，纪录这些链表的当前下标
            a[0] = 1;
            for (int i = 1; i < n; i++) {
                a[i] = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) 
                    a[i] = Math.min(a[i], p[j] * a[idx[j]]);
                for (int j = 0; j < m; j++) 
                    if (p[j] * a[idx[j]] == a[i]) // 如果存在重复，那么多个下标可能同时更新指向下一个to avoid repeat
                        idx[j]++;
            }
            return a[n-1];
        }
        public int nthSuperUglyNumber(int n, int[] p) { // Let's store the candidate instead of calculating it again?
            int m = p.length;
            int [] a = new int [n];   
            a[0] = 1;
            Queue<int []> q = new PriorityQueue<>((x, y)->x[0] - y[0]);
            for (int i = 0; i < m; i++) 
                q.offer(new int []{p[i], 0, p[i]}); // 0 is the ugly no, 1 is the index, 2 is the prime number
            for (int i = 1; i < n; i++) {
                int next = q.peek()[0];
                a[i] = next;
                while (q.peek()[0] == next) { // 相比于O(M)的时间遍历一次prime,这里用O(logM)的时间作更新
                    int [] cur = q.poll();    // 效率没有显著提高：这里插入和删除也是很耗时的
                    cur[0] = cur[2] * a[cur[1]];
                    cur[1]++;
                    q.offer(cur);
                }
            }
            return a[n-1];
        }
        public int nthSuperUglyNumber(int n, int[] p) {
            int m = p.length;
            int [] a = new int [n];   
            int [] idx = new int [m]; 
            a[0] = 1;
            for (int i = 1; i < n; i++) {
                a[i] = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) { // try to finish this using ONE Pass
                    if (p[j] * a[idx[j]] == a[i-1]) 
                        idx[j]++;
                    a[i] = Math.min(a[i], p[j] * a[idx[j]]);
                }
            }
            return a[n-1];
        }

        public int numberOfSets(int n, int k) { 
            if (k == n-1) return 1;
            this.n = n;
            dp = new Long [n][k+1];
            return (int)dfs(0, k);
        }
        long mod = (int)1e9 + 7;
        Long [][] dp; // have to be Long, Integer overflow
        int n;
        private long dfs(int idx, int k) {
            if (dp[idx][k] != null) return dp[idx][k];
            if (k == 0) return 1;
            long ans = 0;
            for (int i = idx+1; i < n; i++)
                ans += (i - idx) * dfs(i, k-1);
            return dp[idx][k] = ans % mod;
        }
        public int numberOfSets(int n, int k) {
            int mod = (int)1e9 + 7;
            long [][][] dp = new long [n][k+1][2]; // dp[i][j][0/1]: 0, 1, 2 ... i形成j段线段，并且第j段线段是1（否0）以点i结尾
            dp[0][0][0] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= k; j++) {
                    dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % mod;
                    dp[i][j][1] = dp[i-1][j][1];
                    if (j > 0)
                        dp[i][j][1] = (dp[i][j][1] + dp[i-1][j-1][0] + dp[i-1][j-1][1]) % mod; 
                }
            }
            return (int)((dp[n-1][k][0] + dp[n-1][k][1]) % mod);
        }
        int mod = 1_000_000_007;
        public int numberOfSets(int n, int k) { // tle
            long[][] dp = new long[n][k + 1];
            dp[0][0] = 1;
            for (int i = 0; i < n; i++) 
                for (int j = 0; j <= Math.min(k, i); j++) {
                    if (i > 0) dp[i][j] = dp[i - 1][j];
                    if (j > 0) 
                        for (int h = i - 1; h >= 0; h--) 
                            dp[i][j] = (dp[i][j] + dp[h][j - 1]) % mod;
                }
            return (int)dp[n - 1][k];
        }
        int mod = 1_000_000_007;
        public int numberOfSets(int n, int k) {
            long[][] dp = new long[n][k + 1];
            dp[0][0] = 1;
            long[] sums = new long[k + 1];
            for (int i = 0; i < n; i++) 
                for (int j = Math.min(k, i); j >= 0; j--) {
                    if (i > 0) dp[i][j] = dp[i - 1][j];
                    if (j > 0) dp[i][j] = (sums[j - 1] + dp[i][j]) % mod;
                    sums[j] = (sums[j] + dp[i][j]) % mod;
                }
            return (int)dp[n - 1][k];
        }

        public int countPaths(int n, int[][] roads) { // 这个题改天再重新写一遍吧
            this.n = n;
            for (int [] e : roads) {
                adj.computeIfAbsent(e[0], z -> new ArrayList<>()).add(new int [] {e[1], e[2]});;
                adj.computeIfAbsent(e[1], z -> new ArrayList<>()).add(new int [] {e[0], e[2]});;
            }
            dijestra(); // 这里我都是分步进行的：找出最短距离后，重新建图、再重新搜路数，但其实这三步可以一遍pass一次遍历就能完成，不用分三次：把分的三步合成一次遍历
            for (int [] e : roads) {
                int u = e[0], v = e[1];
                if (Math.abs(dist[u] - dist[v]) == e[2]) {
                    if (dist[u] < dist[v])
                        map.computeIfAbsent(v, z -> new ArrayList<>()).add(u);
                    else
                        map.computeIfAbsent(u, z -> new ArrayList<>()).add(v);
                }
            }
            return dfs(0);
        }
        Map<Integer, List<int []>> adj = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>(); // 不再是无向图，已经是有向图了（终于自己悟出来，第一次看答案居然还不明白怎么莫名其妙就变单向了。。。）
        Map<Integer, Integer> dp = new HashMap<>();        // 这里是不需要记忆化搜索的吗 n <= 200 应该还是需要的吧
        int mod = (int)1e9 + 7;
        long [] dist;
        int n;
        private int dfs(int u) {
            if (u == n-1) return 1;
            if (dp.containsKey(u)) return dp.get(u);
            if (map.get(u) == null || map.get(u).size() == 0) {
                dp.put(u, 0);
                return 0;
            }
            long ans = 0;
            for (int v : map.get(u)) 
                ans = (ans + dfs(v)) % mod;
            dp.put(u, (int)ans);
            return (int)ans;
        }
        private void dijestra() {
            dist = new long [n];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[n-1] = 0l;
            Queue<long []> q = new PriorityQueue<long []>((a, b) -> (int)(a[1] - b[1])); // int [] shold work too and easier
            q.offer(new long []{n-1, 0l});
            while (!q.isEmpty()) {
                long [] u = q.poll();
                if (dist[(int)u[0]] < u[1]) continue;
                if (adj.get((int)(u[0])) == null) continue;
                for (int [] v : adj.get((int)u[0])) 
                    if ((long)v[1] + (long)u[1] < dist[v[0]]) {
                        dist[v[0]] = u[1] + v[1];
                        q.offer(new long [] {v[0], dist[(int)v[0]]});
                    }
            }
        }
        public int countPaths(int n, int[][] roads) { // 别人的方法写得好简洁呀
            int mod = (int)1e9 + 7;
            int[][] adj = new int[n][n];
            for(int[] e : roads){
                adj[ e[0] ][ e[1] ] = e[2];
                adj[ e[1] ][ e[0] ] = e[2];
            }
            int[] time = new int[n], cnt = new int[n];
            Arrays.fill(time, 1, n,  Integer.MAX_VALUE); // 嗯，学习了
            cnt[0] = 1;
            Queue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
            q.offer(new int [] {0,0});  
            while (!q.isEmpty()) {
                int [] e = q.poll();
                int v = e[0], t = e[1];
                if (t <= time[v]) {
                    for (int i = 0; i < n; i++) 
                        if (adj[v][i] != 0) {
                            if (time[v] + adj[v][i] < time[i]) { 
                                time[i] = time[v] + adj[v][i]; 
                                q.offer (new int[] {i, time[i]});
                                cnt[i] = cnt[v];
                            } else if (time[v]+adj[v][i] == time[i]) 
                                cnt[i] =  (cnt[i]+cnt[v])%mod;
                        }
                }
            }
            return cnt[n-1];
        }
        int[] dist;
        long[] dp;
        public void findDis(Map<Integer, List<int[]>> graph){
            PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> (a[1]- b[1]));
            pq.add(new int[]{0, 0});
            dist[0]=0;
            dp[0]=1;
            while(!pq.isEmpty()){
                int[] top=pq.poll();
                int u=top[0], d=top[1];
                if(dist[u]< d) // new edit
                    continue;
                for(int[] v: graph.get(u)){
                    if(dist[v[0]] > d + v[1]){
                        dist[v[0]] = d+v[1];
                        dp[v[0]]=dp[u];
                        pq.offer(new int[]{v[0], dist[v[0]]});
                    }else{
                        if(dist[v[0]] == d+v[1]){
                            dp[v[0]]+=dp[u];
                            dp[v[0]]%= 1_000_000_007;
                        }
                    }
                }
            }
        }
        public int countPaths(int n, int[][] roads) {
            dist=new int[n];
            dp=new long[n];
            Map<Integer, List<int[]>> graph=new HashMap();
            Arrays.fill(dist, Integer.MAX_VALUE);
            for(int i=0;i<n;i++)
                graph.put(i, new ArrayList());
            for(int[] e: roads){
                graph.get(e[0]).add(new int[]{e[1], e[2]});
                graph.get(e[1]).add(new int[]{e[0], e[2]});
            }
            findDis(graph);
            return (int)dp[n-1]%1_000_000_007;
        }
        public int countPaths(int n, int[][] roads) {
            int [][] map = new int [n][n];
            for (int i = 0; i < n; i++)
                Arrays.fill(map[i], -1);
            int u = 0, v = 0, t = 0;
            for (int i = 0; i < roads.length; i++) {
                u = roads[i][0];
                v = roads[i][1];
                t = roads[i][2];
                map[u][v] = t;
                map[v][u] = t;
            }
            int mod = 1_000_000_007;
            long [] time = new long [n]; // time[i]表示从路口0出发到达路口i的最短用时
            long [] cnt = new long [n];  // count[i]表示在最短用时情况下从路口0出发到达路口i对应的方案数
            Arrays.fill(time, -1);
            time[0] = 0;
            cnt[0] = 1;                  // 路口0的到达方案数为1       
            Queue<int []> q = new PriorityQueue<>((a, b)->a[1]-b[1]); //小顶堆，用于输出下一最快到达的路口及时间
            for (int i = 0; i < n; i++) 
                if (map[0][i] > 0) q.offer(new int [] {i, map[0][i], 0});
            int [] cur = null;
            while (!q.isEmpty()) {
                cur = q.poll();
                u = cur[0];
                t = cur[1];
                v = cur[2];
                if (time[u] != -1 && t > time[u]) continue; // 当前路口已在更短的时间内被访问，即当前路径不是最短路径，跳过
                if (time[u] == -1) {    // 第一次到达
                    time[u] = t;
                    cnt[u] = cnt[v] % mod;
                    for (int i = 0; i < n; i++)
                        if (map[u][i] > 0)
                            q.offer(new int [] {i, t + map[u][i], u});
                } else // time[u] == t: true
                    cnt[u] = (cnt[u] + cnt[v]) % mod;
            }
            return (int)cnt[n-1];
        }

        public int numTilings(int n) {
            int mod = (int)1e9 + 7;
            int [][] dp = new int [n+1][2];
            dp[0][0] = 1;
            dp[1][0] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i][0] = (int)((dp[i-1][0] + dp[i-2][0]) % mod + (2 * dp[i-1][1]) % mod) % mod;
                dp[i][1] = (int)(dp[i-2][0] + dp[i-1][1]) % mod;
            }
            return dp[n][0];
        }

        public int sumSubarrayMins(int[] a) { // 以每一个数为最小值找出左右边界。累加和
            int mod = (int)1e9 + 7;
            int n = a.length;
            int [] l = new int [n]; // 以每个当前数为最小值的左右最长边界
            int [] r = new int [n];
            ArrayDeque<Integer> s = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!s.isEmpty() && a[i] <= a[s.peek()]) // bug: a[i] < a[s.peek()]
                    r[s.pop()] = i-1;
                s.push(i);
            }
            while (!s.isEmpty()) r[s.pop()] = n-1;
            for (int i = n-1; i >= 0; i--) {
                while (!s.isEmpty() && a[i] < a[s.peek()])
                    l[s.pop()] = i+1;
                s.push(i);
            }
            while (!s.isEmpty()) 
                l[s.pop()] = 0;
            long sum = 0;
            long lcnt = 0, rcnt = 0;
            for (int i = 0; i < n; i++) {
                lcnt = i - l[i] + 1;
                rcnt = r[i] - i + 1;
                sum += a[i] * lcnt * rcnt;
                sum %= mod;
            }
            return (int)sum;
        }
        public int sumSubarrayMins(int[] a) { // 将上面的三次遍历three passes变为一次遍历求结果
            int mod = (int)1e9 + 7;
            Deque<Integer> s = new ArrayDeque<>();
            long res = 0;
            for (int i = 0; i < a.length; i++) {
                while (!s.isEmpty() && a[i] < a[s.peek()]) { // 对于pop()出来的每一个数，计算出以它为最小值的左右边界，并累加和
                    int pos = s.pop();                       // l和r是a[pos]左右数的选择数
                    long l = pos - (s.isEmpty() ? -1 : s.peek()), r = i - pos;
                    res += (l * r % mod) * a[pos] % mod;
                    res %= mod;
                }
                s.push(i);
            }
            while (!s.isEmpty()) {
                int pos = s.pop();
                long l = pos - (s.isEmpty() ? -1 : s.peek()), r = a.length - pos;
                res += (l * r % mod) * a[pos] % mod;
                res %= mod;
            }
            return (int) res;
        }
        private int MOD = (int)(1e9 + 7);
        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;
            Deque<Integer> dk = new LinkedList<>(); // 单调递增栈， 使用原生函数，效率狠好！
            long res = 0;
            for (int i = 0; i < n; i++) {
                while (!dk.isEmpty() && arr[dk.peekLast()] > arr[i]) {
                    int pkIdx = dk.pollLast();
                    int stIdx;
                    if (dk.isEmpty()) stIdx = -1;
                    else stIdx = dk.peekLast();
                    res += (long)arr[pkIdx] * (long)(i - pkIdx) * (long)(pkIdx - stIdx);
                }
                dk.offerLast(i);
            }
            while (!dk.isEmpty()) {
                int pkIdx = dk.pollLast();
                int stIdx;
                if (dk.isEmpty()) stIdx = -1;
                else stIdx = dk.peekLast();
                res += (long)arr[pkIdx] * (long)(n - pkIdx) * (long)(pkIdx - stIdx);
            }
            return (int)(res % MOD);
        }
        public int sumSubarrayMins(int[] arr) { // the fastest can search so far
            int sum = 0;
            int mod = (int) 1e9 + 7;
            int curStVal = 0;
            Deque<int[]> s = new ArrayDeque<>(); // int [] {value, count}
            for (int i = 0; i < arr.length; i++) {
                int curCnt = 1;
                int curVal = arr[i];
                while (!s.isEmpty() && s.peek()[0] >= curVal) {
                    int[] popped = s.pop();
                    curStVal -= popped[1] * popped[0];
                    curCnt += popped[1]; // assign all previous count to current
                }
                s.push(new int[]{curVal, curCnt});
                curStVal += curVal * curCnt;
                sum = (sum + curStVal) % mod;
            }
            return sum;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int  r = s.sumSubarrayMins( a);
        System.out.println("r: " + r);
    }
}