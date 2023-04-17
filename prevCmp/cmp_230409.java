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
        // public boolean haveConflict(String[] s, String[] t) {
        //     int a = getVal(s[0]), b = getVal(s[1]);
        //     int c = getVal(t[0]), d = getVal(t[1]);
        //     if (a <= c) {
        //         if (b < c) return false;
        //         return true;
        //     } else return haveConflict(t, s);
        // }
        // int getVal(String t) {
        //     char [] s = t.toCharArray();
        //     return Integer.parseInt(t.substring(0, 2)) * 60 + Integer.parseInt(t.substring(3));
        // }
        // class Item implements Comparable<Item> {
        //     int v, f;
        //     public Item(int v, int f) {
        //         this.v = v;
        //         this.f = f;
        //     }
        //     @Override public int compareTo(Item other) { // 想要按值降序排列
        //         return this.v != other.v ? other.v - this.v : other.f - this.f;
        //     }
        //     public void print() {
        //         System.out.println("[v: " + v + ", f: " + f + "]"); 
        //     }
        // }
//         public long makeSimilar(int[] a, int[] b) {
//             int n = a.length, N = 1000001;
//             int [] cnt = new int [N];
//             for (var v : b) cnt[v]++;
//             TreeMap<Integer, Integer> ma = new TreeMap<>(Collections.reverseOrder());
//             TreeMap<Integer, Integer> mb = new TreeMap<>(Collections.reverseOrder());
//             for (int i = 1; i < N; i++) 
//                 if (cnt[i] > 0)
//                     // sb.add(new Item(i, cnt[i]));
//                     mb.put(i, cnt[i]);
//             Arrays.fill(cnt, 0);
//             for (var v : a) cnt[v]++;
//             for (int i = 1; i < N; i++) 
//                 if (cnt[i] > 0)
//                     // sa.add(new Item(i, cnt[i]));
//                     ma.put(i, cnt[i]);
//             System.out.println("ma.size(): " + ma.size());
//             for (Map.Entry<Integer, Integer> en : ma.entrySet()) 
//                 System.out.print(en.getKey() + ", " + en.getValue() + "\n");
//             System.out.println("mb.size(): " + mb.size());
//             for (Map.Entry<Integer, Integer> en : mb.entrySet()) 
//                 System.out.print(en.getKey() + ", " + en.getValue() + "\n");

//             Set<Integer> ka = ma.keySet();
//             Set<Integer> kb = mb.keySet();
//             ka.retainAll(kb);
//             for (var v : ka) {
//                 int va = ma.get(v), vb = mb.get(v);
//                 if (va == vb) {
//                     ma.remove(v);
//                     mb.remove(v);
//                 } else if (va < vb)
//                     mb.put(v, vb - va);
//                 else 
//                     ma.put(v, va - vb);
//             }
//             long f = 0;
//             for (Map.Entry<Integer, Integer> en : ma.entrySet()) {
//                 int k = en.getKey(), v = en.getValue();
// // returns the least key greater than or equal to the given key or null if the such a key is absent.
//                 Integer hi = mb.ceilingKey(k);
//                 if (hi == null) {
//                     Integer lo = mb.floorKey(k);
//                 }
//             }
//             return 0;
//         }
        // public long makeSimilar(int[] a, int[] b) {
        //     int n = a.length, N = 1000001, min = 0;
        //     int [] ca = new int [N];
        //     int [] cb = new int [N];
        //     for (var v : a) ca[v]++;
        //     for (var v : b) cb[v]++;
        //     long f = 0;
        //     for (int i = N-1; i >= 0; i--) {
        //         if (ca[i] == cb[i]) continue;
        //         min = Math.min(ca[i], cb[i])
        //     }
        //     return 0;
        // }

// // 想得太简单了:要对每个元素分解质因子,统计每个质因子的个数
// // 因为每个数值可能会狠大,要用[1, 30]?内的质因素怎么样的.......
// // 这个题感觉有点儿像1735,但是今天头比较昏,数值也很大[1, 1000000000],想不清楚这个题要怎么分解每个数
//         public int subarrayGCD(int[] a, int k) {
//             Set<Integer> st = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
//             if (!st.contains(k)) return 0;
//             int n = a.length, f = 0, j = 0, l = 0, r = 0;
//             boolean [] vis = new boolean[n];
//             for (int i = 0; i < n; i++) 
//                 if (a[i] % k == 0) vis[i] = true;
//             for (int i = 0; i < n; i++) {
//                 if (a[i] != k) continue;
//                 System.out.println("\n i: " + i);
//                 j = i-1;
//                 while (j >= 0 && vis[j]) j--;
//                 l = (i == 0 ? 1 : i - j);
//                 j = i + 1;
//                 while (j < n && vis[j]) j++;
//                 r = j - i;
//                 System.out.println("l: " + l); 
//                 System.out.println("r: " + r); 
//                 f += l * r;
//                 System.out.println("f: " + f); 
//             }
//             return f;
//         }

         
// // 用TreeMap<Integer, TreeSet<Integer>> 会比下面的效率高吗?        
//         // Map<Integer, Queue<Integer>> idx; // [num, Queue[idx1 idx1 ....]] 为什么我会用这种相对奇怪的数据结构呢?
//         Map<Integer, Integer> m;          // [idx, num]
//         Map<Integer, TreeSet<Integer>> idx;
//         public NumberContainers() {
//         // public cmp() {
//             m = new HashMap<>();
//             idx = new HashMap<>();
//         }
//         public void change(int index, int number) {
//             // 这里,因为没有从idx中移除,所以下次取的时候就需要遍历一下            
//             m.put(index, number);
//             idx.computeIfAbsent(number, z -> new TreeSet<>()).add(index);
//             // // 先处理更改前的位标数据更新
//             // if (m.containsKey(index)) {
//             //     // idx.get(m.get(index)).remove((Integer)number);
//             //     idx.get(m.get(index)).remove((Integer)index);
//             //     if (idx.get(m.get(index)).isEmpty()) // 如果数据清空了就清空这个键
//             //         idx.remove(m.get(index));
//             // }
//             // m.put(index, number);
//             // idx.computeIfAbsent(number, z -> new PriorityQueue<>());
//             // idx.get(number).add(index);
//         }
//         public int find(int number) {
//             // return idx.containsKey(number) ? idx.get(number).peek() : -1;
//             if (!idx.containsKey(number)) return -1;
//             for (var v : idx.get(number))  // idx 从小到大遍历,当某个是合法值
//                 if (m.get(v) == number)
//                     return v;
//             return -1;
//         }
 
        // public long countExcellentPairs(int[] a, int k) { // >= k 不是 == k
        //     int n = a.length;
        //     Integer [] f = new Integer [n];
        //     // TreeMap<Integer, Integer> m = new TreeMap<>();
        //     TreeSet<Integer> m = new TreeSet<>();
        //     for (int i = 0; i < n; i++) {
        //         f[i] = Integer.bitCount(a[i]);
        //         // m.put(f[i], m.getOrDefault(f[i], 0) + 1);
        //         m.add(f[i]);
        //     }
        //     Arrays.sort(f);
        //     int [] s = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         s[i] = s[i-1] + f[i-1];
        //     System.out.println(Arrays.toString(f));
        //     System.out.println(Arrays.toString(s));
        //     Set<Integer> vis = new HashSet<>();
        //     long ans = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (vis.contains(f[i])) continue;
        //         Integer hi = m.ceiling(k - f[i]); // ceilingKey() floorKey()
        //         if (hi != null && hi != f[i]) ans += Math.min(m.get(f[i]), m.get(hi)) * 2;
        //         else if (hi != null) ans += 1;
        //         vis.add(f[i]);
        //     }
        //     return ans;
        // }

        // public int AlternateDigitSum(int n) {
        //     if (n < 10) return n;
        //     int cnt = 0;
        //     int v = n;
        //     int [] p = new int [10];
        //     p[0] = 1;
        //     while (v >= 10) {
        //         cnt++;
        //         v /= 10;
        //         p[cnt] = 10 * p[cnt-1];
        //     } 
        //     int r = 0, s = 1;
        //     while (cnt > 0) {
        //         r += s * n / (p[cnt]) % 10;
        //         s *= -1;
        //         cnt--;
        //     }
        //     r += s * n % 10;
        //     return r;
        // }

        // public int[][] sortTheStudents(int[][] a, int k) { 
        //     int m = a.length, n = a[0].length;
        //     List<int []> l = new ArrayList<>();
        //     for (int [] v : a) 
        //         l.add(v);
        //     Collections.sort(l, new Comparator<int []>() {
        //             @Override
        //             public int compare(int [] o1, int [] o2) {
        //                 return o2[k] - o1[k];
        //             }
        //         });
        //     int idx = 0;
        //     for (int [] v : l) 
        //         a[idx++] = v;
        //     return a;
        // }

