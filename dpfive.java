import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.math.BigInteger;

import static java.util.stream.Collectors.toMap;

public class dpfive {
    public static class Solution {

        List<List<Integer>> ll = new ArrayList<>();
        boolean [] vis;
        int n;
        public int numSquarefulPerms(int[] a) {
            n = a.length;
            if (Arrays.stream(a).distinct().count() == 1) {
                if (!isSquare(a[0] + a[1])) return 0;
                return 1;
            }
            vis = new boolean[n];
            dfs(a, 0, new ArrayList<>());
            return ll.size();
        }
        private void dfs(int [] a, int idx, List<Integer> l) { // tle tle tle
            if (l.size() >= 2 && !isValid(l)) return;
            if (l.size() == n) {
                if (isValid(l) && !ll.contains(l)) ll.add(new ArrayList<>(l));
                return ;
            }
            for (int i = 0; i < n; i++) {
                if (i > 0 && a[i] == a[i-1] && vis[i-1]) continue; // 很重要,总结
                if (!vis[i]) {
                    vis[i] = true;
                    l.add(a[i]);
                   dfs(a, i+1, l);
                    l.remove(l.size()-1);
                    vis[i] = false;
                }
            }
        }
        private boolean isSquare(int v) {
            return Math.pow((int)Math.sqrt(v), 2) == v;
        }
        private boolean isValid(List<Integer> l) {
            for (int i = 0; i <= l.size()-2; i++) 
                if (!isSquare(l.get(i) + l.get(i+1))) return false;
            return true;
        }


        public class MinSeg {
            List<Integer> tree = new ArrayList<>();
            int n;
            public MinSeg (int [] arr) {
                n = arr.length;
                tree = new ArrayList<>(2 * n);
                for (int i = 0; i < n; i++)
                    tree.add(0);
                for (int i = 0; i < n; i++)
                    tree.add(arr[i]);
                for (int i = n-1; i >= 0; i--) // i >= 0
                    tree.set(i, Math.min(tree.get(2 * i), tree.get(2 * i+1)));
            }
            public void update(int idx, int v) {
                idx += n;
                tree.set(idx, v);
                while (idx > 1) {
                    idx /= 2;
                    tree.set(idx, Math.min(tree.get(2 * idx), tree.get(2 * idx+1)));
                }
            }
            public int getMin(int l, int r) { // [l, r) include left, not included right
                l += n;
                r += n;
                int min = Integer.MAX_VALUE;
                while (l < r) {
                    if ((l & 1) == 1) {
                        min = Math.min(min, tree.get(l));
                        l++;
                    }
                    if ((r & 1) == 1) {
                        r--; // order matters !!!
                        min = Math.min(min, tree.get(r));
                    }
                    l >>= 1;
                    r >>= 1;
                }
                return min;
            }
        }
        public int minNumberOperations(int[] target) {
            n = target.length;
            minSeg = new MinSeg(target);
            return minNumberOperationsRecursive(target, 0, n-1, 0);
        }
        MinSeg minSeg;
        int n;
        private int minNumberOperationsRecursive(int [] a, int bgn, int end, int preMin) { // tle: 1st time write it right, but this time got tle tle tle 
            if (bgn == end) return a[bgn] - preMin;
            int min = minSeg.getMin(bgn, end+1), ans = min - preMin;
            List<Integer> minIdx = new ArrayList<>();
            for (int i = bgn; i <= end; i++) 
                if (a[i] == min) minIdx.add(i);
             if (minIdx.size() == end - bgn + 1) return ans;
            if (minIdx.size() == 2 && minIdx.get(0) == bgn && minIdx.get(1) == end)
                return ans + minNumberOperationsRecursive(a, bgn+1, end-1, min);
            else if (minIdx.size() == 1)
                return ans + (minIdx.get(0) == bgn ? minNumberOperationsRecursive(a, bgn+1, end, min) :
                              (minIdx.get(0) == end ? minNumberOperationsRecursive(a, bgn, end-1, min) :
                               minNumberOperationsRecursive(a, bgn, minIdx.get(0)-1, min) + minNumberOperationsRecursive(a, minIdx.get(0)+1, end, min)));
            else if (minIdx.size() >= 2) {
                for (int i = 0; i < minIdx.size(); i++) {
                    if (i == 0) {
                        ans += (minIdx.get(0) == bgn ? 0 : minNumberOperationsRecursive(a, bgn, minIdx.get(i)-1, min));
                        continue;
                    }
                    if (minIdx.get(i) == minIdx.get(i-1) + 1) continue;
                    ans += minNumberOperationsRecursive(a, minIdx.get(i-1)+1, minIdx.get(i)-1, min);
                }
                if (minIdx.get(minIdx.size()-1) < end) ans += minNumberOperationsRecursive(a, minIdx.get(minIdx.size()-1)+1, end, min);
                return ans;
            }
            return -1;
        }
        public int minNumberOperations(int[] target) {
            ArrayDeque<Integer> st = new ArrayDeque<>();
            int low = 0, ans = 0;
            for (int i = 0; i < target.length; i++) {
                if (!st.isEmpty() && st.peek() > target[i]) {
                    ans += st.peek() - low;
                    while (!st.isEmpty() && st.peek() > target[i]) st.pop();
                    low = target[i];
                }
                st.push(target[i]);
            }
            if (!st.isEmpty() && st.peek() > low) ans += st.pop() - low;
            return ans;
        }

