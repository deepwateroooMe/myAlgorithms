// import com.UnionFind;
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

public class mtwoixed {
    public static class Solution {

        // public int superPow(int a, int [] b) {
        //     a %= mod;
        //     int n = b.length, j = n-1;
        //     if (b.length == 1) return quickMul(a, b[0]) % mod;
        //     int [] tmp = new int [n-1];
        //     System.arraycopy(b, 0, tmp, 0, n-1);
        //     return (quickMul(superPow(a, tmp), 10) * quickMul(a, b[j])) % mod;
        // }
        // static final int mod = 1337;
        // int quickMul(int a, int e) {
        //     if (e == 0) return 1;
        //     int ans = 1;
        //     for (int i = 1; i <= e; i++) 
        //         ans = (ans * a) % mod;
        //     return ans;
        // }

        // public int lastRemaining(int n) { // TLE: 应该是不需要这么真正一步一步地去删除的
        //     if (n == 1) return 1;
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 1; i <= n; i++) 
        //         l.add(i);
        //     int cnt = 0;
        //     while (l.size() > 1) {
        //         int len = l.size();
        //         if (cnt % 2 == 0) {
        //             if (len % 2 == 0) {
        //                 for (int i = len-2; i >= 0; i -= 2) 
        //                     l.remove(i);
        //             } else {
        //                 for (int i = len-1; i >= 0; i -= 2) 
        //                     l.remove(i);
        //             }
        //         } else {
        //             for (int i = len-1; i >= 0; i -= 2)
        //                 l.remove(i);
        //         }
        //         cnt++;
        //     }
        //     return l.get(0);
        // }

        // public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) { // 长方形不一定是会正着放的，还可能歪着放。。。。。。求角度
        //     int [][] a = new int [4][];
        //     a[0] = p1;
        //     a[1] = p2;
        //     a[2] = p3;
        //     a[3] = p4;
        // // public boolean validSquare(int[][] a) {
        //     Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     return a[0][0] == a[1][0] && a[2][0] == a[3][0]
        //         && a[0][1] == a[2][1] && a[1][1] == a[3][1]
        //         && a[0][1] != a[1][1] && a[2][0] != a[0][0];
        // }
        // int [][] a = new int [][] {{1,0},
        //                            {-1,0},
        //                            {0,1},
        //                            {0,-1}};