//  感觉这个题目没有想透，有很多犄角旮旯没想透彻        
        public boolean makeStringsEqual(String ss, String tt) {
            int n = ss.length(), i = 0, j = n-1, k = 0, x = 0;
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            while (i <= j && s[i] == t[i]) i++;
            if (i == n) return true;
            // while (j > i && s[j] == t[j]) j--;
            // if (j < 0 || i == j && s[i] == t[j]) return true;
            while (i < n) {
                while (i < j && s[i] == t[i]) i++;
                if (i == n) return true;
                
                System.out.println("\n i: " + i);
                k = n-1;
                while (k > i && s[k] == '0') k--; // 找个1
                // System.out.println(Arrays.toString(s));
                x = 0;
                while (x < i && s[x] == '0') x++;
                System.out.println("k: " + k);
                System.out.println("x: " + x);

                // if (k == i) return false;
                // if (k == i && x == i) {
                //     return false;
                // }
                if (k == n-1 && x == 0) return false;
                if (s[i] == '1') { // 从尾巴找个1
                    s[i] = '0';
                    // s[k] = 1;
                    if (k == i && x == i) {
                        if (i < n-1) s[i+1] = 1;
                        else s[x-1] = 1;
                    }
                } else { // [0, 1]
                    s[i] = '1';
                }
                i++;
                // System.out.println(Arrays.toString(s));
                System.out.println("i: " + i);
            }
            if (i == j) return s[i] == t[j];
            if (i == n) return true;
            return false;
        }

// // 区间型动态规划
//        Long [][] dp;
//        long minCost(int [] a, int x, int y, int k) {
//             if (dp[x][y] != null) return dp[x][y];
//             if (x == y) return dp[x][y] = (long)k; // 长度为1个元素
//             // 不划分，作为一个整体
//             Map<Integer, Integer> m = new HashMap<>();
//             for (int i = x; i <= y; i++) 
//                 m.put(a[i], m.getOrDefault(a[i], 0) + 1);
//             long base = k, min = Long.MAX_VALUE;
//             for (Integer val : m.values()) 
//                 if (val > 1) base += val; // 不划分，作为一个整体
//             min = base;
//             // 从不同的地方划分，取最优解
//             for (int i = x; i < y; i++) { // 在它后面划分
//                long cur = minCost(a, x, i, k) + minCost(a, i+1, y, k);
//                 min = Math.min(min, cur);
//             }
//             return dp[x][y] = min;
//         } 
//         public int minCost(int[] a, int k) { // TLE: 什么地方没有优化好？
//             int n = a.length; // [1, 1000]
//             dp = new Long [n][n];
//             return (int)minCost(a, 0, n-1, k);
//         }

        // public long pickGifts(int[] a, int k) {
        //     int n = a.length;
        //     Deque<Integer> q = new ArrayDeque<>((x, y) -> y - x);
        //     for (int v : a) 
        //         q.offerFirst(v);
        //     while (k > 0 && !q.isEmpty()) {
        //         int v = Math.sqrt(q.pollLast());
        //         q.offerFirst(v);
        //     }
        //     long r = 0;
        //     while (!q.isEmpty()) r += q.pollLast();
        //     return r;
        // }

        // public int[][] mergeArrays(int[][] a, int[][] b) {
        //     int m = a.length, n = b.length;
        //     Set<Integer> s = new HashSet<>();
        //     for (int i = 0; i < m; i++) 
        //         s.add(a[i][0]);
        //     for (int i = 0; i < n; i++) 
        //         s.add(b[i][0]);
        //     int [][] r = new int [s.size()][2];
        //     int i = 0, j = 0, k = 0, p = 0;
        //     while (i < m || j < n) {
        //         if (i < m && j < n) {
        //             int min = Math.min(a[i][0], b[j][0]);
        //             if (p != 0 && min > p) k++;
        //             if (min > p)
        //                 r[k][0] = a[i][0];
        //             if (a[i][0] == b[j][0]) {
        //                 r[k][1] = a[i][1] + b[j][1];
        //                 i++;
        //                 j++;
        //             } else {
        //                 if (min == a[i][0]) {
        //                     r[k][1] = a[i][1];
        //                     i++;
        //                 } else {
        //                     r[k][0] = b[j][0];
        //                     r[k][1] = b[j][1];
        //                     j++;
        //                 }                   
        //             }
        //             p = min;
        //         } else {
        //             while (i < m) {
        //                 if (a[i][0] > p) {
        //                     k++;
        //                     r[k][0] = p = a[i][0];
        //                 } 
        //                 r[k][1] += a[i++][1];
        //             }
        //             while (j < n) {
        //                 if (b[j][0] > p) {
        //                     k++;
        //                     r[k][0] = p = b[j][0];
        //                 } 
        //                 r[k][1] += b[j++][1];
        //             } 
        //         }
        //     }
        //     return r;
        // }

        // // 我会被它一行代码的解决方法气死的。。。。。看不懂
        // public int minOperations(int n) {
        //     return Integer.bitCount(n ^ (3 * n));
        // }
        // public int minOperations(int n) {
        //         int l = log2(n);
        //         int num =(int)Math.pow(2, l);
        //         if (num == n) return 1;
        //         int op = 0;
        //         while (n != 0) {
        //             l = log2(n);
        //             int left = (int) Math.pow(2, l); 
        //             int right = (int) Math.pow(2, l+1); 
        //             if ((n-left) < (right-n)) n = n - left;  // 转换为左边，或是右边数的操作 
        //             else n = right - n;
        //             op++;
        //         }
        //         return op;
        //     }
        // public static int log2(int N) { // 把以 10 为底的数，求2 的指数次数
        //         int result = (int)(Math.log(N) / Math.log(2));
        //         return result;
        //     }

