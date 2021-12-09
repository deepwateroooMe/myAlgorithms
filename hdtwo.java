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

public class hdtwo {
    public static class Solution {

        // public List<String> addOperators(String s, int target) {
        //     helper(s, "", 0, 0, target);
        //     return ans;
        // }
        // List<String> ans = new ArrayList<>();
        // char [] s;
        // int n;
        // void helper(String s, String t, long cur, long pre, int target) {
        //     if (cur == target && s.length() == 0) {
        //         ans.add(new String(t));
        //         return ;
        //     }
        //     for (int i = 1; i <= s.length(); i++) {
        //         String tmp = s.substring(0, i);
        //         // if (tmp.length() > 1 && tmp.charAt(0) == 0) continue; // BUG
        //         if (tmp.length() > 1 && tmp.charAt(0) == '0') return ;
        //         long v = Long.parseLong(tmp);
        //         String next = s.substring(i);
        //         if (t.length() > 0) {
        //             helper(next, t + "*" + v, (cur - pre) + pre * v, pre * v, target);
        //             helper(next, t + "+" + v, cur + v, v, target);
        //             helper(next, t + "-" + v, cur - v, -v, target);
        //         } else helper(next, tmp, v, v, target); 
        //     }
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
        // public int countRangeSum(int[] a, int lower, int upper) {
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

        // public boolean isSelfCrossing(int[] d) {
        //     int n = d.length;
        //     if (n < 4) return false;
        //     for (int i = 3; i < n; i++) {
        //         if (d[i] >= d[i-2] && d[i-3] >= d[i-1]) return true;
        //         if (i >= 4 && d[i-1] == d[i-3] && d[i] >= d[i-2] - d[i-4]) return true;
        //         if (i >= 5 && d[i-2] >= d[i-4] && d[i-3] >= d[i-1] && d[i-1] >= d[i-3] - d[i-5] && d[i] >= d[i-2] - d[i-4]) return true;
        //     }
        //     return false;
        // }

        // public boolean isValid(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     ArrayDeque<String> st = new ArrayDeque<>();
        //     for (int i = 0; i < n; i++) {
        //         if (i > 0 && st.isEmpty()) return false;
        //         if (t.substring(i, Math.min(n, i+9)).equals("<![CDATA[")) { // cdata 标签
        //             int j = i + 9;
        //             i = t.indexOf("]]>", j); // 这些地方，i都自动往后跳
        //             if (i == -1) return false;
        //             i += 2; // 跳至"]]>"之后 
        //         } else if (t.substring(i, Math.min(n, i+2)).equals("</")) { // tag尾标签
        //             int j = i + 2;
        //             i = t.indexOf(">", j);  // 
        //             String tmp = t.substring(j, i);
        //             if (st.isEmpty() || !st.peekLast().equals(tmp)) return false;
        //             st.pollLast();
        //         } else if (s[i] == '<') { // 以 < 开头的其它情况都考虑过了
        //             int j = i + 1;
        //             i = t.indexOf(">", j);
        //             if (i == -1 || j == i || i-j > 9) return false;
        //             for (int k = j; k < i; k++)
        //                 if (!Character.isUpperCase(s[k])) return false;
        //             String tmp = t.substring(j, i);
        //             st.offerLast(tmp); // 开头标签压入栈， 方便上面的结尾时对比，名字需要符合
        //         }
        //     }
        //     return st.isEmpty();
        // }

        // public int scheduleCourse(int[][] a) {
        //     int n = a.length;
        //     Arrays.sort(a, (x, y)->x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]); // 结束时间升序、持续时间升序
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> y[0] - x[0]);     // 持续时间降序：换的时候优先换耗时最久的课程
        //     int cnt = 0, t = 0; // t: time now
        //     for (int i = 0; i < n; i++) {
        //         int [] cur = a[i];
        //         // if (t + cur[0] > cur[1]) continue; // 你不是接下来else：会拿晚结束的课程与之前持续较久的课程换的吗，所有不能跳过
        //         // if (cur[0] > cur[1]) continue; // 应该不会存在这种test case吧
        //         if (t + cur[0] <= cur[1]) {
        //             q.offer(cur);
        //             t += cur[0];
        //         } else if (!q.isEmpty() && q.peek()[0] > cur[0]) {
        //                 int [] top = q.poll();
        //                 t = t - top[0] + cur[0];
        //                 q.offer(cur);
        //             }
        //     }
        //     return q.size();
        // }

