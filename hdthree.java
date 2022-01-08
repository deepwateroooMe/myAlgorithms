import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toMap;

public class hdthree {
    public static class Solution {

        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) { // bug: 这里的顺序被我写得有点儿昏乎
            int n = profits.length;
            List<int []> p = new ArrayList<>();
            for (int i = 0; i < n; i++) 
                p.add(new int [] {profits[i], capital[i]});
            Collections.sort(p, (a, b)->a[1] - b[1]); // 按启动资金升序排列
            // for (int [] zz : p) 
            //     System.out.println(Arrays.toString(zz));
            Queue<int []> q = new PriorityQueue<>((x, y) -> y[0]-y[1] - x[0]+x[1]); // 按获得降序排列
            int max = 0, i = 0, j = 0;
            while (i < n) {
                System.out.println("\n i: " + i);
                j = i;
                while (j < n && p.get(j)[1] <= max) 
                    q.offer(p.get(j++));
                i = Math.min(j, i+1);
                System.out.println("max: " + max);
                System.out.println("k: " + k);
                while (!q.isEmpty() && k > 0) {
                    max = Math.max(max, max - q.peek()[1] + q.poll()[0]);
                    k--;
                }
            }
            return max;
        }

        List<Integer> ll = new ArrayList<>(); // all the values
        Map<Integer, Set<Integer>> idx = new HashMap<>();
        Random rand;
        public RandomizedCollection() {
            ll = new ArrayList<>(); // all the values
            idx = new HashMap<>();
            rand = new Random();
        }
        public boolean insert(int val) {
            boolean has = !idx.containsKey(val);
            ll.add(val);
            idx.computeIfAbsent(val, z -> new HashSet<>()).add(ll.size()-1);
            return has;
        }
        public boolean remove(int val) { // 当想要移掉一个数的时候，从下标set里移去任意第一个，并用链表ll的最后一个元素来填充替换链表中移去下标的数值 
            if (!idx.containsKey(val)) return false;
            Set<Integer> id = idx.get(val);
            int one = id.iterator().next();
            if (id.size() == 1) idx.remove(val); 
            else id.remove(one);
            int v = ll.get(ll.size()-1);
            if (one != ll.size()-1) { // 这里需要区分
                Set<Integer> idTwo = idx.get(v);
                int two = idTwo.iterator().next();
                idTwo.add(one);
                idTwo.remove(ll.size()-1);
                // if (idTwo.size() == 1) idx.remove(v); // BUG: 当把最后一个元素移动替换到删除元素位置，需要同步更新最后元素下标位置的set
                // else idTwo.remove(two);
                ll.set(one, v);
            }
            ll.remove(ll.size()-1); // 需要写在上面区分的外面
            return true;
        }
        public int getRandom() {
            return ll.get(rand.nextInt(ll.size()));
        }

        class BIT { // Binary Indexed Tree, Fenwick Tree // 这里有bug,今天晚点儿再回来改这个
            long [] tree;
            int [] a; // 从1开始
            int n;
            public BIT(int n) {
                this.n = n;
                this.tree = new long [n+1];
            }            
            public BIT(int [] arr) {
                this.n = arr.length + 1;
                this.tree = new long [n];
                this.a = Arrays.copyOf(arr, arr.length);
                long tmp = 0;
                for (int i = 1; i < n; i++) {
                    tmp = 0;
                    int lowbit = i & ((i - 1) ^ i);
                    for (int j = i; j > i - lowbit; j--) 
                        tmp = tmp + a[j-1];
                    tree[i] = tmp;
                }
                System.out.println(Arrays.toString(a));
                System.out.println(Arrays.toString(tree));
            }
            public int treeRange(int i, int j) { // inclusive: tree of a[i, j], includes a[i] and a[j]
                return (int)(tree(j) - tree(i-1));
            }
            long tree(int i) {
                long ans = 0;
                i++;
                while (i > 0 && i < n) {
                    ans += tree[i];
                    i = i - (i & ((i-1) ^ i));
                    // i -= lowBit(i);
                }
                return ans;
            }
            void update(int i, int v) { // O(logN)
                int dif = v - a[i];   // 从1开始
                a[i] = v;
                i += 1;
                for (; i < n; i = i + (i & ((i-1) ^ i)))
                    tree[i] += dif;
                // while (i+1 < a.length) {
                //     tree[i+1] += dif;
                //     i += lowBit(i);
                // }
            }
            int lowBit(int n) { // ???
                return n & (-n);
            }
        }
        public int countRangeSum(int[] a, int lower, int upper) { // 有bug，换个方法先写出来
            int n = a.length;
            // if (n == 1) return a[0] <= upper && a[0] >= lower ? 1 : 0;
            BIT bit = new BIT(a);
            int cnt = 0;
            for (int i = 0; i < n; i++) 
                for (int j = i; j < n; j++) {
                    System.out.println("\n i: " + i);
                    System.out.println("j: " + j);
                    long tree = bit.treeRange(i, j+1);
                    System.out.println("tree: " + tree);
                    if (tree >= lower && tree <= upper) ++cnt;
                }
            return cnt;
        }
        public int countRangeSum(int[] a, int lower, int upper) { // bug
            n = a.length;
            sum = new long [n];
            for (int i = 0; i < n; i++) 
                sum[i] = (i == 0 ? 0 : sum[i-1]) + a[i];
            return getCnt(upper) - getCnt(lower-1);
        }
        long [] sum;
        int n;
        int getCnt(int v) {
            int cnt = 0;
            Map<Long, Integer> m = new HashMap<>();
            m.put(0l, 1); // v == 0 ?
            for (int i = 0; i < n; i++) {
                if (sum[i] < v) // 键里存的所有的key,构成的子片段都会小
                    cnt += m.values().stream().reduce(0, Integer::sum);
                else if (sum[i] >= v && m.containsKey(sum[i] - v))
                    cnt += m.get(sum[i] - v);
                m.put(sum[i], m.getOrDefault(sum[i], 0) + 1);
            }
            return cnt;
        }

