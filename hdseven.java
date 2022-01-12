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

public class hdseven {
    public static class Solution {

        // public List<Integer> busiestServers(int k, int [] a, int [] l) { // treeset<Servers> heap: finishing time increasing
        //     int [] cnt = new int [k];
        //     TreeSet<Integer> ss = new TreeSet<>(); // server idxes
        //     for (int i = 0; i < k; i++) ss.add(i);
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> x[0] + x[1] - (y[0] + y[1])); // ia: [bgn, duration]
        //     int t = a[0], max = 0;
        //     for (int i = 0; i < a.length; i++) {
        //         t = a[i];
        //         while (!q.isEmpty() && q.peek()[0] + q.peek()[1] <= t) ss.add(q.poll()[2]);
        //         if (ss.isEmpty()) continue;
        //         if (ss.contains(i % k)) {
        //             q.offer(new int [] {t, l[i], i % k});
        //             ss.remove(i % k);
        //             cnt[i%k]++;
        //             max = Math.max(max, cnt[i%k]);
        //         } else {
        //             // int idx = ss.pollFirst();     // 不是取第一个available
        //             int idx = getNext(ss, i % k, k); // 而是取期望值后面更高的 或者 从头来数按顺序的
        //             ss.remove(idx);
        //             q.offer(new int [] {t, l[i], idx});
        //             cnt[idx]++;
        //             max = Math.max(max, cnt[idx]);
        //         }
        //     }
        //     List<Integer> ans = new ArrayList<>();
        //     for (int i = 0; i < k; i++) 
        //         if (cnt[i] == max) ans.add(i);
        //     return ans;
        // }
        // int getNext(TreeSet<Integer> ss, int idx, int k) { 
        //     Integer hi = ss.higher(idx);
        //     if (hi != null) return hi;
        //     hi = ss.higher(-1);
        //     return hi;
        //     // int i = (idx + 1) % k;  // 把treeset没当treeset用？！！！
        //     // while (!ss.contains(i)) 
        //     //     i = (i + 1) % k;
        //     // return i;
        // }

        // public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) { // BUG: 改天再写一遍吧
        //     for (int i = 0; i < edges.length; i++) 
        //         m.add(new int [] {i, edges[i][0], edges[i][1], edges[i][2]});
        //     Collections.sort(m, (a, b) -> a[3] != b[3] ? a[3] - b[3] : a[0] - b[0]); // 这里i的关系随排序会变
        //     uf = new UnionFind(n);
        //     kruskal(n, si, -1, true);
        //     int minWeiGlo = minw;
        //     l = new ArrayList<>();
        //     uf = new UnionFind(n);
        //     for (int e : si) { // si: edges idxes
        //         minw = 0;
        //         uf = new UnionFind(n);
        //         kruskal(n, new HashSet<>(), e, true);
        //         if (minw > minWeiGlo || uf.getCnt() > 1) l.add(e);
        //     }
        //     ll.add(l); // critical edges idx list
        //     l = new ArrayList<>();
        //     // for (int i = 0; i < edges.length; i++) {
        //     for (int [] e : m) {
        //         if (ll.get(0).contains(e[0])) continue; // 上一步已经证明：这条边很重要，所以不用考虑
        //         minw = 0;
        //         uf = new UnionFind(n);
        //         kruskal(n, new HashSet<>(), e[0], false);
        //         if (minw == minWeiGlo) l.add(e[0]);
        //     }
        //     ll.add(l);
        //     return ll;
        // }
        // // Map<Integer, int []> m = new HashMap<>();
        // List<int []> m = new ArrayList<>();
        // Set<Integer> si = new HashSet<>();
        // List<List<Integer>> ll = new ArrayList<>();
        // List<Integer> l = new ArrayList<>();
        // UnionFind uf = null;
        // int minw = 0; // 最小生成树，最小weight和
        // void kruskal(int n, Set<Integer> s, int i, boolean vis) { // vis: 是否包含第i条边,计入图谱
        //     if (!vis) {
        //         uf.merge(m.get(i)[1], m.get(i)[2]); // BUG: 这里错了，这里传进来的原始第i条边，
        //         s.add(i);
        //         minw += m.get(i)[3];                // BUG: 并不对应再对应List<int []>里的第i个元素，因为重新排序过，这样还是原来的map比较好用
        //     }
        //     for (int [] e : m) {
        //         if (uf.sameGroup(e[1], e[2]) || e[0] == i && vis) continue;
        //         if (s.size() < n-1) {
        //             uf.merge(e[1], e[2]);
        //             s.add(e[0]);
        //             minw += e[3];
        //         }
        //     }
        // }
        // HashMap<Integer, int []> m = new HashMap<>(); // 这是参考以前写的
        // HashSet<Integer> s = new HashSet<>();
        // List<List<Integer>> ll = new ArrayList<>();
        // List<Integer> l = new ArrayList<>();
        // int minw = 0;
        // UnionFind uf;
        // public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        //     HashMap<Integer, int []> map = new HashMap<>();
        //     for (int i = 0; i < edges.length; i++) 
        //         map.put(i, edges[i]);
        //     Comparator<Map.Entry<Integer, int []>> c = new Comparator<Map.Entry<Integer, int []>>() {
        //         @Override 
        //         public int compare(Map.Entry<Integer, int []> a, Map.Entry<Integer, int []> b) {
        //             int cmp1 = (a.getValue())[2] - (b.getValue())[2];
        //             if (cmp1 != 0) 
        //                 return cmp1;
        //             else return a.getKey().compareTo(b.getKey());
        //         }
        //     };
        //     m = map.entrySet().stream().sorted(c)
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        //     uf = new UnionFind(n);
        //     kruskal(n, s, -1, true);
        //     int minG = minw;
        //     l = new ArrayList<>();
        //     uf = new UnionFind(n);
        //     for (Integer val : s) {
        //         minw = 0;
        //         uf.reset();
        //         kruskal(n, new HashSet<>(), val, true);
        //         if (minw > minG || uf.getCnt() > 1) l.add(val);
        //     }
        //     ll.add(l);
        //     l = new ArrayList<>();
        //     for (Integer i : m.keySet()) {
        //         if (ll.get(0).contains(i)) continue;
        //         minw = 0;
        //         uf.reset();
        //         kruskal(n, new HashSet<>(), i, false);
        //         if (minw == minG) l.add(i);
        //     }
        //     ll.add(l);
        //     return ll;
        // }
        // private void kruskal(int n, HashSet<Integer> s, int i, boolean vis) {
        //     if (!vis) {
        //         uf.merge((m.get(i))[0], (m.get(i))[1]); 
        //         s.add(i);
        //         minw += (m.get(i))[2];
        //     }
        //     for (Map.Entry<Integer, int []> entry : m.entrySet()) {
        //         int [] cur = entry.getValue();
        //         if (uf.sameGroup(cur[0], cur[1]) || (entry.getKey() == i && vis)) continue;
        //         if (s.size() < n-1) {
        //             uf.merge(cur[0], cur[1]);
        //             s.add(entry.getKey());
        //             minw += cur[2];
        //         }
        //     }            
        // }
        // public class UnionFind {
        //     int [] pare;
        //     // int [] rank;
        //     int cnt;
        //     int n;
        //     public UnionFind(int x) {
        //         this.n = x;
        //         cnt = n;
        //         pare = new int[n];
        //         // rank = new int[n];
        //         for (int i = 0; i < n; i++) 
        //             pare[i] = i;
        //     }
        //     public void reset() {
        //         for (int i = 0; i < n; i++) 
        //             pare[i] = i;
        //         cnt = n;
        //         // rank = new int [n];
        //     }
        //     public int find(int val) {
        //         while (val != pare[val]) {
        //             pare[val] = pare[pare[val]];
        //             val = pare[val];
        //         }
        //         return val;
        //     }
        //     public void merge(int p, int q) {
        //         int rp = find(p);
        //         int rq = find(q);
        //         // if (rank[rp] < rank[rq]) 
        //         //     swap(rp, rq);
        //         pare[rq] = rp;
        //         // rank[rp] += rank[rq];
        //         --cnt; //
        //     }
        //     public boolean sameGroup(int x, int y) {
        //         return find(x) == find(y);
        //     }
        //     public int getCnt() {
        //         return cnt;
        //     }
        //     // private void swap(int x, int y) {
        //     //     int tmp = x;
        //     //     x = y;
        //     //     y = tmp;
        //     // }
        // }
        // public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        //     List<int []> lia = new ArrayList<>();
        //     for (int [] e : edges) lia.add(e);
        //     Collections.sort(lia, (x, y) -> x[2] - y[2]);
        //     List<Integer> critical = new ArrayList<>();
        //     List<Integer> pseudo = new ArrayList<>();
        //     int minCost = getCostOfMST(n, lia, null, null);
        //     for (int i = 0; i < edges.length; i++) {
        //         int [] e = edges[i];
        //         if (getCostOfMST(n, lia, null, e) > minCost) // 优先条件：如果已经是critical,就不用考虑后面的了
        //             critical.add(i);
        //         else if (getCostOfMST(n, lia, e, null) == minCost)
        //             pseudo.add(i);
        //     }
        //     return Arrays.asList(critical, pseudo);
        // }
        // int getCostOfMST(int n, List<int []> adj, int [] req, int [] avd) { // avoid 
        //     int ans = 0;
        //     DSU dsu = new DSU(n);
        //     if (req != null) {
        //         dsu.union(req[0], req[1]);
        //         ans += req[2];
        //     }
        //     for (int [] e : adj) {
        //         if (e != avd && dsu.union(e[0], e[1])) // 可以合并
        //             ans += e[2];
        //         if (dsu.getCnt() == 1)
        //             return ans;
        //     }
        //     return Integer.MAX_VALUE; // 无法生成合法的最小生成树
        // }
        // static class DSU {
        //     int [] par;
        //     int [] rank; // 关于rank和size的部分
        //     int size;
        //     public boolean union(int x, int y) {
        //         int px = find(x), py = find(y);
        //         if (px == py) return false;
        //         // if (rank[x] >= rank[y]) { // BUG
        //         if (rank[px] >= rank[py]) {
        //             par[py] = px;
        //             if (rank[px] == rank[py])
        //                 ++rank[px];
        //             // rank[x] += rank[y]; // BUG: 这里自己写错了
        //         } else {
        //             par[px] = py;
        //             // rank[y] += rank[x];
        //         }
        //         --size;
        //         return true;
        //     }
        //     public int getCnt() {
        //         return size;
        //     }
        //     int find(int x) {
        //         // if (par[x] != x) par[x] = find(par[x]); // BUG
        //         while (par[x] != x) {
        //             par[x] = par[par[x]];
        //             x = par[x];
        //         }
        //         return par[x];
        //     }
        //     public DSU(int n) {
        //         size = n;
        //         par = new int [n];
        //         rank = new int [n];
        //         for (int i = 0; i < n; i++) 
        //             par[i] = i;
        //     }
        // }

