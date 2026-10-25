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

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long maxAlternatingSum(int[] a) {
        //     int n = a.length;
        //     // 【偶奇下标、分别的、前缀和】预处理
        //     long [] f = new long [n+1], g = new long [n+1]; // Even Odd
        //     Arrays.fill(f, Long.MIN_VALUE / 2);
        //     Arrays.fill(g, Long.MIN_VALUE / 2);
        //     for (int i = 0; i < n; i++) 
        //         if (i % 2 == 0) {
        //             // f[i+1] = (i == 0 ? 0 : f[i-1]) + a[i];
        //             f[i+1] = (i == 0 ? 0 : f[i]) + a[i];
        //             if (i > 0)
        //                 g[i+1] = g[i];
        //             else if (n > 1)
        //                 g[i+1] = 0;
        //         } else {
        //             // g[i+1] = (i == 1 ? 0 : g[i-1]) + a[i];
        //             g[i+1] = (i == 1 ? 0 : g[i]) + a[i];
        //             f[i+1] = f[i];
        //         }
        //     System.out.println(Arrays.toString(f));
        //     System.out.println(Arrays.toString(g));
        //     long r = f[n] - (g[n] == Long.MIN_VALUE / 2 ? 0 : g[n]);
        //     // 遍历：被删除下标 i 元素后的、全局最优解
        //     for (int i = 0; i < n; i++) {
        //         // 删除【偶数下标】
        //         if (i % 2 == 0) {
        //             r = Math.max(r, (i == 0 ? g[n] - (f[n] - a[i])
        //                              : f[i] - g[i] + (g[n]-g[i] - (f[n]-f[i+1]))));
        //         }
        //         // 删除【奇数下标】
        //         else {
        //             r = Math.max(r, (i == n-1 ? f[n]-g[n-1]
        //                              : f[i]-g[i] + (g[n]-g[i+1]) - (f[n]-f[i])));
        //         }
        //     }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] maxProductPair(int[] a, int v) {
        //     int n = a.length, max = Integer.MIN_VALUE / 2;
        //     int [] f = new int [2]; Arrays.fill(f, -1);
        //     for (int i = 0; i < n-1; i++)
        //         for (int j = i+1; j < n; j++) {
        //             if (a[i] == a[j]) continue;
        //             if (a[i] + a[j] == v && a[i] * a[j] > max) {
        //                 max = a[i] * a[j];
        //                 f[0] = (a[i] > a[j] ? i : j);
        //                 f[1] = (a[i] > a[j] ? j : i); 
        //             }
        //         }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int resilientSubarray(int[] a, int k) {
        //     int n = a.length, ans = 1;
        //     int [] f = new int [n], r  = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         f[i] = a[i] % k;
        //         r[i] = (i == 0 ? 0 : r[i-1]) + a[i]; // preSum
        //     }
        //     for (int i = 0; i < n-1; i++) {
        //         int j = i+1;
        //         while (j < n && f[j] == f[i]) j++;
        //         if ((r[j-1] - r[i]) % k == 0) {
        //             ans = Math.max(ans, j-i);
        //             i = j-1; 
        //         }
        //     }
        //     return ans;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // TLE TLE TLE ...
        // public int resilientSubarray(int[] a, int k) {
        //     int n = a.length, ans = 1;
        //     int [] f = new int [n], g = new int [n];
        //     long [] r = new long [n];
        //     for (int i = 0; i < n; i++) {
        //         f[i] = a[i] % k;
        //         r[i] = (i == 0 ? 0l : r[i-1]) + (long)a[i]; // preSum
        //     }
        //     System.out.println(Arrays.toString(f));
        //     System.out.println(Arrays.toString(r));
        //     for (int i = 0; i < n; i++) {
        //         g[i] = i;
        //         int j = i+1;
        //         while (j < n && f[j] == f[i]) j++;
        //         if (j-1 != i)
        //             Arrays.fill(g, i, j-1, j-1);
        //     }
        //     System.out.println(Arrays.toString(g));
        //     // 【TODO：】改状下面的方法，把它改写成不超时 
        //     for (int i = 0; i < n-1; i++) {        // 遍历了：【所有可能性的、打头】。。
        //         if (g[i] != i && (r[g[i]] - r[i]) % k == 0) {
        //             ans = Math.max(ans, g[i]-i + 1);
        //             i = g[i]; 
        //         }
        //     }
        //     return ans;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean threeFibonacciSum(int n) {
        //     if (n % 2 == 1) return false;
        //     int m = 46;
        //     int [] f = new int [m];
        //     f[1] = f[2] = 1;
        //     for (int i = 3; i < m; i++)
        //         f[i] = f[i-1] + f[i-2];
        //     for (int i = 0; i < m-1; i++)
        //         if (f[i] + f[i+1] == n / 2) return true;
        //     return false;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // class BusBooking {
        // int [][] f, g;
        // int n, t, tt;
        // public BusBooking(int n) {
        //     this.n = n; 
        //     f = new int [4][n];
        //     g = new int [4][n];
        // }
        // public void toggle(String seat) {
        //     int i = seat.charAt(0)-'A', j = Integer.parseInt(seat.substring(1))-1;
        //     f[i][j] = 1 - f[i][j];
        //     if (f[i][j] == 1) {
        //         if (i == 1 || i == 2) t += 1;
        //         else {
        //             if (i == 0 && f[1][j] == 1 || i == 3 && f[2][j] == 1) {
        //                 t += 3;
        //                 g[i][j] = 1;
        //             }
        //             else t += 1;
        //         }
        //         tt += 1;
        //     } else {
        //         if (g[i][j] == 1) {
        //             t -= 3;
        //             g[i][j] = 0;
        //         } else t -= 1;
        //         tt -= 1;
        //     }
        // }
        // public int getTotalTime() {
        //     return t;
        // }
        // public int getMinTime() {
        //     return tt;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】 
        // // TLE TLE TLE 984 / 1000 testcases passed
        // public List<Integer> maxPrimes(int n, int s) {
        //     if (s == 1) return new ArrayList<>();
        //     // [1000,000] 以内的质数链条
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 2; i <= n; i++) 
        //         if (isPrime(i))
        //             l.add(i);
        //     int m = l.size();
        //     if (m == 0) return new ArrayList<>();
        //     // 【递增、有序数组、前缀和】
        //     long [] f = new long [m];
        //     f[0] = (long)l.get(0);
        //     for (int i = 1; i < m; i++)
        //         f[i] = f[i-1] + (long)l.get(i);
        //     // 【二分查找 O(NlogN)】
        //     int idx = Arrays.binarySearch(f, s);
        //     if (idx >= 0) 
        //         return l.subList(0, idx+1);
        //     int j = -1 * idx - 1;
        //     if (j == m) return l;
        //     if (f[j] - 2l <= (long)s)
        //         return l.subList(1, j+1);
        //     return l.subList(0, j);
        // }
        // boolean isPrime(int v) {
        //     if (v == 1) return false;
        //     if (v < 4) return true;
        //     for (int i = 2; i * i <= v; i++) 
        //         if (v % i == 0) return false;
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minDeletions(int[] a) {
        //     int n = a.length, i = 0, j = 0, f = 0;
        //     while (i < n-1) {
        //         j = i+1;
        //         while (j < n && a[j] == a[i]) {
        //             f++;
        //             j++;
        //         }
        //         if (j == n) return f;
        //         i = j;
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] lastVisitedCell(char[][] a) {
        //     int m = a.length, n = a[0].length;
        //     boolean [][] f = new boolean [m][n];
        //     int i = 0, j = 0, l = 0, r = 0;
        //     while (i >= 0 && i < m && j >= 0 && j < n && !f[i][j]) {
        //         f[i][j] = true; l = i; r = j;
        //         if (a[i][j] == 'L')
        //             --j;
        //         else if (a[i][j] == 'R')
        //             ++j;
        //         else if (a[i][j] == 'U')
        //             --i;
        //         else if (a[i][j] == 'D')
        //             ++i;
        //     }
        //     return new int [] {l, r};           
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int findColoredRoot(int[][] egs, String S) {
        //     n = egs.length+1; s = S.toCharArray();
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<Integer>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     // possible Root 链条 
        //     List<Integer> li = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         List<Integer> l = g[i];
        //         if (sameColor(l) && l.size() <= 2)
        //             li.add(i);
        //     }
        //     if (li.size() == 0) return -1;
        //     for (int i : li) {
        //         if (isValidRoot(i, s[i], -1))
        //             return i;
        //     }
        //     return -1;
        // }
        // List<Integer> [] g; 
        // int n; char [] s;
        // boolean isValidRoot(int u, char c, int p) {
        //     if (s[u] != c) return false;
        //     char cc = (c == 'R' ? 'B' : (c == 'B' ? 'W' : 'R'));
        //     for (int v : g[u]) {
        //         if (v == p) continue;
        //         if (!isValidRoot(v, cc, u)) return false;
        //     }
        //     return true;
        // }
        // boolean sameColor(List<Integer> l) {
        //     char c = s[l.get(0)];
        //     for (int v : l) 
        //         if (s[v] != c)
        //             return false;
        //     return true;
        // }

        // public void removeRange(int left, int right) {
        //     Range high = new Range(right, right);
        //     while (true) {
        //         Range r = ts.lower(high);
        //         if (r == null || r.right <= left) break;
        //         if (r.right > right)
        //             ts.add(new Range(right, r.right));
        //         if (r.left < left)
        //             ts.add(new Range(r.left, left));
        //         ts.remove(r);
        //     }
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，记得：有个 mergeInterval 相关的题目题型
        // class Range implements Comparable<Range> { // 【重要：】只有这样，才可以借助 TreeSet 等数据结构简单查询，就不用自己再写二分搜索了。。。
        //     public int l, r;
        //     public Range(int l, int r) {
        //         this.l = l;
        //         this.r = r;
        //     }
        //     @Override public int compareTo(Range other) { // 这里，我按结束时间升序排列
        //         return this.l != other.l ? this.l - other.l : this.r - other.r;
        //     }
        // }
        // public void addRange(int left, int right, TreeSet<Range> ts) {
        //     int nl = left, nr = right;
        //     Range high = new Range(right, Integer.MAX_VALUE);
        //     while (true) { // 遍历：【自大到小】遍历，会自动合并所有 overlap 的 Range
        //         Range r = ts.lower(high);
        //         if (r == null || r.right < left) break;
        //         if (r.right > right) nr = r.right;
        //         if (r.left < left) nl = r.left;
        //         ts.remove(r);
        //     }
        //     ts.add(new Range(nl, nr));
        // }
        // public boolean queryRange(int left, int right, TreeSet<Range> ts) {
        //     Range target = ts.floor(new Range(left, Integer.MAX_VALUE));
        //     return target != null && target.left <= left && target.right >= right;
        // }
        // // 【TODO：】需要一个改写版本的，可以查询【多个片段，能够合并成目标片段】的 Override 方法 for f
        // public boolean queryRange(int left, int right, TreeSet<Range> ts) {
        //     Range target = ts.floor(new Range(left, Integer.MAX_VALUE));
        //     return target != null && target.left <= left && target.right >= right;
        // }
        // public int minSelection(int[][] a, int[][] b) {
        //     int m = a.length, n = b.length;
        //     Arrays.sort(a, (x, y) -> (x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]));
        //     // target: 合并了的【有序、不 overlap 片段集】
        //     TreeSet<Range> f = new TreeSet<>((a, b)->(a.l != b.l ? a.l - b.l : a.r - b.r)); // 【TODO：】右端点升序，重新排序。。。
        //     TreeSet<Range> ff = new TreeSet<>((a, b)->(a.l != b.l ? a.l - b.l : a.r - b.r));
        //     for (int [] v : b) 
        //         addRange(v[0], v[1], ff);
        //     // 选择：保留【可能完全覆盖的、最大片段】
        //     List<Range> li = new ArrayList<>(), ll = new ArrayList<>();
        //     int i = 0, j = 0;
        //     while (i < m) {
        //         j = i+1;
        //         while (j < m && a[j][0] == a[i][0]) j++;
        //         li.add(a[j-1][0], a[j-1][1]);
        //         i = j;
        //     }
        //     for (Range r : li) f.add(r); // <<<<<<<<<<<<<<<<<<<< 不能合并：源片段
        //     TreeMap<Integer, Integer> dp = new TreeMap<>();
        //     Iterator<Range> it = f.iterator();
        //     while (it.hasNext()) 
        //         ll.add(it.next); // <<<<<<<<<<<<<<<<<<<< 
        //     // 遍历【完全不 overlap 的、目标片段】
        //     for (int i = 0; i < ll.size(); i++) {
        //         Range r = ll.get(i);
        //         if (queryRange(r.l, r.r. f)) { // 存在【1 个片段】可以完全覆盖
        //             if (i == 0)
        //                 dp.put(i, 1);
        //             else dp.put(i, dp.get(i-1) + 1);
        //         } else { // 【TODO：】可能【多个片段，终于，可以完全覆盖】
        //             // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        //             // 亲爱的表哥的活宝妹，改天再写这个破烂题目
        //         }
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int peakValleyDifference(int[] a) {
        //     int n = a.length, f = 0;
        //     for (int i = 1; i < n-1; i++) {
        //         if (a[i-1] < a[i] && a[i] > a[i+1])
        //             f += a[i];
        //         else if (a[i-1] > a[i] && a[i] < a[i+1])
        //             f -= a[i];
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countMagicalPairs(String S) {
        //     int n = S.length(), r = 0; char [] s = S.toCharArray();
        //     int [][] f = new int [n][n];
        //     Set<Character> sc = new HashSet<>();
        //     for (int i = 0; i < n; i++) {
        //         sc.clear();
        //         for (int j = i; j < n; j++) {
        //             sc.add(s[j]);
        //             f[i][j] = sc.size();
        //         }
        //     }
        //     for (int i = 0; i < n-1; i++) 
        //         for (int j = i; j < n-1; j++) 
        //             for (int k = j+1; k < n; k++) 
        //                 if (f[i][j] == f[j+1][k]) r++;
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // TLE TLE TLE 955/1000 passed ... O(NN) 亲爱的表哥的活宝妹，晚点儿再写这个破烂题目
        // // 这个破烂题目，不应该是：遍历【左端点：以左端点为（最大值、或是最小值）来遍历到向右可以延展到的最右端，然后数个数吗，亲爱的表哥的活宝妹、笨宝妹？？？！！！
        // public long countSubarrays(int[] a, int minK, int maxK) {
        //     int n = a.length, i = 0, j = 0, p = 0;
        //     long f = 0l;
        //     while (i < n) {
        //         if (a[i] < minK || a[i] > maxK) {
        //             i++;
        //             continue;
        //         } else if (i > 0 && a[i] == a[i-1]) {
        //             f += (long)--p ;
        //             i++;
        //             continue;
        //         }
        //         j = i + 1;
        //         while (j < n && minK <= a[j] && a[j] <= maxK) j++;
        //         p = j - i;
        //         f += (long)(j - i);
        //         i++;
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，把前一题目，【小规模的 N=2000 的 O(N × N × N)】转化为现在（大规模 N=10^5 的。O(N × 26 × 26)）就可以了
        // // 改进是：外循环每个下标 i, 内循环 j 及内循环 k 不再遍历所有 N, 而仅只遍历最大可能的 26 就可以，不会超时 TLE
        // // 亲爱的表哥的活宝妹，感觉：思路无限清楚，可是下午思路写到这里，细节上脑袋有点儿发昏了。。。改天再接着写这个破烂题目。。。。亲爱的表哥的活宝妹，今天写这些写 sick 了，改天再写。。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long countMagicalPairs(String S) {
        //     int n = S.length(), j = 0, r = 0, l = 0, ll = 0; char [] s = S.toCharArray();
        //     long ans = 0l;
        //     Set<Character> sc = new HashSet<>(), sr = new HashSet<>();
        //     long cur = 0l;
        //     for (int i = 0; i < n-1; i++) { // j: distance
        //         System.out.println("\n i: " + i);
        //         sc.clear();
        //         cur = 0l;
        //         r = i;
        //         // toContinue = false;
        //         while (r < n-1) { // 循环 j:
        //             sc.add(s[r]);
        //             j = sc.size();
        //             System.out.println("i: " + i + " " + "j: " + j);
        //             // 后续字符串：【不够长】
        //             if (j > n - r - 1) break;
        //             sr.clear();
        //             l = r+1;
        //             while (l < n && sr.size() < j) { // 【TODO：】这里要区分 <j 和 ==j 才能数有效个数
        //                 sr.add(s[l]);
        //                 l++;
        //             } // l == n || sr.size() == j
        //             System.out.println("r: " + r + " " + "j: " + j + " " + "l: " + l);
        //             if (sr.size() < j || l >= n-1) {
        //                 if (l >= n-1) {
        //                     // 亲爱的表哥的活宝妹的脑袋，现在正在这个细节上发昏。。。亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹。。。
        //                     int counts = l - r - (l == n && sr.size() == j ? 1 : 0);
        //                     // int counts = l - r - (l == n ? 1 : 0);
        //                     // int counts = l - r - 1;
        //                     ans += (long)counts;
        //                 }
        //                 System.out.println("r: " + r + " " + "j: " + j + " " + "ans 0: " + ans);
        //                 r++;
        //                 continue;
        //             }
        //             // if (l == n) f[i][j] = 1;
        //             ll = l + 1; // 循环 k
        //             sr.add(s[ll]);
        //             while (ll < n && sr.size() == j) {
        //                 ll++;
        //                 sr.add(s[ll]);
        //             }
        //             // if (sr.size() == j) // ll = n;
        //             ans += (long)(ll - l);
        //             System.out.println("r: " + r + " " + "j: " + j + " " + "ans 1: " + ans);
        //             r++;
        //         }
        //         System.out.println("i: " + i + " " + "ans: " + ans);
        //     }
        //     return ans;
        // }
        
    }    // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
        Solution s = new Solution (); 

        // String a = "kkk";
        String a = "aba";

        long r = s.countMagicalPairs(a);
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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】