        // public int[] smallestRange(List<List<Integer>> ll) { // O(Nlgk)
        //     int n = ll.size(), gmin = 0, gmax = Integer.MAX_VALUE, minR = Integer.MAX_VALUE; // global values: 初始化为最大范围
        //     int minIdx = 0, max = Integer.MIN_VALUE, curR = 0;
        //     int [] next = new int [n];
        //     Queue<Integer> q = new PriorityQueue<>((x, y)->ll.get(x).get(next[x]) - ll.get(y).get(next[y])); // 最小堆
        //     for (int i = 0; i < n; i++) {
        //         q.offer(i);
        //         max = Math.max(max, ll.get(i).get(0));
        //     }
        //     while (true) {
        //         minIdx = q.poll();
        //         curR = max - ll.get(minIdx).get(next[minIdx]); // 每条链表至少包含一个元素时的最小范围
        //         if (curR < minR) {
        //             minR = curR;
        //             gmin = ll.get(minIdx).get(next[minIdx]);
        //             gmax = max;
        //         }
        //         next[minIdx]++; // 以某一条单链表一个值为单位，单条链表滑动窗口向右移动，滑动的链表同样是变动的
        //         if (next[minIdx] == ll.get(minIdx).size()) break; // 通过扫完一条最短链表，将初始化过的范围最小化
        //         q.offer(minIdx);
        //         max = Math.max(max, ll.get(minIdx).get(next[minIdx]));
        //     }
        //     return new int [] {gmin, gmax} ;
        // }
        // public int[] smallestRange(List<List<Integer>> ll) {
        //     // 里面存储的是行列数据位置，优先级是列中数据大小
        //     PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> ll.get(o[0]).get(o[1])));
        //     int max = Integer.MIN_VALUE, bgn = 0, end = Integer.MAX_VALUE;
        //     // 先让每个数组中的第一个数进入 q
        //     for (int i = 0; i < ll.size(); i++) {
        //         q.offer(new int [] {i, 0});
        //         max = Math.max(max, ll.get(i).get(0));
        //     }
        //     while (q.size() == ll.size()) { // 当某一个链表遍历结束了，就退出循还了
        //         int e [] = q.poll(), row = e[0], col = e[1]; // 取出最小的元素获得到行列信息
        //         if (end - bgn > max - ll.get(row).get(col)) { // 比较，如果符合条件就更新最小区间信息
        //             bgn = ll.get(row).get(col);
        //             end = max;
        //         }
        //         if (col + 1 < ll.get(row).size()) { // 防止越界
        //             q.offer(new int [] {row, col + 1});
        //             max = Math.max(max, ll.get(row).get(col + 1));
        //         }
        //     }
        //     return new int [] {bgn, end};
        // }
        // public int[] smallestRange(List<List<Integer>> ll) { // O(nk+∣V∣)，其中 n 是所有列表的平均长度，k 是列表数量，|V| 是列表中元素的值域,很慢
        //     int size = ll.size();
        //     Map<Integer, List<Integer>> idx = new HashMap<Integer, List<Integer>>();
        //     int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE;
        //     for (int i = 0; i < size; i++) 
        //         for (int x : ll.get(i)) {
        //             idx.computeIfAbsent(x, z -> new ArrayList<>()).add(i);
        //             xMin = Math.min(xMin, x);
        //             xMax = Math.max(xMax, x);
        //         }
        //     int [] freq = new int[size];
        //     int inside = 0;
        //     int left = xMin, right = xMin - 1;
        //     int bestLeft = xMin, bestRight = xMax;
        //     while (right < xMax) {
        //         right++;
        //         if (idx.containsKey(right)) {
        //             for (int x : idx.get(right)) {
        //                 freq[x]++;
        //                 if (freq[x] == 1) inside++;
        //             }
        //             while (inside == size) {
        //                 if (right - left < bestRight - bestLeft) {
        //                     bestLeft = left;
        //                     bestRight = right;
        //                 }
        //                 if (idx.containsKey(left)) 
        //                     for (int x: idx.get(left)) {
        //                         freq[x]--;
        //                         if (freq[x] == 0) inside--;
        //                     }
        //                 left++;
        //             }
        //         }
        //     }
        //     return new int[]{bestLeft, bestRight};
        // }

        // public int findKthNumber(int m, int n, int k) { // 关于y = -x ？对称
        //     int l = 1, r = m * n;
        //     while (l <= r) {
        //         int mid = l + (r - l) / 2;
        //         int cnt = 0;
        //         for (int i = 1; i <= m; i++) 
        //             cnt += Math.min(n, mid / i);
        //         if (cnt < k) l = mid + 1;
        //         else r = mid - 1;
        //     }
        //     return l;
        // }

        // public int cutOffTree(List<List<Integer>> ll) { // 一开始没读懂题目是什么意思
        //     if (ll.get(0).get(0) == 0) return -1;
        //     m = ll.size();
        //     n = ll.get(0).size();
        //     long cnt = 0;
        //     List<int []> hi = new ArrayList<>();
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (ll.get(i).get(j) > 1) hi.add(new int [] {i, j});
        //     Collections.sort(hi, (a, b)->ll.get(a[0]).get(a[1]) - ll.get(b[0]).get(b[1])); // 树由矮到高的顺序
        //     for (int i = 0; i < hi.size(); i++) {
        //         int [] cur = hi.get(i), pre = (i == 0 ? new int [] {0, 0} : hi.get(i-1));
        //         long v = bfs(pre[0], pre[1], cur[0], cur[1], ll);
        //         if (v >= Long.MAX_VALUE / 3) return -1;
        //         cnt += v;
        //     }
        //     return cnt > Long.MAX_VALUE / 3 ? -1: (int)cnt;
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int m, n;
        // long bfs(int i, int j, int di, int dj, List<List<Integer>> ll) {
        //     Queue<int []> q = new LinkedList<>();
        //     boolean [][] vis = new boolean [m][n];
        //     q.offer(new int [] {i, j});
        //     vis[i][j] = true;
        //     long cnt = 0;
        //     while (!q.isEmpty()) {
        //         for (int z = q.size()-1; z >= 0; z--) {
        //             int [] cur = q.poll();
        //             if (cur[0] == di && cur[1] == dj) return cnt;
        //             for (int [] d : dirs) {
        //                 int x = cur[0] + d[0], y = cur[1] + d[1];
        //                 if (x < 0 || x >= m || y < 0 || y >= n || ll.get(x).get(y) == 0) continue;
        //                 if (!vis[x][y]) {
        //                     q.offer(new int [] {x, y});
        //                     vis[x][y] = true;
        //                 }
        //             }
        //         }
        //         cnt++;
        //     }
        //     return Long.MAX_VALUE / 3;
        // }

        // public String makeLargestSpecial(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     List<String> ls = new ArrayList<>();
        //     int cnt = 0, j = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == '1') cnt++;
        //         else --cnt;
        //         if (cnt == 0) { // 这是一个子结构
        //             ls.add("1" + makeLargestSpecial(t.substring(j+1, i)) + "0");
        //             j = i + 1;
        //         }
        //     }
        //     Collections.sort(ls, (a, b)->b.compareTo(a)); // 字符串降序排列
        //     String ans = "";
        //     for (String v : ls) ans += v;
        //     return ans;
        // }