        // Node head;
        // public Skiplist() {
        //     int N = 16;
        //     Node [] left = new Node[N];  // 左侧向下
        //     Node [] right = new Node[N]; // 右侧向下
        //     for (int i = 0; i < N; i++) {
        //         left[i] = new Node(-1);     // 左侧哨兵： -1
        //         right[i] = new Node(20007); // 右侧消兵:  > 20000
        //         lift[i].right = right[i];   // 左右 连接起来
        //     }
        //     for (int i = 0; i < N-1; i++) { 
        //         left[i].down = left[i + 1];   // 左 侧消兵：向下连接起来
        //         right[i].down = right[i + 1]; // 右 侧消兵：向下连接起来
        //     }
        //     head = left[0]; // 总入口
        // }
        // public boolean search(int target) {
        //     Node r = head;
        //     // while (r.dn != null) { // BUG: 这里现在有点儿想不清楚了。。。。。。
        //     while (r != null) {
        //         if (r.right.val > target)
        //             r = r.down;
        //         else if (r.right.val < target)
        //             r = r.right;
        //         else return true;
        //     }
        //     return false;
        // }
        // public void add(int val) { // 会加上重复的（Skiplist里面已经存在的）值吗？
        //     Node r = head, pre = null;
        //     ArrayDeque<Node> s = new ArrayDeque<>(); // visited path looking for r.v == num
        //     while (r != null) { // 寻找正确的插入位置 [r, r.rt]
        //         if (r.right.val >= val) {
        //             s.offerLast(r);
        //             r = r.down;
        //         } else r = r.right;
        //     }
        //     while (!s.isEmpty()) {
        //         r = s.pollLast();
        //         Node cur = new Node(val);
        //         cur.right = r.right; // 新建节点放入到 r 与 r.right 之间
        //         r.right = cur;
        //         if (pre != null) cur.down = pre; // 如果当前层不是最底层，那么设置新层新插入节点的 down 指向下一层新插入同值节点
        //         pre = cur; 
        //         if (Math.random() < 0.5) break;  // 根据这个概率来决定，新插入节点是否继续向上增加节点
        //     }
        // }
        // public boolean erase(int val) {
        //     Node r = head;
        //     boolean ans = false;
        //     while (r != null) {
        //         if (r.right.val >= val) {
        //             if (r.right.val == val) { // 把当前层的这一节点删除
        //                 r.right = r.right.right; // 
        //                 ans = true;
        //                 // return true; // BUG: 这里只删除了这一层的，不是没有删除彻底吗？
        //             }
        //             r = r.down; // 向下遍历,寻找并删除当前层之下可能存在的节点
        //         } else r = r.right;
        //     }
        //     return ans;
        // }
        // class Node {
        //     int val;
        //     Node right, down;
        //     public Node(int val) {
        //         this.val = val;
        //     }
        // }
 
