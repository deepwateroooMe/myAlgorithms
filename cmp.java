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

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        public int[] recoverOrder(int[] a, int[] b) {
            int n = a.length;
            Set<Integer> s = new HashSet<>(Arrays.stream(b).boxed().collect(Collectors.toList()));
            int [] f = new int [b.length];
            int i = 0;
            for (int j = 0; j < n; j++)
                if (s.contains(a[j]))
                    f[i++] = a[j];
            return f;
        }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] minDifference(int n, int k) {
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // Wrong Answer 754 / 758 testcases passed: Hidden for this testcase during contest.
        // public long maxProduct(int[] a) { // TLE TLE TLE 751/758 passed 算是亲爱的表哥的活宝妹、笨宝妹写【位运算】相关的、相对比较好的成绩。。
        //     int n = a.length;
        //     Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     Arrays.sort(a); 
        //     // 遍历：按数组降序遍历；每个数遍历这个数的【补集的、子集】
        //     long r = 0;
        //     int j = 0, cur = 0, mask = (1 << Integer.toBinaryString(Arrays.stream(a).max().getAsInt()).length()+1);
        //     System.out.println(Arrays.toString(a));
        //     // for (int i = n-1; i > 0; i--) { // 755/758 passed TLE TLE TLE
        //     for (int i = n-1; i >= n/8; i--) { // 752/758 passed
        //         // 【TODO：】怎么才能取（补集）；取32 位要遍历得太多了。缩小范围到 20 位左右
        //         // System.out.println("a[i]: " + a[i] + " " + "Integer.toBinaryString(a[i]): " + Integer.toBinaryString(a[i]));
        //         // j = ~a[i] & ((1 << 20)-1);
        //         // j = ~a[i] & ((1 << String.valueOf(Arrays.stream(a).max().getAsInt()).length()+1)-1);// 写得不对
        //         cur = ~a[i] & (mask -1);
        //         // System.out.println("j: " + j + " " + "Integer.toBinaryString(j): " + Integer.toBinaryString(j));
        //        // 【TODO：】如经典题型【选课问题】，遍历最大补数 j 的【所有、位子集】，O(20 × N)
        //         for (j = cur; j > 0; j = cur & (j - 1)) { // 【TODO：】感觉，这里的细节，怎么有效按位的子集遍历的。细节写得不对
        //             if (s.contains(j)) {
        //                 r = Math.max(r, (long)a[i] * j);
        //                 // System.out.println("j: " + j + " " + "r: " + r);
        //             }
        //         }
        //     }
        //     return r;
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 亲爱的表哥的活宝妹，不知道怎么去想这个题目。。。破烂题目
        public int totalBeauty(int[] a) {
            int n = a.length;
            
        }
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
		Solution s = new Solution ();

        int []  a = new int []  {64, 8, 32};

        long r = s.maxProduct(a);
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