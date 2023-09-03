import com.ListNode;
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

        // // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】

        // public boolean canBeEqual(String ss, String tt) {
        //     char [] s = ss.toCharArray(), t = tt.toCharArray();
        //     for (int i = 0; i < 4; i++) {
        //         if (s[i] == t[i]) continue;
        //         if (i < 2 && (s[i] == t[i+2] || s[i+2] == t[i])) {
        //             if (s[i] == t[i+2]) 
        //                 t[i+2] = t[i];
        //             else s[i+2] = s[i];
        //             continue;
        //         }
        //         return false;
        //     }
        //     return true;
        // }

        // // 如果改一个可以一样，改另一个也可以一样，所以只弄一个: 这个题目，呆会儿再写
        // public boolean checkStrings(String ss, String tt) {
        //     int n = ss.length();
        //     char [] s = ss.toCharArray(), t = tt.toCharArray();
        //     List<Integer> [] l = new ArrayList [26];
        //     Arrays.stream(l).forEach(z -> Arrays.fill(z, new ArrayList<Integer>()));
        //     for (int i = 0; i < n; i++) 
        //         ls[s[i]-'a'].add(i); // 按字母存
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == t[i]) continue;
        //         int j = s[i]-'a', k = t[i] - 'a';
        //         // 写个暴力的，可能会超时：必须带记忆，状态定义
        //         List<Integer> cur = l[k];
        //         for (int x = 0; x < cur.size(); x++) {
        //             if ((cur.get(x) - i) % 2 != 0) continue;
        //             int idx = cur.get(x);
        //             cur.remove(idx);
        //             l[k]
        //             dfs(i+1, new String())
        //         }
        //     }
        // }
        // Map<String, Boolean> m = new HashMap<>();
        
        // public long maxSum(List<Integer> li, int x, int k) { // x: # pairs 491/767
        //     n = li.size(); this.x = x;
        //     if (n == 1 && k == 1 && x == 1) return li.get(0);
        //     Map<Integer, Integer> m = new HashMap<>();
        //     long ans = 0, sum = 0;
        //     for (int r = 0, l = 0; r < n; r++) {
        //         if (r - l + 1 < k) { // 可以保证子数组的长度，固定为 k
        //             m.put(li.get(r), m.getOrDefault(li.get(r), 0) + 1);
        //             sum += (long)li.get(r);
        //             continue;
        //         }
        //         sum += (long)li.get(r);
        //         if (getCnt(m) >= x) ans = Math.max(ans, sum);
        //         System.out.println("\n r: " + r);
        //         System.out.println("sum: " + sum);
        //         if (r - l + 1 == k) {
        //             sum -= li.get(l);
        //             m.put(li.get(l), m.getOrDefault(li.get(l), 1)-1);
        //             if (m.get(li.get(l)) == 0) m.remove(li.get(l));
        //             l++;
        //         }
        //     }
        //     return ans;
        // }
        // int n, x;
        // int getCnt(Map<Integer, Integer> m) {
        //     // System.out.println("m.size(): " + m.size());
        //     // for (Map.Entry<Integer, Integer> en : m.entrySet()) 
        //     //     System.out.print(en.getKey() + ", " + en.getValue() + "\n");
        //     // System.out.println("x: " + x);
        //     // System.out.println("(m.size() == 2 && x > 2): " + (m.size() == 2 && x > 2));
        //     if (m.size() <= 2 && x > 2) return 1;
        //     int r = 0;
        //     for (int k : m.keySet()) {
        //         int v = m.get(k);
        //         r += n - v;
        //     }
        //     System.out.println("(r/2): " + (r/2));
        //     return r == 0 ? 1 : r / 2;
        // }

