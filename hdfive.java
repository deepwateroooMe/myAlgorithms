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

        // static final long mod = (int)1e9 + 7;
        // public int sumSubseqWidths(int[] a) {
        //     int n = a.length;
        //     Arrays.sort(a);
        //     long sum = 0, c = 1;
        //     for (int i = 0; i < n; i++) {
        //         // sum = (sum + (long)a[i] * (long)quickMul(2, i) % mod) % mod;  // bug
        //         // sum = (sum - (long)a[i] * (long)quickMul(2, n-(i+1)) % mod + mod) % mod; // bug
        //         // 由于这种机制下的 2 i 和 2 (n−1−i) 不方便同时计算，这里又用了一个 trick ，就是将 A[i] x (2 (n−1−i) ) 转换为了 A[n-1-i] x 2^i
        //         sum = (sum + (long)a[i] * c - (long)a[n-1-i] * c) % mod;
        //         c = (c << 1) % mod;
        //     }
        //     return (int)sum;
        // }
        // // long quickMul(int base, int exp) {
        // //     long ans = 1;
        // //     while (exp > 0) {
        // //         if (exp % 2 == 1)
        // //             ans = (ans * (long)base) % mod;
        // //         base = (int)((base * base) % mod);
        // //         exp >>= 1;
        // //     }
        // //     return ans;
        // // }

        // public double mincostToHireWorkers(int [] qua, int[] w, int k) {
        //     int n = qua.length;
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         l.add(new int [] {qua[i], w[i]});
        //     Collections.sort(l, (a, b)-> Double.compare((double)a[1] / a[0], (double)b[1] / b[0]));
        //     Queue<Integer> q = new PriorityQueue<>((a, b)->b-a);
        //     double sum = 0, ans = 1e9;
        //     for (int i = 0; i < n; i++) {
        //         int [] cur = l.get(i);
        //         sum += cur[0];
        //         q.offer(cur[0]); // quality
        //         if (q.size() > k) sum -= q.poll();
        //         if (q.size() == k) // 需要保证队列里有要求的人数
        //             ans = Math.min(ans, sum * (double)cur[1] / (double)cur[0]);
        //     }
        //     return ans;
        // }

        // public boolean xorGame(int[] a) {
        //     n = a.length;
        //     int xor = 0;
        //     for (Integer v : a) xor ^= v;
        //     dp = new Boolean [n];
        //     return dfs(0, xor, a);
        // }
        // Boolean [] dp;
        // int n;
        // boolean dfs(int idx, int xor, int [] a) {
        //     // if (idx == n) return n % 2 == 1; // bug
        //     if (idx == n) return idx % 2 == 0;
        //     if (dp[idx] != null) return dp[idx];
        //     if (xor == 0) return idx % 2 == 0;
        //     if (idx % 2 == 0) { // alice turn
        //         for (int i = 0; i < n; i++) {
        //             if (a[i] == -1) continue;
        //             if ((xor ^ a[i]) == 0) continue;
        //             int tmp = a[i];
        //             a[i] = -1;
        //             if (dfs(idx+1, xor ^ tmp, a)) // idx
        //                 return dp[idx] = true;
        //             a[i] = tmp;
        //         }
        //         return dp[idx] = false;
        //     } else {
        //         for (int i = 0; i < n; i++) {
        //             if (a[i] == -1) continue;
        //             if ((xor ^ a[i]) == 0) continue;
        //             int tmp = a[i];
        //             a[i] = -1;
        //             if (!dfs(idx+1, xor ^ tmp, a)) // idx
        //                 return dp[idx] = false;
        //             a[i] = tmp;
        //         }
        //         return dp[idx] = true;
        //     }
        // }

        // public int kSimilarity(String s, String t) { // 这个思路简洁明了，代码也比较好写
        //     if (s.equals(t)) return 0;
        //     ArrayDeque<String> q = new ArrayDeque<>();
        //     Set<String> vis = new HashSet<>();
        //     q.offerLast(s);
        //     vis.add(s);
        //     int cnt = 0;
        //     while (!q.isEmpty()) {
        //         for (int z = q.size()-1; z >= 0; z--) {
        //             String cur = q.pollFirst();
        //             // if (cur.equals(t)) return cnt;
        //             for (String next : getAllNeighbour(cur, t)) {
        //                 if (vis.contains(next)) continue;
        //                 if (next.equals(t)) return cnt + 1;
        //                 q.offerLast(next);
        //                 vis.add(next);
        //             }
        //         }
        //         cnt++;
        //     }
        //     return -1;
        // }
        // List<String> getAllNeighbour(String ss, String tt) {
        //     int n = ss.length(), i = 0;
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     List<String> ans = new ArrayList<>();
        //     while (i < n && s[i] == t[i]) i++;
        //     for (int j = i+1; j < n; j++) 
        //         if (s[j] == t[i]) {
        //             swap(i, j, s);
        //             ans.add(new String(s));
        //             swap(i, j, s);
        //         }
        //     return ans;
        // }
        // void swap(int i, int j, char [] s) {
        //     char c = s[i];
        //     s[i] = s[j];
        //     s[j] = c;
        // }
        // // 对于一个环, 我们可以用一个 01 数组表示每条边是否出现，例如对于环 a -> b -> d -> e -> a，它有 4 条边 a -> b，b -> d，d -> e 和 e -> a，那么它对应的数组中，有 4 个位置（这 4 条边对应的位置）的值为 1，其它值为 0。同样地，基础图 GG 也可以用这种方式来表示。
        // // 因此我们可以使用动态规划来解决这个问题，令 numCycles(G) 表示基础图 GG 最多拆分的环的数目。我们枚举环 CC，检查 CC 是否包含于 GG。状态转移方程为 numCycles(G) = max{1 + numcycles(G - C)}
        // public int kSimilarity(String s, String t) { // 这个思路还是没有继续看下去， todo
        //     if (s.equals(t)) return 0;
        //     n = s.length();
        //     memo = new HashMap<>();
        //     int ans = 0, m = alphabet.length;
        //     int [] cnt = new int[m * m];
        //     for (int i = 0; i < n; i++) 
        //         if (s.charAt(i) != t.charAt(i)) {
        //             cnt[m * (s.charAt(i)-'a') + t.charAt(i)-'a']++;
        //             ans++;
        //         }
        //     List<int []> possibles = new ArrayList<>();
        //     for (int size = 2; size <= m; size++)   // Enumerate over every cycle
        //     search: for (String cycle: permutations(alphabet, 0, size)) {
        //             for (int i = 1; i < size; i++) 
        //                 if (cycle.charAt(i) < cycle.charAt(0))
        //                     continue search;
        //             int [] row = new int [cnt.length];
        //             for (int i = 0; i < size; i++) {
        //                 int u = cycle.charAt(i) - 'a';
        //                 int v = cycle.charAt((i+1) % size) - 'a';
        //                 row[m*u + v]++;
        //             }
        //             possibles.add(row);
        //         }
        //     int [] ZERO = new int [cnt.length];
        //     memo.put(Arrays.toString(ZERO), 0);
        //     return ans - numCycles(possibles, cnt);
        // }
        // String [] alphabet = new String [] {"a", "b", "c", "d", "e", "f"};
        // Map<String, Integer> memo = new HashMap<>();
        // int n;
        // public int numCycles(List<int[]> possibles, int[] count) {
        //     String countS = Arrays.toString(count);
        //     if (memo.containsKey(countS)) return memo.get(countS);
        //     int ans = Integer.MIN_VALUE;
        // search: for (int[] row: possibles) {
        //         int[] count2 = count.clone();
        //         for (int i = 0; i < row.length; ++i) {
        //             if (count2[i] >= row[i])
        //                 count2[i] -= row[i];
        //             else continue search;
        //         }
        //         ans = Math.max(ans, 1 + numCycles(possibles, count2));
        //     }
        //     memo.put(countS, ans);
        //     return ans;
        // }
        // public List<String> permutations(String[] alphabet, int used, int size) {
        //     List<String> ans = new ArrayList();
        //     if (size == 0) {
        //         ans.add(new String(""));
        //         return ans;
        //     }
        //     for (int b = 0; b < m; ++b)
        //         if (((used >> b) & 1) == 0)
        //             for (String rest: permutations(alphabet, used | (1 << b), size - 1))
        //                 ans.add(alphabet[b] + rest);
        //     return ans;
        // }

        // public String orderlyQueue(String s, int k) {
        //     if (k > 1) {
        //         char [] t = s.toCharArray();
        //         Arrays.sort(t);
        //         return new String(t);
        //     }
        //     int n = s.length();
        //     String ans = "";
        //     for (int i = 0; i < n; i++) {
        //         String cur = s.substring(i) + s.substring(0, i);
        //         if (ans.length() == 0 || ans.compareTo(cur) > 0)
        //             ans = new String(cur);
        //     }
        //     return ans;
        // }

        public int[] threeEqualParts(int [] a) {
            int n = a.length, cnt = Arrays.stream(a).sum(), cur = 0, i = 0, j = n-1;
            int [] ans = {-1, -1};
            if (cnt % 3 != 0) return ans;
            while (i < n && a[i] == 0) i++;
            while (j >= 0 && cur < cnt / 3) 
                cur += a[j--]; // a[j] = 0 when ended
            // System.out.println("i: " + i);
            // System.out.println("j: " + j);
            if (!sameSequence(i, j+1, a)) return ans;
            
            i += n-(j+1);
            ans[0] = i-1;
            while (i < n && a[i] == 0) i++;
            if (sameSequence(i, j+1, a)) {
                i += n - (j+1);
                ans[1] = i; // bug: 这里 j是可以左移的 0 0 0 0 0 0 0 
            } else ans[0] = -1;
            return ans;
        }
        boolean sameSequence(int i, int j, int [] a) {
            int n = a.length, k = j;
            while (k < n && a[i] == a[k]) {
                i++;
                k++;
            }
            return k == n && i < j;
        }
    }
    public static void main(String[] args) {
        Solution s  =  new Solution();

        // int [] a = new int [] {1,0,1,0,1};
        int []  a = new int []  {1, 1, 0, 0, 1};

        int [] r = s.threeEqualParts(a);
        System.out.println(Arrays.toString(r));
    }
}
// treeNd root  =  new treeNode(a[0]);
// root.buildtree(root, a);
// root.lvlPrinttree(root);