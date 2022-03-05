// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toMap;

public class hdeight {
    public static class Solution {

        // public double [] getCollisionTimes(int[][] a) {
        //     int n = a.length;
        //     double [] ans = new double [n];
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     Arrays.fill(ans, -1.0);
        //     for (int i = n-1; i >= 0; i--) {
        //         while (!s.isEmpty()) {
        //             if (a[s.peekLast()][1] >= a[i][1] // 栈顶车速比当前车速快
        //                 // 栈顶车速慢，但当前车与栈顶车相遇前，栈顶车早已经与其它车合并过了
        //                 || (ans[s.peekLast()] > 0 && (double)(a[s.peekLast()][0] - a[i][0]) / (a[i][1] - a[s.peekLast()][1]) > ans[s.peekLast()]))
        //                 s.pollLast();
        //             else break;
        //         }
        //         if (!s.isEmpty())
        //             ans[i] = (double)(a[s.peekLast()][0] - a[i][0]) / (a[i][1] - a[s.peekLast()][1]);
        //         s.offerLast(i);
        //     }
        //     return ans;
        // }

        // public int[] minInterval(int[][] intervals, int[] que) {
        //     int m = intervals.length, n = que.length;
        //     int [][] q = new int [n][2];
        //     for (int i = 0; i < n; i++) 
        //         q[i] = new int [] {i, que[i]};
        //     Arrays.sort(q, (x, y) -> x[1] - y[1]);
        //     int [] ans = new int [n];
        //     Arrays.fill(ans, -1);
        //     Arrays.sort(intervals, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); // 这里的排序
        //     Queue<int []> queue = new PriorityQueue<>((x, y) -> x[1]-x[0] - (y[1] - y[0]));
        //     int idx = 0;
        //     for (int i = 0; i < n; i++) {
        //         while (idx < m && intervals[idx][0] <= q[i][1]) {
        //             queue.offer(intervals[idx]);
        //             idx++;
        //         }
        //         while (!queue.isEmpty() && queue.peek()[1] < q[i][1]) queue.poll();
        //         if (!queue.isEmpty()) {
        //             int [] cur = queue.peek();
        //             ans[q[i][0]] = cur[1] - cur[0] + 1;
        //         }
        //     }
        //     return ans;
        // }

        // public int waysToPartition(int[] a, int k) { // BUG: 没休息好。。。。。。
        //     int n = a.length;
        //     long [] pre = new long [n], suf = new long [n];
        //     for (int i = 0; i < n; i++) 
        //         pre[i] = (i == 0 ? 0 : pre[i-1]) + a[i];
        //     for (int i = n-1; i >= 0; i--)
        //         suf[i] = (i == n-1 ? 0 : suf[i+1]) + a[i];
        //     // System.out.println(Arrays.toString(a));
        //     // System.out.println(Arrays.toString(pre));
        //     // System.out.println(Arrays.toString(suf));
        //     Map<Integer, Integer> r = new HashMap<>(), l = new HashMap<>();
        //     // Map<Integer, Integer> l = new HashMap<>();
        //     for (int i = 1; i < n; i++)
        //         r.put(a[i], r.getOrDefault(a[i], 0) + 1);
        //     // System.out.println("r.size(): " + r.size());
        //     // for (Map.Entry<Integer, Integer> en : r.entrySet()) 
        //     //     System.out.print(en.getKey() + ", " + en.getValue() + "\n");
        //     l.put(a[0], 1);
        //     System.out.println("l.size(): " + l.size());
        //     for (Map.Entry<Integer, Integer> en : l.entrySet()) 
        //         System.out.print(en.getKey() + ", " + en.getValue() + "\n");
        //     int ans = 0;
        //     for (int i = 1; i < n; i++) {
        //         // System.out.println("\n i: " + i);
        //         // System.out.println("(pre[i-1] == suf[i]): " + (pre[i-1] == suf[i]));
        //         // System.out.println("(r.containsKey(suf[i] - pre[i-1] + k) || l.containsKey(pre[i-1] - suf[i] + k)) : " + (r.containsKey((int)(suf[i] - pre[i-1] + k)) || l.containsKey(pre[i-1] - suf[i] + k)) );
        //         // System.out.println("l.containsKey(pre[i-1] - suf[i] + k): " + l.containsKey((int)(pre[i-1] - suf[i] + k)));
        //         // System.out.println("suf[i] - pre[i-1] + k: " + (suf[i] - pre[i-1] + k));
        //         // System.out.println("pre[i-1] - suf[i] + k: " + (pre[i-1] - suf[i] + k));
        //         // System.out.println("l.size(): " + l.size());
        //         // for (Map.Entry<Integer, Integer> en : l.entrySet()) 
        //         //     System.out.print(en.getKey() + ", " + en.getValue() + "\n");
        //         // if (pre[i-1] == suf[i] || i == 1 && (long)(pre[0] + k - a[0]) == suf[1]) {
        //         if (pre[i-1] == suf[i]) {
        //             ans++;
        //         // } else if (l.containsKey((int)(pre[i-1] - suf[i] + k))) 
        //             } else if (r.containsKey((int)(suf[i] - pre[i-1] + k)) || l.containsKey((int)(pre[i-1] - suf[i] + k))) 
        //             ans ++;
        //         r.put(a[i], r.get(a[i])-1);
        //         if (r.get(a[i]) == 0) r.remove(a[i]);
        //         l.put(a[i], l.getOrDefault(a[i], 0) + 1);
        //         System.out.println("ans: " + ans);
        //     }
        //     return ans;
        // }

