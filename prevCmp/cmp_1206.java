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

        // public String getDirections(TreeNode root, int startValue, int destValue) { // memory limit 287/332
        //     dfs(root, startValue, "", true);                                        // 还没想明白为什么会memory limit
        //     dfs(root, destValue, "", false);
        //     String ans = "";
        //     int m = one.length(), n = two.length(), i = 0;
        //     for ( i = 0; i < Math.min(n, m); i++) 
        //         if (one.charAt(i) != two.charAt(i)) break;
        //     return "U".repeat(m-i) + two.substring(i);
        // }
        // String one, two;
        // boolean dfs(TreeNode r, int v, String s, boolean isOne) {
        //     if (r == null) return false;
        //     if (r.val == v) {
        //         if (isOne) one = s;
        //         else two = s;
        //         return true;
        //     }
        //     if (dfs(r.left, v, s + "L", isOne)) return true;
        //     return dfs(r.right, v, s + "R", isOne);
        // }
        // public String getDirections(TreeNode root, int startValue, int destValue) { 
        //     List<Character> ls = new ArrayList<>();
        //     List<Character> le = new ArrayList<>();
        //     dfs(root, startValue, ls);
        //     dfs(root, destValue, le);
        //     Collections.reverse(ls);
        //     Collections.reverse(le);
        //     int i = 0;
        //     for (; i < Math.min(ls.size(), le.size()); i++) 
        //         if (ls.get(i) != le.get(i)) break;
        //     String ans = "U".repeat(ls.size()-i);
        //     for (int j = i; j < le.size(); j++) 
        //         ans += le.get(j);
        //     return ans;
        // }
        // boolean dfs(TreeNode r, int v, List<Character> l) {
        //     if (r == null) return false;
        //     if (r.val == v) return true;
        //     if (dfs(r.left, v, l)) {
        //         l.add('L');
        //         return true;
        //     } else if (dfs(r.right, v, l)) {
        //         l.add('R');
        //         return true;
        //     }
        //     return false;
        // }

        // public int[][] validArrangement(int[][] a) { // 接龙型dfs记忆化搜索? : 没有想到这个题的思路，我彻底想错了。。。
        //     n = a.length; // 最开始想的是只有两个数出现次数为1，搜这两个数，但被第3个例子看蒙了，没有想到——只有两个数是奇数,原本的思路腰折了。。。
        //     for (int [] v : a) ll.add(v);
        //     Collections.sort(ll, (x, y)-> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     dp = new ArrayList[n];
        //     for (int i = 0; i < n; i++) {
        //         List<int []> cur = dfs(i, -1);
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
        //     if (dp[idx] != null) return dp[idx];
        //     int [] cur = ll.get(idx);
        //     int v = cur[1];
        //     List<int []> maxList = new ArrayList<>();
        //     List<Integer> next = binarySearch(v);
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
        // // One thing different is that we need to find the start point. it is obvious that if indegree is larger than 0, that is the start point.
        // public int[][] validArrangement(int[][] pairs) { 
        //     Map<Integer, Integer> ins = new HashMap<>();
        //     for (int [] p : pairs) {
        //         adj.computeIfAbsent(p[0], z -> new ArrayList<>()).add(p[1]);
        //         ins.put(p[0], ins.getOrDefault(p[0], 0) + 1);
        //         ins.put(p[1], ins.getOrDefault(p[1], 0) - 1);
        //     }
        //     int bgn = -1;
        //     for (Integer key : ins.keySet()) 
        //         if (ins.get(key) > 0) {
        //             bgn = key;
        //             break;
        //         }
        //     if (bgn == -1) bgn = pairs[0][0]; // 如果没有，就可以随便从某一个点开始？
        //     dfs(bgn);
        //     int n = pairs.length;
        //     int [][] ans = new int [n][];
        //     for (int i = n-1; i >= 0; i--) // 所以这里添加答案，也需要反序回正
        //         ans[n-1-i] = ll.get(i);
        //     return ans;
        // }
        // Map<Integer, List<Integer>> adj = new HashMap<>();
        // List<int []> ll = new ArrayList<>();
        // void dfs(int node) {
        //     while (adj.get(node) != null && adj.get(node).size() > 0) {
        //         List<Integer> nextNodesCandi = adj.get(node);
        //         int next = nextNodesCandi.get(nextNodesCandi.size()-1); // 从后往前遍历，方便从后往前删除已经遍历过的节点
        //         adj.get(node).remove(nextNodesCandi.size()-1);
        //         dfs(next);
        //         ll.add(new int [] {node, next}); // 这里的顺序是倒着加的，dfs完接下来的答案、之后再加的
        //     }
        // }
        // In a word, this solution is to first determine whether the target is an Euler circuit or an Euler path, then solve it.
        public int[][] validArrangement(int[][] pairs) {
            int n = pairs.length;
            Map<Integer, Integer> outdegree = new HashMap<>();
            Map<Integer, Deque<Integer>> out = new HashMap<>();
            for (int[] pair : pairs) {
                outdegree.put(pair[0], outdegree.getOrDefault(pair[0], 0) + 1);
                outdegree.put(pair[1], outdegree.getOrDefault(pair[1], 0) - 1);
            }
            int[][] ans = new int[n][2];
            for (int i = 0; i < n; i++) 
                Arrays.fill(ans[i], -1);
            for (Map.Entry<Integer, Integer> en : map.entrySet()) { // 试图寻找起始和结束的位置
                if (en.getValue() == 1) ans[0][0] = en.getKey();
                if (en.getValue() == -1) ans[n-1][1] = en.getKey();
            }
            if (ans[0][0] == -1) { // 这里为什么就可以从第一个往后搜、从两边往中间搜呢？
                ans[0][0] = pairs[0][0];
                ans[n-1][1] = pairs[0][0];
            }
            for (int[] p : pairs) {
                out.computeIfAbsent(p[0], z -> new ArrayDeque<>()).offerLast(p[1]);
                // out.computeIfAbsent(p[0], k -> new ArrayDeque<>());
                out.computeIfAbsent(p[1], k -> new ArrayDeque<>()); // 需要加上
                // out.get(p[0]).offerLast(p[1]);
            }
            int i = 0, j = n-1;
            while (i < j) { // 没看明白这中间在是做什么？？？
                int from = ans[i][0];
                Deque<Integer> toList = out.get(from); // 这里是个栈， 上面如果不加上，这里会是null
                if (toList.size() == 0) {
                    i--;
                    ans[j][0] = ans[i][0];
                    j--;
                    ans[j][1] = ans[j + 1][0];
                } else {
                    ans[i++][1] = toList.pollLast();
                    // ans[i++][1] = toList.removeLast();
                    ans[i][0] = ans[i - 1][1];
                }
            }
            return ans;
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        int [][] a = new int [][] {{5,1},{4,5},{11,9},{9,4}};

        int [][] r = s.validArrangement(a);
        System.out.println("r.length: " + r.length);
        for (int z = 0; z < r.length; ++z) 
            System.out.println(Arrays.toString(r[z]));
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
