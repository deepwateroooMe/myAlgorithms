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
        // private int getCostOfMST(int n, List<int[]> edges, int[] required, int[] avoid) {
        //     int cost = 0;
        //     DSU dsu = new DSU(n);
        //     if (required != null) {
        //         dsu.union(required[0], required[1]);
        //         cost += required[2];
        //     }
        //     for (int[] edge : edges) {
        //         if (edge != avoid && dsu.union(edge[0], edge[1])) 
        //             cost += edge[2];
        //         if (dsu.getCnt() == 1) 
        //             return cost;
        //     }
        //     return Integer.MAX_VALUE;
        // }
        // public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        //     List<int[]> weights = new ArrayList<>();
        //     for (int[] edge : edges) 
        //         weights.add(edge);
        //     Collections.sort(weights, (w1, w2) -> Integer.compare(w1[2], w2[2]));
        //     List<Integer> critical = new ArrayList<>();
        //     List<Integer> pseudo = new ArrayList<>();
        //     // Min cost of MST.
        //     int minCost = getCostOfMST(n, weights, null, null);
        //     for (int i = 0; i < edges.length; ++i) {
        //         int [] edge = edges[i];
        //         if (getCostOfMST(n, weights, null, edge) > minCost) {
        //             // Without critical edge, cost increases.
        //             critical.add(i);
        //         } else if (getCostOfMST(n, weights, edge, null) == minCost) {
        //             // Since edge is not critical, as long as it can be part of MST, it's pseudo.
        //             pseudo.add(i);
        //         }
        //     }
        //     return Arrays.asList(critical, pseudo);
        // }
        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            List<int []> lia = new ArrayList<>();
            for (int [] e : edges) lia.add(e);
            Collections.sort(lia, (x, y) -> x[2] - y[2]);
            List<Integer> critical = new ArrayList<>();
            List<Integer> pseudo = new ArrayList<>();
            int minCost = getCostOfMST(n, lia, null, null);
            for (int i = 0; i < edges.length; i++) {
                int [] e = edges[i];
                if (getCostOfMST(n, lia, null, e) > minCost) // 优先条件：如果已经是critical,就不用考虑后面的了
                    critical.add(i);
                else if (getCostOfMST(n, lia, e, null) == minCost)
                    pseudo.add(i);
            }
            return Arrays.asList(critical, pseudo);
        }
        int getCostOfMST(int n, List<int []> adj, int [] req, int [] avd) { // avoid 
            int ans = 0;
            DSU dsu = new DSU(n);
            if (req != null) {
                dsu.union(req[0], req[1]);
                ans += req[2];
            }
            for (int [] e : adj) {
                if (e != avd && dsu.union(e[0], e[1])) // 可以合并
                    ans += e[2];
                if (dsu.getCnt() == 1)
                    return ans;
            }
            return Integer.MAX_VALUE; // 无法生成合法的最小生成树
        }
        static class DSU {
            int [] par;
            int [] rank; // 关于rank和size的部分
            int size;
            public boolean union(int x, int y) {
                int px = find(x), py = find(y);
                if (px == py) return false;
                // if (rank[x] >= rank[y]) { // BUG
                if (rank[px] >= rank[py]) {
                    par[py] = px;
                    if (rank[px] == rank[py])
                        ++rank[px];
                    // rank[x] += rank[y]; // BUG: 这里自己写错了
                } else {
                    par[px] = py;
                    // rank[y] += rank[x];
                }
                --size;
                return true;
            }
            public int getCnt() {
                return size;
            }
            int find(int x) {
                // if (par[x] != x) par[x] = find(par[x]); // BUG
                while (par[x] != x) {
                    par[x] = par[par[x]];
                    x = par[x];
                }
                return par[x];
            }
            public DSU(int n) {
                size = n;
                par = new int [n];
                rank = new int [n];
                for (int i = 0; i < n; i++) 
                    par[i] = i;
            }
        }
        // static class DSU {
        //     public boolean union(int x, int y) {
        //         int parentX = find(x);
        //         int parentY = find(y);
        //         if (parentX == parentY) 
        //             return false;
        //         if (rank[parentX] < rank[parentY]) 
        //             parents[parentX] = parentY;
        //         else {
        //             parents[parentY] = parentX;
        //             if (rank[parentX] == rank[parentY]) 
        //                 ++rank[parentX];
        //         }
        //         --size;
        //         return true;
        //     }
        //     public int getCnt() {
        //         return size;
        //     }
        //     public int find(int x) {
        //         while (parents[x] != x) {
        //             parents[x] = parents[parents[x]];
        //             x = parents[x];
        //         }
        //         return parents[x];
        //     }
        //     private int[] parents;
        //     private int[] rank;
        //     private int size;
        //     public DSU(int size) {
        //         this.size = size;
        //         parents = new int[size];
        //         rank = new int[size];
        //         for (int i = 0; i < size; ++i) {
        //             parents[i] = i;
        //         }
        //     }
        // }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
        int [][] a = new int [][] {{0,1,13},{0,2,6},{2,3,13},{3,4,4},{0,5,11},{4,6,14},{4,7,8},{2,8,6},{4,9,6},{7,10,4},{5,11,3},{6,12,7},{12,13,9},{7,13,2},{5,13,10},{0,6,4},{2,7,3},{0,7,8},{1,12,9},{10,12,11},{1,2,7},{1,3,10},{3,10,6},{6,10,4},{4,8,5},{1,13,4},{11,13,8},{2,12,10},{5,8,1},{3,7,6},{7,12,12},{1,7,9},{5,9,1},{2,13,10},{10,11,4},{3,5,10},{6,11,14},{5,12,3},{0,8,13},{8,9,1},{3,6,8},{0,3,4},{2,9,6},{0,11,4},{2,5,14},{4,11,2},{7,11,11},{1,11,6},{2,10,12},{0,13,4},{3,9,9},{4,12,3},{6,7,10},{6,8,13},{9,11,3},{1,6,2},{2,4,12},{0,10,3},{3,12,1},{3,8,12},{1,8,6},{8,13,2},{10,13,12},{9,13,11},{2,11,14},{5,10,9},{5,6,10},{2,6,9},{4,10,7},{3,13,10},{4,13,3},{3,11,9},{7,9,14},{6,9,5},{1,5,12},{4,5,3},{11,12,3},{0,4,8},{5,7,8},{9,12,13},{8,12,12},{1,10,6},{1,9,9},{7,8,9},{9,10,13},{8,11,3},{6,13,7},{0,12,10},{1,4,8},{8,10,2}};

        List<List<Integer>> r = s.findCriticalAndPseudoCriticalEdges(14, a);
        System.out.println("r.size(): " + r.size());
        for (int z = 0; z < r.size(); ++z) 
            System.out.println(Arrays.toString(r.get(z).toArray()));
        
    }
}






