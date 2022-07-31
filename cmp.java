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

        // public int minimumOperations(int[] a) {
        //     int n = a.length, sum = 0, cnt = 0;
        //     Queue<Integer> q = new PriorityQueue<>();
        //     for (int v : a) q.offer(v);
        //     while (!q.isEmpty()) {
        //         int cur = q.poll();
        //         if (cur - sum == 0) continue;
        //         sum = cur;
        //         cnt ++;
        //     }
        //     return cnt;
        // }

        // public int maximumGroups(int[] a) {
        //     int n = a.length, l =  1, r = 1000, m = 0;
        //     long sum = 0;
        //     while (l < r) {
        //         m = l + (r - l) / 2;
        //         int v = getSum(m);
        //         if (v == n) return m;
        //         if (v < n) l++;
        //         else r--;
        //     }
        //     return m;
        // }
        // int getSum(int v) {
        //     return v * (v + 1) / 2;
        // }

        // // 当有环的时候,读不懂这个题目说的是什么意思了:
        // // Return the index of the node that can be reached from both node1 and node2,
        // // such that the MAXIMUM between the distance from node1 to that node, and from node2 to that node is MINIMIZED. 
        // public int closestMeetingNode(int[] a, int u, int v) {
        //     if (u == v) return u;
        //     if (a[u] == v && a[v] == u) return Math.min(u, v);
        //     int n = a.length;
        //     d = new int [2][n];
        //     vis = new boolean [n];
        //     Arrays.fill(d[0], -1);
        //     Arrays.fill(d[1], -1);
        //     getDist(u, 0, a);
        //     Arrays.fill(vis, false);
        //     getDist(v, 1, a);

        //     int min = Integer.MAX_VALUE;
        //     int cur = 0;
        //     int idx = -1;
        //     for (int i = 0; i < 2; i++) {
        //         if (d[i][u] >= cons) d[i][u] -= cons;
        //         if (d[i][v] >= cons) d[i][v] -= cons;
        //     }
        //     System.out.println("d.length: " + d.length);
        //     for (int z = 0; z < d.length; ++z) 
        //         System.out.println(Arrays.toString(d[z]));
        //     for (int i = 0; i < n; i++) {
        //         if (d[0][i] != -1 && d[1][i] != -1 && d[0][i] < cons && d[1][i] < cons) {
        //             cur = d[0][i] + d[1][i];
        //             if (cur < min) {
        //                 min = cur;
        //                 idx = i;
        //             }
        //         }
        //     }
        //     return idx;
        // }
        // int [][] d;
        // boolean [] vis;
        // int cons = Integer.MAX_VALUE / 2;
        // void getDist(int u, int idx, int [] a) {
        //     int cur = u, cnt = 0;
        //     vis[cur] = true;
        //     d[idx][u] = cnt;
        //     while (a[cur] != -1 && !vis[a[cur]]) {
        //         cnt++;
        //         d[idx][a[cur]] = cnt;
        //         vis[cur] = true;
        //         cur = a[cur];
        //     }
        //     while (a[cur] != -1 && vis[a[cur]]) {
        //         d[idx][a[cur]] += cons;
        //         vis[a[cur]] = false;
        //         cur = a[cur];
        //     }
        // }
        // [4,4,8,-1,9,8,4,4,1,1], 5, 6

        public int longestCycle(int[] a) { // still debugging, 46/72 passed........
            int n = a.length;
            vis = new boolean [n];
            // d = new int [n];
            for (int i = 0; i < n; i++) 
                getDist(i, a);
            return max;
        }
        boolean [] vis;
        // int [] d;
        Set<Integer> s = new HashSet<>();
        int max = -1;
        void getDist(int u, int [] a) {
            System.out.println("\n u: " + u);
            if (s.contains(u)) return ;
            int cur = u, cnt = -1;
            vis[cur] = true;
            // d[u] = cnt;
            while (a[cur] != -1 && !vis[a[cur]]) {
                // d[a[cur]] = cnt;
                vis[cur] = true;
                cur = a[cur];
            }
            System.out.println("cur: " + cur);
            if (a[cur] == -1) return ;
            cnt = 1;
            s.add(cur);
            while (a[cur] != -1 && vis[a[cur]]) {
                cnt++;
                vis[a[cur]] = false;
                s.add(a[cur]);
                cur = a[cur];
            }
            System.out.println("cnt: " + cnt);
            if (cnt > 1)
                max = Math.max(max, cnt);

            System.out.println("s.size(): " + s.size());
            System.out.println(Arrays.toString(new ArrayList<>(s).toArray()));
        }
    }
    public static void main(String args[]) { 
        Solution s = new Solution();

        int [] a = new int [] {3,3,4,2,3};
        // int [] a = new int [] {2,-1,3,1};

        int r = s.longestCycle(a);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