        // public int slidingPuzzle(int[][] a) {
        //     int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //     int m = 2, n = 3, i = 0, cnt = 0;
        //     int [][] t = {{1, 2, 3}, {4, 5, 0}};
        //     Set<String> vis = new HashSet<>();
        //     Queue<int [][]> q = new LinkedList<>();
        //     q.offer(a);
        //     vis.add(Arrays.toString(a[0]) + Arrays.toString(a[1]));
        //     while (!q.isEmpty()) {
        //         for (int z = q.size()-1; z >= 0; z--) {
        //             int [][] cur = q.poll();
        //             for ( i = 0; i < m; i++) 
        //                 if (!Arrays.equals(cur[i], t[i])) break;
        //             if (i == m) return cnt;
        //             int [] idx = findZero(cur);
        //             for (int [] d : dirs) {
        //                 int x = idx[0] + d[0], y = idx[1] + d[1];
        //                 if (x < 0 || x >= m || y < 0 || y >= n) continue;
        //                 int [][] b = arrCopy(cur);
        //                 b[idx[0]][idx[1]] = b[x][y];
        //                 b[x][y] = 0;
        //                 String st = Arrays.toString(b[0]) + Arrays.toString(b[1]);
        //                 if (!vis.contains(st)) {
        //                     vis.add(st);
        //                     q.offer(b);
        //                 }
        //             }
        //         }
        //         cnt++;
        //     }
        //     return -1;
        // }
        // int [] findZero(int [][] a) {
        //     for (int i = 0; i < a.length; i++) 
        //         for (int j = 0; j < a[0].length; j++) 
        //             if (a[i][j] == 0) return new int [] {i, j};
        //     return  new int [2];
        // }
        // int [][] arrCopy(int [][] a) {
        //     int [][] b = new int [a.length][];
        //     for (int i = 0; i < a.length; i++)
        //         b[i] = Arrays.copyOf(a[i], a[i].length);
        //     return b;
        // }

        // public int movesToChessboard(int[][] a) {
        //     int n = a.length, rs = 0, cs = 0, rd = 0, cd = 0; // sums difs 
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if ((a[0][0] ^ a[i][0] ^ a[0][j] ^ a[i][j]) > 0) return -1;
        //     for (int i = 0; i < n; i++) {
        //         rs += a[0][i];
        //         cs += a[i][0];
        //         rd += a[i][0] == i % 2 ? 1 : 0;
        //         cd += a[0][i] == i % 2 ? 1 : 0;
        //     }
        //     if (rs < n/2 || rs > (n+1)/2) return -1;
        //     if (cs < n/2 || cs > (n+1)/2) return -1;
        //     if (n % 2 == 1) {
        //         if (rd % 2 == 1) rd = n - rd;
        //         if (cd % 2 == 1) cd = n - cd;
        //     } else {
        //         rd = Math.min(rd, n-rd);
        //         cd = Math.min(cd, n-cd);
        //     }
        //     return (rd + cd) / 2;
        // }