        public int shortestPathLength(int[][] g) { // 主要考点：对状态的遍历，以及对重复节点、反复遍历的调控
            int n = g.length;
            int target = 0, cnt = 0;
            Set<String> vis = new HashSet<>();
            Queue<int []> q = new LinkedList<>();
            for (int i = 0; i < n; i++) { // 从这些个节点起始
                int mask = (1 << i);
                target |= mask;
                vis.add(Integer.toBinaryString(mask) + "_" + Integer.toString(i));
                q.offer(new int [] {mask, i});
            }
            while (!q.isEmpty()) {
                for (int size = q.size()-1; size >= 0; size--) {
                    int [] cur = q.poll();
                    if (cur[0] == target) return cnt;
                    for (int v : g[cur[1]]) {
                        int state = cur[0] | (1 << v);
                        String tmp = Integer.toString(state) + "_" + Integer.toString(v);
                        if (vis.contains(tmp)) continue;
                        vis.add(tmp);
                        q.offer(new int [] {state, v});
                    }
                }
                cnt++;
            }
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int[][] vis;
        int target;
        public int shortestPathLength(int[][] graph){
            target = (1 << graph.length) - 1; 
            vis = new int [graph.length][1 << graph.length]; // For each node's possible binary state, keep path length.
            for (int i = 0; i < graph.length; i++) {
                for (int [] v : vis) Arrays.fill(v, Integer.MAX_VALUE); // Set initial length to Max
                traverse(0, i, graph, 0);
            }
            return min;
        }
        private void traverse(int st, int u, int [][] g, int cnt) {
            if (cnt >= min) return ; // 还是有关系的，能一定程度上提高运行效率
            st |= 1 << u;
            if (st == target) {
                min = Math.min(min, cnt);
                return ;
            }
            for (Integer v : g[u]) 
                if (vis[v][st] > cnt) {
                    vis[v][st] = cnt;
                    traverse(st, v, g, cnt+1);
                }
        }

        public int countArrangement(int n) { // 当数据量很小，又没有思路如何下口的时候，就试试backtracking吧
            this.n = n;
            vis = new boolean [n+1];
            backTracking(new ArrayList<>());
            return ll.size();
        }
        List<List<Integer>> ll = new ArrayList<>();
        boolean [] vis;
        int n;
        private void backTracking(List<Integer> l) {
            if (l.size() == n) {
                // if (!ll.contains(l)) // 这句不用写，写了就超时
                    ll.add(new ArrayList<>(l));
                return ;
            }
            for (int i = 1; i <= n; i++) 
                if (!vis[i] && (l.size() + 1 >= i && (l.size()+1) % i == 0
                                || l.size() + 1 < i && i % (l.size()+1) == 0))  {
                    vis[i] = true;
                    l.add(i);
                    backTracking(l);
                    l.remove(l.size()-1);
                    vis[i] = false;
                }                    
        }

        public int numberOfArithmeticSlices(int[] a) {
            int n = a.length, cnt = 0, addend = 0;
            for (int i = 2; i < n; i++) {
                if (a[i] - a[i-1] == a[i-1] - a[i-2]) 
                    cnt += ++addend;
                else addend = 0;
            }
            returncnt;
        }
        public int numberOfArithmeticSlices(int[] a) {
            int n = a.length;
            int [] dp = new int [n];
            for (int i = 1; i < n-1; i++) {
                if (a[i-1] + a[i+1] == 2 * a[i])
                    dp[i] = dp[i-1] + 1;
            }
            return Arrays.stream(dp).sum();
        }

        // 在找出每个变量的上界之后，就可以在O(maxn}{maxc}^2)的时间内预处理dp 数组。
        //     随后，我们还要预先求出 [2, maxn] 之间的全部质数，复杂度为 O(maxn)。
        public int[] waysToFillArray(int[][] q) {
            int n = q.length;
            int mod = (int)1e9 + 7;
            int maxC = 15;          // 找出「加和」的最大值cmax。根据前面的描述，cmax 即为质因数数量的最大值。
            int maxN = 0, maxK = 0; // 而由于质因数最小为 22，maxkmaxk 最大为 10^4因此质因数数量不会超过log_2 10^4 < 15
            for (int i = 0; i < n; i++) { // 需要遍历数组，找到所有 n, kn,k 的最大值maxn,maxk
                maxN = Math.max(maxN, q[i][0]);
                maxK = Math.max(maxK, q[i][1]);
            }
            long [][] dp = new long [maxN + 1][maxC + 1]; // dp[i][j] 代表给定一个正整数 jj，满足长度为 ii，且加和为 jj的非负整数排列的数量。
            for (int i = 1; i <= maxC; i++) 
                dp[1][i] = 1;
            for (int i = 1; i <= maxN; i++) 
                dp[i][0] = 1;
            for (int i = 2; i <= maxN; i++) 
                for (int j = 1; j <= maxC; j++) 
                    for (int k = 0; k <= j; k++) { // 为了求解dp[i][j]，我们考虑排列中的第一个整数，它的取值范围为 [0,j][0,j]，
                        dp[i][j] += dp[i-1][j-k];  // 若它取值为 kk，则余下 i-1i−1 个整数的加和需要为 j-kj−k，对应的方案数目为dp[i−1][j−k]
                        dp[i][j] %= mod;
                    }
            int [] isPrime = new int [maxK + 1]; // 分解乘积的质因子
            Arrays.fill(isPrime, 1);
            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i <= maxK; i++) {
                if (isPrime[i] == 1) 
                    primes.add(i);
                for (int j = i*2; j <= i*i && j <= maxK; j += i) // 最大乘积为maxK的数组，分解出小的质因子了，那么凡是小质因子的乘积倍数的数都不是质数
                    isPrime[j] = 0;
            }
            int [] ans = new int [n];
            for (int i = 0; i < n; i++) {
                int m = q[i][0], k = q[i][1];
                List<Integer> cs = new ArrayList<>(); // 乘积k的质因子表
                for (int p : primes) {
                    if (p > k) break;
                    int cnt = 0, left = k;
                    while (left % p == 0) {
                        left /= p;
                        cnt++;
                    }
                    if (cnt > 0) cs.add(cnt); // 乘积k中各质因子的个数（指数）
                }
                long res = 1;
                for (int c : cs) {
                    res *= dp[m][c]; // 数组长度为n,数组和为质因子c的指数个数的所有可能的分布数合数，各质因子之间个数之间相乘
                    res %= mod;
                }
                ans[i] = (int)res;
            }
            return ans;
        }
        public int[] waysToFillArray(int[][] queries) {
            int[] result = new int[queries.length];
            int resultIdx = 0;
            Combination combination = new Combination(10030, 20);
            for (int[] q : queries) {
                int n = q[0]; // 长度为n
                int k = q[1]; // 乘积为k
                long product = 1L;
                for (int power : getPrimeFactors(k).values()) {
                    // power个球，分到n个位置，每个位置可以为空
                    // 等价于：（power+n）个球，分到n个位置，每个位置不能为空  
                    // Why？ 等价后得到一种分法，每组减去1，就是原来的解
                    // 插板法可得 C（power + n - 1， n - 1） = C（power + n - 1， power）
                    product = (product * combination.get(n + power - 1, power)) % mod;
                }
                result[resultIdx++] = (int)(product);
            }
            return result;
        }
        long mod = (int)1e9 + 7;
        public HashMap<Integer, Integer> getPrimeFactors(int n) {
            HashMap<Integer, Integer> map = new HashMap();
            for(int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    int cnt = 0;
                    while (n % i == 0) {
                        cnt++;
                        n = n / i;
                    }
                    map.put(i, cnt);
                }
            }
            return map;
        }
        class Combination {
            long[][] c;
            Combination (int n, int m) {
                c = new long[n + 1][m + 1];
                c[0][0] = 1;
                for(int i = 1; i <= n; i++){
                    c[i][0] = 1;
                    for(int j = 1; j <= m; j++) 
                        c[i][j] = (c[i-1][j-1] + c[i-1][j]) % mod;
                }
            }
            public long get(int n, int m) {
                return c[n][m];
            }
        }
        public long getCombination(int n, int r) {
            BigInteger value = new BigInteger("1");
            long toDivide = 1;
            for(int i = 1; i <= r; ++i) {
                value = value.multiply(new BigInteger((n - i + 1) + ""));
                toDivide *= i;
            }
            value = value.divide(new BigInteger(toDivide + ""));
            value = value.remainder(new BigInteger("mod"));
            return value.longValue();
        }