// 这里，自己像是画了只五脏俱全的麻雀，可是还是差了那么一点儿：没写完的
        // 这个题目就成为分解质因子，因为数比较小 [1, 30], 所以只需要考虑2 3 5 三个质因子就可以了，然后就是选元素：2 3 5 三个质因子都不能含有，多于一个
        // int [] getCnts(int v) { // 得到当前数所含的： 2 3 5 质因子的个数
        //     int [] r = new int [3];
        //     int cnt = 0, a = v;
        //     while (a >= 2) {
        //         a /= 2;
        //         cnt++;
        //     }
        //     r[0] = cnt;
        //     a = v;
        //     cnt = 0;
        //     while (a >= 3) {
        //         a /= 3;
        //         cnt++;
        //     }
        //     r[1] = cnt;
        //     cnt = 0;
        //     while (v >= 5) {
        //         v /= 5;
        //         cnt++;
        //     }
        //     r[2] = cnt; 
        //     return r;
        // }
        // public int squareFreeSubsets(int[] a) {
        //     int n = a.length, cnt = 0;
        //     int [][] r = new int [31][3]; // [3]: 2 3 5
        //     for (int i = 1; i < 31; i++) 
        //         r[i] = getCnts(i);
        //     List<Integer> l = new ArrayList<>(); // 加链表里因为它是可能会存在重复的，后可以把它转换成数组成操作
        //     for (int v : a) 
        //         if (r[v][0] < 2 && r[v][1] < 2 && r[v][2] < 2) {
        //             cnt++;
        //             l.add(v);
        //         }
        //     int [] cur = l.toArray(new int [0]); // 不知道这么用对不对
        //     // 然后接下来应该就是动态规划：链表里的数，每个都有可选和不可选两种可能，然后动态规划这部分，不太会做了
        //     // 2 3 5
        //     // 0 0 0
        //     // 1
        //     //   1
        //     //     1
        //     // 1 1
        //     //   1 1
        //     // 1   1
        //     // 1 1 1
        //     // 它只存在以上8 种可能性，笨办法就是每种可能性计算一遍，把结果相加. 先假定可以为空数组，最后减掉空数组这种可能性
        //     // 这里动态规划的部分，还是不会，动态规划的基础不够，也快被自己忘光了
        //     static final int mod = (int)1e9 + 7;
        //     long ans = 1, rnd = 1;
        //     // 0 0 0
        //     for (int i = 0; i < l.size(); i++) {
        //         int c = cur[i];
        //         if (r[c][0] == 0 && r[c][1] == 0 && r[c][2] == 0) {
        //             ans *= 2;
        //             ans %= mod;
        //         }
        //     }
        //     // 1 1 1 
        // }
// // 下面是正确的解法：记忆可真好呀
//         public int squareFreeSubsets(int[] a) {
//             Arrays.stream(dp).forEach(x -> Arrays.fill(x, -1));  // 流式处理法
//             p = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29));
//             return (int)dfs(0, 1, a) - 1; // 减去的，应该是空数组
//         }
//         long [][] dp = new long [1001][1 << 11];
//         static final long mod = (long)1e9 + 7;
//         List<Integer> p = new ArrayList<>(); // primes
//         long dfs(int idx, int prodmask, int [] a) {
//             if (idx >= a.length) return 1;
//             if (dp[idx][prodmask] != -1) return dp[idx][prodmask];  // 计算过，保存过，直接返回结果
//             int mask = getMask(a[idx]);  // 拿到当前数，质因子的分布情况
//             long ans = dfs(idx+1, prodmask, a); // 不包含当前数，可能有的角法
//             if ((mask & prodmask) == 0) // 不含有公共质因子：当前数也可以包含进去
//                 ans += dfs(idx+1, mask | prodmask, a);
//             return dp[idx][prodmask] = ans % mod;
//         } 
//         int getMask(int v) {
//             int r = 0;
//             for (int i = 0; i < 10; i++) {
//                 int cnt = 0;
//                 while (v % p.get(i) == 0) {
//                     cnt++;
//                     v /= p.get(i);
//                 }
//                 if (cnt > 1) return -1;  // 这是一步优化过滤筛选，直接过滤掉不合格的
//                 if (cnt == 1) // 存在，且仅有一个当前质因子的情况下
//                     r |= (1 << (i + 1));
//             }
//             return r;
//         }

        // public String findTheString(int[][] a) {
        //     int n = a.length;
        //     char [] s = new char [n];
        //     s[0] = 'a';
        //     boolean found = false;
        //     // char prev = 'a';// 不知道这里可不可以优化，改天可以再试一下
        //     for (int i = 1; i < n; i++) {
        //         char cur = 'a'; // 总是从最小的开始取值
        //         found = false;
        //         for (int j = 0; j < i; j++) { // 我想要到上面的，但是没有想这个往前遍历的方法，和下面再计算一遍，比较的方法 
        //             cur = (char)Math.max(s[j], cur); // 纪录用到的最大值，好像这个比较麻烦了一点儿
        //             if (a[i][j] > 0) {
        //                 found = true;
        //                 s[i] = s[j];
        //                 break;
        //             }                    
        //         }
        //         if (found) continue;
        //         if (cur == 'z') return "";
        //         ++cur;
        //         s[i] = (char)cur;
        //     }
        //     int [][] cnt = new int [n+1][n+1];
        //     for (int i = n-1; i >= 0; i--) {
        //         for (int j = n-1; j >= 0; j--) {
        //             if (s[i] == s[j]) cnt[i][j] = cnt[i+1][j+1] + 1;
        //             else cnt[i][j] = 0;
        //             if (cnt[i][j] != a[i][j]) return "";
        //         }
        //     }
        //     return String.valueOf(s);
        // }

        // public int[] leftRigthDifference(int[] a) {
        //     int n = a.length;
        //     int [] l = new int [n+1], r = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         l[i] = l[i-1] + a[i-1];
        //     for (int i = n-1; i >= 0; i--) 
        //         r[i] = r[i+1] + a[i]; // r[i+1]
        //     int [] ans = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         ans[i] = Math.abs(l[i] - r[i+1]);
        //     return ans;
        // }

