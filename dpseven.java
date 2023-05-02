import com.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map.Entry;
import java.math.BigInteger;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
public class dpseven {
    public static class Solution {

//         static final int mod = (int)1e9 + 7;
//         public int profitableSchemes(int n, int t, int[] g, int[] p) { // 【记忆化深搜：】数据规模狠小，我可以暴搜之。。。// TLE TLE TLE: 就搞不懂，为什么它就会超时？
//             m = g.length; this.n = n; this.g = g; this.p = p; this.t = t; 
//             return dfs(n, 0, 0);
//         }
//         Map<String, Integer> f = new HashMap<>();
//         int [] g, p;
//         int n, m, t;
//         int dfs(int i, int j, int k) {
//             if (i <= 0 || j == m) return k < t ? 0 : 1; // 没窃贼可用了
//             // if (k >= t) return 1; // 这样不对，没有遍历到尾巴，计数可能远不止 1 种，好多种。。。
//             String key = i + "-" + j + "-" + k;
//             if (f.containsKey(key)) return f.get(key);
//             long ans = dfs(i, j+1, k); // 放弃，第 j 个案件，不作此案
//             if (i >= g[j]) // 作案前提：此案参案人数得足够
//                 ans = (ans + dfs(i - g[j], j+1, k + p[j])) % mod; // 第 j 件案：参与了
//             f.put(key, (int)ans);
//             return (int)ans;
//         }
//         static final int mod = (int)1e9 + 7; // TODO TODO TODO: 用动规，仍然不熟悉，瓣不出来。。。
//         public int profitableSchemes(int n, int t, int[] g, int[] p) { // 【动规：】应该就是个最基本的动规题型，可是为什么会没有思路呢？
//             int m = g.length;
//             int [][][] f = new int [m][n][t+1]; // 【自顶向下：】所有的参数用最压缩的空间，应该不会暴栈。。。
//             f[0][0][0] = 1;
//             for (int i = 0; i < m; i++) // 遍历案件
//                 for (int j = 0; j + g[i] < n; j++) // 遍历可用人选方案
//                     for (int k = 0; k + p[i] <= t; k++) // 这里糊涂：统计少了吗？
//                         f[i][j+g[i]][k+p[i]] = (f[i][j+g[i]][k+p[i]] + f[i][j][k]) % mod;
//             return f[m-1][n-1][t];
//         }

//         public int maxStudents(char[][] a) { // 1349
//             int m = a.length, n = a[0].length;
//             int [] l = new int [m];
//             for (int i = 0; i < m; i++) {
//                 int r = 0;
//                 for (int j = 0; j < n; j++)
//                     if (a[i][j] != '#') r |= (1 << j);
//                 l[i] = r ;
//             }
//             for (int i = 0; i < m; i++)
//                 System.out.println("Integer.toBinaryString(l[i]): " + Integer.toBinaryString(l[i]));
//             int [][] f = new int [m][1 << n];
//             // 【第一行】：当作初始化来处理
//             for (int j = l[0]; j > 0; j = l[0] & (j - 1))
//                 f[0][j] = Integer.bitCount(j);
//             // 【第2-m 行】：动态更新
//             for (int i = 1; i < m; i++) // 遍历行
//                 // for (int j = l[i-1]; j >= 0; j = l[i-1] & (j - 1)) // 遍历前一行的所有坐位方案
//                 for (int j = 0; j < (1 << n); j++) 
//                     for (int k = l[i]; k > 0; k = l[i] & (k - 1)) // 遍历当前行的所有【候选】坐位方案：检查是否可以抄作业
//                         if ((j & (k << 1)) == 0 && (j & (k >> 1)) == 0)
//                             f[i][k] = Math.max(f[i][k], f[i-1][j] + Integer.bitCount(k));
//             System.out.println("f.length: " + f.length);
//             for (int z = 0; z < f.length; ++z) 
//                 System.out.println(Arrays.toString(f[z]));
//             return f[m-1][(1 << n) - 1]; // 这里结果统计得不对：因为有行一个人也不能坐，那再前一行的结果该如何计入总结果的？
//         }
//         char [][] a = new char [][] {{'#','.','#','#','.','#'},{'.','#','#','#','#','.'},{'#','.','#','#','.','#'}};
//         int r = s.maxStudents(a);

//         public long sellingWood(int m, int n, int[][] a) { // 比较繁琐一点儿，改天再写 2312
//             this.m = m; this.n = n; this.a = a; 
//             Arrays.sort(a, (x, y) -> x[0] != y[0] ? y[0] - x[0] : y[1] - x[1]);
//             f = new Integer [m+1][n+1];
//             return dfs(m, n);
//         }
//         Integer [][] f;
//         int [][] a;
//         int m, n;
//         int dfs(int i, int j) {
//             if (i <= 0 ||  j <= 0) return 0;
//             // 终止条件：这里应该还有更多：
//             if (f[i][j] != null) return f[i][j];
//             int ans = 0;
//             // 先找最大块的下标
//             int k = binarySearch()
//         }
//         int binarySearch()

//         public String largestNumber(int[] a, int k) {  // TLE TLE TLE: 85/96
//             this.a = a; this.k = k; n = a.length; min = Arrays.stream(a).min().getAsInt();
//             f = new String [k+1];
//             String ans = dfs(k);
//             return ans == null ? "0" : ans;
//         }
//         String [] f;
//         int n, k, min; int [] a;
//         String dfs(int i) {
//             if (i == 0) return f[i] = "";
//             if (f[i] != null) return f[i];
//             String ans = null;
//             for (int j = n-1; j >= 0; j--) 
//                 if (a[j] <= i && (i == a[j] || i >= a[j] + min)) {
//                     String next = dfs(i - a[j]), cur = "";
//                     if (next != null)
//                         cur = "" + (char)('0' + j+1) + next;
//                     else cur = null;
//                     if (cur != null) 
//                         if (ans == null || cur.length() > ans.length() || ans.compareTo(cur) < 0) ans = cur;
//                 }
//             return f[i] = ans;
//         }
//         public String largestNumber(int[] a, int k) { // TLE TLE TLE: 85/96
//             this.a = a; this.k = k; n = a.length; min = Arrays.stream(a).min().getAsInt();
//             f = new String [k+1];
//             String ans = dfs(k);
//             return ans == null ? "0" : ans;
//         }
//         String [] f;
//         int n, k, min; int [] a;
//         String dfs(int x) {
//             if (x == 0) return f[x] = "";
//             if (f[x] != null) return f[x];
//             String ans = null;
//             for (int j = n-1; j >= 0; j--) {
//                 int i = x;
//                 if (a[j] <= i && (i % a[j] == 0 || i % a[j] >= min)) {
//                     String next = dfs(i % a[j]), cur = null;
//                     if (next != null) {
//                         cur = "";
//                         for (int y = 0; y < i / a[j]; y++)
//                             cur += (char)('0' + j+1);
//                         cur += next;
//                     }
//                         // cur = ((char)('0' + j+1)).repeat(i / a[j]) + next;
//                     else cur = null;
//                     if (cur != null) {
//                         System.out.println("cur: " + cur);
//                         if (ans == null || cur.length() > ans.length() || ans.compareTo(cur) < 0) ans = cur;
//                     }
//                 }
//             }
//             return f[x] = ans;
//         }

//         public int minTaps(int n, int[] a) { // TODO TODO TODO: 暂时不想再写这个题目了
//             int m = a.length;
//             List<int []> l = new ArrayList<>();
//             for (int i = 0; i < m; i++) 
//                 l.add(new int [] {i - a[i], i + a[i]});
//             Collections.sort(l, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
//             for (int i = 0; i < m; i++)
//                 System.out.println(Arrays.toString(l.get(i)));
//             int ans = 1, j = 1, r = l.get(0)[1], left = Math.max(0, l.get(0)[0]), newRit = 0;
//             while (r < n) {
//                 System.out.println("\n r: " + r);
//                 while (j < m && l.get(j)[0] <= left) { // 左端点不变：右端点可以扩展的最右端
//                     r = Math.max(r, l.get(j)[1]);
//                     if (r >= n) return ans;
//                     j++;
//                 }
//                 if (r >= n) return ans;
//                 if (j == m || l.get(j)[0] > r) return -1;
//                 ans++;
//                 // System.out.println("r: " + r);
//                 // System.out.println("j: " + j);
//                 while (j < m && l.get(j)[0] <= r) {
//                     newRit = Math.max(newRit, l.get(j)[1]);
//                     if (newRit >= n) return ans;
//                     j++; // 过滤掉中间可以不用的
//                 }
//                 if (l.get(j)[1] >= n) return ans;
//                 left = l.get(j)[0];
//             }
//             return -1;
//         }

//         public int[] smallestSufficientTeam(String [] a, List<List<String>> ll) { // TODO TODO TODO: 还差最后一步
//             int n = a.length, o = ll.size(); // m 个人， n 种技能
//             int [] l = new int [o];
//             Map<String, Integer> m = new HashMap<>();
//             for (int i = 0; i < n; i++) m.put(a[i], i);
//             int [] f = new int [1 << n];
//             Arrays.fill(f, Integer.MAX_VALUE / 2);
//             f[0] = 0;
//             for (int i = 0; i < o; i++) { // 遍历每个人: 用每个人来更新，不同状态下所需要的最少人数
//                 List<String> e = ll.get(i);
//                 int r = 0;
//                 for (int j = 0; j < e.size(); j++)
//                     if (m.containsKey(e.get(j))) r |= (1 << m.get(e.get(j)));
//                 l[i] = r;
//                 for (int j = (1 << n)-1; j >= r; j--) 
//                     if ((j & r) == r) f[j] = Math.min(f[j], f[j ^ r] + 1);
//             }
//             // for (int i = 0; i < (1 << n); i++) 
//             //     System.out.println("Integer.toBinaryString(f[i]): " + Integer.toBinaryString(f[i]));
//             // System.out.println("f[(1 << n) - 1]: " + f[(1 << n) - 1]);
//             // 现在：要怎么倒回去去找那些，可组成最小组合的人呢？
//             return new int []{};
//         }

// // 这个题，同上一个打印机一样【拓朴排序？还有个更好的拓朴排序的题目】，还有点儿印象，但印象不深
//         public int connectTwoGroups(List<List<Integer>> a) { // 看来这个题。。。1595 要好好多想几遍【爱表哥，爱生活！！！】
//             int m = a.size(), n = a.get(0).size();
//             int [][] r = new int [m][1 << n]; // 这里，就是准备，待用
//             for (int i = 0; i < m; i++) {
//                 for (int j = 0; j < (1 << n); j++) {
//                     int sum = 0;
//                     for (int k = 0; k < n; k++)
//                         if ((j & (1 << k)) > 0) sum += a.get(i).get(k);
//                     r[i][j] = sum;
//                 }
//             }
//             int [][] f = new int [m+1][1 << n];
//             Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE));
//             // f[0][0] = 0; // 【BUG：】初始化得不对，这里一个点是不行的，得一行点。。。
//             f[1] = r[0];
//             for (int i = 1; i < m; i++)  // 遍历每一行: 左边的每个点，要么去更新已连的右边点减少销耗，要么去连一个新的点
//                 // for (int j = (1 << n)-1; j > 0; j--) { // 遍历每一种与右点配对现状的更新可能性
//                 for (int j = 1; j < (1 << n); j++) {
//                     // 【更新：】右边现存连点中的每个状态下的每个点，将其换连成左边这个点【仍然不对】。。。。
//                     for (int k = 0; k < n; k++) { // 遍历右边当前状态 mask 下，每个点，【与左边当前遍历点】的更新可能性【情况二分】
//                         // if ((j & (1 << k)) > 0) // 当前点连了一个某个左边点：这里遍历的状态，仍然不够，左边这个待连点，仍然是可以与右边一片点，几个狠多个点一起连的。。。
//                             // f[i][j | (1 << k)] = Math.min(f[i][j | (1 << k)], f[i-1][j] + a.get(i).get(k));
//                             // f[i+1][j] = Math.min(f[i+1][j], f[i][j ^ (1 << k)] + a.get(i).get(k)); // 把右边 k 点，换成连左边 i 点
//                             // f[i+1][j | (1 << k)] = Math.min(f[i+1][j | (1 << k)], f[i][j] + a.get(i).get(k)); // 把右边 k 点，换成连左边 i 点
                            
//                         // else // 【BUG：】出发点是对的，但没想全，就是左边这个点，不是只能连右边一个点，还可以是一片点？所以有狠多状态。。。
//                             f[i+1][j | (1 << k)] = Math.min(f[i+1][j | (1 << k)], f[i][j] + a.get(i).get(k));
//                     }
//                     // 【更新：】右边还没有连的连点中的每个状态下的每个还没能连的点，将其连接成左边这个点，左边这个点可以对应右边狠多个点连接
//                     int rest = (1 << n)-1 - j; // 想要表示：右连，所有还不曾被连过的点，所有可能的状态 rest 表示截至第 i 行还没被选过的列
//                     for (int k = rest; k > 0; k = (k - 1) & rest) // 只遍历没选过的列的所有组合 
//                         f[i+1][j | k] = Math.min(f[i+1][j | k], f[i][j] + r[i][k]);
//                         // f[i][j | k] = Math.min(f[i][j | k], f[i-1][j] + r[i][k]);
//                 }
//             // return f[m-1][(1 << n) - 1];
//             return f[m][(1 << n) - 1];
//         }

//         public int maxScore(int[] a) { // 当用回塑的方法：这里有个保证正确答案就会浪费时间，而不浪费时间就无法保证正确答案，所以可能需要其它优化办法，或是换用动规来写 1799
//             n = a.length; m = n / 2; this.a = a; 
//             g = new ArrayList [m];
//             Arrays.setAll(g, z -> new ArrayList<Integer>());
//             // ll = new ArrayList<>();
//             Arrays.sort(a);
//             for (int i = 0; i < n; i++)
//                 for (int j = i+1; j < n; j++) {
//                     int x = a[i], y = a[j], g = gcd(x, y);
//                     String k = String.valueOf(x) + String.valueOf(y);
//                     mg.put(k, g);
//                     // mg.put(String.valueOf(y)+String.valueOf(x), g);
//                 }
//             backTracking(0, 0);
//             return max;
//         }
//         int n, m, max = 0;
//         // List<List<Integer>> ll;
//         int [] a;
//         List<Integer> [] g; // 【BUG：】这里看似简洁，实则浪费了狠多不必要的时间，不应该这么写
//         Map<String, Integer> mg = new HashMap<>();
//         void backTracking(int i, int cur) {
//             if (i == n) {
//                 if (cur > max) max = cur;
//                 return ;
//             }
//             int k = 0;
//             while (k < m) {
//                 // if (k > 0 && g[k-1].size() == 0) break;
//                 List<Integer> l = g[k];
//                 if (l.size() > 0 && l.size() < 2) {
//                     l.add(a[i]);
//                     // backTracking(i+1, cur + (l.size() == 1 ? 0 : gcd(l.get(0), a[i]) * (k+1)), a);
//                     String key = String.valueOf(Math.min(l.get(0), a[i])) + String.valueOf(Math.max(l.get(0), a[i]));
//                     backTracking(i+1, cur + (l.size() == 1 ? 0 : mg.get(key) * (k+1)));
//                     l.remove(l.size()-1);
//                 } else if (l.size() == 0) {
//                     l.add(a[i]);
//                     backTracking(i+1, cur);
//                     l.remove(l.size()-1);
//                     // break;
//                 }
//                 k++;
//             }
//         }
//         int gcd(int x, int y) {
//             if (y == 0) return x;
//             return gcd(y, x % y);
//         }
//         // // if (ll.size() == 0) ll.add(new ArrayList<>());
//         // for (int k = 0; k < ll.size(); k++) {
//         //     List<Integer> l = ll.get(k); //g[k];
//         //     if (l.size() < 2) {
//         //         l.add(a[i]);
//         //         // backTracking(i+1, cur + (l.size() == 1 ? 0 : gcd(l.get(0), a[i]) * (k+1)), a);
//         //         // String key = String.valueOf(Math.min(l.get(0), a[i])) + String.valueOf(Math.max(l.get(0), a[i]));
//         //         backTracking(i+1, cur + (l.size() == 1 ? 0 : mg.get(l.get(0)+ "" + a[i]) * (k+1)));
//         //         // backTracking(i+1, cur + mg.get(String.valueOf(l.get(0))+String.valueOf(a[i])) * (k+1));
//         //         l.remove(l.size()-1);
//         //     }
//         // }
//         // if (ll.size() < m) {
//         //     ll.add(new ArrayList<>());
//         //     List<Integer> l = ll.get(ll.size()-1);
//         //     l.add(a[i]);
//         //     backTracking(i+1, cur);
//         //     ll.remove(ll.size()-1);
//         // }
//         // for (int k = 0; k < m; k++) {
//         //     List<Integer> l = g[k];
//         //     if (l.size() < 2) {
//         //         l.add(a[i]);
//         //         // backTracking(i+1, cur + (l.size() == 1 ? 0 : gcd(l.get(0), a[i]) * (k+1)), a);
//         //         String key = String.valueOf(Math.min(l.get(0), a[i])) + String.valueOf(Math.max(l.get(0), a[i]));
//         //         backTracking(i+1, cur + (l.size() == 1 ? 0 : mg.get(key) * (k+1)), a);
//         //         l.remove(l.size()-1);
//         //     }
//         // }

//         【这个题型：】要好好总结一下 1187 比较奇特
//         public int makeArrayIncreasing(int[] a, int[] b) {
//             Arrays.sort(b);
//             int n = a.length, p = -1; m = b.length;
//             li = new ArrayList<>(); // 尽量写这种简单的，免得自己容易数错
//             for (int v : b) {
//                 if (v != p) li.add(v);
//                 p = v;
//             }
//             m = li.size(); 
//             int [][] f = new int [n+1][Math.min(m, n) + 1]; // 最多时行 Math.min(m, b) 次交换
//             Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE));
//             f[0][0] = -1; // 哨兵：－1
//             for (int i = 1; i <= n; i++) 
//                 for (int j = 0; j <= Math.min(i, m); j++) { // 分两种情况来更新
//                     /* 如果当前元素大于序列的最后一个元素 */
//                     if (a[i-1] > f[i-1][j])
//                         f[i][j] = a[i-1];
//                     /* 查找严格大于 dp[i - 1][j - 1] 的最小元素 */
//                     if (j > 0 && f[i-1][j-1] != Integer.MAX_VALUE) {
//                         int idx = binarySearch(j-1, f[i-1][j-1]);
//                         if (idx != m)
//                             f[i][j] = Math.min(f[i][j], li.get(idx));
//                     }
//                     if (i == n && f[i][j] != Integer.MAX_VALUE) return j;
//                 }
//             return -1;
//         }
//         List<Integer> li;
//         int m;
//         int binarySearch(int l, int v) { // 去找第一个 >= v 的下标
//             int r = m; // 右边界：不包括【l,r）：感觉这里我还没有弄狠透彻。。。
//             while (l < r) {
//                 int mid = (l + r) / 2;
//                 if (li.get(mid) > v) r = mid;
//                 else l = mid + 1;
//             }
//             return l;
//         }

//         public int maximalRectangle(char[][] a) {// TODO TODO TODO: 
//             int m = a.length, n = a[0].length;
//             int [][] s = new int [m+1][n+1];
//             for (int i = 0; i < m; i++) 
//                 for (int j = 0; j < n; j++)
//                     s[i+1][j+1] = s[i+1][j] + s[i][j+1] - s[i][j] + (a[i][j] - '0');
//             int [][] r = new int [m+1][n+1], d = new int [m+1][n+1];
//             for (int i = 0; i < m; i++)
//                 for (int j = n-1; j >= 0; j--) // 数右边1 的个数: j 是工整对应的
//                     if (a[i][j] == '1')
//                         r[i+1][j] = r[i+1][j+1] + 1;
//             for (int j = 0; j < n; j++)
//                 for (int i = m-1; i >= 0; i--) // 数下边 1 的个数： i 是工整对应的
//                     if (a[i][j] == '1') d[i][j+1] = d[i+1][j+1] + 1;
//             int max = 0;
//             for (int i = 0; i < m; i++) 
//                 for (int j = 0; j < n; j++) {
//                     if (a[i][j] == '1') {
//                         int rr =  r[i+1][j], dd = d[i][j+1], area = rr * dd;
//                         if (s[i+dd][j+rr] - s[i+dd][j] - s[i][j+rr] + s[i][j] == area)
//                             max = Math.max(area, max);
//                         else {
//                             if (max >= area || rr == 1 && dd == 1) continue;
//                             for (int x = i+dd-1; x >= i; x--)  // 这种情况下，不想再数下去了。。。
//                                 for (int y = j+rr-1; y >= j; y--) {
//                                 }
//                         }
//                     }
//                 }
//         }

//         public int numWays(int k, int n) {
//             this.n = n;
//             f = new Integer [501][k+1];
//             return dfs(0, k);
//         }
//         Integer [][] f;
//         int n; static final int mod = (int)1e9 + 7;
//         int dfs(int i, int j) {
//             if (j == 0) return i == 0 ? 1 : 0;
//             if (i >= n) return 0;
//             if (f[i][j] != null) return f[i][j];
//             if (i > j) return f[i][j] = 0; // 无法按时赶回来。。。
//             long ans = 0;
//             if (i > 0) ans = (ans + dfs(i-1, j-1)) % mod;
//             ans = (ans + dfs(i, j-1)) % mod;
//             ans = (ans + dfs(i+1, j-1)) % mod;
//             return f[i][j] = (int) ans;
//         }

//         public int numberWays(List<List<Integer>> ll) { // 【回塑：】一定会超时。。。: 帽子太多了就会超时，得用动规。。。
//             n = ll.size();
//             backTracking(0, 0, ll);
//             return ans;
//         }
//         int n, m, ans = 0;
//         void backTracking(int i, int j, List<List<Integer>> ll) { // j: mask
//             if (i == n) {
//                 if (Integer.bitCount(j) == n) // 一定要有这么多人顶帽子
//                     ans++;
//                 return ;
//             }
//             for (int k = 0; k < ll.get(i).size(); k++) {
//                 int id = ll.get(i).get(k);
//                 if ((j & (1 << id)) == 0) // 这顶帽子还没人带
//                     backTracking(i+1, j | (1 << id), ll);
//             }
//         }
//         static final int mod = (int)1e9 + 7; // 哪里还写得不对，再想一想，再接着写
//         public int numberWays(List<List<Integer>> ll) { // 【动规：】比较习惯写【自顶向下】，仍然是从没有帽子开始，遍历到所有的人都有帽子，感觉是自顶向下
//             int n = ll.size(), m = 0;
//             for (int i = 0; i < n; i++)
//                 m = Math.max(m, Collections.max(ll.get(i)));
//             m++;
//             // 因为要遍历帽子，需要简单重构：每顶帽子，是有哪些人比较喜欢它？
//             List<Integer> [] g = new ArrayList [m];
//             Arrays.setAll(g, z -> new ArrayList<>());
//             Set<Integer> hats = new HashSet<>();
//             for (int i = 0; i < n; i++) 
//                 for (int v : ll.get(i)) {
//                     g[v].add(i); // 【每顶帽子：】有这些人会比较喜欢它。。。
//                     hats.add(v);
//                 }
//             List<Integer> l = new ArrayList<>();
//             for (int v : hats) l.add(v);
//             m = l.size();
//             // System.out.println("l.size(): " + l.size());
//             // System.out.println(Arrays.toString(l.toArray()));
//             // for (int i = 0; i < m; i++) {
//             //     System.out.println("g[l.get(i)].size(): " + g[l.get(i)].size());
//             //     System.out.println(Arrays.toString(g[l.get(i)].toArray()));
//             // }
//             int [][] f = new int [m][1 << n];
//             // for (int i = 0; i < (1 << n); i++) 
//             //     f[i][0] = 1;
//             f[0][0] = 1;
//             for (int j = 0; j < m; j++) // 遍历帽子：当前这顶帽子 j, 可以给谁带？它说前面的【1,j-1】的帽子已经有人带了
//                 for (int i = 0; i < (1 << n); i++) { // 遍历：人的带与没带，帽子的状态
//                     // System.out.println("\n Integer.toBinaryString(i): " + Integer.toBinaryString(i));
//                     for (int k : g[l.get(j)]) { // 遍历：喜欢这顶帽子 j 的所有可能会带它的人
//                         System.out.println("k: " + k);
//                         if ((i & (1 << k)) == 0) { // 喜欢这顶帽子的，这个当前人，还没带帽子，可以给它带下
//                             f[j][i | (1 << k)] = (f[j][i | (1 << k)] + (j == 0 ? 1 : f[j-1][i])) % mod;
//                         }
//                     }
//                 } 
//             System.out.println("f.length: " + f.length);
//             for (int z = 0; z < f.length; ++z) 
//                 System.out.println(Arrays.toString(f[z]));
//             return f[m-1][(1 << n)-1];
//         }

// // 感觉这个题，跟前面那个自己数不对的题型是一样的, 就去数可以生成的个数. 就是生成所有可能的更短的，或是同样长短，但是不大于当前目标字符串的个数。。可变长度。
//         public int atMostNGivenDigitSet(String[] a, int v) { 
//             o = a.length; s = String.valueOf(v).toCharArray(); n = s.length;
//             return dfs(0, 0, true); // 这里的状态，可能还没能想全？
//         }
//         Map<String, Integer> m = new HashMap<>();
//         String [] a;
//         char [] s;
//         int o, m;
//         int dfs(int i, int j, )

