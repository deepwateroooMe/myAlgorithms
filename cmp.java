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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
public class cmp {
    // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    public static class Solution { 
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minQueenMoves(int[] a, int[] b) {
        //     if (a[0] == b[0] && a[1] == b[1]) return 0;
        //     if (a[0] == b[0] || a[1] == b[1]) return 1;
        //     if (Math.abs(a[0] - b[0]) == Math.abs(a[1] - b[1])) return 1;
        //     return 2;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 636/640 passed... 亲爱的表哥的活宝妹，看不懂 failed 掉的案例，是什么意思。。。
        // public boolean canTransform(int[] a, int[] b) {
        //     int n = a.length;
        //     if (b.length != n) return false;
        //     List<int []> l = new ArrayList<>();
        //     List<int []> ll = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] == b[i]) continue;
        //         l.add(new int [] {a[i], b[i], i});
        //         ll.add(new int [] {a[i] - b[i], i});
        //     }
        //     // 按【Ai: 升序排列】方便 O(logN) 二分查找
        //     Collections.sort(l, (x, y)->(x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]));
        //     Collections.sort(ll, (x, y)->(x[0] != y[0] ? x[0] - y[0] : x[1] - y[1])); // 按〇升序排列
        //     Arrays.sort(a);Arrays.sort(b);
        //     boolean valid = true;
        //     long r = 0l, rr = 0l;
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] != b[i]) //{
        //             valid = false;
        //             // break;
        //         // }
        //         r += (long)a[i];
        //         rr += (long)b[i];
        //     }
        //     if (valid) return true;
        //     if (r == rr) return true;
        //     int m = l.size();
        //     boolean [] f = new boolean [n];
        //     for (int i = 0; i < m; i++) {
        //         if (f[l.get(i)[2]]) continue;
        //         // if (a[i] > b[i]) return false;
        //         Comparator<int[]> arrayComparator = (x, y) -> Integer.compare(x[0], y[0]);
        //         int [] key = new int [] {b[i] - a[i], 0};
        //         int j = Collections.binarySearch(ll, key, arrayComparator);
        //         // System.out.println("i: " + i + " " + "j: " + j);
        //         System.out.println("l.get(i)[2]: " + l.get(i)[2] + " " + "j: " + j);
        //        if (j < 0) return false;
        //        while (j < m && f[ll.get(j)[1]]) j++;
        //         if (j == m) return false;
        //         f[ll.get(j)[1]] = true;
        //     }
        //     return true;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 636/640 passed... 亲爱的表哥的活宝妹，看不懂 failed 掉的案例，是什么意思。。。
        // public boolean canTransform(int[] a, int[] b) {
        //     int n = a.length;
        //     int [] f = new int [n];
        //     Arrays.fill(f, Integer.MIN_VALUE / 2);
        //     for (int i = 0; i < n-1; i++) {
        //         int v = (f[i] == Integer.MIN_VALUE / 2 ? a[i] : f[i]);
        //         if (v == b[i]) continue;
        //         f[i+1] = (int)((long)v + (long)a[i+1] - (long)b[i]);
        //         f[i] = v + a[i+1] - f[i+1];
        //     }
        //     System.out.println(Arrays.toString(f));
        //     return (f[n-1] == Integer.MIN_VALUE / 2 && a[n-1] == b[n-1] || f[n-1] == b[n-1]);
        // }
        // int []  a = new int []  {1000000000, 1000000000, 1000000000, 1000000000, 294967296};
        // int [] b = new int [] {0,0,0,0,0};
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] rearrangeArray(int[] a) {
        //     int n = a.length, i = 0;
        //     TreeMap<Integer, Integer> m = new TreeMap<>(), t = new TreeMap<>();
        //     for (int v : a) 
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //     int [] f = new int [n];
        //     while (m.size() > 0) {
                
        //         for (int key : m.keySet()) {
        //             f[i++] = key;
        //             int v = m.get(key);
        //             if (--v > 0)
        //                 t.put(key, v);
        //         }
        //         m.clear();
        //         m.putAll(t);
        //         t.clear();
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 思路想得不够透彻，选了第2 高频次的数，但当有多个备选，位置下标 idx-matters....
        // public int maxEqualAdjacentPairs(int[] a) {
        //     int n = a.length, r = 0, v = 0;
        //     if (Arrays.stream(a).distinct().count() == 1) return n-1;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int x : a) 
        //         m.put(x, m.getOrDefault(x, 0) + 1);
        //     int maxCnt = Collections.max(m.values()), key = 0, sec = 0, secCnt = 0;
        //     for (Map.Entry<Integer, Integer> en : m.entrySet()) {
        //         v = en.getValue();
        //         if (v == maxCnt) {
        //             key = en.getKey();
        //         } else if (v > secCnt) {
        //             secCnt = v;
        //             sec = en.getKey();
        //         }
        //     }
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] == sec) {
        //             a[i] = key;
        //             // if (i == 0) continue;
        //             if (i > 0 && a[i] == a[i-1])  r++;
        //         } else if (a[i] == key && i > 0 && a[i] == a[i-1]) r++;
        //     }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxSubarray(int[] a) {
        //     int n = a.length;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 如果不能转化为【图 Graph】的思路来问题，就想到先前有个什么【接龙型动规】
        // // 【接龙型动规】
        // // 亲爱的表哥的活宝妹，今天晚上电脑没电了。。。笨宝妹晚上想想这个破烂题目，明天再接着这里写这组破烂题目
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long maxEarnings(int[][] a) {
        //     int n = a.length;
        //     // 不知道：数组是否是有序排列的
        //     // Arrays.sort(a, (x, y)->(x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]));
        //     // 【结束时间：升序】
        //     Arrays.sort(a, (x, y)->(x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]));
        //     // 截止【结束时间】：所能获得的最大利润
        //     TreeMap<Integer, Long> m = new TreeMap<>();
        //     for (int i = 0; i < n; i++) {
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minRotations(String S) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     System.out.println(Arrays.toString(s));
        //     int f = 0, r = 0; // r: current
        //     for (int i = 0; i < n; i++) {
        //         int v = s[i] - '0';
        //         f += Math.min(Math.abs(v - r), Math.min(r + 10 - v, 10 - r + v));
        //         r = v;
        //         System.out.println("f: " + f + " " + "r: " + r);
        //     }
        //     return f;
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，不想再写这个破烂题目了，太恶心人了。。。。
        // public int minRotations(int n, String S) {
        //     char [] s = S.toCharArray();
        //     int [] f = new int [n], g = new int [n];
        //     helperRotation(S, f);
        //     // Arrays.fill(g, -(s[n-1]-'0'));
        //     g[0] = -(s[n-1]-'0');
        //     // System.out.println(Arrays.toString(g));
        // helperRotation(new StringBuilder(S).reverse().toString(), g);
        //     System.out.println(Arrays.toString(f));
        //     System.out.println(Arrays.toString(g));
        //     int ans = f[n-1], v = s[n-1] - '0', r = 0;
        //     for (int i = 0; i < n-1; i++) {
        //         System.out.println("\n i: " + i);
        //         r = (i == 0 ? 0 : s[i-1]-'0');
        //         // System.out.println("((i == 0 ? 0 : f[i-1]) + g[n-1-(i == 0 ? 0 : i-1)] + Math.min(Math.abs(v - r), Math.min(r + 10 - v, 10 - r + v))): " + ((i == 0 ? 0 : f[i-1]) + g[n-1-(i == 0 ? 0 : i-1)] + Math.min(Math.abs(v - r), Math.min(r + 10 - v, 10 - r + v))));
        //         // System.out.println("Math.abs(v-r): " + Math.abs(v-r) + " " + "Math.min(r + 10 - v, 10 - r + v): " + Math.min(r + 10 - v, 10 - r + v));
        //         // if (i > 0) {
        //         //     System.out.println("f[i-1]: " + f[i-1] + " " + "g[n-1-(i == 0 ? 0 : i-1)]: " + g[n-1-(i == 0 ? 0 : i-1)]);
        //         //     System.out.println("f[i-1] + g[n-1-(i == 0 ? 0 : i-1)]: " + f[i-1] + g[n-1-(i == 0 ? 0 : i-1)]);
        //         // }
        //         ans = Math.min(ans, (i == 0 ? 0 : f[i-1]) + g[n-1-(i == 0 ? 0 : i)]
        //                        + Math.min(Math.abs(v - r), Math.min(r + 10 - v, 10 - r + v))); 
        //         System.out.println("r: " + r + " " + "ans: " + ans);
        //     }
        //     return ans;
        // }
        // void helperRotation(String S, int [] f) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     System.out.println(Arrays.toString(s));
        //     int r = 0; // r: current
        //     for (int i = 0; i < n; i++) {
        //         int v = s[i] - '0';
        //         f[i] += (i == 0 ? 0 : f[i-1]) + Math.min(Math.abs(v - r), Math.min(r + 10 - v, 10 - r + v));
        //         r = v;
        //     }
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        public long maxAlternatingSum(int[] a) {
            int n = a.length;
            // 【偶奇下标、分别的、前缀和】预处理
            long [] f = new long [n+1], g = new long [n+1]; // Even Odd
            Arrays.fill(f, Long.MIN_VALUE / 2);
            Arrays.fill(g, Long.MIN_VALUE / 2);
            for (int i = 0; i < n; i++) 
                if (i % 2 == 0) {
                    // f[i+1] = (i == 0 ? 0 : f[i-1]) + a[i];
                    f[i+1] = (i == 0 ? 0 : f[i]) + a[i];
                    if (i > 0)
                        g[i+1] = g[i];
                    else if (n > 1)
                        g[i+1] = 0;
                } else {
                    // g[i+1] = (i == 1 ? 0 : g[i-1]) + a[i];
                    g[i+1] = (i == 1 ? 0 : g[i]) + a[i];
                    f[i+1] = f[i];
                }
            System.out.println(Arrays.toString(f));
            System.out.println(Arrays.toString(g));
            long r = f[n] - (g[n] == Long.MIN_VALUE / 2 ? 0 : g[n]);
            // 遍历：被删除下标 i 元素后的、全局最优解
            for (int i = 0; i < n; i++) {
                // 删除【偶数下标】
                if (i % 2 == 0) {
                    r = Math.max(r, (i == 0 ? g[n] - (f[n] - a[i])
                                     : f[i] - g[i] + (g[n]-g[i] - (f[n]-f[i+1]))));
                }
                // 删除【奇数下标】
                else {
                    r = Math.max(r, (i == n-1 ? f[n]-g[n-1]
                                     : f[i]-g[i] + (g[n]-g[i+1]) - (f[n]-f[i])));
                }
            }
            return r;
        }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        public int countGoodStrings(long n) {
            return 0;
        }
    }    // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
        Solution s = new Solution (); 

        int [] a = new int [] {5, -5, 1};
        
        long r = s.maxAlternatingSum(a);
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