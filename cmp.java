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

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 【动规】：感觉是，这个世界上最简单的（动规题型）？
        public int climbStairs(int n, int[] a) {
            // 【状态定义】：到【0,n】各级台阶的（最小代价）
            int [] f = new int [n+1];
            // 【初始化】
            Arrays.fill(f, Integer.MAX_VALUE / 2);
            f[0] = 0;
            // f[1] = a[0] + (int)Math.pow(1-0, 2); // 只能从0 跳到 1
            // // 可以【1. 从 1 跳到 2】或者【2. 从 0 跳到 2】，2 者取小值 
            // f[2] = Math.min(f[1] + a[1] + (int)Math.pow(2-1, 2), f[0] + a[1] + (int)Math.pow(2-0, 2));
            int j = 0;
            for (int i = 1; i <= n; i++) {
                for (int d = 1; d < 4 && i-d >= 0; d++) { // j: [i-1][i-2][i-3]
                    j = i - d;
                    f[i] = Math.min(f[i], f[j] + a[i-1] + (int)Math.pow(d, 2));
                }
            }
            System.out.println(Arrays.toString(f));
            return f[n];
        }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 感觉，这个破烂题目，亲爱的表哥的活宝妹，不知道怎么去想，交换的【顺序不定、次数不定】。。
        // public long maxAlternatingSum(int[] nums, int[][] swaps) {
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 【滑动窗口】：【自左向右】遍历字符串里【长度为 k 的、子串】，统计（特异【DULR】字频）的个数。。
        public int distinctPoints(String S, int k) {
            int n = S.length(); char [] s = S.toCharArray();
            Map<Character, Integer> m = new HashMap<>();
            Set<String> si = new HashSet<>();
            m.put('D', 0); m.put('U', 1);
            m.put('L', 2); m.put('R', 3);
            int [] r = new int [4];
            for (int i = 0; i < k; i++) 
                r[m.get(s[i])]++;
            si.add(new String((r[0] == r[1] ? "0-0" : (r[0] > r[1] ? r[0]-r[1] + "-0" : "0-" + (r[1]-r[0]))) + "-"
                               + (r[2] == r[3] ? "0-0" : (r[2] > r[3] ? r[2]-r[3] + "-0" : "0-" + (r[3]-r[2])))));
            for (int i = k; i < n; i++) {
                r[m.get(s[i-k])]--;
                r[m.get(s[i])]++;
                si.add(new String((r[0] == r[1] ? "0-0" : (r[0] > r[1] ? r[0]-r[1] + "-0" : "0-" + (r[1]-r[0]))) + "-"
                                   + (r[2] == r[3] ? "0-0" : (r[2] > r[3] ? r[2]-r[3] + "-0" : "0-" + (r[3]-r[2])))));
             }
            for (String v : si) 
                System.out.println("v: " + v);
            return si.size();
        }
        // 【前3 个题目都狠简单】，只是相对繁琐，写得没意为；可是最后一个相对难一点儿的，一大早上瞎吃嗨胀蛋白质胀太多的亲爱的表哥的活宝妹，又想不出来。。。
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
		Solution s = new Solution ();

        String a = "DRLRUUDD";

        int r = s.distinctPoints(a, 4);
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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】