        // public int leastOpsExpressTarget(int v, int target) { // 【记忆化深搜：】写不到动规，就还是先暴搜一遍呀 964
        //     this.v = v;
        //     return dfs(target);
        // }
        // Map<Integer, Integer> m = new HashMap<>();
        // int v;
        // int dfs(int i) {
        //     System.out.println("\n i: " + i);
        //     if (i == v || i == 0) return 0;
        //     if (i < v) return Integer.MAX_VALUE / 2;
        //     if (m.containsKey(i)) return m.get(i);
        //     int ans = Integer.MAX_VALUE / 2;
        //     if (i >= v)
        //         ans = Math.min(ans, 1 + dfs(i - v));
        //     ans = Math.min(ans, 1 + dfs(v - i));
        //     ans = Math.min(ans, 1 + dfs(i / v));
        //     ans = Math.min(ans, 1 + dfs(v / i));
        //     m.put(i, ans);
        //     System.out.println("\n i: " + i);
        //     System.out.println("ans: " + ans);
        //     return ans;
        // }

        // public int maxProfit(int[] a) {
        //     int n = a.length, min = a[0], max = 0;
        //     // 从左往右：一次交易的最大利润；从右往左：一次交易的最大利润
        //     int [] l = new int [n], r = new int [n];
        //     // Arrays.fill(l, -1); Arrays.fill(r, -1); // 【BUG：】哨兵值，有时候只能进行一笔交易，就是【0,n-1】下标下，某个值为 -1 不方便，不如留它为 0 不用检查
        //     for (int i = 1; i < n; i++) {
        //         min = Math.min(min, a[i]);
        //         max = Math.max(max, a[i] - min);
        //         l[i] = max;
        //     }
        //     max = 0;
        //     int localMax = a[n-1];
        //     for (int i = n-2; i >= 0; i--) {
        //         max = Math.max(max, localMax - a[i]);
        //         localMax = Math.max(localMax, a[i]);
        //         r[i] = max;
        //     }
        //     System.out.println(Arrays.toString(l));
        //     System.out.println(Arrays.toString(r));
        //     int ans = 0;
        //     for (int i = 0; i < n; i++)
        //         ans = Math.max(ans, l[i] + r[i]);
        //     return ans;
        // }
        
