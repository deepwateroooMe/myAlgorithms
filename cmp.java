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

        // public List<Integer> intersection(int[][] a) {
        //     int n = a.length, j = 0;
        //     Set<Integer> [] s = new HashSet [n];
        //     for (int i = 0; i < n; i++) s[i] = new HashSet<Integer>(Arrays.stream(a[i]).boxed().collect(Collectors.toList()));
        //     List<Integer> ans = new ArrayList<>();
        //     for (int i = 1; i <= 1000; i++) {
        //         j = 0;
        //         for (; j < n; j++) 
        //             if (!s[j].contains(i)) break;
        //         if (j == n) ans.add(i);
        //     }
        //     return ans;
        // }

        // public int countLatticePoints(int[][] a) {
        //     Set<String> s = new HashSet<>();
        //     for (int [] v : a) {
        //         int x = v[0], y = v[1], r = v[2], rr = r * r;
        //         for (int i = x - r; i <= x + r; i++) 
        //             for (int j = y - r; j <= y + r; j++) 
        //                 if (Math.pow(i - x, 2) + Math.pow(j - y, 2) <= rr) {
        //                     s.add(String.valueOf(i) + "_" + String.valueOf(j));
        //                 }
        //     }
        //     return s.size();
        // }

        public int[] countRectangles(int[][] a, int[][] pt) { // 这里面宽度和高度绕来绕去的，思路不是很清楚，不知道哪里想错了
            int n = a.length, N = 101, idx = 0, cur = 0;
            int [] cnt = new int [N];
            List<Integer> [] l = new ArrayList [N];
            for (int i = 0; i < N; i++) l[i] = new ArrayList<>();
            for (int [] v : a) l[v[1]].add(v[0]);
            for (int i = 0; i < N; i++) {
                Collections.sort(l[i]); // 按照升序排列
                cnt[i] = l[i].size();
            }
            int [] ans = new int [pt.length];
            List<int []> np = new ArrayList<>();
            for (int [] v : pt) 
                np.add(new int [] {idx++, v[0], v[1]});
            Collections.sort(np, (x, y) -> x[2] != y[2] ? x[2] - y[2] : x[1] - y[1]);
            for (int [] v : np) {
                cur = 0;
                for (int j = 1; j < N; j++) { // 高度
                    // if (j >= v[2]) {
                    //     cur += cnt[j];
                    //     continue;
                    // }
                    if (l[j].size() == 0 || v[1] > l[j].get(cnt[j]-1)) continue;
                    if (v[1] <= l[j].get(0)) {
                        cur += cnt[j];
                        continue;
                    }
                    idx = 0;
                    while (idx < l[j].size() && l[j].get(idx) < v[1]) idx++;
                    cur += cnt[j] - idx;
                }
                ans[v[0]] = cur;
            }
            return ans;
        }

        // public int[] fullBloomFlowers(int[][] f, int[] p) {
        //     int n = p.length, m = f.length, idx = 0, prev = -1;
        //     List<int []> lp = new ArrayList<>();
        //     for (int v : p) lp.add(new int [] {idx++, v});
        //     Collections.sort(lp, (x, y) -> x[1] - y[1]); // 看花人时间顺序：升序排列
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);   // 花开的时间，升序
        //     Queue<int []> end = new PriorityQueue<>((x, y) -> x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]); // 花谢的时间，升序
        //     for (int [] v : f) q.offer(v);
        //     int [] ans = new int [n];
        //     Arrays.fill(ans, -1);
        //     for (int i = 0; i < n; i++) {
        //         int [] v = lp.get(i);
        //         int t = v[1];
        //         if (t == prev) {
        //             ans[v[0]] = ans[lp.get(i-1)[0]];
        //             continue;
        //         }
        //         while (!q.isEmpty() && q.peek()[0] <= t) 
        //             end.offer(q.poll());
        //         if (end.isEmpty()) {
        //             ans[v[0]] = 0;
        //             continue;
        //         } 
        //         while (!end.isEmpty() && end.peek()[1] < t) end.poll();
        //         ans[v[0]] = end.size();
        //         prev = t;
        //     }
        //     return ans;
        // }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{1,1},{2,2},{3,3}};
        // int [][] b = new int [][] {{1,3},{1,1}};
        // int [][] a = new int [][] {{1,6},{3,7},{9,12},{4,13}};
        // int [] b = new int [] {2, 3, 7, 11};
        // int [][] a = new int [][] {{1,10},{3,3}};
        // int [] b = new int [] {3, 3, 2};
        int [][] a = new int [][] {{11,11},{24,46},{3,25},{44,46}};
        int [] b = new int [] {1, 8, 26, 7, 43, 26, 1};
            
        int [] r = s.fullBloomFlowers(a, b);
        System.out.println(Arrays.toString(r));
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
