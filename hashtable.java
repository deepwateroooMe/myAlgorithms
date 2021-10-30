import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class hashtable {
    public static class Solution {

        // public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        //     int [][] arr = new int [n][n];
        //     boolean [][] vis = new boolean[n][n];
        //     for (int i = 0; i < lamps.length; i++) 
        //         for (int j = 0; j < lamps[i].length; j++) {
        //             arr[lamps[i][0]][lamps[i][1]] = 1;
        //             vis[lamps[i][0]][lamps[i][1]] = true;
        //         }
        //     for (int i = 0; i < lamps.length; i++) {
        //         for (int j = 0; j < lamps[i].length; j++) {
        //             if (arr[i][j] == 1 && vis[i][j]) {
        //                 for (int x = 0; x < n; x++) {
        //                     arr[i][x] = 1;
        //                     arr[x][j] = 1;
        //                     arr
        //                 }
        //             } 
        //         }
        //     }
        // }

        
        // public double[] medianSlidingWindow(int[] nums, int k) {
        //     TreeMap<Integer, Integer> ma = new TreeMap<>();
        //     TreeMap<Integer, Integer> mb = new TreeMap<>();
        //     for (int i = 0; i < k; i++) {
        //         if (i % 2 == 0) {
        //             mb.put(nums[i], mb.getOrDefault(nums[i], 0) + 1);
        //             int n = mb.firstKey();
        //             if (mb.get(n) == 1) mb.remove(n);
        //             else mb.put(n, mb.get(n) - 1);
        //             ma.put(n, ma.getOrDefault(n, 0) + 1);
        //         } else {
        //             ma.put(nums[i], ma.getOrDefault(nums[i], 0) + 1);
        //             int n = ma.lastKey();
        //             if (ma.get(n) == 1) ma.remove(n);
        //             else ma.put(n, ma.get(n) - 1);
        //             mb.put(n, mb.getOrDefault(n, 0) + 1);
        //         }
        //     }
        //     double [] res = new double[nums.length-k+1];
        //     if (k % 2 == 1) res[0] = ma.lastKey();
        //     else res[0] =  (double)(((long)(ma.lastKey()) + (long)(mb.firstKey())) / 2.0);
        //     for (int i = 0; i + k < nums.length; i++) {
        //         ma.put(nums[i+k], ma.getOrDefault(nums[i+k], 0) + 1);
        //         int n = ma.lastKey();
        //         if (ma.get(n) == 1) ma.remove(n);
        //         else ma.put(n, ma.get(n) - 1);
        //         mb.put(n, mb.getOrDefault(n, 0) + 1);
        //         if (ma.containsKey(nums[i])) {
        //             if (ma.get(nums[i]) == 1) ma.remove(nums[i]);
        //             else ma.put(nums[i], ma.get(nums[i]) - 1);
        //             int v = mb.firstKey();
        //             if (mb.get(v) == 1) mb.remove(v);
        //             else mb.put(v, mb.get(v) - 1);
        //             ma.put(v, ma.getOrDefault(v, 0) + 1);
        //         } else {
        //             if (mb.get(nums[i]) == 1) mb.remove(nums[i]);
        //             else mb.put(nums[i], mb.get(nums[i]) - 1);
        //         }
        //         if (k % 2 == 1) res[i+1] = ma.lastKey();
        //         else res[i+1] = (double)(((long)(ma.lastKey()) + (long)(mb.firstKey())) / 2.0);
        //     }
        //     return res;
        // }


        // public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        //     Map<Integer, Set<Integer>> m = new HashMap<>();
        //     for (int [] arr : logs) 
        //         m.computeIfAbsent(arr[0], w -> new HashSet<>()).add(arr[1]);
        //     int [] ans = new int [k];
        //     for (Map.Entry<Integer, Set<Integer>> en : m.entrySet()) {
        //         int v = en.getValue().size();
        //         if (v <= k) ans[v-1]++;
        //     }
        //     return ans;
        // }

        // private int cntTarget(int [] arr, int target) {
        //     int cnt = 0, sum = 0;
        //     Map<Integer, Integer> cntMap = new HashMap<>();
        //     cntMap.put(0, 1);
        //     for (int i = 0; i < arr.length; i++) {
        //         sum += arr[i];
        //         cnt += cntMap.getOrDefault(sum - target, 0);
        //         cntMap.compute(sum, (k, v) -> { // 
        //                 if (v == null) v = 0;
        //                 return v+1;
        //             });
        //         return cnt;
        //     }
        // }
        // public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //     int m = matrix.length, n = matrix[0].length, cur = 0;
        //     int [][] sum = new int [m][n]; // sums of row sum only
        //     for (int i = 0; i < m; i++) {
        //         cur = 0;
        //         for (int j = 0; j < n; j++) {
        //             cur += matrix[i][j];
        //             sum[i][j] = cur;
        //         }
        //     }
        //     int cnt = 0;
        //     for (int j = 0; j < n; j++) {
        //         for (int k = j; k < n; k++) {
        //             int [] tmp = new int [m];
        //             for (int i = 0; i < m; i++) 
        //                 tmp[i] = sum[i][k] - (j == 0 ? 0 : sum[i][j-1]);
        //             int oneCnt = cntTarget(tmp, target);
        //             cnt += oneCnt;
        //         }
        //     }
        //     return cnt;
        // }
        // public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //     int m = matrix.length, n = matrix[0].length, rowSum = 0;
        //     int [][] sum = new int [m][n]; // sums of row sum only
        //     for (int i = 0; i < m; i++) {
        //         rowSum = 0;
        //         for (int j = 0; j < n; j++) {
        //             rowSum += matrix[i][j];
        //             sum[i][j] = rowSum + (i == 0 ? 0 : sum[i-1][j]);
        //         }
        //     }
        //     int cnt = 0, cur = 0;
        //     for (int j = 0; j < n; j++)     // col1
        //         for (int k = j; k < n; k++) {// col2
        //             Map<Integer, Integer> map = new HashMap<>(); // 用于记录前缀和个数
        //             for (int i = 0; i < m; i++) {
        //                 cur = sum[i][k] - (j == 0 ? 0 : sum[i][j-1]);
        //                 if (cur == target) ++cnt;
        //                 cnt += map.getOrDefault(cur - target, 0);
        //                 map.put(cur, map.getOrDefault(cur, 0) + 1);
        //             }
        //         }
        //     return cnt;
        // }
        // public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //     int m = matrix.length, n = matrix[0].length;
        //     int [][] sum = new int [m][n+1]; // sums of row sum only
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) 
        //             sum[i][j+1] = sum[i][j] + matrix[i][j];
        //     }
        //     int cnt = 0, cur = 0;
        //     for (int j = 0; j < n; j++)      // col1
        //         for (int k = j; k < n; k++) {// col2
        //             cur = 0;
        //             Map<Integer, Integer> map = new HashMap<>(); // 用于记录前缀和个数
        //             map.put(0, 1);
        //             for (int i = 0; i < m; i++) {
        //                 cur += sum[i][k+1] - sum[i][j];
        //                 cnt += map.getOrDefault(cur - target, 0);
        //                 map.put(cur, map.getOrDefault(cur, 0) + 1);
        //             }
        //         }
        //     return cnt;
        // }

        // public int numSubmatrixSumTarget(int [][] matrix, int target) {
        //     int res = 0, m = matrix.length, n = matrix[0].length;
        //     int [][] sum = new int [m+1][n+1];
        //     for (int i = 1; i <= m; ++i) 
        //         for (int j = 1; j <= n; ++j) 
        //             sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
        //     for (int i = 1; i <= m; ++i) 
        //         for (int j = 1; j <= n; ++j) 
        //             for (int p = 1; p <= i; ++p) 
        //                 for (int q = 1; q <= j; ++q) {
        //                     int t = sum[i][j] - sum[i][q - 1] - sum[p - 1][j] + sum[p - 1][q - 1];
        //                     if (t == target) ++res;
        //                 }
        //     return res;
        // }
        // public int numSubmatrixSumTarget(int [][] matrix, int target) {
        //     int res = 0, m = matrix.length, n = matrix[0].length;
        //     for (int i = 0; i < m; ++i) 
        //         for (int j = 1; j < n; ++j) 
        //             matrix[i][j] += matrix[i][j - 1];
        //     for (int i = 0; i < n; ++i) 
        //         for (int j = i; j < n; ++j) {
        //             Map<Integer, Integer> cntMap = new HashMap<>();
        //             cntMap.put(0, 1);
        //             int cur = 0;
        //             for (int k = 0; k < m; ++k) {
        //                 cur += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
        //                 res += cntMap.getOrDefault(cur-target, 0);
        //                 cntMap.put(cur, cntMap.getOrDefault(cur, 0) + 1);
        //             }
        //         }
        //     return res;
        // }


        // public List<Integer> findDuplicates(int[] arr) {
        //     int n = arr.length;
        //     List<Integer> ans = new ArrayList<>();
        //     Set<Integer> s = new HashSet<>();
        //     for (int v : arr) 
        //         if (!s.add(v)) {
        //             ans.add(v);
        //             s.remove(v);
        //         }
        //     return ans;
        // }


        // public int numSpecialEquivGroups(String[] words) {
        //     int n = words.length;
        //     Map<String, Set<String>> m = new HashMap<>();
        //     for (String s : words) {
        //         int [][] cnt = new int [2][26];
        //         for (int i = 0; i < s.length(); i++) 
        //             if (i % 2 == 0) cnt[0][s.charAt(i)-'a']++;
        //             else cnt[1][s.charAt(i)-'a']++;
        //         String key = "";
        //         for (int j = 0; j < 26; j++) 
        //             if (cnt[0][j] > 0) key += (char)(j+'a') + "" + (cnt[0][j] > 1 ? cnt[0][j] : "");
        //         for (int j = 0; j < 26; j++) 
        //                 if (cnt[1][j] > 0) key += (char)(j+'a') + "" + (cnt[1][j] > 1 ? cnt[1][j] : "");
        //         m.computeIfAbsent(key, z -> new HashSet<>()).add(s);
        //     }
        //    return m.size();
        // }

        
        // public int[] restoreArray(int[][] adjacentPairs) {
        //     int n = adjacentPairs.length + 1;
        //     int [] ans = new int [n];
        //     Set<Integer> s = new HashSet<>();
        //     for (int [] p : adjacentPairs) {
        //         if (!s.add(p[0])) s.remove(p[0]);
        //         if (!s.add(p[1])) s.remove(p[1]);
        //     }
        //     ans[0] = s.iterator().next();
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int [] v : adjacentPairs) {
        //         m.computeIfAbsent(v[0], z -> new ArrayList<>()).add(v[1]);
        //         m.computeIfAbsent(v[1], z -> new ArrayList<>()).add(v[0]);
        //     }
        //     ans[1] = m.get(ans[0]).get(0);
        //     for (int i = 2; i < n; i++) {
        //         List<Integer> l = m.get(ans[i-1]);
        //         if (l.get(0) == ans[i-2]) ans[i] = l.get(1);
        //         else ans[i] = l.get(0);
        //     }
        //     return ans;
        // }


        // public int tupleSameProduct(int[] arr) {
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < arr.length; i++) 
        //         for (int j = i+1; j < arr.length; j++) {
        //             int v = arr[i] * arr[j];
        //             m.put(v, m.getOrDefault(v, 0) + 1);
        //         }
        //     int ans = 0;
        //     for (Map.Entry<Integer, Integer> en : m.entrySet()) 
        //         if (en.getValue() >= 2) {
        //             int n = en.getValue();
        //             ans += (n == 2 ? 8 : n * 2 * (n-1) * 2);
        //         }
        //     return ans;
        // }


        // public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        //     Map<Integer, Integer> m = new HashMap<>();
        //     Map<Integer, Integer> n = new HashMap<>();
        //     int va = 0, vb = 0, ans = 0;
        //     for (int i = 0; i < a.length; i++) 
        //         for (int j = 0; j < a.length; j++) {
        //             va = a[i] + b[j];
        //             m.put(va, m.getOrDefault(va, 0) + 1);
        //             vb = c[i] + d[j];
        //             n.put(vb, n.getOrDefault(vb, 0) + 1);
        //         }
        //     for (Integer v : m.keySet()) 
        //         if (n.containsKey(-v)) ans += m.get(v) * n.get(-v);
        //     return ans;
        // }


        // private boolean diffByOneOne(String x, String y) {
        //     int cnt = 0, dcnt = 0;
        //     for (int i = 0; i < x.length(); i++) {
        //         if (x.charAt(i) != y.charAt(i)) {
        //             if (Math.abs(x.charAt(i) - y.charAt(i)) == 1
        //                 || (x.charAt(i) == '0' && y.charAt(i) == '9')
        //                 || (x.charAt(i) == '9' && y.charAt(i) == '0'))
        //                 ++dcnt;
        //             ++cnt;
        //         }
        //     }
        //     return cnt == 1 && dcnt == 1 ? true : false;
        // }
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // List<Integer> l = new ArrayList<>();
        // public int openLock(String[] deadends, String target) {
        //     HashSet<Integer> s = new HashSet<>();
        //     for (int i = 0; i < deadends.length; i++) 
        //         s.add(Integer.parseInt(deadends[i]));
        //     for (int i = 0; i < 10000; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }            
        //     for (int i = 0; i < 10000; i++) {
        //         for (int j = 0; j < 10000; j++) {
        //             if (j == i || s.contains(i) || s.contains(j)) continue;
        //             if (diffByOneOne(String.format("%04d", i), String.format("%04d", j))) {
        //                 m.get(i).add(j);
        //                 m.get(j).add(i);
        //             }
        //         }
        //     }
        //     return 0;
        // }


        // public int minAreaRect(int[][] pt) { // 题目理解错了：四个顶点必须由数组里的点组成
        //     int n = pt.length, min = Integer.MAX_VALUE;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) {
        //             if (pt[i][0] == pt[j][0] || pt[i][1] == pt[j][1]) continue;
        //             int v = Math.abs(pt[i][0] - pt[j][0]) * Math.abs(pt[i][1] - pt[j][1]);
        //             System.out.println("v: " + v);
        //             min = Math.min(min, v);
        //         }
        //     return min;
        // }


        // public int subarraysDivByK(int[] arr, int k) { // 为什么对数数组的个数就怕数不清楚呢？！！！
        //     int n = arr.length;
        //     int [] sum = Arrays.copyOf(arr, n);
        //     for (int i = 1; i < n; i++) 
        //         sum[i] += sum[i-1];
        // }


        // private boolean diffByOne(String s, String t)  {
        //     int cnt = 0;
        //     for (int i = 0; i < s.length(); i++) 
        //         if (s.charAt(i) != t.charAt(i)) {
        //             cnt++;
        //             if (cnt > 1) return false;
        //         }
        //     return true;
        // }
        // public int minMutation(String start, String end, String[] bank) {
        //     Set<String> s = new HashSet<>(Arrays.asList(bank));
        //     Queue<String> q = new LinkedList<>();
        //     Set<String> vis = new HashSet<>();
        //     q.offer(start);
        //     vis.add(start);
        //     int step = 0;
        //     while (!q.isEmpty()) {
        //         for (int size = q.size(); size > 0; size--) {
        //             String cur = q.poll();
        //             if (cur.equals(end)) return step;
        //             for (String str : bank) 
        //                 if (diffByOne(cur, str) && !vis.contains(str)) {
        //                     q.offer(str);
        //                     vis.add(str);
        //                 } 
        //         }
        //         ++step;
        //     }
        //     return -1;
        // }


        // private int getMinDiff(Map<Integer, Integer> m) {
        //     List<Integer> l = new ArrayList<>();
        //     for (Integer key : m.keySet()) 
        //         l.add(key);
        //     Collections.sort(l);
        //     // System.out.println("l.size(): " + l.size());
        //     // System.out.println(Arrays.toString(l.toArray()));
        //     int min = Integer.MAX_VALUE;
        //     for (int i = 1; i < l.size(); i++) 
        //         min = Math.min(min, Math.abs(l.get(i) - l.get(i-1)));
        //     // System.out.println("min: " + min);
        //     return min;
        // }
        // public int[] minDifference(int[] arr, int[][] queries) {
        //     List<int []> qr = new ArrayList<>();
        //     for (int i = 0; i < queries.length; i++) 
        //         qr.add(new int [] {i, queries[i][0], queries[i][1]});
        //     Collections.sort(qr, (a, b)->(a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]));
        //     // for (int [] zz : qr) 
        //     //     System.out.println(Arrays.toString(zz));
        //     int [] ans = new int [queries.length];
        //     Map<Integer, Integer> m = new HashMap<>();
        //     int i = 0, j = 0;
        //     for (int [] q : qr) {
        //         // System.out.println("\n" + Arrays.toString(q));
        //         int l = q[1], r = q[2];
        //         if (j == 0) j = r;
        //         // System.out.println("j: " + j);
        //         // System.out.println("r: " + r);
        //         // System.out.println("i: " + i);
        //         while (i < l && m.containsKey(arr[i])) {
        //             m.put(arr[i], m.get(arr[i])-1);
        //             if (m.get(arr[i]) == 0) m.remove(arr[i]);
        //             i++;
        //         }
        //         while (j > r && m.containsKey(arr[j])) {
        //             m.put(arr[j], m.get(arr[j])-1);
        //             if (m.get(arr[j]) == 0) m.remove(arr[j]);
        //             --j;
        //         }
        //         // System.out.println("m.size(): " + m.size());
        //         // for (Map.Entry<Integer, Integer> en : m.entrySet()) 
        //         //     System.out.print(en.getKey() + ", " + en.getValue() + "\n");
        //         // System.out.println("i: " + i);
        //         for (int k = l; k <= r; k++) 
        //            m.put(arr[k], m.getOrDefault(arr[k], 0) + 1);
        //         if (j < r) j = r;
        //         // System.out.println("i: " + i);
        //         // System.out.println("j: " + j);
        //         if (i < l) i = l;
        //         ans[q[0]] = getMinDiff(m);
        //         // System.out.println("ans[q[0]]: " + ans[q[0]]);
        //     }
        //     return ans;
        // }


        // public ListNode removeZeroSumSublists(ListNode head) { // 感觉这里linkedList不是障碍，但是数组移除和为零的片段后
        //     List<Integer> l = new ArrayList<>();
        //     ListNode p = head;
        //     while (p != null) {
        //         l.add(p.val);
        //         p = p.next;
        //     }
        //     // for (int i = 1; i < l.size(); i++) 
        //     //     l.set(i, l.get(i) + l.get(i-1));
        //     // if (l.contains(0)) {
        //     //     int i = 0;
        //     //     while (l.get(i) != 0) l.remove(i);
        //     //     l.remove(0);
        //     // }
        //     Map<Integer, Integer> m = new HashMap<>(); // sum, idx: m里允许重复数出现吗？
        //     int sum = 0;
        //     for (int i = 0; i < l.size(); i++)
        //         sum += l.get(i);
        //         if (m.containsKey(l.get(i))) {
        //             int v = l.get(i);
        //             int j = m.get(l.get(i)) + 1; // idx
        //             while (l.get(j) != v) {
        //                 m.remove(l.get(j));
        //                 l.remove(j);
        //             }
        //             l.remove(j);
        //         }
        //     p = head;
        //     return p;
        // }


        // public int findMaxLength(int[] arr) {
        //     int n = arr.length;
        //     int j = 0, max = 0, cur = 0;
        //     int [] cnt = new int [2];
        //     for (int i = 0; i < n; i++) {
        //         cnt[arr[i]]++;
        //         if (cnt[0] == cnt[1]) max = Math.max(max, i-j+1);
        //     }
        // }




        // public int maxNonOverlapping(int[] arr, int target) { // 这里好好再想一下 bug bug bug
        //     int [] sum = Arrays.copyOf(arr, arr.length);
        //     for (int i = 1; i < sum.length; i++) 
        //         sum[i] += sum[i-1];
        //     int j = 0, ans = 0;
        //     for (int i = 0; i < sum.length; i++) {
        //         if (sum[i] - (j == 0 ? 0 : sum[j-1]) == target) {
        //             j = i+1;
        //             ans++;
        //             continue;
        //         } 
        //         if (sum[i] - (j == 0 ? 0 : sum[j-1]) > target) {
        //             while (sum[i] - (j == 0 ? 0 : sum[j-1]) > target) j++;
        //             if (sum[i] - sum[j-1] == target) {
        //                 ans++;
        //                 j = i+1;
        //             }                        
        //         }
        //     }
        //     return ans;
        // }
        // public int maxNonOverlapping(int[] arr, int target) { // 记住前面出现过的sum - target是否存在，记在一个键值图里面
        //     int [] dp = new int [arr.length+1];
        //     Map<Integer, Integer> idx = new HashMap<>(); // key是index, value是[0,key]这个范围能求出的最大值
        //     idx.put(0, -1);
        //     int sum = 0, ans = 0;
        //     for (int i = 0; i < arr.length; i++) {
        //         sum += arr[i];
        //         if (idx.containsKey(sum - target)) 
        //             ans = Math.max(ans, dp[idx.get(sum - target) + 1] + 1); // 这里写index[s-t]+1是因为dp[i]表示的是前i个数，和index有1个偏移
        //         idx.put(sum, i);
        //         dp[i+1] = ans;
        //     }
        //     return ans;
        // }


        // public int subarraySum(int[] arr, int k) {
        //     int n = arr.length, ans = 0;
        //     int [] sum = Arrays.copyOf(arr, n);
        //     for (int i = 1; i < n; i++) 
        //         sum[i] += sum[i-1];
        //     Map<Integer, Integer> m = new HashMap<>();
        //     m.put(0, 1);
        //     for (int i = 0; i < n; i++) {
        //         if (m.containsKey(sum[i] - k)) ans += m.get(sum[i] - k);
        //         m.put(sum[i], m.getOrDefault(sum[i], 0) + 1);
        //     }
        //     return ans;
        // }


        // public int threeSumMulti(int[] arr, int target) {
        //     int mod = (int)1e9 + 7;
        //     int n = arr.length;
        //     int [] cnt = new int [101];
        //     for (Integer v : arr) 
        //         cnt[v]++;
        //     cnt[arr[0]]--;
        //     TreeMap<Integer, Integer> m = new TreeMap<>();
        //     m.put(arr[0], 1);
        //     long ans = 0;
        //     for (int i = 1; i < n-1; i++) {
        //         cnt[arr[i]]--;
        //         for (Integer key : m.keySet()) {
        //             if (key + arr[i] <= target && target-key-arr[i] <= 100 && cnt[target - key - arr[i]] > 0)
        //                 ans = (ans + m.get(key) * cnt[target - key - arr[i]] % mod + mod) % mod;
        //         }
        //         m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        //     }
        //     return (int)ans;
        // }


        // public List<Integer> majorityElement(int[] arr) {
        //     int n = arr.length;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (Integer v : arr) 
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //     Map<Integer, Integer> tmp = m.entrySet().stream()
        //         .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     List<Integer> res = new ArrayList<>();
        //     for (Map.Entry<Integer, Integer> en : tmp.entrySet()) {
        //         int v = en.getValue();
        //         if (v > n / 3) res.add(en.getKey());
        //         else break;
        //     }
        //     return res;
        // }


        // public boolean canArrange(int[] arr, int k) {
        //     int n = arr.length;
        //     int [] cnt = new int [k];
        //     for (Integer v : arr) 
        //         cnt[((v % k) + k) % k]++;
        //     System.out.println(Arrays.toString(cnt));
        //     for (int i = 0; i < k; i++) {
        //         if ((i == 0 || i == k-i) && cnt[i] % 2 == 1) return false;
        //         else if (i == 0 || i == k-i) continue;
        //         if (cnt[i] != cnt[k-i]) return false;
        //     }
        //     return true;
        // }


        // private int reverse(int v) {
        //     String s = String.valueOf(v);
        //     String t = new StringBuilder(s).reverse().toString().replaceFirst("^0+(?!$)", "");
        //     return Integer.parseInt(t);
        // }
        // public int countNicePairs(int[] arr) {
        //     int mod = (int)1e9 + 7;
        //     int n = arr.length;
        //     int [] rev = Arrays.copyOf(arr, n);
        //     for (int i = 0; i < n; i++)
        //         rev[i] = reverse(rev[i]);
        //     Map<Integer, Integer> m = new HashMap<>();
        //     m.put(arr[0] - rev[0], 1);
        //     long ans = 0;
        //     for (int i = 1; i < n; i++) {
        //         int v = arr[i] - rev[i];
        //         if (m.containsKey(v)) 
        //             ans = (ans + m.get(v)) % mod;
        //         m.put(arr[i]-rev[i], m.getOrDefault(arr[i]-rev[i], 0) + 1);
        //     }
        //     return (int)ans;
        // }

        
        // private boolean perfectSqure(long v) {
        //     double a = Math.sqrt(v);
        //     return (a - Math.floor(a) == 0);
        // }
        // public int numTriplets(int[] a, int[] b) {
        //     int m = a.length, n = b.length;
        //     Map<Long, Integer> ma = new HashMap<>();
        //     Map<Long, Integer> mb = new HashMap<>();
        //     for (int i = 0; i < m; i++)
        //         ma.put((long)a[i]*a[i], ma.getOrDefault((long)a[i]*a[i], 0) + 1);
        //     for (int i = 0; i < n; i++)
        //         mb.put((long)b[i]*b[i], mb.getOrDefault((long)b[i]*b[i], 0) + 1);
        //     int ans = 0;
        //     Map<Integer, Integer> ca = new HashMap<>();
        //     Map<Integer, Integer> cb = new HashMap<>();
        //     ca.put(a[0], 1);
        //     for (int i = 1; i < m; i++) {
        //         for (Map.Entry<Integer, Integer> en : ca.entrySet()) {
        //             long v = (long)a[i] * en.getKey();
        //             if (perfectSqure(v) && mb.containsKey(v))
        //                 ans += en.getValue() * mb.get(v);
        //         }
        //         ca.put(a[i], ca.getOrDefault(a[i], 0) + 1);
        //     }
        //     cb.put(b[0], 1);
        //     for (int i = 1; i < n; i++) {
        //         for (Map.Entry<Integer, Integer> en : cb.entrySet()) {
        //             long v = (long)b[i] * en.getKey();
        //             if (perfectSqure(v) && ma.containsKey(v))
        //                 ans += en.getValue() * ma.get(v);
        //         }
        //         cb.put(b[i], cb.getOrDefault(b[i], 0) + 1);
        //     }
        //     return ans;
        // }


        // public boolean canReorderDoubled(int[] arr) {
        //     int n = arr.length;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int v : arr) 
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //     Map<Integer, Integer> tmp = m.entrySet().stream()
        //         .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())) 
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     // System.out.println("tmp.size(): " + tmp.size());
        //     // for (Map.Entry<Integer, Integer> en : tmp.entrySet()) 
        //     //     System.out.print(en.getKey() + ", " + en.getValue() + "\n");
        //    m = new HashMap<>(tmp);
        //     while (tmp.size() > 0) {
        //         for (Map.Entry<Integer, Integer> en : tmp.entrySet()) {
        //             int k = en.getKey(), v = en.getValue();
        //             // System.out.println("\n k: " + k);
        //             // System.out.println("v: " + v);
        //             if (k % 2 == 0 && tmp.containsKey(k / 2)) {
        //                 if (tmp.get(k/2) < v) return false;
        //                 int min = Math.min(tmp.get(k / 2), v);
        //                 if (min == v) {
        //                     m.remove(k);
        //                     m.put(k / 2, m.get(k / 2) - v);
        //                     if (m.get(k/2) == 0) m.remove(k/2);
        //                     break;
        //                 } else return false;
        //             }
        //         }
        //         tmp.clear();
        //         tmp = m.entrySet().stream()
        //             .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())) 
        //             .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //         m.clear();
        //         m = new HashMap<>(tmp);
        //     }
        //     return true;
        // }


        // public int countPairs(int [] deliciousness) { // bug bug bug
        //     int mod = (int)1e9 + 7;
        //     int n = deliciousness.length;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     TreeSet<Integer> ts = new TreeSet<>();
        //     for (int v : deliciousness) {
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //         ts.add(v);
        //     }
        //    long ans = 0;
        //     for (Iterator it = ts.iterator(); it.hasNext(); ) {
        //         int v = (int)it.next();
        //         for (int j = 0; j <= 21; j++) {
        //             int u = (int)Math.pow(2, j) - v;
        //             if (u >= v && m.containsKey(u)) {
        //                 if (u == v)
        //                     ans = (ans + m.get(v)*(m.get(v)-1) % mod /2 + mod) % mod;
        //                 else 
        //                     ans = (ans + m.get(v) * m.get(u) % mod + mod) % mod;
        //             }
        //         }
        //     }
        //     return (int)ans;
        // }
        // public int countPairs(int [] deliciousness) { // bug bug bug
        //     int mod = (int)1e9 + 7;
        //     int n = deliciousness.length;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     long ans = 0;
        //     for (int i = 0; i < n; i++) {
        //         int v = deliciousness[i];
        //         for (int j = 0; j < 22; j++) {
        //             int u = (int)Math.pow(2, j) - v;
        //             if (m.containsKey(u))
        //                 ans += m.get(u);
        //         }
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //     }
        //     return (int) (ans % mod);
        // }


        // public int minSubarray(int[] arr, int p) { // 有点儿不明白提示说的是什么意思
        //     int n = arr.length;
        //     int [] sum = Arrays.copyOf(arr, n);
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 1; i < n; i++) 
        //         sum[i] += sum[i-1];
        //     int rem = sum[n-1] % p; //  [0, 1, 2, ... p-1]
        //     for (int i = 0; i < n; i++) {
        //         int tmp = sum[i] % p;
        //         if (i < n-1)
        //             m.put(tmp, i);
        //     }
        //     if (!m.containsKey(rem)) return -1;
        //     return n-1-m.get(rem);
        // }


        // public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        //     List<Set<String>> ll = new ArrayList<>();
        //     for (List<String> ls : favoriteCompanies) 
        //         ll.add(new HashSet<>(ls));
        //     int cnt = 0, j = 0;
        //     List<Integer> ans = new ArrayList<>();
        //     for (int i = 0; i < ll.size(); i++) {
        //         cnt = 0;
        //         for (j = 0; j < ll.size(); j++) {
        //             if (j == i) continue;
        //             if (ll.get(j).size() < ll.get(i).size()) {
        //                 cnt++;
        //                 continue;
        //             }
        //             if (!ll.get(j).containsAll(ll.get(i))) ++cnt;
        //             else break;
        //         }
        //         if (cnt == ll.size()-1) ans.add(i);
        //     }
        //     return ans;
        // }
        // public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        //     List<Set<String>> ll = new ArrayList<>();
        //     for (List<String> ls : favoriteCompanies) 
        //         ll.add(new HashSet<>(ls));
        //     List<Integer> ans = new ArrayList<>();
        //     for (int i = 0; i < ll.size(); i++) {
        //         boolean valid = true;
        //         for (int j = 0; j < ll.size(); j++) {
        //             if (j == i || ll.get(j).size() < ll.get(i).size()) continue;
        //             if (ll.get(j).containsAll(ll.get(i))) {
        //                 valid = false;
        //                 break;
        //             }
        //         }
        //         if (valid) ans.add(i);
        //     }
        //     return ans;
        // }


        // private int helper(int [] arr, int k) { 
        //     int bgn = 0, end = 0, ans = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     while (end < arr.length) {
        //         if (m.getOrDefault(arr[end], 0) == 0) k--;
        //         m.put(arr[end], m.getOrDefault(arr[end], 0) + 1);
        //         end++;
        //         while (k < 0) {
        //             m.put(arr[bgn], m.get(arr[bgn])-1);
        //             if (m.get(arr[bgn]) == 0) k++;
        //             bgn++;
        //         }
        //         ans += end - bgn + 1; // 注意这里是累加，因为求的是子数组的数目的和
        //     }
        //     return ans;
        // }
        // private int helper(int [] arr, int k) { // 总觉得让我数个数的题，数不清楚
        //     int n = arr.length;
        //     int bgn = 0, end = 0, ans = 0;
        //     int [] map = new int [n+1];
        //     while (end < n) {
        //         if (map[arr[end]] == 0) k--;
        //         map[arr[end]]++;
        //         end++;
        //         while (k < 0) {
        //             map[arr[bgn]]--;
        //             if (map[arr[bgn]] ==0) k++;
        //             bgn++;
        //         }
        //         ans += end - bgn + 1;
        //     }
        //     return ans;
        // }
        // public int subarraysWithKDistinct(int[] arr, int k) {
        //     return helper(arr, k) - helper(arr, k-1);
        // }
        // public int subarraysWithKDistinct(int[] arr, int K) {
        //     int n = arr.length, ans = 0;
        //     //为滑动窗口设计2个左指针，指向不同整数个数为K和K-1的子数组左边界
        //     int[] ca = new int[n + 1]; // k
        //     int[] cb = new int[n + 1]; // k-1
        //     int li = 0, lj = 0, r = 0;
        //     int ci = 0, cj = 0;
        //     while (r < n) {
        //         if (ca[arr[r]]++ == 0)
        //             ci++;
        //         if (cb[arr[r++]]++ == 0)
        //             cj++;
        //         while (ci > K)
        //             if (--ca[arr[li++]] == 0)
        //                 ci--;
        //         while (cj > K - 1)
        //             if (--cb[arr[lj++]] == 0)
        //                 cj--;
        //         ans += lj - li;
        //     }
        //     return ans;
        // }


        // public int maxEqualFreq(int[] arr) {
        //     int n = arr.length, ans = 0, maxCnt = 0;
        //     Map<Integer, Integer> cnt = new HashMap<>();
        //     Map<Integer, Integer> fre = new HashMap<>(); // frequency of cnt vals
        //     for (int i = 0; i < n; i++) {
        //         int v = arr[i], vCnt = cnt.getOrDefault(v, 0);
        //         cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        //         maxCnt = Math.max(maxCnt, vCnt+1);
        //         if (fre.containsKey(vCnt) && fre.get(vCnt) > 0) {
        //             fre.put(vCnt, fre.get(vCnt)-1);
        //             if (fre.get(vCnt) == 0) fre.remove(vCnt);
        //         }
        //         fre.put(vCnt + 1, fre.getOrDefault(vCnt+1, 0) + 1);
        //         // 三种情况: 第一种就直接判断 mx 是否为1; 第二种用 mx 乘以 freq[mx]，看是否等于i; 第三种用 mx-1 乘以 feq[mx-1]+1，看是否等于i，
        //         if (maxCnt * fre.getOrDefault(maxCnt, 0) == i || (maxCnt - 1) * (fre.getOrDefault(maxCnt-1, 0) + 1) == i || maxCnt == 1)
        //             ans = i + 1;
        //     }
        //     return ans;
        // }
        // public int maxEqualFreq(int[] arr) {
        //     int n = arr.length, ans = 1, maxCnt = 0;
        //     int [] cnt = new int [100005];
        //     int [] fre = new int [100005];
        //     for (int i = 0; i < n; i++) {
        //         cnt[arr[i]]++;
        //         int curCnt = cnt[arr[i]];
        //         fre[curCnt]++;
        //         if (fre[curCnt] * curCnt == i)
        //             ans = Math.max(ans, i+1);
        //         else if (fre[curCnt] * curCnt == i + 1 && i < n -1)
        //             ans = Math.max(ans, i+2);
        //     }
        //     return ans;
        // }


        // public int subarraysDivByK(int[] arr, int k) {
        //     int n = arr.length, ans = 0;
        //     int [] sum = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         sum[i] = sum[i-1] + arr[i-1];
        //     int [] dp = new int [n+1];
        //     for (int i = 1; i <= n; i++) {
        //         for (int j = i-1; j >= 0; j--) {
        //             if ((sum[i] - sum[j]) % k == 0) {
        //                 dp[i] = dp[j] + 1;
        //                 ans += dp[i];
        //                 break;
        //             }
        //         }
        //     }
        //     return ans;
        // }


        // public boolean checkSubarraySum(int[] arr, int k) { // tle tle tle 
        //     int n = arr.length;
        //     int [] sum = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         sum[i] = sum[i-1] + arr[i-1];
        //     System.out.println("sum[n]: " + sum[n]);
        //     for (int i = 1; i <= n; i++) {
        //         for (int j = i-1; j >= 0; j--) {
        //             if ((sum[i] - sum[j]) % k == 0 && i - j >= 2)
        //                 return true;
        //         }
        //     }
        //     return false;
        // }


        // public int numberOfBoomerangs(int[][] a) { // 不识数，数不清楚！！！
        //     Map<Integer, Integer> m = new HashMap<>();
        //     int ans = 0, cnt = 0;
        //     for (int i = 0; i < a.length; i++) {
        //         System.out.println("\n i: " + i);
        //         for (int j = i+1; j < a.length; j++) {
        //             int v = (int)Math.pow(a[i][0] - a[j][0], 2) + (int)Math.pow(a[i][1] - a[j][1], 2);
        //             // if (m.containsKey(v)) ans += m.get(v);
        //             m.put(v, m.getOrDefault(v, 0) + 1);
        //         }
        //         for (Integer v : m.values()) 
        //             if (v >= 2) ans += v * (v-1)/2;
        //     }
        //     return ans;
        // }


        public int maxEqualRowsAfterFlips(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            Map<String, Integer> cnt = new HashMap<>();
            for (int [] v : mat) {
                if (v[0] == 1) {
                    String cur = "";
                    for (int i = 0; i < n; i++) 
                        cur += "" + v[i];
                    cnt.put(cur, cnt.getOrDefault(cur, 0) + 1);
                } else {
                    String cur = "";
                    for (int i = 0; i < n; i++) 
                        cur += String.valueOf(1 - v[i]);
                    cnt.put(cur, cnt.getOrDefault(cur, 0) + 1);
                }
            }
            Map<String, Integer> tmp = cnt.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
            return tmp.entrySet().iterator().next().getValue();
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{0,0,0},{0,0,1},{1,1,0}};

        int r = s.maxEqualRowsAfterFlips(a);
        System.out.println("r: " + r);
    }
}