        // static final int mod = (int)1e9 + 7;
        // List<Integer> list; // 承受作用力之前的原始数据
        // long add, mul;      // 记的是所有的加和乘操作的最终累积效果
        // public Fancy() {
        //     add = 0;
        //     mul = 1;
        //     list = new ArrayList<>();
        // }
        // public void append(int val) {
        //     val = (int)((val - add + mod) % mod);
        //     val = (int)(((long)val * quickMul(mul, mod - 2)) % mod);
        //     list.add(val); // 因为新加入，所以对当前累积效果取反操作
        // }
        // public void addAll(int inc) {
        //     add = (add + inc) % mod; // 纪录作用力 加
        // }
        // public void multAll(int m) { // 纪录作用力 乘
        //     add = add * m % mod;
        //     mul = mul * m % mod;
        // }
        // public int getIndex(int idx) {
        //     if (idx >= list.size()) return -1;
        //     return (int)((list.get(idx) * mul + add) % mod); // 在原始数据的基础上施加最终的累积效果
        // }
        // long quickMul(long x, int y) {
        //     long ans = 1;
        //     while (y > 0) {
        //         if (y % 2 == 1)
        //             ans = (ans * x) % mod;
        //         x = x * x % mod;
        //         y >>=1 ;
        //     }
        //     return ans;
        // }

        // public int maxBuilding(int n, int[][] res) {
        //     int m = res.length, h [] = new int [m+1]; // 高度限制处建筑的最大高度
        //     if (m == 0) return n-1; // 没有任何限制，返回可能的最大高度 n-1
        //     Arrays.sort(res, (x, y) -> x[0] - y[0]);
        //     h[0] = 0; // 第一栋建筑高度为0
        //     h[1] = Math.min(res[0][1], res[0][0]-1);
        //     for (int i = 1; i < m; i++)    // 从左向右高度限制
        //         h[i+1] = Math.min(res[i][1], h[i] + res[i][0] - res[i-1][0]);
        //     for (int i = m-2; i >= 0; i--) // 从右向左高度限制
        //         h[i+1] = Math.min(h[i+1], h[i+2] + res[i+1][0] - res[i][0]);
        //     // int ans = h[1] + (res[0][0] - h[1]) / 2; // (j − i + h[i] + h[j]) / 2 // bug: 最后两个test case 不过
        //     int ans = (h[1] + res[0][0] - 1 + h[0]) / 2; // (j − i + h[i] + h[j]) / 2
        //     System.out.println("ans: " + ans);
        //     for (int i = 2; i <= m; i++) // 统计各区间最大建筑高度
        //         ans = Math.max(ans, (res[i-1][0] - res[i-2][0] + h[i] + h[i-1]) / 2);
        //     ans = Math.max(ans, h[m] + n - res[m-1][0]); // 最后一栋建筑需单独计算
        //     return ans;
        // }
        // public int maxBuilding(int n, int[][] res) {
        //     int m = res.length+2, r [][] = new int [m][2]; // 高度限制处建筑的最大高度
        //     r[0] = new int [] {1, 0};
        //     for (int i = 0; i < m-2; i++) 
        //         r[i+1] = res[i];
        //     r[m-1] = new int [] {n, n-1};
        //     Arrays.sort(r, (x, y) -> x[0] - y[0]);
        //     for (int i = 1; i < m; i++) 
        //         r[i][1] = Math.min(r[i][1], r[i-1][1] + r[i][0] - r[i-1][0]);
        //     for (int i = m-2; i >= 0; i--)
        //         r[i][1] = Math.min(r[i][1], r[i+1][1] + r[i+1][0] - r[i][0]);
        //     int ans = 0;
        //     for (int i = 0; i < m-1; i++) 
        //         ans = Math.max(ans, (r[i+1][0] - r[i][0] + r[i+1][1] + r[i][1]) / 2);
        //     return ans;
        // }

        // public int[] recoverArray(int[] a) {
        //     n = a.length;
        //     Arrays.sort(a);
        //     vis = new boolean [n];
        //     for (int i = 0; i < n; i++) 
        //         m.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
        //     for (int i = 1; i < n; i++) { // 遍历所有的可能性
        //         int k = a[i] - a[0];                  // k是整数，那么2*k肯定是偶数，且，不能为0
        //         if (k == 0 || (k & 1) == 1) continue; // 为奇数或者0不符合要求没必要再进行下一步,题目要求k为正整数
        //         Arrays.fill(vis, false);
        //         ans = isValid(k >> 1, a);
        //         if (ans != null) return ans;
        //     }
        //     return null;
        // }
        // Map<Integer, List<Integer>> m = new HashMap<>(); // 存储当前值对应的下标,由于可能存在相等的值,故value用列表表示
        // boolean [] vis;
        // int n, ans [];
        // int [] isValid(int k, int [] a) { // 检查当前 k 值是否合法, k 已经除过 2 了
        //     int [] ans = new int [n >> 1];
        //     int idx = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (vis[i]) continue; // 被某个 -k 的数配对过了，跳过
        //         List<Integer> tmp = m.get(a[i] + (k << 1)); // k * 2 ( << ) !!! << 的2优先级很低
        //         if (tmp == null) return null;
        //         int j = 0;
        //         while (j < tmp.size()) {
        //             if (vis[tmp.get(j)]) j++;
        //             else break;
        //         }
        //         if (j == tmp.size()) return null; // 找不到合理的解，返回
        //         vis[tmp.get(j)] = true; // 主要是右半部分 a[i]+k，左边（a[i]-k）从左往右遍历，设不设置为 true无所谓
        //         ans[idx++] = a[i] + k;
        //     }
        //     return ans;
        // }

