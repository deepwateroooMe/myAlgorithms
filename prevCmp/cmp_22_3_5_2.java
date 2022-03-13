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

        public List<String> cellsInRange(String t) {
            List<String> l = new ArrayList<>();
            char [] s = t.toCharArray();
            for (char i = s[0]; i <= s[3]; i++) 
                for (char j = s[1]; j <= s[4]; j++) 
                    l.add(new String("" + i + j));
            return l;
        }
        
        public TreeNode createBinaryTree(int[][] descriptions) {
            Map<Integer, TreeNode> roots = new HashMap<>(); // roots
            List<TreeNode> trees = new ArrayList<>();
            for (int [] v : descriptions) {
                TreeNode cur = roots.getOrDefault(v[0], new TreeNode(v[0]));
                if (v[2] == 1) 
                    cur.left = new TreeNode(v[1]);
                else cur.right = new TreeNode(v[1]);
                if (!roots.containsKey(v[0])) {
                    roots.put(v[0], cur);
                    trees.add(cur);
                }
            }
            for (final TreeNode node : trees) {
                if (roots.containsKey(node.val)) { // 这里判断：是因为接下来 buildTree 会将可以合并的子树键值对删除并回收利用建大树了
                    final TreeNode root = buildTree(roots, node);
                    roots.put(root.val, root);
                }
            }
            final TreeNode root = roots.values().iterator().next(); // 只有这一颗树根
            return root;
        }
        private TreeNode buildTree(Map<Integer, TreeNode> roots, TreeNode node) { // 用 recursion 把所有需要/可以合并的子树建成一棵完整大树，方法很传神
            final TreeNode next = roots.remove(node.val); // map.remove() 返回值: 如果存在 key, 则删除并返回 value；如果不存在则返回 null
            if (next != null) {
                if (next.left != null) node.left = buildTree(roots, next.left);
                if (next.right != null) node.right = buildTree(roots, next.right);
            }
            return node;
        }
        
        public long minimalKSum(int[] a, int k) { 
            Arrays.sort(a);
            Set<Integer> s = new HashSet<>();
            long sum = 0;
            for (int v : a) {
                if (!s.contains(v) && v <= k) {
                    k++;
                    sum += v;
                }
                s.add(v);
            }
            return (long)(k+1) * k / 2 - sum;
        }
        
        // public List<Integer> replaceNonCoprimes(int[] a) { // BUG: 这么debug得太烦琐了。。。。。。
        //     int n = a.length, idx = 0;
        //     List<Integer> l = new ArrayList<>();
        //     l.add(a[0]);
        //     for (int i = 1; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         if (a[i] == l.get(l.size()-1) && a[i] > 1) continue;
        //         int v = gcd(l.get(l.size()-1), a[i]);
        //         System.out.println("v: " + v);
        //         if (v > 1) {
        //             int cur = l.get(l.size()-1) * a[i] / v;
        //             System.out.println("cur: " + cur);
        //             if (cur != l.get(l.size()-1)) {
        //                 if (cur > l.get(l.size()-1))
        //                     l.set(l.size()-1, cur);
        //                 else if (i > 1)
        //                     l.add(cur);
        //                 // else if (i > 1 && cur )
        //                 else if (i == 1) l.set(0, cur);
        //             }
        //         } else l.add(a[i]);
        //         System.out.println("l.size(): " + l.size());
        //         System.out.println(Arrays.toString(l.toArray()));
        //     }
        //     return l;
        // }
        public List<Integer> replaceNonCoprimes(int[] a) { // 感觉这个题的题目读得有点儿稀里糊途，没搞明白那个过程到底是怎么回事
            List<Integer> l = new ArrayList<>();
            int n = a.length, idx = 1;
            long m = a[0];
            while (idx < n) {
                if ((int)gcd(m, a[idx]) == 1) {
                    while (l.size() > 0) {
                        int end = l.get(l.size()-1);
                        if (gcd(m, end) == 1)
                            break;
                        else {
                            l.remove(l.size()-1);
                            m = lcm(end, m);
                        }
                    }
                    l.add((int)m);
                    m = a[idx++];
                } else {
                    m = lcm(m, a[idx]);
                    idx++;
                }
            }
            while (l.size() > 0) {
                int end = l.get(l.size()-1);
                if (gcd(m, end) == 1) break;
                else {
                    l.remove(l.size()-1);
                    m = lcm(end, m);
                }
            }
            l.add((int)m);
            return l;
        }
        long lcm(long x, long y) {
            long v = gcd(x, y);
            return x * y / v;
        }
        long gcd(long x, long y) {
            if (x < y) return gcd(y, x);
            if (y == 0) return x;
            return gcd(y, x % y);
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();
        // long r = s.minimalKSum(a, 6);
        // int [] a = new int [] {6,4,3,2,7,6,2};
        // int [] a = new int [] {2,2,1,1,3,3,3};
        // int []  a = new int []  {31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561};
        // int []  a = new int []  {517, 11, 121, 517, 3, 51, 3, 1887, 5};
        int []  a = new int []  {287, 41, 49, 287, 899, 23, 23, 20677, 5, 825};
        System.out.println(Arrays.toString(a));
        List<Integer> r = s.replaceNonCoprimes(a);
        System.out.println("r.size(): " + r.size());
        System.out.println(Arrays.toString(r.toArray()));
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