        // public int strongPasswordChecker(String t) { // t: pasword 这写的是梵高文，像天书一样居然看不懂了。。。。。。
        //     char [] s = t.toCharArray();
        //     boolean num = false, lo = false, hi = false; // 是否含有： 数字 小写字母 大写字母
        //     // 记录所需小写字母、大写字母和数字的个数，cnt记录重复序列的字符计数
        //     int i = 0, j = 0, n = t.length(), mdi = 0, cnt [] = new int [] {0, 0, 0}, rpt = 0, need = 0, rmd = 0; // 重复 需求 删除
        //     while (j < n) {
        //         char c = s[j];
        //         if (Character.isLowerCase(c)) lo = true;
        //         else if (Character.isUpperCase(c)) hi = true;
        //         else num = true;
        //         while (j < n && s[j] == c) j++;
        //         rpt = j - i; // local same character repeats
        //         if (rpt > 2) {
        //             mdi += rpt / 3; // 地方重复序列长度 >= 3，每3个相同的字母至少得修改一个
        //             ++cnt[rpt % 3];
        //         }
        //         i = j;
        //     }
        //     need = (num ? 0 : 1) + (lo ? 0 : 1) + (hi ? 0 : 1); // 三种特殊要求
        //     if (n < 6) return Math.max(6-n, need); // 长度不足，则根据是否有重复序列进行替换、加添操作
        //     if (n <= 20) return Math.max(mdi, need);
        //     rmd = n - 20;
        //     n -= 20;
        //     if (rmd < cnt[0]) return Math.max(mdi - rmd, need) + n;
        //     rmd -= cnt[0];
        //     mdi -= cnt[0];
        //     if (rmd < (cnt[1] << 1)) return Math.max(mdi - (rmd >> 1), need) + n;
        //     rmd -= (cnt[1] << 1);
        //     mdi -= cnt[1];
        //     return Math.max(mdi - rmd / 3, need) + n;
        // }
        // public int strongPasswordChecker(String t) { // 这个方法思路清晰一点儿，但是慢一些
        //     int n = t.length();  
        //     char [] s = t.toCharArray();
        //     int low = 1, up = 1, num = 1, cnt = 1;
        //     if (Character.isLowerCase(s[0])) low = 0;
        //     else if (Character.isUpperCase(s[0])) up = 0;
        //     else if (Character.isDigit(s[0])) num = 0;
        //     Queue<Integer> q = new PriorityQueue<>((a, b) -> a % 3 - b % 3); // 优先队列，x % 3 小的先出队，为方便需要删除操作时先处理段的序列
        //     for (int i = 1; i < n; i ++) {
        //         if (low == 1 && Character.isLowerCase(s[i])) low = 0;
        //         else if (up == 1 && Character.isUpperCase(s[i])) up = 0;
        //         else if (num == 1 && Character.isDigit(s[i])) num = 0;
        //         // 对连续相同的序列计数，并存入优先队列
        //         if (s[i] != s[i - 1]) {
        //             if (cnt >= 3) q.add(cnt);
        //             cnt = 1;
        //         } else cnt ++;
        //     }
        //     if (cnt >= 3) q.add(cnt);
        //     int ans = 0, all = low + up + num; // 准备取结果
        //     if (n < 6) return Math.max(6 - n, all); // 长度不足，则根据是否有重复序列进行替换、加添操作
        //     while (!q.isEmpty() && n > 20) {    // 删除操作，从最短的连续序列开始处理
        //         int cur = q.remove();
        //         ans ++;
        //         n --;
        //         if (-- cur >= 3) q.add(cur);
        //     }
        //     if (n > 20) return ans + n - 20 + all; // 解决完重复序列后，字符串仍然过长, 就没有办法只能删除
        //     // 未处理完重复序列就已经达到长度要求，继续处理重复序列： 此时就只考虑替换操作就好了
        //     cnt = 0;
        //     while (!q.isEmpty()) 
        //         cnt += q.remove() / 3;
        //     return ans + Math.max(cnt, all);
        // }

        // public String nearestPalindromic(String s) {
        //     long n = s.length(), v = Long.parseLong(s), ans = 0, minDif = Long.MAX_VALUE;
        //     Set<Long> ss = new HashSet<>();
        //     ss.add((long)Math.pow(10, n) + 1);
        //     ss.add((long)Math.pow(10, n-1) - 1);
        //     long pre = Long.parseLong(s.substring(0, (int)(n+1)/2));
        //     for (long i = -1; i <= 1; i++) { // 最接近原始数值的变化： 发生在字符串或数值最中间的数位，变化范围有限「-1，1」
        //         String preStr = "" + (pre + i); 
        //         String cur = preStr + new StringBuilder(preStr).reverse().toString().substring((int)n & 1); // 区分 n 是奇数还是偶数
        //         ss.add(Long.parseLong(cur));
        //     }
        //     ss.remove(v);
        //     for (long cur : ss) {
        //         long dif = Math.abs(v - cur);
        //         if (dif < minDif) {
        //             minDif = dif;
        //             ans = cur;
        //         } else if (dif == minDif)
        //             ans = Math.min(ans, cur);
        //     }
        //     return String.valueOf(ans);
        // }