        // // - https://leetcode.com/problems/abbreviating-the-product-of-a-range/discuss/1646608/C%2B%2BJavaPython-Scientific-Notation-oror-Very-Detailed-Explanation-oror-With-and-Without-Logarithm
        // public String abbreviateProduct(int left, int right) { // BUG todo: 没读懂这究竟是在干
        //     long suf = 1; // suffix
        //     int zoos = 0, dts = 0; // zeroes, digits
        //     double pd = 1.0; // product
        //     for (int i = left; i <= right; i++) {
        //         pd *= i;
        //         while (pd >= 1.0) { // keep 0.1 <= prod < 1.0, so len(str(int(prod * 100000))) == 5
        //             pd /= 10.0;
        //             dts ++;         // add 1 while remove 1 digit
        //         }
        //         suf *= i;
        //         while (suf % 10 == 0) {
        //             zoos++;
        //             suf /= 10;
        //         }
        //         if (suf > Math.pow(10, 8)) suf %= (long)Math.pow(10, 8);
        //     }
        //     if (dts - zoos <= 10)
        //         return (long)(pd * Math.pow(10, dts - zoos) + 0.5) + "e" + zoos;
        //     else {
        //         // you may find that I add 0.5 before cast to int above, but not here.
        //         // It is because when org_digits - zeros <= 10, int(prod * (10 ** (org_digits - zeros)) + 0.5) is the actual
        //         // value, we add 0.5 to the last non-zero digits for rounding, 0.5 just means 0.5 over there.
        //         // However here int(prod * 100000) is the first 5-digit prefix, the 6-th digit is also a valid digit not
        //         // error.If we add 0.5 to 6-th digit, how do we calculate the first 6-digit or 7-digit prefix?o
        //         String ssuf = "0000" + Long.toString(suf);
        //         return (int)(pd * 100000) + "..." + ssuf.substring(ssuf.length() - 5) + 'e' + zoos;
        //     }
        // }

        // public boolean reachingPoints(int i, int j, int x, int y) {
        //     while (x >= i && y >= j) {
        //         if (x > y) {
        //             if ((x - i) % y == 0 && y == j) return true; // 恰好能够取得期望整除效果
        //             x = x - x / y * y; // 不能整除，就减去所有能够整除的部分，保留不能整除的剩余慢慢折腾去吧。。。。。。
        //         } else {
        //             if ((y - j) % x == 0 && x == i) return true;
        //             y = y - y / x * x;
        //         }
        //     }
        //     return false;
        //     // while (!(x == i && y == j)) {
        //     //     int min = Math.min(x, y), max = Math.max(x, y);
        //     //     if (max == x) x -= y; // 这是分步极慢做法
        //     //     else y -= x;
        //     //     if (x < i || y < j) break;
        //     // }
        //     // if (x == i && y == j) return true;
        //     // return false;
        // }

        // // interface MountainArray {
        // //     *     public int get(int index) {}
        // //     *     public int length() {}
        // //     * }
        // // int binarySearchPeek(MountainArray a, int l, int r) {
        // //     if (l == r) return l;
        // //     if (l == r -1) return a.get(l) > a.get(r) ? l : r;
        // //     int m = l + (r - l) / 2;
        // //     // 你好歹也把 ma.get(m) 的值记下来，不用调用两遍吧。。。。。。这个如下8次的调用量太恐怖了
        // //     if (a.get(m-1) < a.get(m) && a.get(m) > a.get(m+1)) return m; // bug: it says too many get() calls
        // //     if (a.get(m-1) < a.get(m) && a.get(m) < a.get(m+1))
        // //         return binarySearchPeek(a, m+1, r);
        // //     return binarySearchPeek(a, l, m-1);
        // // }
        // public int findInMountainArray(int t, MountainArray ma) {
        //     int n = ma.length(), l = 0, r = n-1, idx = 0;
        //     while (l < r) { // 
        //         int m = l + (r - l) / 2;
        //         if (ma.get(m) < ma.get(m+1)) l = m + 1;
        //         else r = m; // 
        //     }
        //     idx = l;
        //     if (ma.get(idx) == t) return idx;
        //     int li = binarySearchTarget(ma, 0, idx-1, t, true);
        //     if (li != -1) return li;
        //     return binarySearchTarget(ma, idx+1, n-1, t, false);
        // }
        // int binarySearchTarget(MountainArray a, int l, int r, int v, boolean left) {
        //     while (l < r) {             //
        //         int m = l + (r - l) / 2;
        //         if (a.get(m) == v) return m;
        //         if (a.get(m) < v) {
        //             if (left) l = m + 1;
        //             else r = m;         // 
        //         } else if (left) r = m; //
        //         else l = m + 1;
        //     }
        //     return a.get(r) == v ? r : -1;
        // }
        // public int findInMountainArray(int t, MountainArray ma) { // 还是下面这个速度比较快一点儿
        //     int n = ma.length(), l = 0, r = n-1, idx, v;
        //     while (l <= r) { 
        //         int m = l + (r - l) / 2;
        //         if (ma.get(m) < ma.get(m+1)) l = m + 1;
        //         else r = m-1; 
        //     }
        //     idx = l;
        //     int li = binarySearchTarget(ma, 0, idx, t, true);
        //     if (li != -1) return li;
        //     return binarySearchTarget(ma, idx+1, n-1, t, false);
        // }
        // int binarySearchTarget(MountainArray a, int l, int r, int v, boolean left) { // left: increasing
        //     if (!left) v *= -1; // 这种乘法。。。。。。
        //     while (l <= r) {
        //         int m = (l + r) / 2;
        //         // int val = a.get(m);
        //         int val = a.get(m) * (left ? 1 : -1);
        //         if (val == v) return m;
        //         if (val > v) r = m-1;
        //         else l = m + 1;
        //         // if (left) {
        //         //     if (val > v) r = m-1;
        //         //     else l = m+1;
        //         // } else if (val > v) l = m+1;
        //         // else r = m-1;
        //     }
        //     return -1;
        // }


