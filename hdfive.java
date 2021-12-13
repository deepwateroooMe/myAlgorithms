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

public class hdfive {
    public static class Solution {

            // int res = 0;
            // private boolean isSame(Map<Integer, Integer> m, Map<Integer, Integer> n) {
            //     if (m.size() != n.size()) return false;
            //     for (Integer key : m.keySet()) 
            //         if (!n.containsKey(key) || n.containsKey(key) && (int)m.get(key) != (int)n.get(key)) return false;
            //     return true;
            // }
            // private int getSmallestK(int [] arr, int idx) {
            //     Map<Integer, Integer> m = new HashMap<>();
            //     Map<Integer, Integer> n = new HashMap<>();
            //     int i = 0;
            //     for (i = idx; i < arr.length; i++) {
            //         m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
            //         n.put(sorted[i], n.getOrDefault(sorted[i], 0) + 1);
            //         if (isSame(m, n)) return i;
            //     }
            //     return i;
            // }
            // private void maxChunksToSortedRecursive(int [] arr, int idx) {
            //     int k = getSmallestK(arr, idx);
            //     res += 1;
            //     if (k >= arr.length-1) return;
            //     maxChunksToSortedRecursive(arr, k+1);
            // }
            // int [] sorted;
            // public int maxChunksToSorted(int[] arr) {
            //     int n = arr.length;
            //     sorted = Arrays.copyOf(arr, n);
            //     Arrays.sort(sorted);
            //     res = 0;
            //     maxChunksToSortedRecursive(arr, 0);
            //     return res;
            // }
        // public int maxChunksToSorted(int[] a) { // bug: 不知道错哪里了
        //     n = a.length;
        //     b = Arrays.copyOf(a, n);
        //     Arrays.sort(b);
        //     maxChunksToSortedRecursive(a, 0);
        //     return ans;
        // }
        // int [] b;
        // int n, ans = 0;
        // void maxChunksToSortedRecursive(int [] a, int idx) {
        //     Map<Integer, Integer> ma = new HashMap<>();
        //     Map<Integer, Integer> mb = new HashMap<>();
        //     int i = idx;
        //     for (; i < n; i++) {
        //         ma.put(a[i], ma.getOrDefault(a[i], 0) + 1);
        //         mb.put(b[i], mb.getOrDefault(b[i], 0) + 1);
        //         if (isSame(ma, mb)) {
        //             ans++;
        //             break;
        //         }
        //     }
        //     if (i < n-1) maxChunksToSortedRecursive(a, i+1);
        // }
        // boolean isSame(Map<Integer, Integer> m, Map<Integer, Integer> k) {
        //     if (m.size() != k.size()) return false;
        //     for (Integer key : m.keySet()) 
        //         if (!k.containsKey(key) || k.containsKey(key) && k.get(key) != m.get(key)) return false;
        //     return true;
        // }
        // public int maxChunksToSorted(int [] a) {
        //     int n = a.length;
        //     int cmax = Integer.MIN_VALUE;
        //     int [] smin = new int[n];
        //     smin[n-1] = a[n-1];
        //     for (int i = n-2; i >= 0; i--) 
        //         smin[i] = smin[i+1] < a[i] ? smin[i+1] : a[i];
        //     int cnt = 1;
        //     for (int i = 0; i < n-1; i++) {
        //         cmax = Math.max(cmax, a[i]);
        //         if (cmax <= smin[i+1]) cnt++;
        //     }
        //     return cnt;
        // }

        // public int bestRotation(int[] a) {
        //     int n = a.length, ans = 0;
        //     int [] change = new int [n];
        //     for (int i = 0; i < n; i++) change[(i - a[i] + 1 + n) % n] -= 1;
        //     for (int i = 1; i < n; i++) {
        //         change[i] += change[i-1] + 1;
        //         ans = change[i] > change[ans] ? i : ans;
        //     }
        //     return ans;
        // }