        public int trapRainWater(int[][] a) { // BFS
            int m = a.length, n = a[0].length;
            Queue<int []> q = new PriorityQueue<>((x, y) -> x[2] - y[2]); // int []: [i, j, a[i][j]] 按照高度由矮到高
            boolean [][] vis = new boolean [m][n];
            for (int j = 0; j < n; j++) { // 把外围一圈的格子先加进去，然后由外向内遍历
                q.offer(new int [] {0, j, a[0][j]});
                q.offer(new int [] {m-1, j, a[m-1][j]});
                vis[0][j] = true;
                vis[m-1][j] = true;
            }
            for (int i = 0; i < m; i++) {
                q.offer(new int [] {i, 0, a[i][0]});
                q.offer(new int [] {i, n-1, a[i][n-1]});
                vis[i][0] = true;
                vis[i][n-1] = true;
            }
            int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int max = 0, ans = 0;
            while (!q.isEmpty()) {
                int [] cur = q.poll();
                max = Math.max(max, cur[2]); // 纪录海平面的高度，
                for (int [] d : dirs) {
                    int i = cur[0] + d[0], j = cur[1] + d[1];
                    if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) continue;
                    vis[i][j] = true;
                    if (a[i][j] < max) // 同外围向内遍历，如果有比海平面低的格，那是可以装水的
                        ans += max - a[i][j];
                    q.offer(new int [] {i, j, a[i][j]});
                }
            }
            return ans;
        }

        Map<Integer, Set<String>> idx; // k,v: cnt, strstr
        Map<String, Integer> cnt; // k,v: string, cnt
        TreeSet<Integer> ts = new TreeSet<>((a,b)->a-b);
        public AllOne() { // 今天早上脑袋不够清醒，就多写几个设计题，写这种也是写得留了不少bug
            idx = new HashMap<>();
            cnt = new HashMap<>();
        }
        public void inc(String key) {
            if (!cnt.containsKey(key)) {
                cnt.put(key, 1);
                idx.computeIfAbsent(1, z -> new HashSet<>()).add(key);
                ts.add(1);
            } else {
                int v = cnt.get(key);
                cnt.put(key, v+1);
                idx.get(v).remove(key); // 没有移彻底的， idx: [v, 0]: 以后还是需要第一次写的时候就想清楚，不移彻底可能会出现哪些情况bug，最好是能一次写到位
                if (idx.get(v).size() == 0) {
                    idx.remove(v); // BUG
                    ts.remove(v);
                }
                idx.computeIfAbsent(v+1, z -> new HashSet<>()).add(key);
                ts.add(v+1);
            }
        }
        public void dec(String key) {
            int v = cnt.get(key);
            idx.get(v).remove(key);
            if (v == 1) cnt.remove(key);
            else cnt.put(key, v-1); //
            if (idx.get(v).size() == 0) {
                idx.remove(v); // BUG
                ts.remove(v);
            }
            if (v > 1) {
                if (!idx.containsKey(v-1)) {
                    ts.add(v-1);
                    idx.put(v-1, new HashSet<>());
                } 
                idx.get(v-1).add(key);
            }
        }
        public String getMaxKey() {
            if (ts.size() == 0) return "";
            return idx.get(ts.last()).iterator().next();
        }
        public String getMinKey() {
            if (ts.size() == 0) return "";
            return idx.get(ts.first()).iterator().next();
        }

        static final int mod = 1337;
        public int largestPalindrome(int n) { // bug: 不知道哪里错了
            if (n == 1) return 9;
            int l = (int)Math.pow(10, n-1), r = (int)Math.pow(10, n)-1;
            // long ll = (int)Math.pow(10, 2*n-1), rr = (int)Math.pow(10, 2*n); // 遍历含有太多杂数，复杂度太高
            for (int i = r; i >= l; i--) {
                long cur = buildPalindrome(i); // 生成回文串反而来得更快
                for (long j = r; j * j >= cur; j--) // cur / j 的最大值是 sqrt(cur)
                    if (cur % j == 0)
                        return (int)(cur % mod);
            }
            return -1;
        }
        long buildPalindrome(int n) {
            String s = ""+n, t = new StringBuilder(s).reverse().toString();
            return Long.parseLong(s + t);
        }

        public int reversePairs(int[] a) { // bug
            int n = a.length, cnt = 0;
            TreeMap<Integer, Integer> m = new TreeMap<>();
            m.put(a[n-1], 1);
            for (int i = n-2; i >= 0; i--) {
                int v = a[i] / 2;
                Integer lo = m.lowerKey(v); // 还需要 <= lo的treemap所有值的和
                // ;
                m.put(a[i], m.getOrDefault(a[i], 0) + 1);
            }
            return cnt;
        }

        public boolean judgePoint24(int[] a) {
            int n = a.length;
            List<Double> l = new ArrayList<>();
            for (Integer v : a) l.add((double)v);
            helper(l);
            return ans;
        }
        double eps = 0.001; //
        boolean ans = false; 
        void helper(List<Double> l) {
            if (ans) return ;
            if (l.size() == 1) {
                if (Math.abs(l.get(0) - 24) < eps) 
                    ans = true;
                return ;
            }
            for (int i = 0; i < l.size(); i++) // 0 / 1
                for (int j = 0; j < i; j++) {
                    double x = l.get(i), y = l.get(j);
                    // List<Integer> tmp = new ArrayList<>(Arrays.asList({x+y, x-y, x*y, y-x}));
                    Double [] a = {x+y, x-y, x*y, y-x};
                    List<Double> tmp = new ArrayList<>(Arrays.asList(a));
                    if (x > eps) tmp.add(y / x); // 保证除数不为0
                    if (y > eps) tmp.add(x / y);
                    l.remove(i);
                    l.remove(j);
                    for (double d : tmp) {
                        l.add(d);
                        helper(l);
                        l.remove(l.size()-1);
                    }
                    l.add(j, y);
                    l.add(i, x);
                }
        }
        public boolean judgePoint24(int[] arr) {
            int n = arr.length;
            List<Double> a = new ArrayList<>();
            for (int i = 0; i < n; i++) 
                a.add((double)arr[i]);
            return helper(a);
        }
        List<Character> sn = List.of('+', '-', '*', '/');
        double eps = 0.001; //
        boolean helper(List<Double> l) {
            if (l.size() == 1) return Math.abs(l.get(0) - 24) < eps;
            for (int i = 0; i < l.size(); i++) 
                for (int j = 0; j < l.size(); j++) {
                    if (i == j) continue;
                    List<Double> tmp = new ArrayList<>();
                    for (int k = 0; k < l.size(); k++) 
                        if (k != i && k != j) tmp.add(l.get(k));
                    for (char o : sn) {
                        if ((o == '+' || o == '*') && i > j) continue;
                        if (o == '/' && l.get(j) < eps) continue; // 除娄不能为0
                        switch (o) {
                        case '+': tmp.add(l.get(i) + l.get(j)); break;
                        case '-': tmp.add(l.get(i) - l.get(j)); break;
                        case '*': tmp.add(l.get(i) * l.get(j)); break;
                        case '/': tmp.add(l.get(i) / l.get(j)); break;
                        }
                        if (helper(tmp)) return true;
                        tmp.remove(tmp.size()-1);
                    }
                }
            return false;
        }

        public int[] hitBricks(int[][] g, int[][] h) {
            m = g.length;
            n = g[0].length;
            for (int [] v : h)
                if (g[v[0]][v[1]] == 1)
                    g[v[0]][v[1]] = 2;
            uf = new UnionFind(m*n+1); // 为什么要多加1个: 用 m*n 连个顶儿
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++)
                    if (g[i][j] == 1) unionAround(i, j, g);
            int [] ans = new int [h.length];
            int sum = uf.cnt[uf.find(m*n)]; // 最终剩下的砖数
            for (int i = h.length-1; i >= 0; i--) {
                int [] v = h[i];
                if (g[v[0]][v[1]] == 2) {
                    unionAround(v[0], v[1], g);
                    g[v[0]][v[1]] = 1; // 1: 被敲掉的砖不能放在结果里
                }
                int cnt = uf.cnt[uf.find(m*n)];
                ans[i] = (cnt - sum > 0 ? cnt - sum - 1 : 0);
                sum = cnt;
            }
            return ans;
        }
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        UnionFind uf;
        int m, n;
        void unionAround(int i, int j, int [][] a) {
            for (int [] d : dirs) {
                int x = i + d[0], y = j + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                if (a[x][y] == 1) uf.union(i*n+j, x*n+y);
            }
            if (i == 0) uf.union(i*n+j, m*n); // 为了方便写代码，跟最后一个 m*n 连,其实跟0跟m*n连没区别
        }
        class UnionFind {
            int [] id; // parent
            int [] cnt;// size
            public UnionFind (int n) {
                id = new int [n];
                cnt = new int [n];
                for (int i = 0; i < n; i++) {
                    id[i] = i;
                    cnt[i] = 1;
                }
            }
            public int find(int i) {
                while (id[i] != i) {
                    id[i] = id[id[i]];
                    i = id[i];
                }
                return i;
            }
            public void union(int i, int j) {
                int rootI = find(i);
                int rootJ = find(j);
                if (rootI != rootJ) {
                    id[rootI] = rootJ;
                    cnt[rootJ] += cnt[rootI];
                }
            }
        }

        public int rectangleArea(int[][] rectangles) {
            ll = new ArrayList<>();
            long ans = 0;
            for (int [] r : rectangles) 
                addRect(r, 0);
            for (int [] r : ll) 
                ans = (ans + (long)(r[2] - r[0]) * (long)(r[3] - r[1])) % mod;
            return (int)ans;
        }        
        static final int mod = (int)1e9 + 7;
        List<int []> ll;
        void addRect(int [] a, int i) { // i: idx
            if (i >= ll.size()) {
                ll.add(a);
                return ;
            }
            int [] r = ll.get(i);
            if (a[2] <= r[0] || a[0] >= r[2] || a[1] >= r[3] || a[3] <= r[1]) { // 被添加的，与现遍历的矩形，完全没有交集，直接往后遍历
                addRect(a, i+1);
                return ;
            } // 找出所有有交集的、交集部分——与现遍历矩形相比，多出来的部分，的四个顶点，再往后遍历
            if (a[0] < r[0]) // 左
                addRect(new int [] {a[0], a[1], r[0], a[3]}, i+1);
            if (a[2] > r[2]) // 右
                addRect(new int [] {r[2], a[1], a[2], a[3]}, i+1);
            if (a[1] < r[1]) // 下: 新增矩形 下侧 也可以有 交叠：注意左侧、右侧前面已经加进去了，现在只加中间部分，不要重复计算
                addRect(new int [] {Math.max(a[0], r[0]), a[1], Math.min(a[2], r[2]), r[1]}, i+1);
            if (a[3] > r[3]) // 上: 新增矩形 上侧 也可以有 交叠：注意左侧、右侧、下侧 前面已经加进去了，现在只加中间部分，不要重复计算
                addRect(new int [] {Math.max(a[0], r[0]), r[3], Math.min(a[2], r[2]), a[3]}, i+1);
        }

        public int shortestPathAllKeys(String [] a) { // 居然被我一遍写对了：开始写的时候还有点儿不是很清楚
            m = a.length;
            n = a[0].length();
            int target = 0, si = 0, sj = 0;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) {
                    char c = a[i].charAt(j);
                    if (c == '@') {
                        si = i;
                        sj = j;
                    } else if (Character.isLowerCase(c))
                        target |= 1 << (c - 'a');
                }
            return bfs(si, sj, target, a);
        }
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m, n;
        int bfs(int x, int y, int target, String [] a) {
            Set<String> vis = new HashSet<>(); // 重点是：这个走过的状态里是需要包含所取得得钥匙的信息的
            Queue<int []> q = new LinkedList<>();
            int [] tmp = {x, y, 0};
            q.offer(tmp);
            vis.add(Arrays.toString(tmp));
            int cnt = 0, mask = 0;
            while (!q.isEmpty()) {
                for (int z = q.size()-1; z >= 0; z--) {
                    int [] cur = q.poll();
                    char c = a[cur[0]].charAt(cur[1]);
                    mask = cur[2];
                    if (Character.isLowerCase(c)) {
                        mask |= (1 << (c - 'a'));
                        if (mask == target) return cnt;
                    }
                    for (int [] d : dirs) {
                        int i = cur[0] + d[0], j = cur[1] + d[1];
                        if (i < 0 || i >= m || j < 0 || j >= n || a[i].charAt(j) == '#') continue;
                        char next = a[i].charAt(j);
                        int [] tpp = new int [] {i, j, mask} ;
                        String key = Arrays.toString(tpp);
                        if (vis.contains(key)) continue;
                        if (Character.isUpperCase(next) && (mask & (1 << (next - 'A'))) == 0) continue;
                        q.offer(tpp);
                        vis.add(key);
                    }
                }
                cnt++;
            }
            return -1;
        }

        public int superpalindromesInRange(String left, String right) { // 这个题还要好好再看看，竟然又写错了一次
            long l = Long.parseLong(left), r = Long.parseLong(right);
            helper("", l, r); // 生成长度为偶数的
            for (char c = '0'; c <= '9'; c++) 
                helper(""+c, l, r); // 生成长度为奇数的
            return cnt;
        }
        int cnt = 0;
        void helper(String s, long l, long r) {
            if (s.length() > 9) return ;
            if (!s.isEmpty() && s.charAt(0) != '0') {
                long v = Long.parseLong(s);
                v *= v;
                if (v > r) return ;
                if (v >= l && isPalindrom(v))
                    cnt++;
            }
            for (char c = '0'; c <= '9'; c++) 
                helper(String.valueOf(c) + s + String.valueOf(c), l, r);
        }
        boolean isPalindrom(long v) {
            long ans = 0, tmp = v;
            while (v > 0) {
                ans = ans * 10 + v % 10;
                v /= 10;
            }
            return ans == tmp;
        }

         public int shortestSubarray(int[] a, int k) { // bug: 不知道这里哪里没有想对
            int n = a.length, min = Integer.MAX_VALUE;
            long sum = 0;
            TreeMap<Long, Integer> m = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                sum += a[i];
                if (sum >= k) {
                    min = Math.min(min, i+1);
                    Long lo = m.lowerKey(sum - k);
                    if (lo != null)
                        min = Math.min(min, i - m.get(lo));
                }
                m.put(sum, i);
            }
            return min == Integer.MAX_VALUE ? -1 : min;
        }

         public int countTriplets(int[] a) { // tle
            int n = a.length, cnt = 0;
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) 
                    for (int k = 0; k < n; k++) 
                        if ((a[i] & a[j] & a[k]) == 0)
                            cnt++;
                        return cnt;
        }
        public int countTriplets(int[] a) {
            int n = a.length, cnt = 0;
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) {
                    int v = (a[i] & a[j]);
                    m.put(v, m.getOrDefault(v, 0) + 1);
                }
            for (int i = 0; i < n; i++) 
                for (Integer key : m.keySet()) 
                    if ((a[i] & key) == 0)
                        cnt += m.get(key);
            return cnt;
        }
        public int countTriplets(int[] a) {
            int n = a.length, r = 1 << 16, v = 0, ans = 0;
            int [] cnt = new int [r];
            Arrays.fill(cnt, -1);
            for (Integer i : a) 
                for (Integer j : a) {
                    v = i & j;
                    if (cnt[v] == -1) {
                        cnt[v] = 0;
                        for (Integer k : a) 
                            if ((v & k) == 0) ++cnt[v];
                    }
                    ans += cnt[v];
                }
            return ans;
        }

        public int [] gridIllumination(int n, int[][] a, int[][] q) { 
            int [][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
            int m = q.length;
            Map<Integer, Integer> r = new HashMap<>(); // row
            Map<Integer, Integer> c = new HashMap<>(); // col
            Map<Integer, Integer> d = new HashMap<>(); // dia: i-j
            Map<Integer, Integer> t = new HashMap<>(); // anti-dia i+j
            Set<Integer> cnt = new HashSet<>();
            for (int [] v : a) {
                int i = v[0] * n + v[1];
                if (cnt.contains(i)) continue;
                r.put(v[0], r.getOrDefault(v[0], 0) + 1);
                c.put(v[1], c.getOrDefault(v[1], 0) + 1);
                d.put(v[0]+v[1], d.getOrDefault(v[0]+v[1], 0) + 1);
                t.put(v[0]-v[1], t.getOrDefault(v[0]-v[1], 0) + 1);
                cnt.add(i);
            }
            int [] ans = new int [m];
            for (int k = 0; k < q.length; k++) {
                int i = q[k][0], j = q[k][1];
                if (r.containsKey(i) || c.containsKey(j) || d.containsKey(i+j) || t.containsKey(i-j))
                    ans[k] = 1;
                for (int [] di : dirs) {
                    int x = i + di[0], y = j + di[1], idx = 0;
                    if (x < 0 || x >= n || y < 0 || y >= n) continue;
                    idx = x * n + y;
                    if (!cnt.contains(idx)) continue;
                    cnt.remove(idx);
                    r.put(x, r.getOrDefault(x, 1)-1);
                    c.put(y, c.getOrDefault(y, 1)-1);
                    d.put(x+y, d.getOrDefault(x+y, 1)-1);
                    t.put(x-y, t.getOrDefault(x-y, 1)-1);
                    if (r.getOrDefault(x, 0) == 0) r.remove(x);
                    if (c.getOrDefault(y, 0) == 0) c.remove(y);
                    if (d.getOrDefault(x+y, 0) == 0) d.remove(x+y);
                    if (t.getOrDefault(x-y, 0) == 0) t.remove(x-y);
                }
            }
            return ans;
        }

        public boolean isEscapePossible(int[][] b, int[] s, int[] t) {
            n = b.length;
            if (n == 0) return true;
            for (int [] v : b) {
                long i = v[0] * N + v[1];
                idx.add(i);
            }
            if (!bfs(s[0], s[1], t)) return false; // 这个细节需要注意
            vis.clear();
            return bfs(t[0], t[1], s);
        }
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<Long> idx = new ArrayList<>();
        Set<Long> vis = new HashSet<>();
        long N = 1000000;
        int n;
        boolean bfs(int x, int y, int [] tar) {
            Queue<int []> q = new LinkedList<>();
            q.offer(new int [] {x, y});
            vis.add(x * N + y);
            while (!q.isEmpty()) {
                int cur [] = q.poll(), i = cur[0], j = cur[1];
                for (int [] d : dirs) {
                    int s = i + d[0], t = j + d[1];
                    if (s < 0 || s >= N || t < 0 || t >= N) continue;
                    long ss = s * N + t ;
                    if (idx.contains(ss) || vis.contains(ss)) continue;
                    if (s == tar[0] && t == tar[1]) return true;
                    q.offer(new int [] {s, t});
                    vis.add(ss);
                }
                if (q.size() > n) return true; // 这个标准不记得了
            }
            return false;
        }

          
    StringBuilder sb = new StringBuilder();
    Trie t = new Trie();
    public StreamChecker(String[] words) { 
        for (String v : words) t.insert(v);
    }
    public boolean query(char letter) { // 去搜trie: 需要一个数据结构来纪录字符序列
        sb.append(letter);
        return t.search(sb);
    }
    private static class Trie { 
        private class Node {
            boolean f;
            Node [] next;
            public Node() {
                f = false;
                next = new Node[26];
            }
        }
        Node root;
        public Trie() {
            root = new Node();
        }
        public boolean search(StringBuilder s) {
            Node r = root;
            for (int i = s.length()-1; i >= 0; i--) {
                int idx = s.charAt(i) - 'a';
                if (r.next[idx] == null) return false;
                if (r.next[idx].f) return true;
                r = r.next[idx];
            }
            return r.f;
        }
        public void insert(String t) { // 插入当前单词的倒序
            char [] s = t.toCharArray();
            Node r = root;
            for (int i = s.length-1; i >= 0; i--) {
                int j = s[i] - 'a';
                if (r.next[j] == null)
                    r.next[j] = new Node();
                r = r.next[j];
            }
            r.f = true;
        }            
    }

        interface MountainArray {
            *     public int get(int index) {}
            *     public int length() {}
            * }
        public int findInMountainArray(int t, MountainArray ma) { // bug
            int n = ma.length(), idx = binarySearchPeek(ma, n);
            System.out.println("idx: " + idx);
            if (t == ma.get(idx)) return idx;
            int l = binarySearchTarget(ma, 0, idx-1, t, true);
            System.out.println("l: " + l);
            if (l != -1) return l;
            return binarySearchTarget(ma, idx+1, n-1, t, false);
        }
        int binarySearchTarget(MountainArray a, int l, int r, int v, boolean onLeft) {
            if (onLeft && (v < a.get(l) || v > a.get(r))
                || !onLeft && (v > a.get(l) || v < a.get(r))) return -1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (a.get(m) == v) return m;
                if (onLeft) {
                    if (a.get(m) > v) r = m-1;
                    else l = m+1;
                } else if (a.get(m) > v) l = m+1;
                else r = m-1;
            }
            return l;
        }
        int binarySearchPeek(MountainArray a, int n) {
            int l = 0, r = n-1;
            while (l <= r - 2) {
                int m = (l + r) / 2;
                if (a.get(m-1) < a.get(m) && a.get(m) > a.get(m+1)) return m;
                else if (a.get(m-1) < a.get(m) && a.get(m) < a.get(m+1)) l = m;
                else r = m-1;
            }
            return l;
        }

        public int[] canSeePersonsCount(int[] a) {
            int n = a.length, ans [] = new int [n];
            ArrayDeque<Integer> s = new ArrayDeque<>(); // 单调递减栈
            s.offerLast(a[n-1]);
            for (int i = n-2; i >= 0; i--) {
                while (!s.isEmpty() && s.peekLast() < a[i]) {
                    s.pollLast();
                    ans[i]++;
                }
                if (!s.isEmpty()) ans[i]++;
                s.offerLast(a[i]);
            }
            return ans;
        }

        public int[][] matrixRankTransform(int[][] mat) {
            final int row = mat.length;
            final int col = mat[0].length;
            //对每个坐标状态压缩(state = i * col + j)
            Integer[] indexs = new Integer[row * col];
            for (int i = 0; i < indexs.length; i++) 
                indexs[i] = i;
            //对坐标点根据mat的值进行排序。
            Arrays.sort(indexs, new Comparator<Integer>() {
                    @Override
                        public int compare(Integer t1, Integer t2) {
                        return mat[t1 / col][t1 % col] - mat[t2 / col][t2 % col];
                    }
                });
            int[] minRows = new int[row]; //第i行的秩号序列，第i行下一个秩号需要大于等于此cell([i, minRows[i]])的值
            int[] minCols = new int[col]; //第j列的秩号序列，第j列下一个秩号需要大于等于此cell([minCols[j], j])的值
            Arrays.fill(minRows, -1);
            Arrays.fill(minCols, -1);
            int[] leaders = new int[row * col]; //并查集，表示同行或同列的同样值串起来的一个集合。
            int[] leaderVals = new int[row * col]; //并查集leader的对应的秩号值。
            for (int i = 0; i < leaders.length; i++) 
                leaders[i] = i;
            int pos = 0;
            while (pos < indexs.length) {
                int val = 1;
                int index = indexs[pos];
                //排序后的第pos个单元格
                int i = index / col;
                int j = index % col;
                int tmpIndex;
                int tmpVal;
                //第i行应该分配的下一个秩号
                if (minRows[i] != -1) {
                    tmpIndex = i * col + minRows[i];
                    int leaderIndex = getLeader(leaders, tmpIndex);
                    tmpVal = leaderVals[leaderIndex];
                    if (mat[i][j] == mat[i][minRows[i]]) {
                        //如果i行有相同的值，合并并查集
                        mergeLeader(leaders, index, tmpIndex);
                        val = Math.max(val, tmpVal);
                    } else {
                        val = Math.max(val, tmpVal + 1);
                    }
                }
                //第j列应该分配的下一个秩号
                if (minCols[j] != -1) {
                    tmpIndex = minCols[j] * col + j;
                    int leaderIndex = getLeader(leaders, tmpIndex);
                    tmpVal = leaderVals[leaderIndex];
                    if (mat[i][j] == mat[minCols[j]][j]) {
                        //如果j列有相同的值，合并并查集
                        mergeLeader(leaders, index, tmpIndex);
                        val = Math.max(val, tmpVal);
                    } else {
                        val = Math.max(val, tmpVal + 1);
                    }
                }
                //val = Math.max(val, ...)是取i行下一个秩号 和 j列下一个秩号 的较大值
                //更新i行和j列秩号序列。此时[i, j]为i行和j列的最大秩号
                minRows[i] = j;
                minCols[j] = i;
                //更新并查集的秩号
                int leader = getLeader(leaders, index);
                leaderVals[leader] = val;
                pos++;
            }
            //将秩号结果由并查集导出到数组ans
            int[][] ans = new int[row][col];
            for (int i = 0; i < row; i++) 
                for (int j = 0; j < col; j++) {
                    int index = i * col + j;
                    ans[i][j] = leaderVals[getLeader(leaders, index)];
                }
            return ans;
        }
        private void mergeLeader(int[] leaders, int index, int tmpIndex) {
            int leader1 = getLeader(leaders, index);
            int leader2 = getLeader(leaders, tmpIndex);
            if (leader1 != leader2) 
                leaders[leader1] = leader2;
        }
        private int getLeader(int[] leaders, int tmpIndex) {
            int leader = leaders[tmpIndex];
            if (leader == leaders[leader]) {
                return leader;
            } else {
                return leaders[tmpIndex] = getLeader(leaders, leader);
            }
        }
        public int[][] matrixRankTransform(int[][] mat) { // 这个题没有思路
            int m = mat.length, n = mat[0].length;
        }

        public int minimumMoves(int[][] g) {
            int [][] dirs = {{1, 0}, {0, 1}};
            int n = g.length, cnt = 0, target [] = {n-1, n-2, n-1, n-1};
            boolean [][][][] vis = new boolean [n][n][n][n]; // 可以写成三维的，但目前四给的比较直观，就暂时先这样吧
            Queue<int []> q = new LinkedList<>();
            q.offer(new int [] {0, 0, 0, 1});;
            vis[0][0][0][1] = true;
            while (!q.isEmpty()) {
                for (int z = q.size()-1; z >= 0; z--) {
                    int [] cur = q.poll();
                    int i = cur[0], j = cur[1], x = cur[2], y = cur[3];
                    if (Arrays.equals(cur, target)) return cnt;
                    if (y < n-1) { // 可能 可以向右移
                        if (i == x && g[x][y+1] != 1 && !vis[i][y][i][y+1]) {
                            q.offer(new int [] {i, y, i, y+1});
                            vis[i][y][i][y+1] = true;
                        } else if (j == y && g[i][j+1] != 1 && g[x][y+1] != 1 && !vis[i][j+1][x][y+1]) {
                            q.offer(new int [] {i, j+1, x, y+1});
                            vis[i][j+1][x][y+1] = true;
                        }
                    }
                    if (x < n-1) { // 可能 可以向下移
                        if (i == x && g[i+1][j] != 1 && g[x+1][y] != 1 && !vis[i+1][j][x+1][y]) { // 小蛇 横躺着
                            q.offer(new int [] {i+1, j, x+1, y});
                            vis[i+1][j][x+1][y] = true;
                        } else if (j == y && g[x+1][y] != 1 && !vis[x][y][x+1][y]) {
                            q.offer(new int [] {x, y, x+1, y});
                            vis[x][y][x+1][y] = true;
                        }
                    }
                    if (i == x && x < n-1) // 横躺着：顺时针方向旋转
                        if (g[i+1][j] != 1 && g[x+1][y] != 1 && !vis[i][j][i+1][j]) {
                            q.offer(new int [] {i, j, i+1, j});
                            vis[i][j][i+1][j] = true;
                        }
                    if (j == y && y < n-1) // 竖躺着：逆时针方向旋转
                        if (g[i][j+1] != 1 && g[x][y+1] != 1 && !vis[i][j][i][j+1]) {
                            q.offer(new int [] {i, j, i, j+1});
                            vis[i][j][i][j+1] = true;
                        }
                }
                cnt++;
            }
            return -1;
        }

        static final int mod = (int)1e9 + 7, N = (int)1e5+1;
        public int sumOfFlooredPairs(int [] a) {
            int n = a.length;
            int [] cnt = new int [N];
            for (Integer v : a) cnt[v]++;
            for (int i = 1; i < N; i++) cnt[i] += cnt[i-1]; // 求前缀和
            long ans = 0;
            for (int i = 1; i < N; i++)
                if (cnt[i] > cnt[i-1]) {
                    long sum = 0;
                    for (int j = 1; j*i < N; j++) {
                        int l = i * j - 1, r = i * (j + 1) - 1; // [l, r]范围内所有数的个数 * 当前倍数
                        sum += (cnt[Math.min(r, N-1)] - cnt[l]) * (long)j;
                    }
                    ans = (ans + (sum % mod) * (cnt[i] - cnt[i-1])) % mod;
                }
            return (int)ans;
        }

         public int numPoints(int[][] points, int r) { // bug: 不知道哪里写错了
            int n = points.length, cnt = 0, max = 0;
            for (int i = 0; i < n; i++) 
                for (int j = i+1; j < n; j++) {
                    int [] x = points[i], y = points[j];
                    long pp = (long)Math.pow(x[0] - y[0], 2) + (long)Math.pow(x[1] - y[1], 2);
                    if (pp < (long)r * r) continue;
                    if (pp == (long)r * r) {
                        double oi = (x[0] + y[0]) / 2.0, oj = (x[1] + y[1]) / 2.0;
                        cnt = getCnts(points, oi, oj, r);
                        max = Math.max(max, cnt);
                    } else {
                        int dx = x[0] - y[0], dy = x[1] - y[1];
                        double oi = (x[0]+y[0])/2.0 + (x[1]-y[1])*Math.sqrt(r*r/((x[0]-y[0])*(x[0]-y[0]) + (x[1]-y[1])*(x[1]-y[1]))-0.25);
                        double oj = (x[1]+y[1])/2.0 + (y[0]-x[0])*Math.sqrt(r*r/((x[0]-y[0])*(x[0]-y[0]) + (x[1]-y[1])*(x[1]-y[1]))-0.25);
                        cnt = getCnts(points, oi, oj, r);
                        max = Math.max(max, cnt);
                        dx = y[0] - x[0];
                        dy = y[1] - x[1];
                        oi = (x[0]+y[0])/2.0 + (x[1]-y[1])*Math.sqrt(r*r/((x[0]-y[0])*(x[0]-y[0]) + (x[1]-y[1])*(x[1]-y[1]))-0.25);
                        oj = (x[1]+y[1])/2.0 + (y[0]-x[0])*Math.sqrt(r*r/((x[0]-y[0])*(x[0]-y[0]) + (x[1]-y[1])*(x[1]-y[1]))-0.25);
                        cnt = getCnts(points, oi, oj, r);
                        max = Math.max(max, cnt);
                    }
                }
            return max;
        }
        // void getCenter(double x1, double y1, double x2, double y2, double R, double &x, double &y) {
        //     x = (x1+x2)/2.0 + (y1-y2)*sqrt(R*R/((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2))-0.25);
        //     y = (y1+y2)/2.0 + (x2-x1)*sqrt(R*R/((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2))-0.25);
        // }
        double eps = 0.001;
        int getCnts(int [][] a, double i, double j, int r) {
            int cnt = 0;
            for (int [] p : a) {
                if (Math.abs(p[0] - i) - eps > r || Math.abs(p[1] - j) - eps > r) continue;
                if (Math.abs(Math.pow(p[0] - i, 2) + Math.pow(p[1] - j, 2) - r*r) < eps) cnt++;
            }
            return cnt;
        }

        public int minDays(int[][] g) { // bug
            m = g.length;
            n = g[0].length;
            uf = new UnionFind(m*n);
            int cnt = 0;
            boolean hasOne = false;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    if (g[i][j] == 1) {
                        hasOne = true;
                        unionAround(i, j, g);
                        cnt++;
                    }
            if (uf.getCnt() == m * n) return hasOne ? 1 : 0; // 
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    if (g[i][j] == 1) {
                        g[i][j] = 0;
                        uf = new UnionFind(m*n);
                        for (int x = 0; x < m; x++) 
                            for (int y = 0; y < n; y++) 
                                if (g[x][y] == 1)
                                    unionAround(x, y, g);
                        System.out.println("uf.getCnt(): " + uf.getCnt());
                        if (uf.getCnt() > m * n - (cnt-1) + 1) return 1; //  && cnt -1 > 1
                        g[i][j] = 1;
                    }
            return 2;
        }
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        UnionFind uf;
        int m, n;
        void unionAround(int i, int j, int [][] a) {
            for (int [] d : dirs) {
                int x = i + d[0], y = j + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || a[x][y] == 0) continue;
                uf.union(i*n+j, x*n+y);
            }
        }
        class UnionFind {
            int [] id; // parent
            int [] cnt;// size
            public UnionFind (int n) {
                id = new int [n];
                cnt = new int [n];
                for (int i = 0; i < n; i++) {
                    id[i] = i;
                    cnt[i] = 1;
                }
            }
            public int getCnt() {
                for (int i = 0; i < id.length; i++) 
                    find(i);
                Set<Integer> sp = new HashSet<>();
                for (int i = 0; i < id.length; i++) 
                    sp.add(id[i]);
                return sp.size();
            }
            public int find(int i) {
                while (id[i] != i) {
                    id[i] = id[id[i]];
                    i = id[i];
                }
                return i;
            }
            public void union(int i, int j) {
                int rootI = find(i);
                int rootJ = find(j);
                if (rootI != rootJ) {
                    id[rootI] = rootJ;
                    cnt[rootJ] += cnt[rootI];
                }
            }
        }

        public List<String> maxNumOfSubstrings(String t) { // undone: 今天有点儿头痛，读不懂题目要求返回的是什么
            int n = t.length();
            char [] s = t.toCharArray();
            int [] bgn = new int [26]; // 记每个字母第一次出现的位置
            int [] end = new int [26]; // 记每个字母最后一次出现的位置
            Arrays.fill(bgn, -1);
            Arrays.fill(end, -1);
            for (int i = 0; i < n; i++) {
                int j = s[i] - 'a';
                if (bgn[j] == -1) bgn[j] = i;
                else end[j] = i;
            }
            System.out.println(Arrays.toString(bgn));
            System.out.println(Arrays.toString(end));
            List<String> ans = new ArrayList<>();
            return ans;
        }

        public boolean isTransformable(String ss, String tt) {  // bug: 这里没读懂题目，遍历、建立的方向弄反了：应该是从尾巴向头建立，而不是从头到尾
            int n = ss.length(), i = 0, j = 0;
            char [] s = ss.toCharArray(), tmp = Arrays.copyOf(s, n);
            Arrays.sort(tmp);
            if (new String(tmp).equals(ss)) return false;
            char [] t = tt.toCharArray();
            while (i < n && s[i] == t[i]) i++;
            if (i == n) return true;
            j = i;
            while (j < n && s[j] != t[i]) j++;
            if (j == n) return false;
            tmp = ss.substring(i, j+1).toCharArray();
            Arrays.sort(tmp);
            String sp = ss.substring(0, i) + new String(tmp) + ss.substring(j+1);
            i++;
            s = sp.toCharArray();
            while (i < n && s[i] == t[i]) i++;
            if (i == n) return true;
            return isTransformable(sp.substring(i), tt.substring(i));
        }

        public int maximumRequests(int n, int[][] req) {
            int m = req.length, range = 1 << m, j = 0, max = 0;
            int [] out = new int [n], in = new int [n]; // 不用弄两个，一个就够用了
            for (int i = 1; i < range; i++) {
                int cnt = Integer.bitCount(i);
                Arrays.fill(in, 0);
                Arrays.fill(out, 0);
                for ( j = 0; j < m; j++) 
                    if (((i >> j) & 1) == 1) {
                        int [] c = req[j];
                        out[c[0]]++;
                        in[c[1]]++;
                    }
                for (j = 0; j < n; j++) 
                    if (out[j] != in[j]) break;
                if (j < n) continue;
                max = Math.max(max, cnt);
            }
            return max;
        }
        public int maximumRequests(int n, int[][] requests) {
            int ans = 0;
        outer_loop: for (int m = 0; m < (1 << requests.length); m++) {
                int [] balance = new int[n];
                for (int i = 0; i < requests.length; i++) 
                    if (((m >> i)&1) == 1) {
                        balance[requests[i][0]]--;
                        balance[requests[i][1]]++;
                    }
                for (int i = 0; i < n; i++)
                     if (balance[i] != 0) continue outer_loop;
                ans = Math.max(ans, Integer.bitCount(m));
            }
            return ans;
        }
        public int maximumRequests(int n, int[][] requests) {
            helper(requests, 0, new int[n], 0);
            return max;
        }
        int max = 0;
        void helper(int [][] a, int idx, int [] cnt, int sum) {
            if (idx == a.length) {
                for (int v : cnt) 
                    if (v != 0) return ;
                max = Math.max(max, sum);
                return ;
            }
            cnt[a[idx][0]]++;
            cnt[a[idx][1]]--;
            helper(a, idx+1, cnt, sum+1);
            cnt[a[idx][0]]--;
            cnt[a[idx][1]]++;
            helper(a, idx+1, cnt, sum);
        }


        
        public TreeNode canMerge(List<TreeNode> trees) {
           for (TreeNode r : trees) m.put(r.val, r);
           for (TreeNode r : trees) 
               if (m.containsKey(r.val)) {
                   TreeNode rt = buildTree(r);
                   m.put(rt.val, rt);
               }
           if (m.size() > 1) return null;
           TreeNode rt = m.values().iterator().next();
           return isValid(rt, Integer.MIN_VALUE, Integer.MAX_VALUE) ? rt : null;
        }
        Map<Integer, TreeNode> m = new HashMap<>(); // rts: roots
        TreeNode buildTree(TreeNode r) { // 自顶向下：构建以 r 为树根的最大可能的大树 
            TreeNode next = m.remove(r.val);
            if (next != null) {
                if (next.left != null) r.left = buildTree(next.left);
                if (next.right != null) r.right = buildTree(next.right);
            }
            return r;
        }
        boolean isValid(TreeNode r, int min, int max) { // 而给出左右范围限定的目的：就具备了传递性，绝对保证递归下去的所有子树都合法,因为限定了他们的合法取值范围
            if (r == null) return true;
            int v = r.val;
            if (v >= max || v <= min) return false; // 
            // if (r.left != null && r.left.val >= v || r.right != null && r.right.val <= v) return false; // 这一行不具备上下传递性：
            return isValid(r.left, min, v) && isValid(r.right, v, max);                                    // 就是某个子子左节点的值可能违规，但检查不出来
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{2,1},{3,2,5},{5,4}};

        List<TreeNode> l = new ArrayList<>();
        for (int [] v : a) {
            TreeNode root = new TreeNode(v[0]);
            root.buildTree(root, v);
            root.levelPrintTree(root);
            l.add(root);
        }

        TreeNode r = s.canMerge(l);
        r.levelPrintTree(r);
    }
}






