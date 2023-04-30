import com.TreeNode;
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

public class dpsix {
    public static class Solution {

        // 万能的【记忆化深搜：】这次刷动规，感觉就写记忆化深搜了。。。。。写得像 1+1=2 一样简单熟练。。。 368
        public List<Integer> largestDivisibleSubset(int[] a) { // 突然想起来：这是一个风味独特的，什么狗屁【接龙型】返回链表等相对特殊的数据结构的记忆化深搜?
            n = a.length; this.a = a;
            for (int v : a) s.add(v);
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) // 【O(N^2logN)】能过吗？
                for (int j = 0; j < n; j++) {
                    int u = a[i], v = a[j], min = Math.min(u, v), max = Math.max(u, v);
                    if (max % min == 0) {
                        List<Integer> l = dfs(max, max / min);
                        if (l.size() > ans.size()) ans = l;
                    }
                }
            return ans;
        }
        Set<Integer> s = new HashSet<>();
        Map<String, List<Integer>> m = new HashMap<>();
        int [] a;
        int n;
        List<Integer> dfs(long i, int j) { // i: u j: d
            long v = i * j;
            if (i > (int)1e9 * 2 || !s.contains((int)v)) return null;
            String k = i + "-" + j;
            if (m.containsKey(k)) return m.get(k);
            List<Integer> l = dfs(v, j), ans = new ArrayList<>(); // 感觉这里哪里写得可能不对。。。
            ans.add((int)v);
            if (l != null)
                for (int val : l) ans.add(val);
            m.put(k, ans);
            return ans;
        }

