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

        int res = 0;
        private boolean isSame(Map<Integer, Integer> m, Map<Integer, Integer> n) {
            if (m.size() != n.size()) return false;
            for (Integer key : m.keySet()) 
                if (!n.containsKey(key) || n.containsKey(key) && (int)m.get(key) != (int)n.get(key)) return false;
            return true;
        }
        private int getSmallestK(int [] arr, int idx) {
            Map<Integer, Integer> m = new HashMap<>();
            Map<Integer, Integer> n = new HashMap<>();
            int i = 0;
            for (i = idx; i < arr.length; i++) {
                m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
                n.put(sorted[i], n.getOrDefault(sorted[i], 0) + 1);
                if (isSame(m, n)) return i;
            }
            return i;
        }
        private void maxChunksToSortedRecursive(int [] arr, int idx) {
            int k = getSmallestK(arr, idx);
            res += 1;
            if (k >= arr.length-1) return;
            maxChunksToSortedRecursive(arr, k+1);
        }
        int [] sorted;
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;
            sorted = Arrays.copyOf(arr, n);
            Arrays.sort(sorted);
            res = 0;
            maxChunksToSortedRecursive(arr, 0);
            return res;
        }
        public int maxChunksToSorted(int[] a) { // bug: 不知道错哪里了
            n = a.length;
            b = Arrays.copyOf(a, n);
            Arrays.sort(b);
            maxChunksToSortedRecursive(a, 0);
            return ans;
        }
        int [] b;
        int n, ans = 0;
        void maxChunksToSortedRecursive(int [] a, int idx) {
            Map<Integer, Integer> ma = new HashMap<>();
            Map<Integer, Integer> mb = new HashMap<>();
            int i = idx;
            for (; i < n; i++) {
                ma.put(a[i], ma.getOrDefault(a[i], 0) + 1);
                mb.put(b[i], mb.getOrDefault(b[i], 0) + 1);
                if (isSame(ma, mb)) {
                    ans++;
                    break;
                }
            }
            if (i < n-1) maxChunksToSortedRecursive(a, i+1);
        }
        boolean isSame(Map<Integer, Integer> m, Map<Integer, Integer> k) {
            if (m.size() != k.size()) return false;
            for (Integer key : m.keySet()) 
                if (!k.containsKey(key) || k.containsKey(key) && k.get(key) != m.get(key)) return false;
            return true;
        }
        public int maxChunksToSorted(int [] a) {
            int n = a.length;
            int cmax = Integer.MIN_VALUE;
            int [] smin = new int[n];
            smin[n-1] = a[n-1];
            for (int i = n-2; i >= 0; i--) 
                smin[i] = smin[i+1] < a[i] ? smin[i+1] : a[i];
            int cnt = 1;
            for (int i = 0; i < n-1; i++) {
                cmax = Math.max(cmax, a[i]);
                if (cmax <= smin[i+1]) cnt++;
            }
            return cnt;
        }

        public int bestRotation(int[] a) {
            int n = a.length, ans = 0;
            int [] change = new int [n];
            for (int i = 0; i < n; i++) change[(i - a[i] + 1 + n) % n] -= 1;
            for (int i = 1; i < n; i++) {
                change[i] += change[i-1] + 1;
                ans = change[i] > change[ans] ? i : ans;
            }
            return ans;
        }

        public int numBusesToDestination(int[][] a, int s, int t) { // 没有tle,但是好一个慢字了得。。。。。。
            if (s == t) return 0;
            int n = a.length;
            Map<Integer, List<Integer>> adj = new HashMap<>();
            Queue<Integer> q = new LinkedList<>();
            boolean [] vis = new boolean [n];
            for (int i = 0; i < n; i++) 
                if (Arrays.stream(a[i]).boxed().collect(Collectors.toList()).contains(s)) {
                    q.offer(i);
                    vis[i] = true;
                }
            int cnt = 1;
            Set<Integer> sa = new HashSet<>(), sb = new HashSet<>();
            while (!q.isEmpty()) {
                for (int z = q.size()-1; z >= 0; z--) {
                    int u = q.poll();
                    if (Arrays.stream(a[u]).boxed().collect(Collectors.toList()).contains(t)) return cnt;
                    sa = new HashSet<>(Arrays.stream(a[u]).boxed().collect(Collectors.toList()));
                    for (int j = 0; j < n; j++) {
                        if (j == u || vis[j]) continue;
                        sb = new HashSet<>(Arrays.stream(a[j]).boxed().collect(Collectors.toList()));
                        sb.retainAll(sa);
                        if (sb.size() > 0) {
                            q.offer(j);
                            vis[j] = true;
                        }
                    }
                }
                cnt++;
            }
            return -1;
        }
        public int numBusesToDestination(int[][] a, int s, int t) { // 个人认为这个方法最适合俺们普罗大众。。。。。。
            if (s == t) return 0;
            Queue<Integer> q = new LinkedList<>();
            Map<Integer, List<Integer>> adj = new HashMap<>(); // 纪录每一个站点有哪些公交车可乘换
            for (int i = 0; i < a.length; i++)
                for (int j = 0; j < a[i].length; j++)
                    adj.computeIfAbsent(a[i][j], z -> new ArrayList<>()).add(i);
            Set<Integer> vis = new HashSet<>();
            q.offer(s); 
            int ans = 1; 
            while (!q.isEmpty()) { // 然后遍历所有的站点站台，找一个最快的解
                for (int z = q.size()-1; z >= 0; z--) {
                    int cur = q.poll();
                    List<Integer> bs = adj.get(cur);
                    for (int bus : bs) {
                        if (vis.contains(bus)) continue;
                        vis.add(bus);
                        for (int j = 0; j < a[bus].length; j++) {
                            if (a[bus][j] == t) return ans;
                            q.offer(a[bus][j]);  
                        }
                    }
                }
                ans++;
            }
            return -1;
        }
        public int numBusesToDestination(int[][] routes, int S, int T) { // 这个方法慢
            int n = routes.length;
            HashMap<Integer, HashSet<Integer>> to_routes = new HashMap<>();
            for (int i = 0; i < routes.length; ++i) {
                for (int j : routes[i]) {
                    if (!to_routes.containsKey(j))
                        to_routes.put(j, new HashSet<Integer>());
                    to_routes.get(j).add(i);
                }
            }
            Queue<int[]> bfs = new ArrayDeque();
            bfs.offer(new int[] {S, 0});
            HashSet<Integer> seen = new HashSet<>();
            seen.add(S);
            boolean[] seen_routes = new boolean[n];
            while (!bfs.isEmpty()) {
                int stop = bfs.peek()[0], bus = bfs.peek()[1];
                bfs.poll();
                if (stop == T) return bus;
                for (int i : to_routes.get(stop)) {
                    if (seen_routes[i]) continue;
                    for (int j : routes[i]) {
                        if (!seen.contains(j)) {
                            seen.add(j);
                            bfs.offer(new int[] {j, bus + 1});
                        }
                    }
                    seen_routes[i] = true;
                }
            }
            return -1;
        }
        public int numBusesToDestination(int[][] a, int s, int t) { // 这个最快，但不是很容易记住
            if (s == t) return 0;
            int n = a.length;
            boolean [][] cnn = new boolean [n][n];
            Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
            for (int i = 0; i < n; i++) 
                for (int site : a[i]) {
                    List<Integer> list = adj.getOrDefault(site, new ArrayList<Integer>());
                    for (int j : list) 
                        cnn[i][j] = cnn[j][i] = true;
                    list.add(i);
                    adj.put(site, list);
                    // adj.computeIfAbsent(site, z -> new ArrayList<>()).add(i);
                }
            int [] dis = new int [n];
            Arrays.fill(dis, -1);
            Queue<Integer> q = new LinkedList<Integer>();
            for (int bus : adj.getOrDefault(s, new ArrayList<Integer>())) {
                dis[bus] = 1;
                q.offer(bus);
            }
            while (!q.isEmpty()) {
                int x = q.poll();
                for (int y = 0; y < n; y++) 
                    if (cnn[x][y] && dis[y] == -1) {
                        dis[y] = dis[x] + 1;
                        q.offer(y);
                    }
            }
            int ans = Integer.MAX_VALUE;
            for (int bus : adj.getOrDefault(t, new ArrayList<Integer>())) 
                if (dis[bus] != -1) 
                    ans = Math.min(ans, dis[bus]);
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        Random rand;
        int [] dk;
        int m, n ;
        public Solution(int n, int[] blacklist) {
            this.m = blacklist.length;
            this.dk = Arrays.copyOf(blacklist, m);
            this.n = n;
            rand = new Random();
            Arrays.sort(this.dk);
    }
    // 这是一个不容易理解的方法，其思想是：已知白名单中的元素个数必然有 N-blen 个，我直接生成一个`[0,N-blen)`中的随机数k，代表我要找白名单中的第k个数；现在我要解决的问题是，如何快速确定**白名单中**的第k个数在**总名单**上的第几个位置。
    // 现假设这个数在**总名单**上的第x个位置（总名单第x个位置的成员就等于x），则有两种情况：
    // 1. 黑名单上所有的数都比x大，那么x左侧不可能含有黑名单成员，直接返回x即可，因为它就是白名单成员之一。
    // 2. 黑名单上有y个数都小于x，那么说明x的左侧一定有y个黑名单成员。所以x实际上是总名单中的第k个数往后再数y个位置的结果，其中k等于值x在白名单中的索引。
    // 所以问题就转化成了随机产生一个k，去找到y，从而确定x。
    // 1. 首先对黑名单进行排序
    // 2. 每次调用`pick()`
    //         1. 先随机产生k
    //         2. 然后利用二分查找，利用k确定y
    //         1. 初始low指针=0，high指针=blen-1
    //             2. 每次`mid=(low+high+1)/2`，比较`B[mid]`与k的大小关系，然后收缩y的范围
    //             3. 如果y=0，直接返回k；如果y>0，返回k+y+1
    public int pick() {
        int next = rand.nextInt(n-m);
        int l = 0, r = m-1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (dk[mid] - mid > next) r = mid-1;
            else l = mid;
        }
        return l == r && dk[l] - l <= next ? next + l + 1 : next;
    }
    Map<Integer, Integer> map = new HashMap<>(); // idx, v, 存得太多了，不需要，只要存黑名单里存在的配对就可以了
    Set<Integer> hi = new HashSet<>();
    Random rand;
    int m, n;
    public Solution(int n, int[] a) {
        this.n = n;
        m = a.length;
        Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        for (int i = n-m; i < n; i++) 
            if (!s.contains(i))
                hi.add(i);
        Iterator it = hi.iterator();
        for (Integer v : s) 
            if (v < n-m) map.put(v, it.next());
        // int j = n-1;
        // for (int i = 0; i < n-m; i++) { // 也不用遍历这个大头，只需要遍历黑名单里的就可以了
        //     if (s.contains(i)) {
        //         while (j > i && s.contains(j)) j--;
        //         map.put(i, j--);
        //     } else map.put(i, i);
        // }
        rand = new Random();
    }
    public int pick() {
        int i = rand.nextInt(n-m);
        return map.containsKey(i) ? map.get(i) : i;
    }

    Map<Integer, List<Integer>> cnt = new HashMap<>();
    Map<Integer, Integer> m = new HashMap<>();
    // ArrayDeque<Integer> s = new ArrayDeque<>();
    // ArrayDeque<Integer> t = new ArrayDeque<>();
    int maxCnt = 0;
    // public FreqStack() {
    public hdfive() {
    }
    public void push(int val) { // BUG: 这里面数值的添加顺序没有理对，改天回来再写这个
        // s.offerLast(val);
        m.put(val, m.getOrDefault(val, 0) + 1);
        int v = m.get(val);
        maxCnt = Math.max(maxCnt, v);
        cnt.computeIfAbsent(v, z -> new ArrayList<>()).add(val);
        System.out.println("v: " + v);
        if (v > 1) cnt.get(v-1).remove(new Integer(val));
        // System.out.println("cnt.size(): " + cnt.size());
        // for (Map.Entry<Integer, List<Integer>> en : cnt.entrySet()) {
        //     System.out.print(en.getKey() + ": ");
        //     System.out.println(Arrays.toString(en.getValue().toArray()));
        // }
    }
    public int pop() {
        List<Integer> l = cnt.get(maxCnt);
        int ans = l.remove(l.size()-1);
        if (maxCnt > 1) {
            cnt.computeIfAbsent(maxCnt-1, z -> new ArrayList<>()).add(ans);
            m.put(ans, m.get(ans) - 1);
        } else m.remove(ans);
        if (l.size() == 0) {
            cnt.remove(maxCnt);
            maxCnt--;
        }
        return ans;
    }
    hdfive s = new hdfive();
    s.push(5); // The stack is [5]
    s.push(7); // The stack is [5,7]
    s.push(5); // The stack is [5,7,5]
    s.push(7); // The stack is [5,7,5,7]
    s.push(4); // The stack is [5,7,5,7,4]
    s.push(5); // The stack is [5,7,5,7,4,5]
    int r = s.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
    System.out.println("r: " + r);
    int r1 = s.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
    System.out.println("r1: " + r1);
    int r2 = s.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
    System.out.println("r2: " + r2);
    int r3 = s.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    System.out.println("r3: " + r3);

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
        // long quickMul(int base, int exp) {
        //     long ans = 1;
        //     while (exp > 0) {
        //         if (exp % 2 == 1)
        //             ans = (ans * (long)base) % mod;
        //         base = (int)((base * base) % mod);
        //         exp >>= 1;
        //     }
        //     return ans;
        // }

        public double mincostToHireWorkers(int [] qua, int[] w, int k) {
            int n = qua.length;
            List<int []> l = new ArrayList<>();
            for (int i = 0; i < n; i++) 
                l.add(new int [] {qua[i], w[i]});
            Collections.sort(l, (a, b)-> Double.compare((double)a[1] / a[0], (double)b[1] / b[0]));
            Queue<Integer> q = new PriorityQueue<>((a, b)->b-a);
            double sum = 0, ans = 1e9;
            for (int i = 0; i < n; i++) {
                int [] cur = l.get(i);
                sum += cur[0];
                q.offer(cur[0]); // quality
                if (q.size() > k) sum -= q.poll();
                if (q.size() == k) // 需要保证队列里有要求的人数
                    ans = Math.min(ans, sum * (double)cur[1] / (double)cur[0]);
            }
            return ans;
        }

        public boolean xorGame(int[] a) {
            n = a.length;
            int xor = 0;
            for (Integer v : a) xor ^= v;
            dp = new Boolean [n];
            return dfs(0, xor, a);
        }
        Boolean [] dp;
        int n;
        boolean dfs(int idx, int xor, int [] a) {
            // if (idx == n) return n % 2 == 1; // bug
            if (idx == n) return idx % 2 == 0;
            if (dp[idx] != null) return dp[idx];
            if (xor == 0) return idx % 2 == 0;
            if (idx % 2 == 0) { // alice turn
                for (int i = 0; i < n; i++) {
                    if (a[i] == -1) continue;
                    if ((xor ^ a[i]) == 0) continue;
                    int tmp = a[i];
                    a[i] = -1;
                    if (dfs(idx+1, xor ^ tmp, a)) // idx
                        return dp[idx] = true;
                    a[i] = tmp;
                }
                return dp[idx] = false;
            } else {
                for (int i = 0; i < n; i++) {
                    if (a[i] == -1) continue;
                    if ((xor ^ a[i]) == 0) continue;
                    int tmp = a[i];
                    a[i] = -1;
                    if (!dfs(idx+1, xor ^ tmp, a)) // idx
                        return dp[idx] = false;
                    a[i] = tmp;
                }
                return dp[idx] = true;
            }
        }

        public int kSimilarity(String s, String t) { // 这个思路简洁明了，代码也比较好写
            if (s.equals(t)) return 0;
            ArrayDeque<String> q = new ArrayDeque<>();
            Set<String> vis = new HashSet<>();
            q.offerLast(s);
            vis.add(s);
            int cnt = 0;
            while (!q.isEmpty()) {
                for (int z = q.size()-1; z >= 0; z--) {
                    String cur = q.pollFirst();
                    // if (cur.equals(t)) return cnt;
                    for (String next : getAllNeighbour(cur, t)) {
                        if (vis.contains(next)) continue;
                        if (next.equals(t)) return cnt + 1;
                        q.offerLast(next);
                        vis.add(next);
                    }
                }
                cnt++;
            }
            return -1;
        }
        List<String> getAllNeighbour(String ss, String tt) {
            int n = ss.length(), i = 0;
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            List<String> ans = new ArrayList<>();
            while (i < n && s[i] == t[i]) i++;
            for (int j = i+1; j < n; j++) 
                if (s[j] == t[i]) {
                    swap(i, j, s);
                    ans.add(new String(s));
                    swap(i, j, s);
                }
            return ans;
        }
        void swap(int i, int j, char [] s) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
        // 对于一个环, 我们可以用一个 01 数组表示每条边是否出现，例如对于环 a -> b -> d -> e -> a，它有 4 条边 a -> b，b -> d，d -> e 和 e -> a，那么它对应的数组中，有 4 个位置（这 4 条边对应的位置）的值为 1，其它值为 0。同样地，基础图 GG 也可以用这种方式来表示。
        // 因此我们可以使用动态规划来解决这个问题，令 numCycles(G) 表示基础图 GG 最多拆分的环的数目。我们枚举环 CC，检查 CC 是否包含于 GG。状态转移方程为 numCycles(G) = max{1 + numcycles(G - C)}
        public int kSimilarity(String s, String t) { // 这个思路还是没有继续看下去， todo
            if (s.equals(t)) return 0;
            n = s.length();
            memo = new HashMap<>();
            int ans = 0, m = alphabet.length;
            int [] cnt = new int[m * m];
            for (int i = 0; i < n; i++) 
                if (s.charAt(i) != t.charAt(i)) {
                    cnt[m * (s.charAt(i)-'a') + t.charAt(i)-'a']++;
                    ans++;
                }
            List<int []> possibles = new ArrayList<>();
            for (int size = 2; size <= m; size++)   // Enumerate over every cycle
            search: for (String cycle: permutations(alphabet, 0, size)) {
                    for (int i = 1; i < size; i++) 
                        if (cycle.charAt(i) < cycle.charAt(0))
                            continue search;
                    int [] row = new int [cnt.length];
                    for (int i = 0; i < size; i++) {
                        int u = cycle.charAt(i) - 'a';
                        int v = cycle.charAt((i+1) % size) - 'a';
                        row[m*u + v]++;
                    }
                    possibles.add(row);
                }
            int [] ZERO = new int [cnt.length];
            memo.put(Arrays.toString(ZERO), 0);
            return ans - numCycles(possibles, cnt);
        }
        String [] alphabet = new String [] {"a", "b", "c", "d", "e", "f"};
        Map<String, Integer> memo = new HashMap<>();
        int n;
        public int numCycles(List<int[]> possibles, int[] count) {
            String countS = Arrays.toString(count);
            if (memo.containsKey(countS)) return memo.get(countS);
            int ans = Integer.MIN_VALUE;
        search: for (int[] row: possibles) {
                int[] count2 = count.clone();
                for (int i = 0; i < row.length; ++i) {
                    if (count2[i] >= row[i])
                        count2[i] -= row[i];
                    else continue search;
                }
                ans = Math.max(ans, 1 + numCycles(possibles, count2));
            }
            memo.put(countS, ans);
            return ans;
        }
        public List<String> permutations(String[] alphabet, int used, int size) {
            List<String> ans = new ArrayList();
            if (size == 0) {
                ans.add(new String(""));
                return ans;
            }
            for (int b = 0; b < m; ++b)
                if (((used >> b) & 1) == 0)
                    for (String rest: permutations(alphabet, used | (1 << b), size - 1))
                        ans.add(alphabet[b] + rest);
            return ans;
        }

        public String orderlyQueue(String s, int k) {
            if (k > 1) {
                char [] t = s.toCharArray();
                Arrays.sort(t);
                return new String(t);
            }
            int n = s.length();
            String ans = "";
            for (int i = 0; i < n; i++) {
                String cur = s.substring(i) + s.substring(0, i);
                if (ans.length() == 0 || ans.compareTo(cur) > 0)
                    ans = new String(cur);
            }
            return ans;
        }

        public int[] threeEqualParts(int [] a) {
            int n = a.length, cnt = Arrays.stream(a).sum(), cur = 0, i = 0, j = n-1;
            if (cnt == 0) return new int [] {0, n-1} ;
            int [] ans = {-1, -1};
            if (cnt % 3 != 0) return ans;
            while (i < n && a[i] == 0) i++;
            while (j >= 0 && cur < cnt / 3) 
                cur += a[j--]; // a[j] = 0 when ended
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
            return k == n && i <= j;
        }

        public int findMaximizedCapital(int k, int w, int [] p, int [] c) {
            List<int []> l = new ArrayList<>();
            int n = p.length, ans = w, i = 0;
            for ( i = 0; i < n; i++) 
                l.add(new int [] {p[i], c[i]}); // profit[i], capital[i]
            Collections.sort(l, (a, b) -> a[1] - b[1]); // 按启动资金排序，升序
            Queue<int []> q = new PriorityQueue<>((x, y) -> y[0] != x[0] ? y[0] - x[0] : x[1] - y[1]); // priorityQueue是基于排序的完全二叉树
            i = 0;
            while (i < n && k > 0) {
                if (l.get(i)[1] > ans && q.isEmpty()) return ans;
                while (i < n && l.get(i)[1] <= ans) { // 按照手上的资金，把所有可以做的全部加进去
                    q.offer(l.get(i));
                    i++;
                }
                if (k > 0 && !q.isEmpty()) {
                    ans += q.poll()[0];
                    k--;
                }
            }
            while (k > 0 && !q.isEmpty()) {
                ans += q.poll()[0];
                k--;
            }
            return ans;
        }

        public int findMinMoves(int [] a) {
            int n = a.length;
            int [] sum = new int [n+1];
            for (int i = 1; i <= n; i++) 
                sum[i] = sum[i-1] + a[i-1];
            if (sum[n] % n != 0) return -1;
            int avg = sum[n] / n, ans = 0;
            for (int i = 0; i < n; i++) {
                int l = i * avg - sum[i];  // 左边机器移动的总次数
                int r = (n - (i+1)) * avg - (sum[n] - sum[i+1]); // 右边机器移动的总次数
                if (l > 0 && r > 0)
                    ans = Math.max(ans, l + r);
                else ans = Math.max(ans, Math.max(l, r));
            }                
            return ans;
        }

        // 对于有向图中，如果存在indegree(v) == 2的点，那么要删除的一定是这个点的某条有向边(u -> v)
        //    因为题目最后保证是一个rooted tree（every node has exactly one parent），具体看第一段定义；
        // 如果不存在indegree(v) == 2的点，那么直接删去最后一个造成环存在的有向边即可。
        // 现在存在三种情况：
        // （1）有向图中只有环。这种情况就简单将两个节点具有共同根节点的边删去就好。
        // （2）有向图中没有环，但有个节点有两个父节点。这种情况就将第二次出现不同父节点的边删去就好。
        // （3）有向图中既有环，而且有个节点还有两个父节点。这时就检测当除去第二次出现父节点的边后，剩余边是不是合法的，如果不合法证明应该删掉的是另一个父节点的边。
        public int [] findRedundantDirectedConnection(int [][] egs) {
            Set<Integer> p = new HashSet<>();
            Map<Integer, Integer> par = new HashMap<>(); // k,v: v <-- u
            List<int []> candi = new ArrayList<>();
            for (int [] e : egs) {
                int u = e[0], v = e[1];
                p.add(u);
                p.add(v);
                if (!par.containsKey(v)) { // 对于入度为1的右端点边，记在字典里
                    par.put(v, u);
                    continue;
                }
                candi.add(new int [] {par.get(v), v}); // 第一次出现的边
                candi.add(new int [] {u, v});          // 第二次出现的边，答案是这两者之一
                e[1] = -1; // 先将后出现的第二条边废掉，验证答案
            }
            UnionFind uf = new UnionFind(p.size()); // 总顶点的个数
            for (int [] e : egs) {
                if (e[1] == -1) continue;   // 跳过正在验证是否为的答案后出现的第二条边
                int u = e[0]-1, v = e[1]-1; // uf 0-based
                if (!uf.union(u, v)) { // 在已经废除后出现的第二条边之后，还是出现了环，那么后出现的第二条边不是答案，第一条才是
                    if (candi.isEmpty()) return e; // 不存在入度为 2 的点，直接删去最后一条造成环存在的有向边， 即当前边即可
                    return candi.get(0);
                }
            }
            return candi.get(1); // 删除第二条边后，所有的存在都合法，那么就返回第二条边
        }
        class UnionFind {
            int[] parent;
            int[] rank;
            int size;
            public UnionFind(int size) {
                this.size = size;
                parent = new int[size];
                rank = new int[size];
                for (int i = 0; i < size; i++) parent[i] = i;
            }
            public int find(int x) {
                if (parent[x] != x) 
                    parent[x] = find(parent[x]);
                return parent[x];
            }
            public boolean union(int x, int y) { 
                int xp = find(x);
                int yp = find(y);
                if (xp == yp) return false; // 已经在同一个强连通分量中
                if (rank[xp] > rank[yp]) 
                    parent[yp] = xp;
                else if (rank[xp] < rank[yp]) 
                    parent[xp] = yp;
                else {
                    parent[yp] = xp;
                    rank[xp]++;
                }
                return true;
            }
        }

    Trie t;
    public WordFilter(String[] sa) {
        t = new Trie();
        Set<String> ss = new HashSet<>();
        for (int i = 0; i < sa.length; i++) {
            ss.clear();
            ss.addAll(getAlllSufPreString(sa[i]));
            for (String v : ss) 
                t.insert(v, i);
        }
    }
    public int f(String prefix, String suffix) {
        String s = suffix + "{" + prefix;
        return t.search(s);
    }
    Set<String> getAlllSufPreString(String s) {
        Set<String> ss = new HashSet<>();
        int n = s.length();
        ss.add(s);
        for (int i = n-1; i >= 0; i--) {
            String cur = s.substring(i) + "{" + s;
            ss.add(cur);
        }
        return ss;
    }
   class Trie {
       Node root;
       public Trie() {
           root = new Node();
       }
       public int search(String t) {
           int n = t.length();
           char [] s = t.toCharArray();
           Node r = root;
           for (int i = 0; i < n; i++) {
               int idx = s[i] - 'a';
               if (r.next[idx] == null) return -1;
               r = r.next[idx];
           }
           return r.i;
       }
       public void insert(String t, int v) {
           int n = t.length(), idx = 0;
           char [] s = t.toCharArray();
           Node r = root;
           for (int i = 0; i < n; i++) {
               idx = s[i] - 'a';
               if (r.next[idx] == null) {
                   r.next[idx] = new Node();
                   r.i = v;
               } else if (v > r.i) r.i = v;
               r = r.next[idx];
           }
           r.i = v; // BUG: 这一步不能写丢了
       }
       class Node {
           int i; // idx 
           Node [] next;
           public Node() {
               i = -1;
               next = new Node [27]; // next[26] = '{' which is right after 'z'
           }
       }
   }

        public boolean reachingPoints(int x, int y, int i, int j) { // bug
            if (x == i && y == j) return true;
            Deque<int []> q = new ArrayDeque<>();
            Set<String> vis = new HashSet<>();
            q.offerLast(new int [] {x, y});
            vis.add(x+"-"+y);
            while (!q.isEmpty()) {
                int [] cur = q.pollLast();
                if (cur[0] == i && cur[1] == j) return true;
                int ij = cur[0] + cur[1]; // % 这里需要某种快进效果，否则应该一定会超时的
                if (ij > i && ij > j) continue;
                String ta = ij + "-" + cur[1], tb = cur[0] + "-" + ij;
                if (ij <= i && !vis.contains(ta)) {
                    vis.add(ta);
                    q.offerLast(new int [] {ij, cur[1]});
                }
                if (ij <= j && !vis.contains(tb)) {
                    vis.add(tb);
                    q.offerLast(new int [] {cur[0], ij});
                }
            }
            return false;
        }
        // 35
        // 13
        // 455955547
        // 420098884

        public int shortestSubarray(int[] a, int k) { // BUG
            int n = a.length, ans = Integer.MAX_VALUE, j = 0;
            // long sum = 0;
            // ArrayDeque<Integer> s = new ArrayDeque<>();
            // for (int i = 0; i < n; i++) {
            //     sum += a[i];
            //     if (sum >= k) ans = Math.min(ans, i+1);
            //     while (!s.isEmpty() && (sum >= k && a[s.peekFirst()] >= 0
            //                             || sum < k && a[s.peekFirst()] < 0)) {
            //         sum -= a[s.pollFirst()];
            //         if (sum >= k && !s.isEmpty()) ans = Math.min(ans, i - s.peekFirst() + 1);
            //     }
            //     s.offerLast(i);
            // }
            // return ans == Integer.MAX_VALUE ? -1 : ans;
        }
        public int shortestSubarray(int[] a, int k) { 
            int n = a.length, ans = Integer.MAX_VALUE, j = 0;
            long [] sum = new long [n+1];
            for (int i = 1; i <= n; i++) 
                sum[i] = sum[i-1] + a[i-1];
            ArrayDeque<Integer> s = new ArrayDeque<>(); // 单调递增
            for (int i = 0; i <= n; i++) {
                while (!s.isEmpty() && sum[i] - sum[s.peekFirst()] >= k)
                    ans = Math.min(ans, i - s.pollFirst());
                while (!s.isEmpty() && sum[s.peekLast()] >= sum[i])
                    s.pollLast();
                s.offerLast(i);
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }        

        public int reachableNodes(int[][] edges, int maxMoves, int n) {
            int [][] adj = new int [n][n];
            for (int i = 0; i < n; i++) 
                Arrays.fill(adj[i], -1);
            for (int [] v : edges) {
                adj[v[0]][v[1]] = v[2];
                adj[v[1]][v[0]] = v[2];
            }
            Queue<int []> q = new PriorityQueue<>((x, y) -> y[0] - x[0]);
            boolean [] vis = new boolean [n];
            q.offer(new int [] {maxMoves, 0});
            int ans = 0;
            while (!q.isEmpty()) {
                int [] cur = q.poll();
                int cnt = cur[0], u = cur[1];
                if (vis[u]) continue;
                vis[u] = true;
                ans++;
                for (int i = 0; i < n; i++) {
                    if (adj[u][i] == -1) continue;
                    if (cnt > adj[u][i] && !vis[i])
                        q.offer(new int [] {cnt - adj[u][i] - 1, i});
                    adj[i][u] -= Math.min(cnt, adj[u][i]);
                    ans += Math.min(cnt, adj[u][i]);
                }
            }
            return ans;
        }
        
        Map<Integer, Integer> cnt;     // k, v: val, cnt
        Map<Integer, List<Integer>> m; // cnt, val list
        int maxCnt, lastVal;
        public FreqStack() {
            cnt = new HashMap<>();
            m = new HashMap<>();
            maxCnt = 0;
            lastVal = -1;
        }
        public void push(int val) { 
            cnt.put(val, cnt.getOrDefault(val, 0) + 1);
            m.computeIfAbsent(cnt.get(val), z -> new ArrayList<>()).add(val); // m里存有之间统计过的出现次数： 1 2 3 4 5 6 7
            lastVal = val;
            if (cnt.get(val) > maxCnt) maxCnt = cnt.get(val);
        }
        public int pop() {
            List<Integer> l = cnt.get(maxCnt);
            int ans = l.remove(l.size()-1);
            if (l.size() == 0) maxCnt--;    // 只从出现过的最高的次数往下减
            if (maxCnt > 0) {
                cnt.put(ans, cnt.get(ans) - 1);
            }
            return ans;
        }

         public int largestComponentSize(int[] a) { // tle
            int n = a.length;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) 
                for (int j = i+1; j < n; j++) {
                    if (uf.sameGroup(i, j) || gcd(a[i], a[j]) == 1) continue;
                    uf.union(i, j);
                }
            return uf.getLargetComponent();
        }
        int gcd(int x, int y) {
            if (y == 0) return x;
            return gcd(y, x % y);
        }
        class UnionFind {
            private int [] p;
            public UnionFind(int size) {
                p = new int[size];
                for (int i = 0; i < size; i++)
                    p[i] = i;
            }
            public boolean sameGroup(int i, int j) {
                return find(i) == find(j);
            }
            public int getLargetComponent() {
                int [] cnt = new int [p.length];
                int max = 0;
                for (int i = 0; i < p.length; i++) {
                    find(i);
                    ++cnt[p[i]];
                    max = Math.max(max, cnt[p[i]]);
                }
                return max;
            }
            public int find(int x) {
                if (p[x] != x)
                    p[x] = find(p[x]);
                return p[x];
            }
            public void union(int x, int y) {
                int px = find(x), py = find(y);
                if (px != py)
                    p[px] = py;
            }
        }
        public int largestComponentSize(int[] a) { 
            int n = a.length;
            UnionFind uf = new UnionFind();
            for (int v : a) { // 通过两个值是否有 > 1 的质因子，决定了两个数是否连通
                if (v == 1) continue;
                List<Integer> l = getPrimeFactors(v); 
                uf.addToParent(l.get(0));
                for (int i = 1; i < l.size(); i++) 
                    uf.merge(l.get(0), l.get(i)); // 对于同一个数来说，其所有的质因子之间是连通的，以便借助这些质因子可以与其它拥有某个某些质因子的数相连通 
            }
            return uf.getLargestComponentCnt();
        }
        private List<Integer> getPrimeFactors(int val) {
            List<Integer> l = new ArrayList<>();
            if (val % 2 == 0) {
                l.add(2);
                while (val % 2 == 0) val /= 2;
            }
            for (int i = 3; i*i <= val; i += 2) 
                if (val % i == 0) {
                    l.add(i);
                    while (val % i == 0) val /= i;
                }
            if (val > 2) l.add(val);
            return l;
        }
        private class UnionFind {
            HashMap<Integer, Integer> par;
            HashMap<Integer, Integer> cnt; // 以各个数的最小（>1）质因子为键的、最大（原数组元素个数）强连通分量的数组元素个数，为值 
            public UnionFind() {
                par = new HashMap<>();
                cnt = new HashMap<>();
            }
            public int find(int val) {
                if (!par.containsKey(val)) {
                    par.put(val, val);
                    cnt.put(val, 0);
                    return val;
                }
                if (par.get(val) != val) par.put(val, find(par.get(val)));
                return par.get(val);
            }
            public void merge(int p, int q) {
                int rp = find(p);
                int rq = find(q);
                if (rp == rq) return;
                par.put(rq, rp);
                cnt.put(rp, cnt.get(rp) + cnt.get(rq));
            }
            public void addToParent(int val) {
                int x = this.find(val);
                cnt.put(x, cnt.get(x) + 1);
            }
            private int getLargestComponentCnt() { 
                return Collections.max(cnt.values());
            }
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            dfs(root, 0, 0);
            List<List<Integer>> ll = new ArrayList<>();
            for (Integer c : m.keySet()) { // c: col
                List<Integer> l = new ArrayList<>();
                for (List<Integer> li : m.get(c).values()) {
                    if (li.size() == 1) l.add(li.get(0));
                    else {
                        Collections.sort(li);
                        for (Integer val : li)
                            l.add(val);
                    }
                }
                ll.add(l);
            }
            return ll;
        }
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> m = new TreeMap<>(); // k, v: col, <k, v: row, r.vals>
        void dfs(TreeNode r, int i, int j) {
            if (r == null) return ;
            m.computeIfAbsent(j, z -> new TreeMap<>()).computeIfAbsent(i, z -> new ArrayList<>()).add(r.val);
            dfs(r.left, i+1, j-1);
            dfs(r.right, i+1, j+1);
        }

        public boolean isRationalEqual(String s, String t) {
            return Double.compare(stodj(s), stodj(t)) == 0;
        }
        double stodj(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            String u = "";
            if (s[n-1] == ')') { // 如果表达式里面存在（）对，那么把这里面循环的部分重复20次
                int i = t.indexOf("(");
                u = t.substring(0, i) + t.substring(i+1, n-1).repeat(20);
            } else u = t;
            return Double.parseDouble(u);
        }

        public int subarraysWithKDistinct(int[] a, int k) {
            return getCntNoMoreThanK(a, k) - getCntNoMoreThanK(a, k-1);
        }
        int getCntNoMoreThanK(int [] a, int k) { // <= k
            int n = a.length, ans = 0, j = 0;
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < n; i++) {
                m.put(a[i], m.getOrDefault(a[i], 0) + 1);
                while (m.size() > k) {
                    if (m.get(a[j]) > 1) m.put(a[j], m.get(a[j])-1);
                    else m.remove(a[j]);
                    j++;
                }
                ans += i - j + 1; // 就这一句是精华
            }
            return ans;
        }

        public int minKBitFlips(int[] a, int k) { 
            int n = a.length, ans = 0, cur = 0; // cur： 翻转累加效应 
            int [] f = new int [n]; // 标记以某个下标位打头的k个元素片段实施了翻转
            for (int i = 0; i < n; i++) {
                if (i >= k) cur ^= f[i-k]; // 回逆回逆到的最远位置是： i-k
                if (cur % 2 == a[i]) {
                    if (i + k > n) return -1;
                    f[i] = 1;
                    cur ^= 1;
                    ++ans;
                }
                // if (a[i] == 1) continue; // tle
                // if (i + k <= n) {
                //     ans++;
                //     for (int j = i; j < i+k; j++) // 你真的真的是一个一个滴去翻转了 N=100000， O(N^2) OJ不会给你好果子吃的
                //         a[j] = 1 - a[j];
                // } else return -1;
            }
            return ans;
        }        
        public int minKBitFlips(int[] a, int k) { 
            int n = a.length, ans = 0;
            Deque<Integer> s = new ArrayDeque<>(); // 标记以某个下标位打头的k个元素片段实施了翻转
            for (int i = 0; i < n; i++) {
                if (!s.isEmpty() && s.peekFirst() + k <= i) s.pollFirst();
                if (s.size() % 2 == a[i]) {
                    if (i + k > n) return -1;
                    s.offerLast(i);
                    ans++;
                }
            }
            return ans;
        }
        public int minKBitFlips(int[] a, int k) {
            int n = a.length, ans = 0, f = 0;
            for (int i = 0; i < n; i++) {
                if (i >= k) f -= a[i-k] / 2;
                if (f % 2 == a[i]) {
                    if (i + k > n) return -1;
                    a[i] += 2;
                    ans++;
                    f++;
                }
            }
            return ans;
        }

        // Write a function "parse" which calls helper functions "parse_or", "parse_and", "parse_not". // 这里还有哪里有一点儿不通 BUG
        public boolean parseBoolExpr(String s) { // bug, have not finished yet
            int n = s.length();
            char c = s.charAt(0);
            if (n == 1) return c == 't';
            if (c == '!') return parseNot(s.substring(2, n-1));
            if (c == '|') return parseOr(s.substring(2, n-1));
            // if (c == '&')
                return parseAnd(s.substring(2, n-1));
            // if (c == '!') return parse(s.substring(2, n-1), c);
            // if (c == '|') return parse(s.substring(2, n-1), c);
            // // if (c == '&')
            //     return parse(s.substring(2, n-1), c);
        }
        // boolean parse(String t, char sn) { // 能不能把三个函数合并成一个函数，都是重复 
        boolean parseOr(String t) { // 能不能把三个函数合并成一个函数，都是重复 
            int n = t.length(), j = 0, l = 0, r = 0;
            char [] s = t.toCharArray();
            boolean ans = false;
            for (int i = 0; i < n; i++) {
                char c = s[i];
                if (c == '!' || c == '|' || c == '&') {
                    j = i+2; l = 1; r = 0;
                    while (j < n && l != r) {
                        if (s[j] == '(') l++;
                        else if (s[j] == ')') {
                            if (l > 0)  l--;
                            else r++;
                            if (l == r) break;
                        }
                    }
                    if (c == '!') ans |= parseNot(t.substring(i+2, j));
                    if (c == '|') ans |= parseOr(t.substring(i+2, j));
                    if (c == '&') ans |= parseAnd(t.substring(i+2, j));
                    // if (sn == '!') ans = !parse(t.substring(i+2, j), c);
                    // if (sn == '|') ans |= parse(t.substring(i+2, j), c);
                    // if (sn == '&') ans = true && parse(t.substring(i+2, j), c);
                    i = j;
                } else if (c == 't' || c == 'f') {
                    ans |= c == 't';
                    i ++;
                }
            }
            return ans;
        }
        boolean parseAnd(String t) {
            int n = t.length(), j = 0, l = 0, r = 0;
            char [] s = t.toCharArray();
            boolean ans = true;
            for (int i = 0; i < n; i++) {
                char c = s[i];
                if (c == '!' || c == '|' || c == '&') {
                    j = i+2; l = 1; r = 0;
                    while (j < n && l != r) {
                        if (s[j] == '(') l++;
                        else if (s[j] == ')') {
                            if (l > 0)  l--;
                            else r++;
                            if (l == r) break;
                        }
                    }
                    if (c == '!') ans &= parseNot(t.substring(i+2, j));
                    if (c == '|') ans &= parseOr(t.substring(i+2, j));
                    if (c == '&') ans &= parseAnd(t.substring(i+2, j));
                    i = j;
                } else if (c == 't' || c == 'f') {
                    ans &= c == 't';
                    i ++;
                }
            }
            return ans;
        }
        boolean parseNot(String t) {
            int n = t.length(), j = 0, l = 0, r = 0;
            char [] s = t.toCharArray();
            boolean ans = true;
            for (int i = 0; i < n; i++) {
                char c = s[i];
                if (c == '!' || c == '|' || c == '&') {
                    j = i+2; l = 1; r = 0;
                    while (j < n && l != r) {
                        if (s[j] == '(') l++;
                        else if (s[j] == ')') {
                            if (l > 0)  l--;
                            else r++;
                            if (l == r) break;
                        }
                    }
                    if (c == '!') ans = !parseNot(t.substring(i+2, j));
                    if (c == '|') ans = !parseOr(t.substring(i+2, j));
                    if (c == '&') ans = !parseAnd(t.substring(i+2, j));
                    i = j;
                } else if (c == 't' || c == 'f') {
                    ans = c == 'f';
                    i ++;
                }
            }
            return ans;
        }

        public int[] sortItems(int n, int m, int[] g, List<List<Integer>> bef) {
            List<List<Integer>> its = new ArrayList<>();
            List<List<Integer>> gps = new ArrayList<>(); // 组图： 下标： 组编号；组内元素
            List<Integer> ids = new ArrayList<>();
            for (int i = 0; i < m+n; i++) {
                ids.add(i);
                its.add(new ArrayList<>());
                gps.add(new ArrayList<>());
            }
            List<List<Integer>> itg = new ArrayList<>(); // itemGraph, n items, 元素先后順序图：每个元素，之后的元素包括（）
            for (int i = 0; i < n; i++) 
                itg.add(new ArrayList<>());
            int [] insIts = new int [n];   // 每个元素各自入度
            int [] insGps = new int [m+n]; // 每个组的各自入度
            int resId = m; // 把先前剩余的、不属于任何组的，分别分布到只含其一个元素的编号较大（编号不被其它元素占用[0, m-1]）的组中
            for (int i = 0; i < n; i++) {
                if (g[i] == -1)
                    g[i] = resId++;
                its.get(g[i]).add(i); // 下标：元素所属的组编号；组内元素
            }
            for (int i = 0; i < n; i++) {
                int gid = g[i];
                for (int it : bef.get(i)) { // 在现元素i之前的元素链表
                    int befGid = g[it];
                    if (befGid == gid) { // 在同一个组内，可以进行组内排序
                        insIts[i]++;
                        itg.get(it).add(i); // 从之前的元素可以连接到现元素 <== 会进行拓扑排序，所有先发生的在前，后发生的在后
                    } else { // 属于不同的组，须进行组间排序
                        if (gps.get(gid).contains(befGid)) return new int [0]; // 这里发生了矛盾，需返回
                        insGps[gid]++;
                        gps.get(befGid).add(gid); // 从之前的组可以连接到现组  <== 会进行拓扑排序，所有先发生的在前，后发生的在后
                    }
                }
            }
            List<Integer> gsort = topologicalSort(insGps, gps, ids); // 组间排序
            if (gsort.size() == 0) return new int [0];
            int [] ans = new int [n];
            int i = 0;
            for (Integer gid : gsort) { // 对排好序的各组，进行组内排序
                int size = its.get(gid).size();
                if (size == 0) continue;
                List<Integer> li = topologicalSort(insIts, itg, its.get(gid)); // 进行组内排序
                if (li.size() == 0) return new int [0];
                for (int it : li) 
                    ans[i++] = it;
            }
            return ans;
        }
        List<Integer> topologicalSort(int [] ins, List<List<Integer>> adj, List<Integer> li) {
            Deque<Integer> q = new ArrayDeque<>();
            for (Integer v : li) 
                if (ins[v] == 0) q.offerLast(v);
            List<Integer> ans = new ArrayList<>();
            while (!q.isEmpty()) {
                int cur = q.pollFirst();
                ans.add(cur);
                for (Integer v : adj.get(cur)) 
                    if (--ins[v] == 0) q.offerLast(v);
            }
            return ans;
        }

        public List<String> maxNumOfSubstrings(String t) { 
            int n = t.length();
            char [] s = t.toCharArray();
            int [] bgn = new int [26]; // 记每个字母第一次出现的位置
            int [] end = new int [26]; // 记每个字母最后一次出现的位置
            Arrays.fill(bgn, -1);
            Arrays.fill(end, -1);
            for (int i = 0; i < n; i++) {
                int j = s[i] - 'a';
                if (bgn[j] == -1){
                    bgn[j] = i;
                    end[j] = i; // bug: 字符串的最后一个字母eg: abbcce
                } else end[j] = i;
            }
            TreeSet<String> ss = new TreeSet<>((a, b)->a.length() != b.length() ? a.length() - b.length() : a.compareTo(b));
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                int l = bgn[s[i] - 'a'];
                if (l < i) continue; // 如果左边界左移，说明已经处理过了，不用管它了
                int r = end[s[i] - 'a'], j = i, k = i;
                valid = true;
                while (j < n && j < r) {
                    r = Math.max(r, end[s[j]-'a']); // 最右边界
                    l = Math.min(l, bgn[s[j]-'a']);
                    if (l < i) {
                        valid = false;
                        break;
                    }
                    j++;
                }
                if (valid)
                    ss.add(t.substring(i, r+1));
            }
            List<String> ans = new ArrayList<>();
            Iterator it = ss.iterator();
            while (it.hasNext()) {
                String cur = (String)it.next();
                if (ans.size() == 0) {
                    ans.add(cur);
                    continue;
                }
                valid = true;
                for (String sc : ans) 
                    if (cur.indexOf(sc) != -1) {
                        valid = false;
                        break;
                    }                    
                if (valid) ans.add(cur);
            }
            return ans;
        }

        public int minimumDeviation(int[] a) {
            int n = a.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            TreeSet<Integer> s = new TreeSet<>();
            for (int v : a) {
                if (v % 2 == 1) s.add(v * 2);
                else s.add(v);
                min = Math.min(min, v);
                max = Math.max(max, v);
            }
            int dif = s.last() - s.first(), preDif = Integer.MAX_VALUE;
            max = s.last();
            min = Integer.MAX_VALUE; // ans
            while (dif != preDif) {
                if (max % 2 == 0) {
                    s.remove(max);
                    s.add(max / 2);
                }
                max = s.last(); // 将最大的数缩小了一半
                preDif = dif;
                dif = max - s.first();
                min = Math.min(min, dif);
            }
            return min;
        }

        public int[] maximizeXor(int [] a, int [][] q) { // bug
            int n = a.length, m = q.length, j = 0;
            int [] ans = new int [m];
            Arrays.fill(ans, -1);
            Arrays.sort(a);
            List<int []> li = new ArrayList<>();
            for (int i = 0; i < m; i++) 
                li.add(new int [] {i, q[i][0], q[i][1]}); // i, xi, mi, needs a[j] <= mi
            Collections.sort(li, (x, y)->x[2] - y[2]);
            Trie t = new Trie();
            for (int i = 0; i < m; i++) {
                int [] cur = li.get(i);
                if (j == 0 && cur[2] < a[j]) continue;
                while (j < n && a[j] <= cur[2]) t.insert(a[j++]);
                ans[cur[0]] = t.getMaxXORWithVal(cur[1]);
            }
            return ans;
        }
        class Trie {
            Node root;
            public Trie() {
                root = new Node();
            }
            public int getMaxXORWithVal(int v) {
                Node r = root;
                return getMaxXORWithValRecursive(v, r, 31);
            }
            int getMaxXORWithValRecursive(int v, Node r, int i) {
                if (i < 0) return 0;
                int j = -1, ans = 0;
                if (r == null || r.next == null) return 0;
                // if (r == null) return 0;
                // for (int i = idx; i >= 0; i--) {
                int curV = ((1 << i) & v) > 0 ? 1 : 0; // v 在当前位上的取值： 1 or 0
                if (r.next == null) return curV;
                if (curV == 1) { // 感觉这里的逻辑还是写得迷迷糊糊。。。。。。感觉大致思路到位，细节有待改进，改天再回来写这个
                    if (r.next[0] != null)
                        ans = (1 << i) | getMaxXORWithValRecursive(v, r.next[0], i-1);
                    else if (r.next[1] != null)
                        ans = getMaxXORWithValRecursive(v, r.next[1], i-1);
                } else { // curV = 0
                    if (r.next[1] != null)
                        ans = (1 << i) | getMaxXORWithValRecursive(v, r.next[0], i-1);
                    else if (r.next[0] != null)
                        ans = getMaxXORWithValRecursive(v, r.next[0], i-1);
                }
                // }
                return ans;
            }
            public void insert(int v) {
                Node r = root;
                int idx = -1;
                for (int i = 31; i >= 0; i--) {
                    if (((1 << i) & v) > 0) idx = 1;
                    else idx = 0;
                    if (r.next[idx] == null)
                        r.next[idx] = new Node();
                    r = r.next[idx];
                }
                r.v = v;
            }
            class Node {
                int v;
                Node [] next;
                public Node() {
                    v = -1;
                    next = new Node[2];
                }
            }
        }

        public int minOperations(int [] t, int [] a) {
            int m = t.length, n = a.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < m; i++) 
                map.put(t[i], i);
            for (int i = 0; i < n; i++) 
                if (map.containsKey(a[i]))
                    a[i] = map.get(a[i]);
                else a[i] = -1;  //
            return m - getLengthOfLIS(a);
        }
        int getLengthOfLIS(int [] a) {
            int n = a.length, cnt = 0, j = 0;
            int [] dp = new int [n]; // 动态规划数组 dp，其中 dp[i] 表示当前长度为 i 的递增子序列的末位数值
            Arrays.fill(dp, -1);
            for (int i = 0; i < n; i++) {
                if (a[i] == -1) continue; // arr中该位置对应的数值不存在于target中，跳过
                j = binarySearch(dp, cnt, a[i]);
                dp[j] = a[i];
                if (j == cnt) cnt++;
            }
            return cnt;
        }
        int binarySearch(int [] a, int n, int v) {
            int l = 0, r = n-1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (a[m] < v) l = m + 1;
                else r = m - 1;
            }
            return l;
        }
        public int minOperations(int[] target, int[] arr) {
            // 将arr中的数值替换为其在target中的下标
            int n = target.length, m = arr.length;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();// 记录target中各个值对应的下标
            for (int i = 0; i < n; i++)
                map.put(target[i], i);
            int[] array = new int[m];// 记录arr中数值被替换后的下标
            for (int i = 0; i < m; i++)// 替换arr中的数值
                array[i] = (map.containsKey(arr[i])) ? map.get(arr[i]) : -1;
            // 动态规划+二分，求array中的最长递增子序列
            int[] dp = new int[n];// dp[i]表示当前长度为i的递增子序列的末位数值
            Arrays.fill(dp, -1);
            int len = 0;// i为遍历array过程中的指针，len为当前最长递增子序列的长度
            for (int i = 0; i < m; i++) {
                if (array[i] == -1)// arr中该位置对应的数值不存在于target中，跳过
                    continue;
                if (array[i] > dp[len])// array中该数值大于当前最长递增子序列的末位，延长序列
                    dp[++len] = array[i];
                else if (array[i] <= dp[1])// 数值小于子序列首位，直接替换
                    dp[1] = array[i];
                else {// 二分查找第一个大于等于dp[i]的位置
                    int l = 1, r = len;
                    while (l < r) {
                        int mid = (l + r) >> 1;
                        if (dp[mid] < array[i])
                            l = mid + 1;
                        else
                            r = mid;
                    }
                    dp[l] = array[i];// 替换第一个大于等于dp[i]的数值
                }
            }
            return n - len;// n-最长公共子序列的长度，就是需要插入的次数
        }
        public int minOperations(int[] t, int[] a) {
            int n = t.length;
            Map<Integer, Integer> m = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; ++i) 
                m.put(t[i], i);
            List<Integer> d = new AayList<Integer>();
            for (int val : a) 
                if (m.containsKey(val)) {
                    int idx = m.get(val);
                    int it = binarySearch(d, idx);
                    if (it != d.size()) 
                        d.set(it, idx);
                    else 
                        d.add(idx);
                }
            return n - d.size();
        }
        public int binarySearch(List<Integer> li, int t) {
            int size = li.size();
            if (size == 0 || li.get(size - 1) < t) 
                return size;
            int low = 0, high = size - 1;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (li.get(mid) < t) 
                    low = mid + 1;
                else 
                    high = mid;
            }
            return low;
        }

        public int maximumScore(int[] a, int k) {
            int n = a.length, ans = 0;
            List<Integer> li = new ArrayList<>();
            List<Integer> ri = new ArrayList<>();
            li.add(k);
            ri.add(k);
            for (int i = k-1; i >= 0; i--) 
                if (a[i] < a[li.get(li.size()-1)]) li.add(i);
            for (int i = k+1; i < n; i++) 
                if (a[i] < a[ri.get(ri.size()-1)]) ri.add(i);
            int i = 0, j = 0, nl = li.size(), nr = ri.size();
            while (i < nl || j < nr) {
                int l = (i == nl - 1) ? -1 : li.get(i+1);
                int r = (j == nr - 1) ? n : ri.get(j+1);
                ans = Math.max(ans, Math.min(a[li.get(i)], a[ri.get(j)]) * (r - l - 1));
                if (i == nl - 1 && j == nr - 1) break;
                else if (i == nl - 1) j++;
                else if (j == nr - 1) i++;
                else if (a[l] <= a[r]) j++;
                else i++;
            }
            return ans;
        }
        public int maximumScore(int[] a, int k) { // 这个方法速度很慢， 上面一个比较快
            ArrayDeque<Integer> s = new ArrayDeque<>();
            int ans = 0;
            for (int i = 0; i < a.length; i++) {
                while (!s.isEmpty() && a[s.peekLast()] > a[i]) {
                    int idx = s.pollLast();
                    int l = -1;
                    if (!s.isEmpty()) l = s.peekLast();
                    int cur = (i - l - 1) * a[idx];
                    if (l + 1 <= k && i-1 >= k) ans = Math.max(ans, cur);
                }
                s.offerLast(i);
            }
            while (!s.isEmpty()) {
                int idx = s.pollLast();
                int l = -1;
                if (!s.isEmpty()) l = s.peekLast();
                int cur = (a.length - l - 1) * a[idx];
                if (l <= k) ans = Math.max(ans, cur);
            }
            return ans;
        }
        public int maximumScore(int[] a, int k) {  // O(N) Two Pointers
            int n = a.length, ans = a[k];
            int l = k, r = k, min = a[k];
            while (true) {
                while (r+1 < n && a[r+1] >= min) r++;
                while (l-1 >= 0 && a[l-1] >= min) l--;
                ans = Math.max(ans, min*(r - l + 1));
                if (l == 0 && r == n-1) break;
                if (l == 0) min = a[r+1];
                else if (r == n-1) min = a[l-1];
                else min = Math.max(a[r+1], a[l-1]);
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution s  =  new Solution();

        int [] a = new int [] {1,4,3,7,4,5};
        
        int r = s.maximumScore(a, 3);
        System.out.println("r: " + r);
    }
}
//  TreeNode root  =  new TreeNode(a[0]);
//  root.buildTree(root, a);
//  root.levelPrintTree(root);











