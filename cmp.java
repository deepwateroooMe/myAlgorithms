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

        // public int minNumberOfHours(int oe, int op, int[] a, int[] e) {
        //     int ans = Arrays.stream(a).sum();
        //     if (ans >= oe) ans = ans + 1 - oe;
        //     else ans = 0;
        //     for (int i = 0; i < a.length; i++) 
        //         if (op <= e[i]) {
        //             ans += 1 + e[i] - op;
        //             op = 1 + e[i] + e[i];
        //         } else op += e[i];
        //     return ans;
        // }

        // public String largestPalindromic(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     List<int []> [] l = new ArrayList[10];
        //     for (int i = 0; i < 10; i++) 
        //         l[i] = new ArrayList<>();
        //     for (char c : s)
        //         if (l[c-'0'].size() == 0)
        //             l[c-'0'].add(new int [] {c-'0', 1});
        //         else l[c-'0'].get(0)[1]++;
        //     StringBuilder r = new StringBuilder();
        //     for (int i = 9; i >= 0; i--) {
        //         if (l[i].size() == 0) continue;
        //         int cur = l[i].get(0)[1];
        //         if (cur >= 2 && (i > 0 || r.length() > 0)) {
        //             r.append(((char)('0'+i) + "").repeat(cur / 2));
        //             l[i].get(0)[1] %= 2;
        //         }
        //     }
        //     String front = r.toString();
        //     for (int i = 9; i >= 0; i--) {
        //         if (l[i].size() == 0) continue;
        //         int cur = l[i].get(0)[1];
        //         if (cur == 1) {
        //             r.append((char)('0' + i));
        //             break;
        //         }
        //     }
        //     String ans = r.toString() + new StringBuilder(front).reverse().toString();
        //     return ans.equals("") ? "0" : ans;
        // }

        // 问题没有想透：当是叶子节点的时候，因为上层的分叉，会有很多复杂的情况
        // 把整个新树再遍历一遍，去找全局最大值
        public int amountOfTime(TreeNode r, int v) {
            if (r == null) return 0;
            root = buildTree(r);
            updateDepth(root, v);
            if (v == r.val) return root.d-1;
            int ans = 0;
            System.out.println("rd: " + rd);
            System.out.println("root.d: " + root.d);

            if (r.left == null || r.right == null)
                travis(root);
            else {
                if (r.left != null && root.l.vis) 
                    ans = Math.max(rd-1, (root.l.d - rd + 1  + (r.right == null ? 0 : root.r.d)));
                if (r.right != null && root.r.vis)
                    ans = Math.max(rd-1, (root.r.d - rd + 1 + (r.left == null ? 0 : root.l.d)));
            }

            
            return Math.max(max, ans);
        }
        int rd = 0, max = 0;
        TND root;
        void travis(TND r) {
            if (r == null) return ;
            int cur = getMaxAsRoot(r);
            if (cur > max) max = cur;
            travis(r.l);
            travis(r.r);
        }
        int getMaxAsRoot(TND r) {
            int ans = 0;
            if (r.l != null && r.l.vis) 
                ans = Math.max(rd-1, r.d - rd + Math.max(root.d - r.d, r.r == null ? 0 : r.r.d));
            else if (r.r != null && r.r.vis)
                ans = Math.max(rd-1, r.d - rd + Math.max(root.d - r.d, r.l == null ? 0 : r.l.d));
            return ans;
        }
        int updateDepth(TND r, int val) {
            // if (r != null)
            //     System.out.println("\n r.n.val: " + r.n.val);
            if (r == null) return 0;
            if (r.l == null && r.r == null) {
                if (r.n.val == val) {
                    rd = 1;
                    r.vis = true;
                }
                r.d = 1;
                return 1;
            }
            int cntLeft = updateDepth(r.l, val);
            int cntRight = updateDepth(r.r, val);
            r.d = Math.max(cntLeft, cntRight) + 1;
            // System.out.println("r.d: " + r.d);
            if (r.l != null && r.l.vis || r.r != null && r.r.vis) r.vis = true;
            if (r.n.val == val) {
                rd = r.d;
                r.vis = true;
            }
            return r.d;
        }
        TND buildTree(TreeNode r) {
            if (r == null) return null;
            TND s = new TND(r);
            s.l = buildTree(r.left);
            s.r = buildTree(r.right);
            return s;
        }
        class TND {
            TreeNode n;
            int d;
            boolean vis; // mark 是否在子树中
            TND l, r;
            public TND(TreeNode n) {
                this.n = n;
            }
            public TND(TreeNode n, int d) {
                this.n = n;
                this.d =d;
            }
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        // int []  a = new int []  {1, 5, 3, -1, 4, 10, 6, 9, 2};
        // int []  a = new int []  {1, 2, -1, 3, -1, 4, -1, 5};
        // int []  a = new int []  {16, -1, 20, 7, 12, -1, 15, -1, 19, -1, 1, 2};
        int []  a = new int []  {1, -1, 2, 3, 4, -1, 5};

        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        
        int r = s.amountOfTime(root, 4);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