        public int longestValidParentheses(String t) { // TODO TODO TODO: 不知道这个转化的思路对不对，改天再写。。。这个思路可能不太对，应该用栈
            int n = t.length(), max = 0, sum = 0; char [] s = t.toCharArray();
            int [] r = new int [n];
            for (int i = 0; i < n; i++) r[i] = (s[i] == '(' ? -1 : 1);
            System.out.println(Arrays.toString(r));
            Map<Integer, Integer> m = new HashMap<>();
            m.put(0, -1);
            for (int i = 0; i < n; i++) {
                System.out.println("\n i: " + i);
                int v = r[i];
                sum += v;
                if (sum >= 1) {
                    sum = 0;
                    m.put(0, i);
                } else if (sum == 0 || m.containsKey(sum)) {
                    max = Math.max(max, i - m.get(sum));
                }
                System.out.println("sum: " + sum);
                m.put(sum, i);
            }
            return max;
        }
        public int longestValidParentheses(String t) {  // 感觉：现在还是不太喜欢用栈，也要把栈写熟练了。。。【爱表哥，爱生活！！！】
            int n = t.length(), max = 0; char [] s = t.toCharArray();
            Deque<Integer> sc = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char c = s[i];
                if (c == ')' && !sc.isEmpty() && s[sc.peekFirst()] == '(') {
                    sc.pollFirst();
                    if (sc.isEmpty()) max = Math.max(max, i+1);
                } else if (c == ')') {
                    if (!sc.isEmpty())
                        max = Math.max(max, i - sc.peekFirst()-1); // ) 【s.peekFirst(),i】) 两个之间是有效的
                    // else max = Math.max(max, i+1); // 这里不对
                    sc.offerFirst(i);  // 不合法的字符，也入栈
                }
                else if (c == '(') {
                    if (!sc.isEmpty()) max = Math.max(max, i-sc.peekFirst()-1);
                    sc.offerFirst(i);
                }
            }
            if (!sc.isEmpty()) max = Math.max(max, n - sc.peekFirst()-1);
            else return n;
            return max;
        }

        // 【比较繁琐：】先用栈解出正确答案；再记忆化深搜【这个地方的思路还不太清楚。。。】出所有可能答案？再计结果 2019
        public int scoreOfStudents(String t, int[] a) { 
            n = a.length; m = t.length(); s = t.toCharArray(); this.a = a; 
            int ans = getCorrectResult();
            System.out.println("ans: " + ans);

            return 0;
        }
        char [] s; int [] a;
        int n, m;
        int getCorrectResult() {
            Stack<Integer> si = new Stack<>(); 
            Stack<Character> sc = new Stack<>();
            for (int i = 0; i < m; i++) {
                char c = s[i];
                if (Character.isDigit(c)) {
                    if (!sc.isEmpty() && sc.peek() == '*') { // 计算一步结果: 先算乘法 
                        int v = si.pop() * (c - '0');
                        sc.pop();  // 把乘号，扔出去
                        si.push(v); // 把当前结果，入数字栈
                    } else si.push(c-'0'); // 数字栈
                } else sc.push(c); // 符号栈
            }
            int r = 0; // 当前，只剩下加法来做
            while (!si.isEmpty()) r += si.pop();
            return r;
        }

        public int minCut(String t) { // 最少切割的意思是说，每个回文尽可能地长 // TODO TODO TODO: 思路不清楚，没写完
            int n = t.length(); char [] s = t.toCharArray();
            boolean [][] f = new boolean [n][n];
            for (int i = 0; i < n; i++) f[i][i] = true;
            for (int i = n-2; i >= 0; i--)
                for (int j = i+1; j < n; j++) 
                    if (s[i] == s[j] && (j - i <= 2 || f[i+1][j-1])) f[i][j] = true;
            int [] r = new int [n+1];
            Arrays.fill(r, Integer.MAX_VALUE);
            r[0] = 1;
            for (int j = 1; j < n; j++)
                for (int i = j-1; i >= 0; i--) 
                    if (f[i][j]) r[j+1] = Math.min(r[j], r[i] + 1);
            return r[n];
        }
        public int minCut(String t) { // 最小切割数：那么每个回文子串，尽可能地最长。。。132
            n = t.length(); s = t.toCharArray(); this.t = t; 
            p = new boolean [n][n]; // 方便O[1] 查询是否为回文
            for (int i = 0; i < n; i++) p[i][i] = true;
            for (int i = n-2; i >= 0; i--)
                for (int j = i+1; j < n; j++)
                    if (s[i] == s[j] && (j - i <= 2 || p[i+1][j-1])) p[i][j] = true;
            // 【记忆化深搜：】写不到了，怎么办呢？搜呀。。。
            f = new Integer [n][n];
            int r = dfs(0, n-1); 
            System.out.println("r: " + r);
            return r == 1 ? 0 : r-1;
        }
        Integer [][] f; String t;
        boolean [][] p;
        char [] s; int n;
        int dfs(int i, int j) {
            if (i > j) return Integer.MAX_VALUE / 2;
            if (f[i][j] != null) return f[i][j];
            if (p[i][j] || i == j) return f[i][j] = 1;
            int r = Integer.MAX_VALUE / 2;
            for (int k = i; k <= j; k++) 
                if (p[i][k]) r = Math.min(r, 1 + dfs(k+1, j));
            return f[i][j] = r;
        }

        public boolean canMouseWin(String[] a, int catLen, int mouseLen) { // 【返回的是：小老鼠赢了吗？】159/179 // TODO TODO TODO: 
            this.catLen = catLen; this.mouseLen = mouseLen; m = a.length; n = a[0].length(); N = m * n;
            s = new char [m][n];
            for (int i = 0; i < m; i++) s[i] = a[i].toCharArray();
            f = new Boolean [N][N][2];
            int mi = 0, mj = 0, ci = 0, cj = 0, fi = 0, fj = 0;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (s[i][j] == 'C') {
                        ci = i; cj = j;
                    } else if (s[i][j] == 'M') {
                        mi = i; mj = j;
                    } else if (s[i][j] == 'F') {
                        fi = i; fj = j;
                    }
            fd = fi * n + fj;
            return dfs(mi * n + mj, ci * n + cj, 0);
        }
        Boolean [][][] f;
        int m, n, fd, N, mouseLen, catLen;
        char [][] s;
        boolean dfs(int ii, int jj, int k) { // 【想不明白：】哪里写错了。。。
            boolean mouseTurn = (k % 2 == 0);
            int len = (mouseTurn ? mouseLen : catLen);
            int i = 0, j = 0;
            if (mouseTurn) { i = ii / n; j = ii % n; }
            else { i = jj / n; j = jj % n; }
            // System.out.println("\n i: " + i);
            // System.out.println("j: " + j);
            // System.out.println("mouseTurn: " + mouseTurn);
            if (k >= 1000) return !mouseTurn;
            if (f[ii][jj][k%2] != null) return f[ii][jj][k%2];
            if (ii == jj) return f[ii][jj][k%2] = false;
            if (s[i][j] == 'F') return f[ii][jj][k%2] = mouseTurn;
            for (int x = j-1; x >= Math.max(0, j - len); x--) { // 向左
                if (s[i][x] == '#') break;
                if (i * n + x == fd) return f[ii][jj][k%2] = mouseTurn;
                if (mouseTurn && i * n + x == jj) continue; // 这就是从猫头上跳过了呀。。。
                else if (!mouseTurn && i * n + x == ii) return f[ii][jj][k%2] = false;
                if (mouseTurn && dfs(i * n + x, jj, k+1) || !mouseTurn && !dfs(ii, i * n + x, k+1)) return f[ii][jj][k%2] = mouseTurn;
            }
            for (int x = j+1; x <= Math.min(n-1, j + len); x++) { // 向右
                if (s[i][x] == '#') break;
                if (i * n + x == fd) return f[ii][jj][k%2] = mouseTurn; 
                if (mouseTurn && i * n + x == jj) continue;
                else if (!mouseTurn && i * n + x == ii) return f[ii][jj][k%2] = false;
                if (mouseTurn && dfs(i * n + x, jj, k+1) || !mouseTurn && !dfs(ii, i * n + x, k+1)) return f[ii][jj][k%2] = mouseTurn;
            }
            for (int x = i-1; x >= Math.max(0, i - len); x--) { // 向上
                if (s[x][j] == '#') break;
                if (x * n + j == fd) return f[ii][jj][k%2] = mouseTurn;
                if (mouseTurn && x * n + j == jj) continue;
                else if (!mouseTurn && x * n + j == ii) return f[ii][jj][k%2] = false;
                if (mouseTurn && dfs(x * n + j, jj, k+1) || !mouseTurn && !dfs(ii, x * n + j, k+1)) return f[ii][jj][k%2] = mouseTurn;
            }
            for (int x = i+1; x <= Math.min(m-1, i + len); x++) { // 向下
                if (s[x][j] == '#') break;
                if (x * n + j == fd) return f[ii][jj][k%2] = mouseTurn;
                if (mouseTurn && x * n + j == jj) continue;
                else if (!mouseTurn && x * n + j == ii) return f[ii][jj][k%2] = false;
                if (mouseTurn && dfs(x * n + j, jj, k+1) || !mouseTurn && !dfs(ii, x * n + j, k+1)) return f[ii][jj][k%2] = mouseTurn;
            }
            if (mouseTurn && dfs(ii, jj, k+1) || !mouseTurn && !(dfs(ii, jj, k+1))) // 【原地不动】
                return f[ii][jj][k%2] = mouseTurn;
            // System.out.println("\n i: " + i);
            // System.out.println("j: " + j);
            // System.out.println("mouseTurn: " + mouseTurn);
            return f[ii][jj][k%2] = !mouseTurn;
        }

        public int catMouseGame(int[][] g) { / 改天再写这两个题目
            n = g.length; this.g = g; 
            f = new Integer [n][n][2*n+1];
            return dfs(1, 2, 0);
        }
        int n; int [][] g;
        Integer [][][] f;
        int dfs(int i, int j, int k) {
            // if (k == 2 * n) return f[i][j][k] = 0;
            if (k == 2 * n) return 0;
            if (i == j) return f[i][j][k] = 2; // 同一位置：猫赢
            if (i == 0) return f[i][j][k] = 1; // 老鼠：能够先进洞房...
            if (f[i][j][k] != null) return f[i][j][k];
            if (k % 2 == 0) { // 老鼠
                boolean catWin = true;
                for (int v : g[i]) {
                    int val = dfs(v, j, k+1);
                    if (val == 1) return f[i][j][k] = 1;
                    else if (val != 2) catWin = false;
                }
                return f[i][j][k] = (catWin ? 2 : 0);
            } else { // 猫
                boolean mouseWin = true;
                for (int v : g[j]) {
                    if (v == 0) continue; // 猫：不许进老鼠房间...
                    int val = dfs(i, v, k+1);
                    if (val == 2) return f[i][j][k] = 2;
                    else if (val != 1) mouseWin = false;
                }
                return f[i][j][k] = (mouseWin ? 1 : 0);
            }
        }

        // 没有读懂题目的提示：是什么意思，为什么传统的方法不可以？【这里有个问题是：】找到了时间限度内可达，可是因为每个节点的重量。。。再想一下 1928
        public int minCost(int t, int [][] egs, int[] a) {
            n = egs.length; g = new ArrayList [n]; this.a = a; 
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1], w = e[2];
                g[u].add(new int [] {v, w});
                g[v].add(new int [] {u, w});
            }
            d = new int [n];
            Arrays.fill(d, Integer.MAX_VALUE);
            calculateShortestDist(0);
            System.out.println(Arrays.toString(d));
            if (d[n-1] == Integer.MAX_VALUE) return -1;
            // f = new int [n]; // 【动规】：试着写，可是这个是树状遍历的形式，还是不太会写。。。
            f = new Integer [n][n+1];
            // f[n-1] = a[n-1];
            return dfs(0, n);
            // return min;
        }
        int dfs(int i, int j) {
            if (i == n-1) return a[i];
            if (f[i][j] != null) return f[i][j];
            int ans = Integer.MAX_VALUE;
            for (int [] e : g[i]) {
                if (e[0] == j) continue;
                if (d[e[0]] > d[i]) 
                    ans = Math.min(ans, a[i] + dfs(e[0], i));
            }
            return f[i][j] = ans;
        }
        List<int []> [] g;
        int n, min = Integer.MAX_VALUE; int [] d, a;
        Integer [][] f;
        void calculateShortestDist(int uu) {
            d[uu] = 0;
            Queue<int []> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
            q.offer(new int [] {uu, 0});
            while (!q.isEmpty()) {
                int [] cur = q.poll();
                int u = cur[0], t = cur[1];
                for (int [] v : g[u])
                    if (t + v[1] < d[v[0]]) {
                        d[v[0]] = t + v[1];
                        q.offer(new int [] {v[0], d[v[0]]});
                    }
            }
        }

        public int maxPalindromes(String t, int k) { // 【记忆化深搜：】会超时，被逼着去写动规。。。
            n = t.length(); s = t.toCharArray(); this.k = k;
            if (t.chars().distinct().count() == 1) return n / k;
            p = new boolean [n][n]; // 方便 O[1] 查询是否为回文
            for (int i = 0; i < n; i++) p[i][i] = true;
            for (int i = n-1; i >= 0; i--) 
                for (int j = i+1; j < n; j++) 
                    if (s[i] == s[j] && (j - i <= 2 || p[i+1][j-1]))
                        p[i][j] = true;
            f = new Integer [n]; // 【记忆化深搜：】会超时，被逼着去写动规。。。
            return dfs(0);
        }
        Integer [] f;
        boolean [][] p; 
        char [] s; int n, k;
        int dfs(int i) { // 【记忆化深搜：】会超时，被逼着去写动规。。。
            if (i > n-k) return 0;
            if (f[i] != null) return f[i];
            if (i == n-k) return f[i] = (p[i][n-1] ? 1 : 0);
            int ans = 0;
            for (int j = i; j + k <= n; j++) // 遍历回文子串的头【O(N^2)】有点儿慢, 想到【O(NlogN)】会想到线段树。。。
                for (int x = j+k-1; x < n; x++) // 遍历回文子串的尾
                    if (p[j][x]) 
                        ans = Math.max(ans, 1 + dfs(x+1));
            return f[i] = ans;
        }
        public int maxPalindromes(String t, int k) { // 【动规：】：与自己的原始土方法相比，中心扩展法与动规结合起来了，不需要单独先扫一遍是否回文。。。
            int n = t.length(); char [] s = t.toCharArray();
            int [] f = new int [n+1];
            // 长度为 n 的字符串，可能产生最 2n-1 级回文中文【Li,Ri】，其中Li = [i/2], Ri = Li + (i % 2)
            // 只要从 0 到 2n-2 【0,2*N-2】遍历 i, 就可以得到所有可能的回文中心，这样就把奇数与偶数长度两种情况统一起来了
            for (int i = 0; i < 2*n-1; i++) { // 中心扩展法: 这里【l.r】为回文子串的遍历中心，向两边扩散。。。
                int l = i / 2, r = l + (i % 2);
                f[l+1] = Math.max(f[l+1], f[l]); // 在回文子串内，为 f[l+1], 否则取之前一位的最大值 
                for (; l >= 0 && r < n && s[l] == s[r]; l--,r++)
                    if (r - l + 1 >= k)
                        f[r+1] = Math.max(f[r+1], f[l] + 1);
            }
            return f[n];
        }        

        static final int mod = (int)1e9 + 7; // TODO TODO TODO: 现在初步尝试，还想不清楚哪里出错了。。。 // TODO TODO TODO: 
        public int countPartitions(int[] a, int k) {
            n = a.length; this.a = a; 
            long sum = 0;
            for (int v : a) sum += v;
            if (sum < 2 * k) return 0;
            // int [] f = new int [k]; // 去数和记：和不超过 k 的所有的可能性【O(10^6)】可能是苛以过的
            // f[0] = 1;
            // for (int i = 0; i < n; i++) { // 遍历每个当前数：把这个数，加与不加
            //     int v = a[i];
            //     for (int j = k-1; j - v >= 0; j--) // 对于每个出现的数值，不管是不是 v 的重复出现，累计更新重复效果。。
            //         if (f[j-v] > 0) f[j] = (f[j] + f[j-v]) % mod;
            //     if (v < k) f[v] = Math.max(f[v], 1); // 更新当前和的可能性：最小为 1
            // }
            Arrays.sort(a);
            f = new Integer [n][k];
            dfs(n-1, k-1); // 记忆化深搜
            System.out.println("f.length: " + f.length);
            for (int z = 0; z < f.length; ++z) 
                System.out.println(Arrays.toString(f[z]));
            // int ans = 0;
            // for (int i = 0; i < k; i++)
            //     if (f[n-1][i] != null) ans = (ans + f[n-1][i]) % mod;
            // return quickPow(2, n) - ans;
            return quickPow(2, n) - dfs(n-1, k-1);
        }
        Integer [][] f;
        int n; int [] a;
        int dfs(int i, int j) { // 搜和 <= j
            if (j < 0) return 0;
            if (i < 0) return 1;
            if (f[i][j] != null) return f[i][j];
            return f[i][j] = (int)(dfs(i-1, j-a[i]) + dfs(i-1, j)) % mod;
        }
        int quickPow(int v, int n) {
            long r = 1;
            while (n > 0) {
                if (n % 2 == 1)
                    r = (r * v) % mod;
                v = (v * v) % mod;
                n >>= 1;
            }
            return (int)r;
        }

        // 先走一遍，采最多的走，再走一遍，能采多少采多少？那么第一遍走，就把采得最多的路径给改掉，变每格为0 【好像仍然会失掉最优解】
        public int cherryPickup(int[][] a) {
            int n = a.length;
            // 【动规：】先找一条可以采最多的路径，动规解法，找到一遍的最大值 
            int [][] f = new int [n][n];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MIN_VALUE)); // 加了这个，多些判断，但不会出错【不会多走不能走的格】
            f[0][0] = a[0][0];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (f[i][j] == Integer.MIN_VALUE) continue;
                    if (j < n-1 && a[i][j+1] != -1) // 向右
                        f[i][j+1] = Math.max(f[i][j+1], f[i][j] + a[i][j+1]); 
                    if (i < n-1 && a[i+1][j] != -1) // 向下
                        f[i+1][j] = Math.max(f[i+1][j], f[i][j] + a[i+1][j]);
                }
            int ans = f[n-1][n-1], r = ans;
            if (ans == Integer.MIN_VALUE) return 0;
            // 【清理路径：】把采过的路径，变 0
            for (int i = n-1; i >= 0; i--) 
                for (int j = n-1; j >= 0; j--) {
                    if (f[i][j] == r) {
                        r -= a[i][j];
                        a[i][j] = 0;
                    } else if (i > 0 && f[i-1][j] == r) {
                        r -= a[i-1][j];
                        a[i-1][j] = 0;
                    } else if (j > 0 && f[i][j-1] == r) {
                        r -= a[i][j-1];
                        a[i][j-1] = 0;
                    }
                }
            // 【再走第二遍】：找剩余的最多路径，累计和
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MIN_VALUE));
            f[n-1][n-1] = a[n-1][n-1];
            for (int i = n-1; i >= 0; i--) 
                for (int j = n-1; j >= 0; j--) {
                    if (f[i][j] == Integer.MIN_VALUE) continue;
                    if (i > 0 && a[i-1][j] != -1) f[i-1][j] = Math.max(f[i-1][j], f[i][j] + a[i-1][j]);
                    if (j > 0 && a[i][j-1] != -1) f[i][j-1] = Math.max(f[i][j-1], f[i][j] + a[i][j-1]);
                }
            return ans + f[0][0];
        }
        // 【不带记忆的深搜。。。】被自己打雷雷坏了吧。。。
        public int cherryPickup(int[][] a) { // 能不能像那个类似题一样，一次起两个格呢？没说错了，但是严重超时, 
            n = a.length; this.a = a;
            if (n == 1) return a[0][0];
            vis = new boolean [n * n][n * n]; 
            dfs(0, 0, a[0][0]); // 这个方法太慢了，就直接动规
            return max;
        }
        int [][] dirs = {{1, 0}, {0, 1}};
        boolean [][] vis; int [][] a;
        int n, max = 0;
        void dfs(int ij, int iijj, int cur) {
            int i = ij / n, j = ij % n, ii = iijj / n, jj = iijj % n;
            if (i < 0 || i >= n || j < 0 || j >= n || ii < 0 || ii >= n || jj < 0 || jj >= n
                || a[i][j] == -1 || a[ii][jj] == -1 || vis[ij][iijj]) return ;
            if (i == n-1 && j == n-1 && ii == n-1 && jj == n-1) {
                max = Math.max(max, cur + a[i][j]);
                return ;
            }
            vis[ij][iijj] = true;
            cur += (i != ii && j != jj) ? a[i][j] + a[ii][jj] : a[i][j];
            for (int [] d : dirs) {
                int x = i + d[0], y = j + d[1];
                for (int [] dd : dirs) {
                    int xx = ii + dd[0], yy = jj + dd[1];
                    dfs(x * n + y, xx * n + yy, cur);
                }
            }
            vis[ij][iijj] = false;
        }
