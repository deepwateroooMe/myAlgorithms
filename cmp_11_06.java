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
 
        // private boolean isValid(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     Set<Character> sc = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        //     Map<Character, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         if (!sc.contains(s[i])) return false;
        //         m.put(s[i], m.getOrDefault(s[i], 0) + 1);
        //     }
        //     if (m.size() < 5) return false;
        //     return true;
        // }
        // public int countVowelSubstrings(String t) {  // sliding window思路是对的，只是个数数得不对
        //     int n = t.length(), ans = 0;
        //     char [] s = t.toCharArray();
        //     Set<Character> sc = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        //     Map<Character, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j <= n; j++) {
        //             String cur = t.substring(i, j);
        //             if (isValid(cur)) ans++;
        //         }
        //     return ans;
        // }
        // private int count(int bgn, Map<Character, Integer> m) {
        //     int last = Integer.MAX_VALUE;
        //     for (Integer v : m.values()) 
        //         last = Math.min(last, v);
        //     return last - bgn + 1;
        // }
        // public int countVowelSubstrings(String t) {  // sliding window思路是对的，只是个数数得不对
        //     int n = t.length(), ans = 0, j = 0;
        //     char [] s = t.toCharArray();
        //     Set<Character> sc = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        //     Map<Character, Integer> m = new HashMap<>(); // value is the latest index of the vowel
        //     for (int i = 0; i < n; i++) {
        //         if (!sc.contains(s[i])) continue;
        //         j = i;
        //         while (j < n && sc.contains(s[j])) {
        //             m.put(s[j], j);
        //             // if (m.size() == 5) ans++; // 这里数得、加得不对
        //             if (m.size() == 5) {
        //                 int tmp = count(i, m);
        //                 ans += tmp;
        //             }
        //             j++;
        //         }
        //         // if (j - i >= 4 || m.size() == 5) {
        //         //     while (i <= j && m.size() == 5) {
        //         //         m.put(s[i], m.get(s[i])-1);
        //         //         if (m.get(s[i]) == 0) m.remove(s[i]);
        //         //         i++;
        //         //         if (m.size() == 5) ans++;
        //         //         else if (m.size() < 5) break;
        //         //     }
        //         // }
        //         m.clear();
        //         i = j-1;
        //     }
        //     return ans;
        // }

                
        // public long countVowels(String t) {
        //     int n = t.length();
        //     long sum = 0, ans = 0;
        //     Set<Character> sc = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        //     char [] s = t.toCharArray();
        //     long [] cnt = new long [n];
        //     // for (int i = 0; i < n; i++) { // O(N^2)
        //     //     // for (int i = n-1; i >= 0; i--) {
        //     //     sum += (sc.contains(s[i]) ? 1 : 0);
        //     //     cnt[i] = sum;
        //     // }
        //     // for (int i = 0; i < n; i++) 
        //     //     for (int j = i+1; j <= n; j++) 
        //     //         ans += cnt[j-1] - (i == 0 ? 0 : cnt[i-1]);
        //     // return ans;
        //     for (int i = 0; i < n; i++) { // 这里思考的出发点是对的，
        //         if (!sc.contains(s[i])) continue;
        //         // ans += n-i; // 但仍如之前，很多数个数的题数不清楚一样，这里数得不对；但这里数得不对，是因为想得不够透彻
        //         ans += (i + 1) * ((long)n - i);
        //     } 
        //     // System.out.println("ans: " + ans);
        //     return ans;
        // }


        // private boolean canDistribute(int k, int n, int [] a) {
        //     int cnt = 0;
        //     for (int i = 0; i < a.length; i++) {
        //         if (a[i] <= k) cnt += 1;
        //         else cnt = cnt +  (a[i] / k + (a[i] % k == 0 ? 0 : 1)); // 多一个括号的区别
        //     }
        //     return cnt <= n;
        //     // long sum = Arrays.stream(a).sum(); // 这个，把问题想简单了
        //     // return (long)k * n >= sum;
        // }
        // public int minimizedMaximum(int n, int[] a) {
        //     Arrays.sort(a);
        //     if (a.length == 1 && n == 1) return a[0];
        //     int l = 1, r = Arrays.stream(a).max().getAsInt(), ans = 0;
        //     while (l <= r) {
        //         int m = l + (r - l) / 2;
        //         if (canDistribute(m, n, a)) {
        //             ans = m;
        //             r = m-1;
        //         } else l = m + 1;
        //     }
        //     return ans;
        // }


        private int [] dijkstra() {
            int [] ans = new int [n];
            Arrays.fill(ans, Integer.MAX_VALUE);
            ans[0] = 0;
            // boolean [] vis = new boolean [n]; // 因为可以重复遍历，要允许它重复遍历  
            // vis[idx] = true;                  // 因为可以重复遍历，要允许它重复遍历  
            // Queue<int []> q = new LinkedList<>();
            Queue<int []> q = new PriorityQueue<>((a, b)->a[1] - b[1]);
            q.offer(new int [] {0, 0});
            while (!q.isEmpty()) {
                int [] cur = q.poll();
                if (cur[1] > ans[cur[0]]) continue;
                for (int [] nei : adj.get(cur[0])) {
                    // if (nei[0] == cur[0]) continue; // 因为可以重复遍历，要允许它重复遍历  
                    if (nei[1] + cur[1] < ans[nei[0]]) {
                        ans[nei[0]] = nei[1] + cur[1];
                        // if (!vis[nei[0]]) {
                        q.offer(new int [] {nei[0], ans[nei[0]]});
                        // vis[nei[0]] = true;
                    }
                }
            }
            return ans;
        }
        private void dfs(int idx, int avaTime, int [] t, int [] v, Set<Integer> vis) {
            if (idx == 0) {
                int cur = 0;
                for (Integer node : vis) 
                    cur += v[node];
                ans = Math.max(ans, cur);
            }
            for (int [] nei : adj.get(idx)) 
                if (t[nei[0]] + nei[1] <= avaTime) { //
                    boolean added = vis.add(nei[0]);
                    dfs(nei[0], avaTime - nei[1], t, v, vis);
                    if (added)
                        vis.remove(nei[0]);
                }
        }
        int [] time;
        List<List<int []>> adj = new ArrayList<>();
        int n, ans = 0;
        public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
            n = values.length;
            for (int i = 0; i < n; i++) 
                adj.add(new ArrayList<>());
            for (int [] e : edges) {
                adj.get(e[0]).add(new int [] {e[1], e[2]});
                adj.get(e[1]).add(new int [] {e[0], e[2]});
            }
            time = dijkstra();
            Set<Integer> si = new HashSet<>();
            si.add(0);
            dfs(0, maxTime, time, values, si);
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int []  a = new int []  { 0, 32, 10, 43};
        // int [][] b = new int [][] {{0,1,10},{1,2,15},{0,3,10}};
        // int []  a = new int []  {5, 10, 15, 20};
        // int [][] b = new int [][] {{0,1,10},{1,2,10},{0,3,10}};
        // int []  a = new int []  {1, 2, 3, 4};
        // int [][] b = new int [][] {{0,1,10},{1,2,11},{2,3,12},{1,3,13}};
        int [] a = new int [] {95};
        int [][] b = new int [][] {};

        int r = s.maximalPathQuality(a, b, 83);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