        // public int[][] validArrangement(int[][] pa) {
        //     Map<Integer, Integer> ins = new HashMap<>();
        //     for (int [] p : pa) {
        //         adj.computeIfAbsent(p[0], z -> new ArrayList<>()).add(p[1]);
        //         ins.put(p[0], ins.getOrDefault(p[0], 0) + 1); // 这里的入度，与拓扑排序中入度不一样
        //         ins.put(p[1], ins.getOrDefault(p[1], 0) - 1); // 这里，更严格地说，应该是 出度
        //     }
        //     int bgn = -1;
        //     for (int k : ins.keySet())
        //         if (ins.get(k) > 0) {
        //             bgn = k;
        //             break;
        //         }
        //     if (bgn == -1) bgn = pa[0][0]; // 如果没有，形成的将是一个环路，那么从什么地方开始都可以的、没有区别
        //     dfs(bgn);
        //     int n = pa.length;
        //     int [][] ans = new int [n][];
        //     for (int i = n-1; i >= 0; i--)
        //         ans[n-1-i] = ll.get(i);
        //     return ans;
        // }
        // Map<Integer, List<Integer>> adj = new HashMap<>();
        // List<int []> ll = new ArrayList<>();
        // void dfs(int u) {
        //     while (adj.get(u) != null && adj.get(u).size() > 0) {
        //         List<Integer> next = adj.get(u);
        //         int v = next.get(next.size()-1);
        //         adj.get(u).remove(next.size()-1); // 实时更新图中数据
        //         dfs(v);
        //         ll.add(new int [] {u, v}); // dfs完之后再加这个，是从遍历过的最尾巴加到最开始遍历的，顺序是反着的
        //     }
        // }