// 【带记忆的深搜。。。】记忆化深搜。。。仍然不对。。。
        public int cherryPickup(int[][] a) { 
            n = a.length; this.a = a;
            if (n == 1) return a[0][0];
            // v = new boolean [n * n][n * n];  // 全局的，不要重复
            f = new Integer [n*n][n*n];
            return dfs(0, 0, new boolean [n][n]); // 不带记忆的，一定慢，为什么要记忆呢？！！！
        }
        int [][] dirs = {{1, 0}, {0, 1}};
        // boolean [][] v;
        int [][] a;
        Integer [][] f;
        int n, max = 0;
        int dfs(int ij, int iijj, boolean [][] vis) {
            int i = ij / n, j = ij % n, ii = iijj / n, jj = iijj % n;
            if (i < 0 || i >= n || j < 0 || j >= n || ii < 0 || ii >= n || jj < 0 || jj >= n
                || a[i][j] == -1 || a[ii][jj] == -1) return 0;
            if (f[ij][iijj] != null) return f[ij][iijj];
            if (i == n-1 && j == n-1 && ii == n-1 && jj == n-1) return f[ij][iijj] = a[i][j];
            // int cur = (vis[i][j] ? 0 : a[i][j]) + (i != ii || j != jj ? (vis[ii][jj] ? 0 : a[ii][jj]) : 0);
            int cur = (vis[i][j] ? 0 : a[i][j]);
            vis[i][j] = true;
            cur += (i != ii || j != jj ? (vis[ii][jj] ? 0 : a[ii][jj]) : 0);
            vis[ii][jj] = true;
            // v[ij][iijj] = true;
            int ans = 0;
            for (int [] d : dirs) {  // 某个格会走到另一个踩过的格上去。。。
                int x = i + d[0], y = j + d[1];
                for (int [] dd : dirs) {
                    int xx = ii + dd[0], yy = jj + dd[1];
                    ans = Math.max(ans, cur + dfs(x*n+y, xx*n+yy, vis));
                    // a[i][j] + (i != ii || j != jj ? a[ii][jj] : 0) + dfs(x*n+y, xx*n+yy));
                }
            }
            return f[ij][iijj] = ans;
        }
        public int cherryPickup(int[][] a) { // 看了思路提示，才想起来，当初是这么写来着，记忆记性真好呀。。。
            int n = a.length, m =  2 * (n - 1) + 1;
            int [][][] f = new int [m][n][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    Arrays.fill(f[i][j], Integer.MIN_VALUE);
            f[0][0][0] = a[0][0]; // 【自顶向下的动规】，从头走到尾巴上去, 自顶向下，就是说，以当前的状态，往后推，更新以后的状态
            for (int i = 0; i < m; i++) // 第 i 步走法
                for (int j = 0; j < n; j++) // 第一个人所在的行 A
                    for (int k = 0; k < n; k++) { // 第二个人所在的行 B
                        if (f[i][j][k] == Integer.MIN_VALUE) continue; // 某个格，可能不可到达
                        int x = 0, y = 0;
                        // A 向下， B 向下
                        x = j+1; y = k+1;
                        if (x < n && y < n && a[x][i+1-x] != -1 && a[y][i+1-y] != -1)
                            f[i+1][x][y] = Math.max(f[i+1][x][y], f[i][j][k] + (x == y ? a[x][i+1-x] : a[x][i+1-x] + a[y][i+1-y]));
                        // A 向右， B 向下
                        x = j; y = k+1;
                        if (i+1 - x < n && y < n && a[x][i+1-x] != -1 && a[y][i+1-y] != -1)
                            f[i+1][x][y] = Math.max(f[i+1][x][y], f[i][j][k] + (x == y ? a[x][i+1-x] : a[x][i+1-x] + a[y][i+1-y]));
                        // A 向下， B 向右
                        x = j+1; y = k;
                        if (x < n && i+1 - y < n && a[x][i+1-x] != -1 && a[y][i+1-y] != -1)
                            f[i+1][x][y] = Math.max(f[i+1][x][y], f[i][j][k] + (x == y ? a[x][i+1-x] : a[x][i+1-x] + a[y][i+1-y]));
                        // A 向右， B 向右
                        x = j; y = k;
                        if (i+1 - x < n && i+1 - y < n && a[x][i+1-x] != -1 && a[y][i+1-y] != -1)
                            f[i+1][x][y] = Math.max(f[i+1][x][y], f[i][j][k] + (x == y ? a[x][i+1-x] : a[x][i+1-x] + a[y][i+1-y]));
                    }
            return f[m-1][n-1][n-1] == Integer.MIN_VALUE ? 0 : f[m-1][n-1][n-1];
        }

        public int maxEnvelopes(int[][] a) {
            int n = a.length; this.a = a; 
            Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); // 重新按升序排列，习惯
            List<int []> l = new ArrayList<>(); l.add(a[0]);
            for (int i = 1; i < n; i++) {
                if (a[i][0] == a[i-1][0] && a[i][1] == a[i-1][1]) continue;
                l.add(a[i]);
            }
            int m = l.size();
            a = new int [m][2];
            for (int i = 0; i < m; i++) a[i] = l.get(i);
            System.out.println("a.length: " + a.length);
            for (int z = 0; z < a.length; ++z) 
                System.out.println(Arrays.toString(a[z]));
            int [] f = new int [m];
            f[0] = 1;
            for (int i = 1; i < n; i++) {
                int x = a[i][0], y = a[i][1];
                int j = binarySearch(0, i-1, x, y);
                while (j != -1 && j >= 0) { // 因为没有把数穿起来，所以右边第一个，不能保证最长最优解，仍然要往后遍历。。。那么就变成：【是否会超时】？
                    f[i] = Math.max(f[i], f[j] + 1);
                    if (j < m-1) 
                        j = binarySearch(0, j-1, x, y);
                    else break;
                }
                f[i] = Math.max(f[i], 1);
            }
            return Arrays.stream(f).max().getAsInt();
        }
        int [][] a;
        int binarySearch(int l, int r, int x, int y) { // 寻找左边界: 注意原数组是按【降序排列的】// TODO TODO TODO: 这里没有改完。。。改天再写
            if (x < a[l][0] && y < a[l][1]) return -1;
            if (x <= a[r][0] || y <= a[r][1]) return -1;
            if (l == r) return a[l][0] < x && a[l][1] < y ? l : -1;
            while (l < r) {
                int m = (l + r) >> 1;
                if (a[m][0] >= x || a[m][1] >= y) l = m+1;
                else r = m;
            }
            return l >= 0 && l <= r && a[l][0] < x && a[l][1] < y ? l : -1;
        }

        static final int mod = (int)1e9 + 7;
        int [][] dirs = {{-1, 0}, {0, -1}, {-1, -1}};
        public int[] pathsWithMaxScore(List<String> l) { // 【动规：】自底向上
            int m = l.size(), n = l.get(0).length(), i = 0, j = 0;
            int [][] f = new int [m][n];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, -1));
            f[m-1][n-1] = 0;
            long [][] r = new long [m][n];
            r[m-1][n-1] = 1;
            for (i = m-1; i >= 0; i--) 
                for (j = n-1; j >= 0; j--) {
                    if (f[i][j] == -1) continue;
                    char c = l.get(i).charAt(j);
                    if (c == 'X') continue;
                    if (c == 'S' || c != 'X' || c == 'E') {
                        for (int [] d : dirs) {
                            int x = i + d[0], y = j + d[1];
                            if (x < 0 || y < 0 || l.get(x).charAt(y) == 'X') continue;
                            int v = f[i][j] + (l.get(x).charAt(y) == 'E' ? 0 : l.get(x).charAt(y) - '0');
                            if (v > f[x][y]) {
                                f[x][y] = v;
                                r[x][y] = r[i][j];
                            } else if (v == f[x][y])
                                r[x][y] = (r[x][y] + r[i][j]) % mod;
                        }
                    }
                }
            if (i < 0 && j < 0 && f[0][0] != -1) return new int [] {f[0][0], (int)r[0][0]};
            else return new int [] {0, 0};
        }

        static final int mod = (int)1e9 + 7;
        public int maxSum(int[] a, int[] b) {
            int m = a.length, n = b.length, i = 0, j = 0, x = -1, y = -1;
            long [] l = new long [m+1], r = new long [n+1];
            for ( i = 0; i < m; i++) l[i+1] = l[i] + a[i];
            for ( i = 0; i < n; i++) r[i+1] = r[i] + b[i];
            TreeMap<Integer, List<Integer>> mi = new TreeMap<>();
            i = 0; j = 0;
            while (i < m && j < n) {
                if (a[i] == b[j]) {
                    mi.put(a[i], List.of(i, j));
                    i++;
                    j++;
                } else if (a[i] < b[j]) i++;
                else j++;
            }
            long ans = 0;
            i = 0; j = 0;
            for (Map.Entry<Integer, List<Integer>> en : mi.entrySet()) {
                int k = en.getKey();
                List<Integer> li = en.getValue();
                if (x == -1 && y == -1) {
                    x = li.get(0);
                    y = li.get(1);
                    ans = Math.max(l[x], r[y]); // 不带公共点
                } else {
                    ans = (ans + Math.max(l[li.get(0)] - l[x], r[li.get(1)] - r[y])) % mod; // 带一端公共点：带头，不带尾。。。
                    x = li.get(0);
                    y = li.get(1);
                }
            }
            if (x != -1 && y != -1)
                ans = (ans + Math.max(l[m] - l[x], r[n] - r[y])) % mod;
            else return (int)Math.max(l[m], r[n]);
            return (int)ans;
        }

        public boolean canDistribute(int[] a, int [] b) { // TODO TODO TODO: 102/109 1655
            n = b.length; int N = a.length; this.a = b;
            Map<Integer, Integer> m = new HashMap<>();
            for (int v : a) m.put(v, m.getOrDefault(v, 0) + 1); // 50 个
            Arrays.sort(b); // 升序排列
            backTracking(n-1, 0, 0);
            boolean [] f = new boolean [1 << n];
            f[0] = true;
            for (Map.Entry<Integer, Integer> en : m.entrySet()) {
                int k = en.getKey(), v = en.getValue();
                Integer key = masks.floorKey(v); // 这些里面的，应该是最全最优解，其它键值比它小的，不用遍历了，忆经可以保证结果正确
                if (key == null) continue; // 什么也填不了
                for (int i = (1 << n)-1; i > 0; i--)
                    for (int mask : masks.get(key)) { // 遍历这个数：所有可能的分布，必须暴力以保证结果正确
                        if ((i & mask) == mask)
                            f[i] |= f[i ^ mask];
                    }
            }
            return f[(1 << n)-1];
        }
        int n; int [] a;
        TreeMap<int, Set<Integer>> masks = new TreeMap<>(); // sum, mask 可能会有不同的，或是多个
        void backTracking(int i, int j, int k) { // i: idx j: sum k: mask 
            if (i < 0) {
                masks.computeIfAbsent(j, z -> new TreeSet<>((x, y)-> y-x)).add(k);
                return ;
            }
            backTracking(i-1, j + a[i], k | (1 << i));
            backTracking(i-1, j, k);
        }

        class Node { // TODO TODO TODO: 55/58
            int s, ll, rr; // ll: maxLeft, rr: minRight: 主要是用来帮助父节点判断是否是 BST 来用来着。。。
            boolean b;
            Node l, r;
            public Node() {
                // l = new Node(); // 栈溢出
                // r = new Node();
            }
        }
        boolean allNeg = true;
        public int maxSumBST(TreeNode root) {
            Node r = new Node();
            traversal(root, r);
            if (allNeg) return 0;
            return getMax(r);
        }
        int max = 0;
        int getMax(Node r) {
            if (r == null) return 0;
            if (r.b) max = Math.max(max, r.s);
            return Math.max(max, Math.max(getMax(r.l), getMax(r.r)));
        }
        void traversal(TreeNode r, Node p) {
            if (r == null) {
                p.b = true;
                p = null; // <<<<<<<<<<<<<<<<<<<< 不起效？
                return ;
            }
            if (r.val >= 0 && allNeg) allNeg = false;
            if (r.left == null && r.right == null) {
                p.s = r.val;
                p.b = true;
                p.ll = p.s; // 【叶子节点：】左右最值，是自己
                p.rr = p.s;
                return;
            }
            p.l = new Node();
            p.r = new Node();
            // p.l.b = true;
            // p.r.b = true;
            traversal(r.left, p.l);
            traversal(r.right, p.r);
            p.s = p.l.s + p.r.s + r.val; // 左右子树，与父节点和
            p.ll = Math.max(p.l.ll, r.val); // 【这里不要更新到根节点】：
            p.rr = Math.min(Math.min(p.l.ll, p.r.rr), r.val);
            // p.rr = Math.min(p.l.ll, Math.min(r.val, p.r.rr));
            // p.rr = Math.min(p.r.rr, r.val); // 这个地方可能出错了。。。
            // p.rr = Math.min((p.r.s == 0 ? Integer.MAX_VALUE : p.r.rr), r.val);
            // p.b = (p.l == null || p.l.b && p.l.ll < r.val) && (p.r == null || p.r.b && r.val < p.r.rr); // BST: 左中右，小大关系
            p.b = (p.l.b || p.l.s == 0) && (p.r.b || p.r.s == 0) && (p.l.ll == 0 || p.l.ll < r.val) && (p.r.rr == 0 || r.val < p.r.rr);
        }

        public boolean possiblyEquals(String S, String T) {  // 【记忆化深搜：】解题思路，应该是这样，不知道还有没有什么细节？改天再写这个 2060
            m = S.length(); n = T.length(); s = S.toCharArray(); t = T.toCharArray();
            if (s[0] != t[0] && !Character.isDigit(s[0]) && !Character.isDigit(t[0])) return false;
            f = new Boolean [m][n];
            return dfs(0, 0);
        }
        int m, n; char [] s, t;
        Boolean [][] f;
        boolean dfs(int i, int j) { // 因为数字的参入，存在四种比较可能性，要把那些瓣清楚。。。
            if (i == m && n == j) return true;
            if (i == m || j == n) return false;
            if (f[i][j] != null) return f[i][j];
            if (!Character.isDigit(s[i]) && s[i] == t[j]) return f[i][j] = dfs(i+1, j+1);
        }        

