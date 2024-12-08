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

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        public long maxRectangleArea(int[] xx, int[] yy) {
            int n = xx.length;
            int [][] a = new int [n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = xx[i];
                a[i][1] = yy[i];
            }
            Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); 
        }
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
		Solution s = new Solution ();

        int []  a = new int []  {3, -2};

        long r = s.maxSubarraySum(a, 1);
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