        // public String smallestGoodBase(String n) { // 用BigInteger，速度很慢
        //     long v = Long.parseLong(n);
        //     //对所有可能的指数n进行遍历
        //     for (int i = (int)(Math.log(v) / Math.log(2)) + 1; i >= 2; i--) {
        //         long l = 2, r = v, m;
        //         //进行二叉搜索，寻找最小的good base。
        //         while (l <= r) {
        //             m = l + (r - l) / 2;
        //             BigInteger left = BigInteger.valueOf(m); 
        //             left = left.pow(i).subtract(BigInteger.ONE);
        //             BigInteger right = BigInteger.valueOf(v).multiply(BigInteger.valueOf(m).subtract(BigInteger.ONE));
        //             int cmp = left.compareTo(right);
        //             if (cmp == 0) return String.valueOf(m);
        //             else if (cmp < 0) l = m + 1;
        //             else r = m - 1;
        //         }
        //     }
        //     return String.valueOf(v-1);
        // }
        // public String smallestGoodBase(String n) { // binary search 吗
        //     long v = Long.parseLong(n);
        //     for (int i = (int)(Math.log(v+1) / Math.log(2)); i >= 0; i--) { // 想要 k 最小，m 取最大为 log_2(v+1)
        //         long l = 2, r = (long)Math.pow(v, 1.0 / (i-1)) + 1; // + 1： 因为这里有round()，所以要取大一点儿
        //         // long l = 2, r = (long)Math.pow(v, 1.0 / (i-1));  // BUG： 因为这里有round()，所以要取大一点儿
        //         while (l < r) {
        //             long m = l + (r - l) / 2, sum = 0; // m: mid, functioning as base
        //             for (int j = 0; j < i; j++) 
        //                 sum = sum * m + 1;
        //             if (sum == v) return String.valueOf(m);
        //             if (sum < v) l = m + 1;
        //             else r = m-1; // -1: 才更高效
        //         }
        //     }
        //     return String.valueOf(v-1);
        // }
        // public String smallestGoodBase(String n) { // 1ms 100% ?
        //     long v = Long.parseLong(n), x = 1;
        //     for (int i = 64; i >= 1; i--) 
        //         if ((x << i) < v) {
        //             long k = helper(v, i);
        //             if (k != -1) return String.valueOf(k);
        //         }
        //     return String.valueOf(v-1);
        // }
        // long helper(long v, int i) {
        //     long l = 1, r = (long)(Math.pow(v, 1.0/i) + 1);
        //     while (l < r) {
        //         long m = l + (r - l) / 2, cur = 1; 
        //         for (int j = 0; j < i; j++)
        //             cur = cur * m + 1;
        //         if (cur == v) return m;
        //         if (cur < v) l = m + 1;
        //         else r = m - 1;
        //     }
        //     return -1;
        // }

    // Node [] left, right;
    // int min = -1, max = 20007, N = 16;
    // Node head;
    // public Skiplist() {
    //     left = new Node [16];
    //     right = new Node [16];
    //     for (int i = 0; i < N; i++) {
    //         // left[i].v = min; // BUG: 这第一个node不是还没有initialized吗？
    //         // right[i].v = max;// BUG:
    //         left[i] = new Node(min);
    //         right[i] = new Node(max);
    //         left[i].rt = right[i];
    //     }
    //     for (int i = 0; i < N-1; i++) {
    //         left[i].dn = left[i+1];
    //         right[i].dn = right[i+1];
    //     }            
    //     head = left[0];
    // }
    // public boolean search(int target) {
    //     Node r = head;
    //     // while (r.dn != null) { // BUG: 这里现在有点儿想不清楚了。。。。。。
    //     while (r != null) {
    //         while (r.rt.v < target) r = r.rt;
    //         if (r.rt.v == target) return true;
    //         else r = r.dn;
    //     }
    //     return false;
    // }
    // public void add(int num) { // 会加上重复的（Skiplist里面已经存在的）值吗？
    //     Node r = head, pre = null;
    //     ArrayDeque<Node> s = new ArrayDeque<>(); // visited path looking for r.v == num
    //     // 寻找正确的插入位置 [r, r.rt]
    //     while (r != null) {
    //         // while (r.rt.v < num) r = r.rt; // 向右步移
    //         if (r.rt.v >= num) {
    //             s.offerLast(r);
    //             // if (r.rt.v == num)
    //             r = r.dn; // 往下走
    //                 // return; // BUG: 有重复也是要再加进去的
    //         } else r = r.rt;
    //     }
    //     while (!s.isEmpty()) {
    //          r = s.pollLast();
    //         Node cur = new Node(num);
    //         cur.rt = r.rt;
    //         r.rt = cur;
    //         if (pre != null) cur.dn = pre;
    //         pre = cur;
    //         if (Math.random() < 0.5) break;
    //     }
    // }
    // public boolean erase(int num) {
    //     Node r = head;
    //     boolean ans = false;
    //     while (r != null) {
    //         while (r.rt.v < num) r = r.rt;
    //         if (r.rt.v == num) {
    //             ans = true;
    //             r.rt = r.rt.rt; 
    //             // return true; // BUG: 这里只删除了这一层的，不是没有删除彻底吗？
    //         }
    //         r = r.dn;
    //     }
    //     return ans;
    // }
    // static class Node {
    //     int v;
    //     Node rt, dn; // right, down
    //     public Node(int val) {
    //         v = val;
    //     }
    // }

