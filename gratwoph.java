import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
// import javafx.util.Pair;

import static java.util.stream.Collectors.toMap;

public class gratwoph {
    public static class Solution {

        // public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        //     HashMap<Integer, List<Integer>> m = new HashMap<>();
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = -1; i < m; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < group.size(); i++) 
        //         m.get(group[i]).add(i);
        //     List<List<Integer>> ll = new ArrayList<>();
        //     for (int i = 0; i < beforeItems.size(); i++) {
        //         if (beforeItems.get(i).size() == 0) continue;
        //         l = new ArrayList<>();
        //         for (int j = 0; j < beforeItems.get(i).size(); j++) {
        //         }
        //     }
        // }

        // public int waysToBuildRooms(int[] prevRoom) {
        //     int n = prevRoom.length;
        //     int [] dp = new int [n];
        //     dp [n-1] = 1;
        //     int cnt = 1;
        //     for (int i = n-2; i >= 0; i--) {
        //         if (prevRoom[i] != prevRoom[i+1]) {
        //             dp[i] = 1;
        //             cnt = 1;
        //         } else {
        //             ++cnt;
        //             dp[i] = cnt * dp[i+1];
        //         }
        //     }
        //     System.out.println("dp.length: " + dp.length);
        //     for (int z = 0; z < dp.length; ++z) 
        //         System.out.print(dp[z] + ", ");
        //     System.out.println("");
        // }

        
        // HashMap<Integer, int []> m = new HashMap<>();
        // HashSet<Integer> s = new HashSet<>();
        // List<List<Integer>> ll = new ArrayList<>();
        // List<Integer> l = new ArrayList<>();
        // int [] cur = null;
        // int minw = 0;
        // UnionFind uf = null;
        // public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        //     HashMap<Integer, int []> map = new HashMap<>();
        //     for (int i = 0; i < edges.length; i++) 
        //         map.put(i, edges[i]);
        //     Comparator<Map.Entry<Integer, int []>> c = new Comparator<Map.Entry<Integer, int []>>() {
        //         @Override 
        //         public int compare(Map.Entry<Integer, int []> a, Map.Entry<Integer, int []> b) {
        //             int cmp1 = (a.getValue())[2] - (b.getValue())[2];
        //             if (cmp1 != 0) {
        //                 return cmp1;
        //             } else {
        //                 return a.getKey().compareTo(b.getKey());
        //             }
        //         }
        //     };
        //     m = map.entrySet().stream().sorted(c)
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        //     uf = new UnionFind(n);
        //     kruskal(n, s, -1, true);
        //     int minG = minw;
        //     l = new ArrayList<>();
        //     uf = new UnionFind(n);
        //     HashSet<Integer> ss = null;
        //     for (Integer val : s) {
        //         minw = 0;
        //         uf = new UnionFind(n);
        //         ss = new HashSet<>();
        //         kruskal(n, ss, val, true);
        //         if (minw > minG || uf.getCnt() > 1) l.add(val);
        //     }
        //     ll.add(l);
        //     l = new ArrayList<>();
        //     for (Integer i : m.keySet()) {
        //         if (ll.get(0).contains(i)) continue;
        //         minw = 0;
        //         uf = new UnionFind(n);
        //         ss = new HashSet<>();
        //         kruskal(n, ss, i, false);
        //         if (minw == minG)
        //             l.add(i);
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
        //         cur = entry.getValue();
        //         if (uf.sameGroup(cur[0], cur[1]) || (entry.getKey() == i && vis)) continue;
        //         if (s.size() < n-1) {
        //             uf.merge(cur[0], cur[1]);
        //             s.add(entry.getKey());
        //             minw += cur[2];
        //         }
        //     }            
        // }

        
        // HashMap<Integer, int []> m = new HashMap<>();
        // HashSet<Integer> s = new HashSet<>();
        // HashSet<Integer> sa = new HashSet<>();
        // HashSet<Integer> sb = new HashSet<>();
        // List<List<Integer>> ll = new ArrayList<>();
        // List<Integer> l = new ArrayList<>();
        // int [] cur = null;
        // int minw = 0;
        // UnionFind uf = null;
        // public int maxNumEdgesToRemove(int n, int[][] edges) {
        //     HashMap<Integer, int []> map = new HashMap<>();
        //     for (int i = 0; i < edges.length; i++) 
        //         map.put(i, edges[i]);
        //     Comparator<Map.Entry<Integer, int []>> c = new Comparator<Map.Entry<Integer, int []>>() {
        //         @Override 
        //         public int compare(Map.Entry<Integer, int []> a, Map.Entry<Integer, int []> b) {
        //             int cmp1 = (b.getValue())[0] - (a.getValue())[0];
        //             if (cmp1 != 0) {
        //                 return cmp1;
        //             } else {
        //                 return a.getKey().compareTo(b.getKey());
        //             }
        //         }
        //     };
        //     m = map.entrySet().stream().sorted(c)
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        //     uf = new UnionFind(n+1);
        //     for (Map.Entry<Integer, int []> entry : m.entrySet()) {
        //         cur = entry.getValue();
        //         if (uf.sameGroup(cur[1], cur[2])) continue;
        //         uf.merge(cur[1], cur[2]);
        //         if (cur[0] == 3) s.add(entry.getKey());
        //         else if (cur[0] == 1) sa.add(entry.getKey());
        //         else sb.add(entry.getKey());
        //     }
        //     if (uf.getCnt() > 2 || sa.size() > 0) return -1;
        //     if (sa.size() == 0) {
        //         if (sb.size() == 0 && uf.getCnt() == 2) return edges.length - s.size();
        //         uf = new UnionFind(n+1);
        //         for (Integer val : s) 
        //             uf.merge(edges[val][1], edges[val][2]);
        //         for (Map.Entry<Integer, int []> entry : m.entrySet()) {
        //             cur = entry.getValue();
        //             if (cur[0] == 1) {
        //                 if (uf.sameGroup(cur[1], cur[2])) continue;
        //                 uf.merge(cur[1], cur[2]);
        //                 sa.add(entry.getKey());
        //                 if (uf.getCnt() == 1) break;
        //             }
        //         }
        //         return edges.length - s.size() -sb.size() - sa.size();
        //     }
        //     return -1;
        // }


