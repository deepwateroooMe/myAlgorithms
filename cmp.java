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

        // // 【记忆化深搜】：方法思路是对的，不知道、不明白为什么会超时？是因为还是更简单的，脑袋急转变的解法，妈的，吭死人不偿命。。。活宝妹哼哧哼哧写了半天。。。
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
        // public int longestString(int x, int y, int z) { // 吭死人不偿命，这种题太可恶了！！！
        //     return Math.min(x, y) * 4 + (x != y ? 2 : 0) + 2 * z;
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

        // // 要把题目所给的线索稍微理一理：排序，滑动窗口？
        // public int[] countServers(int n, int[][] a, int v, int[] q) {
        //     // 【排序：】分两边：
        //     Arrays.sort(a, (x, y) -> x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]); // 服务器时间顺序的排序
        //     int m = q.length;
        //     List<int []> li = new ArrayList<>(); // 查询的排序
        //     for (int i = 0; i < m; i++)             
        //         li.add(new int [] {i, q[i]});
        //     Collections.sort(li, (x, y) -> x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]);
        //     // 解题：顺序遍历，感觉一个滑动窗口，是可以解决问题的
        //     int i = 0, j = 0, k = 0;
        //     int [] r = new int [m];
        //     while (j < m) { // j: 遍历查询;
        //         while (i < n && a[i][1] < li.get(j)[1] - v) i++; // 去头：【左端点，右移】 前面所有时间不符合的去掉
        //         if (i == n) {
        //             r[li.get(j)[0]] = 0;
        //             return r;
        //         }
        //         // 把当前 i 记下来
        //         // m.put(i, a[i][1]);
        //         insert(new int [] {i, a[i][1]});                
        //         k = i+1; // 右端点
        //         while (k < n && a[k][1] <= li.get(j)[1]) {
        //             // 入窗口管理，记下来
        //             k++; // 【右端点：】右移
        //         }
        //         r[li.get(j)[0]] = k - i; // 计结果: 不能直接这么数，它还有重复！！！
        //         j++;
        //     }
        //     return r;
        // }
        // // Map<Integer, int []> m = new HashMap<>(); // 记录窗口内的 id, 最后发布时间 ?
        // // 需要一个有序字典：有序数据结构来，记录过往时间，方便【左端点】右移时，删除不符合条件的
        // // 数据结构：必须方便查找、更新，与踢除，所以最好自己维护升序链表，自己维护排序
        // // Queue<int []> q = new PriorityQueue<>((x, y) -> x[]); // 这个可能会超时
        // List<int []> l = new ArrayList<>();// 维护 l[i][1] 升序排列，可是同样会有更新时，需要更新某个 id 的情况？怎么查，没序？
        // // 还是把这个题先放一下，改天再写
        // void insert(int [] a) {
        //     if (l.size() == 0) {
        //         l.add(0, a);
        //         return ;
        //     }
        // }

        // public int countBeautifulPairs(int[] a) {
        //     int n = a.length, r = 0;
        //     for (int i = 0; i < n-1; i++)
        //         for (int j = i+1; j < n; j++)
        //             if (gcd(Integer.parseInt(String.valueOf(a[i]).substring(0, 1)), a[j] % 10) == 1) r++;
        //     return r;
        // }
        // int gcd(int x, int y) {
        //     if (y == 0) return x;
        //     return gcd(y, x % y);
        // }

        // static final int mod = (int)1e9 + 7;
        // public int numberOfGoodSubarraySplits(int[] a) {
        //     int n = a.length;
        //     long ans = 1;
        //     int [] r = new int [n];
        //     for (int i = 0; i < n; i++)
        //         r[i] = (i == 0 ? 0 : r[i-1]) + a[i];
        //     if (r[n-1] <= 1) return r[n-1];
        //     System.out.println(Arrays.toString(r));
        //     int i = 0, j = 0;
        //     while (i < n && r[i] < 1) i++;
        //     while (j < n) {
        //         j = i+1;
        //         while (j < n && r[j] == r[i]) j++;
        //         ans = (ans * (j == n ? 1 : j - i)) % mod;
        //         i = j;
        //     }
        //     return (int)ans;
        // }

        // public List<Integer> survivedRobotsHealths(int[] a, int[] h, String T) {
        //     int n = T.length(); 
        //     if (T.chars().distinct().count() == 1) return Arrays.stream(h).boxed().collect(Collectors.toList()); // 如果只有一个方向，直接返回
        //     // 需要先排序一下，但是要记住下标
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         l.add(new int [] {h[i], (T.charAt(i) == 'R' ? 0 : 1), i, a[i]});
        //     Collections.sort(l, (x, y) -> x[3] - y[3]);
        //     int [] tmp = new int [n];
        //     int i = 0;
        //     Deque<int []> s = new ArrayDeque<>();
        //     while (i < n && l.get(i)[1] == 1) {
        //         tmp[l.get(i)[2]] = l.get(i)[0];
        //         i++;
        //     }
        //     while (i < n) {
        //         while (i < n && l.get(i)[1] == 0) { // 向右移动
        //             s.offerFirst(l.get(i));
        //             i++;
        //         }
        //         while (i < n && l.get(i)[1] == 1 && !s.isEmpty()) {
        //             if (s.peekFirst()[0] > l.get(i)[0]) {
        //                 s.peekFirst()[0] -= 1;
        //                 i++;
        //             } else if (s.peekFirst()[0] == l.get(i)[0]) {
        //                 s.pollFirst();
        //                 i++;
        //             } else {
        //                 s.pollFirst();
        //                 l.get(i)[0] -= 1;
        //             }
        //         }
        //         if (i < n && s.isEmpty() && l.get(i)[1] == 1) {
        //             // s.offerFirst(l.get(i));
        //             tmp[l.get(i)[2]] = l.get(i)[0];
        //             i++;
        //             while (i < n && l.get(i)[1] == 1) {
        //                 tmp[l.get(i)[2]] = l.get(i)[0];
        //                 i++;
        //             }
        //         } 
        //     }
        //     while (!s.isEmpty()) {
        //         int [] cur = s.pollFirst();
        //         tmp[cur[2]] = cur[0];
        //     }
        //     List<Integer> ans = new ArrayList<>();
        //     for ( i = 0; i < n; i++)
        //         if (tmp[i] > 0) ans.add(tmp[i]);
        //     return ans;
        // }

        // // 把人恶心死的贱题目。。。
        // // 不知道这个死题目说的是什么意思，讨厌这种恶心题目，以后不写了。。。
        // public int makeTheIntegerZero(int x, int y) {
        //     return dfs(x, y);
        // }
        // Map<Integer, int []> m = new HashMap<>();
        // int dfs(int i, int j) {
        //     if (i == 0) return 0;
        //     if (m.containsKey(i)) return m.get(i);
        // }

        // public int longestAlternatingSubarray(int[] a, int k) { // 把人恶心死的题目
        //     int n = a.length;
        //     int [] f = new int [n];
        //     for (int i = 0; i < n; i++)
        //         if (a[i] % 2 == 0 && a[i] <= k) f[i] = 1;
        //     if (a[n-1] <= k) f[n-1] = (a[n-1] % 2 == 0 ? 1 : 0);
        //     if (n == 1) return a[0] % 2 == 0 && a[0] <= k ? 1 : 0;
        //     for (int i = n-2; i >= 0; i--) { // 从后往前遍历
        //         if (a[i] > k) continue;
        //         if (f[i] > 0 && a[i] % 2 != a[i+1] % 2)
        //             f[i] = (f[i+1] > 0 ? f[i+1] : (a[i+1] <= k ? 1 : 0)) + 1;
        //         else if (i > 0 && f[i] == 0 && a[i-1] <= k && a[i-1] % 2 != a[i] % 2 && a[i+1] <= k && a[i] % 2 != a[i+1] % 2)
        //             f[i] = f[i+1] + 1;
        //     }
        //     return Arrays.stream(f).max().getAsInt();
        // }

        // // TLE: 不知道再怎么提速了。。。我感觉自己先 process 了一遍，用一个数组标记了是否是质数，但计算是否是质数的算法不对
        // public List<List<Integer>> findPrimePairs(int n) {
        //     List<List<Integer>> ll = new ArrayList<>();
        //     f = new Boolean [n+1];
        //     for (int i = 2; i <= n; i++)
        //         for (int j = 2; j * j <= i; j++) {
        //             if (i == j) continue;
        //             if (i % j == 0) f[i] = false;
        //         }
        //     for (int i = 2; i <= n / 2; i++) {
        //         if (f[i] != null && !f[i]) continue;
        //         if (isPrime(i) && isPrime(n - i))
        //             ll.add(List.of(i, n-i));
        //     }
        //     return ll;
        // }
        // Boolean [] f;
        // boolean isPrime(int v) {
        //     if (f[v] != null) return f[v];
        //     if (v == 1) {
        //         f[v] = true;
        //         return true;
        //     }
        //     for (int i = 2; i * i <= v; i++) 
        //         if (v % i == 0) {
        //             f[v] = false;
        //             return false;
        //         }
        //     f[v] = true;
        //     return true;
        // }