        // static final int mod = 1337;
        // public int largestPalindrome(int n) {
        //     if (n == 1) return 9;
        //     int l = (int)Math.pow(10, n-1), r = (int)Math.pow(10, n)-1;
        //     for (int i = r; i >= l; i--) {
        //         long cur = generatePalindrome(i);
        //         for (long j = r; j * j >= cur; j--) {
        //             if (cur % j == 0)
        //                 return (int)(cur % mod);
        //         }
        //     }
        //     return -1;
        // }
        // long generatePalindrome(int v) {
        //     String s = "" + v, t = new StringBuilder(s).reverse().toString();
        //     return Long.parseLong(s + t);
        // }

    // int [] ori; // BUG: some problem , half done
    // public Solution(int[] a) {
    // public mtwoixed(int[] a) {
    //     ori = new int [a.length];
    //     System.arraycopy(a, 0, ori, 0, a.length);
    // }
    // public int[] reset() {
    //     return ori;
    // }
    // public int[] shuffle() {
    //     int [] a = new int [ori.length];
    //     shuffle(a, 0, new boolean [ori.length], ori);
    //     return a;
    // }
    // void shuffle(int [] a, int idx, boolean [] vis, int [] o) {
    //     if (idx == o.length) return ;
    //     for (int i = 0; i < o.length; i++) {
    //         if (vis[i]) continue;
    //         vis[i] = true;
    //         a[idx] = o[i];
    //         shuffle(a, idx+1, vis, o);
    //         vis[i] = false;
    //     }
    // }

        // public boolean checkPerfectNumber(int v) { // tle
        //     long sum = 0;
        //     for (int i = 1; i <= v/2; i++) 
        //         if (v % i == 0)
        //             sum += i;
        //     return (int)sum == v;
        // }

        // public int[][] matrixReshape(int[][] a, int r, int c) { // BUG: 题目理解错了。。。
        //     int m = a.length, n = a[0].length, idx = 0;
        //     // if (r < m || c < n || r == m && c == n) return a;
        //     if (r * c < m * n || r == m && c == n) return a;
        //     int [] b = new int [m * n];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             b[idx++] = a[i][j];
        //     System.out.println(Arrays.toString(b));
        //     if (r == 1) {
        //         int [][] ans = new int [1][];
        //         ans[0] = b;
        //         return ans;
        //      }
        //     // idx = 0;
        //     // int [][] ans = new int [r][c];
        //     // for (int i = 0; i < r && idx < m * n; i++) 
        //     //     for (int j = 0; j < c && idx < m * n; j++) 
        //     //         ans[i][j] = b[idx++];
        //     // System.out.println("ans.length: " + ans.length);
        //     // for (int z = 0; z < ans.length; ++z) 
        //     //     System.out.println(Arrays.toString(ans[z]));
        //     return a;
        // }

