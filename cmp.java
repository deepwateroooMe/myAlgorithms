import com.TreeNode;

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

        // // 不知道所有的 i<j 都能连通是什么意思，但是大概是先转化成一个无向图，再求所有的 i<j
        // // N(10^5) 感觉上面想得太复杂了，能不能直接理解为存在一个公质因子
        // // 走连通图，含公因质子的一个模块里: 好好的思路，被我写成了 TLE...
        // class UnionFind {
        //     private int[] p;
        //     int cnt;
        //     public UnionFind(int size) {
        //         p = new int[size];
        //         cnt = size;
        //         for (int i = 0; i < size; i++) 
        //             p[i] = i;
        //     }
        //     public int find(int x) {
        //         if (p[x] != x) 
        //             p[x] = find(p[x]);
        //         return p[x];
        //     }
        //     public void union(int x, int y) {
        //         int px = find(x), py = find(y);
        //         if (px != py) {
        //             p[px] = py;
        //             --cnt;
        //         }
        //     }
        //     public int getCnt() {// 去拿连通集的个数：我这里数得不对。。。。。【活宝妹就是一定要嫁给亲爱的表哥！！】
        //         return cnt;
        //     }
        // }
        // private UnionFind uf; // 【活宝妹就是一定要嫁给亲爱的表哥！！！】
        // Set<Integer> s = new HashSet<>(); // 出现过的质因子，备案
        // public boolean canTraverseAllPairs(int[] a) {
        //     int n = a.length, max = Arrays.stream(a).max().getAsInt(), j;
        //     if (n == 1) return true;
        //     // 自己求质数表备案
        //     List<Integer> p = new ArrayList<>();
        //     for (int i = 1; i <= max; i++) 
        //         if (isPrime(i)) p.add(i);
        //     System.out.println("p.size(): " + p.size());
        //     System.out.println(Arrays.toString(p.toArray()));
        //     uf = new UnionFind(p.size());
        //     boolean [] v = new boolean [p.size()];
        //     for (int i = 0; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         int pre = -1;
        //         for (j = 0; j < p.size(); j++) // 这么写的目的是：把【O(N^2)】转化成【O(N*Contant)】免得超时
        //             if (a[i] % p.get(j) == 0) {
        //                 s.add(j);
        //                 if (pre == -1) pre = j;
        //                 else uf.union(j, pre); // 对同一个数来说，它的质因子要连起来
        //                 if (v[j]) break;
        //                 else v[j] = true;
        //             }
        //         System.out.println("j: " + j);
        //         if (j < p.size()) // 可以与其它的连通: 用这个数把它所有质因子的连通集连接起来
        //             for (int k = 0; k < p.size(); k++) {
        //                 if (k == j) continue;
        //                 if (v[k])
        //                     uf.union(k, j);
        //                 if (!v[k] && a[i] % p.get(k) == 0) v[k] = true;
        //             }
        //         System.out.println(Arrays.toString(v));
        //         System.out.println("uf.getCnt(): " + uf.getCnt());
        //     }
        //     // 然后数个数，返回只有一个集，就可以了
        //     // 这里的【BUG：】是： 100000 以内的数，某些质因子可能从来不曾出现过
        //     int cnt = 0;
        //     for (var vis : v) if (vis) cnt++;
        //     System.out.println("cnt: " + cnt);
        //     System.out.println("uf.getCnt(): " + uf.getCnt());
        //     return uf.getCnt() == p.size() - cnt + 1;
        // }
        // boolean isPrime(int x) {
        //     if (x <= 1) return false;
        //     // 判断是否被2~自身数-1范围内的值整除
        //     for (int i = 2; i < x;++i){
        //         if (x%i == 0)
        //             return false;
        //     }
        //     return true;
        // }
        // int gcd(int x, int y) {
        //     if (y == 0) return x;
        //     return gcd(y, x % y);
        // }

        // public int minimizedStringLength(String s) {
        //     return (int)s.chars().distinct().count();
        // }

        // public int semiOrderedPermutation(int[] a) {
        //     int n = a.length, i = -1, j = -1;
        //     for (int k = 0; k < n; k++) {
        //         if (a[k] == 1) i = k;
        //         else if (a[k] == n) j = k;
        //         if (i != -1 && j != -1) break;
        //     }
        //     return i + n - j - 1 - (i > j ? 1 : 0);
        // }

        // // 这个题说有无数重复，所以过滤掉先前的重复，只保留最多 2m 次调用
        // // 内存溢出：必须动规
        // public long matrixSumQueries(int n, int[][] a) {
        //     int m = a.length;
        //     int [] r = new int [n], c = new int [n];
        //     Arrays.fill(r, -1); Arrays.fill(c, -1);
        //     for (int i = 0; i < m; i++) {
        //         int [] cur = a[i];
        //         if (cur[0] == 0) r[cur[1]] = i;
        //         else c[cur[1]] = i;
        //     }
        //     // // 这里大概不能直接生成数组，而用个什么 DP 的形式来统计结果。。。
        //     // long [][] ans = new long [n][n];
        //     // for (int i = 0; i < m; i++) {
        //     //     int [] cur = a[i];
        //     //     if (cur[0] == 0 && r[cur[1]] == i) 
        //     //         for (int j = 0; j < n; j++) 
        //     //             ans[cur[1]][j] = cur[2];
        //     //     else if (cur[0] == 1 && c[cur[1]] == i)
        //     //         for (int j = 0; j < n; j++)
        //     //             ans[j][cur[1]] = cur[2];
        //     // }
        //     long [] rr = new long [n], cc = new long [n];// 记行和列的和
        //     Arrays.fill(rr, 0); Arrays.fill(cc, 0);
        //     long ans = 0;
        //     for (int k = 0; k < m; k++) {
        //         int [] cur = a[k];
        //         int i = cur[1], j = cur[1];
        //         if (cur[0] == 0 && r[i] == k) {
        //             if (rr[i] == 0) {
        //                 rr[i] = (long)cur[2] * n;
        //                 ans += (long)n * cur[2];
        //             } else {
        //                 ans += (long)n * cur[2] - rr[i];
        //                 rr[i] = (long)cur[2] * n;
        //                 for ( j = 0; j < n; j++) {
        //                     if (c[j] != )
        //                         }
        //             }
        //             r[i] = cur[2]; // 更改这个值可能还会造成其它问题，用另两个数组来纪录
        //             // 那么它可能会带来的列的变化: 暂时不管，反正只算一遍, 感觉这里可能会出错，没考虑列的更新
        //         } else if (cur[0] == 1 && c[j] == k) {
        //             if (cc[j] == 0) {
        //                 cc[j] = (long)n * cur[2];
        //                 ans += cc[j];
        //             } else {
        //                 ans += (long)n * cur[2] - cc[j];
        //                 cc[j] = (long)n * cur[2];
        //             }
        //             c[j] = cur[2];
        //         }
        //     }
        //     // for (int i = 0; i < m; i++) {
        //     //     int [] cur = a[i];
        //     //     if (cur[0] == 0 && r[cur[1]] == i) {
        //     //         if (rr[cur[1]] == 0) {
        //     //             rr[cur[1]] = (long)cur[2] * n;
        //     //             ans += (long)n * cur[2];
        //     //         } else {
        //     //             ans += (long)n * cur[2] - rr[cur[1]];
        //     //             rr[cur[1]] = (long)cur[2] * n;
        //     //             for (int j = 0; j < n; j++) {
        //     //                 if ()
        //     //             }
        //     //         }
        //     //         r[cur[1]] = cur[2];
        //     //         // 那么它可能会带来的列的变化: 暂时不管，反正只算一遍, 感觉这里可能会出错，没考虑列的更新
        //     //     } else if (cur[0] == 1 && c[cur[1]] == i) {
        //     //         if (cc[cur[1]] == 0) {
        //     //             cc[cur[1]] = (long)n * cur[2];
        //     //             ans += cc[cur[1]];
        //     //         } else {
        //     //             ans += (long)n * cur[2] - cc[cur[1]];
        //     //             cc[cur[1]] = (long)n * cur[2];
        //     //         }
        //     //         c[cur[1]] = cur[2];
        //     //     }
        //     // }
        //     return ans / 2;
        // }
        
        // // 这个题：大概是要按位来生成这些数，因为数量级非常大，数位动规【记忆化深搜】参考 1397 大概需要一两个 boolean 变量来标记是 lo-hi 最后一位什么的
        // public int count(String S, String T, int min, int max) {
        //     m = S.length(); n = T.length(); this.min = min; this.max = max; 
        //     s = S.toCharArray(); t = T.toCharArray();
        //     int r = count(t) - count(s) + mod, tmp = 0;
        //     for (var c : s) tmp += c - '0';
        //     if (tmp >= min && tmp <= max) r ++;
        //     return r % mod;
        // }
        // static final int mod = (int)1e9 + 7;
        // int m, n, min, max;
        // char [] s, t;
        // int count(char [] s) {
        //     int n = s.length;
        //     int [][] f = new int [n][Math.min(9 * n, max) + 1];
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, -1)); // -1 表示没有计算过  // 这里，不能忘记设置初始值的标记了。。【BUG：】
        //     return dfs(s, f, 0, 0, true);
        // }
        // int dfs(char [] s, int [][] f, int i, int j, boolean isLimit) { // j: sum
        //     if (j > max) return 0; // 数字和超值，非法数字
        //     if (i == s.length) return j >= min ? 1 : 0;
        //     // boolean 变量 val 没有记入状态，是因为 f 记的永远是 val ＝ false 时的状态值； val ＝ true 只有长度的 n 种情况，可以不用记
        //     if (!isLimit && f[i][j] != -1) return f[i][j]; 
        //     int r = 0;
        //     int hi = isLimit ? s[i] - '0' : 9; // 当前数位 i, 如果标记变量 isLimit与限制数是一样的，那就只能取到有限最大值，否则取 9
        //     for (int k = 0; k <= hi; k++) // 遍历当前数位 i 可能取到的所有的数值
        //         r = (r + dfs(s, f, i+1, j + k, isLimit && k == hi)) % mod;
        //     if (!isLimit) f[i][j] = r;
        //     return r;
        // }

        // public boolean isFascinating(int n) {
        //     String s = n + "" + String.valueOf(2 * n) + String.valueOf(3 * n);
        //     if (s.length() != 9) return false;
        //     Set<Character> sc = new HashSet<>(List.of('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        //     if (s.indexOf("0") != -1) return false;
        //     for (char c : sc) 
        //         if (s.indexOf(c) == -1) return false;
        //     return true;
        // }