// 【 n<= 500, 2^10】【 o<= 50, 2^6】【YN:2^2】【YN:2^2】【可以建一个 20 （10+6+2+2）位的 mask】1397 【KMP】【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        public int findGoodStrings(int n, String S, String T, String E) { // 【哪里没有写对，上下字符的处理，与受限字符的处理，可能不对】// TODO TODO TODO: 
            this.n = n; m = E.length();
            s = S.toCharArray(); t = T.toCharArray(); e = E.toCharArray();
            return dfs(0, 0, true, true);
        }
        Map<Integer, Integer> f = new HashMap<>(); // 动规：记忆化用它，因为2^20=(int)1e6 数据规模有点儿大，但是是离散化的，用字典比较好
        static final int mod = (int)1e9 + 7;
        char [] s, t, e;
        int [] fail; // 【这个数组狠重要】
        int m, n;
        int dfs(int i, int j, boolean lo, boolean hi) {
            if (j == m) return 0; // 是说，包含了 evil 字符串为子串，【不合法】
            if (i == n) return j < m ? 1 : 0;
            int key = getKey(i, j, lo, hi);
            if (f.containsKey(key)) return f.get(key);
            // 遍历当前下标 i 所有【可能，且合法】的字符选择并深搜：受最小最大限制，且不能出现在不可出现的字符串
            int x = (lo ? s[i] - 'a' : 0);   // 【等于S:】最小字符受限，
            int y = (hi ? t[i] - 'a' : 25); // 【等于T:】最大字符受限
            long r = 0;
            for (int k = x; k <= y; k++) { // 【找到原因了：】这里说，evil 的当前字符不匹配，但它可能匹配先前出面过的某段序列，
                // 可以跳的，比如：evil="abgab|h|c" 如果 j ＝ 5 遍历到 g 字符，虽然不匹配 h, 但它匹配了之前 j ＝ 3... 要弄个 LCP 什么之类的，忘记了。。。先放一下
                r = (r + (long)dfs(i+1, (k == e[j] - 'a' ? j+1 : fail[j]), lo && k == s[i] - 'a', hi && k == t[i] - 'a')) % mod;
            }
            f.put(key, (int)r);
            return (int)r;
        }
        int getKey(int i, int j, boolean l, boolean r) {
            return (1 << i) << 10 | (1 << j) << 4 | (1 << (l ? 1 : 0)) << 2 | 1 << (r ? 1 : 0); // 【没括号】
        }
        String a = "pzdanyao";
        String b = "wgpmtywi";
        String c = "sdka";
        int r = s.findGoodStrings(8, a, b, c);

        public int longestMountain(int[] a) { // TODO TODO TODO: 56/75
            int n = a.length, j = 0, i = 0, max = 0;
            boolean up = false, dn = false;
            while (i < n) {
                while (!up && i < n-1 && a[i] >= a[i+1]) i++;
                if (i == n) return max;
                if (i > 0 && a[i] < a[i-1])
                    j = i; // 1
                else if (i > 0 && a[i] > a[i-1])
                    j = i-1;
                ++i;
                if (i == n) return max;
                while (i < n && a[i] > a[i-1]) {
                    if (!up) up = true;
                    i++;
                }
                if (i == n) return max;
                while (i < n && a[i] < a[i-1]) {
                    if (!dn) dn = true;
                    i++;
                }
                if (up && dn) {
                    max = Math.max(max, i - j);
                    // up = false;
                    dn = false;
                }
            }
            return max;
        }
        public int longestMountain(int[] a) { // TODO TODO TODO: 56/75
            int n = a.length, j = 0, i = 1, max = 0;
            if (n < 3) return 0;
            boolean up = false, dn = false;
            Stack<Integer> s = new Stack<>();
            s.push(0);
            while (i < n) {
                while (i < n && a[i] > a[i-1]) {
                    if (!up) up = true;
                    i++;
                }
                while (i > n && a[i] < a[i-1]) {
                    if (!dn) dn = true;
                    i++;
                }
                if (up && dn) max = Math.max(max, i)                     
            }
        }

        public int minNumberOperations(int[] a) { // TLE TLE TLE: 127/129 弄个线段树，来区间型更新不好吗？ 1526
            n = a.length; this.a = a;
            if (Arrays.stream(a).distinct().count() == 1) return a[0];
            return minNumberOperations(0, n-1, 0);
        }
        int [] a; int n;
        int minNumberOperations(int i, int j, int v) {
            if (i > j) return 0;
            if (i == j) return a[i] - v;
            int min = a[i];
            List<Integer> l = new ArrayList<>();
            for (int k = i; k <= j; k++) 
                if (a[k] < min) {
                    min = a[k];
                    l.clear();
                    l.add(k);
                } else if (a[k] == min) l.add(k);
            int ans = min - v, pre = -1, idx = -1;
            for (int k = 0; k < l.size(); k++) {
                idx = l.get(k);
                ans += (k == 0 ? minNumberOperations(i, idx-1, min) :
                        minNumberOperations(pre + 1, idx-1, min));
                pre = idx;
            }
            ans += minNumberOperations(idx+1, j, min);
            return ans;
        }

        public int minDifficulty(int[] a, int d) { // 如果能读明白，是把这个数级划分为 d 个子数组，就狠好解题了。。。
            n = a.length; this.a = a;
            if (n < d) return -1;
            f = new Integer [n][d+1];
            int v = dfs(0, d);
            return v == Integer.MAX_VALUE ? -1 : v;
        }
        Integer [][] f;
        int n; int [] a;
        int dfs(int i, int j) {
            if (i == n) return 0;
            if (f[i][j] != null) return f[i][j];
            if (j == 1) {
                int max = 0;
                for (int x = i; x < n; x++)
                    max = Math.max(max, a[x]);
                return f[i][j] = max;
            }
            int ans = Integer.MAX_VALUE, max = 0;
            for (int x = i; x <= n-j; x++) { // 当前子数组，遍历到 x】，包括右端点
                max = Math.max(max, a[x]);
                ans = Math.min(ans, max + dfs(x+1, j-1));
            }
            return f[i][j] = ans;
        }

        public int maxValue(int[][] a, int k) {
            n = a.length; this.a = a; 
            Arrays.sort(a, (x, y)->x[0] != y[0] ? x[0] - y[0] : y[2] - x[2]);  // 这里，把价值排前面
            f = new Integer [n][k+1];
            return dfs(0, k);
        }
        Integer [][] f;
        int n; int [][] a;
        int dfs(int i, int j) {
            if (i == n || j == 0) return 0;
            if (f[i][j] != null) return f[i][j];
            if (j == 1) {
                int max = 0;
                for (int x = i; x < n; x++)
                    max = Math.max(max, a[x][2]);
                return f[i][j] = max;
            }
            int ans = Math.max(a[i][2], dfs(i+1, j)); // 这里意思说：可以不管是否一定选够 j 件事件，但选个价值最高的
            int idx = binarySearch(i+1, n-1, a[i][1] + 1); // 【二分查找】说：即便 dfs 记忆化深搜，仍然可以借助二分查找等来提速。【爱表哥，爱生活！！！】
            if (idx != -1) ans = Math.max(ans, a[i][2] + dfs(idx, j-1));
            return f[i][j] = ans;
        }        
        int binarySearch(int l, int r, int v) {
            if (l < 0 || l >= n) return -1;
            if (v <= a[l][0]) return l;
            if (v > a[r][0]) return -1;
            while (l < r) {
                int m = (l + r) >> 1;
                if (a[m][0] >= v) r = m;
                else l = m+1;
            }
            return a[l][0] >= v ? l : -1;
        }

        public int maxValueOfCoins(List<List<Integer>> a, int k) {
            n = a.size(); r = new int [n][];
            for (int i = 0; i < n; i++) {
                List<Integer> l = a.get(i);
                int m = l.size(); int [] s = new int [m+1];
                for (int j = 0; j < m; j++) s[j+1] = s[j] + l.get(j);
                r[i] = s;
            }
            // int [][] f = new int [n][k+1]; // 【动规：】写不到呀，写不到，还不适应。。。
            f = new Integer [n][k+1];
            return dfs(0, k);
        }
        Integer [][] f;
        int n; int [][] r;
        int dfs(int i, int j) {
            if (i == n) return 0;
            if (f[i][j] != null) return f[i][j];
            int ans = 0;
            for (int k = 0; k <= Math.min(j, r[i].length-1); k++) 
                ans = Math.max(ans, r[i][k] + dfs(i+1, j - k));
            return f[i][j] = ans;
        }

        public int minimumTime(int n, int[][] egs, int [] t) { // 2050 还是不知道哪里写错了。。。
            int [] p = new int [n];
            for (int [] e : egs) {
                int u = e[0], v = e[1];
                p[v-1] |= (1 << (u-1)); // 这样才能用 n 位来表示
            }
            System.out.println(Arrays.toString(p));
            for (int i = 0; i < n; i++) System.out.println("\n Integer.toBinaryString(p[i]): " + Integer.toBinaryString(p[i]));
            int [] f = new int [1 << n];
            Arrays.fill(f, Integer.MAX_VALUE / 2);
            f[0] = 0;
            for (int i = 0; i < (1 << n); i++) {  // 遍历所有的状态
                // System.out.println("\n i: " + i);
                int r = 0;
                for (int j = 0; j < n; j++) // 遍历每种状态下的【备选课程候选】：没要求，或是要求全上过满足了
                    if (p[j] == 0 || ((i & p[j]) == p[j])) // 这么写，就可能包括了已经选过的课，但运行快一点儿
                        r |= (1 << j);
                r = (r & (~i)); // 【过滤：】过滤掉所有已经选过的课程
                if (i == 0)
                    System.out.println("\n Integer.toBinaryString(r): " + Integer.toBinaryString(r));
                // for (int toBeSelected = r; toBeSelected > 0; toBeSelected = toBeSelected & (toBeSelected-1)) { // 遍历候选课程所有可能的状态【这里写错了？】
// 遍历候选课程所有可能的状态【这里写错了？】感觉这里写的状态太少了
                // for (int toBeSelected = r; toBeSelected > 0; toBeSelected = ((toBeSelected -1) & toBeSelected)) {
                for (int toBeSelected = r; toBeSelected > 0; toBeSelected--) {
                    int timeNeeded = 0;
                    toBeSelected = (r & toBeSelected); // 这才遍历了所有的状态
                    if (i == 0)
                        System.out.println("Integer.toBinaryString(toBeSelected): " + Integer.toBinaryString(toBeSelected));
                    for (int j = 0; j < n; j++)
                        if ((toBeSelected & (1 << j)) > 0)
                            timeNeeded = Math.max(timeNeeded, t[j]);
                    if (i == 0)
                        System.out.println("timeNeeded: " + timeNeeded);
                    if (toBeSelected > 0)
                        f[i | toBeSelected] = Math.min(f[i | toBeSelected], f[i] + timeNeeded);
                }
            }
            return f[(1 << n) -1];
        }
        int [][] a = new int [][] {{2,7},{2,6},{3,6},{4,6},{7,6},{2,1},{3,1},{4,1},{6,1},{7,1},{3,8},{5,8},{7,8},{1,9},{2,9},{6,9},{7,9}};
        int [] b = new int [] {9, 5, 9, 5, 8, 7, 7, 8, 4};
        int r = s.minimumTime(9, a, b);

        // 算出最长公有子序列之后，要用这个东西把最短XX 给还原回来。。。。。
        public String shortestCommonSupersequence(String S, String T) { // 1092
            int m = S.length(), n = T.length();
            char [] s = S.toCharArray();
            char [] t = T.toCharArray();
            int [][] f = new int [m+1][n+1];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++)
                    if (s[i] == t[j]) f[i+1][j+1] = f[i][j] + 1;
                    else f[i+1][j+1] = Math.max(f[i+1][j], f[i][j+1]);
            if (f[m][n] == Math.max(m, n)) return S;
            System.out.println("f.length: " + f.length);
            for (int z = 0; z < f.length; ++z) 
                System.out.println(Arrays.toString(f[z]));
            // 然后根据上面的统计结果，往回倒。。。。。
            int o = m + n - f[m][n]; int i = 0, j = 0;
            char [] r = new char [o];
            for (int k = 0; k < o; k++) {
                System.out.println("\n k: " + k);
                // System.out.println("i: " + i);
                // System.out.println("j: " + j);
                if (i < m && j < n && s[i] == t[j]) {
                    r[k] = s[i];
                    i++;
                    j++;
                } else if (i < m-1 && j < n-1 && f[i+1][j+2] > f[i+2][j+1]) {
                    r[k] = t[j]; j++;
                } else if (i < m-1 && j < n-1) {
                    r[k] = s[i]; i++;
                } else if (i < m || j < n) {
                    while (i < m) r[k++] = s[i++];
                    System.out.println("j: " + j);
                    System.out.println("k: " + k);
                    while (j < n) r[k++] = t[j++];
                }
                 System.out.println(Arrays.toString(r));
            }
             System.out.println(Arrays.toString(r));
            return new String(r);
        }
        String a = "bbabacaa";
        String b = "cccababab";
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        String r = s.shortestCommonSupersequence(a, b);

        public int minCost(int n, int[] a) {
            this.n = n; m = a.length+2; 
            Arrays.sort(a);
            int [] r = new int [m];
            for (int i = 0; i < a.length; i++)
                r[i+1] = a[i]; r[m-1] = n;
            System.out.println(Arrays.toString(r));
            this.a = r;
            f = new Integer [m][m];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE / 2));
            return dfs(0, m-1);
        }
        Integer [][] f;
        int [] a;
        int m, n;
        int dfs(int i, int j) {
            if (j == i+1) return f[i][j] = 0;
            if (f[i][j] != Integer.MAX_VALUE / 2) return f[i][j];
            int ans = Integer.MAX_VALUE / 2;
            for (int k = i+1; k < j; k++) 
                ans = Math.min(ans, dfs(i, k) + dfs(k, j) + (a[j] - a[i]));
            return f[i][j] = ans;
        }

        public boolean winnerSquareGame(int n) {
            this.n = n;
            f = new Boolean [n+1][2];
            return dfs(n, 0);
        }
        Boolean [][] f;
        int n;
        boolean dfs(int i, int j) {
            if (i < 1) return f[i][j] = (j == 0 ? false : true);
            if (f[i][j] != null) return f[i][j];
            for (int k = 1; k * k <= i; k++) {
                if (j == 0 && dfs(i - k*k, 1-j) || j == 1 && !dfs(i - k*k, 1-j))
                    return f[i][j] = (j == 0 ? true : false);
            }
            return f[i][j] = (j == 0 ? false : true);
        }

        public String stoneGameIII(int[] a) { // 【没弄明白：】 min-max 题型，算是怎么回事？ 1406
            n = a.length; this.a = a; 
            f = new Integer [n][2];
            int v = dfs(0);
            return v > 0 ? "Alice" : (v == 0 ? "Tie" : "Bob");
        }
        Integer [][] f;
        int [] a;
        int n;
        int dfs(int i, int j) { // 怎么才能把它设计成：A － B 多出来的分值呢？
            if (i == n) return 0;
            if (f[i][j] != null) return f[i][j];
            int ans = 0, sum = 0;
            for (int k = i; k <= Math.min(n-1, i+2); k++) {
                sum += a[k];
                ans = Math.max(ans, sum - dfs(k+1, 1-j));
            }
            return f[i] = ans;
        }

        public int maxCoins(int[] a) { // 这个题被自己彻底忘记了，只能先硬瓣一下。。。没弄懂。。。 312
            l = Arrays.stream(a).boxed().collect(Collectors.toList());
            f = new Integer [n][n];
            return dfs(0, n-1);
        }
        Integer [][] f;
        int n; List<Integer> l;
        int dfs(int i, int j) {
            if (i == j) return f[i][j] = l.get(i);
            if (i+1 == j) return f[i][j] = a[i] * a[j] + Math.max(a[j], a[i]);
            if (f[i][j] != null) return f[i][j];
            int ans = 0;
            for (int k = i+1; k < j; k++) 
                ans = Math.max(ans, a[k-1] * a[k] * a[k+1] + dfs(i, k-1) + dfs(k+1, j));
            return ans;
        }        

        public int maximumsSplicedArray(int[] a, int[] b) { // 能用【动规】来写的题目，是不是就可以先用【记忆化深搜】先写一遍？ // TODO TODO TODO: 
            n = a.length; this.a = a; this.b = b; 
            l = new int [n+1]; r = new int [n+1];
            for (int i = 0; i < n; i++) {
                l[i+1] = l[i] + a[i];
                r[i+1] = r[i] + b[i];
            }
            System.out.println(Arrays.toString(l));
            System.out.println(Arrays.toString(r));
            // f = new Integer [n][n]; // 需要区分是否交换一次，因为最多交换一次，不能深搜的时候，无意中交换了无数次。。。
            int max = Math.max(l[n], r[n]);
            for (int i = 0; i <= n; i++)
                for (int j = i; j < n; j++) 
                    max = Math.max(max, l[i] + r[j+1] - l[i] + l[n] - l[j+1]);
            return max;
            // return dfs(0, n-1); // 最多交换一次
        }
        Integer [][] f;
        int n; int [] l, r, a, b;
        int dfs(int i, int j) {
            if (i >= n) return 0;
            // if (i == j) return f[i][j] = (k == 0 ? a[i] : Math.max(a[i], a[j]));
            if (f[i][j] != null) return f[i][j];

            int ans = Math.max(l[j+1] - l[i], r[j+1] - r[i]); // 不换：什么也不做
            for (int x = i; x <= j; x++) // 交换一次：【x,y】包括两端，可是起始与终点，如何划分呢？这是要【暴力查找两个端点？】遍历交换时的左端点
                for (int y = x; y <= j; y++) // 遍历交换，可能的右端点【恐怖：】当【O(N^2)】而且N 【1,1e5】会狠恐怖吧。。。
                    // ans = Math.max(ans, Math.max(l[x] + (r[y+1] - r[x]) + l[j+1] - l[y+1], l[y+1] + dfs(y+1, j, 1)));
                    ans = Math.max(ans, l[x] + (r[y+1] - r[x]) + l[j+1] - l[y+1]);
            return f[i][j] = ans;
        }
        // public int maximumsSplicedArray(int[] a, int[] b) { // 能用【动规】来写的题目，是不是就可以先用【记忆化深搜】先写一遍？ // TODO TODO TODO: 
        //     int n = a.length;
        //     int [] l = new int [n+1]; r = new int [n+1]; // 这个前缀和，还是要的
        //     for (int i = 0; i < n; i++) {
        //         l[i+1] = l[i] + a[i];
        //         r[i+1] = r[i] + b[i];
        //     } 
        //     int [][] f = new Integer [n][3];
        //     for (int i = 0; i < n; i++) { // 从左往右遍历当前元素 
        //         f[i][0] = l[i+1]; // 永远，仍然只是 A 数组里所有元素的和
        //         f[i][1] = (i == 0 ? r[i+1] : f[i-1][0] +)
        //     }
        // }
        int [] a = new int [] {10, 20, 50, 15, 30, 10};
        int [] b = new int [] {40, 20, 10, 100, 10, 10};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        int r = s.maximumsSplicedArray(a, b);

        public int minDistance(int[] a, int k) { // 1478 中位数，讨厌数学
            n = a.length; this.a = a;
            r = new int [n+1];
            for (int i = 0; i < n; i++) r[i+1] = r[i] + a[i];
            System.out.println(Arrays.toString(r));
            f = new Integer [n][k+1];
            return dfs(0, k);
        }
        Integer [][] f;
        int [] a, r;
        int n;
        int dfs(int i, int j) {
            System.out.println("\n i: " + i);
            System.out.println("j: " + j);
            if (i == n) return 0;
            if (j == 1) {
                // int r = 0;
                // for (int k = i; k < n; k++)
                //     r += a[k] - a[i + (n - i) / 2 - 1];
                return f[i][j] = r[n] - r[i] - (n-i) * a[i+(n-i) / 2 -1];
            }
            if (f[i][j] != null) return f[i][j];
            int ans = Integer.MAX_VALUE;
            for (int k = i; k < n-(j-1); k++) { // 不会算中位数。。。
                System.out.println("k: " + k);
                ans = Math.min(ans, (k-i == 0 ? 0 : r[k+1] - r[i] - a[i + (k+1-i)/2 - 1] * (k + 1 - i)) + dfs(k+1, j-1));
                // ans = Math.min(ans, (k-i == 0 ? 0 : r[k+1] - r[i] - (a[k] + a[i]) / 2 * (k + 1 - i)) + dfs(k+1, j-1));
            }
            System.out.println("\n i: " + i);
            System.out.println("j: " + j);
            System.out.println("ans: " + ans);
            return f[i][j] = ans;
        }

        public int maxHeight(int[][] a) {
            int n = a.length;
            List<int []> l = new ArrayList<>();
            for (int [] e : a) l.add(rotate(e));
            Collections.sort(l, (x, y)-> x[0] != y[0] ? x[0] - y[0] : (x[1] != y[1] ? x[1] - y[1] : x[2] - y[2])); // 严格升序
            int [] f = new int [n];
            for (int i = 0; i < n; i++) {
                f[i] = l.get(i)[2];
                int x = l.get(i)[0], y = l.get(i)[1], z = l.get(i)[2];
                for (int j = i-1; j >= 0; j--) {
                    int [] r = l.get(j);
                    if (x >= r[0] && y >= r[1] && z >= r[2])
                        f[i] = Math.max(f[i], f[j] + z);
                }
            }
            return Arrays.stream(f).max().getAsInt();
        }
        int [] rotate(int [] A) {
            int a = A[0], b = A[1], c = A[2];
            int min = Math.min(a, Math.min(b, c));
            int max = Math.max(a, Math.max(b, c));
            int mid = (max == a ? (min == b ? c : b) : (max == b ? (min == c ? a : c) : (min == a ? b : a))); // 最难的，在这里。。。
            return new int [] {mid, min, max};
        }

        public int numWays(String[] a, String T) { // 不知道哪里写错了。。。1639
            n = T.length(); m = a.length; o = a[0].length(); this.a = a; 
            s = T.toCharArray();
            r = new int [m][o][26]; // 字符频率表
            for (int i = 0; i < m; i++) {
                int j = 0;
                for (char c : a[i].toCharArray()) {
                    r[i][j][c-'a']++;
                    j++;
                }
            }
            f = new Integer [n][m][o];
            long ans = 0;
            for (int j = 0; j < m; j++)
                ans = (ans + dfs(0, j, 0)) % mod;
            return (int)ans;
        }
        Integer [][][] f;
        int [][][] r;
        int n, m, o;
        static final int mod = (int)1e9 + 7;
        char [] s; String [] a;
        int dfs(int i, int j, int k) { // i: 下标， j: 使用的单词 k: 单词的下标
            // System.out.println("\n i: " + i);
            // System.out.println("s[i]: " + s[i]);
            // System.out.println("j: " + j);
            // System.out.println("k: " + k);
            if (i == n) return (k <= o ? 1 : 0);
            if (f[i][j][k] != null) return f[i][j][k];
            if (k + (n - i) > o) return f[i][j][k] = 0;// 不够长了。。。
            int idx = s[i] - 'a';
            // if (r[j][k][idx] == 0) return f[i][j][k] = 0; // 这里不对，每个字符串，它存在一个遍历空间
            long ans = 0;
            for (int x = k; x < o - (n-i-1); x++)
                if (r[j][x][idx] > 0) {
                    for (int y = 0; y < m; y++) 
                        ans = (ans + dfs(i+1, y, x+1)) % mod;
                }
            // System.out.println("\n i: " + i);
            // System.out.println("j: " + j);
            // System.out.println("k: " + k);
            return f[i][j][k] = (int)ans;
        }

        public int jobScheduling(int[] s, int[] e, int[] p) {
            int n = s.length;
            a = new int [n][3];
            for (int i = 0; i < n; i++)
                a[i] = new int [] {s[i], e[i], p[i]} ;
            Arrays.sort(a, (x, y) -> x[0] - y[0]); // 开始时间升序
            int [] f = new int [n];
            for (int i = n-1; i >= 0; i--) {
                f[i] = a[i][2];
                int j = binarySearch(i+1, n-1, a[i][1]);
                if (j == -1) continue;
                int right = a[j][1];
                // for (; j < n; j++) // 【优化：】这里是不需要遍历完的，只一个片段
                while (j < n && a[j][0] < right) { // a[j][0] == right 这个结果其实已经被计入了，不必要？
                    f[i] = Math.max(f[i], f[j] + a[i][2]);
                    j++;
                }
            }
            return Arrays.stream(f).max().getAsInt();
        }
        int [][] a;
        int binarySearch(int l, int r, int v) { // 找 v <= a[i][0] 的这个最左下标
            if (l > r) return -1;
            if (v <= a[l][0]) return l;
            // if (a[r][0] > v) return -1; // 【BUG:】这就是自己写的神搜索。。。
            while (l < r) {
                int m = (l + r) / 2;
                if (a[m][0] < v) l = m+1;
                else r = m;
            }
            return l >= 0 && l <= r && a[l][0] >= v ? l : -1;
        }

        public int stoneGameVIII(int[] a) { // 【记忆化深搜：】仍处在试着去理解这些 min-max 之类的题型，还是昏的 1872
            n = a.length; this.a = a;
            p = new int [n+1];
            for (int i = 0; i < n; i++) p[i+1] = p[i] + a[i];
            System.out.println(Arrays.toString(p));
            f = new Integer [n];
            return dfs(0);
        }
        Integer [] f;
        int [] a, p;
        int n;
        int dfs(int i) {
            System.out.println("\n i: " + i);
            if (i >= n-1) return 0;
            if (f[i] != null) return f[i];
            int r = 0, sum = a[i];
            for (int j = i+1; j < n; j++) {
                sum += a[j];
                a[j] = sum;
                // r = Math.max(r, p[j+1] - dfs(j+1));
                r = Math.max(r, sum - dfs(j));
            }
            System.out.println("\n i: " + i);
            System.out.println("r: " + r);
            return f[i] = r;
        }

        public int largestPathValue(String t, int[][] egs) { // 【动规：】这里动规的部分，与其它无向图记忆化深搜，感觉方向是反的，还没想透 1857
            int n = s.length(); int [] r = new int [n]; char [] s = t.toCharArray();
            List<Integer> [] g = new ArrayList [n];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1];
                g[u].add(v);
                r[v]++;
            }
            int [][] f = new int [n][26];
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++)
                if (r[i] == 0) {
                    q.offer(i);
                    f[i][s[i]-'a']++;
                    for (int v : g[i]) {
                        --r[v];
                        if (r[v] == 0) q.offer(v);
                        f[v][s[v]-'a']++;
                    }
                }
            if (q.isEmpty()) return -1; // 说明有环，有环就没有入度为 0 的节点
            while (!q.isEmpty()) {
                int u = q.poll();
                f[u][s[u]-'a']
            }
        }

        public int minimumDistance(String t) { // 1320: 我本来要【记忆化深搜】的，可是一看，它说让【暴搜】，想下感觉暴搜不该是天下最简单的事吗？
            n = t.length; s = t.toCharArray();
            f = new Integer [n][26][27];
            return dfs(0, 26, 26);
        }
        int n; char [] s;
        Integer [][][] f;
        int dfs(int i, int j, int k) {
            if (i == n) return 0;
            if (f[i][j][k] != null) return f[i][j][k];
        }        
        public int minimumDistance(String t) {// 1320: 我本来要【记忆化深搜】的，可是一看，它说让【暴搜】，想下感觉暴搜不该是天下最简单的事吗？
            int n = t.length(); char [] s = t.toCharArray(); int x = 5, y = 6;
            int [][][] f = new int [26][26][n];
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) Arrays.fill(f[i][j], Integer.MAX_VALUE);
            f[0][0][0] = 0;
            for (int i = 0; i < 26; i++) // 第一个手指头
                for (int j = 0; j < 26; j++) { // 第二个手指头
                    if (j == i) continue; // 不会笨到，两个手指头敲一个键吧。。。
                    for (int k = 0; k < n; k++) { // 第 k 个字符
                        int ii = (s[k] - 'A') / y, jj = (s[k] - 'A') % y;
                        int d = Math.abs(ii - i / y) + Math.abs(jj - i % y), dd = Math.abs(ii - j / y) + Math.abs(jj - j % y);
                        // System.out.println("\n (s[k]-'A): " + (s[k]-'A'));
                        // System.out.println("j: " + j);
                        // System.out.println("k: " + k);
                        if (d <= dd) f[s[k]-'A'][j][k] = Math.min(f[s[k]-'A'][j][k], (k == 0 ? 0 : f[i][j][k-1]) + d);
                        else f[i][s[k]-'A'][k] = Math.min(f[i][s[k]-'A'][k], (k == 0 ? 0 : f[i][j][k-1]) + dd);
                    }
                }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++)
                for (int j = 0; j < 26; j++)
                    ans = Math.min(ans, f[i][j][n-1]);
            return ans;
        }

        static final int mod = (int)1e9 + 7;
        public int countSpecialSubsequences(int[] a) { //【记忆化深搜：】试一下会超时吗？
            n = a.length; this.a = a;
            g = new ArrayList<>();
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int i = 0; i < n; i++)
                g[a[i]].add(i);
            f = new Integer [n][3];
            return dfs(0, 0);
        }
        Integer [][] f;
        List<Integer> [] g;
        int [] a; int n;
        int dfs(int i, int j) {
            if (i == n) return j > 2 ? 1 : 0;
            if (f[i][j] != null) return f[i][j];
            if (i > g[j].get(g[j].size()-1)) return f[i][j] = 0;
            int idx = binarySearch(i, j);
            long ans = 0;
            for (int k = idx; k < g[j].size(); k++) 
                ans = (ans + dfs(idx+1, j+1)) % mod;
        }
        int binarySearch(int v, int i) {
            List<Integer> li = g[i];
            int l = 0, r = l.size()-1;
            if (v <= li.get(0)) return 0;
            if (v > li.get(li.size()-1)) return -1;
            while (l < r) {
                int m = (l + r) / 2;
                if (li.get(m) < v) l = m+1;
                else r = m;
            }
            return l < li.size() && li.get(i) >= v ? l : -1;
        }
    }                                         
    public static void main (String[] args) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Solution s  =  new Solution ();

        String a = "CAKE";

        int r = s.minimumDistance(a);
        System.out.println("r: " + r);
    } 
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);  
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);