        // public boolean validSquare(int[] a, int[] b, int[] c, int[] d) {
        //     List<int []> ps = new ArrayList<>();
        //     ps.add(a);
        //     ps.add(b);
        //     ps.add(c);
        //     ps.add(d);
        //     TreeSet<Integer> di= new TreeSet<>();
        //     for (int [] va : ps) {
        //         di.clear();
        //         for (int [] vb : ps) {
        //             if (va == vb) continue;
        //             di.add(getDistPowTwo(va, vb));
        //         }
        //         if (di.size() != 2) return false;
        //         if (di.last() != di.first() * 2) return false;
        //     }
        //     return true;
        // }
        // int getDistPowTwo(int [] a, int [] b) {
        //     return (int)(Math.pow(a[0]-b[0], 2) + Math.pow(a[1] - b[1], 2));
        // }

        // public int lastRemaining(int n) {
        //     int fst = 1, dif = 1; // 第一个元素、相邻两个数与数之间的差值
        //     boolean left = true;  // 不是否从左侧开始删起
        //     while (n > 1) {
        //         if (left || n % 2 == 1)
        //             fst += dif;
        //         n /= 2;
        //         dif *= 2;
        //         left = !left;
        //     }
        //     return fst;
        // }

        // public int[] findDiagonalOrder(int[][] a) { // BUG: half done
        //     int m = a.length, n = a[0].length;
        //     if (m == 1) return a[0];
        //     int [] ans = new int [m * n];
        //     if (n == 1) {
        //         int idx = 0;
        //         for (int i = 0; i < m; i++) 
        //             ans[idx++] = a[i][0];
        //         return ans;
        //     }
        // }

