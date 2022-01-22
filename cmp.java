// import com.ListNode;

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

        // public int minimumCost(int[] a) {
        //     int n = a.length, sum = Arrays.stream(a).sum(), i = n-3;
        //     if (n < 3) return sum;
        //     Arrays.sort(a);
        //     for (; i >= 0; i -= 3) 
        //         sum -= a[i];
        //     return sum;
        // }

        // public List<List<Integer>> highestRankedKItems(int[][] a, int[] pricing, int[] start, int k) { // a: grid
        //     int m = a.length, n = a[0].length, cnt = 0;
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> x[2] != y[2] ? x[2] - y[2] : 
        //                                           (a[x[0]][x[1]] != a[y[0]][y[1]] ? a[x[0]][x[1]] - a[y[0]][y[1]] : (x[0] != y[0] ? x[0] - y[0] : x[1] - y[1])));
        //     boolean [][] vis = new boolean [m][n];
        //     q.offer(new int [] {start[0], start[1], 0});
        //     vis[start[0]][start[1]] = true;
        //     int [][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        //     List<List<Integer>> ans = new ArrayList<>();
        //     if (a[start[0]][start[1]] == 0) return ans;
        //     while (!q.isEmpty()) {
        //         for (int z = q.size()-1; z >= 0; z--) {
        //             int [] cur = q.poll();
        //             if (ans.size() < k && a[cur[0]][cur[1]] >= pricing[0] && a[cur[0]][cur[1]] <= pricing[1]) ans.add(List.of(cur[0], cur[1]));
        //             else if (ans.size() == k) return ans;
        //             for (int [] d : dirs) {
        //                 int i = cur[0] + d[0], j = cur[1] + d[1];
        //                 if (i < 0 || i >= m || j < 0 || j >= n || a[i][j] == 0 || vis[i][j]) continue;
        //                 q.offer(new int [] {i, j, cnt});
        //                 vis[i][j] = true;
        //                 continue;
        //             }
        //         }
        //         cnt++;
        //     }
        //     return ans;
        // }

        // public int numberOfArrays(int[] a, int l, int h) { // 应该是：差分数组 的应用，但仍然是没有头緒: 到最后想了一会儿才想出来
        //     int n = a.length, ans = 0;
        //     int [] sum = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         sum[i] = (i == 0 ? 0 : sum[i-1]) + a[i];
        //     Arrays.sort(sum);
        //     for (int i = Math.min(1, l); i <= Math.min(h, 100000); i++) 
        //         if (sum[0] + i >= l && sum[n-1] + i <= h) ans++;
        //     return ans;
        // }

        // public int numSubarraysWithSum(int[] arr, int goal) {
        //     int n = arr.length, cnt = 0, i = 0, j = 0;
        //     int [] sum = new int [n];
        //     for ( j = 0; j < n; j++) 
        //         sum[j] = (j == 0 ? 0 : sum[j-1]) + arr[j];
        //     for ( j = 0; j < n; j++) {
        //         if (sum[j] - (i == 0 ? 0 : sum[i-1]) > goal) i++;
        //         if (sum[j] - (i == 0 ? 0 : sum[i-1]) == goal) cnt++;
        //     }
        //     ++i; --j;
        //     while (i < j && sum[j] - (i == 0 ? 0 : sum[i-1]) == goal) {
        //         cnt++;
        //         ++i;
        //     }
        //     return cnt;
        // }
        // public int numberOfWays(String t) { // t: corridor
        //     int n = t.length(), j = 0, i = 0, cnt = 0;
        //     char [] s = t.toCharArray();
        //     int [] sum = new int [n];
        //     for ( j = 0; j < n; j++)
        //         sum[j] = (j == 0 ? 0 : sum[j-1]) + (s[j] == 'S' ? 1 : 0);
        //     // System.out.println(Arrays.toString(sum));
        //     // if (sum[n-1] < 2) return 0;
        //     // if (sum[n-1] == 2) return 1;
        //     // for ( j = 0; j < n; j++) {
        //     //     if (sum[j] - (i == 0 ? 0 : sum[i-1]) > 2) i++;
        //     //     if (sum[j] - (i == 0 ? 0 : sum[i-1]) == 2) cnt++;
        //     // }
        //     // ++i;
        //     // --j;
        //     // while (i < j && sum[j] - (i == 0 ? 0 : sum[i-1]) == 2) {
        //     //     cnt++;
        //     //     ++i;
        //     // }
        //     // // while (i < n && sum[i] == 0) i++;
        //     // // for (; i < n; i++) {
        //     // // }
        //     // return cnt;
        // }
        // public int subarraysWithKDistinct(int[] a, int k) {
        //     return getCntNoMoreThanK(a, k) - getCntNoMoreThanK(a, k-1);
        // }
        // int getCntNoMoreThanK(int [] a, int k) { // <= k
        //     int n = a.length, ans = 0, j = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         m.put(a[i], m.getOrDefault(a[i], 0) + 1);
        //         while (m.size() > k) {
        //             if (m.get(a[j]) > 1) m.put(a[j], m.get(a[j])-1);
        //             else m.remove(a[j]);
        //             j++;
        //         }
        //         ans += i - j + 1; // 就这一句是精华
        //     }
        //     return ans;
        // }
        // public int numberOfWays(String t) { // t: corridor 知道解法是sliding window, 但昨天晚上没有休息好，思路总是理不顺
        //     int n = t.length(), ans = 1, j = n-1, sum = 0, bgn = 0, end = 0, cnt = 0;
        //     char [] s = t.toCharArray();
        //     while (i < j) {
        //         while (i < n && sum < 2) {
        //             if (s[i] == 'S') sum++;
        //             i++;
        //         }
        //         while (j >= 0 && cnt < 2) {
        //             if (s[j] == 'S') cnt++;
        //             j--;
        //         }
        //         bgn = i;
        //         end = j;
        //         while (i <= end && s[i] == 'P') i++;
        //         while (j > i && s[j] == 'P') j--;
        //         ans += (i - bgn) * (end - j);
        //         sum = 0;
        //         cnt = 0;
        //     }
        //     return ans;
        // }
        public int numberOfWays(String t) { // t: corridor 知道解法是sliding window, 但昨天晚上没有休息好，思路总是理不顺 115/220 passed
            int n = t.length(), ans = 1, j = 0, cnt = 0, bgn = 0, sum = 0, end = n-1;
            char [] s = t.toCharArray();
            for (char v : s) 
                sum += v == 'S' ? 1 : 0;
            if (sum < 2) return 0;
            if (sum == 2) return 1;
            // List<Integer> l = new ArrayList<>();
            while (end >= 0 && cnt < 2) {
                cnt += s[end] == 'S' ? 1 : 0;
                end--;
            }
            cnt = 0;
            for (int i = 0; i <= end; i++) {
                System.out.println("\n i: " + i);
                
                cnt += s[i] == 'S' ? 1 : 0;
                if (cnt < 2) continue;
                if (cnt == 2) {
                    bgn = i;
                    System.out.println("i: " + i);
                    i++;
                    while (i < n && s[i] == 'P') i++;
                    if (i > bgn+1) ans *= i - bgn;
                    cnt = 0;
                    i -= 1;
                    System.out.println("ans: " + ans);
                }
            }
            if (cnt  > 0) return 0;
            return ans;
        }
    }   
    public static void main (String[] args) {
        Solution s = new Solution ();

        // String a = "SSPPSPS";
        String a = "SSSPPPSPPSPSSSSSSPPPSPP";
     // String a = "SS SPPPS PP SPS SS SS SPPPSPP";
        System.out.println("a: " + a);

        int r = s.numberOfWays(a);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

 // TreeNode root = new TreeNode(a[0]);
 // root.buildTree(root, a);
 // root.levelPrintTree(root);