//         public long continuousSubarrays(int[] a) {
//             int n = a.length;
// // 只有使用【双端队列】自己维护排序，才是【O(N)】解法；其它是【O(NlgN)】解法 
//             ArrayDeque<Integer> min = new ArrayDeque<>(); // 升序: 保留重复
//             ArrayDeque<Integer> max = new ArrayDeque<>(); // 降序
//             long ans = 0;
//             for (int r = 0, l = 0; r < n; r++) { // 遍历：处理每一个右端点 r
//                 // 在添加当前下标 r 的值前，检查两队列，维护他们的排序，【预处理】: 两队列的右端点，并添加进队列
//                 while (!min.isEmpty() && a[min.peekLast()] > a[r]) min.pollLast();
//                 min.offerLast(r);
//                 while (!max.isEmpty() && a[max.peekLast()] < a[r]) max.pollLast();
//                 max.offerLast(r);
//                 // 【预处理】：两队列的队列头，舍弃不合法的队列头
//                 while (!min.isEmpty() && !max.isEmpty() && a[max.peekFirst()] - a[min.peekFirst()] > 2) { // 去看两队列的排序，当然是比较头呀。。。
//                     if (max.peekFirst() < min.peekFirst()) 
//                         l = max.pollFirst() + 1;
//                     else l = min.pollFirst() + 1;
//                 }
//                 ans += r - l + 1; // 取【遍历当前下标 r】的子数组的个数
//             }
//             return ans;
//         }