        // public long maxProduct(String ss) { // BUG: 半头三桩（第二次自己起头写的）
        //     String t = preprocess(ss);
        //     System.out.println("t: " + t); // right: 用来记录最右回文字符串的最右位置
        //     int n = t.length(), sum = 0, right = 0, id = -1 // id: 用来记录最右回文字符串的中心位置
        //         char [] s = t.toCharArray();
        //     int [] p = new int [n]; // 用来记录每个位置的最大回文半径
        //     for (int i = 0; i < n; i++) { // 从左向右依次遍历
        //         if (i <= right) // 从回文半径数获取计算过的回文半径，减少计算
        //             p[i] = Math.min(right-i+id, p[2 * id - i]);
        //         else p[i] = 1; // 初始化每一位置最小半径至少为1
        //         while (i - p[i] >= 0 && i + p[i] < t.length()
        //                && s[i - p[i]] == s[i + p[i]]) // 只有相等的情况才有可能找到最大的回文半径。
        //             p[i]++; // 以 i 为中心，最大限度地向两边扩展
        //         if (p[i] + i -1 > right) { // 当right相同是，取最左边的中心位置效率最高，所以不用更新。
        //             right = p[i] + i - 1;
        //             // id = i;
        //             id = p[i]; //
        //             // sum = Math.right(sum, p[i]);
        //         }
        //     }
        //     return p;
        // }
        // String preprocess(String t) {
        //     if (t.length() == 0) return "";
        //     for (int i = 0; i < t.length(); i++) // 插入字符，统一奇偶性便于计算。
        //         s += "#" + t.charAt(i);
        //     s += "#";
        //     return s.toString();
        // }
        // private String processInput(String t) {
        //     char [] s = t.toCharArray();
        //     // 由于第一个和最后一个字符都是#号，且也需要搜索回文，为了防止越界，我们还需要在首尾再加上非#号字符，实际操作时我们还需给开头加上个非#号字符'$'，结尾加一个'@'
        //     String ans = "$#"; // 不论原字符串是奇数还是偶数个，处理之后得到的字符串的个数都是奇数个，这样就不用分情况讨论了
        //     for (int i = 0; i < t.length(); i++) 
        //         ans += s[i] + "#";
        //     ans += "@";
        //     return ans;
        // }
        // public long maxProduct(String t) {
        //     int m = t.length();
        //     t = processInput(t);
        //     char [] s = t.toCharArray();
        //     int n = s.length;
        //     // 如何求 len 数组，需要新增两个辅助变量 r 和 idx，其中 idx 为最大回文子串中心的位置，r 是回文串能延伸到的最右端的位置
        //     int r = 0, idx = 0; // 最大右边界、最大回文串的中心位置
        //     int [] len = new int [n];
        //     for (int i = 1; i < n-1; i++) {
        //         len[i] = r > i ? Math.min(len[2*idx-i], r-i) : 1;
        //         while (i + len[i] < n-1 && i - len[i] >= 0 && s[i+len[i]] == s[i-len[i]])
        //             ++len[i];
        //         if (r < len[i]+i) {
        //             r = len[i] + i;
        //             idx = i;
        //         }
        //     }
        //     int [] arr = new int [m];
        //     idx = 0;
        //     for (int i = 2; i < n-1; i++) 
        //         if (s[i] != '#' && s[i] != '@') arr[idx++] = len[i] - len[i-1];
        //     int [] pre = new int [m]; 
        //     int [] suf = new int [m];
        //     return 0;
        // }
        // private int expand(int l, int r, String s) {
        //     while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
        //         l--;
        //         r++;
        //     }
        //     return (r - l - 2) / 2;
        // }
        // private int [] manacher(String s) {
        //     int [] ans = new int [s.length()];
        //     int idx = -1, r = -1;
        //     for (int i = 0; i < s.length(); i++) {
        //         int cur = (i <= r ? Math.min(r-i, ans[2 * idx - i]) + 1 : 1);
        //         ans[i] = expand(i-cur, i+cur, s);
        //         if (ans[i] + i > r) {
        //             idx = i;
        //             r = ans[i] + i;
        //         }
        //     }
        //     return ans;
        // }
        // public long maxProduct(String t) { // bug bug bug 不知道哪里错掉了
        //     int n = t.length();
        //     int [] len = manacher(t);
        //     int [] pre = new int [n], suf = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         pre[i] = i;
        //         suf[i] = i;
        //     }
        //     for (int i = 0; i < n; i++) {
        //         suf[i - len[i]] = Math.max(i, suf[i - len[i]]);
        //         pre[i + len[i]] = Math.min(i, pre[i + len[i]]);
        //     }
        //     for (int i = 1; i < n; i++)
        //         suf[i] = Math.max(suf[i], suf[i-1]);
        //     for (int i = n-2; i >= 0; i--) 
        //         pre[i] = Math.min(pre[i], pre[i+1]);
        //     int [] pp = new int [n], ss = new int [n];
        //     pp[0] = 2 * pre[0] + 1;
        //     for (int i = 1; i < n; i++) 
        //         pp[i] = Math.max(pp[i-1], 2 * (i - pre[i]) + 1);
        //     ss[n-1] = 2 * (n-1 - suf[n-1]) + 1;
        //     for (int i = n-2; i >= 0; i--) 
        //         ss[i] = Math.max(suf[i+1], 2 * (suf[i] - i) + 1);
        //     long ans = 1;
        //     for (int i = 0; i < n-1; i++)
        //         ans = Math.max(ans, (long)pp[i] * ss[i+1]);
        //     return ans;
        // }
        // public long maxProduct(String t) { // rolling hash 算法： Time complexity - O(n), space compelxity - O(n). NO collision detection
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     long [] p = new long[n + 1]; // pow[i] = BASE^i
        //     p[0] = 1;
        //     for (int i = 1; i <= n; i++) p[i] = p[i-1] * base % mod;
        //     long [] lh = new long [n+1], rh = new long [n+1]; // 从左向右、从右向左遍历的hash值
        //     for (int i = 1; i <= n; i++)   // s[0, i):   从左向右遍历
        //         lh[i] = (lh[i-1] * base + s[i-1]-'a') % mod;
        //     for (int i = n-1; i >= 0; i--) // s(i, n-1]: 从右向左遍历
        //         rh[i] = (rh[i+1] * base + s[i] - 'a') % mod;
        //     int left [] = new int [n], right [] = new int [n];
        //     for (int i = 0, max = 1; i < n; i++) {    // 以i为 右 端点，回文片段在其左侧的最大回文长度
        //         if (max < i && isPalindromic(i-max-1, i+1, lh, rh, p)) max += 2;
        //         left[i] = max;
        //     }
        //     for (int i = n-1, max = 1; i >= 0; i--) { // 以i为 左 端点，回文片段在其右侧的最大回文长度
        //         if (i + max + 2 <= n && isPalindromic(i, i+max+2, lh, rh, p)) max += 2;
        //         right[i] = max;
        //     }
        //     long ans = 1;
        //     for (int i = 1; i < n; i++)
        //         ans = Math.max(ans, (long)left[i-1] * right[i]);
        //     return ans;
        // }        
        // static final long mod = Integer.MAX_VALUE;
        // static final long base = 29L;
        // static boolean isPalindromic(int l, int r, long [] left, long [] right, long [] p) {
        //     return lh(l, r, left, p) == rh(l, r, right, p);
        // }
        // static long lh(int l, int r, long [] hash, long [] p) {
        //     long ans = (hash[r] - hash[l] * p[r-l]) % mod;
        //     if (ans < 0) ans += mod;
        //     return ans;
        // }
        // static long rh(int l, int r, long [] hash, long [] p) {
        //     long ans = (hash[l] - hash[r] * p[r-l]) % mod;
        //     if (ans < 0) ans += mod;
        //     return ans;
        // }
        // public long maxProduct(String s) { // 
        //     int n = s.length();
        //     int d [] = manacher(s); // 以i为中心的，包括当前字符的单侧最大回文长度
        //     int l [] = new int [n], r [] = new int [n]; // 转化为：以当前坐标为最右、最左极限的全回文片段最大长度
        //     for (int i = 0; i < n; i++) {
        //         l[i+d[i]-1] = Math.max(l[i+d[i]-1], 2 * d[i]-1); // 用第一个当前下标，来更新所有右端所能企及、以右端点为结尾的最大片段长度,从左向右
        //         r[i-d[i]+1] = 2 * d[i] - 1;                      // 用当前回文片段全长，更新以左端点为起始点的最大长度, 从右向左???
        //     }
        //     // if maximum palindrome has end at i and its length is L, then there's a palindrome of length L-2 with end at position i-1
        //     for (int i = n-2, j = n-1; i >= 0; i--, j--) // 从右向左
        //         l[i] = Math.max(l[i], l[j]-2); 
        //     for (int i = 1, j = 0; i < n; i++, j++)      // 从左向右
        //         r[i] = Math.max(r[i], r[j]-2);
        //     // Same fact for beginnings of palindromes
        //     for (int i = 1, j = 0; i < n; i++, j++)
        //         l[i] = Math.max(l[i], l[j]);
        //     for (int i = n-2, j = n-1; i >= 0; i--, j--)
        //         r[i] = Math.max(r[i], r[j]);
        //     long ans = 1;
        //     for (int i = 1; i < n; i++) 
        //         ans = Math.max(ans, (long)l[i-1] * r[i]);
        //     return ans;
        // }
        // static int [] manacher(String t) { // 这个写法可能并不标准： modifiedOddManacher
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int [] ans = new int [n];
        //     for (int i = 0, l = 0, r = -1; i < n; i++) {
        //         int len = i > r ? 1 : Math.min(ans[l+r-i], r-i+1); // 起始单侧长度只有1
        //         int maxLen = Math.min(i, n-1-i); // 就算两边都能对称延伸至两端点，以现i为中心的回文的 单侧最大长度(包括当前下标的字符计算在内)
        //         int x = i - len, y = i + len;
        //         while (len <= maxLen && s[x--] == s[y++]) len++; // 向两侧扩散延伸
        //         ans[i] = len--;
        //         if (i + len > r) {
        //             l = i - len;
        //             r = i + len;
        //         }
        //     }
        //     return ans;
        // }
        // public long maxProduct(String s) { // 这个方法是：目前自己能够理解的解法里最快的
        //     int n = s.length();
        //     StringBuilder sb = new StringBuilder(s);
        //     int [] l = new int [n], r = new int [n];
        //     modifiedOddManacher(sb.toString(), l);
        //     modifiedOddManacher(sb.reverse().toString(), r);
        //     long ans = 1;
        //     for (int i = 0; i < n-1; i++) 
        //         ans = Math.max(ans, (1 + (l[i]-1) * 2l) * (1 + (r[n-(i+1)-1]-1) * 2l));
        //     return ans;
        // }
        // void modifiedOddManacher(String t, int [] d) { 
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int [] idx = new int [n]; // idx: center
        //     for (int i = 0, l = 0, r = -1; i < n; i++) {
        //         int radius = (i > r) ? 1 : Math.min(idx[l+(r-i)], r-i+1);
        //         while (i - radius >= 0 && i + radius < n && s[i-radius] == s[i+radius]) { // 因为半径没有限制，所以要检查两边是否会出界
        //             d[i+radius] = radius + 1;
        //             radius++;
        //         }
        //         idx[i] = radius--;
        //         if (i + radius > r) {
        //             l = i - radius;
        //             r = i + radius;
        //         }
        //     }
        //     for (int i = 0, max = 1; i < n; i++) {
        //         max = Math.max(max, d[i]);
        //         d[i] = max;
        //     }
        // }
        // // Just comapare with basic odd Manacher for better understanding.
        // void oddManacher(String s) { // 是需要对比理解一下
        //     int n = s.length();
        //     int [] idx = new int [n];
        //     for (int i = 0, l = 0, r = -1; i < n; i++) {
        //         int radius = (i > r) ? 1 : Math.min(idx[l+r-i], r-i+1);
        //         while (i - radius >= 0 && i + radius < n && s[i-radius] == s[i+radius]) radius++;
        //         idx[i] = radius--;
        //         if (i + radius > r) {
        //             l = i - radius;
        //             r = i + radius;
        //         }
        //     }
        // }
        // // 需要改天再回过头，把自己解法里的bug找出来
        // public long maxProduct(String s) { // 这个方法稍慢，但思路相对简洁
        //     final int n = s.length();
        //     long ans = 1;
        //     // l[i] := max length of palindromes in s[0..i)
        //     int[] l = manacher(s, n);
        //     // r[i] := max length of palindromes in s[i..n)
        //     int[] r = manacher(new StringBuilder(s).reverse().toString(), n);
        //     reverse(r, 0, n - 1);
        //     for (int i = 0; i + 1 < n; ++i)
        //         ans = Math.max(ans, (long) l[i] * r[i + 1]);
        //     return ans;
        // }
        // private int[] manacher(final String s, int n) {
        //     int[] maxExtends = new int[n];
        //     int[] l2r = new int[n];
        //     Arrays.fill(l2r, 1);
        //     int center = 0;
        //     for (int i = 0; i < n; ++i) {
        //         final int r = center + maxExtends[center] - 1;
        //         final int mirrorIndex = center - (i - center);
        //         int extend = i > r ? 1 : Math.min(maxExtends[mirrorIndex], r - i + 1);
        //         while (i - extend >= 0 && i + extend < n && s.charAt(i - extend) == s.charAt(i + extend)) {
        //             l2r[i + extend] = 2 * extend + 1;
        //             ++extend;
        //         }
        //         maxExtends[i] = extend;
        //         if (i + maxExtends[i] >= r)
        //             center = i;
        //     }
        //     for (int i = 1; i < n; ++i)
        //         l2r[i] = Math.max(l2r[i], l2r[i - 1]);
        //     return l2r;
        // }
        // private void reverse(int[] A, int l, int r) {
        //     while (l < r)
        //         swap(A, l++, r--);
        // }
        // private void swap(int[] A, int i, int j) {
        //     final int temp = A[i];
        //     A[i] = A[j];
        //     A[j] = temp;
        // }

