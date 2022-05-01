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

        // public int countPrefixes(String[] words, String s) {
        //     int cnt = 0;
        //     for (String si : words) 
        //         if (s.indexOf(si) == 0) cnt++;
        //     return cnt;
        // }

        // public int minimumAverageDifference(int[] a) {
        //     int n = a.length, idx = -1;
        //     long cur = 0, min = Long.MAX_VALUE;
        //     long[] pre = new long[n], suf = new long[n+1];
        //     for (int i = 0; i < n; i++) 
        //         pre[i] = (i == 0 ? a[i] : pre[i-1] + a[i]);
        //     for (int i = n-1; i >= 0; i--) 
        //         suf[i] = suf[i+1] + a[i];
        //     for (int i = 0; i < n; i++) {
        //         cur = Math.abs(Math.round((float)(pre[i]/(i+1))) - (i == n-1 ? 0 : Math.round((float)(suf[i+1]/(n-i-1)))));
        //         if (cur < min) {
        //             min = cur;
        //             idx = i;
        //         }
        //     }
        //     return idx;
        // }

        // public int countUnguarded(int m, int n, int[][] g, int[][] w) {
        //     int [][] a = new int [m][n];
        //     boolean [][] vis = new boolean [m][n];
        //     for (int [] v : g) {
        //         int i = v[0], j = v[1];
        //         a[i][j] = 1; // Guard
        //         vis[i][j] = true;
        //     }
        //     for (int [] v : w) {
        //         int i = v[0], j = v[1];
        //         a[i][j] = -1; // Wall
        //         vis[i][j] = true;
        //     }
        //     for (int [] v : g) {
        //         int ii = v[0], jj = v[1], i, j;
        //         for ( i = ii-1; i >= 0; i--) {
        //             j = jj;
        //             if (a[i][j] != 0) break; // = 1 or -1
        //             if (vis[i][j]) continue;
        //             vis[i][j] = true;
        //         }
        //         for ( i = ii+1; i < m; i++) {
        //             j = jj;
        //             if (a[i][j] != 0) break; // = 1 or -1
        //             if (vis[i][j]) continue;
        //             vis[i][j] = true;
        //         }
        //         for ( j = jj-1; j >= 0; j--) {
        //             i = ii;
        //             if (a[i][j] != 0) break; // = 1 or -1
        //             if (vis[i][j]) continue;
        //             vis[i][j] = true;
        //         }
        //         for ( j = jj+1; j < n; j++) {
        //             i = ii;
        //             if (a[i][j] != 0) break; // = 1 or -1
        //             if (vis[i][j]) continue;
        //             vis[i][j] = true;
        //         }
        //     }
        //     int cnt = 0;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (!vis[i][j]) cnt++;
        //     return cnt;
        // }

        public int maximumMinutes(int[][] a) { // bug： 以为自己想的已经是比较近了，可是还是有一个地方想得不对，思路上差了那么一丁点儿！！！
            m = a.length;
            n = a[0].length;
            if (a[0][1] == 1 || a[1][0] == 1 || a[1][1] == 1) return -1; // 这是最狭窄的不可能的情况
            int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            Set<String> f = new HashSet<>(); 
            int max = getShortestTimeBurned(a);
            System.out.println("max: " + max);
            
            if (max == 1000000000) return 1000000000;
            return binarySearch(0, max, a);
        }
        int m, n, ans = 0;
        // 然后再binary search可以呆在原地的最长时间
        int binarySearch(int l, int r, int [][] a) {
            while (l <= r) {
                int mid = l + (r - l) / 2;
                System.out.println("mid: " + mid);
                for (int [] d : dirs) { // bug:
                    int i = d[0], j = d[1];
                    if (i < 0 || i >= m || j < 0 || j >= n || a[i][j] == 1 || st.get(0).contains(i+"-"+j)) continue;
                    if (dfsPossible(m, i, j, a)) {
                        // ans = Math.max(ans, m);
                        ans = mid;
                        System.out.println("ans: " + ans);
                        l = mid + 1;
                    } else r = mid-1;
                }
            }
            return ans;
        }
        boolean dfsPossible(int v, int x, int y, int [][] a) { // v: 时间点, [i, j]
            if (st.get(v).contains(x+"-"+y)) return false;
            for (int [] d : dirs) {
                int i = x + d[0], j = y + d[1];
                if (i < 0 || i >= m || j < 0 || j >= n || a[i][j] == 2 || st.get(v).contains(i + "-" + j)) continue;
                if (dfsPossible(v+1, i, j, a)) return true;
            }
            return false;
        }
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<Set<String>> st = new ArrayList<>();
        // 找火会烧到房子的最短所需要的时间
        int getShortestTimeBurned(int [][] a) {
            Deque<int []> q = new ArrayDeque<>();
            int cnt = 0;
            Set<String> vis = new HashSet<>();
            Set<String> sc = new HashSet<>();
            for (int i = 0; i < m; i++) // 火的起始状态
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 1) {
                        q.offer(new int [] {i, j});
                        // vis.add(i + "-" + j);
                        sc.add(i + "-" + j);
                    }
                }
            st.add(sc);
            vis.addAll(sc);
            while (true) { // bug: 这个最短时间，哪里写错了？ 
                while (!q.isEmpty()) {
                    sc.clear();
                    for (int w = q.size()-1; w >= 0; w--) {
                        int [] cur = q.pollFirst();
                        int r = cur[0], c = cur[1];
                        if (r == m-1 && c == n-1) return cnt;
                        for (int [] d : dirs) {
                            int i = r + d[0], j = c + d[1];
                            if (i < 0 || i >= m || j < 0 || j >= n || a[i][j] == 2 || vis.contains(i + "-" + j)) continue;
                            q.offerLast(new int [] {i, j});
                            // vis.add(i + "-" + j);
                            sc.add(i + "-" + j);
                        }
                    }
                    vis.addAll(sc);
                    st.add(vis); // 每个时间点下的火焰状态
                    cnt++;
                }
                if (q.isEmpty()) return 1000000000;
            }
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        int [][] a = new int [][] {{0,2,0,0,0,0,0},{0,0,0,2,2,1,0},{0,2,0,0,1,2,0},{0,0,2,2,2,0,2},{0,0,0,0,0,0,0}};

        int r = s.maximumMinutes(a);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