        // public int numBusesToDestination(int[][] a, int s, int t) { // 没有tle,但是好一个慢字了得。。。。。。
        //     if (s == t) return 0;
        //     int n = a.length;
        //     Map<Integer, List<Integer>> adj = new HashMap<>();
        //     Queue<Integer> q = new LinkedList<>();
        //     boolean [] vis = new boolean [n];
        //     for (int i = 0; i < n; i++) 
        //         if (Arrays.stream(a[i]).boxed().collect(Collectors.toList()).contains(s)) {
        //             q.offer(i);
        //             vis[i] = true;
        //         }
        //     int cnt = 1;
        //     Set<Integer> sa = new HashSet<>(), sb = new HashSet<>();
        //     while (!q.isEmpty()) {
        //         for (int z = q.size()-1; z >= 0; z--) {
        //             int u = q.poll();
        //             if (Arrays.stream(a[u]).boxed().collect(Collectors.toList()).contains(t)) return cnt;
        //             sa = new HashSet<>(Arrays.stream(a[u]).boxed().collect(Collectors.toList()));
        //             for (int j = 0; j < n; j++) {
        //                 if (j == u || vis[j]) continue;
        //                 sb = new HashSet<>(Arrays.stream(a[j]).boxed().collect(Collectors.toList()));
        //                 sb.retainAll(sa);
        //                 if (sb.size() > 0) {
        //                     q.offer(j);
        //                     vis[j] = true;
        //                 }
        //             }
        //         }
        //         cnt++;
        //     }
        //     return -1;
        // }
        // public int numBusesToDestination(int[][] a, int s, int t) { // 个人认为这个方法最适合俺们普罗大众。。。。。。
        //     if (s == t) return 0;
        //     Queue<Integer> q = new LinkedList<>();
        //     Map<Integer, List<Integer>> adj = new HashMap<>(); // 纪录每一个站点有哪些公交车可乘换
        //     for (int i = 0; i < a.length; i++)
        //         for (int j = 0; j < a[i].length; j++)
        //             adj.computeIfAbsent(a[i][j], z -> new ArrayList<>()).add(i);
        //     Set<Integer> vis = new HashSet<>();
        //     q.offer(s); 
        //     int ans = 1; 
        //     while (!q.isEmpty()) { // 然后遍历所有的站点站台，找一个最快的解
        //         for (int z = q.size()-1; z >= 0; z--) {
        //             int cur = q.poll();
        //             List<Integer> bs = adj.get(cur);
        //             for (int bus : bs) {
        //                 if (vis.contains(bus)) continue;
        //                 vis.add(bus);
        //                 for (int j = 0; j < a[bus].length; j++) {
        //                     if (a[bus][j] == t) return ans;
        //                     q.offer(a[bus][j]);  
        //                 }
        //             }
        //         }
        //         ans++;
        //     }
        //     return -1;
        // }
        // public int numBusesToDestination(int[][] routes, int S, int T) { // 这个方法慢
        //     int n = routes.length;
        //     HashMap<Integer, HashSet<Integer>> to_routes = new HashMap<>();
        //     for (int i = 0; i < routes.length; ++i) {
        //         for (int j : routes[i]) {
        //             if (!to_routes.containsKey(j))
        //                 to_routes.put(j, new HashSet<Integer>());
        //             to_routes.get(j).add(i);
        //         }
        //     }
        //     Queue<int[]> bfs = new ArrayDeque();
        //     bfs.offer(new int[] {S, 0});
        //     HashSet<Integer> seen = new HashSet<>();
        //     seen.add(S);
        //     boolean[] seen_routes = new boolean[n];
        //     while (!bfs.isEmpty()) {
        //         int stop = bfs.peek()[0], bus = bfs.peek()[1];
        //         bfs.poll();
        //         if (stop == T) return bus;
        //         for (int i : to_routes.get(stop)) {
        //             if (seen_routes[i]) continue;
        //             for (int j : routes[i]) {
        //                 if (!seen.contains(j)) {
        //                     seen.add(j);
        //                     bfs.offer(new int[] {j, bus + 1});
        //                 }
        //             }
        //             seen_routes[i] = true;
        //         }
        //     }
        //     return -1;
        // }
        // public int numBusesToDestination(int[][] a, int s, int t) { // 这个最快，但不是很容易记住
        //     if (s == t) return 0;
        //     int n = a.length;
        //     boolean [][] cnn = new boolean [n][n];
        //     Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        //     for (int i = 0; i < n; i++) 
        //         for (int site : a[i]) {
        //             List<Integer> list = adj.getOrDefault(site, new ArrayList<Integer>());
        //             for (int j : list) 
        //                 cnn[i][j] = cnn[j][i] = true;
        //             list.add(i);
        //             adj.put(site, list);
        //             // adj.computeIfAbsent(site, z -> new ArrayList<>()).add(i);
        //         }
        //     int [] dis = new int [n];
        //     Arrays.fill(dis, -1);
        //     Queue<Integer> q = new LinkedList<Integer>();
        //     for (int bus : adj.getOrDefault(s, new ArrayList<Integer>())) {
        //         dis[bus] = 1;
        //         q.offer(bus);
        //     }
        //     while (!q.isEmpty()) {
        //         int x = q.poll();
        //         for (int y = 0; y < n; y++) 
        //             if (cnn[x][y] && dis[y] == -1) {
        //                 dis[y] = dis[x] + 1;
        //                 q.offer(y);
        //             }
        //     }
        //     int ans = Integer.MAX_VALUE;
        //     for (int bus : adj.getOrDefault(t, new ArrayList<Integer>())) 
        //         if (dis[bus] != -1) 
        //             ans = Math.min(ans, dis[bus]);
        //     return ans == Integer.MAX_VALUE ? -1 : ans;
        // }