        // public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //     List<List<Integer>> ll = new ArrayList<>();
        //     return ll;
        // }

        
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // HashMap<Integer, List<Integer>> o = new HashMap<>();
        // List<Integer> l;
        // int [] vis;
        // int res;
        // public int reachableNodes(int[][] edges, int maxMoves, int n) {
        //     // HashMap<Integer, List<Integer>> map = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //         l = new ArrayList<>();
        //         o.put(i, l);
        //     }
        //     for (int i = 0; i < edges.length; i++) {
        //         m.get(edges[i][0]).add(edges[i][1]);
        //         o.get(edges[i][0]).add(edges[i][2]);
        //         m.get(edges[i][1]).add(edges[i][0]);
        //         o.get(edges[i][1]).add(edges[i][2]);
        //     }
        //     System.out.println("m.size(): " + m.size());
        //     for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
        //         System.out.print(entry.getKey() + ": "); 
        //         for (int z = 0; z < entry.getValue().size(); z++) 
        //             System.out.print(entry.getValue().get(z) + ", ");
        //         System.out.print("\n");
        //     }
        //     res = 0;
        //     vis = new int [n];
        //     vis[0] = -1;
        //     dfs(maxMoves, 0, 1);
        //     System.out.println("res: " + res);
        //     return res;
        // }
        // private void dfs(int k, int i, int cnt) {
        //     System.out.println("\ni: " + i);
        //     System.out.println("k: " + k);
        //     System.out.println("cnt: " + cnt);
        //     if (m.get(i).size() == 0) {
        //         if (cnt > res) res = cnt;
        //         return;
        //     }
        //     int j = 0;
        //     for ( j = 0; j < m.get(i).size(); j++) {
        //         System.out.println("m.get(i).get(j): " + m.get(i).get(j));
        //         if (vis[m.get(i).get(j)] == -1) continue;

        //         System.out.println("o.get(i).get(j): " + o.get(i).get(j));
        //         System.out.println("(o.get(i).get(j) <= k-1): " + (o.get(i).get(j) <= k-1));
        //         if (o.get(i).get(j) <= k-1) {
        //             if (o.get(i).get(j) == k-1) {
        //                 res += o.get(i).get(j) + 1;
        //                 System.out.println("res 0: " + res);
        //                 continue;
        //             } else {
        //                 vis[m.get(i).get(j)] = -1;
        //                 dfs(k-o.get(i).get(j)-1, m.get(i).get(j), cnt + o.get(i).get(j) + 1);
        //                 vis[m.get(i).get(j)] = 1;
        //             }
        //         } else {
        //             res += k;
        //             System.out.println("res 2: " + res);
        //             continue;
        //         }
        //     }
        //     if (j == m.get(i).size()) res = cnt + res;
        // }

        

        // private class Node {
        //     int i;
        //     int t;
        //     int v;
        //     public Node(int a, int b, int c) {
        //         i = a;
        //         t = b;
        //         v = c;
        //     }
        // }
        // Queue<Node> q = new PriorityQueue<>((a, b) -> (a.v - b.v));
        // public void dijkstra(int [][] dp, int k, int [] arr, int t, int i) {
        //     q.add(new Node(i, t, dp[0][0]));
        //     Node tmp = null;
        //     while (!q.isEmpty()) {
        //         tmp = q.poll();
        //         for (int j = 0; j < m.get(tmp.i).size(); j++) {
        //             // if (vis[m.get(tmp.i).get(j)] == -1) continue;
        //             if (v.get(tmp.i).get(j)) continue;
        //             if (tmp.t + o.get(tmp.i).get(j) <= k) {
        //                 if (tmp.v + arr[m.get(tmp.i).get(j)] != dp[t+o.get(tmp.i).get(j)][m.get(tmp.i).get(j)]) {
        //                     dp[tmp.t+o.get(tmp.i).get(j)][m.get(tmp.i).get(j)] = tmp.v + arr[m.get(tmp.i).get(j)];
        //                     if (m.get(tmp.i).get(j) == n-1) return;
        //                     lb = new ArrayList<>(v.get(tmp.i));
        //                     lb.set(j, true);
        //                     v.put(tmp.i, lb);
        //                     // v.get(tmp.i).get(j) = true;
        //                     // vis[m.get(tmp.i).get(j)] = -1;
        //                     q.add(new Node(m.get(tmp.i).get(j), tmp.t + o.get(tmp.i).get(j), dp[tmp.t+o.get(tmp.i).get(j)][m.get(tmp.i).get(j)]));
        //                 }
        //             }
        //         }
        //     }
        // }        

        
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // List<List<Integer>> res = new ArrayList<>(); // for sccs
        // List<List<Integer>> ll = new ArrayList<>();  // 存储割边的容器，容器中存储的是数组，每个数组只有两个元素，表示这个边依附的两个顶点
        // List<Integer> l = new ArrayList<>();
        // Stack<Integer> s = new Stack<>();
        // List<Integer> lv = new ArrayList<>(); // 存储割点集的容器
        // int idx = 0;
        // boolean [] ins;
        // boolean [] iv;  //  用于标记是否是割点
        // int [] dfn;
        // int [] low;
        // int [] pare;
        // private void tarjan(int i, int p) {
        //     System.out.println("\ni: " + i);
        //     dfn[i] = ++idx; // 初始化时间戳                 
        //     low[i] = idx;
        //     System.out.println("dfn[i]: " + dfn[i]);
        //     System.out.println("low[i]: " + low[i]);
        //     s.push(i);
        //     ins[i] = true;
        //     for (int j = 0; j < m.get(i).size(); j++) { // 遍历后续节点
        //         System.out.println("m.get(i).get(j): " + m.get(i).get(j));
        //         System.out.println("(ins[m.get(i).get(j)]: " + (ins[m.get(i).get(j)]));
                
        //         if (dfn[m.get(i).get(j)] == -1) {       // 如果没有被访问过: 如果v不在栈中（树枝边），DFS(v)，并且LOW[u] = min{LOW(u),LOW(v)};
        //             tarjan(m.get(i).get(j), i);            // 递归调用
        //             low[i] = Math.min(low[i], low[m.get(i).get(j)]); // 更新所能到的上层顶点
        //             System.out.println("(low[m.get(i).get(j)] >= dfn[i]): " + (low[m.get(i).get(j)] >= dfn[i]));
                    
        //             if (low[m.get(i).get(j)] >= dfn[i]) { // 判断割点
        //                 iv[i] = true;
        //                 System.out.println("(low[m.get(i).get(j)] > dfn[i]): " + (low[m.get(i).get(j)] > dfn[i]));
        //                 if (low[m.get(i).get(j)] >= dfn[i] && m.get(i).get(j) != p) { // 判断桥
        //                     l = new ArrayList<>();
        //                     l.add(i);
        //                     l.add(m.get(i).get(j));
        //                     ll.add(l);
        //                 }
        //             }
        //         } else if (ins[m.get(i).get(j)]) {      // 如果在栈中，并且被访问过: 如果v在栈中（前向边/后向边），此时LOW[u] = min{LOW[u],DFN[v]}
        //             low[i] = Math.min(low[i], dfn[m.get(i).get(j)]); // 到栈中最上端的节点
        //             // System.out.println("(low[i] == dfn[i]): " + (low[i] == dfn[i]));
        //         }
        //     }
        //     if (low[i] == dfn[i]) { // 发现是整个强连通分量子树里的最小根
        //         l = new ArrayList<>();
        //         int x = -1;
        //         while (i != x) {
        //             x = s.pop();
        //             ins[x] = false;
        //             l.add(x);
        //         }
        //         res.add(l);
        //     }
        // }
        // public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //     for (int i = 0; i < n; i++) {
        //         l  = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < connections.size(); i++) {
        //         m.get(connections.get(i).get(0)).add(connections.get(i).get(1));
        //         m.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        //     }
        //     System.out.println("m.size(): " + m.size());
        //     for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
        //         System.out.print(entry.getKey() + ": "); 
        //         for (int z = 0; z < entry.getValue().size(); z++) 
        //             System.out.print(entry.getValue().get(z) + ", ");
        //         System.out.print("\n");
        //     }
        //     dfn = new int [n];
        //     low = new int [n];
        //     ins = new boolean [n];
        //     iv = new boolean [n];
        //     Arrays.fill(dfn, -1);
        //     Arrays.fill(low, -1);
        //     for (Integer key : m.keySet()) {
        //         if (dfn[key] == -1)
        //             tarjan(key, -1);
        //     }
        //     System.out.println("ll.size(): " + ll.size());
        //     for (int z = 0; z < ll.size(); ++z) {
        //         for (int q = 0; q < ll.get(z).size(); q++) 
        //             System.out.print(ll.get(z).get(q) + ", ");
        //         System.out.print("\n ");
        //     }
        //     return ll;
        // }

