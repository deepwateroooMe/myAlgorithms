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

        // public List<List<Integer>> mergeSimilarItems(int[][] a, int[][] b) {
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int [] v : a) 
        //         m.put(v[0], m.getOrDefault(v[0], 0) + v[1]);
        //     for (int [] v : b) 
        //         m.put(v[0], m.getOrDefault(v[0], 0) + v[1]);
        //     List<List<Integer>> l = new ArrayList<>();
        //     for (Map.Entry<Integer, Integer> en : m.entrySet()) 
        //         l.add(List.of(en.getKey(), en.getValue()));
        //     Collections.sort(l, (x, y) -> x.get(0) != y.get(0) ? x.get(0) - y.get(0) : x.get(1) - y.get(1));
        //     return l;
        // }

        // public long taskSchedulerII(int[] a, int val) {
        //     int n = a.length, idx = 0;
        //     long cnt = 1;
        //     Map<Integer, Long> m = new HashMap<>(); // k, v: [taskIdx, cntIdx]
        //     while (idx < n) {
        //         if (m.containsKey(a[idx]) && cnt <= m.get(a[idx]) + val)
        //             cnt += m.get(a[idx]) + val + 1 - cnt;
        //         if (!m.containsKey(a[idx]) || cnt > m.get(a[idx]) + val) { // 新任务,或是已经超过时间限制了
        //             m.put(a[idx], cnt);
        //             idx++;
        //             cnt++;
        //         }
        //     }
        //     return cnt-1;
        // }

        // public long minimumReplacement(int[] a) {
        //     int n = a.length;
        // }

        // Memory Limit Exceeded 
        // 1 <= nums.length <= 10^5
        //     1 <= nums[i] <= 10^9
        public long countBadPairs(int[] a) { // TLE TLE TLE: dont like these problems, will attend later this evening's instead
            int n = a.length, cnt = 0;
            int [][] d = new int [n][n];
            for (int i = 0; i < n; i++) 
                Arrays.fill(d[i], Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) 
                for (int j = i+1; j < n; j++) {
                    d[i][j] = a[j] - a[i];
                    if (d[i][j] != j - i) cnt++;
                }                    
            return cnt;
        }
    }
    public static void main(String args[]) { 
        Solution s = new Solution();

        int [] a = new int [] {1,2,1,2,3,1};

        long r = s.taskSchedulerII(a, 3);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
