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
    // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    public static class Solution { 
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 看起来像是【动规】的样子，实际上是【滑动窗口】。。要【前缀和】和【中间2 个片段】一一数据预处理计算
        // public long maxProfit(int[] a, int[] b, int k) { // a: price b:action
        //     int n = a.length;
        //     long [] f = new long [n+1], p = new long [n+1];
        //     long ans = 0l;
        //     for (int i = 0; i < n; i++) {
        //         p[i+1] = p[i] + (long)a[i] * b[i];
        //         f[i+1] = f[i] + (long)a[i] * 1l;
        //     }
        //     ans = p[n];
        //     // 遍历：【前半段 k/2 长度片段的、所有、合法、终点】
        //     for (int i = 0; i < n - k/2; i++) {
        //         if (i < k/2-1) 
        //             continue;
        //         ans = Math.max(ans, f[i+1+k/2] - f[i+1] + p[i+1-k/2] + p[n] - p[i+1+k/2]);
        //     }
        //     return ans;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 不知道怎么去想这个题目，【暴力】写一遍，先
        // static final int mod = (int)1e9 + 7;
        // public int xorAfterQueries(int[] a, int[][] qs) {
        //     int n = a.length, m = qs.length;
        //     for (int [] f : qs) {
        //         for (int i = f[0]; i <= f[1]; i += f[2]) 
        //             a[i] = (int)(((long)a[i] * f[3]) % mod);
        //     }
        //     for (int i = 1; i < n; i++)
        //         a[i] = (a[i] ^ a[i-1]);
        //     return a[n-1];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 感觉，像是【二维、区间型、动规】，2 维可能内存会暴OOM, 得改用【字典】
        // // 有个【特别有用、和帮助】的条件是： a[i] 在【1,..】不会是0; 所以可以把【删除】当作 a[i]=0 看，并且不影响结果
        // // 写不到【动规】，先写【记忆化深搜】
        // // 【状态定义】：动规状态，迁移中与【数组 a[i] 中、删除片段】的数组状态相关，需要（带入、记入）这个数组的删除状态，就是『删除片段的、和』
        // // 数组中的【重复数字、重复片段】对周围链接的影响。。。【TODO：】
        // // 所以，还是需要维护2个【随时  任何第1-n? 选择中；dfs 过程中、方便、动态区间更新、前缀和】；另一个BIT 只标记【0/1】删除与否，方便 dfs 其它选择回塑。。
        // public class BIT {
        //     long [] f;
        //     int [] a, aa;
        //     int n;
        //     public BIT(int [] a) {
        //         this.n = a.length;
        //         f = new long [n]; // 从1 开始
        //         this.a = new int [n];
        //         Arrays.fill(this.a, 1);
        //         aa = new int [n];
        //         aa = Arrays.copyOf(a);
        //     }
        //     public void resetFlag() {
        //         Arrays.fill(a, 1);
        //     }
        //     public void pointUpdate(int i, long v) { // 【初始化】：是记 a[i] 还是记 preSum[i], 应该是 preSum[i]
        //         while (i < n) {
        //             f[i] += v * a[i] * aa[i]; // 【TODO：】不能简化 v[0/1], 因为不同片段和，删除掉的值不一样。。
        //             i += lowbit(i);
        //         }
        //     }
        //     // 【TODO：】BIT 【区间更新】的简单原理是O(NlogN) 的时间复杂度？
        //     public void rangeUpdate(int l, int r, int v) { // v: operation 0/1
        //         for (int i = l; i <= r; i++) {
        //             // 先，更新标记 flag
        //             a[i] = v;
        //             // 再更新：前缀和。。
        //             pointUpdate(i, v);
        //         }
        //     }
        //     private int lowbit(int i) {
        //         return i & -i; // 【TODO：】这里的【位】原理，还是不懂
        //     }
        // }
        // // 【TODO：】先不写这个题目，晚点儿再写这个题目。。没想明白。。
        // public long minArraySum(int[] a, int k) {
        //  n = a.length;
        //  p = new long [n+1]; // preSum
        //  m = new HashMap<>();
        //  for (int i = 0; i < n; i++)
        //      p[i+1] = p[i] + (long)a[i];
        //  Set<Long> [] s = new HashSet[k];
        //  Arrays.setAll(s, z -> new HashSet<Long>());
        //  s[0].add(0);
        //  BIT bit = new BIT(p);
        //  // 遍历【前缀和】：遍历、第1 个可以被 k 整除的【删除片段】
        //  int j;
        //  long min = Long.MAX_VALUE;
        //  for (int i = 1; i <= n; i++) {
        //      j = f[i] % k;
        //      for (long v : f[j]) {
        //          bit.resetFlag();
        //          bit.rangeUpdate(v, i, -1);
        //          min = Math.min(min, dfs(0, n-1))
        //      }
        //  }
        // }
        // int n;
        // long [] p;
        // Map<long [], Integer> m;

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，笨宝妹上午中午写的这一组题目写得不好，这会儿下午傍晚晚餐前再写一组，看能写出几题目，狠久没有写了，都已经感觉有点儿手生了。。
        // public int xorAfterQueries(int[] a, int[][] qs) {
        //     int n = a.length, m = qs.length;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int gcdOfOddEvenSums(int n) {
        //     int l = 0, r = 0;
        //     for (int i = 1; i < n*2; i += 2) 
        //         l += i;
        //     for (int i = 2; i <= n*2; i += 2)
        //         r += i;
        //     return gcd(l, r);
        // }
        // int gcd(int l, int r) {
        //     if (r == 0) return l;
        //     return gcd(r, l % r);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean partitionArray(int[] a, int k) {
        //     int n = a.length;
        //     Map<Integer, Integer> mo = new HashMap<>();
        //     for (int v : a)
        //         mo.put(v, mo.getOrDefault(v, 0) + 1);
        //     if (Collections.max(mo.values()) == 1)
        //         return (n % k == 0);
        //     // 【降序排列】：先按值，再按 Key
        //     Map<Integer, Integer> m = MapUtil.sortByValue(mo, true);
        //     // 【TODO：】这些折数组太烦人了，先写其它题目
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【从右向左】：排序【自小向大】遍历数值 a[i]
        // // 遍历了3 次，感觉脑袋正糊糊，不知道该怎么有序地去遍历它们。。【TODO：】
        // public int[] maxValue(int[] a) {
        //     int n = a.length;
        //     int [] f = new int [n];
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         l.add(new int [] {a[i], i});
        //     // 排序：值降序、下标升序【自左向右】
        //     Collections.sort(l, (x, y)-> (x[0] != y[0] ? y[0] - x[0] : x[1] - y[1]));
        //     // 用来：快速索命 f[i] 中的最大合法值，键降序，值升序，排列
        //     // TreeMap<Integer, Integer> m = new TreeMap<>((x, y)->(x.getKey() != y.getKey() ? y.getKey() - x.getKey() : x.getValue() - y.getValue()));
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int [] v : l) 
        //         m.put(v[0], v[1]);
        //     for (int i = 0; i < n; i++) {
        //         int [] cur = l.get(i);
        //         System.out.println(Arrays.toString(cur));
        //         int v = cur[0], j = cur[1];
        //         if (i == 0) {
        //             f[j] = v;
        //             m.put(f[j], j);
        //             System.out.println(Arrays.toString(f));
        //             continue;
        //         }
        //         // 遍历：键降序，值升序，排列的有序字典 m
        //         for (Map.Entry<Integer, Integer> en : m.entrySet()) {
        //             int idx = en.getValue();
        //             if (idx < j) {
        //                 f[j] = f[idx];
        //                 break;
        //             }
        //         }
        //         if (f[j] == 0) f[j] = v; // 有序遍历，觉得这不可能 <== 想得不对，是可能没值的，就是先前遍历过的全在当前下标的右边
        //         System.out.println(Arrays.toString(f));
        //     }
        //     // 【TODO：】这里还没完，只完成了【向左跳】；还要再遍历一遍【往右跳】
        //     // 健升序、值下标降序【自右往左遍历】
        //     Collections.sort(l, (x, y)-> (x[0] != y[0] ? x[0] - y[0] : y[1] - x[1]));
        //     // m.clear();
        //     // for (int [] v : l) 
        //     //     m.put(v[0], v[1]);
        //     for (int i = 0; i < n; i++) {
        //         int [] cur = l.get(i);
        //         System.out.println(Arrays.toString(cur));
        //         int v = cur[0], j = cur[1];
        //         // if (i == 0) {
        //         //     // f[j] = v;
        //         //     m.put(f[j], j);
        //         //     System.out.println(Arrays.toString(f));
        //         //     continue;
        //         // }
        //         // 遍历：键降序，值升序，排列的有序字典 m
        //         for (Map.Entry<Integer, Integer> en : m.entrySet()) {
        //             int idx = en.getValue();
        //             if (idx < j) {
        //                 f[j] = Math.max(f[j], f[idx]);
        //                 // break;
        //             }
        //         }
        //         if (f[j] == 0) f[j] = v; // 有序遍历，觉得这不可能 <== 想得不对，是可能没值的，就是先前遍历过的全在当前下标的右边
        //         System.out.println(Arrays.toString(f));
                
        //     }
        //     // 【TODO：】这里还没完，只完成了【向左跳】；还要再遍历一遍【往右跳】
        //     // 健升序、值下标降序【自右往左遍历】
        //     m.clear();
        //     for (int [] v : l) 
        //         m.put(v[0], v[1]);
        //     for (int i = 0; i < n; i++) {
        //         int [] cur = l.get(i);
        //         System.out.println(Arrays.toString(cur));
        //         int v = cur[0], j = cur[1];
        //         // 遍历：键降序，值升序，排列的有序字典 m
        //         for (Map.Entry<Integer, Integer> en : m.entrySet()) {
        //             int idx = en.getValue();
        //             if (idx > j) {
        //                 f[j] = Math.max(f[j], f[idx]);
        //                 // break;
        //             }
        //         }
        //         if (f[j] == 0) f[j] = v; // 有序遍历，觉得这不可能 <== 想得不对，是可能没值的，就是先前遍历过的全在当前下标的右边
        //         System.out.println(Arrays.toString(f));
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int getLeastFrequentDigit(int n) {
        //     int [] f = new int [10];
        //     char [] s = String.valueOf(n).toCharArray();
        //     for (char c : s) {
        //         int i = c - '0';
        //         f[i]++;
        //     }
        //     int freq = Arrays.stream(f).max().getAsInt(), r = 0;
        //     for (int i = 0; i < 10; i++)
        //         if (f[i] == freq) {
        //             r = i;
        //             break;
        //         }
        //     for (int i = 0; i < 10; i++) {
        //         if (f[i] == 0) continue;
        //         if (f[i] < freq) {
        //             r = i;
        //             freq = f[i];
        //         }
        //     }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹觉得：这个破烂题目出得极其猥琐。。。晚点儿再写这个题目
        // public int score(String[] cards, char x) {
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规：稍作修改的动规、变态动规】。。这个题目，感觉原理都是明白的。。但是亲爱的表哥的活宝妹、笨宝妹昨天晚上吃太多鸡腿蛋白质，脑袋有点儿昏，细节上总出错。。
        // static final int mod = (int)1e9 + 7;
        // public int uniquePaths(int[][] a) {
        //     int m = a.length, n = a[0].length;
        //     int [][][] f = new int [m][n][2]; // 2: 0-->Right 1-->Down
        //     Arrays.fill(f[0][0], 1);
        //     for (int j = 1; j < n; j++)
        //         if (a[0][j] == 0)
        //             f[0][j][0] = f[0][j-1][0];
        //         else if (a[0][j] == 1 && a[0][j-1] == 0 && m > 1)
        //             f[1][j][1] = f[0][j-1][0];
        //     for (int i = 1; i < m; i++)
        //         if (a[i][0] == 0)
        //             f[i][0][1] = f[i-1][0][1];
        //         else if (a[i][0] == 1 && a[i-1][0] == 0 && n > 1)
        //             f[i][1][0] = f[i-1][0][1];
        //     // 遍历：【每个格】
        //     for (int i = 1; i < m; i++)
        //         for (int j = 1; j < n; j++) {
        //             if (i == 0 && j == 0) continue;
        //             if (a[i][j] == 0) {
        //                 if (a[i][j-1] == 0) // Right: 0
        //                     f[i][j][0] = (f[i][j][0] + f[i][j-1][0] + f[i][j-1][1]) % mod;
        //                 if (a[i-1][j] == 0) // Down: 1
        //                     f[i][j][1] = (f[i][j][1] + f[i-1][j][0] + f[i-1][j][1]) % mod;
        //             } else { // 变态镜子
        //                 // 镜子反射到右边Right: 0, 自上向下Down 时，反射向右边
        //                 if (j < n-1) {
        //                     // 第1 次反射的镜子
        //                     if (a[i-1][j] == 0)
        //                         f[i][j+1][0] = (f[i][j+1][0] + f[i-1][j][0] + f[i-1][j][0]) % mod;
        //                     // else 
        //                         // 连续反射：【TODO：】也仍然要分方向; 同样也要【区分来源】
        //                         f[i][j+1][0] = (f[i][j+1][0] + f[i][j][1]) % mod;
        //                 }
        //                 // 镜子反射到下边Down: 1, 自左向右Right 时，反射向下边
        //                 if (i < m-1) {
        //                     // 第1 次反射的镜子
        //                     if (a[i][j-1] == 0)
        //                         f[i+1][j][1] = (f[i+1][j][1] + f[i][j-1][0] + f[i][j-1][1]) % mod;
        //                     // else
        //                         // 连续反射：【TODO：】也仍然要分方向; 同样也要【区分来源】
        //                         f[i+1][j][1] = (f[i+1][j][1] + f[i][j][0]) % mod;
        //                 }
        //             }
        //         }
        //     int [] tmp = new int [n];
        //     for (int i = 0; i < m; i++) {
        //         Arrays.fill(tmp, 0);
        //         for (int j = 0; j < n; j++)
        //             tmp[j] = Arrays.stream(f[i][j]).sum();
        //         System.out.println(Arrays.toString(tmp));
        //     }
        //     System.out.println(Arrays.toString(f[1][1]));
        //     return (f[m-1][n-1][0] + f[m-1][n-1][1]) % mod;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] recoverOrder(int[] a, int[] b) {
        //     int n = a.length;
        //     Set<Integer> s = new HashSet<>(Arrays.stream(b).boxed().collect(Collectors.toList()));
        //     int [] f = new int [b.length];
        //     int i = 0;
        //     for (int j = 0; j < n; j++)
        //         if (s.contains(a[j]))
        //             f[i++] = a[j];
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // Wrong Answer 754 / 758 testcases passed: Hidden for this testcase during contest.
        // // 亲爱的表哥的活宝妹的基本思路、出发点都是对的；只是离【动规】解法的题解，还差一小步。。。需要转化为【动规】的状态转移方程。。。
        // // 看【题解】看不懂，它的语言是体育老师教的，表达不清楚。。。看源码看懂了，可是今天不想再写这个破烂题目了。。。
        // public long maxProduct(int[] a) { // TLE TLE TLE 751/758 passed 算是亲爱的表哥的活宝妹、笨宝妹写【位运算】相关的、相对比较好的成绩。。
        //     int n = a.length;
        //     Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     // Arrays.sort(a); 
        //     // 遍历：按数组降序遍历；每个数遍历这个数的【补集的、子集】
        //     long r = 0;
        //     int j = 0, cur = 0, mask = (1 << Integer.toBinaryString(Arrays.stream(a).max().getAsInt()).length()+1) -1;
        //     // System.out.println(Arrays.toString(a));
        //     for (int i = n-1; i > 0; i--) { // 755/758 passed TLE TLE TLE
        //     // for (int i = n-1; i >= n/8; i--) { // 752/758 passed
        //         // 【TODO：】怎么才能取（补集）；取32 位要遍历得太多了。缩小范围到 20 位左右
        //         // System.out.println("a[i]: " + a[i] + " " + "Integer.toBinaryString(a[i]): " + Integer.toBinaryString(a[i]));
        //         // j = ~a[i] & ((1 << 20)-1);
        //         // j = ~a[i] & ((1 << String.valueOf(Arrays.stream(a).max().getAsInt()).length()+1)-1);// 写得不对
        //         cur = ~a[i] & mask;
        //        // 【TODO：】如经典题型【选课问题】，遍历最大补数 j 的【所有、位子集】，O(20 × N)
        //         for (j = cur; j > 0 && a[i] * j >= r; j = cur & (j - 1)) { // 【TODO：】感觉，这里的细节，怎么有效按位的子集遍历的。细节写得不对
        //         // for (j = cur; j > 0; j = j & (j - 1)) { // 这么写，居然是错的。。
        //             // 【TODO：】裁枝，【自大到小】遍历 j; 当 a[i] × j <= max 时裁枝，跳出遍历
        //             // a[i] * j >= r
        //             if (s.contains(j)) { // <<<<<<<<<<<<<<<<<<<< 遍历：a[i] 【补集】中的所有元素，并一一判断是否存在
        //                 r = Math.max(r, (long)a[i] * j);
        //             }
        //         }
        //     }
        //     return r;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个破烂题目，真烦人，把它手写一遍，加深印象，以后，亲爱的表哥的活宝妹自己就会写了！！！
        // // 亲爱的表哥的活宝妹、笨宝妹，上周考场上脑袋昏昏，天才般地【回忆、回想出了：经典题型（选课问题II）里的遍历方法】；却止步那里
        // // 现在再看，这个【动规】的思路，浑然天成。。亲爱的表哥的活宝妹、笨宝妹，怎么会上周六自己想不出来、这么直观直白的【动规】解法。。。
        // // 可是，感觉2 种解法的O(20N) 与O(w(1<<w)) 都差不多；感觉只能说，leetcode 把时间卡得太死，把亲爱的表哥的活宝妹的笨解法给卡成TLE TLE TLE 了。。。
        // public long maxProduct(int[] a) { 
        //     int n = a.length, mv = Arrays.stream(a).max().getAsInt(), w = 32 - Integer.numberOfLeadingZeros(mv), s = (1 << w);
        //     // 【动规】数组：f[i] 存的是，【1,S-1】范围内a[i] 中存在的、【最大数】
        //     long [] f = new long [s];
        //     // 【初始化】
        //     for (int v : a) 
        //         f[v] = (long)v;
        //     // 【自小到大】遍历：（自小到大）动规更新
        //     for (int i = 1; i < s; i++) // O((w=20)*(1<<w20)
        //         for (int j = 0; j < w; j++) {
        //             if ((i & (1 << j)) > 0)
        //                 f[i] = Math.max(f[i], f[i ^ (1 << j)]);
        //         }
        //     long max = 0;
        //     for (int v : a) 
        //         max = Math.max(max, (long)v * f[(s-1) ^ v]);
        //     return max;
        // }
        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minOperations(int[] a) {
        //     int n = a.length;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minOperations(String S) {
        //     int n = S.length(), m = 26; char [] s = S.toCharArray();
        //     int [] f = new int [m], r = new int [m];
        //     for (char c : s)
        //         f[c-'a']++;
        //     for (int i = 1; i < m; i++) {
        //         if (r[i] + f[i] != 0)
        //             r[(i+1)%26] += r[i] + 1;
        //     }
        //     return r[0];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【数位动规】：数（二进制）中，不大于这个数的个数，遍历位，遍历一半。。
        // // 怎么数的呢？狠久没写这类题型，亲爱的表哥的活宝妹、笨宝妹还是忘记了是怎么数的了。。。前不久不是刚写出过【左右边界串、且非毒串】的遍历数法吗？
        // // 【记忆化深搜】：
        // // 从【低位0 往高位】遍历：第0 位特殊
        // // 【TODO：】不知道哪里写错了
        // public int countBinaryPalindromes(long n) { // 50 位
        //     String S = Long.toBinaryString(n);
        //     s = S.toCharArray();
        //     this.n = s.length / 2 + s.length % 2;
        //     m = s.length;
        //     f = new Integer [this.n][2]; // j2[0/1]: 标记是否 match-n 的数位 
        //     // f = new Integer [n][2][2]; //
        //     int ans = dfs(0, 1);
        //     --this.m; // 长度可以变短
        //     for (; this.m >= 0; this.m--) {
        //         for (int i = 0; i < this.n; i++)
        //             Arrays.fill(f[i], 0);
        //         n = this.m / 2;
        //         ans += dfs(1, 0);
        //     }
        //     // return dfs(0, 1);
        //     return ans;
        // }
        // int n, m;
        // char [] s;
        // Integer [][] f;
        // int dfs(int i, int j) {
        //     // 【终止条件】：遍历到【最中间位】 m 可以是【奇数、或、偶数】
        //     // 【区分】：是否 match-n; 是【奇数位、偶数位】等
        //     if (i == n-1) {
        //         if (j == 1) { // match-n
        //             if (m % 2 == 1)
        //                 return f[i][j] = 1;
        //             else // 偶数位: 完全相同，则0=>1 或1=>2; 不同：则1 种可能性就是0
        //                 return f[i][j] = (s[i] == s[i+1] ? s[i]-'0'+1 : 1);
        //         } else { // 不用 match-n: 是任何数位，都可以随意取 0/1 吗？应该是的
        //             return f[i][j] = 2;
        //         }
        //     }
        //     if (f[i][j] != null && f[i][j] != 0) return f[i][j];
        //     if (j == 1) // match-n
        //         return f[i][j] = (dfs(i+1, j) + (s[i] == '1' ? dfs(i+1, 1-j) : 0));
        //     else // NO match-n
        //         return f[i][j] = 2 * dfs(i+1, j);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int smallestAbsent(int[] a) {
        //     int n = a.length, sum = Arrays.stream(a).sum(), r = (int)Math.ceil((double)sum * 1.0/ n);
        //     Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     System.out.println("sum: " + sum + " " + "r: " + r);
        //     for (int i = Math.max(r + (sum % n == 0 ? 1 : 0), 1); i < 102; i++) 
        //         if (!s.contains(i)) return i;
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】：一看就是动规，只是要怎么去写呢？？
        // // 【滑动窗口】：每个窗口里，其实只需要记录（Max=r, Sec=l)出现频次 [最多、次多]的类型，就可以了
        // // 【pqia 双端优先队列】：O(N)?
        // // 但是，亲爱的表哥的活宝妹，还是不知道怎么去想这个题目，晚点儿再写这个题目
        // public int minArrivalsToDiscard(int[] a, int w, int m) {
        //     int n = a.length;
        //     int [][] f = new int [n][2];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个破烂题目的【排序】狠烦人
        // public int[][] generateSchedule(int n) {
        //     int [][] f = new int [n * 2][2];
        //     int [][][] a = new int [n][n][2];
        //     f[0][0] = 0;
        //     f[0][1] = 1;
        //     a[0][1][0] = 1;
        //     int j = 0, k = 0;
        //     for (int i = 1; i < n * 2; i++) {
        //         j = 0; k = 0;
        //         while (j < n && k < n && (j == k || a[Math.min(j, k)][Math.max(j, k)][j < k ? 0 : 1] > 0)) {
        //             while (j == f[i-1][0] || j == f[i-1][1]) j++;
        //             while (k == f[i-1][0] || k == f[i-1][1]) k++;
        //             if (j == k) j++;
        //             if (j == n || k == n) break;
        //             if (a[Math.min(j, k)][Math.max(j, k)][0] > 0 || a[Math.min(j, k)][Math.max(j, k)][1] > 0) {
        //                 if (a[Math.min(j, k)][Math.max(j, k)][0] > 0) j++;
        //                 else k++;
        //             }
        //         }
        //         if (j == n || k == n) return new int [0][];
        //         f[i][0] = j;
        //         f[i][1] = k;
        //         a[Math.min(j, k)][Math.max(j, k)][j < k ? 0 : 1] = 1;
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】：这个破烂题目，是上次亲爱的表哥的活宝妹、亲爱的表哥的活宝妹、笨宝妹【自长成长。。上上个周末、自发终于能够写出：经典选课问题II】的变形、动规题目吗？
        // // 先，【数组最大值 max】，再根据 max 的0-bit 空缺数位，遍历数位，XOR 出一个以 max 的首位为最长位的、【极尽可能大】的 XOR 序列＝＝》XOR 值＝f
        // // 再，根据 f 的空缺位，遍历出一个【极尽可能大】的 SEc
        // // 最后，最大值 f 与，次大值 sec XOR 出一个相对更大的数： f ^ sec = ans
        // // 亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，如果再按【2 周前、上上周六】晚上的【按数位遍历】方法，可能又要TLE TLE TLE
        // // 【动规】：只遍历一遍数组，O（30*N）动规出数组中每个数的（不大于、此数的？、最大XOR 值）？？？
        // // 【动规】：只遍历一遍数组，O（30*N）动规出数组中每个数的（不小于、此数的？、最大XOR 值）？？？
        // public int maxXorSubsequences(int[] a) {
        //     int n = a.length, max = Arrays.stream(a).max().getAsInt(), m = 32 - Integer.numberOfLeadingZeros(max);
        //     //（1<<30=10^9）感觉需要占用的空间太多，怕OOM, 用字典
        //     TreeMap<Integer, Integer> f = new TreeMap<>((x, y)->y-x);
        //     for (int v : a) f.put(v, v);
        //     for (int i = 1; i < (1 << m); i++) {
        //         int len = Math.min(m, 32 - Integer.numberOfLeadingZeros(i));
        //         for (int j = 0; j < len; j++) {
        //             if (((i >> j) & 1) == 0)
        //                 f.put(i | (1 << j), Math.max(f.getOrDefault(i | (1 << j), 0), f.getOrDefault(i, 0) ^ f.getOrDefault(1 << j, 0)));
        //         }
        //     }
        //     max = Collections.max(f.values());
        //     System.out.println("max: " + max);
        //     // 为什么，打印字典里的值，最小只能到 3 ，而没能1 和 2？？？
        //     // 把 f 里，所有值为 0 的 entry, 全部清空，方便下面后面的，遍历查找【最大、有效键值对】
        //     TreeMap<Integer, Integer> ff = new TreeMap<>((x, y)->y-x);
        //     for (Map.Entry<Integer, Integer> en : f.entrySet()) 
        //         if (en.getValue() != 0) ff.put(en.getKey(), en.getValue());
        //     f.clear();
        //     f = ff;
        //     System.out.println("f.size(): " + f.size());
        //     for (Map.Entry<Integer, Integer> en : f.entrySet()) 
        //         System.out.print(en.getKey() + ", " + en.getValue() + "\n");
        //     System.out.println("max: " + max);
        //     Integer sec = null;
        //     for (int i = m-1; i > 0; i--) {
        //         if ((max & (1 << i)) == 0) {
        //             // 【TODO：】感觉，这里取值太小了，可以取得再大一点儿
        //             sec = f.floorKey(Math.min(max-1, 1 << i));
        //             // System.out.println("(1 << (i+1)-1): " + (1 << (i+1)-1));
        //             // sec = f.lowerKey(Math.min(max ^ (1 << i) & ((1 << (i+1))-1), (1 << (i + 1))-1));
        //             // 【TODO：】亲爱的表哥的活宝妹，这里脑袋昏掉了，不知道是怎么回事，哪里细节出错了，今天上午不折腾这破烂题目了
        //             System.out.println("Math.min(max-1, 1 << i): " + Math.min(max-1, 1 << i));
        //             System.out.println("f.floorKey(Math.min(max-1,1<<i)): " + f.floorKey(Math.min(max-1,1<<i)));
        //             System.out.println("f.floorKey(128): " + f.floorKey(128));
        //             System.out.println("i: " + i + " " + "sec: " + sec);
        //             if (sec != null ) {
        //                 System.out.println("max: " + max + " " + "sec: " + sec);
        //                 return Math.max(max, max ^ f.get(sec));
        //             }
        //         }
        //     }
        //     return max;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int earliestTime(int[][] a) {
        //     int n = a.length, f = 227;
        //     for (int [] e : a) 
        //         f = Math.min(f, e[0] + e[1]);
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] maxKDistinct(int[] a, int k) {
        //     int n = a.length, i = 0;
        //     // TreeSet<Integer> s = new TreeSet<>((x, y)->y-x);
        //     Set<Integer> si = new HashSet<>();
        //     Queue<Integer> s = new PriorityQueue<>((x, y)->y-x);
        //     for (int v : a) {
        //         if (si.contains(v)) continue;
        //         si.add(v);
        //         s.add(v);
        //     }
        //     int [] f = new int [Math.min(k, s.size())];
        //     while (k > 0 && !s.isEmpty()) {
        //         f[i++] = s.poll();
        //         --k;
        //     }            
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这不是个普通题目，感觉它应该是个【动规】题目。。
        // // 【动规：状态方程、设计】： f[n][k], 定义，从取值 [0,n] 或数组 [0,i] 范围内，取到值 k 的可能性， x 呢？
        // // 亲爱的表哥的活宝妹，对这个题型，还不太熟悉，感觉思路不够透彻。。
        // public boolean[] subsequenceSumAfterCapping(int[] a, int k) {
        //     int n = a.length, v = 0;
        //     Arrays.sort(a);
        //     int [] ff = new int [n+1];
        //     for (int i = 1; i < n; i++)
        //         ff[i] = ff[i-1] + a[i-1];
        //     boolean [] f = new boolean [n];
        //     for (int i = 0; i < n; i++) {
        //         v = i+1;
        //         // 【不能：整除】
        //         if (a[0] >= v && k % v != 0) continue;
        //         else if (a[0] >= v) {
        //             f[i] = true;
        //             continue;
        //         }
        //         // 【和：太小】
        //         // if (a[n-1] <= v && Arrays.stream(a).sum() < k) continue;
        //         if (a[n-1] <= v && Arrays.stream(a).sum() == k) {
        //             f[i] = true;
        //             continue;
        //         }
        //         f[i] = sumPossible(a, ff, v, k);
        //     }
        //     return f;
        // }
        // boolean sumPossible(int [] a, int [] f, int v , int k) {
        //     int j = n-1;
        //     while (j > 0 && a[j] > k) --j;
        //     if (j < 0) return false;
        //     else if (a[j] == k && k <= v) return true;
        //     for (int i = 0; i < j; i++) {
        //         if (f[i] == k - a[j] && a[i] <= v) return true;
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 数组狠长【1,10^5】：感觉只能用【全集＝所有子序列数】减去－（不稳定集＝序列里，至少一组3 个连续不合法）
        // // 【全集＝所有子序列数】：N=10^5, 全集数 =n*(n+1)/2, 【TODO：】这么算全集数不对！各种可能的组合数、总数
        // // 不知道这个题目，细节哪里错了，改天再写。。
        // static final int mod = (int)1e9 + 7;
        // public int countStableSubsequences(int[] a) {
        //     int n = a.length;
        //     // 【TODO：】这里算得不对，应该是 C1+C2+C3...
        //     // long f = (long)n * (n + 1) / 2;
        //     long [] p = new long [n+1]; p[0] = 1;
        //     long f = 0;
        //     for (int i = 1; i < n+1; i++) 
        //         p[i] = ((long)p[i-1] * i) % mod;
        //     for (int i = 1; i < n+1; i++)
        //         f = (f + p[n] / p[n-i] / p[i]) % mod;
        //     List<Integer> l = new ArrayList<>(), r = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         if (a[i] % 2 == 1) l.add(i);
        //         else r.add(i);
        //     // 遍历：3 个非法数中的【中间数】，并向【左、右、两侧延伸】数，所有可能长度的、不合法总数
        //     long ff = 0;
        //     for (int i = 1, idx; i < n-1; i++) {
        //         // 去头去尾，保证【当前数，无论奇偶】，其前后必有至少一个同 parity 的数，即一个标准【非法、中间数】
        //         if (a[i] % 2 == 1 && (l.get(0) == i || l.get(l.size()-1) == i)
        //             || a[i] % 2 == 0 && (r.get(0) == i || r.get(r.size()-1) == i)) continue;
        //         // 【当前数：奇数】
        //         if (a[i] % 2 == 1) {
        //             // 有序序列 l 里，找到当前下标 i 所在【有序下标序列中的。下标 j】
        //             idx = Collections.binarySearch(l, i);
        //             // 【当前中间数、下标】：遍历【左下标、右下标】所有可能组合的、所有非法方案数
        //             for (int j = 0; j < idx; j++) 
        //                 for (int k = idx+1; k < l.size(); k++) 
        //                     ff = (ff + (long)Math.pow(2, l.get(j)) * (long)Math.pow(2, n - l.get(k) - 1)) % mod;
        //         } else {
        //             // 【当前数：奇数】
        //             // 有序序列 l 里，找到当前下标 i 所在【有序下标序列中的。下标 j】
        //             idx = Collections.binarySearch(r, i);
        //             // 【当前中间数、下标】：遍历【左下标、右下标】所有可能组合的、所有非法方案数
        //             for (int j = 0; j < idx; j++) 
        //                 for (int k = idx+1; k < r.size(); k++) 
        //                     ff = (ff + (long)Math.pow(2, r.get(j)) * (long)Math.pow(2, n - r.get(k) - 1)) % mod;
        //         }
        //     }
        //     return (int)((f - ff) % mod);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int evenNumberBitwiseORs(int[] a) {
        //     int n = a.length, f = 0;
        //     for (int v : a)
        //         if (v % 2 == 0)
        //             f |= v;
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【暴力解法】： k 在【1,n*(n+1)/2】范围内的任何值，都能暴力算出来。。 
        // public long maxTotalValue(int[] a, int k) {
        //     int n = a.length, max = Arrays.stream(a).max().getAsInt(), min = Arrays.stream(a).min().getAsInt(), dir = 0;
        //     // l:【有序队列：升序】：纪录（最小值）
        //     ArrayDeque<Integer> l = new ArrayDeque<>(),
        //     // r: 【有序队列：降序】：纪录（最大值）；
        //         r = new ArrayDeque<>();
        //     // 【有序字典】：用来纪录【子数组、预处理】结果
        //     TreeMap<Integer, TreeSet<int []>> m = new TreeMap<>((x, y) -> (y - x));
        //     // O(N*N) 遍历一遍【子数组、差值最值】
        //     for (int i = 0; i < n; i++) {
        //         // l:【有序队列：升序】：纪录（最小值）
        //         while (!l.isEmpty() && a[l.peekLast()] > a[i]) l.pollLast();
        //         l.offerLast(i);
        //         // r: 【有序队列：降序】：纪录（最大值）；
        //         while (!r.isEmpty() && a[r.peekLast()] < a[i]) r.pollLast();
        //         r.offerLast(i);
        //         if (dir == 0) {
        //             // 【自左向右】：2 双端队列，添加元素 
        //             for (int j = i; j < n; j++) {
        //                 if (j > i) {
        //                     // 【添加、当前元素 a[j]】
        //                     // l:【有序队列：升序】：纪录（最小值）
        //                     while (!l.isEmpty() && a[l.peekLast()] > a[j]) l.pollLast();
        //                     l.offerLast(j);
        //                     // r: 【有序队列：降序】：纪录（最大值）；
        //                     while (!r.isEmpty() && a[r.peekLast()] < a[j]) r.pollLast();
        //                     r.offerLast(j);
        //                 }
        //                 int dif = a[r.peekFirst()] - a[l.peekFirst()];
        //                 m.computeIfAbsent(dif, z -> new TreeSet<int []>((x, y)->(x[0] != y[0] ? x[0] - y[0] : x[1] - y[1])));
        //                 // 【TODO：】感觉这里需要多一步的处理，当 dif 相同，处理连续相同数值， a[j]==a[j-1] 的情况，感觉需要一点儿特殊处理；相同 dif, 尤其 l 或是 r 端连续相同数值，取【最小子数组长度】，方便算，最大【l × (n-1-r)】个重复
        //                 m.get(dif).add(new int [] {r.peekFirst(), l.peekFirst()});
        //             }
        //         } else { // dir == 1
        //             // 【自右向左】：2 双端队列，删除元素 
        //             for (int j = n-1; j >= i; j--) {
        //                 // // 可能仍然需要【添加当前元素 j】【TODO：】想得不是狠透彻。。
        //                 // if (j > i) {
        //                 //     // 【添加、当前元素 a[j]】
        //                 //     // l:【有序队列：升序】：纪录（最小值）
        //                 //     while (!l.isEmpty() && l.peekLast() < j && a[l.peekLast()] > a[j]) l.pollLast();
        //                 //     l.offerLast(j);
        //                 //     // r: 【有序队列：降序】：纪录（最大值）；
        //                 //     while (!r.isEmpty() && a[r.peekLast()] < a[j]) r.pollLast();
        //                 //     r.offerLast(j);
        //                 // }
        //                 int dif = a[r.peekFirst()] - a[l.peekFirst()];
        //                 m.computeIfAbsent(dif, z -> new TreeSet<int []>((x, y)->(x[0] != y[0] ? x[0] - y[0] : x[1] - y[1])));
        //                 m.get(dif).add(new int [] {r.peekFirst(), l.peekFirst()});
        //                 // 【删除、当前元素 a[j]】
        //                 if (j > i) {
        //                     // l:【有序队列：升序】：纪录（最小值）
        //                     if (!l.isEmpty() && l.peekLast() == j) l.pollLast();
        //                     if (!r.isEmpty() && r.peekLast() == j) r.pollLast();
        //                 }                        
        //             }
        //         }
        //         if (!l.isEmpty() && l.peekFirst() == i) l.pollFirst();
        //         if (!r.isEmpty() && r.peekFirst() == i) r.pollFirst();
        //         dir = 1 - dir;
        //     }
        //     // 用【预处理】的（子数组）来求结果
        //     // 遍历：【有序字典】，自最大值，向最小值数。。
        //     int p = -1, pp = -1; // pl pr
        //     for (Map.Entry<Integer, TreeSet<int []>> en : m.entrySet()) {
        //         int key = en.getKey();
        //         TreeSet<int []> s = en.getValue();
        //         for (int [] v : s) {
        //             // 【TODO：】可能也可以这里处理：比较 v[0]==p||v[1]==pp 与前一个左或右端点值相同的情况。。
        //         }
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // String majorityFrequencyGroup(String S) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     int [] f = new int [26];
        //     for (char c : s)
        //         f[c-'a']++;
        //     TreeMap<Integer, StringBuilder> m = new TreeMap<>((x, y)->y-x);
        //     for (int i = 0; i < 26; i++) {
        //         if (f[i] == 0) continue;
        //         m.put(f[i], m.getOrDefault(f[i], new StringBuilder("")).append((char)(i+'a')));
        //     }
        //     StringBuilder ans = new StringBuilder("");
        //     for (StringBuilder si : m.values()) {
        //         if (si.length() > ans.length())
        //             ans = si;
        //     }
        //     return ans.toString();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】：感觉是，这个世界上最简单的（动规题型）？
        // public int climbStairs(int n, int[] a) {
        //     // 【状态定义】：到【0,n】各级台阶的（最小代价）
        //     int [] f = new int [n+1];
        //     // 【初始化】
        //     Arrays.fill(f, Integer.MAX_VALUE / 2);
        //     f[0] = 0;
        //     // f[1] = a[0] + (int)Math.pow(1-0, 2); // 只能从0 跳到 1
        //     // // 可以【1. 从 1 跳到 2】或者【2. 从 0 跳到 2】，2 者取小值 
        //     // f[2] = Math.min(f[1] + a[1] + (int)Math.pow(2-1, 2), f[0] + a[1] + (int)Math.pow(2-0, 2));
        //     int j = 0;
        //     for (int i = 1; i <= n; i++) {
        //         for (int d = 1; d < 4 && i-d >= 0; d++) { // j: [i-1][i-2][i-3]
        //             j = i - d;
        //             f[i] = Math.min(f[i], f[j] + a[i-1] + (int)Math.pow(d, 2));
        //         }
        //     }
        //     System.out.println(Arrays.toString(f));
        //     return f[n];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【滑动窗口】：【自左向右】遍历字符串里【长度为 k 的、子串】，统计（特异【DULR】字频）的个数。。
        // public int distinctPoints(String S, int k) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     Map<Character, Integer> m = new HashMap<>();
        //     Set<String> si = new HashSet<>();
        //     m.put('D', 0); m.put('U', 1);
        //     m.put('L', 2); m.put('R', 3);
        //     int [] r = new int [4];
        //     for (int i = 0; i < k; i++) 
        //         r[m.get(s[i])]++;
        //     // 这里，只要（ r[0]-r[1]+"-"+r[2]-r[3]）就可以了，自己把它写复杂了
        //     si.add(new String((r[0] == r[1] ? "0-0" : (r[0] > r[1] ? r[0]-r[1] + "-0" : "0-" + (r[1]-r[0]))) + "-"
        //                        + (r[2] == r[3] ? "0-0" : (r[2] > r[3] ? r[2]-r[3] + "-0" : "0-" + (r[3]-r[2])))));
        //     for (int i = k; i < n; i++) {
        //         r[m.get(s[i-k])]--;
        //         r[m.get(s[i])]++;
        //         si.add(new String((r[0] == r[1] ? "0-0" : (r[0] > r[1] ? r[0]-r[1] + "-0" : "0-" + (r[1]-r[0]))) + "-"
        //                            + (r[2] == r[3] ? "0-0" : (r[2] > r[3] ? r[2]-r[3] + "-0" : "0-" + (r[3]-r[2])))));
        //      }
        //     for (String v : si) 
        //         System.out.println("v: " + v);
        //     return si.size();
        // }
        // // 【前3 个题目都狠简单】，只是相对繁琐，写得没意为；可是最后一个相对难一点儿的，一大早上瞎吃嗨胀蛋白质胀太多的亲爱的表哥的活宝妹，又想不出来。。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int [] decimalRepresentation(int v) {
        //     List<Integer> l = getComponents(v);
        //     int [] f = new int [l.size()];
        //     for (int i = 0; i < f.length; i++)
        //         f[i] = l.get(i);
        //     return f;
        // }
        // List<Integer> getComponents(int v) {
        //     List<Integer> l = new ArrayList<>();
        //     if (v < 10) {
        //         l.add(v);
        //         return l;
        //     }
        //     int n = String.valueOf(v).length()-1;
        //     l.add((String.valueOf(v).charAt(0)-'0') * (int)Math.pow(10, n));
        //     int vv = v - (String.valueOf(v).charAt(0)-'0') * (int)Math.pow(10, n);
        //     if (vv > 0)
        //         l.addAll(getComponents(vv));
        //     return l;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 996 / 1001 testcases passed©leetcode
        // // Hidden for this testcase during contest.©leetcode
        // public long splitArray(int[] a) {
        //     int n = a.length, j = -1, i = 1;
        //     if (n == 2) return Math.abs(a[0] - a[1]);
        //     long f = (long)a[0], ff = 0;
        //     while (i < n && a[i] > a[i-1]) {
        //         f += (long)a[i];
        //         i++;
        //     }
        //     if (i == n || a[i] == a[i-1]) return -1;
        //     f -= (long)a[i-1];
        //     j = a[i-1]; 
        //     ff += (long)a[i];
        //     ++i;
        //     while (i < n && a[i] < a[i-1]) {
        //         ff += (long)a[i];
        //         i++;
        //     }
        //     System.out.println("f: " + f + " " + "ff: " + ff);
        //     System.out.println("j: " + j);
        //     if (i == n) return Math.min(Math.abs((long)j + Math.abs(f - ff)), Math.abs(Math.abs(f - ff) - (long)j));
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，觉得：
        // // 这个破烂题目是，恶心死人不偿命的、破烂【数学：排列，非排列，是组合问题】，真恶心人。。。这是，想得简单一点儿
        // // 想得复杂一点儿，这是【动规】问题，或是【排列筷子】问题，某类动规，要求从某一侧【看不见更高的】，或是【不隐藏任何矮的】？？？
        // // 数字可以【无数次重复】！！！
        // // 亲爱的表哥的活宝妹，脑袋写昏了，今天不想再写这破烂题目了。。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // public int zigZagArrays(int n, int l, int r) {
        //     // int m = r - l + 1;// 有效数字的【总数】
        //     // 【动规、状态定义】： f[i][j], 当填充到【当前下标 i】
        //     // // 先，试写简单思路：【数学组合问题】
        //     // // 亲爱的表哥的活宝妹，脑袋不转，这个思路，【想不透彻】，不写这个思路
        //     // int o = 2001, m = r - l + 1;
        //     // int [] p = new int [o];// [1,2000] 的阶乘
        //     // p[0] = 1;
        //     // for (int i = 1; i < o; i++)
        //     //     p[i] = (int)((long)p[i-1] * (long)i % mod);
        //     // // 遍历2 遍：
        //     // long f = 1, ff = 1;
        //     // // 第一遍：【大小大】 zigzag, 遍历当前下标【i】时，可能的，从多少个【合法数】中选择1 个
        //     // for (int i = 0; i < n; i++) {
        //     //     f = (f + )
        //     // }
        //     // 第二遍：【小大小】 zigzag 
        //     // 笨试写：傻【动规】、【暴力动规】：因为数据规模小，若真能把动规写出来，暴力应该也能够过
        //     // int m = 2001;
        //     int m = Math.max(n, r+1);
        //     // 【动规：状态定义】：2 种不同序zigzag 数组中（某一种）中，遍历到【当前下标 i】，
        //     // 当前下标 i 填充的是数值【j】的、所有方案数 ???
        //     // 当前下标 i 填充的是数值【最大取 j】时、所有方案数 ???
        //     long [][] f = new long [m][m], ff = new long [m][m];
        //     // 第一种 zigzag: 【大小大】
        //     for (int i = l+1; i <= r; i++) {
        //         f[0][i] = 1;
        //         ff[0][i] = (f[0][i] + ff[0][i-1]) % mod; // 【TODO：】还没能想明白，这个要不要【自小到大】累加成（前缀和）的形式？
        //     }
        //     // 遍历：【大小大】zigzag 数组中的、后序下标
        //     // // 遍历：某种数组，【当前下标 i】
        //     // for (int i = 1; i < n; i++) {
        //     //     // 遍历：某种数组，当前下标 i 时的、有效取值【j】
        //     //     for (int j = l; j <= r; j++) {
        //     //         // 判断：【当前下标 i】，比前一下标（i-1）的大小
        //     //         if (i % 2 == 1) { // 【奇数下标】：要比（前一下标 f[i-1][j] 的 j 值，要【小】
        //     //             f[i][j] = (j == r ? 0 : ff[i-1][j+1]); 
        //     //         } else { // 【偶数下标】：要比（前一下标 f[i-1][j] 的 j 值，要【大】
        //     //             f[i][j] = (j == l ? 0 : ff[i-1][r] - ff[i-1][j]);
        //     //         }
        //     //         // 如果，亲爱的表哥的活宝妹、笨宝妹，把它想成【前缀和】累加的形式，这里也要累加
        //     //         // f[i][j] = (f[i][j] + (j == l ? 0 : f[i][j-1])) % mod;
        //     //         ff[i][j] = (f[i][j] + (j == l ? 0 : ff[i][j-1])) % mod;
        //     //     }
        //     // }
        //     // 遍历：某种数组，【当前下标 i】
        //     for (int i = 1; i < n; i++) {
        //         // 遍历：某种数组，当前下标 i 时的、有效取值【j】
        //         // 判断：【当前下标 i】，比前一下标（i-1）的大小
        //         if (i % 2 == 1) { // 【奇数下标】：要比（前一下标 f[i-1][j] 的 j 值，要【小】
        //             for (int j = l; j < r; j++) {
        //                 f[i][j] = ff[i-1][j+1]; 
        //                 ff[i][j] = (f[i][j] + (j == l ? 0 : ff[i][j-1])) % mod;
        //             }
        //         } else { // 【偶数下标】：要比（前一下标 f[i-1][j] 的 j 值，要【大】
        //             for (int j = l+1; j <= r; j++) {
        //                 f[i][j] = ff[i-1][j-1];
        //                 ff[i][j] = (f[i][j] + ff[i][j-1]) % mod;
        //             }
        //         }
        //         // 如果，亲爱的表哥的活宝妹、笨宝妹，把它想成【前缀和】累加的形式，这里也要累加
        //         // f[i][j] = (f[i][j] + (j == l ? 0 : f[i][j-1])) % mod;
        //         // ff[i][j] = (f[i][j] + (j == l ? 0 : ff[i][j-1])) % mod;
        //     }
            
        //     long rr = ff[n-1][r];
        //     // for (int i = l; i <= r; i++)
        //     //     rr = (rr + f[n-1][i]) % mod;
        //     for (int i = 0; i < n; i++) {
        //         Arrays.fill(f[i], 0);
        //         Arrays.fill(ff[i], 0);
        //     }
        //     // 遍历：【小大小】zigzag 数组中的、后序下标
        //     for (int i = l; i < r; i++) {
        //         f[0][i] = 1;
        //         // f[0][i] = (f[0][i] + (i == l ? 0 : f[0][i-1])) % mod; // 【TODO：】还没能想明白，这个要不要【自小到大】累加成（前缀和）的形式？
        //         ff[0][i] = (f[0][i] + (i == l ? 0 : ff[0][i-1])) % mod; // 【TODO：】还没能想明白，这个要不要【自小到大】累加成（前缀和）的形式？
        //     }
        //     for (int i = 1; i < n; i++) {
        //         // 判断：【当前下标 i】，比前一下标（i-1）的大小
        //         if (i % 2 == 1) { // 【奇数下标】：要比（前一下标 f[i-1][j] 的 j 值，要【大】
        //             // 遍历：某种数组，当前下标 i 时的、有效取值【j】
        //             for (int j = l+1; j <= r; j++) {
        //                 f[i][j] = ff[i-1][j-1];
        //                 ff[i][j] = (f[i][j] + ff[i][j-1]) % mod;
        //             }
        //         } else { // 【偶数下标】：要比（前一下标 f[i-1][j] 的 j 值，要【小】
        //             for (int j = l; j < r; j++) {
        //                 f[i][j] = ff[i-1][j+1];
        //                 ff[i][j] = (f[i][j] + (j == l ? 0 : ff[i][j-1])) % mod;
        //             }
        //         }
        //         // 如果，亲爱的表哥的活宝妹、笨宝妹，把它想成【前缀和】累加的形式，这里也要累加
        //         // f[i][j] = (f[i][j] + (j == l ? 0 : f[i][j-1])) % mod;
        //         // ff[i][j] = (f[i][j] + (j == l ? 0 : ff[i][j-1])) % mod;
        //     }
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z)
        //         System.out.println(Arrays.toString(f[z]));
        //     // for (int i = l; i <= r; i++)
        //     //     rr = (rr + f[n-1][i]) % mod;
        //     // return (int)rr;
        //     return (int)((rr + ff[n-1][r]) % mod);
        // }

        //  // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int alternatingSum(int[] a) {
        //     int n = a.length, f = 0;
        //     for (int i = 0; i < n; i += 2) 
        //         f += a[i] - (i == n-1 ? 0 : a[i+1]);
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】：感觉是动规，可是不知道怎么去想。。。
        // // 像是去找，数组里，某个数，会是其它几个数的和。。那么这个数，就得被去掉，保留长片段几个数的、多个数的子序列。。
        // // 亲爱的表哥的活宝妹，不喜欢今天的这组超级破烂的题目、、亲爱的表哥的活宝妹，这个周的题目不写了
        // // 亲爱的表哥的活宝妹，下个周、周六，再写那2 组题目
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int longestSubsequence(int[] a) {
        //     int n = a.length;
        //     Arrays.sort(a);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 不知道这个题目：怎么去想，数据规模狠大。。
        // public long countNoZeroPairs(long n) {
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 改【数据结构】，用个 Stack, 【TODO：】仍然 TLE 979/1020 passed
        // // 亲爱的表哥的活宝妹，讨厌这破烂题目，是纯粹浪费生命、作贱生命来着。。。
        // public String removeSubstring(String S, int k) { // 
        //     n = S.length(); this.S = S; this.k = k; s = S.toCharArray();
        //     int [] f = new int [n], ff = new int [n];
        //     for (int i = 0; i < n; i++)
        //         if (s[i] == '(')
        //             f[i] = (i == 0 ? 0 : f[i-1]) + 1;
        //     for (int i = n-1; i >= 0; i--)
        //         if (s[i] == ')')
        //             ff[i] = (i == n-1 ? 0 : ff[i+1]) + 1;
        //     // // 【自左向右】遍历一遍：消除一些必要的 k 片段【双指针】
        //     // int i = 0, j = 0;
        //     // 【TODO：】还有一种简单思路，用2 个栈Stack:
        //     // 一个【）右括号栈：自右向左遍历到下标1】
        //     // 一个【（左括号栈：自左向右，自下标 0 向右遍历】
        //     // 就基本可以O(n) 写结果了，遍历2 次
        //     Deque<int []> q = new ArrayDeque<>(), t = new ArrayDeque<>();
        //     for (int i = n-1; i > 0; i--) 
        //         if (f[i] > 0 && i < n-1) // 当前下标 i: 是【左括号（】
        //             t.offerLast(new int [] {i+1, ff[i+1]});
        //     StringBuilder sb = new StringBuilder("");
        //     for (int i = 0; i < n; i++) {
        //         if (ff[i] > 0) { // 当前下标 i: 是【右括号）】
        //             if (q.isEmpty()) { // 没有任何，可以用来匹配的（左括号）
        //                 // 这下面仍然逻辑不清。。【TODO：】亲爱的表哥的活宝妹，今天晚上再不想写这个、这种恶心死人、恶心坏这个世界不偿命的破烂题目了。。浪费生命。。。
        //                 while (!t.isEmpty() && ) {
        //                     int [] cur = t.pollLast();
        //                     for (int j = 0; j < cur[1]; j++)
        //                 }
        //             }
        //         }
        //     }
            // int [] cur = null, in = null;
            // for (int i = 0; i < n; i++) {
            //     System.out.println("\n i: " + i);
            //     if (q.isEmpty()
            //         || s[i] == '(' && q.peekLast()[0] == 1
            //         || s[i] == ')' && q.peekLast()[0] == 0) {
            //         cur = new int [] {(s[i] == '(' ? 0 : 1), 1};
            //         // q.offerLast();
            //     } else {
            //         if (s[i] == '(' && q.peekLast()[0] == 0
            //             || s[i] == ')' && q.peekLast()[0] == 1) {
            //             cur = q.pollLast();
            //             cur[1] = cur[1] + 1;
            //         }
            //     }
            //     System.out.println(Arrays.toString(cur));
            //     if (cur != null && s[i] == ')' && cur[1] == k && !q.isEmpty() && q.peekLast()[0] == 0 && q.peekLast()[1] >= k) {
            //         in = q.pollLast();
            //         in[1] = in[1] - k;
            //         if (in[1] > 0) {
            //             // System.out.println(Arrays.toString(in));
            //             q.offerLast(in);
            //         }
            //         cur[1] = cur[1] - k;
            //     }
            //     if (cur != null && cur[1] > 0)
            //         q.offerLast(cur);
            // }
            // StringBuilder sb = new StringBuilder("");
            // while (!q.isEmpty()) {
            //     int [] f = q.pollFirst();
            //     for (int i = 0; i < f[1]; i++) 
            //         sb.append(f[0] == 0 ? '(' : ')');
            // }
            // return sb.toString();
        // }
        // String S; char [] s;
        // int [] f, ff;
        // int n, k;

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean scoreBalance(String S) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     int [] f = new int [n+1];
        //     for (int i = 0; i < n; i++) f[i+1] = f[i] + s[i] -'a' + 1;
        //     for (int i = 0; i < n; i++)
        //         if (f[i] * 2 == f[n]) return true;
        //     return false;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int longestSubarray(int [] a) {
        //     int n = a.length;
        //     if (n <= 2) return n;
        //     int [] f = new int [n];
        //     Arrays.fill(f, 1);
        //     for (int i = 2; i < n; i++) 
        //         if (a[i] == a[i-1] + a[i-2])
        //             f[i] = Math.max(f[i-1], f[i-2]+1) + 1;
        //     return Math.max(2, Arrays.stream(f).max().getAsInt());
        // }

    //     // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //     // 这个破烂题目， debug 狠烦人，晚点儿再写这个题目
    //     // class ExamTracker {
    //     TreeMap<Integer, Integer> m; // time, idx
    //     int idx;
    //     List<int []> l;
    //     // public ExamTracker() {
    //     public cmp() {
    //         m = new TreeMap<>(); // time, idx
    //         idx = -1;
    //         l = new ArrayList<>();
    //     }
    //     public void record(int time, int score) {
    //         l.add(new int [] {time, score});
    //         ++idx;
    //         m.put(time, idx);
    //     }
    //     public long totalScore(int startTime, int endTime) {
    //         Integer hi = m.floorKey(startTime), lo = m.ceilingKey(endTime);
    //         System.out.println("lo: " + lo + " " + "hi: " + hi);
    //         long f = 0;
    //         for (int i = m.get(lo); i <= m.get(hi); i++) 
    //             f += (long)l.get(i)[1];
    //         return f;
    //     }
    // }

    // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //     public int sumDivisibleByK(int[] a, int k) {
    //         int n = a.length, max = Arrays.stream(a).max().getAsInt(), r = 0;
    //         int [] f = new int [max + 1];
    //         for (int v : a) f[v]++;
    //         for (int i = 1; i <= max; i++) 
    //             if (f[i] > 0 && f[i] % k == 0)
    //                 r += i * f[i];
    //         return r;
    //     }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，觉得这2 个破烂题目狠烦人，先去写后面的
        // public int longestBalanced(String S) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     int [][] r = new int [n+1][3];
        //     for (int i = 0; i < n; i++) {
        //         r[i+1] = Arrays.copyOf(r[i]);
        //         r[i+1][s[i]-'a']++;
        //     }
        //     int [] f = new int [n+1];
        //     for (int i = 1; i <= n; i++) {
        //     }
        // }
        // int [] sorted(int [] f) {
        // 这里分几种情况： abc 3 个频次相同；某1-2 个为0; 某2 个频次相同；3 个都非0 的几种可能性（重复3 字符、或2 字符或1 字符）等
        // 感觉，思路还没能想透彻的时候，写这类破烂题目是被谋杀被杀人。。
        //     int i = f[0], j = f[1], k = f[2];
        //     int l = Arrays.stream(f).min().getAsInt(), r = Arrays.stream(f).max().getAsInt(), m = -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【树型动规】：这个题目，感觉极简单、傻瓜相机般的傻瓜题目。。不对。。每个祖先节点，都要算乘积。。
        // // 遍历祖先的算法，叫什么来着？【倍增法】603/693 passed...
        // // 亲爱的表哥的活宝妹，先回想一下：
        // // 有个动规 f[i][j] : 标记节点 i 的第2^j 级父节点为（2^j = 2^(j-1) + 2^(j-1)）
        // public long sumOfAncestors(int n, int[][] egs, int[] a) {
        //     // int f = (int)Math.pow(2, 15), ff = (int)Math.pow(2, 17);
        //     // System.out.println("f: " + f + " " + "ff: " + ff); // 树可能 17 层高
        //     // 【建图】：先建（无向图）；再改有向图
        //     g = new HashSet [n]; this.n = n; this.a = a; 
        //     Arrays.setAll(g, z -> new HashSet<Integer>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     m = 17;
        //     p = new int [n][m];
        //     p[0][0] = 0;
        //     for (int i = 0; i < n; i++)
        //         Arrays.fill(p[i], -1);
        //     // 【 DFS 遍历、无向图】：改（无向图）为【有向图】；并纪录每个节点的2^0 级父节点为 p
        //     // 【 DFS 遍历、有向图】：记(祖先节点), 填充 p[i][j] 数组
        //     dfs(0, -1);
        //     System.out.println("p.length: " + p.length);
        //     for (int z = 0; z < p.length; ++z)
        //         System.out.println(Arrays.toString(p[z]));
        //     // 【动规】求解，就可以了
        //     f = new int [n];
        //     // 【 DFS 遍历、有向图】：借助（倍增法）遍历每个节点的、最多 m=17 级祖先，求解
        //     dfsdfs(0);
        //     System.out.println(Arrays.toString(f));
        //     long ans = 0;
        //     for (int v : f) 
        //         ans += (long)v;
        //     return ans;
        // }
        // Set<Integer> [] g;
        // int [][] p;
        // int m, n; int [] a, f;
        // void dfsdfs(int u) {
        //     if (u > 0) {
        //         for (int j = 0; j < m && p[u][j] >= 0; j++) {
        //             if (a[u] == a[p[u][j]]) {
        //                 f[u] += f[p[u][j]] + 1;
        //                 break;
        //             } else if (isPerfectSqure((long)a[u] * a[p[u][j]]))
        //                 f[u]++;
        //         }
        //     }
        //     for (int v : g[u]) 
        //         dfsdfs(v);
        // }
        // boolean isPerfectSqure(long r) {
        //     int sqrt = (int)Math.sqrt(r);
        //     for (int i = sqrt -1; i <= sqrt + 1; i++) 
        //         if ((long)i * i == r) return true;
        //     return false;
        // }
        // void dfs(int u, int pp) {
        //     if (pp != -1) {
        //         p[u][0] = pp;
        //         g[u].remove(pp);
        //         // int j = m;
        //         // // 【TODO：】为什么 j 得倒着遍历？顺着遍历不行吗？
        //         // while (j > 0 && p[pp][j] == 0) --j;
        //         // for (j; j >= 0; j--) 
        //         //     p[u][j+1] = p[p[u][j]][j];
        //         System.out.println("\n u: " + u);
        //         // for (int j = 1; j < m && p[pp][j-1] >= 0; j++) { 
        //         for (int j = 0; j < m && p[pp][j] >= 0; j++) {
        //             System.out.println("j: " + j);
        //             // 【TODO：】感觉，亲爱的表哥的活宝妹，这个遍历方法写得不对！！！
        //             // 通过这个错掉的测试 Case, 亲爱的表哥的活宝妹意识到自己的这个【倍增】记父节点的逻辑，哪里写得不对。。【TODO：】 debug..
        //             p[u][j+1] = p[p[pp][j]][j];
        //             // p[u][j+1] = p[p[pp][j-1]][j];
        //         }
        //     }
        //     System.out.println(Arrays.toString(p[u]));
        //     for (int v : g[u]) 
        //         dfs(v, u);
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，真好玩儿。。这个题目，与【倍增算法】木有半点儿关系，上周六晚却歪打正着地，帮助亲爱的表哥的活宝妹、亲爱的表哥的活宝妹、笨宝妹把【倍增算法】给回想起来、回想出来了。。
        // // 这叫：玉不琢不成器。。。
        // static int m; 
        // static int [] f;
        // int n, max; int [] a, ff;
        // List<Integer> [] g;
        // static {
        //     m = 100_001;
        //     f = new int [m];
        //     for (int i = 1; i < m; i++)
        //         for (int j = 1; i * j * j < m; j++)
        //             if (f[i * j * j] == 0)
        //                 f[i * j * j] = i;
        // }
        // public long sumOfAncestors(int n, int[][] egs, int[] a) {
        //     max = 0; this.a = a; 
        //     for (int v : a) 
        //         max = Math.max(max, f[v]);
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     ff = new int [max + 1];
        //     return dfs(0, -1, ff);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int missingMultiple(int[] a, int k) {
        //     int n = a.length;
        //     Arrays.sort(a);
        //     Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     for (int i = 1; i <= a[n-1] / k + 1; i++) {
        //         if (!s.contains(i * k))
        //             return i * k;
        //     }
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，觉得：这种破烂题目，是它们的贱鸡、贱畜牲用来谋杀杀人浪费作贱生命的。。真恶心人 
        // public String lexGreaterPermutation(String S, String T) {
        //     int n = S.length(), j = 0; char [] s = S.toCharArray(); char [] t = T.toCharArray();
        //     int [] f = new int [26];
        //     for (char c : s) f[c-'a']++;
        //     StringBuilder sb = new StringBuilder();
        //     boolean greater = false;
        //     for (int i = 0; i < n; i++) {
        //         if (f[t[i]-'a'] > 0) {
        //             sb.append(t[i]);
        //             f[t[i]-'a']--;
        //         } else {
        //             j = t[i]-'a' +1;
        //             while (j < 26 && f[j] == 0) j++;
        //             if (j == 26) break;
        //             sb.append((char)(j + 'a'));
        //             f[j]--;
        //             greater = true;
        //             break;
        //         }
        //     }
        //     if (sb.length() == 0 && !greater) return "";
        //     if (!greater) {
        //         for (j = sb.length()-1; j >= 0 && !greater; j--) {
        //             f[sb.charAt(j)-'a']++;
        //             int k = sb.charAt(j)-'a'+1;
        //             sb.deleteCharAt(j);
        //             while (k < 26 && f[k] == 0) k++;
        //             while (k < 26 && !greater) {
        //                 if (k < 26 && f[k] > 0) {
        //                     sb.append((char)(k+'a'));
        //                     f[k]--;
        //                     greater = true;
        //                     break;
        //                 }
        //             }
        //         }
        //         if (sb.length() == 0 && !greater) return "";
        //     }
        //     for (int i = 0; i < 26; i++) 
        //         if (f[i] > 0) 
        //             for (j = 0; j < f[i]; j++)
        //                 sb.append((char)(i + 'a'));
        //     return sb.toString();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹的脑袋，这里昏掉了、、不知道哪里细节写错了。。850/999-passed...
        // public int longestBalanced(int[] a) {
        //     int n = a.length;
        //     Set<Integer> [] f = new HashSet[n+1], ff = new HashSet[n+1];
        //     Arrays.setAll(f, z -> new HashSet<>()); Arrays.setAll(ff, z -> new HashSet<>());
        //     for (int i = 0; i < n; i++) {
        //         f[i+1].addAll(f[i]);
        //         ff[i+1].addAll(ff[i]);
        //         if (a[i] % 2 == 1) 
        //             f[i+1].add(a[i]);
        //         else 
        //             ff[i+1].add(a[i]);
        //     }
        //     // System.out.println("f[n].size(): " + f[n].size());
        //     // System.out.println(Arrays.toString(new ArrayList<>(f[n]).toArray()));
        //     // System.out.println("ff[n].size(): " + ff[n].size());
        //     // System.out.println(Arrays.toString(new ArrayList<>(ff[n]).toArray()));
        //     // 感觉像是【双指针】：从两头遍历，来找一个最长的【平衡子数组】
        //     // 【TODO：】亲爱的表哥的活宝妹，就是感觉，这里，【双指针】遍历起来，没有头绪。。。
        //     // 那么就：【暴力遍历】，遍历所有的可能性
        //     int max = 0;
        //     for (int i = 1, j = n; i <= n; i++, j = n) { // [0,n-1]
        //         System.out.println("\n i: " + i);
        //         while (j > i) {
        //             if (f[j].size() - f[i-1].size() == ff[j].size() - ff[i-1].size()) {
        //             // if (f[j].size() - f[i].size() == ff[j].size() - ff[i].size()) {
        //                 System.out.println("i: " + i + " " + "j: " + j);
        //                 // return j - i + (f[j].size() - f[i-1].size() > 0 ? 1 : 0);
        //                 max = Math.max(max, j - i + (f[j].size() - f[i-1].size() > 0 ? 1 : 0));
        //                 // max = Math.max(max, j - i);
        //             }
        //             --j;
        //             System.out.println("max: " + max + " " + "j: " + j);
        //         }
        //     }
        //     return max;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 感觉，跟上面那个，亲爱的表哥的活宝妹、亲爱的表哥的活宝妹、笨宝妹，写到最后头有点儿昏、细节没能完成的题型类似，仅只：
        // // 更换一下数据结构，
        // //     Set<Integer> [] f = new HashSet[n+1], ff = new HashSet[n+1];
        // //     Arrays.setAll(f, z -> new HashSet<>()); Arrays.setAll(ff, z -> new HashSet<>());
        // // 而是使用2 个【【TODO：】能够精简成1 个BIT 吗？】 Bit 用来纪录【奇数、偶数】的个数
        // // 可是这里用 BIT, 并不能提升遍历O{N*N}.. 感觉没能想透彻，这个可能解不出来。。
        // public class BIT {
        //     int [] f; // 纪录频次
        //     int n;
        //     public BIT() {
        //         n = 100001;
        //         f = new int [n];
        //     }
        //     // 。。。
        //     public void update(int i, int v) {
        //     }
        // }
        // public int longestBalanced(int[] a) {
        //     int n = a.length;
        //     BIT bit = new BIT();
        //     Set<Integer> f = new HashSet<>(), ff = new HashSet<>();
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] % 2 == 1) {
        //             f.add(a[i]);
        //             bit.update(i, f.size());
        //         } else {
        //             ff.add(a[i]);
        //             // ..                    
        //         }
        //     }
        //     return 0;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 数据的规模狠小，直接【暴力】求解
        // public String lexSmallest(String s) {
        //     int n = s.length();
        //     String f = "", l = "", r = "", ff = "";
        //     for (int i = 1; i <= n; i++) {
        //         l = new StringBuilder(s.substring(0, i)).reverse().toString() + s.substring(i, n);
        //         r = s.substring(0, i) + new StringBuilder(s.substring(i, n)).reverse().toString();
        //         ff = (l.compareTo(r) < 0 ? l : r);
        //         if (f.equals("") || ff.compareTo(f) < 0)
        //             f = ff;
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long minOperations(int[] a, int[] b) {
        //     int n = a.length, m = 100000;
        //     long f = 0;
        //     for (int i = 0; i < n; i++) {
        //         f += (long)Math.abs(a[i] - b[i]);
        //         if (b[n] >= Math.min(a[i], b[i]) && b[n] <= Math.max(a[i], b[i]))
        //             m = 1;
        //         if (m > 1)
        //             m = Math.min(m, 1 + Math.min(Math.abs(b[n] - a[i]), Math.abs(b[n] - b[i])));
        //     }
        //     return f + (long)m;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，对这个破烂题目，不太会想，先去写其它的
        // public String maxSumOfSquares(int num, int sum) {
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // TLE TLE TLE 970/981 passed
        // static final int mod = (int)1e9 + 7;
        // public int countCoprime(int[][] a) {
        //     int m = a.length, n = a[0].length, o = 1, g = 0;
        //     for (int i = 0; i < m; i++)
        //         o = Math.max(o, Arrays.stream(a[i]).max().getAsInt());
        //     // 【动规、状态记忆方程】：当遍历到当前下标【i,j】第 i 行的第 j 列、所有，这前 i 个数的（最大公约数）为 k 的方案数
        //     // long [][][] f = new long [m][n][o+1];
        //     long [][][] f = new long [m][o+1][n];
        //     for (int j = 0; j < n; j++)
        //         // f[0][j][a[0][j]] = 1;
        //         f[0][a[0][j]][j] = 1;
        //     for (int i = 1; i < m; i++) 
        //         for (int j = 0; j < n; j++)
        //             for (int k = 1; k <= o; k++) {
        //                 g = gcd(a[i][j], k);
        //                 // for (int x = 0; x < n; x++) 
        //                 //     // f[i][j][g] = (f[i][j][g] + f[i-1][x][k]) % mod;
        //                 //     f[i][g][j] = (f[i][g][j] + f[i-1][k][x]) % mod;
        //                 long sum = LongStream.of(f[i-1][k]).sum();
        //                 f[i][g][j] = (f[i][g][j] + sum) % mod;
        //             }
        //     long r = 0;
        //     for (int j = 0; j < n; j++)
        //         r = (r + f[m-1][1][j]) % mod;
        //     return (int)r;
        // }
        // int gcd(int i, int j) {
        //     if (j == 0) return i;
        //     return gcd(j, i % j);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long removeZeros(long n) {
        //     String S = String.valueOf(n); char [] s = S.toCharArray();
        //     StringBuilder sb = new StringBuilder();
        //     for (int i = 0; i < s.length; i++) 
        //         if (s[i] != '0')
        //             sb.append(s[i]);
        //     long f = 0;
        //     for (int i = 0; i < sb.length(); i++) 
        //         f = f * 10 + (long)(sb.charAt(i) - '0');
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long maxAlternatingSum(int[] a) {
        //     int n = a.length;
        //     long f = 0, ff = 0, j = 0;
        //     Queue<Long> q = new PriorityQueue<>((x, y)-> (-1) * Long.compare(x, y));
        //     for (int i = 0; i < n; i++) {
        //         j = a[i] * a[i];
        //         f += (long)j;
        //         q.offer(j);
        //     }
        //     while (q.size() > n / 2) 
        //         ff += q.poll();
        //     return ff - (f - ff);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // TLE TLE TLE 741/752 passed
        // public long countStableSubarrays(int[] a) {
        //     int n = a.length;
        //     long [] f = new long [n+1];
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         f[i+1] = f[i] + (long)a[i];
        //         m.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
        //     }
        //     long r = 0;
        //     int i = 0, size = 0;
        //     for (int k : m.keySet()) {
        //         if (m.get(k).size() <= 1 || m.get(k).size() == 2 && m.get(k).get(1)-m.get(k).get(0)+1 < 3) continue;
        //         List<Integer> l = m.get(k);
        //         i = 0; size = l.size();
        //         while (size - i > 1) {
        //             for (int j = i+1; j < l.size(); j++) {
        //                 if (l.get(j)-l.get(i)+1 < 3) continue;
        //                 if ((long)k == f[l.get(j)] - f[l.get(i)+1]) r++;
        //             }
        //             i++;
        //         }
        //     }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 数组中可能会有【重复数字】，不知道怎么去比较：（非降序数组的、子数组）是否重复
        // public long numGoodSubarrays(int[] a, int k) {
        //     int n = a.length;
        //     long [] f = new long [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         f[i] = f[i-1] + (long)a[i-1];
        //     long r = 0;
        //     Map<Long, List<Integer>> m = new HashMap<>();
        //     for (int i = 1; i <= n; i++) {
        //         if (f[i] < (long)k) continue;
        //         if (f[i] == (long)k) r++;
        //         else if (m.containsKey(f[i] % k)) { // f[i] > k
                    
        //         }
        //         m.computeIfAbsent(f[i] % k, z -> new ArrayList<>()).add(i);
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public List<Integer> findMissingElements(int[] a) {
        //     int n = a.length;
        //     Arrays.sort(a);
        //     Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     List<Integer> f = new ArrayList<>();
        //     for (int i = a[0]+1; i < a[n-1]; i++) 
        //         if (!s.contains(i))
        //             f.add(i);
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，感觉这个题目的思路狠清晰，可是细节不知道哪里写错了，晚点儿再写这个破烂题目。。
        // public long maxProduct(int[] a) {
        //     int n = a.length;
        //     // 【从左、从右：最大正数】
        //     int [] l = new int [n+1], r = new int [n+1];
        //     // 【从左、从右：最小负数】
        //     int [] ll = new int [n+1], rr = new int [n+1];
        //     // 【从左到右】遍历：纪录（最大正数、最小负数）
        //     for (int i = 0; i < n; i++) {
        //         l[i+1] = Math.max(l[i], a[i]);
        //         ll[i+1] = Math.min(ll[i], a[i]);
        //     }
        //     for (int i = n-1; i >= 0; i--) {
        //         r[i] = Math.max(r[i+1], a[i]);
        //         rr[i] = Math.min(rr[i+1], a[i]);
        //     }
        //     long f = -1l * (long)Math.pow(10, 15), min = -100_000l, max = 100_000l, fl = 0, fr = 0;
        //     // 遍历：【中间下标】
        //     for (int i = 1; i < n; i++) { 
        //         if (l[i] > 0 && r[i+1] > 0 || ll[i] < 0 && rr[i+1] < 0) {
        //             f = Math.max(f, max * Math.max((long)l[i] * r[i+1], (long)ll[i] * rr[i+1]));
        //         } else if ((l[i] != 0 || r[i+1] != 0) && (ll[i] != 0 || rr[i+1] != 0)) {
        //             f = Math.max(f, min * (long)Math.min(ll[i], rr[i+1]) * Math.max(l[i], r[i+1]));
        //         } else
        //             f = Math.max(f, 0);
        //         // System.out.println("i: " + i + " " + "f: " + f);
        //    }
        //     if (n == 3) 
        //         f = Math.max(f, Math.max(max * Math.max(a[0] * a[1], a[1] * a[2]), min * Math.min(a[0] * a[1], a[1] * a[2])));
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，觉得这个破烂题目出得太没意思了、不想写，先去写其它的
        // public long minimumTime(int[] d, int[] r) {
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public String lexPalindromicPermutation(String S, String T) {
        //     int n = S.length(), r = 0; char [] s = S.toCharArray(), t = T.toCharArray();
        //     int [] f = new int [26];
        //     for (char c : s)
        //         f[c-'a']++;
        //     for (int v : f) 
        //         if (v > 0 && v % 2 == 1) r++;
        //     if (r > 1) return "";
        //     // 【TODO：】接下来是，根据 f[i] 的字母出现频次，来写符合要求的字符串。。
        //     // 可是，亲爱的表哥的活宝妹，感觉这个好繁琐，这个破烂题目写得没什么意思，不想再写了
        //     // 亲爱的表哥的活宝妹，下周的2 场比赛，再接着写
        //     // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minMoves(int[] a) {
        //     int n = a.length, sum = Arrays.stream(a).sum(), max = Arrays.stream(a).max().getAsInt();
        //     return max * n - sum;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，这里，不知道哪里细节写错了，不想再写这种折磨死人不偿命的破烂题目了。。。傍晚再写另一组的。。
        // public int longestSubarray(int[] a) {
        //     int n = a.length, r = 0;
        //     if (n == 1) return 1;
        //     int [][] f = new int [n][2];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(f[i], 1);
        //     if (a[0] > a[1])
        //         f[1][1] = 2;
        //     for (int i = 1; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         System.out.println("(a[i] >= a[i-1]): " + (a[i] >= a[i-1]));
        //         if (a[i] >= a[i-1]) {
        //             f[i][0] = f[i-1][0] + 1;
        //             if (f[i-1][1] > 1 && i >= 2 && (a[i] >= a[i-2] || a[i-2] > a[i-1]))
        //             // if (f[i-1][1] > 1 && i >= 2 && a[i] >= a[i-2])
        //                 f[i][1] = f[i-1][1] + 1;
        //             // if (i >= 2 && (a[i] >= a[i-2] || a[i-2] > a[i-1]))
        //             f[i][1] = Math.max(f[i][1], f[i-1][0] + 1);
        //         } else { // 在下标 i 试图更新一个数字
        //             f[i][1] = f[i-1][0] + 1;
        //         }
        //         System.out.println("f.length: " + f.length);
        //         for (int z = 0; z < f.length; ++z)
        //             System.out.println(Arrays.toString(f[z]));
        //     }
        //    for (int i = 0; i < n; i++)
        //         r = Math.max(r, Math.max(f[i][0], f[i][1]));
        //     return r;
        // }
        // int [] a = new int [] {1, 2, 3, 1, 2};
        // // int [] a = new int [] {3, -4, -2};

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countMajoritySubarrays(int[] a, int t) {
        //     int n = a.length, r = 0;
        //     // 亲爱的表哥的活宝妹，不要想得太复杂了，先【暴力】解决一下，这个数据规模狠小的问题
        //     int [] f = new int [n+1];
        //     // 【自左向右】
        //     for (int i = 1; i <= n; i++)
        //         f[i] = f[i-1] + (a[i-1] == t ? 1 : 0);
        //     // 遍历：【左端点 i】：每个左端点 i, 遍历所有可能的（右端点 j）
        //     for (int i = 0, j = 0; i < n; i++, j = i) {
        //         if (a[i] == t) r++; // 长度为 1 的子数组
        //         ++j;
        //         while (j < n) {
        //             while (j < n && f[j+1]-f[i] < (j-i+1)/2+1) j++;
        //             if (j == n) continue;
        //             r++;
        //             j++;
        //         }
        //     }
        //     return r;
        // }

    //     // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //     // 感觉，总体思路算是对的、测试过了一半；不想再写这个破烂题目了
    //     public long countMajoritySubarrays(int[] a, int t) {
    //         int n = a.length, p = -1;
    //         long r = 0;
    //         // 亲爱的表哥的活宝妹，不要想得太复杂了，先【暴力】解决一下，这个数据规模狠小的问题
    //         int [] nt = new int [n], pr = new int [n];
    //         List<Integer> l = new ArrayList<>(); // 下标链条
    //         Arrays.fill(nt, n); Arrays.fill(pr, -1);
    //         // 【自左向右】
    //         for (int i = 1; i <= n; i++) 
    //             if (a[i-1] == t) {
    //                 l.add(i-1);
    //                 pr[i-1] = p;
    //                 p = i-1;
    //             }
    //         // 【自右向左】
    //         p = n;
    //         for (int i = n-1; i >= 0; i--) 
    //             if (a[i] == t) {
    //                 nt[i] = p;
    //                 p = i;
    //             }
    //         System.out.println(Arrays.toString(pr));
    //         System.out.println(Arrays.toString(nt));
    //         // 遍历：【每个：最左 t 值在下标 l.get(i) 的子数组】：并向两侧扩展扩散
    //         for (int i = 0; i < l.size(); i++) {
    //             r++;
    //             System.out.println("\n i: " + i + " r: " + r);
    //             // 遍历：【含 2 个、3 个、4 个。。 l.size() 个 t 值】的（最右 t 值），计入所有合法子数组个数
    //             for (int j = i+1; j < l.size(); j++) {
    //                 System.out.println("i: " + i + " " + "j: " + j);
    //                 System.out.println("l.get(i): " + l.get(i) + " " + "l.get(j): " + l.get(j));
    //                 // 【最左 t 值在下标 l.get(i)】（最右 t 值在下标 l.get(j)）的、最短子数组
    //                 if (j-i+1 >= (l.get(j) - l.get(i) + 1) /2 + 1) {
    //                     r++;
    //                     System.out.println("r 1: " + r);
    // // 还有可能：【向左、向右】向两侧扩展一定长度: 【向右】或扩展方案数 * （向左）可扩展方案数
    //                     // 【TODO：】这里有【数多】和【数少】的双重可能性。。。
    //             long ll = (long)Math.max(Math.min(l.get(i) - pr[l.get(i)]-(pr[l.get(i)] == -1 ? 0 : 1), l.get(i) - (l.get(j) - ((j-i+1) * 2-1))), 0);
    //                     long rr = (long)Math.max(Math.min(nt[l.get(j)] - l.get(j)-1, (j-i+1) * 2 - 1 + l.get(i)-1 - l.get(j)), 0);
    //                     System.out.println("ll: " + ll + " " + "rr: " + rr);
    //                     r += (ll == 0l || rr == 0l ? ll + rr : ll * rr + (ll == 1l && rr == 1l ? 1l : 0));
    //                     System.out.println("r 2: " + r);
    //                 }
    //             }
    //         }
    //         return r; 
    //     }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minimumDistance(int[] a) {
        //     int n = a.length, i = 0, j = 0, k = 0, r = 3427;
        //     List<Integer> [] f = new ArrayList[n+1];
        //     Arrays.setAll(f, z -> new ArrayList<Integer>());
        //     for ( i = 0; i < n; i++) {
        //         j = a[i];
        //         f[j].add(i);
        //     }
        //     for (List<Integer> l : f) {
        //         if (l.size() < 3) continue;
        //         for (int x = 0; x < l.size()-2; x++) 
        //             for (int y = x+1; y < l.size()-1; y++) 
        //                 for (int z = y+1; z < l.size(); z++) {
        //                     i = l.get(x); j = l.get(y); k = l.get(z);
        //                     r = Math.min(r, Math.abs(i-j) + Math.abs(i-k) + Math.abs(j-k));
        //                 }
        //     }
        //     return (r == 3427 ? -1 : r);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，随便改了改，977/979-passed 但不知道最后 3 个不过的 test-case 是什么样的
        // public int minimumDistance(int[] a) {
        //     int n = a.length, i = 0, j = 0, k = 0, r = 34227;
        //     if (n < 3) return -1;
        //     List<Integer> [] f = new ArrayList[n+1];
        //     Arrays.setAll(f, z -> new ArrayList<Integer>());
        //     for ( i = 0; i < n; i++) {
        //         j = a[i];
        //         f[j].add(i);
        //     }
        //     for (List<Integer> l : f) {
        //         if (l.size() < 3) continue;
        //         for (int x = 0; x < l.size()-2; x++) {
        //             i = l.get(x); j = l.get(x+2); // k = l.get(x+2);
        //             r = Math.min(r, Math.abs(i-j) * 2);
        //         }
        //     }
        //     return (r == 34227 ? -1 : r);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，不知道哪里细节写错了，晚点儿再写这个题目
        // public int maxPathScore(int[][] a, int kk) {
        //     int m = a.length, n = a[0].length, v = 0, nk = 0, nv = 0; // new-Key
        //     TreeMap<Integer, Integer> [][] f = new TreeMap [m+1][n+1];
        //     for (int i = 0; i <= m; i++)
        //         Arrays.setAll(f[i], z -> new TreeMap<Integer, Integer>((x, y)->y-x)); // 【键值对】：【Scoer, Cost-leftover】
        //     f[0][1].put(0, kk); f[m][n].put(-1, 0);
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) {
        //             // 【从上往下】移动
        //             for (int k : f[i-1][j].keySet()) {
        //                 v = f[i-1][j].get(k); nk = k + a[i-1][j-1]; nv = f[i][j].getOrDefault(nk, 0);
        //                 f[i][j].put(nk, Math.max(nv, v - (a[i-1][j-1] == 0 ? 0 : 1)));
        //                 if (f[i][j].get(nk) < 0) f[i][j].remove(nk);
        //             }
        //             // 【从左往右】移动
        //             for (int k : f[i][j-1].keySet()) {
        //                 v = f[i][j-1].get(k); nk = k + a[i-1][j-1]; nv = f[i][j].getOrDefault(nk, 0);
        //                 f[i][j].put(nk, Math.max(nv, v - (a[i-1][j-1] == 0 ? 0 : 1)));
        //                 if (f[i][j].get(nk) < 0) f[i][j].remove(nk);
        //             }
        //             // System.out.println("f[i][j].size(): " + f[i][j].size());
        //             // System.out.println(Arrays.toString(f[i][j].keySet().toArray()));
        //        }
        //     return f[m][n].firstKey();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】：亲爱的表哥的活宝妹，写不到（动规），就只能先写【记忆化深搜】！！！
        // // 【动规】的优势是：【自左向右】遍历时，可以【2 个、双端队列】来O(n)-O(1) 时间取得片段的（某遍历区间的、最大值与最小值）；可是，亲爱的表哥的活宝妹、笨宝妹这种题型还写不习惯动规。。。
        // // 【环形数组】：把2 个同样数组串起来当（环形数组）用
        // // 【数据结构】：O(logN) 时间查询【区间：最大值与最小值】用（线段树）；用【线段树】来维护【0,2n-1】数组内的（任何区间的、最大最小值）因为【数组是固定不变的、不曾不会、实时更新】，所以（不必打懒惰标记）。。
        // // 【动规】：最后动规求解O(2N*logN)?
        // // 【TODO：】2 个优化点：【线段树、数据结构的使用，未必是最高效的】；
        // public class SegNode {
        //     int i, j, f, ff; // 【左右下标 i,j; 最小值 f 和、最大值 ff】
        //     SegNode l, r; // 【左、右、子节点】
        //     public SegNode(int i, int j) {
        //         this.i = i; this.j = j;
        //         l = null; r = null;
        //     }
        // }
        // SegNode build(int i, int j, int [] a) {
        //     SegNode r = new SegNode(i, j);
        //     if (i == j) {
        //         r.f = r.ff = a[i];
        //         return r;
        //     }
        //     int m = (i + j) / 2;
        //     // 【自项向下】 push-down：建立每个节点、子节点
        //     r.l = build(i, m, a);
        //     r.r = build(m+1, j, a);
        //     // 【自底向上】 push-up：更新每个节点的【最大值与最小值】
        //     r.f = Math.min(r.l.f, r.r.f);
        //     r.ff = Math.max(r.l.ff, r.r.ff);
        //     return r;
        // }
        // void insert(SegNode f, int idx) {
        //     int m = (f.i + f.j) / 2;
        //     if (idx <= m)
        //         insert(f.l, idx);
        //     else 
        //         insert(f.r, idx);
        // }
        // int getMin(SegNode f, int i, int j) {
        //     if (j < f.i || f.j < i) return 0; // 空集
        //     // 区间【i,j】是 f[f.i, f.j] 的子集
        //     if (i <= f.i && f.j <= j) return f.f;
        //     int m = (f.j + f.j) / 2;
        //     return Math.min(getMin(f.l, i, m), getMin(f.r, m+1, j));
        // }
        // int getMax(SegNode f, int i, int j) {
        //     if (j < f.i || f.j < i) return 0; // 空集
        //     // 区间【i,j】是 f[f.i, f.j] 的子集
        //     if (i <= f.i && f.j <= j) return f.ff;
        //     int m = (f.j + f.j) / 2;
        //     return Math.max(getMax(f.l, i, m), getMax(f.r, m+1, j));
        // }
        // int getDif(SegNode f, int i, int j) {
        //     return getMax(f, i, j) - getMin(f, i, j);
        // }
        // public long maximumScore(int[] aa, int kk) {
        //     int m = aa.length; n = m * 2;
        //     a = new int [n];
        //     for (int i = 0; i < m; i++) {
        //         a[i] = aa[i];
        //         a[i+m] = aa[i];
        //     }
        //     // // 【预处理：实时】：【最小值】与（最大值）记下来？
        //     // // 【自左向右】遍历左端点，维护一个【最小值双端队列】O(n);
        //     // // 【自左向右＋自右向左】遍历右端点，维护一个【最大值双端队列】O(n);??? 【TODO：】感觉这里想得不透彻
        //     // int [][][] r = new int [n][n][2];
        //     //  建立线段树【O(logN)】时间获得【最大值与最小值】
        //     SegNode r = build(0, n-1, a);
        //     long [][][] f = new long [n][n][kk * 2 +1];
        //     // 【初始化】：
        //     // f[i][i][0..k] = 1;
        //     // 遍历：当前最新添加子数组的、【右端点】
        //     // for (int j = 0; j < n-(k-1); j++) { // 【TODO：】这里【起止点：左右边界】可能不对。。
        //     for (int j = 1; j < n; j++) { // 【TODO：】这里【起止点：左右边界】可能不对。。
        //         // 遍历：当前最新添加子数组的、【左端点】
        //         for (int i = 0; i < j; i++) {
        //             // 遍历：当前最新添加子数组的、【长度】
        //             for (int k = 1; k <= Math.min((j-i+1), kk * 2); k++) { // 最多【j-i+1】个、单数子数组
        //                 // 【TODO：】可能还涉及【边界：长度为1 片段】特殊值处理的、过程中（初始化相关）。。
        //                 if (k == 1){
        //                     f[i][j][k] = getDif(r, i, j);
        //                     continue;
        //                 }
        //                 // 在【i,j-1,k-1】的基础上，添加最后一个【单数、子数组 j】
        //                 f[i][j][k] = Math.max(f[i][j][k], f[i][j-1][k-1]);
        //                 // 在【i,j-1,k】的基础上，在（最后一个子数组 k）添加最后一个【单数、子元素j】
        //                 // 遍历：前一个片段、第【k-1】个片段的结束下标、也即、第【k】个片段的、所有合法【起始下标 x：自 i+k-1 开始，合法】最大值 f[i][x][k-1] ＋ [getDif(f, i, j)=getMax(f, x, j) - getMin(f, x, j)]
        //                 // 【TODO：】2 个优化点：【上面，有效区间内、最大值的维护】或有更高效的、遍历方法或是借助数据结构的记忆方式，变量 k 的遍历，或有O(1) 方法来解决 O(k) 的 k 变量的遍历 
        //                 // 【TODO：】可能还涉及【边界：长度为1 片段】特殊值处理的、过程中（初始化相关）。。
        //                 f[i][j][k] = Math.max(f[i][j][k], f[i][i+k-2][k-1] + getDif(r, i+k-1, j));
        //             }
        //         }
        //     }
        //     long max = 0;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 1; j <= kk; j++) 
        //             max = Math.max(max, f[i][i+m-1][j]);
        //     return max;
        // }
        // int n; int [] a;

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maximizeExpressionOfThree(int[] a) {
        //     int n = a.length, ff = -102, f = -102, r = Arrays.stream(a).min().getAsInt() ;
        //     for (int i = 0; i < n; i++) {
        //         // 【最大值】
        //         if (ff == -102 || a[i] > ff) {
        //             if (ff != -102)
        //                 f = ff;
        //             ff = a[i];
        //         } else if (f == -102 || a[i] > f) { // 【第2 大值 sec】
        //             f = a[i];
        //         } 
        //    }
        //     return ff + f - r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minLengthAfterRemovals(String S) {
        //     int n = S.length(); char [] t = S.toCharArray();
        //     Deque<Character> s = new ArrayDeque<>();
        //     for (char c : t) {
        //         if (s.isEmpty() || s.peekLast() == c)
        //             s.offerFirst(c);
        //         else if (s.peekLast() != c)
        //             s.pollLast();
        //     }
        //     return s.size();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，觉得这个破烂题目，还算比较简单的？ 按数组 a[i] 【从小到大】的顺序遍历、预处理【动规数组】
        // // 【动规】：有个经典题型，f[i] 既与 f[i-1] 相关，也与 f[i-2] 相关，需要找出来复习一下，是生成什么由【0/1】组成的半随机序列，要求片段里不能存在“011”之类的特殊子序列？忘记细节了，需要找出来复习一下
        // // 亲爱的表哥的活宝妹，觉得，这个动规，就是数个数，可是细节上仍然有狠大的出入，改天再写1!!
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long[] countStableSubarrays(int[] a, int[][] qs) {
        //     int n = a.length, m = qs.length;
        //     // 【左边、最小值的下标】＋（右边，最大值的下标）
        //     int [] l = new int [n], r = new int [n];
        //     for (int i = 1; i < n; i++) {
        //         if (a[i] >= a[i-1]) l[i] = l[i-1];
        //         else l[i] = i;
        //     }
        //     Arrays.fill(r, n-1);
        //     for (int i = n-2; i >= 0; i--) {
        //         if (a[i] <= a[i+1]) r[i] = r[i+1];
        //         else r[i] = i;
        //     }
        //     int [] f = new int [n]; Arrays.fill(f, 1);
        //    Integer [] idx = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        //     Arrays.sort(idx, (i, j)-> (a[i] != a[j] ? a[i] - a[j] : i - j));
        //     System.out.println(Arrays.toString(idx));

        //     // 按数组 a[i] 【从小到大】的顺序遍历、预处理【动规数组】 
        //     for (int idxx = 1; idxx < n; idxx++) {
        //         int i = idx[idxx]; // 【自小到大：当前 a[i] 下标】
        //         System.out.println("idxx: " + idxx + " " + "i: " + i);
        //         if (i == 0 || a[i-1] > a[i]) {
        //             System.out.println(Arrays.toString(f));
        //             continue;
        //         }
        //         // 计算：【以前下标 i-1 为结尾的、所有合法子数组】（用来合并当前下标 i），叠加和
        //         // f[i] += (f[i-1] - (i == 1 || l[i] > i-2 ? 0 : f[i-2])) * 2;
        //         // f[i] += (f[i-1] - (i == 1 || l[i] > i-2 ? 0 : f[i-2])) * 2 + (i >= 2 ? f[i-2] : 0);
        //         // 计算：【以前下标 i-1 为结尾的、所有合法子数组】（用来合并当前下标 i），叠加和【以i-1 为右端点的先前所有合法子数组】
        //         // f[i] += (f[i-1] - (i == 1 || l[i] > i-2 ? 0 : f[i-2])) + f[i-1];
        //         f[i] += (f[i-1] - (i == 1 || l[i] > i-2 ? 0 : f[i-2])) * 2 + (i == 1 || l[i] > i-2 ? 0 : f[i-2]);
        //         // 【TODO：】这里还需要考虑 a[i] == a[i-1] 重复数字的特殊情况？
        //         if (a[i] == a[i-1])
        //             f[i] -= 1; // 【TODO：】这里只减少1 个，对吗？
        //         System.out.println(Arrays.toString(f));
        //     }
        //     System.out.println(Arrays.toString(f));

        //     long [] ans = new long [m];
        //     int k = 0;
        //     for (int [] q : qs) {
        //         int i = q[0], j = q[1], cur = i;
        //         // 【单值】
        //         if (i == j) {
        //             ans[k++] = 1;
        //             continue;
        //         }
        //         // 【左端点】：可能数多，减去【左端点】可能多算的部分
        //         if (i > 0 && a[i-1] <= a[i])
        //             ans[k] -= f[i-1] * 2;
        //         while (i <= j) {
        //             // 【右端点】：移动到（当前：不减子数组）可以延伸的【合法、最右端】
        //             cur = Math.min(j, r[i]);
        //             ans[k] += f[cur];
        //             i = cur+1;
        //         }
        //         k++;
        //     }
        //     return ans;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minimumFlips(int n) {
        //     String S = Integer.toBinaryString(n); char [] s = S.toCharArray();
        //     String T = new StringBuilder(S).reverse().toString(); char [] t = T.toCharArray();
        //     int f = 0;
        //     for (int i = 0; i < s.length; i++) 
        //         if (s[i] != t[i]) f++;
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个破烂题目，要【暴力】一个数字一个数字、一个数位一个数位地去数吗？讨厌这类破烂题目，晚点儿再写这个题目
        // 亲爱的表哥的活宝妹，傍晚想到后面那个相对难题目的解法了，【数位动规】，遍历【l,r】上下界两边界数的【1,n-1】数位，
        // 遍历当前数位，记【前一位数字】，动规过度到下一位【从低位到高位遍历】时，数当前数位向下一个高位过渡时的【顶或是底】的个数，就不会超时了【TODO：】
        // public int totalWaviness(int x, int y) {
        //     int f = 0, k = 0;
        //     for (int i = x; i <= y; i++) {
        //         char [] s = String.valueOf(i).toCharArray();
        //         if (s.length < 3) continue;
        //         k = 0;
        //         for (int j = 1; j < s.length-1; j++) 
        //             if (s[j] - s[j-1] > 0 && s[j] - s[j+1] > 0
        //                 || s[j] - s[j-1] < 0 && s[j] - s[j+1] < 0)
        //                 k++;
        //         f += k;
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long sumAndMultiply(int n) {
        //     String S = String.valueOf(n);
        //     StringBuilder s = new StringBuilder();
        //     int f = 0;
        //     for (char c : S.toCharArray())
        //         if (c != '0') {
        //             s.append(c);
        //             f += c - '0';
        //         }
        //     if (s.length() == 0) return 0;
        //     return (long)f * Integer.parseInt(s.toString());
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，感觉，这里XOR 异或数组的性质，好像忘记了，先不写这个题目
        // // TLE TLE TLE: 超时了，并且超时还比较严重。。。晚点儿再写这个破烂题目
        // public int maxBalancedSubarray(int[] a) {
        //     int n = a.length;
        //     int [] l = new int [n+1], r = new int [n+1], f = new int [n+1];
        //     for (int i = 0; i < n; i++) { // 数：【奇偶个数】
        //         if (a[i] % 2 == 1) {
        //             l[i+1] = l[i] + 1;
        //             r[i+1] = r[i];
        //         } else {
        //             r[i+1] = r[i] + 1;
        //             l[i+1] = l[i];
        //         }
        //         f[i+1] = f[i] ^ a[i];
        //     }
        //     // 遍历（有技巧、有裁枝地、遍历所有可能性）：所有【子数组 XOR 值为 0】的可能性，再检测：子数组【奇偶个数的、合法性】
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     int ff = 0; // 答案
        //     for (int i = 1; i <= n; i++) {
        //         // 先查：当前子数组【0,i-1】
        //         if (f[i] == 0 && l[i] == r[i]) {
        //             ff = Math.max(ff, i);
        //             // if (!m.containsKey(f[i])) // 保留【最左端点】？
        //             //     m.put(f[i], i); // i
        //             System.out.println("ff 0: " + ff);
        //           m.computeIfAbsent(f[i], z -> new ArrayList<>()).add(i);
        //             continue;
        //         }
        //         // 再查：左端点右移后的、子数组
        //         if (m.containsKey(f[i])) 
        //             for (int j : m.get(f[i])) 
        //                 if (l[i] - l[j] == r[i] - r[j]) {
        //                     ff = Math.max(ff, i - j);
        //                     System.out.println("ff 1: " + ff);
        //                     break;
        //                 }
        //         m.computeIfAbsent(f[i], z -> new ArrayList<>()).add(i);
        //     }
        //     System.out.println("ff: " + ff);
        //     return ff;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // TLE TLE TLE 509/52617 passed..【TODO：】 queries 是【离线解法】还可以将queries 按【l,r】左右下标升序排列，以便必要的时候，可以得用前面求得的结果
        // // 亲爱的表哥的活宝妹，今天不想再写这破烂题目了，今天的两组题目都极其恶心人，亲爱的表哥的活宝妹，下周六再写晚上的题目
        // static final int mod = (int)1e9 + 7;
        // public int[] sumAndMultiply(String S, int[][] qs) {
        //     int n = S.length();
        //     char [] s = S.toCharArray();
        //     TreeMap<Integer, Integer> m = new TreeMap<>(); // s[i]==>idx
        //     List<Integer> li = new ArrayList<>();
        //     int j = 0; // li 下标 idx=j
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] != '0') {
        //             m.put(i, j);
        //             li.add(s[i] - '0');
        //             j++;
        //         }
        //     }
        //     int [] p = new int [li.size()+1];
        //     for (int i = 1; i < li.size()+1; i++) // 数位【前缀和】
        //         p[i] = p[i-1] + li.get(i-1);
        //     int [] f = new int [qs.length];
        //     j = 0;
        //     // TLE TLE TLE 【TODO：】 queries 是【离线解法】还可以将queries 按【l,r】左右下标升序排列，以便必要的时候，可以得用前面求得的结果
        //     for (int[] q : qs) {
        //         // System.out.println("j: " + j);
        //         // System.out.println(Arrays.toString(q));
        //        // 【TODO：】这里边界，可能不对
        //         Integer ll = m.ceilingKey(q[0]), rr = m.floorKey(q[1]);
        //         int l = 0, r = n-1;
        //         if (ll == null || (rr == null || ll > rr)) {
        //             j++;
        //             continue;
        //         }
        //         l = m.get(ll); r = m.get(rr);
        //     for (int k = l; k <= r; k++) 
        //             f[j] = (int)(((long)f[j] * 10l + li.get(k)) % mod);
        //         f[j] = (int)((long)f[j] * (p[r+1] - p[l]) % mod);
        //         j++;
        //     } 
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】，绝对的【动规题型】：数组元素的值，最多 19 位，一定按照数位遍历！！ 19 位有点儿大，15 位或不超时，但19 位感觉有可能会超时
        // // 【自顶向下】：子序列遍历的方法，是：【暴力 19 个数位】的所有可能性！【1<<19-1】
        // // 【0,18】数位，每个数位的遍历方法：【数位遍历】的技巧：按【0,18】数位上的【1/0】分组，分组后，直接数所有可能性
        // // 【TODO：】把这个题目，拆成（2 个阶段的、暴力遍历），是否存在奇角数错的地方？遍历【1<<19-1】当多个数位时，可能会存在交差？
        // // 亲爱的表哥的活宝妹，晚点儿再想这个破烂题目
        // static final int mod = (int)1e9 + 7;
        // public int countEffective(int[] a) {
        //     // int f = (int)Math.pow(2, 18), ff = (int)Math.pow(2, 20); // a[] 无素最多 15 位
        //     // System.out.println("f: " + f + " " + "ff: " + ff);
        //     int n = a.length, max = Arrays.stream(a).max().getAsInt(), m = (int)(Math.log(max) / Math.log(2));
        //     return 0;
        // }
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
        public static void main (String[] args) { 
		Solution s = new Solution ();

        int [] r = s.sumAndMultiply(a, b);
        System.out.println(Arrays.toString(r));
    }
}
// ListNode head = new ListNode(a0]);  
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】