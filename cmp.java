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

        // public boolean evaluateTree(TreeNode r) {
        //     if (r.left == null && r.right == null) return r.val == 1 ? true : false;
        //     return r.val == 2 ? evaluateTree(r.left) || evaluateTree(r.right)
        //         : evaluateTree(r.left) && evaluateTree(r.right);
        // }

        // // binary search: O(NlogN)
        // public int latestTimeCatchTheBus(int[] bus, int[] pas, int cap) {
        //     Arrays.sort(bus);
        //     Arrays.sort(pas);
        //     n = bus.length;
        //     m = pas.length;
        //     Set<Integer> s = new HashSet<>();
        //     for (int v : pas) s.add(v);
        //     int v = binarySearch(bus[0], bus[n-1], bus, pas, cap);
        //     while (s.contains(v)) {
        //         v = v-1;
        //     }
        //     return v;
        // }
        // int n, m;
        // int binarySearch(int l, int r, int [] bus, int [] pas, int cap) {
        // }

        // public long minSumSquareDiff(int[] a, int[] b, int x, int y) {
        //     int n = a.length;
        //     int [] c = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         c[i] = a[i] - b[i];
        //     Arrays.sort(c);
        //       // |---+----+----+----+----+----+----+----+----|
        //       // | A | +1 | -1 | +1 | -1 | +1 | -1 |    |    |
        //       // | B | +1 | -1 | -1 | +1 |    |    | +1 | -1 |
        //       // |---+----+----+----+----+----+----+----+----|
        //       // | C |  0 |  0 | +2 | -2 | +1 | -1 | -1 | +1 |
        //     // 还要弄个queue一类的东西，按照绝对值的相对关系来排序
        // }

//         public int validSubarraySize(int[] a, int t) { // tle tle tle 
//             int n = a.length, min = Arrays.stream(a).min().getAsInt(), max = Arrays.stream(a).max().getAsInt();
//             if (min > t / n) return n;
//             if (t/1 <= min) return -1;
//             Queue<int []> q = new PriorityQueue<>((x, y) -> x[0] != y[0] ? y[0] - x[0] : y[1] - x[1]); // 值，长度
// // 这里复杂度太高了，好像是用栈可以做到O（N）的处理时间？对栈消化不良            。。。。。
//             int j = 0, k = 0;
//             for (int i = 0; i < n; i++) {
//                 int v = a[i];
//                 j = i+1;
//                 while (j < n && a[j] >= v) j++;
//                 k = i-1;
//                 while (k >= 0 && a[k] >= v) k--;
//                 q.offer(new int [] {a[i], j-k-1});
//             }
//             while (!q.isEmpty()) {
//                 int [] tp = q.peek();
//                 for (int i = 1; i <= n; i++) {
//                     int v = t / i;
//                     if (tp[0] > v && tp[1] >= i) return i;
//                 }
//                 q.poll();
//             }
//             return -1;
//         }

    }
    public static void main(String args[]) { 
        Solution s = new Solution();

        int [] a = new int [] {1, 3, 4, 3, 1};

        int r = s.validSubarraySize(a, 6);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
