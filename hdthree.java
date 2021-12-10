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

        // public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) { // bug: 这里的顺序被我写得有点儿昏乎
        //     int n = profits.length;
        //     List<int []> p = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         p.add(new int [] {profits[i], capital[i]});
        //     Collections.sort(p, (a, b)->a[1] - b[1]); // 按启动资金升序排列
        //     // for (int [] zz : p) 
        //     //     System.out.println(Arrays.toString(zz));
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> y[0]-y[1] - x[0]+x[1]); // 按获得降序排列
        //     int max = 0, i = 0, j = 0;
        //     while (i < n) {
        //         System.out.println("\n i: " + i);
        //         j = i;
        //         while (j < n && p.get(j)[1] <= max) 
        //             q.offer(p.get(j++));
        //         i = Math.min(j, i+1);
        //         System.out.println("max: " + max);
        //         System.out.println("k: " + k);
        //         while (!q.isEmpty() && k > 0) {
        //             max = Math.max(max, max - q.peek()[1] + q.poll()[0]);
        //             k--;
        //         }
        //     }
        //     return max;
        // }

        // List<Integer> ll = new ArrayList<>(); // all the values
        // Map<Integer, Set<Integer>> idx = new HashMap<>();
        // Random rand;
        // public RandomizedCollection() {
        //     ll = new ArrayList<>(); // all the values
        //     idx = new HashMap<>();
        //     rand = new Random();
        // }
        // public boolean insert(int val) {
        //     boolean has = !idx.containsKey(val);
        //     ll.add(val);
        //     idx.computeIfAbsent(val, z -> new HashSet<>()).add(ll.size()-1);
        //     return has;
        // }
        // public boolean remove(int val) { // 当想要移掉一个数的时候，从下标set里移去任意第一个，并用链表ll的最后一个元素来填充替换链表中移去下标的数值 
        //     if (!idx.containsKey(val)) return false;
        //     Set<Integer> id = idx.get(val);
        //     int one = id.iterator().next();
        //     if (id.size() == 1) idx.remove(val); 
        //     else id.remove(one);
        //     int v = ll.get(ll.size()-1);
        //     if (one != ll.size()-1) { // 这里需要区分
        //         Set<Integer> idTwo = idx.get(v);
        //         int two = idTwo.iterator().next();
        //         idTwo.add(one);
        //         idTwo.remove(ll.size()-1);
        //         // if (idTwo.size() == 1) idx.remove(v); // BUG: 当把最后一个元素移动替换到删除元素位置，需要同步更新最后元素下标位置的set
        //         // else idTwo.remove(two);
        //         ll.set(one, v);
        //     }
        //     ll.remove(ll.size()-1); // 需要写在上面区分的外面
        //     return true;
        // }
        // public int getRandom() {
        //     return ll.get(rand.nextInt(ll.size()));
        // }

        // class BIT { // Binary Indexed Tree, Fenwick Tree // 这里有bug,今天晚点儿再回来改这个
        //     long [] tree;
        //     int [] a; // 从1开始
        //     int n;
        //     public BIT(int n) {
        //         this.n = n;
        //         this.tree = new long [n+1];
        //     }            
        //     public BIT(int [] arr) {
        //         this.n = arr.length + 1;
        //         this.tree = new long [n];
        //         this.a = Arrays.copyOf(arr, arr.length);
        //         long tmp = 0;
        //         for (int i = 1; i < n; i++) {
        //             tmp = 0;
        //             int lowbit = i & ((i - 1) ^ i);
        //             for (int j = i; j > i - lowbit; j--) 
        //                 tmp = tmp + a[j-1];
        //             tree[i] = tmp;
        //         }
        //         System.out.println(Arrays.toString(a));
        //         System.out.println(Arrays.toString(tree));
        //     }
        //     public int treeRange(int i, int j) { // inclusive: tree of a[i, j], includes a[i] and a[j]
        //         return (int)(tree(j) - tree(i-1));
        //     }
        //     long tree(int i) {
        //         long ans = 0;
        //         i++;
        //         while (i > 0 && i < n) {
        //             ans += tree[i];
        //             i = i - (i & ((i-1) ^ i));
        //             // i -= lowBit(i);
        //         }
        //         return ans;
        //     }
        //     void update(int i, int v) { // O(logN)
        //         int dif = v - a[i];   // 从1开始
        //         a[i] = v;
        //         i += 1;
        //         for (; i < n; i = i + (i & ((i-1) ^ i)))
        //             tree[i] += dif;
        //         // while (i+1 < a.length) {
        //         //     tree[i+1] += dif;
        //         //     i += lowBit(i);
        //         // }
        //     }
        //     int lowBit(int n) { // ???
        //         return n & (-n);
        //     }
        // }
        // public int countRangeSum(int[] a, int lower, int upper) { // 有bug，换个方法先写出来
        //     int n = a.length;
        //     // if (n == 1) return a[0] <= upper && a[0] >= lower ? 1 : 0;
        //     BIT bit = new BIT(a);
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i; j < n; j++) {
        //             System.out.println("\n i: " + i);
        //             System.out.println("j: " + j);
        //             long tree = bit.treeRange(i, j+1);
        //             System.out.println("tree: " + tree);
        //             if (tree >= lower && tree <= upper) ++cnt;
        //         }
        //     return cnt;
        // }
        // public int countRangeSum(int[] a, int lower, int upper) { // bug
        //     n = a.length;
        //     sum = new long [n];
        //     for (int i = 0; i < n; i++) 
        //         sum[i] = (i == 0 ? 0 : sum[i-1]) + a[i];
        //     return getCnt(upper) - getCnt(lower-1);
        // }
        // long [] sum;
        // int n;
        // int getCnt(int v) {
        //     int cnt = 0;
        //     Map<Long, Integer> m = new HashMap<>();
        //     m.put(0l, 1); // v == 0 ?
        //     for (int i = 0; i < n; i++) {
        //         if (sum[i] < v) // 键里存的所有的key,构成的子片段都会小
        //             cnt += m.values().stream().reduce(0, Integer::sum);
        //         else if (sum[i] >= v && m.containsKey(sum[i] - v))
        //             cnt += m.get(sum[i] - v);
        //         m.put(sum[i], m.getOrDefault(sum[i], 0) + 1);
        //     }
        //     return cnt;
        // }

        // public int trapRainWater(int[][] a) { // BFS
        //     int m = a.length, n = a[0].length;
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> x[2] - y[2]); // int []: [i, j, a[i][j]] 按照高度由矮到高
        //     boolean [][] vis = new boolean [m][n];
        //     for (int j = 0; j < n; j++) { // 把外围一圈的格子先加进去，然后由外向内遍历
        //         q.offer(new int [] {0, j, a[0][j]});
        //         q.offer(new int [] {m-1, j, a[m-1][j]});
        //         vis[0][j] = true;
        //         vis[m-1][j] = true;
        //     }
        //     for (int i = 0; i < m; i++) {
        //         q.offer(new int [] {i, 0, a[i][0]});
        //         q.offer(new int [] {i, n-1, a[i][n-1]});
        //         vis[i][0] = true;
        //         vis[i][n-1] = true;
        //     }
        //     int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //     int max = 0, ans = 0;
        //     while (!q.isEmpty()) {
        //         int [] cur = q.poll();
        //         max = Math.max(max, cur[2]); // 纪录海平面的高度，
        //         for (int [] d : dirs) {
        //             int i = cur[0] + d[0], j = cur[1] + d[1];
        //             if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) continue;
        //             vis[i][j] = true;
        //             if (a[i][j] < max) // 同外围向内遍历，如果有比海平面低的格，那是可以装水的
        //                 ans += max - a[i][j];
        //             q.offer(new int [] {i, j, a[i][j]});
        //         }
        //     }
        //     return ans;
        // }

        // Map<Integer, Set<String>> idx; // k,v: cnt, strstr
        // Map<String, Integer> cnt; // k,v: string, cnt
        // TreeSet<Integer> ts = new TreeSet<>((a,b)->a-b);
        // public AllOne() { // 今天早上脑袋不够清醒，就多写几个设计题，写这种也是写得留了不少bug
        //     idx = new HashMap<>();
        //     cnt = new HashMap<>();
        // }
        // public void inc(String key) {
        //     if (!cnt.containsKey(key)) {
        //         cnt.put(key, 1);
        //         idx.computeIfAbsent(1, z -> new HashSet<>()).add(key);
        //         ts.add(1);
        //     } else {
        //         int v = cnt.get(key);
        //         cnt.put(key, v+1);
        //         idx.get(v).remove(key); // 没有移彻底的， idx: [v, 0]: 以后还是需要第一次写的时候就想清楚，不移彻底可能会出现哪些情况bug，最好是能一次写到位
        //         if (idx.get(v).size() == 0) {
        //             idx.remove(v); // BUG
        //             ts.remove(v);
        //         }
        //         idx.computeIfAbsent(v+1, z -> new HashSet<>()).add(key);
        //         ts.add(v+1);
        //     }
        // }
        // public void dec(String key) {
        //     int v = cnt.get(key);
        //     idx.get(v).remove(key);
        //     if (v == 1) cnt.remove(key);
        //     else cnt.put(key, v-1); //
        //     if (idx.get(v).size() == 0) {
        //         idx.remove(v); // BUG
        //         ts.remove(v);
        //     }
        //     if (v > 1) {
        //         if (!idx.containsKey(v-1)) {
        //             ts.add(v-1);
        //             idx.put(v-1, new HashSet<>());
        //         } 
        //         idx.get(v-1).add(key);
        //     }
        // }
        // public String getMaxKey() {
        //     if (ts.size() == 0) return "";
        //     return idx.get(ts.last()).iterator().next();
        // }
        // public String getMinKey() {
        //     if (ts.size() == 0) return "";
        //     return idx.get(ts.first()).iterator().next();
        // }

        // TreeSet<Integer> ts = new TreeSet<>();       // different cnters for key 纯操作次数 升序
        // Map<Integer, Integer> m = new HashMap<>();   // map: [key, value] 图：键值对
        // Map<Integer, Integer> cnt = new HashMap<>(); // cnt: [key, keyCnt] 操作次数 计数器
        // Map<Integer, Set<Integer>> idx = new HashMap<>(); // idx: [cnt, keys] 操作次数
        // int n;
        // // public LFUCache(int capacity) {
        // public hdthree(int capacity) {
        //     this.n = capacity;
        // }
        // public int get(int key) {
        //     if (!m.containsKey(key)) return -1;
        //     updateOperations(key);
        //     return m.get(key);
        // }
        // public void put(int key, int value) {
        //     if (m.containsKey(key)) { // 存在 
        //         m.put(key, value);
        //         cnt.put(key, cnt.getOrDefault(key, 0) + 1);
        //         updateOperations(key);
        //     // } else if (m.size() < n) { // 可以补在后面简化代码
        //     //     m.put(key, value);
        //     //     cnt.put(key, 1); // 第一次放入
        //     //     updateOperations(key);
        //     } else if (m.size() == n) { // 需要先删除
        //         int key = -1, leastCnt = ts.first();
        //         if (idx.get(leastCnt).size() == 1) {
        //             key = idx.get(leastCnt).iterator().next();
        //             idx.remove(leastCnt);
        //             cnt.remove(key);
        //             m.remove(key);
        //             ts.pollFirst();
        //         } else {
        //             for (Integer ks : idx.get(leastCnt)) { // 还需要一个 least recently used， 改天再写这个
        //             }
        //         }
        //     }
        // }
        // void updateOperations(int k) {
        //     int pre = cnt.get(k);
        //     idx.get(pre).remove(k); // 操作次数总表
        //     if (idx.get(pre).size() == 0) {
        //         idx.remove(pre);
        //         ts.remove(pre);
        //     }            
        //     cnt.put(k, cnt.get(k) + 1); // 计数器
        //     idx.computeIfAbsent(pre+1, z -> new HashSet<>()).add(k);
        //     ts.add(pre+1);
        // }

        // public double [] medianSlidingWindow(int [] a, int k) { // bug: not finished yet divide and conquer, merge sort的思路可能更即写一点儿
        //     int n = a.length, idx = 0;
        //     double [] ans = new double[n-k+1];
        //     if (k == 1) {
        //         for (Integer v : a) 
        //             ans[idx++] = (double)v;
        //         return ans;
        //     }
        //     Queue<Integer> l = new PriorityQueue<>((a, b)->b-a);
        //     Queue<Integer> r = new PriorityQueue<>((a, b)->a-b);
        //     boolean odd = (k % 2 == 1); // 设置r里多一个元素
        //     l.offer(a[0]);
        //     for (int i = 1; i < k; i++) { // 放置前k个元素:怎么放呢？
        //         if (l.size() != r.size()) {
        //             r.offer(num);
        //             l.offer(r.poll());
        //         } else { // ==
        //             l.offer(num);
        //             r.offer(l.poll());
        //         }
        //     }
        //     System.out.println("(l.size() >= r.size()-1): " + (l.size() >= r.size()-1));
        //     System.out.println("l.peek() <= r.peek(): " + l.peek() <= r.peek());
        //     while (l.size() > k / 2) r.offer(l.poll());
        //     if (l.size() == r.size())
        //         ans[idx] = (l.peek() + r.peek()) / 2.0;
        //     // else if (l.size() > r.size()) ans[idx] = l.peek();
        //     else ans[idx] = r.peek();
        //     idx++;
        //     for (int i = k; i < n; i++) {
        //         int pre = a[i - k];
        //         if (pre >= r.peek()) r.remove() // heap这里应该不能直接删除吧，可能需要先转移一部分到min里去，再转回来
        //     }
        //     return ans;
        // }

        // static final int mod = 1337;
        // public int largestPalindrome(int n) { // bug: 不知道哪里错了
        //     if (n == 1) return 9;
        //     int l = (int)Math.pow(10, n-1), r = (int)Math.pow(10, n)-1;
        //     // long ll = (int)Math.pow(10, 2*n-1), rr = (int)Math.pow(10, 2*n); // 遍历含有太多杂数，复杂度太高
        //     for (int i = r; i >= l; i--) {
        //         long cur = buildPalindrome(i); // 生成回文串反而来得更快
        //         for (long j = r; j * j >= cur; j--) // cur / j 的最大值是 sqrt(cur)
        //             if (cur % j == 0)
        //                 return (int)(cur % mod);
        //     }
        //     return -1;
        // }
        // long buildPalindrome(int n) {
        //     String s = ""+n, t = new StringBuilder(s).reverse().toString();
        //     return Long.parseLong(s + t);
        // }

        // public int reversePairs(int[] a) { // bug
        //     int n = a.length, cnt = 0;
        //     TreeMap<Integer, Integer> m = new TreeMap<>();
        //     m.put(a[n-1], 1);
        //     for (int i = n-2; i >= 0; i--) {
        //         int v = a[i] / 2;
        //         Integer lo = m.lowerKey(v); // 还需要 <= lo的treemap所有值的和
        //         // ;
        //         m.put(a[i], m.getOrDefault(a[i], 0) + 1);
        //     }
        //     return cnt;
        // }

        // public boolean judgePoint24(int[] a) {
        //     int n = a.length;
        //     List<Double> l = new ArrayList<>();
        //     for (Integer v : a) l.add((double)v);
        //     helper(l);
        //     return ans;
        // }
        // double eps = 0.001; //
        // boolean ans = false; 
        // void helper(List<Double> l) {
        //     if (ans) return ;
        //     if (l.size() == 1) {
        //         if (Math.abs(l.get(0) - 24) < eps) 
        //             ans = true;
        //         return ;
        //     }
        //     for (int i = 0; i < l.size(); i++) // 0 / 1
        //         for (int j = 0; j < i; j++) {
        //             double x = l.get(i), y = l.get(j);
        //             // List<Integer> tmp = new ArrayList<>(Arrays.asList({x+y, x-y, x*y, y-x}));
        //             Double [] a = {x+y, x-y, x*y, y-x};
        //             List<Double> tmp = new ArrayList<>(Arrays.asList(a));
        //             if (x > eps) tmp.add(y / x); // 保证除数不为0
        //             if (y > eps) tmp.add(x / y);
        //             l.remove(i);
        //             l.remove(j);
        //             for (double d : tmp) {
        //                 l.add(d);
        //                 helper(l);
        //                 l.remove(l.size()-1);
        //             }
        //             l.add(j, y);
        //             l.add(i, x);
        //         }
        // }
        // public boolean judgePoint24(int[] arr) {
        //     int n = arr.length;
        //     List<Double> a = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         a.add((double)arr[i]);
        //     return helper(a);
        // }
        // List<Character> sn = List.of('+', '-', '*', '/');
        // double eps = 0.001; //
        // boolean helper(List<Double> l) {
        //     if (l.size() == 1) return Math.abs(l.get(0) - 24) < eps;
        //     for (int i = 0; i < l.size(); i++) 
        //         for (int j = 0; j < l.size(); j++) {
        //             if (i == j) continue;
        //             List<Double> tmp = new ArrayList<>();
        //             for (int k = 0; k < l.size(); k++) 
        //                 if (k != i && k != j) tmp.add(l.get(k));
        //             for (char o : sn) {
        //                 if ((o == '+' || o == '*') && i > j) continue;
        //                 if (o == '/' && l.get(j) < eps) continue; // 除娄不能为0
        //                 switch (o) {
        //                 case '+': tmp.add(l.get(i) + l.get(j)); break;
        //                 case '-': tmp.add(l.get(i) - l.get(j)); break;
        //                 case '*': tmp.add(l.get(i) * l.get(j)); break;
        //                 case '/': tmp.add(l.get(i) / l.get(j)); break;
        //                 }
        //                 if (helper(tmp)) return true;
        //                 tmp.remove(tmp.size()-1);
        //             }
        //         }
        //     return false;
        // }

        // public int[] hitBricks(int[][] g, int[][] h) {
        //     m = g.length;
        //     n = g[0].length;
        //     for (int [] v : h)
        //         if (g[v[0]][v[1]] == 1)
        //             g[v[0]][v[1]] = 2;
        //     uf = new UnionFind(m*n+1); // 为什么要多加1个: 用 m*n 连个顶儿
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++)
        //             if (g[i][j] == 1) unionAround(i, j, g);
        //     int [] ans = new int [h.length];
        //     int sum = uf.cnt[uf.find(m*n)]; // 最终剩下的砖数
        //     for (int i = h.length-1; i >= 0; i--) {
        //         int [] v = h[i];
        //         if (g[v[0]][v[1]] == 2) {
        //             unionAround(v[0], v[1], g);
        //             g[v[0]][v[1]] = 1; // 1: 被敲掉的砖不能放在结果里
        //         }
        //         int cnt = uf.cnt[uf.find(m*n)];
        //         ans[i] = (cnt - sum > 0 ? cnt - sum - 1 : 0);
        //         sum = cnt;
        //     }
        //     return ans;
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // UnionFind uf;
        // int m, n;
        // void unionAround(int i, int j, int [][] a) {
        //     for (int [] d : dirs) {
        //         int x = i + d[0], y = j + d[1];
        //         if (x < 0 || x >= m || y < 0 || y >= n) continue;
        //         if (a[x][y] == 1) uf.union(i*n+j, x*n+y);
        //     }
        //     if (i == 0) uf.union(i*n+j, m*n); // 为了方便写代码，跟最后一个 m*n 连,其实跟0跟m*n连没区别
        // }
        // class UnionFind {
        //     int [] id; // parent
        //     int [] cnt;// size
        //     public UnionFind (int n) {
        //         id = new int [n];
        //         cnt = new int [n];
        //         for (int i = 0; i < n; i++) {
        //             id[i] = i;
        //             cnt[i] = 1;
        //         }
        //     }
        //     public int find(int i) {
        //         while (id[i] != i) {
        //             id[i] = id[id[i]];
        //             i = id[i];
        //         }
        //         return i;
        //     }
        //     public void union(int i, int j) {
        //         int rootI = find(i);
        //         int rootJ = find(j);
        //         if (rootI != rootJ) {
        //             id[rootI] = rootJ;
        //             cnt[rootJ] += cnt[rootI];
        //         }
        //     }
        // }

        // public int rectangleArea(int[][] rectangles) {
        //     ll = new ArrayList<>();
        //     long ans = 0;
        //     for (int [] r : rectangles) 
        //         addRect(r, 0);
        //     for (int [] r : ll) 
        //         ans = (ans + (long)(r[2] - r[0]) * (long)(r[3] - r[1])) % mod;
        //     return (int)ans;
        // }        
        // static final int mod = (int)1e9 + 7;
        // List<int []> ll;
        // void addRect(int [] a, int i) { // i: idx
        //     if (i >= ll.size()) {
        //         ll.add(a);
        //         return ;
        //     }
        //     int [] r = ll.get(i);
        //     if (a[2] <= r[0] || a[0] >= r[2] || a[1] >= r[3] || a[3] <= r[1]) { // 被添加的，与现遍历的矩形，完全没有交集，直接往后遍历
        //         addRect(a, i+1);
        //         return ;
        //     } // 找出所有有交集的、交集部分——与现遍历矩形相比，多出来的部分，的四个顶点，再往后遍历
        //     if (a[0] < r[0]) // 左
        //         addRect(new int [] {a[0], a[1], r[0], a[3]}, i+1);
        //     if (a[2] > r[2]) // 右
        //         addRect(new int [] {r[2], a[1], a[2], a[3]}, i+1);
        //     if (a[1] < r[1]) // 下: 新增矩形 下侧 也可以有 交叠：注意左侧、右侧前面已经加进去了，现在只加中间部分，不要重复计算
        //         addRect(new int [] {Math.max(a[0], r[0]), a[1], Math.min(a[2], r[2]), r[1]}, i+1);
        //     if (a[3] > r[3]) // 上: 新增矩形 上侧 也可以有 交叠：注意左侧、右侧、下侧 前面已经加进去了，现在只加中间部分，不要重复计算
        //         addRect(new int [] {Math.max(a[0], r[0]), r[3], Math.min(a[2], r[2]), a[3]}, i+1);
        // }

        // public int shortestPathAllKeys(String [] a) { // 居然被我一遍写对了：开始写的时候还有点儿不是很清楚
        //     m = a.length;
        //     n = a[0].length();
        //     int target = 0, si = 0, sj = 0;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) {
        //             char c = a[i].charAt(j);
        //             if (c == '@') {
        //                 si = i;
        //                 sj = j;
        //             } else if (Character.isLowerCase(c))
        //                 target |= 1 << (c - 'a');
        //         }
        //     return bfs(si, sj, target, a);
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int m, n;
        // int bfs(int x, int y, int target, String [] a) {
        //     Set<String> vis = new HashSet<>(); // 重点是：这个走过的状态里是需要包含所取得得钥匙的信息的
        //     Queue<int []> q = new LinkedList<>();
        //     int [] tmp = {x, y, 0};
        //     q.offer(tmp);
        //     vis.add(Arrays.toString(tmp));
        //     int cnt = 0, mask = 0;
        //     while (!q.isEmpty()) {
        //         for (int z = q.size()-1; z >= 0; z--) {
        //             int [] cur = q.poll();
        //             char c = a[cur[0]].charAt(cur[1]);
        //             mask = cur[2];
        //             if (Character.isLowerCase(c)) {
        //                 mask |= (1 << (c - 'a'));
        //                 if (mask == target) return cnt;
        //             }
        //             for (int [] d : dirs) {
        //                 int i = cur[0] + d[0], j = cur[1] + d[1];
        //                 if (i < 0 || i >= m || j < 0 || j >= n || a[i].charAt(j) == '#') continue;
        //                 char next = a[i].charAt(j);
        //                 int [] tpp = new int [] {i, j, mask} ;
        //                 String key = Arrays.toString(tpp);
        //                 if (vis.contains(key)) continue;
        //                 if (Character.isUpperCase(next) && (mask & (1 << (next - 'A'))) == 0) continue;
        //                 q.offer(tpp);
        //                 vis.add(key);
        //             }
        //         }
        //         cnt++;
        //     }
        //     return -1;
        // }

        // public int superpalindromesInRange(String left, String right) { // 这个题还要好好再看看，竟然又写错了一次
        //     long l = Long.parseLong(left), r = Long.parseLong(right);
        //     helper("", l, r); // 生成长度为偶数的
        //     for (char c = '0'; c <= '9'; c++) 
        //         helper(""+c, l, r); // 生成长度为奇数的
        //     return cnt;
        // }
        // int cnt = 0;
        // void helper(String s, long l, long r) {
        //     if (s.length() > 9) return ;
        //     if (!s.isEmpty() && s.charAt(0) != '0') {
        //         long v = Long.parseLong(s);
        //         v *= v;
        //         if (v > r) return ;
        //         if (v >= l && isPalindrom(v))
        //             cnt++;
        //     }
        //     for (char c = '0'; c <= '9'; c++) 
        //         helper(String.valueOf(c) + s + String.valueOf(c), l, r);
        // }
        // boolean isPalindrom(long v) {
        //     long ans = 0, tmp = v;
        //     while (v > 0) {
        //         ans = ans * 10 + v % 10;
        //         v /= 10;
        //     }
        //     return ans == tmp;
        // }

        //  public int shortestSubarray(int[] a, int k) { // bug: 不知道这里哪里没有想对
        //     int n = a.length, min = Integer.MAX_VALUE;
        //     long sum = 0;
        //     TreeMap<Long, Integer> m = new TreeMap<>();
        //     for (int i = 0; i < n; i++) {
        //         sum += a[i];
        //         if (sum >= k) {
        //             min = Math.min(min, i+1);
        //             Long lo = m.lowerKey(sum - k);
        //             if (lo != null)
        //                 min = Math.min(min, i - m.get(lo));
        //         }
        //         m.put(sum, i);
        //     }
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }

        //  public int countTriplets(int[] a) { // tle
        //     int n = a.length, cnt = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) 
        //             for (int k = 0; k < n; k++) 
        //                 if ((a[i] & a[j] & a[k]) == 0)
        //                     cnt++;
        //                 return cnt;
        // }
        // public int countTriplets(int[] a) {
        //     int n = a.length, cnt = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) {
        //             int v = (a[i] & a[j]);
        //             m.put(v, m.getOrDefault(v, 0) + 1);
        //         }
        //     for (int i = 0; i < n; i++) 
        //         for (Integer key : m.keySet()) 
        //             if ((a[i] & key) == 0)
        //                 cnt += m.get(key);
        //     return cnt;
        // }
        // public int countTriplets(int[] a) {
        //     int n = a.length, r = 1 << 16, v = 0, ans = 0;
        //     int [] cnt = new int [r];
        //     Arrays.fill(cnt, -1);
        //     for (Integer i : a) 
        //         for (Integer j : a) {
        //             v = i & j;
        //             if (cnt[v] == -1) {
        //                 cnt[v] = 0;
        //                 for (Integer k : a) 
        //                     if ((v & k) == 0) ++cnt[v];
        //             }
        //             ans += cnt[v];
        //         }
        //     return ans;
        // }

        // public int [] gridIllumination(int n, int[][] a, int[][] q) { // 终于独立完整地把它完整地写了一遍。。。。。。
        //     int [][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        //     int m = q.length;
        //     Map<Integer, Integer> r = new HashMap<>(); // row
        //     Map<Integer, Integer> c = new HashMap<>(); // col
        //     Map<Integer, Integer> d = new HashMap<>(); // dia: i-j
        //     Map<Integer, Integer> t = new HashMap<>(); // anti-dia i+j
        //     Set<Integer> cnt = new HashSet<>();
        //     for (int [] v : a) {
        //         int i = v[0] * n + v[1];
        //         if (cnt.contains(i)) continue;
        //         r.put(v[0], r.getOrDefault(v[0], 0) + 1);
        //         c.put(v[1], c.getOrDefault(v[1], 0) + 1);
        //         d.put(v[0]+v[1], d.getOrDefault(v[0]+v[1], 0) + 1);
        //         t.put(v[0]-v[1], t.getOrDefault(v[0]-v[1], 0) + 1);
        //         cnt.add(i);
        //     }
        //     int [] ans = new int [m];
        //     for (int k = 0; k < q.length; k++) {
        //         int i = q[k][0], j = q[k][1];
        //         if (r.containsKey(i) || c.containsKey(j) || d.containsKey(i+j) || t.containsKey(i-j))
        //             ans[k] = 1;
        //         for (int [] di : dirs) {
        //             int x = i + di[0], y = j + di[1], idx = 0;
        //             if (x < 0 || x >= n || y < 0 || y >= n) continue;
        //             idx = x * n + y;
        //             if (!cnt.contains(idx)) continue;
        //             cnt.remove(idx);
        //             r.put(x, r.getOrDefault(x, 1)-1);
        //             c.put(y, c.getOrDefault(y, 1)-1);
        //             d.put(x+y, d.getOrDefault(x+y, 1)-1);
        //             t.put(x-y, t.getOrDefault(x-y, 1)-1);
        //             if (r.getOrDefault(x, 0) == 0) r.remove(x);
        //             if (c.getOrDefault(y, 0) == 0) c.remove(y);
        //             if (d.getOrDefault(x+y, 0) == 0) d.remove(x+y);
        //             if (t.getOrDefault(x-y, 0) == 0) t.remove(x-y);
        //         }
        //     }
        //     return ans;
        // }

        // public boolean isEscapePossible(int[][] b, int[] s, int[] t) {
        //     n = b.length;
        //     if (n == 0) return true;
        //     for (int [] v : b) {
        //         long i = v[0] * N + v[1];
        //         idx.add(i);
        //     }
        //     if (!bfs(s[0], s[1], t)) return false; // 这个细节需要注意
        //     vis.clear();
        //     return bfs(t[0], t[1], s);
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // List<Long> idx = new ArrayList<>();
        // Set<Long> vis = new HashSet<>();
        // long N = 1000000;
        // int n;
        // boolean bfs(int x, int y, int [] tar) {
        //     Queue<int []> q = new LinkedList<>();
        //     q.offer(new int [] {x, y});
        //     vis.add(x * N + y);
        //     while (!q.isEmpty()) {
        //         int cur [] = q.poll(), i = cur[0], j = cur[1];
        //         for (int [] d : dirs) {
        //             int s = i + d[0], t = j + d[1];
        //             if (s < 0 || s >= N || t < 0 || t >= N) continue;
        //             long ss = s * N + t ;
        //             if (idx.contains(ss) || vis.contains(ss)) continue;
        //             if (s == tar[0] && t == tar[1]) return true;
        //             q.offer(new int [] {s, t});
        //             vis.add(ss);
        //         }
        //         if (q.size() > n) return true; // 这个标准不记得了
        //     }
        //     return false;
        // }        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{0,999991},{0,999993},{0,999996},{1,999996},{1,999997},{1,999998},{1,999999}};
        int [] b = new int [] {0,999997};
        int [] c = new int [] {0, 2};

        boolean r = s.isEscapePossible(a, b, c);
        System.out.println("r: " + r);
    }
}
// TreeNd root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.lvlPrintTree(root);