        // public int largestIsland(int[][] a) {
        //     int m = a.length, n = a[0].length;
        //     UnionFind uf = new UnionFind(m*n);
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) {
        //             if (a[i][j] == 0) continue;
        //             for (int [] d : dirs) {
        //                 int x = i + d[0], y = j + d[1];
        //                 if (x < 0 || x >= m || y < 0 || y >= n || a[x][y] == 0) continue;
        //                 uf.merge(i*n+j, x*n+y);
        //             }
        //         }
        //     int max = 0, sum = 0;
        //     boolean found = false;
        //     Set<Integer> cur = new HashSet<>();
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (a[i][j] == 0) {
        //                 found = true;
        //                 cur.clear();
        //                 sum = 1;
        //                 for (int [] d : dirs) {
        //                     int x = i + d[0], y = j + d[1];
        //                     if (x < 0 || x >= m || y < 0 || y >= n || a[x][y] == 0) continue;
        //                     cur.add(uf.find(x*n+y));
        //                 }
        //                 for (Integer par : cur) 
        //                     sum += uf.getSize(par);
        //                 max = Math.max(max, sum);
        //             }
        //     return found ? max : m*n;
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // public class UnionFind {
        //     int [] par, size;
        //     int n;
        //     public UnionFind(int x) {
        //         n = x;
        //         par = new int[n];
        //         size = new int [n];
        //         for (int i = 0; i < n; i++) par[i] = i;
        //         Arrays.fill(size, 1);
        //     }
        //     public int getSize(int v) {
        //         return size[v];
        //     }
        //     public int find(int val) {
        //         while (val != par[val]) {
        //             par[val] = par[par[val]];
        //             val = par[val];
        //         }
        //         return val;
        //     }
        //     public void merge(int p, int q) {
        //         int rp = find(p);
        //         int rq = find(q);
        //         if (rp == rq) return ;
        //         par[rq] = rp;
        //         size[rp] += size[rq];
        //     }
        //     public boolean sameGroup(int x, int y) {
        //         return find(x) == find(y);
        //     }
        //     private void swap(int x, int y) {
        //         int tmp = x;
        //         x = y;
        //         y = tmp;
        //     }
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
    // class Range {
    //     int l, r;
    //     public Range(int l, int r) {
    //         this.l = l;
    //         this.r = r;
    //     }
    // }

        // public int swimInWater(int[][] a) {
        //     int n = a.length, l = 1, r = n * n, ans = 0;
        //     if (n == 1) return a[0][0];
        //     while (l <= r) {
        //         int m = (l + r) / 2;
        //         if (bfs(0, 0, m, n, a)) {
        //             ans = m;        //             r = m-1;
        //         } else l = m+1;
        //     }
        //     return ans;
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // boolean bfs(int i, int j, int v, int n, int [][] a) { // 这里要用bfs更快一些，dfs会超时
        //     if (a[i][j] > v) return false;
        //     Queue<int []> q = new LinkedList<>();
        //     q.offer(new int [] {i, j});
        //     boolean [][] vis = new boolean [n][n];
        //     vis[i][j] = true;
        //     while (!q.isEmpty()) {
        //         int [] cur = q.poll();
        //         if (cur[0] == n-1 && cur[1] == n-1) return true;
        //         for (int [] d : dirs) {
        //             int x = cur[0] + d[0], y = cur[1] + d[1];
        //             if (x < 0 || x >= n || y < 0 || y >= n || vis[x][y]) continue;
        //             if (a[x][y] > v) continue;
        //             q.offer(new int [] {x, y});
        //             vis[x][y] = true;
        //         }
        //     }
        //     return false;
        // }

        // public int numSimilarGroups(String[] s) {
        //     int n = s.length;
        //     UnionFind uf = new UnionFind(n);
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) 
        //             if (s[i].equals(s[j]) || difByTwo(s[i], s[j]))
        //                 uf.merge(i, j);
        //     return uf.getCnt();
        // }
        // boolean difByTwo(String ss, String tt) {
        //     int n = ss.length(), cnt = 0;
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     for (int i = 0; i < n; i++) 
        //         if (s[i] != t[i]) {
        //             cnt++;
        //             if (cnt > 2) return false;
        //         }
        //     return true;
        // }
        // public class UnionFind {
        //     int [] par, size;
        //     int n, cnt;
        //     public UnionFind(int x) {
        //         n = x;
        //         cnt = n;
        //         par = new int[n];
        //         size = new int [n];
        //         for (int i = 0; i < n; i++) par[i] = i;
        //         Arrays.fill(size, 1);
        //     }
        //     public int find(int val) {
        //         while (val != par[val]) {
        //             par[val] = par[par[val]];
        //             val = par[val];
        //         }
        //         return val;
        //     }
        //     public void merge(int p, int q) {
        //         int rp = find(p);
        //         int rq = find(q);
        //         if (rp == rq) return;
        //         par[rq] = rp;
        //         size[rp] += size[rq];
        //         cnt--; // 
        //     }
        //     public int getCnt() {
        //         return cnt;
        //     }
        // }

        // public int uniquePathsIII(int [][] a) {
        //     m = a.length;
        //     n = a[0].length;
        //     int si = 0, sj = 0, ei = 0, ej = 0, cnt = 0;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (a[i][j] == 1) {
        //                 si = i;
        //                 sj = j;
        //             } else if (a[i][j] == 2) {
        //                 ei = i;
        //                 ej = j;
        //             } else if (a[i][j]== -1) cnt++;
        //     vis = new boolean [m][n];
        //     dfs(si, sj, ei, ej, new ArrayList<>(), cnt, a);
        //     return ll.size();
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // List<List<Integer>> ll = new ArrayList<>();
        // boolean [][] vis;
        // int m, n;
        // void dfs(int i, int j, int ei, int ej, List<Integer> l, int cnt, int [][] a) {
        //     if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j] || a[i][j] == -1) return ;
        //     if (i == ei && j == ej) {
        //         if (l.size() == m * n - cnt -1) {
        //             l.add(i*n+j);
        //             ll.add(new ArrayList<>(l));
        //             l.remove(l.size()-1);
        //         }
        //         return ;
        //     }
        //     vis[i][j] = true;
        //     l.add(a[i][j]);
        //     for (int [] d : dirs) 
        //         dfs(i+d[0], j+d[1], ei, ej, l, cnt, a);
        //     l.remove(l.size()-1);
        //     vis[i][j] = false;
        // }

        // public String lastSubstring(String t) { // 这么写效率更高一点儿
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int i = 0, j = 1, k = 0;
        //     while (j + k < n) {
        //         if (s[i+k] == s[j+k]) k++; // 连续相同的字母，向右遍历，扫至尾
        //         else if (s[i+k] < s[j+k]) { // 以 i 开头的子串没有以j 开头的子串好
        //             // i = j; // tle 
        //             i = Math.max(i + k + 1, j); // 所以这里更新i 至j：一个相对更好的解
        //             j = i + 1; // j往后挪一位
        //             k = 0;  // 重新再计数
        //         } else { // s[i+k] > s[j+k], i是更优解，i不用更新
        //             j += k + 1;
        //             k = 0;
        //         }
        //     }
        //     return t.substring(i);
        // }
        // public String lastSubstring(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int i = 0, j = 1, k = 0;
        //     while (j + k < n) {
        //         if (s[i+k] == s[j+k]) {
        //             k++; // 连续相同的字母，向右遍历，扫至尾
        //             continue;
        //         }
        //         if (s[i+k] > s[j+k]) { // i是更优解，i不用更新 
        //             // j++; // tle
        //             j += k+1;
        //         } else { // 以 i 开头的子串没有以j 开头的子串好
        //             // i = j; // tle 
        //             i = Math.max(i + k + 1, j); // 所以这里更新i 至j：一个相对更好的解
        //             j = i + 1; // j往后挪一位
        //         } 
        //         k = 0;  // 重新再计数
        //     }
        //     return t.substring(i);
        // }

        // public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        //     UnionFind uf = new UnionFind(n+1);
        //     for (int i = threshold + 1; i <= n; ++i) // > threshold
        //         for (int j = i * 2; j <= n; j += i) 
        //             uf.merge(i, j);
        //     // int [][] g = new int [n+1][n+1]; // tle
        //     // for (int i = 1; i <= n; i++) 
        //     //     for (int j = 1; j <= n; j++) {
        //     //         if (g[i][j] == 0) {
        //     //             g[i][j] = gcd(i, j);
        //     //             g[j][i] = g[i][j];
        //     //         }
        //     //         if (g[i][j] > threshold) 
        //     //             uf.merge(i, j);
        //     //     }
        //     List<Boolean> ans = new ArrayList<>();
        //     for (int i = 0; i < queries.length; i++) 
        //         ans.add(uf.sameGroup(queries[i][0], queries[i][1]));
        //     return ans;
        // }
        // public class UnionFind {
        //     int [] par, size;
        //     int n, cnt;
        //     public UnionFind(int x) {
        //         n = x;
        //         cnt = n;
        //         par = new int[n];
        //         size = new int [n];
        //         for (int i = 0; i < n; i++) par[i] = i;
        //         Arrays.fill(size, 1);
        //     }
        //     public boolean sameGroup(int x, int y) {
        //         return find(x) == find(y);
        //     }
        //     public int find(int val) {
        //         while (val != par[val]) {
        //             par[val] = par[par[val]];
        //             val = par[val];
        //         }
        //         return val;
        //     }
        //     public void merge(int p, int q) {
        //         int rp = find(p);
        //         int rq = find(q);
        //         if (rp == rq) return;
        //         par[rq] = rp;
        //         size[rp] += size[rq];
        //         cnt--; // 
        //     }
        //     public int getCnt() {
        //         return cnt;
        //     }
        // }
        // // int gcd(int x, int y) {
        // //     if (y == 0) return x;
        // //     return gcd(y, x % y);
        // // }

        // public int numSubmatrixSumTarget(int[][] mat, int target) {
        //     int m = mat.length, n = mat[0].length, cnt = 0;
        //     int [][] sum = new int [m+1][n+1];
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             sum[i][j] = sum[i][j-1] + sum[i-1][j] + mat[i-1][j-1] - sum[i-1][j-1];
        //     for (int i = 0; i < m; i++) // for循环太多，复杂度太高了
        //         for (int d = 1; i+d <= m; d++) {
        //             int r = i + d;
        //             for (int j = 0; j <=n; j++) 
        //                 for (int k = 1; j+k <= n; k++) {
        //                     int c = j + k;
        //                     int cur = sum[r][c] - sum[r][j] - sum[i][c] + sum[i][j];
        //                     if (cur == target) cnt++;
        //                 }
        //         }
        //     return cnt;
        // }
        // public int numSubmatrixSumTarget(int[][] a, int target) {
        //     int res = 0, m = a.length, n = a[0].length;
        //     for (int i = 0; i < m; i++)
        //         for (int j = 1; j < n; j++)
        //             a[i][j] += a[i][j - 1]; // 把它变成是每行至列j的和
        //     Map<Integer, Integer> cnt = new HashMap<>();
        //     for (int i = 0; i < n; i++) // 固定两个列
        //         for (int j = i; j < n; j++) {
        //             cnt.clear();
        //             cnt.put(0, 1);
        //             int cur = 0;
        //             for (int k = 0; k < m; k++) { // 累加行的和
        //                 cur += a[k][j] - (i > 0 ? a[k][i - 1] : 0);
        //                 res += cnt.getOrDefault(cur - target, 0);
        //                 cnt.put(cur, cnt.getOrDefault(cur, 0) + 1);
        //             }
        //         }
        //     return res;
        // }
        // public int numSubmatrixSumTarget(int[][] a, int target) {
        //     int ans = 0, m = a.length, n = a[0].length;
        //     for (int j = 0; j < n; j++) 
        //         for (int i = 1; i < m; i++) 
        //             a[i][j] += a[i-1][j];
        //     Map<Integer, Integer> cnt = new HashMap<>();
        //     for (int k = 0; k < m; k++) // 固定两个行
        //         for (int i = k; i < m; i++) {
        //             cnt.clear();
        //             cnt.put(0, 1); // 引子
        //             int sum = 0;
        //             for (int j = 0; j < n; j++) { // 累加列的和
        //                 sum += a[i][j] - (k > 0 ? a[k-1][j] : 0);
        //                 ans += cnt.getOrDefault(sum - target, 0);
        //                 cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
        //             }
        //         }
        //     return ans;
        // }

        // public List<Integer> findNumOfValidWords(String[] w, String[] p) {
        //     int m = w.length, n = p.length;
        //     Map<Integer, Integer> map = new HashMap<>();
        //     for (String s : w) { // 将每个字符串转化成一个mask,字母的前后出现顺序无关，只与26个字母是否出现相关
        //         int cur = 0;
        //         for (char c : s.toCharArray()) 
        //             cur |= (1 << (c - 'a'));
        //         map.put(cur, map.getOrDefault(cur, 0) + 1);
        //     }
        //     List<Integer> ans = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         String cur = p[i];
        //         int fstMask = (1 << (cur.charAt(0) - 'a')); // 第1个字母必须出现
        //         int cnt = map.getOrDefault(fstMask, 0);
        //         List<Integer> maskList = new ArrayList<>();
        //         for (int j = 1; j < 7; j++) { // 其它字符不是必须，遍历所有可能的子集subset
        //             List<Integer> l = new ArrayList<>();
        //             int curMask = 1 << (cur.charAt(j)-'a') | fstMask; // 只出现第一个字符，和当前字符两个字符
        //             cnt += map.getOrDefault(curMask, 0);
        //             l.add(curMask);
        //             for (Integer v : maskList) {
        //                 int tmpMask = v | curMask; // 可以出现第一个字符，当前字符，以及j之前出现的所有可能字符的所有子集
        //                 cnt += map.getOrDefault(tmpMask, 0);
        //                 l.add(tmpMask); // 收集各个子集
        //             }
        //             maskList.addAll(l); // 收集各个子集
        //         }
        //         ans.add(cnt);
        //     }
        //     return ans;
        // }

        // public int minFlips(int[][] a) {
        //     m = a.length;
        //     n = a[0].length;
        //     if (m == 1 && n == 1) return a[0][0] == 0 ? 0 : 1;
        //     int r = 1 << (m*n), min = Integer.MAX_VALUE;
        //     if (isZeroMat(a)) return 0;
        //     for (int i = 1; i < r; i++) {
        //         int [][] b = arrCopy(a);
        //         for (int j = 0; j < m*n; j++) 
        //             if (((i >> j) & 1) == 1) 
        //                 flip(b, j);
        //         if (isZeroMat(b)) min = Math.min(min, Integer.bitCount(i));
        //     }
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int m, n;
        // boolean isZeroMat(int [][] a) {
        //     int max = 0, m = a.length;
        //     for (int i = 0; i < m; i++) 
        //         max = Math.max(max, Arrays.stream(a[i]).max().getAsInt());
        //     return max == 0;
        // }
        // void flip(int [][] a, int idx) {
        //     int x = idx / n, y = idx % n;
        //     for (int [] d : dirs) {
        //         int i = x + d[0], j = y + d[1];
        //         if (i < 0 || i >= m || j < 0 || j >= n) continue;
        //         a[i][j] = 1 - a[i][j];
        //     }
        //     a[x][y] = 1 - a[x][y];
        // }
        // int [][] arrCopy(int [][] a) {
        //     int [][] ans = new int[m][];
        //     for (int i = 0; i < m; i++) 
        //         ans[i] = Arrays.copyOf(a[i], n);
        //     return ans;
        // }

        // public int minJumps(int[] a) { // tle
        //     int n = a.length;
        //     Map<Integer, Set<Integer>> adj = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         if (i > 0) {
        //             adj.computeIfAbsent(i, z -> new HashSet<>()).add(i-1);
        //             adj.computeIfAbsent(i-1, z -> new HashSet<>()).add(i);
        //         }
        //         if (i < n-1) {
        //             adj.computeIfAbsent(i, z -> new HashSet<>()).add(i+1);
        //             adj.computeIfAbsent(i+1, z -> new HashSet<>()).add(i);
        //         }
        //         for (int j = 0; j < n; j++) {
        //             if (j == i || a[i] != a[j]) continue;
        //             adj.computeIfAbsent(i, z -> new HashSet<>()).add(j);
        //             adj.computeIfAbsent(j, z -> new HashSet<>()).add(i);
        //         }
        //     }
        //     boolean [] vis = new boolean [n];
        //     Queue<Integer> q = new PriorityQueue<>((x, y)->y-x);
        //     // Queue<Integer> q = new LinkedList<>();
        //     q.offer(0);
        //     vis[0] = true; // 这里vis的状态可能设置得不够好
        //     int cnt = 0;
        //     while (!q.isEmpty()) {
        //         for (int z = q.size()-1; z >= 0; z--) {
        //             int idx = q.poll();
        //             if (idx == n-1) return cnt;
        //             for (Integer next : adj.get(idx)) {
        //                 if (vis[next]) continue;
        //                 q.offer(next);
        //                 vis[next] = true;
        //             }
        //         }
        //         cnt++;
        //     }
        //     return -1;
        // }

        // public class MaxSeg {
        //     List<Integer> tree = new ArrayList<>();
        //     int n;
        //     public MaxSeg (int [] arr) {
        //         n = arr.length;
        //         tree = new ArrayList<>(2 * n);
        //         for (int i = 0; i < n; i++)
        //             tree.add(0);
        //         for (int i = 0; i < n; i++)
        //             tree.add(arr[i]); // same effect as below
        //         for (int i = n-1; i >= 0; i--) // i >= 0
        //             tree.set(i, Math.max(tree.get(2 * i), tree.get(2 * i+1)));
        //     }
        //     public void update(int idx, int v) {
        //         idx += n;
        //         tree.set(idx, v);
        //         while (idx > 1) {
        //             idx /= 2;
        //             tree.set(idx, Math.max(tree.get(2 * idx), tree.get(2 * idx+1)));
        //         }
        //     }
        //     public int getMax(int l, int r) { // [l, r)
        //         l += n;
        //         r += n;
        //         int max = Integer.MIN_VALUE;
        //         while (l < r) {
        //             if ((l & 1) == 1) {
        //                 max = Math.max(max, tree.get(l));
        //                 l++;
        //             }
        //             if ((r & 1) == 1) {
        //                 r--; // order matters !!!
        //                 max = Math.max(max, tree.get(r));
        //             }
        //             l >>= 1;
        //             r >>= 1;
        //         }
        //         return max;
        //     }
        // }
        // public boolean isPossible(int[] a) { // tle 
        //     int n = a.length, max = 0;
        //     if (n== 2 && (a[0] == 1 || a[1] == 1)) return true;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     long sum = 0;
        //     for (int i = 0; i < n; i++) {
        //         sum += a[i];
        //         m.put(a[i], i);
        //     }
        //     System.out.println("sum: " + sum);
        //     MaxSeg ms = new MaxSeg(a);
        //     while (true) {
        //         max = ms.getMax(0, n);
        //         if (max == 1) return true;
        //         if (max <= (int)(sum - max)) return false;
        //         int i = m.get(max);
        //         a[i] = (int)(max - (sum - max));
        //         ms.update(i, a[i]);
        //         m.remove(max);
        //         m.put(a[i], i);
        //         sum -= max - a[i]; // BUG: 重复重复现重复
        //     }
        // }
        // public boolean isPossible(int[] a) {
        //     int n = a.length;
        //     if (n == 1) return a[0] == 1;
        //     long sum = 0;
        //     Queue<Integer> q = new PriorityQueue<>((x, b)-> b-x); // 最大堆：可以不用一个相对复杂很多的MaxSeg,用个最大堆就可以了
        //     for (int v : a) {
        //         q.offer(v);
        //         sum += v;
        //     }
        //     int max = 0;
        //     while (q.peek() != 1) {
        //         max = q.poll();
        //         if (max <= sum - max) return false;
        //         int pre = (int)(max % (int)(sum - max)); 
        //         if (pre == 0) return sum - max == 1;
        //         sum -= (max - pre);
        //         q.offer(pre);
        //     }
        //     return true;
        // }

        // static final int mod = (int)1e9 + 7;
        // public int maxPerformance(int n, int[] s, int[] e, int k) {
        //     List<int []> ll = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         ll.add(new int [] {s[i], e[i]});
        //     Collections.sort(ll, (a, b) -> b[1] != a[1] ? b[1] - a[1] : b[0] - a[0]);
        //     for (int [] zz : ll) 
        //         System.out.println(Arrays.toString(zz));
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); // 速度由氏到高，方便晚点儿的时候把差的扔出去
        //     long sum = 0, max = 0;
        //     int idx = 0;
        //     for (int i = 0; i < n; i++) {
        //         int [] cur = ll.get(i);
        //         sum += cur[0]; 
        //         q.offer(cur);
        //         while (!q.isEmpty() && q.size() > k) sum -= q.poll()[0];
        //         max = Math.max(max, sum * cur[1]);
        //     }
        //     return (int)(max % mod);
        // }

        // public String longestPrefix(String t) { // 还是不太透，要再看一下  KMP
        //     int n = t.length(), j = 0;
        //     char [] s = t.toCharArray();
        //     int [] lps = new int [n];
        //     lps[0] = 0;
        //     for (int i = 1; i < n; i++) {
        //         j = lps[i-1]; // 前一个字符所指向的位置
        //         while (s[i] != s[j]) { // 如果两个字符不相同，则j一直向前寻求找上一个出现的相同字符或，回到最开始并break掉
        //             if (j == 0) {
        //                 j = -1;
        //                 break;
        //             } // else
        //             j = lps[j-1];
        //         }
        //         lps[i] = j + 1;
        //     }
        //     return t.substring(0, lps[n-1]);
        // }

        // public int findMaxValueOfEquation(int[][] a, int k) {
        //     int n = a.length, max = Integer.MIN_VALUE;
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        //     for (int i = 0; i < n; i++) {
        //         int [] cur = a[i];
        //         while (!q.isEmpty() && cur[0] - q.peek()[1] > k) q.poll();
        //         if (!q.isEmpty())
        //             max = Math.max(max, cur[0] + cur[1] + q.peek()[0]);
        //         q.offer(new int [] {cur[1]-cur[0], cur[0]});
        //     }
        //     return max;
        // }

        // public int longestAwesome(String t) { // tle: 那就需要换个方法遍历
        //     int n = t.length(), max = 0, cnt = 0, cur = 0;
        //     char [] s = t.toCharArray();
        //     Map<Integer, Integer> m = new HashMap<>(); // [mask, idx]
        //     for (int i = 0; i < n; i++) {
        //         cur ^= (1 << (s[i] - '0'));
        //         cnt = Integer.bitCount(cur);
        //         if (cnt <= 1) {
        //             max = i+1; // 如果当前子串满足要求，更新最大值
        //             if (!m.containsKey(cur))
        //                 m.put(cur, i);
        //             continue;
        //         } // 如果当前不满足条件：需要考虑在前某个前缀的基础上连接了一个可以构成回文的子串, corner case比较多
        //         for (Integer key : m.keySet()) { // tle 是因为m里面的key 太多了
        //             int dif = cur ^ key;
        //             if (dif > 0 && Integer.bitCount(dif) == 1) 
        //                 max = Math.max(max, i - m.get(key));
        //         }
        //         if (!m.containsKey(cur))
        //             m.put(cur, i);
        //     }
        //     return max;
        // }
        // public int longestAwesome(String t) { // Expected complexity is O(n*A) where A is the alphabet (10).
        //     int n = t.length(), max = 0, cnt = 0, cur = 0; // 坑巨多：
        //     char [] s = t.toCharArray();
        //     Map<Integer, Integer> m = new HashMap<>(); // [mask, idx]
        //     for (int i = 0; i < n; i++) {
        //         cur ^= (1 << (s[i] - '0'));
        //         cnt = Integer.bitCount(cur);
        //         if (cnt <= 1) {
        //             max = i+1; // 如果当前子串满足要求，更新最大值
        //             if (!m.containsKey(cur)) // 只存第一次出现的mask，即只存同一个不合格mask的最短前缀
        //                 m.put(cur, i);
        //             continue;
        //         } // 如果当前不满足条件：需要考虑在前某个前缀的基础上连接了一个可以构成回文的子串, corner case比较多
        //         if (m.containsKey(cur)) max = Math.max(max, i - m.get(cur)); // 同一个可能之前出现过
        //         for (int j = 0; j < 10; j++)
        //             if (((cur >> j) & 1) == 1) {
        //                 int tmp = cur ^ (1 << j);
        //                 if (m.containsKey(tmp)) max = Math.max(max, i - m.get(tmp));
        //             } else { // ((( i >> j) & 1) == 0) 
        //                 int tmp = cur | (1 << j);
        //                 if (m.containsKey(tmp)) max = Math.max(max, i - m.get(tmp));
        //             }
        //         if (!m.containsKey(cur))
        //             m.put(cur, i);
        //     }
        //     return max;
        // }

        // public int minMoves(int[] a, int k) { 
        //     if (k == 1) return 0;
        //     int n = a.length;
        //     List<Integer> g = new ArrayList<>();
        //     List<Integer> sum = new ArrayList<>();
        //     sum.add(0);
        //     int cnt = -1, last = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] == 0) continue;
        //         ++cnt;
        //         g.add(i-cnt);
        //         sum.add(last + i - cnt);
        //         last += i - cnt;
        //     }
        //     int m = g.size();
        //     int ans = Integer.MAX_VALUE;
        //     for (int i = 0; i+k <= m; i++) {
        //         int mid = (i + i + k - 1) / 2;
        //         int q = g.get(mid);
        //         ans = Math.min(ans, (2*(mid-i)-k+1) * q + sum.get(i+k) - sum.get(mid+1) - sum.get(mid) + sum.get(i));
        //     }
        //     return ans;
        // }

        // public int minTrioDegree(int n, int[][] edges) { // tle 
        //     Map<Integer, List<Integer>> adj = new HashMap<>();
        //     for (int [] e : edges) {
        //         adj.computeIfAbsent(e[0], z -> new ArrayList<>()).add(e[1]);
        //         adj.computeIfAbsent(e[1], z -> new ArrayList<>()).add(e[0]);
        //     }
        //     boolean [] vis = new boolean [n+1];
        //     int min = Integer.MAX_VALUE;
        //     List<Integer> l = new ArrayList<>();
        //     for (Map.Entry<Integer, List<Integer>> en : adj.entrySet()) {
        //         int key = en.getKey();
        //         if (vis[key]) continue;
        //         vis[key] = true;
        //         l = adj.get(key);
        //         if (l.size() < 2) continue;
        //         for (int i = 0; i < l.size(); i++) 
        //             for (int j = 1; j < l.size(); j++) {
        //                 if (i == j || vis[l.get(i)] || vis[l.get(j)]) continue;
        //                 if (adj.get(l.get(i)).contains(l.get(j)))
        //                     min = Math.min(min, adj.get(key).size() + adj.get(l.get(i)).size() + adj.get(l.get(j)).size() - 6);
        //             }
        //     }
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }
        // public int minTrioDegree(int n, int[][] edges) {
        //     int maxSize = 401;
        //     boolean [][] arr = new boolean[maxSize][maxSize];
        //     int [] ins = new int[n+1];
        //     for (int i = 0; i < edges.length; i++) {
        //         int x = edges[i][0], y = edges[i][1];
        //         arr[x][y] = true;
        //         arr[y][x] = true;
        //         ins[x]++;
        //         ins[y]++;
        //     }
        //     int res = Integer.MAX_VALUE;
        //     for (int i = 1; i <= n; i++) 
        //         for (int j = i+1; j <= n; j++) 
        //             if (arr[i][j]) 
        //                 for (int k = j+1; k <= n; k++) {
        //                     if (arr[j][k] && arr[i][k])
        //                         res = Math.min(res, ins[i] + ins[j] + ins[k] - 6);
        //                 }
        //     return res == Integer.MAX_VALUE ? -1 : res;
        // }

        // public int calculate(String t) {
        //     int n = t.length(), sign = 1, ans = 0;
        //     char [] s = t.toCharArray();
        //     ArrayDeque<Integer> st = new ArrayDeque<>();
        //     for (int i = 0; i < n; i++) {
        //         char c = s[i];
        //         if (c >= '0') {
        //             int v = 0;
        //             while (i < n && Character.isDigit(s[i])) 
        //                 v = v * 10 + (s[i++] - '0');
        //             ans += sign * v;
        //             --i;
        //         } else if (c == '+') sign = 1;
        //         else if (c == '-') sign = -1;
        //         else if (c == '(') { // 处理这个的时候：数值和全局变量都重置一下
        //             st.offerLast(ans);
        //             st.offerLast(sign);
        //             ans = 0;
        //             sign = 1;
        //         } else if (s[i] == ')') {
        //             ans *= st.pollLast();
        //             ans += st.pollLast();
        //         }
        //     }
        //     return ans;
        // }
        // public int calculate(String t) {
        //     int n = t.length(), sign = 1, ans = 0, v = 0;
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         char c = s[i];
        //         if (c >= '0' && c <= '9') {
        //             v = v * 10 + (c - '0');
        //         } else if (c == '(') {
        //             int j = i, cnt = 0;
        //             for (; i < n; i++) {
        //                 if (s[i] == '(') ++cnt;
        //                 else if (s[i] == ')') --cnt;
        //                 if (cnt == 0) break;
        //             }
        //             v = calculate(t.substring(j+1, i));
        //         }
        //         if (c == '+' || c == '-' || i == n-1) {
        //             ans += sign * v;
        //             v = 0;
        //             sign = (c == '+') ? 1 : -1;
        //         }
        //     }
        //     return ans;
        // }

        // Queue<Integer> lit;
        // Queue<Integer> big;
        // public MedianFinder() {
        //     lit = new PriorityQueue<>((a, b)->b-a); // small: 降序排列
        //     big = new PriorityQueue<>((a, b)->a-b); // big: 升序排列
        // }
        // public void addNum(int num) {
        //     if (lit.size() != big.size()) {
        //         big.offer(num);
        //         lit.offer(big.poll());
        //     } else { // ==
        //         lit.offer(num);
        //         big.offer(lit.poll());
        //     }
        // }
        // public double findMedian() {
        //     if (lit.size() == big.size()) return (lit.peek() + big.peek()) / 2.0;
        //     else if (lit.size() > big.size())
        //         return lit.peek();
        //     else return big.peek();
        // }

        // public String shortestPalindrome(String t) { 
        //     // if (t.chars().distinct().count() == 1) return t;
        //     // if (isPalindrome(t)) return t; // 这种提前的判断也会耽误时间
        //     int n = t.length(), j = 0;
        //     char [] s = t.toCharArray();
        //     for (int i = n-1; i >= 0; i--) // 精髓就在这两行
        //         if (s[i] == s[j]) j++;     // 
        //     if (j == n) return t;
        //     String suf = t.substring(j);
        //     System.out.println("suf: " + suf);
        //     return new StringBuilder (suf).reverse().toString() + shortestPalindrome(t.substring(0, j)) + suf;
        // }
        // public String shortestPalindrome(String t) { // 这个方法比上面的一个方法要慢
        //     String s = new StringBuilder (t).reverse().toString();
        //     s = t + "#" + s; // 原串 + “#” + 反转串
        //     int n = t.length(), m = s.length(), j = 0;
        //     int [] p = new int [m];
        //     for (int i = 1; i < m; i++) {
        //         int k = p[i-1];
        //         while (k > 0 && s.charAt(k) != s.charAt(i)) k = p[k-1];
        //         k += (s.charAt(i) == s.charAt(k) ? 1 : 0);
        //         p[i] = k;
        //     }
        //     return s.substring(n+1, 2 * n + 1 - p[m-1]) + t;
        // }
        // public String shortestPalindrome(String s) {
        //     int n = s.length();
        //     int base = 131, mod = 1000000007;
        //     int left = 0, right = 0, mul = 1;
        //     int best = -1;
        //     for (int i = 0; i < n; ++i) {
        //         left = (int) (((long) left * base + s.charAt(i)) % mod);
        //         right = (int) ((right + (long) mul * s.charAt(i)) % mod);
        //         if (left == right) best = i;
        //         mul = (int) ((long) mul * base % mod);
        //     }
        //     String add = (best == n - 1 ? "" : s.substring(best + 1));
        //     StringBuffer ans = new StringBuffer(add).reverse();
        //     ans.append(s);
        //     return ans.toString();
        // }
        // public String shortestPalindrome(String s) {
        //     int n = s.length();
        //     int[] fail = new int[n]; // 
        //     Arrays.fill(fail, -1);
        //     for (int i = 1; i < n; ++i) {
        //         int j = fail[i - 1];
        //         while (j != -1 && s.charAt(j + 1) != s.charAt(i)) 
        //             j = fail[j];
        //         if (s.charAt(j + 1) == s.charAt(i)) 
        //             fail[i] = j + 1;
        //     }
        //     int best = -1;
        //     for (int i = n - 1; i >= 0; --i) {
        //         while (best != -1 && s.charAt(best + 1) != s.charAt(i)) 
        //             best = fail[best];
        //         if (s.charAt(best + 1) == s.charAt(i)) 
        //             ++best;
        //     }
        //     String add = (best == n - 1 ? "" : s.substring(best + 1));
        //     StringBuffer ans = new StringBuffer(add).reverse();
        //     ans.append(s);
        //     return ans.toString();
        // }

    // TreeSet<Range> ts;
    // public SummaryRanges() {
    //     // ts = new TreeSet<>((a, b)->a.l != b.l ? a.l - b.l : a.r - b.r); // BUG: ?!!!
    //     ts = new TreeSet<>((a, b)->a.l - b.l); // 居然是这个东西不能写得太详细了？！！！
    //     // ts = new TreeSet<>();
    // }
    // public void addNum(int val) {
    //     Range cur = new Range(val, val);
    //     Range lo = ts.floor(cur);
    //     Range hi = ts.ceiling(cur);
    //     if (lo != null && lo.r + 1 >= val) {
    //         cur.l = lo.l;
    //         cur.r = Math.max(val, lo.r); //
    //         ts.remove(lo);
    //     } 
    //     if (hi != null && val == hi.l - 1) {
    //         cur.r = hi.r;
    //         ts.remove(hi);
    //     }
    //     ts.add(cur);
    // }
    // public int[][] getIntervals() {
    //     int [][] ans = new int [ts.size()][2];
    //     int i = 0;
    //     for (Range r : ts) {
    //         ans[i][0] = r.l;
    //         ans[i][1] = r.r;
    //         i++;
    //     }
    //     return ans;
    // }
    // class Range {
    //     // class Range implements Comparable<Range> {
    //     int l, r;
    //     public Range(int l, int r) {
    //         this.l = l;
    //         this.r = r;
    //     }
    //     // @Override public int compareTo(Range o) {
    //     //     return this.l - o.l;
    //     // }
    // }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        
        List<Integer> r = s.countSmaller(a);
        System.out.println("r.size(): " + r.size());
        System.out.println(Arrays.toString(r.toArray()));
    }
}
// TreeNd root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.lvlPrintTree(root);