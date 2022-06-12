import com.TreeNode;

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

        // public double calculateTax(int[][] a, int v) {
        //     int n = a.length;
        //     double ans = 0;
        //     for (int i = 0; i < n && v > 0; i++) {
        //         if (i == 0) {
        //             if (v >= a[i][0]) {
        //                 ans += a[i][0] * a[i][1] / 100.0;
        //                 v -= a[i][0];
        //             } else {
        //                 ans += v * a[i][1] / 100.0;
        //                 v = 0;
        //             }
        //         } else {
        //             if (v >= a[i][0] - a[i-1][0]) {
        //                 ans += (a[i][0] - a[i-1][0]) * a[i][1] / 100.0;
        //                 v -= a[i][0] - a[i-1][0];
        //             } else {
        //                 ans += v * a[i][1] / 100.0;
        //                 v = 0;
        //             }
        //         }
        //     }
        //     return ans;
        // }

        // public int minPathCost(int[][] a, int[][] c) {
        //     int m = a.length, n = a[0].length;
        //     Map<Integer, Integer> idx = new HashMap<>();
        //     for (int i = 0; i < m-1; i++) 
        //         for (int j = 0; j < n; j++)
        //             idx.put(i*n+j, a[i][j]);
        //     // bottom up approach
        //     int [][] dp = new int [m][n];
        //     int min = Integer.MAX_VALUE, cur = Integer.MAX_VALUE;
        //     for (int j = 0; j < n; j++) 
        //         dp[m-1][j] = a[m-1][j];
        //     for (int i = m-2; i >= 0; i--) {
        //         for (int j = 0; j < n; j++) {
        //             min = Integer.MAX_VALUE;
        //             for (int k = 0; k < n; k++) {
        //                 cur = c[idx.get(i*n+j)][k] + dp[i+1][k];
        //                 min = Math.min(min, cur);
        //             }
        //             dp[i][j] = min + a[i][j];
        //         }
        //     }
        //     min = Integer.MAX_VALUE;
        //     for (int j = 0; j < n; j++) 
        //         min = Math.min(min, dp[0][j]);
        //     return min;
        // }

        // public int distributeCookies(int[] a, int k) {
        //     n = a.length;
        //     if (k == n) return Arrays.stream(a).max().getAsInt();
        //     l = new ArrayList[k];
        //     for (int i = 0; i < k; i++) 
        //         l[i] = new ArrayList<>();
        //     dfsBackTracking(0, l, k, a);
        //     return min;
        // }
        // int n;
        // int min = Integer.MAX_VALUE;
        // List<Integer> [] l;
        // void dfsBackTracking(int idx, List<Integer> [] l, int k, int [] a) {
        //     if (idx == n) {
        //         int cur = 0, max = 0;
        //         for (int i = 0; i < k; i++) {
        //             cur = 0;
        //             for (int j = 0; j < l[i].size(); j++) 
        //                 cur += l[i].get(j);
        //             if (cur > min) return ;
        //             max = Math.max(max, cur);
        //         }
        //         min = Math.min(min, max);
        //         return ;
        //     }
        //     for (int i = 0; i < k; i++) {
        //         l[i].add(a[idx]);
        //         dfsBackTracking(idx+1, l, k, a);
        //         l[i].remove(l[i].size()-1);
        //     }
        // }

        public long distinctNames(String[] a) { // 25/89 tle .....
            int n = a.length;
            List<String> [] l = new ArrayList [26];
            for (int i = 0; i < 26; i++) 
                l[i] = new ArrayList<>();
            Set<String> so = new HashSet<>();
            for (String s : a) {
                char c = s.charAt(0);
                l[c-'a'].add(s);
                so.add(s);
            }
            long ans = 0;
            Set<String> ss = new HashSet<>();
            String cur = "";
            for (int i = 0; i < 26; i++) {
                if (l[i].size() == 0) continue;
                for (int j = 0; j < 26 && j != i; j++) {
                    if (l[j].size() == 0) continue;
                    char c = (char)('a' + j);
                    for (int ii = 0; ii < l[i].size(); ii++) {
                        String pre = l[i].get(ii);
                        String ta = c + pre.substring(1);
                        if (so.contains(ta)) continue;
                        c = (char)('a' + i);
                        for (int jj = 0; jj < l[j].size(); jj++) {
                            String next = l[j].get(jj);
                            String tb = c + next.substring(1);
                            if (!so.contains(tb)) 
                                ans += 2;
                        }
                    }
                }
            }
            return ans;
        }
    }
    public static void main(String args[]) { 
        Solution s = new Solution();

        String [] a = new String [] {"phhrrjjcm", "zjfkpps", "pm", "fnpduelfe", "mxtvjnq"};

        long r = s.distinctNames(a);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