// // 把题目转化一下，这个方法很容易懂        
//         public int minimumTime(int[][] a) {
//             if (a[0][1] > 1 && a[1][0] > 1) return -1; // 永远无法到达
//             m = a.length;
//             n = a[0].length;
//             dp = new int [m][n];
//             for (int i = 0; i < m; i++) 
//                 Arrays.fill(dp[i], Integer.MAX_VALUE);
//             return bfs(0, 0, 0, a);
//         }
//         int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//         int [][] dp; // 定义 dp[i][j] 为到达（i, j）的最小时间，那么dp[0][0] = 0, 答案为dp[m-1][n-1]
//         int m, n;
//         int bfs(int xx, int yy, int dd, int [][] a) {
//             Queue<int []> q = new PriorityQueue<>((x, y) -> x[2] - y[2]); // 优先队列
//             q.offer(new int [] {xx, yy, dd});
//             while (!q.isEmpty()) {
//                 int [] cur = q.poll();
//                 int x = cur[0], y = cur[1], t = cur[2];
//                 if (x == m-1 && y == n-1) return t; // 最短路径：永远是第一次走到的就是最短的
//                 for (int [] d : dirs) { // 枚举周围四个格子
//                     int i = x + d[0], j = y + d[1];
//                     if (i < 0 || i >= m || j < 0 || j >= n) continue;
//                     int nd = Math.max(t+1, a[i][j]);
//                     nd += (nd - i - j) % 2; // nd 必须和 x+y 同奇偶, 就是说 nd ％ 2 ＝＝ (x+y) ％ 2
//                     if (nd < dp[i][j]) {
//                         dp[i][j] = nd; // 更新最短路
//                         q.offer(new int [] {i, j, nd});
//                     }
//                 }
//             }
//             return -1;
//         }
// // 换另一种方法写一下：
//         public int minimumTime(int[][] a) {
//             if (a[0][1] > 1 && a[1][0] > 1) return -1; // 永远无法到达
//             m = a.length;
//             n = a[0].length;
//             vis = new int [m][n];
//             int left = Math.max(a[m-1][n-1], m+n-2)-1;
//             int right = (int)1e5 + m + n;
//             while (left + 1 < right) {
//                 int mid = (left + right) >>> 1;
//                 if (check(mid, a)) right = mid;
//                 else left = mid;
//             }
//             return right + (right + m + n) % 2;
//         }
//         int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//         int [][] vis;
//         int m, n;
//         boolean check(int t, int [][] a) { // 给一个固定的时间，判断，能否在这个时间之内，从尾巴走到头？
//             vis[m-1][n-1] = t; // 这里是，想要从尾巴上走
//             var q = new ArrayList<int []>();
//             q.add(new int [] {m-1, n-1});
//             for (int ii = t-1; !q.isEmpty(); ii--) { // 遍历时间点【对应时间点所在的格子】，队列里要有元素
//                 var tmp = q;
//                 q = new ArrayList<>();
//                 for (var p : tmp) {
//                     int x = p[0], y = p[1];
//                     for (int [] d : dirs) {
//                         int i = x + d[0], j = y + d[1];
//                         if (i >= 0 && i < m && j >= 0 && j < n && vis[i][j] != t && a[i][j] <= ii) { // 如果当前的格、方向是可以走的
//                             if (i == 0 && j == 0) return true;
//                             vis[i][j] = t; // 用二分的值来标记，避免重复创建 vis 数组
//                             q.add(new int [] {i, j});
//                         }
//                     }
//                 }
//             }
//             return false;
//         }

        // public int[] divisibilityArray(String s, int m) {
        //     int n = s.length(); // 这里的问题是，这个数字可以很大 [1, 100000], 感觉很容易就溢出了，不喜欢这个题目
        //     int [] r = new int [n], ans = new int [n];  // 这里标记余数
        //     // if (s.charAt(0) == '0') return r; // 它说是，不要这个限制条件的。因为把0 也看成是整除
        //     r[0] = Integer.valueOf(s.substring(0, 1)) % m;
        //     if (r[0] == 0) ans[0] = 1;
        //     for (int i = 1; i < n; i++) {  // 往后遍历：把每个答案算出来
        //         r[i] = (int)(((long)r[i-1] * 10l + (long)Integer.valueOf(s.substring(i, i+1))) % m);
        //         if (r[i] == 0) ans[i] = 1;
        //     }
        //     return ans;
        // }

        // public int passThePillow(int n, int t) {
        //     int idx = 1, d = 1;
        //     while (t > 0) {
        //         if (d > 0) {
        //             for (int i = 1; i < n && t > 0; i++) {
        //                 idx++;
        //                 t--;
        //             }
        //             d *= -1;
        //         } else {
        //             for (int i = n; i > 1 && t > 0; i--) {
        //                 idx--;
        //                 t--;
        //             }
        //             d *= -1;
        //         }
        //     }
        //     return idx;
        // }

        // public long kthLargestLevelSum(TreeNode root, int k) {
        //     levelTraverTree(root);
        //     long r = -1l;
        //     while (k > 0 && !pq.isEmpty()) {
        //         r = pq.poll();
        //         k--;
        //     }
        //     return k == 0 ? r : -1l;
        // }
        // Queue<Long> pq = new PriorityQueue<Long>((x, y) -> Long.compare(y, x)); // 降序排列
        // void levelTraverTree(TreeNode root) {
        //     Deque<TreeNode> q = new ArrayDeque<>();
        //     q.addFirst(root);
        //     long sum = 0;
        //     while (!q.isEmpty()) {
        //         int cnt = q.size();
        //         for (; cnt > 0; cnt--) {
        //             TreeNode r = q.pollLast();
        //             sum += r.val;
        //             if (r.left != null) q.addFirst(r.left);
        //             if (r.right != null) q.addFirst(r.right);
        //         }
        //         pq.add(sum);
        //         sum = 0l;
        //     }
        // }
        
// // n [1, 10000];
//         // a[i]: [1, 1e6]
//         // 应该是不能去数所有的质数了，因为数大；去数所有包括最开始数的因子
//         public int findValidSplit(int[] a) {
//             int n = a.length;

//         }
//         int gcd(int x, int y) { // 这个方法要理解透彻，现在就成抄的这个方法了
//             if (x < y) return gcd(y, x);
//             return gcd(y, x % y);
//         }

        // public int vowelStrings(String[] a, int l, int r) {
        //     int n = a.length, ans = 0;
        //     for (int i = l; i <= r; i++) 
        //         if (isVowelString(a[i])) ans++;
        //     return ans;
        // }
        // boolean isVowelString(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     List<Character> l = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));
        //     Set<Character> sc = new HashSet<>(l);
        //     return sc.contains(s[0]) && sc.contains(s[n-1]);
        // }

        // public int maxScore(int[] a) {
        //     int n = a.length;
        //     Arrays.sort(a); 
        //     long [] r = new long [n+1];
        //     for (int i = n-1; i >= 0; i--) {
        //         r[i] = r[i+1] + a[i];
        //         if (r[i] <= 0) return (n-1)-i;
        //     }
        //     return n;
        // }

        //         // 不知道哪里写错了，数多了：这些都是自己最最原始的想法，狠天真，呵呵
//         public int waysToReachTarget(int t, int[][] a) {
//             Arrays.sort(a, (x, y)-> y[1] - x[1]); // 降序排列

//             System.out.println("a.length: " + a.length);
//             for (int z = 0; z < a.length; ++z) 
//                 System.out.println(Arrays.toString(a[z]));
            
