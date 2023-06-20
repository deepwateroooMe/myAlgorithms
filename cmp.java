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

        // // 感觉这个题：数据规模小，只要写出一个干净的全排列，必要的优化，应该就可以过，不明白为什么只有 2665 个人写过了？
        // public int specialPerm(int[] a) {
        //     n = a.length; this.a = a;
        //     Arrays.sort(a); // 为什么要升序排列：全排列顺序不再重要，所以可以排列帮助自己
        //     // 最后几十个测试用例：可能有些特殊情况需要考虑，但是还没能想明白
        //     // int d = a[1] / a[0];
        //     // if (a[1] % a[0] == 0) {
        //     //     if (n == 2) return 2;
        //     //     int i = 2;
        //     //     for (i = 2; i < n; i++)
        //     //         if (a[i] % a[i-1] != 0 || a[i] / a[i-1] != d) break;
        //     //     if (i == n) return 2 * n;
        //     // }
        //     perm(0, new ArrayList<Integer>(), new boolean [n]);
        //     return (int)(r % mod);
        // }
        // static final int mod = (int)1e9 + 7;
        // int [] a; int n;
        // long r = 0; 
        // void perm(int i, List<Integer> l, boolean [] vis) {
        //     if (l.size() == n) {
        //         r++;
        //         return ;
        //     }
        //     for (int j = 0; j < n; j++) {
        //         if (vis[j]) continue;
        //         if (l.size() == 0 || a[j] % l.get(l.size()-1) == 0 || l.get(l.size()-1) % a[j] == 0) {
        //             l.add(a[j]);
        //             vis[j] = true;
        //             perm(j+1, l, vis);
        //             l.remove(l.size()-1);
        //             vis[j] = false;
        //         }
        //     }
        // }

        // 【动规：】只有两个涂匠，是什么意思呢？两个要花钱的涂匠永远涂最便宜的两个，同样时间范围内，1 个免费涂匠永远涂最贵的这个时间段的墙。。。
        // 先排序一下：费用【从小到大】；但是因为消耗时间的问题，仍然是一个因素
        // 再用一个最大堆来消息 n 个费用最大的墙【这里就成为费用、时间两个因素的平衡。。。】
        // 【记忆化深搜】：一般动规，都能改写成记忆化深搜。。。？？？觉得这个方法仍然是最合适的
        public int paintWalls(int[] a, int[] b) {
            n = a.length; this.a = a; this.b = b; 
            return dfs(2, 0, new int [n]); // 2 个涂匠
        }
        Map<String, Integer> m = new HashMap<>();
        int n; int [] a, b;
        int dfs(int i, int j, int [] vis) {
            // System.out.println("\n i: " + i);
            // System.out.println("j: " + j);
            // System.out.println(Arrays.toString(vis));
            if (Arrays.stream(vis).sum() == n) return 0; // 全部涂完了
            String key = i + "-" + j + "-" + Arrays.toString(vis);
            if (m.containsKey(key)) return m.get(key);
            if (i == 0) {
                Queue<Integer> q = new PriorityQueue<>((x, y)->a[y] - a[x]); // 最大堆
                for (int k = 0; k < n; k++)
                    if (vis[k] == 0) q.offer(k);
                int x = j;
                while (x > 0 && !q.isEmpty()) {
                    vis[q.poll()] = 1;
                    x--;
                }
                m.put(key, dfs(2, 0, vis));
                return m.get(key);
            }
            int r = Integer.MAX_VALUE;
            for (int k = 0; k < n; k++) { // 这里一定会超时，所以需要排序的优化。。。【这个会超时的方法】：也不知道哪里写错了，改天再写。。【活宝妹就是一定要嫁给亲爱的表哥！！爱表哥，爱生活！！！】
                if (vis[k] == 1) continue;
                vis[k] = 1;
                System.out.println(Arrays.toString(vis));
                r = Math.min(r, a[k] + dfs(i-1, j + b[k], vis));
                // System.out.println("r: " + r);
                vis[k] = 0;
            }
            m.put(key, r);
            // System.out.println("\n i: " + i);
            // System.out.println("j: " + j);
            // System.out.println("r: " + r);
            return r;
        }        
    }             
    public static void main (String[] args) { 
        Solution s = new Solution ();

        // int [] a = new int [] {1, 2, 3, 2};
        // int [] b = new int [] {1,2,3,2};
        int [] a = new int [] {2, 3, 4, 2};
        int [] b = new int [] {1, 1, 1, 1};

        int r = s.paintWalls(a, b);
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













