        public int numberOfUniqueGoodSubsequences(String t) {
            int mod = (int)1e9 + 7;
            t = "#" + t;
            char [] s = t.toCharArray();
            int n = t.length(), ooo = 0, one = 0, i = 1;
            long [] dp = new long [n];
            while (i < n && s[i] == '0') i++;
            if (i == n) return 1;
            dp[i] = 1;
            one = i;
            ooo = i-1;
            for (int j = i+1; j < n; j++) {
                int k = (s[j] == '0' ? ooo : one); // 
                dp[j] = (2 * dp[j-1] % mod - (k >= 1 ? dp[k-1] : 0) + mod) % mod;
                if (s[j] == '0') ooo = j;
                else one = j;
            }
            return (int)dp[n-1] + (t.indexOf("0") != -1 ? 1 : 0);
        }
        public int numberOfUniqueGoodSubsequences(String t) { // bug
            long mod = (int)1e9 + 7;
            int n = t.length();
            long [] dp = new long [2];
            String b = "" + Long.parseLong(t); // 自动去掉开头的0: 这里字符串的长度很长 bug
            int  l =  n - b.length();
            if (l > 0) dp[0] = 1;
            long sum = dp[0];
            for (char c : b.toCharArray()) {
                if (dp[0] >= 1)
                    dp[c-'0'] = (long)Arrays.stream(dp).sum() % mod;
                else dp[c-'0'] = (1 + (long)Arrays.stream(dp).sum()) % mod;
            }
            return (int)((long)Arrays.stream(dp).sum() % mod);
        }

