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
    // public static class Solution {

        // // public List<Integer> goodDaysToRobBank(int[] a, int t) {
        // //     int n = a.length;
        // //     int [] up = new int [n], dn = new int [n];
        // //     List<Integer> tmp = new ArrayList<>();
        // //     // ArrayDeque<Integer> up = new ArrayDeque<>();
        // //     // ArrayDeque<Integer> dn = new ArrayDeque<>();
        // //     int j = 0;
        // //     for (int i = 0; i < n-1; i++) { // 把它们换成动规的行式避免重复计算
        // //         for ( j = i-1; j >= 0; j--)
        // //             if (a[j] >= a[j+1])
        // //                 dn[i] = dn[i+1]
        // //         //     if (a[j] < a[j+1]) break;
        // //         // dn[i] = i - j-1;
        // //     }
        // //     for (int i = 0; i < n-1; i++) {
        // //         if (a)
        // //         for ( j = i+1; j < n; j++) 
        // //             if (a[j] < a[j-1]) break;
        // //         up[i] = j - i- 1;
        // //     }
        // //     for (int i = 0; i < n; i++) 
        // //         if (up[i] >= t && dn[i] >= t) tmp.add(i);
        // //     System.out.println(Arrays.toString(dn));
        // //     System.out.println(Arrays.toString(up));
        // //     return tmp;
        // public List<Integer> goodDaysToRobBank(int[] a, int t) {
        //         int n = a.length;
        //         int [] up = new int [n], dn = new int [n];
        //         List<Integer> tmp = new ArrayList<>();
        //         // ArrayDeque<Integer> up = new ArrayDeque<>();
        //         // ArrayDeque<Integer> dn = new ArrayDeque<>();
        //         int j = 0;
        //         for (int i = 0; i < n-1; i++) { // 把它们换成动规的行式避免重复计算，最终想到了动规的思路
        //             if (i > 0 && a[i] <= a[i-1])
        //                 dn[i] = dn[i-1] + 1;
        //         }
        //         // for (int i = 0; i < n-1; i++) { // 把它们换成动规的行式避免重复计算，第二版：笨版
        //         //     for ( j = i-1; j >= 0; j--)
        //         //         if (a[j] < a[j+1]) break;
        //         //     dn[i] = i - j-1;
        //         // }
        //         for (int i = n-2; i >= 0; i--) {
        //             if (a[i] <= a[i+1])
        //                 up[i] = up[i+1] + 1;
        //         }
        //         // for (int i = 0; i < n-1; i++) {
        //         //     for ( j = i+1; j < n; j++) 
        //         //         if (a[j] < a[j-1]) break;
        //         //     up[i] = j - i- 1;
        //         // }
        //         for (int i = 0; i < n; i++) 
        //             if (up[i] >= t && dn[i] >= t) tmp.add(i);
        //         System.out.println(Arrays.toString(dn));
        //         System.out.println(Arrays.toString(up));
            //     return tmp;
            // // List<Integer> ans = new ArrayList<>(); // 第一版：土版
            // // if (n == 1) {
            // //     if (t == 0) {
            // //         ans.add(0);
            // //         return ans;
            // //     }
            // //     return ans;
            // // }
            // // while (k < n-1 && a[k] < a[k+1]) k++;
            // // while (j > 0 && a[j-1] > a[j]) j--;
            // // while (k <= j) {
            // //     System.out.println("\n k: " + k);
            // //     i = k;
            // //     cnt = 0;
            // //     while (i < n-1 && a[i] >= a[i+1]) {
            // //         i++;
            // //         cnt++;
            // //         if (cnt >= t && a[i] == a[i+1]) cb++;
            // //     }
            // //     System.out.println("i: " + i);
            // //     can = i-1;
            // //     // cb = (i > 0 && a[i] == a[i-1] ? cnt : 0);
            // //     // cb = 0;
            // //     while (i < n-1 && a[i] <= a[i+1]) {
            // //         i++;
            // //         cb++;
            // //     }
            // //     if (cnt >= t && cb >= t) ans.add(can);
            // //     k++;
            // // }
            // // return ans;
        // }

        //  public int maximumDetonation(int[][] a) { // 总体的大致思路是对的，细节方面细小方面有误：有向图不是无向图
        //     int n = a.length, maxCnt = 0;          // 早上脑袋还是不够清醒：有一个错的case,就应该赶快去想要改哪些
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) {
        //             int [] p = a[i], c = a[j];
        //             if ((long)Math.pow(p[0]-c[0], 2) + (long)Math.pow(p[1]-c[1], 2) < (long)Math.pow(p[2]+c[2], 2)) {
        //                 m.computeIfAbsent(i, z -> new ArrayList<>()).add(j);
        //                 m.computeIfAbsent(j, z -> new ArrayList<>()).add(i);
        //             }
        //         }
        //     for (int i = 0; i < n; i++) 
        //         maxCnt = Math.max(maxCnt, m.getOrDefault(i, new ArrayList<>()).size());
        //     if (maxCnt == n-1) return n;
        //     for (int i = 0; i < n; i++) 
        //         dfs(i, -1, 1);
        //     return max;
        // }
        // Map<Integer, List<Integer>> m = new HashMap<>();
        // int max = 0;
        // void dfs(int idx, int p, int cnt) {
        //     if (!m.containsKey(idx) || m.get(idx).size() == 1 && m.get(idx).get(0) == p) {
        //         if (cnt > max) max = cnt;
        //         return ;
        //     }
        //     for (Integer next : m.get(idx)) {
        //         if (next == p) continue;
        //         dfs(next, idx, cnt+1);
        //     }
        // }
        // public int maximumDetonation(int[][] a) { // 做题的时候，需要把思路理得在透彻一些
        //     int n = a.length, maxCnt = 0;
        //     adj = new ArrayList[n];
        //     for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++) {
        //             if (j == i) continue;
        //             int [] p = a[i], c = a[j];
        //             if ((long)Math.pow(p[0]-c[0], 2) + (long)Math.pow(p[1]-c[1], 2) <= (long)Math.pow(p[2], 2))
        //                 adj[i].add(j);
        //         }
        //     for (int i = 0; i < n; i++) //
        //         maxCnt = Math.max(maxCnt, adj[i].size());
        //     if (maxCnt == n-1) return n; // 这个提前检测还能提高不少效能？！！！
        //     vis = new boolean [n+1];
        //     for (int i = 0; i < n; i++) {
        //         Arrays.fill(vis, false);
        //         cnt = 0; // 用了全局变量，这里就得重置
        //         dfs(i);
        //         maxCnt = Math.max(maxCnt, cnt);
        //     }
        //     return maxCnt;
        // }
        // List<Integer> [] adj;
        // boolean [] vis;
        // int cnt = 0;
        // void dfs(int idx) {
        //     vis[idx] = true;
        //     cnt++;
        //     for (Integer next : adj[idx]) 
        //         if (!vis[next])
        //             dfs(next);
        // }

        // public int[] maxSubsequence(int[] a, int k) { // tle: 早上的脑袋好缰呀，这么写得出来,却完全忘了只需要把它们排序一下就可以了。。。。。。
        //            n = a.length;
        //            if (k == n) return a;
        //            helper(0, 0, new ArrayList<>(), a, k);
        //            int [] res = new int [k];
        //            for (int i = 0; i < k; i++) 
        //                res[i] = ans.get(i);
        //            return res;
        //        }
        //        List<Integer> ans = new ArrayList<>();
        //        int max = Integer.MIN_VALUE, n;
        //        void helper(int idx, int sum, List<Integer> l, int [] a, int k) {
        //            if (l.size() > k) return ;
        //            if (l.size() == k && sum < max) return ;
        //            if (idx == n) {
        //                if (l.size() == k) 
        //                    if (sum > max) {
        //                        max = sum;
        //                        ans = new ArrayList<>(l);
        //                    }
        //                return ;
        //            }
        //            helper(idx+1, sum, l, a, k);
        //            // List<Integer> tmp = new ArrayList<>(l);
        //            // tmp.add(a[idx]);
        //            l.add(a[idx]);
        //            helper(idx+1, sum + a[idx], l, a, k);
        //            l.remove(l.size()-1);
        //        }
        // public int[] maxSubsequence(int[] a, int k) { // 早上的脑袋好缰呀，这么写得出来,却完全忘了只需要把它们排序一下就可以了。。。。。。
        //     int n = a.length;
        //     List<int []> l = new ArrayList<>();
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         l.add(new int [] {i, a[i]});
        //         m.put(a[i], i);
        //     }
        //     Collections.sort(l, (x, y)->y[1] - x[1]);
        //     l = l.subList(0, k);
        //     Collections.sort(l, (x, y)->x[0] - y[0]);
        //     int [] ans = new int [k];
        //     for (int i = 0; i < k; i++) 
        //         ans[i] = l.get(i)[1];
        //     return ans;
        // }

    Queue<Pt> l;
    Queue<Pt> r;
    int idx = 0;
    public SORTracker() { // 早上因为前几个题做题不顺有压力，最后这一题看了一眼就直接没有去想，回补之前的题去了，如果休息好状态的时候，考场上应该是能做出来的
        l = new PriorityQueue<>((a, b)-> a.v != b.v ? a.v - b.v : b.s.compareTo(a.s)); // 左边升序：注意因为是最小堆，字符串的排列是反着的
        r = new PriorityQueue<>((a, b)-> a.v != b.v ? b.v - a.v : a.s.compareTo(b.s)); // 右边降序
    }
    public void add(String name, int score) {
        l.add(new Pt(name, score));
        if (l.size() > idx + 1)
            r.offer(l.poll());
    }
    public String get() {
        idx++;
        String v = l.peek().s;
        if (!r.isEmpty()) l.offer(r.poll());
        return v;
    }
    class Pt {
        String s;
        int v;
        public Pt(String t, int x) {
            s = t;
            v = x;
        }
    }
    // }

    public static void main (String[] args) {
        // Solution s = new Solution ();

        cmp s = new cmp(); // Initialize the s system.
        s.add("bradford", 2); // Add location with name="bradford" and score=2 to the system.
        s.add("branford", 3); // Add location with name="branford" and score=3 to the system.
        String r1 = s.get();              // The sorted locations, from best to worst, are: branford, bradford.
        System.out.println("r1: " + r1);
        
        // Note that branford precedes bradford due to its higher score (3 > 2).
        // This is the 1st time get() is called, so return the best location: "branford".
        s.add("alps", 2);     // Add location with name="alps" and score=2 to the system.
        String r2 = s.get();              // Sorted locations: branford, alps, bradford.
        System.out.println("r2: " + r2);
        
        // Note that alps precedes bradford even though they have the same score (2).
        // This is because "alps" is lexicographically smaller than "bradford".
        // Return the 2nd best location "alps", as it is the 2nd time get() is called.
        s.add("orland", 2);   // Add location with name="orland" and score=2 to the system.
        String r3 = s.get();              // Sorted locations: branford, alps, bradford, orland.
        System.out.println("r3: " + r3);
        
        // Return "bradford", as it is the 3rd time get() is called.
        s.add("orlando", 3);  // Add location with name="orlando" and score=3 to the system.
        String r4 = s.get();              // Sorted locations: branford, orlando, alps, bradford, orland.
        System.out.println("r4: " + r4);
        
        // Return "bradford".
        s.add("alpine", 2);   // Add location with name="alpine" and score=2 to the system.
        String r5 = s.get();              // Sorted locations: branford, orlando, alpine, alps, bradford, orland.
        System.out.println("r5: " + r5);
        
        // Return "bradford".
        String r6 = s.get();              // Sorted locations: branford, orlando, alpine, alps, bradford, orland.
        System.out.println("r6: " + r6);
        
        // Return "orland".

        // int [] r = s.maxSubsequence(a, 3);
        // System.out.println(Arrays.toString(r));
    }
}
// cmp s = new cmp (a);

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