        // public int maximalPathQuality(int[] val, int[][] edges, int maxTime) {
        //     int n = val.length;
        //     for (int [] e : edges) {
        //         adj.computeIfAbsent(e[0], z -> new ArrayList<>()).add(new int [] {e[1], e[2]});
        //         adj.computeIfAbsent(e[1], z -> new ArrayList<>()).add(new int [] {e[0], e[2]});
        //     }
        //     dp = new Integer [n][maxTime + 1];
        //     Map<Integer, Integer> map = new HashMap<>();
        //     map.put(0, 1);
        //     return dfs(0, maxTime, map, val);
        // }
        // Map<Integer, List<int []>> adj = new HashMap<>();
        // Integer [][] dp;
        // int dfs(int u, int t, Map<Integer, Integer> m, int [] a) {
        //     if (t < 0) return 0;
        //     if (t == 0) {
        //         if (u == 0) 
        //             return dp[u][t] = a[u];
        //         // m.put(u, m.get(u)-1);
        //         if (m.get(u) == 0) m.remove(u);
        //         return dp[u][t] = Integer.MIN_VALUE;
        //     }
        //     if (dp[u][t] != null) return dp[u][t];
        //     int ans = 0;
        //     for (int [] v : adj.get(u)) {
        //         m.put(v[0], m.getOrDefault(v[0], 0) + 1);
        //         int cur = dfs(v[0], t-v[1], m, a);
        //         if (cur != Integer.MIN_VALUE) {
        //             int sum = 0;
        //             for (Integer key : m.keySet()) 
        //                 sum += a[key];
        //             ans = Math.max(ans, sum);
        //         }
        //         m.put(v[0], m.get(v[0])-1);
        //         if (m.get(v[0]) == 0) m.remove(v[0]);
        //     }
        //     return dp[u][t] = ans;
        // }

        // public int consecutiveNumbersSum(int n) {
        //     int cnt = 1;
        //     for (int i = 2; i < Math.sqrt(2 * n); i++)
        //         if ((n - i * (i - 1)/2) % i == 0) cnt++;
        //     return cnt;
        // }

        // public boolean isGoodArray(int[] a) {
        //     int x = a[0];
        //     for (int v : a) {
        //         x = gcd(x, v);
        //         if (x == 1) return true;
        //     }
        //     return false;
        // }
        // int gcd(int x, int y) {
        //     if (x < y) return gcd(y, x);
        //     if (y == 0) return x;
        //     return gcd(y, x % y);
        // }

        // static final long mod = (int)1e9 + 7;
        // public int numberOfWays(String t) { 
        //     int n = t.length(), sum = 0, cnt = 0;
        //     long ans = 1;
        //     char [] s = t.toCharArray();
        //     for (char v : s) 
        //         sum += v == 'S' ? 1 : 0;
        //     if (sum < 2 || sum % 2 != 0) return 0;
        //     if (sum == 2) return 1;
        //     int i = 0, j = 0;
        //     while (i < n) {
        //         while (i < n && cnt < 2) {
        //             if (s[i] == 'S') cnt++;
        //             i++;
        //         } 
        //         if (i == n) return (int)ans;
        //         j = i; 
        //         while (i < n && s[i] != 'S') i++;
        //         if (i == n) return (int)ans;
        //         ans *= (long)(i - j + 1);
        //         ans %= mod;
        //         cnt = 0;
        //     }
        //     return (int)ans;
        // }
        // static final long mod = (int)1e9 + 7;
        // public int numberOfWays(String s) {
        //     long ans = 1, j = 0, k = 0;
        //     for (int i = 0; i < s.length(); i++) {
        //         if (s.charAt(i) == 'S') {
        //             if (++k > 2 && k % 2 == 1)
        //                 ans = ans * (i - j) % mod;
        //             j = i;
        //         }
        //     }
        //     return k % 2 == 0 && k > 0 ? (int)ans : 0;
        // }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // String a = "SSPPSPS";
        // String a = "SSSPPPSPPSPSSSSSSPPPSPP";
        // String a = "PPPPPSPPSPPSPPPSPPPPSPPPPSPPPPSPPSPPPSPSPPPSPSPPPSPSPPPSPSPPPPSPPPPSPPPSPPSPPPPSPSPPPPSPSPPPPSPSPPPSPPSPPPPSPSPSS";
        String a = "PPPPPPPSPPPSPPPPSPPPSPPPPPSPPPSPPSPPSPPPPPSPSPPPPPSPPSPPPPPSPPSPPSPPPSPPPPSPPPPSPPPPPSPSPPPPSPSPPPSPPPPSPPPPPSPSPPSPPPPSPPSPPSPPSPPPSPPSPSPPSSSS";
        System.out.println("a: " + a);

        int r = s.numberOfWays(a);
        System.out.println("r: " + r);
    }
}
// TreeNd root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.lvlPrintTree(root);

// 1920000000
//  919999993