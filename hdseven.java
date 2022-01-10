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

        // private Node head;
        // public Skiplist() {
        //     Node[] left = new Node[16];  // 左侧向下
        //     Node[] right = new Node[16]; // 右侧向下
        //     for(int i = 0; i < 16; i++) {
        //         left[i] = new Node(-1);     // 左侧哨兵： -1
        //         right[i] = new Node(20001); // 右侧消兵:  > 20000
        //     }
        //     for(int i = 0; i < 15; i++) { 
        //         left[i].right = right[i];  // 前15层：左右连接起来
        //         left[i].down = left[i + 1];   // 左 侧消兵：向下连接起来
        //         right[i].down = right[i + 1]; // 右 侧消兵：向下连接起来
        //     }
        //     left[15].right = right[15]; // 最底层： 向右连接起来
        //     head = left[0]; // 总入口
        // }
        // public boolean search(int target) {
        //     Node r = head;
        //     while (r != null) {
        //         if (r.right.val > target)
        //             r = r.down;
        //         else if (r.right.val < target)
        //             r = r.right;
        //         else return true;
        //     }
        //     return false;
        // }
        // public void add(int val) {
        //     Node r = head;
        //     ArrayDeque<Node> s = new ArrayDeque<>();
        //     while (r != null) {
        //         if (r.right.val >= val) {
        //             s.offerLast(r);
        //             r = r.down;
        //         } else r = r.right;
        //     }
        //     Node pre = null;
        //     while (!s.isEmpty()) {
        //         r = s.pollLast();
        //         Node cur = new Node(val);
        //         cur.right = r.right; // 新建节点放入到 r 与 r.right 之间
        //         r.right = cur;
        //         if (pre != null) cur.down = pre; // 如果当前层不是最底层，那么设置新层新插入节点的 down 指向下一层新插入同值节点
        //         pre = cur;  // keep updated
        //         if (Math.random() < 0.5) break;  // 根据这个概率来决定，新插入节点是否继续向上增加节点
        //     }
        // }
        // public boolean erase(int val) {
        //     Node r = head;
        //     boolean ans = false;
        //     while (r != null) {
        //         if (r.right.val >= val) {
        //             if (r.right.val == val) { // 把当前层的这一节点删除
        //                 ans = true;
        //                 r.right = r.right.right; // 
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

    } 
    public static void main (String[] args) {
        Solution s = new Solution ();

        boolean r = s.reachingPoints(1, 1, 3, 5);
        System.out.println("r: " + r);
    } 
} 