//             n = a.length;
//             dp = new Integer [1001][n]; // [t][cnt][val]
//             return dfs(t, 0, a);
//         }
//         static final int mod = (int)1e9 + 7;
//         Integer [][] dp;
//         int n;
// // 爱亲爱的表哥，活宝妹一定要嫁的亲爱的表哥！！！活宝妹就是一定要嫁给亲爱的表哥，爱表哥，爱生活！！！
//         int dfs(int t, int ii, int [][] a) { 
//             if (t < 1 || ii >= n) return 0;
//             if (dp[t][ii] != null) return dp[t][ii];
//             int idx = ii;
//             while (a[idx][1] > t) ++idx; // 至少要先找到那个 <= 的行
//             int ans = 0; // 对当前行的处理：
//             if (a[idx][1] == t) {
//                 ans += 1;
//                 for (int i = idx+1; i < n; i++) 
//                     ans = (ans + dfs(t, idx+1, a)) % mod;
//                 return dp[t][ii] = ans;
//                 // return dp[t][idx] = 1 + dfs(t, idx+1, a); // 这里不对
//             }
//             // 不相等的情况下，数个数
//             int cnt = a[idx][0], del = 0;
//             // if (cnt * a[idx][1] < t) return dp[t][idx] = 0; // 这里不对
//             while (cnt * a[idx][1] > t) cnt--;
//             if (cnt * a[idx][1] == t) ans += 1;
//             System.out.println("ans: " + ans);
//             // System.out.println("cnt: " + cnt);
//             for (; cnt > 0; cnt--) {
//                 del += a[idx][1];
//                 System.out.println("cnt: " + cnt);
//                 System.out.println("del: " + del);
//                 ans = (ans + dfs(t-del, idx+1, a)) % mod;
//             }
//             for (int i = idx+1; i < n; i++) 
//                 ans = (ans + dfs(t, idx+1, a)) % mod;
//             return dp[t][ii] = ans;
//         }
        // // 应该是用动态规划来写的: 很久没写了，全忘记了。记得动态规划总是可以改写为 dfs 记忆化搜索，想找一个那种解法来加深理解
        // static final int mod = (int)1e9 + 7;
        // public int waysToReachTarget(int t, int[][] a) {
        //     int n = a.length;
        //     int [][] dp = new int [n+1][t+1]; // dp[i][j] := # of ways to earn j points with first i types.
        //     dp[0][0] = 1;
        //     for (int i = 1; i <= n; i++) {
        //         final int cnt = a[i-1][0], mark = a[i-1][1];
        //         for (int j = 0; j <= t; j++) {
        //             for (int solved = 0; solved <= cnt; solved++) {
        //                 if (j - solved * mark >= 0) {
        //                     dp[i][j] += dp[i-1][j - solved * mark];
        //                     dp[i][j] %= mod;
        //                 }
        //             }
        //         }
        //     }
        //     return dp[n][t];
        // }

        // // 不喜欢数数，但是仍被它逼去数，狠烦人。滑动窗口，里面异或操作
        // // 不喜欢这个题目： 0 片段需要特殊处理，还要桥接前后处理，感觉想不透
        // // 感觉是需要以数组中的0 片段为中心，向两边扩展的；0 片段的某侧有异或0 片段的情况也狠复杂，不想写了
        // // 感觉这个题目，给自己的教训是：行百里者，半于九十～～！！！其实就差再多那么一点点儿的努力，就能解决了
        // public long beautifulSubarrays(int[] a) { // [0, 0, 0]
        //     int n = a.length;
        //     long ans = 0;
        //     int [] r = new int [n];
        //     r[0] = a[0];
        //     // Set<Integer> s = new HashSet<>();// 可能会有得复，所以不能够使用简单的，要用字典, 要数个数的
        //     // s.add(r[0]);
        //     Map<Integer, Integer> m = new HashMap<>();
        //     m.put(r[0], 1);
        //     if (r[0] == 0) ans++;
        //     for (int i = 1; i < n; i++) { // 这里，是的，可以把它只遍历一遍
        //         r[i] = r[i-1] ^ a[i];
        //         ans += (!m.containsKey(r[i]) ? 0 : (long)m.get(r[i]));
        //         if (r[i] == 0) ans++;// ＝＝ 0 的情况特殊处理了
        //         m.put(r[i], m.getOrDefault(r[i], 0) + 1);
        //     }
        //     return ans;
        // }

        // class Range { 
        //     int l, r, t;
        //     public Range(int l, int r, int t) {
        //         this.l = l;
        //         this.r = r;
        //         this.t = t;
        //     }
        //     public String toString() {
        //         return "Range(" + left + "," + right + ")";
        //     }
        // }
        // class RangeManager {
        //     TreeSet<Range> ts;
        //     public RangeManager() {
        //         ts = new TreeSet<>((a, b)->(a.l != b.l ? a.l - b.l : a.r - b.r));
        //     }
        //     public void AddR(Range r) {
        //         if (ts.Size() == 0) ts.add(r);
        //     }
        // }
        // TreeSet<Range> ts, tt; // ans 
// // 看来，亲爱的表哥的活宝妹是做人太地道，以至一永远学不会贪心算法。。。爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！
//         public int findMinimumTime(int[][] a) { 
//             Arrays.sort(a, (x, y) -> x[1] - y[1]); // 截止时间的，升序排列【这里制造了一个势：后面的都在前一个后面结束】
//             int n = a.length, r = 0;
//             boolean [] vis = new boolean [2007];
//             for (int i = 0; i < n; i++) {
//                 int cnt = 0;
//                 for (int j = a[i][0]; j <= a[i][1]; j++) // 数一数，这个任务，有几秒是已经完成了的呢？
//                     if (vis[j]) cnt++;
//                 int j = a[i][1];// 贪心的思路体现在这里：从最后一秒往前数
//                 while (cnt < a[i][2]) {
//                     if (!vis[j]) { // 这相标准不能丢：是因为，如果之前已经统计过的不算，
//                         r++; // 计入结果 
//                         cnt++;// 当前计数
//                         vis[j] = true;// 打标记
//                     }
//                     j--;
//                 }
//             }
//             return r;
//         }

        // public int maximizeGreatness(int[] a) { // 把这个数组重新排列一下，数重排后比原位上大的坐标个数 
        //     int n = a.length, r = 0;
        //     TreeMap<Integer, Integer> m = new TreeMap<>();
        //     for (int v : a) m.put(v, m.getOrDefault(v, 0) + 1);
        //     for (int i = 0; i < n; i++) {
        //         int v = a[i];
        //         Integer hi = m.ceilingKey(v+1);
        //         if (hi != null) {
        //             r++;
        //             if (m.get(hi) > 1)
        //                 m.put(hi, m.getOrDefault(hi, 1)-1);
        //             else m.remove(hi);
        //         }
        //     }
        //     return r;
        // }

        // public long findScore(int[] a) {
        //     int n = a.length, idx = 0;
        //     long r = 0;
        //     boolean [] vis = new boolean [n];
        //     List<int []> l = new ArrayList<>();
        //     for (int v : a) 
        //         l.add(new int [] {idx++, v});
        //     Collections.sort(l, (x, y)-> x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]);
        //     for (int [] v : l) {
        //         int x = v[1], i = v[0];
        //         if (vis[i]) continue;
        //         r += x;
        //         vis[i] = true;
        //         if (i > 0) vis[i-1] = true;
        //         if (i < n-1) vis[i+1] = true;
        //     }
        //     return r;
        // }

        // public long repairCars(int[] a, int n) {
        //     long ans = Long.MAX_VALUE;
        //     Arrays.sort(a);
        //     long l = 0l, r = Long.MAX_VALUE;
        //     while (l <= r) {
        //         long m = (r + l) / 2;
        //         if (possible(m, a, n)) {
        //             ans = Math.min(ans, m);
        //             r = m-1;
        //         } else l = m + 1;
        //     }
        //     long max = getExactTime(ans, a, n);
        //     return max < ans ? max : ans;
        // }
        // long getExactTime(long v, int [] a, int n) {
        //     long max = 0;
        //     for (int i = 0; i < a.length && n > 0; i++) {
        //         int m = (int)Math.sqrt(v / (long)a[i]);
        //         long cur = (long)a[i] * m * m;
        //         max = Math.max(max, cur);
        //         n -= m;
        //     }
        //     return max;
        // }
        // boolean possible(long v, int [] a, int n) {
        //     for (int i = 0; i < a.length && n > 0; i++) {
        //         if (a[i] > v) return false;
        //         int m = (int)Math.sqrt(v / a[i]);
        //         n -= m;
        //     }
        //     if (n <= 0) return true;
        //     return false;
        // }

        // public int distMoney(int v, int n) { // 实在是不喜欢这个题，太恶心人了
        //     int r = 0, idx = 0;
        //     if (v < n) return -1;
        //     v -= n; // 每人先分 1 块钱
        //     if (v < 7) return 0; // 这里要区分什么时候不能分，什么时候分的是 0
        //     while (idx < n-1 && v >= 7) {
        //         if (v >= 7) {
        //             r ++;
        //             v -= 7;
        //             idx++;
        //         }
        //     }
        //     if (idx == n-1) r += (v == 7 ? 1 : 0);
        //     if (v == 3) {
        //         if (idx == n-1)
        //             r -= 1;
        //     }
        //     return r;
        // }

        // public int kItemsWithMaximumSum(int p, int z, int n, int k) {
        //     if (k <= p + z) return k >= p ? p : k;
        //     return p - (k - p - z);
        // }

        // public boolean primeSubOperation(int[] a) {
        //     int n = a.length;
        //     if (n == 1) return true;
        //     // 如果使用贪心算法，思路仍然不是狠清楚，比较麻烦一点儿。那么就是说，从头遍历，把从头开始的数尽可能地减少到最小，但保持升续排列
        //     // 数据规模比较小，可以不用考虑其它优化
        //     for (int i = 0; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         if (i == 0 && a[i] == 1 || i > 0 && a[i] == a[i-1]+1 || i == n-1 && a[i] > a[i-1]) continue;
        //         int cur = getMin(a[i], i == 0 ? 0 : a[i-1]);
        //         if (cur != -1)
        //             a[i] = cur;
        //         // }
        //         if (i > 0 && a[i] <= a[i-1]) return false;
        //         System.out.println("a[i]: " + a[i]);
        //     }
        //     return true;
        // }
        // List<Integer> l = new ArrayList<>(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997));
        // TreeSet<Integer> s = new TreeSet<>(l); // 把 [1, 1000] 里的质数存里面
        // int getMin(int v, int r) { // v > r
        //     Integer l = s.floor(v - r - 1);
        //     if (l == null) return -1;
        //     return v - l;
        // }

        // public List<Long> minOperations(int[] a, int[] q) {
        //     int m = q.length, n = a.length;
        //     long sum = 0;
        //     Arrays.sort(a); // 按升序排列
        //     System.out.println(Arrays.toString(a));
        //     long [] r = new long [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         r[i] = r[i-1] + (long)a[i-1];
        //     System.out.println(Arrays.toString(r));
                
        //     List<Long> l = new ArrayList<>();
        //     for (int v : q) {
        //         if (v <= a[0] || v >= a[n-1])
        //             l.add(Math.abs(v * (long)n - r[n])); // 这里想得不对
        //         else { // 需要一步中转: 二分查找下标
        //             int idx = Arrays.binarySearch(a, v);
        //             System.out.println("idx: " + idx);
        //             if (idx >= 0)
        //                 l.add(Math.abs(v * (long)(idx) - r[idx] +  r[n] - r[idx+1] - v * (long)(n - idx - 1)));
        //             else {
        //                 idx = idx * (-1) - 1;
        //                 l.add(Math.abs(v * (long)idx - r[idx] +  r[n] - r[idx] - v * (long)(n - idx)));
        //             }
        //         }
        //     }
        //     return l;
        // }

