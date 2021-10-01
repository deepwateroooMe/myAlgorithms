// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class unionFind {
    public static class Solution {

        
        // int m, n;
        // boolean res;
        // private void dfs(int i, int j, int [][] arr) {
        //     if (i == m-1 && j == n-1) {
        //         res = true;
        //         return;
        //     }
        //     switch(arr[i][j]) {
        //     case 1:
        //         if (j < n-1 && (arr[i][j+1] == 1 || arr[i][j+1] == 3 || arr[i][j+1] == 5) && !vis[i][j+1]) {
        //             vis[i][j+1] = true;
        //             dfs(i, j+1, arr);
        //         }
        //         if (j > 0  &&  (arr[i][j-1] == 1 || arr[i][j-1] == 4 || arr[i][j-1] == 6) && !vis[i][j-1])  {
        //             vis[i][j-1] = true;
        //             dfs(i, j-1, arr);
        //         }
        //         break;
        //     case 2:
        //         if (i < m-1 && (arr[i+1][j] == 2 || arr[i+1][j] == 5 || arr[i+1][j] == 6) && !vis[i+1][j]) {
        //             vis[i+1][j] = true;
        //             dfs(i+1, j, arr);
        //         }
        //         if (i > 0 && (arr[i-1][j] == 2 || arr[i-1][j] == 3 || arr[i-1][j] == 4) && !vis[i-1][j]) {
        //             vis[i-1][j] = true;
        //             dfs(i-1, j, arr);
        //         }
        //         break;
        //     case 3:
        //         if (i < m-1 && (arr[i+1][j] == 2 || arr[i+1][j] == 5 || arr[i+1][j] == 6) && !vis[i+1][j]) {
        //             vis[i+1][j] = true;
        //             dfs(i+1, j, arr);
        //         }
        //         if (j > 0  &&  (arr[i][j-1] == 1 || arr[i][j-1] == 4 || arr[i][j-1] == 6) && !vis[i][j-1]) {
        //             vis[i][j-1] = true;
        //             dfs(i, j-1, arr);
        //         }
        //         break;
        //     case 4:
        //         if (i < m-1 && (arr[i+1][j] == 2 || arr[i+1][j] == 5 || arr[i+1][j] == 6) && !vis[i+1][j]) {
        //             vis[i+1][j] = true;
        //             dfs(i+1, j, arr);
        //         }
        //         if (j < n-1 && (arr[i][j+1] == 1 || arr[i][j+1] == 3 || arr[i][j+1] == 5) && !vis[i][j+1]) {
        //             vis[i][j+1] = true;
        //             dfs(i, j+1, arr);
        //         }
        //         break;
        //     case 5:
        //         if (j > 0  &&  (arr[i][j-1] == 1 || arr[i][j-1] == 4 || arr[i][j-1] == 6) && !vis[i][j-1]) {
        //             vis[i][j-1] = true;
        //             dfs(i, j-1, arr);
        //         }
        //         if (i > 0 && (arr[i-1][j] == 2 || arr[i-1][j] == 3 || arr[i-1][j] == 4) && !vis[i-1][j]) {
        //             vis[i-1][j] = true;
        //             dfs(i-1, j, arr);
        //         }
        //         break;
        //     case 6:
        //         if (j < n-1 && (arr[i][j+1] == 1 || arr[i][j+1] == 3 || arr[i][j+1] == 5) && !vis[i][j+1]) {
        //             vis[i][j+1] = true;
        //             dfs(i, j+1, arr);
        //         }
        //         if (i > 0 && (arr[i-1][j] == 2 || arr[i-1][j] == 3 || arr[i-1][j] == 4) && !vis[i-1][j]) {
        //             vis[i-1][j] = true;
        //             dfs(i-1, j, arr);
        //         }
        //         break;
        //     }
        // }
        // boolean [][] vis;
        // public boolean hasValidPath(int[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     if (m == 1 && n == 1) return true;
        //     vis = new boolean[m][n];
        //     res = false;
        //     vis[0][0] = true;
        //     dfs(0, 0, grid);
        //     return res;
        // }


        // List<Pt> l = new ArrayList<>();
        // int n;
        // public class Pt {
        //     int i;
        //     int j;
        //     int v;
        //     public Pt (int a, int b, int c) {
        //         i = a;
        //         j = b;
        //         v = c;
        //     }
        // }
        // public int minCostConnectPoints(int[][] points) {
        //     n = points.length;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (j == i) continue;
        //             l.add(new Pt(i, j, Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1] - points[j][1])));
        //         }
        //     }
        //     Collections.sort(l, new Comparator<Pt> () {
        //             @Override public int compare(Pt x, Pt y) {
        //                 int com = x.v - y.v;
        //                 if (com == 0) return x.i - y.i; 
        //                 return com;
        //             }
        //         });
        //     HashSet<Integer> s = new HashSet<>();
        //     int minw = 0;
        //     UnionFind uf = new UnionFind(n);
        //     int i = 0;
        //     while (s.size() <= n && i < l.size() && uf.getCnt() > 1) {
        //         if (!uf.sameGroup(l.get(i).i, l.get(i).j)) {
        //             uf.merge(l.get(i).i, l.get(i).j);
        //             if (!s.contains(l.get(i).i)) s.add(l.get(i).i);
        //             if (!s.contains(l.get(i).j)) s.add(l.get(i).j);
        //             minw += l.get(i).v;
        //         }
        //         ++i;
        //     }
        //     return minw;
        // }

        // public class Pt {
        //     String i;
        //     String j;
        //     String v;
        //     public pt(String a, String b, String c) {
        //         i = a;
        //         j = b;
        //         v = c;
        //     }
        // }
        // public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //     int n = accounts.size();
        //     if (n == 1) return accounts;
        //     HashMap<String, String> m = new HashMap<>();
        //     HashSet<Pt> s = new HashSet<>();
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 1; j < accounts.get(i).size(); j++) {
        //             for (int k = 1; k < accounts.get(i).size(); k++) {
        //                 if (j == k) continue;
        //                 s.add(new Pt(accounts.get(i).get(j), accounts.get(i).get(k), accounts.get(i).get(0)));
        //             }
        //         }
        //     }
        // }
        // String [][] a = new String [][] {{"John","johnsmith@mail.com","john_newyork@mail.com"},
        //                                  {"John","johnsmith@mail.com","john00@mail.com"},
        //                                  {"Mary","mary@mail.com"},
        //                                  {"John","johnnybravo@mail.com"}};
        // String [][] a = new String [][] {{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"},
        //                                  {"Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"},
        //                                  {"Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"},
        //                                  {"Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"},
        //                                  {"Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"}}

        


        // List<Integer> l = new ArrayList<>();
        // boolean [][] vis;
        // int m, n;
        // boolean res = false;
        // UnionFind uf;
        // private void dfs(int oi, int oj, int pi, int pj, int i, int j, char [][] arr) {
        //     if ((i > 0 && arr[i-1][j] == arr[i][j] && vis[i-1][j] && (i-1 != pi || j != pj) && uf.sameGroup(i*n+j, (i-1)*n+j))
        //         || (i < m-1 && arr[i+1][j] == arr[i][j] && vis[i+1][j] && uf.sameGroup(i*n+j, (i+1)*n+j) && (i+1 != pi && j != pj))
        //         || (j > 0 && arr[i][j-1] == arr[i][j] && vis[i][j-1] && uf.sameGroup(i*n+j, i*n+j-1) && (i != pi && j-1 != pj))
        //         || (j < n-1 && arr[i][j+1] == arr[i][j] && vis[i][j+1] && uf.sameGroup(i*n+j, i*n+j+1) && (i != pi && j+1 != pj))) {
        //         // if ((i > 0 && arr[i-1][j] == arr[i][j] && vis[i-1][j] && i-1 == oi && j == oj && (i-1 != pi || j != pj))
        //     //     || (i < m-1 && arr[i+1][j] == arr[i][j] && vis[i+1][j] && i+1 == oi && j == oj && (i+1 != pi && j != pj))
        //     //     || (j > 0 && arr[i][j-1] == arr[i][j] && vis[i][j-1] && i == oi && j-1 == oj && (i != pi && j-1 != pj))
        //     //     || (j < n-1 && arr[i][j+1] == arr[i][j] && vis[i][j+1] && i == oi && j+1 == oj && (i != pi && j+1 != pj))) {
        //         res = true;
        //         return;
        //     }
        //     if (j < n-1 && arr[i][j+1] == arr[i][j] && !vis[i][j+1]) {
        //         vis[i][j+1] = true;
        //         uf.merge(i*n+j, i*n+j+1);
        //         dfs(oi, oj, i, j, i, j+1, arr);
        //     }
        //     if (j > 0 && arr[i][j-1] == arr[i][j] && !vis[i][j-1]) {
        //         vis[i][j-1] = true;
        //         uf.merge(i*n+j, i*n+j-1);
        //         dfs(oi, oj, i, j, i, j-1, arr);
        //     }
        //     if (i < m-1 && arr[i+1][j] == arr[i][j] && !vis[i+1][j]) {
        //         vis[i+1][j] = true;
        //         uf.merge(i*n+j, (i+1)*n+j);
        //         dfs(oi, oj, i, j, i+1, j, arr);
        //     }
        //     if (i > 0 && arr[i-1][j] == arr[i][j] && !vis[i-1][j]) {
        //         vis[i-1][j] = true;
        //         uf.merge(i*n+j, (i-1)*n+j);
        //         dfs(oi, oj, i, j, i-1, j, arr);
        //     }
        // }
        // public boolean containsCycle(char[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     if (m == 1 || n == 1) return false;
        //     vis = new boolean[m][n];
        //     uf = new UnionFind(m*n);
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (!vis[i][j]) {
        //                 // for (int x = 0; x < m; x++) 
        //                 //     Arrays.fill(vis[x], false);
        //                 res = false;
        //                 vis[i][j] = true;
        //                 dfs(i, j, -1, -1, i, j, grid);
        //                 if (res) return true;
        //                 vis[i][j] = false;
        //             }
        //         }
        //     }
        //     return false;
        // }

        
        // private boolean issimilar(String x, String y) {
        //     int n = x.length();
        //     int i = 0;
        //     while (i < n && x.charAt(i) == y.charAt(i)) ++i;
        //     if (i == n) return true;
        //     int j = i+1;
        //     while (j < n && x.charAt(j) == y.charAt(j)) ++j;
        //     if (x.charAt(i) == y.charAt(j) && x.charAt(j) == y.charAt(i)) {
        //         ++j;
        //         if (j == n) return true;
        //         while (j < n && x.charAt(j) == y.charAt(j)) ++j;
        //         if (j == n) return true;
        //     } 
        //     return false;
        // }
        // public int numSimilarGroups(String[] strs) {
        //     int n = strs.length;
        //     UnionFind uf = new UnionFind(n);
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (j == i) continue;
        //             if (issimilar(strs[i], strs[j]) && !uf.sameGroup(i, j)) uf.merge(i, j);
        //         }
        //     }
        //     return uf.getCnt();
        // }


        // public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        //     List<Boolean> res = new ArrayList<>();
        //     if (threshold == 0) {
        //         for (int i = 0; i < queries.length; i++) 
        //             res.add(true);
        //         return res;
        //     }
        //     UnionFind uf = new UnionFind(n+1);
        //     for (int i = threshold + 1; i <= n; i++) {
        //         for (int j = i+1; j <= n; j++) {
        //             if (j % i == 0 && !uf.sameGroup(i, j)) uf.merge(i, j);
        //         }
        //     }
        //     for (int i = 0; i < queries.length; i++) 
        //         res.add(uf.sameGroup(queries[i][0], queries[i][1]));
        //     return res;
        // }
        

        // private class UnionFind {
        //     HashMap<Integer, Integer> pare;
        //     HashMap<Integer, Integer> rank;
        //     public UnionFind() {
        //         pare = new HashMap<>();
        //         rank = new HashMap<>();
        //     }
        //     public int find(int val) {
        //         if (!pare.containsKey(val)) {
        //             pare.put(val, val);
        //             rank.put(val, 0);
        //             return val;
        //         }
        //         if (pare.get(val) != val) pare.put(val, find(pare.get(val)));
        //         return pare.get(val);
        //     }
        //     public void merge(int p, int q) {
        //         int rp = find(p);
        //         int rq = find(q);
        //         if (rp == rq) return;
        //         pare.put(rq, rp);
        //         rank.put(rp, rank.get(rp) + rank.get(rq));
        //     }
        //     public void addToParent(int val) {
        //         int x = this.find(val);
        //         rank.put(x, rank.get(x) + 1);
        //     }
        //     private int getLargestComponentCnt() {
        //         int ans = 0;
        //         for (Integer key : pare.keySet()) 
        //             ans = Math.max(ans, rank.get(key));
        //         return ans;
        //     }
        // }
        // private List<Integer> getPrimeFactors(int val) {
        //     List<Integer> l = new ArrayList<>();
        //     if (val % 2 == 0) {
        //         l.add(2);
        //         while (val % 2 == 0) val /= 2;
        //     }
        //     for (int i = 3; i*i <= val; i += 2) {
        //         if (val % i == 0) {
        //             l.add(i);
        //             while (val % i == 0) val /= i;
        //         }
        //     }
        //     if (val > 2) l.add(val);
        //     return l;
        // }
        // public int largestComponentSize(int[] nums) {
        //     int n = nums.length;
        //     UnionFind uf = new UnionFind();
        //     Arrays.sort(nums);
        //     for (int val : nums) {
        //         if (val >= 2) {
        //             List<Integer> l = getPrimeFactors(val);
        //             uf.addToParent(l.get(0));
        //             for (int i = 1; i < l.size(); i++) 
        //                 uf.merge(l.get(0), l.get(i));
        //         }
        //     }
        //     return uf.getLargestComponentCnt();
        // }


        // public class UnionFind {
        //     int [] pare;
        //     int [] rank;
        //     int n;
        //     int cnt;
        //     public UnionFind(int x) {
        //         n = x;
        //         cnt = n;
        //         pare = new int[n];
        //         rank = new int[n];
        //         for (int i = 0; i < n; i++) 
        //             pare[i] = i;
        //         Arrays.fill(rank, 0);
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
        //         if (rank[rp] < rank[rq]) 
        //             swap(rp, rq);
        //         pare[rq] = rp;
        //         rank[rp] += rank[rq];
        //         --cnt;
        //     }
        //     public boolean sameGroup(int x, int y) {
        //         return find(x) == find(y);
        //     }
        //     public int getCnt() {
        //         return cnt;
        //     }
        //     private void swap(int x, int y) {
        //         int tmp = x;
        //         x = y;
        //         y = tmp;
        //     }
            // private int getCleanCnts(int [] arr, int val) {
            //     HashSet<Integer> sp = new HashSet<>();
            //     int p = 0;
            //     for (int i = 0; i < arr.length; i++) {
            //         p = find(arr[i]);
            //         sp.add(p);
            //     }
            //     int cnt = 0;
            //     int pval;
            //     if (val != -1) pval = find(val);
            //     else pval = -1;
            //     for (int i = 0; i < n; i++) {
            //         p = find(i);
            //         if (sp.contains(p) && p != pval) ++cnt;
            //     }
            //     return n - cnt;
            // }
            // public int getComponentCnts(int val, int [] arr) {
            //     if (getCnt() == 1 && arr.length == 1) return n;
            //     boolean sib = false;
            //     for (int node : arr) {
            //         if (sameGroup(val, node) && val != node) {
            //             sib = true;
            //             if (getCnt() == 1) return 0;
            //             else return getCleanCnts(arr, -1);
            //         }
            //     }
            //     if (!sib) {
            //         if (getCnt() == 1 && arr.length > 1) return 0;
            //         else return getCleanCnts(arr, val);
            //     }
            //     return -1;
            // }
        // }
        // public int minMalwareSpread(int[][] graph, int[] initial) {
        //     int n = graph.length;
        //     UnionFind uf = new UnionFind(n);
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (j == i) continue;
        //             if (!uf.sameGroup(i, j) && graph[i][j] == 1) uf.merge(i, j);
        //         }
        //     }
        //     Arrays.sort(initial);
        //     int [] arr = new int[initial.length];
        //     Arrays.fill(arr, -1);
        //     for (int i = 0; i < initial.length; i++) 
        //         arr[i] = uf.getComponentCnts(initial[i], initial);
        //     int maxIdx = 0;
        //     for (int i = 1; i < initial.length; i++) 
        //         maxIdx = arr[i] > arr[maxIdx] ? i : maxIdx;
        //     return initial[maxIdx];
        // }


        // public class UnionFind {
        //     int [] pare;
        //     int [] rank;
        //     int n;
        //     int cnt;
        //     public UnionFind(int x) {
        //         n = x;
        //         cnt = n;
        //         pare = new int[n];
        //         rank = new int[n];
        //         for (int i = 0; i < n; i++) 
        //             pare[i] = i;
        //         Arrays.fill(rank, 0);
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
        //         if (rank[rp] < rank[rq]) 
        //             swap(rp, rq);
        //         pare[rq] = rp;
        //         rank[rp] += rank[rq];
        //         --cnt;
        //     }
        //     public boolean sameGroup(int x, int y) {
        //         return find(x) == find(y);
        //     }
        //     public int getCnt() {
        //         return cnt;
        //     }
        //     private void swap(int x, int y) {
        //         int tmp = x;
        //         x = y;
        //         y = tmp;
        //     }
        //     public UnionFind clone() {
        //         UnionFind copy = new UnionFind(n);
        //         copy.pare = new int[n];
        //         copy.rank = new int[n];
        //         for (int i = 0; i < n; i++) {
        //             copy.pare[i] = pare[i];
        //             copy.rank[i] = rank[i];
        //         }
        //         copy.cnt = cnt;
        //         return copy;
        //     }
        //     private int getCleanCnts(int [] arr, int val) {
        //         HashSet<Integer> sp = new HashSet<>();

        //         int pval;
        //         if (val != -1) pval = find(val);
        //         else pval = -1;

        //         int p = 0;
        //         for (int i = 0; i < arr.length; i++) {
        //             if (arr[i] == val) continue;
        //             p = find(arr[i]);
        //             sp.add(p);
        //         }
        //         int cnt = 0;
        //         for (int i = 0; i < n; i++) {
        //             p = find(i);
        //             if (sp.contains(p) && p != pval) ++cnt;
        //         }
        //         return n - cnt - 1;
        //     }
        //     public int getComponentCnts(int val, int [] arr) {
        //         if (getCnt() == 1 && arr.length == 1) return n-1;
        //         boolean sib = false;
        //         for (int node : arr) {
        //             if (sameGroup(val, node) && val != node) {
        //                 sib = true;
        //                 if (getCnt() == 1) return 0;
        //                 else return getCleanCnts(arr, -1);
        //             }
        //         }
        //         if (!sib) {
        //             if (getCnt() == 1 && arr.length > 1) return 0;
        //             else return getCleanCnts(arr, val);
        //         }
        //         return -1;
        //     }
        // }
        // private boolean contains(int [] arr, int val) {
        //     for (int i = 0; i < arr.length; i++) 
        //         if (arr[i] == val) return true;
        //     return false;
        // }
        // public int minMalwareSpread(int[][] graph, int[] initial) {
        //     int n = graph.length;
        //     UnionFind uf = new UnionFind(n);
        //     Arrays.sort(initial);
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (j == i) continue;
        //             if (!uf.sameGroup(i, j) && !contains(initial, i) && !contains(initial, j) && graph[i][j] == 1)
        //                 uf.merge(i, j);
        //         }
        //     }
        //     UnionFind cp = uf.clone();
        //     int [] arr = new int[initial.length];
        //     for (int i = 0; i < initial.length; i++) {
        //         cp = uf.clone();
        //         for (int k = 0; k < initial.length; k++) {
        //             for (int j = 0; j < n; j++) {
        //                 if (k == i || j == initial[i]) continue;
        //                 if (!cp.sameGroup(initial[k], j) && graph[initial[k]][j] == 1)
        //                     cp.merge(initial[k], j);
        //             }
        //         }
        //         arr[i] = cp.getComponentCnts(initial[i], initial);
        //         cp = null;
        //     }
        //     int maxIdx = 0;
        //     for (int i = 1; i < initial.length; i++) 
        //         maxIdx = arr[i] > arr[maxIdx] ? i : maxIdx;
        //     return initial[maxIdx];
        // }

        
        // private class UnionFind {
        //     HashMap<Integer, Integer> pare;
        //     HashMap<Integer, Integer> rank;
        //     public UnionFind() {
        //         pare = new HashMap<>();
        //         rank = new HashMap<>();
        //     }
        //     public int find(int val) {
        //         if (!pare.containsKey(val)) {
        //             pare.put(val, val);
        //             rank.put(val, 0);
        //             return val;
        //         }
        //         if (pare.get(val) != val) pare.put(val, find(pare.get(val)));
        //         return pare.get(val);
        //     }
        //     public void merge(int p, int q) {
        //         int rp = find(p);
        //         int rq = find(q);
        //         if (rp == rq) return;
        //         pare.put(rq, rp);
        //         if (rank.get(rq) == 0) rank.put(rq, 1);
        //         rank.put(rp, rank.get(rp) + rank.get(rq));
        //     }
        //     public boolean sameGroup(int x, int y) {
        //         return find(x) == find(y);
        //     }
        //     public void addToParent(int val) {
        //         int x = this.find(val);
        //         rank.put(x, rank.get(x) + 1);
        //     }
        //     // public int getRemovedCnts(int i, int j, int m, int n) {
        //     //     int ans = 0;
        //     //     int p = find(i*n+j);
        //     //     for (int x = i; x < m; x++) {
        //     //         for (int y = j; y < n; y++) {
        //     //             if (find(x*n+y) == p) {
        //     //                 rank.put(x*n+y, rank.get(x*n+y)-1 >= 0 ? rank.get(x*n+y)-1 : 0);
        //     //                 pare.put(x*n+y, x*n+y);
        //     //                 rank.put(pare.get(x*n+y), rank.get(pare.get(x*n+y))-1);
        //     //                 ++ans;   
        //     //             }
        //     //         }
        //     //     }
        //     //     return ans - 1;
        //     // }
        // }



//         public class UnionFind {
//             int [] pare;
//             int [] rank;
//             int n;
//             int cnt;
//             public UnionFind(int x) {
//                 n = x;
//                 cnt = n;
//                 pare = new int[n];
//                 rank = new int[n];
//                 for (int i = 0; i < n; i++)
//                     // pare[i] = -1;
//                     pare[i] = i;
//                 Arrays.fill(rank, 0);
//             }
//             public int find(int val) {
//                 while (val != pare[val]) {
//                     pare[val] = pare[pare[val]];
//                     val = pare[val];
//                 }
//                 if (rank[val] == 0) rank[val] = 1;
//                 return val;
//             }
//             public void merge(int p, int q) {
//                 int rp = find(p);
//                 int rq = find(q);
//                 if (rank[rp] < rank[rq]) 
//                     swap(rp, rq);
//                 pare[rq] = rp;
//                 rank[rp] += rank[rq];
//                 --cnt;
//             }
//             public boolean sameGroup(int x, int y) {
//                 return find(x) == find(y);
//             }
//             public int getCnt() {
//                 return cnt;
//             }
//             private void swap(int x, int y) {
//                 int tmp = x;
//                 x = y;
//                 y = tmp;
//             }
//             public UnionFind clone() {
//                 UnionFind copy = new UnionFind(n);
//                 copy.pare = new int[n];
//                 copy.rank = new int[n];
//                 for (int i = 0; i < n; i++) {
//                     copy.pare[i] = pare[i];
//                     copy.rank[i] = rank[i];
//                 }
//                 copy.cnt = cnt;
//                 return copy;
//             }
//             public int getLargestGroupCnts() {
//                 for (int i = 0; i < n; i++) 
//                     find(i);
//                 // System.out.println("pare.length: " + pare.length);
//                 // for (int z = 0; z < pare.length; ++z) 
//                 //     System.out.print(pare[z] + ", ");
//                 // System.out.println("");
//                 System.out.println("getCnt(): " + getCnt());

// // 0, 1, 2,   3, 4, 5, 6,
// // 7, 15, 15, 15, 15, 12, 13
// // 14, 18, 16, 17, 25, 19, 20,
// // 21, 22, 23, 24, 32, 26, 27, 
// // 28, 29, 30, 31, 39, 33, 34,
// // 35, 29, 37, 38, 46, 40, 41,
// // 42, 46, 46, 46, 36, 47, 48,        
//                 // HashMap<Integer, Integer> m = new HashMap<>();
//                 // for (int i = 0; i < n; i++)
//                 //     m.put(pare[i], m.getOrDefault(pare[i], 0) + 1);
//                 // Map<Integer, Integer> map = m.entrySet().stream()
//                 //     .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                 //     .limit(5)
//                 //     .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//                 // Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
//                 // Map.Entry<Integer, Integer> cur = itr.next();
//                 // return cur.getValue();
//                 int max = 0;
//                 for (int i = 0; i < n; i++) 
//                     max = Math.max(max, rank[i]);
//                 return max;
//             }
//         }
//         UnionFind uf;
//         int n;
//         boolean [][] vis;
//         private void dfs(int [][] arr, int i, int j) {
//             if (i > 0 && arr[i-1][j] == 1 && !vis[i-1][j]) {
//                 uf.merge((i-1)*n+j, i*n+j);
//                 vis[i-1][j] = true;
//                 dfs(arr, i-1, j);
//             }
//             if (i < n-1 && arr[i+1][j] == 1 && !vis[i+1][j]) {
//                 uf.merge((i+1)*n+j, i*n+j);
//                 vis[i+1][j] = true;
//                 dfs(arr, i+1, j);
//             }
//             if (j > 0 && arr[i][j-1] == 1 && !vis[i][j-1]) {
//                 uf.merge(i*n+j, i*n+j-1);
//                 vis[i][j-1] = true;
//                 dfs(arr, i, j-1);
//             }
//             if (j < n-1 && arr[i][j+1] == 1 && !vis[i][j+1]) {
//                 uf.merge(i*n+j, i*n+j+1);
//                 vis[i][j+1] = true;
//                 dfs(arr, i, j+1);
//             }
//         }
//         public int largestIsland(int[][] grid) {
//             n = grid.length;
//             if (n == 1) return 1;
//             int cnt = 0;
//             for (int i = 0; i < n; i++) {
//                 for (int j = 0; j < n; j++) {
//                     if (grid[i][j] == 1) ++cnt;
//                 }                
//             }
//             if (cnt ==0) return 1;
//             uf = new UnionFind(n*n);
//             vis = new boolean[n][n];
//             for (int i = 0; i < n; i++) {
//                 for (int j = 0; j < n; j++) {
//                     if (!vis[i][j] && grid[i][j] == 1) {
//                         vis[i][j] = true;
//                         dfs(grid, i, j);
//                         break;
//                     }
//                 }
//             }
//             System.out.println("uf.getCnt(): " + uf.getCnt());
//             System.out.println("uf.pare.length: " + uf.pare.length);
//             for (int z = 0; z < uf.pare.length; ++z) 
//                 System.out.print(uf.pare[z] + ", ");
//             System.out.println("");

//             System.out.println("uf.rank.length: " + uf.rank.length);
//             for (int z = 0; z < uf.rank.length; ++z) 
//                 System.out.print(uf.rank[z] + ", ");
//             System.out.println("");


//             System.out.println("uf.getLargestGroupCnts(): " + uf.getLargestGroupCnts());
            
//             cnt = 0;
//             int max = Integer.MIN_VALUE;
//             for (int k = 0; k < n; k++) 
//                 Arrays.fill(vis[k], false);
//             for (int i = 0; i < n; i++) {
//                 for (int j = 0; j < n; j++) {
//                     if (!vis[i][j] && grid[i][j] == 0) {
//                         System.out.println("\ni: " + i);
//                         System.out.println("j: " + j);
//                         vis[i][j] = true;
//                         cnt = 0;
//                         if (i > 0 && grid[i-1][j] == 1) ++cnt;
//                         if (i < n-1 && grid[i+1][j] == 1) ++cnt;
//                         if (j > 0 && grid[i][j-1] == 1) ++cnt;
//                         if (j < n-1 && grid[i][j+1] == 1) ++cnt;
//                         if (cnt >= 1) {
//                             // poss = true;
//                             UnionFind cp = uf.clone();
//                             if (i > 0 && grid[i-1][j] == 1) 
//                                 cp.merge((i-1)*n+j, i*n+j);
//                             if (i < n-1 && grid[i+1][j] == 1) 
//                                 cp.merge((i+1)*n+j, i*n+j);
//                             if (j > 0 && grid[i][j-1] == 1) 
//                                 cp.merge(i*n+j-1, i*n+j);
//                             if (j < n-1 && grid[i][j+1] == 1) 
//                                 cp.merge(i*n+j+1, i*n+j);
//                             System.out.println("cp.getLargestGroupCnts(): " + cp.getLargestGroupCnts());
//                             max = Math.max(max, cp.getLargestGroupCnts());
//                         }
//                     }
//                 }
//             }
//             return max == Integer.MIN_VALUE ? n*n : max;
//         }


        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // int n;
        // public int[] findRedundantDirectedConnection(int[][] edges) {
        //     int n = edges.length;
        //     // List<Integer> l = new ArrayList<>();
        //     // for (int i = 0; i < n; i++) {
        //     //     l = new ArrayList<>();
        //     //     m.put(i, l);
        //     // }
        //     // for (int i = 0; i < n; i++) {
        //     //     m.get(edges[i][0]).add(edges[i][1]);
        //     // }
        //     // System.out.println("");
        //     // System.out.println("m.size(): " + m.size());
        //     // for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
        //     //     System.out.print(entry.getKey() + ": "); 
        //     //     for (int z = 0; z < entry.getValue().size(); z++) {
        //     //         System.out.print(entry.getValue().get(z) + ", ");
        //     //     }
        //     //     System.out.print("\n");
        //     // }
        //     // System.out.println("");

        //     // int [] vis = new int [n+1];
        //     // UnionFind uf = new UnionFind(n+1);
        //     // for (int i = 0; i < n; i++) {
        //     //     if (uf.find(edges[i][1]) != edges[i][1] || vis[edges[i][1]] != 0) return edges[i];
        //     //     vis[edges[i][0]] = -1;
        //     //     vis[edges[i][1]] = -1;
        //     //     uf.merge(edges[i][0], edges[i][1]);
        //     //     // s.add(edges[i][0]);
        //     //     // s.add(edges[i][1]);
        //     // }
        //     return new int [0];
        // }


        // private class UnionFind {
        //     int [] arr;
        //     int size;
        //     public UnionFind(int n) {
        //         this.size = n;
        //         this.arr = new int[this.size];
        //         for (int i = 0; i < size; i++) 
        //             arr[i] = i;
        //     }
        //     public int find(int i) {
        //         if (i != arr[i])
        //             arr[i] = find(arr[i]);
        //         return arr[i];
        //     }
        //     public void merge(int i, int j) {
        //         int ri = find(i);
        //         int rj = find(j);
        //         if (ri != rj) {
        //             arr[rj] = ri; 
        //             size -= 1;
        //         }
        //     }
        // }
        // public int regionsBySlashes(String[] grid) {
        //     int n = grid.length;
        //     UnionFind uf = new UnionFind(4*n*n);
        //     int k = 0;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             k = 4 * (i * n + j);
        //             if (grid[i].charAt(j) == '/' || grid[i].charAt(j) == ' ') {
        //                 uf.merge(k, k+1);
        //                 uf.merge(k+2, k+3);
        //             }
        //             if (grid[i].charAt(j) == '\\' || grid[i].charAt(j) == ' ') {
        //                 uf.merge(k, k+3);
        //                 uf.merge(k+1, k+2);
        //             }
        //             if (i > 0) uf.merge(k, 4*((i-1)*n+j)+2);
        //             if (j > 0) uf.merge(k+1, 4*(i*n+j-1)+3);
        //             if (j < n-1) uf.merge(k+3, 4*(i*n+j+1)+1);
        //             if (i < n-1) uf.merge(k+2, 4*((i+1)*n+j));
        //         }
        //     }
        //     return uf.size;
        // }

        
//         private int findParent(int [] arr, int x) {
//             // while (arr[x] != x) {
//             //     x = arr[x]; // 两种不同的写法
//             //     arr[x] = findParent(arr, arr[x]);
//             // }
//             // return arr[x];
//             if (arr[x] == x) return x;
//             arr[x] = findParent(arr, arr[x]);
//             return arr[x];
//         }
//         public List<List<String>> accountsMerge(List<List<String>> accounts) {
//             Map<String, Integer> owner = new HashMap<>();
//             Map<Integer, TreeSet<String>> union = new HashMap<>(); // match idx & Set<Sting emails>
//             int n = accounts.size(), p = 0;
//             int [] par = new int [n];
//             for (int i = 0; i < n; i++) par[i] = i;
//             List<String> ls = new ArrayList<>(); 
//             for (int i = 0; i < n; i++) { // find the ownerIdx for each email address
//                 ls = accounts.get(i);
//                 for (int j = 1; j < ls.size(); j++) {
//                     String email = ls.get(j);
//                     if (owner.containsKey(email)) {
//                         p = findParent(par, owner.get(email));
//                         par[p] = i; // union accounts that belong to the same user here by updating parent relation
//                     }
//                     owner.put(email, i);
//                 }
//             }
//              // union all emails belong to the same owner
//             for (String emal : owner.keySet()) {
//                 int ownerIdx = findParent(par, owner.get(emal));
//                 TreeSet<String> set = union.getOrDefault(ownerIdx, new TreeSet<>());
//                 set.add(emal);
//                 union.put(ownerIdx, set);
//             }
// // Generate return result
//             List<List<String>> res = new ArrayList<>();
//             for (int ownerIdx : union.keySet()) {
//                 ls = new ArrayList<>();
//                 ls.add(accounts.get(ownerIdx).get(0));  // get the owner name
//                 ls.addAll(union.get(ownerIdx));
//                 res.add(ls);
//             }
//             return res;
//         }


        // int [] par;
        // int [] rank;
        // int n;
        // public int find(int v) {
        //     if (v != par[v] ) 
        //         par[v] = find(par[v]);
        //     return par[v];
        // }
        // public boolean union(int i, int j) {
        //     int ri = find(i);
        //     int rj = find(j);
        //     if (ri == rj) return false;
        //     if (rank[ri] < rank[rj]) par[ri] = rj;
        //     else if (rank[ri] > rank[rj]) par[rj] = ri;
        //     else {
        //         par[rj] = ri;
        //         rank[ri] ++; // 维护rank的值
        //     }
        //     return true;
        // }
        // public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        //     int n = s.length();
        //     par = new int [n];
        //     rank = new int [n];
        //     List<Queue<Character>> list = new ArrayList<>(n);
        //     for (int i = 0; i < n; i++) {
        //         par[i] = i;
        //         list.add(new PriorityQueue<>());
        //     }
        //     Arrays.fill(rank, 1);
        //     pairs.forEach(p -> union(p.get(0), p.get(1))); // Perform union for each pair.
        //     // Add each character to the priority queue associated with its component.
        //     IntStream.range(0, n).forEach(index -> list.get(find(index)).add(s.charAt(index)));
        //     // Build the result, by removing chars from the corresponding priority queue.
        //     StringBuilder buffer = new StringBuilder(n);
        //     IntStream.range(0, n).forEachOrdered(index -> buffer.append(list.get(find(index)).remove()));
        //     return buffer.toString();
        // }


        // private void dfs(int i, Set<Integer> visited, int [] arr) {
        //     if (!visited.contains(arr[i])) {
        //         Set<Integer> children = tree.getOrDefault(i, new HashSet<Integer>());
        //         for (int v : children) 
        //             dfs(v, visited, arr);
        //         visited.add(arr[i]);
        //     }
        // }
        // Map<Integer, Set<Integer>> tree = new HashMap<>();
        // int [] ans;
        // int n;
        // public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        //     n = parents.length;
        //     ans = new int [n];
        //     Arrays.fill(ans, 1); 
        //     int oneIdx = -1;
        //     for (int i = 0; i < n; i++) 
        //         if (nums[i] == 1) {
        //             oneIdx = i;
        //             break;
        //         }
        //     if (oneIdx == -1) return ans;
        //     for (int i = 1; i < n; i++) {
        //         tree.computeIfAbsent(parents[i], k -> new HashSet<Integer>());
        //         tree.get(parents[i]).add(i);
        //         // tree.computeIfAbsent(i, k -> new HashSet<Integer>()); // 这里要想一下：为什么双向图他只加一个方向？
        //         // tree.get(i).add(parents[i]);
        //     }
        //     Set<Integer> visited = new HashSet<>(); // 这个直接转化为想要的结果，很便捷
        //     int parentIter = oneIdx;
        //     int miss = 1;
        //     while (parentIter >= 0) { // 从值为1的节点向根遍历（自底向上），没有任何重复计算，只走完这一条自底向项的路径就可以了
        //         dfs(parentIter, visited, nums);
        //         while (visited.contains(miss)) ++miss;
        //         ans[parentIter] = miss;
        //         parentIter = parents[parentIter];
        //     }
        //     return ans;
        // }


        // public class UnionFind {
        //     int [] par;
        //     int [] rank;
        //     int n, cnt;
        //     public UnionFind(int x) {
        //         n = x;
        //         cnt = n;
        //         par = new int[n];
        //         rank = new int[n];
        //         for (int i = 0; i < n; i++) 
        //             par[i] = i;
        //     }
        //     public int find(int v) {
        //         if (v == par[v]) return v;
        //         par[v] = find(par[v]);
        //         return par[v];
        //     }
        //     public void merge(int p, int q) {
        //         int rp = find(p);
        //         int rq = find(q);
        //         if (rank[rp] < rank[rq]) par[rp] = rq;
        //         else if (rank[rp] > rank[rq]) par[rq] = rp;
        //         else {
        //             par[rq] = rp;
        //             rank[rp]++;
        //          }
        //         --cnt;
        //     }
        //     public boolean sameGroup(int x, int y) {
        //         return find(x) == find(y);
        //     }
        //     public int getCnt() { return cnt; }
        //     public List<List<Integer>> getComponents() {
        //         HashMap<Integer, List<Integer>> m = new HashMap<>();
        //         for (int i = 0; i < n; i++) {
        //             find(i);
        //             m.computeIfAbsent(par[i], k -> new ArrayList<>());
        //             m.get(par[i]).add(i);
        //         }
        //         List<List<Integer>> res = new ArrayList<>();
        //         List<Integer> l = new ArrayList<>();
        //         for (List<Integer> val : m.values()) 
        //             res.add(val);
        //         return res;
        //     }
        // }        
        // public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        //     int n = source.length;
        //     UnionFind uf = new UnionFind(n);
        //     for (int i = 0; i < allowedSwaps.length; i++) 
        //         if (!uf.sameGroup(allowedSwaps[i][0], allowedSwaps[i][1]))
        //             uf.merge(allowedSwaps[i][0], allowedSwaps[i][1]);
        //     List<List<Integer>> ll = uf.getComponents();
        //     List<Integer> s = new ArrayList<>();
        //     List<Integer> t = new ArrayList<>();
        //     Map<Integer, Integer> m = new HashMap<>();
        //     List<Integer> l = new ArrayList<>();
        //     int ans = 0;
        //     for (int i = 0; i < ll.size(); i++) {
        //         l = ll.get(i);
        //         m.clear();
        //         for (int v : l) 
        //             m.put(source[v], m.getOrDefault(source[v], 0) + 1);
        //         for (int j = 0; j < l.size(); j++) 
        //             if (m.containsKey(target[l.get(j)])) {
        //                 m.put(target[l.get(j)], m.get(target[l.get(j)])-1);
        //                 if (m.get(target[l.get(j)]) == 0) m.remove(target[l.get(j)]);
        //             } else ++ans;
        //     }
        //     return ans;
        // }

        
        // public class UnionFind { // 注意：我前面关于强连通分量个数的题写错了
        //     int [] par;
        //     int [] rank;
        //     int n;
        //     public UnionFind(int x) {
        //         n = x;
        //         par = new int[n];
        //         rank = new int[n];
        //         for (int i = 0; i < n; i++) par[i] = i;
        //     }
        //     public int find(int v) {
        //         if (v >= n) return -1;
        //         if (v == par[v]) return v;
        //         par[v] = find(par[v]);
        //         return par[v];
        //     }
        //     public void merge(int p, int q) {
        //         int rp = find(p);
        //         int rq = find(q);
        //         if (rank[rp] < rank[rq]) par[rp] = rq;
        //         else if (rank[rp] > rank[rq]) par[rq] = rp;
        //         else {
        //             par[rq] = rp;
        //             rank[rp]++;
        //         }
        //     }
        // }
        // private boolean onlyOne(int a, int b) {
        //     if (a == 1 || b == 1) return true;
        //     while (true) {
        //         int t = a % b;
        //         if (t == 0) break;
        //         else {
        //             a = b;
        //             b = t;
        //         }
        //     }
        //     if (b > 1) return false;
        //     return true;
        // }

        
        // private int find (int v) {
        //     if (!parent.containsKey(v)) {
        //         parent.put(v, v);
        //         return v;
        //     }
        //     if (parent.get(v) != v)
        //         parent.put(v, find(parent.get(v)));
        //     return parent.get(v);
        // }
        // private void union(int x, int y) {
        //     int rx = find(x);
        //     int ry = find(y);
        //     if (rx != ry) parent.put(rx, ry);
        // }
        // /**
        //    general idea (not accepted)
        //    we can simply union pairs of numbers which has gcd > 1 in quadratic time and then check of groups that
        //    are formed by union of pairs can be invidually sorted. 
        //    improved (accpeted)
        //    In above approach problem is we are union-ing pairs in quadratic time. To improve upon it. We union a number
        //    which is present in 'nums' with its smallest prime factor. thus if two numbers has same smallest prime factor
        //    their gcd is guaranted to be >1. 
        // **/
        // Map<Integer, Integer> parent = new HashMap<>();
        // public boolean gcdSort(int[] arr) {
        //     int n = arr.length;
        //     parent = new HashMap<Integer, Integer>();
        //     int [] sorted = arr.clone();
        //     Arrays.sort(sorted);
        //     int max = Arrays.stream(arr).max().getAsInt();
        //     Set<Integer> numSet = new HashSet<>();
        //     numSet.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        //     int p = 2;  // Seive algorithm
        //     boolean [] primes = new boolean [max + 1];
        //     Arrays.fill(primes, true);
        //     while (p < max) {
        //         if (primes[p]) {
        //             for (int i = p; i <= max; i += p) { // 我合并的是数组的索引，他优化成合并所有拥有公约数为p的数组中沿未合并的值
        //                 if (numSet.contains(i)) union(p, i);
        //                 primes[i] = false;
        //             }
        //         }
        //         p++;
        //     }
        //     for (int i = 0; i < n; i++) 
        //         if (arr[i] != sorted[i] && find(sorted[i]) != find(arr[i])) return false;
        //     return true;
        // }
        
        
        // private class UnionFind {
        //     HashMap<Integer, Integer> pare;
        //     HashMap<Integer, Integer> rank;
        //     public UnionFind() {
        //         pare = new HashMap<>();
        //         rank = new HashMap<>();
        //     }
        //     public int find(int val) {
        //         if (!pare.containsKey(val)) {
        //             pare.put(val, val);
        //             rank.put(val, 0);
        //             return val;
        //         }
        //         if (pare.get(val) != val) pare.put(val, find(pare.get(val)));
        //         return pare.get(val);
        //     }
        //     public void merge(int p, int q) {
        //         int rp = find(p);
        //         int rq = find(q);
        //         if (rp == rq) return;
        //         pare.put(rq, rp);
        //         if (rank.get(rq) == 0) rank.put(rq, 1);
        //         rank.put(rp, rank.get(rp) + rank.get(rq));
        //     }
        //     public boolean sameGroup(int x, int y) {
        //         return find(x) == find(y);
        //     }
        //     public void addToParent(int val) {
        //         int x = this.find(val);
        //         rank.put(x, rank.get(x) + 1);
        //     }
        //     public int getRemovedCnts(int i, int j, int m, int n) {
        //         int ans = 0;
        //         int p = find(i*n+j);
        //         for (int x = 0; x < m; x++) {
        //             for (int y = 0; y < n; y++) {
        //                 if (find(x*n+y) == p) {
        //                     rank.put(x*n+y, rank.get(x*n+y)-1 >= 0 ? rank.get(x*n+y)-1 : 0);
        //                     pare.put(x*n+y, x*n+y);
        //                     rank.put(pare.get(x*n+y), rank.get(pare.get(x*n+y))-1);
        //                     ++ans;   
        //                 }
        //             }
        //         }
        //         return ans - 1;
        //     }
        // }
        // public int[] hitBricks(int[][] grid, int[][] hits) {
        //     int m = grid.length;
        //     int n = grid[0].length;
        //     int [] arr = new int [hits.length];
        //     if (m == 1) return arr;
        //     UnionFind uf = new UnionFind();
        //     for (int i = 0; i < m; i++) {   // 每一次这个东西都是需要从新建立的
        //         for (int j = 0; j < n; j++) {
        //             if (i == 0 && grid[i][j] == 1) {
        //                 uf.addToParent(i*n+j);
        //                 continue;
        //             }
        //             if (i > 0 && grid[i][j] == 1 && grid[i-1][j] == 1 && !uf.sameGroup((i-1)*n+j, i*n+j)) 
        //                 uf.merge((i-1)*n+j, i*n+j);
        //             if (j > 0 && grid[i][j] == 1 && grid[i][j-1] == 1 && !uf.sameGroup(i*n+j, i*n+j-1))
        //                 uf.merge(i*n+j-1, i*n+j);
        //         }
        //         for (int j = n-2; j >= 0; j--) {
        //             if (grid[i][j] == 1 && grid[i][j+1] == 1 && uf.pare.containsKey(i*n+j+1) && !uf.sameGroup(i*n+j, i*n+j+1))
        //                 uf.merge(i*n+j+1, i*n+j);
        //         }
        //         if (i > 0) {
        //             for (int j = i-1; j >= 0 ; --j) {
        //                 for (int k = 0; k < n; k++) {
        //                     if (grid[j][k] == 1 && grid[j+1][k] == 1 && uf.pare.containsKey((j+1)*n+k) && !uf.sameGroup(j*n+k, (j+1)*n+k))
        //                         uf.merge((j+1)*n+k, j*n+k);
        //                 }
        //             }
        //         }
        //     }
        //     for (int i = 0; i < hits.length; i++) {
        //         if (grid[hits[i][0]][hits[i][1]] == 0 || uf.find(hits[i][0]*n+hits[i][1]) == hits[i][0]*n+hits[i][1]) {
        //             arr[i] = 0;
        //             continue;
        //         }
        //         arr[i] = uf.getRemovedCnts(hits[i][0], hits[i][1], m, n);
        //     }
        //     return arr;
        // }


        
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [] a = new int [] {7, 21, 3};
        int []  a = new int []  {5, 2, 6, 2};

        boolean res  = s.gcdSort(a);
        System.out.println("res: " + res);
        
    }
}