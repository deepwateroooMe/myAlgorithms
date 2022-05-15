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

        // public String largestGoodInteger(String s) {
        //     for (int i = 9; i >= 0; i--) {
        //         String cur = (""+i).repeat(3);
        //         if (s.indexOf(cur) != -1) return cur;
        //     }
        //     return "";
        // }

        // public class Node {
        //     TreeNode nd; // TreeNode
        //     int s; // sum
        //     int c; // cnt
        //     Node l; // left
        //     Node r; // right
        //     public Node() {
        //         nd = null;
        //         s = 0;
        //         c = 0;
        //         l = null;
        //         r = null;
        //     }
        //     public Node(TreeNode r) {
        //         nd = r;
        //         s = 0;
        //         c = 0;
        //         l = null;
        //         r = null;
        //     }
        //     public Node(TreeNode x, int sum, int cnt) {
        //         nd = x;
        //         s = sum;
        //         c = cnt;
        //         l = null;
        //         r = null;
        //     }
        //     public Node(TreeNode x, int sum, int cnt, Node left, Node right) {
        //         nd = x;
        //         s = sum;
        //         c = cnt;
        //         l = left;
        //         r = right;
        //     }
        // }
        // Node r;
        // // bottom-up build tree?????
        // Node buildNodeTree(TreeNode p) {
        //     if (p == null) return null;
        //     if (p.left == null && p.right == null) {
        //         r = new Node(p, p.val, 1);
        //         return r;
        //     }
        //     Node r = new Node(p);
        //     if (p.left != null) {
        //         r.l = buildNodeTree(p.left);
        //     }
        //     if (p.right != null) {
        //         r.r = buildNodeTree(p.right);
        //     }
        //     return r;
        // }
        // // bottom up update values and cnts
        // void calNodeTree(Node r) {
        //     if (r == null) return ;
        //     if (r.l == null && r.r == null) {
        //         cnt++;
        //           return ;
        //     }
        //     calNodeTree(r.l);
        //     calNodeTree(r.r);
        //     r.s = (r.l != null ? r.l.s : 0) + (r.r == null ? 0 : r.r.s) + r.nd.val;
        //     r.c = (r.l != null ? r.l.c : 0) + (r.r == null ? 0 : r.r.c) + 1;
        //     if (Math.floor((float)r.s / r.c) == r.nd.val) 
        //         cnt++;
        // }
        // int cnt = 0;
        // public int averageOfSubtree(TreeNode root) {
        //     r = buildNodeTree(root);
        //     calNodeTree(r);
        //     return cnt;
        // }

        // public boolean hasValidPath(char[][] a) { // TLE: 为什么呢？
        //      m = a.length;
        //      n = a[0].length;
        //      if (a[0][0] == ')') return false;
        //      Deque<Character> s = new ArrayDeque<>();
        //      return dfs(0, 0, s, a);
        //  }
        // int m, n;
        // int [][] dirs = {{1, 0}, {0, 1}}; // 向下， 向右
        // boolean dfs(int i, int j, Deque<Character> s, char [][] a) {
        //     if (s.isEmpty() && a[i][j] == ')') return false;
        //     if (s.isEmpty()) {
        //         s.offerLast(a[i][j]);
        //     } else {
        //         if (a[i][j] == ')' && s.peekLast() == '(') s.pollLast();
        //         else s.offerLast(a[i][j]);
        //         if (i == m-1 && j == n-1 && s.isEmpty()) return true; // 终止条件
        //         else if (i == m-1 && j == n-1) return false;
        //     }
        //     for (int [] d : dirs) {
        //         int x = i + d[0], y = j + d[1];
        //         if (x >= m || y >= n) continue;
        //         // if (dfs(x, y, s, a)) return true; // BUG
        //         if (dfs(x, y, new ArrayDeque(s), a)) return true;
        //     }
        //     return false;
        // }
        // public boolean hasValidPath(char[][] a) { // TLE ? 为什么呢？
        //     m = a.length;
        //     n = a[0].length;
        //     if (a[0][0] == ')') return false;
        //     return dfs(0, 0, 0, 0, a);
        // }
        // int m, n;
        // int [][] dirs = {{1, 0}, {0, 1}}; // 向下， 向右
        // boolean dfs(int i, int j, int l, int r, char [][] a) {
        //     if (l == r && a[i][j] == ')') return false;
        //     if (a[i][j] == '(') l++;
        //     else { // ')'
        //         if (l > 0) l--;
        //         else r++;
        //     }
        //     if (r > l) return false;
        //     if (i == m-1 && j == n-1 && l == r) return true; // 终止条件
        //     else if (i == m-1 && j == n-1) return false;
        //     for (int [] d : dirs) {
        //         int x = i + d[0], y = j + d[1];
        //         if (x >= m || y >= n) continue;
        //         if (dfs(x, y, l, r, a)) return true;
        //     }
        //     return false;
        // }

        public int countTexts(String t) { // 动态规划: 查询#1977，思路应该是比较像，可以还是忘记是怎么写的了
            int n = t.length();
            char [] s = t.toCharArray();
            for (int i = 2; i <= 9; i++) 
                m.put((char)('0'+i), 3);
            m.put('7', 4);
            m.put('9', 4);
            // 根据字符，根据这个字符最多可以连续出现的次数，来破解字符串，好久没写了，跟上面树的题一样，写起来感觉。。。。。。
            // 是需要再多写几个题目练练手了。。。。。。
            int [][] lcp = new int [n][n];
            
        }
        static final int mod = (int)1e9 + 7;
        Map<Character, Integer> m = new HashMap<>();
    }
    public st[atic void main(St[ring args{}) {
        Solution s = new Solution();

        char [][] a = new char [][] {{'(','(','('},{')','(',')'},{'(','(',')'},{'(','(',')'}}; 
        
        boolean r = s.hasValidPath(a);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
