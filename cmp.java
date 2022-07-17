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

        // public int[] numberOfPairs(int[] a) {
        //     int n = a.length, N = 101;
        //     int [] cnt = new int [N];
        //     for (int v : a) cnt[v]++;
        //     int [] ans = new int [2];
        //     for (int i = 0; i < N; i++) {
        //         if (cnt[i] % 2 == 1) ans[1]++;
        //         ans[0] = ans[0] + (cnt[i] / 2);
        //     }
        //     return ans;
        // }

        // public int maximumSum(int[] a) {
        //     int n = a.length;
        //     Map<Integer, Queue<Integer>> m = new HashMap<>();
        //     for (int v : a) {
        //         int k = getSum(v);
        //         if (!m.containsKey(k)) m.put(k, new PriorityQueue<>((x, y) -> y - x));
        //         m.get(k).offer(v);
        //     }
        //     int max = -1, cur = 0, cnt = 0;
        //     for (Integer key : m.keySet()) {
        //         Queue<Integer> q = m.get(key);
        //         cur = 0;
        //         cnt = 0;
        //         while (!q.isEmpty() && cnt < 2) {
        //             int top = q.poll();
        //             cur += top;
        //             cnt++;
        //         }
        //         if (cnt < 2) continue;
        //         max = Math.max(max, cur);
        //     }
        //     return max;
        // }
        // int getSum(int v) {
        //     String s = String.valueOf(v);
        //     int ans = 0;
        //     for (char c : s.toCharArray()) 
        //         ans += (c - '0');
        //     return ans;
        // }

        // static class P {
        //     public String s;
        //     public int i;
        //     public P(String s, int i) {
        //         this.s = s;
        //         this.i = i;
        //     }
        // }
        // public int[] smallestTrimmedNumbers(String[] s, int[][] a) {
        //     int n = s.length, m = a.length, idx = 0;
        //     int [][] l = new int [m][3];
        //     for (int [] v : a) {
        //         l[idx][0] = idx;
        //         l[idx][1] = v[0];
        //         l[idx++][2] = v[1];
        //     }
        //     Arrays.sort(l, (x, y) -> x[2] != y[2] ? y[2] - x[2] : x[1] - y[1]);
        //     Queue<P> q = new PriorityQueue<>((x, y) -> !x.s.equals(y.s) ? x.s.compareTo(y.s) : x.i - y.i);
        //     List<P> ll = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         q.offer(new P(s[i], i));
        //     int [] ans = new int [m];
        //     int cnt = 0;
        //     for (int i = 0; i < m; i++) {
        //         int [] v = l[i];
        //         if (q.isEmpty() || l[i][2] != q.peek().s.length()) {
        //             if (ll.size() > 0)  //  先裁链表里的
        //                 for (P p : ll) 
        //                     p.s = p.s.substring(p.s.length() - l[i][2]);
        //             while (!q.isEmpty()) { // 再裁 Q 里的：重裁，重新排序
        //                 P cur = q.poll();
        //                 cur.s = cur.s.substring(cur.s.length() - l[i][2]);
        //                 ll.add(cur);
        //                 // q.offer(cur);
        //             }
        //             for (P p : ll) // 这里是不是有更好的办法，直接移加到 Q 里 ？？？？
        //                 q.offer(p);
        //             ll.clear();
        //             cnt = 0;
        //             while (cnt < l[i][1]) {
        //                 ll.add(q.poll());
        //                 cnt++;
        //             }
        //             ans[l[i][0]] = ll.get(ll.size()-1).i;
        //         } else { // 接着往下遍历
        //             while (cnt < l[i][1]) {
        //                 ll.add(q.poll());
        //                 cnt++;
        //             }
        //             ans[l[i][0]] = ll.get(ll.size()-1).i;
        //         }
        //     }
        //     return ans;
        // }

        public int minOperations(int[] a, int[] b) {
            int n = a.length, m = b.length;
            // 对数组 A 的处理：有重复，统计了出现次数的 PriorityQueue
            Queue<int []> q = new PriorityQueue<>((x, y) -> x[0] - y[0]);
            Map<Integer, Integer> m = new HashMap<>();
            for (int v : a) m.put(v, m.getOrDefault(v, 0) + 1);
            for (Integer key : m.keySet()) 
                q.offer(new int [key, m.get(key)]);
            // 对数组 B 的处理：应该是去找最小公约数，或是最小公共质因子 ？？？这后半部分思路不清楚，暂时不做了
        }
    }
    public static void main(String args[]) { 
        Solution s = new Solution();

        String [] a = new String [] {"102","473","251","814"};
        int [][] b = new int [][] {{1,1},{2,3},{4,2},{1,2}};

        int [] r = s.smallestTrimmedNumbers(a, b);
        System.out.println(Arrays.toString(r));
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