// // 数据规模狠小，随便来个暴力解法就可以了
//         public int longestSemiRepetitiveSubstring(String t) {
//             int n = t.length(), max = 1; char [] s = t.toCharArray();
//             for (int i = 0; i < n; i++)
//                 for (int j = i+1; j <= n; j++) {
//                     String cur = t.substring(i, j);
//                      System.out.println("cur: " + cur);
//                     if (valid(cur)) {
//                         max = Math.max(max, cur.length());
//                          System.out.println("max: " + max);
//                     }
//                 }
//             return max;
//         }
//         boolean valid(String t) { // 它说，只要是最多只有一对连续两个字符相同
//             int n = t.length(), cnt = 0; char [] s = t.toCharArray();
//             for (int i = 0; i < n-1; i++) {
//                 if (s[i] != s[i+1]) continue;
//                 cnt++;
//             }
//             return cnt <= 1;
//         }

        // // 感觉：读不懂这个题目，为什么 (i,j) 跟 (j,i) 会是一样的？读不懂这个题目，先跳过去
        // 一维的，无限长的线，因为两个相邻的只要会撞，就会改变方向【亲爱的表哥，活宝妹永远不改变方向：因为活宝妹永远就是一定要嫁给亲爱的表哥！！！】
        // 所以 d 时间内，可能是动态变化的。想不透这些动态变化，不写了
        // public int sumDistance(int[] nums, String s, int d) {
        // }
        // 这里 m 【1,10000】， n 【1,5】想的是二分查找，O[NlogN] 搜出一个最大子数组行长度，可是 check(int-v) 行数为某个值时，
        // 觉得这里面，有点儿什么机巧想得不透，今天就不写这个了
        // public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        // }

        // public int findNonMinOrMax(int[] a) {
        //     int min = Arrays.stream(a).min().getAsInt(), max = Arrays.stream(a).max().getAsInt();
        //     for (int v : a)
        //         if (v != min && v != max) return v;
        //     return -1;
        // }

        // public String smallestString(String t) {
        //     int n = t.length(); char [] s = t.toCharArray();
        //     int i = 0, j = -1;
        //     while (i < n && s[i] == 'a') i++;
        //     if (i == n) {
        //         s[n-1] = 'z';
        //     } else {
        //         j = i;
        //         while (j < n && s[j] != 'a') {
        //             s[j] = (char)(s[j] - 1);
        //             j++;
        //         }
        //     }
        //     return new String(s);
        // }

        // // 鬼读得懂这个题目：说得是什么意思呢？读不懂它在移什么。。。
        // public long minCost(int[] a, int x) {
        //     int n = a.length;
        //     return n;
        // }

        // 不写了，不喜欢这些恶心死人不偿命的算法题。。。写项目比较好玩一点儿
        // public int[] maximumSumQueries(int[] a, int[] b, int[][] c) {
        //     n = a.length; m = c.length;
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < m; i++) l.add(new int [] {i, c[i][0], c[i][1]});
        //     Collections.sort(l, (x, y) -> x[1] != y[1] ? x[1] - y[1] : x[2] - y[2]); // 第一个数组值升序排列
        //     List<int []> ll = new ArrayList<>();
        //     for (int i = 0; i < n; i++) ll.add(new int [] {a[i], b[i]});
        //     Collections.sort(ll, (x, y) -> x[1] != y[1] ? x[1] - y[1] : x[2] - y[2]); //a 升序， b 升序
        //     int [] r = new int [m];
        //     for (int [] v : l) {
        //         int i = v[1], j = v[2];
        //         int k = binarySearch(i, ll);
        //     }
        // }
        // int m, n;
        // int binarySearch(int i, int j, List<int []> l) { // 直接就二分查找最大值，最大和
        //     int [] r = l.get(m-1);
        //     if (i > r[1] || j > r[2]) return -1; // 完全没有满足条件的
        //     // if (r[1] >= i && r[2] >= j) return r[1] + r[2];
        //     // 其它情况，就是至少有一个满足条件的，直接二分查找和
        //     int lo = l.get(0)[1] + l.get(0)[2], hi = l.get(m-1)[1] + l.get(m-1)[2];
        // }

        // static final int mod = (int)1e9 + 7;
        // public int sumDistance(int[] a, String t, int d) {
        //     int n = a.length; char [] s = t.toCharArray();
        //     // 先独立计算这些机器人在 d 秒后的位置：因为机器人可以互相穿透对方
        //     // （【活宝妹想要能够从亲爱的表哥的灵魂中川行、穿过。。。任何时候，活宝妹就是一定要嫁给亲爱的表哥！！！】）
        //     long [] r = new long [n];
        //     for (int i = 0; i < n; i++)
        //         // a[i] = (s[i] == 'L' ? a[i] - d : a[i] + d); // 这个，只是它的系统测试用例不健全，这种写法会溢出，必须改变 long 【】数组才对。。。
        //         r[i] = (s[i] == 'L' ? (long)a[i] - (long)d : (long)a[i] + (long)d); // 这个，只是它的系统测试用例不健全，这种写法会溢出，必须改变 long 【】数组才对。。。
        //         // r[i] = (long) a[i] + d * ((s[i] & 2) - 1); // L=-1, R=1 看不懂这算是什么写法？ s[i] & 2: 活宝妹就是一定要嫁给亲爱的表哥！！
        //     Arrays.sort(r); // 排序一下，不影响结果
        //     // long [] r = new long [n]; // 这里并不真的需要前缀和，只要一个变量记之前的和就可以了
        //     // for (int i = 0; i < n; i++)
        //     //     r[i] = (i == 0 ? 0 : r[i-1]) + (long)a[i];
        //     long sum = 0, ans = 0;
        //     for (int i = 0; i < n; i++) {
        //         ans = (ans + (long)i * r[i] - sum) % mod;
        //         sum += r[i];
        //     }
        //     return (int)ans;
        // }

        // // 看不懂：这个题目的列数，是在干什么，起什么作用？读不懂提示，不理解提示。。。
        // public List<Integer> goodSubsetofBinaryMatrix(int[][] a) {
        //     int m = a.length, n = a[0].length;
        //     for (int i = 0; i < m; i++) 
        //         if (Arrays.stream(v).sum() == 0) return i;
        // }
        // 其它的题目，晚点儿改天再写

        // public int distanceTraveled(int x, int y) {
        //     int r = 0;
        //     while (x >= 5 && y >= 1) {
        //         r += 10 * 5;
        //         x -= 4;
        //         y -= 1;
        //     }
        //     return r + 10 * x;
        // }

        // public int findValueOfPartition(int[] a) {
        //     int n = a.length, min = Integer.MAX_VALUE;
        //     Arrays.sort(a);
        //     for (int i = 0; i < n-1; i++)
        //         min = Math.min(min, Math.abs(a[i] - a[i+1]));
        //     return min;
        // }

        // public int specialPerm(int[] a) {
        //     n = a.length; this.a = a;
        //     return dfs(1, 0);
        // }
        // static final int mod = (int)1e9 + 7;
        // int [] a; int n;
        // Map<Long, Integer> m = new HashMap<>();
        // int dfs(int i, int j) {
        //     if (j == (1 << n) - 1) return 1;
        //     long key = (long) i << 14 | j;
        //     if (m.containsKey(key)) return m.get(key);
        //     int r = 0;
        //     for (int k = 0; k < n; k++) 
        //         if ((j & (1 << k)) == 0 && (a[k] % i == 0 || i % a[k] == 0))
        //             r = (r + dfs(a[k], j | (1 << k))) % mod;
        //     m.put(key, r);
        //     return r;
        // }        

        // // 这个题目：有个参数没有拎清楚。再想一下，改天再试着来写
        // public int paintWalls(int[] a, int[] b) {
        //     n = a.length; this.a = a; this.b = b; 
        //     for (int i = 0; i < n; i++)
        //         l.add(new int [] {a[i], b[i]});
        //     Collections.sort(l, (x, y) -> x[0] != y[0] ? x[0] - y[0] : y[1] - x[1]);
        //     return dfs(0, 0, new int [n]);
        // }
        // List<int []> l = new ArrayList<>();
        // Map<String, Integer> m = new HashMap<>(); // 数据比较离散
        // int [] a, b;
        // int n;
        // int dfs(int i, int j, int [] v) { // 对于每个当前的 i, 付费做和留给闲将做
        //     if (Arrays.stream(v).sum() == n) return 0;
        //     String key = i + "-" + j + "-" + Arrays.toString(v);
        //     if (m.containsKey(key)) return m.get(key);
        //     int r = Integer.MAX_VALUE;
        //     if (j > 0) {
        //         int x = j;
        //         for (int k = n-1; k >= 0 && x > 0; k--) {
        //             if (v[k] == 1) continue; 
        //             v[k] = 1;
        //             x --;
        //         }
        //         m.put(key, dfs(i, 0, v));
        //         return m.get(key);
        //     }
        //     while (i < n && v[i] == 1) i++;
        //     if (i == n) {
        //         i = 0;
        //         while (i < n && v[i] == 1) i++;
        //         if (i == n) return 0;
        //     }
        //     v[i] = 1;
        //     r = Math.min(r, l.get(i)[0] + dfs(i+1, l.get(i)[1], v));
        //     v[i] = 0;
        //     r = Math.min(r, dfs(i+1, 0, v)); // 这里跳过 i, 就是前面可能存在没有处理的元素
        //     m.put(key, r);
        //     return r;
        // }

        // public int maximumNumberOfStringPairs(String[] a) {
        //     int n = a.length, r = 0;
        //     Set<String> s = new HashSet<>();
        //     for (int i = 0; i < n; i++) {
        //         String cur = new String(new StringBuilder(a[i]).reverse());
        //         if (s.contains(cur)) {
        //             r++;
        //             s.remove(cur);
        //         } else s.add(a[i]);
        //     }
        //     return r;
        // }

        // // 【记忆化深搜】：方法思路是对的，不知道、不明白为什么会超时？
        // public int longestString(int x, int y, int z) {
        //     n = Math.max(x, Math.max(y, z)) + 1;
        //     f = new Integer [n][n][n][4];// 最后一维：标记前面一个字符串是哪个
        //     return dfs(x, y, z, 3);
        // }
        // Integer [][][][] f;
        // int n;
        // int dfs(int i, int j, int k, int x) {
        //     if (i < 0 || j < 0 || k < 0) return 0;
        //     if (i == 0 && j == 0 && k == 0) return 0;
        //     if (f[i][j][k][x] != null) return f[i][j][k][x];
        //     int r = 0;
        //     if (i > 0 && x != 0) // 可以接在 y z 后面，不能接在自己的后面
        //         r = Math.max(r, 2 + dfs(i-1, j, k, 0));
        //     if (j > 0 && (x == 3 || x == 0)) // 可以接在 x 后面
        //         r = Math.max(r, 2 + dfs(i, j-1, k, 1));
        //     if (k > 0 && x != 0) // 可以接在 y,z 自己的后面
        //         r = Math.max(r, 2 + dfs(i, j, k-1, 2));
        //     return f[i][j][k][x] = r;
        // }

        // // 【记忆化深搜】：直接用自顶向下的【动规】来写。因为是自顶向下，这里感觉不太会用【记忆化深搜】来倒着搜？这两个方法的转化，在这个题，脑袋里失效了。。。先写下一个
        // public int minimizeConcatenatedLength(String[] a) {
        //     n = a.length;
        //     // f = new int [n][2]; // 后一维：标记是【i-1,i】＝0, 【i,i-1】＝ 1 的最小长度
        //     m.put(0, new String [] {a[0], a[0], String.valueOf(a[0].length()), String.valueOf(a[0].length())});
        //     for (int i = 1; i < n; i++) {
        //         // 这里的情况：就变成为，细节狠繁琐，思路仍然是直白的
        //         String pone = m.get(i-1)[0], ptwo = m.get(i-1)[1];
                
        //         String one = getAddedString(pone, a[i]);    // 这里要去拿先前存的
        //         String oneone = getAddedString(a[i], pone); // 这里要去拿先前存的
        //         String two = getAddedString(ptwo, a[i]);
        //         String twotwo = getAddedString(a[i], ptwo);
        //         // 现在脑袋有点儿不转了：过程中，非最终结果，字符串可能存在的个数，是呈指数增加，还是固定不变的？
        //         // 如何过把程中的结果记下来呢？
        //         int p = Integer.parseInt(m.get(i-1)[2]);
        //         String oo = one.length() >
        //         m.put(i, new String [] {
        //                 one, two, String.valueOf(p + one.length()), String.valueOf(p + two.length())});
        //     }
        //     return Math.max(Integer.parseInt(m.get(n-1)[2]), Integer.parseInt(m.get(n-1)[3]));
        // }
        // Map<Integer, String []> m = new HashMap<>();
        // int n;
        // String getAddedString(String S, String T) {
        //     int m = S.length(), n = T.length();
        //     char [] s = S.toCharArray(), t = T.toCharArray();
        //     int i = 0;
        //     while (i < n && m >= i+1 && S.endsWith(T.substring(0, i+1))) i++;
        //     return i == n ? "" : T.substring(i);
        // }

        // 【任何时候，活宝妹就是一定要嫁给亲爱的表哥！！！爱表哥，爱生活！！！】
        public int[] countServers(int n, int[][] logs, int x, int[] queries) {
            
        }
    }             
    public static void main (String[] args) { 
        Solution s = new Solution ();

        int r = s.minimizeConcatenatedLength(a);
        System.out.println("r: " + r);
    }
}
// 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
// 【任何时候，活宝妹就是一定要嫁给亲爱的表哥！！】