    // Random rand;
    // int [] dk;
    // int m, n ;
    // public Solution(int n, int[] blacklist) {
    //     this.m = blacklist.length;
    //     this.dk = Arrays.copyOf(blacklist, m);
    //     this.n = n;
    //     rand = new Random();
    //     Arrays.sort(this.dk);
    // }
    // // 这是一个不容易理解的方法，其思想是：已知白名单中的元素个数必然有 N-blen 个，我直接生成一个`[0,N-blen)`中的随机数k，代表我要找白名单中的第k个数；现在我要解决的问题是，如何快速确定**白名单中**的第k个数在**总名单**上的第几个位置。
    // // 现假设这个数在**总名单**上的第x个位置（总名单第x个位置的成员就等于x），则有两种情况：
    // // 1. 黑名单上所有的数都比x大，那么x左侧不可能含有黑名单成员，直接返回x即可，因为它就是白名单成员之一。
    // // 2. 黑名单上有y个数都小于x，那么说明x的左侧一定有y个黑名单成员。所以x实际上是总名单中的第k个数往后再数y个位置的结果，其中k等于值x在白名单中的索引。
    // // 所以问题就转化成了随机产生一个k，去找到y，从而确定x。
    // // 1. 首先对黑名单进行排序
    // // 2. 每次调用`pick()`
    // //         1. 先随机产生k
    // //         2. 然后利用二分查找，利用k确定y
    // //         1. 初始low指针=0，high指针=blen-1
    // //             2. 每次`mid=(low+high+1)/2`，比较`B[mid]`与k的大小关系，然后收缩y的范围
    // //             3. 如果y=0，直接返回k；如果y>0，返回k+y+1
    // public int pick() {
    //     int next = rand.nextInt(n-m);
    //     int l = 0, r = m-1;
    //     while (l < r) {
    //         int mid = (l + r + 1) / 2;
    //         if (dk[mid] - mid > next) r = mid-1;
    //         else l = mid;
    //     }
    //     return l == r && dk[l] - l <= next ? next + l + 1 : next;
    // }
    // Map<Integer, Integer> map = new HashMap<>(); // idx, v, 存得太多了，不需要，只要存黑名单里存在的配对就可以了
    // Set<Integer> hi = new HashSet<>();
    // Random rand;
    // int m, n;
    // public Solution(int n, int[] a) {
    //     this.n = n;
    //     m = a.length;
    //     Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
    //     for (int i = n-m; i < n; i++) 
    //         if (!s.contains(i))
    //             hi.add(i);
    //     Iterator it = hi.iterator();
    //     for (Integer v : s) 
    //         if (v < n-m) map.put(v, it.next());
    //     // int j = n-1;
    //     // for (int i = 0; i < n-m; i++) { // 也不用遍历这个大头，只需要遍历黑名单里的就可以了
    //     //     if (s.contains(i)) {
    //     //         while (j > i && s.contains(j)) j--;
    //     //         map.put(i, j--);
    //     //     } else map.put(i, i);
    //     // }
    //     rand = new Random();
    // }
    // public int pick() {
    //     int i = rand.nextInt(n-m);
    //     return map.containsKey(i) ? map.get(i) : i;
    // }