        //  // 【回塑：】试一遍B 数组的全排列
        // public int minimumXORSum(int [] a, int [] b) { // TLE TLE TLE: 51/64
        //     n = a.length; this.a = a; this.b = b;
        //     backTracking(0, 0, 0, new boolean [n]);
        //     return min;
        // }
        // int n, min = Integer.MAX_VALUE;
        // int [] a, b;
        // void backTracking(int i, int j, int k, boolean [] v) { // i: idx of A, j: |Sum, k: B elements cnter
        //     if (i == n) {
        //         if (k == n)
        //             min = Math.min(min, j);
        //         return ;
        //     }
        //     for (int x = 0; x < n; x++) { // 遍历当前 B 所有可能的取值
        //         if (!v[x]) {
        //             v[x] = true;
        //             backTracking(i+1, j + (a[i] ^ b[x]), k + 1, v);
        //             v[x] = false;
        //         }
        //     }
        // }
        // // 【最傻最天真】的思路是：【n <= 14】所以可以回塑的方法，建出B 数组的所有全排列；再傻傻去计算每种全排列的值，取最小值。。。【活宝妹就是一定要嫁给亲爱的表哥！！】
        // public int minimumXORSum(int [] a, int [] b) {
        //     int n = a.length, r = Integer.MAX_VALUE;
        //     int [][] f = new int [n+1][1 << n]; // 【自顶向下】：A 中前 i 个元素与B 中某 i 个元素，异或的最大值
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE / 2));
        //     Arrays.fill(f[0], 0);
        //     for (int i = 0; i < n; i++) // 遍历数组 A 中的每个当前元素
        //         for (int j = 0; j < (1 << n); j++) {
        //             for (int k = 0; k < n; k++) { // 【试着更新每一位：】
        //                 if ((j & (1 << k)) > 0) // 这个位上，被异或过
        //                     f[i+1][j] = Math.min(f[i+1][j], f[i][j ^ (1 << k)] + (a[i] ^ b[k]));
        //                 else // 这个位上，是空的，不曾被异或过 
        //                     f[i+1][j | (1 << k)] = Math.min(f[i+1][j | (1 << k)], f[i][j] + (a[i] ^ b[k]));
        //             }
        //         }
        //     return f[n][(1 << n)-1];
        // }

        // public boolean possiblyEquals(String S, String T) {  // 【记忆化深搜：】2060
        //     m = S.length(); n = T.length(); s = S.toCharArray(); t = T.toCharArray();
        //     if (s[0] != t[0] && !Character.isDigit(s[0]) && !Character.isDigit(t[0])) return false;
        //     f = new Boolean [m][n];
        //     return dfs(0, 0);
        // }
        // int m, n; char [] s, t;
        // Boolean [][] f;
        // boolean dfs(int i, int j) { // 因为数字的参入，存在四种比较可能性，要把那些瓣清楚。。。
        //     if (i == m && n == j) return true;
        //     if (i == m || j == n) return false;
        //     if (f[i][j] != null) return f[i][j];
        //     // 【两个字符：一样】
        //     if (s[i] == t[j] && !Character.isDigit(s[i])) return f[i][j] = dfs(i+1, j+1);
        //     // 【两个字符：不一样】
        //     if (s[i] != t[j] && !Character.isDigit(s[i]) && !Character.isDigit(t[j])) return f[i][j] = false;
        //     // 【两个都是数字】
        //     if (Character.isDigit(s[i]) && Character.isDigit(t[j])) {
        //         List<int []> l = new ArrayList<>();
        //         int v = 0, k = i, min = Integer.MAX_VALUE;
        //         while (k < m && Character.isDigit(s[k])) {
        //             v = v * 10 + s[k] - '0';
        //             l.add(new int [] {v, k}); // 【v,k】 k 是当前取到 v 值的下标
        //             k++;
        //         }
        //         v = 0, k = j;
        //         while (k < m && Character.isDigit(t[k])) {
        //             v = v * 10 + t[k] - '0';
        //             for (int x = 0; x < l.size(); x++) {
        //                 int [] li = l.get(x);
        //                 min = Math.min(li[0], v); // 这里再想一下：两个同时是数字，被绕昏了。。。
        //                 if (dfs(i + (li[0] > min ? li[0] : min), k+1)) return f[i][j] = true;
        //             }
        //         }
        //     } else { // 【仅有一个是数字：】
        //         boolean isSdigit = Character.isDigit(s[i]);
        //         int v = 0, idx = (isSdigit ? i : j), max = Math.min(idx+2, (isSdigit ? m-1 : n-1)), k = idx;
        //         for (; k <= max; k++) {
        //             if (isSdigit && !Character.isDigit(s[k]) || !isSdigit && !Character.isDigit(t[j])) break;
        //             v = v * 10 + (isSdigit ? s[i] : t[j]) - '0';
        //             if (dfs(isSdigit ? k : i + (k - j), isSdigit ? j + (k - i) : k)) return f[i][j] = true;
        //         }
        //     }
        // }        

        // int n; int [] a;
        // TreeMap<int, Set<Integer>> masks = new TreeMap<>(); // sum, mask 可能会有不同的，或是多个
        // void backTracking(int i, int j, int k) { // i: idx j: sum k: mask 
        //     if (i < 0) {
        //         masks.computeIfAbsent(j, z -> new TreeSet<>((x, y)-> y-x)).add(k);
        //         return ;
        //     }
        //     backTracking(i-1, j + a[i], k | (1 << i));
        //     backTracking(i-1, j, k);
        // }
        // public boolean canDistribute(int[] a, int [] b) { // 102/109Wrong-answer 
        //     n = b.length; int N = a.length; this.a = b;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int v : a) m.put(v, m.getOrDefault(v, 0) + 1); // 50 个
        //     Arrays.sort(b); // 升序排列
        //     backTracking(n-1, 0, 0);
        //     boolean [] f = new boolean [1 << n];
        //     f[0] = true;
        //     for (Map.Entry<Integer, Integer> en : m.entrySet()) {
        //         int k = en.getKey(), v = en.getValue();
        //         Integer key = masks.floorKey(v); // 这些里面的，应该是最全最优解，其它键值比它小的，不用遍历了，忆经可以保证结果正确
        //         if (key == null) continue; // 什么也填不了
        //         for (int i = (1 << n)-1; i > 0; i--)
        //             for (int mask : masks.get(key)) { // 遍历这个数：所有可能的分布，必须暴力以保证结果正确
        //                 if ((i & mask) == mask)
        //                     f[i] |= f[i ^ mask];
        //             }
        //     }
        //     return f[(1 << n)-1];
        // }
        // public boolean canDistribute(int[] a, int [] b) { // 不知道哪里写趴了，傍晚回来再接着写。。。【活宝妹就是一定要嫁给亲爱的表哥！！！】
        //     int n = b.length;
        //     int N = 1001, idx = 0;
        //     int [] r = new int [N], cnt = new int [N];
        //     for (int i = 0; i < a.length; i++) {
        //         r[a[i]]++;
        //         cnt[a[i]] = 1;
        //     }
        //     int o = Arrays.stream(cnt).sum();
        //     TreeMap<Integer, Integer> m = new TreeMap<>();
        //     TreeSet<Integer> [] s = new TreeSet[o];
        //     Arrays.setAll(s, z -> new TreeSet<Integer>((x, y) -> (y - x)));
        //     for (int i = 0; i < N; i++)
        //         if (r[i] > 0) 
        //             m.put(r[i], idx++);
        //     for (int i = 1; i < (1 << n); i++) {
        //         int cur = 0;
        //         for (int j = 0; j < n; j++) 
        //             if ((i & (1 << j)) > 0) cur += b[j];
        //         Integer key = m.ceilingKey(cur);
        //         if (key != null) 
        //             for (int k = m.get(key); k >= 0; k--) // 所有和 >= 大于当前和 cur 的数，添加当前 mask 
        //                 s[k].add(i);
        //     }
        //     boolean [][] f = new boolean [o+1][1 << n];
        //     f[0][0] = true;
        //     for (int i = 0; i < o; i++) // 试图：用每个数来更新任何可能状态下的最优解，这里当前数可以更新：一个到多个不同的子集，子集，该如何遍历？
        //         for (int j = 0; j < (1 << n); j++) { // 遍历每种状态下
        //             for (int k : s[i]) {
        //                 if ((j & k) == 0) // 这些人，还没分到数
        //                     f[i+1][j | k] |= f[i][j];
        //             }
        //         }
        //     return f[o][(1 << n)-1];
        // }

        // static final int mod = (int)1e9 + 7;
        // public int numberOfArrays(String t, int k) { // 【记忆化深搜：】为什么就写不习惯动规呢？
        //     s = t.toCharArray(); this.k = k; n = t.length();
        //     f = new Integer [n];
        //     return dfs(0);
        // }
        // Integer [] f;
        // char [] s;
        // int n, k;
        // int dfs(int i) {
        //     if (i == n) return 1;
        //     if (f[i] != null) return f[i];
        //     if (s[i] == '0') return f[i] = 0;
        //     long ans = 0, v = 0;
        //     for (int j = i; j < n && v < k; j++) {
        //         v = v * 10 + s[j] - '0';
        //         if (v > k) break;
        //         if (v != 0)
        //             ans = (ans + dfs(j+1)) % mod;
        //     }
        //     return f[i] = (int)ans;
        // }        
        // // public int numberOfArrays(String t, int k) { // 【记忆化深搜：】为什么就写不习惯动规呢？
        // //     int n = t.length(); char [] s = t.toCharArray();
        // //     int [] f = new int [n+1];
        // //     f[n] = s[n-1] == '0' ? 0 : (s[n-1] - '0' <= k ? 1 : 0);
        // //     for (int i = n-2; i >= 0; i--) {
        // //         if (s[i] == '0') continue;
        // //         int v = 0;
        // //         for (int j = i; j < n && v <= k; j++) {
        // //             v = v * 10 + s[j] - '0';
        // //             if (v > k) break;
        // //             f[i+1] = (f[i+1] + f[j+2]) % mod; // TODO TODO TODO: 
        // //         }
        // //     }
        // // }
    }
    public static void main (String[] args) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Solution s  =  new Solution ();

        int r = s.numberOfArrays(a, 823924906);
        System.out.println("r: " + r);
    } 
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);  
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);