        public int superEggDrop(int k, int n) {
            int dp [][] = new int [k + 1][n + 1];
	        for(int i = 1 ; i <= n ; i++) dp[1][i] = i;
	        for(int i = 2 ; i <= k; i++) {
	            int x = 0 , y = 0;
	            for(int j = 1 ; j <= n ; j++) { 
                    dp[i][j] = 1 + Math.max(dp[i][x] , dp[i-1][y]);
                    if (dp[i-1][y+1] > dp[i][x+1] || dp[i][x] == dp[i][x+1]) x++;
                    else y++;   
	            }
	        }    
            return dp[k][n];
        }
        public int twoEggDrop(int n) { // 1 + 2 + 3 + ... + x >= n ==> get x
            if (n <= 2) return n;
            return (int)(Math.ceil((-1 + Math.sqrt((long)n * 8 + 1)) / 2.0));
        }
        // 思路： https://zhuanlan.zhihu.com/p/41257286
        // DP[i][j]表示用i个鸡蛋，j层楼的情况下最坏情况下所需扔鸡蛋的最少数目。
        // 可知初始条件为：
        // DP[1][0] = 0; DP[2][0] = 0;
        // DP[1][1] = 1; DP[2][1] = 1;
        // DP[1][i] = i; //i = 1 … n
        // 对于DP[2][i], i = 2 … n的情况，我们可以这样考虑：
        //     遍历j=2…i，求DP[2][j]，分两种情况：
        //     如果第1个鸡蛋在第j-1层摔破了，则我们在第j层只需摔第2个鸡蛋一次即可，此时总摔鸡蛋数为DP[1][j-1]+1。
        //     注意上面的1是因为第j层需要摔第2个鸡蛋1次。为什么DP[1][j-1]不能写成1呢？因为第1个鸡蛋在第j-1层摔破了，我们不能肯定在第1,2,…,j-2层不会破，所以要用DP[1][j-1]。
        //     如果第1个鸡蛋在第j-1层没有摔破，则我们在第j到i层有2个鸡蛋可以摔，此时退化到DP[2][i-j]的情况。该种情形下总共扔1+DP[2][i-j]。那个1就是表示第1个鸡蛋在第j-1层扔了1次。这里我们为什么只考虑用1，而不用考虑DP[1][j-1]呢？因为如果第j-1层没有摔破，第1,2,…,j-2层也就不用考虑了。
        //     因为是求最坏情况下的数目，所以DP[2][j]=1 + max(DP[1][j-1]+1, DP[2][i-j])。
        //     而我们是要求所有最坏情况下的最少数目，所以DP[2][j]=min(1 + max(DP[1][j-1]+1, DP[2][i-j]))。i = 2…n, j = 2…i。
        public int twoEggDrop(int n) { // 1 + 2 + 3 + ... + x >= n ==> get x
            if (n <= 1) return n;
            int [][] dp = new int [3][n+1]; // DP[i][j]表示用i个鸡蛋，j层楼的情况下最坏情况下所需扔鸡蛋的最少数目。
            for (int i = 0; i < 3; i++) 
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[1][0] = 0;
            dp[1][1] = 1;
            dp[2][0] = 0;
            dp[2][1] = 1;
            for (int i = 1; i <= n; i++) dp[1][i] = i;
            for (int i = 2; i <= n; i++) 
                for (int j = 2; j <= i; j++) 
                    dp[2][i] = Math.min(dp[2][i], 1 + Math.max(dp[1][j-1], dp[2][i-j])); // 1: 这个鸡蛋在j-i层扔了一次，要统计入结果
            return dp[2][n];
        }
        public int superEggDrop(int k, int n) { // tle:  
            if (k < 1 || n < 1) return 0;
            int [] pre = new int [n+1]; //上一层备忘录，存储鸡蛋数量-1的n层楼条件下的最优化尝试次数
            int [] cur = new int [n+1]; // 当前备忘录，存储当前鸡蛋数量的n层楼条件下的最优化尝试次数
            for (int i = 1; i <= n; i++) // 把备忘录每个元素初始化成最大的尝试次数
                cur[i] = i;
            for (int i = 2; i <= k; i++) {
                pre = cur.clone(); // 当前备忘录拷贝给上一次备忘录，并重新初始化当前备忘录
                for (int j = 1; j <= n; j++) cur[j] = j;
                for (int j = 1; j <= n; j++) // 需要想办法去优化时间复杂度。这种写法里面我们枚举了 [1, j] 范围所有的k值，总时间复杂度为 O(KN^2)，
                    for (int x = 1; x < j; x++) 
// 扔鸡蛋的楼层从1到m枚举一遍，如果当前算出的尝试次数小于上一次算出的尝试次数，则取代上一次的尝试次数。
// 这里可以打印k的值，从而知道第一个鸡蛋是从第几次扔的。
                        cur[j] = Math.min(cur[j], 1 + Math.max(pre[x-1], cur[j-x]));
            }
            return cur[n];
        }
        // 若我们仔细观察 dp[i - 1][k - 1] 和 dp[i][j - k]，可以发现前者是随着k递增，后者是随着k递减，且每次变化的值最多为1，
        // 所以只要存在某个k值使得二者相等，那么就能得到最优解，否则取最相近的两个k值做比较，
        // 由于这种单调性，我们可以在 [1, j] 范围内对k进行二分查找，找到第一个使得 dp[i - 1][k - 1] 不小于 dp[i][j - k] 的k值，然后用这个k值去更新 dp[i][j] 即可，
        // 这样时间复杂度就减少到了 O(KNlgN)
        public int superEggDrop(int k, int n) {
            int dp [][] = new int [k + 1][n + 1];
	        for(int i = 1 ; i <= n ; i++) dp[1][i] = i;
	        for(int i = 2 ; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = j;
                    int left = 1, right = j;
                    while (left < right) {
                        int mid = left + (right - left) / 2;
                        if (dp[i-1][mid-1] < dp[i][j-mid]) left = mid + 1;
                        else right = mid;
                    }
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][right-1], dp[i][j-right]) + 1);
                }
	        }    
            return dp[k][n];
        }
        public int superEggDrop(int k, int n) {
            int dp [][] = new int [k + 1][n + 1];
	        for(int i = 1 ; i <= n ; i++) dp[1][i] = i;
	        for(int i = 2 ; i <= k; i++) {
                int s = 1;
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = j;
                    while (s < j && dp[i-1][s-1] < dp[i][j-s]) ++s;
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][s-1], dp[i][j-s]) + 1);
                }
	        }    
            return dp[k][n];
        }
        public int superEggDrop(int k, int n) {
            int dp [][] = new int [n + 1][k + 1];
            int m = 0;
            while (dp[m][k] < n) {
                ++m;
                for (int j = 1; j <= k; j++)
                    dp[m][j] = dp[m-1][j-1] + dp[m-1][j] + 1;
            }
            return m;
        }
        public int superEggDrop(int k, int n) {
            int [] dp = new int [k+1];
            int ans = 0;
            for (; dp[k] < n; ans++) 
                for (int i = k; i > 0; i--) 
                    dp[i] = dp[i] + dp[i-1] + 1;
            return ans;
        }
        public int superEggDrop(int k, int n) {
            int l = 1, r = n;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (helper(m, k, n) < n) l = m + 1;
                else r = m;
            }
            return r;
        }
        private int helper(int x, int k, int n) {
            int ans = 0, r = 1;
            for (int i = 1; i <= k; i++) {
                r *= x - i + 1;
                r /= i;
                ans += r;
                if (ans >= n) break;
            }
            return ans;
        }

        public int mincostTickets(int[] d, int[] c) {
            int n = d.length, max = d[n-1]; // <= 365
            int [] dp = new int [max+1];
            boolean [] vis = new boolean [max + 1];
            for (Integer v : d) vis[v] = true;
            for (int i = 0; i <= max; i++) {
                if (!vis[i]) {
                    dp[i] = dp[i-1];
                    continue;
                }
                dp[i] = dp[i-1] + c[0];
                dp[i] = Math.min(dp[i], dp[Math.max(0, i-7)] + c[1]); // 这种写法很简洁
                dp[i] = Math.min(dp[i], dp[Math.max(0, i-30)] + c[2]);
            }
            return dp[max];
        }

        public double nthPersonGetsNthSeat(int n) {
            if (n == 1) return 1.0;
            double [] dp = new double [n];
            double sum = 0;
            for (int i = 1; i < n; i++) {
                dp[i] = (1 + sum) / (i + 1);
                sum += dp[i];
            }
            return dp[n-1];
        }

        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) { // bug: 这个前后的时间点总是没能确定，所以思路不清晰
            int n = startTime.length;
            List<int []> map = new ArrayList<>();
            for (int i = 0; i < startTime.length; i++) 
                map.add(new int [] {startTime[i], endTime[i], profit[i]});
            Collections.sort(map, (a, b) -> a[0] - b[0]);
            for (int [] zz : map) 
                System.out.println(Arrays.toString(zz));
            int [] dp = new int [n];
            for (int i = 0; i < n; i++) 
                dp[i] = map.get(i)[2]; // 单个能取得的利润
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i-1], map.get(i)[2]);
                for (int j = i-1; j >= 0; j--) { 
                    if (map.get(j)[1] <= map.get(i)[0]) {
                        dp[i] = Math.max(dp[i], dp[j] + map.get(i)[2]);
                        // break;
                    }
                    // else dp[i] = Math.max(dp[i], dp[i-1]);
                }
            }
            System.out.println(Arrays.toString(dp));
            // return Arrays.stream(dp).max().getAsInt();
            return dp[n-1];
        }
        // 目标：在最接近自己startime的endtime里得到最大的proft前缀
        // 维护一个递增的endtime序列
        // 该序列同时记录在此endtime下的最大profit
        // 按递增endtime遍历工作
        // 如果本次工作后profit比更早的endtime下的更多，就把这个工作记进去，不然做个p
        // 因为升序，所以还能二分查找。exciting！
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) { // 这个前后的时间点总是没能确定，所以思路不清晰
            int n = startTime.length;
            List<int []> map = new ArrayList<>();
            for (int i = 0; i < startTime.length; i++) 
                map.add(new int [] {startTime[i], endTime[i], profit[i]});
            Collections.sort(map, (a, b) -> a[0] - b[0]);
            for (int [] zz : map) 
                System.out.println(Arrays.toString(zz));
            
            int [] dp = new int [n];
            dp[n-1] = map.get(n-1)[2]; // 反向逆序遍历的优点：遍历过的时间点一定在当前事件之后，只有选与不选当前事件两种策略中取最优解
            int j = 0;
            for (int i = n-2; i >= 0; i--) {
                j = binarySearchNext(i+1, map);
                // j = getNext(i, map);
                dp[i] = Math.max(dp[i+1], (j == -1 ? 0 : dp[j]) + map.get(i)[2]);
            }
            return dp[0];
        }
        private int getNext(int idx, List<int []> ll) {
            for (int i = idx+1; i < ll.size(); i++) 
                if (ll.get(i)[0] >= ll.get(idx)[1]) return i;
            return -1;
        }
        private int binarySearchNext(int x, List<int []> ll) { // 这里居然写出bug来了 // bug todo
            int l = x + 1, r = ll.size()-1, v = ll.get(x)[1], ans = -1; // x end time
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (ll.get(m)[0] >= v) {
                    ans = m;
                    r = m-1;
                } else l = m+1;
            }
            // return l < ll.size() && ll.get(l)[0] >= v ? l : -1;
            return ans;
        }

        public int[] maxSumOfThreeSubarrays(int[] a, int k) {
            int n = a.length;
            int [] sum = new int [n+1];
            for (int i = 1; i <= n; i++) 
                sum[i] = sum[i-1] + a[i-1];
            int [] left = new int [n];
            int [] rite = new int [n];
            int [] ans = new int [3];
            int cur = sum[k] - sum[0];
            for (int i = k; i < n; i++) 
                if (sum[i+1] - sum[i-k+1] > cur) {
                    left[i] = i-k+1;
                    cur = sum[i+1] - sum[i-k+1];
                } else left[i] = left[i-1];
            Arrays.fill(rite, n-k);
            cur = sum[n] - sum[n-k];
            for (int i = n-k-1; i >= 0; i--) {
                int v = sum[i+k] - sum[i];
                if (v >= cur) { // == 当等的时候，也是需要更新答案的
                    cur = v;
                    rite[i] = i;
                } else rite[i] = rite[i+1];
            }
            int max = Integer.MIN_VALUE;
            for (int i = k; i <= n-k * 2; i++) {
                int l = left[i-1], r = rite[i+k];
                cur = sum[i+k] - sum[i] + sum[l+k] - sum[l] + sum[r+k] - sum[r];
                if (cur > max) {
                    max = cur;
                    ans = new int [] {l, i, r};
                }
            }
            return ans;
        }

        private int dfs(int [] a, int i, int j) {
            if (j - i < 2) return 0; // 最开始终止条件没有写对
            if (dp[i][j] > 0) return dp[i][j];
            int ans = Integer.MAX_VALUE;
            for (int k = i+1; k < j; k++) 
                ans = Math.min(ans, a[i]*a[k]*a[j] + dfs(a, i, k) + dfs(a, k, j));
            return dp[i][j] = ans;
        }
        int [][] dp;
        int n;
        public int minScoreTriangulation(int[] a) {
            n = a.length;
            dp = new int [n][n];
            return dfs(a, 0, n-1);
        }

        public int minSteps(int n) {
            if (n == 1) return 0;
            int [] dp = new int [n+1];
            dp[1] = 0;
            dp[2] = 2;     // copy A + paste A 
            for (int i = 3; i <= n; i++) {
                dp[i] = i; // 最多操作i次，在dp[2] = 2的基础上每多加一个字母就多paste一次
                for (int j = i-1; j >= 2; j--) {
                    if (i % j == 0) // 可以在面板上有j个A的基础上，copy j个A，再paste i/j-1次
                        dp[i] = Math.min(dp[i], dp[j]+1 + i/j-1);
                }
            }
            return dp[n];
        }

        // 首先我们对矩阵进行数据初始化。即求出每一行以及每一列上的前缀和。
        // 遍历矩阵每一个点（两层循环），并以该点最为起点（row, col），向右下方向画矩形（两层循环，分别循环矩形的宽width和高height），
        //       注意矩形范围不能越界。起始时width和height分别为0，即当前点自身是一个矩形。
        // 当width扩大一格后，实际上是增加了(row, col+width)到(row+height, col+width)这一部分的面积（宽为width，高为height），
        //       我们通过前缀和数组求出该区域和是否等于height，如果等于，返回结果加一即可。
        // width扩大一格的操作同理。
        public int numSubmat(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int [][] row = new int [m][n]; // 每一行的前缀和
            int [][] col = new int [m][n]; // 每一列的前缀和
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) 
                    row[i][j] = (j == 0 ? 0 : row[i][j-1]) + mat[i][j];
            for (int j = 0; j < n; j++) 
                for (int i = 0; i < m; i++) 
                    col[i][j] = (i == 0 ? 0 : col[i-1][j]) + mat[i][j];
            int ans = 0;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    for (int r = 0; i+r < m; r++)       // 以当前点为顶点，向下扩大一格, r = 0 起点是0，当前格自身也是答案
                        for (int c = 0; j+c < n; c++) { // 以当前点为顶点，向右扩大一格
                            int x = i + r, y = j + c;
                            // 数新扩张区域内每行每列区域内长度累加和都等于长度，即新增区域每格都是1
                            if ((j == 0 && row[x][y] == c+1 || j > 0 && row[x][y] - row[x][j-1] == c+1)
                                && (i == 0 && col[x][y] == r+1 || i > 0 && col[x][y] - col[i-1][y] == r+1))
                                ans++;
                            else break;
                        }
            return ans;
        }
        Used two Arrays to store number of consecutive ones on the left, and number of consecutive ones above(up)
            In one m*n loop we can count the number of order 1xM rectangles where M belongs to [1,m-1]
            and we can count rectangles of order MxN each time where M>1. in the k index loop.
        public int numSubmat(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int [][] left = new int [m][n]; // 每一行的前缀和
            int [][] abov = new int [m][n]; // 每一列的前缀和
            int ans = 0;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    if (mat[i][j] == 1)  {
                        left[i][j] = (j == 0 ? 0 : left[i][j-1]) + 1;
                        ans += (j == 0 ? 1 : left[i][j]);
                        abov[i][j] = (i == 0 ? 0 : abov[i-1][j]) + 1;
                        if (i > 0) {
                            int min = left[i][j];
                            for (int k = 1; k < abov[i][j]; k++) {
                                min = Math.min(min, left[i-k][j]);
                                ans += min;
                            }
                        }
                    }
            return ans;
        }
        // In the first pass through the matrix, we store the heights of 1s above a given i,j
        // In the second pass, we go through each element that is nonzero, scan leftwards,
        //     adding the minimum of the heights encountered until we reach the beginning of the row or hit a zero.
        public int numSubmat(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            for (int j = 0; j < n; j++) {
                int colsum = 0;
                for (int i = 0; i < m; i++) {
                    if (mat[i][j] == 0) colsum = 0;
                    else colsum += mat[i][j];
                    mat[i][j] = colsum;
                }
            }
            int tot = 0;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < mat[i].length; j++) {
                    int k = j;
                    int min = Integer.MAX_VALUE;
                    while (k >= 0 && mat[i][k] != 0) {
                        min = Math.min(min, mat[i][k]);
                        tot += min;
                        k--;
                    }
                }
            return tot;
        }
        private int res = 0; // todo
        private int n;
        public int numSubmat(int[][] mat) {
            this.n = mat[0].length;
            // dp[j] : the height (number of consecutive '1's) of column j 
            int[] dp = new int[n];
            for (int i = 0; i < mat.length; i++) {
                // calculating (updating) heights
                for (int j = 0; j < n; j++) 
                    dp[j] = mat[i][j] == 1 ? dp[j] + 1 : 0;
                enumerateRowByMinHeight(dp);
            }
            return res;
        }
        public void enumerateRowByMinHeight(int[] dp) {
            // monotonic stack storing indices : for index p < q in stack, dp[p] < dp[q]
            Deque<Integer> stack = new LinkedList<>();
            stack.offerLast(-1);
            for (int j = 0; j < n; j++) {
                while (stack.peekLast() != -1 && dp[stack.peekLast()] >= dp[j]) {
                    int idx = stack.pollLast();
                    res += dp[idx] * (idx - stack.peekLast()) * (j - idx);
                }
                stack.offerLast(j);
            }
            while (stack.peekLast() != -1) {
                int idx = stack.pollLast();
                res += dp[idx] * (idx - stack.peekLast()) * (n - idx);
            }
        }

        public int minFlipsMonoIncr(String t) { // bug
            int n = t.length();
            char [] s = t.toCharArray();
            boolean hasOne = false, hasZoo = false;
            int cntOne = 0, cntZoo = 0;
            int i = 0, j = 0;
            while (i < n && s[i] != '1') i++; // 去头0
            if (i == n) return 0;
            hasOne = true; // ??
            i++;
            while (i < n) {
                if (s[i] == '0') cntZoo++;
                i++;
            }
            i = n-1;
            while (i >= 0 && s[i] != '0') i--; // 去尾1
            i--;
            while (i >= 0) {
                if (s[i] == '1') cntOne++;
                i--;
            }
            // 这种思路乍看上去没什么问题，但是实际上是有问题的，比如对于这个例子 "10011111110010111011"，如果按这种思路的话，
            //     就应该将所有的0变为1，从而返回6，但实际上更优的解法是将第一个1变为0，将后4个0变为1即可，最终可以返回5，这说明了之前的解法是不正确的。
            return Math.min(cntOne, cntZoo); // 然后保留换0 1 的最小次数，思路不对
        }
        可以用动态规划 Dynamic Programming 来做，需要使用两个 dp 数组，其中 cnt1[i] 表示将范围是 [0, i-1] 的子串内最小的将1转为0的个数，从而形成单调字符串。
        同理，cnt0[j] 表示将范围是 [j, n-1] 的子串内最小的将0转为1的个数，从而形成单调字符串。
        这样最终在某个位置使得 cnt0[i]+cnt1[i] 最小的时候，就是变为单调串的最优解，
        public int minFlipsMonoIncr(String t) { // bug
            int n = t.length();
            char [] s = t.toCharArray();
            int [] l = new int [n+1], r = new int [n];
            for (int i = 1; i <= n; i++) 
                l[i] = l[i-1] + (s[i-1] == '0' ? 0 : 1); // cnt left --> right 1--> 0
            for (int i = n-1; i >= 0; i--) 
                r[i] = (i == n-1 ? 0 : r[i+1]) + (s[i] == '0' ? 1 : 0);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) 
                min = Math.min(l[i] + r[i], min);
            min = Math.min(min, l[n]);
            return min;
        }
        public int minFlipsMonoIncr(String t) { // bug
            int n = t.length(), ans = Integer.MAX_VALUE;
            char [] s = t.toCharArray();
            int [] l = new int [n+1], r = new int [n+1];
            for (int i = 1, j = n-1; i <= n; i++, --j) {
                l[i] = l[i-1] + (s[i-1] == '0' ? 0 : 1); // cnt left --> right 1--> 0
                r[j] = r[j+1] + (s[j] == '0' ? 1 : 0);
            }
            for (int i = 0; i <= n; i++) 
                ans = Math.min(l[i] + r[i], ans);
            return ans;
        }
        用一个变量 cnt1 来记录当前位置时1出现的次数，同时 res 表示使到当前位置的子串变为单调串的翻转次数，
        用来记录0的个数，因为遇到0就翻1一定可以组成单调串，但不一定是最优解，
        每次都要和 cnt1 比较以下，若 cnt1 较小，就将 res 更新为 cnt1，
        此时保证了到当前位置的子串变为单调串的翻转次数最少，并不关心到底是把0变为1，还是1变为0了
        public int minFlipsMonoIncr(String t) { // bug
            int n = t.length(), res = 0, cntOne = 0;
            char [] s = t.toCharArray();
            for (int i = 0; i < n; i++) {
                if (s[i] == '0') res++;
                else cntOne++;
                res = Math.min(res, cntOne);
            }
            return res;
        }

       public int maxScoreSightseeingPair(int[] a) {
            int n = a.length;
            int idx = 0, ans = 0;
            for (int i = 1; i < n; i++) {
                if (a[i] + a[idx] + idx - i > ans) 
                    ans = a[i] + a[idx] + idx - i;
                if (a[i] + i > a[idx] + idx)
                    idx = i;
            }
            return ans;
        }

        public int longestSubarray(int[] a) { // bug出多了，自己也能悟出来：数据结构能帮大忙：
            int n = a.length, cnt = 0, i = 0, max = 0; // 以后比赛的时候就这么写，自己数下标，数得累死还bug满天飞，借助一个双端队列，至少自动过滤掉不少bug
            ArrayDeque<Integer> q = new ArrayDeque<>();
            boolean hasO = false; // {0, 0, 1, 1} 这个特例不能忘记了
            while (i < n && a[i] == 0) {
                hasO = true;
                i++;
            }
            if (i == n) return 0;
            for (; i < n; i++) {
                q.offerLast(a[i]);
                if (a[i] == 0) {
                    cnt++;
                    if (cnt == 2) {
                        max = Math.max(max, q.size()-cnt);
                        while (!q.isEmpty() && q.peek() != 0) q.pollFirst();
                        q.pollFirst();
                        cnt--;
                    }
                }
            }
            if (a[n-1] == 1) max = Math.max(max, q.size()-(cnt > 0 ? cnt : (hasO ? 0 : 1)));
            else max = Math.max(max, q.size()-cnt);
            return max;
        }
        int longestSubarray(vector<int>& nums) {
            const int n = nums.size();
            int ans = 0;
            int sum = 0; // sum of nums[l~r].
            for (int l = 0, r = 0; r < n; ++r) {
                sum += nums[r];
                while (l < r && sum < r - l) // Maintain sum >= r - l, at most 1 zero.
                    sum -= nums[l++];
                ans = max(ans, r - l);
            }
            return ans;
        }
        count1：当前包含一个非1的连续长度。
        count2：当前全是1的连续长度。
        循环数组每一个数字，如果当前数字是1，count1和count2同时加一，同时使用count1更新全局最大值。
        重点来了，如果当前数字是非1，则设count1等于count2，count2设为0。最后处理一下全是1的特例即可。
        public int longestSubarray(int[] a) { // bug出多了，自己也能悟出来：数据结构帮大忙：
            int n = a.length, ans = 0, cnt = 0, one = 0, zoo = 0;
            for (Integer v : a) {
                if (v == 0) {
                    zoo++;
                    cnt = one;
                    one = 0;
                } else {
                    cnt++;
                    one++;
                    ans = Math.max(ans, cnt);
                }
            }
            return ans == n ? n-1 : ans;
        }
        int longestSubarray(vector<int>& nums) {
            const int n = nums.size();
            vector<int> l(n);
            vector<int> r(n);
            for (int i = 0; i < n; ++i)
                l[i] = (i > 0 ? l[i - 1] * nums[i] : 0) + nums[i];
            for (int i = n - 1; i >= 0; --i)
                r[i] = (i < n - 1 ? r[i + 1] * nums[i] : 0) + nums[i];
            int ans = 0;
            for (int i = 0; i < n; ++i)
                ans = max(ans, (i > 0 ? l[i - 1] : 0) + 
                               (i < n - 1 ? r[i + 1] : 0));
            return ans;
        }
        int longestSubarray(vector<int>& nums) {
            const int n = nums.size();
            // dp[i][0] := longest subarray ends with nums[i-1] has no zeros.
            // dp[i][0] := longest subarray ends with nums[i-1] has 1 zero.
            vector<vector<int>> dp(n + 1, vector<int>(2));
            int ans = 0;
            for (int i = 1; i <= n; ++i) {
                if (nums[i - 1] == 1) {
                    dp[i][0] = dp[i - 1][0] + 1;
                    dp[i][1] = dp[i - 1][1] + 1;
                } else {
                    dp[i][0] = 0;
                    dp[i][1] = dp[i - 1][0] + 1;
                }
                ans = max({ans, dp[i][0] - 1, dp[i][1] - 1});
            }
            return ans;
        }

        public long maxAlternatingSum(int[] a) {
            long odd = 0, evn = a[0]; // 上一元素为偶数下标、奇数下标时的最大交替和
            for (int i = 1; i < a.length; i++) {
                evn = Math.max(evn, odd + a[i]); // 偶数下标交替和转移
                odd = Math.max(odd, evn - a[i]); // 奇数下标交替和转移
            }
            return evn;
        }
        public long maxAlternatingSum(int[] a) {
            int [] b = new int [a.length+1];
            System.arraycopy(a, 0, b, 1, a.length);
            long ans = 0;
            for (int i = 1; i < b.length; i++) 
                if (b[i] - b[i-1] > 0) ans += b[i] - b[i-1];
            return ans;
        }
        public long maxAlternatingSum(int[] arr) { // ?
            int n = arr.length;
            if (n == 1) return arr[0];
            int i = 0;
            long res = 0;
            while (true) {
                while (i < n-1 && arr[i+1] > arr[i]) ++i;
                res += arr[i];
                if (i == n-1) return res;
                ++i;
                while (i < n-1 && arr[i+1] < arr[i]) ++i;
                if (i == n-1) return res;
                res -= arr[i];
                ++i;
            }
        }
        
        public int minimumDeletions(String t) { // bug
            int n = t.length();
            char [] s = t.toCharArray();
            int [] pre = new int [n]; // b
            int [] suf = new int [n]; // a
            int cnt = 0, ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++)
                pre[i] = s[i] == 'b' ? ++cnt : cnt;
            cnt = 0;
            for (int i = n-1; i >= 0; i--)
                suf[i] = s[i] == 'a' ? ++cnt : cnt;
            for (int i = 0; i < n; i++) {
                if (pre[i] == 0 || suf[i] == 0) continue;
                ans = Math.min(ans, (i == 0 ? 0 : pre[i]) + (i == n-1 ? 0 : suf[i])-1);
            } // "aaaaaabbbbabaaaabbabaaabbabbbaaabababaaaaaaabbaaabaaababaaabababa"
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
        public int minimumDeletions(String t) { // 
            int n = t.length();
            char [] s = t.toCharArray();
            int a = 0, b = 0;
            for (int i = 0; i < n; i++) 
                a += s[i] == 'a' ? 1 : 0;
            int ans = a;
            for (int i = 0; i < n; i++) { // 对于每个当前位置来说，数了前面的b 和 后面的a, 那么遍历一遍取最小值就可以了
                b += s[i] == 'b' ? 1 : 0;
                a -= s[i] == 'a' ? 1 : 0;
                ans = Math.min(ans, a + b - (s[i] == 'b' ? 1 : 0));
            }
            return ans;
        }

        public int largest1BorderedSquare(int[][] g) {
            int m = g.length, n = g[0].length, cnt = 0;
            int [][] rite = new int [m][n], down = new int [m][n];
            for (int i = 0; i < m; i++) 
                for (int j = n-1; j >= 0; j--) 
                    rite[i][j] = j == n-1 ? g[i][j] : (g[i][j] == 1 ? rite[i][j+1]+1 : 0);
            for (int j = 0; j < n; j++) 
                for (int i = m-1; i >= 0; i--) 
                    down[i][j] = i == m-1 ? g[i][j] : (g[i][j] == 1 ? down[i+1][j]+1 : 0);
            int ans = 0;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) {
                    if (g[i][j] == 0) continue;
                    if (down[i][j] == 1 || rite[i][j] == 1) {
                        if (ans == 0) ans = 1;
                        continue;
                    }
                    int max = Math.min(down[i][j], rite[i][j]);
                    while (max > 1) {
                        if (rite[i+max-1][j] < max || down[i][j+max-1] < max) {
                            max--;
                            continue;
                        } else break;
                    }
                    ans = Math.max(ans, max*max);
                }
            return ans;
        }

        public int eraseOverlapIntervals(int[][] a) { // 刚过去周六早上的比赛简单的当时就想出来O(NlogN)的解法了，这里居然还有些不通
            int n = a.length, max = 0;
            Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); // starttime, then end time
            int [] dp = new int [n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (a[j][1] > a[i][0]) continue;
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
            return n-max;
        }
        public int eraseOverlapIntervals(int[][] a) {  // bug
            int n = a.length, max = 0;
            Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); // starttime, then end time
            int [] dp = new int [n];
            Arrays.fill(dp, 1);
            Queue<Integer> q = new PriorityQueue<>((x, y)-> dp[y] - dp[x]); // end time decreasing
            for (int i = 0; i < n; i++) {
                // for (int j = 0; j < i; j++) {
                //     if (a[j][1] > a[i][0]) continue;
                //     dp[i] = Math.max(dp[i], dp[j] + 1);
                // }
                while (!q.isEmpty() && a[q.peek()][1] > a[i][0]) q.poll();
                if (!q.isEmpty())
                    dp[i] = Math.max(dp[i], dp[q.peek()] + 1);
                q.offer(i);
                max = Math.max(max, dp[i]);
                maxDp[i] = max;
            }
            return n-max;
        }
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) return 0;
            Arrays.sort(intervals, (a, b)->a[1] - b[1]);
            int n = intervals.length;
            int right = intervals[0][1];
            int ans = 1;
            for (int i = 1; i < n; ++i) 
                if (intervals[i][0] >= right) {
                    ++ans;
                    right = intervals[i][1];
                }
            return n - ans;
        }

        public int findTheCity(int n, int[][] edge, int distThreshold) {
            int [][] g = new int [n][n];
            for (int i = 0; i < n; i++) 
                Arrays.fill(g[i], Integer.MAX_VALUE);
            for (int [] e : edge) {
                g[e[0]][e[1]] = e[2];
                g[e[1]][e[0]] = e[2];
            }
            for (int k = 0; k < n; k++) 
                for (int i = 0; i < n; i++) 
                    for (int j = 0; j < n; j++) {
                        if (i == j || g[i][k] == Integer.MAX_VALUE || g[k][j] == Integer.MAX_VALUE) continue;
                        g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                    }
            int [] cnt = new int [n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) 
                    if (g[i][j] <= distThreshold) cnt[i]++;
            int min = Integer.MAX_VALUE, ans = n;
            for (int i = 0; i < n; i++) 
                if (cnt[i] <= min) {
                    min = cnt[i];
                    ans = i;
                }
            return ans;
        }

        public int longestArithSeqLength(int[] a) { // dif < 0 就说明不能再用数组了，必须改用图
            int n = a.length, N = 501, max = 2;
            int [][] dp = new int [n][N];
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
                for (int j = 0; j < i; j++) {
                    int dif = a[i] - a[j];
                    dp[i][dif] = Math.max(dp[i][dif], dp[j][dif] == 0 ? 2 : dp[j][dif] + 1);
                    max = Math.max(max, dp[i][dif]);
                }
            }
            return max;
        }
        public int longestArithSeqLength(int[] arr) { // 上一次写的，看来本质一样呀
            int n = arr.length;
            List<Map<Integer, Integer>> lm = new ArrayList<>();
            lm.add(new HashMap<>());
            int diff = 0;
            int max = 0, locMax = 0;
            for (int i = 1; i < n; i++) {
                Map<Integer, Integer> m = new HashMap<>();
                for (int j = i-1; j >= 0; j--) {
                    diff = arr[i] - arr[j];
                    locMax = Math.max(m.getOrDefault(diff, 2), lm.get(j).getOrDefault(diff, 1) + 1);
                    m.put(diff, locMax);
                    max = Math.max(max, locMax);
                }
                lm.add(m);
            }
            return max;
        }
        public int longestArithSeqLength(int[] a) { // 原来就是这样的呀，看来自己多想想还是能够独立想得出来的嘛
            int n = a.length, max = 2;
            if (n <= 2) return n;
            Map<Integer, Integer> [] dp = new HashMap[n];
            dp[0] = new HashMap<>();
            for (int i = 1; i < n; i++) {
                dp[i] = new HashMap<>();
                for (int j = 0; j < i; j++) {
                    int dif = a[i] - a[j];
                    int tmp = Math.max(dp[i].getOrDefault(dif, 2), dp[j].getOrDefault(dif, 1) + 1);
                    dp[i].put(dif, tmp);
                    max = Math.max(max, tmp);
                }
            }
            return max;
        }

        public int orderOfLargestPlusSign(int n, int[][] mine) {
            int [][] a = new int [n][n];
            for (int i = 0; i < n; i++) 
                Arrays.fill(a[i], 1);
            for (int [] v : mine) 
                a[v[0]][v[1]] = 0;
            int [][] u = new int [n][n];
            int [][] d = new int [n][n];
            int [][] l = new int [n][n];
            int [][] r = new int [n][n];
            int cnt = 0, k = 0;
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 0) continue;
                    u[i][j] = 1; d[i][j] = 1;
                    l[i][j] = 1; r[i][j] = 1;
                    
                    cnt = 1; k = i-1;
                    while (k >= 0 && a[k][j] == 1) {
                        cnt++;
                        k--;
                    }
                    u[i][j] = cnt;
                    cnt = 1; k = i+1;
                    while (k < n && a[k][j] == 1) {
                        cnt++;
                        k++;
                    }
                    d[i][j] = cnt;
                    cnt = 1; k = j+1;
                    while (k < n && a[i][k] == 1) {
                        cnt++;
                        k++;
                    }
                    r[i][j] = cnt;
                    cnt = 1; k = j-1;
                    while (k >= 0 && a[i][k] == 1) {
                        cnt++;
                        k--;
                    }
                    l[i][j] = cnt;
                }
            int max = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 0) continue;
                    int c = Math.min(u[i][j], d[i][j]);
                    int b = Math.min(l[i][j], r[i][j]);
                    max = Math.max(max, Math.min(c, b));
                }
            return max;
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
        public int lenLongestFibSubseq(int[] a) {
            int n = a.length, max = 0, pre = 0, cur = 0, next = 0, cnt = 0;
            int [] dp = new int [n];
            Arrays.fill(dp, 1);
            Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    next = a[i] + a[j];
                    if (!s.contains(next)) continue;
                    pre = a[i];
                    cur = next;
                    cnt = 3;
                    while (s.contains(pre + cur)) {
                        cnt++;
                        next = pre + cur;
                        pre = cur;
                        cur = next;
                    }
                    max = Math.max(max, cnt);
                }
            }
            return max;
        }

        public int maxTurbulenceSize(int[] a) { // 好像这个题的思路傻掉了
            int n = a.length, max = 0, cnt = 0;
            if (n < 2) return n;
            boolean up = false, down = false;
            for (int i = 0; i < n-1; i++) {
                // if (!up && !down) {
                //     if (a[i] < a[i+1]) up = true;
                //     else if (a[i] > a[i+1]) down = true;
                //     if (up || down) cnt = 2;
                //     max = Math.max(max, cnt);
                //     continue;
                // }
                if (up && a[i] > a[i+1] || down && a[i] < a[i+1]) {
                    cnt++;
                    if (up) {
                        up = false;
                        down = true;
                    } else {
                        down = false;
                        up = true;
                    } 
                } else if (a[i] == a[i+1]) {
                    max = Math.max(max, cnt);
                    up = false;
                    down = false;
                } else {
                // if (!up && !down) {
                    up = false;
                    down = false;
                    if (a[i] < a[i+1]) up = true;
                    else if (a[i] > a[i+1]) down = true;
                    if (up || down) cnt = 2;
                    max = Math.max(max, cnt);
                    // continue;
                }
            }
            max = Math.max(max, cnt);
            return max;
        }

        
    }
    public static void main(String[] args) {
        Solution s  =  new Solution();

        int []  a = new int []  {2, 0, 2, 4, 2, 5, 0, 1, 2, 3};

        int r =  s.maxTurbulenceSize( a);
        System.out.println("r: " + r);
    }
}