//         // 感觉，这个死题目是骗人的，说得也不清楚，什么 k 1 <= k <= s.length, 不该是 k 在【1,26】范围内吗？骗人。。。
//         static final int mod = (int)1e9 + 7;
//         public int countKSubsequencesWithMaxBeauty(String S, int k) { // 不知道哪里写错了，改天再检查
//             int n = S.length(); char [] s = S.toCharArray();
//             int [] r = new int [26]; // frequency
//             for (int i = 0; i < n; i++) r[s[i]-'a']++;
//             // int [] f = new int [1 << k]; // 1 << 26 因为这个长度有限，数据离散，不能用这个
//             Map<Integer, Integer> m = new HashMap<>();
//             for (int i = 0; i < 26; i++) // 【初始化】：一个字符的 mask, 频率
//                 m.put((1 << i), r[i]);
//             System.out.println(Arrays.toString(r));
//             // 【动规】：动规, 就是，遍历过程中，动态更新和，与频率的过程
//             // Set<Integer> sk = new HashSet<>(); // K 长的 mask 集合
//             long ans = 0;
//             for (int i = 1; i < (1 << Math.min(n, 26)); i++) { // 遍历策略：每增加一个 bit位，只在增加这个位之前的【基】的基础上，作更新
//                 int bcnt = Integer.bitCount(i);
//                 if (bcnt == 1) continue; // 这个，我忆经初始化了
//                 for (int j = 0; j < 26; j++) { // 遍历 26 个数位，消除掉当前数位，先前有解过吗？有，就在那个基础上作更新
//                     // if ((i & (1 << j)) > 0 && m.containsKey(i - (1 << j)))
//                     if (((i >> j) & 1) == 1 && m.containsKey(i - (1 << j)))
//                         // m.put(i, m.getOrDefault(i, 0) + (r[i] * m.get(i - (1 << j)) + mod) % mod);
//                         m.put(i, (r[j] * m.get(i - (1 << j)) + mod) % mod);
//                 }
//                 if (bcnt == k) ans = (ans + m.get(i)) % mod;
//             }
//             return (int)ans;
// // int [] getSum(int v) {
//         //    int rr = 0;
//         //     long f = 1;
//         //     for (int i = 0; i < 26; i++)
//         //         if ((v & (1 << i)) > 0) {
//         //             rr = rr + r[i];
//         //             f = (f * r[i] + mod) % mod;
//         //         }
//         //     return new int [] {rr, (int)f};
//         }

        // public int countSymmetricIntegers(int l, int h) {
        //     int r = 0;
        //     for (int i = l; i <= h; i++)
        //         if (valid(i)) r++;
        //     return r;
        // }
        // boolean valid(int v) {
        //     char [] s = String.valueOf(v).toCharArray();
        //     int n = s.length;
        //     if (n % 2 == 1) return false;
        //     int r = 0;
        //     for (int i = 0; i < n/2; i++) r += s[i] - '0';
        //     for (int i = n/2; i < n; i++) r -= s[i] - '0';
        //     return r == 0;
        // }

        // public int minimumOperations(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     if (t.endsWith("00") || t.endsWith("25") || t.endsWith("50") || t.endsWith("75")) return 0;
        //     if (n == 1) return s[0] == '0' ? 0 : 1;
        //     if (n == 2) return s[0] == '0' || s[1] == '0' ? 1 : 2;
        //     // 从尾巴往前找，找两遍，数据规模小，随便写写都能过
        //     int ans = n;
        //     int [] r = new int [2]; Arrays.fill(r, -1);

        //     for (int i = n-1; i >= 0; i--) {
        //         System.out.println("\n i: " + i);
        //         if (s[i] == '0' && r[0] == -1) {
        //             r[0] = i;
        //             continue;
        //         } else if (s[i] == '5' && r[0] >= 0)
        //             return n - i - 2;
        //         else if (s[i] == '5' && r[1] == -1) {
        //             r[1] = i;
        //             continue;
        //         } else if (r[0] >= 0 && (s[i] == '0' || s[i] == '5')
        //                    || r[1] >= 0 && (s[i] == '2' || s[i] == '7')) {
        //             return n - i - 2;
        //         }
        //     }
        //     return n - (r[0] != -1 ? 1 : 0);
        // }

        // // 过会儿再写这个题目【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long countInterestingSubarrays(List<Integer> li, int m, int k) {
        //     n = li.size(); this.m = m; this.k = k; 
        //     long r = 0;
        //     for (int i = 0; i * m + k <= n; i++) {
        //         System.out.println("(i * m + k): " + (i * m + k));
        //         long one = calcCnt(li, i * m + k);
        //         System.out.println("one: " + one);
        //         r += one;
        //     }
        //     return r;
        // }
        // int m, n, k;
        // long calcCnt(List<Integer> li, int cnt) {
        //     long ans = 0;
        //     int cur = 0, l = 0, r = 0;
        //     for (; r < n; r++) {
        //         System.out.println("\n r: " + r);
        //         if (li.get(r) % m == k) cur++;
        //         // 这里，右端点，还可以往右移
        //         if (cur == cnt && (cnt != 0 || cnt == 0 && li.get(r) % m != k)) ans++;
        //         // boolean again = false;
        //         // if (cur > cnt) again = true;
        //         while (cur > cnt) {
        //             // again = true;
        //             if (li.get(l) % m == k) --cur;
        //             l++;
        //         }
        //         // if (cur == cnt && again && (cnt != 0 || cnt == 0 && li.get(r) % m != k)) ans++;
        //         if (cur == cnt && (cnt != 0 || cnt == 0 && li.get(r) % m != k)) ans++;
        //         System.out.println("ans: " + ans);
        //     }
        //     System.out.println("ans: " + ans);
        //     System.out.println("cur: " + cur);
        //     while (l <= r && cur >= cnt) {
        //         while (cur >= cnt) {
        //             if (li.get(l) % m == k) --cur;
        //         }
        //         if (cur == cnt) ans++;
        //         l++;
        //     }
        //     System.out.println("ans: " + ans);
        //     return ans;
        // }

        // 怎么感觉，这是个像是【最大值、最小值】线段树（还有【sum 线段树】），或是求出现次数最多元素的线段树一样。。。
        // 最有效的帮助信息 W 【1,26】要怎么使用这个参数呢？
        public int[] minOperationsQueries(int n, int[][] egs, int[][] qs) {
            g = new ArrayList [n];
            Arrays.stream(g).forEach(z -> Arrays.fill(z, new ArrayList<int []>()));
            for (int [] e : egs) {
                int u = e[0], v = e[1], w = e[2];
                g[u].add(new int [] {v, w});
                g[v].add(new int [] {u, w});
            }
            // 感觉，这个题，可能可以当＝【有向图】来处理，就是随便选哪个作为【根结点】，结果都一样
            // 随机选定一个【根节点】预处理，建立【1,26】词频表
            // 动规解题, 就是先前的什么树状动规？
            f = new int [n][26];
            // 选【0】作为根结点
            dfs(0, -1);
            
        }
        List<int []> [] g;
        int [][] f;
        void dfs(int u, int p) {
            for (int [] v : g[u]) { // 遍历每个子节点
                if (v[0] == p) continue;
                f[u][v[1]]++; // 统计词频
                dfs(v[0], u);
            }
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        int [] a = new int [] {11,12,21,31};
        // int [] a = new int [] {3,2,4};
        System.out.println(Arrays.toString(a));

        long r = s.countInterestingSubarrays(Arrays.stream(a).boxed().collect(Collectors.toList()), 10, 1);
        System.out.println("r: " + r);
    }

}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】