        // public int minJumps(int [] a) {
        //     int n = a.length;
        //     if (n == 1) return 0;
        //     boolean [] vis = new boolean [n];
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         if (i-1 >= 0 && a[i-1] == a[i] && i+1 < n && a[i+1] == a[i]) { // 任何一端的相等元素都可以cover当前元素，直接跳过
        //             vis[i] = true;
        //             continue;
        //         }
        //         m.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
        //     }
        //     Deque<Integer> q = new ArrayDeque<>();
        //     Set<Integer> sc = new HashSet<>(); // set of current
        //     Set<Integer> sn = new HashSet<>(); // set of next
        //     sc.add(0);
        //     int cnt = 0;
        //     while (sc.size() > 0) {
        //         for (int v : sc) q.offerLast(v);
        //         while (!q.isEmpty()) {
        //             int cur = q.pollFirst();
        //             if (cur == n-1) return cnt;
        //             vis[cur] = true;
        //             if (cur < n-1 && !vis[cur+1]) sn.add(cur+1);
        //             if (cur > 0 && !vis[cur-1]) sn.add(cur-1);
        //             for (int idx : m.get(a[cur])) {
        //                 if (vis[idx] || idx == cur) continue;
        //                 if (idx == n-1) return cnt + 1;
        //                 sn.add(idx);
        //             }
        //             m.put(a[cur], new ArrayList<>()); // 每个相同数值只处理一次进队列操作
        //         }
        //         sc.clear();
        //         sc.addAll(sn);
        //         sn.clear();
        //         cnt++;
        //     }
        //     return -1;
        // }
        // public int minJumps(int [] a) { // 比上面的方法快了很多
        //     int n = a.length;
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
        //     int cnt = 0;
        //     boolean [] vis = new boolean [n];
        //     Deque<Integer> q = new ArrayDeque<>();
        //     q.offerLast(0);
        //     vis[0] = true;
        //     while (!q.isEmpty()) {
        //         for (int z = q.size()-1; z >= 0; z--) {
        //             int cur = q.pollFirst();
        //             if (cur == n-1) return cnt;
        //             for (int idx : m.get(a[cur])) 
        //                 if (idx != cur && !vis[idx]) {
        //                     q.offerLast(idx);
        //                     vis[idx] = true;
        //                 }
        //             if (cur-1 >= 0 && !vis[cur-1]) {
        //                 q.offerLast(cur-1);
        //                 vis[cur-1] = true;
        //             }
        //             if (cur+1 < n && !vis[cur+1]) {
        //                 q.offerLast(cur+1);
        //                 vis[cur+1] = true;
        //             }
        //             m.put(a[cur], new ArrayList<>()); // 清零操作：每个相同数值只做入队列操作一次
        //         }
        //         cnt++;
        //     }
        //     return -1;
        // }

        // public double frogPosition(int n, int[][] edges, int t, int target) { // dfs记忆化搜索: 这里记忆化是用不上的，这相当于是暴力！！！
        //     ll = new ArrayList [n+1];
        //     for (int i = 0; i <= n; i++) 
        //         ll[i] = new ArrayList<>();
        //     for (int [] e : edges) {
        //         ll[e[0]].add(e[1]);
                // ll[e[1]].add(e[0]);
        //     }
        //     vis = new boolean [n+1];
        //     dp = new Double [n+1][t+1];
        //     dfs(1, t, target, n);
        //     return dp[1][t];
        // }
        // List<Integer> [] ll;
        // boolean [] vis;
        // Double [][] dp;
        // double dfs(int u, int t, int target, int n) {
        //     if (t < 0 || u < 1 || u > n) return 0;
        //     // if (u == target) return 1.0; // BUG: if t > 0 它还会跳走的
        //     if (u == target && t == 0) return 1.0;
        //     if (dp[u][t] != null) return dp[u][t];
        //     vis[u] = true;
        //     double ans = 0;
        //     int cnt = 0; // valid path cnts
        //     for (int v : ll[u]) {
        //         if (vis[v]) continue;
        //         ans += dfs(v, t-1, target, n);
        //         cnt++;
        //     }
        //     if (cnt == 0 && u == target) return dp[u][t] = 1.0;
        //     return dp[u][t] = cnt == 0 ? 0 : (double)(ans / cnt);
        // }
        // public double frogPosition(int n, int[][] edges, int t, int target) { // BFS
        //     List<Integer> [] ll = new ArrayList [n+1]; // 生成图
        //     for (int i = 0; i <= n; i++) 
        //         ll[i] = new ArrayList<>();
        //     for (int [] e : edges) {
        //         ll[e[0]].add(e[1]);
        //         ll[e[1]].add(e[0]);
        //     }
        //     // BFS处理
        //     boolean [] vis = new boolean [n+1];
        //     double [] dp = new double [n+1];
        //     Deque<Integer> q = new ArrayDeque<>();
        //     q.offerLast(1);
        //     vis[1] = true;
        //     dp[1] = 1;
        //     while (!q.isEmpty() && t-- > 0) { // t--: 压缩代码长度
        //         for (int w = q.size()-1; w >= 0; w--) {
        //             int u = q.pollFirst(), cnt = 0;
        //             for (int v : ll[u])
        //                 if (!vis[v]) cnt++;
        //             for (int v : ll[u]) {
        //                 if (vis[v]) continue;
        //                 vis[v] = true;
        //                 q.offerLast(v);
        //                 dp[v] = dp[u] / cnt; 
        //             }
        //             if (cnt > 0) dp[u] = 0; // 还需继续跳且存在可以跳的结点时，一定不会停留在当前结点
        //         }
        //     }
        //     return dp[target];
        // }
        // public double frogPosition(int n, int[][] edges, int t, int target) { // dfs: 记里记忆化是用不上的！！！这个方法相对会快一点儿
        //     ll = new ArrayList [n+1]; // 生成图
        //     for (int i = 0; i <= n; i++) 
        //         ll[i] = new ArrayList<>();
        //     for (int [] e : edges) {
        //         ll[e[0]].add(e[1]);
        //         ll[e[1]].add(e[0]);
        //     }
        //     // dfs处理
        //     vis = new boolean [n+1];
        //     pre = new int [n+1];
        //     vis[1] = true;
        //     int dep = dfs(1, target);
        //     // 存在以下情况可以判断无法停在target:
        //     // 1. 跳跃的次数 小于 1到target的长度
        //     // 2. 跳跃的次数 大于 1到target的长度 且 还存在可以跳的结点（不管是起点可以跳，还是终点可以跳）
        //     if (t < dep || t > dep && (target == 1 && ll[1].size() > 0 || ll[target].size() > 1))
        //         return 0;
        //     // 累乘得到从结点1走到target的概率的分母
        //     int denominator = 1;
        //     while (pre[target] != 0) {
        //         target = pre[target];
        //         denominator *= target == 1 ? ll[1].size() : ll[target].size()-1;
        //     }            
        //     return 1.0 / denominator;
        // }
        // List<Integer> [] ll;
        // boolean [] vis;
        // int [] pre;
        // int dfs(int u, int target) { // 返回从u到target的长度，无法到达则返回-1
        //     if (u == target) return 0;
        //     for (int v : ll[u]) {
        //         if (vis[v]) continue;
        //         vis[v] = true;
        //         pre[v] = u;
        //         int dep = dfs(v, target);
        //         if (dep >= 0) return 1 + dep;
        //     }
        //     return -1;
        // }

        // // 哪些字符不能为0
        // boolean [] notZero = new boolean[26];
        // // 每一种字符出现的权重
        // int [] wei = new int[26];
        // public boolean isSolvable(String[] sa, String res) {
        //     // 标记字符是否出现过
        //     int [] vis = new int [26];
        //     for (String s : sa) {
        //         int w = 1, idx;
        //         for (int i = s.length()-1; i >= 0; i--) {
        //             idx = s.charAt(i) - 'A';
        //             vis[idx] = 1;  // 权重的奇招是简化这道题解法的灵魂
        //             wei[idx] += w; // 字符是可以重复出现，并且出现在不同的idx位置上，但计算的是 +/- 各位上权重的累加效应
        //             w *= 10;       // 但缺点也在这里：没法裁枝，不方便优化效率 
        //         }
        //         if (s.length() > 1)
        //             notZero[s.charAt(0) - 'A'] = true;
        //     }
        //     int w = 1, idx = 0;
        //     for (int i = res.length()-1; i >= 0; i--) {
        //         idx = res.charAt(i) - 'A';
        //         vis[idx] = 1;
        //         wei[idx] -= w;  // 字符是可以重复出现，并且出现在不同的idx位置上，但计算的是 +/- 各位上权重的累加效应
        //         w *= 10;
        //     }
        //     if (res.length() > 1)
        //         notZero[res.charAt(0) - 'A'] = true;
        //     Integer a [] = new int [Arrays.stream(vis).sum()]; // Integer []: 方便接下来的 排序 和 裁枝优化
        //     idx = 0;
        //     for (int i = 0; i < 26; i++) 
        //         if (vis[i] > 0) a[idx++] = i;
        //     Arrays.sort(a, (x, y) -> Math.abs(wei[y]) - Math.abs(wei[x]));
        //     return dfs(0, 0, new boolean [10], a);
        // }
        // boolean dfs(int idx, int sum, boolean [] vis, Integer [] a) {
        //     if (idx == a.length) return sum == 0; // 终止条件
        //     for (int i = 0; i < 10; i++) { // 遍历每个可以match到的数字
        //         if (notZero[a[idx]] && i == 0 || vis[i]) continue; // 注意这里的match: a[idx] == s.charAt(i)-'A'
        //         vis[i] = true;
        //         if (dfs(idx+1, sum + i * wei[a[idx]], vis, a))     // 遍历每个出现过的字符
        //             return true;
        //         vis[i] = false;
        //     }
        //     return false;
        // }
        // public boolean isSolvable(String[] sa, String res) {
        //     for (String s : sa) {
        //         int w = 1, idx;
        //         for (int i = s.length()-1; i >= 0; i--) {
        //             idx = s.charAt(i) - 'A';
        //             swei.put(idx, swei.getOrDefault(idx, 0) + w); // 字符是可以重复出现，并且出现在不同的idx位置上，但计算的是 +/- 各位上权重的累加效应
        //             w *= 10; // 但缺点也在这里：没法裁枝，不方便优化效率 : 还是可以优化的
        //         }
        //         if (s.length() > 1)
        //             notZero.add(s.charAt(0) - 'A');
        //     }
        //     int w = 1, idx;
        //     for (int i = res.length()-1; i >= 0; i--) {
        //         idx = res.charAt(i) - 'A';
        //         swei.put(idx, swei.getOrDefault(idx, 0) - w); // 字符是可以重复出现，并且出现在不同的idx位置上，但计算的是 +/- 各位上权重的累加效应
        //         w *= 10;
        //     }
        //     if (res.length() > 1)
        //         notZero.add(res.charAt(0) - 'A');
        //     wei = (new ArrayList<Map.Entry<Integer, Integer>>(swei.entrySet())).toArray();
        //     Arrays.sort(wei, (x, y) -> Math.abs(((Map.Entry<Integer, Integer>)y).getValue()) - Math.abs(((Map.Entry<Integer, Integer>)x).getValue()));
        //     int n = swei.size(); 
        //     min = new int [n];
        //     max = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         List<Integer> pos = new ArrayList<>(), neg = new ArrayList<>();
        //         for (int j = i; j < n; j++) {
        //             int v = ((Map.Entry<Integer, Integer>)wei[j]).getValue();
        //             if (v > 0) pos.add(v);
        //             else if (v < 0) neg.add(v);
        //             Collections.sort(pos);
        //             Collections.sort(neg);
        //         }
        //         for (int j = 0; j < pos.size(); j++) {
        //             min[i] += (pos.size()-1-j) * pos.get(j);
        //             max[i] += (10 - pos.size() + j) * pos.get(j);
        //         }
        //         for (int j = 0; j < neg.size(); j++) {
        //             min[i] += (9 - j) * neg.get(j);
        //             max[i] += j * neg.get(j);
        //        }
        //     }
        //     zoos = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         zoos[i] = notZero.contains(((Map.Entry<Integer, Integer>)wei[i]).getKey()) ? 1 : 0;
        //     vis = new boolean [10];
        //     return dfs(0, 0);
        // }
        // List<Integer> notZero = new ArrayList<>();
        // Map<Integer, Integer> swei = new HashMap<>();
        // int [] min, max, zoos;
        // Object [] wei;
        // boolean vis [];
        // boolean dfs(int idx, int sum) {
        //     if (idx == wei.length) return sum == 0;
        //     if (!(sum + min[idx] <= 0 && sum + max[idx] >= 0)) // 剪枝优化
        //         return false;
        //     for (int i = zoos[idx]; i < 10; i++) {
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             boolean check = dfs(idx+1, sum + ((Map.Entry<Integer, Integer>)wei[idx]).getValue() * i);
        //             vis[i] = false;
        //             if (check) return true;
        //         }
        //     }
        //     return false;
        // }

        
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        String []  a = new String []  {"SEND", "MORE"};
        String b = "MONEY";
    //     String []  a = new String []  {"A", "B"};
    // String b = "A";

        boolean r = s.isSolvable(a, b);
        System.out.println("r: " + r);
    } 
} 