        // private class Node {
        //     int i;
        //     double v;
        //     public double getValue() {
        //         return v;
        //     }
        //     public Node(int a, double c) {
        //         i = a;
        //         v = c;
        //     } 
        // }
        // HashMap<Integer, List<Node>> m = new HashMap<>();
        // List<Node> l = new ArrayList<>();
        // public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < succProb.length; i++) {
        //         m.get(edges[i][0]).add(new Node(edges[i][1], Math.log(succProb[i])));
        //         m.get(edges[i][1]).add(new Node(edges[i][0], Math.log(succProb[i])));
        //     }
        //     for (List<Node> val : m.values()) 
        //         Collections.sort(val, Comparator.comparingDouble(Node::getValue).reversed());
        //     // System.out.println("m.size(): " + m.size());
        //     // for (Map.Entry<Integer, List<Node>> entry : m.entrySet()) {
        //     //     System.out.print(entry.getKey() + ": "); 
        //     //     for (int z = 0; z < entry.getValue().size(); z++) 
        //     //         System.out.print("(" + entry.getValue().get(z).i + ", " + entry.getValue().get(z).v + ") ");
        //     //     System.out.print("\n");
        //     // }
        //     arr = new double [n];
        //     Arrays.fill(arr, -Double.MAX_VALUE);
        //     arr[start] = 0;
        //     dijkstra(n, start, end, 0d);
        //     return res == -Double.MAX_VALUE ? 0 : Math.pow(2, res);
        // }
        // double [] arr;
        // double res = -Double.MAX_VALUE;
        // private void dijkstra(int n, int i, int t, double val) {
        //     Queue<Node> q = new PriorityQueue<>(Comparator.comparingDouble(Node::getValue).reversed());
        //     q.add(new Node(i, val));
        //     Node cur = null;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         // System.out.println("\ncur.i: " + cur.i);
        //         for (int j = 0; j < m.get(cur.i).size(); j++) {
        //             // System.out.println("m.get(cur.i).get(j).i: " + m.get(cur.i).get(j).i);
        //             // System.out.println("(m.get(cur.i).get(j).i == t): " + (m.get(cur.i).get(j).i == t));
        //             if (m.get(cur.i).get(j).i == t) {
        //                 if (res < val + m.get(cur.i).get(j).v)
        //                     res = val + m.get(cur.i).get(j).v;
        //                 return;
        //                 // continue;
        //             }
        //             // System.out.println("(arr[m.get(cur.i).get(j).i] < cur.v + m.get(cur.i).get(j).v): " + (arr[m.get(cur.i).get(j).i] < cur.v + m.get(cur.i).get(j).v));
        //             if (arr[m.get(cur.i).get(j).i] < cur.v + m.get(cur.i).get(j).v) {
        //                 arr[m.get(cur.i).get(j).i] = cur.v + m.get(cur.i).get(j).v;
        //                 q.add(new Node(m.get(cur.i).get(j).i, arr[m.get(cur.i).get(j).i]));
        //             }
        //         }
        //     }
        // }


        // static class Eg {
        //     int u, v, next;
        //     // int w;
        //     boolean cut;
        //     // int num;
        // }
        // public Eg[] egs;
        // public int cnt;
        // public int [] fir;
        // int [] low;
        // int [] dfn;
        // int recdfn;
        // void tarjanAddEg(int u, int v, int w) {
        //     egs[cnt] = new Eg();
        //     egs[cnt].u = u;
        //     egs[cnt].v = v;
        //     // egs[cnt].w = w;
        //     egs[cnt].cut = false;
        //     // egs[cnt].num = 0;
        //     egs[cnt].next = fir[u]; // ?
        //     fir[u] = cnt++;         // ?
        // }
        // private void initTarjan(int nodeSize, int edgeSize) {
        //     cnt = 0;
        //     egs = new Eg [edgeSize];
        //     low = new int [nodeSize];
        //     dfn = new int [nodeSize];
        //     fir = new int [edgeSize];
        //     Arrays.fill(fir, -1);
        // }
        // private void tarjan(int u, int fa) { // fa: father
        //     low[u] = ++recdfn;
        //     dfn[u] = recdfn;
        //     int have = 0;
        //     for (int i = fir[u]; i != -1; i = egs[i].next) {
        //         int v = egs[i].v;
        //         if (have == 0 && v == fa) { // 走过你来时的路
        //             have++;
        //             continue;
        //         }
        //         if (dfn[v] == 0) { // dfs过程中还未经过该点
        //             tarjan(v, u);
        //             low[u] = Math.min(low[u], low[v]);
        //             if (dfn[u] < low[v]) { // 连通世外桃源与外界的路
        //                 // 当 dfn[x] < low[y] 的时候:
        //                 // --- 我们发现从yy节点出发,在不经过(x,y)(x,y)的前提下,不管走哪一条边,我们都无法抵达xx节点,或者比xx节点更早出现的节点
        //                 // --- 此时我们发现yy所在的子树似乎形成了一个封闭圈,那么(x,y)(x,y)自然也就是桥了.
        //                 egs[i].cut = true;
        //                 egs[i^1].cut = true; // ???
        //             }
        //         } else {
        //             low[u] = Math.min(low[u], dfn[v]); // 取已访问的节点的dfs序的最小值
        //         }
        //     }
        // }
        // private boolean findEdgeCut(int l, int r) {
        //     Arrays.fill(low, 0);
        //     Arrays.fill(dfn, 0);
        //     recdfn = 0;
        //     tarjan(l, l);
        //     for (int i = l; i <= r; i++) {
        //         if (dfn[i] == 0) return false;
        //     }
        //     return true;
        // }
        // public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //     initTarjan(n, connections.size()*2);
        //     for (List<Integer> eg : connections) {
        //         tarjanAddEg(eg.get(0), eg.get(1), 1);
        //         tarjanAddEg(eg.get(1), eg.get(0), 1);
        //     }
        //     // boolean ans = findEdgeCut(0, n-1);
        //     Arrays.fill(low, 0);
        //     Arrays.fill(dfn, 0);
        //     recdfn = 0;
        //     tarjan(0, 0);
        //     List<List<Integer>> res = new ArrayList<>();
        //     int l = connections.size();
        //     for (int i = 0; i < l * 2; i += 2) { // i += 2 skipped egs[i^1] ?
        //         Eg eg = egs[i];
        //         if (eg != null && eg.cut) {
        //             List<Integer> t = new ArrayList<>();
        //             t.add(eg.u);
        //             t.add(eg.v);
        //             res.add(t);
        //         }
        //     }
        //     return res;
        // }