        // public boolean checkPossibility(int[] a) { // BUG: 301/335 PASSED
        //     int n = a.length;
        //     if (n == 1) return true;
        //     boolean vis = false;
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     for (int i = 0; i < n-1; i++) {
        //         // System.out.println("\n i: " + i);
        //         if (a[i] > a[i+1]) {
        //             if (vis) return false;
        //             if (!s.isEmpty()) {
        //                 int top = s.peekLast();
        //                 if (a[i+1] < top) s.offerLast(a[i]);
        //                 else s.offerLast(a[i+1]);
        //             } else s.offerLast(a[i+1]);
        //             i++;
        //             vis = true;
        //         } else s.offerLast(a[i]);
        //     }
        //     // System.out.println("s.size(): " + s.size());
        //     // System.out.println(Arrays.toString(new ArrayList<>(s).toArray()));
        //     System.out.println("vis: " + vis);
        //     if (!s.isEmpty() && a[n-1] < s.peekLast() && vis) return false;
        //     return true;
        // }
        // int [] a = new int [] {3, 4, 2, 3};
        // // int [] a = new int [] {1, 2, 4, 5, 3};

        // public int partitionDisjoint(int[] a) {
        //     int n = a.length;
        //     int [] min = new int [n+1], max = new int [n+1];
        //     min[n] = Integer.MAX_VALUE;
        //     for (int i = n-1; i >= 0; i--) 
        //         min[i] = Math.min(a[i], min[i+1]);
        //     max[0] = -1;
        //     for (int i = 0; i < n; i++) {
        //         max[i+1] = Math.max(max[i], a[i]);
        //         if (min[i+1] >= max[i+1]) return i+1;
        //     }
        //     return -1;
        // }

        // public boolean canReorderDoubled(int[] a) { // BUG: 想的是使用滚动map，但这里还有一点儿什么没有想通
        //     int n = a.length;
        //     if (n % 2 == 1) return false;
        //     // List<Integer> l = new ArrayList<>();
        //     TreeMap<Integer, Integer> m = new TreeMap<>(); // 用一个treemap从小到大遍历一遍应该是可以的。。。改天再写这个题吧
        //     for (int v : a) {
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //         // l.add(v);
        //     }
        //     TreeMap<Integer, Integer> tmp = new TreeMap<>(m);
        //     // Collections.sort(l, (x, y) -> Math.abs(x) != Math.abs(y) ? Math.abs(x) - Math.abs(y) : x - y);
        //     Iterator<Map.Entry<Integer, Integer>> it = m.entrySet().iterator();
        //     while (m.size() > 0) {
        //         Map.Entry<Integer, Integer> en = it.next();
        //         int k = en.getKey(), v = en.getValue();
        //         if (!tmp.containsKey(k) || k != 0 && !m.containsKey(2 * k)) return false;
        //         tmp.put(k, tmp.get(k) - 1);
        //         if (tmp.get(k) == 0) tmp.remove(k);
        //         tmp.put(2*k, tmp.get(2*k) - 1);
        //         if (tmp.get(2*k) == 0) tmp.remove(2*k);
        //     }
        //     return true;
        // }

        // public int[] sumEvenAfterQueries(int[] a, int[][] q) {
        //     int n = a.length, idx = 0, sum = 0, pre = 0;
        //     for (int v : a) 
        //         if (v % 2 == 0) sum += v;
        //     int [] ans = new int [q.length];
        //     for (int i = 0; i < q.length; i++) {
        //         idx = q[i][1];
        //         pre = a[idx];
        //         a[idx] += q[i][0];
        //         if (a[idx] % 2 == 0) sum += pre % 2 == 0 ? a[idx] - pre : a[idx];
        //         else sum -= pre % 2 == 0 ? pre : 0;
        //         ans[i] = sum;
        //     }
        //     return ans;
        // }
 
        // public int maxAbsValExpr(int[] a, int[] b) { // tle tle 
        //     int n = a.length, ans = 0;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             int ii = Math.abs(a[i] - a[j]), jj = Math.abs(b[i] - b[j]);
        //             int c = ii + jj, d = ii - jj;
        //             int x = -ii + jj, y = -ii - jj;
        //             c = Math.max(c, d);
        //             x = Math.max(x, y);
        //             ans = Math.max(ans, Math.max(c, x) + j - i);
        //         }
        //     }
        //     return ans;
        // }

        // public ListNode removeZeroSumSublists(ListNode head) { // half done
        //     int n = 0, idx = 0;
        //     ListNode r = head;
        //     while (r != null) {
        //         n++;
        //         r = r.next;
        //     }
        //     System.out.println("n: " + n);
        //     int [] a = new int [n];
        //     r = head;
        //     while (r != null) {
        //         a[idx++] = r.val;
        //         r = r.next;
        //     }
        // }
        // int [] removeZeroSums(int [] a) {
        //     int n = a.length, sum = 0, j = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     m.put(0, -1); //
        //     for (int i = 0; i < n; i++) {
        //         sum += a[i];
        //         if (sum == 0 || m.containsKey(sum)) { // 这里把那个片段擦除
        //         }
        //     }
        // }

        // public int superEggDrop(int k, int n) { // TLE: O(KN^2) 还需要优化一下
        //     if (k < 1 || n < 1) return 0;
        //     int [] pre = new int [n+1], cur = new int [n+1]; // 上一层和当前层的备忘录
        //     for (int i = 1; i <= n; i++) 
        //         cur[i] = i; // 初始化成最大的尝试次数
        //     for (int i = 2; i <= k; i++) {
        //         pre = cur.clone();
        //         for (int j = 1; j <= n; j++) cur[j] = j;
        //         for (int j = 1; j <= n; j++) // 这里可能还需要更优的时间复杂度
        //             for (int x = 1; x < j; x++) 
        //                 cur[j] = Math.min(cur[j], 1 + Math.max(pre[x-1], cur[j-x]));
        //     }
        //     return cur[n];
        // }
        // public int superEggDrop(int k, int n) { // O(KNlgN)
        //     int [][] dp = new int [k+1][n+1];
        //     for (int i = 1; i <= n; i++) dp[1][i] = i; // 把只有一个鸡蛋的情况初始化为最大值
        //     for (int i = 2; i <= k; i++) {
        //         for (int j = 1; j <= n; j++) {
        //             dp[i][j] = j;
        //             int l = 1, r = j, m = 0;
        //             while (l < r) {
        //                 m = (l + r) / 2;
        //                 if (dp[i-1][m-1] < dp[i][j-m]) l = m + 1; // < 左边随m递增，< 右边随m递减，这个性质在这里很重要，所以可以二分查找
        //                 else r = m;
        //             } // 这里查找的右边界也注意一下
        //             dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][r-1], dp[i][j-r]) + 1); // 用这个鸡蛋测试了一次了
        //         }
        //     }
        //     return dp[k][n];
        // }
        // public int superEggDrop(int k, int n) { // O(KN)
        //     int [][] dp = new int [k+1][n+1];
        //     for (int i = 1; i <= n; i++) dp[1][i] = i; // 把只有一个鸡蛋的情况初始化为最大值
        //     for (int i = 2; i <= k; i++) {
        //         int s = 1; // k
        //         for (int j = 1; j <= n; j++) { // n
        //             dp[i][j] = j;
        //             while (s < j && dp[i-1][s-1] < dp[i][j-s]) s++; // 因为单调性，s一直向右滑动，总共执行n次
        //             dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][s-1], dp[i][j-s]) + 1);
        //         }
        //     }
        //     return dp[k][n];
        // }
        // public int superEggDrop(int k, int n) { // O(KlgN): 为什么说这里就是 O(klgN)呢？因为dp[m][k]的增长呈指数级的？
        //     int [][] dp = new int [n+1][k+1]; // 在第 i 次移动且使用第 j 个鸡蛋测试第 dp[i-1][j-1]+1 层
        //     int m = 0; // 最小测试次数
        //     while (dp[m][k] < n) { // 当dp[m][k] == n，退出循环的时候，m就是要求的最小操作次数了
        //         ++m;
        //         for (int j = 1; j <= k; j++) 
        //             dp[m][j] = dp[m-1][j-1] + dp[m-1][j] + 1; // 分上一次测的 第j-1个鸡蛋 碎了 和 没有碎 两种情况来更新当前值
        //     }
        //     return m;
        // }
        // public int superEggDrop(int k, int n) { // O(KlgN): 空间压缩
        //     int [] dp = new int [k+1]; // dp[i] 表示当前次数下使用 i 个鸡蛋可以测出的最高楼层
        //     int ans = 0;
        //     for (; dp[k] < n; ans++) // 压缩代码到一行
        //         for (int i = k; i >= 1; i--) // 压缩空间后，因为是想要根据上一行[ans-1]时的i-1/i来更新当前结果，需要倒序遍历以免产生脏数据
        //             dp[i] = dp[i] + dp[i-1] + 1;
        //     return ans;
        // }
        // public int superEggDrop(int k, int n) { // O(KlgN)：数学推导找出了推理公式，速度最快
        //     int l = 1, r = n;
        //     while (l < r) { // 寻找右边界
        //         int m = l + (r - l) / 2;
        //         if (helper(m, k, n) < n) l = m + 1;
        //         else r = m;
        //     }
        //     return r;
        // }
        // int helper(int m, int k, int n) { // 能查找到的最大楼层数
        //     int ans = 0, r = 1;
        //     for (int i = 1; i <= k; i++) {
        //         r *= m - i + 1;
        //         r /= i;
        //         ans += r;
        //         if (ans >= n) break;
        //     }
        //     return ans;
        // }

        // public long minimumDifference(int[] a) {
        //     int m = a.length, n = m / 3, idx = 0;
        //     long sum = 0, ans = Long.MAX_VALUE;
        //     long [] pre = new long [n+1], suf = new long [n+1];
        //     Queue<Integer> min = new PriorityQueue<>((x, y)->y-x);
        //     for (int i = 0; i < n; i++) {
        //         min.offer(a[i]);
        //         sum += a[i];
        //     }
        //     pre[idx++] = sum;
        //     for (int i = n; i < 2 * n; i++) {
        //         if (a[i] < min.peek()) {
        //             sum -= min.poll();
        //             min.offer(a[i]);
        //             sum += a[i];
        //         }
        //         pre[idx++] = sum;
        //     }
        //     idx = n;
        //     sum = 0;
        //     Queue<Integer> max = new PriorityQueue<>();
        //     for (int i = m-1; i > m-1-n; i--) {
        //         sum += a[i];
        //         max.offer(a[i]);
        //     }
        //     suf[idx--] = sum;
        //     for (int i = m-1-n; i >= n; i--) {
        //         if (a[i] >= max.peek()) {
        //             sum -= max.poll();
        //             max.offer(a[i]);
        //             sum += a[i];
        //         }
        //         suf[idx--] = sum;
        //     }
        //     for (int i = 0; i <= n; i++) {
        //         long dif = pre[i] - suf[i];
        //         ans = Math.min(ans, dif);
        //     }
        //     return ans;
        // }

        // public String abbreviateProduct(int left, int right) {
        //     long suf = 1;       // 末五位
        //     int zoo = 0, orgDigits = 0;
        //     double prod =  1.0; // 首五位
        //     for (int n = left; n <= right; n++) {
        //         prod *= n;
        //         while (prod >= 1.0) {
        //             prod /= 10.0;
        //             orgDigits++;
        //         }
        //         suf *= n;
        //         while (suf % 10 == 0) {
        //             zoo ++;
        //             suf /= 10;
        //         }
        //         // 有种特殊情况就是：尾数的最后既没有0，也超过了14位，那么对它取模化小
        //         if (suf > Math.pow(10, 14)) suf %= (long)Math.pow(10, 14);
        //     }
        //     if (orgDigits - zoo <= 10)
        //         // String r = s.abbreviateProduct(621, 625);
        //         // return (long)(prod * Math.pow(10, orgDigits - zoo)) + "e" + zoo; // 290/291 passed
        //         return (long)(prod * Math.pow(10, orgDigits - zoo) + 0.5) + "e" + zoo;
        //     else {
        //         // you may find that I add 0.5 before cast to int above, but not here.
        //         // It is because when org_digits - zeros <= 10, int(prod * (10 ** (org_digits - zeros)) + 0.5) is the actual
        //         // value, we add 0.5 to the last non-zero digits for rounding, 0.5 just means 0.5 over there.
        //         // However here int(prod * 100000) is the first 5-digit prefix, the 6-th digit is also a valid digit not
        //         // error.If we add 0.5 to 6-th digit, how do we calculate the first 6-digit or 7-digit prefix?
        //         String sufStr = "0000" + Long.toString(suf);
        //         return (int)(prod * 100000) + "..." + sufStr.substring(sufStr.length() - 5) + "e" + zoo;
        //     }
        // }

    // Map<Integer, Integer> m;
    // final int a = 1001; // i * a + j
    // public DetectSquares() { // on the way to be fixed
    // // public mtwoixed() { 
    //     m = new HashMap<>();
    // }
    // public void add(int[] p) {
    //     int v = p[0] * a + p[1];
    //     m.put(v, m.getOrDefault(v, 0) + 1);
    // }
    // public int count(int[] p) {
    //     int ans = 0, tmp = 0;
    //     for (Integer key : m.keySet()) {
    //         int i = key / a, j = key % a;
    //         if (j == p[1]) {
    //             if (i == p[0]) continue;
    //             if (i > p[0]) {
    //                 ans += m.get(key) * m.getOrDefault(p[0]*a + j + i-p[0], 0) * m.getOrDefault(i*a + j+i-p[0], 0);
    //             } else 
    //                 ans += m.get(key) * m.getOrDefault(p[0]*a + j + p[0]-i, 0) * m.getOrDefault(i*a + j+p[0]-i, 0);
    //         }
    //     }
    //     return ans;
    // }


    }
    public static void main (String[] args) {
        // Solution s  =  new Solution ();

        mtwoixed s = new mtwoixed();
        s.add([3, 10]);
        s.add([11, 2]);
        s.add([3, 2]);
        int r = s.count([11, 10]); // return 1. You can choose:
        System.out.println("r: " + r);
        
        //   - The first, second, and third points
        int r1 = s.count([14, 8]);  // return 0. The query point cannot form a square with any points in the data structure.
        System.out.println("r1: " + r1);

        s.add([11, 2]);    // Adding duplicate points is allowed.

        int r2 = s.count([11, 10]); // return 2. You can choose:
        System.out.println("r2: " + r2);
        //   - The first, second, and third points
        //   - The first, third, and fourth points
        
        // String r = s.abbreviateProduct(621, 625);
        // System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
