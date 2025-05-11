import com.TreeNode;
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;
import java.math.BigInteger;
import static java.util.stream.Collectors.toMap;
public class cmp {
    public static class Solution {
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxSum(int[] a) {
        //     int n = a.length, m = 0, j = 0;
        //     Set<Integer> s = new HashSet<>();
        //     for (int v : a) 
        //         if (v > 0 && !s.contains(v)) {
        //             m++;
        //             s.add(v);
        //         }
        //     if (m == 0) return Arrays.stream(a).max().getAsInt();
        //     int [] b = new int [m];
        //     s.clear();
        //     for (int i = 0; i < n; i++)
        //         if (a[i] > 0 && !s.contains(a[i])) {
        //             b[j++] = a[i];
        //             s.add(a[i]);
        //         }
        //     // 万恶的【滑动窗口】又滚出来了。。它们的贱鸡、贱畜牲，真贱！！
        //     j = 0; s.clear();
        //     int sum = 0, max = Integer.MIN_VALUE;
        //     for (int i = 0; i < m; i++) {
        //         sum += b[i];
        //         if (s.contains(b[i])) {
        //             while (j <= i && s.contains(b[i])) {
        //                 sum -= b[j];
        //                 s.remove(b[j]);
        //                 j++;
        //             }
        //         }
        //         s.add(b[i]);
        //         max = Math.max(max, sum);
        //     }
        //     max = Math.max(max, sum);
        //     return max;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public List<Integer> solveQueries(int[] a, int[] b) {
        //     int n = a.length;
        //     int [] l = new int [2 * n], r = new int [2 * n];
        //     Arrays.fill(l, 2 * n); Arrays.fill(r, 2 * n);
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n * 2; i++) {
        //         if (m.containsKey(a[i % n]))
        //             r[m.get(a[i % n])] = i;
        //         m.put(a[i % n], i);
        //     }
        //     m.clear();
        //     // 这里能取【n,2n-1】范围吗？
        //     for (int i = 2 * n-1; i >= 0; i--) {
        //         if (m.containsKey(a[i % n]))
        //             l[m.get(a[i % n])] = i % n;
        //         m.put(a[i % n], i);
        //     }
        //     System.out.println(Arrays.toString(l));
        //     List<Integer> li = new ArrayList<>();
        //     for (int i = 0; i < b.length; i++) {
        //         int j = b[i];
        //         if (l[j+n] == 2 * n && r[j] == 2 * n || l[j+n]%n == j && r[j] == j+n) li.add(-1);
        //         else 
        //             li.add(Math.min(r[j] - j , j > l[j+n]%n ? j - l[j+n]%n : n-l[j+n]%n+j));
        //     }
        //     return li;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minZeroArray(int[] a, int[][] qs) {
        //     n = a.length; this.a = a; this.qs = qs; 
        //     int l = 0, r = qs.length, ans = Integer.MAX_VALUE;
        //     while (l <= r) {
        //         int m = (l + r) / 2;
        //         System.out.println("m: " + m);
        //         if (valid(m)) {
        //             ans = m;
        //             r = m-1;
        //         } else l = m + 1;
        //     }
        //     return ans == Integer.MAX_VALUE ? -1 : ans;
        //     //== qs.length+1 ? -1 : r;
        // }
        // int [] a; int [][] qs; int n;
        // // 它还涉及到：前 v 个操作，可以跳过某些不干活。。。
        // boolean valid(int v) {
        //     int [] f = new int [n];
        //     f = Arrays.copyOf(a, n);
        //     for (int j = 0; j < v; j++) {
        //         int [] cur = qs[j];
        //         int l = cur[0], r = cur[1], val = cur[2];
        //         for (int i = l; i <= r; i++) 
        //             if (f[i] >= val) f[i] -= val;
        //     }
        //     System.out.println("(Arrays.stream(f).sum() == 0): " + (Arrays.stream(f).sum() == 0));
        //     return Arrays.stream(f).sum() == 0;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxContainers(int n, int w, int maxWeight) {
        //     if (w > maxWeight) return 0;
        //     if (n * n * w <= maxWeight) return n * n;
        //     this.n = n; this.w = w; this.maxWeight = maxWeight;
        //     int l = (w <= maxWeight ? 1 : 0), r = n * n, max = 0; 
        //     while (l <= r) {
        //         int m = (l + r) / 2;
        //         if (valid(m)) {
        //             max = Math.max(max, m);
        //             l = m+1;
        //         } else r = m-1;
        //     }
        //     return max;
        // }
        // int n, w, maxWeight;
        // boolean valid(int v) {
        //     return v * w <= maxWeight;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public class UnionGraph {
        //     int [] f;
        //     int n, cnt;
        //     public UnionGraph(int n) {
        //         this.n = n; cnt = n;
        //         f = new int [n];
        //         for (int i = 0; i < n; i++) 
        //             f[i] = i;
        //     }
        //     int find(int i) {
        //         while (i != f[i]) {
        //             f[i] = f[f[i]];
        //             // f[i] = find(f[i]);
        //             i = f[i];
        //         }
        //         // return f[i];
        //         return i;
        //     }
        //     public boolean sameGroup(int i, int j) {
        //         return find(i) == find(j);
        //     }
        //     public void merge(int i, int j) {
        //         int p = find(i), q = find(j);
        //         // 把两个子树，随便随机合并成一个子树
        //         f[p] = q;
        //         --cnt;
        //     }
        //     public int getComponents() {
        //         // return (int)Arrays.stream(f).distinct().count();
        //         System.out.println(Arrays.toString(f));
        //         return cnt;
        //     }
        // }
        // public int numberOfComponents(int[][] f, int k) {
        //     int n = f.length, m = f[0].length, cnt = 0;
        //     Set<Integer> s = new HashSet<>(), t = new HashSet<>();
        //     UnionGraph uf = new UnionGraph(n);
        //     for (int i = 0; i < n; i++) {
        //         if (f[i].length < k) continue;
        //         s.clear(); 
        //         for (int v : f[i]) s.add(v);
        //         if (s.size() < k) continue;
        //         for (int j = i+1; j < n; j++) {
        //             if (uf.sameGroup(i, j)) continue;
        //             cnt = 0; t.clear();
        //             for (int v : f[j]) t.add(v);
        //             for (int v : t)
        //                 if (s.contains(v)) cnt++;
        //             if (cnt >= k) uf.merge(i, j);
        //         }
        //     }
        //     return uf.getComponents();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，读不懂题目说的是什么意思；看不懂例子里的讲解
        // public long minTime(int[] skill, int[] mana) {
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 破烂题目：好像要用【回塑】，并且判断是否合法，再数个数
        // // 或者，遍历【1<<n】的可能性；再每种选择的3 个数字里，数合法个数累加
        // public int totalNumbers(int[] a) {
        //     n = a.length, f = 0; this.a = a; 
        //     for (int i = 1; i < (1 << n); i++) {
        //         int cnt = Integer.bitCount(i);
        //         if (cnt != 3) continue; // 3 个数字 
        //         // 再数个数
        //         f += getCnts(i);
                
        //     }
        // }
        // int n; int [] a;
        // int getCnts(int v) { // 【TODO：】这个数得好烦呀，晚点儿再写这个
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个题目，其实狠简单，就是狠繁琐. 亲爱的表哥的活宝妹早说了，这种破烂题目，都是贱鸡、贱畜牲作贱生命，狠讨厌这类题目
        // class Spreadsheet {
        //     // 用来记【A-Z】26 列里：不同行的、设置过的值
        //     Map<Integer, Integer> [] m;
        //     int n;
        //     public Spreadsheet(int rows) {
        //         m = new HashMap[26];
        //         Arrays.setAll(m, z -> new HashMap<Integer, Integer>());
        //         n = rows;
        //     }
        //     public void setCell(String cell, int value) {
        //         int i = Integer.parseInt(cell.substring(1)), j = cell.toCharArray()[0]-'A';
        //         m[j].put(i, value);
        //     }
        //     public void resetCell(String cell) {
        //         int i = Integer.parseInt(cell.substring(1)), j = cell.toCharArray()[0]-'A';
        //         if (m[j].containsKey(i))
        //             m[j].remove(i);
        //     }
        //     public int getValue(String formula) {
        //         String [] s = formula.substring(1).split("\\+");
        //         int i = 0, j = 0, f = 0;
        //         for (String v : s) {
        //             if (v.toCharArray()[0] - 'A' >= 0) {
        //                 j = v.toCharArray()[0] - 'A';
        //                 f += (m[j].containsKey(Integer.parseInt(v.substring(1))) ? m[j].get(Integer.parseInt(v.substring(1))) : 0);
        //             }
        //             else f += Integer.parseInt(v);
        //         }
        //         return f;
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个破烂题目：一看就是狗屁破烂【字典树】呀。。计数，数个数，数与【本字符串】不同的、共存于至少 k 个字符串的（字典树）的『最大深度』
        // // 亲爱的表哥的活宝妹，感觉思路是对的，不知道细节哪里写错了。。。【TODO：】先去挪车、去车里喝水，晚上有时间再检查这个破烂垃圾题目
        // public class PrefixTree {
        //     class Node {
        //         Node [] n;
        //         int i; // cnts
        //         public Node() {
        //             i = 0;
        //             n = new Node[26];
        //         }
        //     }
        //     Node r;
        //     public PrefixTree() {
        //         r = new Node();
        //     }
        //     public void insert(String t) {
        //         int n = t.length(); char [] s = t.toCharArray();
        //         Node f = r; f.i++;
        //         for (int i = 0; i < n; i++) {
        //             int j = s[i] - 'a';
        //             if (f.n[j] == null) f.n[j] = new Node();
        //             f.n[j].i++; // 累加节点计数
        //             f = f.n[j];
        //         }
        //     }
        //     // 【DFS 深搜：】与 t 不同的、至少 k 串的最大公共前缀长度；或与和相同的、至少 k+1 串的、最大公共前缀长度
        //     private int getLongestPrefixCommonDFS(Node f, String t, int k, boolean same, int d) { // d: 树深度，同样标记字符串的 idx
        //         // System.out.println("t: " + t + " same: " + same);
        //         int n = t.length(); char [] s = t.toCharArray();
        //         int j = 0, max = 0;
        //         if (same) {
        //             if (d < t.length()) {
        //                 j = s[d] - 'a'; 
        //                 if (f.n[j] == null || f.n[j].i < k) {
        //                     // System.out.println("d: " + d);
        //                     return d;
        //                 }
        //                 return getLongestPrefixCommonDFS(f.n[j], t, k, same, d+1);
        //             } else {
        //                 for (j = 0; j < 26; j++) {
        //                     if (f.n[j] == null || f.n[j].i < k) {
        //                         max = Math.max(max, d);
        //                         // System.out.println("max 00: " + max);
        //                         continue; // 节点为空、个数不够
        //                     }
        //                     max = Math.max(max, getLongestPrefixCommonDFS(f.n[j], t, k, same, d+1));
        //                 }
        //                 // System.out.println("max 1: " + max);
        //                 return max;
        //             }
        //         } else { // NOT same
        //             System.out.println("t: " + t + " same: " + same);
        //             for ( j = 0; j < 26; j++) {
        //                 if (d < t.length() && j == s[d]-'a') continue; // 相同的，跳过
        //                 if (f.n[j] == null || f.n[j].i < k) {
        //                     max = Math.max(max, d);
        //                     System.out.println("max 0: " + max);
        //                     continue; // 节点为空、个数不够
        //                 }
        //                 max = Math.max(max, getLongestPrefixCommonDFS(f.n[j], t, k, same, d+1));
        //             }
        //             System.out.println("max 2: " + max);
        //             return max;
        //         }
        //     } 
        //     public int getLongestPrefixCommon(String t, int k) {
        //         Node f = r;
        //         int i = getLongestPrefixCommonDFS(f, t, k, false, 0), j = getLongestPrefixCommonDFS(f, t, k+1, true, 0);
        //         System.out.println("i: " + i + " " + "j: " + j);
        //         return Math.max(i, j);
        //         // return Math.max(getLongestPrefixCommonDFS(f, t, k, false, 0), getLongestPrefixCommonDFS(f, t, k+1, true, 0));
        //     }
        // public int[] longestCommonPrefix(String[] a, int k) {
        //     int n = a.length;
        //     PrefixTree pf = new PrefixTree();
        //     for (String v : a) pf.insert(v);
        //     int [] f = new int [n]; 
        //     for (int i = 0; i < n; i++) 
        //         f[i] = pf.getLongestPrefixCommon(a[i], k);
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int reverseDegree(String T) {
        //     int n = T.length(); char [] s = T.toCharArray();
        //     int f = 0;
        //     for (int i = 0; i < n; i++) 
        //         f += (i + 1) * (1 + ('z' - s[i]));
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxActiveSectionsAfterTrade(String T) {
        //     int n = T.length(); char [] s = T.toCharArray();
        //     // [动规]纪录：每个1, 【最左合法0】和（最右合法0）
        //     int [] l = new int [n], r = new int [n], f = new int [n];
        //     int idx = -1;
        //     Arrays.fill(l, n); Arrays.fill(r, -1);
        //     for (int i = 0; i < n; i++) {
        //         f[i] = s[i] - '0';
        //         if (i > 0) f[i] += f[i-1];
        //     }
        //     // 【自左向右】遍历：（动规）出 l[]
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == '0') {
        //             if (idx == -1) idx = i;
        //             continue;
        //         }
        //         // s[i] == 1
        //         if (i == 0) l[i] = n;
        //         else if (s[i] == s[i-1])
        //             l[i] = l[i-1];
        //         else {
        //             l[i] = idx;
        //             idx = -1;
        //         }
        //     }
        //     // 【自右向左】遍历：（动规）出 r[]
        //     idx = -1;
        //     for (int i = n-1; i >= 0; i--) {
        //         if (s[i] == '0') {
        //             if (idx == -1)
        //                 idx = i;
        //             continue;
        //         }
        //         if (i == n-1) r[i] = -1;
        //         else if (s[i] == s[i+1])
        //             r[i] = r[i+1];
        //         else {
        //             r[i]= idx;
        //             idx = -1;
        //         }
        //     }
        //    // 遍历一遍：求全遍最优解。因为最多只操作1 次，极度简化，所以可以不必动规，直接（贪心）也能求全局最优解
        //     int max = f[n-1];
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == '0') continue;
        //         if (l[i] < i && r[i] > i)
        //             max = Math.max(max, f[n-1] - (f[r[i]] - (l[i] == 0 ? 0 : f[l[i]-1])) + r[i] - l[i] + 1);
        //     }
        //     return max;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 对现在的亲爱的表哥的活宝妹来说，这个破烂【动规】，不是太简单了吗？
        // // 现在知道，还是需要想一想的吧。。但仍然感觉，可以去想，不超出亲爱的表哥的活宝妹的【动规解题能力】之外。。
        // public long minimumCost(int[] a, int[] c, int k) {
        //     int n = a.length;
        //     // 【原位】：变成（前缀和）数组
        //     for (int i = 1; i < n; i++) {
        //         a[i] += a[i-1];
        //         c[i] += c[i-1];
        //     }
        //     // 【动规：状态定义】，不是一维的，需要纪录（截止，当前下标[i:0-n-1]）将数组分成[j:1-n] 个子数组的、最佳解？
        //     // 【优化】：当遍历到每个当前下标[i:0-n-1], 如何理新此 [j:1-i+1] 最优解？
        //     // 【动规：状态转移方程】亲爱的表哥的活宝妹，需要想清楚（求每个 f[i][j] 全局最优解）的过程，不漏掉解
        //     // 【动规：状态定义】，不是二维的？当把当前下标 i 合并累积入 f[i-1][j] 的最后一个子数组时，最后一个子数组的（左右端点 [l,r]）同样 matter...
        //     long [][] f = new long [n+1][n];
        //     // 遍历：【自左向右】，以当前下标[i: 0-n-1] 作为（右端点）
        //     //     要么：【不启】新子数组，合并入前 [j:1,i-1] 个子数组的、最后一个子数组中去，更新 f[i][j: 1,i-1]
        //     //     要么：【启头】新子数组，在前结果 f[i-1][j: 1,i-1] 的基础上，更新当前 f[i][j: 1,i]
        //     for (int i = 1; i <= n; i++) {
        //         for (int j = 1; j <= i; j++) { // 【升序】遍历：从一个一个小小基础问题，累积求解
        //             if (i == 1 && j == 1) {
        //                 f[i][j] = (a[i-1] + k * j) * c[i-1];
        //                 continue;
        //             }
        //             // 要么：【不启】新子数组(j < i)，合并入前 [j:1-i] 个子数组的、最后一个子数组中去，更新 f[i][j: 1-i]
        //             // 这里，好像有个没能想清楚的、嵌套 c[l,r] 的更新，就是【前结果 f[i-1][j]】的最后一个子数组的（首尾下标[l,r]）相关
        //             // 分析：当前下标 a[i-1] 合并累积入 f[i-1][j] 的最后一个子数组后： f[i][j] 需要在 f[i-1][j] 的基础上，作哪些改变？
        //             if (j == 1) { //[0,i-1] 全局仅只一个片段
        //                 // 更新：累加 c[i-1] 的【左乘代价】；累加 a[i-1] 更新后的（右乘代价）
        //                 f[i][j] = f[i-1][j]
        //                     + (a[i-1] + k * j) * (c[i-1] - c[i-2]) // 累加 c[i-1] 的【左乘代价】；
        //                     + (a[i-1] - a[i-2]) * c[i-1];          // 累加 a[i-1] 更新后的（右乘代价）
        //                 continue;
        //             }
        //             // j>1: 但与上面 j=1 类似,
        //             // 这里 j>1 的 j 因子要纳入考虑，就是要考虑 f[i-1][j] 的最后一个、第 j 个子数组的【左端点】在哪里：
        //             // 【TODO：】当需要嵌套第三层循环，为什么不是定义【三维动规数组】？
        //             // 【TODO：】这里应该有什么（贪心）之类的优化才对，要不然【三维动规O(10^9)】不过会TLE
        //             // 嵌套一层循环：f[i-1][j] 的最后一个、第 j 个子数组的【左端点】的起点在 k: [k:j-1,i-1]
        //             // 更新：累加 c[i-1] 的【左乘代价】；累加 a[i-1] 更新后的（右乘代价）
        //             for (int k = j-1; k <= i-1; k++) {
        //                 f[i][j] = Math.max(f[i][j], f[k][j]
        //             }
        //             f[i][j] = f[i-1][j]
        //                 + (a[i-1] + k * j) * (c[i-1] - c[i-2]) // 累加 c[i-1] 的【左乘代价】；
        //                 + (a[i-1] - a[i-2]) * c[i-1];          // 累加 a[i-1] 更新后的（右乘代价）
        //         }
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] minCosts(int[] a) {
        //     int n = a.length;
        //     int [] f = new int [n];
        //     // f = Arrays.copyOf(a, n);
        //     f[0] = a[0];
        //     for (int i = 1; i < n; i++) 
        //         f[i] = Math.min(f[i-1], a[i]);
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，如同上午的第三题，写不到【动规】，就先写【记忆化深搜】TLE TLE TLE 712/773
        // public long minOperations(int[] a, int x, int k) {
        //     n = a.length; this.a = a; this.x = x;
        //     p = new long [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         p[i] = p[i-1] + (long)a[i-1];
        //     f = new Long [n][k+1];
        //     return dfs(0, k);
        // }
        // int n, x;
        // int [] a;
        // long [] p;
        // Long [][] f;
        // // 以当前下标 i 为起点，剩余数组，构造 j 个合法子数组的【最小操作数】
        // long dfs(int i, int j) {
        //     if (i >= n) return j <= 0 ? 0 : Long.MAX_VALUE / 2;
        //     if (i > n-x && j >= 1) return Long.MAX_VALUE / 2;
        //     else if (i > n-x || j <= 0) return 0;
        //     System.out.println("\ni: " + i + " " + "j: " + j);
        //     if (f[i][j] != null) return f[i][j];
        //     long min = Long.MAX_VALUE / 2;
        //     // 以【当前下标 i】为起点，连续 x 个数的最小操作数
        //     // // 【TODO：】下面的方法不对，不一定是【全局最优解】
        //     // min = Math.min(min, Math.min(l, ll) + dfs(i+x, j-1));
        //     min = Math.min(min, getMinOps(i) + dfs(i+x, j-1));
        //     // System.out.println("min: " + min);
        //     // 不以【当前下标 i】为起点，跳过这个，走下一个
        //     min = Math.min(min, dfs(i+1, j));
        //     return f[i][j] = min;
        // }        
        // long getMinOps(int i) {
        //     // 以【当前下标 i】为起点，连续 x 个数的最小操作数
        //     long sum = p[i+x] - p[i];
        //     double avg = sum / (double)x;
        //     double lo = Math.floor(avg), hi = Math.ceil(avg);
        //     long l = 0, ll = 0;
        //     List<Integer> li = new ArrayList<>();
        //     for (int k = i; k < i+x; k++) {
        //         li.add(a[k]);
        //         l += (long)Math.abs(a[k] - lo);
        //         ll += (long)Math.abs(a[k] - hi);
        //     }
        //     // 【TODO：】下面的方法不对，不一定是【全局最优解】
        //     long min = Math.min(l, ll);
        //     Collections.sort(li);
        //     // System.out.println("li.size(): " + li.size());
        //     // System.out.println(Arrays.toString(li.toArray()));
        //    int loo = li.get(x/2 - (x % 2 == 0 ? 1 : 0)), hii = li.get(x / 2);
        //     // System.out.println("loo: " + loo + " " + "hii: " + hii);
        //     l = 0; ll = 0;
        //     for (int k = i; k < i+x; k++) {
        //         l += (long)Math.abs(a[k] - loo);
        //         ll += (long)Math.abs(a[k] - hii);
        //     }
        //     min = Math.min(min, Math.min(l, ll));
        //     return min;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】 
        // // 这个关于【回文】的相关算法，亲爱的表哥的活宝妹忘记了，晚点儿再写这个
        // public int longestPalindrome(String SS, String TT) {
        //     String T = new StringBuilder(TT).reverse().toString();
        //     // 把TT 倒过来后，就可以S+T O(N) 查找最长公共前缀了 LCP? LongestCommonPrefixString....
        //     int m = SS.length(), n = T.length(), max = 1;
        //     String S = SS + T; char [] s = S.toCharArray();
        //     System.out.println("S: " + S);
        //     // 回想呀回想呀，亲爱的表哥的活宝妹笨宝妹，要把这个经典O(N) 算法给回想出来
        //     // 每个【回文、窗口的、左右端点】： l,r 亲爱的表哥的活宝妹笨宝妹记错了，【左右窗口端点】的是Z 数组
        //     int [] f = new int [m+n];
        //     for (int i = 1; i < m+n; i++) {
        //         System.out.println("\n i: " + i);
        //         int j = f[i-1];
        //         while (j > 0 && s[i] != s[j]) 
        //             j = f[j-1];
        //         System.out.println("j: " + j);
        //         if (s[i] == s[j]) j++;
        //         f[i] = j;
        //         System.out.println("j: " + j);
        //     }
        //     System.out.println(Arrays.toString(f));
        //     max = Arrays.stream(f).max().getAsInt();
        //     // 【TODO：】需要添加一步：扫TT 单串的最长回文（子串）长度
        //     // 这里也有个O(N) 的算法。。。
        //     return max * 2 + (max < m ? 1 : 0);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，居然把它给写超时了。。TLE TLE TLE 【TODO：】
        // public int minimumPairRemoval(int[] a) {
        //     int n = a.length, min = 2000, f = 0, v = 0, idx = -1, j = 1;
        //     l = Arrays.stream(a).boxed().collect(Collectors.toList());
        //     while (j < l.size() && !valid()) {
        //         min = 2000; idx = -1;
        //         // for (int i = j; i < l.size(); i++) {
        //         for (int i = 1; i < l.size(); i++) {
        //             v = l.get(i) + l.get(i-1);
        //             if (v < min) {
        //                 min = v;
        //                 idx = i;
        //             }
        //         }
        //         if (idx != -1) {
        //             f++;
        //             l.remove(idx);
        //             l.set(idx-1, min);
        //             // j = (idx == l.size() ? 1 : idx);
        //             idx = -1; min = 2000;
        //         }
        //     }
        //     return f;
        // }
        // List<Integer> l;
        // boolean valid() {
        //     if (l.size() == 0) return true;
        //     for (int i = 1; i < l.size(); i++)
        //         if (l.get(i) < l.get(i-1)) return false;
        //     return true;
        // }

    //     // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】 539/727 passed
    //     // 这种破烂题目，是它们的贱鸡、贱畜牲，用来作贱生命的。。。它们的贱鸡、贱畜牲，真贱！！！
    // // 亲爱的表哥的活宝妹，今天晚上，被这个破烂题目给恶心坏了。。它们的贱鸡、贱畜牲，真贱！！！
    //     class BIT {
    //         int [] f;
    //         int n;
    //         public BIT(int n) {
    //             this.n = n;
    //             f = new int [n];
    //         }
    //         // 亲爱的表哥的活宝妹，把这里没有写对。。。
    //         public void update(int i, int v) {
    //             while (i < n) {
    //                 f[i] += v;
    //                 i += lowBit(i);
    //             }
    //         }
    //         private int lowBit(int i) {
    //             return i & -i;
    //         }

    //         // 【TODO：】感觉这里的细节，有点儿忘记，或记错了
    //         private int getSum(int i) {
    //             System.out.println("i: " + i);
    //            int ans = 0;
    //             while (i > 0) {
    //                 ans += f[i];
    //                 i -= lowBit(i);
    //             }
    //             System.out.println("i: " + i + " " + "ans: " + ans);
    //             // System.out.println("ans: " + ans);
    //            return ans;
    //         }
    //         public int querySum(int i, int j) {
    //             System.out.println("i: " + i + " " + "j: " + j);
    //             System.out.println(Arrays.toString(f));
    //             return getSum(i) - getSum(j-1);
    //         }
    //     }
    //     // class Router {
    // class cmp {
    //     ArrayDeque<int []> q;
    //     Map<Integer, Map<Integer, Set<Integer>>> dst;
    //     Map<String, Set<Integer>> t;
    //     // TreeMap<Integer, Integer> mt;
    //     // Map<Integer, TreeMap<Integer, Integer>> mt; 
    //     Map<Integer, TreeMap<Integer, Map<Integer, Integer>>> mt; 
    //     Map<Integer, BIT> dq;
    //         int idx, n, m, cc;
    //     // public Router(int memoryLimit) {
    //         public cmp(int memoryLimit) {
    //         // n = 100001;
    //             n = 10;
    //         m = memoryLimit;
    //         q = new ArrayDeque<>();
    //         dst = new HashMap<>();
    //         t = new HashMap<>();
    //         mt = new HashMap<>();
    //         dq = new HashMap<>();
    //         idx = 1; cc = 0;
    //     }
    //     public boolean addPacket(int so, int de, int ti) {
    //         String k = String.valueOf(so) + "-" + String.valueOf(de);
    //         if (t.containsKey(k) && t.get(k).contains(ti)) return false;
    //         // mt.put(ti, idx++);
    //         mt.computeIfAbsent(de, z -> new TreeMap<Integer, Map<Integer, Integer>>());
    //         dq.computeIfAbsent(de, z -> new BIT(n)); //.update(idx-1, 1);
    //         if (mt.get(de).containsKey(ti)) {
    //             int idxx = mt.get(de).get(ti);
    //             dq.get(de).update(idxx, 1);
    //             mt.get(de).get(ti).put(idxx, mt.get(de).get(ti).getOrDefault(idxx, 0) + 1);
    //         } else {
    //             // mt.get(de).put(ti, idx);
    //             mt.get(de).computeIfAbsent(ti, z -> new HashMap<Integer, Integer>()).add(idx, 1);
    //                 // put(ti, idx);
    //             dq.get(de).update(idx, 1);
    //         }
    //         idx++;
    //         cc++;
    //       if (cc > m) {
    //           System.out.println("cc: " + cc);
    //             // q.pollFirst();
    //           forwardPacket();
    //             --cc;
    //         }
    //         q.offerLast(new int [] {so, de, ti});
    //         Map<Integer, Set<Integer>> cur = dst.get(de);
    //         if (cur == null) cur = new HashMap<Integer, Set<Integer>>();
    //         cur.computeIfAbsent(so, z -> new HashSet<Integer>()).add(ti);
    //         dst.put(de, cur);
    //         t.computeIfAbsent(k, z -> new HashSet<Integer>()).add(ti); 
    //         // dq.computeIfAbsent(de, z -> new BIT(n)).update(idx-1, 1);
    //         return true;
    //     }
    //     public int[] forwardPacket() {
    //         if (q.isEmpty()) return new int [] {};
    //         int [] cur = q.pollFirst();
    //         --cc;
    //         String k = String.valueOf(cur[0]) + "-" + String.valueOf(cur[1]);
    //         t.get(k).remove(cur[2]);
    //         dst.get(cur[1]).get(cur[0]).remove(cur[2]);
    //         if (mt.containsKey(cur[1]) && mt.get(cur[1]).containsKey(cur[2]) && dq.containsKey((cur[1])))
    //             dq.get(cur[1]).update(mt.get(cur[1]).get(cur[2]), -1);
    //         // mt.remove(cur[2]);
    //         mt.get(cur[1]).remove(cur[2]); // <<<<<<<<<<<<<<<<<<<< 
    //         return cur;
    //     }
    //     // 用BIT 字典；需要借助辅助字典压缩数据
    //     public int getCount(int destination, int startTime, int endTime) {
    //         if (!dq.containsKey(destination)) return 0;
    //         for (int key : mt.get(destination).keySet()) 
    //             System.out.println("key: " + key);
    //         Integer end = mt.get(destination).floorKey(endTime);
    //         Integer bgn = mt.get(destination).ceilingKey(startTime);
    //         System.out.println("bgn: " + bgn + " " + "end: " + end);
    //         if (bgn == null || end == null) return 0;
    //         return dq.get(destination).querySum(mt.get(destination).get(end), bgn == null ? 0 : mt.get(destination).get(bgn));
    //     }
    //     // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 感觉，它像是【区间型动规】，但是还没能想明白：怎么比较小区间前后的大小。。最小区间单位为[相邻的、2 个数]
        // public int minimumPairRemoval(int[] a) {
        //     int n = a.length;
        //     return 0;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minOperations(int[] a, int k) {
        //     int f = Arrays.stream(a).sum();
        //     return f % k;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这里【N:1-100000】取值比较大，但是【2^17 > 100000】
        // // 应该主要遍历：最多 17 个数位就可以了，那么算是O(17*17*17) ？
        // // 感觉上面，像是哪里还想得不对？？
        // // 最外层的 [<= n] 的数位遍历：需要一个特殊高效的遍历方法，那个破烂【选课】的（数位）遍历方法，从最大数 n 从最高位到低位遍历？
        // // 先写后面的题目 
        // public int uniqueXorTriplets(int[] a) {
        //     int n = a.length, m = Integer.highestOneBit(n);
        //     Set<Integer> s = new HashSet<>();
        //     return 0;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 说的是（无向图），感觉像是【根为1 的、有向图】! 当确定以【1 为根节点】，（无向图）就是【有向图】，需要自己辨别设置有向图的方向
        // // 【动规：树状动规】
        // // （自上向下的）线段树、懒标记？懒惰标记，可以【当且仅当， q[2,v]】的时候，再（DFS 自顶向下、下放懒惰标记）先不考虑这个思路，直接写，TLE 超时后再想【懒惰标记】
        // // 亲爱的表哥的活宝妹，觉得：现有的思路，【基本完整】，应该可以写出和通过这个题目的测试！
        // // 查【带懒惰标记的、线段树】写法
        // public int[] treeQueries(int n, int[][] egs, int[][] qs) {
        //     g = new HashMap[n]; this.n = n; m = (int)(Math.log(n-1)/Math.log(2)) + 1;
        //     Arrays.setAll(g, z -> new HashMap<Integer, Integer>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1], w = e[2];
        //         g[u].put(v, w);
        //         g[v].put(u, w);
        //     }
        //     // （无向图）变【有向图】：删除不必要的双向边, 并纪录初始路径和
        //     // 遍历【有向图】：纪录每个节点的2^j 个最近祖先的节点号
        //     g = new int [m][m];
        //     dfs(1, -1);  // 有向图，可以同步，更新纪录【祖先编号】吗？
        //     g[1][0] = -1;
        //     dfsP(1);
        //     // r: 用作【自定义、懒惰标记】, 标记狠好打、非树型更新：不太方便，所以要记 f[i][j] 每个节点的 17 个最近祖先的节点号，快速倍增查询
        //     f = new int [n+1], r = new int [n+1]; // 【树型动规】的状态记忆数组， f[1] ＝ 0
        //     List<Integer> l = new ArrayList<>();
        //     for (int [] q : qs) 
        //         if (q[0] == 1) {
        //             int u = q[1], v = q[2], w = q[3];
        //             if (q[3] == g[u].get(v)) continue; // 更新无效
        //             if (g[u].containsKey(v)) {
        //                 // 【TODO：】这里写得不对，太简单; 仅只在当前节点 v 所有父节点没有标记的情况下，可以直接打标记 r[v] ＝ w-g[u].get(v) 纪录，需要更新的差值
        //                 // （自底向上、最远到根节点1）查询最近父节点懒惰标记
        //                 // （自顶向下： pushDown 父节点中存在的、懒惰标记）至当前节点：父节点的（懒惰标记）部分下移
        //                 // 【TODO：】。。。
        //                 // r[v] = w-g[u].get(v);
        //                 g[u].put(v, w);
        //             } else { // g[v].containsKey(u)
        //                 // 【TODO：】。。。
        //                 r[u] = w - g[v].get(u);
        //                 g[v].put(u, w);
        //             }
        //         } else { // 2 query
        //             int u = q[1];
        //             // 【懒惰标记】：（自底向上）遍历父节点，查找可能存在的、最近懒惰标记，或有什么方法纪录？倍增法，可以记到各种的N 阶祖先。。
        //             // （向顶向下）：【懒惰标记】最小必要下移、更新、到当前查询节点
                    
        //         }
        // }
        // // 亲爱的表哥的活宝妹、这里，狠想把【无向图】根据边，直接建成：可以打（懒惰标记）的线段树！！！无向图可能有多个分支，线段树一般只有2 个左右分叉。。
        // // 亲爱的表哥的活宝妹，笨宝妹，上面的思路、不难实现：
        // // 【最近公共祖先】建立树的方式，适用于（多叉子节点）就可以实现了。。倍增法。。
        // // 【倍增法】：设 f[i][j] 为节点 i 向上走 2^j 步能走到的父节点，那么就有
        // // f[i][j] = f[f[i][j-1]][j-1]; 2^j = 2^(j-1)... 这里怎么看不懂了呢？
        // int [][] p; // 【最近公共祖先】：纪录，每个节点的、最多 17 级最近祖先，可以方便用来快速遍历
        // // 也可以， Set<Integer> s = new HashSet<>(); 用来记录 pushDown 懒惰标记的节点集合
        // // 可是，永远存在：【懒惰标记】，与查询时、必要的【懒惰标记追踪】之间的平衡
        // // 只打标记，就每个查询 q[i] 都要遍历每个节点的、最多17 个祖先；
        // // 不打标记，任何更新随时 pushDown 到所有叶节点, 根据 qs.length 可能也会性能浪费。。
        // // 【懒惰标记】＋每个 q[i] 查询祖先标记
        // // 【懒惰标记】标记方法：
        // // 【二维数组】定义：忘记了， f[i][j] ＝ f[i-1][j-1] ＋ f[i-1][j-1]?
        // Map<Integer, Integer> [] g;
        // // 如何使用【懒惰标记的、线段树】方法，就应该需要使用其它【动规、状态纪录方法，如线段树】
        // int [] f, r; // dist[Weight Path Sum] from root 1
        // int m, n;
        // void dfs(int u, int v) {
        //     g[u][0] = v; // g[1][0] = -1
        //     if (v != -1) // 遍历【子节点】时，移除（向父节点、无向边）变成有向图
        //         g[u].remove(v);
        //     for (int vv : g[u].keySet()) {
        //         // g[v].remove(u);
        //         f[vv] += f[u];
        //         dfs(vv, u);
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int findClosest(int x, int y, int z) {
        //     if (x <= z && y <= z)
       //         return x != y ? (x < y ? 2 : 1) : 0;
        //     if (x > z && y > z)
        //         return x != y ? (x < y ? 1 : 2) : 0;
        //     if (x < y) return z-x < y-z ? 1 : (z-x == y-z ? 0 : 2);
        //     return z-y < x-z ? 2 : (z-y == x-z ? 0 : 1);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public String smallestPalindrome(String S) {
        //     int n = S.length(), j = -1; char [] s = S.toCharArray();
        //     int [] f = new int [26];
        //     for (char c : s) {
        //         int i = c-'a';
        //         f[i]++;
        //     }
        //     StringBuilder ss = new StringBuilder();
        //     for (int i = 0; i < 26; i++) {
        //         if (f[i] == 0) continue;
        //         if (f[i] % 2 == 1) {
        //             j = i;
        //             if (f[i] == 1)
        //                 continue;
        //         }
        //         for (int k = 0; k < f[i] / 2; k++) 
        //             ss.append((char)(i+'a'));
        //     }
        //     int m = ss.length();
        //     for (int i = m-1; i >= 0; i--) 
        //         ss.append(ss.charAt(i));
        //     if (j != -1)
        //         ss.insert(m, (char)('a'+j));
        //     return ss.toString();
        // }

//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         // 这个破烂题目，不难，就是【狠琐碎】
//         // b:[2,10] 新生成的字符串，只可能涨长，不可能缩短，所以【转 Base】后，还得使用字符串
//         // 【左右、字符串、转Base】后，就转换成为（经典题型）：【数位动规：左右边界字符串】符合要求的个数，遍历数位、动规。。或【记忆化深搜】
//         // 写过的题目：有那个【左右串、非毒串】的个数，及其它【数位动规】相关。。
//         // 难点在【新Base:2-10】后的【左右串】比较长，状态【记忆数组、记忆状态的、数据结构】不太好定义
//         // 【目的 m <= n】：数【左、右】字符串界定的所有中间串里，数位值不降的个数
//         // 【记忆化深搜】（记忆数组、记忆状态）定义：
//         // Map<Integer, Integer> [] f;
//         static final int mod = (int)1e9 + 7;
//         public int countNumbers(String S, String T, int b) {
//             this.b = b;
//             if (b != 10) {
//                 S = getBasedString(S);
//                 T = getBasedString(T);
//             }
//             s = S.toCharArray(); t = T.toCharArray();
//             m = s.length; n = t.length;
//             System.out.println("S: " + S + " " + "T: " + T);
//             // 【字符串、返过来】比较好操作
// // 267 1314
// // 762 772 862 872 882 962 972 982 992 ...
// // 4131
//             f = new HashMap[n];
//             Arrays.setAll(f, z -> new HashMap<Integer, Integer>());
//             // m 位、以 s[0] 打头的、满足【不小于、左串】的、所有合法个数
//             long ans = 0;
//             ans = (ans + dfs(m-1, 1, s[m-1]-'0', 0)) % mod;
//             if (n > m) {
//                 // 这里少算结果了
//                 for (int j = s[m-1]-'0'; j < b; j++) {
//                     // System.out.println("j: " + j);
//                     // System.out.println("ans: " + ans);
//                     ans = (ans + dfs(m-1, 0, j, 0)) % mod; // <<<<<<<<<<<<<<<<<<<< 
//                     // System.out.println("ans: " + ans);
//                 }
//                 // for (int j = s[m-1]-'0'+1; j < b; j++) {
//                 //     // System.out.println("j: " + j);
//                 //     // System.out.println("ans: " + ans);
//                 //     ans = (ans + dfs(m-1, 0, j, 0)) % mod;
//                 //     // System.out.println("ans: " + ans);
//                 // }
//                 for (int i = m; i < n-1; i++)
//                     for (int j = 0; j < b; j++) 
//                         ans = (ans + dfs(i, 0, j, 0)) % mod;
//                         // dfs(i, 0, j);
//                 for (int j = 1; j <= t[n-1]-'0'; j++) {
//                     // System.out.println("j: " + j);
//                     // System.out.println("ans: " + ans);
//                     ans = (ans + dfs(n-1, 0, j, (j == t[n-1]-'0' ? 1 : 0))) % mod;
//                     // System.out.println("ans: " + ans);
//                 }
//             } else // n == m
//                 for (int j = s[m-1]-'0'+1; j <= t[m-1]-'0'; j++) {
//                     ans = (ans + dfs(m-1, 0, j, (j == t[m-1]-'0' ? 1 : 0))) % mod;
//                 }
//             // 结果：把字典【m-1,n-1】下所有合法值。累加求和，返回?
//             return (int)ans;
//         }
//         Map<Integer, Integer> [] f;  // 【n】个不同数位打头的、不同（当前、最高最显著位上、数值为[0,b-1] 等子状态）的合法个数
//         char [] s, t;
//         int m, n, b;
//         int dfs(int i, int j, int k, int y) { // 状态里，前一显著位的值？
//             System.out.println("\ni: " + i + " " + "j: " + j + " k: " + k + " y: " + y);
//             // System.out.println("\ni: " + i + " " + "j: " + j);
//             // 【写错了】：需要检查当前位的合法性
//             // 【TODO：】甚至：区分 j 在ST 左右串的不同，就是 j 匹配左串， k 匹配右串，用2 个不同数位来记 jk 这两个状态 
//             // if (i == 0) return 0;
//             if (i == 0) { // 【TODO：】这里脑袋昏昏、今天不想这个破烂题目了
//                 // return 1;
//                 int v = ((j == 1 && s[0]-'0' >= k
//                           || y == 1 && t[0]-'0' <= k || j != 1 && y != 1) ? 1 : 0);
//                 System.out.println("v: " + v);
//                 return v;
//             }
//             int curKey = ((j << 6) | (y << 5) | k);
//             if (f[i].containsKey(curKey)) return f[i].get(curKey);
//             // 遍历：下一个不显著位的、【合法、取值范围】
//             int l = k, r = b-1; // l: 这里缺省，不记0 打头的，需要时再数 0 打头的
//             if (j == 1) {
//                 if (i == m-1) {
//                     l = Math.max(s[i]-'0', k);
//                     r = (n > m ? b-1 : t[i]-'0');
//                 } else { // i == n-1
//                     r = t[i] - '0';
//                 }
//             } else if (y == 1) {
//                 r = Math.min(b-1, t[i]-'0');
//             }
//             System.out.println("l: " + l + " " + "r: " + r);
//             long ans = 0;
//             for (int x = l; x <= r; x++) {
//                 int key = ((j == 1 && i == m-1 && (x == l || x == r) ? (1 << 6) : 0)
//                            | (y == 1 && i == n-1 && x == r ? (1 << 5) : 0)
//                            | x);
//                 if (f[i-1].containsKey(key))
//                     ans = (ans + f[i-1].get(key)) % mod;
//                 else ans = (ans + dfs(i-1, (j == 1 && i == m-1 && (x == l || x == r) ? 1 : 0), x, (y == 1 && i == n-1 && x == r ? 1 : 0))) % mod;
//             }
//             f[i].put(curKey, (int)ans);
//             System.out.println("\ni: " + i + " " + "j: " + j + " k: " + k + " y: " + y);
//             System.out.println("ans: " + ans);
//             return (int)ans;
//         }
//         String getBasedString(String S) {
//             int n = S.length(), r = 0; char [] f = S.toCharArray();
//             long v = 0, base = 1;
//             for (int i = n-1; i >= 0; i--) {
//                 v += (long)(base * (f[i]-'0'));
//                 base *= 10;
//             }
//             StringBuilder s = new StringBuilder();
//             while (v > 0) {
//                 s.insert(0, (char)('0'+ v % b));
//                 v = v / b;
//             }
//             return s.reverse().toString();
//         }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long calculateScore(String[] f, int[] a) {
        //     long ans = 0;
        //     int n = f.length, i = 0;
        //     boolean [] r = new boolean [n];
        //     while (i >= 0 && i < n && !r[i]) {
        //         r[i] = true;
        //         if (f[i].equals("add")) {
        //             ans += a[i];
        //             i++;
        //         } else 
        //             i += a[i];
        //     }
        //     return ans;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maximumPossibleSize(int[] a) {
        //     int n = a.length, f = n, j = 0, p = a[0];
        //     for (int i = 1; i < n; i++) {
        //         if (a[i] >= p) {
        //             p = a[i];
        //             continue;
        //         }
        //         --f;
        //         j = i+1;
        //         while (j < n && a[j] < p) {
        //             f--;
        //             j++;
        //         }
        //         if (j == n) return f;
        //         p = a[j];
        //         i = j;
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 破烂题目、恶心吧啦：【分解质因子】
        // public long [] resultArray(int[] a, int k) {
        //     n = a.length; this.a = a; this.k = k; 
        //     f = new int [n][k+1]; // [235] 三个质因子，但为写得方便，就【012345】
        //     prep();
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z)
        //         System.out.println(Arrays.toString(f[z]));
        //     // 然后，亲爱的表哥的活宝妹，就不知道该怎么去想后面的了。。。狠讨厌这类恶心死人不偿命的破烂题目
        //     // 亲爱的表哥的活宝妹，讨厌这类题目，再不想看了，下周再写
        //     // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        //     return new long [0];
        // }
        // int [][] f; int n, k; int [] a;
        // void prep() {
        //     int i = 0, vv = 0;
        //     for (int v : a) {
        //         for (int j = k; j > 1; j--) {
        //             vv = v;
        //             while (vv >= j && vv % j == 0) {
        //                 f[i][j]++;
        //                 vv /= j;
        //             }
        //         }
        //         i++;
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countCoveredBuildings(int n, int[][] f) {
        //     TreeMap<Integer, TreeSet<Integer>> m = new TreeMap<>();
        //     for (int [] a : f) {
        //         int i = a[0], j = a[1];
        //         m.computeIfAbsent(i, z -> new TreeSet<Integer>()).add(j);
        //         m.computeIfAbsent(-j, z -> new TreeSet<Integer>()).add(i);
        //     }
        //     int r = 0;
        //     for (int [] a : f) {
        //         int i = a[0], j = a[1];
        //         if (m.get(i).size() < 3 || m.get(-j).size() < 3) continue;
        //         // 它要【四个方向】上都至少有一个楼
        //         Integer li = m.get(-j).lower(i), hi = m.get(-j).higher(i), lj = m.get(i).lower(j), hj = m.get(i).higher(j);
        //         if (li != null && hi != null && lj != null && hj != null) 
        //             r++;
        //     }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，觉得：这好像是【连通图】 UnionFind
        // public class UF {
        //     int [] f;
        //     int n;
        //     public UF(int n) {
        //         this.n = n;
        //         f = new int [n];
        //         for (int i = 0; i < n; i++) f[i] = i;
        //     }
        //     public int find(int i) {
        //         if (i != f[i])
        //             f[i] = find(f[i]);
        //         return f[i];
        //     }
        //     public void merge(int i, int j) {
        //         int fi = find(i), fj = find(j);
        //         if (fi != fj) 
        //             f[i] = fj;
        //     }
        //     public boolean sameComponent(int i, int j) {
        //         return find(i) == find(j);
        //     }
        // }
        // public boolean[] pathExistenceQueries(int n, int[] a, int d, int[][] qs) {
        //     int m = qs.length, j = 0;
        //     UF uf = new UF(n);
        //     for (int i = 1; i < a.length; i++) {
        //         while (j < i && a[i] - a[j] > d) j++;
        //         if (j < i) uf.merge(i, j);
        //     }
        //     boolean [] f =  new boolean [m];
        //     j = 0;
        //     for (int[] q : qs) {
        //         int u = q[0], v = q[1];
        //         if (uf.sameComponent(u, v)) f[j] = true;
        //         j++;
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 跟上面的题目狠像，稍微变动了一下
        // // 亲爱的表哥的活宝妹，觉得：这好像是【连通图】 UnionFind
        // public class UF {
        //     int [] f, r;
        //     int n;
        //     public UF(int n) {
        //         this.n = n;
        //         f = new int [n]; r = new int [n];
        //         for (int i = 0; i < n; i++) f[i] = i;
        //         // Arrays.fill(r, 1);
        //     }
        //     public int find(int i) {
        //         if (i != f[i])
        //             f[i] = find(f[i]);
        //         return f[i];
        //     }
        //     // 这里Merge 的时候，最好维护【最小高度、平衡树，达到最高效O(logN) 查询】
        //     public void merge(int i, int j) {
        //         int fi = find(i), fj = find(j);
        //         if (fi == fj) return ;
        //         if (r[fi] > r[fj])
        //             f[fj] = fi;
        //         else if (r[fi] < r[fj])
        //             f[fi] = fj;
        //         else {
        //             f[fi] = fj;
        //             r[fj]++;
        //         }
        //     }
        //     public boolean sameComponent(int i, int j) {
        //         return find(i) == find(j);
        //     }
        // }
        // public int[] pathExistenceQueries(int n, int[] a, int d, int[][] qs) {
        //     int m = qs.length, j = 0;
        //     UF uf = new UF(n);
        //     List<int []> l = new ArrayList<>();
        //     for (int v : a) 
        //         l.add(new int [v, j++]);
        //     Collections.sort(l, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     for (int i = 1; i < a.length; i++) {
        //         while (j < i && l.get(i) - l.get(j) > d) j++;
        //         if (j < i) uf.merge(l.get(i)[1], l.get(j)[1]);
        //     }
        //     int [] f =  new int [m]; Arrays.fill(f, -1);
        //     // 【TODO：】感觉，这个 qs 也需要【带下标、排序一下】？
        //     // 不知道：【连通块内、两节点间的、最小距离】要怎么算，如果每个 qs-i 都【Dijango】最小距离一次，感觉会超时 TLE
        //     j = 0;
        //     for (int[] q : qs) {
        //         int u = q[0], v = q[1];
        //         if (!uf.sameComponent(u, v)) continue;
        //         // 求【连通块内、两节点间的、最小距离】
        //         j++;
        //     }
        //     return f;
        // }

        //  // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxProduct(int n) {
        //     int [] f =  new int [10];
        //     String s = String.valueOf(n);
        //     for (char c : s.toCharArray()) 
        //         f[c-'0']++;
        //     int r = -1;
        //     for (int i = 9; i >= 0; i--) {
        //         if (f[i] == 0) continue;
        //         if (f[i] > 1) return (r == -1 ? i * i : i * r);
        //         else if (f[i] == 1 && r > -1) return r * i;
        //         else r = i;
        //     }
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        //  // 妈的。。好像，亲爱的表哥的活宝妹前几天刚看【游戏场景、所使用的数据结构的、四叉权与八叉树】
        //  // 需要写一个，类似【recursive】的方法，分四个象限来填充正方块里的数字
        // public int[][] specialGrid(int N) {
        //     n = (int)Math.pow(2, N); m = n / 2;
        //     if (N == 0) return new int [][] {{0}};
        //     if (N == 1) return new int [][] {{3, 0}, {2, 1}};
        //     f = new int [n][n];
        //     quadFill2DArray(0, n * n -1, n, 0, 0);
        //     return f;
        // }
        // int [][] f;
        // int m, n;
        // void quadFill2DArray(int l, int r, int nn, int i, int j) {
        //     // 一个格
        //     if (l == r && nn == 1) {
        //         f[i][j] = l;
        //         return ;
        //     }
        //     // 四个格
        //     if (r - l == 3 && nn == 2) {
        //         f[i][j+1] = l;
        //         f[i+1][j+1] = l + 1;
        //         f[i+1][j] = l + 2;
        //         f[i][j] = r;
        //         return ;
        //     }
        //     quadFill2DArray(l, l + nn * nn/4-1, nn/2, i, j+nn/2);
        //     quadFill2DArray(l + nn * nn/4, l + nn * nn / 2 - 1, nn/2, i+nn/2, j+nn/2);
        //     quadFill2DArray(l + nn * nn / 2, l + nn * nn / 4 * 3 -1, nn/2, i+nn/2, j);
        //     quadFill2DArray(r - nn * nn / 4+1, r, nn/2, i, j);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 狗屁【动规、区间型动规】：应该主要是考题型；想透彻能写出来的话，应该不至少TLE 超时
        // public int minTravelTime(int l, int n, int k, int[] a, int[] t) {
        //     this.n = n; this.k = k; this.a = a; this.t = t;
        //     // 【动态更新】：当某个【下标移除】后，用下标来标记，就存在局限。。
        //     // 不用【动规】思路，用【贪心、或是、递推】，因为更新下标的【实时、与、后续】效应，这个状态定义、记忆数组？仍然不对。。
        //     // int [][][] f = new int [n][n][k+1];
        //     // Arrays.setAll(f, z -> new HashMap<Integer, Integer>());
        //     //   j             i             k      val
        //     // Map<Integer, Map<Integer, Map<Integer, Integer>>> f = new HashMap<>();
        //     TreeMap<Integer, TreeMap<Integer, Integer>> f = new TreeMap<>();
        //     Map<Integer, Integer> updates = new HashMap<>(); // 纪录实时更新的？
        //     for (int i = 0; i < n; i++)
        //         updates.put(a[i], t[i]);
        //     for (int j = 0; j < n; j++) {
        //         // f[j][j][0] = t[j] * ((j == n-1 ? a[j] : a[j+1]) - a[j]);
        //         f.computeIfAbsent(a[j], z -> new TreeMap<Integer, Integer>>())();
        //         // Map<Integer, Integer> tmp = new HashMap<>();
        //         // tmp.put(0, j < n-1 ? t[j] * (a[j+1] - a[j]) : 0);
        //         f.get(a[j]).put(0, j < n-1 ? t[j] * (a[j+1] - a[j]) : 0);
        //         // 遍历：前序下标 i, 和【操作次数 K】
        //         Integer lo = f.lowerKey(a[i]);
        //         while (lo != null) {
        //             // 遍历：【操作次数 k: 从小到大】
        //             for (Map.Entry<Integer, Integer> en : f.get(lo).entrySet()) {
        //                 int key = en.getKey(), v = en.getValue();
        //                 // 上一个【lo,ti】是否更新过？
        //                 int cur = v + updates.get(lo) * (a[j] - lo);
        //                 f.get(a[j]).put(key, cur);
        //                 if (j > 0 && j < n-1 && key < j-1) {
        //                     // 在【当前位点 j】作一次合并、与实时更新。。。【TODO：】后面的细节没有写完。。                            
        //                     cur = f.get(lo).get(key-1) + updates.get(lo) * (a[j+1] - lo);
        //                 }
        //             }
        //             lo = f.lowerKey(lo);
        //         }
        //         // for (int i = 0; i < n-1; i++) {
        //         //     f[i][i][0] = t[i] * (a[i+1] - a[i]);
        //         //     f[i].put(a[i], (i == 0 ? 0 : f[i-1].get(a[i-1])) + t[i] * (a[i+1] - a[i]));
        //         //     // f.computeIfAbsent(a[i], z -> new HashMap<Integer, Map<Integer, Integer>>())();
        //         //     // Map<Integer, Integer> tmp = new HashMap<>();
        //         //     // tmp.put(0, t[i] * (a[i+1] - a[i]));
        //         //     // f.get(a[i]).put(0, tmp);
        //         //     // 这里是【极简：0 次操作】的
        //         //     if (i > 0) // f[0][1][0] = f[0][0][0] + f[1][1][0] + ..
        //         //         f[i-1][i][0] = f[0][i-1][0] + f[i][i][0] + t[i-1] * (a[i] - a[i-1]);
        //         //     // 遍历：前序下标 j, 和【操作次数 K】
        //         // }
        //     // return dfs(0, n-1, k);
        // }
        // Integer [][][] f;
        // int [] a, t;
        // int n, k;
        // int dfs(int i, int j, int k) {
        //     // if (i == j && k == 0)
        //     //     return
        //     // 没有操作、不操作
        //     if (k == 0) {
        //         int r = 0;
        //         for (int x = i; x < j; x++) {
        //             r += (a[x+1] - a[x]) * t[x];
        //             return f[i][j][k] = r;
        //         }
        //     }
        //         // 【叶子节点】：处理合并操作;
        //     // 【动规？】这里【子问题】的处理，有后续效应，可能不能用【动规】，用【贪心】。。
        //     if (i+1 == j && k == 1) {
        //         return t[i-1] * (a[j] - a[i]) + t[i] * 
        //             (a[j] - a[i]) * t[i]
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个题目，读不懂，感觉 k==m 永恒。。。想不出：什么情况下会可能 k != m
        // // 题目有点儿烦琐：N[1,50], k==m[1,30]
        // // 是【序列】，没有说【数组不能排序】，（数组应该就可以排序、简化重复数字的处理？）
        // // 当k==m[1,30], 数组规模仍然相对大，得对半分、分成：2 个 k/2==m/2【1,15】规模级的O(NlogN) 解法？
        // // 思路：想不透彻，不写这个破烂题目了。。
        // static final int mod = (int)1e9 + 7;
        // public int magicalSum(int m, int k, int[] a) {
        //     int n = a.length;
        //     Arrays.sort(a);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxFreqSum(String T) {
        //     int n = T.length(); char [] s = T.toCharArray();
        //     int [] f = new int [26];
        //     for (char c : s) 
        //         f[c-'a']++;
        //     List<Character> cs = List.of('a', 'e', 'i', 'o', 'u');
        //     int l = 0, r = 0;
        //     for (int i = 0; i < 26; i++) 
        //         if (cs.contains((char)(i+'a')))
        //             l = Math.max(l, f[i]);
        //         else r = Math.max(r, f[i]);
        //     return l + r;
        // }


        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minOperations(int[] f) {
        //     n = f.length; this.f = f; 
        //     // 亲爱的表哥的活宝妹，这里，没读懂题目
        //     // return (int)Arrays.stream(a).distinct().count() - (Arrays.stream(a).min().getAsInt() == 0 ? 1 : 0);
        //     return getOps(0, n-1);
        // }
        // int [] f;
        // int n;
        // int getOps(int i, int j) {
        //     System.out.println("\ni: " + i + " " + "j: " + j);
        //     if (Arrays.stream(f).max().getAsInt() == 0) return 0;
        //     if (i == j) return (f[i] > 0 ? 1 : 0);
        //     int min = Integer.MAX_VALUE;
        //     int k = i;
        //     while (j >= i && f[j] == 0) j--;
        //     if (j < i) return 0;
        //     while (k <= j && f[k] == 0) k++;
        //     if (k == j) return 1;
        //     i = k;
        //     for (; k <= j; k++)
        //         if (f[k] > 0)
        //             min = Math.min(min, f[k]);
        //     k = i;
        //     int ans = 0;
        //     for (; k <= j; k++) {
        //         if (f[k] == min || f[k] == 0) {
        //             System.out.println("k: " + k);
        //             ans += (k == i ? 0 : getOps(i, k-1));
        //             System.out.println("ans: " + ans);
        //            i = k + (k == j ? 0 : 1);
        //         }
        //     }
        //     if (f[j] != min)
        //         ans += getOps(i, j);
        //     return  ans+1;
        // }
        // // 晚点儿再写这个
        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】： f[i][j] 定义？
        // // 如果【自底向上】 i 叶子节点的【父节点】，可能不止1 个。。
        // public int maxWeight(int n, int[][] egs, int k, int t) { // TLE TLE TLE
        //     g = new ArrayList[n]; this.n = n; this.k = k; this.t = t; 
        //     Arrays.setAll(g, z -> new ArrayList<int[]>());
        //     // 【根节点】：是哪个
        //     int [] r = new int [n];
        //     boolean [] vis = new boolean [n];
        //     List<Integer> roots = new ArrayList<Integer>();
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1], w = e[2];
        //         g[u].add(new int [] {v, w});
        //         r[v]++;
        //         vis[u] = true;
        //     }
        //     int u = -1;
        //     for (int i = 0; i < n; i++)
        //         if (r[i] == 0 && vis[i])
        //             roots.add(i);
        //     // 没有说，【必须从根节点出发】
        //     if (roots.size() == 0) return (k == 0 ? 0 : max);
        //     f = new int [n][k+1];
        //     for (int v : roots) 
        //         dfsMaxKt(v, 0, 0);
        //     return max;
        // }
        // List<int []> [] g;
        // int [][] f;
        // int n, max = -1, k, t;
        // void dfsMaxKt(int u, int d, int wi) {
        //     // 【终节点】：全局最值            
        //     if (d == k) {
        //         // System.out.println("u: " + u + " " + "wi: " + wi);
        //         if (wi < t)
        //             max = Math.max(max, wi);
        //         return;
        //     }
        //     for (int [] e : g[u]) {
        //         int v = e[0], w = e[1];
        //         dfsMaxKt(v, 0, 0);
        //         if (wi + w >= t) continue;
        //         dfsMaxKt(v, d+1, wi+w);
        //     }
        //     // for (int [] e : g[u]) {
        //     //     int v = e[0], w = e[1];
        //     //     dfsMaxKt(v, 0, 0);
        //     // }
        // }
        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long subtreeInversionSum(int[][] egs, int[] a, int k) {
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minDeletion(String S, int k) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     int [] f = new int [26];
        //     for (char c : s) 
        //         f[c-'a']++;
        //     List<Integer> l = new ArrayList<>();
        //     for (int v : f) 
        //         if (v > 0)
        //             l.add(v);
        //     Collections.sort(l, (x, y)->y-x);
        //     if (l.size() <= k) return 0;
        //     int r = 0;
        //     for (int i = l.size()-1; i >= k; i--) 
        //         r += l.get(i);
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean canPartitionGrid(int[][] f) {
        //     int m = f.length, n = f[0].length, v = 0;
        //     int [] r = new int [m], c = new int [n];
        //     for (int i = 0; i < m; i++) {
        //         r[i] = Arrays.stream(f[i]).sum();
        //         if (i > 0)
        //             r[i] += r[i-1];
        //     }
        //     for (int i = 0; i < n; i++) {
        //         v = 0;
        //         for (int j = 0; j < m; j++)
        //             v += f[j][i];
        //         c[i] = v;
        //         if (i > 0)
        //             c[i] += c[i-1];
        //     }
        //     for (int i = 0; i < m-1; i++)
        //         if (r[i] == r[m-1] - r[i]) return true;
        //     for (int i = 0; i < n-1; i++)
        //         if (c[i] == c[n-1] - c[i]) return true;
        //     return false;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 先【检测：环的存在】；再分布其它: 一条线;
        // // 只有【1 个或几个、独立的团环，和或，1 条或几条直线】算【1,n】的分布，求边和最大值
        // public long maxScore(int n, int[][] egs) {
        //     this.n = n;
        //     g = new ArrayList [n];
        //     f = new int [n];
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //         f[u]++;
        //         f[v]++;
        //     }
        //     vis = new boolean [n];
        //     ans = 0;
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         if (f[i] == 2)
        //             l.add(i);
        //     cur = n;
        //     for (int v : l) 
        //         if (!vis[v]) dfs(v, -1, new ArrayList<Integer>(), new boolean [n]);
        // }
        // List<Integer> [] g;
        // int [] f;
        // boolean [] vis;
        // int n, ans, cur;
        // void dfs(int u, int p, List<Integer> l, boolean [] vi) {
        //     vi[u] = true;
        //     l.add(u);
        //     for (int v : g[u]) {
        //         if (v != p && vi[v]) { // 检测到一个环
        //             for (int node : l) {
        //                 vis[node] = true;
        //             }
        //         }
        //     }
        // }
        // long getVal(int v, int m) {
        //     int pp = -1, p = v; // pp p
        //     long f = 0;
        //     while (m > 1) {
        //         f += (long)(v * (v + 1));
        //         pp = p;
        //         p = v;
        //         // if (r == -1) r = v;
        //         // else if (l == -1) l = v;
        //         v--;
        //         m--;
        //     }
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 跟前面的狠像，只多一步【纪录格里数字的出现与否、与出现的位置】 BIT
        // 考虑【重复出现的数字】
        public boolean canPartitionGrid(int[][] f) { // 681/682 testcases passed 不知道最后2 个数据量狠大的测试用命算是怎么回事。。
            int m = f.length, n = f[0].length; long v = 0;
            Map<Long, TreeMap<Integer, Integer>> mp = new HashMap<>(); 
            for (int i = 0; i < f.length; i++) 
                for (int j = 0; j < n; j++) {
                    mp.computeIfAbsent((long)f[i][j], z -> new TreeMap<Integer, Integer>());
                    mp.get((long)f[i][j]).put(i, j);
                    mp.get((long)f[i][j]).put(-j, i);
                }
            long [] r = new long [m], c = new long [n];
            for (int i = 0; i < m; i++) {
                v = 0;
                for (int j = 0; j < n; j++)
                    r[i] += (long)f[i][j];
                if (i > 0)
                    r[i] += r[i-1];
            }
            for (int i = 0; i < n; i++) {
                v = 0;
                for (int j = 0; j < m; j++)
                    v += (long)f[j][i];
                c[i] = v;
                if (i > 0)
                    c[i] += c[i-1];
            }
            for (int i = 0; i < m-1; i++) {
                long lt = r[i], rt = r[m-1] - r[i];
                if (r[i] == r[m-1] - r[i]) return true;
                long dif = Math.abs(lt - rt);
                if (mp.containsKey(dif) && mp.get(dif).size() > 0) { 
                    Integer lo = mp.get(dif).floorKey(i), hi = mp.get(dif).ceilingKey(i+1);
                    if (lt > rt && lo != null && i > 0
                        || lt < rt && hi != null && (hi > i+1 || m > i+2 || n == 2))
                        return true;
                }
            }
            for (int i = 0; i < n-1; i++) {
                if (c[i] == c[n-1] - c[i]) return true;
                long lt = c[i], rt = c[n-1] - c[i];
                long dif = Math.abs(lt - rt);
                if (mp.containsKey(dif) && mp.get(dif).size() > 0) { 
                    Integer lo = mp.get(dif).ceilingKey(-1 * i), hi = mp.get(dif).floorKey(-1 * (i+1));
                    if (lt > rt && lo != null && i > 0
                        || lt < rt && hi != null && (hi < -1 * (i+1) || n > i+2 || m == 2))
                        return true;
                }
            }
            return false;
        }
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
        public static void main (String[] args) { 
		Solution s = new Solution ();

        // int []  a = new int []  {7,2,0,4,2};
        // System.out.println(Arrays.toString(a));
        // int r = s.minOperations(a);

        int [][] a = new int [][] {{4, 3, 7},{5, 3, 3}};

    boolean r = s.canPartitionGrid(a);
    System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a0]);  
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】