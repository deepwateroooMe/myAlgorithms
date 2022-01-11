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

    }
    public static void main (String[] args) {
        Solution s  =  new Solution ();

        String a = "4681";

        String r = s.smallestGoodBase(a); 
        System.out.println("r: " + r);
    }
}
