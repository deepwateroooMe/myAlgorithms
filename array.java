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


    }
    public static void main(String[] args) {
        Solution s  =  new Solution();

        // int [] a = new int [] {6,3,5,2};
        int []  a = new int []  {1000000000, 1000000000, 1000000000};

        int r = s.minSubarray(a, 3);
        System.out.println("r: " + r);
    }
}