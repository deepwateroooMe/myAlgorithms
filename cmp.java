import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class cmp {
    public static class Solution {
        
        // public static List<Integer> minimalHeaviestSetA(List<Integer> a) { // N: [1, 10^5] 降序排列
        //     int n = a.size();
        //     // Collections.sort(a, (x, y) -> y - x);
        //     Collections.sort(a); // 升序排列
        //     long [] s = new long [n];
        //     long t = s[n-1], cur = 0l;
        //     for (int i = 0; i < n; i++) 
        //         s[i] = (i == 0 ? 0 : s[i-1]) + a.get(i);
        //     for (int i = n-1; i > 0; i--) {
        //         cur = t - s[i-1];
        //         if (cur > s[i-1])
        //             return a.subList(i, n);
        //     }
        //     return new ArrayList<>();
        // }
        
        // public static int countGroups(List<String> a) {
        //     int m = a.size(), n = a.get(0).length();
        //     char [][] arr = new char [m][n];
        //     for (int i = 0; i < m; i++) 
        //         arr[i] = a.get(i).toCharArray();
        //     DSU uf = new DSU(n);
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < i; j++) {
        //             if (arr[i][j] == 1 && !uf.areConnected(i, j))
        //                 uf.union(i, j);
        //         }
        //     return uf.getCnt();
        // }
        // private static class DSU {
        //     private int N;
        //     private int [] parent, rank;
        //     public DSU( int n) {
        //         this.N = n;
        //         this.parent = new int [N];
        //         this.rank = new int [N];
        //         for (int i = 0; i < N; i++) {
        //             this.parent[i] = i;
        //             this.rank[i] = 1;
        //         }
        //     }
        //     public int getCnt() {
        //         Set<Integer> s = new HashSet<>();
        //         for (int i = 0; i < N; i++) {
        //             find(i);
        //             if (!s.contains(parent[i])) s.add(parent[i]);
        //         }
        //         return s.size();
        //     }
        //     public boolean areConnected(int u, int v) {
        //         return find(u) == find(v);
        //     }
        //     public void union(int u, int v) { // O(Log(N))
        //         if (u != v) {
        //             int p = find(u);
        //             int q = find(v);
        //                 if (p != q) {
        //                     if (rank[p] > rank[q]) {
        //                         parent[q] = p;
        //                         rank[p] += rank[q];
        //                     } else {
        //                         parent[p] = q;
        //                         rank[q] += rank[p];
        //                     }
        //                 }
        //         }
        //     }
        //     private int find(int v) {
        //         int x = v;
        //         while (x != parent[x])
        //             x = parent[x];
        //         parent[v] = x;
        //         return x;
        //     }
        // }

        // public static long getHeaviestPackage(List<Integer> l) {
        //     ArrayDeque<Long> s = new ArrayDeque<>();
        //     int n = l.size();
        //     long max = 0l, cur = 0l;
        //     for (int i = n-1; i >= 0; i--) {
        //         System.out.println("\n i: " + i);
        //         if (s.isEmpty() || l.get(i) < s.peekLast()) {
        //             s.offerLast((long)l.get(i) + (s.isEmpty() ? 0 : s.pollLast()));
        //             continue;
        //         }
        //         if (l.get(i) >= s.peekLast())
        //             s.offerLast((long)l.get(i));
        //         else if (i == 0 || l.get(i) <= l.get(i-1)) {
        //             cur = l.get(i);
        //             while (!s.isEmpty() && cur < s.peekLast()) {
        //                 cur += s.pollLast();
        //             }
        //             max = Math.max(max, cur);
        //             s.offerLast(cur);
        //         }
        //     }
        //     for (var v : s) 
        //         max = Math.max(max, v);
        //     return max;
        // }
        
        // public int findMaximumSustainableClusterSize(List<Integer> pl, List<Integer> bl, long pmax) {
        //     p = pl.stream().mapToInt(Integer::intValue).toArray();
        //     b = bl.stream().mapToInt(Integer::intValue).toArray();
        //     n = p.length;
        //     s = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         s[i] = (i == 0 ? 0 : s[i-1]) + p[i];
        //     int l = 1, r = n, ans = 0;
        //     while (l <= r) { // O(NlogN) sliding window for maximum O(N)
        //         int m = l + (r - l) / 2;
        //         System.out.println("\n m: " + m);
        //         System.out.println("l: " + l);
        //         System.out.println("r: " + r);
        //         if (isPossible(m, pmax)) {
        //             ans = m;
        //             l = m + 1;
        //             System.out.println("ans: " + ans);
        //         } else r = m-1;
        //     }
        //     return ans;
        // }
        // int [] p, b, s;
        // int n;
        // boolean isPossible(int v, long limit) { // sliding window to find a matched one
        //     ArrayDeque<Integer> q = new ArrayDeque<>(); // 好像是双端队列，可排序的，升序排列吧(那就是一个最大堆，但是比堆效率高O(N)而不是堆的O(NlogN))
        //     for (int l = 0, r = 0; r < n; r++) { // left right
        //         while (!q.isEmpty() && r - q.peekFirst() >= v) 
        //             q.pollFirst(); // 左出不在窗口内的(最大)值
        //         if (q.isEmpty() || b[r] > b[q.peekLast()]) // 保证升序排列
        //             q.offerLast(r); // 当前入列
        //         while (r > l + v -1) l++;
        //         if (r == l + v - 1) {
        //             if ((long)((s[r] - (l == 0 ? 0 : s[l-1])) * v + b[q.peekLast()]) <= limit)
        //                 return true;
        //         }
        //     }
        //     return false;
        // }
        
        // public int mostFrequentEven(int[] a) {
        //     int n = a.length, ans = -1, max = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (var v : a) {
        //         if (v % 2 == 0) {
        //             m.put(v, m.getOrDefault(v, 0) + 1);
        //             if (m.get(v) >= max) {
        //                 if (m.get(v) == max)
        //                     ans = Math.min(ans, v);
        //                 else ans = v;
        //                 max = m.get(v);
        //             }
        //         }
        //     }
        //     return ans;
        // }

        // public int partitionString(String t) {
        //     int n = t.length(), cnt = 0;
        //     char [] s = t.toCharArray();
        //     Set<Character> m = new HashSet<>();
        //     for (int l = 0, i = 0; i < n; i++) { // i: right
        //         if (!m.contains(s[i])) {
        //             m.add(s[i]);
        //             continue;
        //         } else {
        //             m.clear();
        //             cnt++;
        //             m.add(s[i]);
        //         }
        //     }
        //     return cnt + 1;
        // }

        // TreeSet<Range> ts;
        // public RangeModule() {
        //     ts = new TreeSet<>((a, b) -> a.l != b.l ? a.l - b.l : a.r - b.r);
        // }
        // public void addRange(int left, int right) {
        //     int l = left, r = right;
        //     Range hi = new Range(r, Integer.MAX_VALUE);
        //     while (true) { // 相当于是合并有交集的子集
        //         Range lower = ts.lower(hi);
        //         if (lower == null || lower.r < l) break;
        //         if (lower.r > r) r = lower.r;
        //         if (lower.l < l) l = lower.l;
        //         ts.remove(lower);
        //     }
        //     ts.add(new Range(l, r));
        // }
        // // floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
        // // ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
        // public boolean queryRange(int left, int right) {
        //     Range cur = ts.floor(new Range(left, Integer.MAX_VALUE));
        //     return cur != null && cur.l <= left && cur.r >= right;
        // }
        // public void removeRange(int left, int right) {
        //     Range hi = new Range(right, right);
        //     while (true) {
        //         Range lower = ts.lower(hi);
        //         if (lower == null || lower.r <= left) break;
        //         if (lower.r > right) ts.add(new Range(right, lower.r));
        //         if (lower.l < left) ts.add(new Range(lower.l, left));
        //         ts.remove(lower);
        //     }
        // }
        // // 不知道哪里写错了
        // class Range implements Comparable<Range> {
        //     int l, r;
        //     public Range(int l, int r) {
        //         this.l = l;
        //         this.r = r;
        //     }
        //     @Override public int compareTo(Range other) {
        //         return this.l - other.l;
        //     }
        // }
        // boolean vis = false;
        // public int minGroups(int[][] a) {
        //     int n = a.length;
        //     List<TreeSet<Range>> l = new ArrayList<>();
        //     for (var i : a) {
        //         Range r = new Range(i[0], i[1]);
        //         vis = false;
        //         for (var ts : l) {
        //             Range lower = ts.floor(r);
        //             Range higher = ts.ceiling(r);
        //             if ((lower == null || lower.r < r.l) && (higher == null || higher.l > r.r)) {
        //                 ts.add(r);
        //                 vis = true;
        //                 break;
        //             }
        //         }
        //         if (!vis) {
        //             TreeSet<Range> s = new TreeSet<>(); // 升序排列
        //             s.add(r);
        //             l.add(s);
        //         }
        //     }
        //     return l.size();
        // }
        // int [][] a = new int [][] {{229966,812955},{308778,948377},{893612,952735},{395781,574123},{478514,875165},{766513,953839},{460683,491583},{133951,212694},{376149,838265},{541380,686845},{461394,568742},{804546,904032},{422466,467909},{557048,758709},{680460,899053},{110928,267321},{470258,650065},{534607,921875},{292993,994721},{645020,692560},{898840,947977},{33584,330630},{903142,970252},{17375,626775},{804313,972796},{582079,757160},{785002,987823},{599263,997719},{486500,527956},{566481,813653},{211239,863969},{808577,883125},{21880,516436},{264747,412144},{327175,772333},{984807,988224},{758172,916673},{23583,406006},{954674,956043},{379202,544291},{688869,785368},{841735,983869},{99836,916620},{332504,740696},{740840,793924},{896607,920924},{868540,922727},{125849,550941},{433284,685766}};

        // public int lengthOfLIS(int[] a, int k) { // N: [1, 10^5] 有个贪心的O(NlogN)算法，但是一时半会儿想不起来了
        //     int n = a.length, max = 1;
        //     int [] f = new int [n];
        //     Arrays.fill(f, 1); // 初始化
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) {
        //             if (a[j] > a[i] && a[j] - a[i] <= k) {
        //                 if (f[i] + 1 > f[j]) {
        //                     f[j] = f[i] + 1;
        //                     max = Math.max(max, f[j]);
        //                 }
        //             }
        //         }
        //     return max;
        // }
        public int lengthOfLIS(int[] a, int k) { // N: [1, 10^5] 有个贪心的O(NlogN)算法，但是一时半会儿想不起来了
            int n = a.length, max = 1, N = Arrays.stream(a).max().getAsInt() + 1;
            // List<Integer>[] ll = new ArrayList[N];
            // Arrays.setAll(ll, z -> new ArrayList<>());
            // ll[a[0]].add(a[0]);
            int [][] f = new int [N][2];
            for (var v : a) {
                f[v][0] = v; // 队尾的值 
                f[v][1] = 1; // 初始化，以当前值为头的最大长度
            }
            // System.out.println("f.length: " + f.length);
            // for (int z = 0; z < f.length; ++z) 
            //     System.out.println(Arrays.toString(f[z]));

            for (int i = 1; i < n; i++) {
                System.out.println("\n i: " + i);
                for (int j = a[i]-1; j >= Math.max(1, a[i]-k); j--) {
                    System.out.println("j: " + j); 
                    if (f[j][1] > 0 && f[j][0] >= a[i] - k && f[j][1] + 1 >= f[i][1]) {
                        if (f[j][1] + 1 > f[i][1]) {
                            f[i][1] = f[j][1] + 1;
                            max = Math.max(max, f[i][1]);
                            System.out.println("max: " + max); 
                        } // 没想明白其它情况下要如何再优化一下
                    }
                }
                // if (a[i] > l.get(l.size()-1) && a[i] - l.get(l.size()-1) <= k) {
                //     l.add(a[i]);
                //     max = l.size();
                // } else {
                //     int bgn = 0, end = l.size()-1, m = -1;
                //     while (bgn <= end) {
                //         int mid = bgn + (end - bgn) / 2;
                //         if (a[i] <= l.get(mid)) {
                //             m = mid;
                //             end = mid - 1;
                //         } else bgn =  mid + 1;
                //     }
                //     if (m != -1 && l.get(m) > a[i]) // 贪心法：总是填最小可能的值在一个位置上
                //         l.set(m, a[i]);
                // }
                System.out.println("max: " + max); 
            }
            return max;
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        int r = s.wordCount(a, b);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

 // ListNode r = s.deleteMiddle(head);
 // r.printList(r);

 // TreeNode root = new TreeNode(a[0]);
 // root.buildTree(root, a);
 // root.levelPrintTree(root);
        
 // String r = s.getDirections(root, 2, 1);
 // System.out.println("r: " + r);

