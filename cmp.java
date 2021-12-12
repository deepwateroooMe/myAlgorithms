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

        // public int countPoints(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int [] cnt = new int [10];
        //     Map<Character, Integer> m = new HashMap<>();
        //     m.put('R', 0);
        //     m.put('G', 1);
        //     m.put('B', 2);
        //     for (int i = 0; i < n-1; i += 2) {
        //         char c = s[i];
        //         int idx = s[i+1] - '0';
        //         cnt[idx] |= (1 << m.get(c));
        //     }
        //     int ans = 0;
        //     for (int i = 0; i < 10; i++) 
        //         if ((cnt[i] & 111) == 7)
        //             ans++;
        //     return ans;
        // }

        // public long subArrayRanges(int[] a) {
        //     int n = a.length;
        //     // ArrayDeque<Integer> min = new ArrayDeque<>(); // increase
        //     // ArrayDeque<Integer> max = new ArrayDeque<>(); // decr
        //     Queue<Integer> min = new PriorityQueue<>((x, y)->x-y);
        //     Queue<Integer> max = new PriorityQueue<>((x, y)->y-x);
        //     long sum = 0;
        //     for (int i = 0; i < n; i++) {
        //         min.clear();
        //         max.clear();
        //         min.offer(a[i]);
        //         max.offer(a[i]);
        //         // min.offerLast(a[i]);
        //         // max.offerLast(a[i]);
        //         for (int j = i+1; j < n; j++) {
        //             // while (!min.isEmpty() && min.peekLast() >= a[i]) min.pollLast();
        //             // while (!max.isEmpty() && max.peekLast() <= a[i]) max.pollLast();
        //             min.offer(a[j]);
        //             max.offer(a[j]);
        //             // if (!min.isEmpty() && !max.isEmpty())
        //                 sum += max.peek() - min.peek();
        //         }
        //     }
        //     return sum;
        // }

        // public int minimumRefill(int[] p, int ca, int cb) { // 这应该就是睡眠受干扰表现出来的症状吧：明明思路很对，在一个细节上硬死
        //     int n = p.length;
        //     if (n == 1) return 0;
        //     long v = ca, vb = cb;
        //     int ans = -1, i, j;
        //     int [] a = new int [n];
        //     int [] b = new int [n];
        //     for ( i = 0, j = n-1; i <= j; i++, j--) {
        //         if (i < j) {
        //             if ((int)v >= p[i]) {
        //                 a[i] = (i == 0 ? 0 : a[i-1]);
        //                 v -= p[i];
        //             } else {
        //                 a[i] = (i == 0 ? 0 : a[i-1]) + 1;
        //                 // v = v + ca - p[i]; // 这应该就是睡眠受干扰表现出来的症状吧：明明思路很对，在一个细节上硬死
        //                 v = ca - p[i];
        //             }
        //             if (vb >= p[j]) {
        //                 b[j] = (j == n-1 ? 0 : b[j+1]);
        //                 vb -= p[j];
        //             } else {
        //                 b[j] = (j == n-1 ? 0 : b[j+1]) + 1;
        //                 // vb = vb + cb - p[j]; // 这应该就是睡眠受干扰表现出来的症状吧：明明思路很对，在一个细节上硬死
        //                 vb = cb - p[j];
        //             } 
        //         } else if (i == j) {
        //             if (v >= vb) ans = (v >= p[i] ? a[i-1] + b[j+1] : a[i-1] + b[j+1] + 1);
        //             else {
        //                 if (vb >= p[j]) ans = a[i-1] + b[j+1];
        //                 else ans = a[i-1] + b[j+1] + 1;
        //             }
        //         } 
        //     }
        //     // System.out.println("ans: " + ans);
        //     // System.out.println("i: " + i);
        //     // System.out.println("j: " + j);
        //     if (ans == -1) ans = a[i-1] + b[j+1];
        //     // System.out.println(Arrays.toString(a));
        //     // System.out.println(Arrays.toString(b));
        //     return ans;
        // }

        public int maxTotalFruits(int[][] a, int s, int k) {
            int n = a.length, sum = 0;
            if (n == 1) return Math.abs(a[0][0] - s) <= k ? a[0][1] : 0;
            
            for (int i = 0; i < n; i++) {
                int [] p = a[i];
                if (Math.abs(s - p[0]) <= k) {
                    adj.computeIfAbsent(s, z -> new ArrayList<>()).add(new int [] {p[0], p[1]});
                    if (s == p[0]) sum = p[1];
                }
                for (int j = i+1; j < n; j++) {
                    int [] c = a[j];
                    if (c[0] == s) continue;
                    if (c[0] - p[0] <= k) {
                        adj.computeIfAbsent(p[0], z -> new ArrayList<>()).add(new int [] {c[0], c[1]});;
                        adj.computeIfAbsent(c[0], z -> new ArrayList<>()).add(new int [] {p[0], p[1]});;
                    }
                }
            }
            // System.out.println("adj.size(): " + adj.size());
            // for (Map.Entry<Integer, List<int []>> en : adj.entrySet()) {
            //     System.out.print(en.getKey() + ": ");
            //     for (int [] zz : en.getValue()) 
            //         System.out.println(Arrays.toString(zz));
            // }
            vis = new boolean [a[n-1][0] + 1];
            if (adj.get(s) == null) return 0;
            for (int [] cur : adj.get(s)) {
                Arrays.fill(vis, false);
                vis[s] = true;
                // vis[cur[0]] = true;
                dfs(cur[0], s, sum + cur[1], k - (Math.abs(cur[0] - s)));
            }                
            // dfs(s, -1, sum);
            return max;
        }
        Map<Integer, List<int []>> adj = new HashMap<>();
        boolean [] vis;
        int max = 0;
        void dfs(int idx, int p, int cnt, int k) {
            if (k < 0) return ;
            vis[idx] = true;
            max = Math.max(max, cnt);
            if (adj.get(idx) == null || adj.get(idx).size() == 1 && adj.get(idx).get(0)[0] == p) 
                return ;
            if (k == 0) return ;
            for (int [] next : adj.get(idx)) {
                if (next[0] == idx) continue;
                // if (next[0] == idx || vis[next[0]]) continue;
                // vis[next[0]] = true;
                dfs(next[0], idx, cnt + next[1], k - Math.abs(next[0] - idx));
                // vis[next[0]] = false;
            }
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        // // int [][] a = new int [][] {{2,8},{6,3},{8,6}};
        // int [][] a = new int [][] {{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}};
        // // int [][] a = new int [][] {{0,3},{6,4},{8,5}};
        // // int [][] a = new int [][] {{200000,10000}};
        // // int [][] a = new int [][] {{0,7},{7,4},{9,10},{12,6},{14,8},{16,5},{17,8},{19,4},{20,1},{21,3},{24,3},{25,3},{26,1},{28,10},{30,9},{31,6},{32,1},{37,5},{40,9}};

        // int r = s.maxTotalFruits(a, 5, 4);
        // System.out.println("r: " + r);

        int []  a = new int []  {726, 739, 934, 116, 643,
            648, 473, 984, 482, 85,
            850, 806, 146, 764, 156,
            66, 186, 339, 985, 237,
            662, 552, 800, 78, 617, 933, 481, 652,
            796, 594, 151, 82, 183,
            241, 525, 221, 951, 732,
            799, 483, 368, 354, 776,
            175, 974, 187, 913, 842};
        System.out.println(Arrays.toString(a));

        int r = s.minimumRefill(a, 1439, 1207);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// ListNode r = s.deleteMiddle(head);
// r.printList(r);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
        
// String r = s.getDirections(root, 2, 1);
// System.out.println("r: " + r);
