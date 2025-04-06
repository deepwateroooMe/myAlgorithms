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
// public class cmp {
    // public static class Solution {
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
    // }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
		// Solution s = new Solution ();
        cmp s = new cmp (2);

        boolean r = s.addPacket(5, 3, 1);
        System.out.println("r: " + r);
        r = s.addPacket(1, 5, 6);
        System.out.println("r: " + r);
        // r = s.addPacket(1,4,90);
        // System.out.println("r: " + r);
        // r = s.addPacket(3,5,95);
        // System.out.println("r: " + r);
        // int [] rr = s.forwardPacket();
        // System.out.println(Arrays.toString(rr));
        // r = s.addPacket(4,5,105);
        // System.out.println("r: " + r);
        // r = s.addPacket(5,2,110);
        // System.out.println("r: " + r);
        int rrr = s.getCount(3, 3, 3);
        System.out.println("rrr: " + rrr);
        // rrr = s.getCount(5, 2, 3);
        // System.out.println("rrr: " + rrr);

        // int r = s.minimumPairRemoval(a);
        // System.out.println("r: " + r);
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