// // 这个题：完全读不懂，也读不懂它的破烂提示说的是什么意思，过段时间再写
//         public int sumImbalanceNumbers(int[] a) { 
//             int n = a.length;
//         }

        // 亲爱的表哥，早上的活宝妹，被他们破烂网站以网络宕机为名，剥夺了活宝妹早上做这几个题目的机会，下午就稍微写一下
        // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹，就是一定要嫁给亲爱的表哥！！爱表哥，爱生活！！！】

        // 这个题目，说得狠绕，看半天才看懂: 【记忆化深搜】：真的，第一个题目记忆化深搜，他们真来了。。。
        // 这个方法对吗，子数组，如果记忆化深搜，怎么处理连贯性问题？
        // 爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！
        // public int alternatingSubarray(int[] a) { // 不知道哪里写错了，先放一下
        //     n = a.length; this.a = a; 
        //     f = new Integer [n][2];
        //     int r = dfs(0, 0); 
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z) 
        //         System.out.println(Arrays.toString(f[z]));
        //     return r == 0 ? -1 : r;
        // }
        // Integer [][] f; int [] a;
        // int n;
        // int dfs(int i, int j) {
        //     if (j == 1 && i == n-1) return 1;
        //     if (i >= n-1) return 0;
        //     if (f[i][j] != null) return f[i][j];
        //     int r = 0;
        //     if (j == 0 && a[i] == a[i+1] - 1)
        //         r = Math.max(r, 1 + dfs(i+1, 1));
        //     else if (j == 1 && a[i] == a[i+1] + 1)
        //         r = Math.max(r, 1 + dfs(i+1, 0));
        //     if (j == 0) r = Math.max(r, dfs(i+1, 0));
        //     if (j == 1) r = Math.max(r, dfs(i+1, 0));
        //     if (j == 1 && r == 1) r = 2;
        //     return f[i][j] = r;
        // }        
        // // int [] a = new int [] {42,43,44,43,44,43,44,45,46};

        // public List<Integer> relocateMarbles(int[] a, int[] s, int[] e) {
        //     int n = s.length;
        //     Set<Integer> c = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     for (int i = 0; i < n; i++) {
        //         c.remove(new Integer(s[i]));
        //         c.add(e[i]);
        //     }
        //     List<Integer> l = new ArrayList<>(c);
        //     Collections.sort(l);
        //     return l;
        // }

        // // 先试写一下：【自顶向下】动规：
        // public int minimumBeautifulSubstrings(String S) {
        //     int n = S.length();
        //     char [] s = S.toCharArray();
        //     f = new int [n];
        //     Arrays.fill(f, Integer.MAX_VALUE);
        //     if (s[0] == '0') return -1;
        //     return dfs(0);
        // }
        // // 【记忆化深搜】：
        // public int minimumBeautifulSubstrings(String S) {
        //     n = S.length(); this.t = S; 
        //     s = S.toCharArray();
        //     f = new int [n];
        //     Arrays.fill(f, Integer.MAX_VALUE / 2);
        //     int r = dfs(0); 
        //     return r == Integer.MAX_VALUE / 2 ? -1 : r;
        // }
        // int [] f;
        // int n; char [] s; String t;
        // int dfs(int i) {
        //     if (i == n) return 0;
        //     if (f[i] != Integer.MAX_VALUE / 2) return f[i];
        //     if (s[i] == '0') return f[i] = Integer.MAX_VALUE / 2;
        //     if (i == n-1) return f[i] = 1;
        //     if (i > n-3) return f[i] = 1 + dfs(i+1);
        //     int r = Integer.MAX_VALUE / 2, j = 0;
        //     for (j = n; j >= i+1; j--) {
        //         // 我这里：5 的指数次方，简单想成是以 1 或 101 结尾，可能不一定对？
        //         if (j - i >= 3 && t.substring(j-3, j).equals("101")) {
        //             r = Math.min(r, 1 + dfs(j));
        //             // break;// 因为我倒序遍历，找到一个应该可以停
        //         }
        //     }
        //     if (j == i) r = Math.min(r, 1 + dfs(i+1));
        //     return f[i] = r;
        // }

        // // 这个题目，说的不知道是什么意思，没有思路
        // public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        // }

        // public int theMaximumAchievableX(int num, int t) {
        //     return num + t * 2;
        // }

        // public int maximumJumps(int[] a, int t) {
        //     n = a.length; this.a = a; this.t = t; 
        //     f = new Integer [n];
        //     int r = dfs(0);
        //     return r < 0 ? -1 : r;
        // }
        // Integer [] f;
        // int n, t; int [] a;
        // int dfs(int i) {
        //     if (i == n-1) return 0;
        //     if (f[i] != null) return f[i];
        //     int r = Integer.MIN_VALUE / 2;
        //     for (int j = i+1; j < n; j++) {
        //         if (Math.abs(a[j] - a[i]) > t) continue;
        //         r = Math.max(r, 1 + dfs(j));
        //     }
        //     return f[i] = r;
        // }        

        // public boolean checkArray(int[] a, int k) {
        //     if (k == 1) return true;
        //     int n = a.length;
        //     for (int i = n-1; i - k >= -1; i--) {
        //         if (a[i] == 0) continue;
        //         for (int j = i-1; j > i - k && j >= 0; j--) {
        //             a[j] -= a[i];
        //             if (a[j] < 0) return false;
        //         }
        //         a[i] = 0;
        //     }
        //     return Arrays.stream(a).max().getAsInt() == 0;
        // }

        // public int maxNonDecreasingLength(int[] a, int[] b) {
        //     int n = a.length;
        //     Integer [][] f = new Integer [n][2]; // 0 : a, 1 : b
        //     // 不用【记忆化深搜】，就【自顶向下】从头到尾动规
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, 1));
        //     for (int i = 1; i < n; i++) {
        //         if (a[i] >= a[i-1]) f[i][0] = Math.max(f[i][0], 1 + f[i-1][0]);
        //         if (a[i] >= b[i-1]) f[i][0] = Math.max(f[i][0], 1 + f[i-1][1]);
        //         if (b[i] >= a[i-1]) f[i][1] = Math.max(f[i][1], 1 + f[i-1][0]);
        //         if (b[i] >= b[i-1]) f[i][1] = Math.max(f[i][1], 1 + f[i-1][1]);
        //     }
        //     int max = 0;
        //     for (int i = 0; i < n; i++)
        //         max = Math.max(max, Math.max(f[i][0], f[i][1]));
        //     return max;
        // } // 今天晚上的题目出得太简单了，写得也没有什么意思。。今天晚上暂时先写两三个题目，要脑袋好好转一转，晚上才睡得着吧。。爱表哥，爱生活！！！

    //     // 这个题目应该不难，繁琐在哪里呢？这题写得太烦人，没有收获，不写这个题目了
    // Map<Integer, List<int []>> m = new HashMap<>(); // mID: [idx, size]
    // // TreeMap<Integer, Integer> idx = new TreeMap<>(); // idx: length 按占用着的、下标升序排列. 【这个是优化】O(10^6) 可能暴力可以过？
    // boolean [] v; // vis
    // int n;
    // public Allocator(int n) {
    // // public cmp(int n) {
    //     this.n = n; 
    //     v = new boolean [n];
    // }
    // public int allocate(int size, int mID) { // 同一个 mID 可能多次出现，得记住【用个字典】
    //     int idx = getIdx(size);
    //     System.out.println("idx: " + idx);
    //     if (idx == -1) return -1;
    //     for (int i = idx; i < idx + size; i++)
    //         v[i] = true;
    //     m.computeIfAbsent(mID, z -> new ArrayList<>()).add(new int [] {mID, size});
    //     return idx;
    // }
    // public int free(int mID) {
    //     if (!m.containsKey(mID)) return 0;
    //     int r = 0;
    //     for (int [] c : m.get(mID)) {
    //         r += c[1];
    //         for (int i = c[0]; i + c[1] <= n; i++)
    //             v[i] = false;
    //     }
    //     return r;
    // }
    // int getIdx(int x) {
    //     for (int i = 0; i < n; i++) {
    //         if (v[i]) continue;
    //         if (x == 1) return i;
    //         int j = i+1;
    //         for ( j = i+1; j < i + x && j < n; j++) 
    //             if (v[j]) break;
    //         if (j + x > n) return i;
    //     }
    //     return -1;
    // }

        // int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        // int [] p, size; // 使用【并查集】
        // // 不仅求值数值排序，也要把矩形排序。【矩形的排序】，这个题目，被我忘记了。。
        // public int[] maxPoints(int[][] arr, int[] b) {
        //     int m = arr.length, n = arr[0].length, mn = m * n, o = b.length;
        //     // 【并查集】
        //     p = new int [mn];
        //     for (int i = 0; i < mn; i++) p[i] = i;
        //     size = new int [mn];
        //     Arrays.fill(size, 1);
        //     // 【矩阵排序：】升序处理
        //     int [][] a = new int [mn][3];
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++)
        //             a[i*n+j] = new int [] {arr[i][j], i, j};
        //     Arrays.sort(a, (x, y)-> x[0] - y[0]);
        //     // 查询的下标按照查询值从小到大排序，方便离线
        //     Integer [] id = IntStream.range(0, o).boxed().toArray(Integer[]::new);
        //     Arrays.sort(id, (i, j)->b[i] - b[j]); // 按查询值：升序排列
        //     int [] ans = new int [o];
        //     int j = 0;
        //     for (int i : id) { // 遍历查询值 
        //         int val = b[i];
        //         for (; j < mn && a[j][0] < val; ++j) { // 这里 j 是，对所有 id 的数，连续遍历一次
        //             int x = a[j][1],  y = a[j][2];
        //             // 枚举周围四个格子，值小于 val才可以合并：并查连通集
        //             for (int [] d : dirs) { // 遍历周边四个方向
        //                 int xx = x + d[0], yy = y + d[1];
        //                 if (xx >= 0 && xx < m && yy >= 0 && yy < n && arr[xx][yy] < val) // 题目要求的是：严格小于
        //                     merge(x * n + y, xx * n + yy); // 把坐标压缩成一维的编号
        //             }
        //         }
        //         if (arr[0][0] < val)
        //             ans[i] = size[find(0)];
        //     }
        //     return ans;
        // }
        // // 并查集模板
        // int find(int v) {
        //     if (p[v] != v)
        //         p[v] = find(p[v]); // 这一步的原理，需要再熟悉一下
        //     return p[v];
        // }
        // void merge(int bgn, int end) {
        //     bgn = find(bgn); // 找到最原始的父节点
        //     end = find(end);
        //     if (bgn != end) { // 不在同一个连通集里
        //         p[bgn] = end;
        //         size[end] += size[bgn];
        //     }
        // }
        // // 【最小堆】：跟我最原始的思路差不多，可是自己有一点儿没能想透，没写完。。。【这个方法没再写一遍，改天再写】
        // // 睡眠被干扰，一窃一丝没想明白，就没能写完。。。恨它们恨得要死！！！【任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！！爱表哥，爱生活！！！】
        // private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // public int[] maxPoints(int[][] grid, int[] queries) {
        //     // 查询的下标按照查询值从小到大排序，方便离线
        //     var k = queries.length;
        //     var id = IntStream.range(0, k).boxed().toArray(Integer[]::new);
        //     Arrays.sort(id, (i, j) -> queries[i] - queries[j]);
        //     var ans = new int[k];
        //     var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        //     pq.add(new int[]{grid[0][0], 0, 0});
        //     grid[0][0] = 0; // 充当 vis 数组的作用
        //     int m = grid.length, n = grid[0].length, cnt = 0;
        //     for (var i : id) {
        //         var q = queries[i];
        //         while (!pq.isEmpty() && pq.peek()[0] < q) {
        //             ++cnt;
        //             var p = pq.poll();
        //             for (var d : dirs) { // 枚举周围四个格子
        //                 int x = p[1] + d[0], y = p[2] + d[1];
        //                 if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] > 0) {
        //                     pq.add(new int[]{grid[x][y], x, y});
        //                     grid[x][y] = 0; // 充当 vis 数组的作用
        //                 }
        //             }
        //         }
        //         ans[i] = cnt;
        //     }
        //     return ans;
        // }

        // public int sumOfSquares(int[] a) {
        //     int n = a.length, r = 0;
        //     for (int i = 1; i <= n; i++)
        //         if (n % i == 0) r += a[i-1] * a[i-1];
        //     return r;
        // }
        
        // // 【亲爱的表哥，你的活宝妹居然没忘记，轻松写过了。。。任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！爱表哥，爱生活！！！】
        // // 这个破题目：感觉是什么差分数组，之类的.
        // public int maximumBeauty(int[] a, int k) {
        //     int n = a.length, r [] = new int [100001], max = 0;
        //     for (int v : a) {
        //         r[Math.max(0, v-k)] += 1;
        //         r[Math.min(100000, v + k + 1)] -= 1;
        //     }
        //     max = r[0];
        //     for (int i = 1; i <= 100000; i++) {
        //         r[i] += r[i-1];
        //         max = Math.max(max, r[i]);
        //     }
        //     return max;
        // }

        // public int minimumIndex(List<Integer> l) {
        //     int n = l.size(), maxVal = 0, maxCnt = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         int v = l.get(i);
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //         if (m.get(v) > maxCnt) {
        //             maxVal = v;
        //             maxCnt = m.get(v);
        //         }
        //     }
        //     m.clear();
        //     for (int i = 0; i < n-1; i++) {
        //         int v = l.get(i);
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //         if (l.get(i) != maxVal) continue;
        //         if (m.get(v) * 2 > i+1 && (maxCnt - m.get(v)) * 2 > n - (i+1))
        //             return i;
        //     }
        //     return -1;
        // }

        // public class Node {
        //     Node [] c; // children
        //     boolean w;
        //     public Node() {
        //         this.c = new Node[26];
        //         w = false;
        //     }
        // }
        // // 这个破题目：应该是要去用什么狗屁的 Tier? 。。。。。这个题，思路不够透彻，今天晚上不太想写了
        // public int longestValidSubstring(String t, List<String> ls) {
        //     int n = t.length(), max = 0, l = 0;
        //     char [] s = t.toCharArray();
        //     // // 把所有禁止的放到，什么狗屁死东西上面，方便查找O(26*10) ？
        //     // Node r = new Node();
        //     // for (String s : l) insert(r, s);
        //     Set<String> ss = new HashSet<>(ls);
        //     // 查找：搜索字典树
        //     for (int i = 0; i + max <= n && i < n; i++) {
        //         int j = i + 1;
        //         for (j = i+1; j <= Math.max(i + max, i+10) && j <= n; j++) {
        //             String cur = t.substring(i, j);
        //             // if (startsWith(r))
        //             if (!ss.contains(cur)) continue;
        //             break;
        //         }
        //         if (j <= Math.max(i + max, i+10)) { // 当前右端点不起效，取值
        //             max = Math.max(max, j - l);
        //             l = i+1;
        //             continue;
        //         } 
        //     }
        //     return max;
        // }
        // boolean startsWith(Node r, String t) {
        //     int n = t.length(); char [] s = t.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         int j = s[i] - 'a';
        //         if (r.c[j] == null) return false;
        //         r = r.c[j];
        //     }
        //     return r.w;
        // }
        // public void insert(Node r, String t) { // 插入数值
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         int j = s[i] - 'a';
        //         if (r.c[j] == null) r.c[j] = new Node();
        //         r = r.c[j];
        //     }
        //     r.w = true;
        // }

        // public boolean isGood(int[] a) {
        //     int n = a.length;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int v : a) {
        //         if (v >= n) return false;
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //         if (m.get(v) > 1 && v != n-1) return false;
        //     }
        //     return true;
        // }

        // public String sortVowels(String t) {
        //     int n = t.length(); char [] s = t.toCharArray();
        //     Map<Character, Integer> m = new HashMap<>();
        //     Map<Integer, Integer> o = new HashMap<>();
        //     int [] r = new int [10];
        //     m.put('A', 0);
        //     m.put('E', 1);
        //     m.put('I', 2);
        //     m.put('O', 3);
        //     m.put('U', 4);
        //     m.put('a', 5);
        //     m.put('e', 6);
        //     m.put('i', 7);
        //     m.put('o', 8);
        //     m.put('u', 9);
        //     o.put(0, 0);
        //     o.put(1, 4);
        //     o.put(2, 8);
        //     o.put(3, 14);
        //     o.put(4, 20);
        //     o.put(5, 0);
        //     o.put(6, 4);
        //     o.put(7, 8);
        //     o.put(8, 14);
        //     o.put(9, 20);
        //     Set<Character> sc = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        //     for (char c : s) 
        //         if (sc.contains(c))
        //             // m.put(c, m.getOrDefault(c, 0) + 1);
        //             r[m.get(c)]++;
        //     System.out.println(Arrays.toString(r));
        //     int idx = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (!sc.contains(s[i])) continue;
        //         while (r[idx] == 0) ++idx;
        //         System.out.println("\n idx: " + idx);
        //         if (idx >= 10)
        //             return new String(s);
        //         System.out.println("\n idx: " + idx);
        //         System.out.println("i: " + i);
        //         char c = s[i];
        //         s[i] = (char)((idx < 5 ? 'A' + o.get(idx): 'a' + o.get(idx)));
        //         --r[idx];
        //         System.out.println(Arrays.toString(r));
        //         System.out.println(Arrays.toString(s));
        //     }
        //     return new String(s);
        // }

        // // 【记忆化深搜】：超时了。。。【自底向上、的动规】是可能能过的，不太会写动规。。。
        // public long maxScore(int[] a, int x) {
        //     n = a.length; this.a = a; this.x = x; 
        //     f = new Long [n];
        //     return dfs(0);
        // }
        // int n, x; int [] a;
        // Long [] f;
        // long dfs(int  i) {
        //     if (i >= n) return 0;
        //     if (f[i] != null) return f[i];
        //     long r = a[i];
        //     for (int j = i+1; j < n; j++)
        //         r = Math.max(r, a[i] + dfs(j) - (a[i] % 2 == a[j] % 2 ? 0 : x));
        //     return f[i] = r;
        // }        
        // public long maxScore(int[] a, int x) {
        //     int n = a.length;
        //     long mOdd = 0, mEven = 0; // 记遍历过的最大奇偶值
        //     int idxOdd = -1, idxEven = -1;
        //     long [] f = new long [n];
        //     for (int i = 0; i < n; i++) f[i] = (long)a[i];
        //     if (a[n-1] % 2 == 0) {
        //         mEven = a[n-1];
        //         idxEven = n-1;
        //     } else {
        //         mOdd = a[n-1];
        //         idxOdd = n-1;
        //     }
        //     for (int i = n-2; i >= 0; i--) {
        //         f[i] = Math.max(f[i], a[i] + Math.max(idxEven == -1 ? 0 : (mEven - (a[i] % 2 == a[idxEven] % 2 ? 0 : x)),
        //                                               idxOdd == -1 ? 0 : (mOdd - (a[i] % 2 == a[idxOdd] % 2 ? 0 : x))));
        //         if (a[i] % 2 == 0) {
        //             mEven = f[i];
        //             idxEven = i;
        //         } else {
        //             mOdd = f[i];
        //             idxOdd = i;
        //         }
        //     }
        //     return f[0];
        // }

        // public int numberOfWays(int n, int x) {
        //     ll = new ArrayList<>();
        //     Arrays.setAll(ll, z -> new ArrayList<>());
        //     for (int i = 1; i < 301; i++) ll[1].add(i);
        //     ll[2] = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
        //     ll[3] = List.of(1, 2, 3, 4, 5, 6);
        //     ll[4] = List.of(1, 2, 3, 4);
        //     ll[5] = List.of(1, 2, 3);
        //     // 接下来：凑和为一个固定的数，就是硬币问题了，可是今天不想再写了。。
        //     f = new Integer [n+1];
        //     f[0] = 1; this.j = x; 
        //     return helper(n);
        // }
        // List<Integer> [] ll; int j;
        // static final int mod = (int)1e9 + 7;
        // Integer [] f;
        // int helper(int i) {
        //     if (i < 0) return 0; // 这里需要有一个区分：不合法解，需要能够从答案里去掉
        //     if (f[i] != null) return f[i];
        //     int n = ll[j].size(), r = 0;
        //     List<Integer> l = ll[j];
        //     for (int k = n-1; k >= 0; k--) {
        //         if (Math.pow(l.get(k), j) > i) continue;
        //         // if (l.get(k) == i) r += 1;
        //         r = (r + ) // 改天再写这个题目                
        //     }
        // }

        // public List<String> splitWordsBySeparator(List<String> a, char c) {
        //     List<String> l = new ArrayList<>();
        //     for (String t : a) {
        //         int n = t.length(), j = 0, i = 0;
        //         char [] s = t.toCharArray();
        //         while (i < n) {
        //             if (s[i] == c && i > 0 && j != i) // 把可能的答案先写出来
        //                 l.add(t.substring(j, i));
        //             while (i < n && s[i] == c) {
        //                 j = i+1;
        //                 i++;
        //             }
        //             i++;
        //         }
        //         if (i == n && j < i) l.add(t.substring(j, i));
        //     }
        //     return l;
        // }

        // // 【区间型动规】：？太恐怖了吧。。。可以先算一个【非降序小区间的和】，再求整个更大片段【非降序小区间的和】，直到找不到更大的值。。
        // public long maxArrayValue(int[] a) {
        //     int n = a.length, i = n-1;
        //     if (n == 1) return a[0];
        //     List<Long> l = new ArrayList<>();
        //     long r = 0;
        //     while (i > 0) { // 【从左到右遍历】：但是否，从左到右，能够保证正确性呢？现改成：【从右往左遍历】
        //         while (!l.isEmpty() && i >= 0 && a[i] <= l.get(l.size()-1)) {
        //             l.set(l.size()-1, l.get(l.size()-1) + (long)a[i]);
        //             --i;
        //         }
        //         if (i < 0) return l.get(l.size()-1);
        //         if (i == 0) break;
        //         if (a[i] < a[i-1]) {
        //             l.add((long)a[i]);
        //             i--;
        //             r = 0;
        //         } else {
        //             while (i > 0 && a[i] >= a[i-1]) {
        //                 r += a[i];
        //                 --i;
        //             }
        //             if (i > 0) {
        //                 if (l.size() == 0 || l.get(l.size()-1) < r + (long)a[i]) {
        //                     l.add((long)a[i] + r);
        //                     --i;
        //                     r = 0;
        //                 }
        //             }
        //         }
        //     }
        //     if (r >= a[0]) {
        //         if (!l.isEmpty() && (long)a[0] + r <= l.get(l.size()-1)) 
        //             return (long)a[0] + r + l.get(l.size()-1);
        //         l.add((long)a[0] + r);
        //     } else {
        //         if (r == 0) {
        //             if (l.isEmpty() || a[0] > l.get(l.size()-1))
        //                 l.add((long)a[0]);
        //             else 
        //                 l.set(l.size()-1, l.get(l.size()-1) + (long)a[0]); 
        //         } else {
        //             while (!l.isEmpty() && r <= l.get(l.size()-1)) {
        //                 r += l.get(l.size()-1);
        //                 l.remove(l.size()-1);
        //             }
        //             l.add(r);
        //         }
        //     }
        //     return Collections.max(l);
        // }

        // public long countPalindromePaths(List<Integer> p, String t) {
        //     n = t.length(); s = t.toCharArray();
        //     // if (t.chars().distinct().count() == 1) return (long)n * (long)(n-1) / 2l; // 极特殊：只有一个字符，所有路径 
        //     // 【无向图：】==> 【有向图】处理
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     for (int i = 1; i < n; i++) { // 有向图：题目说的是无向图，但实际上，这里当作【有向图】来处理
        //         // g[i].add(p.get(i));
        //         g[p.get(i)].add(new int [] {i, 1 << (s[i] - 'a')});
        //     }
        //     // 【深搜：】遍历每个节点，更新每个节点的 mask. 同步统计结果
        //     // f = new int [n]; // 这里当时脑袋还有一点儿昏：光 mask 是不对的，应该是异或。（手误。。亲爱的表哥的活宝妹，当时心里想的是异或，手上敲的是或。。。）
        //     // m.put(0, 1); // 它说，特殊情况是：当前节点（从根到当前节点的异或值）就为0 或是2^i 一个数位。【卫兵值？】不需要这行？
        //     dfs(0, 0);
        //     return r;
        // }
        // // 先走基本功：把图建好，设计基本数据结构存储必备信息. 
        // List<int []> [] g;
        // int n; char [] s;
        // long r = 0; // 这个用来记结果
        // // 可是感觉这个题，用 Trie （每个节点：背个马甲，记字符出现的奇偶性【不用背太重的数组，背个26 位的 mask 标记字符出现的奇偶性就可以了】）似乎更像呀。。。不是建无向图。怎么根据这个数组来建 Trie 呢？
        // // 上面想错了，不用Trie, 只要一个 mask数组来记每个节点，从根节点字符出现的奇偶性就对了
        // // int [] f; // 这个数组不好：这是记每个节点的 mask
        // Map<Integer, Integer> m = new HashMap<>(); // 用字典记更方便：记的是每个节点异或 mask 的出现频率，所以必须用字典
        // void dfs(int u, int mask) { // 【深搜：】更新每个节点的异或 mask: 同步数结果
        //     // f[u] = mask;
        //     // 先统计：【当前节点】已经存在的两种情况下的结果
        //     r +=  m.getOrDefault(mask, 0); // 把，两个节点异或为 0 的个数，统计入结果。其实也包含了当前节点异或值为 0 的情况
        //     for (int i = 0; i < 26; i++)   // 把，两个节点异或为 2^i 的个数，统计入结果 
        //         r += m.getOrDefault(mask ^ (1 << i), 0);
        //     // 【BUG：】忘记更新，异或值出现过的词频了  // <<<<<<<<<<<<<<<<<<<< 
        //     m.put(mask, m.getOrDefault(mask, 0) + 1); // <<<<<<<<<<<<<<<<<<<< 
        //     // 再【深搜】：遍历子节点
        //     for (int [] v : g[u]) 
        //         dfs(v[0], mask ^ v[1]); // 手误。。亲爱的表哥的活宝妹，当时心里想的是异或，手上敲的是或。。。
        // }
        
        // // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxIncreasingGroups(List<Integer> usageLimits) {
        //     return 0;
        // }

        // public int numberOfEmployeesWhoMetTarget(int[] a, int target) {
        //     int n = a.length, r = 0;
        //     for (int v : a) 
        //         if (v >= target) r++;
        //     return r;
        // }

        // // 不知道哪里写错了：先把右端点移到尽可能右，再右移左端点
        // public int countCompleteSubarrays(int[] a) {
        //     Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     int n = a.length, cnt = s.size(), ans = 0, l = 0, r = 0;
        //     System.out.println("cnt: " + cnt);
        //     if (cnt == 1) return n * (n + 1) / 2;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     boolean mod = false;
        //     for (; r < n; r++) { // 滑动窗口
        //         System.out.println("\n r: " + r);
        //         int v = a[r];
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //         while (r < n && m.size() == cnt) {
        //         // if (r < n && m.size() == cnt) {
        //             ans++;
        //             // continue;
        //             r++;
        //             if (r < n) {
        //                 v = a[r];
        //                 m.put(v, m.getOrDefault(v, 0) + 1);
        //             }
        //         }
        //         System.out.println("ans: " + ans);
        //         if (m.size() > cnt) mod = true;
        //         while (m.size() > cnt) {
        //             v = a[l];
        //             m.put(v, m.getOrDefault(v, 1)-1);
        //             if (m.get(v) == 0) m.remove(v);
        //             l++;
        //         }
        //         if (mod && m.size() == cnt) {
        //             ans++;
        //             l++;
        //         }
        //     }
        //     if (m.size() > cnt) mod = true;
        //     while (l < r && m.size() > cnt) {
        //         int v = a[l];
        //         m.put(v, m.getOrDefault(v, 1)-1);
        //         if (m.get(v) == 0) m.remove(v);
        //         l++;
        //     }
        //     if (mod) ans++;
        //     int v = a[l];
        //     m.put(v, m.getOrDefault(v, 1)-1);
        //     if (m.get(v) == 0) m.remove(v);
        //     while (m.size() == cnt && l < r) {
        //         System.out.println("\n l: " + l);
        //         System.out.println("ans: " + ans);
        //         ans++;
        //         v = a[l];
        //         m.put(v, m.getOrDefault(v, 1)-1);
        //         if (m.get(v) == 0) m.remove(v);
        //         l++;
        //         // ans++;
        //         // continue;
        //     }
        //     return ans;
        // }

        // 【记忆化深搜】：找到这个题目的正确状态  数位DP, 一个位一个位的数，数最多100 位
        public int countSteppingNumbers(String low, String high) {
            s = low.toCharArray(); t = high.toCharArray();
            m = low.length(); n = high.length();
            f = new Integer [n][11];
            return dfs(0, 10, false, false);
        }
        static final int mod = (int)1e9 + 7;
        char [] s, t;
        int m, n;
        Integer [][] f; // 【哪里数错了。。】
        int dfs(int i, int j, boolean lo, boolean hi) { // i 是遍历的数位，j: 当前数位值, 。从高位往低位遍历，可是要比较数的长度, 感觉状态欠缺，需要 boolean
            System.out.println("\n i: " + i);
            System.out.println("j: " + j);
            System.out.println("lo: " + lo);
            System.out.println("hi: " + hi);
            if (i > n || j < 0 || i > 0 && j >= 10) return 0;
            // 从这里处理不合法的，有点儿低效，没关系: 【比小的小，比大的大】不可以
            if (i > 0 && (lo && i < m && s[i]-'0' > j+1 || hi && i < n && t[i]-'0' < j-1)) return 0;
            // if (i == m || i == n) return 1;
            if (i == n) return 1;
            if (f[i][j] != null) return f[i][j];
            long r = 0;
            if (i == 0) { // 起始位特殊：可以任意打头，其它受限
                if (m == n) {
                    for (int k = s[i]-'0'; k <= t[i]-'0'; k++) 
                        r = (r + dfs(i+1, k, k == s[i]-'0', k == t[i]-'0')) % mod;
                } else { // m < n
                    for (int k = 1; k <= t[i] - '0'; k++) 
                        r = (r + dfs(i+1, k, k == s[i]-'0', k == t[i]-'0')) % mod;
                }
            } else { // 受前一位了限制：＋－1 只能
                r = (r + dfs(i+1, j+1, lo && j+1 == s[i] - '0', hi && j+1 == t[i]-'0')) % mod;
                r = (r + dfs(i+1, j-1, lo && j-1 == s[i]-'0', hi && j-1 == t[i]-'0')) % mod;
            }
            System.out.println("\n i: " + i);
            System.out.println("j: " + j);
            System.out.println("lo: " + lo);
            System.out.println("hi: " + hi);
            System.out.println("r: " + r);
            return f[i][j] = (int)r;
        }
    }             
    public static void main (String[] args) { 
        Solution s = new Solution ();

        String a = "90";
        String b = "101";

        int r = s.countSteppingNumbers(a, b);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要嫁给亲爱的表哥！！活宝妹若是还没能嫁给亲爱的表哥，活宝妹就是永远守候在亲爱的表哥的身边！！爱表哥，爱生活！！！】