//         // 这个题不是很有思路，但是求最小什么的，应该都是一个最小什么相关的算法，边写边想
//         public int collectTheCoins(int[] a, int[][] e) {
//  n = a.length;
// // 存有钱的节点索引
//             Set<Integer> s = new HashSet<>(); 
//             for (int i = 0; i < n; i++) 
//                 if (a[i] > 0) s.add(i);
// // 构建无向图：【看了一下题目上的提示，它是从构建无向图的时候就精简到最小无向图，这些思路还是需要练习的。。。】
//             g = new List [n];
//             for (int i = 0; i < n; i++) 
//                 g[i] = new ArrayList<>();
//             for (int [] eg : e) {
//                 int u = eg[0], v = eg[1];
//                 g[u].add(v);
//                 g[v].add(u);
//             }
// // 为了省时间，需要一次性算出和记住：每个其它节点到有钱节点所需要的单程步数【这个是固定不变的】
//             vis = new boolean [n];
//             for (int v : s) {
//                 m.put(v, new int [n]);
//                 updateDist(v, 0);
//             }
//             System.out.println("m.size(): " + m.size());
//             for (Map.Entry<Integer, int []> en : m.entrySet()) {
//                 System.out.print(en.getKey() + ": ");
//                 System.out.println(Arrays.toString(en.getValue()));
//             }
//             // 然后遍历所有可能的离有钱节点S: 最远 2 个距离的节点，动态更新找最小值
//             // 感觉这里还是有些没想清楚：需要记住每个节点下，可以取到哪些节点的钱？打算参考别人的解法来写这个题了。。。
//             return 0;
//         }
//         List<Integer> [] g;
//         Map<Integer, int []> m = new HashMap<>(); // dist [] to coined nodes
//         int n;
//         boolean [] vis;
//         void updateDist(int uv, int cnt) { // 算，到每个有钱节点的最小步数，2 步以内计 0
//             int [] d = m.get(uv);
//             Arrays.fill(d, Integer.MAX_VALUE);
//             d[uv] = 0;
//             Deque<int []> q = new ArrayDeque<>();
//             q.offerFirst(new int [] {uv, cnt}); 
//             Arrays.fill(vis, false);
//             while (!q.isEmpty()) {
//                 int size = q.size();
//                 for (; size > 0; size--) {
//                     int [] cur = q.pollLast();
//                     int u = cur[0], dist = cur[1];
//                     vis[u] = true;
//                     for (int v : g[u]) { // 遍历当前有钱节点的相邻节点
//                         if (vis[v]) continue;
//                         if (cnt >= 2 && cnt-2 <= d[v]) d[v] = cnt - 2;
//                         q.offerFirst(new int [] {v, cnt+1});
//                     }
//                 } 
//             }
//         }

        // public int minNumber(int[] a, int[] b) {
        //     int m = a.length, n = b.length;
        //     boolean [][] vis = new boolean [2][10];
        //     for (int v : a) vis[0][v] = true;
        //     for (int v : b) vis[1][v] = true;
        //     for (int i = 1; i < 10; i++)
        //         if (vis[0][i] && vis[1][i]) return i;
        //     int r = 0;
        //     boolean visA = false, visB = false;
        //     for (int i = 1; i < 10; i++) {
        //         if (vis[0][i] || vis[1][i]) {
        //             if (!visA && vis[0][i] || !visB && vis[1][i]) {
        //                 if (vis[0][i]) visA = true;
        //                 if (vis[1][i]) visB = true;
        //                 r += i;
        //                 if (visA && visB) return r;
        //                 r *= 10;
        //             }
        //         }
        //     }
        //     return -1;
        // }

        // // 数组里面会存在负数，并不是只要有个负数，就一定去掉，因为左右两边如果和》 0, 仍然是能够增加的
        // public int maximumCostSubstring(String s, String chars, int[] vals) {
        //     Map<Character, Integer> m = new HashMap<>();
        //     int n = chars.length();
        //     for (int i = 0; i < n; i++) 
        //         m.put(chars.charAt(i), vals[i]);
        //     int [] r = new int [s.length()];
        //     // r[0] = m.containsKey(chars.charAt(0)) ? m.get(chars.charAt(0)) : chars.charAt(0) - 'a' + 1;
        //     for (int i = 0; i < s.length(); i++) 
        //         r[i] = m.containsKey(s.charAt(i)) ? m.get(s.charAt(i)) : s.charAt(i) - 'a' + 1;                
        //     // 然后，这里就是求最大片段和：滑动窗口? 这里好像还有点儿什么没想透？
        //     System.out.println(Arrays.toString(r));
        //     int v = maxsequence3(r, r.length);
        //     System.out.println("vi: " + v);
        //     return v > 0 ? v : 0;
        // }
        // int maxsequence3(int a[], int len) { // 这个算法好像哪里不对
        //     int maxsum, maxhere;
        //     maxsum = maxhere = a[0];   //初始化最大和为a【0】
        //     for (int i=1; i<len; i++) {
        //         if (maxhere <= 0)
        //             maxhere = a[i];  //如果前面位置最大连续子序列和小于等于0，则以当前位置i结尾的最大连续子序列和为a[i]
        //         else
        //             maxhere += a[i]; //如果前面位置最大连续子序列和大于0，则以当前位置i结尾的最大连续子序列和为它们两者之和
        //         if (maxhere > maxsum) {
        //             maxsum = maxhere;  //更新最大连续子序列和
        //         }
        //     }
        //     return maxsum;
        // }

        // 下面，是被自己在超时后改昏了头的：        
        //        public int findShortestCycle(int n, int[][] eg) { // 求一个最小环的大小，检测有没有环: 超时，需要找一个优化方法
        //            g = new HashSet [n];
        //            for (int i = 0; i < n; i++) g[i] = new HashSet<>();
        //            for (int [] e : eg) {
        //                int u = e[0], v = e[1];
        //                g[u].add(v);
        //                g[v].add(u);
        //            }
        //            for (int i = 0; i < n; i++) 
        //                traverase(i, -1, 0, new HashSet<>());
        //            return min == Integer.MAX_VALUE ? -1 : min;
        //        }
        //        Set<Integer> [] g;
        //        int min = Integer.MAX_VALUE;
        //        // class Node {
        //        //     int [] r;
        //        //     HashSet<Integer> v;
        //        //     public Node(int [] a, HashSet<Integer> vv) {
        //        //         r = a;
        //        //         v = vv;
        //        //     }
        //        // }
        //        void traverase(int uu, int p, int cnt, Set<Integer> vis) {
        //            System.out.println("\n uu: " + uu);
        //            System.out.println("cnt: " + cnt);
        //            Deque<int []> q = new ArrayDeque<>();
        // // if (vis.contains(uu)) {
        //            //     if (cnt < min) min = cnt;
        //            //     System.out.println("min: " + min);
        //            //     return ;
        //            // }
        //            // q.offerFirst(new Node(new int [] {uu, p, cnt}, new HashSet<>()));
        //            q.offerFirst(new int [] {uu, p, cnt});
        //            while (!q.isEmpty()) {
        //                // Node tmp = q.pollLast();
        //                // int [] cur = tmp.r;
        //                int [] cur = q.pollLast();
        //                System.out.println(Arrays.toString(cur));
        //                int u = cur[0], pr = cur[1];
        //                if (vis.contains(u)) {
        //                    if (cnt < min) min = cnt;
        //                    System.out.println("u: " + u);
        //                    System.out.println("min: " + min);
        //                    return ;
        //                }
        //                // tmp.v.add(u);
        //                vis.add(u);
        //                for (int v : g[u]) { 
        //                    if (v == pr) continue;
        //                    // traverase(v, uu, cnt+1, vis);
        //                    // q.offerFirst(new Node(new int [] {v, u, cur[2]+1}, tmp.v));
        //                    q.offerFirst(new int [] {v, u, cur[2]+1});
        //                }
        //                // tmp.v.remove(u);
        //            }
        //        }
        // public int findShortestCycle(int n, int[][] eg) { // 求一个最小环的大小，检测有没有环: 超时，需要找一个优化方法 // // TLE TLE TLE: 
        //     g = new HashSet [n];
        //     for (int i = 0; i < n; i++) g[i] = new HashSet<>();
        //     for (int [] e : eg) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     for (int i = 0; i < n; i++) 
        //         traverase(i, -1, 0, new HashSet<>());
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }
        // Set<Integer> [] g;
        // int min = Integer.MAX_VALUE;
        // void traverase(int uu, int p, int cnt, Set<Integer> vis) {
        //     System.out.println("\n uu: " + uu);
        //     System.out.println("cnt: " + cnt);
        //     if (vis.contains(uu)) {
        //         if (cnt < min) min = cnt;
        //         System.out.println("min: " + min);
        //         return ;
        //     }
        //     vis.add(uu);
        //     for (int v : g[uu]) {
        //         if (v == p) continue;
        //         traverase(v, uu, cnt+1, vis);
        //     }
        //     vis.remove(uu);
        // }

        // // 没有思路: 知道环形如何处理，不知道怎么让它们全相等？
        // public long makeSubKSumEqual(int[] a, int k) {
        //     int n = a.length;
        // }
                
        // public int findTheLongestBalancedSubstring(String t) {
        //     int n = t.length(), max = 0;
        //     char [] s = t.toCharArray();
        //     int i = 0, j = 0, cntA = 0, cntB = 0;
        //     while (i < n && s[i] == '1') i++;
        //     if (i == n) return max;
        //     System.out.println("\n i: " + i);
        //     while (i < n) {
        //         while (i < n && s[i] == '0') {
        //             cntA++;
        //             i++;
        //         }
        //         if (i == n) return max;
        //         while (i < n && s[i] == '1') {
        //             cntB++;
        //             i++;
        //         }
        //         max = Math.max(max, Math.min(cntA, cntB) * 2);
        //         cntA = 0;
        //         cntB = 0;
        //         if (i == n) return max;
        //     }
        //     max = Math.max(max, Math.min(cntA, cntB) * 2);
        //     return max;
        // }

        // public List<List<Integer>> findMatrix(int[] a) {
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int v : a)
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //     int n = Collections.max(m.values());
        //     List<List<Integer>> r = new ArrayList<>(n);
        //     for (int i = 0; i < n; i++)
        //         r.add(new ArrayList<>());
        //     for (Map.Entry<Integer, Integer> en : m.entrySet()) {
        //         for (int i = 0; i < en.getValue(); i++)
        //             r.get(i).add(en.getKey());
        //     }
        //     return r;
        // }

        // public int miceAndCheese(int[] a, int[] b, int k) {
        //     int n = a.length;
        //     int [][] d = new int [n][2]; // a[i] - b[i]
        //     for (int i = 0; i < n; i++) {
        //         d[i][0] = i;
        //         d[i][1] = a[i] - b[i];
        //     }
        //     Arrays.sort(d, (x, y) -> y[1] - x[1]);
        //     boolean [] vis = new boolean [n];
        //     for (int i = 0; i < k; i++) // 第一只老鼠吃的 K 块
        //         vis[d[i][0]] = true;
        //     int r = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (vis[i]) r += a[i];
        //         else r += b[i];
        //     }
        //     return r;
        // }

        // // 不知道这个P 题目说的是什么意思
        // public int[] minReverseOperations(int n, int p, int[] b, int k) {
        //     int m = b.length;
        //     Set<Integer> s = new HashSet<>(Arrays.stream(b).boxed().collect(Collectors.toList()));
        //     int [] r = new int [n];
        //     Arrays.fill(r, -1);
        //     r[p] = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (s.contains(i) || i == p) continue; // -1 0
        //     }
        // }
        // int getCnt(int idx, int n, int p, Set<Integer> s, int k) { // 这个巅倒片段，不知道说的是什么意思 
        // public int findSmallestInteger(int[] a, int k) {
        //     int n = a.length, j = 0;
        //     Arrays.sort(a); // 升序排列
        //     TreeMap<Integer, Integer> m = new TreeMap<>();
        //     for (int i = 0; i < n; i++) {
        //         int v =  ((a[i] + k) % k + k) % k; // 保证它是非负数
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //     }
        //     if (!m.containsKey(0)) return 0;
        //     while (m.containsKey(j % k)) {
        //         if (m.get(j % k) > 1)
        //             m.put(j % k, m.getOrDefault(j % k, 1)-1);
        //         else m.remove(j % k);
        //         j++;
        //     }
        //     return j;
        // }

        // // 这个题之前写过，有点儿印象，但感觉消化不透：
        // // 超时了再来想这个：数据规模小，感觉能瓣出来一样。。。。。脑袋有点儿糊，想得不透
        // // 思路：1<= N<= 20, 怎么把这个数组分成两半，一折为二，变成两个 10 个长度的，就不会超时
        // public int beautifulSubsets(int[] a, int k) { // 它说，这个方法超时了 TLE TLE TLE 
        //     n = a.length;
        //     int r = (1 << n), ans = 0;
        //     for (int i = 1; i < r; i++)             
        //         if (isValidSubsets(i, a, k)) ans++;
        //     return ans;
        // }
        // int n;
        // boolean isValidSubsets(int v, int [] a, int k) {
        //     Set<Integer> s = new HashSet<>();
        //     for (int i = 0; i < n; i++) {
        //         if (((v >> i) & 1) == 1) { // 这一个位是 1
        //             if (s.contains(a[i] + k) || s.contains(a[i] - k)) return false;
        //             s.add(a[i]);
        //         }
        //     }
        //     return true;
        // }
        // public int beautifulSubsets(int[] a, int k) { // 越写越糊。。。。。
        //     nn = a.length;
        //     m = nn / 2;
        //     n = nn - m;
        //     int ll = (1 << m), rr = (1 << n);
        //     int [] l = new int [m], r = new int [n];
        //     int ans = 0;
        //     l = Arrays.copyOfRange(a, 0, m);
        //     r = Arrays.copyOfRange(a, m, nn);
        //     for (int i = 0; i < ll; i++) 
        //         for (int j = 0; j < rr; j++) 
        //             if (isValidSubsets(i, j, a, k)) ans++;
        //     return ans;
        // }
        // int m, n, nn;
        // boolean isValidSubsets(int l, int r, int [] a, int k) {
        //     int cur = ((l << n) | r);
        //     for (int v : masks) 
        //         if ((cur & v) >= v) return false;
        //     return true;
        // }
        // Set<Integer> masks = new HashSet<>();
        // void buildMasks(int [] a, int k) {
        //     int n = a.length;
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < nn; i++)
        //         m.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
        //     for (int i = 0; i < nn; i++) {
        //         int v = a[i];
        //         int cur = (1 << i);
        //         if (m.containsKey(v + k)) {
        //             for (int idx : m.get(v+k)) 
        //                 masks.add(cur | (1 << idx));
        //         }
        //         if (m.containsKey(v - k)) {
        //             for (int idx : m.get(v-k)) 
        //                 masks.add(cur | (1 << idx));
        //         }
        //     }
        // }
        // // 现在是，把回塑方法，给忘得一干二净了。。。。。
        // public int beautifulSubsets(int[] a, int k) { // 【亲爱的表哥，活宝妹一定要嫁的亲爱的表哥！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        //     Arrays.sort(a);// 把它按照升序排列
        //     Map<Integer, Integer> m = new HashMap<>();// 已经包含了的数
        //     int n = a.length;
        //     return dfs(0, a, k, m, n) - 1;
        // }
        // int dfs(int idx, int [] a, int k, Map<Integer, Integer> m, int n) {
        //     if (idx == n) return 1;
        //     int r = 0;
        //     if (m.getOrDefault(a[idx]-k, 0) == 0) {
        //         m.put(a[idx], m.getOrDefault(a[idx], 0) + 1);
        //         r += dfs(idx+1, a, k, m, n);
        //         m.put(a[idx], m.getOrDefault(a[idx], 0)-1);
        //     }
        //     r += dfs(idx+1, a, k, m, n);
        //     return r;
        // }

        // public int minMaxDifference(int v) {
        //     int max = getMax(v);
        //     int min = getMin(v);
        //     return max - min;
        // }
        // int getMin(int v) {
        //     String t = String.valueOf(v);
        //     char [] s = t.toCharArray();
        //     int idx = 0, n = t.length();
        //     char a = s[0];
        //     for (char c : s) {
        //         if (c == a) s[idx] = '0';
        //         idx++;
        //     }
        //     return Integer.parseInt(new String(s));
        // }
        // int getMax(int v) {
        //     String t = String.valueOf(v);
        //     char [] s = t.toCharArray();
        //     int idx = 0, n = t.length();
        //     while (idx < n && s[idx] == '9') idx++;
        //     if (idx == n) return v;
        //     char a = s[idx]; // 不一定是第一个，因为第一个是 9 的时候，就要往后数
        //     for (int i = idx; i < n; i++) {
        //         if (s[i] == a) s[idx] = '9';
        //         idx++;
        //     }
        //     return Integer.parseInt(new String(s));
        // }

        // public int diagonalPrime(int[][] a) {
        //     int n = a.length;
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++)
        //             l.add(new int [] {a[i][j], i, j});
        //     Collections.sort(l, (x, y)-> x[0] != y[0] ? y[0] - x[0] : x[1] - y[1]); // 降序排列
        //     for (int [] v : l)
        //         if ((v[1] == v[2] || v[2] == n-1 - v[1]) && isPrime(v[0])) return v[0];
        //     return 0;
        // }
        // public static boolean isPrime(int n) {
        //     if (n < 3) {
        //         if (n == 2) 
        //             return true;
        //         else
        //             return false;
        //     }
        //     for (int i = 2; i < n; i++) 
        //         if (n % i == 0) 
        //             return false;
        //     return true;
        // }

        // // 这里好像还有一个贪心的思想，这个题目知道自己想错后，就没再写了。。。
        // public int minimizeMax(int[] a, int p) {
        //     int n = a.length;
        //     Arrays.sort(a);
        //     return a[2*(p-1)+1] - a[2*(p-1)];
        // }

        // 感觉这里，我记忆化搜索的方向，与它动态规划的方向是反的。可是两个本来就是反着的。。。改天再写，今天不想写了。。。
        // Queue<Integer> q = new PriorityQueue<>(); 感觉确实能再快一点儿
        // public int minimumVisitedCells(int[][] a) { // 动态规划，可是怎么实现不超时？ TLE TLE TLE 感觉已经是记忆化搜索了呀？！！！
        //     m = a.length;
        //     n = a[0].length;
        //     // 还是说，这里先检查一遍，是否可到达 ? 可是先检查一遍不是也要花时间吗？
        //     f = new Integer [m][n];  // 自己认准某一个方向来遍历
        //     for (int i = 0; i < m; i++) 
        //         Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        //     int r = dfs(0, 0, a);
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z) 
        //         System.out.println(Arrays.toString(f[z]));
        //     return r == Integer.MAX_VALUE / 2 ? -1 : r;
        // }
        // Integer [][] f;
        // int m, n;
        // int dfs(int ii, int jj, int [][] a) { // 记忆化揵从当前坐标到终点的最小步数
        //     // if (ii >= m || jj >= n) return Integer.MAX_VALUE / 2; // 主要是免得溢出
        //     if (ii == m-1 && jj == n-1) return f[ii][jj] = 1;
        //     if (f[ii][jj] < Integer.MAX_VALUE / 2) return f[ii][jj];
        //     int r = Integer.MAX_VALUE / 2;
        //     // for (int j = Math.min(a[ii][jj] + jj, n-1); j > jj; j--) {
        //     int max = Math.min(a[ii][jj] + jj, n-1);
        //     for (int j = max; j > jj; j--) {
        //         int cur = 1 + dfs(ii, j, a);
        //         r = Math.min(r, cur);
        //     }
        //     max = Math.min(a[ii][jj] + ii, m-1);
        //     for (int i = max; i > ii; i--) {
        //         int cur = 1 + dfs(i, jj, a);
        //         r = Math.min(r, cur);
        //     }
        //     return f[ii][jj] = r;
        // }        

        // long getSum(List<Integer> l) {
        //     long r = 0l;
        //     for (int v : l)
        //     // for (int k = i; k <= j; k++) 
        //         r += (long)v;
        //     return r;
        // }
    }
    public static void main (String[] args) { 
        Solution s = new Solution ();

        // int [] a = new int [] {1,3,1,1,2};
        int [] a = new int [] {0,5,3,1,2,8,6,6,6};

        long [] r = s.distance(a);
        System.out.println(Arrays.toString(r));
    }
}
// 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
























