    // Map<Integer, List<Integer>> cnt = new HashMap<>();
    // Map<Integer, Integer> m = new HashMap<>();
    // // ArrayDeque<Integer> s = new ArrayDeque<>();
    // // ArrayDeque<Integer> t = new ArrayDeque<>();
    // int maxCnt = 0;
    // // public FreqStack() {
    // public hdfive() {
    // }
    // public void push(int val) { // BUG: 这里面数值的添加顺序没有理对，改天回来再写这个
    //     // s.offerLast(val);
    //     m.put(val, m.getOrDefault(val, 0) + 1);
    //     int v = m.get(val);
    //     maxCnt = Math.max(maxCnt, v);
    //     cnt.computeIfAbsent(v, z -> new ArrayList<>()).add(val);
    //     System.out.println("v: " + v);
    //     if (v > 1) cnt.get(v-1).remove(new Integer(val));
    //     // System.out.println("cnt.size(): " + cnt.size());
    //     // for (Map.Entry<Integer, List<Integer>> en : cnt.entrySet()) {
    //     //     System.out.print(en.getKey() + ": ");
    //     //     System.out.println(Arrays.toString(en.getValue().toArray()));
    //     // }
    // }
    // public int pop() {
    //     List<Integer> l = cnt.get(maxCnt);
    //     int ans = l.remove(l.size()-1);
    //     if (maxCnt > 1) {
    //         cnt.computeIfAbsent(maxCnt-1, z -> new ArrayList<>()).add(ans);
    //         m.put(ans, m.get(ans) - 1);
    //     } else m.remove(ans);
    //     if (l.size() == 0) {
    //         cnt.remove(maxCnt);
    //         maxCnt--;
    //     }
    //     return ans;
    // }
    // hdfive s = new hdfive();
    // s.push(5); // The stack is [5]
    // s.push(7); // The stack is [5,7]
    // s.push(5); // The stack is [5,7,5]
    // s.push(7); // The stack is [5,7,5,7]
    // s.push(4); // The stack is [5,7,5,7,4]
    // s.push(5); // The stack is [5,7,5,7,4,5]
    // int r = s.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
    // System.out.println("r: " + r);
    // int r1 = s.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
    // System.out.println("r1: " + r1);
    // int r2 = s.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
    // System.out.println("r2: " + r2);
    // int r3 = s.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    // System.out.println("r3: " + r3);

        static final long mod = (int)1e9 + 7;
        public int sumSubseqWidths(int[] a) {
            int n = a.length;
            Arrays.sort(a);
            long sum = 0, c = 1;
            for (int i = 0; i < n; i++) {
                // sum = (sum + (long)a[i] * (long)quickMul(2, i) % mod) % mod;  // bug
                // sum = (sum - (long)a[i] * (long)quickMul(2, n-(i+1)) % mod + mod) % mod; // bug
                // 由于这种机制下的 2 i 和 2 (n−1−i) 不方便同时计算，这里又用了一个 trick ，就是将 A[i] x (2 (n−1−i) ) 转换为了 A[n-1-i] x 2^i
                sum = (sum + (long)a[i] * c - (long)a[n-1-i] * c) % mod;
                c = (c << 1) % mod;
            }
            return (int)sum;
        }
        long quickMul(int base, int exp) {
            long ans = 1;
            while (exp > 0) {
                if (exp % 2 == 1)
                    ans = (ans * (long)base) % mod;
                base = (int)((base * base) % mod);
                exp >>= 1;
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution s  =  new Solution();

        // int [] a = new int [] {2,1,3};
        int []  a = new int []  {5, 69, 89, 92, 31, 16, 25, 45, 63, 40, 16, 56, 24, 40, 75, 82, 40, 12, 50, 62, 92, 44, 67, 38, 92, 22, 91, 24, 26, 21, 100, 42, 23, 56, 64, 43, 95, 76, 84, 79, 89, 4, 16, 94, 16, 77, 92, 9, 30, 13};

        int r = s.sumSubseqWidths(a);
        System.out.println("r: " + r);
    }
}
// treeNd root  =  new treeNode(a[0]);
// root.buildtree(root, a);
// root.lvlPrinttree(root);