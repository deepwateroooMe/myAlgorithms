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

        public int superPow(int a, int [] b) {
            a %= mod;
            int n = b.length, j = n-1;
            if (b.length == 1) return quickMul(a, b[0]) % mod;
            int [] tmp = new int [n-1];
            System.arraycopy(b, 0, tmp, 0, n-1);
            return (quickMul(superPow(a, tmp), 10) * quickMul(a, b[j])) % mod;
        }
        static final int mod = 1337;
        int quickMul(int a, int e) {
            if (e == 0) return 1;
            int ans = 1;
            for (int i = 1; i <= e; i++) 
                ans = (ans * a) % mod;
            return ans;
        }

        public int lastRemaining(int n) { // TLE: 应该是不需要这么真正一步一步地去删除的
            if (n == 1) return 1;
            List<Integer> l = new ArrayList<>();
            for (int i = 1; i <= n; i++) 
                l.add(i);
            int cnt = 0;
            while (l.size() > 1) {
                int len = l.size();
                if (cnt % 2 == 0) {
                    if (len % 2 == 0) {
                        for (int i = len-2; i >= 0; i -= 2) 
                            l.remove(i);
                    } else {
                        for (int i = len-1; i >= 0; i -= 2) 
                            l.remove(i);
                    }
                } else {
                    for (int i = len-1; i >= 0; i -= 2)
                        l.remove(i);
                }
                cnt++;
            }
            return l.get(0);
        }

        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) { // 长方形不一定是会正着放的，还可能歪着放。。。。。。求角度
            int [][] a = new int [4][];
            a[0] = p1;
            a[1] = p2;
            a[2] = p3;
            a[3] = p4;
        // public boolean validSquare(int[][] a) {
            Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            return a[0][0] == a[1][0] && a[2][0] == a[3][0]
                && a[0][1] == a[2][1] && a[1][1] == a[3][1]
                && a[0][1] != a[1][1] && a[2][0] != a[0][0];
        }
        int [][] a = new int [][] {{1,0},
                                   {-1,0},
                                   {0,1},
                                   {0,-1}};

        public int strongPasswordChecker(String t) { // t: pasword 这写的是梵高文，像天书一样居然看不懂了。。。。。。
            char [] s = t.toCharArray();
            boolean num = false, lo = false, hi = false; // 是否含有： 数字 小写字母 大写字母
            // 记录所需小写字母、大写字母和数字的个数，cnt记录重复序列的字符计数
            int i = 0, j = 0, n = t.length(), mdi = 0, cnt [] = new int [] {0, 0, 0}, rpt = 0, need = 0, rmd = 0; // 重复 需求 删除
            while (j < n) {
                char c = s[j];
                if (Character.isLowerCase(c)) lo = true;
                else if (Character.isUpperCase(c)) hi = true;
                else num = true;
                while (j < n && s[j] == c) j++;
                rpt = j - i; // local same character repeats
                if (rpt > 2) {
                    mdi += rpt / 3; // 地方重复序列长度 >= 3，每3个相同的字母至少得修改一个
                    ++cnt[rpt % 3];
                }
                i = j;
            }
            need = (num ? 0 : 1) + (lo ? 0 : 1) + (hi ? 0 : 1); // 三种特殊要求
            if (n < 6) return Math.max(6-n, need); // 长度不足，则根据是否有重复序列进行替换、加添操作
            if (n <= 20) return Math.max(mdi, need);
            rmd = n - 20;
            n -= 20;
            if (rmd < cnt[0]) return Math.max(mdi - rmd, need) + n;
            rmd -= cnt[0];
            mdi -= cnt[0];
            if (rmd < (cnt[1] << 1)) return Math.max(mdi - (rmd >> 1), need) + n;
            rmd -= (cnt[1] << 1);
            mdi -= cnt[1];
            return Math.max(mdi - rmd / 3, need) + n;
        }
        public int strongPasswordChecker(String t) { // 这个方法思路清晰一点儿，但是慢一些
            int n = t.length();  
            char [] s = t.toCharArray();
            int low = 1, up = 1, num = 1, cnt = 1;
            if (Character.isLowerCase(s[0])) low = 0;
            else if (Character.isUpperCase(s[0])) up = 0;
            else if (Character.isDigit(s[0])) num = 0;
            Queue<Integer> q = new PriorityQueue<>((a, b) -> a % 3 - b % 3); // 优先队列，x % 3 小的先出队，为方便需要删除操作时先处理段的序列
            for (int i = 1; i < n; i ++) {
                if (low == 1 && Character.isLowerCase(s[i])) low = 0;
                else if (up == 1 && Character.isUpperCase(s[i])) up = 0;
                else if (num == 1 && Character.isDigit(s[i])) num = 0;
                // 对连续相同的序列计数，并存入优先队列
                if (s[i] != s[i - 1]) {
                    if (cnt >= 3) q.add(cnt);
                    cnt = 1;
                } else cnt ++;
            }
            if (cnt >= 3) q.add(cnt);
            int ans = 0, all = low + up + num; // 准备取结果
            if (n < 6) return Math.max(6 - n, all); // 长度不足，则根据是否有重复序列进行替换、加添操作
            while (!q.isEmpty() && n > 20) {    // 删除操作，从最短的连续序列开始处理
                int cur = q.remove();
                ans ++;
                n --;
                if (-- cur >= 3) q.add(cur);
            }
            if (n > 20) return ans + n - 20 + all; // 解决完重复序列后，字符串仍然过长, 就没有办法只能删除
            // 未处理完重复序列就已经达到长度要求，继续处理重复序列： 此时就只考虑替换操作就好了
            cnt = 0;
            while (!q.isEmpty()) 
                cnt += q.remove() / 3;
            return ans + Math.max(cnt, all);
        }

        public String nearestPalindromic(String s) {
            long n = s.length(), v = Long.parseLong(s), ans = 0, minDif = Long.MAX_VALUE;
            Set<Long> ss = new HashSet<>();
            ss.add((long)Math.pow(10, n) + 1);
            ss.add((long)Math.pow(10, n-1) - 1);
            long pre = Long.parseLong(s.substring(0, (int)(n+1)/2));
            for (long i = -1; i <= 1; i++) { // 最接近原始数值的变化： 发生在字符串或数值最中间的数位，变化范围有限「-1，1」
                String preStr = "" + (pre + i); 
                String cur = preStr + new StringBuilder(preStr).reverse().toString().substring((int)n & 1); // 区分 n 是奇数还是偶数
                ss.add(Long.parseLong(cur));
            }
            ss.remove(v);
            for (long cur : ss) {
                long dif = Math.abs(v - cur);
                if (dif < minDif) {
                    minDif = dif;
                    ans = cur;
                } else if (dif == minDif)
                    ans = Math.min(ans, cur);
            }
            return String.valueOf(ans);
        }

        public String smallestGoodBase(String n) { // 用BigInteger，速度很慢
            long v = Long.parseLong(n);
            //对所有可能的指数n进行遍历
            for (int i = (int)(Math.log(v) / Math.log(2)) + 1; i >= 2; i--) {
                long l = 2, r = v, m;
                //进行二叉搜索，寻找最小的good base。
                while (l <= r) {
                    m = l + (r - l) / 2;
                    BigInteger left = BigInteger.valueOf(m); 
                    left = left.pow(i).subtract(BigInteger.ONE);
                    BigInteger right = BigInteger.valueOf(v).multiply(BigInteger.valueOf(m).subtract(BigInteger.ONE));
                    int cmp = left.compareTo(right);
                    if (cmp == 0) return String.valueOf(m);
                    else if (cmp < 0) l = m + 1;
                    else r = m - 1;
                }
            }
            return String.valueOf(v-1);
        }
        public String smallestGoodBase(String n) { // binary search 吗
            long v = Long.parseLong(n);
            for (int i = (int)(Math.log(v+1) / Math.log(2)); i >= 0; i--) { // 想要 k 最小，m 取最大为 log_2(v+1)
                long l = 2, r = (long)Math.pow(v, 1.0 / (i-1)) + 1; // + 1： 因为这里有round()，所以要取大一点儿
                // long l = 2, r = (long)Math.pow(v, 1.0 / (i-1));  // BUG： 因为这里有round()，所以要取大一点儿
                while (l < r) {
                    long m = l + (r - l) / 2, sum = 0; // m: mid, functioning as base
                    for (int j = 0; j < i; j++) 
                        sum = sum * m + 1;
                    if (sum == v) return String.valueOf(m);
                    if (sum < v) l = m + 1;
                    else r = m-1; // -1: 才更高效
                }
            }
            return String.valueOf(v-1);
        }
        public String smallestGoodBase(String n) { // 1ms 100% ?
            long v = Long.parseLong(n), x = 1;
            for (int i = 64; i >= 1; i--) 
                if ((x << i) < v) {
                    long k = helper(v, i);
                    if (k != -1) return String.valueOf(k);
                }
            return String.valueOf(v-1);
        }
        long helper(long v, int i) {
            long l = 1, r = (long)(Math.pow(v, 1.0/i) + 1);
            while (l < r) {
                long m = l + (r - l) / 2, cur = 1; 
                for (int j = 0; j < i; j++)
                    cur = cur * m + 1;
                if (cur == v) return m;
                if (cur < v) l = m + 1;
                else r = m - 1;
            }
            return -1;
        }

    Node [] left, right;
    int min = -1, max = 20007, N = 16;
    Node head;
    public Skiplist() {
        left = new Node [16];
        right = new Node [16];
        for (int i = 0; i < N; i++) {
            // left[i].v = min; // BUG: 这第一个node不是还没有initialized吗？
            // right[i].v = max;// BUG:
            left[i] = new Node(min);
            right[i] = new Node(max);
            left[i].rt = right[i];
        }
        for (int i = 0; i < N-1; i++) {
            left[i].dn = left[i+1];
            right[i].dn = right[i+1];
        }            
        head = left[0];
    }
    public boolean search(int target) {
        Node r = head;
        // while (r.dn != null) { // BUG: 这里现在有点儿想不清楚了。。。。。。
        while (r != null) {
            while (r.rt.v < target) r = r.rt;
            if (r.rt.v == target) return true;
            else r = r.dn;
        }
        return false;
    }
    public void add(int num) { // 会加上重复的（Skiplist里面已经存在的）值吗？
        Node r = head, pre = null;
        ArrayDeque<Node> s = new ArrayDeque<>(); // visited path looking for r.v == num
        // 寻找正确的插入位置 [r, r.rt]
        while (r != null) {
            // while (r.rt.v < num) r = r.rt; // 向右步移
            if (r.rt.v >= num) {
                s.offerLast(r);
                // if (r.rt.v == num)
                r = r.dn; // 往下走
                    // return; // BUG: 有重复也是要再加进去的
            } else r = r.rt;
        }
        while (!s.isEmpty()) {
             r = s.pollLast();
            Node cur = new Node(num);
            cur.rt = r.rt;
            r.rt = cur;
            if (pre != null) cur.dn = pre;
            pre = cur;
            if (Math.random() < 0.5) break;
        }
    }
    public boolean erase(int num) {
        Node r = head;
        boolean ans = false;
        while (r != null) {
            while (r.rt.v < num) r = r.rt;
            if (r.rt.v == num) {
                ans = true;
                r.rt = r.rt.rt; 
                // return true; // BUG: 这里只删除了这一层的，不是没有删除彻底吗？
            }
            r = r.dn;
        }
        return ans;
    }
    static class Node {
        int v;
        Node rt, dn; // right, down
        public Node(int val) {
            v = val;
        }
    }

        static final int mod = 1337;
        public int largestPalindrome(int n) {
            if (n == 1) return 9;
            int l = (int)Math.pow(10, n-1), r = (int)Math.pow(10, n)-1;
            for (int i = r; i >= l; i--) {
                long cur = generatePalindrome(i);
                for (long j = r; j * j >= cur; j--) {
                    if (cur % j == 0)
                        return (int)(cur % mod);
                }
            }
            return -1;
        }
        long generatePalindrome(int v) {
            String s = "" + v, t = new StringBuilder(s).reverse().toString();
            return Long.parseLong(s + t);
        }

    int [] ori; // BUG: some problem , half done
    public Solution(int[] a) {
    public mtwoixed(int[] a) {
        ori = new int [a.length];
        System.arraycopy(a, 0, ori, 0, a.length);
    }
    public int[] reset() {
        return ori;
    }
    public int[] shuffle() {
        int [] a = new int [ori.length];
        shuffle(a, 0, new boolean [ori.length], ori);
        return a;
    }
    void shuffle(int [] a, int idx, boolean [] vis, int [] o) {
        if (idx == o.length) return ;
        for (int i = 0; i < o.length; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            a[idx] = o[i];
            shuffle(a, idx+1, vis, o);
            vis[i] = false;
        }
    }

        public boolean checkPerfectNumber(int v) { // tle
            long sum = 0;
            for (int i = 1; i <= v/2; i++) 
                if (v % i == 0)
                    sum += i;
            return (int)sum == v;
        }

        public int[][] matrixReshape(int[][] a, int r, int c) { // BUG: 题目理解错了。。。
            int m = a.length, n = a[0].length, idx = 0;
            // if (r < m || c < n || r == m && c == n) return a;
            if (r * c < m * n || r == m && c == n) return a;
            int [] b = new int [m * n];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    b[idx++] = a[i][j];
            System.out.println(Arrays.toString(b));
            if (r == 1) {
                int [][] ans = new int [1][];
                ans[0] = b;
                return ans;
             }
            // idx = 0;
            // int [][] ans = new int [r][c];
            // for (int i = 0; i < r && idx < m * n; i++) 
            //     for (int j = 0; j < c && idx < m * n; j++) 
            //         ans[i][j] = b[idx++];
            // System.out.println("ans.length: " + ans.length);
            // for (int z = 0; z < ans.length; ++z) 
            //     System.out.println(Arrays.toString(ans[z]));
            return a;
        }

        public boolean validSquare(int[] a, int[] b, int[] c, int[] d) {
            List<int []> ps = new ArrayList<>();
            ps.add(a);
            ps.add(b);
            ps.add(c);
            ps.add(d);
            TreeSet<Integer> di= new TreeSet<>();
            for (int [] va : ps) {
                di.clear();
                for (int [] vb : ps) {
                    if (va == vb) continue;
                    di.add(getDistPowTwo(va, vb));
                }
                if (di.size() != 2) return false;
                if (di.last() != di.first() * 2) return false;
            }
            return true;
        }
        int getDistPowTwo(int [] a, int [] b) {
            return (int)(Math.pow(a[0]-b[0], 2) + Math.pow(a[1] - b[1], 2));
        }

        public int lastRemaining(int n) {
            int fst = 1, dif = 1; // 第一个元素、相邻两个数与数之间的差值
            boolean left = true;  // 不是否从左侧开始删起
            while (n > 1) {
                if (left || n % 2 == 1)
                    fst += dif;
                n /= 2;
                dif *= 2;
                left = !left;
            }
            return fst;
        }

        public int[] findDiagonalOrder(int[][] a) { // BUG: half done
            int m = a.length, n = a[0].length;
            if (m == 1) return a[0];
            int [] ans = new int [m * n];
            if (n == 1) {
                int idx = 0;
                for (int i = 0; i < m; i++) 
                    ans[idx++] = a[i][0];
                return ans;
            }
        }

        public boolean checkPossibility(int[] a) { // BUG: 301/335 PASSED
            int n = a.length;
            if (n == 1) return true;
            boolean vis = false;
            ArrayDeque<Integer> s = new ArrayDeque<>();
            for (int i = 0; i < n-1; i++) {
                // System.out.println("\n i: " + i);
                if (a[i] > a[i+1]) {
                    if (vis) return false;
                    if (!s.isEmpty()) {
                        int top = s.peekLast();
                        if (a[i+1] < top) s.offerLast(a[i]);
                        else s.offerLast(a[i+1]);
                    } else s.offerLast(a[i+1]);
                    i++;
                    vis = true;
                } else s.offerLast(a[i]);
            }
            // System.out.println("s.size(): " + s.size());
            // System.out.println(Arrays.toString(new ArrayList<>(s).toArray()));
            System.out.println("vis: " + vis);
            if (!s.isEmpty() && a[n-1] < s.peekLast() && vis) return false;
            return true;
        }
        int [] a = new int [] {3, 4, 2, 3};
        // int [] a = new int [] {1, 2, 4, 5, 3};

        public int partitionDisjoint(int[] a) {
            int n = a.length;
            int [] min = new int [n+1], max = new int [n+1];
            min[n] = Integer.MAX_VALUE;
            for (int i = n-1; i >= 0; i--) 
                min[i] = Math.min(a[i], min[i+1]);
            max[0] = -1;
            for (int i = 0; i < n; i++) {
                max[i+1] = Math.max(max[i], a[i]);
                if (min[i+1] >= max[i+1]) return i+1;
            }
            return -1;
        }

        public boolean canReorderDoubled(int[] a) { // BUG: 想的是使用滚动map，但这里还有一点儿什么没有想通
            int n = a.length;
            if (n % 2 == 1) return false;
            // List<Integer> l = new ArrayList<>();
            TreeMap<Integer, Integer> m = new TreeMap<>(); // 用一个treemap从小到大遍历一遍应该是可以的。。。改天再写这个题吧
            for (int v : a) {
                m.put(v, m.getOrDefault(v, 0) + 1);
                // l.add(v);
            }
            TreeMap<Integer, Integer> tmp = new TreeMap<>(m);
            // Collections.sort(l, (x, y) -> Math.abs(x) != Math.abs(y) ? Math.abs(x) - Math.abs(y) : x - y);
            Iterator<Map.Entry<Integer, Integer>> it = m.entrySet().iterator();
            while (m.size() > 0) {
                Map.Entry<Integer, Integer> en = it.next();
                int k = en.getKey(), v = en.getValue();
                if (!tmp.containsKey(k) || k != 0 && !m.containsKey(2 * k)) return false;
                tmp.put(k, tmp.get(k) - 1);
                if (tmp.get(k) == 0) tmp.remove(k);
                tmp.put(2*k, tmp.get(2*k) - 1);
                if (tmp.get(2*k) == 0) tmp.remove(2*k);
            }
            return true;
        }

        public int[] sumEvenAfterQueries(int[] a, int[][] q) {
            int n = a.length, idx = 0, sum = 0, pre = 0;
            for (int v : a) 
                if (v % 2 == 0) sum += v;
            int [] ans = new int [q.length];
            for (int i = 0; i < q.length; i++) {
                idx = q[i][1];
                pre = a[idx];
                a[idx] += q[i][0];
                if (a[idx] % 2 == 0) sum += pre % 2 == 0 ? a[idx] - pre : a[idx];
                else sum -= pre % 2 == 0 ? pre : 0;
                ans[i] = sum;
            }
            return ans;
        }
 
        public int maxAbsValExpr(int[] a, int[] b) { // tle tle 
            int n = a.length, ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    int ii = Math.abs(a[i] - a[j]), jj = Math.abs(b[i] - b[j]);
                    int c = ii + jj, d = ii - jj;
                    int x = -ii + jj, y = -ii - jj;
                    c = Math.max(c, d);
                    x = Math.max(x, y);
                    ans = Math.max(ans, Math.max(c, x) + j - i);
                }
            }
            return ans;
        }

        public ListNode removeZeroSumSublists(ListNode head) { // half done
            int n = 0, idx = 0;
            ListNode r = head;
            while (r != null) {
                n++;
                r = r.next;
            }
            System.out.println("n: " + n);
            int [] a = new int [n];
            r = head;
            while (r != null) {
                a[idx++] = r.val;
                r = r.next;
            }
        }
        int [] removeZeroSums(int [] a) {
            int n = a.length, sum = 0, j = 0;
            Map<Integer, Integer> m = new HashMap<>();
            m.put(0, -1); //
            for (int i = 0; i < n; i++) {
                sum += a[i];
                if (sum == 0 || m.containsKey(sum)) { // 这里把那个片段擦除
                }
            }
        }

        public int superEggDrop(int k, int n) { // TLE: O(KN^2) 还需要优化一下
            if (k < 1 || n < 1) return 0;
            int [] pre = new int [n+1], cur = new int [n+1]; // 上一层和当前层的备忘录
            for (int i = 1; i <= n; i++) 
                cur[i] = i; // 初始化成最大的尝试次数
            for (int i = 2; i <= k; i++) {
                pre = cur.clone();
                for (int j = 1; j <= n; j++) cur[j] = j;
                for (int j = 1; j <= n; j++) // 这里可能还需要更优的时间复杂度
                    for (int x = 1; x < j; x++) 
                        cur[j] = Math.min(cur[j], 1 + Math.max(pre[x-1], cur[j-x]));
            }
            return cur[n];
        }
        public int superEggDrop(int k, int n) { // O(KNlgN)
            int [][] dp = new int [k+1][n+1];
            for (int i = 1; i <= n; i++) dp[1][i] = i; // 把只有一个鸡蛋的情况初始化为最大值
            for (int i = 2; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = j;
                    int l = 1, r = j, m = 0;
                    while (l < r) {
                        m = (l + r) / 2;
                        if (dp[i-1][m-1] < dp[i][j-m]) l = m + 1; // < 左边随m递增，< 右边随m递减，这个性质在这里很重要，所以可以二分查找
                        else r = m;
                    } // 这里查找的右边界也注意一下
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][r-1], dp[i][j-r]) + 1); // 用这个鸡蛋测试了一次了
                }
            }
            return dp[k][n];
        }
        public int superEggDrop(int k, int n) { // O(KN)
            int [][] dp = new int [k+1][n+1];
            for (int i = 1; i <= n; i++) dp[1][i] = i; // 把只有一个鸡蛋的情况初始化为最大值
            for (int i = 2; i <= k; i++) {
                int s = 1; // k
                for (int j = 1; j <= n; j++) { // n
                    dp[i][j] = j;
                    while (s < j && dp[i-1][s-1] < dp[i][j-s]) s++; // 因为单调性，s一直向右滑动，总共执行n次
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][s-1], dp[i][j-s]) + 1);
                }
            }
            return dp[k][n];
        }
        public int superEggDrop(int k, int n) { // O(KlgN): 为什么说这里就是 O(klgN)呢？因为dp[m][k]的增长呈指数级的？
            int [][] dp = new int [n+1][k+1]; // 在第 i 次移动且使用第 j 个鸡蛋测试第 dp[i-1][j-1]+1 层
            int m = 0; // 最小测试次数
            while (dp[m][k] < n) { // 当dp[m][k] == n，退出循环的时候，m就是要求的最小操作次数了
                ++m;
                for (int j = 1; j <= k; j++) 
                    dp[m][j] = dp[m-1][j-1] + dp[m-1][j] + 1; // 分上一次测的 第j-1个鸡蛋 碎了 和 没有碎 两种情况来更新当前值
            }
            return m;
        }
        public int superEggDrop(int k, int n) { // O(KlgN): 空间压缩
            int [] dp = new int [k+1]; // dp[i] 表示当前次数下使用 i 个鸡蛋可以测出的最高楼层
            int ans = 0;
            for (; dp[k] < n; ans++) // 压缩代码到一行
                for (int i = k; i >= 1; i--) // 压缩空间后，因为是想要根据上一行[ans-1]时的i-1/i来更新当前结果，需要倒序遍历以免产生脏数据
                    dp[i] = dp[i] + dp[i-1] + 1;
            return ans;
        }
        public int superEggDrop(int k, int n) { // O(KlgN)：数学推导找出了推理公式，速度最快
            int l = 1, r = n;
            while (l < r) { // 寻找右边界
                int m = l + (r - l) / 2;
                if (helper(m, k, n) < n) l = m + 1;
                else r = m;
            }
            return r;
        }
        int helper(int m, int k, int n) { // 能查找到的最大楼层数
            int ans = 0, r = 1;
            for (int i = 1; i <= k; i++) {
                r *= m - i + 1;
                r /= i;
                ans += r;
                if (ans >= n) break;
            }
            return ans;
        }

        public long minimumDifference(int[] a) {
            int m = a.length, n = m / 3, idx = 0;
            long sum = 0, ans = Long.MAX_VALUE;
            long [] pre = new long [n+1], suf = new long [n+1];
            Queue<Integer> min = new PriorityQueue<>((x, y)->y-x);
            for (int i = 0; i < n; i++) {
                min.offer(a[i]);
                sum += a[i];
            }
            pre[idx++] = sum;
            for (int i = n; i < 2 * n; i++) {
                if (a[i] < min.peek()) {
                    sum -= min.poll();
                    min.offer(a[i]);
                    sum += a[i];
                }
                pre[idx++] = sum;
            }
            idx = n;
            sum = 0;
            Queue<Integer> max = new PriorityQueue<>();
            for (int i = m-1; i > m-1-n; i--) {
                sum += a[i];
                max.offer(a[i]);
            }
            suf[idx--] = sum;
            for (int i = m-1-n; i >= n; i--) {
                if (a[i] >= max.peek()) {
                    sum -= max.poll();
                    max.offer(a[i]);
                    sum += a[i];
                }
                suf[idx--] = sum;
            }
            for (int i = 0; i <= n; i++) {
                long dif = pre[i] - suf[i];
                ans = Math.min(ans, dif);
            }
            return ans;
        }

        public String abbreviateProduct(int left, int right) {
            long suf = 1;       // 末五位
            int zoo = 0, orgDigits = 0;
            double prod =  1.0; // 首五位
            for (int n = left; n <= right; n++) {
                prod *= n;
                while (prod >= 1.0) {
                    prod /= 10.0;
                    orgDigits++;
                }
                suf *= n;
                while (suf % 10 == 0) {
                    zoo ++;
                    suf /= 10;
                }
                // 有种特殊情况就是：尾数的最后既没有0，也超过了14位，那么对它取模化小
                if (suf > Math.pow(10, 14)) suf %= (long)Math.pow(10, 14);
            }
            if (orgDigits - zoo <= 10)
                // String r = s.abbreviateProduct(621, 625);
                // return (long)(prod * Math.pow(10, orgDigits - zoo)) + "e" + zoo; // 290/291 passed
                return (long)(prod * Math.pow(10, orgDigits - zoo) + 0.5) + "e" + zoo;
            else {
                // you may find that I add 0.5 before cast to int above, but not here.
                // It is because when org_digits - zeros <= 10, int(prod * (10 ** (org_digits - zeros)) + 0.5) is the actual
                // value, we add 0.5 to the last non-zero digits for rounding, 0.5 just means 0.5 over there.
                // However here int(prod * 100000) is the first 5-digit prefix, the 6-th digit is also a valid digit not
                // error.If we add 0.5 to 6-th digit, how do we calculate the first 6-digit or 7-digit prefix?
                String sufStr = "0000" + Long.toString(suf);
                return (int)(prod * 100000) + "..." + sufStr.substring(sufStr.length() - 5) + "e" + zoo;
            }
        }

    Map<Integer, Integer> m;
    final int a = 1001; // i * a + j
    public DetectSquares() { // on the way to be fixed
    // public mtwoixed() { 
        m = new HashMap<>();
    }
    public void add(int[] p) {
        int v = p[0] * a + p[1];
        m.put(v, m.getOrDefault(v, 0) + 1);
    }
    public int count(int[] p) {
        int ans = 0, tmp = 0;
        for (Integer key : m.keySet()) {
            int i = key / a, j = key % a;
            if (j == p[1]) {
                if (i == p[0]) continue;
                if (i > p[0]) {
                    ans += m.get(key) * m.getOrDefault(p[0]*a + j + i-p[0], 0) * m.getOrDefault(i*a + j+i-p[0], 0);
                } else 
                    ans += m.get(key) * m.getOrDefault(p[0]*a + j + p[0]-i, 0) * m.getOrDefault(i*a + j+p[0]-i, 0);
            }
        }
        return ans;
    }

        public boolean placeWordInCrossword(char[][] a, String t) { // 这代码写得太奇葩了吧：用dfs的思路再写一遍
            m = a.length;
            n = a[0].length;
            o = t.length();
            s = t.toCharArray();
            if (checkUpDown(a)) return true;
            char [][] tmp = new char[m][n];
            for (int i = m-1; i >= 0; i--) 
                System.arraycopy(a[i], 0, tmp[m-1-i], 0, n);
            if (checkUpDown(tmp)) return true;
            if (checkLeftRight(a)) return true;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n/2 + (n%2); j++) {
                    char x = a[i][j];
                    a[i][j] = a[i][n-1-j];
                    a[i][n-1-j] = x;
                }                    
            return checkLeftRight(a);
        }
        int m, n, o, i = 0, j = 0, k = 0;
        char [] s ;
        boolean checkLeftRight(char [][] a) { // 从左到右, 从右到左
            for ( i = 0; i < m; i++) {
                j = 0;
                while (j+o <= n && (a[i][j] == '#' || a[i][j] != ' ' && a[i][j] != s[0])) j++;
                if (j+o > n) continue;
                if (j+o <= n && j > 0 && a[i][j-1] != '#')
                    j++;
                    // continue; // BUG
                for (int jj = j; jj+o <= n; jj++) {
                    k = 0;
                    if (jj > 0 && a[i][jj-1] != '#') continue;
                    System.out.println("jj: " + jj);
                    while (jj < n && k < o) {
                        if (a[i][jj] == s[k] || a[i][jj] == ' ') {
                            jj++;
                            k++;
                        } else if (a[i][jj] == '#' || a[i][jj] != ' ' && a[i][jj] != s[k])
                            break;
                    }
                    if (k == o && (jj == n || jj < n && a[i][jj] == '#')) return true;
                }
            }
            return false;
        }
        boolean checkUpDown(char [][] a) { // 从上到下, 从下到上
            if (m < o) return false;
            for ( j = 0; j < n; j++) {
                i = 0;
                while (i+o <= m && (a[i][j] == '#' || a[i][j] != ' ' && a[i][j] != s[0])) i++;
                if (i + o > m) continue; // 剩余格的长度不够
                if (i + o <= m && i > 0 && a[i-1][j] != '#')
                    i++;
                    // continue; // BUG
                System.out.println("i: " + i);
                for (int ii = i; ii+o <= m; ii++) {
                    k = 0;
                    if (ii > 0 && a[ii-1][j] != '#') continue;
                    while (ii < m && k < o) {
                        if (a[ii][j] == s[k] || a[ii][j] == ' ') {
                            ii++;
                            k++;
                        } else if (a[ii][j] == '#' || a[ii][j] != ' ' && a[ii][j] != s[k])
                            break;
                    }
                    if (k == o && (ii == m || ii < m && a[ii][j] == '#')) return true;
                }
            }
            return false;
        }

           
        // 先考虑一下一个被另一个彻底被包围的情况，再分四种情况将交叠的上下左右拆成小块，再累积和？
        public int computeArea(int x, int y, int xx, int yy, int i, int j, int ii, int jj) { // BUG: 这个题目还没有写完
            int sum = (xx - x) * (yy - y) + (ii - i) * (jj - j);
            // 分上下 与 左右 不交叠的情况
            if (xx <= i || ii <= x || y >= jj || j >= yy) return sum;
            // 有重叠的情况这么考虑还是比较繁琐，改天再写这种题吧
            List<int []> l = new ArrayList<>();
            l.add(new int [] {x, y});
            l.add(new int [] {xx, yy});
            l.add(new int [] {i, j});
            l.add(new int [] {ii, jj});
            Collections.sort(l, (a, b)->a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        }

    int [] ori;
    int [] a;
    Random r = new Random();
    public Solution(int[] nums) {
        ori = nums;
        a = Arrays.copyOf(ori, ori.length);
    }
    public int[] reset() {
        a = Arrays.copyOf(ori, ori.length);
        return a;
    }
    public int[] shuffle() {
        for (int i = a.length-1; i >= 0; i--) {
            int cur = a[i];
            // 随机生成一个小于数组长度的下标
            int idx = r.nextInt(a.length);
            a[i] = a[idx];
            a[idx] = cur;
        }
        return a;
    }

        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length, n = mat[0].length, idx = 0;
            int [] ans = new int [m * n];
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < m+n-1; i++) { // -1
                l.clear();
                int r = i < n ? 0 : i - n + 1;
                int c = i < n ? i : n-1;
                while (r < m && c >= 0) {
                    l.add(mat[r][c]); // 右上角往左下角遍历
                    ++r;
                    --c;
                }
                if (i % 2 == 0)
                    Collections.reverse(l);
                for (int j = 0; j < l.size(); j++) 
                    ans[idx++] = l.get(j);
            }
            return ans;
        }
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length, n = mat[0].length, idx = 0;
            int [] ans = new int [m * n];
            int r = 0, c = 0, d = 1; // d = 1: 向右上角方向
            while (r < m && c < n) {
                ans[idx++] = mat[r][c];
                int i = r + (d == 1 ? -1 : 1);
                int j = c + (d == 1 ? 1 : -1);
                if (i < 0 || i == m || j < 0 || j == n) {
                    if (d == 1) { // 向右 或 向下移动一格
                        r += (c == n-1 ? 1 : 0);
                        c += (c < n-1 ? 1 : 0);
                    } else {
                        c += (r == m-1 ? 1 : 0);
                        r += (r < m-1 ? 1 : 0);
                    }
                    d = 1 - d;
                } else {
                    r = i;
                    c = j;
                }
            }
            return ans;
        }

        public boolean checkPossibility(int[] a) { // 这个题写得太烦了，很多corner case
            int n = a.length, i = 0;
            if (n == 1) return true;
            boolean vis = false;
            ArrayDeque<Integer> s = new ArrayDeque<>();
            for ( i = 0; i < n-1; i++) {
                if (a[i] > a[i+1]) {
                    if (vis) return false;
                    if (!s.isEmpty()) {
                        int top = s.peekLast();
                        if (a[i+1] < top) s.offerLast(a[i]);
                        else s.offerLast(a[i+1]);
                    } else s.offerLast(a[i+1]);
                    i++;
                    if (i == n-1) return true;
                    vis = true;
                } else {
                    if (s.isEmpty() || a[i] >= s.peekLast())
                        s.offerLast(a[i]);
                    else if (vis) return false;
                    else {
                        vis = true;
                        s.pollLast();
                        if (!s.isEmpty() && a[i] < s.peekLast()) return false;
                        s.offerLast(a[i]);
                    }
                }
            }
            if (i < n-1) return false;
            if (!s.isEmpty() && a[n-1] < s.peekLast() && vis) return false;
            return true;
        }
 
        public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
            int [] best = new int [18];
            Arrays.fill(best, Integer.MAX_VALUE);
            // 记录真正的最大连续使用的圈数，17 只是我们估计出的上界
            int maxDiff = 0;
            for (int [] v : tires) {
                long lap = v[0], cur = v[0];
                for (int i = 1; lap < changeTime + v[0]; i++) {
                    best[i] = Math.min(best[i], (int)cur);
                    lap *= v[1];
                    cur += lap;
                    maxDiff = Math.max(maxDiff, i);
                }
            }
            int [] f = new int [numLaps+1];
            Arrays.fill(f, Integer.MAX_VALUE);
            f[0] = 0;
            for (int i = 1; i <= numLaps; i++) 
                for (int j = i-1; j >= 0 && i-j <= maxDiff; j--) 
                    f[i] = Math.min(f[i], f[j] + best[i-j] + changeTime);
            return f[numLaps] - changeTime;
        }

        public int[] constructArray(int n, int k) { // O(k*n)
            // 初始化为1到n，此时差值为1种
            int [] ans = new int [n];
            for (int i = 0; i < n; i++) 
                ans[i] = i+1;
            // 然后从第二位到末位开始不停翻转，每翻转一次增加一种差值
            for (int i = 1; i < k; i++) 
                swap(ans, i, n-1);
            return ans;
        }
        void swap(int [] a, int l, int r) {
            for (int i = 0; i <= (r-l) / 2; i++) {
                int tmp = a[l+i];
                a[l+i] = a[r-i];
                a[r-i] = tmp;
            }
        }
        public int[] constructArray(int n, int k) { // O(N)
            int l = 1, r = k + 1, idx = 0;
            int [] ans = new int [n];
            while (l <= r) {
                ans[idx++] = l++;
                if (l <= r)
                    ans[idx++] = r--;
            }
            for (int i = k+2; i <= n; i++)
                ans[idx++] = i;
            return ans;
        }

        public int monotoneIncreasingDigits(int val) {
            t = String.valueOf(val);
            n = t.length();
            s = t.toCharArray();
            return Integer.parseInt(getMID(0));
        }
        String t;
        char [] s;
        int n;
        String getMID(int idx) {
            if (idx == n-1) return "" + s[idx];
            if ((""+s[idx]).repeat(n-idx).compareTo(t.substring(idx)) <= 0)
                return "" + s[idx] + getMID(idx+1);
            else return (s[idx] == '1' ? "" : (char)('0'+(s[idx]-'1'))) + "9".repeat(n-idx-1);
        }

        public boolean isIdealPermutation(int[] a) {
            int n = a.length;
            if (n <= 2) return true;
            int max = a[0];
            for (int i = 2; i < n; i++) {
                max = Math.max(max, a[i-2]);
                if (a[i] < max) return false;
            }
            return true;
        }

        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        public boolean escapeGhosts(int [][] g, int [] t) {
            Set<int []> sc = new HashSet<>(), sn = new HashSet<>();
            for (int [] c : g) sc.add(c);
            System.out.println("sc.size(): " + sc.size());
            for (int [] zz : sc) 
                System.out.println(Arrays.toString(zz));

            int l = -10001, r = 10001;
            Deque<int []> q = new ArrayDeque<>();
            q.offerLast(new int [] {0, 0});
            int k = 0;
            while (!q.isEmpty()) {
                System.out.println("\nk: " + k++);
                for (int z = q.size()-1; z >= 0; z--) {
                    int [] cur = q.pollFirst();
                    System.out.println("\n" + Arrays.toString(cur));
                    if (sc.contains(cur)) return false; // set里是否包含int[]，这样是不对的。。。。。。
                    if (cur[0] == t[0] && cur[1] == t[1]) return true;
                    for (int [] v : sc) {
                        for (int [] d : dirs) {
                            int i = v[0] + d[0], j = v[1] + d[1];
                            if (i <= l || i >= r || j <= l || j >= r) continue;
                            sn.add(new int [] {i, j}); // 感觉这里好像还有点儿不太对 
                        }
                    }
                    for (int [] d : dirs) {
                        int i = cur[0] + d[0], j = cur[1] + d[1];
                        if (i <= l || i >= r || j <= l || j >= r) continue;
                        q.offer(new int [] {i, j});
                    }
                }
                sc.clear();
                sc.addAll(sn);
                System.out.println("sc.size(): " + sc.size());
                for (int [] zz : sc) 
                    System.out.println(Arrays.toString(zz));
                sn.clear();
            }
            return false;
        }

        public int maxValueOfCoins(List<List<Integer>> ll, int k) {
            int n = ll.size();
            dp = new Integer [n][k+1];
            return backpack(n-1, k, ll);
        }
        Integer [][] dp;
        int backpack(int i, int k, List<List<Integer>> ll) {
            if (i < 0  || k == 0) return 0;
            if (dp[i][k] != null) return dp[i][k];
            int n = Math.min(ll.get(i).size(), k);
            int exclude = backpack(i-1, k, ll);
            int include = 0;
            for (int j = 0, sum = 0; j < n; j++) {
                sum += ll.get(i).get(j);
                include = Math.max(sum + backpack(i-1, k-j-1, ll), include);
            }
            return dp[i][k] = Math.max(exclude, include);
        }
        public int maxValueOfCoins(List<List<Integer>> ll, int k) {
            int [] dp = new int [k+1];
            int cnt = 0;
            for (List<Integer> l : ll) {
                for (int i = 1; i < l.size(); i++)
                    l.set(i, l.get(i) + l.get(i-1)); // pile 前缀和
                cnt = Math.min(cnt + l.size(), k);   // 优化：j 从前 i 个栈的大小之和开始枚举（不超过 k）
                for (int i = cnt; i > 0; i--) {
                    for (int j = 0; j < Math.min(l.size(), i); j++) // j 从下标 idx = 0 开始遍历，硬币的个数为 j+1 个
                        dp[i] = Math.max(dp[i], dp[i - (j+1)] + l.get(j));
                }
            }
            return dp[k];
        }

        // 【这个题目比较好玩儿：任何时候，活宝妹就是一定要嫁给亲爱的表哥！！！】
        public int maximumMinutes(int[][] a) { // 9/55 没有过，不知道是什么原因，改天再写这个
            m = a.length;
            n = a[0].length; // mn: kMax
            r = new int [m * n]; // 火烧到每个方格所需要的最短时间 
            Arrays.fill(r, Integer.MAX_VALUE);
            buildFireGrid(a); // 把这个方法提出去，就可能让代码各个功能模块更加独立  // <<<<<<<<<<<<<<<<<<<< 

            int l = 0, h = m*n, ans = -1; // 接下来，再用二分查找法找一个最大的等待时间
            while (l <= h) { // 判断条件： l 《＝ r 等号狠重要
                int m = l + (h - l) / 2;
                if (isSuccesible(m, r, a)) {
                    ans = Math.max(ans, m);
                    l = m + 1;
                } else h = m-1;
            }
// 再判断一遍，可以永远等吗？【这里，自己最初的想法：是需要再遍历一遍，但是参考别人的，只要答案 ans ＝ m*n 就可以认定，可以永远等！！！一定要嫁给亲爱的表哥！！！】
// 【去掉这个多余步骤之后： 】 51 / 55 testcases passed
            //     if (ans == -1) return ans; // 再判断一遍，可以永远等吗？
            //     Deque<int []> qq = new ArrayDeque<>();
            //     qq.offerFirst(new int [] {0, 0});
            //     Arrays.stream(vis).forEach(x -> Arrays.fill(x, false));
            //     while (!qq.isEmpty()) {
            //         for (int size = qq.size()-1; size >= 0; size--) {
            //             int [] cur = qq.pollLast();
            //             int i = cur[0], j = cur[1];
            //             if (i == m-1 && j == n-1) return 1000000000;
            //             for (int [] d : dirs) {
            //                 int x = i + d[0], y = j + d[1];
            //                 if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y] || a[x][y] != 0 || r[x*n+y] != Integer.MAX_VALUE) continue;
            //                 vis[x][y] = true;
            //                 qq.offerFirst(new int [] {x, y});
            //             }
            //         }
            //     }
            //     return ans;
            return ans == m*n ? (int)1e9 : ans;
        }
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int [] r;
        int m, n;
        boolean isSuccesible(int v, int [] r, int [][] a) {
            Deque<int []> q = new ArrayDeque<>();
            boolean [][] vis = new boolean [m][n];
            q.offerFirst(new int [] {0, 0});
            vis[0][0] = true;
            while (!q.isEmpty()) {
                v++; // 提到前面来
                for (int size = q.size()-1; size >= 0; size--) {
                    int [] cur = q.pollLast();
                    int i = cur[0], j = cur[1];
                    // // 【不一定：即便最后一个格，也是可能有火烧身的。。。也需要先行判断：因为特权主义，亲爱的表哥在活宝妹这里永远拥有特权！！！】
                    // if (i == m-1 && j == n-1) {
                    //     if (r[i*n+j] < v) continue; // 【不合法解：火及时烧到了终点。。。】
                    //     return true;
                    // }
                    for (int [] d : dirs) {
                        int x = i + d[0], y = j + d[1];
// 这里下面判断用 v+1, 也可以把后面 v++ 提前面、循环的前面去
// 【看似简洁，漏洞无数：折三段：来判断】: 最主要的，当 r[x*n+y]==v-Continue 时，会过滤掉一个可能存在的正确答案！！！它给了最后一个终点格特权。。。
                        // if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y] || a[x][y] != 0 || r[x*n+y] <= v+1) continue; // 【折三段：来判断】
                        if (x < 0 || x >= m || y < 0 || y >= n || a[x][y] != 0 || vis[x][y] || r[x*n+y] < v) continue;
                        // 【把终止条件结果，放在这里判断】
                        if (x == m-1 && y == n-1) { // 【不一定：即便最后一个格，也是可能有火烧身的。。。】
                            if (r[x*n+y] < v) continue;
                            return true;
                        }
                        if (r[x*n+y] == v) continue;
                        
                        vis[x][y] = true;
                        q.offerFirst(new int [] {x, y});
                    }
                }
                // v++;
            }
            return false;
        }
        void buildFireGrid(int [][] a) {
            int time = 0;
            boolean [][] vis = new boolean [m][n];
            Deque<int []> q = new ArrayDeque<>();
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    if (a[i][j] == 1) {
                        q.offerFirst(new int [] {i, j});
                        vis[i][j] = true;
                    }
            while (!q.isEmpty()) {
                for (int size = q.size()-1; size >= 0; size--) {
                    int [] cur = q.pollLast();
                    int i = cur[0], j = cur[1];
                    r[i*n+j] = time; // 更新纪录：烧到某个方格的最短时间
                    for (int [] d : dirs) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y] || a[x][y] == 2) continue; // 遍历过了，或是不能穿墙
                        vis[x][y] = true;
                        q.offerFirst(new int [] {x, y});
                    }
                }
                time++;
            }
        }

        // 【方法不通：滑动窗口无法解决去重的问题！！！】乍一看可以用变长的滑动窗口来解决，但是这里需要对子数组去重，所以必须要另想办法
        public int countDistinct(int[] a, int k, int p) { // TODO TODO TODO: 12/152 【数呀数呀数，可怜的不识数、数不清数的弱弱。。。】
            int n = a.length, r = 0, j = 0, cnt = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] % p == 0) cnt++;
                if (cnt <= k) r++;
                else {
                    while (j < i && cnt > k) {
                        if (a[j] % p == 0) 
                            cnt--;
                        j++;
                    }
                    r += i-j+ 1;
                }
            }
            return r + n-1-j;
        }
        class Node {
            public Map<Integer, Node> cld = new HashMap<>(); // cld: children
            public int cnt = 0;
        }
        public int countDistinct(int[] a, int k, int p) {
            for (int i = 0; i < a.length; i++) // 从数组中的每个下标为起始点，数每个下标为起始点的合法子数组个数，的和，进行累加 
                insert(root, a, i, k, p);
            return ans;
        }
        Node root = new Node();
        int ans = 0;
        void insert(Node r, int [] a, int idx, int k, int p) {
            // 【终止条件：】下标越界，或是片段内可整除个数超过了 k 个
            if (idx == a.length || k - (a[idx] % p == 0 ? 1 : 0) < 0) return;
            if (!r.cld.containsKey(a[idx])) {
                r.cld.put(a[idx], new Node());
                ++ans;
            }
            insert(r.cld.get(a[idx]), a, idx+1, k - (a[idx] % p == 0 ? 1 : 0), p);
        }

        // 【思路不对：原始、单纯、简单、粗暴！！！】
        static boolean [] vis = new boolean [1000000001]; // TODO TODO TODO 【爷：这里直接内存溢出，好吧！！！】
        public int maximumWhiteTiles(int[][] a, int k) {
            int n = a.length, max = 1, cnt = 0;
            Arrays.fill(vis, false);
            for (int [] v : a) { // 感觉这一步，做得极其低效
                if (v[1] - v[0] >= k) return k;
                for (int i = v[0]; i <= v[1]; i++) 
                    vis[i] = true;
            }
            for (int i = 0; i+k <= n; i++) {
                if (i == 0) {
                    for (int j = 0; j < k; j++) {
                        if (vis[j]) cnt++;
                        max = Math.max(max, cnt);
                    }
                    continue;
                }
                cnt += (vis[i+k] ? 1 : 0);
                cnt -= (vis[i-1] ? 1 : 0);
                max = Math.max(max, cnt);
            }
            return max;
        }

        public int maximumWhiteTiles(int[][] a, int k) {
            // 【先扫一遍：】有没有可能直接返回的最大长度
            if (Arrays.stream(a).anyMatch(t -> t[1] - t[0] + 1 >= k)) return k;
            int n = a.length, ans = 0;
            Arrays.sort(a, (x, y) -> x[0] - y[0]); // 【确保按照： 起点升序排列】
            List<Integer> starts = new ArrayList<>();
            int [] p = new int [n+1]; // p: prefix 长度累加和
            for (int [] t : a) 
                starts.add(t[0]);
            for (int i = 0; i < n; i++) {
                int len = a[i][1] - a[i][0] + 1;
                p[i+1] = p[i] + len;
            }
            for (int i = 0; i < n; i++) {
                int bgn = a[i][0], end = bgn + k - 1;
                int endIdx = firstGreater(starts, end) - 1; // 查找一个长度为 k 的片段最远能够延伸到的片段的下标
                int notCovered = Math.max(0, a[endIdx][1] - end); // 最无的那个片段中，可能还没能盖住的长度
                ans = Math.max(ans, p[endIdx + 1] - p[i] - notCovered); // damit emacs C-j pyim bug.....
            }
            return ans;
        }
        int firstGreater(List<Integer> li, int t) {
            int l = 0, r = l.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (li.get(m) > t) r = m;
                else l = m+1;
            }
            return l;
        }

        public int maxSubArray(int[] a) { // 【写得狠不科学，有点儿糊糊，让它。。。】
            int n = a.length, max = Integer.MIN_VALUE, sum = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (sum <= 0) {
                    if (sum != Integer.MIN_VALUE)
                        max = Math.max(max, sum);
                    sum = a[i];
                } else sum += a[i];
                max = Math.max(max, sum);
            }
            return max;
        }
        public int largestVariance(String t) {
            int n = t.length();
            if (n == 1) return 0;
            char [] s = t.toCharArray();
            int r = 0;
            for (char i = 'a'; i <= 'z'; i++)
                for (char j = 'a'; j <= 'z'; j++) {
                    if (i == j) continue; // 需要两个不同的字母，两个都得出现
                    int diff = 0, diffWithB = -n; // diffWithB: 记录包含了 a 和b 的子串中 cntA － cntB 的最大差值 
                    for (int k = 0; k < n; k++) {
                        if (s[k] == i) {
                            ++diff;// 【假定：永远是 cntA 》＝ cntB】
                            ++diffWithB;
                        } else if (s[k] == j) {
                            diffWithB = --diff;// 只有在遇到B 时，才是真正有效值 
                            diff = Math.max(diff, 0);// 所以当 cntA-cntB=diff 《 0 时直接重置为 0
                        }
                        r = Math.max(r, diffWithB);
                    }
                }
            return r;
        }

