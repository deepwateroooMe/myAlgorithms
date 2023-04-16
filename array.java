import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class array {
    public static class Solution {

        // public int countDifferentSubsequenceGCDs(int[] a) {
        //     int n = a.length, N = Arrays.stream(a).max().getAsInt()+1, ans = 0;
        //     int [] vis = new int [N];
        //     for (Integer v : a) vis[v] = 1;
        //     for (int i = 1; i < N; i++) { // 计算i是否为某子序列的最大公约数
        //         int gcdNum = 0;
        //         for (int j = i; j < N; j += i) { // 寻找i的倍数
        //             if (vis[j] == 1) {
        //                 if (gcdNum == 0)
        //                     gcdNum = j;
        //                 else gcdNum = getGCD(j, gcdNum); // 记录当前遍历到i倍数的最大公约数
        //                 if (gcdNum == i) { // i可以为最大公约数，添加答案
        //                     ans++;
        //                     break;
        //                 }
        //             }
        //         }
        //     }
        //     return ans;
        // }
        // private int getGCD(int x, int y) { //  求最大公约数，默认 x > y
        //     int c;
        //     while (y > 0) {
        //         c = x % y;
        //         x = y;
        //         y = c;
        //     }
        //     return x;
        // }

        // private double [] findCenter(int [] a, int [] b, double r) {
        //     double [] u = new double [] {a[0], a[1]};
        //     double [] v = new double [] {b[0], b[1]};
        //     double [] m = new double [2], ans = new double [2];
        //     m[0] = (u[0] + v[0]) / 2.0;
        //     m[1] = (u[1] + v[1]) / 2.0;
        //     double angle = Math.atan2(u[0] - v[0], v[1] - u[1]);
        //     double d = Math.sqrt(r*r - Math.pow(u[0] - m[0], 2) - Math.pow(u[1] - m[1], 2));
        //     ans[0] = m[0] + d * Math.cos(angle);
        //     ans[1] = m[1] + d * Math.sin(angle);
        //     return ans;
        // }
        // public int numPoints(int[][] points, int r) {
        //     int n = points.length, max = 1, cnt;
        //     if (n < 2) return n;
        //     for (int i = 0; i < n; i++) {
        //         int [] u = points[i];
        //         for (int j = i+1; j < n; j++) {
        //             int [] v = points[j];
        //             if (Math.abs(u[0] - v[0]) - 2 * r > 0 || Math.abs(u[1] - v[1]) - 2 * r > 0) continue;
        //             if (Math.pow(u[0] - v[0], 2) + Math.pow(u[1] - v[1], 2) > 4 * r * r) continue;
        //             cnt = 2;
        //             double [] o = findCenter(u, v, (double)r);
        //             for (int k = 0; k < n; k++) {
        //                 if (k == i || k == j) continue;
        //                 int [] w = points[k];
        //                 if (Double.compare(Math.abs(w[0] - o[0]), r) > 0 || Double.compare(Math.abs(w[1] - o[1]), r) > 0) continue;
        //                 if (Math.pow(Math.abs(w[0] - o[0]), 2) + Math.pow(Math.abs(w[1] - o[1]), 2) > (double)r * r) continue;
        //                 cnt++;
        //             }
        //             max = Math.max(max, cnt);
        //         }
        //     }
        //     return max;
        // }

        // public int findMinMoves(int[] a) {
        //     int n = a.length;
        //     int [] sum = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         sum[i] = sum[i-1] + a[i-1];
        //     if (sum[n] % n != 0) return -1;
        //     int avg = sum[n] / n, ans = 0;
        //     for (int i = 0; i < n; i++) {
        //         int l = i * avg - sum[i];
        //         int r = (n - (i+1)) * avg - (sum[n] - sum[i+1]);
        //         if (l > 0 && r > 0)
        //             ans = Math.max(ans, l + r);
        //         else ans = Math.max(ans, Math.max(Math.abs(l), Math.abs(r)));
        //     }
        //     return ans;
        // }
        // public int findMinMoves(int[] a) {
        //     int n = a.length, sum = Arrays.stream(a).sum(), avg = sum / n;
        //     if (sum % n != 0) return -1;
        //     int ans = 0, cnt = 0;
        //     for (Integer v : a) {
        //         cnt += v - avg;
        //         ans = Math.max(ans, Math.max(Math.abs(cnt), v-avg));
        //     }
        //     return ans;
        // }

        // public int [][] outerTrees(int [][] trees) {
        //     Set<int []> hull = new HashSet<>();
        //     if (trees.length < 4) {
        //         hull.addAll(Arrays.asList(trees));
        //         int [][] res = new int[hull.size()][2];
        //         int index = 0;
        //         for (int [] h : hull) {
        //             res[index] = h;
        //             index++;
        //         }
        //         return res;
        //     }
        //     int leftMost = 0;
        //     for (int i = 0; i < trees.length; i++) 
        //         if (trees[i][0] < trees[leftMost][0]) 
        //             leftMost = i;
        //     int p = leftMost;
        //     do {
        //         int q = (p + 1) % trees.length;
        //         for (int i = 0; i < trees.length; i++) 
        //             if (orientation(trees[p], trees[i], trees[q]) < 0) 
        //                 q = i;
        //         for (int i = 0; i < trees.length; i++) 
        //             if (i != p && i != q && orientation(trees[p], trees[i], trees[q]) == 0 && inBetween(trees[p], trees[i], trees[q])) 
        //                 hull.add(trees[i]);
        //         hull.add(trees[q]);
        //         p = q;
        //     } while (p != leftMost);
        //     int [][] res = new int[hull.size()][2];
        //     int index = 0;
        //     for (int [] h : hull) {
        //         res[index] = h;
        //         index++;
        //     }
        //     return res;
        // }
        // public int orientation(int [] p, int [] q, int [] r) {
        //     return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
        // }
        // public boolean inBetween(int [] p, int [] i, int [] q) {
        //     boolean a = i[0] >= p[0] && i[0] <= q[0] || i[0] <= p[0] && i[0] >= q[0];
        //     boolean b = i[1] >= p[1] && i[1] <= q[1] || i[1] <= p[1] && i[1] >= q[1];
        //     return a && b;
        // }
        // public int[][] outerTrees(int[][] trees) { // O(NlogN) 扫描线法
        //     if (trees.length <= 1) return trees;
        //     int[] bm = bottomLeft(trees);
        //     Arrays.sort(trees, (o1, o2) -> {
        //             double diff = orientation(bm, o1, o2) - orientation(bm, o2, o1);
        //             if (diff == 0) return distance(bm, o1) - distance(bm, o2);
        //             else return diff > 0 ? 1 : -1;
        //         });
        //     int i = trees.length - 1;
        //     while (i >= 0 && orientation(bm, trees[trees.length - 1], trees[i]) == 0) 
        //         i--;
        //     for (int l = i + 1, h = trees.length - 1; l < h; l++, h--) {
        //         int[] temp = trees[l];
        //         trees[l] = trees[h];
        //         trees[h] = temp;
        //     }
        //     Stack<int[]> stack = new Stack<>();
        //     stack.push(trees[0]);
        //     stack.push(trees[1]);
        //     for (int j = 2; j < trees.length; j++) {
        //         int[] top = stack.pop();
        //         while (orientation(stack.peek(), top, trees[j]) > 0) 
        //             top = stack.pop();
        //         stack.push(top);
        //         stack.push(trees[j]);
        //     }
        //     int[][] res = new int[stack.size()][2];
        //     int index = 0;
        //     for (int[] tree : stack) {
        //         res[index] = tree;
        //         index++;
        //     }
        //     return res;
        // }
        // public int orientation(int[] p, int[] q, int[] r) {
        //     return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
        // }
        // public int distance(int[] p, int[] q) {
        //     return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
        // }
        // private int[] bottomLeft(int[][] points) { // 找一个y值最小的点作为左下角的起始点
        //     int[] bottomLeft = points[0];
        //     for (int[] p : points) 
        //         if (p[1] < bottomLeft[1]) 
        //             bottomLeft = p;
        //     return bottomLeft;
        // }

        // public int[] recoverArray(int n, int[] sums) {
        //     int offset = Math.min(0, Arrays.stream(sums).min().getAsInt());
        //     offset = -offset;
        //     TreeMap<Integer, Integer> m = new TreeMap<>(); // java没有multiset，使用TreeMap代替 {子集和: 出现的次数}，次数为0则删除掉
        //     for (Integer v : sums) {
        //         v += offset;
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //     }
        //     m.put(0, m.get(0) - 1); // 先（试图）移除空子集0: 后面会统一移除
        //     int [] dp = new int [1 << n]; // 状态压缩，存储已移除掉的子集，初始化dp[0]=0可省略
        //     int [] ans = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         // 延迟删除策略，最小值次数为0，则抛弃掉此最小值
        //         while (m.firstEntry().getValue() == 0) m.pollFirstEntry(); 
        //         ans[i] = m.firstKey();
        //         for (int mask = 0; mask < 1 << i; mask++) {
        //             dp[mask | 1 << i] = dp[mask] + ans[i];
        //             m.put(dp[mask | 1 << i], m.get(dp[mask | 1 << i]) - 1); // 减少cnt，为的是接下来的移除
        //         }
        //     }
        //     for (int mask = 0;; ++mask)
        //         if (dp[mask] == offset) {
        //             for (int i = 0; i < n; i++)
        //                 if ((mask & 1 << i) != 0)
        //                     ans[i] = -ans[i];
        //             return ans;
        //         }
        // }

        // public int minSubarray(int[] a, int p) { 
        //     // int n = a.length, ans = n, sum = Arrays.stream(a).sum() % p; // BUG: overflow
        //     int n = a.length, ans = n, sum = 0;
        //     for (int v : a)
        //         sum = (sum + v) % p;
        //     if (sum == 0) return 0;
        //     Map<Integer, Integer> m = new HashMap<>(); // residual, idx
        //     m.put(0, 0);
        //     for (int i = 0, v = 0; i < n; i++) {
        //         v = (v + a[i]) % p;
        //         int key = (v - sum + p) % p;
        //         if (m.containsKey(key)) {
        //             int l = m.get(key);
        //             ans = Math.min(ans, i+1-l);
        //         }
        //         m.put(v, i+1);
        //     }
        //     return ans == n ? -1 : ans;
        // }

        // public int[][] onesMinusZeros(int[][] a) {
        //     int m = a.length, n = a[0].length;
        //     int [] r = new int [m], c = new int [n];
        //     int [][] d = new int [m][n];
        //     for (int i = 0; i < m; i++) r[i] = Arrays.stream(a[i]).sum();
        //     for (int j = 0; j < n; j++) 
        //         for (int i = 0; i < m; i++) c[j] += a[i][j];
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++)
        //             d[i][j] = r[i] + c[j] - (n - r[i]) - (m - c[j]);
        //     return d;
        // }

        // public int findTheWinner(int n, int k) {
        //     boolean [] r = new boolean [n];
        //     int cnt = n, i = 0, curCnt = 0;
        //     while (cnt > 1) {
        //         curCnt = 0;
        //         while (curCnt < k) {
        //             while (!r[i] && curCnt < k) {
        //                 curCnt++;
        //                 if (curCnt == k) break;
        //                 i++;
        //                 if (i == n) i = 0;
        //             }
        //             while (r[i]) {
        //                 i++;
        //                 if (i == n) i = 0;
        //             }
        //         }
        //         cnt--;
        //         r[i] = true;
        //     }
        //     for (i = 0; i < n; i++) if (!r[i]) return i + 1;
        //     return -1;
        // }

        // public int[] deckRevealedIncreasing(int[] a) { // TODO TODO 
        //     int n = a.length, r [] = new int [n];
        //     Set<Integer> s = new TreeSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     r[0] = Arrays.stream(a).min().getAsInt();
        //     s.remove(r[0]);
        //     for (int i = 2; i < n; i += 2) {
        //         r[i] = s.first();
        //         s.remove(r[i]);
        //     }
        //     // 后面的几个不知道怎么填了。。。
        // }

        // public List<List<Integer>> queensAttacktheKing(int[][] a, int[] k) {
        //     int n = 8, i = k[0], j = k[1];
        //     int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},
        //                      {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        //     Set<Integer> s = new HashSet<>();
        //     for (int [] v : a) 
        //         s.add(v[0] * n + v[1]);
        //     List<List<Integer>> r = new ArrayList<>();
        //     for (int [] d : dirs) {
        //         int x = i + d[0], y = j + d[1];
        //         if (x < 0 || x >= n || y < 0 || y >= n) continue;
        //         while (x >= 0 && x < n && y >= 0 && y < n && !s.contains(x*n+y)) {
        //             x += d[0];
        //             y += d[1];
        //         }
        //         if (x >= 0 && x < n && y >= 0 && y < n && s.contains(x*n+y)) { // 每个方向上，只有第一个出面的，可以直接攻击 
        //             r.add(List.of(x, y));
        //             s.remove(x*n + y);
        //             continue;
        //         }
        //     }
        //     return r;
        // }

        // int idx, discnt, m, n;
        // Map<Integer, Integer> prices = new HashMap<>();
        // public Cashier(int n, int discount, int[] products, int[] prices) {
        //     idx = 0;
        //     m = products.length;
        //     discnt = discount;
        //     this.n = n;
        //     for (int i = 0; i < m; i++) 
        //         this.prices.put(products[i], prices[i]);
        // }
        // public double getBill(int[] product, int[] amount) {
        //     idx++;
        //     double ans = 0;
        //     for (int i = 0; i < product.length; i++) {
        //         if (idx % n == 0) 
        //             ans += (double)prices.get(product[i]) * amount[i] * (100 - discnt) / 100;
        //         else ans += (double)prices.get(product[i]) * amount[i];
        //     }
        //     return ans;
        // }

        // public int numTimesAllBlue(int[] a) {
        //     int n = a.length, r = 0, s = 0, i = 0, d = 0;
        //     for (int v : a) {
        //         s += v;
        //         ++i;
        //         d += i;
        //         if (s == d) r++;
        //     }
        //     return r;
        // }

        // public char[][] rotateTheBox(char[][] a) { // TODO TODO TODO 
        //     int m = a.length, n = a[0].length;
        //     char [][] r = new [n][m];
        //     for (int i = m-1; i >= 0; i--) {
        //         int j = n-1;
        //         while (j >= 0) {
        //             while (j >= 0 && a[])                     
        //         }
        //     }
        // }

        // public int matchPlayersAndTrainers(int[] a, int[] b) {
        //     int m = a.length, n = b.length, i = 0, j = 0, r = 0;
        //     Arrays.sort(a);
        //     Arrays.sort(b);
        //     while (j < n && b[j] < a[i]) j++;
        //     if (j == n) return r;
        //     for (i = 0; i < m; i++) { 
        //         while (j < n && b[j] < a[i]) j++;
        //         if (j == n) return r;
        //         if (a[i] <= b[j]) {
        //             if (j == n) return r;
        //             r++;
        //             j++;
        //         }
        //     }
        //     return r;
        // }

        // public List<String> twoEditWords(String[] a, String[] b) { // aaaaaaaa 32/33 passed 
        //     int n = a.length;
        //     m = a[0].length();
        //     List<String> r = new ArrayList<>();
        //     for (var s : a) 
        //         for (var t : b) 
        //             if (check(s, t) && (r.size() == 0 || !r.get(r.size()-1).equals(s))) r.add(s);
        //     return r;
        // }
        // int m;
        // boolean check(String S, String T) {
        //     char [] s = S.toCharArray();
        //     char [] t = T.toCharArray();
        //     int i = 0, r = 0;
        //     while (i < m) {
        //         while (i < m && s[i] == t[i]) i++;
        //         if (i < m) {
        //             r++;
        //             i++;
        //         }
        //     }
        //     return r <= 2;
        // }

        // public long dividePlayers(int[] a) {
        //     int n = a.length, i = 0, j = n-1, sum = Arrays.stream(a).sum();
        //     Arrays.sort(a);
        //     if (sum % (n / 2) != 0) return -1;
        //     int s = a[i] + a[j];
        //     long r = a[i++] * a[j--];
        //     while (i < j) {
        //         if (a[i] + a[j] == s) 
        //             r += a[i++] * a[j--];
        //         else return -1;
        //     }
        //     return r;
        // }

        // public String largestWordCount(String[] a, String[] b) {
        //     int n = a.length;
        //     Map<String, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         int v = a[i].split(" ").length;
        //         m.put(b[i], m.getOrDefault(b[i], 0) + v);
        //     }
        //     int max = 0;
        //     String r = "";
        //     for (Map.Entry<String, Integer> en : m.entrySet()) 
        //         if (en.getValue() >= max) {
        //             if (r.equals("") || r.compareTo(en.getKey()) > 0) r = en.getKey(); // 这里不知道大写字母是否是排在前面的
        //             max = en.getValue();
        //         }
        //     return r;
        // }

        // public int findMinArrowShots(int[][] a) { // 这里好像是要用一个差分数组：或者是感觉线段树更像。。。
        //     int n = a.length;
        //     if (n == 0) return 0;
        //     Arrays.sort(a, new Comparator<int []>() {
        //             public int compare(int [] x, int [] y) {
        //                 if (x[1] > y[1]) return 1;
        //                 else if (x[1] < y[1]) return -1;
        //                 return 0;
        //             }
        //         });
        //     // Arrays.sort(a, (x, y) -> x[1] - y[1]); // 【这么写不对！！！】
        //     int pos = a[0][1]; // 当前的箭，最远可以向右偏移的距离
        //     int r = 1;
        //     for (int [] v : a) 
        //         if (v[0] > pos) { // 接上不，必须再发一玫箭！！！
        //             pos = v[1];
        //             ++r;
        //         }
        //     return r;
        // }

        // public int maxConsecutive(int l, int r, int[] a) {
        //     int n = a.length, i = l, max = 0;
        //     Arrays.sort(a);
        //     for (int v : a) {
        //         int cur = v - i;
        //         max = Math.max(max, cur);
        //         i = v+1;
        //     }
        //     if (r > a[n-1]) max = Math.max(max, r - a[n-1]);
        //     return max;
        // }

        // // 先把 b 带下标排序一下，再把 a 排序，把 a 必要的话，向左偏移一下，再把偏移后的 a 按了下标重排回正确的位置【可是感觉不想写】
        // public int[] advantageCount(int[] a, int[] b) {
        //     int n = a.length;
        //     Integer l [] = new Integer [n], r [] = new Integer [n];
        //     for (int i = 0; i < n; i++) {
        //         l[i] = i;
        //         r[i] = i;
        //     }
        //     Arrays.sort(l, (x, y) -> a[x] - a[y]); // 这就得到了排序后的两个数组的【从小到大的】下标排序
        //     Arrays.sort(r, (x, y) -> b[x] - b[y]);
        //     int [] ans = new int [n];
        //     int i = 0, j = n-1; // 排序后数组 b 的左右指针
        //     for (int k = 0; k < n; k++) 
        //         if (a[l[k]] > b[r[i]]) { // 贪心思想：当前 Ak 可用，用上
        //             ans[r[i]] = a[l[k]];
        //             ++i;
        //         } else { // 当前 Ak 不可用，放后面去配对 Bj 里相对大数的部分
        //             ans[r[j]] = a[l[k]];
        //             --j;
        //         }
        //     return ans;
        // }

        // public int largestMagicSquare(int[][] a) {
        //     m = a.length;
        //     n = a[0].length;
        //     r = new int [m][n];
        //     c = new int [m][n];
        //     for (int i = 0; i < m; i++) r[i][0] = a[i][0];
        //     for (int j = 0; j < n; j++) c[0][j] = a[0][j];
        //     for (int j = 1; j < n; j++)
        //         for (int i = 0; i < m; i++) 
        //             r[i][j] = r[i][j-1] + a[i][j];
        //     for (int i = 1; i < m; i++)
        //         for (int j = 0; j < n; j++)
        //             c[i][j] = c[i-1][j] + a[i][j];
        //     for (int d = Math.min(m, n); d > 0; d--) {// 从最大宽度往小遍历
        //         for (int i = 0; i + d <= m; i++)
        //             for (int j = 0; j + d <= n; j++) { // 以【 i,j 】为左上顶点，宽度为 d
        //                 if (checkIJD(i, j, d, a)) return d;
        //             }
        //     }
        //     return 1;
        // }
        // int m, n;
        // int [][] r, c;
        // boolean checkIJD(int i, int j, int d, int [][] a) {
        //     // 检查行、列、对角线的和是否相等
        //     int sum = r[i][j+d-1] - (j == 0 ? 0 : r[i][j-1]), cur = 0;
        //     System.out.println("sum: " + sum);
        //     for (int x = i+1; x < i+d; x++)
        //         if (r[x][j+d-1] - (j == 0 ? 0 : r[x][j-1]) != sum) return false;
        //     for (int y = j; y < j+d; y++)
        //         if (c[i+d-1][y] - (i == 0 ? 0 : c[i-1][y]) != sum) return false;
        //     for (int x = 0; x < d; x++)
        //         cur += a[i+x][j+x];
        //     if (cur != sum) return false;
        //     cur = 0;
        //     for (int x = 0; x < d; x++)
        //         cur += a[i+x][j+d-x-1];
        //     if (cur != sum) return false;
        //     return true;
        // }

        // public int longestNiceSubarray(int[] a) { // 【不知道哪里边边角角的地主错了，改天再写 TODO TODO TODO 】
        //     n = a.length;
        //     int l = 1, r = 30, ans = 1;
        //     while (l <= r) {
        //         int m = (l + r) >> 1;
        //         System.out.println("\n m: " + m);
        //         if (check(m, a)) {
        //             ans = Math.max(ans, m);
        //             l = m + 1;
        //         } else r = m-1;
        //     }
        //     return ans;
        // }
        // int n;
        // boolean check(int v, int [] a) {
        //     int i = 0, j = 0, mask = 0;
        //     for (i = 0; i < n; i++) {
        //         if ((mask & a[i]) > 0) {
        //             if (i - j >= v) return true;
        //             while (j < i && (a[i] & a[j]) == 0) j++;
        //             if (j < i && (a[i] & a[j]) > 0) {
        //                 mask ^= a[j];
        //                 j++;
        //             }
        //             if (j < i && (mask & a[i]) == 0)
        //                 mask |= a[i];
        //             else if (j == i) mask = a[i];
        //         } else
        //             mask |= a[i];
        //     }
        //     if (i == n && i - j >= v) return true;
        //     return false;
        // }
        // int [] a = new int [] {178830999,19325904,844110858,806734874,280746028,64,256,33554432,882197187,104359873,453049214,820924081,624788281,710612132,839991691};
    }
    public static void main(String[] args) {
        Solution s  =  new Solution();

        int r = s.longestNiceSubarray(a);
        System.out.println("r: " + r);
    }
} // 不想再写这些数组了，写得太没意思了，看点儿别的。。。