        // private class Node {
        //     int i;
        //     int v;
        //     public Node (int a, int b) {
        //         i = a;
        //         v = b;
        //     }
        // }
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // List<Integer> l = new ArrayList<>();
        // public int[] gardenNoAdj(int n, int[][] paths) {
        //     int [] arr = new int [n+1];
        //     for (int i = 1; i < n+1; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < paths.length; i++) {
        //         m.get(paths[i][0]).add(paths[i][1]);
        //         m.get(paths[i][1]).add(paths[i][0]);
        //     }
        //     for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) 
        //         Collections.sort(entry.getValue());
        //     // System.out.println("m.size(): " + m.size());
        //     // for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
        //     //     System.out.print(entry.getKey() + ": "); 
        //     //     for (int z = 0; z < entry.getValue().size(); z++) 
        //     //         System.out.print(entry.getValue().get(z) + ", ");
        //     //     System.out.print("\n");
        //     // }
        //     Queue<Node> q = new LinkedList<>();
        //     HashSet<Integer> s = new HashSet<>();
        //     Node tmp = null;
        //     boolean [] vis = new boolean[n+1];
        //     for (int x = 1; x <= n; x++) {
        //         if (arr[x] != 0) continue;
        //         arr[x] = 1;
        //         q.add(new Node(x, 1));
        //         int j = -1;
        //         while (!q.isEmpty()) {
        //             tmp = q.poll();
        //             if (tmp.v < arr[tmp.i]) continue;
        //             s.clear();
        //             vis[tmp.i] = true;
        //             l = m.get(tmp.i);
        //               // System.out.println("\ntmp.i: " + tmp.i);
        //               // System.out.println("tmp.v: " + tmp.v);
        //             s.add(tmp.v);
        //             boolean ups = false;
        //             for (int i = 0; i < l.size(); i++) {
        //                 // System.out.println("l.get(i): " + l.get(i));
        //                 // System.out.println("vis[l.get(i)]: " + vis[l.get(i)]);
        //                 // System.out.println("arr[l.get(i)]: " + arr[l.get(i)]);
        //                 if (arr[l.get(i)] != 0 && !vis[l.get(i)]) {
        //                     if (arr[l.get(i)] == tmp.v) {
        //                         ++arr[l.get(i)];
        //                     } else
        //                     s.add(arr[l.get(i)]);
        //                 } else if (vis[l.get(i)] && arr[l.get(i)] == tmp.v) {
        //                     ups = true;
        //                 }
        //             }
        //             if (ups && s.size() == 1) {
        //                 s.clear();
        //                 for (int i = 0; i < l.size(); i++) 
        //                     s.add(arr[l.get(i)]);
        //                 j = 1;
        //                 while (j < 5 && s.contains(j)) ++j;
        //                 arr[tmp.i] = j;
        //                 continue;
        //             }
        //             // System.out.println("s.size(): " + s.size());
        //             // for (Integer z : s)
        //             //     System.out.print(z + ", ");
        //             // System.out.print("\n");
        //             j = 1;
        //             while (j < 5 && s.contains(j)) ++j;
        //             // System.out.println("j: " + j);
        //             for (int i = 0; i < l.size(); i++) {
        //                 if (vis[l.get(i)]) continue;
        //                 if (arr[l.get(i)] == 0) 
        //                     arr[l.get(i)] = j;
        //                 q.add(new Node(l.get(i), arr[l.get(i)]));
        //             }
        //         }
        //     }
        //     int [] res = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         res[i] = arr[i+1];
        //     return res;
        // }
        // int [][] a = new int [][] {{3,4},{4,5},{3,2},{5,1},{1,3},{4,2}}; 
        // int [][] a = new int [][] {{1,2},{3,4}}; 
        // int [][] a = new int [][] {{3,4},{4,5},{3,2},{5,1},{1,3},{4,2}}; 
        // int [][] a = new int [][] {{1,2},{2,3},{3,1}}; 
        // int [][] a = new int [][] {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}}; 
        // int [][] a = new int [][] {{1,4},{7,5},{4,5},{6,4},{9,7},{9,2},{1,5},{6,7},{1,8},{3,6},{3,2},{3,9}}; 
        // int [][] a = new int [][] {{8,7},{26,19},{23,8},{19,17},{29,25},{16,6},{8,15},{13,23},{1,28},{19,27},{9,30},{7,28},{30,4},{15,12},{1,10},{10,3},{18,28},{9,20},{13,1},{26,3},{24,29},{10,6},{3,23},{27,14},{13,24},{21,16},{17,30},{21,26},{16,18},{6,4},{4,7},{27,2},{2,5},{14,22},{29,14},{25,5}}; 

        
        // private class Pt {
        //     int i;
        //     int v;
        //     public Pt (int a, int b) {
        //         i = a;
        //         v = b;
        //     }
        // }
        // HashMap<Integer, List<Pt>> m = new HashMap<>();
        // List<Pt> l = new ArrayList<>();
        // int [] arr;
        // public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        //     Arrays.sort(edgeList, new Comparator<int []>() {
        //             public int compare( int [] x, int [] y ) {
        //                 if ( x[2] != y[2]) return x[2] - y[2];
        //                 return x[0] - y[0];
        //             }
        //         });
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < edgeList.length; i++) {
        //         m.get(edgeList[i][0]).add(new Pt(edgeList[i][1], edgeList[i][2]));
        //         m.get(edgeList[i][1]).add(new Pt(edgeList[i][0], edgeList[i][2]));
        //     }
        //     for (Map.Entry<Integer, List<Pt>> entry : m.entrySet()) {
        //         Collections.sort(entry.getValue(), new Comparator<Pt>() {
        //                 @Override public int compare(Pt x, Pt y) {
        //                     if (x.v == y.v) return x.i - y.i;
        //                     else return x.v - y.v;
        //                 }
        //             });
        //     }
        //     // System.out.println("m.size(): " + m.size());
        //     // for (Map.Entry<Integer, List<Pt>> entry : m.entrySet()) {
        //     //     System.out.print(entry.getKey() + ": "); 
        //     //     for (int z = 0; z < entry.getValue().size(); z++) 
        //     //         System.out.print("[" + entry.getValue().get(z).i + ", " + entry.getValue().get(z).v + "]");
        //     //     System.out.print("\n");
        //     // }
        //     Arrays.sort(queries, new Comparator<int []>() {
        //             public int compare( int [] x, int [] y ) {
        //                 if ( x[0] != y[0]) return x[0] - y[0];
        //                 return x[1] - y[1];
        //             }
        //         });
        //     arr = new int [n];
        //     boolean [] res = new boolean[queries.length];
        //     for (int i = 0; i < queries.length; i++) {
        //         Arrays.fill(arr, Integer.MAX_VALUE);
        //         arr[queries[i][0]] = 0;
        //         if (queries[i][0] == queries[i][1]) res[i] = true;
        //         else res[i] = reachable(queries[i][0], queries[i][1], queries[i][2]);
        //     }
        //     return res;
        // }
        // private boolean reachable(int s, int t, int k) {
        //     Arrays.fill(arr, Integer.MAX_VALUE);
        //     arr[s] = 0;
        //     Queue<Pt> q = new LinkedList<>();
        //     q.add(new Pt(s, 0));
        //     Pt cur = null, one;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         System.out.println("\ncur.i: " + cur.i);
        //         System.out.println("cur.v: " + cur.v);
        //         if (cur.v > arr[cur.i] || cur.v > k) continue;
        //         for (int i = 0; i < m.get(cur.i).size(); i++) {
        //             one = m.get(cur.i).get(i);
        //             if (one.i == t && cur.v + one.v <= k) return true;
        //             if (cur.v + one.v > k) break;
        //             if (arr[one.i] > cur.v + one.v) arr[one.i] = cur.v + one.v;
        //             if (arr[one.i] < k)
        //                 q.add(new Pt(one.i, arr[one.i]));
        //         }
        //     }
        //     return false;
        // }


        // public int largestPathValue(String colors, int[][] edges) {
        //     int n = colors.length();
        //     int[] deg = new int[n];//各节点入度
        //     Arrays.fill(deg, 0);
        //     List<List<Integer>> list = new ArrayList<List<Integer>>(n);//邻接表
        //     for (int i = 0; i < n; i++)
        //         list.add(new ArrayList<Integer>());
        //     //入度和邻接表初始化
        //     for (int[] edge : edges) {
        //         int u = edge[0], v = edge[1];
        //         deg[v]++;
        //         list.get(u).add(v);
        //     }
        //     //拓扑排序
        //     int[] topo = new int[n];
        //     int nodeNum = 0;//当前已拓扑排序的节点数
        //     Queue<Integer> q = new LinkedList<>();//暂存当前入度为0的节点
        //     for (int i = 0; i < n; i++)
        //         if (deg[i] == 0)
        //             q.offer(i);
        //     while (!q.isEmpty()) {
        //         int u = q.poll();
        //         topo[nodeNum++] = u;
        //         for (Integer v : list.get(u)) {
        //             if (--deg[v] == 0)
        //                 q.offer(v);
        //         }
        //     }
        //     if (nodeNum < n)//图中有环
        //         return -1;
        //     int ans = 0;
        //     for (int i = 0; i < 26; i++) {//依次遍历26种颜色
        //         char color =(char)((int)'a' + i);//当前颜色
        //         int[] dp = new int[n];//动态规划结果
        //         Arrays.fill(dp, 0);
        //         for (int j = n - 1; j >= 0; j--) {//按照拓扑顺序从后向前动态规划
        //             int u = topo[j];
        //             for (Integer v : list.get(u))
        //                 dp[u] = Math.max(dp[u], dp[v]);//后续路径中当前颜色的最大节点个数
        //             if (colors.charAt(u) == color)
        //                 dp[u]++;
        //             ans = Math.max(ans, dp[u]);
        //         }
        //     }
        //     return ans;
        // }

        // public int largestPathValue(String colors, int[][] edges) {
        //     int n = colors.length();
        //     int [] ins = new int[n];
        //     List<List<Integer>> ll = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         ll.add(new ArrayList<>());
        //     for (int i = 0; i < edges.length; i++) {
        //         ++ins[edges[i][1]];
        //         ll.get(edges[i][0]).add(edges[i][1]);
        //     }
        //     Queue<Integer> q = new LinkedList<>();
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         if (ins[i] == 0) q.add(i);
        //     int cur = 0;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         l.add(cur);
        //         for (Integer val : ll.get(cur)) {
        //             if (--ins[val] == 0)
        //                 q.add(val);
        //         }
        //     }
        //     if (l.size() < n) return -1;
        //     int res = 0;
        //     for (int i = 0; i < 26; i++) {
        //         char color = (char)((int)'a'+i);
        //         int [] dp = new int[n];
        //         for (int j = n-1; j >= 0; j--) {
        //             int  u = l.get(j);
        //             for (Integer v : ll.get(u)) 
        //                 dp[u] = Math.max(dp[u], dp[v]);
        //             if (colors.charAt(u) == color)
        //                 dp[u]++;
        //             res = Math.max(res, dp[u]);
        //         }
        //     }
        //     return res; 
        // }


        // HashMap<String, HashMap<String, Double>> m = new HashMap<>();
        // public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //     m = new HashMap<>();
        //     HashSet<String> ss = new HashSet<>(); // set of String variables: set is faster
        //     HashMap<String, Double> l = new HashMap<>();
        //     for (int i = 0; i < equations.size(); i++) {
        //         l = new HashMap<>();
        //         m.put(equations.get(i).get(0), l);
        //         l = new HashMap<>();
        //         m.put(equations.get(i).get(1), l);
        //     }
        //     for (int i = 0; i < equations.size(); i++) {
        //         m.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
        //         m.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1.0 / values[i]);
        //         ss.add(equations.get(i).get(0));
        //         ss.add(equations.get(i).get(1));
        //     }
        //     double [] res = new double[queries.size()];
        //     for (int i = 0; i < queries.size(); i++) {
        //         if ((!ss.contains(queries.get(i).get(0))) || (!ss.contains(queries.get(i).get(1)))) {
        //             res[i] = -1.00000;
        //             continue;
        //         } // 这上面的这个条件要吗？改天可以再好好检查一下 e
        //         if (queries.get(i).get(0) == queries.get(i).get(1) && m.containsKey(queries.get(i).get(0))) {
        //             res[i] = 1.00000;
        //             continue;
        //         }
        //         HashSet<String> s = new HashSet<>(); // visited equations
        //         double t = helper(queries.get(i).get(0), queries.get(i).get(1), s);
        //         res[i] = t;
        //     }
        //     return res;
        // }
        // private double helper(String up, String down, HashSet<String> s) {
        //     if (m.containsKey(up) && m.get(up).containsKey(down)) return m.get(up).get(down);
        //     for (Map.Entry<String, Double> entry : m.get(up).entrySet()) {
        //         String key = entry.getKey();
        //         if (s.contains(key)) continue;
        //         s.add(key);
        //         double t = helper(key, down, s);
        //         if (t > 0.0) return t * entry.getValue();
        //     }
        //     return -1.0;
        // }

        
        // private void dfs(int i, List<Integer> li) {
        //     if (m.get(i).length == 0 || (m.get(i).length == 1 && res.contains((m.get(i))[0]))) {
        //         return;
        //     } else if ((m.get(i).length == 1 && s.contains((m.get(i))[0]))) {
        //         safe = false;
        //         return;
        //     }
        //     for (int j = 0; j < m.get(i).length; j++) {
        //         if (vis[(m.get(i))[j]] == -1 && !li.contains((m.get(i))[j])) continue;
        //         else if (li.contains((m.get(i))[j]) || s.contains((m.get(i))[j]) || (m.get(i))[j] == i) {
        //             safe = false;
        //             return;
        //         }
        //         vis[(m.get(i))[j]] = -1;
        //         t = new ArrayList<>(li);
        //         t.add((m.get(i))[j]);
        //         dfs((m.get(i))[j], t);
        //         vis[(m.get(i))[j]] = 1;
        //     }
        // }
        // List<Integer> t;
        // HashSet<Integer> s = new HashSet<>();
        // HashMap<Integer, int []> m;
        // List<Integer> res;
        // boolean safe;
        // int [] vis;
        // int [] tmp;
        // int n;
        // public List<Integer> eventualSafeNodes(int[][] graph) {
        //     HashMap<Integer, int []> map = new HashMap<>();
        //     List<Integer> l = new ArrayList<>();
        //     n = graph.length;
        //     for (int i = 0; i < n; i++)
        //         map.put(i, graph[i]);
        //     m = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        //     res = new ArrayList<>();
        //     vis = new int[n];
        //     for (Map.Entry<Integer, int []> entry : m.entrySet()) {
        //         tmp = entry.getValue();
        //         if (tmp.length == 0 || (tmp.length == 1 && res.contains(tmp[0]))) {
        //             res.add(0, entry.getKey());
        //             continue;
        //         }
        //         vis[entry.getKey()] = -1;
        //         l = new ArrayList<>();
        //         l.add(entry.getKey());
        //         safe = true;
        //         dfs(entry.getKey(), l);
        //         vis[entry.getKey()] = 1;
        //         if (safe) res.add(0, entry.getKey());
        //         else s.add(entry.getKey());
        //     }            
        //     return res;
        // }
        // enum Color {
        //     WHITE, BLACK, GREY,
        // }
        // public boolean dfs(int [][] arr, int i, Color [] color) {
        //     if (color[i] != Color.WHITE)
        //         return color[i] == Color.BLACK;
        //     color[i] = Color.GREY;
        //     for (int val : arr[i]) {
        //         if (!dfs(arr, val, color)) return false;
        //     }
        //     color[i] = Color.BLACK;
        //     return true;
        // }
        // public List<Integer> eventualSafeNodes(int[][] graph) {
        //     List<Integer> res = new ArrayList<>();
        //     if (graph.length == 0) return res;
        //     Color [] color = new Color [graph.length];
        //     Arrays.fill(color, Color.WHITE);
        //     for (int i = 0; i < graph.length; i++) {
        //         if (dfs(graph, i, color)) res.add(i);
        //     }
        //     return res;
        // }
        // public List<Integer> eventualSafeNodes(int[][] arr) {
        //     List<Integer> res = new ArrayList<>();
        //     int n = arr.length;
        //     if (n == 0) return res;
        //     List<Set<Integer>> graph = new ArrayList<>(); // 正向边图
        //     List<Set<Integer>> rgraph = new ArrayList<>();// 反向边图
        //     Queue<Integer> q = new LinkedList<>();        // 安全节点队列
        //     boolean [] safe = new boolean[n];
        //     for (int i = 0; i < n; i++) {
        //         graph.add(new HashSet<Integer>());
        //         rgraph.add(new HashSet<Integer>());
        //     }
        //     for (int i = 0; i < n; i++) {
        //         for (int j : arr[i]) {
        //             graph.get(i).add(j);
        //             rgraph.get(j).add(i);
        //         }
        //         if (arr[i].length == 0) q.offer(i);
        //     }
        //     while (!q.isEmpty()) {
        //         int i = q.poll();
        //         safe[i] = true;
        //         for (int j : rgraph.get(i)) {
        //             graph.get(j).remove(i);
        //             if (graph.get(j).isEmpty()) q.offer(j);
        //         }
        //     }
        //     for (int i = 0; i < n; i++) 
        //         if (safe[i]) res.add(i);
        //     return res;
        // }


        // public int minTrioDegree(int n, int[][] edges) {
        //     HashMap<Integer, List<Integer>> m = new HashMap<>();
        //     List<Integer> l;
        //     boolean [] vis = new boolean[n+1];
        //     for (int i = 0; i < n+1; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < edges.length; i++) {
        //         m.get(edges[i][0]).add(edges[i][1]);
        //         m.get(edges[i][1]).add(edges[i][0]);
        //     }
        //     int min = Integer.MAX_VALUE;
        //     int val = -1;
        //     for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
        //         if (vis[entry.getKey()]) continue;
        //         vis[entry.getKey()] = true;
        //         l = entry.getValue();
        //         if (l.size() < 2) continue;
        //         for (int i = 0; i < l.size(); i++) {
        //             for (int j = 1; j < l.size(); j++) {
        //                 if (j == i || vis[l.get(i)] || vis[l.get(j)]) continue;
        //                 if (m.get(l.get(i)).contains(l.get(j))) {
        //                     val = l.size() + m.get(l.get(i)).size() + m.get(l.get(j)).size() - 6;
        //                     if (val < min) min = val;
        //                 }
        //             }
        //         }
        //     }
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }
        // public int minTrioDegree(int n, int[][] edges) {
        //     int m = edges.length;
        //     int maxSize = 401;
        //     boolean [][] arr = new boolean[maxSize][maxSize];
        //     int [] ins = new int[n+1];
        //     for (int i = 0; i < m; i++) {
        //         int x = edges[i][0], y = edges[i][1];
        //         arr[x][y] = true;
        //         arr[y][x] = true;
        //         ins[x]++;
        //         ins[y]++;
        //     }
        //     int res = Integer.MAX_VALUE;
        //     for (int i = 1; i <= n; i++) {
        //         for (int j = i+1; j <= n; j++) {
        //             if (arr[i][j]) {
        //                 for (int k = j+1; k <= n; k++) {
        //                     if (arr[j][k] && arr[i][k])
        //                         res = Math.min(res, ins[i] + ins[j] + ins[k] - 6);
        //                 }
        //             }
        //         }
        //     }
        //     return res == Integer.MAX_VALUE ? -1 : res;
        // }


        
        // private class Node {
        //     int i;
        //     int v;
        //     public Node(int a, int b) {
        //         i = a;
        //         v = b;
        //     }
        // }
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // HashMap<Integer, List<Integer>> o = new HashMap<>();
        // HashSet<Integer> s = new HashSet<>();
        // int res;
        // public int networkDelayTime(int[][] times, int n, int k) {
        //     if (n == 1) return times[0][0] == k ? times[0][2] : -1;
        //     if (n == 2) return times[0][0] == k ? times[0][2] : (times.length > 1 && times[1][0] == k ? times[1][2] : -1);
        //     Arrays.sort(times, new Comparator<int []>() {
        //             public int compare(int [] a, int [] b) {
        //                 if (a[2] != b[2]) return a[2] - b[2];
        //                 else return a[0] - b[0];
        //             }
        //         });
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n+1; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //         l = new ArrayList<>();
        //         o.put(i, l);
        //     }
        //     for (int i = 0; i < times.length; i++) {
        //         m.get(times[i][0]).add(times[i][1]);
        //         o.get(times[i][0]).add(times[i][2]);
        //     }
        //     UnionFind uf = new UnionFind(n+1);
        //     for (int i = k; i < n+1; i++) 
        //         for (int j = 0; j < m.get(i).size(); j++) {
        //             if (!uf.sameGroup(i, m.get(i).get(j)))
        //                 uf.merge(i, m.get(i).get(j));
        //         }
        //     for (int i = 0; i < k; i++) 
        //         for (int j = 0; j < m.get(i).size(); j++) {
        //             if (!uf.sameGroup(i, m.get(i).get(j)))
        //                 uf.merge(i, m.get(i).get(j));
        //         }
        //     if (uf.getCnt() > 2) return -1;
        //     arr = new int[n+1];
        //     res = Integer.MAX_VALUE;
        //     Arrays.fill(arr, Integer.MAX_VALUE);
        //     arr[k] = 0;
        //     dijstr(n, k, 0);
        //     if (s.size() == n) return res;
        //     return -1;
        // }
        // int [] arr;
        // private void dijstr(int n, int i, int val) {
        //     Queue<Node> q = new PriorityQueue<>((x, y) -> x.v - y.v);
        //     q.add(new Node(i, val));
        //     s.add(i);
        //     Node cur = null;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         if (m.get(cur.i).size() == 0) {
        //             if (cur.v < res && s.size() == n) res = cur.v;
        //             continue;
        //         }
        //         for (int j = 0; j < m.get(cur.i).size(); j++) {
        //              System.out.println("m.get(cur.i).get(j): " + m.get(cur.i).get(j));
        //             if (arr[m.get(cur.i).get(j)] > cur.v + o.get(cur.i).get(j)) {
        //                 arr[m.get(cur.i).get(j)] = cur.v + o.get(cur.i).get(j);
        //             }
        //             if (m.get(cur.i).get(j) != i) { // handling back edges
        //                 s.add(m.get(cur.i).get(j));
        //                 q.add(new Node(m.get(cur.i).get(j), arr[m.get(cur.i).get(j)]));
        //             }
        //         }
        //     }
        // }        


        // private void helper(int [] arr, int n, int limit, int mask, int cnt) {
        //     if (cnt >= min) return;
        //     if (Integer.bitCount(mask) == n) {
        //         min = Math.min(min, cnt);
        //         return;
        //     }
        //     int bitCount = Integer.bitCount(mask), cur = 0;
        //     for (int i = 0; i < n+1; i++) {
        //         if (arr[i] > 0 || (cur & (1 << j)) == 1) continue;
        //         cur = (mask | (1 << i));
        //         // int [] ins = new int [n+1];
        //         // System.arraycopy(arr, 0, ins, 0, n+1);
        //         for (int k = 0; k < m.get(i).size(); k++) // 如果一次只选不门课，不是很好处理
        //             ins[m.get(i).get(k)]--;
        //         helper(arr, n, limit, cur, () cnt);
        //         // for (int j = i; j < i+Math.min(avCnt, limit) && j < n+1; j++) {
        //         //     if (arr[j] == 0 && ((cur & (1 << j)) == 0)) {
        //         //         cur |= (1 << j);
        //         //         for (int k = 0; k < m.get(j).size(); k++) 
        //         //             ins[m.get(j).get(k)]--;
        //         //     }
        //         // }
        //         helper(ins, n, limit, cur, cnt+1);
        //     }
        // }
        // HashMap<Integer, List<Integer>> m;
        // int [] sem;
        // // boolean [] vis;
        // int min;
        // public int minNumberOfSemesters(int n, int[][] relations, int k) {
        //     if (relations == null || relations.length == 0 || relations[0].length == 0) return n % k == 0 ? n / k : n / k + 1;
        //     m = new HashMap<>();
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 1; i <= n; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     sem = new int [n+1];
        //     int [] ins = new int [n+1];
        //     ins[0] = -1;
        //     // vis = new boolean[n+1];
        //     for (int i = 0; i < relations.length; i++) {
        //         ins[relations[i][1]]++;
        //         m.get(relations[i][0]).add(relations[i][1]);
        //     }
        //     min = Integer.MAX_VALUE;
        //     helper(ins, n, k, (1 << n), 0);
        //     return min;
        // }
        // int [][] a = new int [][] {{12,8},{2,4},{3,7},{6,8},{11,8},{9,4},{9,7},{12,4},{11,4},{6,4},{1,4},{10,7},{10,4},{1,7},{1,8},{2,7},{8,4},{10,8},{12,7},{5,4},{3,4},{11,7},{7,4},{13,4},{9,8},{13,8}};
        // int res = s.minNumberOfSemesters(13, a, 9);


        // private class DisjointSetUnion {
        //     private int N;
        //     private int [] parent, rank;
        //     public DisjointSetUnion( int n) {
        //         this.N = n;
        //         this.parent = new int [N];
        //         this.rank = new int [N];
        //         for (int i = 0; i < N; i++) {
        //             this.parent[i] = i;
        //             this.rank[i] = 1;
        //         }
        //     }
        //     public boolean areConnected(int u, int v) {
        //         return find(u) == find(v);
        //     }
        //     public void union(int u, int v) {
        //         if (u != v) {
        //             int p = find(u);
        //             int q = find(v);
        //             if (p != q) {
        //                 if (rank[p] > rank[q]) {
        //                     parent[q] = p;
        //                     rank[p] += rank[q];
        //                 } else {
        //                     parent[p] = q;
        //                     rank[q] += rank[p];
        //                 }
        //             }
        //         }
        //     }
        //     private int find(int v) { // 我记得这里有个同步更新父数组的优化步骤，和rank优化冲突吗？要总结一下
        //         int x = v;
        //         while (x != parent[x])
        //             x = parent[x];
        //         parent[v] = x;
        //         return x;
        //     }
        // }
        // class Query implements Comparable<Query> {
        //     public int idx, start, end, weight;
        //     public Query(int idx, int bgn, int end, int weight) {
        //         this.idx = idx;
        //         this.start = bgn;
        //         this.end = end;
        //         this.weight = weight;
        //     }
        //     @Override public int compareTo(Query query) {
        //         return this.weight - query.weight;
        //     }
        // }
        // // 我们可以分别对 edges 和 queries 进行一次升序排序。本题和 1170. 比较字符串最小字母出现频次 类似， 都可以采取 *离线排序优化* 的方式来解。
        // // 接下来，遍历 queries。遍历 queries 的同时将权值小于 limitj 的边进行合并。
        // // 接下来，我们只需要判断 pj 和 qj 是否已经在同一个联通域即可。
        // // 因此如果 pj 和 qj 在同一个联通域，那么其联通的路径上的所有边必定都小于 limitj，其原因就是前面加粗的那句话。
        // // 注意到排序打乱了 queries 的索引，因此我们需要记录一下其原始索引。
        // public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        //     DisjointSetUnion set = new DisjointSetUnion(n);
        //     Arrays.sort(edgeList, (a, b) -> a[2]-b[2]); // arrange edges in ascending order of weights
        //     int m = queries.length, i;
        //     int E = edgeList.length;
        //     Query [] qarr = new Query[m];
        //     for (i = 0; i < m; i++) 
        //         qarr[i] = new Query(i, queries[i][0], queries[i][1], queries[i][2]);
        //     Arrays.sort(qarr);                // arrange queries in ascending order of threshold weights
        //     boolean [] ans = new boolean [m];
        //     int idx = 0;
        //     for (i = 0; i < m; i++) {
        //         while (idx < E && edgeList[idx][2] < qarr[i].weight) {
        //             set.union(edgeList[idx][0], edgeList[idx][1]);
        //             ++idx;
        //         }
        //         ans[qarr[i].idx] = set.areConnected(qarr[i].start, qarr[i].end);
        //     }
        //     return ans;
        // }
        // // 令 m, q edges 和 queries 的长度。
        // //     时间复杂度：$O(mlogm + qlogq)
        // //     空间复杂度：$O(n + q)

        
        // public class DistanceLimitedPathsExist {
        //     class UnionFind {
        //         private int[] p;
        //         public UnionFind(int size) {
        //             p = new int[size];
        //             for (int i = 0; i < size; i++) 
        //                 p[i] = i;
        //         }
        //         public int find(int x) {
        //             if (p[x] != x) 
        //                 p[x] = find(p[x]);
        //             return p[x];
        //         }
        //         public void union(int x, int y) {
        //             int px = find(x), py = find(y);
        //             if (px != py) 
        //                 p[px] = py;
        //         }
        //     }
        //     private UnionFind uf;
        //     // 这里是链式前向星建图
        //     private int[] h, e, ne, w;
        //     private int idx;
        //     private void add(int a, int b, int c) {
        //         e[idx] = b;
        //         ne[idx] = h[a];
        //         w[idx] = c;
        //         h[a] = idx++;
        //     }
        //     // 这里是倍增法所需的数组和变量
        //     private int[][] f, g;
        //     private int[] depth;
        //     // n是顶点数，log是n对2的对数，log + 1也是f的第二维应该开的长度
        //     private int n, log;
        //     public DistanceLimitedPathsExist(int n, int[][] edgeList) {
        //         this.n = n;
        //         depth = new int[n];
        //         h = new int[n];
        //         Arrays.fill(h, -1);
        //         // 无向图，边要开两倍
        //         e = new int[n << 1];
        //         ne = new int[n << 1];
        //         w = new int[n << 1];
        //         // 这一段是Kruskal算法建最小生成森林
        //         Arrays.sort(edgeList, (e1, e2) -> Integer.compare(e1[2], e2[2]));
        //         uf = new UnionFind(n);
        //         for (int[] e : edgeList) {
        //             int a = e[0], b = e[1], len = e[2];
        //             if (uf.find(a) != uf.find(b)) {
        //                 uf.union(a, b);
        //                 add(a, b, len);
        //                 add(b, a, len);
        //             }
        //         }
        //         log = (int) (Math.log(n) / Math.log(2));
        //         f = new int[n][log + 1];
        //         g = new int[n][log + 1];
        //         for (int[] row : f) {
        //             Arrays.fill(row, -1);
        //         }
        //         boolean[] vis = new boolean[n];
        //         for (int i = 0; i < n; i++) {
        //             if (!vis[i]) {
        //                 bfs(i, vis);
        //             }
        //         }
        //         init();
        //     }
        //     // 递推一遍f和g数组
        //     private void init() {
        //         for (int i = 1; i < log + 1; i++) {
        //             for (int j = 0; j < n; j++) {
        //                 if (f[j][i - 1] != -1) {
        //                     f[j][i] = f[f[j][i - 1]][i - 1];
        //                     g[j][i] = Math.max(g[j][i - 1], g[f[j][i - 1]][i - 1]);
        //                 }
        //             }
        //         }
        //     }
        //     // BFS一遍x所在连通块，并初始化f和g数组，并求出depth数组
        //     private void bfs(int x, boolean[] vis) {
        //         Queue<Integer> q = new ArrayDeque<>();
        //         q.offer(x);
        //         vis[x] = true;
        //         while (!q.isEmpty()) {
        //             int u = q.poll();
        //             for (int i = h[u]; i != -1; i = ne[i]) {
        //                 int v = e[i];
        //                 if (vis[v]) continue;
        //                 vis[v] = true;
        //                 f[v][0] = u;
        //                 g[v][0] = w[i];
        //                 q.offer(v);
        //                 depth[v] = depth[u] + 1;
        //             }
        //         }
        //     }
        //     public boolean query(int p, int q, int limit) {
        //         if (uf.find(p) != uf.find(q)) 
        //             return false;
        //         if (depth[p] < depth[q]) {
        //             int tmp = p;
        //             p = q;
        //             q = tmp;
        //         }
        //         // 先走到同一深度
        //         int diff = depth[p] - depth[q];
        //         int pow = 0, max = 0;
        //         while (diff > 0) {
        //             if ((diff & 1) == 1) {
        //                 max = Math.max(max, g[p][pow]);
        //                 p = f[p][pow];
        //             }
        //             pow++;
        //             diff >>= 1;
        //         }
        //         // 已经走到同一点了，那深度更浅的那个点就是最近公共祖先，max就是经过的边的最大值
        //         if (p == q) return max < limit;
        //         // 否则跳到最近公共祖先下面一层，沿途更新答案
        //         for (int i = log; i >= 0; i--) {
        //             if (f[p][i] != f[q][i]) {
        //                 max = Math.max(max, g[p][i]);
        //                 max = Math.max(max, g[q][i]);
        //                 p = f[p][i];
        //                 q = f[q][i];
        //             }
        //         }
        //         // 最后别忘了用最后一步更新答案
        //         max = Math.max(max, g[p][0]);
        //         max = Math.max(max, g[q][0]);
        //         return max < limit;
        //     }
        // }
   }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{0,1,10},{1,2,5},{2,3,9},{3,4,13}};
        int [][] b = new int [][] {{0,4,14},{1,4,13}};

      boolean [] res = s.distanceLimitedPathsExist(5, a, b);
      System.out.println("res.length: " + res.length);
      for (int z = 0; z < res.length; ++z) 
          System.out.print(res[z] + ", ");
      System.out.println("");
    }
}