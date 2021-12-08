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

        public int[] canSeePersonsCount(int[] a) {
            int n = a.length, ans [] = new int [n];
            ans[n-2] = 1;
            if (n == 2) return ans;
            ArrayDeque<Integer> s = new ArrayDeque<>();
            s.offerLast(n-1);
            s.offerLast(n-2);
            for (int i = n-3; i >= 0; i--) {
                
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{1,3},{2,5},{3,7}};

        List<Boolean> r = s.areConnected(7, 2, a);
        System.out.println("r.size(): " + r.size());
        System.out.println(Arrays.toString(r.toArray()));
    }
}
// TreeNd root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.lvlPrintTree(root);









