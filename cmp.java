import com.TreeNode;
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minOperations(int[] a, int k) {
        //     int n = a.length, min = Arrays.stream(a).min().getAsInt();
        //     if (min < k) return -1;
        //     return (int)Arrays.stream(a).distinct().count() - (k < min ? 0 : 1);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这里还有哪点儿细节，没想透，写得不对。。。
        // public int findMinimumTime(List<Integer> l, int k) {
        //     Collections.sort(l);
        //     int n = l.size();
        //     int f = 1, x = 1, i = 0, t = 1;
        //     while (i < n) {
        //         System.out.println("\n t: " + t + " x: " + x);
        //         System.out.println("i: " + i + " " + "f: " + f);
        //         if (f < l.get(i)) {
        //             f += x;
        //         } else {
        //             x += k;
        //             f = x;
        //             i++;
        //         }
        //         t++;
        //     }            
        //     return t-1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 没有其它想法，就直接写【暴力解法】
        // public int minOperations(int n, int m) {
        //     char [] s = String.valueOf(n).toCharArray(), t = String.valueOf(m).toCharArray();
        //     int cur = 0, mod = 1, ans = n;
        //     for (int i = 0; i < s.length; i++) {
        //         if (s[i] == t[i]) continue;
        //         System.out.println("\n i: " + i);
        //         cur += (s[i]-'0') * mod;
        //         int d = (s[i] > t[i] ? -1 : 1);
        //         while (s[i] + d != t[i]) {
        //             if (!isPrime(n / (10 * mod) * (10 * mod) + cur + d * mod))
        //                 return -1; // 答案不对、还有迂回的解法。。。。
        //             ans += n + d * mod;
        //             d += (s[i] > t[i] ? -1 : 1);
        //             System.out.println("ans: " + ans + " " + "d: " + d);
        //         }
        //         mod *= 10;
        //     }
        //     ans += m;
        //     return ans;
        // }
        // boolean isPrime(int f) {
        //     if (f < 4) return true;
        //     for (int i = 2; i * i <= f; i++) 
        //         if (f % i == 0) return false;
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 那么，为什么这个题目，大家解不出来呢？
        // // 【暴力解法】：最可能的结果是，TLE TLE TLE
        // // 【非、暴力解法】：就要处理 threshold <= 2*10^5 的质因子及其个数，以及数组中的那些鬼数。。。
        // // 先，【预处理】threshold <= 2*10^5 ，分解质因子，数其个数
        // // 再，过滤【数组】中的元素，含【非法质因子】的，孤立孤岛1 个，再处理其它
        // // 还是说，用【传统、连通图】来写呢？ UnionFound
        // public int countComponents(int[] a, int threshold) {
        //     int n = a.length;
        //     // 【字典】：记【预处理】threshold <= 2*10^5 ，分解质因子，数其个数
        //     // 再，过滤【数组】中的元素，含【非法质因子】的，孤立孤岛1 个，再处理其它
        //     Arrays.sort(a); // 从小到大，先处理小数。。
        //     System.out.println(Arrays.toString(a));
        //     if (a[0] > threshold) return n;
        //     UF uf = new UF(n);
        //     // 为什么要用字典呢？
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     m.computeIfAbsent(getSmallestPrimeFactor(a[0]), z -> new ArrayList<>()).add(0);
        //     boolean connected = false;
        //     for (int i = 1; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         if (a[i] > threshold) break;
        //         connected = false;
        //         int p = getSmallestPrimeFactor(a[i]);
        //         while (!connected) {
        //             if (!m.containsKey(p)) break;
        //             for (int v : m.get(p)) {
        //                 if (getLcm(a[v], a[i]) <= threshold) {
        //                     uf.union(v, i);
        //                     connected = true;
        //                     m.computeIfAbsent(p, z -> new ArrayList<>()).add(i);
        //                     System.out.println("uf.getcomponentsTTCnts();: " + uf.getcomponentsTTCnts());
        //                     break;
        //                 }
        //             }
        //             if (connected) break;
        //             // while (p == getSmallestPrimeFactor(a[i] / p)) // <<<<<<<<<<<<<<<<<<<< 【TODO：】还有错。。
        //             p = getSmallestPrimeFactor(a[i] / p);
        //         }
        //         if (connected) continue;
        //         for (int j = 0; j < i; j++) 
        //             if (getLcm(a[i], a[j]) <= threshold) {
        //                 uf.union(j, i);
        //                 p = getSmallestPrimeFactor(a[i]);
        //                 m.computeIfAbsent(p, z -> new ArrayList<>()).add(i);
        //             }
        //         System.out.println("uf.getcomponentsTTCnts();: " + uf.getcomponentsTTCnts());
        //     }
        //     return uf.getcomponentsTTCnts();
        // }
        // class UF {
        //     int [] f;
        //     int n, size;
        //     public UF(int n) {
        //         this.n = n; size = n;
        //         f = new int [n];
        //         for (int i = 0; i < n; i++)
        //             f[i] = i;
        //     }
        //     int find(int i) {
        //         if (f[i] == i) return f[i];
        //         while (f[i] != find(f[i]))
        //             f[i] = find(f[i]);
        //         return f[i];
        //     }
        //     void union(int i, int j) {
        //         int pi = find(i), pj = find(j);
        //         if (pi != pj) {
        //             f[i] = pj;
        //             size--;
        //         }
        //     }
        //     int getcomponentsTTCnts() {
        //         return size;
        //     }
        // }
        // List<Integer> l = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
        //                           31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
        //                           73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
        //                           127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
        //                           179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
        //                           233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
        //                           283, 293, 307, 311, 313, 317); // 66 个数
        // int getSmallestPrimeFactor(int x) {
        //     for (int i = 0; i < l.size(); i++) 
        //         if (x % l.get(i) == 0) return l.get(i);
        //     return -1;
        // }
        // int getGcd(int i, int j) { // 求：【最大公约数】
        //     if (j == 0) return i;
        //     return getGcd(j, i % j);
        // }
        // int getLcm(int i, int j) { // 求：【最小公倍数】＝ 两数积 除以 最大公约数
        //     return i * j / getGcd(i, j);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] constructTransformedArray(int[] a) {
        //     int n = a.length;
        //     int [] f = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] == 0) continue;
        //         if (a[i] > 0) f[i] = a[(i + a[i]) % n];
        //         else f[i] = a[(i + a[i] + 100 * n) % n];
        //     }
        //     return f;
        // }

//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         // 因为数据规模小，先弄个可以过的方法2^10 勉强能过。。
//         public int maxRectangleArea(int[][] a) {
//             int n = a.length, max = -1;
//             Arrays.sort(a, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); this.a = a; 
//             boolean valid = true;
//             for (int v = 0; v < (1 << n); v++) {
//                 if (Integer.bitCount(v) != 4) continue;
//                 int [] f = new int [4];
//                 int idx = 0;
//                 for (int j = 0; j < n; j++) 
//                     if ((v & (1 << j)) > 0) f[idx++] = j;
//                 int i = f[0], j = f[1], k = f[2], xx = f[3];
//                 if (a[i][0] != a[j][0] || a[i][1] != a[k][1]
//                     || a[k][0] != a[xx][0] || a[j][1] != a[xx][1])
//                     continue;
// // 再把中间的【空洞检测】：必须落在正方形外
//                 x = new int [2]; yy = new int [2];
//                 x[0] = a[i][0]; x[1] = a[k][0];
//                 yy[0] = a[i][1]; yy[1] = a[j][1];
//                 valid = true;
//                 if (j-i > 1)
//                     for (int y = i+1; y < j; y++) 
//                         if (!outside(y)) {
//                             valid = false;
//                             break;
//                         }
//                 if (!valid) continue;
//                 if (k-j > 1) {
//                     for (int y = j+1; y < k; y++) {
//                         if (!outside(y)) {
//                             valid = false;
//                             break;
//                         }
//                     }
//                 }
//                 if (!valid) continue;
//                 if (xx-k > 1)
//                     for (int y = k+1; y < xx; y++) 
//                         if (!outside(y)) {
//                             valid = false;
//                             break;
//                         }
//                 if (!valid) continue;
//                 i = f[0]; j = f[1]; k = f[2]; xx = f[3];
//                 max = Math.max(max, (a[k][0] - a[i][0]) * (a[j][1] - a[i][1]));
//             }
//             return max;
//         }
//         int [][] a;
//         int [] x, yy;
//         boolean outside(int i) {
//             if (a[i][0] >= x[0] && a[i][0] <= x[1]
//                 && a[i][1] >= yy[0] && a[i][1] <= yy[1])
//                 return false;
//             return true;
//         }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，先写个【暴力解法】
        // // 数字也大，数据规模也大。。。感觉与【差分数组、和、2 个BIT】有可能有点儿关系。。【TODO：】
        // public long maxSubarraySum(int[] a, int k) { // TLE 655/661
        //     int n = a.length;
        //     long [] f = new long [n+1];
        //     for (int i = 1; i <= n; i++)
        //         f[i] = f[i-1] + (long)a[i-1];
        //     long r = Long.MIN_VALUE;
        //     for (int i = k; i <= n; i++) { // 累计和
        //         for (int j = i-k; j >= 0; j -= k) 
        //             if (Long.compare(r, f[i]-f[j]) < 0) 
        //                 r = f[i] - f[j];
        //     }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long maxRectangleArea(int[] xx, int[] yy) {
        //     int n = xx.length;
        //     int [][] a = new int [n][2];
        //     for (int i = 0; i < n; i++) {
        //         a[i][0] = xx[i];
        //         a[i][1] = yy[i];
        //     }
        //     Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); 
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int buttonWithLongestTime(int[][] a) {
        //     int n = a.length, idx = a[0][0], t = a[0][1], cur = 0;
        //     for (int i = 1; i < n; i++) {
        //         cur = a[i][1] - a[i-1][1];
        //         if (cur > t || cur == t && a[i][0] < idx) {
        //             if (cur > t)
        //                 t = cur;
        //             idx = a[i][0];
        //         }
        //     }
        //     return idx;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 像个什么，狗屁的【图的转化】：怎么把两个数组，转化成一个图，求转化后图的【最大边距】
        // // 数据规模狠小，不想什么多的，就【暴力】写。。。暂时不写这个题目了。。。【TODO：】
        // public double maxAmount(String initialCurrency, List<List<String>> p, double[] r, List<List<String>> pp, double[] rr) {
        //     int m = rr.length, n = r.length; intCur = initialCurrency;
        //     // this.p = p; this.pp = pp; this.r = r; this.rr = rr; 
        //     Map<String, Double> map = new HashMap<String, Double>(), s = new HashMap<String, Double>();
        //     // // 【数据预处理】：添加相反的, 直接添加相反的，会Stackoverflow. 还是得建图。。建图的方向问题。。
        //     // double [] rn = new double [n * 2], rrn = new double [m * 2];
        //     // for (int i = 0; i < n; i++) {
        //     //     p.add(List.of(p.get(i).get(1), p.get(i).get(0)));
        //     //     rn[i] = r[i];
        //     //     rn[n + i] = (double)(1d / r[i]);
        //     // }
        //     // for (int i = 0; i < m; i++) {
        //     //     pp.add(List.of(pp.get(i).get(1), pp.get(i).get(0)));
        //     //     rrn[i] = rr[i];
        //     //     rrn[n + i] = (double)(1d / rr[i]);
        //     // }
        //     // 【第1 天】
        //     // dfs(initialCurrency, 1.0, p, rn, map);
        //     dfs(initialCurrency, 1.0, p, r, map);
        //     // 【第2 天】
        //     for (Map.Entry<String, Double> en : map.entrySet()) 
        //         // dfs(en.getKey(), en.getValue(), pp, rrn, s);
        //         dfs(en.getKey(), en.getValue(), pp, rr, s);
        //     // dfs(initialCurrency, 1.0, pp, rrn, s);
        //     dfs(initialCurrency, 1.0, pp, rr, s);
        //     return s.getOrDefault(initialCurrency, 1.0);
        //     // return Collections.max(s.values());
        // }
        // String intCur;
        // void dfs(String cur, double v, List<List<String>> l, double [] f,  Map<String, Double> map) {
        //     // if (!must || must && cur.equals(intCur))
        //     map.put(cur, Math.max(map.getOrDefault(cur, 0d), v));
        //     for (int i = 0; i < f.length; i++) {
        //         if (l.get(i).get(0).equals(cur))
        //             dfs(l.get(i).get(1), (double)v * f[i], l, f, map);
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 明明是【动规】，写【暴力】: 写暴力，不知道会不会超时。。感觉像是会的。。TLE TLE TLE 578/583 晚点儿再写
        //  public int beautifulSplits(int[] a) {
        //      n = a.length; this.a = a; 
        //      int f = 0;
        //      for (int i = 1; i < n-1; i++) 
        //          for (int j = i+1; j < n; j++) 
        //              if (isPrefix(i, j)) f++;
        //      return f;
        //  }
        // int n; int [] a;
        // boolean isPrefix(int i, int j) {
        //     boolean valid = false; 
        //     if (i <= j - i && a[i] == a[0]) {
        //         valid = true;
        //         for (int x = i; x < 2 * i; x++) 
        //             if (a[x] != a[x-i]) {
        //                 valid = false;
        //                 break;
        //             }
        //         if (valid) return true;
        //     }
        //     if (j-i <= n-j && a[j] == a[i]) {
        //         valid = true;
        //         for (int x = j; x < j+j-i; x++) 
        //             if (a[x] != a[x - (j-i)]) {
        //                 valid = false;
        //                 break;
        //             }
        //         if (valid) return true;
        //     }
        //     return false;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 明明是【动规】，写【暴力】: 写暴力，不知道会不会超时。。感觉像是会的。。TLE TLE TLE 578/583 晚点儿再写
        // // 亲爱的表哥的活宝妹，笨宝妹，哪怕是写：万能的【记忆化深搜】与比直接写最蠢笨的【暴力】不容易超时。。。
        // // 亲爱的表哥的活宝妹，笨宝妹，这跟【记忆化深搜】有关系吗？
        // public int beautifulSplits(int[] a) {
        //     n = a.length; this.a = a;
        //     g = new ArrayList [51];
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     for (int i = 0; i < n; i++)
        //         g[a[i]].add(i); // 【单调升序】：晚点儿可以【二分查找O(logN)】
        //     // 思路不透彻。。。
        // }
        // int n; int [] a;
        // List<Integer> [] g;

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int makeStringGood(String S) {
        //     int n = S.length(), m = 0; char [] s = S.toCharArray();
        //     int [] a = new int [26];
        //     for (char c : s)
        //         a[c-'a']++;
        //     for (int i = 0; i < 26; i++)
        //         if (a[i] > 0) m++; // 字符总个数
        //     int [] f = new int [26];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countSubarrays(int[] a) {
        //     int n = a.length, f = 0;
        //     for (int i = 0; i+2 < n; i++) 
        //         if ((a[i] + a[i+2]) * 2 == a[i+1]) f++;
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【记忆化深搜】，应该是能够写过的；直接写【动规】
        // static final int mod = (int)1e9 + 7;
        // public int countPathsWithXorValue(int[][] a, int v) {
        //     int m = a.length, n = a[0].length, o = 16;
        //     int [][][] f = new int [m][n][o];
        //     f[0][0][a[0][0]] = 1;
        //     for (int j = 1; j < n; j++)
        //         for (int k = 0; k < o; k++) 
        //         f[0][j][k] = f[0][j-1][k ^ a[0][j]];
        //     for (int i = 1; i < m; i++)
        //         for (int k = 0; k < o; k++)
        //             f[i][0][k] = f[i-1][0][k ^ a[i][0]];
        //     for (int i = 1; i < m; i++)
        //         for (int j = 1; j < n; j++) {
        //             // if ((a[i-1][j-1] ^ v) > 0) continue;
        //             for (int k = 0; k < o; k++) {
        //                 f[i][j][k] = (int)(((long)f[i][j][k] + (long)f[i-1][j][k ^ a[i][j]]) % mod);
        //                 f[i][j][k] = (int)(((long)f[i][j][k] + (long)f[i][j-1][k ^ a[i][j]]) % mod);
        //             }
        //         }
        //     return f[m-1][n-1][v];
        // }
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 【记忆化深搜】，应该是能够写过的；直接写【动规】
        // static final int mod = (int)1e9 + 7;
        // public int countPathsWithXorValue(int[][] a, int v) {
        //     int m = a.length, n = a[0].length, o = 16;
        //     int [][][] f = new int [m+1][n+1][o];
        //     f[0][1][0] = f[1][0][0] = 1;
        //     for (int i = 1; i <= m; i++)
        //         for (int j = 1; j <= n; j++) {
        //             // if ((a[i-1][j-1] ^ v) > 0) continue;
        //             for (int k = 0; k < o; k++) {
        //                 f[i][j][k] = (int)(((long)f[i][j][k] + (long)f[i-1][j][k ^ a[i-1][j-1]]) % mod);
        //                 f[i][j][k] = (int)(((long)f[i][j][k] + (long)f[i][j-1][k ^ a[i-1][j-1]]) % mod);
        //                 if (i == 1 && j == 1)
        //                     f[i][j][k] /= 2;
        //             }
        //         }
        //     return f[m][n][v];
        // }

        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean checkValidCuts(int m, int [][] f) {
        //     int n = f.length;
        //     // 【按 x 轴，升序排列】：检测竖切
        //     Arrays.sort(f, (x, y) -> x[0] != y[0] ? x[0] - y[0] : (x[2] != y[2] ? x[2] - y[2] : x[1] - y[1])); 
        //     int p = f[0][2], i = 1, cnt = 1;
        //     while (i < n) {
        //         while (i < n && f[i][0] < p) {
        //             p = Math.max(p, f[i][2]);
        //             i++;
        //         }
        //         if (i < n) {
        //             p = f[i][2];
        //             cnt++;
        //             i++;
        //         }
        //     }
        //     if (cnt >= 3) return true;
        //     // 【按 x 轴，升序排列】：检测竖切
        //     Arrays.sort(f, (x, y) -> x[1] != y[1] ? x[1] - y[1] : (x[3] != y[3] ? x[3] - y[3] : x[0] - y[0])); 
        //     p = f[0][3]; i = 1; cnt = 1;
        //     while (i < n) {
        //         while (i < n && f[i][1] < p) {
        //             p = Math.max(p, f[i][3]);
        //             i++;
        //         }
        //         if (i < n) {
        //             p = f[i][3];
        //             cnt++;
        //             i++;
        //         }
        //     }
        //     return cnt >= 3;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】：状态定义，比较难。。
        // // 亲爱的表哥的活宝妹，觉得：今天早上的题目，往常每两周周六早上的题目，都【狠难】。。今天的【太简单、没意思】
        // // 亲爱的表哥的活宝妹，觉得：今天早上的题目，【简单的题目，太简单；难的题目，又太难，木意思。。。】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // public int subsequencesWithMiddleMode(int[] a) {
        //     int n = a.length;
        //     // 【数据、按下标序列的、字频】：预处理
        //     // 字频：单值的、按序列 idx 的、截止当前序列的【字频】【字典数组】
        //     Map<Integer, Integer> [] m = new HashMap[n];
        //     Arrays.setAll(m, z -> new HashMap<Integer, Integer>());
        //     m[0].put(a[0], 1);
        //     for (int i = 1; i < n; i++) {
        //         m[i].putAll(m[i-1]);
        //         m[i].put(a[i], m[i].getOrDefault(a[i], 0)+1);
        //     }
        //     // 【遍历：五数序列的中间值 s2】，累加个数
        //     // 五个数的中间数S2: 可以出现【2, 3, 4, 5】次，可能需要分情况讨论。。
        //     long f = 0;
        //     for (int i = 2; i+2 < n; i++) {
        //         if (m[n-1].get(a[i]) == 1) continue; // 全数组，出现且仅出现1 次，一定不合法！！
        //         // switch (m[i].get(a[i])) {
        //         switch (m[n-1].get(a[i])) {
        //         case 2:
        //         case 3: // 这两种情况特殊，或可全并讨论
        //         case 4:
        //         case 5: // 可以 >= 5 
        //         }
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minimumOperations(int[] a) {
        //     int n = a.length;
        //     Set<Integer> s = new HashSet<>();
        //     for (int i = n-1; i >= 0; i--) {
        //         if (!s.contains(a[i]))
        //             s.add(a[i]);
        //         else return (i+1) / 3 + ((i+1) % 3 != 0 ? 1 : 0);
        //     }
        //     return 0;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxDistinctElements(int[] a, int k) {
        //     int n = a.length, cnt = 0;
        //     Arrays.sort(a);
        //     System.out.println(Arrays.toString(a));
        //     Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     if (k == 0) return s.size();
        //     // 【贪心】：每个下标，都取尽可能地小
        //     s.clear();
        //     a[0] -= k;
        //     s.add(a[0]);
        //     for (int i = 1; i < n; i++) {
        //         if (a[i-1]+1 < a[i] - k)
        //             a[i] -= k;
        //         else
        //             // if (a[i-1]+1 <= a[i] + k)
        //             a[i] = Math.min(a[i-1]+1, a[i] + k);
        //         s.add(a[i]);
        //     }
        //     return s.size();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 不能用【局部贪心法】：因为局部贪心，可能无法保证全局最优
        // public int minLength(String S, int cnt) {
        //     n = S.length(); char [] s = S.toCharArray(); this.cnt = cnt; 
        //     a = new int [n];
        //     for (int i = 0; i < n; i++)
        //         a[i] = s[i] - '0';
        //     System.out.println(Arrays.toString(a));
        //   // 【二分查找】
        //     int l = 1, r = n, ans = n;
        //     while (l <= r) {
        //         int m = (l + r) / 2;
        //         System.out.println("l: " + l + " " + "r: " + r);
        //         System.out.println("m: " + m);
        //         if (isPossible(m)) {
        //             ans = m;
        //             System.out.println("ans: " + ans);
        //             r = m-1;
        //         } else l = m + 1;
        //     }
        //     return ans;
        // }
        // int [] a;
        // int n, cnt;
        // // 【检测方法】：是可以使用【贪心的】。。
        // boolean isPossible(int v) { // 这个检测方法写得不对
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> y[1]-y[0] - (x[1]-x[0]));
        //     int i = 1, j = 0, cnts = cnt;
        //     int [] b = new int [n];
        //     b = Arrays.copyOf(a, n);
        //     // 预处理数据，加入队列
        //     while (i < n) {
        //         if (b[i] != b[i-1]) {
        //             i++;
        //             continue;
        //         }
        //         j = i;
        //         while (j < n && b[j] == b[i-1]) 
        //             j++;
        //         // if (j == n || b[j] != b[i]) i = j;
        //         if (j == n || b[j] != b[i-1]) {
        //             q.add(new int [] {j-1, i-1});
        //             i = j+1;
        //         }
        //     }
        //     while (cnts >= 0 && !q.isEmpty()) {
        //         if (q.peek()[1] - q.peek()[0] + 1 <= v) return true;
        //         int [] f = q.poll();
        //         // 下面这一步，计算不对。。。
        //         // 亲爱的表哥的活宝妹，晚餐胀得太饱了。。。脑袋在这里打酱糊。。。【TODO：】这个细节写得不对。。。
        //         cnts -= (f[1] - f[0] + 1) / (v+1) - ((f[1] - f[0] + 1) % (v+1) == v ? 1 : 0);
        //     }
        //     return cnts >= 0;
        // }
        // boolean isPossible(int v) { // 这个检测方法写得不对：有个顺序问题，不一定是修改最后一个。。
        //     int i = 1, j = 0, cnts = cnt;
        //     int [] b = new int [n];
        //     b = Arrays.copyOf(a, n);
        //     while (i < n) {
        //         System.out.println("\n i: " + i);
        //         if (b[i] != b[i-1]) {
        //             i++;
        //             continue;
        //         }
        //         j = i;
        //         while (j < n && b[j] == b[i-1]) {
        //             if (j-i+1 == v) {
        //                 cnts--;
        //                 System.out.println("j: " + j + " " + "cnts: " + cnts);
        //                 if (cnts < 0) return false;
        //                 b[j] = 1 - b[j];
        //                 i = j;
        //                 j = i;
        //                 // break;
        //             } else 
        //                 j++;
        //         }
        //         if (j == n || b[j] != b[i]) i = j;
        //     }
        //     return cnts >= 0;
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        public int minimumOperations(int[][] f) {
            int m = f.length, n = f[0].length, r = 0;
            for (int j = 0; j < n; j++) 
                for (int i = 1; i < m; i++) {
                    if (f[i][j] != f[i-1][j]+1) {
                        r += Math.max(f[i][j], f[i-1][j]+1) - f[i][j];
                        f[i][j] = Math.max(f[i][j], f[i-1][j]+1);
                    }
                }
            return r;
        }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int compare(String S, String T) {
        //     int m = S.length(), n = T.length(); char [] s = S.toCharArray(), t = T.toCharArray();
        //     int o = Math.min(m, n);
        //     for (int i = 0; i < o; i++)
        //         if (s[i] - t[i] < 0) return -1;
        //         else if (s[i] - t[i] > 0) return 1;
        //     return (m == n ? 0 : (m < n ? -1 : 1));
        // }
        // public String answerString(String S, int k) {
        //     int n = S.length(), m = 26; char [] s = S.toCharArray();
        //     if (k == 1) return S;
        //     List<Integer> [] f = new ArrayList[m];
        //     Arrays.setAll(f, z -> new ArrayList<Integer>());
        //     for (int i = 0; i < n; i++)
        //         f[s[i]-'a'].add(i);
        //     Queue<Integer> q;
        //     int [] r;
        //     // 遍历: 贪心，只要找到最大可折分的，就直接返回
        //     for (int i = m-1; i >= 0; i--) { // [z-a]
        //         if (f[i].size() == 0) continue;
        //         if (k == n) return new String(""+(char)('a'+i));
        //         // 【多源头、同字符 z 打头、多个字符串大小比较】：好像AC 自动机。。
        //         r = new int [f[i].size()];
        //         for (int j = 0; j < f[i].size(); j++)
        //             r[j] = f[i].get(j);
        //         q = new PriorityQueue<Integer>((x, y)-> -1 * compare(S.substring(r[x], n-Math.max(0, k-1-r[x])),
        //                                                        S.substring(r[y], n-Math.max(0, k-1-r[y]))));
        //         for (int j = 0; j < f[i].size(); j++)
        //             q.offer(j);
        //         int j = q.peek();
        //         return S.substring(r[j], n-Math.max(0, k-1-r[j]));
        //     }
        //     return "";
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【TODO：】亲爱的表哥的活宝妹，不知道这里哪里写错了。。。
        // public long numberOfSubsequences(int [] a) {
        //     int n = a.length; long r = 0;
        //     // 遍历【pq】与【rs】中间的数。。没想透：感觉遍历中间这些数，不靠谱，可能重复，不够精确。。
        //     // for (int i = 3; i < n-3; i++) 
        //     Map<Integer, Integer> f = new HashMap<>();
        //     for (int i = n-1; i >= 6; i--) 
        //         f.put(a[i], f.getOrDefault(a[i], 0) + 1);
        //     // 遍历：【自左向右，字典纪录前事】；遍历第三个数 r, 查找第四个数 s
        //     Map<Integer, Integer> [] m = new TreeMap[n];
        //     Arrays.setAll(m, z -> new TreeMap<Integer, Integer>((x, y)->y-x));
        //     m[2].put(a[0] * a[2], 1);
        //     m[3].put(a[1] * a[3], 1);
        //     m[3].put(a[0] * a[3], 1);
        //     // 遍历【 a[i] 为第三个数 r】：前序处理字典数组；后序处理词频字典
        //     for (int i = 4; i < n; i++) {
        //         // 遍历前面 2 个字典 m[i-2] 和 m[i-3]
        //         for (int d = 2; d <= 3; d++) {
        //             for (int k : m[i-d].keySet()) {
        //                 if (k >= a[i] && k % a[i] == 0) {
        //                     // 查找、数：第四个数 s 的可能个数
        //                     if (f.containsKey(k / a[i]))
        //                         r += (long)f.get(k / a[i]) * m[i-d].get(k);
        //                 } else if (k < a[i])
        //                     break;
        //             }
        //             // m[i].putAll(m[i-d]);
        //         }
        //         m[i].putAll(m[i-2]);
        //         for (Map.Entry<Integer, Integer> en : m[i-3].entrySet()) 
        //             m[i].put(en.getKey(), m[i].getOrDefault(en.getKey(), 0) + en.getValue());
        //         // 前序处理字典数组
        //         for (int j = i-2; j >= 0; j--) 
        //             m[i].put(a[i] * a[j], m[i].getOrDefault(a[i] * a[j], 0) + 1);
        //         // 后序处理词频字典
        //         if (i+2 < n) {
        //             f.put(a[i+2], f.getOrDefault(a[i+2], 1)-1);
        //             if (f.get(a[i+2]) == 0)
        //                 f.remove(a[i+2]);
        //         }
        //     }
        //     return r;
        // }
        // int []  a = new int []  {3, 4, 3, 4, 3, 4, 3, 4};

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 数据规模好大： m|n[1,10^5] k[0,n-1]
        // // 亲爱的表哥的活宝妹，数据规模狠大的时候，就不要脑袋不转，死盯着【三维动规：MNK】，三维动规，一定超时！！！
        // // 一定【不是、三维动规】：一定有其它简单解法。。。就是狗屁不通、恶心死人不尝命的数学解法。。。真贱。。。
        // static final int mod = (int)1e9 + 7;
        // public int countGoodArrays(int n, int m, int k) {
        //     long [] f = new long [n+1];
        //     f[0] = 1l;
        //     for (int i = 1; i <= n; i++) 
        //         f[i] = (long)(f[i-1] * (long)i % mod);
        //     return (int)((m * quickMul(m-1, n-1-k) * f[n-1] / (f[n-1-k] * f[k]) + mod) % mod);
        // }
        // long quickMul(long b, long p) {
        //     long f = 1;
        //     while (p > 0) {
        //         if ((p & 1) == 1) 
        //             f = (long)(f * b % mod);
        //         b = (long)(b * b % mod);
        //         p /= 2 ;
        //     }
        //     System.out.println("f: " + f);
        //     return f;
        // }
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
		Solution s = new Solution ();

        int r = s.;
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