// TODO TODO TODO : 只写了一半，没有写完【动态规划：不习惯的前提下，仍写 dfs 记忆化搜索，只是自顶向下，与自底向上的区别】
        public int countTexts(String t) {// 【2-6:】三种可能；【7-9】：四种可能 
            n = t.length();
            s = t.toCharArray();
            f = new Long [n];
            dfs(0);
            return (int)f[0].intValue();
        }
        static final int mod = (int)1e9 + 7;
        Set<Character> sc = new HashSet<>(List.of('a', 'd', 'g', 'j', 'm', 'p', 't', 'w'));
        // Set<Character> ss = new HashSet<>(List.of('b', 'e', 'h', 'k', 'n, 'q', 'u', 'x'));
        // Set<Character> sss = new HashSet<>(List.of('c', 'f', 'i', 'l', 'o', 'r', 'v', 'y'));
        // Set<Character> ssss = new HashSet<>(List.of('s', 'z'));
        Long [] f;
        char [] s;
        int n;
        long dfs(int idx) {
            System.out.println("\n idx: " + idx);
            if (idx >= n) return 0;// 越边界：返回 0
            // 【终止条件：】判断相对复杂一点儿, 这里考虑的情况不够 ?
            if (idx == n-1 && sc.contains(s[idx])) {
                System.out.println("f[idx]: 1l");
                return f[idx] = 1l;
            }
            if (f[idx] != null) return f[idx];// 记忆化，不重复计算
            long r = 0;
            int i = idx + 1;
            int maxCnt = (s[idx]-'0' < 7 ? 3 : 4);
            while (i < n && i < idx + maxCnt && s[i] == s[idx]) i++;
            // for (int j = idx+1; j < Math.min(i, idx+maxCnt); j++) {
            for (int j = idx+1; j <= i; j++) {// 这里的情况考虑得过于简单了？只当作了一个字母，可是可以是第一个字母的重复？？？
                System.out.println("j: " + j);
                long cur = dfs(j);
                r = (r + cur) % mod;
                System.out.println("r: " + r);
            }
            System.out.println("r: " + r);
            return f[idx] = r;
        }
        
        static final int mod = (int)1e9 + 7;
        public int sumSubarrayMins(int[] a) { // 【遍历两遍的解法：】直观，比较容易懂
            int n = a.length, l [] = new int [n], r [] = new int [n];
            Deque<Integer> s = new ArrayDeque<>();
            for (int i = 0; i < n; i++) { // 遍历一遍：录下左边界
                while (!s.isEmpty() && a[s.peek()] > a[i]) s.pollFirst();
                if (s.isEmpty()) l[i] = -1;
                else l[i] = s.peek();
                s.offerFirst(i);
            }
            s.clear();
            for (int i = n-1; i >= 0; i--) { // 遍历一遍：录下右边界
                while (!s.isEmpty() && a[s.peek()] >= a[i]) s.pop();// 是说，某一边可以、需要取等号的 ?
                if (s.isEmpty()) r[i] = n;
                else r[i] = s.peek();
                s.offerFirst(i);
            }
            long ans = 0;
            for (int i = 0; i < n; i++) 
                ans = (ans + (long)(i - l[i]) * (r[i] - i) * a[i]) % mod;
            return (int)ans;
        }
        static final int mod = (int)1e9 + 7;
        public int sumSubarrayMins(int[] a) { // 【遍历一遍的解法：】就不直观！！！
            int n = a.length, j, k;
            long ans = 0;
            Deque<Integer> s = new ArrayDeque<>();
            for (int i = 0; i <= n; i++) {
                int cur = i == n ? Integer.MIN_VALUE : a[i];
                while (!s.isEmpty() && cur < a[s.peek()]) {
                    j = s.pollFirst();
                    k = s.isEmpty() ? -1 : s.peek();
                    ans += (long)a[j] * (i - j) * (j - k);// 【处理的是当前下标 i 之前的栈中各个元素！！！】再多想一想
                }
                s.offerFirst(i);
            }
            return (int)(ans % (long)mod);
        }
        public long subArrayRanges(int[] a) {
            int n = a.length, j, k;
            long r = 0;
            Deque<Integer> s = new ArrayDeque<>();
            // 跟前一题不同的地方在于：遍历当前下标，并不计算要的以当前下标为最小或最大值，而是以当前坐标前一个坐标为基【最小最大值】的累积和
            for (int i = 0; i <= n; i++) { // 【遍历第一遍：】减去所有可能的最小值，的和 
                int cur = i == n ? Integer.MIN_VALUE : a[i];
                while (!s.isEmpty() && cur < a[s.peek()]) {
                    j = s.pollFirst();
                    k = s.isEmpty() ? -1 : s.peek();
                    r -= (long)a[j] * (i - j) * (j - k);
                }
                s.offerFirst(i);
            }
            s.clear();
            for (int i = 0; i <= n; i++) { // 【遍历第二遍：】加上所有可能的最大值，的和 
                int cur = i == n ? Integer.MAX_VALUE : a[i];
                while (!s.isEmpty() && a[s.peek()] < cur) {
                    j = s.pollFirst();
                    k = s.isEmpty() ? -1 : s.peek();
                    r += (long)a[j] * (i - j) * (j - k);
                }
                s.offerFirst(i);
            }
            return r;
        }
        // 这里能够想到的思路是说： prefix Sum 用来计算子数组片段的和；【但是感觉，还缺少什么，把思路组织不起来】
        // 当去找一个数组中最小元素的时候，是一个从左到右O(N) 的遍历，在遍历的每一个元素上，来计算最左最右，当前元素作为可能的子数组中最小值的可能存在的最大次数，栈！！！
        static final int mod = (int)1e9 + 7;
        public int totalStrength(int[] a) {// 【错误思路】
            int n = a.length, l [] = new int [n], r [] = new int [n];
            long [] p = new long [n];// prefix sum: 用来求，子数组片段的和，的时修，比较方便
            for (int i = 0; i < n; i++) 
                p[i] = (i == 0 ? 0 : p[i-1]) + (long)a[i];
            // Init a Monotonic Stack -
            // Used ArrayDeque for Stack instead of Stack as ArrayDeque does not require acquiring & releasing thread locks, which is costly in time
            Deque<Integer> s = new ArrayDeque<>();
            for (int i = 0; i < n; i++) { // 【遍历第一遍：】去找所有的左边界
                while (!s.isEmpty() && a[s.peek()] > a[i]) s.pollFirst();
                if (s.isEmpty()) l[i] = -1;
                else l[i] = s.peek();
                s.offerFirst(i);
            }
            s.clear();
            for (int i = n-1; i >= 0; i--) { // 【遍历第二遍：】去找所有的右边界
                while (!s.isEmpty() && a[s.peek()] >= a[i]) s.pollFirst();
                if (s.isEmpty()) r[i] = n;
                else r[i] = s.peek();
                s.offerFirst(i);
            }
            long ans = 0;
            for (int i = 0; i < n; i++) // 【出错：】虽然找到了左右边界，但思路不对，左右边界是所有情况，这所有情况中每一种的左右边界又各自不同，所以想错了。。。 
                ans = (ans + (long)a[i] * (p[r[i] == n ? n-1 : r[i]] - p[l[i] == -1 ? 0 : l[i]])% mod) % mod;
            return (int)ans;
        }
        // 【栈栈栈：单调栈： bugglyCoding: 】需要再想一下，是怎么回事？因为是所有子数组的片段处理和，所以是对 prefixSum 前缀和数组的，再次取前缀和，也因此长度为 n+2
        public int totalStrength(int[] a) {
            final int mod = (int)1e9 + 7;
            int n = a.length;
            int sum = 0, ans = 0, p [] = new int [n+2];
            Deque<Integer> s = new ArrayDeque<>();
            for (int i = 0; i <= n; i++) {
                int cur = i < n ? a[i] : 0;
                sum = (sum + cur) % mod;    // 【看不懂：】这里不是已经是累加和了吗？
                p[i+1] = (sum + p[i]) % mod;// 【看不懂：】上面 sum 已经是累加和了，为什么这里会再累加一遍？就是这样滴～～！！！
                while (!s.isEmpty() && cur < a[s.peek()]) {
                    int j = s.pollFirst();
                    int left = s.isEmpty() ? -1 : s.peek();
                    long leftAcc = left < 0 ? p[j] : p[j] - p[left];
                    long rightAcc = p[i] - p[j];
                    int leftLength = j - left;
                    int rightLength = i - j;
                    ans = (int)(ans + (rightAcc * leftLength - leftAcc * rightLength) % mod * a[j] % mod) % mod;
                }
                s.offerFirst(i);
            }
            return (ans + mod) % mod;
        }
        public int totalStrength(int[] a) {// 【打不死的小强：换个方法再来一遍，不信不懂了，哈哈哈。。。就是一定要嫁给偶亲爱的表哥！！！】
            final int mod = (int)1e9 + 7;
            int n = a.length;
            long [] p = new long [n], pp = new long [n+1];
            for (int i = 0; i < n; i++) // prefixSum p[]
                p[i] = ((i == 0 ? 0 : p[i-1]) + a[i]) % mod;
            for (int i = 0; i < n; i++) // prefixSum pp[] of the previous prefixSum p[]
                pp[i+1] = (pp[i] + p[i]) % mod;
            Deque<Integer> s = new ArrayDeque<>();
            int left [] = new int [n]; // left: 说的是 left, 但记录的是左边第一个比它小的数的下标，因为它是从右向左反着遍历的
            Arrays.fill(left, -1);
            for (int i = n-1; i >= 0; i--) {
                while (!s.isEmpty() && a[s.peek()] >= a[i])
                    left[s.pollFirst()] = i;
                s.offerFirst(i);
            }
            int right [] = new int [n]; // right: 说的是 right, 但记录的是右边第一个比它小的数的下标，
            Arrays.fill(right, n);
            s.clear();
            for (int i = 0; i < n; i++) {
                while (!s.isEmpty() && a[s.peek()] > a[i])
                    right[s.pollFirst()] = i;
                s.offerFirst(i);
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                int l = left[i], r = right[i];
                long leftSum = pp[i] - pp[Math.max(0, l)], rightSum = pp[r] - pp[i];
                int leftLen = i - l, rightLen = r - i;
                ans += a[i] * (rightSum * leftLen % mod - leftSum * rightLen % mod ＋ mod) % mod;
                ans %= mod;
            }
            return (int)ans;
        }
    }
    public static void main (String[] args) {
        Solution s  =  new Solution ();

        int [] a = new int [] {1,3,1,2};

        int r = s.totalStrength(a);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);






























