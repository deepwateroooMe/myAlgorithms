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

        // public int[] findEvenNumbers(int[] a) {
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (Integer v : a) 
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //     boolean bk = false;
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 100; i < 1000; i += 2) {
        //         String s = "" + i;
        //         Map<Character, Integer> cur = getCnt(s);
        //         bk = false;
        //         for (Character key : cur.keySet()) 
        //             if (!m.containsKey(key-'0') || m.get(key-'0') < cur.get(key)) {
        //                 bk = true;
        //                 break;
        //             }
        //         if (bk) continue;
        //         l.add(i);
        //     }
        //     int [] ans = new int [l.size()];
        //     for (int i = 0; i < l.size(); i++) 
        //         ans[i] = l.get(i);
        //     return ans;
        // }
        // Map<Character, Integer> getCnt(String t) {
        //     Map<Character, Integer> m = new HashMap<>();
        //     for (int i = 0; i < 3; i++) 
        //         m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0) + 1);
        //     return m;
        // }
        
        // public ListNode deleteMiddle(ListNode head) {
        //     ListNode r = head, pre = null, cur = null, next = null;
        //     int cnt = 0, n = 0;
        //     while (r != null) {
        //         n ++;
        //         r = r.next;
        //     }
        //     if (n == 1) return null;
        //     if (n == 2) {
        //         head.next = null;
        //         return head;
        //     }
        //     System.out.println("n: " + n);
        //     r = head;
        //     while (cnt < n / 2-1) {
        //         r = r.next;
        //         cnt++;
        //     }
        //     pre = r;
        //     cur = r.next;
        //     next = cur.next;
        //     pre.next = next;
        //     return head;
        // }

        // public int[][] validArrangement(int[][] a) { // 接龙型dfs记忆化搜索
        //     n = a.length;
        //     for (int [] v : a) ll.add(v);
        //     Collections.sort(ll, (x, y)-> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     // System.out.println("ll.size(): " + ll.size());
        //     // for (int [] v : ll) 
        //     //     System.out.println(Arrays.toString(v));
        //     dp = new ArrayList[n];
        //     for (int i = 0; i < n; i++) {
        //         List<int []> cur = dfs(i, -1);
        //         // System.out.println("(cur.size() == n): " + (cur.size() == n));
        //         if (cur.size() == n) {
        //             int [][] ans = new int [n][];
        //             for (int j = 0; j < n; j++) {
        //                 ans[j] = cur.get(j);
        //                 return ans;
        //             }
        //         }
        //     }
        //     return null;
        // }
        // Map<Integer, String> idx = new HashMap<>();
        // List<int []> ll = new ArrayList<>(); //
        // List<int []>[] dp;
        // int n;
        // List<int []> dfs(int idx, int pre) {
        //     // System.out.println("\n idx: " + idx);
        //     // System.out.println(Arrays.toString(ll.get(idx)));
        //     if (dp[idx] != null) return dp[idx];
        //     int [] cur = ll.get(idx);
        //     int v = cur[1];
        //     List<int []> maxList = new ArrayList<>();
        //     List<Integer> next = binarySearch(v);
        //     // System.out.println("next.size(): " + next.size());
        //     // System.out.println(Arrays.toString(next.toArray()));
        //     for (Integer vv : next) {
        //         List<int []> tmp = dfs(vv, ll.get(vv)[1]);
        //         if (tmp.size() > maxList.size()) // 这里可能不是最长长度就能得到结果，而是要能连起来
        //             maxList = new ArrayList<>(tmp);
        //     }
        //     maxList.add(ll.get(idx));
        //     dp[idx] = maxList;
        //     return maxList;
        // }
        // List<Integer> binarySearch(int v) {
        //     if (v < ll.get(0)[0] || v > ll.get(n-1)[0]) return new ArrayList<>();
        //     int l = 0, r = n-1;
        //     List<Integer> ans = new ArrayList<>();
        //     while (l <= r) {
        //         int m = l + (r - l) / 2;
        //         if (ll.get(m)[0] == v) {
        //             int i = m, j = m;
        //             while (i >= 0 && ll.get(i)[0] == v) i--;
        //             while (j < n && ll.get(j)[0] == v) j++;
        //             for (int k = i+1; k < j; k++)
        //                 ans.add(k);
        //             return ans;
        //         } else if (ll.get(m)[0] < v) l = m+1;
        //         else r = m-1;
        //     }
        //     return null;
        // }

        public String getDirections(TreeNode root, int startValue, int destValue) { // 需要再稍微系统化地组织一下思路
            List<TreeNode> one = new ArrayList<>();
            List<TreeNode> two = new ArrayList<>();
            dfs(root, startValue, one, a);
            dfs(root, destValue, two, b);
            // System.out.println("one.size(): " + one.size());
            // System.out.println(Arrays.toString(one.toArray()));
            // System.out.println("two.size(): " + two.size());
            // System.out.println(Arrays.toString(two.toArray()));
            int m = one.size(), n = two.size(), i = 0;
            TreeNode p = null;
            for ( i = Math.min(m, n)-1; i >= 0; i--) 
                if (one.get(i) == two.get(i)) {
                    p = one.get(i);
                    break;
                }
            String ans = "";
            for (int j = m-1; j >= i; j--) 
                ans += "U";
            for (; i < n-1; i++) {
                if (two.get(i+1) == two.get(i).left) ans += "L";
                else ans += "R";
            }
            ans += (b == two.get(i).left ? "L" : "R");
            return ans;
        }
        TreeNode a = null, b = null;
        boolean dfs(TreeNode r, int v, List<TreeNode> l, TreeNode tmp) {
            if (r == null) return false;
            if (r.val == v) {
                tmp = r;
                return true;
            }
            l.add(r);
            if (dfs(r.left, v, l, tmp)) return true;
            return dfs(r.right, v, l, tmp);
            // l.remove(new Integer(r.val));
        }

    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        // int [][] a = new int [][] {{5,1},{4,5},{11,9},{9,4}};

        // int [][] r = s.validArrangement(a);
        // System.out.println("r.length: " + r.length);
        // for (int z = 0; z < r.length; ++z) 
        //     System.out.println(Arrays.toString(r[z]));
        

        int []  a = new int []  {5, 1, 2, 3, -1, 6, 4};

        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        
        String r = s.getDirections(root, 3, 6);
        System.out.println("r: " + r);
        
    }
}
// cmp s = new cmp (a);

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// ListNode r = s.deleteMiddle(head);
// r.printList(r);
